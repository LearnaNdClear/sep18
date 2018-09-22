package Selenium.Screenshot;

import org.openqa.selenium.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenShotParticularArea {
	public static void main(String[] args) throws IOException {
		//ff version 62.0 & gecko driver 0.21.0
		
		System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		
		
		By locate = By.id("hplogo");
		WebElement ele = driver.findElement(locate);

		// Get entire page screenshot
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);

		// Get the location of element on the page
		Point point = ele.getLocation();

		// Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
		    eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);

		// Copy the element screenshot to disk
		File screenshotLocation = new File("image/GoogleLogo_screenshot.png");
		FileUtils.copyFile(screenshot, screenshotLocation);
	}
}
