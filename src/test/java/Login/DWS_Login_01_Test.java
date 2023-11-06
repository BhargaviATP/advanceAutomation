package Login;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.ITestListenerUtility;

@Listeners(ITestListenerUtility.class)
public class DWS_Login_01_Test extends BaseClass {
	@Test(dataProvider = "data", dataProviderClass = ExcelUtility.class,groups="Functional Group")
		public void Login_to_application_withValidCredentials(String email,String password) {
		
		loginpage.getLogin().click();
		logger.log(Status.INFO, "User click on login link");
		loginpage.getEmail().sendKeys("email");
		logger.log(Status.INFO, "User entered email address");
		loginpage.getPassword().sendKeys("password");
		logger.log(Status.INFO, "User entered password");
		loginpage.getRememberMe().click();
		logger.log(Status.INFO, "User clicked on Remember-me");
		loginpage.getLoginBtn().click();
		logger.log(Status.INFO, "User clicked on Login Button");
		
		//String pageurl = loginpage.driver.getCurrentUrl();
		
//		boolean checkpage;
//		if (pageurl.equals(property.getDatafromPropertyFile("url"))) {
//			checkpage = true;
//			logger.log(Status.INFO, "User navigated to Home page");
//		} else {
//			checkpage = false;
//			logger.log(Status.FAIL, "User Login Failed");
//		}
//		assertTrue(checkpage);
		
	}
}
