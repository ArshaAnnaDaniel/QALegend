package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtility;

public class AddUserPage {
	WebDriver driver;
	public AddUserPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (id="surname")
	WebElement surname;
	@FindBy (id="first_name")
	WebElement firstname;
	@FindBy (id="last_name")
	WebElement lastname;
	@FindBy (id="email")
	WebElement ema_il;
	@FindBy (id="username")
	WebElement username;
	@FindBy (id="select2-role-container")
	WebElement role;
	@FindBy (id="password")
	WebElement password;
	@FindBy (id="confirm_password")
	WebElement confirm_password;
	@FindBy (id="submit_user_button")
	WebElement submit_button;
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement logined_user;
	@FindBy(xpath = "//a[@class='btn btn-default btn-flat']")
	WebElement log_out;
	
	public void enterPrefix(String prefix) {
		WebElementUtility.enterValue(surname, prefix);
	}
	public void enterFirstName(String Firstname) {
		WebElementUtility.enterValue(firstname, Firstname);
	}
	public void enterLastName(String Lastname) {
		WebElementUtility.enterValue(lastname, Lastname);
	}
	public void enterEmail(String email) {
		WebElementUtility.enterValue(ema_il, email);
	}
	public void enterUserName(String user_name) {
		WebElementUtility.enterValue(username, user_name);
		
	}
	public void enterPassword(String pass_word) {
		WebElementUtility.enterValue(password, pass_word);
		
	}
	public void enterConPassword(String con_pass_word) {
		WebElementUtility.enterValue(confirm_password, con_pass_word);
		
	}
	public UsersPage clickOnSubmitButton() {
		WebElementUtility.clickOnElement(submit_button);
		return new UsersPage(driver);
		
	}
	public String getTittle() {
		String tittle=driver.getTitle();
		return tittle;
	}
	public void clickOnUserName() {
		WebElementUtility.clickOnElement(logined_user);
	}
	public LoginPage clickOnLogOut() {
		WebElementUtility.clickOnElement(log_out);
		return new LoginPage(driver);
	}

}
