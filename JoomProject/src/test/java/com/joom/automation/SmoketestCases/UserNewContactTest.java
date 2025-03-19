package com.joom.automation.SmoketestCases;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;


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
import com.joom.automation.objectrepository.UserHomePage;
import com.joom.automation.objectrepository.UserSignUpPage;

@Listeners(com.joom.automation.listenerUtility.ListImpClass.class)
public class UserNewContactTest extends BaseClassForUser{

	    public WebdriverUtility wb = new WebdriverUtility();
	    public JsonForUserUtility js = new JsonForUserUtility();
	    public  UserHomePage uhp = new UserHomePage(driver);
	    public ExcelUtilityForAdmin elib = new ExcelUtilityForAdmin();
	   public UserSignUpPage usp = new UserSignUpPage(driver);
	   
	    
	    @Test(priority = 1)
	    public void userNewContactTest() throws InterruptedException, EncryptedDocumentException, IOException {
	       
	    	
	        HomePage hp = new HomePage(driver);
	      
	        WebElement login = hp.getLoginLink();
             wb.waitForElementPresent(driver, login);
	       
	      
	        login.click();
	       
	        // Get data from Excel
	        String Fullname = elib.getDataFromExcel("USER", 2, 0);
	       uhp=new UserHomePage(driver);
	        uhp.getFullnametxtfield().sendKeys(Fullname);
	        System.out.println("hai7");
	        
	        System.out.println("hello");

	        String Email = elib.getDataFromExcel("USER", 2, 1);
	        uhp.getEmailtxtfld().sendKeys(Email);

	        usp = new UserSignUpPage(driver);
	        WebElement signup = usp.getSignUpbtn();
	        wb.scrollToElements(driver, signup);
	        signup.click();

	        String Contactno = elib.getDataFromExcel("USER", 2, 2);
	        uhp.getContactnotxtfld().sendKeys(Contactno);

	        String password = elib.getDataFromExcel("USER", 2, 3);
	        uhp.getPasswordtxtfld().sendKeys(password);

	        String confirmpassword = elib.getDataFromExcel("USER", 2, 4); // Fixed Sheet Name
	        uhp.getConfirmpasswordtxtfld().sendKeys(confirmpassword);
	        
	       
        
	   usp.getSignUpbtn().click();

	        

		    System.out.println("gth2");
	        wb.switchtoAlertAndAccept(driver);

	        SoftAssert sa = new SoftAssert();
	        sa.assertTrue(driver.getCurrentUrl().contains("AppServer/Online_Shopping_Application/login.php"),
	                "New Contact was not processed successfully!");

	        Reporter.log("New Contact passed successfully.", true);
	        
	        ulp. getLogoutlink() .click() ;

	    }
	}



