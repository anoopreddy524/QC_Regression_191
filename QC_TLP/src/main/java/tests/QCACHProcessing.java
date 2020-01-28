package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class QCACHProcessing extends QCStore {
	
	public static void ACHProcess(String SSN,String NextDueDate)
	{
		 
		try{
			int lastrow=TestData.getLastRow((prop.getProperty("Deposit")));
			String sheetName=prop.getProperty("Deposit");
			System.out.println("...."+sheetName);
				
			for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String StoreID = TestData.getCellData(sheetName,"StoreID",row);
					
					if(SSN.equals(RegSSN))
					{
							
			       Thread.sleep(4000);
					test.log(LogStatus.INFO, "ACH Processing through from Admin has initiated");
					driver.switchTo().defaultContent();	
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(prop.getProperty("admin_ACH_transaction"))).click();		
					test.log(LogStatus.PASS, "Clicked on Transactions");
					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
				
					 Actions action = new Actions(driver);  
					 WebElement ACH=driver.findElement(locator(prop.getProperty("admin_ACH_menu")));
					 action.moveToElement(ACH).build().perform();
					 test.log(LogStatus.PASS, " Mouse hover on ACH menu");
					 Thread.sleep(2000);
					 WebElement pdl=driver.findElement(locator(prop.getProperty("admin_pdl")));
					 action.moveToElement(pdl).build().perform();
					 test.log(LogStatus.PASS, " Mouse hover on payday loan menu");
					 Thread.sleep(3000);
					 driver.findElement(locator(prop.getProperty("admin_ACH_processing"))).click();
					 test.log(LogStatus.PASS, " click on ACH Processing");
					 Thread.sleep(3000);
					
				for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
				 driver.switchTo().defaultContent();
				 driver.switchTo().frame("mainFrame");
				 driver.switchTo().frame("main");
				 driver.findElement(locator(prop.getProperty("admin_str_nbr_btn"))).click();
				 driver.findElement(locator(prop.getProperty("admin_str_nbr"))).sendKeys(StoreID);
				 test.log(LogStatus.PASS, "StoreID is entered: "+StoreID);
				 System.out.println(NextDueDate);
				 test.log(LogStatus.PASS, "Age Store Date is :"+NextDueDate);
				 Thread.sleep(5000);
				 String Due_Date[] =NextDueDate.split("/");
			     String Due_Date1 = Due_Date[0];
			     String Due_Date2 = Due_Date[1];
			     String Due_Date3 = Due_Date[2];
			     driver.findElement(locator(prop.getProperty("bgn_mon"))).clear();
			     driver.findElement(locator(prop.getProperty("bgn_mon"))).sendKeys(Due_Date1);
			        test.log(LogStatus.PASS, "Begin Month is entered: "+Due_Date1);
			        driver.findElement(locator(prop.getProperty("bgn_date"))).clear();
			        driver.findElement(locator(prop.getProperty("bgn_date"))).sendKeys(Due_Date2);
					test.log(LogStatus.PASS, "Begin Date is entered: "+Due_Date2);
					driver.findElement(locator(prop.getProperty("bgn_year"))).clear();
					driver.findElement(locator(prop.getProperty("bgn_year"))).sendKeys(Due_Date3);
					test.log(LogStatus.PASS, "Begin Year is entered: "+Due_Date3);
					
					driver.findElement(locator(prop.getProperty("end_mon"))).clear();
					driver.findElement(locator(prop.getProperty("end_mon"))).sendKeys(Due_Date1);
			        test.log(LogStatus.PASS, "End Month is entered: "+Due_Date1);
			        driver.findElement(locator(prop.getProperty("end_date"))).clear();
			        driver.findElement(locator(prop.getProperty("end_date"))).sendKeys(Due_Date2);
					test.log(LogStatus.PASS, "End Date is entered: "+Due_Date2);
					driver.findElement(locator(prop.getProperty("end_year"))).clear();
					driver.findElement(locator(prop.getProperty("end_year"))).sendKeys(Due_Date3);
					test.log(LogStatus.PASS, "End Year is entered: "+Due_Date3); 
					driver.findElement(locator(prop.getProperty("admin_search"))).click();
					test.log(LogStatus.PASS, "Click on Submit button ");
					Thread.sleep(4000);
					driver.findElement(locator(prop.getProperty("ACH_process_now"))).click();
					test.log(LogStatus.PASS, "Clicked on ACH Process Now Successfully");
					 test.log(LogStatus.PASS, "********************************************** ");
					break;
						 
					}
				
					}
				
		
				
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.FAIL, "ACH Processing from Admin is failed");


		}




}

}
