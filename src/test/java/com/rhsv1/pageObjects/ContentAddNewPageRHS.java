package com.rhsv1.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContentAddNewPageRHS {
	
	public ContentAddNewPageRHS(WebDriver rdriver) {

		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Contents']")
	@CacheLookup
	WebElement content;

	@FindBy(xpath = "//a[normalize-space()='Add New Content']")
	@CacheLookup
	WebElement addNewContent;

	@FindBy(xpath = "//select[@id='select']")
	@CacheLookup
	public WebElement selectSection;

	@FindBy(xpath = "//input[@name='contenttitle']")
	@CacheLookup
	WebElement contenttitle;

	@FindBy(xpath = "//input[@name='price']")
	@CacheLookup
	WebElement contentprice;
	
	@FindBy(xpath = "//div[4]//div[1]//input[1]")
	@CacheLookup
	WebElement contentsqe;
	
	@FindBy(xpath = "//div[5]//div[1]//input[1]")
	@CacheLookup
	WebElement contentImgAltTag;
	
	@FindBy(xpath = "//textarea[@name='contentdesc']")
	@CacheLookup
	WebElement contentdesc;
	
	@FindBy(xpath = "//div[7]//div[1]//input[1]")
	@CacheLookup
	WebElement contentDate;
	
	@FindBy(xpath = "//div[9]//div[1]//input[1]")
	@CacheLookup
	WebElement contentLocation;
	
	
	@FindBy(xpath = "//div[9]//div[1]//input[1]")
	@CacheLookup
	WebElement contentAddLink;
	
	@FindBy(xpath = "//input[@id='fupImage']")
	@CacheLookup
	WebElement contentImage;
	
	@FindBy(xpath = "//button[@name='submit']")
	@CacheLookup
	WebElement submit;

	public void contentclick() {

		content.click();
	}

	public void setaddNewContent() {

		addNewContent.click();
	}

	public void setselectSection(String selectionName) {

		
		  Select sel = new Select(selectSection);
		  
		  sel.selectByVisibleText(selectionName);
		 }
	
	public void setcontenttitle(String contenttitleString1) {

		contenttitle.sendKeys(contenttitleString1);
	}

	public void setcontentprice(String contentpricesString) {

		contentprice.sendKeys(contentpricesString);
	}
	public void setcontentsqe(String contentseqString) {

		contentsqe.sendKeys(contentseqString);
	}
	
	public void setcontentImgAltTag(String contentImgAltTagString) {

		contentImgAltTag.sendKeys(contentImgAltTagString);
	}
		
	public void setcontentdesc(String contentdescsString) {

		contentdesc.sendKeys(contentdescsString);
	}
	
	public void setcontentDate(String contentDateString) {

		contentDate.sendKeys(contentDateString);
	}
	
	public void setcontentLocation(String contentLocationString) {

		contentLocation.sendKeys(contentLocationString);
	}
	
	public void setcontentAddLink(String contentAddLinkString) {

		contentAddLink.sendKeys(contentAddLinkString);
	}
	
	public void setcontentImage(String filePathString) {

		contentImage.sendKeys(filePathString);
	}
	
	
	public void submitAddNewContent() {

		submit.click();
	}
	
}
