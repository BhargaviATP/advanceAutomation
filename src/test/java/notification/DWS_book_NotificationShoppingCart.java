package notification;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class DWS_book_NotificationShoppingCart extends BaseClass {
	@Test(groups="System Group")
	public void goTo_ShoppingCart_Through_Notification_Bar(){
		
		//Going to ShoppingCart through Notification, instead of ShoppingCart Link.
		
		driver.findElement(By.partialLinkText("Books")).click();
		driver.findElement(By.xpath("//img[@alt='Picture of Computing and Internet']")).click();
		driver.findElement(By.id("add-to-cart-button-13")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.linkText("shopping cart"));
		WBUtility.explicitWaitReference(10).until(ExpectedConditions.visibilityOf(ele));
		ele.click();
		
		WBUtility.explicitWaitReference(10).until(ExpectedConditions.visibilityOf(bookpage.getRemoveCart()));
}
}


