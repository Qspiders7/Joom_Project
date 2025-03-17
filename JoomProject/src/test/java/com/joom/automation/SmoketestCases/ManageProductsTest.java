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
import com.joom.automation.objectrepository.HomePage;
import com.joom.automation.objectrepository.ManageProductsPage;

@Listeners(com.joom.automation.listenerUtility.ListImpClass.class)
public class ManageProductsTest extends BaseClassForUser {
	@Test( groups = "Smoke")
	public void deleteProducts() throws Throwable {
		mpp = new ManageProductsPage(driver);
		jad = new JsonForAdminUtility();

		String USERNAME = jad.readDataFromJson("username");
		String PASSWORD = jad.readDataFromJson("password");

		alp = new AdminLoginPage(driver);
		alp.adminLogin(USERNAME, PASSWORD);

		HomePage hp = new HomePage(driver);
		hp.getAdminLoginLink().click();

		ela = new ExcelUtilityForAdmin();
		wb = new WebdriverUtility();

		WebElement productLink = mpp.getManageProductsLink();
		wb.waitForElementPresent(driver, productLink, 20);
		productLink.click();
		// String productName = ela.getDataFromExcel("Sheet1", 1, 9);
		wb.waitForPageToLoad(driver);

		driver.findElement(By.xpath(
				"//td[text()='Asian Casuals  (White, White)']/following-sibling::td[last()]//i[contains(@class,'icon-remove-sign')]"))
				.click();
		wb.switchToAlertAndAccept(driver);

	}


}
