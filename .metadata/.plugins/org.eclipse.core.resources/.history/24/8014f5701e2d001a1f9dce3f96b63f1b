package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class AQcEPP extends QCStore {

	 public static String month;
	 public static String day;
	 public static String year;
public static void epp(String SSN,String AppURL) throws InterruptedException
	{
	
			 test.log(LogStatus.PASS, "************EPP Transaction started****************");
		
	 
				int lastrow=TestData.getLastRow("EPP");
				String sheetName="EPP";

				for(int row=2;row<=lastrow;row++)
				{	
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					
					String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
					String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					if(SSN.equals(RegSSN))
					{		
						String SSN1 = SSN.substring(0, 3);
						String SSN2 = SSN.substring(3,5);
						String SSN3 = SSN.substring(5,9);
						
						 
						Thread.sleep(1000);
						test.log(LogStatus.INFO,"EPP started");
					   driver.switchTo().frame("topFrame");
						driver.findElement(locator(Aprop.getProperty("transactions_tab"))).click();			
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						
						driver.findElement(By.cssSelector("li[id='911101']")	).click();			
						test.log(LogStatus.PASS, "Clicked on Transaction");		
						driver.switchTo().frame("main");	
						Thread.sleep(500);
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
						driver.findElement(locator(Aprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
						driver.findElement(locator(Aprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
						driver.findElement(locator(Aprop.getProperty("csr_new_loan_submit_button"))).click();
						test.log(LogStatus.PASS, "Click on GO Button under search results");		
						for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);				
					    driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");					    					   					     
					    driver.findElement(locator(Aprop.getProperty("csr_new_loan_go_button"))).click();
					    test.log(LogStatus.PASS, "Clicked on GO Button");
					    Thread.sleep(2000);					  
								
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						
						 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						 test.log(LogStatus.PASS, "Click on GO Button under loan section");
						 Thread.sleep(1000);
						 driver.findElement(By.name("transactionList")).sendKeys(TxnType);
						 test.log(LogStatus.PASS, "Transaction Type is selected as EPP");
						 					 
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button");
						 Thread.sleep(3000);
						 try { 
							    Alert alert = driver.switchTo().alert();
							String almsg=alert.getText();
							test.log(LogStatus.PASS, "Alert with message"+almsg);
							    alert.accept();
							    test.log(LogStatus.PASS, "Alert handeld");
							    //if alert present, accept and move on.														
								
							}
							catch (NoAlertPresentException e) {
							    //do what you normally would if you didn't have the alert.
							}
						 Thread.sleep(500);	
						 
						 driver.findElement(By.name("paymentPlanFreq")).sendKeys(Income_PayFrequency);
						 
						 test.log(LogStatus.PASS, "Frequency Type is :"+Income_PayFrequency);
						 
						 driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table[3]/tbody/tr[6]/td[2]/input[1]")).click();
						 test.log(LogStatus.PASS, "Clicked on next button ");
						 Thread.sleep(2000);
						 test.log(LogStatus.PASS, "Getting First intallment date ");
						 
						 month=driver.findElement(By.xpath("//*[@id='payPlan']/div[1]/input")).getAttribute("value");
						 test.log(LogStatus.PASS, "Month is "+month);
						  day=driver.findElement(By.name("day0")).getAttribute("value");
						 test.log(LogStatus.PASS, "date is "+day);
						 year=driver.findElement(By.name("year0")).getAttribute("value");
						 test.log(LogStatus.PASS, "year is "+year);
						 
						
						 driver.findElement(By.name("chkgAcctNbr")).sendKeys(last4cheknum);
						 
						 test.log(LogStatus.PASS, "Checking account number  is :"+last4cheknum);
						 
						 driver.findElement(By.name("password")).sendKeys(PIN);
						 
						 test.log(LogStatus.PASS, "Pin is entered");
						 
						 driver.findElement(By.name("submitBtn")).click();
						 
						 test.log(LogStatus.PASS, "Clicked on Finished Extended payment Plan");
						 
						 
						 if(driver.findElement(By.name("checkyes")).isDisplayed())
							{
								test.log(LogStatus.PASS, "EPP Transaction Completed ");
								test.log(LogStatus.INFO, "**********************************************************************************");
								
							}
							else
							{
								test.log(LogStatus.FAIL, "EPP Transaction Failed ");
							}
					
						
						
					}
					}
				}
		
		
	
}


public static void scheduler() throws InterruptedException{
	
	try{
		/*String month="03";
	 String day="12";
	 String year="2018";*/
	test.log(LogStatus.INFO, "Performing scheduler to 1st installment date");
	 driver.switchTo().defaultContent();
		driver.switchTo().frame("topFrame");
		driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
		test.log(LogStatus.PASS, "Clicked on Cash Management");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");							
		driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
		test.log(LogStatus.PASS, "Clicked on Start Scheduler");
		Thread.sleep(3000);
		for( String winHandle1 : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle1);
		}			
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");
		
		driver.findElement(By.name("endMonth")).sendKeys(month);
		test.log(LogStatus.PASS, "Month is entered: "+month);
		driver.findElement(By.name("endDay")).sendKeys(day);
		test.log(LogStatus.PASS, "Date is entered: "+day);
		driver.findElement(By.name("endYear")).sendKeys(year);
		test.log(LogStatus.PASS, "Year is entered: "+year);
		driver.findElement(By.name("runSchedulerBtn")).click();
		test.log(LogStatus.PASS, "Clicked on Run Scheduler");
		Thread.sleep(500);
		//String alert1=   driver.switchTo().alert().getText();
		//test.log(LogStatus.PASS, "Clicked on Finish Loan: "+alert1);

		try { 
			Alert alert = driver.switchTo().alert();

			alert.accept();
			//if alert present, accept and move on.														

		}
		catch (NoAlertPresentException e) {
			//do what you normally would if you didn't have the alert.
		}
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 100000);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ok")));
		Thread.sleep(5000);
		driver.findElement(By.name("ok")).click();
		//test.log(Status.PASS, "Clicked on Scheduler Ok");
		test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "<FONT color=green>  ****Scheduler completed******");
		test.log(LogStatus.INFO, "Logout Successfully");
		driver.quit();}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		test.log(LogStatus.FAIL,"EPP Scheduler failed");

	}
}
}
