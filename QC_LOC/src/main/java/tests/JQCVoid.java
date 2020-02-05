package tests;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCVoid extends QCStore{


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


			        String Scenario = TestData.getCellData(sheetName,"Scenario",row);
			    
			       String TenderType = TestData.getCellData(sheetName,"TenderType",row);
			       
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					
					        
			       Thread.sleep(4000);
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
					Thread.sleep(3000);
				
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
					Thread.sleep(3000);
					
				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
								    

						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					   
					   
					    
					     String loan_nbr= driver.findElement(locator(Aprop.getProperty("loan_nbr"))).getText();//Changed X-path in properties
						 test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						   
						 driver.findElement(By.name("transactionList")).sendKeys(TxnType);
						 test.log(LogStatus.PASS, "Transaction Type is selected as "+TxnType);
						 Thread.sleep(3000);
						 driver.findElement(By.xpath("//input[@value='Go' and @name='button']")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 Thread.sleep(10000);
						 
		
							
							 if(Scenario.equalsIgnoreCase("VoidLoan"))
							 {
								 //String LOCamount="520.00";
								 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
								 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);	
								 Thread.sleep(500);
								 String disbamt = driver.findElement(By.name("htmlPayAmt")).getAttribute("value");//Added
								test.log(LogStatus.PASS, "Paymentamt is :" + disbamt);
								Thread.sleep(500);
								driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(disbamt);
								test.log(LogStatus.PASS, "Tender Amt is entered as "+disbamt);
								Thread.sleep(500);
								driver.findElement(By.name("password")).sendKeys(PIN);
								test.log(LogStatus.PASS, "Password is selected as "+PIN);
								Thread.sleep(500);
								driver.findElement(By.name("Submit22")).click();
								 																					
								 test.log(LogStatus.PASS, "Clicked on Finish Void Loan button ");
							 }
							 
							 else if(Scenario.equalsIgnoreCase("Refinance"))
							 {
								 driver.findElement(By.name("transactionDataBean.monetaryCd")).sendKeys(TenderType);
								 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								test.log(LogStatus.PASS, "Password is selected as "+PIN);
								driver.findElement(By.name("Submit23")).click();
										
									test.log(LogStatus.PASS, "Clicked on Finish Void Refinance button ");
									
							 }
							 else if(Scenario.equalsIgnoreCase("Refinance_Void"))
							 {
								 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
								 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								test.log(LogStatus.PASS, "Password is selected as "+PIN);
								driver.findElement(By.name("Submit23")).click();
										
									test.log(LogStatus.PASS, "Clicked on Finish Void Refinance button ");
									
							 }
							 else if(Scenario.equalsIgnoreCase("Payment Void"))
							 {
								 driver.findElement(By.name("transactionDataBean.tenderType")).sendKeys(TenderType);
								 test.log(LogStatus.PASS, "Disb type is entered as "+TenderType);
								 driver.findElement(By.name("password")).sendKeys(PIN);
								 test.log(LogStatus.PASS, "Enter the password value as "+PIN);
								 driver.findElement(By.name("Submit22")).click();										
								 test.log(LogStatus.PASS, "Clicked on Finish Void Payment button ");
									
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
								 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								test.log(LogStatus.PASS, "Password is selected as "+PIN);
								driver.findElement(By.name("Submit22")).click();
										
									test.log(LogStatus.PASS, "Clicked on Finish Void button ");
									
							 }
							 else if(Scenario.equalsIgnoreCase("Void Refund"))
							 {
								 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
								 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);								
								driver.findElement(By.name("finish")).click();
										
									test.log(LogStatus.PASS, "Clicked on Finish Void button ");
									
							 }
							 else 
							 {
								 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
								 Thread.sleep(5000);
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
										// if(driver.findElement(By.xpath("//input[@onclick='finish()' and @class='sortbuttons']")).isDisplayed())
											{	
											 //Thread.sleep(3000);
											 //driver.findElement(By.xpath("//input[@onclick='finish()' and @class='sortbuttons']")).click();
												test.log(LogStatus.PASS, "<FONT color=green style=Arial> Void is Completed Successfully ");
												
												//driver.findElement(By.xpath("//input[@value='No' and @class='sortbuttons']")).click();
												test.log(LogStatus.PASS, "********************************************************");
											}
											//else
											{
												test.log(LogStatus.INFO, "<FONT color=green style=Arial>Void is  Completed Successfully ");
											}

						
					break;			 								
				}
		
				}

}
	public static void refinancestepupVoid(String SSN,String AppURL) throws Exception
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


			        String Scenario = TestData.getCellData(sheetName,"Scenario",row);
			    
			       String TenderType = TestData.getCellData(sheetName,"TenderType",row);
			       
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					
					        
			       Thread.sleep(4000);
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
					Thread.sleep(3000);
				
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
					Thread.sleep(1000);
					
				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
								    

						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					   
					   
					    
					     String loan_nbr= driver.findElement(locator(Aprop.getProperty("loan_nbr"))).getText();//Changed X-path in properties
						 test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						   
						 driver.findElement(By.name("transactionList")).sendKeys(TxnType);
						 test.log(LogStatus.PASS, "Transaction Type is selected as "+TxnType);
						 driver.findElement(By.xpath("//input[@value='Go' and @name='button']")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 Thread.sleep(5000);
						 
		
							
							 if(Scenario.equalsIgnoreCase("VoidLoan"))
							 {
								 //String LOCamount="520.00";
								 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
								 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);	
								 Thread.sleep(500);
								 String disbamt = driver.findElement(By.name("htmlPayAmt")).getAttribute("value");//Added
								test.log(LogStatus.PASS, "Paymentamt is :" + disbamt);
								Thread.sleep(500);
								driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(disbamt);
								test.log(LogStatus.PASS, "Tender Amt is entered as "+disbamt);
								Thread.sleep(500);
								driver.findElement(By.name("password")).sendKeys(PIN);
								test.log(LogStatus.PASS, "Password is selected as "+PIN);
								Thread.sleep(500);
								driver.findElement(By.name("Submit22")).click();
								 																					
								 test.log(LogStatus.PASS, "Clicked on Finish Void Loan button ");
							 }
							 
							 else if(Scenario.equalsIgnoreCase("Refinance"))
							 {
								 driver.findElement(By.name("transactionDataBean.monetaryCd")).sendKeys(TenderType);
								 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								test.log(LogStatus.PASS, "Password is selected as "+PIN);
								driver.findElement(By.name("Submit23")).click();
										
									test.log(LogStatus.PASS, "Clicked on Finish Void Refinance button ");
									
							 }
							 else if(Scenario.equalsIgnoreCase("Refinance_Void"))
							 {
								 //driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
								 //test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								test.log(LogStatus.PASS, "Password is selected as "+PIN);
								driver.findElement(By.name("Submit23")).click();
										
									test.log(LogStatus.PASS, "Clicked on Finish Void Refinance button ");
									
							 }
							 else if(Scenario.equalsIgnoreCase("Payment Void"))
							 {
								 driver.findElement(By.name("transactionDataBean.tenderType")).sendKeys(TenderType);
								 test.log(LogStatus.PASS, "Disb type is entered as "+TenderType);
								 driver.findElement(By.name("password")).sendKeys(PIN);
								 test.log(LogStatus.PASS, "Enter the password value as "+PIN);
								 driver.findElement(By.name("Submit22")).click();										
								 test.log(LogStatus.PASS, "Clicked on Finish Void Payment button ");
									
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
								 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								test.log(LogStatus.PASS, "Password is selected as "+PIN);
								driver.findElement(By.name("Submit22")).click();
										
									test.log(LogStatus.PASS, "Clicked on Finish Void button ");
									
							 }
							 else if(Scenario.equalsIgnoreCase("Void Refund"))
							 {
								 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
								 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);								
								driver.findElement(By.name("finish")).click();
										
									test.log(LogStatus.PASS, "Clicked on Finish Void button ");
									
							 }
							 else 
							 {
								 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
								 Thread.sleep(5000);
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
										// if(driver.findElement(By.xpath("//input[@onclick='finish()' and @class='sortbuttons']")).isDisplayed())
											{	
											 //Thread.sleep(3000);
											 //driver.findElement(By.xpath("//input[@onclick='finish()' and @class='sortbuttons']")).click();
												test.log(LogStatus.PASS, "<FONT color=green style=Arial> Void is Completed Successfully ");
												
												//driver.findElement(By.xpath("//input[@value='No' and @class='sortbuttons']")).click();
												test.log(LogStatus.PASS, "********************************************************");
											}
											//else
											{
												test.log(LogStatus.INFO, "<FONT color=green style=Arial>Void is  Completed Successfully ");
											}

						
					break;			 								
				}
		
				}
			
}	
	
	
	
}