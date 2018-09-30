package Selenium.First;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Selenium.Utils.SeleniumUtils;

public class AssertVsVerify {

	@Parameters({"browser","url"})
	@Test(priority=0)
	public void AssertCase(String browser,String url){
		SeleniumUtils ut = new SeleniumUtils();
		ut.launchBrowser(browser,url);
		ut.enterTextBox("id", "lst-ib", "thoughtworks");
		ut.wait(2);
		ut.clickElement("id", "hplogo");
		ut.wait(2);
		
		ut.clickElement("name", "btnK");
		ut.clickElement("link", "ThoughtWorks | Creative technology consultants | ThoughtWorks");
		ut.verifyTitle("ThoughtWorks | Creative technology consultants | ThoughtWorks");
		ut.enterTextBox("name", "q", "selenium");
		ut.clickElement("class", "search-bar__button");
		ut.verifyElementText("class", "search-result__title", "Happy 10th Birthday, Selenium | ThoughtWorks");
		ut.closeBrowser();
		
	}
	
}
