package Selenium.First;

import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class FirstSeleniumPhatonJs {

	public static void main(String[] args) {
		 System.setProperty("phantomjs.binary.path", "phantomjs/phantomjs.exe");	
		 //need selenium standalone server to excute
		/* PhantomJSDriver driver = new PhantomJSDriver();	
         driver.get("http://www.google.com");
         System.out.println("Page title is: " + driver.getTitle());		
         driver.quit();		*/
	}

}
