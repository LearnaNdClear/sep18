package Selenium.First;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertHandle {
 public static void main(String[] args) {
	 System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
	 FirefoxDriver driver = new FirefoxDriver();
	 
	 driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver");
	 driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();
	 Alert alr = driver.switchTo().alert();
	 
	 System.out.println(alr.getText());
	 alr.accept();
	 driver.switchTo().defaultContent();
	 driver.findElement(By.xpath("//button[text()='Confirm Pop up']")).click();
	 Alert alr2 = driver.switchTo().alert();
	 System.out.println(alr.getText());
	 alr.dismiss();
	 driver.switchTo().defaultContent();
	
	 String clickedButton=driver.findElement(By.id("ConfirmOption")).getText();
	 System.out.println(clickedButton);
	 driver.findElement(By.xpath("//button[text()='Prompt Pop up']")).click();
	 Alert alr3 = driver.switchTo().alert();
	 alr3.sendKeys("Yes");
	 alr3.accept();
	 
	 
	 
	 

}
}
