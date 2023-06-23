package com.rhsv1.testCases;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.rhsv1.pageObjects.AddNewUsersPageRHS;

public class TC_RHS_AddNewUsers extends RHSBase {
	
	Map<String, String> maptestMap;

	@DataProvider(name = "testlink")
	public Object[][] getData() throws Exception {
		String fileString = "C:/Users/Arya ATG/eclipse-workspace/rhsv1/src/test/java/com/rhsv1/testData/UserAddNew.xlsx";
		Object[][] obj = exlRead(fileString);
		return obj;
	}

	public void loginPage() throws Exception {
		TC_RHS_LoginPage tc_RHS_LoginPage = new TC_RHS_LoginPage();
		tc_RHS_LoginPage.validUserNamePassword();
	}
	

	@Test(dataProvider = "testlink",priority = 1)
	public void submitAddNewUser(Map<String, String> maptestMap) throws Exception {

		AddNewUsersPageRHS anpr = new AddNewUsersPageRHS(driver);
		loginPage();
		
		anpr.userClick();
		anpr.addUserClick();
		anpr.setRole(maptestMap.get("Role"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));		
		wait.until(ExpectedConditions.elementToBeClickable(anpr.role));
		anpr.setfullName(maptestMap.get("FullName"));
		anpr.setmobileNumberUserName(maptestMap.get("MobileNumberUsername"));
		anpr.setpassword(maptestMap.get("Password"));
		anpr.setalternateLandLineNumber(maptestMap.get("AlternateLandlineNumber"));
		anpr.setemail(maptestMap.get("Email"));
		anpr.setaddress(maptestMap.get("Address"));
		anpr.setgender(maptestMap.get("Gender"));
		anpr.setaadharCardNumber(maptestMap.get("AadharNo"));
		anpr.setPANNumber(maptestMap.get("PANNo"));
		anpr.clickSubmit();
	}
	@Test(dataProvider = "testlink",priority = 2)
	public void clearAddNewUser(Map<String, String> maptestMap) throws Exception {

		AddNewUsersPageRHS anpr = new AddNewUsersPageRHS(driver);
		loginPage();
		Thread.sleep(3000);
		anpr.userClick();
		anpr.addUserClick();
		anpr.setRole(maptestMap.get("Role"));
		anpr.setfullName(maptestMap.get("FullName"));
		anpr.setmobileNumberUserName(maptestMap.get("MobileNumberUsername"));
		anpr.setpassword(maptestMap.get("Password"));
		anpr.setalternateLandLineNumber(maptestMap.get("AlternateLandlineNumber"));
		anpr.setemail(maptestMap.get("Email"));
		anpr.setaddress(maptestMap.get("Address"));
		anpr.setgender(maptestMap.get("Gender"));
		anpr.setaadharCardNumber(maptestMap.get("AadharNo"));
		anpr.setPANNumber(maptestMap.get("PANNo"));
		anpr.clickclear();
	}
}
