package com.rhsv1.testCases;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rhsv1.pageObjects.ViewReceiptsPage;

public class TC_RHS_ViewReceipts extends RHSBase{
	
	SoftAssert assert1 = new SoftAssert();
	
	public void loginPage() throws Exception {
		TC_RHS_LoginPage tc_RHS_LoginPage = new TC_RHS_LoginPage();
		tc_RHS_LoginPage.validUserNamePassword();
	}
	@Test(priority = 1)
	public void viewReceipts() throws Exception {
		ViewReceiptsPage vrp=new ViewReceiptsPage(driver);
		 loginPage();
		vrp.receiptsclick();
		vrp.viewReceiptsClick();
		vrp.viewReceiptsInsideClick();
		
	}
	
	@Test(priority = 2)
	public void actionEditSubmit() throws Exception {
		ViewReceiptsPage vrp=new ViewReceiptsPage(driver);
		 loginPage();
		vrp.receiptsclick();
		vrp.viewReceiptsClick();
		vrp.actionbuttonViewReceiptClick();
		vrp.actionEditReceiptClick();
		TC_RHS_AddReceipts tc_RHS_AddReceipts= new TC_RHS_AddReceipts();
		tc_RHS_AddReceipts.AddReceiptsData();
		vrp.submitEditReceiptClick();
		
	}
	@Test(priority = 3)
	public void actionEditClear() throws Exception {
		ViewReceiptsPage vrp=new ViewReceiptsPage(driver);
		 loginPage();
		vrp.receiptsclick();
		vrp.viewReceiptsClick();
		vrp.actionbuttonViewReceiptClick();
		vrp.actionEditReceiptClick();
		TC_RHS_AddReceipts tc_RHS_AddReceipts= new TC_RHS_AddReceipts();
		tc_RHS_AddReceipts.AddReceiptsData();
		vrp.clearEditReceiptClick();
		
	}
	@Test(priority = 4)
	public void actionDelete() throws Exception {
		ViewReceiptsPage vrp=new ViewReceiptsPage(driver);
		 loginPage();
		vrp.receiptsclick();
		vrp.viewReceiptsClick();
		vrp.actionbuttonViewReceiptClick();
		vrp.deleteReceiptClick();
		
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		
	}
	
}
