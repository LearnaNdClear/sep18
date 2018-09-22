package Selenium.First;

import Selenium.Utils.SeleniumUtils;

public class IrctcLogin {
	
	public static void main(String[] args) {
		SeleniumUtils sel = new SeleniumUtils();
		sel.launchBrowser("chrome", "https://www.irctc.co.in/eticketing/userSignUp.jsf");
		sel.enterTextBox("id", "userRegistrationForm:userName", "learnclear123");
		sel.enterTextBox("id", "userRegistrationForm:password", "learnclear123");
		sel.enterTextBox("id", "userRegistrationForm:confpasword", "learnclear123");
		sel.selectDropDown("id", "userRegistrationForm:securityQ", "What is your pet name?");
		sel.enterTextBox("id", "userRegistrationForm:securityAnswer", "jimmy");
		sel.enterTextBox("id", "userRegistrationForm:firstName", "LearnNClear");
		sel.clickElement("id", "userRegistrationForm:gender:0");
		sel.clickElement("id", "userRegistrationForm:maritalStatus:1");
		sel.selectDropDown("id", "userRegistrationForm:dobDay", "22");
		sel.selectDropDown("id", "userRegistrationForm:dobMonth", "SEP");
		sel.selectDropDown("id", "userRegistrationForm:dateOfBirth", "1990");
		sel.selectDropDown("id", "userRegistrationForm:occupation", "SelfEmployed");
		sel.selectDropDown("id", "userRegistrationForm:countries", "India");
		sel.enterTextBox("id", "userRegistrationForm:email", "learnandclear@gmail.com");
		sel.enterTextBox("id", "userRegistrationForm:mobile", "9789175876");
		sel.selectDropDown("id", "userRegistrationForm:nationalityId", "India");
		sel.enterTextBox("id", "userRegistrationForm:pincode", "603103");
		sel.clickElement("id", "nlpCaptchaImg");
		sel.wait(2);
		sel.selectDropDown("id", "userRegistrationForm:cityName", "Kanchipuram");
		sel.clickElement("id", "nlpCaptchaImg");
		sel.wait(2);
		sel.selectDropDown("id", "userRegistrationForm:postofficeName", "Kelambakkam S.O");
		sel.enterTextBox("id", "userRegistrationForm:landline", "9789175876");
		sel.clickElement("link", "Submit Registration Form>>>");
		sel.acceptAlert();
		sel.enterTextBox("id", "userRegistrationForm:password", "Learnclear123");
		sel.takeScreenshot("SubmitForm2.png");
		sel.enterTextBox("id", "userRegistrationForm:confpasword", "Learnclear123");
		sel.enterTextBox("id", "userRegistrationForm:address", "123");
		sel.takeScreenshot("SubmitForm.png");
		sel.clickElement("link", "Submit Registration Form>>>");
		sel.acceptAlert();
		sel.acceptAlert();
		sel.takeScreenshot("IrctcTermsAndCondition.png");
	}

}
