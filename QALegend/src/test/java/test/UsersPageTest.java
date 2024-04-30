package test;

import org.qalegend.automation_core.Base;
import org.qalegend.contants.Contants;
import org.qalegend.contants.Messages;
import org.qalegend.utilities.ExcelUtility;
import org.qalegend.utilities.WaitUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;

public class UsersPageTest extends Base{
	@Test(priority=8,groups="Smoke")
	public void verifyManageUserTittle() 
	{
		String username=ExcelUtility.readStringData(2, 0, Contants.LOGIN_PAGE_DATA);
		String password=ExcelUtility.readStringData(3, 0, Contants.LOGIN_PAGE_DATA);
		LoginPage login= new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home= new HomePage(driver);
		HomePage home_=login.clickOnLoginButton();
		home.clickOnEndTour();
		WaitUtility.waitUsingImplicitWait(driver);
		home.clickOnUserManagement();
		UsersPage manage=home.clickOnUsers();
		UsersPage manageuser= new UsersPage(driver);
		String title_actual=manageuser.getTittle();
		String title_expected=ExcelUtility.readStringData(0, 0, Contants.MANAGE_USER_DATA);
		Assert.assertEquals(title_actual, title_expected,Messages.TITTLE_MISMATCH);
		
		
	}


}
