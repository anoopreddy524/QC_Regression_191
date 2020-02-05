package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class SQCAdminStoreSetup extends QCStore
{

	public static void storeSetup(String SSN,String AppURL) throws InterruptedException
	{
	 		 
			int lastrow=TestData.getLastRow("Store_Setup");
			String sheetName="Store_Setup";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String UserName = TestData.getCellData(sheetName,"AdminUserName",row);
					String Password = TestData.getCellData(sheetName,"AdminPassword",row);
					String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
					//String PIN = TestData.getCellData(sheetName,"PIN",row);
					//String Tran_cd = TestData.getCellData(sheetName,"Tran_cd",row);
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

		//driver.findElement(locator(Sprop.getProperty("admin_store_setup_tab"))).click(); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='100000']/a")).click();

		test.log(LogStatus.PASS, "Clicked on Store tab");
	
	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	
	//driver.findElement(locator(Sprop.getProperty("admin_store_config"))).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='101000']/a")).click();

	test.log(LogStatus.PASS, "Clicked on Store Config link");

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");
    Thread.sleep(3000);
	//driver.findElement(locator(Sprop.getProperty("admin_store_edit"))).click();
    driver.findElement(By.xpath("//*[@id='101020']/a")).click();

	test.log(LogStatus.PASS, "Clicked on Store Edit");
	
	Thread.sleep(5000);
	//driver.switchTo().defaultContent();

	//driver.switchTo().frame("topFrame");
	driver.switchTo().frame("main");
	
	//driver.findElement(locator(Sprop.getProperty("admin_store_nbr"))).sendKeys(StoreID);
	//Thread.sleep(6000);
	driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td/table/tbody/tr[1]/td/b/input")).sendKeys(StoreID);

	test.log(LogStatus.PASS, "Entered Store number "+StoreID);

	//driver.findElement(locator(Sprop.getProperty("admin_store_submit_btn"))).click();
	Thread.sleep(500);
	driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td/table/tbody/tr[3]/td/input[1]")).click();

	test.log(LogStatus.PASS, "Clicked on Submit button");


	Thread.sleep(5000);


	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.switchTo().frame("main");

	//driver.findElement(locator(Sprop.getProperty("admin_store_status"))).sendKeys("Open");
	driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[1]/tbody/tr[4]/td/table[1]/tbody/tr[3]/td[1]/select")).sendKeys("Open");

	test.log(LogStatus.PASS, "Store status set as Open"); 
	String business_unit=driver.findElement(By.name("locationBean.businessUnitCd")).getAttribute("value");

	//driver.findElement(locator(Sprop.getProperty("admin_store_edit_submit"))).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[3]")).click();

	test.log(LogStatus.PASS, "Clicked on Submit"); 
	Thread.sleep(5000);
	
	try { 
		Alert alert = driver.switchTo().alert();
		alert.accept();
		test.log(LogStatus.PASS, "Handled the alert"); 
		//if alert present, accept and move on.														

	}
	catch (NoAlertPresentException e) {
		//do what you normally would if you didn't have the alert.
	}
	try{
		if(business_unit.equalsIgnoreCase("1"))
		{
			Thread.sleep(5000);
		//driver.findElement(By.name("locationBean.businessUnitCdDisp")).sendKeys("2");
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[1]/tbody/tr[4]/td/table[1]/tbody/tr[2]/td[1]/select")).sendKeys("2");
		}
		else
		{
			Thread.sleep(5000);
			//driver.findElement(By.name("locationBean.businessUnitCdDisp")).sendKeys("1");
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[1]/tbody/tr[4]/td/table[1]/tbody/tr[2]/td[1]/select")).sendKeys("1");
		}
		test.log(LogStatus.PASS, "Changed business unit"); 

		//driver.findElement(locator(Sprop.getProperty("admin_store_edit_submit"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[3]")).click();

		test.log(LogStatus.PASS, "Clicked on Submit"); 
	}
	catch(Exception e)
	{
		
	}
	Thread.sleep(5000);
	//driver.findElement(locator(Sprop.getProperty("admin_store_ok_btn"))).click();
	driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table/tbody/tr[3]/td[2]/table/tbody/tr[2]/td/input")).click();

	test.log(LogStatus.PASS, "Clicked on OK button"); 


	test.log(LogStatus.PASS, "Store Setup is successful:");
	test.log(LogStatus.PASS, "***********************************************");
	//driver.close();
	

break;
}
			}	
	


	
	}
}
