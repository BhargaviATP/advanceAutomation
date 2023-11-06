package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.BaseClass;

public class CartPage extends BaseClass {
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//input[@class='button-2 product-box-add-to-cart-button'])[2]")
	private WebElement addtoCartButton;
	@FindBy(linkText="Shopping cart")
	private WebElement Shoppingcart;
	@FindBy(linkText="Shopping cart(0)")
	private WebElement Shoppingcartzero;
	@FindBy(linkText="14.1-inch Laptop")
	private WebElement product;
	
	public WebElement getproduct() {
		return product;
	}
	public WebElement getAddtoCartButton() {
		return addtoCartButton;
	}
	public WebElement getShoppingcart() {
		return Shoppingcart;
	}
	public WebElement getShoppingcartzero() {
		return Shoppingcartzero;
	}
}
