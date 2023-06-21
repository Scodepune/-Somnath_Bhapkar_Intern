package com.rhsv1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewUsersPageRHS {

	public AddNewUsersPageRHS(WebDriver rdriver) {

		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Users']")
	@CacheLookup
	WebElement user;

	@FindBy(xpath = "//a[normalize-space()='Add User']")
	@CacheLookup
	WebElement addUser;

	@FindBy(xpath = "//a[normalize-space()='Add User']")
	@CacheLookup
	WebElement addNewUser;

	@FindBy(xpath = "//select[@id='role']")
	@CacheLookup
	WebElement role;

	@FindBy(xpath = "//input[@placeholder='Enter full name']")
	@CacheLookup
	WebElement fullName;

	@FindBy(xpath = "//input[@placeholder='Enter Mobile Number']")
	@CacheLookup
	WebElement mobileNumberUserName;

	@FindBy(xpath = "//input[@placeholder='Enter Password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//input[@placeholder='Alternate / Landline Number']")
	@CacheLookup
	WebElement alternateLanLineNumber;

	@FindBy(xpath = "//input[@placeholder='Enter email address']")
	@CacheLookup
	WebElement email;

	@FindBy(xpath = "//textarea[@placeholder='Enter your address']")
	@CacheLookup
	WebElement address;

	@FindBy(xpath = "//select[@name='gender']")
	@CacheLookup
	WebElement gender;

	@FindBy(xpath = "//input[@placeholder='Aadhar Card Number']")
	@CacheLookup
	WebElement aadharCardNumber;
	
	@FindBy(xpath = "//input[@placeholder='PAN Card Number']")
	@CacheLookup
	WebElement PANNumber;
	
	@FindBy(xpath = "//button[@name='submit']")
	@CacheLookup
	WebElement submit;
	
	@FindBy(xpath = "//button[@type='reset']")
	@CacheLookup
	WebElement clear;
	
	
	

	public void userClick() {

		user.click();
	}

	public void addUserClick() {

		addUser.click();
	}

	public void setRole(String roleSelection) {

		role.sendKeys(roleSelection);
	}

	public void setfullName(String fullNameString) {

		fullName.sendKeys(fullNameString);
	}

	public void setmobileNumberUserName(String mobileNumberUserNameString) {

		mobileNumberUserName.sendKeys(mobileNumberUserNameString);
	}

	public void setpassword(String passwordString) {

		password.sendKeys(passwordString);
	}

	public void setalternateLandLineNumber(String alternateLanLineNumberString) {

		alternateLanLineNumber.sendKeys(alternateLanLineNumberString);
	}

	public void setemail(String emailString) {

		email.sendKeys(emailString);
	}

	public void setaddress(String addressString) {

		address.sendKeys(addressString);
	}

	public void setgender(String genderString) {

		Select gendSelect = new Select(gender);

		gendSelect.selectByVisibleText(genderString);
	}

	public void setaadharCardNumber(String aadharCardNumberString) {

		aadharCardNumber.sendKeys(aadharCardNumberString);
	}
	
	public void setPANNumber(String PANNumberString) {

		PANNumber.sendKeys(PANNumberString);
	}
	
	public void clickSubmit() {

		submit.click();
	}
	
	public void clickclear() {

		clear.click();
	}
	
}
