package com.rhsv1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewContentsPage {
	public ViewContentsPage(WebDriver rdriver) {

		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Contents']")
	@CacheLookup
	WebElement content;	
	
	@FindBy(xpath = "//a[normalize-space()='View Contents']")
	@CacheLookup
	WebElement viewContent;	
	
	@FindBy(xpath = "//input[@type='search']")
	@CacheLookup
	WebElement search;	
	
	@FindBy(xpath = "//tbody/tr[2]/td[5]/div[1]/button[1]")
	@CacheLookup
	WebElement action;	
	
	@FindBy(xpath = "//div[@class='dropdown-menu show']//a[@title='View Content'][normalize-space()='View']")
	@CacheLookup
	WebElement actionView;
	
	@FindBy(xpath = "//div[@class='dropdown-menu show']//a[@title='Edit Content'][normalize-space()='Edit']")
	@CacheLookup
	WebElement actionEdit;
	
	@FindBy(xpath = "//div[@class='dropdown-menu show']//a[@title='Delete Record'][normalize-space()='Delete']")
	@CacheLookup
	WebElement actionDelete;
	
	public void contentclick() {

		content.click();
	}
	public void viewcontentclick() {

		viewContent.click();
	}
	public void setSearch(String searchData) {

		search.sendKeys(searchData);
	}
	public void setSearchClear() {

		search.clear();
	}
	
	public void clickaction() {

		action.click();
	}
	public void clickactionview() {

		actionView.click();
	}
	public void clickactionEdit() {

		actionEdit.click();
	}
	public void clickactionDelete() {

		actionDelete.click();
	}
	
}
