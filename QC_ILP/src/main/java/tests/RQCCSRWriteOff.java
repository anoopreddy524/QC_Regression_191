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

public class RQCCSRWriteOff extends QCStore {
	public static void writeoff(String SSN, String AppURL) {
		/*int i;
		for (i = 0; i < 3; i++) {
			driver.get("http://192.168.2.203/cc/login/index.jsp");*/
			try {
				// String FileName=
				// prop.getProperty("QC_Store_NewLoan_file_name");

				// ExcelNew TestData = new
				// ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");
				int lastrow = TestData.getLastRow("Writeoff");
				String sheetName = "Writeoff";

				for (int row = 2; row <= lastrow; row++) {

					// test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR
					// Application is launched", ExtentColor.BLUE));
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					if (SSN.equals(RegSSN)) {
						String UserName = TestData.getCellData(sheetName, "UserName", row);
						String Password = TestData.getCellData(sheetName, "Password", row);
						String PIN = TestData.getCellData(sheetName, "PIN", row);
						// System.out.println(Password);
						encryption_store_no = TestData.getCellData(sheetName, "encryption_store_no", row);
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);
						String ProductType = TestData.getCellData(sheetName, "ProductType", row);

						// String CountofDollarCoins =
						// TestData.getCellData(sheetName,"CountofDollarCoins",row);

						DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
						String SSN1 = SSN.substring(0, 3);
						String SSN2 = SSN.substring(3, 5);
						String SSN3 = SSN.substring(5, 9);

						Thread.sleep(4000);
						// test.log(LogStatus.INFO,
						// MarkupHelper.createLabel("Age Store process is
						// initiated", ExtentColor.BLUE));
						// test.log(LogStatus.INFO, "Age Store process is
						// initiated");

						test.log(LogStatus.INFO, "WriteOff process");
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

						// String loan_nbr=
						// driver.findElement(locator(prop.getProperty("csr_loan_nbr"))).getText();
						// test.log(LogStatus.PASS, "Loan Number is" +
						// loan_nbr);
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

						if (ProductID.equals("PDL")) {
							// driver.findElement(By.xpath("
							// /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
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

						String loan_nbr = driver.findElement(locator(prop.getProperty("csr_loan_nbr"))).getText();
						test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						Thread.sleep(5000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("topFrame");
		// -----------------------------------
						// driver.switchTo().frame("topFrame");
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));

						driver.findElement(locator(prop.getProperty("borrower_tab"))).click();
						Thread.sleep(2000);

						test.log(LogStatus.PASS, "Clicked on Borrower");

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='903000']")));
						driver.findElement(locator(prop.getProperty("collections_link"))).click();

						test.log(LogStatus.PASS, "Clicked on Collection");
						Thread.sleep(5000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("name=requestBean.installmentType")));
						Thread.sleep(500);
						driver.findElement(By.name("requestBean.installmentType")).sendKeys(ProductType);
						test.log(LogStatus.PASS, "Product Type Selected as :" + ProductType);
						Thread.sleep(500);
						driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[22]/td[1]/input")).click();
						test.log(LogStatus.PASS, "Clicked on Customer search radiobutton");
						Thread.sleep(500);
						driver.findElement(By.xpath("//*[@id='ach12']/option[6]")).click();
						test.log(LogStatus.PASS, "Loan Nbr selected from List");
						Thread.sleep(500);
						driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_nbr);
						test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_nbr);
						Thread.sleep(500);
						driver.findElement(By.name("Button3")).click();
						test.log(LogStatus.PASS, "Clicked on Search button");
						//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("name=requestBean.installmentType")));
						Thread.sleep(10000);									
						driver.findElement(By.xpath("//*[@id='"+loan_nbr+"']/td[19]/input[4]")).click();
						//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(5000);	
						driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[14]/td[2]/table/tbody/tr[2]/td[2]/input")).click();
						test.log(LogStatus.PASS, "Clicked on Go Writeoff");
						Thread.sleep(5000);
						
						encryption_transaction_nbr = driver.findElement(By.name("customerBean.randomNbr1")).getAttribute("value");				
						test.log(LogStatus.PASS, "Trans Number is" + encryption_transaction_nbr);
						
		//Admin Login For Getting Encryption Key
						
						// driver1 = new InternetExplorerDriver();
						 RAdminLoginForEncryption.getEncryption(driver,SSN, AppURL);
						 Thread.sleep(5000);
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						 Thread.sleep(5000);
						 driver.findElement(By.name("customerBean.eanNbr1")).sendKeys(Eankey);
						 test.log(LogStatus.PASS, "Encryption number enter is :" +Eankey);
						 driver.findElement(By.name("SubButton")).click();
						 test.log(LogStatus.PASS, "Clicked on Submit Button");
						 Thread.sleep(5000);
						 driver.findElement(By.name("checkok")).click();
						 test.log(LogStatus.PASS, "Clicked on Ok");
						 test.log(LogStatus.PASS, "WriteOff Completed Successfully");
						 driver.close();
						 
		// ------------------------------------
						
						 break;
					}
								}	
						
						
					}

									catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										test.log(LogStatus.FAIL,"Writeoff failed");

									}

						}
					}
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
/*
						break;
					}

				}

				break;

			} catch (Exception e) {
				// TODO Auto-generated catch block
				// test.log(LogStatus.FAIL, MarkupHelper.createLabel("CSR login
				// is failed", ExtentColor.RED));
				// test.log(LogStatus.FAIL,"EODDeposit is failed");
				test.log(LogStatus.INFO, "" + e);
				test.log(LogStatus.INFO, "EODDeposit process is initiated again due to Application sync issue");

				e.printStackTrace();
				continue;
			}

		}
		if (i == 3) {
			test.log(LogStatus.FAIL, "EODDeposit process is failed");

		}
	}
}
*/