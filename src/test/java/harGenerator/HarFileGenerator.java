package harGenerator;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class HarFileGenerator {
    public static void main(String[] args) {
        // Start BrowserMob Proxy
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0); // Start on any available port

        // Get Selenium Proxy settings
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // Set up WebDriver with Proxy
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update path to chromedriver
        ChromeOptions options = new ChromeOptions();
        options.setProxy(seleniumProxy);
        WebDriver driver = new ChromeDriver(options);

        try {
            // Start HAR capture
            proxy.newHar("exactspace");

            // Open the target website
            driver.get("https://exactspace.co/");

            // Wait for the page to load completely
            Thread.sleep(5000); // Use WebDriver waits in real scenarios

            // Get the HAR data
            Har har = proxy.getHar();
            File harFile = new File("exactspace.har");
            har.writeTo(harFile);
            System.out.println("HAR file generated: " + harFile.getAbsolutePath());

            // Parse the HAR file
            parseHarFile(harFile);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Stop the proxy and close the browser
            proxy.stop();
            driver.quit();
        }
    }

    private static void parseHarFile(File harFile) {
        try {
            // Parse the HAR file using Jackson
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(harFile);

            // Navigate to log entries
            JsonNode entries = rootNode.path("log").path("entries");

            int totalCount = 0;
            int count2xx = 0, count4xx = 0, count5xx = 0;

            // Iterate through entries to get status codes
            Iterator<JsonNode> iterator = entries.elements();
            while (iterator.hasNext()) {
                JsonNode entry = iterator.next();
                int statusCode = entry.path("response").path("status").asInt();

                totalCount++;
                if (statusCode >= 200 && statusCode < 300) {
                    count2xx++;
                } else if (statusCode >= 400 && statusCode < 500) {
                    count4xx++;
                } else if (statusCode >= 500) {
                    count5xx++;
                }
            }

            // Print results
            System.out.println("Total Status Codes: " + totalCount);
            System.out.println("2XX Status Codes: " + count2xx);
            System.out.println("4XX Status Codes: " + count4xx);
            System.out.println("5XX Status Codes: " + count5xx);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
