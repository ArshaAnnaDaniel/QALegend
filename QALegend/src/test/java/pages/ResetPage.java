package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtility;

public class ResetPage {
	WebDriver driver;
	public ResetPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(id = "email")
	WebElement email_field;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement Resend_link;
	
	
	@FindBy(xpath = "//span[@class='help-block']//strong")
	WebElement email_error_message;
	
	
	public void enterEmail(String expected_email) {
		WebElementUtility.enterValue(email_field, expected_email);
		}
	public void clickOnResetLink() {
		WebElementUtility.clickOnElement(Resend_link);
	
	}
	public String getEmailErrorMessage() {
		String error=WebElementUtility.getText(email_error_message);
		return error;
	}

}
