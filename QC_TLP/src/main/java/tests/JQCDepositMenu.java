package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;


public class JQCDepositMenu extends QCStore{
	public static void depositMenu(String SSN,String AppURL) throws InterruptedException
	{
		 
				int lastrow=TestData.getLastRow("Deposit");
				String sheetName="Deposit";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
					
					String RepresentmentType = TestData.getCellData(sheetName,"RepresentmentType",row);
			  
			       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);

					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					     		       
					
			       Thread.sleep(4000);
					test.log(LogStatus.INFO, "Deposit Menu from CSR has initiated");

					driver.switchTo().frame("bottom");
					String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					test.log(LogStatus.PASS, ""+Str_date);
					
					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
	
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(9000);
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
					    
					     String loan_nbr= driver.findElement(locator(prop.getProperty("loan_nbr"))).getText();
						  test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						   
						   driver.findElement(locator(prop.getProperty("clear_go"))).click();
						   test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
						   driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							
							if(ESign_CollateralType.equalsIgnoreCase("ACH"))
							{
								driver.findElement(By.linkText("ACH")).click();
								 Thread.sleep(2000);
								 test.log(LogStatus.PASS, "Clicked on ACH Menu");
								 driver.findElement(locator(prop.getProperty("deposit_ach_tlp"))).click();
								 test.log(LogStatus.PASS, "Clicked on Title Loan");
							 Thread.sleep(2000);
							 driver.findElement(locator(prop.getProperty("deposit_tlp_achdeposit"))).click();
							 test.log(LogStatus.PASS, "Clicked on ACH deposit");
							 Thread.sleep(2000);
							 
							 driver.switchTo().defaultContent();
							    driver.switchTo().frame("mainFrame");
							    driver.switchTo().frame("main");
							 driver.findElement(locator(prop.getProperty("deposit_loan_nbr"))).sendKeys(loan_nbr);
							 test.log(LogStatus.PASS, "Entered Loan number as "+ loan_nbr);
							 driver.findElement(locator(prop.getProperty("ACH_submit"))).click();
							 test.log(LogStatus.PASS, "Clicked on Submit button ");
							 driver.findElement(locator(prop.getProperty("deposit_ilp_deposit_type"))).sendKeys(RepresentmentType);
							 test.log(LogStatus.PASS, "Entered Loan number as "+ RepresentmentType);
							 driver.findElement(locator(prop.getProperty("deposit_check_box"))).click();
							 test.log(LogStatus.PASS, "Selected the radio button ");
							 
							 driver.findElement(locator(prop.getProperty("finish_ach_deposit"))).click();
							 test.log(LogStatus.PASS, "Clicked on  "+ESign_CollateralType+"Deposit button");
								test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
								test.log(LogStatus.PASS, "********************************************** ");

							}
							
							if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
							{
								Actions action = new Actions(driver);  
								 WebElement dc=driver.findElement(locator(prop.getProperty("DC")));
								 action.moveToElement(dc).build().perform();
								 test.log(LogStatus.PASS, " Mouse hover on collateral Debit Card menu");
								 Thread.sleep(2000);
								 WebElement pdl=driver.findElement(locator(prop.getProperty("deposit_debitcard_tlp")));
								 action.moveToElement(pdl).build().perform();
								 test.log(LogStatus.PASS, " Mouse hover on Title loan menu");
								 Thread.sleep(3000);
								 driver.findElement(locator(prop.getProperty("deposit_DC_tlpdeposit"))).click();
								 test.log(LogStatus.PASS, " click on deposit menu");
								 Thread.sleep(2000);
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 driver.findElement(locator(prop.getProperty("deposit_loan_nbr"))).sendKeys(loan_nbr);
								 driver.findElement(locator(prop.getProperty("ACH_submit"))).click();
								 
								 
								 test.log(LogStatus.PASS, "Clicked on submit button");
								 driver.findElement(locator(prop.getProperty("deposit_check_box"))).click();
								 driver.findElement(locator(prop.getProperty("finish_ach_deposit"))).click();
								 test.log(LogStatus.PASS, "Clicked on  "+ESign_CollateralType+"Deposit button");
								test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
								test.log(LogStatus.PASS, "********************************************** ");

							}
						 
						 
						 break;
						 
					}
				}
			





	}
}



