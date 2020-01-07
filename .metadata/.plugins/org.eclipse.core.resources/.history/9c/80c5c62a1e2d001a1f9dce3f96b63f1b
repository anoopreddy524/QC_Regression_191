package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class AQC_EPPClear extends QCStore{

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


				driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
					test.log(LogStatus.PASS, "Clicked on Cash Management");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.findElement(By.xpath("//*[@id='932000']/a")).click();	
					test.log(LogStatus.PASS, "Clicked on Safe button");
					Thread.sleep(2000);

					driver.findElement(By.xpath("//*[@id='932040']/a")).click();
					test.log(LogStatus.PASS, "Clicked on Internal transfer button");
					driver.switchTo().frame("main");
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table[1]/tbody/tr[1]/td[2]/select")).sendKeys("Drawer 1212 to safe");;	
					test.log(LogStatus.PASS, "Selected drawere to safe option");
					Thread.sleep(3000);

					WebElement e= driver.findElement(By.name("requestBean.noOfDollars"));	
					e.click();
					e.sendKeys("0");
					test.log(LogStatus.PASS, "Enterd count of dollar coins :"+"0");
					Thread.sleep(1500);


					driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table[1]/tbody/tr[9]/td/table/tbody/tr[2]/td[3]/input")).click();
					test.log(LogStatus.PASS, "click on check box ");


					driver.findElement(By.name("safeToDrawerRequestBean.password")).sendKeys(PIN);;
					test.log(LogStatus.PASS, "Entered password as :"+PIN);
					Thread.sleep(1500);
					driver.findElement(By.name("internaltransfer")).click();
					test.log(LogStatus.PASS, "Clicked on Finish Internal transfer");
					test.log(LogStatus.INFO, "Internal Transfer Finished");
					
					//-----------------------------------------------------------------------------------------------------
					
					test.log(LogStatus.INFO, "Deposit form safe started");
					Thread.sleep(3000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
					test.log(LogStatus.PASS, "Clicked on Cash Management");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.findElement(By.xpath("//*[@id='932000']/a")).click();	
					test.log(LogStatus.PASS, "Clicked on Safe button");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='932050']/a")).click();	
					test.log(LogStatus.PASS, "Clicked on Deposit button");
					Thread.sleep(3000);
					driver.switchTo().frame("main");
					WebElement e1= driver.findElement(By.name("safeDepositRequestBean.noOfDollars"));
					e1.click();
					e1.sendKeys("0");
					test.log(LogStatus.PASS, "Enterd count of dollar coins :"+"0");
					
					
					Thread.sleep(1500);
							
				List<WebElement>  rows = driver.findElements(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr")); 

					int n=rows.size();
					// System.out.println("No of rows are : " + n);
					//test.log(LogStatus.PASS, "First name is"+FirstName);
					//ESign_CheckNbr="951605";
					for(int i=4;i<=n;i++){

						String Checknumber=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();

						test.log(LogStatus.PASS, "Getting check number for the check box to check condition"+Checknumber);
						
						test.log(LogStatus.PASS, "Check number is"+ESign_CheckNbr);
						Thread.sleep(3000);
						//if(Cname.toLowerCase().trim().contains(FirstName.toLowerCase().trim()))
						if(Checknumber.contains(ESign_CheckNbr)){

							test.log(LogStatus.PASS, "name condition satisfied ");
														
							driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/input")).click();
							test.log(LogStatus.PASS, "Clicked on check box ");
							
							driver.findElement(By.name("safeDepositRequestBean.password")).sendKeys(PIN);
							test.log(LogStatus.PASS, "password enterd as :"+PIN);

							driver.findElement(By.name("finishdeposit")).click();
							test.log(LogStatus.PASS, "Clicked on Finish button in safe deposit page");
							try { 
								Alert alert = driver.switchTo().alert();
								String almsg=alert.getText();
								
								alert.accept();
								test.log(LogStatus.PASS, "Alert accpted with message :"+almsg);
								// if alert present, accept and move on.												

							}
							catch (NoAlertPresentException e5) {
								//do what you normally would if you didn't have the alert.
							}
							Thread.sleep(3000);
							driver.findElement(By.name("finishdeposit")).click();
							test.log(LogStatus.PASS, "Clicked on Finish button in deposit  verification page");
							test.log(LogStatus.INFO, "Deposit from safe has Finished");
							break;
						}
						else{
							test.log(LogStatus.FAIL, "Check number condition failed");
						}}
					//-------------------------------------------------------------------------------------------------------
					
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
						driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					}
					if(ProductID.equals(Aprop.getProperty("TLP")))
					{
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
					}

					Thread.sleep(5000);
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
