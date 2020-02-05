package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
/*
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.LogStatus;

public class JQCEncryptionDetails extends QCStore{
	

	public static String encryption_transaction;
	public static String encryption_store;
	

	public static void readEncryptionDetails(String SSN,String AppURL) throws InterruptedException
	{
		 

				int lastrow=TestData.getLastRow("New_Loan");
				String sheetName="New_Loan";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					encryption_store_no="523";
							//TestData.getCellData(sheetName,"StoreID",row);
					if(SSN.equals(RegSSN))
					{


					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					  			       
					
			       Thread.sleep(4000);
					test.log(LogStatus.INFO, "Getting required details for encryption Key from CSR has initiated");

					driver.switchTo().frame("bottom");
					String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					String store_date[]=Str_date.split(":");
					test.log(LogStatus.PASS, ""+Str_date);
					
					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
		
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
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
			
				    String mainwindow=driver.getWindowHandle();
				    driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).click();
				    test.log(LogStatus.PASS, "Clicked on Customer number link");
				    for(String winHandle : driver.getWindowHandles()){
						if(!mainwindow.equalsIgnoreCase(winHandle))
						{
					    driver.switchTo().window(winHandle);
					    
						
					    String loan_nbr= driver.findElement(By.xpath("//*[@id='all']/div[1]/table[1]/tbody/tr[3]/td[2]")).getText();
						test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
					    NextDueDate= driver.findElement(By.xpath("//*[@id='all']/div[1]/table[1]/tbody/tr[3]/td[5]")).getText();
				        test.log(LogStatus.PASS, "Next due date is "+NextDueDate);
				        Thread.sleep(5000);
				        driver.close();
						break;
						}
				    }
					
					
						driver.switchTo().window(mainwindow);
					
					
					
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
					   driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					   test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					   
					    Thread.sleep(5000);
					    
					    
						 driver.findElement(By.name("transactionList")).sendKeys("Void");
						 test.log(LogStatus.PASS, "Transaction Type is selected as Void");
						 Thread.sleep(5000);
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 Thread.sleep(8000);
		
						 for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							
							 encryption_transaction=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td")).getText();
							 String TranID0[] =encryption_transaction.split(":");
							 String TranID1 = TranID0[0];
							 System.out.println(TranID1);
								encryption_transaction_nbr = TranID0[1]; 
							test.log(LogStatus.PASS, "TranId captured:"+encryption_transaction_nbr); 
							test.log(LogStatus.PASS, "StoreId captured:"+encryption_store_no); 

									
						 driver.findElement(locator(Aprop.getProperty("encryption_no_btn"))).click();
						 test.log(LogStatus.PASS, "Clicked on No button under Encryption details");
						 test.log(LogStatus.PASS, "***************************************");
						 //driver.close();

				break;

					}
									}
		


	}
				
	 
					}
				
		
	

