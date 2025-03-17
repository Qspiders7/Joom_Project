package com.joom.automation.objectrepository;
/* 
 * @author soumya
 * 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//a[text()='Admin Login']")
	private WebElement adminLoginLink;

	@FindBy(linkText = "Login")
	private WebElement loginLink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAdminLoginLink() {
		return adminLoginLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

}
