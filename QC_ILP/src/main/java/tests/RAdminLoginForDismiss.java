package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;



public class RAdminLoginForDismiss extends QCStore{


	public static void dismiss(WebDriver driver,String SSN,String AppURL)
	{
	try{
		//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("Dismiss");
			String sheetName="Dismiss";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
				String AdminUserName = TestData.getCellData(sheetName,"AdminUserName",row);
				String AdminPassword = TestData.getCellData(sheetName,"AdminPassword",row);
				   //String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				String Trancd = TestData.getCellData(sheetName,"Trancd",row);
				String StoreID = TestData.getCellData(sheetName,"StoreID",row);
				String BankruptcyStatus = TestData.getCellData(sheetName,"BankruptcyStatus",row);
				String CaseNo = TestData.getCellData(sheetName,"CaseNo",row);
				String BankChapter = TestData.getCellData(sheetName,"BankChapter",row);
				String AttorneyName = TestData.getCellData(sheetName,"AttorneyName",row);
				String AttorneyPhone = TestData.getCellData(sheetName,"AttorneyPhone",row);
				String AttorneyP1 = AttorneyPhone.substring(0, 3);
		        String AttorneyP2 = AttorneyPhone.substring(3, 6);
		        String AttorneyP3 = AttorneyPhone.substring(6, 10);
				
				
				
				
				
				
				

				test.log(LogStatus.INFO,"Admin Application is launched");

				driver = new InternetExplorerDriver();
				//wait = new WebDriverWait(driver, 40000);

				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
			
				driver.get(AdminURL);
				test.log(LogStatus.INFO,"Opened the Admin URL"+ AdminURL);
				test.log(LogStatus.INFO,"Admin Login For Dismiss"+ AdminURL);



	
	DateFormat df=new SimpleDateFormat("MM/dd/yyyy"); 

	driver.findElement(By.name("loginRequestBean.userId")).sendKeys(AdminUserName);

	test.log(LogStatus.PASS, "Username is entered: "+AdminUserName); 

	driver.findElement(By.name("loginRequestBean.password")).sendKeys(AdminPassword);

	test.log(LogStatus.PASS, "Password is entered: "+AdminPassword); 

	//Click Login Button

	driver.findElement(By.name("login")).click();

	test.log(LogStatus.PASS, "Clicked on Submit button");

	Thread.sleep(8000);


	driver.switchTo().defaultContent();

	driver.switchTo().frame("topFrame");
	
	Thread.sleep(5000);

	driver.findElement(By.xpath("//*[@id='500000']/a")).click();

	test.log(LogStatus.PASS, "Clicked on Transaction tab");
	
	
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
	Thread.sleep(8000);
	driver.findElement(By.xpath("//*[@id='502000']/a")).click();

	test.log(LogStatus.PASS, "Clicked on Borrower link");

	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");
	Thread.sleep(5000);
	driver.findElement(By.linkText("Bankrupt/Deceased Suite")).click();

	test.log(LogStatus.PASS, "Clicked on Bankrupt");
	
	Thread.sleep(5000);
	
	driver.switchTo().defaultContent();
	
	driver.switchTo().frame("mainFrame");
	
	driver.switchTo().frame("main");
	
	
	driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[1]/td[2]/input")).sendKeys(StoreID);
	System.out.print("StoreID");
	test.log(LogStatus.PASS, "Store number Entered"+StoreID); 
	
	driver.findElement(By.name("requestBean.dealNbr")).sendKeys(loan_number);

	test.log(LogStatus.PASS, "Loan number Entered"+loan_number);
	
	Thread.sleep(5000);
	
//Code For Mouse Over
	
	Actions action = new Actions(driver);
	action.moveByOffset(200,100).perform();
	Thread.sleep(10000);
	action.click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[3]/tbody/tr/td[2]/input")).click();
	                             
	test.log(LogStatus.PASS, "Clicked on Submit");
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
	
	test.log(LogStatus.PASS, "Clicked on GO Button");
			 
	Thread.sleep(500);
	
    driver.switchTo().defaultContent();
	
	driver.switchTo().frame("mainFrame");
	
	driver.switchTo().frame("main");
	
	Thread.sleep(5000);
	
    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
	
	test.log(LogStatus.PASS, "Clicked on Edit GO Button");
	
	Thread.sleep(5000);
	
	driver.findElement(By.name("requestBean.bnkStatus")).sendKeys(BankruptcyStatus);
	
	test.log(LogStatus.PASS, "bankruptcy Status is :" +BankruptcyStatus);
	
	Thread.sleep(500);
	
	driver.findElement(By.name("ubnkDate1")).sendKeys(Date1.trim());
	
    	
	test.log(LogStatus.PASS, "Date Entered is :" +Date1);
	
	//Thread.sleep(500);
	
	driver.findElement(By.name("ubnkDate2")).sendKeys(Date2.trim());
	
    //driver.findElement(By.name("bankruptcyFilingDate2")).sendKeys(Date2);
	
	test.log(LogStatus.PASS, "Date Entered is :" +Date2);
	
	Thread.sleep(500);
	
	driver.findElement(By.name("ubnkDate3")).sendKeys(Date3.trim());
	
    //driver.findElement(By.name("bankruptcyFilingDate3")).sendKeys(Date3);
	
	test.log(LogStatus.PASS, "Date Entered is :" +Date3);
	
	Thread.sleep(500);
	
	
	
	driver.findElement(By.xpath("//*[@id='bt_AddBankruptcy']")).click();
	
	test.log(LogStatus.PASS, "Clicked on Save");

	Thread.sleep(8000);
	
	test.log(LogStatus.PASS, "Status is : Dismissed");
	
	test.log(LogStatus.PASS, "Dismissed Completed Successfully");
	
	driver.close();

break;
}
			}	
	
	
}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					test.log(LogStatus.FAIL,"Dismissed in Admin is failed");
					Assert.assertTrue(false);

				}

	}
}
