package driverScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctionLibaray.FunctionsLibrary;
import utilities.PropertyFileUtil;

public class dummy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//System.out.println(PropertyFileUtil.getValueForKey("browser"));
		
		/*WebDriver driver=FunctionsLibrary.startBrowser();
		System.out.println(driver);
        */
		
		ExtentReports rep= new ExtentReports("D:\\Madhavi\\StockAccountingHybridFF\\Reports\\ExtentReport.html");
		
		
		ExtentTest writer = rep.startTest("loginTest");
		
		
		
		
		WebDriver driver1=FunctionsLibrary.startBrowser();
		
		
		System.out.println("Chrome open");  //log statement
		
		writer.log(LogStatus.INFO, "chrome open");
		
		FunctionsLibrary.openApplication(driver1);
		writer.log(LogStatus.INFO, "Lunchapp");
		
		FunctionsLibrary.waitForElement(driver1, "id", "username", "10");
		
		writer.log(LogStatus.INFO, "wait");
		
		FunctionsLibrary.typeAction(driver1, "id", "username", "admin");
		writer.log(LogStatus.INFO, "Enter username");
		
		FunctionsLibrary.waitForElement(driver1, "name", "password", "10");
		writer.log(LogStatus.INFO, "wait");
		
		FunctionsLibrary.typeAction(driver1, "name", "password", "master");
		writer.log(LogStatus.INFO, "Enter password");
		
		FunctionsLibrary.waitForElement(driver1, "id", "btnsubmit", "10");
		writer.log(LogStatus.INFO, "wait");
		
		FunctionsLibrary.clickAction(driver1, "id", "btnsubmit");
		writer.log(LogStatus.INFO, "click login");
		
		writer.log(LogStatus.PASS, "Pass");
		rep.endTest(writer);
		
		rep.flush();
		
		
		
		
	}

}
