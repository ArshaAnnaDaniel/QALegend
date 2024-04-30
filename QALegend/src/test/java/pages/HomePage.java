package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.DateUtility;
import org.qalegend.utilities.WebElementUtility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (xpath ="//section[@class='content-header']//h1")
	WebElement welcome_user;
	@FindBy(xpath ="//span[@class='title']")
	WebElement user_management;
	@FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']")
	WebElement login_Date;
	@FindBy (xpath ="/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/span")
	WebElement users;
	@FindBy (xpath ="//button[@class='btn btn-default btn-sm']")
	WebElement endtour;
	
	public String getLoggedUser() {
		String user=WebElementUtility.getText(welcome_user);
		return user;
	}
	public String getTittle() {
		String tittle=driver.getTitle();
		return tittle;
	}
	
	public String getLoginDate()
	{
		String login_date = WebElementUtility.getText(login_Date);
		return login_date;
	}
	public String getCurrentDate()
	{
		String current_date = DateUtility.getUserLoginDate("dd-MM-YYYY");
		return current_date;
	}
	public void clickOnUserManagement() {
		WebElementUtility.clickOnElement(user_management);
		
	}
	public UsersPage clickOnUsers() {
		WebElementUtility.clickOnElement(users);
		return new UsersPage(driver);
		
	}
	public void clickOnEndTour() {
		WebElementUtility.clickOnElement(endtour);
		
	}

}
