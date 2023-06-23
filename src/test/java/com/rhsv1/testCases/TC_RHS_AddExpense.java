package com.rhsv1.testCases;

import java.util.Map;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.rhsv1.pageObjects.AddExpensePageRHS;

public class TC_RHS_AddExpense extends RHSBase {
	
	@DataProvider(name = "testlink")
	public Object[][] getData() throws Exception {
		String fileString = "C:/Users/Arya ATG/eclipse-workspace/rhsv1/src/test/java/com/rhsv1/testData/AddExpense.xlsx";
		Object[][] obj = exlRead(fileString);
		return obj;
	}

	public void loginPage() throws Exception {
		TC_RHS_LoginPage tc_RHS_LoginPage = new TC_RHS_LoginPage();
		tc_RHS_LoginPage.validUserNamePassword();
	}

	
@Test(priority = 1,dataProvider = "testlink")
	public void addAddExpenseData(Map<String, String> maptestMap) throws Exception {
		AddExpensePageRHS aepr = new AddExpensePageRHS(driver);
		loginPage();
		Thread.sleep(3000);
		aepr.clickExpenses();
		aepr.clickaddExpense();
		aepr.addExpenseFormData(maptestMap);
		aepr.clickSubmit();
	}
@Test(priority = 2,dataProvider = "testlink")
	public void clearAddExpenseData(Map<String, String> maptestMap) throws Exception {
		AddExpensePageRHS aepr = new AddExpensePageRHS(driver);
		loginPage();
		Thread.sleep(3000);
		aepr.clickExpenses();
		aepr.clickaddExpense();
		aepr.addExpenseFormData(maptestMap);
		aepr.clickClear();
	}
}
