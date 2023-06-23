package com.rhsv1.testCases;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.rhsv1.pageObjects.ListExpensesPageRHS;

public class TC_RHS_ListExpenses extends RHSBase {
	
	@DataProvider(name = "testlink")
	public Object[][] getData() throws Exception {
		String fileString = "C:/Users/Arya ATG/eclipse-workspace/rhsv1/src/test/java/com/rhsv1/testData/ListExpensesData.xlsx";
		Object[][] obj = exlRead(fileString);
		return obj;
	}
	
	public void loginPage() throws Exception {
		TC_RHS_LoginPage tc_RHS_LoginPage = new TC_RHS_LoginPage();
		tc_RHS_LoginPage.validUserNamePassword();
	}

	@Test(dataProvider = "testlink",priority = 1)
	public void searchFromDateToDate(Map<String, String> maptestMap) throws Exception {
		ListExpensesPageRHS lep = new ListExpensesPageRHS(driver);
		loginPage();
		Thread.sleep(3000);
		lep.clickExpenses();
		lep.clicklistExpense();
		lep.setFromDateSearchListExpense(maptestMap.get("FromDate"));
		lep.setToDateSearchListExpense(maptestMap.get("ToDate"));
		lep.setNameListSearchListExpense(maptestMap.get("SelectEmployee"));
		lep.clickSubmitSearchListExpense();
	}
	
	
	@Test(dataProvider = "testlink",priority = 3)
	public void searchNormal(Map<String, String> maptestMap) throws Exception {
		ListExpensesPageRHS lep = new ListExpensesPageRHS(driver);
		loginPage();
		Thread.sleep(3000);
		lep.clickExpenses();
		lep.clicklistExpense();
		lep.setSearchListExpense(maptestMap.get("Search"));
		
	}
	@Test(dataProvider = "testlink",priority = 4)
	public void delete(Map<String, String> maptestMap) throws Exception {
		ListExpensesPageRHS lep = new ListExpensesPageRHS(driver);
		loginPage();
		Thread.sleep(3000);
		lep.clickExpenses();
		lep.clicklistExpense();
		lep.setSearchListExpense(maptestMap.get("Search"));
		lep.deleteSearch();
		 Alert alert = driver.switchTo().alert();
		 alert.dismiss();
		assertEquals(driver.getPageSource().contains(maptestMap.get("Search")),true);
		 Thread.sleep(3000);
		lep.deleteSearch();
		 alert.accept();
		assertEquals(driver.getPageSource().contains(maptestMap.get("Search")),false);
		
		
	}
}
