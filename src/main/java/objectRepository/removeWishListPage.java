package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.BaseClass;

public class removeWishListPage extends BaseClass {
	public removeWishListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='removefromcart']")
	private WebElement productCheckBox;
	@FindBy(xpath="//input[@value='Update wishlist']")
	private WebElement updateWishList;
	
	public WebElement getProductCheckBox() {
		return productCheckBox;
	}
	public WebElement getUpdateWishList() {
		return updateWishList;
	}
	
}
