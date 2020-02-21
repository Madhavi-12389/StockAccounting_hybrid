package driverScript;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.mongodb.MapReduceCommand.OutputType;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctionLibaray.FunctionsLibrary;
import utilities.ExcelUtil;

public class DriverScriptForSupplierCreation {
	
	public static WebDriver driver=null;;
	static ExtentTest test;

	public static void main(String[] args) throws IOException {

		 ExtentReports report;
		 ExtentTest writer;
		 
		
		
		ExcelUtil excl= new ExcelUtil();
		
		
		for (int i = 1; i <= excl.rowCount("MasterTestCases"); i++) {
			
			String ModuleStatus="";
			
			if (excl.getData("MasterTestCases", i, 2).equalsIgnoreCase("Y")) {
				
				
				
				String tcmodule= excl.getData("MasterTestCases", i, 1);
				report= new ExtentReports("D:\\Madhavi\\StockAccountingHybridFF\\Reports\\"+tcmodule+FunctionsLibrary.generateDate()+".html");
				test=report.startTest(tcmodule);
				 tcmodule= excl.getData("MasterTestCases", i, 1);
				
				
				for (int j = 0; j < excl.rowCount(tcmodule); j++) {
				    String Description=	excl.getData(tcmodule, j, 0);
					
				    String Functionname=	excl.getData(tcmodule, j, 1);
				    String locatortype=	excl.getData(tcmodule, j, 2);
				    String locatorvalue=	excl.getData(tcmodule, j, 3);
				    String testdata=	excl.getData(tcmodule, j, 4);
				    
				   try{ 
				    if(Functionname.equalsIgnoreCase("startBrowser")){
				    	 driver = FunctionsLibrary.startBrowser();
				    	 test.log(LogStatus.INFO, Description);
				    	
				    }else if(Functionname.equalsIgnoreCase("openApplication")){
				    	FunctionsLibrary.openApplication(driver);
				    	 test.log(LogStatus.INFO, Description);
				    
				    }else if(Functionname.equalsIgnoreCase("waitforElement")){
				    	FunctionsLibrary.waitForElement(driver, locatortype, locatorvalue, testdata);;
				    	 test.log(LogStatus.INFO, Description);
				    
				    }else if(Functionname.equalsIgnoreCase("typeAction")){
				    	FunctionsLibrary.typeAction(driver, locatortype, locatorvalue, testdata);
				    	 test.log(LogStatus.INFO, Description);
				    }
				    
				    
				    else if(Functionname.equalsIgnoreCase("clickAction")){
				    	FunctionsLibrary.clickAction(driver, locatortype, locatorvalue);
				    	 test.log(LogStatus.INFO, Description);
				    }
				    
				    else if(Functionname.equalsIgnoreCase("captureData")){
				    	FunctionsLibrary.captureData(driver, locatortype, locatorvalue); 
				    	 test.log(LogStatus.INFO, Description);
				    }
				    else if(Functionname.equalsIgnoreCase("tableValidation")){
				    	FunctionsLibrary.tableValidation(driver, testdata);
				    	 test.log(LogStatus.INFO, Description);
				    }
				    else if(Functionname.equalsIgnoreCase("closeBrowser")){
				    	FunctionsLibrary.closeBrowser(driver);
				    	 test.log(LogStatus.INFO, Description);
				    }
				    
				   // System.out.println(tcmodule);
				    excl.setData(tcmodule, j, 5, "Pass");
				    test.log(LogStatus.PASS, Description);
				    ModuleStatus="pass";
				   }catch(Exception e){
					   e.printStackTrace();
					   excl.setData(tcmodule, j, 5, "Fail");   
					   ModuleStatus="Fail";
					   test.log(LogStatus.FAIL, Description);
					   //take screenshot
					   
					   String reqDate= FunctionsLibrary.generateDate();
					   File srcFile=((TakesScreenshot)driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
						FileUtils.copyFile(srcFile, new File("D:\\Madhavi\\StockAccountingHybridFF\\Screenshots\\"+Description+reqDate+".png"));
					   
					   test.log(LogStatus.INFO, test.addScreenCapture("D:\\Madhavi\\StockAccountingHybridFF\\Screenshots\\"+Description+reqDate+".png"));
					   break;
				   } 
					
				}
				
				
				//write master sheetPass
				if(ModuleStatus.equalsIgnoreCase("Pass")){
					excl.setData("MasterTestCases",i,3,"Pass");
				}else{
					excl.setData("MasterTestCases",i,3,"Fail");
				}
				
				report.endTest(test);
	               report.flush();
				
				
			} else {
	               
				excl.setData("MasterTestCases", i, 3, "Not");
				
			}
			
			
		}
		
		
	}

		
		

}

