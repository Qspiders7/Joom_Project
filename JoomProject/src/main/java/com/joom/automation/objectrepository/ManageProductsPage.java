package com.joom.automation.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductsPage {

	@FindBy(xpath = "//a[contains(text(),'Manage Products')] ")
	private WebElement manageProductsLink;

	public ManageProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getManageProductsLink() {
		return manageProductsLink;
	}

}
