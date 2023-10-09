package org.meta.facebook.testUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;

	public static ExtentReports getReporterObject() {

		String path = System.getProperty("user.dir") + "//reports//index.html";
		System.out.println(path);
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Facebook App Automation Results");
		reporter.config().setDocumentTitle("Facebook App Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Tausif Elahi");
		return extent;

	}

}
