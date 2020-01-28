package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class QCPrePaymentVoid extends QCStore{
	public static void prePaymentVoid(String SSN,String AppURL){
		try{
			int lastrow=TestData.getLastRow((prop.getProperty("Void")));
			String sheetName= prop.getProperty("Void");
			//test.log(LogStatus.PASS, "*****************"+sheetName);
			for(int row=2;row<=lastrow;row++)
			{
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String PIN = TestData.getCellData(sheetName,"PIN#",row);
					String DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
					

					DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);		       
					
			       Thread.sleep(4000);
			   	test.log(LogStatus.INFO, "PrePayment through from CSR has initiated");

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
				    if(ProductID.equals("PDL"))
					 {
				    driver.findElement(locator(prop.getProperty("go_button"))).click();
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
					   driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						
							for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 driver.findElement(By.name("transactionList")).sendKeys("Void");
							 test.log(LogStatus.PASS, "Transaction type is selected Void");
							 driver.findElement(By.id("go_Button")).click();
							 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");	
							 Thread.sleep(1000);
							 driver.findElement(By.name("transactionDataBean.disbursementType")).sendKeys(DisbType);
							 test.log(LogStatus.PASS, " Selected the Tender_Type as " +DisbType);
							 
							 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
							 test.log(LogStatus.PASS, " Entered password");
							 driver.findElement(By.name("Submit22")).click();
							 test.log(LogStatus.PASS, " cliked on finish pre-payment Void button");
							 Thread.sleep(3000);
							 if(ESign_CollateralType.equalsIgnoreCase("ACH"))
								{
							 if(driver.findElement(By.xpath("//*[text()='Void ACH Pre-Payment Completed Successfully.']")).isDisplayed())
							 	{
						
								 test.log(LogStatus.PASS, " Void Pre-Payement from CSR is successfull");
								 test.log(LogStatus.PASS, "********************************************** ");
								 
							 	} 
							}
							 else if(ESign_CollateralType.equalsIgnoreCase("CHECK"))
								{
								 if(driver.findElement(By.xpath("//input[@name='checkyes']")).isDisplayed())
								 	{
							
									 test.log(LogStatus.PASS, " Void Pre-Payement from CSR is successfull");
									 test.log(LogStatus.PASS, "********************************************** ");
									 
								 	}
								}
							 break;
							 }
			}
		}
		catch(Exception e){
			e.printStackTrace();
			test.log(LogStatus.FAIL, "PrePayment from CSR is failed");
		}
	} 

}



