package Selenium.First;

import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumChrome {

	public static void main(String[] args) {
		//Chrome version 69 & chromedriver 2.42
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		//driver.quit();
		
	}

}
