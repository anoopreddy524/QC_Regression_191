package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCDepositDropdown extends QCStore{

	public static void depositDropDown(String SSN,String AppURL) throws InterruptedException
	{
		 
	
				int lastrow=TestData.getLastRow("Deposit");
				String sheetName="Deposit";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
					
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					String Deposit_Type = TestData.getCellData(sheetName,"RepresentmentType",row);
			       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);

					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);		       
					
			       Thread.sleep(2000);

					test.log(LogStatus.INFO, "Deposit through from CSR has initiated");

					driver.switchTo().frame("bottom");
					String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					test.log(LogStatus.PASS, ""+Str_date);
					
					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();		
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(2000);
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
				    
				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
					driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					    driver.findElement(By.xpath("//*[@value='Go' and@name='button']")).click();
					    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					   
					     loan_nbr= driver.findElement(locator(Jprop.getProperty("csr_loan_nbr"))).getText();
						   test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						   Thread.sleep(1000);
						   driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");

							if(ESign_CollateralType.equalsIgnoreCase("ACH"))
							{
								for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
							
								 driver.findElement(By.name("transactionList")).sendKeys(ESign_CollateralType+" Deposit");
								 test.log(LogStatus.PASS, "Transaction type is selected "+ESign_CollateralType+" Deposit");
								 driver.findElement(By.id("go_Button")).click();
								 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");

								 driver.findElement(By.name("requestBean.chkName")).click();
								 test.log(LogStatus.PASS, " Selected checkbox under Checks to be ACHD");
								 
								 
								 driver.findElement(By.name("CmdReturnPosting")).click();
								 test.log(LogStatus.PASS, " Cliked on next button");
								 
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								 test.log(LogStatus.PASS, " Entered password");
								 
								 driver.findElement(By.name("Submit22")).click();
								 test.log(LogStatus.PASS, " cliked on finish ACH deposit button");
								 
								 if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
								 {

								test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
								test.log(LogStatus.PASS, "********************************************** ");

							}else{
								Thread.sleep(100);
								test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
								test.log(LogStatus.PASS, "********************************************** ");
							}
							}
							
							if(ESign_CollateralType.equalsIgnoreCase("CHECK"))
							{
								for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 driver.findElement(By.name("transactionList")).sendKeys(ESign_CollateralType+" Deposit");
								 test.log(LogStatus.PASS, "Transaction type is selected"+ESign_CollateralType+" Deposit");
								 driver.findElement(By.id("go_Button")).click();
								 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
								 
								 driver.findElement(By.name("transactionDataBean.chk21ReDepType")).sendKeys(Deposit_Type);
								 test.log(LogStatus.PASS, " Select the Deposit_Type as"+Deposit_Type);
								
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								 test.log(LogStatus.PASS, " Entered password "+PIN);
								 
								 driver.findElement(By.name("finish")).click();
								 test.log(LogStatus.PASS, " click on finish deposit button");
								 
								 if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
								 {

								test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
								test.log(LogStatus.PASS, "********************************************** ");
								 }else{
									 Thread.sleep(100);
										test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
										test.log(LogStatus.PASS, "********************************************** ");
									}

							}
							if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
							{
								driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 driver.findElement(By.name("transactionList")).sendKeys("DebitCard Deposit");
								 test.log(LogStatus.PASS, "Transaction type is selected"+ESign_CollateralType+" Deposit");
								 driver.findElement(By.id("go_Button")).click();
								 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
								 driver.findElement(locator(Jprop.getProperty("ACH_process_now"))).click();
								 
								 test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
								 test.log(LogStatus.PASS, "********************************************** ");
								/* driver.findElement(By.name("requestBean.chkName")).click();
								 test.log(LogStatus.PASS, " Selected checkbox under checks to be ACHD option");
								 
								 
								 driver.findElement(By.name("CmdReturnPosting")).click();
								 test.log(LogStatus.PASS, " clik on next button");
								 
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								 test.log(LogStatus.PASS, " Entered password");
								 
								 driver.findElement(By.name("Submit22")).click();
								 test.log(LogStatus.PASS, " clik on finsish ACH deposit button");
								 
								 if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
								 {
								// test.log(LogStatus.PASS, ESign_CollateralType+" Deposit completed sucessfully");
						
								//test.log(LogStatus.PASS, MarkupHelper.createLabel(ESign_CollateralType+" Deposit from CSR is successfull", ExtentColor.GREEN));
								test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
								test.log(LogStatus.PASS, "********************************************** ");

							}*/
							}
						 
						 break;
						 
					}
				
					}
				
		
				
		
		




}
}






