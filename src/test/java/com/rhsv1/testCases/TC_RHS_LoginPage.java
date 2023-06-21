package com.rhsv1.testCases;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import com.rhsv1.pageObjects.LoginPageRHS;

public class TC_RHS_LoginPage extends RHSBase {

		
	@Test(enabled=true, priority = 1)
	public void validUserNamePassword(){
		String expectedtitle;
		String actualTitle;
		LoginPageRHS loginPage = new LoginPageRHS(driver);
		loginPage.setUserName(readConfig.getUserName());
		loginPage.setPassword(readConfig.getPassword());
		loginPage.clicksign();
		expectedtitle = "Enquiries";
		actualTitle = driver.getTitle();
		assertEquals(expectedtitle, actualTitle);
		
		 
	}

	@Test(enabled=true, priority = 2)
	public void inValidUserNamePassword(){
		String expecteErrorMessage;
		String actualErrorMessage;
		LoginPageRHS loginPage = new LoginPageRHS(driver);
		loginPage.setUserName("Riddhi1");
		loginPage.setPassword("123");
		loginPage.clicksign();
		expecteErrorMessage = "Error!Invalid Username or Password";		
		actualErrorMessage = loginPage.seterrorMessage();		
		assertEquals(expecteErrorMessage, actualErrorMessage);
		
		

	}

	@Test(enabled=true, priority = 3)
	public void blankUserNamePassword(){
		String expecteErrorMessage;
		String actualErrorMessage;
		LoginPageRHS loginPage = new LoginPageRHS(driver);
		loginPage.setUserName("");
		loginPage.setPassword("");
		loginPage.clicksign();
		expecteErrorMessage = "Error!Username and Password field should not left blank";
		actualErrorMessage = loginPage.seterrorMessage();		
		assertEquals(expecteErrorMessage, actualErrorMessage);
		

	}

	@Test(enabled=true, priority = 4)
	public void validUserNameBlankPassword(){
		String expecteErrorMessage;
		String actualErrorMessage;
		LoginPageRHS loginPage = new LoginPageRHS(driver);
		loginPage.setUserName("Riddhi");
		loginPage.setPassword("");
		loginPage.clicksign();
		expecteErrorMessage = "Error!Password field should not left blank";
		actualErrorMessage = loginPage.seterrorMessage();
		assertEquals(expecteErrorMessage, actualErrorMessage);
		

	}
	@Test(enabled=true, priority = 5)
	public void blankkUserNameValidPassword(){
		String expecteErrorMessage;
		String actualErrorMessage;
		LoginPageRHS loginPage = new LoginPageRHS(driver);
		loginPage.setUserName("");
		loginPage.setPassword("100");
		loginPage.clicksign();
		expecteErrorMessage = "Error!Username field should not left blank";
		actualErrorMessage = loginPage.seterrorMessage();
		assertEquals(expecteErrorMessage, actualErrorMessage);
		
	}
		

}