package com.joom.automation.IntegrationTestCases;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForUser;
import com.joom.automation.generic.fileutility.ExcelUtilityForAdmin;
import com.joom.automation.generic.fileutility.JsonForAdminUtility;

import com.joom.automation.objectrepository.AdminLoginPage;
import com.joom.automation.objectrepository.AdminPage;
import com.joom.automation.objectrepository.HomePage;
import com.joom.automation.objectrepository.SubCategoryPage;


@Listeners(com.joom.automation.listenerUtility.ListImpClass.class)
public class CreateSubCategoryTest extends BaseClassForUser {
	@Test(groups="Integration")
	public void insertSubcategory() throws Throwable {
		
		
		jad = new JsonForAdminUtility();
		
		wb=new WebdriverUtility();

		hp=new HomePage(driver);
		
		Thread.sleep(2000);

		String USERNAME = jad.readDataFromJson("username");
		String PASSWORD = jad.readDataFromJson("password");


		
		hp.getAdminLoginLink().click();
		System.out.println("Admin");

		alp = new AdminLoginPage(driver);
		alp.adminLogin(USERNAME, PASSWORD);
		
		elib= new ExcelUtilityForAdmin();
	
		scp = new SubCategoryPage(driver);
		adp = new AdminPage(driver);
		
	
		WebElement subCategory = adp.getSubCategoryLink();
		subCategory.click();
		
		wb.waitForElementPresent(driver,subCategory , 20);
		WebElement category = scp.getCategoryDropdown();
		category.click();
		String categoryList = elib.getDataFromExcel("Sheet1", 1, 0);

		WebElement selectDropdown = scp.getCategoryDropdown();
		wb.select(selectDropdown, categoryList);
		String subCategoryList = elib.getDataFromExcel("Sheet1", 1, 2);
		wb.waitForElementPresent(driver,category , 20);
		scp.getSubCategoryDropdown().sendKeys(subCategoryList);
		
		WebElement createButton = scp.getCreateButton();
		wb.waitForElementPresent(driver,createButton , 20);
		createButton.click();
		WebElement text = scp.getConfirmMsg();
		wb.waitForElementPresent(driver,text , 20);
		
		Thread.sleep(2000);
		
		
		
		
		text.getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(text, true);
		Reporter.log("created sub category", true);
		
		adp.getLogoutIcon().click();
		adp.getLogoutLink().click();

	}

}
