package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testbase.BaseClass;

public class TC_004_ProductSearch extends BaseClass {
	
	@Test
	public void searchProduct() {
		
		try {
		
		HomePage hp = new HomePage(driver);
		hp.searchItem(p.getProperty("product"));
		hp.clickSearch();
		
		SearchPage sp= new SearchPage(driver);		
		
		String productName=p.getProperty("product");
		
		if (sp.isProductDisplayed()) {
			
			String actualProduct =sp.productConfirm();	
			
			Assert.assertEquals(actualProduct.toLowerCase().contains(productName.toLowerCase()), true);			
			
		} else {			
			
			String exp_msg=sp.getSearchMsg();
			String actual_msg=p.getProperty("noProdMsg");
			
			Assert.assertEquals(exp_msg.toLowerCase()
					.contains(actual_msg.toLowerCase()),true);		}	
		
		}
		catch (Exception e) {
			
			Assert.fail();
		}
		
		
		}
		

	}
	


