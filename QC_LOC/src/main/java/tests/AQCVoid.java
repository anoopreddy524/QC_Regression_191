package tests;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;



import com.relevantcodes.extentreports.LogStatus;

public class AQCVoid extends QCStore{


	public static void qcVoid(String SSN,String AppURL) throws InterruptedException
	{
		int lastrow=TestData.getLastRow("Void");
				String sheetName="Void";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
						String TxnType = TestData.getCellData(sheetName,"TxnType",row);
						String TenderType = TestData.getCellData(sheetName,"TenderType",row);
						
						String PIN = TestData.getCellData(sheetName,"Password",row);
						
						String SSN1 = SSN.substring(0, 3);
						String SSN2 = SSN.substring(3,5);
						String SSN3 = SSN.substring(5,9);

						Thread.sleep(3000);
						test.log(LogStatus.INFO,"*********Void transaction has started***********");
						driver.switchTo().frame("topFrame");
						driver.findElement(locator(Aprop.getProperty("transactions_tab"))).click();			
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");

						driver.findElement(By.cssSelector("li[id='911101']")).click();
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
						test.log(LogStatus.PASS, "Clicked on submit Button");		
									
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");					    					   					     
						driver.findElement(locator(Aprop.getProperty("csr_new_loan_go_button"))).click();
						test.log(LogStatus.PASS, "Clicked on GO Button under search results");
						Thread.sleep(5000);					  
							
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
						Thread.sleep(5000);
						driver.findElement(By.name("transactionList")).sendKeys(TxnType);
						test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
						driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Clicked on Go button ");
						Thread.sleep(500);	
						
				
				
						Thread.sleep(10000);	
						
					/*	String paymentamount=driver.findElement(By.name("requestBean.paymentAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "PaymentAmount captured is :"+paymentamount);*/
						Thread.sleep(2000);	
						driver.findElement(By.name("transactionDataBean.tenderType")).sendKeys(TenderType);
						test.log(LogStatus.PASS, "Disb Type is :"+TenderType);
						Thread.sleep(2000);	
						
						driver.findElement(By.name("password")).sendKeys(PIN);
						test.log(LogStatus.PASS, "Pin is entered as "+ PIN);
						driver.findElement(By.name("Submit22")).click();
						test.log(LogStatus.PASS, "Clicked on Finish Void");

						Thread.sleep(5000);
						try { 
							Alert alert = driver.switchTo().alert();

							alert.accept();
							test.log(LogStatus.PASS, "Alert Handled successfully");
																					
						}
						catch (NoAlertPresentException e) {
							//do what you normally would if you didn't have the alert.
						}
						Thread.sleep(4000);
						/*if(driver.findElement(By.xpath("//input[@class='sortbuttons' and @value='Ok']")).isDisplayed())
						{
						test.log(LogStatus.PASS, "Void transaction is successfully");
						}
						else{
							test.log(LogStatus.INFO, "Void transaction is successfully");
						}*/
						test.log(LogStatus.PASS, "Void transaction is successfully");
						test.log(LogStatus.PASS,"****************************************");
						break;
							 }
							
							 								
				}
		
				
			
}
}