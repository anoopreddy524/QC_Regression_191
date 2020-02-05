package tests;

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

public class VQCCSRWriteOffRecovery extends QCStore {
	public static void writeoffrecovery(String SSN, String AppURL) {
		
		try {
		
			int lastrow = TestData.getLastRow("Writeoff_Recovery");
			String sheetName = "Writeoff_Recovery";

			for (int row = 2; row <= lastrow; row++) {

				
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				if (SSN.equals(RegSSN)) {
		
					String PIN = TestData.getCellData(sheetName, "PIN", row);
				
					String TxnType = TestData.getCellData(sheetName, "TxnType", row);
					String TenderType = TestData.getCellData(sheetName, "TenderType", row);
					String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
					
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3, 5);
					String SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO,"WriteOff Recovery has started");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(Aprop.getProperty("transactions_tab"))).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")).click();
					test.log(LogStatus.PASS, "Clicked on Transaction");		
					driver.switchTo().frame("main");	
					Thread.sleep(500);
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(locator(Aprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(locator(Aprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(locator(Aprop.getProperty("csr_new_loan_submit_button"))).click();
					test.log(LogStatus.PASS, "Clicked on submit Button");		
								
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");					    					   					     
					driver.findElement(locator(Aprop.getProperty("csr_new_loan_go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");
					Thread.sleep(5000);					  
						
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
					Thread.sleep(8000);
					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button ");
					Thread.sleep(6000);	
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					//driver.findElement(By.name("transactionDataBean.paymentBalAmt")).clear();
					
					String WOBalance = driver.findElement(By.name("requestBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment amount is :" + WOBalance);
					//WebElement e4=driver.findElement(By.name("requestBean.paymentAmt"));
					//e4.clear();
					//driver.findElement(By.name("requestBean.paymentAmt")).sendKeys("400");
					
					//driver.findElement(By.name("requestBean.paymentAmt")).sendKeys("500");
					//test.log(LogStatus.PASS, "Payment amount is entered as 400");
					Thread.sleep(500);
					driver.findElement(By.name("requestBean.tenderType")).sendKeys(TenderType);
					Thread.sleep(5000);
					driver.findElement(By.name("requestBean.ccmoNbr")).sendKeys(CC_MO_Nbr);
				        
					test.log(LogStatus.PASS, "CC_MO_Nbr entered :" + CC_MO_Nbr);
					Thread.sleep(500);
					driver.findElement(By.name("requestBean.tenderAmt")).sendKeys(WOBalance);
					test.log(LogStatus.PASS, "Tender amount is entered as :" +WOBalance);		
					Thread.sleep(500);
					driver.findElement(By.name("password")).sendKeys(PIN);
					test.log(LogStatus.PASS, "Pin entered is :" +PIN);
					Thread.sleep(500);
					driver.findElement(By.name("Submit22")).click();
					test.log(LogStatus.PASS, "Clicked on Finish Writeoff Recovery");
					Thread.sleep(5000);
					try {
						Alert alert = driver.switchTo().alert();

						alert.accept();
						// if alert present, accept and move on.

					} catch (NoAlertPresentException e) {
						// do what you normally would if you didn't have the
						// alert.
					}
					Thread.sleep(8000);
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/input[2]")).click();
					 //test.log(LogStatus.PASS, "Clicked on No");
					 test.log(LogStatus.PASS, "WriteOff Recovery Completed Successfully");
					//driver.close();
					
					// ------------------------------------

					break;
				}
			}

		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Writeoff Recovery failed");

		}

	}
}

