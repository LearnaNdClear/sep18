package Selenium.First;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class FirstSeleniumHtmlUnit {

	public static void main(String[] args) {
		HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.get("http://www.google.com/");
		System.out.println(driver.getTitle());
		
	}

}
