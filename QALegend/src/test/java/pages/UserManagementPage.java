package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtility;

public class UserManagementPage {
	WebDriver driver;
	public UserManagementPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//span[@class='title' and contains(text(),'Users')]")
	WebElement user;
	@FindBy(xpath = "//span[@class='title' and contains(text(),'Roles')]")
	WebElement roles;
	//ul[@class='treeview-menu menu-open']//span[@class='title'])[2]
	@FindBy(xpath = "//span[@class='title' and contains(text(),'Sales Commission Agents')]")
	WebElement sales_commission_agents;
	
	
	public boolean isUserEnable() {
		boolean user_enable=WebElementUtility.isElementEnabled(user);
		return user_enable;
	}
	public boolean isRoleEnable() {
		boolean role_enable=WebElementUtility.isElementEnabled(roles);
		return role_enable;
	}
	public boolean isSaleEnable() {
		boolean sale_enable=WebElementUtility.isElementEnabled(sales_commission_agents);
		return sale_enable;
	}

}
