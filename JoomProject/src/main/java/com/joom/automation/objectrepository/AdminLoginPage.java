package com.joom.automation.objectrepository;
/*
 *  @author soumya
 *  Contains Contact Page elements and Business Librariries
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	WebDriver driver;
	@FindBy(xpath="//input[@id='inputEmail']")
	private WebElement adminTextField;

	@FindBy(id = "inputPassword")
	private WebElement adminPasswordTextField;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginButton;

	public AdminLoginPage(WebDriver driver) {
		this.driver=driver;

		PageFactory.initElements(driver,this);

	}

	public WebElement getAdminTextField() {
		return adminTextField;
	}

	public WebElement getAdminPasswordTextField() {
		return adminPasswordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void adminLogin(String username, String password) {
		adminTextField.sendKeys(username);
		adminPasswordTextField.sendKeys(password);
		loginButton.click();
	}

}
