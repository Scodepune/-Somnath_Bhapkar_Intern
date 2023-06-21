package com.rhsv1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SectionPage {
	
	String addSectionNameString;
	
	
	@FindBy(xpath="//span[normalize-space()='Sections']")
	@CacheLookup
	WebElement Sections;

	@FindBy(how=How.XPATH, using="//input[@placeholder='Enter Section Name']")
	@CacheLookup
	WebElement addSection;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	@CacheLookup
	WebElement submitAddSection;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	@CacheLookup
	WebElement addSectionSucessfully;

	@FindBy(xpath="//input[@type='search']")
	@CacheLookup
	WebElement search;
	
	@FindBy(xpath="//input[@type='search']")
	@CacheLookup
	WebElement clearsearch;
	
	String nameString1="//h5[normalize-space()='";
	String nameString2="']";
	String addNameString="pay";
	
			
	/*
	 * @FindBy(xpath = "//h5[normalize-space()='"+addSectionNameString+"'])")
	 * //h5[normalize-space()='Payment Mode']
	 * 
	 * @CacheLookup WebElement findSearchResult;
	 */
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	@CacheLookup
	WebElement alreadyPresentSection;
	
	
	@FindBy(xpath="//td[@class='dataTables_empty']")
	@CacheLookup
	WebElement noFindSearchResult;
	
	
	
	
	public SectionPage(WebDriver rdriver) {

		PageFactory.initElements(rdriver, this);

	}
	
	public void setSections() {

		Sections.click();
	}

	public void setAddSection(String addSectionName) {
		addSection.sendKeys(addSectionName);
	}

	public void Search(String searchString) {

		search.sendKeys(searchString);
	}
	public String setAlreadyPresentSection() {
		 String alreadyPresntString=alreadyPresentSection.getText();
		 return alreadyPresntString;
	}
			
	/*
	 * public String setFindSearchResult() {
	 * 
	 * String searchResultString= findSearchResult.getText(); return
	 * searchResultString; }
	 */
	public void setSubmitAddSection() {
		submitAddSection.click();
	}
	 public String setAddSectionSucessfully() {
		 
		String actualMessageString= addSectionSucessfully.getText();
		return actualMessageString;
		 
	 }
	 
	 public String setNoFindSearchResult() {
		 
		 String resultString=noFindSearchResult.getText();
		 return resultString;
		 
	 }
	 public void setclearsearch() {
		 clearsearch.clear();
	 }
}
