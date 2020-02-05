package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import com.relevantcodes.extentreports.LogStatus;

public class RQCCSRDefaultPayment extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static void sdefaultpayment(String SSN, String AppURL) throws InterruptedException {
		
			int lastrow = TestData.getLastRow("DefaultPayment");
			String sheetName = "DefaultPayment";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String Balance_Status = TestData.getCellData(sheetName, "Balance_Status", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "Default Payment started");
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

						String BalanceStatus = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]")).getText();
								
						
						System.out.println(BalanceStatus);
						Thread.sleep(5000);
						if (Balance_Status.trim().equalsIgnoreCase(BalanceStatus.trim())) {
							test.log(LogStatus.PASS, "Balance Status is :" + Balance_Status);
							
							driver.findElement(By.name("transactionList")).sendKeys(TxnType);
							test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
							driver.findElement(By.name("button")).click();
							test.log(LogStatus.PASS, "Clicked on Go button");
							Thread.sleep(500);
							
							String Paymentamt = driver.findElement(By.name("requestBean.paymentAmt")).getAttribute("value");
							test.log(LogStatus.PASS, "Paymentamt is :" + Paymentamt);
							//driver.findElement(By.name("requestBean.tenderAmt")).clear();
							//driver.findElement(By.name("requestBean.tenderAmt")).sendKeys(Paymentamt);
							//test.log(LogStatus.PASS, "Payment amount entered :" + Paymentamt);
							Thread.sleep(500);
							driver.findElement(By.name("requestBean.tenderType")).sendKeys(TenderType);
							test.log(LogStatus.PASS, "Tender Type entered :" + TenderType);
							
							driver.findElement(By.name("requestBean.tenderAmt")).sendKeys(Paymentamt);
							test.log(LogStatus.PASS, "Tender amount entered :" + Paymentamt);
							driver.findElement(By.name("password")).sendKeys(PIN);
							
							test.log(LogStatus.PASS, "Pin is entered :" + PIN);
							Thread.sleep(500);
							driver.findElement(By.name("Submit22")).click();
							Thread.sleep(3000);
							test.log(LogStatus.PASS, "Clicked on Finish Payment");
							test.log(LogStatus.PASS, "<FONT color=green style=Arial>Default Payment Transaction Completed Successfully");
							Thread.sleep(5000);
							
							try {
								Alert alert = driver.switchTo().alert();

								alert.accept();
								// if alert present, accept and move on.

							} catch (NoAlertPresentException e) {
								// do what you normally would if you didn't have
								// the alert.
							}
							//Thread.sleep(5000);
							
							 driver.close();
						
					}
						else 
							test.log(LogStatus.FAIL, "Status is not Default");
						    //Assert.assertTrue(false);
                          
						break;
					}
				}

			}
			// }

		
	}
}
