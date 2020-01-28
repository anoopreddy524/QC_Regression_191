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
public class QCCSRDefault extends QCStore{
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;
	
	




public static void sdefault(String SSN,String AppURL)
	{
		 
		try{
			//String FileName= prop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Default");
				String sheetName="Default";

				for(int row=2;row<=lastrow;row++)
				{	
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					
					if(SSN.equals(RegSSN))
					{		
						State = TestData.getCellData(sheetName,"StateID",row);
						 //ProductID=TestData.getCellData(sheetName,"ProductID",row);
						//System.out.println(ProductID);
						 
		
						 SSN1 = SSN.substring(0, 3);
						 SSN2 = SSN.substring(3,5);
						 SSN3 = SSN.substring(5,9);
						
						 
						Thread.sleep(3000);
						test.log(LogStatus.INFO, "CSR Login For Default Process");
					    driver.switchTo().frame("topFrame");
						driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						
						driver.findElement(By.cssSelector("li[id='911101']")).click();			
						test.log(LogStatus.PASS, "Clicked on Transaction");		
						driver.switchTo().frame("main");	
						Thread.sleep(500);
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
						driver.findElement(locator(prop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
						driver.findElement(locator(prop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
						driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
						test.log(LogStatus.PASS, "Clicked on submit Button");		
						for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);				
					    driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");					    					   					     
					    driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
					    test.log(LogStatus.PASS, "Clicked on GO Button");
					    Thread.sleep(5000);					  
						for( String winHandle1 : driver.getWindowHandles())
						{
						    driver.switchTo().window(winHandle1);
						}			
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						 Thread.sleep(5000);
						 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						 test.log(LogStatus.PASS, "Clicked on GO Button");
						 Thread.sleep(500);
						 driver.findElement(By.name("transactionList")).sendKeys(TxnType);
						 test.log(LogStatus.PASS, "Transaction Type is selected as:" +TxnType);
						 Thread.sleep(500);
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button");
						 Thread.sleep(500);
						 
//-----------------------------------Colateral Types-----------------------------------------------------------
						 
						 if (ESign_CollateralType.equals("ACH")) {
							
							 if (Income_PayFrequency.equals("Monthly")) {	 
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 String MDefaultDate = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr[3]/td[4]")).getText();
								 System.out.println(MDefaultDate);
								 test.log(LogStatus.PASS, "2nd installment date is :"+MDefaultDate);
								 Thread.sleep(5000);
								 //driver.switchTo().frame("topFrame");
								 for( String winHandle1 : driver.getWindowHandles())
									{
									    driver.switchTo().window(winHandle1);
									}			
									 driver.switchTo().defaultContent();
									 driver.switchTo().frame("topFrame");
									 Thread.sleep(5000);
								 driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
								 test.log(LogStatus.PASS, "Clicked on Cash Management");
								 driver.switchTo().defaultContent();
								driver.switchTo().frame("mainFrame");	
								Thread.sleep(5000);
								driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
								test.log(LogStatus.PASS, "Clicked on Start Scheduler");
								Thread.sleep(5000);
								for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								String Due_Date[] =MDefaultDate.split("/");
						        String Due_Date1 = Due_Date[0];
						        String Due_Date2 = Due_Date[1];
						        String Due_Date3 = Due_Date[2];
						        driver.findElement(By.name("endMonth")).sendKeys(Due_Date1);
						        test.log(LogStatus.PASS, "Month is entered: "+Due_Date1);
								driver.findElement(By.name("endDay")).sendKeys(Due_Date2);
								test.log(LogStatus.PASS, "Date is entered: "+Due_Date2);
								driver.findElement(By.name("endYear")).sendKeys(Due_Date3);
								test.log(LogStatus.PASS, "Year is entered: "+Due_Date3);
								driver.findElement(By.name("runSchedulerBtn")).click();
								test.log(LogStatus.PASS, "Clicked on Run Scheduler");
								Thread.sleep(500);
								 //String alert1=   driver.switchTo().alert().getText();
								 //test.log(LogLogStatus.PASS, "Clicked on Finish Loan: "+alert1);
								 
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
								 //test.log(LogStatus.PASS, "Clicked on Scheduler Ok");
								 test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
								 Thread.sleep(5000);
								 driver.close();
								 
							 
							}
							 else{
								 String DefaultDate = driver.findElement(By.xpath("//*[@id='achHistoryTable']/tbody/tr[4]/td[4]")).getText();	 
								 System.out.println(DefaultDate);
								 test.log(LogStatus.PASS, "3rd installment date is :"+DefaultDate);
								 Thread.sleep(5000);
								 //driver.switchTo().frame("topFrame");
								 for( String winHandle1 : driver.getWindowHandles())
									{
									    driver.switchTo().window(winHandle1);
									}			
									 driver.switchTo().defaultContent();
									 driver.switchTo().frame("topFrame");
									 Thread.sleep(5000);
								 driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
								 test.log(LogStatus.PASS, "Clicked on Cash Management");
								 driver.switchTo().defaultContent();
								driver.switchTo().frame("mainFrame");	
								Thread.sleep(5000);
								driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
								test.log(LogStatus.PASS, "Clicked on Start Scheduler");
								Thread.sleep(5000);
								for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								String Due_Date[] =DefaultDate.split("/");
						        String Due_Date1 = Due_Date[0];
						        String Due_Date2 = Due_Date[1];
						        String Due_Date3 = Due_Date[2];
						        driver.findElement(By.name("endMonth")).sendKeys(Due_Date1);
						        test.log(LogStatus.PASS, "Month is entered: "+Due_Date1);
								driver.findElement(By.name("endDay")).sendKeys(Due_Date2);
								test.log(LogStatus.PASS, "Date is entered: "+Due_Date2);
								driver.findElement(By.name("endYear")).sendKeys(Due_Date3);
								test.log(LogStatus.PASS, "Year is entered: "+Due_Date3);
								driver.findElement(By.name("runSchedulerBtn")).click();
								test.log(LogStatus.PASS, "Clicked on Run Scheduler");
								Thread.sleep(500);
								 //String alert1=   driver.switchTo().alert().getText();
								 //test.log(LogLogStatus.PASS, "Clicked on Finish Loan: "+alert1);
								 
								 try { 
									    Alert alert = driver.switchTo().alert();
									
									    alert.accept();
									    //if alert present, accept and move on.														
										
									}
									catch (NoAlertPresentException e) {
									    //do what you normally would if you didn't have the alert.
									}
								 Thread.sleep(5000);
								 WebDriverWait wait = new WebDriverWait(driver, 10000);	
								 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ok")));
								 Thread.sleep(5000);
								 driver.findElement(By.name("ok")).click();
								 //test.log(LogStatus.PASS, "Clicked on Scheduler Ok");
								 test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
								 Thread.sleep(5000);
								 driver.close();
							 }
								  
						 }
						 
						 if (ESign_CollateralType.equals("NO COLLATERAL")) {
								
							 if (Income_PayFrequency.equals("Monthly")) {	 
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 String MDefaultDate = driver.findElement(By.xpath("//*[@id='myTable1']/tbody[2]/tr[3]/td[2]")).getText();
								 System.out.println(MDefaultDate);
								 test.log(LogStatus.PASS, "2nd installment date is :"+MDefaultDate);
								 Thread.sleep(5000);
								 //driver.switchTo().frame("topFrame");
								 for( String winHandle1 : driver.getWindowHandles())
									{
									    driver.switchTo().window(winHandle1);
									}			
									 driver.switchTo().defaultContent();
									 driver.switchTo().frame("topFrame");
									 Thread.sleep(5000);
								 driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
								 test.log(LogStatus.PASS, "Clicked on Cash Management");
								 driver.switchTo().defaultContent();
								driver.switchTo().frame("mainFrame");	
								Thread.sleep(5000);
								driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
								test.log(LogStatus.PASS, "Clicked on Start Scheduler");
								Thread.sleep(5000);
								for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								String Due_Date[] =MDefaultDate.split("/");
						        String Due_Date1 = Due_Date[0];
						        String Due_Date2 = Due_Date[1];
						        String Due_Date3 = Due_Date[2];
						        driver.findElement(By.name("endMonth")).sendKeys(Due_Date1);
						        test.log(LogStatus.PASS, "Month is entered: "+Due_Date1);
								driver.findElement(By.name("endDay")).sendKeys(Due_Date2);
								test.log(LogStatus.PASS, "Date is entered: "+Due_Date2);
								driver.findElement(By.name("endYear")).sendKeys(Due_Date3);
								test.log(LogStatus.PASS, "Year is entered: "+Due_Date3);
								driver.findElement(By.name("runSchedulerBtn")).click();
								test.log(LogStatus.PASS, "Clicked on Run Scheduler");
								Thread.sleep(500);
								 //String alert1=   driver.switchTo().alert().getText();
								 //test.log(LogLogStatus.PASS, "Clicked on Finish Loan: "+alert1);
								 
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
								 //test.log(LogStatus.PASS, "Clicked on Scheduler Ok");
								 test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
								 Thread.sleep(5000);
								 driver.close();
								 
							 
							}
							 else{
								 String DefaultDate = driver.findElement(By.xpath("//*[@id='myTable1']/tbody[2]/tr[4]/td[2]")).getText();	
								
								 System.out.println(DefaultDate);
								 test.log(LogStatus.PASS, "3rd installment date is :"+DefaultDate);
								 Thread.sleep(5000);
								 //driver.switchTo().frame("topFrame");
								 for( String winHandle1 : driver.getWindowHandles())
									{
									    driver.switchTo().window(winHandle1);
									}			
									 driver.switchTo().defaultContent();
									 driver.switchTo().frame("topFrame");
									 Thread.sleep(5000);
								 driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
								 test.log(LogStatus.PASS, "Clicked on Cash Management");
								 driver.switchTo().defaultContent();
								driver.switchTo().frame("mainFrame");	
								Thread.sleep(5000);
								driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
								test.log(LogStatus.PASS, "Clicked on Start Scheduler");
								Thread.sleep(5000);
								for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								String Due_Date[] =DefaultDate.split("/");
						        String Due_Date1 = Due_Date[0];
						        String Due_Date2 = Due_Date[1];
						        String Due_Date3 = Due_Date[2];
						        driver.findElement(By.name("endMonth")).sendKeys(Due_Date1);
						        test.log(LogStatus.PASS, "Month is entered: "+Due_Date1);
								driver.findElement(By.name("endDay")).sendKeys(Due_Date2);
								test.log(LogStatus.PASS, "Date is entered: "+Due_Date2);
								driver.findElement(By.name("endYear")).sendKeys(Due_Date3);
								test.log(LogStatus.PASS, "Year is entered: "+Due_Date3);
								driver.findElement(By.name("runSchedulerBtn")).click();
								test.log(LogStatus.PASS, "Clicked on Run Scheduler");
								Thread.sleep(500);
								 //String alert1=   driver.switchTo().alert().getText();
								 //test.log(LogLogStatus.PASS, "Clicked on Finish Loan: "+alert1);
								 
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
								 //test.log(LogStatus.PASS, "Clicked on Scheduler Ok");
								 test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
								 Thread.sleep(5000);
								 driver.close();
							 }
								  
						 }
						 
						 if (ESign_CollateralType.equals("DEBIT CARD")) {
								
							 if (Income_PayFrequency.equals("Monthly")) {	 
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 String MDefaultDate = driver.findElement(By.xpath("//*[@id='myTable1']/tbody[2]/tr[3]/td[2]")).getText();
								 System.out.println(MDefaultDate);
								 test.log(LogStatus.PASS, "2nd installment date is :"+MDefaultDate);
								 Thread.sleep(5000);
								 //driver.switchTo().frame("topFrame");
								 for( String winHandle1 : driver.getWindowHandles())
									{
									    driver.switchTo().window(winHandle1);
									}			
									 driver.switchTo().defaultContent();
									 driver.switchTo().frame("topFrame");
									 Thread.sleep(5000);
								 driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
								 test.log(LogStatus.PASS, "Clicked on Cash Management");
								 driver.switchTo().defaultContent();
								driver.switchTo().frame("mainFrame");	
								Thread.sleep(5000);
								driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
								test.log(LogStatus.PASS, "Clicked on Start Scheduler");
								Thread.sleep(5000);
								for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								String Due_Date[] =MDefaultDate.split("/");
						        String Due_Date1 = Due_Date[0];
						        String Due_Date2 = Due_Date[1];
						        String Due_Date3 = Due_Date[2];
						        driver.findElement(By.name("endMonth")).sendKeys(Due_Date1);
						        test.log(LogStatus.PASS, "Month is entered: "+Due_Date1);
								driver.findElement(By.name("endDay")).sendKeys(Due_Date2);
								test.log(LogStatus.PASS, "Date is entered: "+Due_Date2);
								driver.findElement(By.name("endYear")).sendKeys(Due_Date3);
								test.log(LogStatus.PASS, "Year is entered: "+Due_Date3);
								driver.findElement(By.name("runSchedulerBtn")).click();
								test.log(LogStatus.PASS, "Clicked on Run Scheduler");
								Thread.sleep(500);
								 //String alert1=   driver.switchTo().alert().getText();
								 //test.log(LogLogStatus.PASS, "Clicked on Finish Loan: "+alert1);
								 
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
								 //test.log(LogStatus.PASS, "Clicked on Scheduler Ok");
								 test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
								 Thread.sleep(5000);
								 driver.close();
								 
							 
							}
							 else{
								 String DefaultDate = driver.findElement(By.xpath("//*[@id='myTable1']/tbody[2]/tr[4]/td[2]")).getText();
								                                            
								                                                   
								 System.out.println(DefaultDate);
								 test.log(LogStatus.PASS, "3rd installment date is :"+DefaultDate);
								 Thread.sleep(5000);
								 //driver.switchTo().frame("topFrame");
								 for( String winHandle1 : driver.getWindowHandles())
									{
									    driver.switchTo().window(winHandle1);
									}			
									 driver.switchTo().defaultContent();
									 driver.switchTo().frame("topFrame");
									 Thread.sleep(5000);
								 driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
								 test.log(LogStatus.PASS, "Clicked on Cash Management");
								 driver.switchTo().defaultContent();
								driver.switchTo().frame("mainFrame");	
								Thread.sleep(5000);
								driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
								test.log(LogStatus.PASS, "Clicked on Start Scheduler");
								Thread.sleep(5000);
								for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								String Due_Date[] =DefaultDate.split("/");
						        String Due_Date1 = Due_Date[0];
						        String Due_Date2 = Due_Date[1];
						        String Due_Date3 = Due_Date[2];
						        driver.findElement(By.name("endMonth")).sendKeys(Due_Date1);
						        test.log(LogStatus.PASS, "Month is entered: "+Due_Date1);
								driver.findElement(By.name("endDay")).sendKeys(Due_Date2);
								test.log(LogStatus.PASS, "Date is entered: "+Due_Date2);
								driver.findElement(By.name("endYear")).sendKeys(Due_Date3);
								test.log(LogStatus.PASS, "Year is entered: "+Due_Date3);
								driver.findElement(By.name("runSchedulerBtn")).click();
								test.log(LogStatus.PASS, "Clicked on Run Scheduler");
								Thread.sleep(500);
								 //String alert1=   driver.switchTo().alert().getText();
								 //test.log(LogLogStatus.PASS, "Clicked on Finish Loan: "+alert1);
								 
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
								 //test.log(LogStatus.PASS, "Clicked on Scheduler Ok");
								 test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
								 Thread.sleep(5000);
								 driver.close();
							 }
								  
						 }
						 
						 
						 
						 
						 
						 
	//==========================================================================================================					 
						 /*String NextDueDate = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form[1]/table[2]/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[2]/td[4]")).getText();
						 System.out.println(NextDueDate);
						 test.log(LogStatus.PASS, "DueDate is :"+NextDueDate);
						 Thread.sleep(5000);
						 //driver.switchTo().frame("topFrame");
						 for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("topFrame");
							 Thread.sleep(5000);
						 driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
						 test.log(LogStatus.PASS, "Clicked on Cash Management");
						 driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");	
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
						test.log(LogStatus.PASS, "Clicked on Start Scheduler");
						Thread.sleep(5000);
						for( String winHandle1 : driver.getWindowHandles())
						{
						    driver.switchTo().window(winHandle1);
						}			
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						String Due_Date[] =MDefaultDate.split("/");
				        String Due_Date1 = Due_Date[0];
				        String Due_Date2 = Due_Date[1];
				        String Due_Date3 = Due_Date[2];
				        driver.findElement(By.name("endMonth")).sendKeys(Due_Date1);
				        test.log(LogStatus.PASS, "Month is entered: "+Due_Date1);
						driver.findElement(By.name("endDay")).sendKeys(Due_Date2);
						test.log(LogStatus.PASS, "Date is entered: "+Due_Date2);
						driver.findElement(By.name("endYear")).sendKeys(Due_Date3);
						test.log(LogStatus.PASS, "Year is entered: "+Due_Date3);
						driver.findElement(By.name("runSchedulerBtn")).click();
						test.log(LogStatus.PASS, "Clicked on Run Scheduler");
						Thread.sleep(500);
						 //String alert1=   driver.switchTo().alert().getText();
						 //test.log(LogLogStatus.PASS, "Clicked on Finish Loan: "+alert1);
						 
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
						 //test.log(LogStatus.PASS, "Clicked on Scheduler Ok");
						 test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
						 Thread.sleep(5000);
						 driver.close();
		*/				}
					}
				}
		
		}
		                  
						
						/*for( String winHandle1 : driver.getWindowHandles())
						{
						    driver.switchTo().window(winHandle1);
						}			
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						 //	Selection of Product based on the Name provided in Test Data
						 if(driver.findElement(By.id("LoanButtonId")).isEnabled())
						 {
							 
						    WebElement htmltable=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table"));
						    													//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table
						    
							rows=htmltable.findElements(By.tagName("tr"));
							
							count=0;							
							 count=driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")).size();	
							 									//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[1]
							// System.out.println("current row num "+count);	
							// System.out.println(" rows num "+ rows.size());
								
														
													if(ProductID.equals("PDL"))
													 {
													 PDL();
													 break;
													 }
													 if(ProductID.equals("ILP"))
													 {
													 ILP();
													 break;
													 }
													 
													 if(ProductID.equals("TLP"))
													 {
													 TLP();
													 break;
													 }
													 if(ProductID.equals("LOC"))
													 {
													 LOC();
													 break;
													 }																																
												}
												
											}
							
							
					
						 	break;
						 	}
							
					}
			
			}*/

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				test.log(LogStatus.FAIL, "Duedate is failed");

			}
	
}
	
}

