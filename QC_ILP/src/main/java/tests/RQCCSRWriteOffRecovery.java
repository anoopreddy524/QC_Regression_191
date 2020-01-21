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

public class RQCCSRWriteOffRecovery extends QCStore {
	public static void writeoffrecovery(String SSN, String AppURL) {
		
		try {
		
			int lastrow = TestData.getLastRow("Writeoff_Recovery");
			String sheetName = "Writeoff_Recovery";

			for (int row = 2; row <= lastrow; row++) {

				
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				if (SSN.equals(RegSSN)) {
					String UserName = TestData.getCellData(sheetName, "UserName", row);
					String Password = TestData.getCellData(sheetName, "Password", row);
					String PIN = TestData.getCellData(sheetName, "PIN", row);
					// System.out.println(Password);
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String ProductType = TestData.getCellData(sheetName, "ProductType", row);
					String TxnType = TestData.getCellData(sheetName, "TxnType", row);
					String TenderType = TestData.getCellData(sheetName, "TenderType", row);

					
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3, 5);
					String SSN3 = SSN.substring(5, 9);

					Thread.sleep(4000);
					

					test.log(LogStatus.INFO, "WriteOff Recovery Started");
					driver.switchTo().defaultContent();

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
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
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
					// driver.findElement(By.name("button")).click();

					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					// driver.findElement(By.name("button")).click();

					if (ProductID.equals("ILP")) {
						
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					}
					if (ProductID.equals("TLP")) {
						driver.findElement(By
								.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input"))
								.click();
					}

					// Thread.sleep(5000);
					if (ProductID.equals("LOC")) {
						/// html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]
						driver.findElement(By
								.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]"))
								.click();
					}

					// -----------------------------------
					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='go_Button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					Thread.sleep(500);
					
					//driver.findElement(By.name("transactionDataBean.paymentBalAmt")).clear();
					String WOBalance = driver.findElement(By.name("transactionDataBean.paymentBalAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment amount is :" + WOBalance);
					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
					driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(WOBalance);
					test.log(LogStatus.PASS, "Payment amount entered :" + WOBalance);
					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
					driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(WOBalance);
					test.log(LogStatus.PASS, "Payment amount entered :" + WOBalance);
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is :" + TenderType);
					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).clear();
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(WOBalance);
					test.log(LogStatus.PASS, "Tender amount entered :" + WOBalance);					
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
						// do what you normally would if you didn't have the
						// alert.
					}
					Thread.sleep(8000);
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/input[2]")).click();
					 //test.log(LogStatus.PASS, "Clicked on No");
					 test.log(LogStatus.PASS, "WriteOff Recovery Completed Successfully");
					driver.close();
					
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

/*
 * break; }
 * 
 * }
 * 
 * break;
 * 
 * } catch (Exception e) { // TODO Auto-generated catch block //
 * test.log(LogStatus.FAIL, MarkupHelper.createLabel("CSR login // is failed",
 * ExtentColor.RED)); // test.log(LogStatus.FAIL,"EODDeposit is failed");
 * test.log(LogStatus.INFO, "" + e); test.log(LogStatus.INFO,
 * "EODDeposit process is initiated again due to Application sync issue");
 * 
 * e.printStackTrace(); continue; }
 * 
 * } if (i == 3) { test.log(LogStatus.FAIL, "EODDeposit process is failed");
 * 
 * } } }
 */