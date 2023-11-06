package RemoveCart;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;
@Listeners(ITestListenerUtility.class)
public class DWS_RemoveCart_06_Test extends BaseClass {
	@Test(groups="Integration Group")
	/**
	 * This Method is used to click on a product add, the product to
	 * the compared list, and validate whether the added products are present in compared list or not.
	 * @throws InterruptedException
	 */
	public void removeproductfromCart() throws InterruptedException {
		desktoppage.getComputerClick().click();
		desktoppage.getDesktopsClick().click();
		desktoppage.getClickonProduct().click();
		desktoppage.getAddtoCompareList().click();
		Thread.sleep(3000);
		desktoppage.getComputerClick().click();
		desktoppage.getDesktopsClick().click();
		desktoppage.getClickonProduct1().click();
		desktoppage.getAddtoCompareList().click();

		assertTrue(desktoppage.getClickonProduct().isDisplayed());
		
		for(int i=0;i<desktoppage.getRemovebutton().size();) {
			desktoppage.getRemovebutton().get(i).click();
		}
//		for(WebElement remele:desktoppage.getRemovebutton()) {
//			remele.click();
//		}
		if (desktoppage.getRemovebutton().size() == 0) {
			System.out.println("all products are removed from Compare List");
		}
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(desktoppage.getNoithemsinCart()));
	}
}
