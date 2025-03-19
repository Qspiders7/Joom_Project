package com.joom.automation.IntegrationTestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForUser;
import com.joom.automation.generic.fileutility.JsonForUserUtility;
import com.joom.automation.objectrepository.AdminLoginPage;
import com.joom.automation.objectrepository.HomePage;
import com.joom.automation.objectrepository.UserBooksCategoryPage;
import com.joom.automation.objectrepository.UserLogOutPage;
import com.joom.automation.objectrepository.UserLoginPage;
import com.joom.automation.objectrepository.UserProductDetailsPage;
import com.joom.automation.objectrepository.UserShoppingHomePage;
@Listeners(com.joom.automation.listenerUtility.ListImpClass.class)
public class UserWishlistTest extends BaseClassForUser {
@Test(groups="Integration")
public void userWishlistTest() throws InterruptedException, FileNotFoundException, IOException, ParseException {
	
	
	js=new JsonForUserUtility();
	wb=new WebdriverUtility();
	ullp=new UserLoginPage(driver);
	hp=new HomePage(driver);
	ulp=new UserLogOutPage(driver);
	ullp = new UserLoginPage(driver);
	
	wb.waitForPageToLoad(driver);
	driver.manage().window().maximize();
	
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
	

	
	//click on books link
	 ushp = new UserShoppingHomePage(driver);
	ushp.getBooksbtn().click();
	
	// scroll down and click on theastilton book
	 ubcp= new UserBooksCategoryPage(driver);
	WebElement book = ubcp.getDemobooklink();
	wb.scrollToElements(driver, book);
	ubcp.getDemobooklink().click();
	Thread.sleep(2000);
	
	//to click on wishlist button
	 updp= new UserProductDetailsPage(driver);
	updp.getWishlistBtn().click();
	
	Thread.sleep(5000);

	
	SoftAssert sa= new SoftAssert();
		sa.assertTrue(driver.getCurrentUrl().contains("Online_Shopping_Application/my-wishlist.php"), "mywishlist page hasnot been displayed");

    Reporter.log("mywishlist page has been displayed.",true);
    sa.assertAll();
    
   ulp. getLogoutlink() .click() ; 
    
  

	
	
	
}
	


}
