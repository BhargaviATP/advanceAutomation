package Cart;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;

@Listeners(ITestListenerUtility.class)
public class DWS_Cart_03_Test extends BaseClass{
	
		@Test(groups="System Group")
		public void addProductToCart() {//added this to system Testing Xml.
			loginpage.getLogin().click();
			logger.log(Status.INFO, "User click on login link ");
			loginpage.getEmail().sendKeys("seleniumjava@yahoo.com");
			logger.log(Status.INFO, "User entered email address ");
			loginpage.getPassword().sendKeys("sele123");
			logger.log(Status.INFO, "User entered password");
			loginpage.getRememberMe().click();
			logger.log(Status.INFO, "User clicked on Remember-me");
			loginpage.getLoginBtn().click();
			logger.log(Status.INFO, "User clicked on Login Button");
			
			cartpage.getAddtoCartButton().click();
			logger.log(Status.INFO, "User clicked on Add-To-Cart Button");
			cartpage.getShoppingcart().click();
			logger.log(Status.INFO, "User clicked on Shopping Cart");
			assertTrue(cartpage.getproduct().isDisplayed());
			logger.log(Status.INFO, "Product added to Cart");
			
			bookpage.getRemoveCart().click();
			bookpage.getUpdateCart().click();
			logger.log(Status.INFO, "Product removed from Shopping Cart");
		
			WBUtility.explicitWaitReference(10).until(ExpectedConditions.visibilityOf(bookpage.getCartisEmptyMSG()));
		}
	}
// jenkins trail

