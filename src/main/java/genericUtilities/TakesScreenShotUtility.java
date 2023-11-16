package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakesScreenShotUtility {
	WebDriver driver;
	TakesScreenshot ss;
	public TakesScreenShotUtility(WebDriver driver) {
		this.driver=driver;
		ss=(TakesScreenshot)driver;
	}
	/**
	 * 
	 * This method captures a screenshot and appends the current time to the filename.
	 * To obtain the present time, it uses 'LocalDateTime.now()', converts it to a string, and replaces colons (":") with hyphens ("-") to ensure a valid filename.
	 * The method constructs a file path that integrates the user's directory to store the screenshot within a specified directory.
	 * The user directory is retrieved using 'System.getProperty("user.dir")'.
	 * 
	 * @param screenshotname
	 * @return path of screenshot along with directory
	 */
	public String capturingScreenShot(String ScreenShotName) {
		File photo = ss.getScreenshotAs(OutputType.FILE);
		String time = LocalDateTime.now().toString().replace(":", "-");
		String directory = System.getProperty("user.dir");
		String path=""+directory+"./target/erroshots/"+ScreenShotName+" "+time+".png";
		//this will attach the root directory path which is from the user system to the path of the screenshot taken in eclipse,
		//this is needed to integrate the screenShot with the Extent report.
		File destination=new File(path);
		try {
			FileUtils.copyFile(photo, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
