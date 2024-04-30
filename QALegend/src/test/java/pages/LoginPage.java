package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtility;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//a[@class='btn btn-link']")
	WebElement forgetPassword;
	
	@FindBy(xpath = "//span[@class='help-block']//strong")
	WebElement login_error;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement login;
	
	public ResetPage clickOnForgetPassword() {
		WebElementUtility.clickOnElement(forgetPassword);
		return new ResetPage(driver);
	}
	public void enterUserName(String user_name) {
		WebElementUtility.enterValue(username, user_name);
		
	}
	public void enterPassword(String pass_word) {
		WebElementUtility.enterValue(Password, pass_word);
	}
	public HomePage clickOnLoginButton() {
		WebElementUtility.clickOnElement(login);
		return new HomePage(driver);
	}
	public String getloginErrorMessage() {
		String error=WebElementUtility.getText(login_error);
		return error;
	}

}
