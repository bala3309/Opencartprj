package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterPage extends BasePage {

	public UserRegisterPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastName ;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail ;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPwd ;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy ;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue ;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirm;
	
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);	

	}
	public void setLastName(String lname) {
		txtlastName.sendKeys(lname);

	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);

	}
	public void setTelephone(String telphno) {
		txtTelephone.sendKeys(telphno);

	}
	public void setpwd(String pwd) {
		txtPwd.sendKeys(pwd);
	}
	public void setConfirmPwd(String confirmPwd) {
		txtConfirmPwd.sendKeys(confirmPwd);
	}
	public void chkPolicy() {
		chkPolicy.click();

	}
	public void clickContinue() {
		btnContinue.click();

	}
	public String getConfirmationMsg() {
		
		try {
			
			return(msgConfirm.getText());
			
			
		} catch (Exception e) {
			
			return (e.getMessage());
			
			}	
		
		
	}	
	
}
