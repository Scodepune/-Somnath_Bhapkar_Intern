package com.rhsv1.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.rhsv1.pageObjects.ReceiptsPage;

public class TC_RHS_AddReceipts extends RHSBase{

	SoftAssert assert1 = new SoftAssert();
	String residentName = "Sushant Gore (A Wing - 504)";
	String paymentdesc = "ele bill";
	String  setTotalAmount="5000";
	String receivedAmount="1020";
	int  Balance_amount;
	String Transaction_Details="payment rlr bill by upi data by somnath";

	public void loginPage() throws Exception {
		TC_RHS_LoginPage tc_RHS_LoginPage = new TC_RHS_LoginPage();
		tc_RHS_LoginPage.validUserNamePassword();
	}

	@Test(priority = 1)
	public void AddReceipts() throws Exception {
		ReceiptsPage rPage=new ReceiptsPage(driver);
		loginPage();
		AddReceiptsData();
		rPage.submitFormData();
	}
	@Test(priority = 2)
	public void clearReceipts() throws Exception {
		ReceiptsPage rPage=new ReceiptsPage(driver);
		loginPage();
		AddReceiptsData();
		rPage.clearFormData();
		
	}
	public void AddReceiptsData() throws Exception {
		ReceiptsPage rPage=new ReceiptsPage(driver);
		rPage.receiptsclick();
		rPage.addReceiptclick();
		rPage.setSelectResidentName(residentName);
		rPage.setPaymentFordes(paymentdesc);
		rPage.setTotalAmount(setTotalAmount);
		rPage.setreceived_amount(receivedAmount);
		System.out.println("somnath");
		//Balance_amount=rPage.getBalance_amount();
		//System.out.println(Balance_amount);
		rPage.setTransaction_Details(Transaction_Details);
		Thread.sleep(3000);
		
	}

}
