package test;

import org.qalegend.automation_core.Base;
import org.qalegend.contants.Contants;
import org.qalegend.contants.Messages;
import org.qalegend.utilities.ExcelUtility;
import org.qalegend.utilities.WaitUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import data_provider.DataProviders;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends Base{
@Test(priority=1,groups="Regression")
	
	public void verifyLoginPageTittle() 
	{
		
		String actual_tittle=driver.getTitle();
		String expected_tittle=ExcelUtility.readStringData(0, 0, Contants.LOGIN_PAGE_DATA);
		Assert.assertEquals(actual_tittle, expected_tittle,Messages.TITTLE_MISMATCH);
		
		
	}
	@Test(priority=2,groups="Regression")
	public void verifyUserLoginWithValidCredentials() 
	{
		String username=ExcelUtility.readStringData(2, 0, Contants.LOGIN_PAGE_DATA);
		String password=ExcelUtility.readStringData(3, 0, Contants.LOGIN_PAGE_DATA);
		
		LoginPage login= new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home= new HomePage(driver);
		HomePage home1=login.clickOnLoginButton();
		WaitUtility.waitUsingImplicitWait(driver);
		home.clickOnEndTour();
		WaitUtility.waitUsingImplicitWait(driver);
		String user_name=home.getLoggedUser();
		String expected_user=ExcelUtility.readStringData(0, 3, Contants.LOGIN_PAGE_DATA);
		Assert.assertEquals(user_name, expected_user,Messages.LOGIN_MISMATCH);
		}
	@Test(priority=3,groups="Smoke",dataProvider="InvalidUserCredentials",dataProviderClass=DataProviders.class)
	public void verifyErrorMessageWhileLoggingWithInvalidCredentials(String username,String password) 
	{
		
		String expected_error=ExcelUtility.readStringData(5, 0, Contants.LOGIN_PAGE_DATA);
		LoginPage login= new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home_=login.clickOnLoginButton();
		String actual_error=login.getloginErrorMessage();
		Assert.assertEquals(actual_error, expected_error,Messages.LOGIN_MISMATCH);
		}
	
	

}
