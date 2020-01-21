package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class QCAdminStoreSetup extends QCStore
{

	public static void storeSetup(String SSN,String AppURL) throws Exception
	{
		int i;
		for(i=0;i<3;i++)
		{
			//String curr_url=driver.getCurrentUrl();
			//driver.navigate().back();
			driver.get(prop.getProperty("login_page")); 
			//System.out.println(curr_url); 
	try{
		//String FileName= prop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("Store_Setup");
			String sheetName="Store_Setup";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String UserName = TestData.getCellData(sheetName,"AdminUserName",row);
					String Password = TestData.getCellData(sheetName,"AdminPassword",row);
					//String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					String Tran_cd = TestData.getCellData(sheetName,"Tran_cd",row);
					String StoreID = TestData.getCellData(sheetName,"StoreID",row);


					//test.log(LogStatus.INFO, MarkupHelper.createLabel("Admin Application is launched", ExtentColor.BLUE));
				


					driver = new InternetExplorerDriver();
					wait = new WebDriverWait(driver, 40000);

					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
				
					driver.get(AdminURL);
					//test.log(LogStatus.INFO, MarkupHelper.createLabel("Opened the Admin URL"+ AdminURL, ExtentColor.BLUE));
					test.log(LogStatus.INFO, "Opened the Admin URL" + AdminURL);

		driver.findElement(By.name("loginRequestBean.userId")).sendKeys(UserName);

		test.log(LogStatus.PASS, "Username is entered: "+UserName); 

		driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

		test.log(LogStatus.PASS, "Password is entered: "+Password); 

		//Click Login Button

		driver.findElement(By.name("login")).click();

		test.log(LogStatus.PASS, "Clicked on Submit button");
		
		driver.switchTo().defaultContent();

		driver.switchTo().frame("topFrame");

		driver.findElement(locator(prop.getProperty("admin_store_setup_tab"))).click(); 

		test.log(LogStatus.PASS, "Clicked on Store tab");
	
	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	
	driver.findElement(locator(prop.getProperty("admin_store_config"))).click();

	test.log(LogStatus.PASS, "Clicked on Store Config link");

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");
Thread.sleep(2000);
	driver.findElement(locator(prop.getProperty("admin_store_edit"))).click();

	test.log(LogStatus.PASS, "Clicked on Store Edit");
	
	Thread.sleep(2000);
	//driver.switchTo().defaultContent();

	//driver.switchTo().frame("topFrame");
	driver.switchTo().frame("main");
	
	driver.findElement(locator(prop.getProperty("admin_store_nbr"))).sendKeys(StoreID);

	test.log(LogStatus.PASS, "Entered Store number "+StoreID);

	driver.findElement(locator(prop.getProperty("admin_store_submit_btn"))).click();

	test.log(LogStatus.PASS, "Clicked on Submit button");


	Thread.sleep(5000);


	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.switchTo().frame("main");

	driver.findElement(locator(prop.getProperty("admin_store_status"))).sendKeys("Open");

	test.log(LogStatus.PASS, "Store status set as Open"); 

	driver.findElement(locator(prop.getProperty("admin_store_edit_submit"))).click();

	test.log(LogStatus.PASS, "Clicked on Submit"); 
	Thread.sleep(2000);
	driver.findElement(locator(prop.getProperty("admin_store_ok_btn"))).click();

	test.log(LogStatus.PASS, "Clicked on OK button"); 


	test.log(LogStatus.PASS, "Store Setup is successful:");
	test.log(LogStatus.PASS, "***********************************************");
	

break;
}
			}	
	
	break;
}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Getting Encryption from Admin is failed", ExtentColor.RED));
					test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
					String screenshotPath = getScreenhot(driver, "Exception");
									test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					test.log(LogStatus.INFO, "Store setup process is initiated again due to Application sync issue");

					continue;


				}

	}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "Store setup is failed");
	
		}
	}
}
