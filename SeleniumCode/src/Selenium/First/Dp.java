package Selenium.First;

import java.util.NoSuchElementException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Selenium.Utils.SeleniumUtils;

public class Dp {
	
	@DataProvider
	public Object[][] input(){
		return new Object[][]{{"vinothkumar","vinoth","Invalid User Id or Password !!!"
			},
			{"arun","arun","Invalid User Id or Password !!!"
		},{"arun","","Please enter Password"
			},{"","arun","Please enter User Id"
			},{"","","Please enter User Id"
			}};
	}

	
	@Test(dataProvider="input")
	public void testNegative(String username, String password, String message){
		SeleniumUtils util = new SeleniumUtils();
		util.launchBrowser("chrome", "http://login.globalglaze.in/");
		util.enterTextBox("xpath", "//input[@placeholder='USER ID/NEW ID']", username);
		util.enterTextBox("xpath", "//input[@placeholder='PASSWORD']",password);
		util.clickElement("xpath","//input[@value='LOGIN']");
		util.verifyAlertText(message);
		util.closeBrowser();
		
	}
}
