package com.scm.genericutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentation extends BaseClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String Methodname=result.getMethod().getMethodName();
		test=report.createTest(Methodname);
		Reporter.log(Methodname+"----TestScript execution strts from here-----");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String Methodname=result.getMethod().getMethodName();
		test.log(Status.PASS, Methodname+"------>Passed");
		Reporter.log(Methodname+"----TestScript executed successfully-----");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		String MN=Methodname+ new JavaUtils().systemDataInFormat();
		test.addScreenCaptureFromPath(MN);
		TakesScreenshot t=(TakesScreenshot) sdriver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File des=new File("./scrrenshot/"+Methodname+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, MN+"-------->Failed");
		Reporter.log(MN+"----TestScript execution failed-----");
		
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, Methodname+"-------->Failed");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(Methodname+"----TestScript execution Skipped-----");
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./extentRepoty/report.html");
		htmlReport.config().setDocumentTitle("Procure");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Admin_Module");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("url", "http://rmgtestingserver/domain/Supply_Chain_Management/");
		report.setSystemInfo("Reporter name", "Nikhil");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	
	

}
