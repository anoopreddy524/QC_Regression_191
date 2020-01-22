package tests;
import java.io.BufferedReader;
/*This is the base class which contains some reusable code for driver initialization,extent reports
and screen shot functionality
*/
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	public static String FileName;
	
	
		public static WebDriverWait wait;
	    public static WebDriver driver;
	    String appUrl;
	    String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
	    public static ExtentReports reports;
	    public static ExtentTest test;
	    public static Properties Aprop;
	    public static Excel TestData;
	    public static String FirstName;
	    public static String passwrd;
	    public static String report_filename;
	    public static String LastName;
	     //This method to generate extent reports and driver initialization
	     public static void setup() throws IOException {
	         
	        try{ String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
	         //Date D = new Date();

	        	//filename="LendNation_"+timestamp+".html";
	         //System.out.print(filename);
	         //reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/LendNation/"+filename, true);
	         //reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/LendNation/"+report_filename,true);
	         //reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/LendNation/ShortListedScenarios.html", true);
	        report_filename="QC__Store_Execution_Report_"+timestamp+".html";
	        reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/QC_CSR/"+report_filename,true);
	 //      reports.addSystemInfo("Browser Version","Chrome 69");
	         
	         //****Browser initializations
	        // System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/IEDriverServer.exe");
	        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
	         //driver = new InternetExplorerDriver();
	          driver=new ChromeDriver();
	         
	         driver.manage().window().maximize();
	         driver.manage().timeouts().implicitlyWait(02, TimeUnit.SECONDS);
	          wait = new WebDriverWait(driver, 10000);
	          
	          //test=reports.startTest("CSR ACH deposit Scenario","Login-->Age the stote up to due date--->Perform deposit");
	          
	          
	         //*******properties file Code************************* 
	          
	          
	        //prop=prop.getProperty("user.dir")+"/Tests/Objects.properties";
	      	BufferedReader Areader;
	      	//String propertyFilePath=("user.dir")+"/Objects.properties";
	      	
	      	//InputStream input = new FileInputStream("D:/QC_Workspace/AA_Automation/src/Tests/Objects.properties");
	      	//prop.load(input);
	      	//System.out.println(prop.getProperty("LendNation_URL"));
	      	
	      
	      		Areader = new BufferedReader(new FileReader("C:/QC_ILP/src/test/java/tests/AObjects.properties"));
	      		Aprop = new Properties();
	      					
	      						Aprop.load(Areader);
	      						Areader.close();
	 }
	 	catch(Exception e)
		{
			e.printStackTrace();
		}
		}

	     public  static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
	         String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
	         
	         File source = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
	   
	         String destination = System.getProperty("user.dir") + "/ExecutionReports/LendNation/FailedTestsScreenshots/"+screenshotName+dateName+".png";
	         File finalDestination = new File(destination);
	         FileUtils.copyFile(source, finalDestination);
	         return destination;
	         }
	     public static By locator(String obj)
			{
				
				String loctype=null;
				String locname=null;
				 By locator=null;
				 String[] locobj=obj.split("%%"); 
				 loctype=locobj[0];
				 locname=locobj[1];
				// System.out.println("startign of switch case");
				// System.out.println(obj);
				 /*switch(loctype)
				 {
				 case "id": 
					 locator=By.id(locname);
					break;
				 case "name": 
					 locator=By.name(locname);
					break;
				 case "linkText": 
					 locator=By.linkText(locname);
					break;
				 case "xpath": 
					 locator=By.xpath(locname);
					 case "cssSelector": 
					 locator=By.cssSelector(locname);
					break;
				 }*/
				 
				 if(loctype.equalsIgnoreCase("id"))
					 return locator=By.id(locname);
				 else if(loctype.equalsIgnoreCase("name"))
					 return locator=By.name(locname);
				 else if(loctype.equalsIgnoreCase("linkText"))
					 return locator=By.linkText(locname);
				 else if(loctype.equalsIgnoreCase("xpath"))
					 return locator=By.xpath(locname);
				 else if(loctype.equalsIgnoreCase("cssSelector"))
					 return locator=By.cssSelector(locname);
				return locator;
		
			}
	  
	}




















	

