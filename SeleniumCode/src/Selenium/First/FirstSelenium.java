package Selenium.First;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSelenium {

	public static void main(String[] args) {
		//ff version 62.0 & gecko driver 0.21.0
		
		System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.quit();
		
	}

}
