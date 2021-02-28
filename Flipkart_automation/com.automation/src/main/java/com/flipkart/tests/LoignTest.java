package com.flipkart.tests;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.flipkart.pages.LandingPage;
import com.flipkart.pages.PageBase;
import com.flipkart.utilities.Base;
import com.flipkart.utilities.BrowserFactory;
import com.flipkart.utilities.Dataprovider;
import com.flipkart.utilities.PagesWebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class LoignTest{
	WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;
	PageBase pageBase;

	@Test(priority = 1)
	public void setup() throws Exception {
		extent=Base.createExtentReport();
		logger = extent.startTest("allowDialogue");
		driver= BrowserFactory.getDriver();
		driver.get(PagesWebElement.url);
		Thread.sleep(2000);
		pageBase = PageFactory.initElements(driver, PageBase.class);
		if (pageBase.is_Username_visible())
			logger.log(LogStatus.PASS, "Reached to flipkart.com");
		else
			logger.log(LogStatus.FAIL, "Internal problem ");

	}

	@Test(priority=2,dataProvider="login credentials",dataProviderClass = Dataprovider.class)
	public  void login(String uname,String pwd)
	{ logger = extent.startTest("login");
	pageBase = PageFactory.initElements(driver, PageBase.class);
	pageBase.enter_Username(uname);
	pageBase.enter_Password(pwd);
	pageBase.submit_Credential();
	LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
	if (landing.is_Search_Visible())
		logger.log(LogStatus.PASS, "Login successfully");
	else
		logger.log(LogStatus.FAIL, "Bad credentials");
	System.out.println(driver.getTitle());
	}


	@Test(priority = 3)
	public void search_Product() throws Exception
	{logger = extent.startTest("search_Product");
	LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
	System.out.println(driver.getTitle());
	landing.searchProduct("software engineering books");
	landing.click_Search();
	if(driver.getCurrentUrl().contains("q=software%20engineering%20book"))
		logger.log(LogStatus.PASS, "Searched for topic product");
	else
		logger.log(LogStatus.FAIL, "Search not working");
	
	}




	@Test(priority = 4)
	public void add_product_cart() throws Exception
	{
		logger = extent.startTest("add_product_cart");
		LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
		landing.select_product();
		Thread.sleep(2000);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		//driver.close();
		landing.click_buy_Now();
		Thread.sleep(2000);
		if (landing.is_Deliver_Here_Visible())
			logger.log(LogStatus.PASS, "Bought the product");
		else
			logger.log(LogStatus.FAIL, "Seems out of stock or something went wrong");
		driver.switchTo().window(tabs2.get(0));


	}

	@Test(priority = 5)
	public void logout() throws Exception
	{
		logger = extent.startTest("logout");
		LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
		landing.mouse_Hover();
		Thread.sleep(3000);
		if(pageBase.is_Login_visible())
			logger.log(LogStatus.PASS, "Signed out successfully");
		else
			logger.log(LogStatus.FAIL, "unable to logout");
		extent.flush();
		driver.quit();
	}

}
