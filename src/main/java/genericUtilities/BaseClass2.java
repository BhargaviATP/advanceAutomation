package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass2 {
	public static WebDriver driver;
	public static TakesScreenShotUtility ScreenShot;
	@BeforeMethod
	public static void Demo() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		ScreenShot = new TakesScreenShotUtility(driver);
		
	}

}
