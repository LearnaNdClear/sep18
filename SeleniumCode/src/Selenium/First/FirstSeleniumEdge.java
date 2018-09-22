package Selenium.First;

import org.openqa.selenium.edge.EdgeDriver;

public class FirstSeleniumEdge {

	public static void main(String[] args) {
		// edge html 13.10586 & microsoftwebdriver Version: 2.10586 Release 10586
		System.setProperty("webdriver.edge.driver", "driver/MicrosoftWebDriver.exe");
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://www.google.com");
		driver.quit();
		
	}

}
