package PraticeWebDriverMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);	// switching to frame using webelement
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Frame 1 tested");
		
		driver.switchTo().defaultContent();  // switch back to main page
		
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);	// switching to frame using webelement
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Frame 2 tested");
		
		driver.switchTo().defaultContent();
		
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("frame 5 tested");
		
		driver.findElement(By.linkText("https://a9t9.com")).click();
		
		System.out.println(driver.getCurrentUrl());
		boolean isLogoDisplayed = driver.findElement(By.xpath("//img[@alt='Ui.Vision by a9t9 software - Image-Driven Automation']")).isDisplayed();
		System.out.println("Is Logo displayed: " + isLogoDisplayed);
		
		
	}
} 
