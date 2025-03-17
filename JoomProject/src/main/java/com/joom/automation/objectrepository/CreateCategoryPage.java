package com.joom.automation.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCategoryPage {
	@FindBy(xpath = "//input[@placeholder='Enter category Name']")
	private WebElement categoryNameTextField;

	@FindBy(name = "description")
	private WebElement descriptionTextField;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createButton;

	public CreateCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCategoryNameTextField() {
		return categoryNameTextField;
	}

	public WebElement getDescriptionTextField() {
		return descriptionTextField;
	}

	public WebElement getCreateButton() {
		return createButton;
	}

	public void createCategory(String textfield, String description) {
		categoryNameTextField.sendKeys(textfield);
		descriptionTextField.sendKeys(description);
		createButton.click();
	}

}
