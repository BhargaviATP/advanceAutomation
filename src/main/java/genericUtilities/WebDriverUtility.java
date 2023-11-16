package genericUtilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	WebDriver driver;
	JavascriptExecutor js;
	public WebDriverUtility(WebDriver driver) { // class Constructor
		this.driver=driver;
		js=(JavascriptExecutor)driver;
	}
	
	/**
	 * This method is developed for creating a webdriverwait object
	 * that returns wait obj.
	 * @param time
	 * @return WebDriverwait reference variable
	 */
	
	public WebDriverWait explicitWaitReference(int time) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		return wait;
	}
	
	/**
	 * This Method is used to click on Elements using JavaScript Executor
	 * @param WebElement
	 * @return void
	 */
	
	public void clickonElementusingJS( WebElement ele) {
		js.executeScript("arguments[0].click();",ele);
	}
	/*************OLD APPROACH***************/
	//WebDriver driver;
	//public void clickonElementusingJSOLD( WebDriver driver,WebElement ele) {
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();",ele);
	//}
	
	/**
	 * This is a generic method to handle drop downs 
	 * (by VisibleText, Value, Index)
	 * @param WebElement
	 * @return void
	 */
	
	public void handlingDropdown(WebElement element, String value) {
		Select select = new Select(element);
		try {
			select.selectByVisibleText(value);
		}catch (NoSuchElementException e) {
			try {
			select.selectByValue(value);
			
		}catch (Exception e1) {
			select.selectByIndex(Integer.parseInt(value));
		}
		}
	}
	
	/**
	 * This method is developed to create a reference for action class
	 * @return Action  reference variable
	 */
	
	public Actions actionsReference() {
		Actions action = new Actions(driver);
		return action;
	}
	
	/**
	 * This Method is used to enter data into the choosen webElement
	 * @param ele
	 * @param data
	 */
	
	public void enterDataintoElement(WebElement ele,String data) {
		js.executeScript("arguments[0].value='"+data+"'",ele);
	}
	
	/**
	 * This method is developed to scroll the webpage to the given coordinates only once.
	 * @param x coordinate
	 * @param y coordinate
	 */
	
	public void scrollByJS(int x,int y) {
		js.executeScript("window.scrollBy("+x+","+y+");");
	}
	
	/**
	 * This method is developed to scroll the webpage to the given coordinates repeatedly.
	 * @param x coordinate
	 * @param y coordinate
	 */
	
	public void scrollToJS(int x, int y) {
		js.executeScript("window.scrollTo("+x+","+y+");");
	}
	
	/**
	 * This method is used to scroll webpage by element visibility
	 * @param element
	 * @param status
	 */
	
	public void scrollInToViewAction(WebElement element, Boolean status) {
		js.executeScript("arguments[0].scrollIntoView("+status+")",element);
	}
	
	/**
	 * This method is used to switch the driver control from window to frame with help of index
	 * @param index
	 */
	
	public void switchingToFrame(int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch the driver control from window to frame with help of name
	 * @param name
	 */
	
	public void switchingToFrame(String name) {
		driver.switchTo().frame(name);
	}
	
	/**
	 * This method is used to switch the driver control from window to frame with help of WebElement
	 * @param element
	 */
	
	public void switchingToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method is used to switch the driver control from frame to Main window
	 */
	
	public void switchingBackToMainWindow() {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * this method is returning the alert reference
	 */
	
	public Alert returnAlertReference() {
		return driver.switchTo().alert();
	}
	
	/**
	 * This method is used to switch the driver control from one window to another
	 * @param allWindowids
	 * @param expectedTilte
	 * @param parentid
	 */
	
	public void switchingToWindow(Set<String> allWindowids,String expectedTitle, String parentid) {
		allWindowids.remove(parentid);
		for(String id:allWindowids) {
			driver.switchTo().window(id);
			if(expectedTitle.equalsIgnoreCase(driver.getTitle())){
				break;
			}
		}
	}
	
	/**
	 * This method is used to switch the driver control from 
	 * frame to window.
	 * @param parentID
	 */
	
	public void switchingBackToParentWindow(String parentID) {
		driver.switchTo().window(parentID);
	}
	
 }

