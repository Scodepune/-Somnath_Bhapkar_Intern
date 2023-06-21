package com.rhsv1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReceiptsPage {

	public ReceiptsPage(WebDriver rdriver) {

		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//li[4]//a[1]//span[1]")
	@CacheLookup
	WebElement receipts;
	
	@FindBy(xpath = "//a[normalize-space()='Add Receipt']")
	@CacheLookup
	WebElement addReceipt;
	
	@FindBy(xpath = "//select[@name='userid']")
	@CacheLookup
	WebElement selectResidentName;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Payment Description']")
	@CacheLookup
	WebElement paymentFordesc;
	
	@FindBy(xpath = "//input[@id='total_amount']")
	@CacheLookup
	WebElement totalAmount;
	
	@FindBy(xpath = "//input[@id='received_amount']")
	@CacheLookup
	WebElement received_amount;
	
	@FindBy(xpath = "//input[@id='balance_amount']")
	@CacheLookup
	WebElement balance_amount;
	
	@FindBy(xpath = "//textarea[@placeholder='Transaction Details']")
	@CacheLookup
	WebElement transaction_Details;
	
	@FindBy(xpath = "//button[@type='reset']")
	@CacheLookup
	WebElement clearForm;
	
	@FindBy(xpath = "//button[@name='submit']")
	@CacheLookup
	WebElement submitReceipt;
	
	
	
	public void receiptsclick() {

		receipts.click();
	}
	
	public void addReceiptclick() {

		addReceipt.click();
	}
	public void setSelectResidentName(String residentName) {

		Select sel = new Select(selectResidentName);
		  
		  sel.selectByVisibleText(residentName);
	}
	public void setPaymentFordes(String paymentdesc) {

		paymentFordesc.sendKeys(paymentdesc);
	}
	
	public void setTotalAmount(String totalAmountString ) {
		totalAmount.sendKeys(totalAmountString);
		
	}
	public void setreceived_amount(String receivedAmount) {

		received_amount.sendKeys(receivedAmount);
	}
	public int getBalance_amount() {

		String balance_amountstString=  balance_amount.getText();
		
		int amount =Integer.valueOf(balance_amountstString);
		return amount;
	}
	
	public void setTransaction_Details(String Transaction_Details) {

		transaction_Details.sendKeys(Transaction_Details);
	}
	
	public void clearFormData() {

		clearForm.click();
	}
	
	public void submitFormData() {

		submitReceipt.click();
	}
	
}
