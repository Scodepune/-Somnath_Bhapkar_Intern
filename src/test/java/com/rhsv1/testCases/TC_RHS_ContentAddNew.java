package com.rhsv1.testCases;

import java.util.Map;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.rhsv1.pageObjects.ContentAddNewPageRHS;

public class TC_RHS_ContentAddNew extends RHSBase {

	/*
	 * SoftAssert assert1 = new SoftAssert(); String anString = "added new section";
	 * String contentTitleString = "extra expenses"; String contentPriceString =
	 * "1020"; String contentDescString = "Expenses by somnath";
	 */

	@DataProvider(name = "testlink")
	public Object[][] getData() throws Exception {
		String fileString = "C:/Users/Arya ATG/eclipse-workspace/rhsv1/src/test/java/com/rhsv1/testData/ContentAddNew.xlsx";
		Object[][] obj = exlRead(fileString);
		return obj;
	}

	public void loginPage() throws Exception {
		TC_RHS_LoginPage tc_RHS_LoginPage = new TC_RHS_LoginPage();
		tc_RHS_LoginPage.validUserNamePassword();
	}

	@Test(dataProvider = "testlink")
	public void addNewContentTest(Map<String, String> maptestMap) throws Exception {
		ContentAddNewPageRHS canprhs = new ContentAddNewPageRHS(driver);

		loginPage();
		canprhs.contentclick();
		Thread.sleep(3000);
		canprhs.setaddNewContent();
		Thread.sleep(3000);
		canprhs.setselectSection(maptestMap.get("SelectSection"));
		canprhs.setcontenttitle(maptestMap.get("ContentTitle"));
		canprhs.setcontentprice(maptestMap.get("ContentChargesPriceCost"));
		canprhs.setcontentsqe(maptestMap.get("ContentSequence"));
		canprhs.setcontentImgAltTag(maptestMap.get("ContentImgAltTag"));		
		canprhs.setcontentdesc(maptestMap.get("ContentDescription"));
		canprhs.setcontentDate(maptestMap.get("Date"));
		canprhs.setcontentLocation(maptestMap.get("Location"));
		canprhs.setcontentAddLink(maptestMap.get("AddLink"));
		canprhs.setcontentImage(maptestMap.get("Image"));
		canprhs.submitAddNewContent();

	}

}
