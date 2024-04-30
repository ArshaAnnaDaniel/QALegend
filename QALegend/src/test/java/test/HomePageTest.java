package test;

import org.qalegend.automation_core.Base;
import org.qalegend.contants.Contants;
import org.qalegend.contants.Messages;
import org.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends Base{
	@Test(priority=6,groups="Regression")
	public void verifyHomePageTittle() 
	{
		String username=ExcelUtility.readStringData(2, 0, Contants.LOGIN_PAGE_DATA);
		String password=ExcelUtility.readStringData(3, 0, Contants.LOGIN_PAGE_DATA);
		LoginPage login= new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home= new HomePage(driver);
		HomePage home_=login.clickOnLoginButton();
		String actual_tittle=home.getTittle();
		String expected_tittle=ExcelUtility.readStringData(2, 0, Contants.HOME_PAGE_DATA);
		Assert.assertEquals(actual_tittle, expected_tittle,Messages.TITTLE_MISMATCH);
	   }
	@Test(priority=7,groups={"Regression","Smoke"})
	public void verifyUserLoginDate() 
	{
		String username=ExcelUtility.readStringData(2, 0, Contants.LOGIN_PAGE_DATA);
		String password=ExcelUtility.readStringData(3, 0, Contants.LOGIN_PAGE_DATA);
		LoginPage login= new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home= new HomePage(driver);
		HomePage home_=login.clickOnLoginButton();
		String actual_logindate = home.getLoginDate();
		String expected_logindate = home.getCurrentDate();
		Assert.assertEquals(actual_logindate, expected_logindate, Messages.LOGIN_DATE_FAILED);
		
	}

}
