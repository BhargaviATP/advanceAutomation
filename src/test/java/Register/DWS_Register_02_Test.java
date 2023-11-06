package Register;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;

@Listeners(ITestListenerUtility.class)

public class DWS_Register_02_Test extends BaseClass {
	@Test	(groups="Functional Group")
	public void userRegistration() {
		registerPage.getRegistrationLink().click();
		registerPage.getGender().click();
		registerPage.getFirstName().sendKeys("Manasi");
		registerPage.getLastName().sendKeys("S");
		registerPage.getRegisterEmail().sendKeys("seleMansi@gmail.com");
		registerPage.getRegisterPassword().sendKeys("MansiS");
		registerPage.getRegisterConfirmPassword().sendKeys("MansiS");
		registerPage.getRegistrationButton().click();
		
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(registerPage.getYourregistrationcompleted()),ExpectedConditions.visibilityOf(registerPage.getThespecifiedemailalreadyexists())));
	}

}
