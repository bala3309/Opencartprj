package pageObjects;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//div[@class='product-thumb']")
	List<WebElement> productList;
	
	@FindBy(xpath = "//div[@class='caption']//h4/a")
	WebElement productSearch; 
	
	@FindBy(xpath="//p[contains(text(),'There is no product')]")
	WebElement txtNoProdMsg;
	
	
	public boolean isProductDisplayed() {
		
		return(productList.size()>0);

	}
	 
	public String productConfirm() {
		
		
		return(productSearch).getText().trim();			
				
			}
	
	public String getSearchMsg() {
		
		return(txtNoProdMsg.getText().trim());
	}
		
		
	} 
	
	
	


