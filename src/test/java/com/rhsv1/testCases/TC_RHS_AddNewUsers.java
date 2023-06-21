package com.rhsv1.testCases;

import java.util.Map;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.rhsv1.pageObjects.AddNewUsersPageRHS;

public class TC_RHS_AddNewUsers extends RHSBase {

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

	@Test(dependsOnMethods = "dataAddNewUser")
	public void addNewUser() throws Exception {

		
		submitAddNewUserTest();
		clearAddNewUserTest();
	}

	public void submitAddNewUserTest() throws Exception {
		AddNewUsersPageRHS anpr = new AddNewUsersPageRHS(driver);
		Map<String, String> imap = null;
		dataAddNewUser(imap);
		anpr.clickSubmit();

	}

	public void clearAddNewUserTest() throws Exception {
		AddNewUsersPageRHS anpr = new AddNewUsersPageRHS(driver);
		Map<String, String> imap = null;
		dataAddNewUser(imap);
		anpr.clickclear();
	}

	@Test(dataProvider = "testlink")
	public void dataAddNewUser(Map<String, String> maptestMap) throws Exception {

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
	}

}
