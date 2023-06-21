package com.rhsv1.testCases;

import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.TargetDataLine;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Readexceldatfrommap extends RHSBase {
	
	@Test(dataProvider = "testlink")
	public void testExcelData(Map<String, String> maptestMap) throws Exception {
		
		
		System.out.println(maptestMap.get("name"));
	}
	
		@DataProvider(name="testlink")
	public Object[][] getData() throws Exception {
		String fileString = "C:/Users/Arya ATG/eclipse-workspace/rhsv1/src/test/java/com/rhsv1/testData/LoginData.xlsx";
		Object[][] obj =exlRead(fileString);
		return obj;
	}
}
