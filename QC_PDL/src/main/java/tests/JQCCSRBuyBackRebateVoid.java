package tests;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;


public class JQCCSRBuyBackRebateVoid extends QCStore{
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;
	public static String encryption_transaction;
	public static String encryption_store;

public static void buybackrebatevoid(String SSN,String AppURL) throws InterruptedException
	{
	int lastrow=TestData.getLastRow("BuyBackRebate_Void");
			String sheetName="BuyBackRebate_Void";

				for(int row=2;row<=lastrow;row++)
				{	
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String DisbType = TestData.getCellData(sheetName,"DisbType",row);
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
						Thread.sleep(3000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						Thread.sleep(3000);
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
						 Thread.sleep(5000);
						 driver.findElement(By.name("transactionList")).sendKeys("Void");
						 test.log(LogStatus.PASS, "Transaction Type is selected as Void");
						 Thread.sleep(5000);
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button");
				
						 Thread.sleep(3000);
							
						 for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 
							 
							 
							// encryption_date=driver.findElement(locator(prop.getProperty("encryption_date"))).getText();
							 encryption_transaction=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td")).getText();

									 //driver.findElement(locator(prop.getProperty("encryption_transaction_nbr"))).getText();
							// encryption_transaction_id=driver.findElement(locator(prop.getProperty("encryption_transaction_id"))).getText();
							 encryption_store=driver.findElement(locator(prop.getProperty("encryption_store_no"))).getText();
							// encryption_count=driver.findElement(locator(prop.getProperty("encryption_count"))).getText();
							System.out.println(encryption_transaction);
							String TranID0[] =encryption_transaction.split(":");

							String TranID1 = TranID0[0];

							encryption_transaction_nbr = TranID0[1]; 
						test.log(LogStatus.PASS,"TranId captured:"+encryption_transaction_nbr); 

						String StoreID0[] =encryption_store.split(":");

						String StoreID1 = StoreID0[0];

						encryption_store_no = StoreID0[1]; 
						test.log(LogStatus.PASS,"StoreId captured:"+encryption_store_no); 

								
					 //driver.findElement(locator(prop.getProperty("encryption_no_btn"))).click();
					 driver.findElement(By.name("NO")).click();
					 test.log(LogStatus.PASS, "Clicked on No button under Encryption details");
						 
						 driver.close();
			 
					
						}
					}
				}
		
			
}
	
}

