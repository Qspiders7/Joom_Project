package com.joom.automation.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsertProductPage {

	@FindBy(xpath = "//select[@name='category']")
	private WebElement categoryDropDown;

	@FindBy(xpath = "//select[@name='subcategory']")
	private WebElement subCategoryDropDown;

	@FindBy(xpath = "//input[@name='productName']")
	private WebElement productNameTextField;

	@FindBy(xpath = "//input[@name='productCompany']")
	private WebElement productCompanyTextField;

	@FindBy(xpath = "//input[@name='productpricebd']")
	private WebElement productPriceBd;

	@FindBy(xpath = "//input[@name='productprice']")
	private WebElement productpriceAd;

	@FindBy(xpath = "//div[@class=' nicEdit-main']")
	private WebElement descriptionTextField;

	@FindBy(xpath = "//input[@name='productShippingcharge']")
	private WebElement productShippingChargeTextField;

	@FindBy(xpath = "//select[@name='productAvailability']")
	private WebElement productAvailabilityTF;

	@FindBy(xpath = "//input[@name='productimage1']")
	private WebElement image1;

	@FindBy(xpath="//input[@name='productimage2']")
	private WebElement image2;

	@FindBy(xpath="//input[@name='productimage3']")
	private WebElement image3;

	@FindBy(xpath = "//button[text()='Insert']")
	private WebElement insertButton;

	public InsertProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getCategoryDropDown() {
		return categoryDropDown;
	}

	public WebElement getSubCategoryDropDown() {
		return subCategoryDropDown;
	}

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getProductCompanyTextField() {
		return productCompanyTextField;
	}

	public WebElement getProductPriceBd() {
		return productPriceBd;
	}

	public WebElement getProductpriceAd() {
		return productpriceAd;
	}

	public WebElement getDescriptionTextField() {
		return descriptionTextField;
	}

	public WebElement getProductShippingChargeTextField() {
		return productShippingChargeTextField;
	}

	public WebElement getProductAvailabilityTF() {
		return productAvailabilityTF;
	}

	public WebElement getImage1() {
		return image1;
	}

	public WebElement getImage2() {
		return image2;
	}

	public WebElement getImage3() {
		return image3;
	}

	public WebElement getInsertButton() {
		return insertButton;
	}

}
