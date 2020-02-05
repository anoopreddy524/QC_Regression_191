package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class RQCCSRAutoClosure extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static void autoclosure(String SSN, String AppURL) throws InterruptedException {

			int lastrow = TestData.getLastRow("Auto_Closure_Status");
			String sheetName = "Auto_Closure_Status";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String Balance_Status = TestData.getCellData(sheetName, "Balance_Status", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "AutoClosure Verify started");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(Aprop.getProperty("transactions_tab"))).click();
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(locator(Aprop.getProperty("csr_transaction_link"))).click();
					test.log(LogStatus.PASS, "Clicked on Transaction");
					driver.switchTo().frame("main");
					Thread.sleep(500);
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
					driver.findElement(locator(Aprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
					driver.findElement(locator(Aprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
					driver.findElement(locator(Aprop.getProperty("csr_new_loan_submit_button"))).click();
					test.log(LogStatus.PASS, "Clicked on submit Button");
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(locator(Aprop.getProperty("csr_new_loan_go_button"))).click();
						test.log(LogStatus.PASS, "Clicked on GO Button");
						Thread.sleep(5000);
						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on GO Button");
						Thread.sleep(500);

						String BalanceStatus = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]")).getText();
						                                                   
								
						
						System.out.println(BalanceStatus);
						Thread.sleep(5000);
						if (Balance_Status.trim().equalsIgnoreCase(BalanceStatus.trim())) {
							//test.log(LogStatus.PASS, "Balance Status is :" + Balance_Status);
							test.log(LogStatus.INFO, "<FONT color=green style=Arial>LOC Status is :" + Balance_Status );
							
							
							Thread.sleep(5000);
							
							 driver.close();
						
					}
						else 
							test.log(LogStatus.FAIL, "Status is not Closed");
						    //Assert.assertTrue(false);
                          
						break;
					}
				}

			}
			// }

		
	}
}
