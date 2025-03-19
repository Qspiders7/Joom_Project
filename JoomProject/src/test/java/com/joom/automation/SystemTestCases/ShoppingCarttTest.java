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
import com.joom.automation.objectrepository.UserBooksCategoryPage;
import com.joom.automation.objectrepository.UserLogOutPage;
import com.joom.automation.objectrepository.UserLoginPage;
import com.joom.automation.objectrepository.UserMyCartPage;
import com.joom.automation.objectrepository.UserPaymentMethodPage;
import com.joom.automation.objectrepository.UserProductDetailsPage;
import com.joom.automation.objectrepository.UserShoppingHomePage;
@Listeners(com.joom.automation.listenerUtility.ListImpClass.class)
public class ShoppingCarttTest extends BaseClassForUser {
	
	@Test(groups="System Test")
	public void shoppingCarttTest() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		js=new JsonForUserUtility();
		wb=new WebdriverUtility();
		ulp=new  UserLogOutPage(driver);
		
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.getLoginLink().click();

		js = new JsonForUserUtility();
		String USERNAME = js.readDataFromJson("username");
		Thread.sleep(3000);
		String PASSWORD = js.readDataFromJson("password");
		Thread.sleep(3000);

		UserLoginPage ullp = new UserLoginPage(driver);
		ullp.getEmailtxtfield().sendKeys(USERNAME);
		ullp.getPasswordtxtfield().sendKeys(PASSWORD);
		WebElement ele = ullp.getLoginbtn();
		// wb.scrollToElement(driver, ele);
		wb = new WebdriverUtility();
		wb.scrollByAmountt(driver, ele);
		ele.click();
		
		wb.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		
		//click on books button
	 ushp = new UserShoppingHomePage(driver);
		ushp.getBooksbtn().click();
		
		//click on demo book
		 ubcp= new UserBooksCategoryPage(driver);
		WebElement demobook = ubcp.getDemobooklink();
		
		wb= new WebdriverUtility();
		wb.scrollToElements(driver,demobook);
		ubcp.getDemobooklink().click();
		Thread.sleep(2000);
		
		//click on add to cart
		updp= new UserProductDetailsPage(driver);
        WebElement addCart = updp.getAddtocartbtn();
        wb= new WebdriverUtility();
  		wb.scrollToElements(driver,addCart);
  		updp.getAddtocartbtn().click();
  		Thread.sleep(2000);
          
          //alert popup ie.product has been added to cart 
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  		try {
  		    wait.until(ExpectedConditions.alertIsPresent()); 
  		    Alert alert = driver.switchTo().alert();
  		    alert.accept();
  		} catch (Exception e) {
  		    System.out.println("No alert appeared.");
  		}
  		
  		//scroll to proceed to checkout
  		 umcp= new UserMyCartPage(driver);
  		WebElement checkout = umcp.getProceedToCheckoutBtn();
  		
  		wb= new WebdriverUtility();
  		wb.scrollToElements(driver, checkout);
  		umcp.getProceedToCheckoutBtn().click();
  		
  		//select mode of payment and clock on  submit button
  		upmp=new UserPaymentMethodPage(driver);
  		upmp.getCODradiobtn().click();
  		upmp.getSubmitBtn().click();
  		
        ulp.getLogoutlink().click();
        
        

	}	
}	

		
		
		
		
		
		 
	


