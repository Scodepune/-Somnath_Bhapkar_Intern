package com.rhsv1.testCases;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.rhsv1.pageObjects.SectionPage;

public class TC_RHS_SectionsPage extends RHSBase {

	String addSectionNameString;
	double int_random;
	SoftAssert assert1 = new SoftAssert();
		
	public void loginPage() throws Exception {
		TC_RHS_LoginPage tc_RHS_LoginPage = new TC_RHS_LoginPage();
		tc_RHS_LoginPage.validUserNamePassword();
	}
	
	@Test
	public void SectionPageTest() throws IOException, Exception {
			
		loginPage();
		Thread.sleep(3000);
		addNewSectionTest();
		Thread.sleep(3000);
		noSearchSectionTest();
		Thread.sleep(3000);
		addOldSectionTest();
		Thread.sleep(3000);
		SearchSectionTest();
		Thread.sleep(3000);
		System.out.println("All is ok");
		
			
	}
	public String randomDataGene() {
		Random rand = new Random();
		int_random = rand.nextDouble();		
		addSectionNameString= "Test Data"+int_random+"01";
		return addSectionNameString;
		
	}
	public void addNewSectionTest() {
		
		SectionPage sPage = new SectionPage(driver);		
		addSectionNameString=randomDataGene();
		sPage.setSections();
		sPage.setAddSection(addSectionNameString);
		sPage.setSubmitAddSection();
		assert1.assertEquals("Section added Successfully...", sPage.setAddSectionSucessfully());
		System.out.println("addNewSectionTest");
	}

	public void noSearchSectionTest() {
		
		SectionPage sPage = new SectionPage(driver);
		
		sPage.Search("Extra Expenses");
		assert1.assertEquals("No matching records found", sPage.setNoFindSearchResult());
		System.out.println("noSearchSectionTest");
		sPage.setclearsearch();
		System.out.println("Extra Expenses.............");
		
	}
	
	public void SearchSectionTest() {
		
		SectionPage sPage = new SectionPage(driver);
		sPage.Search(addSectionNameString);
		System.out.println("I am in SearchSectionTest.........");
		WebElement findSearchStringResult = driver.findElement(By.xpath("//h5[normalize-space()='"+addSectionNameString+"']"));
	String actualResult=findSearchStringResult.getText();
		assert1.assertEquals(addSectionNameString,actualResult);
		System.out.println("SearchSectionTest");
		System.out.println("Actualstring"+actualResult);
		System.out.println("Expected Result"+addSectionNameString);
		
	}
	
	public void addOldSectionTest() {
		
		SectionPage sPage = new SectionPage(driver);
		sPage.setAddSection(addSectionNameString);
		sPage.setSubmitAddSection();
		assert1.assertEquals("This sections already exists!!!", sPage.setAlreadyPresentSection());
		System.out.println("addOldSectionTest");
		
	}
	
	

}
