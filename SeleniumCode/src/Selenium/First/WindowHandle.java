package Selenium.First;

import Selenium.Utils.SeleniumUtils;

public class WindowHandle {

	
	public static void main(String[] args) {
		SeleniumUtils sel = new SeleniumUtils();
		sel.launchBrowser("chrome", "http://toolsqa.com/automation-practice-switch-windows/");
		
		sel.clickElement("id", "button1");
		sel.switchToWindow();
		sel.quit();
		
	}
}
