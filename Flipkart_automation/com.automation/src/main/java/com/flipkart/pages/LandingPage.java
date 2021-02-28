package com.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.flipkart.utilities.PagesWebElement;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver){
		this.driver=driver;
	}
	@FindBy(how=How.XPATH,using=PagesWebElement.myAccount )
	@CacheLookup
	WebElement myaccount;
	@FindBy(how=How.XPATH,using=PagesWebElement.search )
	@CacheLookup
	WebElement search;
	@FindBy(how=How.XPATH,using=PagesWebElement.logout )
	@CacheLookup
	WebElement logout;
	@FindBy(how=How.XPATH,using=PagesWebElement.search_Icon )
	@CacheLookup
	WebElement search_Icon;
	@FindBy(how=How.XPATH,using=PagesWebElement.select_product)
	@CacheLookup
	WebElement select_Product;
	@FindBy(how=How.XPATH,using=PagesWebElement.buy_Now)
	@CacheLookup
	WebElement buy_Now;
	@FindBy(how=How.XPATH,using=PagesWebElement.deliver_Here)
	@CacheLookup
	WebElement deliver_Here;


	public void searchProduct(String product_Name) {
		try {Thread.sleep(2000);
		search.clear();
		search.sendKeys(product_Name);}
		catch(Exception e) {
			System.out.println(e);
		}

	}
	public void click_Search()
	{
		try {
			search_Icon.click();
			Thread.sleep(2000);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public Boolean is_Search_Visible()
	{
		try {
			Thread.sleep(2000);
			return search.isDisplayed();
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	public Boolean is_Deliver_Here_Visible()
	{
		try {
			Thread.sleep(2000);
			return deliver_Here.isDisplayed();
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	public void select_product() {

		try {
			select_Product.click();
			Thread.sleep(3000);


		}catch (Exception e) {
			// TODO: handle exception
		}

	}
	public void click_buy_Now() {
		try {
			buy_Now.click();
			Thread.sleep(4000);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public void mouse_Hover()throws Exception
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(myaccount).perform();
		actions.moveToElement(logout).click().perform();
		Thread.sleep(2000);
	}
}
