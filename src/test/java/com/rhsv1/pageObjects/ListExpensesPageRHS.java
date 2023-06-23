package com.rhsv1.pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ListExpensesPageRHS {
	WebDriver driver;

	public ListExpensesPageRHS(WebDriver rdriver) {

		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Expenses']")
	@CacheLookup
	WebElement expense;

	@FindBy(xpath = "//a[normalize-space()='List Expenses']")
	@CacheLookup
	WebElement listExpense;

	@FindBy(xpath = "//input[@type='search']")
	@CacheLookup
	WebElement SearchListExpense;

	@FindBy(xpath = "//input[@placeholder='From Date']")
	@CacheLookup
	WebElement fromDatesearchListExpense;

	@FindBy(xpath = "//input[@placeholder='To Date']")
	@CacheLookup
	WebElement toDatesearchListExpense;

	@FindBy(xpath = "//select[@id='selectbox']")
	@CacheLookup
	WebElement nameListsearchListExpense;

	@FindBy(xpath = "//button[@name='submit']")
	@CacheLookup
	WebElement submitNamesearchListExpense;

	@FindBy(xpath = "//tbody/tr[1]/td[8]")
	@CacheLookup
	WebElement deleteSearchResultListExpense;

	public void clickExpenses() {

		expense.click();
	}

	public void clicklistExpense() {

		listExpense.click();
	}

	public void setSearchListExpense(String searchListExpenseString) {

		SearchListExpense.sendKeys(searchListExpenseString);
	}

	public void setFromDateSearchListExpense(String fromDatesearchListExpenseString) {
		
		fromDatesearchListExpense.click();
		fromDatesearchListExpense.sendKeys(fromDatesearchListExpenseString);
	}

	public void setToDateSearchListExpense(String toDatesearchListExpenseString) {
		
		toDatesearchListExpense.click();
		toDatesearchListExpense.sendKeys(toDatesearchListExpenseString);
	}

	public void setNameListSearchListExpense(String nameListsearchListExpenseString) {

		Select selName = new Select(nameListsearchListExpense);
		selName.selectByVisibleText(nameListsearchListExpenseString);
	}

	public void clickSubmitSearchListExpense() {

		submitNamesearchListExpense.click();
	}

	public void deleteSearch() {

		deleteSearchResultListExpense.click();
	}

	/*
	 * public void addExpenseFormData(Map<String, String> maptestMap) {
	 * setFromDateSearchListExpense(maptestMap.get("FromDate"));
	 * setToDateSearchListExpense(maptestMap.get("ToDate"));
	 * setNameListSearchListExpense(maptestMap.get("SelectEmployee"));
	 * clickSubmitSearchListExpense();
	 * setSearchListExpense(maptestMap.get("Search")); deleteSearch();
	 * 
	 * }
	 */
	
}
