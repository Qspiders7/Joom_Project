package com.joom.automation.objectrepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {

WebDriver driver;

	public UserLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(name  ="email")
	private WebElement Emailtxtfield;

	@FindBy(name = "password")
	private WebElement Passwordtxtfield;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginbtn;

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getEmailtxtfield() {
		return Emailtxtfield;
	}

	public WebElement getPasswordtxtfield() {
		return Passwordtxtfield;
	}
   
	//public void LoginAsUser(String username,String password) {
		//getEmailtxtfield().sendKeys(username);
		//getPasswordtxtfield().sendKeys(password);
		
	
		//getLoginbtn().click();
	
	
	
	
		
	}
	

