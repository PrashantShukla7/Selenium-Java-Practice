package xlSheetHandle;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import excelUtils.ExcelUtils;

public class HandleXlsheet {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		driver.manage().window().maximize();
		
		String file = System.getProperty("user.dir")+ "\\testdata\\testData.xlsx";
		int rows = ExcelUtils.getRows(file, "Sheet1");
		
		int cells = ExcelUtils.getCells(file, "Sheet1", 1);

		
		System.out.println(rows);
		System.out.println(cells);
		
		driver.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();
		
		for(int i = 1; i<=rows; i++) {
			
			String data = ExcelUtils.getCellData(file, "Sheet1", i, 0);
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(data);
			
			String roi = ExcelUtils.getCellData(file, "Sheet1", i, 1);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(roi);
			
			String tenure = ExcelUtils.getCellData(file, "Sheet1", i, 2);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(tenure);
			
			String period = ExcelUtils.getCellData(file, "Sheet1", i, 3);
			String frequency = ExcelUtils.getCellData(file, "Sheet1", i, 4);
			String expValue = ExcelUtils.getCellData(file, "Sheet1", i, 5);
			
			WebElement periodDrpDown = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));

			Select periods = new Select(periodDrpDown);
			periods.selectByVisibleText(period);
			
			WebElement frequencyDrpDown = driver.findElement(By.xpath("//select[@id='frequency']"));

			Select frequencies = new Select(frequencyDrpDown);
			frequencies.selectByVisibleText(frequency);
			
			Thread.sleep(3);
			
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();
			
			String calcValue = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if(Double.parseDouble(expValue) == Double.parseDouble(calcValue)) {
				System.out.println("Test passed");
				ExcelUtils.setCellData(file, "Sheet1", i, 6, "passed");

				ExcelUtils.fillGreenColor(file, "Sheet1", i, 6);
			} else {
				System.out.println("Test failed");
				ExcelUtils.setCellData(file, "Sheet1", i, 6, "failed");
				ExcelUtils.fillRedColor(file, "Sheet1", i, 6);
			}
			
			driver.findElement(By.xpath("//div[@class='MT10']//a[2]")).click();
			

		}
		
	}

}
