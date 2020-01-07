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

public class JQC_Redeposit extends QCStore {
	public static void redeposit(String SSN, String AppURL) {
		
			try {
			
				int lastrow = TestData.getLastRow("Redeposit");
				String sheetName = "Redeposit";

				for (int row = 2; row <= lastrow; row++) {

					
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					if (SSN.equals(RegSSN)) {
						String UserName = TestData.getCellData(sheetName, "UserName", row);
						String Password = TestData.getCellData(sheetName, "Password", row);
						String PIN = TestData.getCellData(sheetName, "PIN", row);
						
						encryption_store_no = TestData.getCellData(sheetName, "encryption_store_no", row);
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);
						String ProductType = TestData.getCellData(sheetName, "ProductType", row);

						

						DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
						String SSN1 = SSN.substring(0, 3);
						String SSN2 = SSN.substring(3, 5);
						String SSN3 = SSN.substring(5, 9);

						Thread.sleep(4000);
						

						test.log(LogStatus.INFO, "Redeposit Start");
						driver.switchTo().defaultContent();

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
						driver.switchTo().frame("topFrame");
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
						Thread.sleep(4000);
						driver.findElement(By.cssSelector("li[id='910000']")).click();
						Thread.sleep(6000);
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
						

						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						

						if (ProductID.equals("PDL")) {
							
							
							driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
							test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
						}
						if (ProductID.equals("TLP")) {
							driver.findElement(By
									.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input"))
									.click();
						}

						
						if (ProductID.equals("LOC")) {
							/// html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]
							driver.findElement(By
									.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]"))
									.click();
						}

						String loan_nbr = driver.findElement(locator(Jprop.getProperty("csr_loan_nbr"))).getText();
						test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						Thread.sleep(5000);
						
		// -----------------------------------
						String RepresentmentType = TestData.getCellData(sheetName,"RepresentmentType",row);
						
						
						driver.switchTo().defaultContent();

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
						driver.switchTo().frame("topFrame");
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
						Thread.sleep(4000);
						driver.findElement(By.cssSelector("li[id='910000']")).click();
						Thread.sleep(5000);
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.findElement(By.partialLinkText("Collateral Checks")).click();
						test.log(LogStatus.PASS, "Clicked on collateral check types");
						Thread.sleep(5000);
						driver.findElement(By.partialLinkText("Payday Loan")).click();
						test.log(LogStatus.PASS, "Clicked on Paydayloan"); 
						Thread.sleep(5000);
						driver.findElement(By.partialLinkText("ReDeposit")).click();
						test.log(LogStatus.PASS, "Clicked on Redeposit");

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						
						  test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						
						  
						driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_nbr);
						test.log(LogStatus.PASS, "Enterd loan number is :"+loan_nbr);
						driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Click on submit button");
						//String loan_number="7779583";
						
						test.log(LogStatus.PASS, "Getting loan number from table"+loan_nbr);
						if(loan_nbr.equals(loan_nbr)){
						
							driver.findElement(By.name("requestBean.chkName")).click();
							test.log(LogStatus.PASS, "clicking on check box to selcet customet having loan number"+loan_nbr);
							
							driver.findElement(By.name("dispRepresentmentType")).sendKeys(RepresentmentType);;
							
							test.log(LogStatus.PASS, "Selected representment type as :"+RepresentmentType);
							
							driver.findElement(By.name("CmdReturnPosting")).click();
							test.log(LogStatus.PASS, "Click on submit button");
						}
						else{
							
						}
						
						
						test.log(LogStatus.PASS, " Redeposit  is successfull");
						test.log(LogStatus.PASS, "********************************************** ");
						
						driver.close();
						 
		// ------------------------------------
						
						 break;
					}
								}	
						
						
					}

									catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										test.log(LogStatus.FAIL,"Redeposit failed");

									}

						}
					}
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
