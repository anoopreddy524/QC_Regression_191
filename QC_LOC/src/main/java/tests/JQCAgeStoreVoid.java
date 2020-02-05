package tests;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCAgeStoreVoid extends QCStore{
	

	public static void ageStoreVoid(String SSN,String AppURL) throws InterruptedException
	{
		
			int lastrow=TestData.getLastRow("Void");
				String sheetName="Void";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
					
					String PIN = TestData.getCellData(sheetName,"PIN",row);
		            String TxnType = TestData.getCellData(sheetName,"TxnType",row);
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
					
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");

						  driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					    
					    String loan_nbr= driver.findElement(locator(Aprop.getProperty("loan_nbr"))).getText();
						 test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
					
						 driver.findElement(By.name("transactionList")).sendKeys(TxnType);
						 test.log(LogStatus.PASS, "Transaction Type is selected as "+TxnType);
						 Thread.sleep(1000);
						 driver.findElement(By.xpath("//input[@value='Go' and @name='button']")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 Thread.sleep(2000);

						
								 driver.findElement(locator(Aprop.getProperty("encryption_yes_btn"))).click();
								 test.log(LogStatus.PASS, "Clicked on Yes button under Encryption details");
								 Thread.sleep(500);
								 
								 if(Scenario.equalsIgnoreCase("VoidLoan"))
								 {
								 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
								 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);
								 Thread.sleep(500);
								 
								 String disbamt = driver.findElement(By.name("htmlPayAmt")).getAttribute("value");//Added
									test.log(LogStatus.PASS, "Paymentamt is :" + disbamt);
									Thread.sleep(500);
									driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(disbamt);//Added
									test.log(LogStatus.PASS, "Tender Amt is entered as "+disbamt);
									Thread.sleep(500);
								 
								 								 
								driver.findElement(By.name("transactionDataBean.encryptionKey")).sendKeys(Eankey);
								test.log(LogStatus.PASS, "Encryption key is entered as "+Eankey);
								Thread.sleep(500);
								driver.findElement(By.name("password")).sendKeys(PIN);
								test.log(LogStatus.PASS, "Password is selected as "+PIN);
								
								driver.findElement(By.name("Submit22")).click(); 																				
								 test.log(LogStatus.PASS, "Clicked on Finish Void Loan button ");
								 
								 try { 
									    Alert alert = driver.switchTo().alert();
									    alert.accept();
									    //if alert present, accept and move on.														
										
									}
									catch (NoAlertPresentException e) {
									    //do what you normally would if you didn't have the alert.
									}
												
									 driver.switchTo().defaultContent();
									 driver.switchTo().frame("mainFrame");
									 driver.switchTo().frame("main");
									 
										if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr/td/b")).getText().contains("Successfully"))
											{
												test.log(LogStatus.PASS, "<FONT color=green style=Arial> Age Store Void Loan is Completed Successfully ");
												driver.findElement(By.xpath("//input[@value='Ok' and @class='sortbuttons']")).click();

											}
											else
											{
												test.log(LogStatus.INFO, "<FONT color=green style=Arial>Void Loan is not Completed Successfully ");
											}
								 }
								 else if(Scenario.equalsIgnoreCase("Payment Void"))
								 {
									 driver.findElement(By.name("transactionDataBean.tenderType")).sendKeys(TenderType);
									 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);
									
									driver.findElement(By.name("transactionDataBean.encryptionKey")).sendKeys(Eankey);
									test.log(LogStatus.PASS, "Encryption key is entered as "+Eankey);
									driver.findElement(By.name("password")).sendKeys(PIN);
									test.log(LogStatus.PASS, "Password is selected as "+PIN);
									
									driver.findElement(By.name("Submit22")).click(); 																				
									 test.log(LogStatus.PASS, "Clicked on Finish Void Loan button ");
									 
									 try { 
										    Alert alert = driver.switchTo().alert();
										    alert.accept();
										    //if alert present, accept and move on.														
											
										}
										catch (NoAlertPresentException e) {
										    //do what you normally would if you didn't have the alert.
										}
													
										 driver.switchTo().defaultContent();
										 driver.switchTo().frame("mainFrame");
										 driver.switchTo().frame("main");
										 
											if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/b")).getText().contains("Successfully"))
												{
													test.log(LogStatus.PASS, "<FONT color=green style=Arial> Age Store Void Loan is Completed Successfully ");
													driver.findElement(By.xpath("//input[@value='Ok' and @class='sortbuttons']")).click();

												}
												else
												{
													test.log(LogStatus.INFO, "<FONT color=green style=Arial>Void Loan is Completed Successfully ");
												}								
								 }
								
								
						
							
					break;			 								
				}
		
				}
		

				}

	
}


