package PraticeWebDriverMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingAlerts {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		/*
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		// normal alert with OK button
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();  // clicks on OK button in alert
		
		// alert with OK and Cancel button
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert.dismiss();  // clicks on Cancel button
		
		// handling prompt (alert with input)
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert prompt = driver.switchTo().alert();
		System.out.println(prompt.getText());
		prompt.sendKeys("Welcome");
		prompt.accept();
*/
		
		// handling authentication alert
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");   // "https://username:password@the-internet.herokuapp.com/basic_auth"
																				   // original URL: "https://the-internet.herokuapp.com/basic_auth"  username and 																					password is required in alert, so these are passed the way written above
		
		
		
	}
}
