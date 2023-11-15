package EmailFriend;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;

@Listeners(ITestListenerUtility.class)
public class DWS_EmailFriend_08_Test extends BaseClass {
	@Test(groups="Functional Group")
	public void CaptureErrorMsgbyEmailingFriend() {
		mailErrorMsg.getApparelShoeslink().click();
		mailErrorMsg.getPolkaDotTop().click();
		mailErrorMsg.getEmailaFriendButton().click();
		mailErrorMsg.getEnterFriendEmail().sendKeys("fgc@yahoo.com");
		mailErrorMsg.getEnteryourEmail().sendKeys("fcghhgg@gmail.com");
		mailErrorMsg.getSendEmailButton().click();
		
		String ActualErrorMsg = mailErrorMsg.getErrorMsg().getText();
		String ExpectedErrorMsg="Only registered customers can use email a friend feature";
		
		assertEquals(ActualErrorMsg,ExpectedErrorMsg);
		logger.log(Status.INFO, "Yes, Actual msg is same as Expected Msg");
		
		WBUtility.explicitWaitReference(10).until(ExpectedConditions.visibilityOf(mailErrorMsg.getErrorMsg()));
	}
}
