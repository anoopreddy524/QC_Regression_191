package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCAgeStoreVoid extends QCStore{
	

	public static void ageStoreVoid(String SSN,String AppURL) throws Exception
	{
		int i;
		for(i=0;i<3;i++)
		{
			
			driver.get(prop.getProperty("login_page"));  
		try{
			//String FileName= prop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Void");
				String sheetName="Void";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
					
					String PIN = TestData.getCellData(sheetName,"PIN",row);
			       // System.out.println(Password);
			
			        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		
			        String TxnType = TestData.getCellData(sheetName,"TxnType",row);
		
		
	
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
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
					    driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
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
					   
						/*for( String winHandle1 : driver.getWindowHandles())
						{
						    driver.switchTo().window(winHandle1);
						}			
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");*/

						 
					     String loan_nbr= driver.findElement(locator(prop.getProperty("csr_loan_nbr"))).getText();
						   test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
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
							 if(ProductID.equals("LOC"))
							 {
								 driver.findElement(By.name("password")).sendKeys(PIN);
								 driver.findElement(By.name("Submit22")).click();
								 test.log(LogStatus.PASS, "Password is selected as "+PIN);																					
									test.log(LogStatus.PASS, "Clicked on Finish Void Loan button ");
									
									
									
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
									 if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td[1]/input")).isDisplayed())
										{
										 test.log(LogStatus.PASS, "Void Loan is Completed Successfully ");
											driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td[1]/input")).click();
										}
									 else
										{
											test.log(LogStatus.FAIL, "Void Loan is not Completed Successfully ");
										}
								 
						    	
							 }
							 if(ProductID.equals("PDL"))
							 {

								 driver.findElement(locator(prop.getProperty("encryption_yes_btn"))).click();
								 test.log(LogStatus.PASS, "Clicked on Yes button under Encryption details");
								 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
							 String Pmt= driver.findElement(By.xpath(" /html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[3]/td[1]")).getText();						
							 System.out.println(Pmt);
								driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Pmt);
								test.log(LogStatus.PASS, "Tender Amt is entered as "+Pmt);
								

								driver.findElement(By.name("transactionDataBean.encryptionKey")).sendKeys(Eankey);

								test.log(LogStatus.PASS, "Encryption key is entered as "+Eankey);
								
								driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								 driver.findElement(By.name("Submit23")).click();
								 test.log(LogStatus.PASS, "Password is selected as "+PIN);																					
								 test.log(LogStatus.PASS, "Clicked on Finish Void Loan button ");
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
									 
										 if(driver.findElement(By.name("checkyes")).isDisplayed())
											{
												//test.log(LogStatus.PASS, MarkupHelper.createLabel("Age Store Void Loan is Completed Successfully ", ExtentColor.GREEN));
												test.log(LogStatus.PASS, "Age Store Void Loan is Completed Successfully ");
												test.log(LogStatus.PASS, "***************************************** ");

												driver.findElement(By.name("checkyes")).click();
											}
											else
											{
												test.log(LogStatus.FAIL, "Void Loan is not Completed Successfully ");
											}
							 }
							 if(ProductID.equals("TLP"))
							 {
							 driver.findElement(By.name("tenderType")).sendKeys(TenderType);
							 driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
						    	driver.findElement(By.name("finish")).click();
						    	test.log(LogStatus.PASS, "Password is selected as "+PIN);																					
								test.log(LogStatus.PASS, "Clicked on Finish Void Loan button ");
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
										 if(driver.findElement(By.name("Ok")).isDisplayed())
											{
											// test.log(LogStatus.PASS, MarkupHelper.createLabel("Age Store Void Loan is Completed Successfully ",ExtentColor.GREEN));
											 test.log(LogStatus.PASS, "Age Store Void Loan is Completed Successfully ");
											 test.log(LogStatus.PASS, "**********************************************");


											 driver.findElement(By.name("Ok")).click();
											}
										 else
											{
												test.log(LogStatus.FAIL, "Age Store Void Loan is not Completed Successfully ");
											}
							 }
							
					break;			 								
				}
		
				}
				break;
		}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Age Store Void Trasaction is failed", ExtentColor.RED));
					//test.log(LogStatus.FAIL,"Age Store Void Trasaction is failed");
					test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
					String screenshotPath = getScreenhot(driver, "Exception");
									test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					test.log(LogStatus.INFO, "Age Store Void Trasaction process is initiated again due to Application sync issue");
					continue;


				}

	}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "Age store Due Date  is failed");
	
		}
}
}

