package com.rhsv1.pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddExpensePageRHS {

	WebDriver driver;

	public AddExpensePageRHS(WebDriver rdriver) {

		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Expenses']")
	@CacheLookup
	WebElement expense;
	
	@FindBy(xpath = "//a[normalize-space()='Add Expense']")
	@CacheLookup
	WebElement addExpense;

	@FindBy(xpath = "//input[@placeholder='Enter Name']")
	@CacheLookup
	WebElement expenseDoneBy;

	@FindBy(xpath = "//input[@placeholder='Enter Expense Amount (only digits)']")
	@CacheLookup
	WebElement expenseAmount;

	@FindBy(xpath = "//body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/select[1]")
	@CacheLookup
	WebElement expenseType;

	@FindBy(xpath = "//body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/select[1]")
	@CacheLookup
	WebElement expenseMode;

	@FindBy(xpath = "//input[@name='expense_date']")
	@CacheLookup
	WebElement expenseDate;

	@FindBy(xpath = "//textarea[@placeholder='Enter Note']")
	@CacheLookup
	WebElement expenseNote;

	@FindBy(xpath = "//button[@name='submit']")
	@CacheLookup
	WebElement submitExpenses;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	@CacheLookup
	WebElement expenseAddSuccessfullyActualMessage;
	
	@FindBy(xpath = "//button[@type='reset']")
	@CacheLookup
	WebElement clearElement;
	

	public void clickExpenses() {

		expense.click();
	}
	public void clickaddExpense() {

		addExpense.click();
	}
	
	public void clickExpenses(String expensesDoneByString) {

		expenseDoneBy.sendKeys(expensesDoneByString);
	}

	public void setExpenseDoneBy(String expensesDoneByString) {

		expenseDoneBy.sendKeys(expensesDoneByString);
	}

	public void setExpenseAmount(String expenseAmountString) {
		
		expenseAmount.sendKeys(expenseAmountString);
	}

	public void setExpenseType(String expenseTypeString) {

		Select selAmountSelect = new Select(expenseType);

		selAmountSelect.selectByVisibleText(expenseTypeString);
	}

	public void setExpenseMode(String expenseModeString) {

		Select selAmountSelect = new Select(expenseMode);

		selAmountSelect.selectByVisibleText(expenseModeString);
	}

	public void setExpenseDate(String expenseDateString) {

		expenseDate.sendKeys(expenseDateString);
	}

	public void setExpenseNote(String expenseNoteString) {

		expenseNote.sendKeys(expenseNoteString);
	}

	public void clickSubmit() {

		submitExpenses.click();
	}

	public String Actualmessage() {

		String Message = expenseAddSuccessfullyActualMessage.getText();
		return Message;
	}
	public void clickClear() {

		clearElement.click();
	}
	
	public void addExpenseFormData(Map<String, String> maptestMap)
	{
		setExpenseDoneBy(maptestMap.get("ExpenseDoneBy"));
		setExpenseAmount(maptestMap.get("ExpenseAmountInRS"));
		setExpenseType(maptestMap.get("ExpenseType"));
		setExpenseMode(maptestMap.get("ExpenseMode"));
		setExpenseDate(maptestMap.get("ExpenseDate"));
		setExpenseNote(maptestMap.get("Note"));
	}
	
	
}
