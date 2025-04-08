package CSSLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();	// to maximize the window
		
		// tag id
//		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");
//		driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-shirts");		// tag name is optional in CSS locators
		
		// tag class
//		driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("T-shirts");
//		driver.findElement(By.cssSelector(".search-box-text")).sendKeys("T-shirts");
		
		// tag attribute
//		driver.findElement(By.cssSelector("input[name = 'q']")).sendKeys("T-shirts");
//		driver.findElement(By.cssSelector("[name = 'q']")).sendKeys("T-shirts");
		
		// tag class attribute
//		driver.findElement(By.cssSelector("input.search-box-text[name = 'q']")).sendKeys("T-shirts");
		driver.findElement(By.cssSelector(".search-box-text[name = 'q']")).sendKeys("T-shirts");
		
	}
}
