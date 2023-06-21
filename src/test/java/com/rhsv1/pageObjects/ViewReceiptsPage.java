package com.rhsv1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewReceiptsPage {
	
	
	public ViewReceiptsPage(WebDriver rdriver) {

		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//li[4]//a[1]//span[1]")
	@CacheLookup
	WebElement receipts;
	
	@FindBy(xpath = "//a[@href='list_receipts.php?role=Customer']")
	@CacheLookup
	WebElement viewReceipts;
	
	@FindBy(xpath = "//tbody/tr[1]/td[11]/a[1]")
	@CacheLookup
	WebElement viewReceiptsInside;
	
	@FindBy(xpath = "//body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[12]/div[1]/button[1]")
	@CacheLookup
	WebElement actionbuttonViewReceipt;
	
	
	
	@FindBy(xpath = "//div[@class='dropdown-menu show']//a[@title='Edit Receipt'][normalize-space()='Edit']")
	@CacheLookup
	WebElement actionEditReceipt;
	
	@FindBy(xpath = "//button[@name='submit']")
	@CacheLookup
	WebElement submitEditReceipt;
	
	@FindBy(xpath = "//button[@type='reset']")
	@CacheLookup
	WebElement clearEditReceipt;
	
	@FindBy(xpath = "//div[@class='dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='Delete']")
	@CacheLookup
	WebElement deleteReceipt;
	
	public void receiptsclick() {

		receipts.click();
	}
	public void viewReceiptsClick() {

		viewReceipts.click();
	}
	public void viewReceiptsInsideClick() {

		viewReceiptsInside.click();
	}
	public void actionbuttonViewReceiptClick() {

		actionbuttonViewReceipt.click();
	}
	public void actionEditReceiptClick() {

		actionEditReceipt.click();
	}
	public void submitEditReceiptClick() {

		submitEditReceipt.click();
	}
	public void clearEditReceiptClick() {

		clearEditReceipt.click();
	}
	public void deleteReceiptClick() {

		deleteReceipt.click();
	}
	
	
	
}
