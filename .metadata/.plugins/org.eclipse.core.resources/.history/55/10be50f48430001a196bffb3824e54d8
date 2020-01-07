package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class QCPayment extends QCStore
{

	public static void payment(String SSN,String AppURL) throws Exception
	{
		int i;
		for(i=0;i<3;i++)
		{
		
	try{
			int lastrow=TestData.getLastRow("Payment");
			String sheetName="Payment";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
									
					String PIN = TestData.getCellData(sheetName,"PIN",row);
			
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
					
					String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);
				
					String Scenario = TestData.getCellData(sheetName,"Scenario",row);
					String TxnType = TestData.getCellData(sheetName,"TxnType",row);

					 String SSN1 = SSN.substring(0, 3);
					 String SSN2 = SSN.substring(3,5);
					 String SSN3 = SSN.substring(5,9);
					
					Thread.sleep(3000);
					if(Scenario.equalsIgnoreCase("Partial_Return_Payment"))
					{
						test.log(LogStatus.INFO,"Partial Payment Return Payment started");
					}
					else
					{
						test.log(LogStatus.INFO,"Partial Payment started");	
					}
					
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
					/*for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);*/				
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");					    					   					     
				    driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				    test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				    Thread.sleep(5000);					  
					for( String winHandle1 : driver.getWindowHandles())
					{
					    driver.switchTo().window(winHandle1);
					}			;
					 driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					
					 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					 test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
					 Thread.sleep(5000);
					
						
					 if(Scenario.equalsIgnoreCase("Partial_Return_Payment"))
						{
						 driver.findElement(By.name("transactionList")).sendKeys(TxnType);
							test.log(LogStatus.PASS, "Transaction type is selected as "+TxnType);
							driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button");
						 Thread.sleep(500);	
						
						 driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(PaymentAmount);
						 test.log(LogStatus.PASS, "PaymentAmount entered :"+PaymentAmount);
						 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
						 test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
						 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(TenderAmount);
						 test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);
						 driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
						 test.log(LogStatus.PASS, "Pin is entered as "+ PIN);
						 driver.findElement(By.name("Submit22")).click();
						 test.log(LogStatus.PASS, "Clicked on Finish Partial Payment");
						}
						else
						{
							driver.findElement(By.name("transactionList")).sendKeys("Partial Payment");
							 test.log(LogStatus.PASS, "Transaction Type is selected as Partial Payment");
							 driver.findElement(By.name("button")).click();
							 test.log(LogStatus.PASS, "Clickexd on Go button");
							 Thread.sleep(500);	
							
							 driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(PaymentAmount);
							 test.log(LogStatus.PASS, "PaymentAmount entered :"+PaymentAmount);
							 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
							 test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
							 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(TenderAmount);
							 test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);
							 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
							 test.log(LogStatus.PASS, "Pin is entered");
							 driver.findElement(By.name("finish")).click();
							 test.log(LogStatus.PASS, "Clicked on Finish Partial Payment");
						}
					 
					
					
					 
					  Thread.sleep(5000);
					 try { 
						    Alert alert = driver.switchTo().alert();
						
						    alert.accept();
						    test.log(LogStatus.PASS, "Alert Handeld");
						    //if alert present, accept and move on.														
					 }
						catch (Exception e) {
						    //do what you normally would if you didn't have the alert.
						}
					 Thread.sleep(6000);
					 driver.findElement(By.name("checkyes")).click();
					 test.log(LogStatus.PASS, "Clicked on Yes button");
					 
					 //driver.findElement(By.name("checkno")).click();
					 //test.log(LogStatus.PASS, "BuyBack Completed Successfully");
					 test.log(LogStatus.PASS,"Partial Payment Completed Successfully");
					 test.log(LogStatus.PASS,"*******************************************");
					 //Thread.sleep(5000);

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
					String screenshotPath = getScreenhot(driver, "Payment");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					test.log(LogStatus.INFO, "Patial Payment process is initiated again due to Application sync issue");
					driver.get(prop.getProperty("login_page")); 
					continue;


				}

	}
		if(i==3)
		{
			test.log(LogStatus.FAIL, " Partail Payment setup is failed");
			Assert.assertTrue(false);
	
		}
	}
}
