package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.BaseClass;

public class DeskTopPage extends BaseClass{

	public DeskTopPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText="Computers")
	private WebElement computerClick;
	@FindBy(partialLinkText="Desktops")
	private WebElement DesktopsClick;
	@FindBy(xpath="//img[@alt=\"Picture of Build your own cheap computer\"]")
	private WebElement clickonProduct;
	@FindBy(xpath="//input[@value=\"Add to compare list\"]")
	private WebElement addtoCompareList;
	@FindBy(xpath="//img[@alt=\"Picture of Build your own expensive computer\"]")
	private WebElement clickonProduct1;
	@FindBy(xpath="//input[@title=\"Remove\"]")
	private List<WebElement> removebutton;
	@FindBy(xpath="//div[contains(text(),'You have no items to compare.    ')]")
	private WebElement NoithemsinCart;
	
	public WebElement getNoithemsinCart() {
		return NoithemsinCart;
	}
	public List<WebElement> getRemovebutton() {
		return (List<WebElement>) removebutton;
	}
	public WebElement getComputerClick() {
		return computerClick;
	}
	public WebElement getDesktopsClick() {
		return DesktopsClick;
	}
	public WebElement getClickonProduct() {
		return clickonProduct;
	}
	public WebElement getAddtoCompareList() {
		return addtoCompareList;
	}
	public WebElement getClickonProduct1() {
		return clickonProduct1;
	}
	
}