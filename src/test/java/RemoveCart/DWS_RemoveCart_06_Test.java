package RemoveCart;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
		driver.navigate().back();
		desktoppage.getDesktopsClick().click();
		desktoppage.getClickonProduct1().click();
		desktoppage.getAddtoCompareList().click();

		assertTrue(desktoppage.getClickonProduct().isDisplayed());
		assertTrue(desktoppage.getClickonProduct1().isDisplayed());
			
		for(WebElement remele:desktoppage.getRemovebuttonlist()) {
			try {
				remele.click();
			}catch(Exception e) {
				remele = driver.findElement(By.xpath("//input[@value='Remove']"));
				remele.click();
				System.out.println("Message found: "+e.getMessage());
			}
		}
		if (desktoppage.getRemovebuttonlist().size() == 0) {
			System.out.println("all Desktops are removed from Compare List");
			logger.log(Status.INFO, "all desktops removed from the cart");
		}
		
		WBUtility.explicitWaitReference(10).until(ExpectedConditions.visibilityOf(desktoppage.getNoithemsinCart()));
	}
}
