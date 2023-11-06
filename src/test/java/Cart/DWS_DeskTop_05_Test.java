package Cart;

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
	
@Test
	public void addDeskTopToCart() throws InterruptedException {
	
//	Actions action = new Actions(driver);
//	action.moveToElement(desktoppage.getComputerClick()).perform();
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
    logger.log(Status.INFO, "Product added to CompareList");
    
    WebDriverWait wait= new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(desktoppage.getClickonProduct()),ExpectedConditions.visibilityOf(desktoppage.getClickonProduct1())));
}
}
