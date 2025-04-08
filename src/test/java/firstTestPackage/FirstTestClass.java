package firstTestPackage;

import org.openqa.selenium.chrome.ChromeDriver;

/* 
	Test Case:
	1. Launch Chrome Browser
	2. Open https://demo.nopcommerce.com/
	3. Validate title should be "nopCommerce demo store"
	4. Close the browser.
*/

public class FirstTestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Launch Chrome Browser
		
		ChromeDriver driver = new ChromeDriver();
//		WebDriver driver = new ChromeDriver();  can also do this as WebDriver is the interface and ChromeDriver is child
		
//		2. Open https://demo.nopcommerce.com/
		driver.get("https://demo.nopcommerce.com/");
		
//		3. Validate title should be "nopCommerce demo store"
		String act_title = driver.getTitle();
		if(act_title.equals("nopCommerce demo store")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test failed");
		}
		
//		4. Close the browser.
		driver.close();
//		driver.quit();
		
	}

}
