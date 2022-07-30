package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseTest;

public class ExtentReportNG {
	static ExtentReports extent;
	
	public static ExtentReports getReport() {
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter spark = new ExtentSparkReporter(path);
	spark.config().setReportName("Musafir Web Automation");
	spark.config().setDocumentTitle("Test Result");
	extent=new ExtentReports();
	extent.attachReporter(spark);
	extent.setSystemInfo("Tester", "Arjun");
	return extent;
	}
	public static String takeScreenShot(String stepName) throws IOException {
		Date date = new Date();
		String timeStamp = stepName + date.getTime();
		String filePath = System.getProperty("user.dir") + "\\screenshots\\" + timeStamp + ".png";
		TakesScreenshot srcShot = ((TakesScreenshot) BaseTest.driver);
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filePath);
		FileUtils.copyFile(srcFile, destFile);
		return filePath;
	}
}
