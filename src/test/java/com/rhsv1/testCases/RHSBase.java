package com.rhsv1.testCases;

import java.io.File;
import java.io.FileInputStream;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.rhsv1.utilities.ReadConfig;
import com.rhsv1.utilities.XLUtils;

public class RHSBase {
	ReadConfig readConfig = new ReadConfig();
	
	public static  Logger log;

	public static WebDriver driver;
	public String browserString = readConfig.getBrowserName();
	public String urlString = readConfig.getApplicationUrl();
	public String usernameString = readConfig.getUserName();
	public String passwordString = readConfig.getPassword();

	@BeforeMethod
	public void setup() throws Exception {
		
		log=LogManager.getLogger(RHSBase.class);

		if (browserString.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}

		driver.get(urlString);
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() {

		//driver.quit();

	}

	public static String captureScreenShot(String filename) throws Exception {

		DateTimeFormatter formatedDateTime = DateTimeFormatter.ofPattern("ddMMYY_HHmmss");
		String timeStampString = LocalDateTime.now().format(formatedDateTime);

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		File destFile = new File("./ScreenShots/" + filename + timeStampString + ".png");

		FileUtils.copyFile(sourceFile, destFile);
		System.out.println("Screen shot saved sucessfully.");
		return destFile.getAbsolutePath();
	}

	public Object[][] exlRead(String excelFilePath) throws Exception {

		DataFormatter dFormatter = new DataFormatter();
		int row = XLUtils.getRowCount(excelFilePath, "sheet1");
		int column = XLUtils.getCellCount(excelFilePath, "sheet1", 1);
		FileInputStream file = new FileInputStream(excelFilePath);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheet("Sheet1");

		Object[][] obj1 = new Object[row][1];

		Map<String, String> mapData;

		for (int i = 1; i <= row; i++) {
			
			mapData = new HashMap<String, String>();
			
			for (int j = 0; j < column; j++) {

				String key = dFormatter.formatCellValue(sh.getRow(0).getCell(j));

				String value = dFormatter.formatCellValue(sh.getRow(i).getCell(j));

				mapData.put(key, value);
			}
			
			obj1[i-1][0] = mapData;
		}
		return obj1;
	}

}
