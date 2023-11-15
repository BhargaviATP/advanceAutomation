package Jewellery;

import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;

@Listeners(ITestListenerUtility.class)
public class DWS_jewellery_07_Test extends BaseClass {
	@Test(groups="Integration Group")
	/**
	 * This Method is used to check, whether jewellery is
	 * selected range or not,
	 ** @throws InterruptedException
	 */
	public void compareJewelleryPrice() {
		jpage.getJewelry().click();
		String productPriceRange = jpage.getPriceRangeFilter().getText();
		jpage.getPriceRangeFilter().click();
		String S1=productPriceRange.substring(7, 10);
		int productPricerange=Integer.parseInt(S1);
		
		int strnum = 0;
		for(WebElement price:jpage.getAllPrices()) {
			String substr = price.getText().substring(0, price.getText().length()-3);
			strnum=Integer.parseInt(substr);
			System.out.println(strnum);
		}
		    assertTrue(strnum<=productPricerange);
			System.out.println("All products within range");
			logger.log(Status.INFO, "Yes, Jewellery is within selected Range");
			
			WBUtility.explicitWaitReference(10).until(ExpectedConditions.visibilityOf(jpage.getRemoveFileterAppeared()));
		}
	}




