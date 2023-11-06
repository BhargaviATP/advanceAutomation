package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.BaseClass;

public class BookPage {

	public BookPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(partialLinkText="Books")
	private WebElement books;
	@FindBy(xpath="(//input[@class='button-2 product-box-add-to-cart-button'])[1]")
	private WebElement addbooktoCart;
	@FindBy(linkText="Computing and Internet")
	private WebElement bookinCart; 
	@FindBy(name="removefromcart")
	private WebElement removeCart;
	@FindBy(name="updatecart")
	private WebElement updateCart;
	@FindBy(xpath="//div[contains(text(),'Your Shopping Cart is empty!')]")
	private WebElement CartisEmptyMSG;

	public WebElement getCartisEmptyMSG() {
		return CartisEmptyMSG;
	}
	//		@FindBy(xpath = "//input[@class='button-2 product-box-add-to-cart-button']")
	//	    private List<WebElement> elements;
	//return elements.getIndex(1);
	//		public WebElement getElementbyIndex(int index) {
	//			return elements.get(index);
	//		}
	public WebElement getUpdateCart() {
		return updateCart;
	}
	public WebElement getRemoveCart() {
		return removeCart;
	}
	public WebElement getAddbooktoCart() {
		return addbooktoCart;
	}
	public WebElement getBookinCart() {
		return bookinCart;
	}
	public WebElement getBooks() {
		return books;
	}		
	public WebElement getAddBookstoCart() {
		return addbooktoCart;
	}
}

