package tests;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCRefinance extends QCStore {
	public static String Pbal;
	public static String cardType;
	public static String cardNumber;
	public static String cardEx_month;
	public static String cardEx_Year;
	public static String cvv;
	public static String CardHolderName;

	public static void refinanceStepDown(String SSN, String AppURL) {
		int i;
		for (i = 0; i < 3; i++) {
			
			try {
				int lastrow = TestData.getLastRow("RefinanceStepdown");
				String sheetName = "RefinanceStepdown";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					if (SSN.equals(RegSSN)) {

						String Bank_ChkgAcctNbr = TestData.getCellData(sheetName, "Bank_ChkgAcctNbr", row);
						String last4cheknum = Bank_ChkgAcctNbr.substring(Bank_ChkgAcctNbr.length() - 4);
						String ESign_DisbType = TestData.getCellData(sheetName, "ESign_DisbType", row);
						String ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent",
								row);
						String ESign_Preference = TestData.getCellData(sheetName, "ESign_Preference", row);
						String ESign_CheckNbr = TestData.getCellData(sheetName, "ESign_CheckNbr", row);
						String No_of_checks = TestData.getCellData(sheetName, "No_of_checks", row);
						String Esign_Password = TestData.getCellData(sheetName, "ESign_Password", row);
						String Esign_CollateralType = TestData.getCellData(sheetName, "Esign_CollateralType", row);
						String Collateral = TestData.getCellData(sheetName, "Collateral", row);

						cardType = TestData.getCellData(sheetName, "Card Type ", row);
						cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
						cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
						cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
						cvv = TestData.getCellData(sheetName, "CVV", row);
						CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);
						String SSN1 = SSN.substring(0, 3);
						String SSN2 = SSN.substring(3, 5);
						String SSN3 = SSN.substring(5, 9);

						Thread.sleep(3000);
						test.log(LogStatus.INFO, "Refinance StepDown  process has started");
						driver.switchTo().frame("topFrame");
						driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");

						driver.findElement(By.cssSelector("li[id='911101']")).click();
						test.log(LogStatus.PASS, "Clicked on Transaction");
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
						/*
						 * for(String winHandle : driver.getWindowHandles()) {
						 * driver.switchTo().window(winHandle);
						 */
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
						test.log(LogStatus.PASS, "Clicked on GO Button under search results");
						Thread.sleep(2000);
						/*
						 * for( String winHandle1 : driver.getWindowHandles()) {
						 * driver.switchTo().window(winHandle1); }
						 */
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
						// driver.findElement(By.xpath("
						// /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						// test.log(LogStatus.PASS, "Clicked on Go button under
						// Loans section");
						Thread.sleep(5000);
						driver.findElement(By.name("transactionList")).sendKeys("Refinance");
						test.log(LogStatus.PASS, "Transaction Type is selected as Refinance");
						driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(5000);
						/*
						 * try{ driver.findElement(By.xpath(
						 * "//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]"
						 * )).click(); test.log(LogStatus.PASS,
						 * "Clicked Yes on cashOut popup"); } catch(Exception e)
						 * {
						 * 
						 * }
						 */
						Thread.sleep(3000);
						driver.findElement(By
								.xpath("/html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr/td/input[4]"))
								.click();
						test.log(LogStatus.PASS, "Clicked on History button ");
						Thread.sleep(6000);

						String mainWindow = driver.getWindowHandle();
						for (String winHandle : driver.getWindowHandles()) {
							if (!mainWindow.equalsIgnoreCase(winHandle)) {
								driver.switchTo().window(winHandle);
								Pbal = driver
										.findElement(By
												.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[15]/td/span[2]"))
										.getText();
								test.log(LogStatus.PASS, "Captured principle balance is : " + Pbal);
								// driver.close();
								break;
							}
						}
						driver.switchTo().window(mainWindow);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						// test.log(LogStatus.PASS, "Switching to the window
						// "+driver.getTitle());
						double PbalInt = Float.valueOf(Pbal);
						PbalInt = PbalInt - 10;
						// DecimalFormat f = new DecimalFormat("##.00");
						// f.format(PbalInt)
						PbalInt = Math.round(PbalInt * 100.0) / 100.0;
						String pbalstr = String.valueOf(PbalInt);
						test.log(LogStatus.PASS, "Payment amount is : " + pbalstr);
						Thread.sleep(3000);

						// driver.findElement(By.xpath("/html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/table/tbody/tr[2]/td[2]/input")).clear();
						// driver.findElement(By.xpath("/html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/table/tbody/tr[2]/td[2]/input")).sendKeys(pbalstr);

						// driver.findElement(By.name("transactionDataBean.advAmt")).clear();
						// driver.findElement(By.name("transactionDataBean.advAmt")).sendKeys(pbalstr);
						// driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
						// Thread.sleep(5000);
						driver.findElement(By.name("transactionDataBean.paymentAmt"))
								.sendKeys(Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE)
										+ pbalstr);
						// ("^a"+pbalstr);
						driver.findElement(By.name("qualify")).click();
						// Thread.sleep(8000);

						// driver.findElement(By.name("qualify")).click();
						test.log(LogStatus.PASS, "Clicked on Qualify button ");
						if (Collateral.equalsIgnoreCase("ACH")) {

							driver.findElement(By
									.xpath(" /html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/table/tbody/tr[8]/td[2]/select"))
									.sendKeys(ESign_CourtesyCallConsent);
							test.log(LogStatus.PASS, "Courtesy Call Consent selected as " + ESign_CourtesyCallConsent);

							Thread.sleep(2000);
							driver.findElement(By.xpath(" //*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Esign preference selected as " + ESign_Preference);

						}

						if (Collateral.equalsIgnoreCase("CHECK")) {

							driver.findElement(By
									.xpath(" /html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/table/tbody/tr[8]/td[2]/select"))
									.sendKeys(ESign_CourtesyCallConsent);
							test.log(LogStatus.PASS, "Courtesy Call Consent selected as " + ESign_CourtesyCallConsent);

							Thread.sleep(2000);
							driver.findElement(By.xpath(" //*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Esign preference selected as " + ESign_Preference);
							driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
							test.log(LogStatus.PASS, "Chkg Acct Number enterd" + last4cheknum);
							driver.findElement(By
									.xpath(" /html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr/td/select"))
									.sendKeys(No_of_checks);
							test.log(LogStatus.PASS, "Number of checks " + No_of_checks);
							Thread.sleep(2000);

							driver.findElement(By.xpath(" //*[@id='chkNbr0']")).sendKeys(ESign_CheckNbr);
							test.log(LogStatus.PASS, "Check number enterd as " + ESign_CheckNbr);
						}
						if (Collateral.equalsIgnoreCase("DEBIT CARD"))

						{
							driver.findElement(locator(prop.getProperty("refinance_courtesy_call")))
									.sendKeys(ESign_CourtesyCallConsent);
							test.log(LogStatus.PASS, "Courtesy Call Consent selected as " + ESign_CourtesyCallConsent);
							Thread.sleep(2000);
							driver.findElement(By.xpath(" //*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Esign preference selected as " + ESign_Preference);
							driver.findElement(locator(prop.getProperty("refinance_select_card"))).sendKeys("New Card");
							test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");
							Thread.sleep(2000);

							driver.findElement(locator(prop.getProperty("refinance_select_card_type")))
									.sendKeys(cardType);
							test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);

							driver.findElement(locator(prop.getProperty("refinance_card_number"))).sendKeys(cardNumber);
							test.log(LogStatus.PASS, "Card number is :" + cardNumber);

							driver.findElement(locator(prop.getProperty("refinance_exp_month"))).sendKeys(cardEx_month);
							test.log(LogStatus.PASS, "Enterd Expiry month as" + cardEx_month);
							try {
								Alert alert = driver.switchTo().alert();

								alert.accept();
								// if alert present, accept and move on.

							} catch (Exception e) {
								// do what you normally would if you didn't have
								// the alert.
							}

							driver.findElement(locator(prop.getProperty("refinance_exp_year"))).sendKeys(cardEx_Year);
							test.log(LogStatus.PASS, "Entered Expiry year as" + cardEx_Year);
							try {
								Alert alert = driver.switchTo().alert();

								alert.accept();
								// if alert present, accept and move on.

							} catch (Exception e) {
								// do what you normally would if you didn't have
								// the alert.
							}

							driver.findElement(locator(prop.getProperty("refinance_cvv"))).sendKeys(cvv);
							test.log(LogStatus.PASS, "Enterd CVV as " + cvv);
							driver.findElement(locator(prop.getProperty("refinance_card_holder_name")))
									.sendKeys(CardHolderName);
							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

							driver.findElement(locator(prop.getProperty("refinance_dc_card_add"))).click();
							test.log(LogStatus.PASS, "Clicked on add card button ");

						}

						driver.findElement(By.xpath("//*[@id='tenderTypeId']/select")).sendKeys(ESign_DisbType);
						test.log(LogStatus.PASS, "Tender type is " + ESign_DisbType);

						// *[@id="tenderAmtStyle"]/td[2]/input
						String paymentAmount = driver.findElement(locator(prop.getProperty("refinance_payment_amount")))
								.getAttribute("value");
						driver.findElement(By.xpath("//*[@id='tenderAmtStyle']/td[2]/input")).sendKeys(paymentAmount);
						test.log(LogStatus.PASS, "Tender amount is " + paymentAmount);

						String rebate = driver.findElement(locator(prop.getProperty("refinance_rebate_amount")))
								.getAttribute("value");
						test.log(LogStatus.PASS, "Rebate amount is " + rebate);
						// String stepdownamount=
						// driver.findElement(locator(prop.getProperty("refinance_step_down_amount"))).getAttribute("value");
						test.log(LogStatus.PASS, "Step Same amount is " + pbalstr);
						Thread.sleep(2000);

						// driver.findElement(By.name("requestBean.password")).sendKeys(Esign_Password);
						driver.findElement(locator(prop.getProperty("refinance_password"))).sendKeys(Esign_Password);
						test.log(LogStatus.PASS, "Password enterd as: " + Esign_Password);

						Thread.sleep(5000);
						driver.findElement(locator(prop.getProperty("refinance_finish_button"))).click();
						test.log(LogStatus.PASS, "Clicked on Finish Refinance button ");

						try {
							Alert alert = driver.switchTo().alert();

							alert.accept();
							// if alert present, accept and move on.

						} catch (Exception e) {
							// do what you normally would if you didn't have the
							// alert.
						}
						Thread.sleep(10000);
						try {
							driver.findElement(locator(prop.getProperty("refinance_finish_button"))).click();

						} catch (Exception e) {
							// do what you normally would if you didn't have the
							// alert.
						}
						try {
							Alert alert = driver.switchTo().alert();

							alert.accept();
							// if alert present, accept and move on.

						} catch (Exception e) {
							// do what you normally would if you didn't have the
							// alert.
						}
						String confirm_text = driver
								.findElement(By
										.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[4]/td"))
								.getText();
						test.log(LogStatus.PASS, "" + confirm_text);
						driver.findElement(locator(prop.getProperty("refinance_yes_button"))).click();
						test.log(LogStatus.PASS, "Clicked on Yes button under Confirm screen");
						test.log(LogStatus.PASS, "Refinance Step Down is successful");
						test.log(LogStatus.PASS, "********************************************");

					}
					// else
					{
						// test.log(LogStatus.FAIL, "Steup amount condition Not
						// satisfied ");
					}

					break;
				}

				break;

			}

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// test.log(LogStatus.FAIL, MarkupHelper.createLabel("Getting
				// Encryption from Admin is failed", ExtentColor.RED));
				test.log(LogStatus.INFO, " " + e);
				test.log(LogStatus.INFO, "Refinace Step down process is initiated again due to Application sync issue");
				driver.get(prop.getProperty("login_page")); 

				continue;

			}

		}
		if (i == 3) {
			test.log(LogStatus.FAIL, "Store setup is failed");
			Assert.assertTrue(false);

		}
	}

	public static void refinanceStepSame(String SSN, String AppURL) throws Exception {
		int i;
		for (i = 0; i < 3; i++) {

			try {

				int lastrow = TestData.getLastRow("RefinanceStepSame");
				String sheetName = "RefinanceStepSame";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					if (SSN.equals(RegSSN)) {

						String Bank_ChkgAcctNbr = TestData.getCellData(sheetName, "Bank_ChkgAcctNbr", row);
						String last4cheknum = Bank_ChkgAcctNbr.substring(Bank_ChkgAcctNbr.length() - 4);
						String ESign_DisbType = TestData.getCellData(sheetName, "ESign_DisbType", row);
						String ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent",
								row);
						String ESign_Preference = TestData.getCellData(sheetName, "ESign_Preference", row);
						String ESign_CheckNbr = TestData.getCellData(sheetName, "ESign_CheckNbr", row);
						String No_of_checks = TestData.getCellData(sheetName, "No_of_checks", row);
						String Esign_Password = TestData.getCellData(sheetName, "ESign_Password", row);
						String Esign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						cardType = TestData.getCellData(sheetName, "Card Type ", row);
						cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
						cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
						cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
						cvv = TestData.getCellData(sheetName, "CVV", row);
						CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);

						String Collateral = TestData.getCellData(sheetName, "Collateral", row);
						String SSN1 = SSN.substring(0, 3);
						String SSN2 = SSN.substring(3, 5);
						String SSN3 = SSN.substring(5, 9);

						Thread.sleep(3000);
						test.log(LogStatus.INFO, "Refinance StepSame  process has started");
						driver.switchTo().frame("topFrame");
						driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");

						driver.findElement(By.cssSelector("li[id='911101']")).click();
						test.log(LogStatus.PASS, "Clicked on Transaction");
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
						/*
						 * for(String winHandle : driver.getWindowHandles()) {
						 * driver.switchTo().window(winHandle);
						 */
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
						test.log(LogStatus.PASS, "Clicked on GO Button under search results");
						Thread.sleep(2000);
						/*
						 * for( String winHandle1 : driver.getWindowHandles()) {
						 * driver.switchTo().window(winHandle1); }
						 */
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
						// driver.findElement(By.xpath("
						// /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						// test.log(LogStatus.PASS, "Clicked on Go button under
						// Loans section");
						Thread.sleep(5000);
						driver.findElement(By.name("transactionList")).sendKeys("Refinance");
						test.log(LogStatus.PASS, "Transaction Type is selected as Refinance");
						driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(5000);
						try {
							driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]"))
									.click();
							test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
						} catch (Exception e) {

						}
						Thread.sleep(5000);
						driver.findElement(By
								.xpath("/html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr/td/input[4]"))
								.click();
						test.log(LogStatus.PASS, "Clicked on History button ");
						Thread.sleep(6000);

						String mainWindow = driver.getWindowHandle();
						for (String winHandle : driver.getWindowHandles()) {
							if (!mainWindow.equalsIgnoreCase(winHandle)) {
								driver.switchTo().window(winHandle);
								Pbal = driver
										.findElement(By
												.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[15]/td/span[2]"))
										.getText();
								test.log(LogStatus.PASS, "Captured principle balance is : " + Pbal);
								// driver.close();
								break;
							}
						}
						driver.switchTo().window(mainWindow);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						// test.log(LogStatus.PASS, "Switching to the window
						// "+driver.getTitle());
						double PbalInt = Float.valueOf(Pbal);
						// PbalInt=PbalInt;
						// DecimalFormat f = new DecimalFormat("##.00");
						// f.format(PbalInt)
						PbalInt = Math.round(PbalInt * 100.0) / 100.0;
						String pbalstr = String.valueOf(PbalInt);
						test.log(LogStatus.PASS, "Payment amount is : " + pbalstr);
						Thread.sleep(3000);

						// driver.findElement(By.xpath("/html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/table/tbody/tr[2]/td[2]/input")).clear();
						// driver.findElement(By.xpath("/html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/table/tbody/tr[2]/td[2]/input")).sendKeys(pbalstr);

						// driver.findElement(By.name("transactionDataBean.advAmt")).clear();
						// driver.findElement(By.name("transactionDataBean.advAmt")).sendKeys(pbalstr);
						// driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
						// Thread.sleep(5000);
						driver.findElement(By.name("transactionDataBean.advAmt")).clear();
						try {
							Alert alert = driver.switchTo().alert();

							alert.accept();
							// if alert present, accept and move on.

						} catch (Exception e) {
							// do what you normally would if you didn't have the
							// alert.
						}
						driver.findElement(By.name("transactionDataBean.advAmt")).sendKeys(pbalstr);

						try {
							Alert alert = driver.switchTo().alert();

							alert.accept();
							// if alert present, accept and move on.

						} catch (Exception e) {
							// do what you normally would if you didn't have the
							// alert.
						}
						// ("^a"+pbalstr);
						driver.findElement(By.name("qualify")).click();
						// Thread.sleep(8000);

						// driver.findElement(By.name("qualify")).click();
						test.log(LogStatus.PASS, "Clicked on Qualify button ");

						if (Collateral.equalsIgnoreCase("ACH")) {

							driver.findElement(By
									.xpath(" /html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/table/tbody/tr[8]/td[2]/select"))
									.sendKeys(ESign_CourtesyCallConsent);
							test.log(LogStatus.PASS, "Courtesy Call Consent selected as " + ESign_CourtesyCallConsent);

							Thread.sleep(2000);
							driver.findElement(By.xpath(" //*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Esign preference selected as " + ESign_Preference);

						}

						if (Collateral.equalsIgnoreCase("CHECK")) {

							driver.findElement(By
									.xpath(" /html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/table/tbody/tr[8]/td[2]/select"))
									.sendKeys(ESign_CourtesyCallConsent);
							test.log(LogStatus.PASS, "Courtesy Call Consent selected as " + ESign_CourtesyCallConsent);

							Thread.sleep(2000);
							driver.findElement(By.xpath(" //*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Esign preference selected as " + ESign_Preference);
							driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
							test.log(LogStatus.PASS, "Chkg Acct Number enterd" + last4cheknum);
							driver.findElement(By
									.xpath(" /html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr/td/select"))
									.sendKeys(No_of_checks);
							test.log(LogStatus.PASS, "Number of checks " + No_of_checks);
							Thread.sleep(2000);

							driver.findElement(By.xpath(" //*[@id='chkNbr0']")).sendKeys(ESign_CheckNbr);
							test.log(LogStatus.PASS, "Check number enterd as " + ESign_CheckNbr);
						}
						if (Collateral.equalsIgnoreCase("DEBIT CARD"))

						{
							driver.findElement(locator(prop.getProperty("refinance_courtesy_call")))
									.sendKeys(ESign_CourtesyCallConsent);
							test.log(LogStatus.PASS, "Courtesy Call Consent selected as " + ESign_CourtesyCallConsent);
							Thread.sleep(2000);
							driver.findElement(By.xpath(" //*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Esign preference selected as " + ESign_Preference);
							driver.findElement(locator(prop.getProperty("refinance_select_card"))).sendKeys("New Card");
							test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");
							Thread.sleep(2000);

							driver.findElement(locator(prop.getProperty("refinance_select_card_type")))
									.sendKeys(cardType);
							test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);

							driver.findElement(locator(prop.getProperty("refinance_card_number"))).sendKeys(cardNumber);
							test.log(LogStatus.PASS, "Card number is :" + cardNumber);

							driver.findElement(locator(prop.getProperty("refinance_exp_month"))).sendKeys(cardEx_month);
							test.log(LogStatus.PASS, "Enterd Expiry month as" + cardEx_month);
							try {
								Alert alert = driver.switchTo().alert();

								alert.accept();
								// if alert present, accept and move on.

							} catch (Exception e) {
								// do what you normally would if you didn't have
								// the alert.
							}

							driver.findElement(locator(prop.getProperty("refinance_exp_year"))).sendKeys(cardEx_Year);
							test.log(LogStatus.PASS, "Entered Expiry year as" + cardEx_Year);
							try {
								Alert alert = driver.switchTo().alert();

								alert.accept();
								// if alert present, accept and move on.

							} catch (Exception e) {
								// do what you normally would if you didn't have
								// the alert.
							}

							driver.findElement(locator(prop.getProperty("refinance_cvv"))).sendKeys(cvv);
							test.log(LogStatus.PASS, "Enterd CVV as " + cvv);
							driver.findElement(locator(prop.getProperty("refinance_card_holder_name")))
									.sendKeys(CardHolderName);
							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

							driver.findElement(locator(prop.getProperty("refinance_dc_card_add"))).click();
							test.log(LogStatus.PASS, "Clicked on add card button ");

						}

						driver.findElement(By.xpath("//*[@id='tenderTypeId']/select")).sendKeys(ESign_DisbType);
						test.log(LogStatus.PASS, "Tender type is " + ESign_DisbType);

						// *[@id="tenderAmtStyle"]/td[2]/input
						String paymentAmount = driver.findElement(locator(prop.getProperty("refinance_payment_amount")))
								.getAttribute("value");
						driver.findElement(By.xpath("//*[@id='tenderAmtStyle']/td[2]/input")).sendKeys(paymentAmount);
						test.log(LogStatus.PASS, "Tender amount is " + paymentAmount);

						String rebate = driver.findElement(locator(prop.getProperty("refinance_rebate_amount")))
								.getAttribute("value");
						test.log(LogStatus.PASS, "Rebate amount is " + rebate);
						// String stepdownamount=
						// driver.findElement(locator(prop.getProperty("refinance_step_down_amount"))).getAttribute("value");
						test.log(LogStatus.PASS, "Step Same amount is " + pbalstr);
						Thread.sleep(2000);

						// driver.findElement(By.name("requestBean.password")).sendKeys(Esign_Password);
						driver.findElement(locator(prop.getProperty("refinance_password"))).sendKeys(Esign_Password);
						test.log(LogStatus.PASS, "Password enterd as: " + Esign_Password);

						Thread.sleep(5000);
						driver.findElement(locator(prop.getProperty("refinance_finish_button"))).click();
						test.log(LogStatus.PASS, "Clicked on Finish Refinance button ");

						try {
							Alert alert = driver.switchTo().alert();

							alert.accept();
							// if alert present, accept and move on.

						} catch (Exception e) {
							// do what you normally would if you didn't have the
							// alert.
						}
						Thread.sleep(10000);
						try {
							driver.findElement(locator(prop.getProperty("refinance_finish_button"))).click();

						} catch (Exception e) {
							// do what you normally would if you didn't have the
							// alert.
						}
						try {
							Alert alert = driver.switchTo().alert();

							alert.accept();
							// if alert present, accept and move on.

						} catch (Exception e) {
							// do what you normally would if you didn't have the
							// alert.
						}
						String confirm_text = driver
								.findElement(By
										.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[4]/td"))
								.getText();
						test.log(LogStatus.PASS, "" + confirm_text);
						driver.findElement(locator(prop.getProperty("refinance_yes_button"))).click();
						test.log(LogStatus.PASS, "Clicked on Yes button under Confirm screen");
						test.log(LogStatus.PASS, "Refinance SteSame is successful");
						test.log(LogStatus.PASS, "********************************************");

						// else
						{
							// test.log(LogStatus.FAIL, "Steup amount condition
							// Not satisfied ");
						}

						break;
					}
				}

				break;

			}

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// test.log(LogStatus.FAIL, MarkupHelper.createLabel("Getting
				// Encryption from Admin is failed", ExtentColor.RED));
				test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
				String screenshotPath = getScreenhot(driver, "Exception");
								test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.INFO, "Refinance StepSame process is initiated again due to Application sync issue");
				driver.get(prop.getProperty("login_page")); 
				continue;

			}

		}
		if (i == 3) {
			test.log(LogStatus.FAIL, "Store setup is failed");
			Assert.assertTrue(false);

		}
	}
}
