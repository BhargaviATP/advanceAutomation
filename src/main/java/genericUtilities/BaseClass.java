package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.BookPage;
import objectRepository.CartPage;
import objectRepository.DeskTopPage;
import objectRepository.LoginPage;
import objectRepository.RegisterPage;
import objectRepository.WishListPage;
import objectRepository.emailErrorMsgPage;
import objectRepository.jewelleryPage;
import objectRepository.removeWishListPage;

public class BaseClass implements IAutoConstants {
	public static WebDriver driver;
	public static ExtentTest logger;
	public static TakesScreenShotUtility ScreenShot;
	public static WebDriverUtility WBUtility;
	public PropertyUtility property;
	DatabaseUtility DBUtility;
	public JavaUtility javautility;
	public static LoginPage loginpage;
	public static CartPage cartpage;
	public static BookPage bookpage;
	public static RegisterPage registerPage;
	public static DeskTopPage desktoppage;
	public static jewelleryPage jpage;
	public static emailErrorMsgPage mailErrorMsg;
	public static WishListPage wishlist;
	public static removeWishListPage remwishlist;

	@BeforeClass(alwaysRun = true)
	/**
	 * This Method is used to launch the Browser, it's pre-Condition
	 * for @Test. and Navigate to the application, and initialise utility variables
	 */
	public void launchtheBrowserandNavigateToApplication() {
		property=new PropertyUtility();

		if(BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}if(BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(property.getDatafromPropertyFile("url"));
		WBUtility=new WebDriverUtility(driver);
		ScreenShot= new TakesScreenShotUtility(driver);
		DBUtility=new DatabaseUtility();
		javautility=new JavaUtility();
		loginpage=new LoginPage(driver);
		cartpage=new CartPage(driver);
		bookpage=new BookPage(driver);
		registerPage = new RegisterPage(driver);
		desktoppage=new DeskTopPage(driver);
		jpage = new jewelleryPage(driver);
		mailErrorMsg=new emailErrorMsgPage(driver);
		wishlist = new WishListPage(driver);
		remwishlist = new removeWishListPage(driver);
	}

	@BeforeMethod(alwaysRun = true)
	/**
	 * This Method is used to log into the application, it's a pre-cond
	 * to the @Test. 
	 */
	public void loginToApplication() {
		System.out.println("logged in to application");
	}

	@AfterMethod(alwaysRun = true)
	/**
	 * This Method is used to log out from application, it's a post-cond
	 * to the @Test. 
	 */
	public void logoutFromApplication() {
		System.out.println("logged out from application");
	}

	@AfterClass(alwaysRun = true)
	/**
	 * This Method is used to close the browser, it's a post-cond
	 * to the @Test. 
	 * @throws InterruptedException 
	 */
	public void teardownTheBrowser() {
		driver.quit();
	}
}


