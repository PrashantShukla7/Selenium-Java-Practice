package PraticeWebDriverMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement drpCountry = driver.findElement(By.xpath("//select[@id='country']"));
		Select dropdown = new Select(drpCountry);
		
		List<WebElement> options = dropdown.getOptions();
		
		for(WebElement op : options) {
			System.out.println(op.getText());
		}
		
		dropdown.selectByValue("uk");

	}

}
