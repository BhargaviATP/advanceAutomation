package DeskTopsCompare;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;

@Listeners(ITestListenerUtility.class)
public class DWS_DeskTop_05_Test extends BaseClass{
	@Test(groups="System Group")
	/**
	 * This Method is used to check, whether added products are in cart or not
	 ** @throws InterruptedException
	 */
	public void addDeskTopToCart() throws InterruptedException {
		desktoppage.getComputerClick().click();
		desktoppage.getDesktopsClick().click();
		desktoppage.getClickonProduct().click();
		desktoppage.getAddtoCompareList().click();
		Thread.sleep(3000);
		driver.navigate().back();
		desktoppage.getDesktopsClick().click();
		desktoppage.getClickonProduct1().click();
		desktoppage.getAddtoCompareList().click();

		assertTrue(desktoppage.getClickonProduct().isDisplayed());
		logger.log(Status.INFO, "Product added to CompareList");
		assertTrue(desktoppage.getClickonProduct1().isDisplayed());
		logger.log(Status.INFO, "Product1 added to CompareList");
		
		WBUtility.explicitWaitReference(10).until(ExpectedConditions.visibilityOf(desktoppage.getClickonProduct()));
	}
}
