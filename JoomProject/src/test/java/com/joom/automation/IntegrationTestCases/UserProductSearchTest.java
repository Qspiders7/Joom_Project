package com.joom.automation.IntegrationTestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForUser;
import com.joom.automation.generic.fileutility.ExcelUtilityForAdmin;
import com.joom.automation.generic.fileutility.JsonForUserUtility;
import com.joom.automation.objectrepository.HomePage;
import com.joom.automation.objectrepository.UserLogOutPage;
import com.joom.automation.objectrepository.UserLoginPage;
import com.joom.automation.objectrepository.UserShoppingHomePage;
@Listeners(com.joom.automation.listenerUtility.ListImpClass.class)
public class UserProductSearchTest extends BaseClassForUser {
	@Test(groups="Integration")
	public void userProductSearchTest() throws EncryptedDocumentException, IOException, InterruptedException, ParseException {
		js = new JsonForUserUtility();
		wb = new WebdriverUtility();
		ulp= new UserLogOutPage(driver);
		ullp = new UserLoginPage(driver);

		wb.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.getLoginLink().click();

		js = new JsonForUserUtility();
		String USERNAME = js.readDataFromJson("username");
		Thread.sleep(3000);
		String PASSWORD = js.readDataFromJson("password");
		Thread.sleep(3000);

		
		ullp.getEmailtxtfield().sendKeys(USERNAME);
		ullp.getPasswordtxtfield().sendKeys(PASSWORD);
		WebElement ele = ullp.getLoginbtn();
		// wb.scrollToElement(driver, ele);
		wb = new WebdriverUtility();
		wb.scrollByAmountt(driver, ele);
		ele.click();

		ushp = new UserShoppingHomePage(driver);
		elib = new ExcelUtilityForAdmin();
		String category = elib.getDataFromExcel("USER", 1, 5);
		Thread.sleep(1000);
		ushp.getSeachtxtfld().sendKeys(category);
		ushp.getLoginbtn().click();
		
		SoftAssert sa= new SoftAssert();
  		sa.assertTrue(driver.getCurrentUrl().contains("Online_Shopping_Application/search-result.php"), "searched product not displayed successfully!");
  		Reporter.log("searched product displayed successfully.",true);
  		sa.assertAll();
  		
  		ulp.getLogoutlink().click();
  		
  		
  		


	}

}
