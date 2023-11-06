package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.BaseClass;

public class RegisterPage extends BaseClass{
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Register")
	private WebElement registrationLink;
	@FindBy(id="gender-female")
	private WebElement Gender;
	@FindBy(id="FirstName")
	private WebElement firstName;
	@FindBy(id="LastName")
	private WebElement lastName;
	@FindBy(id="Email")
	private WebElement registerEmail;
	@FindBy(id="Password")
	private WebElement registerPassword;
	@FindBy(id="ConfirmPassword")
	private WebElement registerConfirmPassword;
	@FindBy(id="register-button")
	private WebElement registrationButton;
	@FindBy(xpath="//div[contains(text(), ' Your registration completed')]")
	private WebElement Yourregistrationcompleted;
	@FindBy(xpath="//li[text()='The specified email already exists']")
	private WebElement Thespecifiedemailalreadyexists;
	
	public WebElement getRegistrationLink() {
		return registrationLink;
	}
	public WebElement getGender() {
		return Gender;
	}
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getRegisterEmail() {
		return registerEmail;
	}
	public WebElement getRegisterPassword() {
		return registerPassword;
	}
	public WebElement getRegisterConfirmPassword() {
		return registerConfirmPassword;
	}
	public WebElement getRegistrationButton() {
		return registrationButton;
	}
	public WebElement getYourregistrationcompleted() {
		return Yourregistrationcompleted;
	}
	public WebElement getThespecifiedemailalreadyexists() {
		return Thespecifiedemailalreadyexists;
	}

}
