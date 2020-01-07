package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class AEPPClearOnly extends QCStore{

	
	public static void eppClear(String SSN,String AppURL) throws InterruptedException{
	
			test.log(LogStatus.PASS, "************EPP Clear started****************");
			

			int lastrow=TestData.getLastRow("Deposit");
			String sheetName="Deposit";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);
					
					test.log(LogStatus.INFO, "************************Clear check process has started***********************");
					Thread.sleep(2000);
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
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button ");

									    
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					if(ProductID.equals("PDL"))
					{
						 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						 test.log(LogStatus.PASS, "Click on GO Button under loan section");
					}
					if(ProductID.equals(Aprop.getProperty("TLP")))
					{
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
					}

					//Thread.sleep(5000);
					if(ProductID.equals(Aprop.getProperty("LOC")))
					{

						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					}

					/*String loan_nbr= driver.findElement(locator(Aprop.getProperty("csr_loan_nbr"))).getText();
					test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);*/
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
				
						driver.switchTo().frame("main");
						driver.findElement(locator(Aprop.getProperty("transactionList"))).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Transaction type is selected Clear Check");
						driver.findElement(locator(Aprop.getProperty("go"))).click();
						test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");	
						driver.findElement(locator(Aprop.getProperty("clear_pwd"))).sendKeys(PIN);
						test.log(LogStatus.PASS, " Entered password");
						driver.findElement(locator(Aprop.getProperty("clear_finish"))).click();
						test.log(LogStatus.PASS, " cliked on finish Clear Check button");
						Thread.sleep(3000);
						if(driver.findElement(locator(Aprop.getProperty("clear_checkyes"))).isDisplayed())
						{						
							test.log(LogStatus.PASS, "EPP Clear dropdown from CSR is successfull");
							test.log(LogStatus.PASS, "********************************************** ");								 
						}
					
					

				}}


		
	}}

