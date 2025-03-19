package com.joom.automation.SmoketestCases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.joom.automation.WebDriverUtility.WebdriverUtility;

import com.joom.automation.baseutility.BaseClassForUser;
import com.joom.automation.generic.fileutility.ExcelUtilityForAdmin;
import com.joom.automation.generic.fileutility.JsonForAdminUtility;
import com.joom.automation.objectrepository.AdminLoginPage;
import com.joom.automation.objectrepository.AdminPage;
import com.joom.automation.objectrepository.HomePage;
import com.joom.automation.objectrepository.ManageProductsPage;

@Listeners(com.joom.automation.listenerUtility.ListImpClass.class)
public class ManageProductsTest extends BaseClassForUser {
	@Test( groups = "Smoke")
	public void deleteProducts() throws Throwable {
		mpp = new ManageProductsPage(driver);
		jad = new JsonForAdminUtility();
		hp = new HomePage(driver);
		elib = new ExcelUtilityForAdmin();
		wb = new WebdriverUtility();
		adp=new  AdminPage(driver);
		

		String USERNAME = jad.readDataFromJson("username");
		String PASSWORD = jad.readDataFromJson("password");
		hp.getAdminLoginLink().click();

		System.out.println("hello");
		alp = new AdminLoginPage(driver);
		alp.adminLogin(USERNAME, PASSWORD);

	
		WebElement productLink = mpp.getManageProductsLink();
		wb.waitForElementPresent(driver, productLink, 20);
		productLink.click();
		// String productName = ela.getDataFromExcel("Sheet1", 1, 9);
		wb.waitForPageToLoad(driver);

		
			driver.findElement(By.xpath("//td[text()='ceramic vase']"))	.click();
				
		
		adp.getLogoutIcon().click();
		adp.getLogoutLink().click();

	}


}
