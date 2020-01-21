package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.LogStatus;

//public class QCCSRDueDate extends QCStore {

//}
public class RQCCSRInternalTransfer extends QCStore{
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;
	




public static void internaltransfer(String SSN,String AppURL)
	{
		 
		try{
			//String FileName= prop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("InternalTransfer");
				String sheetName="InternalTransfer";

				for(int row=2;row<=lastrow;row++)
				{	
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String Action = TestData.getCellData(sheetName,"Action",row);
					String CountofDollarCoins = TestData.getCellData(sheetName,"CountofDollarCoins",row);
					String BankerPIN = TestData.getCellData(sheetName,"BankerPIN",row);
					if(SSN.equals(RegSSN))
					{		
						State = TestData.getCellData(sheetName,"StateID",row);
						 //ProductID=TestData.getCellData(sheetName,"ProductID",row);
						//System.out.println(ProductID);
						 
		
						 SSN1 = SSN.substring(0, 3);
						 SSN2 = SSN.substring(3,5);
						 SSN3 = SSN.substring(5,9);
						
						 
						Thread.sleep(3000);
						test.log(LogStatus.INFO, "CSR Login For Internal Transfer");
					   //driver.switchTo().frame("topFrame");
						 //Thread.sleep(5000);
						 //driver.switchTo().frame("topFrame");
						 for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("topFrame");
							 
			//Using try/catch for clicking elements 2nd time if it is not able to click in 1st attempt
							 
						 try
						 {
								 driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
								 test.log(LogStatus.PASS, "Clicked on Cash Management");
								 Thread.sleep(6000);
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 Thread.sleep(6000);
								 driver.findElement(By.xpath("//*[@id='932000']/a")).click();		
								 test.log(LogStatus.PASS, "Clicked on Safe");
								 Thread.sleep(500);
								 driver.findElement(By.xpath("//*[@id='932040']/a")).click();
								 test.log(LogStatus.PASS, "Clicked on Internal Transfer");
						 }
						 catch(Exception e)
						 {
							     driver.get("http://192.168.2.203/cc/login/index.jsp");
							     driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
							     Thread.sleep(6000);
							    driver.switchTo().defaultContent();
							    driver.switchTo().frame("mainFrame");
							    Thread.sleep(6000);
							    driver.findElement(By.xpath("//*[@id='932000']/a")).click();		
							    test.log(LogStatus.PASS, "Clicked on Safe");
							    Thread.sleep(500);
							    driver.findElement(By.xpath("//*[@id='932040']/a")).click();
							    test.log(LogStatus.PASS, "Clicked on Internal Transfer");
						 }
						Thread.sleep(500);
						for( String winHandle1 : driver.getWindowHandles())
						{
						    driver.switchTo().window(winHandle1);
						}			
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						driver.findElement(By.name("D1")).sendKeys(Action);
						test.log(LogStatus.PASS, "Action Type is :"+Action);
						driver.findElement(By.name("requestBean.noOfDollars")).sendKeys(CountofDollarCoins);
						test.log(LogStatus.PASS, "Coin Entered is :"+CountofDollarCoins);
						driver.findElement(By.name("drawerToSafeRequestBean.slipNbrs")).click();
						test.log(LogStatus.PASS, "Clicked on WebCheckbox");
						driver.findElement(By.name("safeToDrawerRequestBean.password")).sendKeys(BankerPIN);
						test.log(LogStatus.PASS, "Banker Pin Entered is :"+BankerPIN);
						driver.findElement(By.name("internaltransfer")).click();
						test.log(LogStatus.PASS, "Clicked on Finish Internal Transfer");
						Thread.sleep(5000);						 
						driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input")).click();						 
						test.log(LogStatus.PASS,"Click on Yes Button");						 
						test.log(LogStatus.PASS,"Drawer to safe Transfer Completed Successfully");
						driver.close();
						
						}
					}
				//}
		
		}
		                  
						
						

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//test.log(LogStatus.FAIL, "New Loan is failed");

			}
	
}
	
}

