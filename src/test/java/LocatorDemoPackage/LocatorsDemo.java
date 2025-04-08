package LocatorDemoPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("laptop");	// searches the element with name "q" and set value to "laptop"
		
		boolean isDisplayed = driver.findElement(By.id("nivo-slider")).isDisplayed();
		System.out.println("The slider is diplayed? " +isDisplayed);
		
		//LinkText
//		driver.findElement(By.linkText("Log in")).click();		// requires whole link text;
//		
//		// partialLinkText
//		driver.findElement(By.partialLinkText("Log")).click();		// Does not require whole Link text. Can also give a part of the Link text.
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total images are : " + images.size());
		
	}

}
