package Selenium.First;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class FirstSeleniumIE {

	public static void main(String[] args) {
		
		//ie version 11.212.1058 & iedriver 3.14
		System.setProperty("webdriver.ie.driver", "driver/IEDriverServer.exe");         
		InternetExplorerDriver driver = new InternetExplorerDriver();
		driver.get("http://www.google.com");
		driver.quit();
		
	}

}
