package com.joom.automation.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserSignUpPage {

	public UserSignUpPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "fullname")
	private WebElement FullNametxtfield;

	@FindBy(id = "email")
	private WebElement Emailtxtfield;

	@FindBy(id = "contactno")
	private WebElement Contactnotxtfield;

	@FindBy(id = "password")
	private WebElement Passwordtxtfield;

	@FindBy(id = "confirmpassword")
	private WebElement ConfirmPasswordtxtfield;

	@FindBy(id = "submit")
	private WebElement SignUpbtn;

	
	public WebElement getFullNametxtfield() {
		return FullNametxtfield;
	}

	public WebElement getEmailtxtfield() {
		return Emailtxtfield;
	}

	public WebElement getContactnotxtfield() {
		return Contactnotxtfield;
	}

	public WebElement getPasswordtxtfield() {
		return Passwordtxtfield;
	}

	public WebElement getConfirmPasswordtxtfield() {
		return ConfirmPasswordtxtfield;
	}

	public WebElement getSignUpbtn() {
		return SignUpbtn;
	}

	public void SignUpAsUser(String Fullname, String Email, String password, String Confirmpassword) {
		getFullNametxtfield().sendKeys(Fullname);
		getEmailtxtfield().sendKeys(Email);
		getPasswordtxtfield().sendKeys(password);
		getConfirmPasswordtxtfield().sendKeys(Confirmpassword);
		getSignUpbtn().click();

	}

}
