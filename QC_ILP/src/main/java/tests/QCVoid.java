package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCVoid extends QCStore{


	public static void qcVoid(String SSN,String AppURL) throws Exception
	{
		        int lastrow=TestData.getLastRow("Void");
				String sheetName="Void";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
				
					  String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String PIN = TestData.getCellData(sheetName,"PIN",row);
			      
			   
			        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			        String Scenario = TestData.getCellData(sheetName,"Scenario",row);
			    
			       String TenderType = TestData.getCellData(sheetName,"TenderType",row);
						   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					
					        
			       Thread.sleep(4000);
					//test.log(LogStatus.INFO, MarkupHelper.createLabel("Transaction Void has started", ExtentColor.BLUE));
					test.log(LogStatus.INFO, "Transaction Void has started");

					driver.switchTo().frame("bottom");
					String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					String store_date[]=Str_date.split(":");
					String business_date=store_date[1];
					test.log(LogStatus.PASS, "Business date is :"+business_date);
					
					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
					
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(1000);
				
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					
					driver.findElement(By.cssSelector("li[id='911101']")).click();			
					test.log(LogStatus.PASS, "Clicked on Transactions");		
					driver.switchTo().frame("main");		
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(By.name("ssn2")).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(By.name("ssn3")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(By.name("submit1")).click();
					test.log(LogStatus.PASS, "Click on submit Button");		
					for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
			
				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
					
					
				for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					   // driver.findElement(By.name("button")).click();
					    
					
						 {
						  driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						  // driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					    }
					   
					    
					    Thread.sleep(5000);
					   
						 driver.findElement(By.name("transactionList")).sendKeys(TxnType);
						 test.log(LogStatus.PASS, "Transaction Type is selected as "+TxnType);
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 Thread.sleep(3000);
		
						 for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
					
							
							 if(Scenario.equalsIgnoreCase("VoidLoan"))
							 {
								 
								 try { 
									 driver.findElement(By.name("tenderType")).sendKeys(TenderType);												
										
									}
									catch (Exception e) {
									    //do what you normally would if you didn't have the alert.
									}
								 try { 
									driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(TenderType);											
										
									}
									catch (Exception e) {
									    //do what you normally would if you didn't have the alert.
									}

								 
								 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);
							
							
								driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
								test.log(LogStatus.PASS, "Password is selected as "+PIN);
								driver.findElement(By.name("finish")).click();
								 																					
								 test.log(LogStatus.PASS, "Clicked on Void Payment button ");
							 }
							 else if(Scenario.equalsIgnoreCase("Refinance"))
							 {
								 driver.findElement(By.name("transactionDataBean.monetaryCd")).sendKeys(TenderType);
								// driver.findElement(By.name("transactionDataBean.disbursementType")).sendKeys(TenderType);--------------Prepayment
								 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								test.log(LogStatus.PASS, "Password is selected as "+PIN);
								driver.findElement(By.name("Submit23")).click();
										
									test.log(LogStatus.PASS, "Clicked on Finish Void Refinance button ");
									
							 }
							 else if(Scenario.equalsIgnoreCase("Deposit Void"))
							 {
								
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								test.log(LogStatus.PASS, "Password is selected as "+PIN);
								driver.findElement(By.name("finish")).click();
										
									test.log(LogStatus.PASS, "Clicked on Finish Void Deposit button ");
									
							 }
							 
							 else if(Scenario.equalsIgnoreCase("NSF Void"))
							 {
								 driver.findElement(By.name("transactionDataBean.disbursementType")).sendKeys(TenderType);
								// driver.findElement(By.name("transactionDataBean.disbursementType")).sendKeys(TenderType);--------------Prepayment
								 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								test.log(LogStatus.PASS, "Password is selected as "+PIN);
								driver.findElement(By.name("Submit22")).click();
										
									test.log(LogStatus.PASS, "Clicked on Finish Void button ");
									
							 }
							 else if(Scenario.equalsIgnoreCase("Void Refund"))
							 {
								 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
								// driver.findElement(By.name("transactionDataBean.disbursementType")).sendKeys(TenderType);--------------Prepayment
								 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);
								
								driver.findElement(By.name("finish")).click();
										
									test.log(LogStatus.PASS, "Clicked on Finish Void button ");
									
							 }
							 else 
							 {
								 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
								 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);
							 String Pmt= driver.findElement(By.xpath(" /html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[3]/td[1]")).getText();						
							 System.out.println(Pmt);
								driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Pmt);
								test.log(LogStatus.PASS, "Tender Amt is entered as "+Pmt);
								driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								test.log(LogStatus.PASS, "Password is selected as "+PIN);
								driver.findElement(By.name("Submit23")).click();
								 																					
								 test.log(LogStatus.PASS, "Clicked on Finish Void Loan button "); 
							 }
								 try { 
									    Alert alert = driver.switchTo().alert();
									    alert.accept();
									    //if alert present, accept and move on.														
										
									}
									catch (NoAlertPresentException e) {
									    //do what you normally would if you didn't have the alert.
									}
									
									for( String winHandle1 : driver.getWindowHandles())
									{
									    driver.switchTo().window(winHandle1);
									}			
									 driver.switchTo().defaultContent();
									 driver.switchTo().frame("mainFrame");
									 driver.switchTo().frame("main");
									 Thread.sleep(5000);
									 
										 //if(driver.findElement(By.name("checkno")).isDisplayed())
											{
												//test.log(LogStatus.PASS, MarkupHelper.createLabel("Void Loan is Completed Successfully ", ExtentColor.GREEN));
												test.log(LogStatus.PASS, "Void is Completed Successfully ");
												test.log(LogStatus.PASS, "**************************************");

												//driver.findElement(By.name("Ok")).click();
											}
											/*else
											{
												test.log(LogStatus.FAIL, "Void Loan is not Completed Successfully ");
											}*/
							
							
							 break;	
							 }
							
							 								
				}
		
				
	
		

	
}
}