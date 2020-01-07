package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.LogStatus;

//public class QCCSRDueDate extends QCStore {

//}
public class QCStoreEPP extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static void epp(String SSN, String AppURL) throws Exception {
		int i;
		for (i = 0; i < 3; i++) {
		
			try {
				// String FileName=
				// prop.getProperty("QC_Store_NewLoan_file_name");

				// ExcelNew TestData = new
				// ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");
				int lastrow = TestData.getLastRow("EPP");
				String sheetName = "EPP";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					String TenderType = TestData.getCellData(sheetName, "TenderType", row);
					String Income_PayFrequency = TestData.getCellData(sheetName, "Income_PayFrequency", row);
					//String ChkAcctNumber = TestData.getCellData(sheetName, "ChkAcctNumber", row);
					String  ChkAcctNumber=SSN.substring(SSN.length() - 4);
					String PIN = TestData.getCellData(sheetName, "PIN", row);
					if (SSN.equals(RegSSN)) {
						State = TestData.getCellData(sheetName, "StateID", row);
						// ProductID=TestData.getCellData(sheetName,"ProductID",row);
						// System.out.println(ProductID);

						SSN1 = SSN.substring(0, 3);
						SSN2 = SSN.substring(3, 5);
						SSN3 = SSN.substring(5, 9);

						Thread.sleep(3000);
						test.log(LogStatus.INFO, "EPP started");
						driver.switchTo().frame("topFrame");
						   	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					        driver.findElement(By.cssSelector("li[id='910000']")).click();	
							
							test.log(LogStatus.PASS, "Clicked on Loan Transactions");
							Thread.sleep(1000);
						
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							
							driver.findElement(By.cssSelector("li[id='911101']")).click();			
							test.log(LogStatus.PASS, "Clicked on Transactions");
						driver.switchTo().frame("main");
						Thread.sleep(500);
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
						driver.findElement(locator(prop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
						driver.findElement(locator(prop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
						driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
						test.log(LogStatus.PASS, "Clicked on submit Button");
						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
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
							Thread.sleep(2000);
							driver.findElement(By.name("transactionList")).sendKeys("EPP");
							test.log(LogStatus.PASS, "Transaction Type is selected as EPP");

							driver.findElement(By.name("button")).click();
							test.log(LogStatus.PASS, "Clicked on Go button");
							Thread.sleep(5000);
							try {
								Alert alert = driver.switchTo().alert();

								alert.accept();
								// if alert present, accept and move on.

							} catch (NoAlertPresentException e) {
								// do what you normally would if you didn't have
								// the alert.
							}
							Thread.sleep(500);

							driver.findElement(By.name("paymentPlanFreq")).sendKeys(Income_PayFrequency);

							test.log(LogStatus.PASS, "Frequency Type is :" + Income_PayFrequency);

							driver.findElement(By
									.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table[3]/tbody/tr[6]/td[2]/input[1]"))
									.click();

							Thread.sleep(5000);

							/*driver.findElement(By
									.xpath("//*[@id='screenBlr']/div[1]/form[1]/table/tbody/tr/td/table/tbody/tr[7]/td/table/tbody/tr[19]/td[2]/input"))
									.sendKeys(ChkAcctNumber);*/
							driver.findElement(By
									.name("chkgAcctNbr"))
									.sendKeys(ChkAcctNumber);

							test.log(LogStatus.PASS, "Checking account number  is :" + ChkAcctNumber);

							driver.findElement(By.name("password")).sendKeys(PIN);

							test.log(LogStatus.PASS, "Pin is entered");

							driver.findElement(By.name("submitBtn")).click();

							test.log(LogStatus.PASS, "Clicked on Finished Extended payment Plan");

							Thread.sleep(5000);
							try {
								Alert alert = driver.switchTo().alert();

								alert.accept();
								// if alert present, accept and move on.

							} catch (NoAlertPresentException e) {
								// do what you normally would if you didn't have
								// the alert.
							}
							Thread.sleep(5000);

							driver.findElement(By.name("checkno")).click();
							test.log(LogStatus.PASS, "Click on No Button");
							// test.log(LogStatus.PASS, "BuyBack Completed
							// Successfully");
							test.log(LogStatus.PASS, "EPP Completed Successfully");

						}
						break;
					}
				}
				break;
			}

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// test.log(LogStatus.FAIL, MarkupHelper.createLabel("Deposit
				// from CSR is failed", ExtentColor.RED));
				test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
				
				String screenshotPath = getScreenhot(driver, "EPP");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.INFO, "EPP intiated again due to Application sync issue");
				driver.get(prop.getProperty("login_page"));  
				continue;
			}

		}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "EPP is failed");
	
		}
	}
}
