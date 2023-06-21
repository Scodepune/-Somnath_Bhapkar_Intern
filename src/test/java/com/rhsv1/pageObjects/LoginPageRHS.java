package com.rhsv1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageRHS {

		
	@FindBy(xpath="//input[@placeholder='Username']")
	@CacheLookup
	WebElement username;

	@FindBy(how=How.XPATH, using="//input[@placeholder='Password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath="//button[normalize-space()='SIGN IN']")
	@CacheLookup
	WebElement signButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	@CacheLookup
	WebElement errorMessage;

	public LoginPageRHS(WebDriver rdriver) {

		PageFactory.initElements(rdriver, this);
		System.out.println("I am in LoginPageRHS ");

	}
	
	public void setUserName(String uname) {

		username.sendKeys(uname);
	}

	public void setPassword(String pwd) {

		password.sendKeys(pwd);
	}

	public void clicksign() {

		signButton.click();
	}
	
	public String seterrorMessage() {

		String errorMessage1= errorMessage.getText();
		return errorMessage1;
	}

}
