package Selenium.Screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSeleniumScreenshot {

	public static void main(String[] args) throws IOException {
		//ff version 62.0 & gecko driver 0.21.0
		
		System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("Image/Screen.png");
		FileUtils.copyFile(SrcFile, DestFile);
		driver.quit();
		
	}

}
