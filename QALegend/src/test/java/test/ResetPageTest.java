package test;

import org.qalegend.automation_core.Base;
import org.qalegend.contants.Contants;
import org.qalegend.contants.Messages;
import org.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ResetPage;

public class ResetPageTest extends Base{
	@Test(priority=4,groups="Regression")
	public void verifyResetPageTittle() 
	{
		
		
		LoginPage login= new LoginPage(driver);
		ResetPage rest_page=login.clickOnForgetPassword();
		String actual_tittle=driver.getTitle();
		String expected_tittle=ExcelUtility.readStringData(0, 0, Contants.RESET_PAGE_DATA);
		Assert.assertEquals(actual_tittle, expected_tittle,Messages.TITTLE_MISMATCH);
		
	}
	@Test(priority=5,groups="Regression")
	public void verifyErrorMessageWithInvalidEmailid() 
	{
		
		
		  LoginPage login= new LoginPage(driver);
		  ResetPage rest_page=login.clickOnForgetPassword();
		  ResetPage reset= new ResetPage(driver);
		  String email=ExcelUtility.readStringData(2, 0, Contants.RESET_PAGE_DATA);
		  reset.enterEmail(email);
		  reset.clickOnResetLink();
		  String actual_error_message=reset.getEmailErrorMessage();
		  String expected_error_message=ExcelUtility.readStringData(3, 0, Contants.RESET_PAGE_DATA);
		  Assert.assertEquals(actual_error_message, expected_error_message,Messages.EMAIL_ERROR_MISMATCH);
		  }



}
