package Selenium.First;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgTest {
	@BeforeSuite
	public void m1() {
		System.out.println("I'm inside m1");
	}

	@BeforeClass
	public void m2() {
		System.out.println("I'm inside m2");
	}
	@BeforeMethod(groups={"smoke"})
	public void m3() {
		System.out.println("I'm inside m3");
	}
	@Test(groups={"smoke"})
	public void m4() {
		System.out.println("I'm inside m4");
	}
	@Test(groups={"sanity","smoke"})
	public void m51() {
		System.out.println("I'm inside m5");
	}
	@AfterMethod
	public void m5() {
		System.out.println("I'm inside m5");
	}
	@AfterClass
	public void m6() {
		System.out.println("I'm inside m6");
	}
	@AfterSuite
	public void m7() {
		System.out.println("I'm inside m7");
	}
	
	@BeforeTest
	public void m11() {
		System.out.println("I'm inside m11");
	}
	
	@AfterTest
	public void m61() {
		System.out.println("I'm inside m61");
	}
}
