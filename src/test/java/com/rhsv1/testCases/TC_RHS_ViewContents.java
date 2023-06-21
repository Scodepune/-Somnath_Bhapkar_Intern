package com.rhsv1.testCases;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rhsv1.pageObjects.ContentAddNewPageRHS;
import com.rhsv1.pageObjects.ViewContentsPage;

public class TC_RHS_ViewContents extends RHSBase {
	SoftAssert assert1 = new SoftAssert();
	String anString = "added new section";
	String contentTitleString = "extra expenses";
	String contentPriceString = "1020";
	String contentDescString = "Expenses by somnath";

	public void loginPage() throws Exception {
		TC_RHS_LoginPage tc_RHS_LoginPage = new TC_RHS_LoginPage();
		tc_RHS_LoginPage.validUserNamePassword();
	}

	@Test
	public void viewContentTest() throws Exception {
		actionView();
		actionEdit();
		actionDelete();
	}

	public void actionView() throws Exception {
		ViewContentsPage vcp = new ViewContentsPage(driver);
		loginPage();
		vcp.contentclick();
		vcp.viewcontentclick();
		vcp.setSearch(anString);
		vcp.clickaction();
		vcp.clickactionview();
	}

	public void actionEdit() {
		ViewContentsPage vcp = new ViewContentsPage(driver);
		ContentAddNewPageRHS canprhs = new ContentAddNewPageRHS(driver);
		vcp.contentclick();
		vcp.viewcontentclick();
		vcp.clickaction();
		vcp.clickactionEdit();
		canprhs.setselectSection(anString);
		canprhs.setcontenttitle(contentTitleString);
		canprhs.setcontentprice(contentPriceString);
		canprhs.setcontentdesc(contentDescString);
		canprhs.submitAddNewContent();
	}

	public void actionDelete() {
		ViewContentsPage vcp = new ViewContentsPage(driver);
		vcp.setSearch(anString);
		vcp.clickaction();
		vcp.clickactionDelete();
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
	}
}