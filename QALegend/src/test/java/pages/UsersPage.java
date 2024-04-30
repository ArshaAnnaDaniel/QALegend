package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtility;

public class UsersPage {
	WebDriver driver;
	public UsersPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (xpath="//a[@class='btn btn-block btn-primary']")
	WebElement add;
	@FindBy (xpath="//input[@class='form-control input-sm']")
	WebElement search;
	@FindBy(xpath = "//a[@class='dropdown-toggle']//span")
	WebElement logined_user;
	@FindBy(xpath = "//a[@class='btn btn-default btn-flat' and text()='Sign Out']")
	WebElement log_out;
	
	@FindBy (xpath="//td[@class='sorting_1']")
	WebElement search_row;
	public String getTittle() {
		String tittle=driver.getTitle();
		return tittle;
	}
	public AddUserPage clickOnAddButton() {
		WebElementUtility.clickOnElement(add);
		return new AddUserPage(driver);
	}
	public void clickOnSearch() {
		WebElementUtility.clickOnElement(search);
	}
	public String getSerachUser() {
		String user=WebElementUtility.getText(search_row);
		return user;
	}
	public void enterSearchValue(String sea_rch) {
		WebElementUtility.enterValue(search, sea_rch);
		
	}
	public void clickOnUserName() {
		//WebElementUtility.clickOnElement(logined_user);
		WebElementUtility.scrollAndClick(driver, logined_user);
	}
	public LoginPage clickOnLogOut() {
		WebElementUtility.clickOnElement(log_out);
		return new LoginPage(driver);
	}

}
