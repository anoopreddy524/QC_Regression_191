package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCClearDropdown extends QCStore {
	public static void clearDropDown(String SSN,String AppURL)
	{
		try{
			int lastrow=TestData.getLastRow((prop.getProperty("Clear")));
			String sheetName=prop.getProperty("Clear");
			System.out.println("...."+sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				System.out.println("...."+RegSSN);
				if(SSN.equals(RegSSN))
				{
				
				String PIN = TestData.getCellData(sheetName,"PIN#",row);
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);	      
		        String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
		        System.out.println(columnname);
		       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
		       Thread.sleep(4000);
				test.log(LogStatus.INFO, "Clear through from CSR has initiated");
				driver.switchTo().frame("bottom");
				String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
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
			    
			    driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button under search results");
				
			for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}				    
				 	driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
				    
				  if(ProductID.equals(prop.getProperty("PDL")))
					 {
					  driver.findElement(locator(prop.getProperty("clear_go"))).click();
					  test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    }
				    if(ProductID.equals(prop.getProperty("TLP")))
					 {
				    	driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
					 }
				    
				    Thread.sleep(5000);
				    if(ProductID.equals(prop.getProperty("LOC")))
					 {
				    		
				    	 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					 }
	
				     String loan_nbr= driver.findElement(locator(prop.getProperty("csr_loan_nbr"))).getText();
					  test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
					   driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						if(ESign_CollateralType.equalsIgnoreCase("CHECK"))
						{
							for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 driver.findElement(locator(prop.getProperty("transactionList"))).sendKeys("Clear Check");
							 test.log(LogStatus.PASS, "Transaction type is selected Clear Check");
							 driver.findElement(locator(prop.getProperty("go"))).click();
							 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");	
							 driver.findElement(locator(prop.getProperty("clear_pwd"))).sendKeys(PIN);
							 test.log(LogStatus.PASS, " Entered password");
							 driver.findElement(locator(prop.getProperty("clear_finish"))).click();
							 test.log(LogStatus.PASS, " cliked on finish Clear Check button");
							 Thread.sleep(3000);
							 if(driver.findElement(locator(prop.getProperty("clear_checkyes"))).isDisplayed())
							 	{						
								 test.log(LogStatus.PASS, ESign_CollateralType+" Clear dropdown from CSR is successfull");
								 test.log(LogStatus.PASS, "********************************************** ");								 
							 	}
							} 
							else if(ESign_CollateralType.equalsIgnoreCase("ACH"))
							{
								for( String winHandle1 : driver.getWindowHandles())
								{
								    driver.switchTo().window(winHandle1);
								}			
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 driver.findElement(locator(prop.getProperty("transactionList"))).sendKeys("ACH Clear");
								 test.log(LogStatus.PASS, "Transaction type is selected ACH Clear");
								 driver.findElement(locator(prop.getProperty("go"))).click();
								 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
								 Thread.sleep(2000);
								 driver.findElement(locator(prop.getProperty("deposit_check_box"))).click();
								 driver.findElement(locator(prop.getProperty("finish_ach_deposit"))).click();
								 Thread.sleep(2000);
								 if(driver.findElement(locator(prop.getProperty("success"))).isDisplayed())
								 	{						
									 test.log(LogStatus.PASS, ESign_CollateralType+ "Clear dropdown from CSR is successfull");
									 test.log(LogStatus.PASS, "********************************************** ");								 
								 	}
								}
						break;
				}
				
				 
			}
			
		}catch(Exception e){
						e.printStackTrace();
						test.log(LogStatus.FAIL, "Check Clear from CSR is failed");

		}
			
		
	}

}
