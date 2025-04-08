package PraticeWebDriverMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");  // can only pass url as string
//		driver.navigate().to("https://testautomationpractice.blogspot.com/"); // functions same as get() but we can pass URL as string as well as URL object;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-input\"]")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		List<WebElement> resLinks = driver.findElements(By.xpath("//a[contains(.,'Selenium')]"));
		for(WebElement link: resLinks) {
			link.click();
		}
		
		Set<String> openedWindows = driver.getWindowHandles();		// returns the id of all opened Windows
		List<String> openWindowsList = new ArrayList<>(openedWindows);
		
		for(String windowId : openWindowsList) {
			String title = driver.switchTo().window(windowId).getTitle();
			if(!title.equals("Automation Testing Practice")) {
				driver.close();
			}
		}

	}

}
