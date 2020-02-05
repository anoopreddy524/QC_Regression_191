package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class VQCDepositDropdown extends QCStore{

	public static void depositDropDown(String SSN,String AppURL)
	{
		for(int i=0;i<3;i++)
		{
			
			//driver.get("http://192.168.2.203/cc/login/index.jsp"); 
		try{
			//String FileName= Vprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Deposit");
				String sheetName="Deposit";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
					
					String PIN = TestData.getCellData(sheetName,"PIN",row);
			       // System.out.println(Password);
		
			        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			        String StateID = TestData.getCellData(sheetName,"StateID",row);
			        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
			        
			        String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
			      
			       String Ctc_PrimaryPhone = TestData.getCellData(sheetName,"Ctc_PrimaryPhone",row);
			       String Ctc_PhoneType = TestData.getCellData(sheetName,"Ctc_PhoneType",row);
			 
			       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
			       String Disb_type = TestData.getCellData(sheetName,"Disb_type",row);
						   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					        String PP1 = Ctc_PrimaryPhone.substring(0, 3);
					        String PP2 = Ctc_PrimaryPhone.substring(3, 6);
					        String PP3 = Ctc_PrimaryPhone.substring(6, 10);
					   			       
					
			       Thread.sleep(4000);
					//test.log(LogStatus.INFO, MarkupHelper.createLabel("Deposit from CSR has initiated", ExtentColor.BLUE));
					test.log(LogStatus.INFO, "Deposit through dropdown from CSR has initiated");

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
				    
				    
				  // String loan_nbr= driver.findElement(locator(Vprop.getProperty("csr_loan_nbr"))).getText();
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
							    
							Thread.sleep(6000);
							    
							    
							driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
					     //String loan_nbr= driver.findElement(locator(Vprop.getProperty("csr_loan_nbr"))).getText();
						  // test.log(LogStatus.PASS, "Loan Number is " + loan_nbr);
						   driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
						
							
							// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Transactions')]")));
						    // driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();	
							// test.log(LogStatus.PASS, "Clicked on Transactions");
				
								//driver.switchTo().defaultContent();
								//driver.switchTo().frame("mainFrame");
								
							
							if(ESign_CollateralType.equalsIgnoreCase("ACH"))
							{
								for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
								 test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
								 Thread.sleep(8000);
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
								// test.log(LogStatus.PASS, " ACH Deposit completed sucessfully");
						
								//test.log(LogStatus.PASS, MarkupHelper.createLabel(ESign_CollateralType+" Deposit from CSR is successfull", ExtentColor.GREEN));
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
								 driver.findElement(By.name("transactionDataBean.chk21ReDepType")).sendKeys(Disb_type);
								 test.log(LogStatus.PASS, " Selected Deposit_Type as "+Disb_type);
								 
								/* driver.findElement(By.name("requestBean.chkName")).click();
								 test.log(LogStatus.PASS, " Selected checkbox under checks to be ACHD option");
								 driver.findElement(By.name("CmdReturnPosting")).click();
								 test.log(LogStatus.PASS, " clik on next button");
								 */
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								 test.log(LogStatus.PASS, " Entered password "+PIN);
								 
								 driver.findElement(By.name("finish")).click();
								 test.log(LogStatus.PASS, " Click on finish deposit button");
								 
								 if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
								 {
								// test.log(LogStatus.PASS, " ACH Deposit completed sucessfully");
						
								//test.log(LogStatus.PASS, MarkupHelper.createLabel(ESign_CollateralType+" Deposit from CSR is successfull", ExtentColor.GREEN));
								test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
								test.log(LogStatus.PASS, "********************************************** ");
								 }
							}
							if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
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

								 driver.findElement(By.name("requestBean.chkName")).click();
								 test.log(LogStatus.PASS, " Selected checkbox under checks to be ACHD option");
								 
								 
								 driver.findElement(By.name("CmdReturnPosting")).click();
								 test.log(LogStatus.PASS, " Clik on next button");
								 
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								 test.log(LogStatus.PASS, " Entered password");
								 
								 driver.findElement(By.name("Submit22")).click();
								 test.log(LogStatus.PASS, " Clik on finsish ACH deposit button");
								 
								 if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
								 {
								// test.log(LogStatus.PASS, ESign_CollateralType+" Deposit completed sucessfully");
						
								//test.log(LogStatus.PASS, MarkupHelper.createLabel(ESign_CollateralType+" Deposit from CSR is successfull", ExtentColor.GREEN));
								test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
								test.log(LogStatus.PASS, "********************************************** ");

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
			//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Deposit from CSR is failed", ExtentColor.RED));
			test.log(LogStatus.INFO, "Deposit Dropdown from CSR is intiated again due to Application sync issue");
			continue;


		}


		}

}
}






