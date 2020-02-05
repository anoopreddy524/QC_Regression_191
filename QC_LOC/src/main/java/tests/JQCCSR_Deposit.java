package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCCSR_Deposit extends QCStore{

	public static void deposit(String SSN,String AppURL)
	{
		int i;
		for(i=0;i<3;i++)
		{
			
			driver.get(csrloginpage); 
		try{
			//String FileName= Jprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
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
			        String DepositType = TestData.getCellData(sheetName,"DepositType",row);
			       
			        
			        String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
			      
			       String Ctc_PrimaryPhone = TestData.getCellData(sheetName,"Ctc_PrimaryPhone",row);
			       String Ctc_PhoneType = TestData.getCellData(sheetName,"Ctc_PhoneType",row);
			 
			       String Esign_CollateralType = TestData.getCellData(sheetName,"Esign_CollateralType",row);
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
					business_date=store_date[1];
					test.log(LogStatus.PASS, ""+Str_date);
					
					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					Thread.sleep(3000);
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
					/*driver.switchTo().defaultContent();				
					driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();	*/		
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
					for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}
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
					   // driver.findElement(By.name("button")).click();
					    
					  if(ProductID.equals("PDL"))
						 {
					    //driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					    }
					    if(ProductID.equals("TLP"))
						 {
					    	driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
						 }
					    
					    Thread.sleep(5000);
					    if(ProductID.equals("LOC"))
						 {
					    		
					    	driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						 }
		
					    
					       loan_number=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")).getText();
					       
						   test.log(LogStatus.PASS, "Loan Number is " + loan_number);
						   driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
						
					
															
							
							if(Esign_CollateralType.equalsIgnoreCase("ACH"))
							{
								for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 driver.findElement(By.name("transactionList")).sendKeys(Esign_CollateralType+" Deposit");
								 test.log(LogStatus.PASS, "Transaction type is selected "+Esign_CollateralType+" Deposit");
								 //driver.findElement(By.id("go_Button")).click();
								 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
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
									 driver.findElement(By.name("ok")).click();
									 //test.log(LogStatus.PASS, "ACH Deposit Completed Successfully");
								test.log(LogStatus.PASS, Esign_CollateralType+" Deposit from CSR is successfull");
								test.log(LogStatus.PASS, "********************************************** ");
                                driver.close();
							}
							}
					
							
							if(Esign_CollateralType.equalsIgnoreCase("CHECK"))
							{
								for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 driver.findElement(By.name("transactionList")).sendKeys(Esign_CollateralType+" Deposit");
								 test.log(LogStatus.PASS, "Transaction type is selected"+Esign_CollateralType+" Deposit");
								 driver.findElement(By.id("go_Button")).click();
								 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
								 
								 driver.findElement(By.name("transactionDataBean.chk21ReDepType")).sendKeys(DepositType);								 
								 test.log(LogStatus.PASS, "Deposit Type is :"+DepositType);
								
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								 test.log(LogStatus.PASS, " Entered password "+PIN);
								 
								 driver.findElement(By.name("finish")).click();
								 test.log(LogStatus.PASS, " Click on finish deposit button");
								 
								 if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
								 {

									 driver.findElement(By.name("ok")).click();
									 //test.log(LogStatus.PASS, "ACH Deposit Completed Successfully");
								test.log(LogStatus.PASS, Esign_CollateralType+" Deposit from CSR is successfull");
								test.log(LogStatus.PASS, "********************************************** ");
								 }
							}
							if(Esign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
							{
								for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 driver.findElement(By.name("transactionList")).sendKeys(Esign_CollateralType+" Deposit");
								 test.log(LogStatus.PASS, "Transaction type is selected"+Esign_CollateralType+" Deposit");
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
								
								test.log(LogStatus.PASS, Esign_CollateralType+" Deposit from CSR is successfull");
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
			test.log(LogStatus.INFO,""+e);
			test.log(LogStatus.INFO, "Deposit Dropdown from CSR is intiated again due to Application sync issue");
			continue;


		}


		}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "Deposit through dropdown is failed");
	
		}
}
}






