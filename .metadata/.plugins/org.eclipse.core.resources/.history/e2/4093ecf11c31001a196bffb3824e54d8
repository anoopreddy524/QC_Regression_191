package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
/*
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCEncryptionDetails extends QCStore{
	

	public static String encryption_transaction;
	public static String encryption_store;
	

	public static void readEncryptionDetails(String SSN,String AppURL) throws Exception
	{
		 
		try{
			//String FileName= prop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("New_Loan");
				String sheetName="New_Loan";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
				
			        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					  			       
					
			       Thread.sleep(4000);
					//test.log(LogStatus.INFO, MarkupHelper.createLabel("Getting required details for encryption Key from CSR has initiated", ExtentColor.BLUE));
					test.log(LogStatus.INFO, "Getting required details for encryption Key from CSR has initiated");

					driver.switchTo().frame("bottom");
					String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					String store_date[]=Str_date.split(":");
					String business_date=store_date[1];
					test.log(LogStatus.PASS, ""+Str_date);
					
					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
					/*driver.switchTo().defaultContent();				
					driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();	*/		
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
				    
				    
				  // String loan_nbr= driver.findElement(locator(prop.getProperty("csr_loan_nbr"))).getText();
				  // test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
					// driver.findElement(By.name("button")).click();
					
				for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					   // driver.findElement(By.name("button")).click();
					    
					  if(ProductID.equals("PDL"))
						 {
						  driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						  // driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					    }
					    if(ProductID.equals("TLP"))
						 {
					    	driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
						 }
					    
					    Thread.sleep(5000);
					    if(ProductID.equals("LOC"))
						 {
					    	///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
					    	 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						 }
		
					     String loan_nbr= driver.findElement(locator(prop.getProperty("csr_loan_nbr"))).getText();
						   test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						 driver.findElement(By.name("transactionList")).sendKeys("Void");
						 test.log(LogStatus.PASS, "Transaction Type is selected as Void");
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
							//test.log(LogStatus.PASS, MarkupHelper.createLabel("TranId captured:"+encryption_transaction_nbr, ExtentColor.GREEN)); 
							test.log(LogStatus.PASS, "TranId captured:"+encryption_transaction_nbr); 


							String StoreID0[] =encryption_store.split(":");

							String StoreID1 = StoreID0[0];

							encryption_store_no = StoreID0[1]; 
							//test.log(LogStatus.PASS, MarkupHelper.createLabel("StoreId captured:"+encryption_store_no, ExtentColor.GREEN)); 
							test.log(LogStatus.PASS, "StoreId captured:"+encryption_store_no); 

									
						 driver.findElement(locator(prop.getProperty("encryption_no_btn"))).click();
						 test.log(LogStatus.PASS, "Clicked on No button under Encryption details");
						 test.log(LogStatus.PASS, "***************************************");
					

				break;

					}
									}
		}
							catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Reading Encryption from CSR is failed", ExtentColor.RED));
								test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
								String screenshotPath = getScreenhot(driver, "Exception");
												test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
								test.log(LogStatus.FAIL, "Reading Encryption from CSR is failed");


							}




	}
				
	 
					}
				
		
	

