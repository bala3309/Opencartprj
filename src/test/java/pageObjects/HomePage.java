package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	// Constructor

	public HomePage(WebDriver driver) {
		super(driver);

	}

	// locators

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txtSearch;
	
	@FindBy(xpath="//i[@class='fa fa-search']")
	WebElement btnSearch;

	// Actions

	public void clickMyAccount() {
		lnkMyAccount.click();

	}

	public void clickRegister() {
		lnkRegister.click();

	}

	public void clickLogin() {
		lnkLogin.click();
	}
	
	public void searchItem(String product) {
		
		txtSearch.sendKeys(product);

	}
	
	public void clickSearch() {
		btnSearch.click();	
		
		
	}

}
