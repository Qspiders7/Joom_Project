package com.joom.automation.IntegrationTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.joom.automation.WebDriverUtility.WebdriverUtility;

import com.joom.automation.baseutility.BaseClassForUser;
import com.joom.automation.generic.fileutility.ExcelUtilityForAdmin;
import com.joom.automation.generic.fileutility.JsonForAdminUtility;
import com.joom.automation.objectrepository.AdminLoginPage;
import com.joom.automation.objectrepository.AdminPage;
import com.joom.automation.objectrepository.HomePage;
import com.joom.automation.objectrepository.InsertProductPage;

@Listeners(com.joom.automation.listenerUtility.ListImpClass.class)
public class InsertProductTest extends BaseClassForUser {
	@Test(groups="Integration")
	public void insertProduct() throws Throwable   {
		
		
		jad = new JsonForAdminUtility();
		
		wb=new WebdriverUtility();

		hp=new HomePage(driver);
		
	ipp	= new InsertProductPage(driver);
		

		String USERNAME = jad.readDataFromJson("username");
		String PASSWORD = jad.readDataFromJson("password");


	
		hp.getAdminLoginLink().click();
		System.out.println("Admin");

		alp = new AdminLoginPage(driver);
		alp.adminLogin(USERNAME, PASSWORD);
	AdminPage	adp = new AdminPage(driver);
		ExcelUtilityForAdmin	elib = new ExcelUtilityForAdmin();
		String category = elib.getDataFromExcel("Sheet1", 1, 0);
		adp.getInserProductLink().click();

		InsertProductPage ipp = new InsertProductPage(driver);
		wb = new WebdriverUtility();
		wb.select(ipp.getCategoryDropDown(), category);
		
		String subcategory = elib.getDataFromExcel("Sheet1", 1, 2);
		

		wb.select(ipp.getSubCategoryDropDown(), subcategory);
		String productName = elib.getDataFromExcel("Sheet1", 1, 3);

		ipp.getProductNameTextField().sendKeys(productName);

		String productCompany = elib.getDataFromExcel("Sheet1", 1, 4);

		ipp.getProductCompanyTextField().sendKeys(productCompany);

		String productPriceBeforeDiscount = elib.getDataFromExcel("Sheet1", 1, 5);

		ipp.getProductPriceBd().sendKeys(productPriceBeforeDiscount);

		String productPriceAfterDiscount = elib.getDataFromExcel("Sheet1", 1, 6);
		ipp.getProductpriceAd().sendKeys(productPriceAfterDiscount);

		String productDiscription = elib.getDataFromExcel("Sheet1", 1, 1);

		ipp.getDescriptionTextField().sendKeys(productDiscription);
		String productShippingCharge = elib.getDataFromExcel("Sheet1", 1, 7);
		WebElement insertButton = driver.findElement(By.xpath("//button[text()='Insert']"));
		
		Actions act=new Actions(driver);
		act.scrollToElement(insertButton);

		ipp.getProductShippingChargeTextField().sendKeys(productShippingCharge);
		String productAvailbility = elib.getDataFromExcel("Sheet1", 1, 8);
		wb.select(ipp.getProductAvailabilityTF(), productAvailbility);
		//ipp.getProductAvailabilityTF().sendKeys(Keys.TAB,Keys.ENTER,"C:/Users/priya/git/repository16/com.joom.automation1/src/test/resources/TestScriptData/iphone_image.webp");
		Thread.sleep(5000);
		
		
		WebElement fileInput1 = ipp.getImage1();
		//fileInput1.click();
		Thread.sleep(2000);
		//Actions a = new Actions(driver);
		///a.sendKeys(ipp.getImage1(),"./src/test/resources/iphone_image.webp").perform();
		fileInput1.sendKeys("‪C:\\Users\\priya\\git\\repository16\\com.joom.automation1\\src\\test\\resources\\TestScriptData\\iphone_image.webp");

        WebElement fileInput2 = ipp.getImage2();
        
        fileInput2.sendKeys("‪C:\\Users\\priya\\git\\repository16\\com.joom.automation1\\src\\test\\resources\\TestScriptData\\iphone_image.webp");

        WebElement fileInput3 = ipp.getImage3();
        fileInput3.sendKeys("‪C:\\Users\\priya\\git\\repository16\\com.joom.automation1\\src\\test\\resources\\TestScriptData\\iphone_image.webp");

        // Click the Insert button
       
        insertButton.click();
        
        adp.getLogoutIcon().click();
		adp.getLogoutLink().click();

	}

}
