package com.rhsv1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ListResidentsUsersPageRHS {

	WebDriver driver;

	public ListResidentsUsersPageRHS(WebDriver rdriver) {

		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Users']")
	@CacheLookup
	WebElement user;

	@FindBy(xpath = "//a[normalize-space()='List Residents']")
	@CacheLookup
	WebElement listResidents;

	@FindBy(xpath = "//input[@type='search']")
	@CacheLookup
	WebElement setSearch;

	@FindBy(xpath = "//tbody/tr[1]/td[7]/a[1]")
	@CacheLookup
	WebElement viewSearchForEnterdData;

	@FindBy(linkText = "View Profile")
	@CacheLookup
	WebElement viewProfileData;

	@FindBy(linkText = "Update Profile")
	@CacheLookup
	WebElement updateProfileData;

	@FindBy(xpath = "//select[@name='wing']")
	@CacheLookup
	WebElement updateWing;

	@FindBy(xpath = "//input[@placeholder='Enter house or flat number']")
	@CacheLookup
	WebElement houseNumber;

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
	WebElement save;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	@CacheLookup
	WebElement successMessage;
	
	@FindBy(xpath="//a[@class='btn btn-danger btn-sm']")
	@CacheLookup
	WebElement deleteResident;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	@CacheLookup
	WebElement deleteSuccessMessage;
	

	public void userClick() {

		user.click();
	}

	public void viewListResidents() {

		listResidents.click();
	}

	public void setSearch(String searchData) {

		setSearch.sendKeys(searchData);
	}

	public void updateWingData(String updateWingString) {
		
		Select selWingSelect = new Select(updateWing);
		selWingSelect.selectByVisibleText(updateWingString);

		// updateProfileData.sendKeys(updateWingString);

	}

	public void updateHouseNumber(String houseNumbersString) {
		// TODO Auto-generated method stub
		houseNumber.clear();
		houseNumber.sendKeys(houseNumbersString);
	}

	public void setfullName(String fullNameString) {
		
		fullName.clear();
		fullName.sendKeys(fullNameString);
	}

	public void setmobileNumberUserName(String mobileNumberUserNameString) {

		mobileNumberUserName.clear();
		mobileNumberUserName.sendKeys(mobileNumberUserNameString);
	}

	public void setpassword(String passwordString) {

		password.clear();
		password.sendKeys(passwordString);
	}

	public void setalternateLandLineNumber(String alternateLanLineNumberString) {

		alternateLanLineNumber.clear();
		alternateLanLineNumber.sendKeys(alternateLanLineNumberString);
	}

	public void setemail(String emailString) {
		
		email.clear();
		email.sendKeys(emailString);
	}

	public void setaddress(String addressString) {
		
		address.clear();
		address.sendKeys(addressString);
	}

	public void setgender(String genderString) {
		
		Select gendSelect = new Select(gender);

		gendSelect.selectByVisibleText(genderString);
	}

	public void setaadharCardNumber(String aadharCardNumberString) {
		
		aadharCardNumber.clear();

		aadharCardNumber.sendKeys(aadharCardNumberString);
	}

	public void setPANNumber(String PANNumberString) {
		
		PANNumber.clear();

		PANNumber.sendKeys(PANNumberString);
	}

	public void viewSearchForEnterdData() {
		
		

		viewSearchForEnterdData.click();
	}

	public void viewProfileData() {

		viewProfileData.click();
	}

	public void updateProfileData() {

		updateProfileData.click();
	}

	public void clickSave() {

		save.click();
	}

	public String setMessage() {

		String Message1= successMessage.getText();
		return Message1;
	}

	public void clickDelete() {

		deleteResident.click();
	}
	public String errormessage() {

		deleteResident.click();
		return errormessage();
	}
	public String deleteSuccessMessage() {

		deleteSuccessMessage.getText();
		return errormessage();
	
	}
}
