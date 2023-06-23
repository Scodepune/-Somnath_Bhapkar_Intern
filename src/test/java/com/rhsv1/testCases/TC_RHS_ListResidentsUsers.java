package com.rhsv1.testCases;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.rhsv1.pageObjects.ListResidentsUsersPageRHS;

public class TC_RHS_ListResidentsUsers extends RHSBase {

	Map<String, String> maptestMap;

	@DataProvider(name = "testlink")
	public Object[][] getData() throws Exception {
		String fileString = "C:/Users/Arya ATG/eclipse-workspace/rhsv1/src/test/java/com/rhsv1/testData/UpdateProfile.xlsx";
		Object[][] obj = exlRead(fileString);
		return obj;
	}

	public void loginPage() throws Exception {
		TC_RHS_LoginPage tc_RHS_LoginPage = new TC_RHS_LoginPage();
		tc_RHS_LoginPage.validUserNamePassword();
	}

	@Test(priority = 1)
	public void viewResident() throws Exception {

		ListResidentsUsersPageRHS lrup = new ListResidentsUsersPageRHS(driver);
		loginPage();
		lrup.userClick();
		lrup.viewListResidents();
		lrup.setSearch("Karen");
		lrup.viewSearchForEnterdData();
		lrup.viewProfileData();
		Thread.sleep(3000);
	}

	@Test(dataProvider = "testlink", priority = 2)
	public void updateResident(Map<String, String> maptestMap) throws Exception {
		ListResidentsUsersPageRHS lrup = new ListResidentsUsersPageRHS(driver);
		viewResident();
		Thread.sleep(3000);
		lrup.updateProfileData();
		lrup.updateWingData(maptestMap.get("WingRowHouse"));
		lrup.updateHouseNumber(maptestMap.get("HouseFlatNumber"));
		lrup.setfullName(maptestMap.get("FullName"));
		lrup.setmobileNumberUserName(maptestMap.get("MobileNumberUsername"));
		lrup.setpassword(maptestMap.get("Password"));
		lrup.setalternateLandLineNumber(maptestMap.get("AlternateLandlineNumber"));
		lrup.setemail(maptestMap.get("Email"));
		lrup.setaddress(maptestMap.get("Address"));
		lrup.setgender(maptestMap.get("Gender"));
		lrup.setaadharCardNumber(maptestMap.get("AadharNo"));
		lrup.setPANNumber(maptestMap.get("PANNo"));
		lrup.clickSave();
		String expecteMessage = "Success! Profile updated successfully!";		
		String actualMessage = lrup.setMessage();	
		assertEquals(actualMessage, expecteMessage);
	}
	@Test
	public void deleteResident() throws Exception {

		ListResidentsUsersPageRHS lrup = new ListResidentsUsersPageRHS(driver);
		loginPage();
		lrup.userClick();
		lrup.viewListResidents();
		lrup.setSearch("Karen");
		lrup.clickDelete();
		Alert alert = driver.switchTo().alert();
		alert.accept();	
		Thread.sleep(3000);
		String expecteMessage="Success! User deleted successfully...";
		String actualMessage =lrup.deleteSuccessMessage();
		assertEquals(actualMessage, expecteMessage);
		
	}
}
