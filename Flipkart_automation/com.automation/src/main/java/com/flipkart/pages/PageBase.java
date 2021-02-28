package com.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.flipkart.utilities.PagesWebElement;

public class PageBase {

	WebDriver driver;

	public PageBase(WebDriver driver){
		this.driver=driver;
	}

	@FindBy(how=How.XPATH,using=PagesWebElement.userName)
	@CacheLookup
	WebElement username;
	@FindBy(how=How.XPATH,using=PagesWebElement.password)
	@CacheLookup
	WebElement password;
	@FindBy(how=How.XPATH,using= PagesWebElement.login_btn)
	@CacheLookup
	WebElement login;

	@FindBy(how=How.XPATH,using = PagesWebElement.submit_Credentials)
	@CacheLookup
	WebElement submitCredentials;
	@FindBy(how=How.XPATH,using= PagesWebElement.popUp_cross_btn)
	@CacheLookup
	WebElement login_Popup;

	public  void click_Login() 
	{
		try {
			login.click();

		}catch(Exception e)
		{
			System.out.println(e);

		}


	}	

	public  Boolean is_Login_visible() 
	{
		try {
			return login.isDisplayed();

		}catch(Exception e)
		{
			System.out.println(e);
			return false;

		}


	}	

	public  void enter_Username(String uname)
	{
		try {
			Thread.sleep(2000);
			username.click();
			username.clear();
			username.sendKeys(uname);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}


	}
	public   Boolean is_Username_visible()
	{
		try {
			return username.isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}


	}
	public  void enter_Password(String pwd) 
	{
		try {
			password.clear();
			password.sendKeys(pwd);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}
	public  void submit_Credential(){

		try {
			submitCredentials.click();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
