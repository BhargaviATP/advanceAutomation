package Book;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;

@Listeners(ITestListenerUtility.class)
public class DWS_Book_04_Test extends BaseClass {
	@Test(groups="System Group")
	public void addBookToCart() throws InterruptedException {
		bookpage.getBooks().click();
		logger.log(Status.INFO, "User Clicked on Books Field");
		Thread.sleep(2000);

		bookpage.getAddBookstoCart().click();
		logger.log(Status.INFO, "User clicked on addBookToCart");
		Thread.sleep(2000);

		cartpage.getShoppingcart().click();
		logger.log(Status.INFO, "User clicked on Shopping Cart");

		assertTrue(bookpage.getBookinCart().isDisplayed());
		logger.log(Status.INFO, "Book added to Shopping Cart");

		bookpage.getRemoveCart().click();
		bookpage.getUpdateCart().click();
		logger.log(Status.INFO, "Book removed from Shopping Cart");
		
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(bookpage.getCartisEmptyMSG()));
	}
}

