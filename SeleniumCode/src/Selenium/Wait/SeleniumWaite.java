package Selenium.Wait;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaite {
	public static void main(String[] args) throws IOException {
		//Explicit wait
	/*	WebDriverWait wait = new WebDriverWait(WebDriverRefrence,20);
		WebElement aboutMe;
		aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("about_me")));
		
		//Fluent wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)                            
				.withTimeout(20, TimeUnit.SECONDS)          
				.pollingEvery(5, TimeUnit.SECONDS)          
				.ignoring(NoSuchElementException.class);    

				  WebElement aboutMe= wait.until(new Function<WebDriver, WebElement>() {       
				public WebElement apply(WebDriver driver) { 
				return driver.findElement(By.id("about_me"));     
				 }  
				});*/
	}
}
