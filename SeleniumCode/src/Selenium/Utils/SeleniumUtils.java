package Selenium.Utils;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;

/**
 * @author HP
 *
 */
public class SeleniumUtils {
	//driver intialization
	WebDriver driver =  null;
	String parentWindowID = null;
	
	
	/**Enter text in text box
	 * 
	 * @param locatorType - id, name, xpath, css, class, link, exactlink or tag
	 * @param locator
	 * @param text
	 */
	public void enterTextBox(String locatorType, String locator, String text){
		System.out.println("Enter the text " + text + " in locator " + locator);
		By locate = findLocator(locatorType,locator);
		driver.findElement(locate).clear();	
		driver.findElement(locate).sendKeys(text);		
	}
	
	/**
	 * Click the element
	 * 
	 * @param locatorType - id, name, xpath, css, class, link, exactlink or tag
	 * @param locator
	 */
	public void clickElement(String locatorType, String locator){
		System.out.println("Click the element with the locator " + locator);
		By locate = findLocator(locatorType,locator);		
		driver.findElement(locate).click();	
	}
	
	/**
	 * Find locator with given combination of input
	 * @param locatorType - id, name, xpath, css, class, link, exactlink, tag
	 * @param locator
	 * @return 
	 */
	public By findLocator(String locatorType, String locator){
		By locate = null;
		if(locatorType  == "id"){
			locate = By.id(locator);
		} else if(locatorType  == "name"){
			locate = By.name(locator);
		}else if(locatorType  == "link"){
			locate = By.partialLinkText(locator);
		}else if(locatorType  == "xpath"){
			locate = By.xpath(locator);
		}else if(locatorType  == "css"){
			locate = By.cssSelector(locator);
		}else if(locatorType  == "class"){
			locate = By.className(locator);
		}else if(locatorType  == "exactlink"){
			locate = By.linkText(locator);
		}else if(locatorType  == "tag"){
			locate = By.tagName(locator);
		}
		return locate;
	}
	
	/**
	 * Move to Selenium to main page
	 */
	public void movetoMainPage(){
		driver.switchTo().defaultContent();
		wait(1);
	}
	
	/**
	 * Verify the text equals web element text
	 * @param locatorType - id, name, xpath, css, class, link, exactlink, tag
	 * @param locator
	 * @param verifyTxt
	 */
	public void verifyText(String locatorType, String locator, String verifyTxt){
		System.out.println("Verify text " + verifyTxt);
		By locate = findLocator(locatorType, locator);		
		String ActualText = driver.findElement(locate).getText();	
		System.err.println("Text present " + ActualText);
		if(ActualText.equals(verifyTxt)){
			System.out.println("Both are same");
		}
		else{
			System.out.println("Both are not same");
		}
		
	}
	
	/**
	 * Verify the text present in web element
	 * @param locatorType - id, name, xpath, css, class, link, exactlink, tag
	 * @param locator
	 * @param verifyTxt
	 */
	public void verifyTextContains(String locatorType, String locator, String verifyTxt){
		System.out.println("Verify text " + verifyTxt);
		By locate = findLocator(locatorType, locator);		
		String ActualText = driver.findElement(locate).getText();	
		System.err.println("Text present " + ActualText);
		if(ActualText.contains(verifyTxt)){
			System.out.println("Both are same");
		}
		else{
			System.out.println("Both are not same");
		}
		
	}
	
	
	/**
	 * Select the value in dropdown
	 * 
	 * @param locatorType - id, name, xpath, css, class, link, exactlink, tag
	 * @param locator
	 * @param selectText
	 */
	public void selectDropDown(String locatorType, String locator, String selectText){
		System.out.println("Select text " + selectText);
		By locate = findLocator(locatorType, locator);	
		WebElement element = driver.findElement(locate);
		Select select =  new Select(element);
		select.selectByVisibleText(selectText);
		
	}
	
	
	/**
	 * Wait the execution for given seconds
	 * 
	 * @param second
	 */
	public void wait(int second){
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			System.out.println("System hanged");
		} 
	}
	
	/**
	 * Launch the requested browser with given url
	 * @param browser - firefox, chrome, ie, edge, headless or phatomjs
	 * @param url
	 */
	public void launchBrowser(String browser, String url){
		if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
			driver = new FirefoxDriver();	
		} else if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", "driver/IEDriverServer.exe");         
			InternetExplorerDriver driver = new InternetExplorerDriver();
		} else if(browser.equals("edge")){
			System.setProperty("webdriver.edge.driver", "driver/MicrosoftWebDriver.exe");
			EdgeDriver driver = new EdgeDriver();
		} else if(browser.equals("headless")){
			HtmlUnitDriver driver = new HtmlUnitDriver();
			driver.get("http://www.google.com/");
		} else if(browser.equals("phatomjs")){
			System.setProperty("phantomjs.binary.path", "phantomjs/phantomjs.exe");		
			PhantomJSDriver driver = new PhantomJSDriver();
		}
		System.out.println("Launch the url " + url + " in " + browser + " browser.");
		driver.get(url);
	}
	
	
	/**
	 * Click OK in alert
	 */
	public void acceptAlert(){
		wait(2);
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert text " + alert.getText());
		alert.accept();
		wait(1);
	}
	
	
	/**
	 * Take screenshot
	 * 
	 * @param filename
	 */
	public void takeScreenshot(String filename){
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File output = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationPath = new File("Screenshot/" + filename);
		try {
			FileUtils.copyFile(output,destinationPath );
			System.out.println("Screentshot taken " + filename);
		} catch (IOException e) {
			System.out.println("Folder Screenshot not found");
		}	
	}
	
	/** 
	 * Move to frame
	 * 
	 * @param frame
	 */
	public void moveToIframe(String frame){
		driver.switchTo().frame(frame);
		wait(2);
	}
	
	/**
	 * Move to frame
	 * 
	 * @param locatorType - id, name, xpath, css, class, link, exactlink or tag
	 * @param locator
	 */
	public void moveToIframe(String locatorType, String locator){
		By locate = findLocator(locatorType,locator);
		WebElement frame = driver.findElement(locate);
		driver.switchTo().frame(frame);
		wait(2);
	}
	
	
	public void switchToWindow() {
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		String currentWindowId = driver.getWindowHandle();
		wait(4);
		Set<String> Ids = driver.getWindowHandles(); 
		for(String Id : Ids) {
			System.out.println(Id);
			if(!Id.equals(currentWindowId)) {
				driver.switchTo().window(Id);
			}
			
		}
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	
	public void switchToWindow(String url) {
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		String currentWindowId = driver.getWindowHandle();
		wait(4);
		Set<String> Ids = driver.getWindowHandles(); 
		for(String Id : Ids) {
			driver.switchTo().window(currentWindowId); 
			if(driver.getCurrentUrl().contains(url)) {
				break;
			}
			
		}
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	
	
	
	public void windowClose() {
		System.out.println("Closed windows " + driver.getTitle());
		driver.close();
	}
	
	public void quit() {
		System.out.println("Closed windows " + driver.getTitle());
		driver.quit();
	}
	
	/**
	 * Close browser
	 */
	public void closeBrowser(){
		driver.close();
	}
	
	
	/**
	 * Switch to window with given title
	 * @param titleOfExpectedWindow
	 * @return
	 */
	public String windowHandlingwindowHandling(String titleOfExpectedWindow){
		parentWindowID = driver.getWindowHandle();
		System.out.println("parent window ID " + parentWindowID);
		
		// get all window IDs
		Set<String> windowIDs = driver.getWindowHandles();

		/**
		 * loop thru window IDs and switch to each window & do getTitle action to verify whether the current window title
		 * matches with expected window title
		 *  
		 */
		
		for (String windowID : windowIDs) {
			System.out.println(windowID);
			
			driver.switchTo().window(windowID);
			String title = driver.getTitle();
			System.out.println("TITLE is " + title);
			
			if (title.contains(titleOfExpectedWindow)) {
				break;
			}

		}
		
		return driver.getWindowHandle();

	}

	/**
	 * Go back to particular window
	 * 
	 * @param childWindowId
	 */
	public void goBackParentWindow(String childWindowId){
		driver.switchTo().window(childWindowId);
	}
	
	/**
	 * Go back to parent window
	 */
	public void goBackParentWindow(){
		driver.switchTo().window(parentWindowID);
	}

	
	public void explicitWait(ExpectedConditions cond, int seconds, By locate){
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void fluentWait(ExpectedConditions cond, int seconds, int pollSeconds, By locate){
		
		    
		    Wait wait = new FluentWait(driver)
		    		 .withTimeout(seconds, TimeUnit.SECONDS)
					 .pollingEvery(pollSeconds, TimeUnit.SECONDS)
		    	 
		    	    .ignoring(NoSuchElementException.class);
		    	 

		    WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
		    public WebElement apply(WebDriver driver) {
		    WebElement element = driver.findElement(By.xpath("//*[@id='softwareTestingMaterial']"));
		    String getTextOnPage = element.getText();
		    if(getTextOnPage.equals("Software Testing Material - DEMO PAGE")){
		    System.out.println(getTextOnPage);
		    return element;
		    }else{
		    System.out.println("FluentWait Failed");
		    return null;
		    }
		    }
		    });
	}
	
	public void verifyTitle(String expectedTitle){
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle,"Title not equal");
	}
	
	
	public void verifyElementText(String locatorType, String locator,String expectedText){
		System.out.println("Verify the text " + expectedText + " in locator " + locator);
		By locate = findLocator(locatorType,locator);
		String actualText = driver.findElement(locate).getText();
		Assert.assertEquals(expectedText, actualText,"Text not equal :" + expectedText + "!=" + actualText);
	}
	
	public void verifyAlertText(String expectedText){
		wait(2);
		String actualText= driver.switchTo().alert().getText();
		
		Assert.assertEquals(actualText, expectedText,actualText + "!=" + expectedText);
		
	}

}
