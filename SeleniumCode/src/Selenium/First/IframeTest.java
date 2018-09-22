package Selenium.First;

public class IframeTest {
	
	
	public static void main(String[] args) {
		SeleniumUtils sel = new SeleniumUtils();
		sel.launchBrowser("firefox", "http://toolsqa.com/iframe-practice-page/");
		sel.moveToIframe("IF2");
		sel.clickElement("link", "Read more");
		sel.movetoMainPage();
		sel.takeScreenshot("iframe.png");
		sel.clickElement("xpath", "//a[contains(@href,'facebook.com/sharer.php')]");
	}
	
	

}
