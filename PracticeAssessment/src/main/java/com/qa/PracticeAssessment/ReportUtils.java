package com.qa.PracticeAssessment;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportUtils {
	private Date date = null;
	
	public static ExtentReports report;
	public ExtentTest test;
	
	public void createReport() {
		report = new ExtentReports("");
		test = report.startTest("Feature Test");
	}
	
	public void logTest(String information) {
		test.log(LogStatus.INFO,information);
	}
	
	
	//Function that takes and logs the screen shot
	public void logScreenShot(WebDriver driver) {
		date = new Date();
		System.out.println(date);
		String imageLocation = Constants.SCREENSHOT_LOCATION + date + ".png";
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(imageLocation));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCapture(imageLocation);
	}
}
