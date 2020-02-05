package tests;

import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class JQCEODDeposit extends QCStore{
	public static void eodDeposit(String SSN,String AppURL) throws InterruptedException, MalformedURLException
	{
			int lastrow=TestData.getLastRow("EOD_Deposit");
				String sheetName="EOD_Deposit";
			

				for(int row=2;row<=lastrow;row++)
				{		
										
						//test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR Application is launched", ExtentColor.BLUE));
						String RegSSN = TestData.getCellData(sheetName,"SSN",row);
						if(SSN.equals(RegSSN))
						{
						String UserName = "csr523";
								//TestData.getCellData(sheetName,"UserName",row);
						String Password = TestData.getCellData(sheetName,"Password",row);
						String PIN = TestData.getCellData(sheetName,"PIN",row);
				       // System.out.println(Password);
				        String StoreId = "523";
				        		//TestData.getCellData(sheetName,"StoreID",row);
				        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				        String CountofDollarCoins = TestData.getCellData(sheetName,"CountofDollarCoins",row);
				       
				     
							   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
						       String SSN1 = SSN.substring(0, 3);
						        String SSN2 = SSN.substring(3,5);
						        String SSN3 = SSN.substring(5,9);
						  	       
						 
						        
				       Thread.sleep(4000);
						//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
						//test.log(LogStatus.INFO, "Age Store process is initiated");

				       test.log(LogStatus.INFO, "Drawer deassign and EOD deposit process" );
				       driver.switchTo().defaultContent();	
						
				        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
						driver.switchTo().frame("topFrame");
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
						 Thread.sleep(4000);
				        driver.findElement(By.cssSelector("li[id='910000']")).click();	
						
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");
						Thread.sleep(4000);
						
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
					    
					    String mainwindow1=driver.getWindowHandle();
			            customer_number=driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).getText();
			            test.log(LogStatus.PASS, "Customer Nbr is :" +customer_number);
					    driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).click();
					    test.log(LogStatus.PASS, "Clicked on Customer number link");
					    for(String winHandle : driver.getWindowHandles()){
							if(!mainwindow1.equalsIgnoreCase(winHandle))
							{
						    driver.switchTo().window(winHandle);
						    
							
						    //loan_number= driver.findElement(locator(Aprop.getProperty("csr_loan_nbr"))).getText();
						    loan_number=driver.findElement(By.xpath("//*[@id='all']/div[1]/table[1]/tbody/tr[3]/td[2]")).getText();
							test.log(LogStatus.PASS, "Loan Number is" + loan_number);
						    //NextDueDate= driver.findElement(locator(Aprop.getProperty("csr_due_date"))).getText();
							//NextDueDate=driver.findElement(By.xpath("//*[@id='all']/div[1]/table[1]/tbody/tr[3]/td[5]")).getText();
					        //test.log(LogStatus.PASS, "Next due date is "+NextDueDate);
					        driver.close();
							break;
							}
					    }
							driver.switchTo().window(mainwindow1);
					    
					    
					    
					
					   /* driver.findElement(By.name("button")).click();
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
						    	driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
							 }*/
						   
						
					    
					    
					   
					   //loan_number=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[2]")).getText();					   
					   //test.log(LogStatus.PASS, "Loan Number is" + loan_number);
					   Thread.sleep(10000);
						driver.switchTo().defaultContent();				
						driver.switchTo().frame("topFrame");
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Cash Management')]")));

						driver.findElement(By.xpath("//*[contains(text(),'Cash Management')]")).click();			
						test.log(LogStatus.PASS, "Clicked on Cash Management");
						Thread.sleep(4000);
					
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
				
						//driver.findElement(By.cssSelector("li[id='911101']")).click();	
						driver.findElement(By.linkText("Drawer")).click();
						test.log(LogStatus.PASS, "Clicked on Drawer");	
						Thread.sleep(1000);
						driver.findElement(By.linkText("Deassign")).click();
						test.log(LogStatus.PASS, "Clicked on Deassign");	
						Thread.sleep(1000);
						driver.switchTo().frame("main");		
						driver.findElement(By.name("drawerDeassignRequestBean.noOfDollars")).sendKeys(CountofDollarCoins);
						test.log(LogStatus.PASS, "Current Cash Balance is provided as "+CountofDollarCoins);	
						//driver.findElement(By.name("drawerDeassignRequestBean.currentCashBalance")).sendKeys("0");
						driver.findElement(By.name("drawerDeassignRequestBean.password")).sendKeys(Password);
						test.log(LogStatus.PASS, "Banker PIN# is enetered as"+Password);	
						driver.findElement(By.name("drawerdeassign")).click();
						test.log(LogStatus.PASS, "Click on Finish De-assign Button");
						try { 
							Alert alert = driver.switchTo().alert();
							alert.accept();
							//if alert present, accept and move on.														

						}
						catch (NoAlertPresentException e) {
							//do what you normally would if you didn't have the alert.
						}
						Thread.sleep(2000);
						driver.findElement(By.name("drawerDeassignRequestBean.noOfDollars")).clear();
						driver.findElement(By.name("drawerDeassignRequestBean.noOfDollars")).sendKeys(CountofDollarCoins);
						test.log(LogStatus.PASS, "Current Cash Balance is provided as "+CountofDollarCoins);	
						Thread.sleep(2000);
						driver.findElement(By.name("drawerDeassignRequestBean.password")).clear();	
						driver.findElement(By.name("drawerDeassignRequestBean.password")).sendKeys(Password);	
						test.log(LogStatus.PASS, "Passwrod entered as  "+Password);
						driver.findElement(By.name("drawerdeassign")).click();
						test.log(LogStatus.PASS, "Clicked on Drawer Deassign button");  
						try { 
							Alert alert = driver.switchTo().alert();
							alert.accept();
							//if alert present, accept and move on.														

						}
						catch (NoAlertPresentException e) {
							//do what you normally would if you didn't have the alert.
						}
						
						for(String winHandle : driver.getWindowHandles()){
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[3]/tbody/tr[9]/td[2]/table")).isDisplayed())
						{
							 WebElement htmltable=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[3]/tbody/tr[9]/td[2]/table"));	
							    
								List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
								System.out.println("current row num "+rows.size());
								int count=0;							
								 count=driver.findElements(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[3]/tbody/tr[9]/td[2]/table/tbody/tr")).size();				 				
								for(int rnum=1;rnum<rows.size();rnum++)
								{                      
									System.out.println("current row num "+rnum);						
								//List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));												
																	
									driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[3]/tbody/tr[9]/td[2]/table/tbody/tr[2]/td[5]/select")).sendKeys("Delete");
									driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[3]/tbody/tr[9]/td[2]/table/tbody/tr[2]/td[6]/input")).click();						
									try { 
										Alert alert = driver.switchTo().alert();
										alert.accept();
										//if alert present, accept and move on.														

									}
									catch (NoAlertPresentException e) {
										//do what you normally would if you didn't have the alert.
									}
									Thread.sleep(5000);
								}
						}
						String DrawerOverShortAmount =driver.findElement(By.name("drawerRequestBean.drawerOverShort")).getAttribute("value");
						driver.findElement(By.name("drawerRequestBean.amount")).sendKeys(DrawerOverShortAmount);
						test.log(LogStatus.PASS, "Amount entered as "+DrawerOverShortAmount);
						driver.findElement(By.name("drawerRequestBean.primary")).sendKeys("Cash Handling");
						test.log(LogStatus.PASS, "Primary Reason is selected as Cash Handling");
						driver.findElement(By.name("drawerRequestBean.notes")).sendKeys("Notes");
						test.log(LogStatus.PASS, "Notes Entered ");	
						driver.findElement(By.name("bt_AddDrawer")).click();
						test.log(LogStatus.PASS, "Click on Add O/S Instance Button");	
						Thread.sleep(5000);
						driver.findElement(By.name("transactionDataBean.password")).sendKeys(Password);
						test.log(LogStatus.PASS, "Entered Password as "+Password);
						Thread.sleep(8000);
						driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[4]/tbody/tr[3]/td[1]/input")).click();

						test.log(LogStatus.PASS, "Click on Finish Drawer O/S");
						try { 
							Alert alert = driver.switchTo().alert();
							alert.accept();
							//if alert present, accept and move on.														

						}
						catch (NoAlertPresentException e) {
							//do what you normally would if you didn't have the alert.
						}
						for(String winHandle : driver.getWindowHandles()){
							driver.switchTo().window(winHandle);
						}				    
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						Thread.sleep(5000);
						if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input")).isDisplayed())
						{

							test.log(LogStatus.PASS,"Drawer De-assigned successfully with over/short.");
							driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input")).click();
						}
						else
						{
							test.log(LogStatus.PASS,"Drawer not De-assigned successfully with over/short.");
						}
						
						Thread.sleep(5000);	    

						driver.switchTo().defaultContent();				
						driver.switchTo().frame("topFrame");
						driver.findElement(By.xpath("//*[contains(text(),'Daily Processing')]")).click();			
						test.log(LogStatus.PASS, "Clicked on Daily Processing");
						Thread.sleep(2000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						Thread.sleep(2000);
						driver.findElement(locator(Aprop.getProperty("daily_processing_start_eod"))).click();
						test.log(LogStatus.PASS, "Clicked on Start EOD processing");
						Thread.sleep(5000);
						String trans_nbr=driver.findElement(locator(Aprop.getProperty("daily_processing_trans_nbr"))).getText();	
						String trans_store=driver.findElement(locator(Aprop.getProperty("daily_processing_store_nbr"))).getText();	
						String transnbr[]=trans_nbr.split(":");
						encryption_transaction_nbr=transnbr[1];
						String transstr[]=trans_store.split(":");
						encryption_store_no=transstr[1];
						test.log(LogStatus.PASS, "Captured Transaction number is"+encryption_transaction_nbr);
						test.log(LogStatus.PASS, "Captured Store number is"+encryption_store_no);
						String mainwindow=driver.getWindowHandle();
						System.out.println("before CSR"+ mainwindow);
					
						//driver1 = new InternetExplorerDriver();	
						JQCAdminEncryption.getEncryption(driver,SSN, AppURL); 
						//AdminLoginForEncryption.getEncryption(driver,SSN, AppURL);
						//method for getting encryption from Admin
						//QCCSRLoginLogout.adminLogout(driver1,SSN, AppURL);				//Admin logout
						
		
// Switchign to CSR						
						
					
						Thread.sleep(2000);
							
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
						test.log(LogStatus.PASS, "Control switched to CSR page to enter Encryption key");
						driver.findElement(locator(Aprop.getProperty("daily_processing_ean_key"))).sendKeys(Eankey);
						test.log(LogStatus.PASS, "Entered the Encryption Key"+Eankey);
						driver.findElement(locator(Aprop.getProperty("daily_processing_yes_btn"))).click();
						test.log(LogStatus.PASS, "Clicked on Yes button");
						driver.findElement(locator(Aprop.getProperty("safe_balance_count_of_dollars_coins"))).sendKeys(CountofDollarCoins);
						test.log(LogStatus.PASS, "Entered in Count of Dollar coins field as "+CountofDollarCoins);
						driver.findElement(locator(Aprop.getProperty("safe_balance_EOD_comments"))).sendKeys("Test EOD");
						test.log(LogStatus.PASS, "Entered comment in Count of EOD comment field as :Test EOD");
						driver.findElement(locator(Aprop.getProperty("safe_balance_safe_bal_btn"))).click();
						test.log(LogStatus.PASS, "Clicked on Safe balance button");
						
						try{
							Thread.sleep(2000);
							driver.findElement(locator(Aprop.getProperty("over_or_short_comments"))).sendKeys("test");
						test.log(LogStatus.PASS, "Entered comment Over/short comment field as :test");
						Thread.sleep(2000);
						driver.findElement(locator(Aprop.getProperty("over_or_short_next_btn"))).click();
					test.log(LogStatus.PASS, "Clicked next under Over/short ");
						}
						catch(Exception e)
						{
							
						}
						
						Thread.sleep(3000);
						driver.findElement(locator(Aprop.getProperty("deposit_next_btn"))).click();
						//driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td[2]/input[3]")).click();

						test.log(LogStatus.PASS, "Clicked next under Deposit section ");
						try{
							driver.findElement(locator(Aprop.getProperty("deposit_checkbox"))).click();
						test.log(LogStatus.PASS, "Selected checkbox under Deposit section ");
						}
						catch(Exception e)
						{
							
						}
						Thread.sleep(5000);
						driver.findElement(locator(Aprop.getProperty("EOD_deposit_next_btn"))).click();
						test.log(LogStatus.PASS, "Clicked next under EOD Deposit section ");
						Thread.sleep(8000);
						driver.findElement(locator(Aprop.getProperty("deposit_verify_finish_btn"))).click();
						test.log(LogStatus.PASS, "Clicked next under Deposit verify section ");
						Thread.sleep(8000);
						Thread.sleep(8000);
						driver.findElement(locator(Aprop.getProperty("EOD_ok_btn"))).click();
						test.log(LogStatus.PASS, "Clicked ok button");
						test.log(LogStatus.PASS, "EODDeposit Completed successfully");
						Thread.sleep(5000);
						driver.close();
						Thread.sleep(5000);
						driver.quit();
			
						break;
					}
			
}
	
	
}
}

