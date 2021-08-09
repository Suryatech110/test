package com.commonUtilis;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	private static ExtentReports extent;

	public static ExtentReports getReportObject() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\index.html");
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Surya");
		return extent;

	}
}
