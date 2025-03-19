package com.joom.automation.SystemTestCases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForUser;
import com.joom.automation.generic.fileutility.JsonForUserUtility;
import com.joom.automation.objectrepository.HomePage;
import com.joom.automation.objectrepository.UserFashionCategoryPage;
import com.joom.automation.objectrepository.UserLoginPage;
import com.joom.automation.objectrepository.UserMyCartPage;
import com.joom.automation.objectrepository.UserShoppingHomePage;

@Listeners(com.joom.automation.listenerUtility.ListImpClass.class)
public class UpdatingShoppingCartTest extends  BaseClassForUser{
	
	@Test(groups="System Test")
	public void updatingShoppingCartTest() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		HomePage hp = new HomePage(driver);
		UserLoginPage ullp = new UserLoginPage(driver);
		UserMyCartPage umcp=new UserMyCartPage(driver);
		UserFashionCategoryPage ufcp = new UserFashionCategoryPage (driver);
		js=new JsonForUserUtility();
		wb=new WebdriverUtility();
		//implicit wait
		wb.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		
		hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.getLoginLink().click();

		js = new JsonForUserUtility();
		String USERNAME = js.readDataFromJson("username");
		Thread.sleep(3000);
		String PASSWORD = js.readDataFromJson("password");
		Thread.sleep(3000);

         ullp = new UserLoginPage(driver);
		ullp.getEmailtxtfield().sendKeys(USERNAME);
		ullp.getPasswordtxtfield().sendKeys(PASSWORD);
		WebElement ele = ullp.getLoginbtn();
		// wb.scrollToElement(driver, ele);
		wb = new WebdriverUtility();
		wb.scrollByAmountt(driver, ele);
		ele.click();
		
		//click on fashion
		System.out.println("hai");
		 ushp= new UserShoppingHomePage(driver);
		 System.out.println("hai1");
		ushp.getFashionbtn().click();
		
		//click on saree product
		ufcp=new UserFashionCategoryPage(driver);
		Thread.sleep(2000);
	
		WebElement saree= ufcp.getSareeBtn();
		wb=new WebdriverUtility();
		//wb.scrollToElement(driver, saree);
		//saree.click();
		Thread.sleep(2000);
		//wb.scrollByAmountt(driver, saree);
		System.out.println("hai3");
		wb.scrollToElements(driver,saree);
		System.out.println("hai4");
		saree.click();
		Thread.sleep(2000);
		//product has been added to the cart popup
		//wb.switchtoAlertAndAccept(driver);
		wb.scrollToElements(driver, saree);
		ufcp.getAddtoCartBtn().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
		    wait.until(ExpectedConditions.alertIsPresent()); 
		    Alert alert = driver.switchTo().alert();
		    alert.accept();
		} catch (Exception e) {
		    System.out.println("No alert appeared.");
		}
		Thread.sleep(2000);
		
	
		//click on updateshopping cart button
	     umcp=new UserMyCartPage(driver);
		Thread.sleep(2000);
		WebElement update = umcp.getUpdateShoppingCartBtn();
		wb= new WebdriverUtility();
		wb.scrollByAmount(driver, update);
		umcp.getUpdateShoppingCartBtn().click();
		Thread.sleep(2000);
		//your cart has been updated popup
		wb.switchtoAlertAndAccept(driver);
		
		SoftAssert sa= new SoftAssert();
  		sa.assertTrue(driver.getCurrentUrl().contains("Online_Shopping_Application/my-cart.php"), "updating was not processed successfully!");

        Reporter.log("Updating the cart test passed successfully.",true);

		ulp.getLogoutlink().click();
		
		
		
		
		
	}

}
