package automateBooking;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomateBooking {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://blazedemo.com/");
		
		// getting departure city and clicking on Boston
		
		WebElement deptCity = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select departCity = new Select(deptCity);
		
		List<WebElement> cityOptions = departCity.getOptions();
		
		for(WebElement city : cityOptions) {
			if(city.getText().equals("Boston")) {
				city.click();
			}
		}
		
		// getting destination city and clicking on London
		WebElement dstCity = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select destCity = new Select(dstCity);
		
		List<WebElement> destOptions = destCity.getOptions();
		
		for(WebElement city : destOptions) {
			if(city.getText().equals("London")) {
				city.click();
			}
		}
		
		//clicking on Find Flights
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		double minPrice = Double.MAX_VALUE;
		int minFlight = -1;
		for(int r = 1; r<=5; r++) {
			for(int c = 1; c<=6; c++) {
				String price = driver.findElement(By.xpath("//tbody/tr[" + r +"]/td[6]")).getText();
				if(Double.parseDouble(price.substring(1)) < minPrice) {
					minPrice = Double.parseDouble(price.substring(1));
					minFlight = r;
				}
			}
		}
		driver.findElement(By.xpath("//tbody/tr["+ minFlight +"]/td[1]")).click();
		
		
		// filling up the reservation form
		
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("PS");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Boston");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("xyz");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("UP");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("111111");
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("111");
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("John Doe");
		driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		
		

	}

}
