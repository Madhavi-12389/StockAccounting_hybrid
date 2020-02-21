package commonFunctionLibaray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.print.DocFlavor.BYTE_ARRAY;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.PropertyFileUtil;

public class FunctionsLibrary {
	
	static WebDriver driver;
	
	
	public static WebDriver startBrowser() throws IOException{
		
		if(PropertyFileUtil.getValueForKey("browser").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Madhavi\\StockAccountingHybridFF\\Driver\\chromedriver.exe");
			 driver = new ChromeDriver();
			
			
			
		}else if(PropertyFileUtil.getValueForKey("browser").equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\Madhavi\\StockAccountingHybridFF\\Driver\\geckodriver.exe");
			 driver = new FirefoxDriver();
			
			
			
		}else if(PropertyFileUtil.getValueForKey("browser").equalsIgnoreCase("IE")){
			
			System.setProperty("webdriver.ie.driver", "D:\\Madhavi\\StockAccountingHybridFF\\Driver\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
			}	
			
		
	return driver;
	
	
}
		
	
	public static void openApplication(WebDriver driver) throws IOException{
		driver.get(PropertyFileUtil.getValueForKey("url"));
		driver.manage().window().maximize();
		
		
	}
	
	
	public static void waitForElement(WebDriver driver,String loctype,String locvalue,String waittime){
		
		WebDriverWait mwait= new WebDriverWait(driver,Integer.parseInt(waittime));
		
		if(loctype.equalsIgnoreCase("id")){
		mwait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locvalue)));
		
		
		}else if(loctype.equalsIgnoreCase("xpath")){
			mwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locvalue)));
			
			
			}else if(loctype.equalsIgnoreCase("name")){
				
				mwait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locvalue)));
				
			}else if(loctype.equalsIgnoreCase("linkText")){
				
				mwait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locvalue)));
				
			}else if(loctype.equalsIgnoreCase("partialLinkText")){
				
				mwait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locvalue)));
				
			}else if(loctype.equalsIgnoreCase("cssSelector")){
				
				mwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locvalue)));
				
			}else if(loctype.equalsIgnoreCase("className")){
				
				mwait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locvalue)));
				
			}else if(loctype.equalsIgnoreCase("tagName")){
				
				mwait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locvalue)));
				
			}
			
			else{
				
				System.out.println("wrong locator");
				
			}
		
		
		
	}
	
	
	public static void typeAction(WebDriver driver,String loctype,String locvalue,String testdata){
		
		
		if(loctype.equalsIgnoreCase("id")){
			driver.findElement(By.id(locvalue)).clear();
			driver.findElement(By.id(locvalue)).sendKeys(testdata);;
			
			}else if(loctype.equalsIgnoreCase("xpath")){
                         driver.findElement(By.xpath(locvalue)).clear();
				
				         driver.findElement(By.xpath(locvalue)).sendKeys(testdata);;
				
				
				}else if(loctype.equalsIgnoreCase("name")){
					
					driver.findElement(By.name(locvalue)).clear();
					
					driver.findElement(By.name(locvalue)).sendKeys(testdata);;
					
				}else if(loctype.equalsIgnoreCase("linkText")){
					driver.findElement(By.linkText(locvalue)).clear();
					driver.findElement(By.linkText(locvalue)).sendKeys(testdata);
					
				}else if(loctype.equalsIgnoreCase("partialLinkText")){
					driver.findElement(By.partialLinkText(locvalue)).clear();
					driver.findElement(By.partialLinkText(locvalue)).sendKeys(testdata);
					
					
				}else if(loctype.equalsIgnoreCase("cssSelector")){
					
					driver.findElement(By.cssSelector(locvalue)).clear();
					driver.findElement(By.cssSelector(locvalue)).sendKeys(testdata);
					
				}else if(loctype.equalsIgnoreCase("className")){
					
					driver.findElement(By.className(locvalue)).clear();
					driver.findElement(By.className(locvalue)).sendKeys(testdata);
					
				}else if(loctype.equalsIgnoreCase("tagName")){
					
					driver.findElement(By.tagName(locvalue)).clear();
					driver.findElement(By.tagName(locvalue)).sendKeys(testdata);
					
				}
				
				
				else{
					
					System.out.println("wrong value");
					
				}
		
	}
	
	
	public static void clickAction(WebDriver driver,String loctype,String locvalue){
		
		if(loctype.equalsIgnoreCase("id")){
			driver.findElement(By.id(locvalue)).click();
		
			
			}else if(loctype.equalsIgnoreCase("xpath")){
				driver.findElement(By.xpath(locvalue)).sendKeys(Keys.ENTER);
				
				}else if(loctype.equalsIgnoreCase("name")){
					driver.findElement(By.name(locvalue)).click();
				}else if(loctype.equalsIgnoreCase("linkText")){
					
					driver.findElement(By.linkText(locvalue)).click();
					
				}else if(loctype.equalsIgnoreCase("partialLinkText")){
					driver.findElement(By.partialLinkText(locvalue)).click();
					
					
				}else if(loctype.equalsIgnoreCase("cssSelector")){
					driver.findElement(By.cssSelector(locvalue)).click();
					
					
				}else if(loctype.equalsIgnoreCase("className")){
					
					driver.findElement(By.className(locvalue)).click();
					
				}else if(loctype.equalsIgnoreCase("tagName")){
					driver.findElement(By.tagName(locvalue)).click();
					
					
				}
				
				
				else{
					
					System.out.println("erong value");
					
				}
		
	}
	
	public static void closeBrowser(WebDriver driver){
		
		driver.close();
		
	}
	
	public static String generateDate(){
		
		
		Date d= new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MM_DD_hh_mm_SS");
        
		String rd= sdf.format(d);
          System.out.println(rd);
		
		return rd;
		
		
		
	}
	
	
	
	public static void captureData(WebDriver driver,String loctype,String locvalue) throws IOException{
		
		String supplierdata="";
		
		if(loctype.equalsIgnoreCase("id")){
			supplierdata = driver.findElement(By.id(locvalue)).getAttribute("value");
			
			
			
			}else if(loctype.equalsIgnoreCase("xpath")){
				supplierdata = driver.findElement(By.xpath(locvalue)).getAttribute("value");
				
				      
				
				
				}else if(loctype.equalsIgnoreCase("name")){
					
					supplierdata =driver.findElement(By.name(locvalue)).getAttribute("value");
					
					
					
				}else if(loctype.equalsIgnoreCase("linkText")){
					supplierdata =driver.findElement(By.linkText(locvalue)).getAttribute("value");
				
					
				}else if(loctype.equalsIgnoreCase("partialLinkText")){
					supplierdata =driver.findElement(By.partialLinkText(locvalue)).getAttribute("value");
					
					
					
				}else if(loctype.equalsIgnoreCase("cssSelector")){
					
					supplierdata =driver.findElement(By.cssSelector(locvalue)).getAttribute("value");
					
				}else if(loctype.equalsIgnoreCase("className")){
					
					supplierdata =driver.findElement(By.className(locvalue)).getAttribute("value");
					
					
				}else if(loctype.equalsIgnoreCase("tagName")){
					
					supplierdata =driver.findElement(By.tagName(locvalue)).getAttribute("value");
					
					
				}
				
				
				else{
					
					System.out.println("wrong value");
					
				}
		     
		FileWriter fw= new FileWriter("D:\\Madhavi\\StockAccountingHybridFF\\CaputreData\\SupplierNumber.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(supplierdata);
		bw.flush();
		bw.close();
		
	}
	
	
	public static void tableValidation(WebDriver driver,String column) throws IOException, InterruptedException{
		
		FileReader fr = new FileReader("./CaputreData/SupplierNumber.txt");
		BufferedReader br= new BufferedReader(fr);
		
		String Exp_data= br.readLine();
		
		if (driver.findElement(By.id(PropertyFileUtil.getValueForKey("searchtextbox"))).isDisplayed()) {
			
			Thread.sleep(5000);
			driver.findElement(By.id(PropertyFileUtil.getValueForKey("searchtextbox"))).sendKeys(Exp_data);
			driver.findElement(By.id(PropertyFileUtil.getValueForKey("searchbutton"))).click();
			
			
		} else {
                  
			driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("searchpanelButton"))).click();
			
			Thread.sleep(5000);
			driver.findElement(By.id(PropertyFileUtil.getValueForKey("searchtextbox"))).sendKeys(Exp_data);
			driver.findElement(By.id(PropertyFileUtil.getValueForKey("searchbutton"))).click();
			
		}
		
		WebElement  table = driver.findElement(By.id(PropertyFileUtil.getValueForKey("suppliertable")));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for (int i = 1; i <=rows.size(); i++) {
			String Act_data= driver.findElement(By.xpath("//table[@id='tbl_a_supplierslist']/tbody/tr["+i+"]/td["+column+"]/div/span")).getText();
			Assert.assertEquals(Act_data, Exp_data);
			System.out.println(Act_data+"     "+Exp_data);
			break;
			
		}
		
		
	}
	
	
	
	
	

}
