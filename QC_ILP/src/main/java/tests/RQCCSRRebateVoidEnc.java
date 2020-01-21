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
public class RQCCSRRebateVoidEnc extends QCStore{
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;
	public static String encryption_transaction;
	public static String encryption_store;
	
	
	
	



public static void rebatevoidenc(String SSN,String AppURL)
	{
		 
		try{
			//String FileName= prop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("BuyBackRebate_Void");
			String sheetName="BuyBackRebate_Void";

				for(int row=2;row<=lastrow;row++)
				{	
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					if(SSN.equals(RegSSN))
					{		
						State = TestData.getCellData(sheetName,"StateID",row);
						 //ProductID=TestData.getCellData(sheetName,"ProductID",row);
						//System.out.println(ProductID);
						 
		
						 SSN1 = SSN.substring(0, 3);
						 SSN2 = SSN.substring(3,5);
						 SSN3 = SSN.substring(5,9);
						
						 
						Thread.sleep(3000);
						test.log(LogStatus.INFO,"BuyBackRebate Void started");
					   driver.switchTo().frame("topFrame");
						driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						
						driver.findElement(locator(prop.getProperty("csr_transaction_link"))).click();			
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
						
						 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						 test.log(LogStatus.PASS, "Clicked on GO Button");
						 Thread.sleep(500);
						 driver.findElement(By.name("transactionList")).sendKeys("Void");
						 test.log(LogStatus.PASS, "Transaction Type is selected as Void");
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button");
						 //Thread.sleep(500);	
			  //Getting Encryption======================================================================
						 for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 driver.findElement(By.name("YES")).click();
							 //driver.findElement(locator(prop.getProperty("encryption_yes_btn"))).click();
							 test.log(LogStatus.PASS, "Clicked on Yes button under Encryption details");
						 
				//======================================================================================
						 Thread.sleep(500);
						 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
						 test.log(LogStatus.PASS, "Tender Type is :"+TenderType);	
						 for(String winHandle1 : driver.getWindowHandles()){
							    driver.switchTo().window(winHandle1);				
							    driver.switchTo().defaultContent();
							    driver.switchTo().frame("mainFrame");
							    driver.switchTo().frame("main");	
						 String Tenderamt = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]/b")).getText();
						 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Tenderamt);
						 Thread.sleep(500);
						 driver.findElement(By.name("transactionDataBean.encryptionKey")).sendKeys(Eankey);
						 test.log(LogStatus.PASS, "Encryption Key Entered :"+Eankey); 

						 //String Paymentamt = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
						 //test.log(LogStatus.PASS, "Payment amount is :"+Paymentamt);
						 //driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Paymentamt);
						 //test.log(LogStatus.PASS, "Tender amount entered :"+Paymentamt);
						 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
						 test.log(LogStatus.PASS, "Pin is entered");
						 driver.findElement(By.name("Submit23")).click();
						 test.log(LogStatus.PASS, "Clicked on Finish Void");
						 Thread.sleep(5000);
						 try { 
							    Alert alert = driver.switchTo().alert();
							
							    alert.accept();
							    //if alert present, accept and move on.														
								
							}
							catch (NoAlertPresentException e) {
							    //do what you normally would if you didn't have the alert.
							}
						 Thread.sleep(5000);
						 driver.findElement(By.name("checkno")).click();
						 //test.log(LogStatus.PASS, "BuyBack Completed Successfully");
						 test.log(LogStatus.PASS,"BuyBackRebate Void Completed Successfully With Encryption Key");
						 Thread.sleep(5000);
						 
			
						}
					}
				}
		
		}
		}
		                  
						
					

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				test.log(LogStatus.FAIL,"Void is failed");

			}
	
}
	
}

