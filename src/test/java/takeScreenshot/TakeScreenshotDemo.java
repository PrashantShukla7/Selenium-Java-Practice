package takeScreenshot;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshotDemo {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
//		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
//		TakesScreenshot ts = driver;   // if using line 10
			
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("D:\\Automation\\First Workspace\\seleniumwebdriver\\src\\test\\java\\Screenshots", "fullPage.png");
		sourceFile.renameTo(targetFile);
		
		File featuredFile = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']")).getScreenshotAs(OutputType.FILE);
		targetFile = new File("D:\\Automation\\First Workspace\\seleniumwebdriver\\src\\test\\java\\Screenshots", "featuredPage.png");
		featuredFile.renameTo(targetFile);
		
	}
}
