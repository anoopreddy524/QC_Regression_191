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

public class JQCCSRWriteOffRecovery extends QCStore {
	public static void writeoffrecovery(String SSN, String AppURL) throws InterruptedException {
		

			int lastrow = TestData.getLastRow("Writeoff_Recovery");
			String sheetName = "Writeoff_Recovery";

			for (int row = 2; row <= lastrow; row++) {


				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				if (SSN.equals(RegSSN)) {
					
					String PIN = TestData.getCellData(sheetName, "PIN", row);
					
					
					String TxnType = TestData.getCellData(sheetName, "TxnType", row);
					String TenderType = TestData.getCellData(sheetName, "TenderType", row);


					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3, 5);
					String SSN3 = SSN.substring(5, 9);

					Thread.sleep(4000);
					
					test.log(LogStatus.INFO, "WriteOff Recovery Started");
					driver.switchTo().defaultContent();

					
					driver.switchTo().frame("topFrame");
					
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
					test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
					driver.findElement(By.name("ssn2")).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
					driver.findElement(By.name("ssn3")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
					driver.findElement(By.name("submit1")).click();
					test.log(LogStatus.PASS, "Click on submit Button");
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

				
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
					

					
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					
					String loan_nbr = driver.findElement(locator(prop.getProperty("csr_loan_nbr"))).getText();
					test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
				
					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='go_Button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is :" + TenderType);
					Thread.sleep(500);
					String Paymentamt = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment amount is :" + Paymentamt);
					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Paymentamt);
					test.log(LogStatus.PASS, "Tender amount entered :" + Paymentamt);
					Thread.sleep(500);
					driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
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
						
					}
					driver.findElement(By.name("checkno")).click();
					 test.log(LogStatus.PASS, "Clicked on No");
					 test.log(LogStatus.PASS, "WriteOff Recovery Completed Successfully");
					
					
					// ------------------------------------

					break;
				}
			}

		

	}
}

