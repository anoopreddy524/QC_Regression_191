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

public class RQCCSRWORecovery extends QCStore {
	
	
	public static void simplewriteoff_recovery(String SSN, String AppURL) {
		
			try {
				
				int lastrow = TestData.getLastRow("Writeoff");
				String sheetName = "Writeoff";

				for (int row = 2; row <= lastrow; row++) {

					
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					
					
					if (SSN.equals(RegSSN)) {
						String UserName = TestData.getCellData(sheetName, "UserName", row);
						String Password = TestData.getCellData(sheetName, "Password", row);
						String PIN = TestData.getCellData(sheetName, "PIN", row);
						// System.out.println(Password);
						encryption_store_no = TestData.getCellData(sheetName, "encryption_store_no", row);
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);
						String ProductType = TestData.getCellData(sheetName, "ProductType", row);
						String ReasonsforTransfer = TestData.getCellData(sheetName, "ReasonsforTransfer", row);
						String Comments = TestData.getCellData(sheetName, "Comments", row);

						DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
						String SSN1 = SSN.substring(0, 3);
						String SSN2 = SSN.substring(3, 5);
						String SSN3 = SSN.substring(5, 9);

						Thread.sleep(4000);
					
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
						String mainwindow=driver.getWindowHandle();
					    driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).click();
					    test.log(LogStatus.PASS, "Clicked on Customer number link");
					    for(String winHandle : driver.getWindowHandles()){
							if(!mainwindow.equalsIgnoreCase(winHandle))
							{
						    driver.switchTo().window(winHandle);
						    
							
						    //loan_number= driver.findElement(locator(Rprop.getProperty("csr_loan_nbr"))).getText();
						    loan_number=driver.findElement(By.xpath("//*[@id='all']/div[1]/table[1]/tbody/tr[3]/td[2]")).getText();
							test.log(LogStatus.PASS, "Loan Number is" + loan_number);
						    //NextDueDate= driver.findElement(locator(Rprop.getProperty("csr_due_date"))).getText();
							NextDueDate=driver.findElement(By.xpath("//*[@id='all']/div[1]/table[1]/tbody/tr[3]/td[5]")).getText();
					        test.log(LogStatus.PASS, "Next due date is "+NextDueDate);
					        driver.close();
							break;
							}
					    }
							driver.switchTo().window(mainwindow);
						
					
						
					//==================================================
						//String loan_nbr = driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[2]")).getText();
						//test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						Thread.sleep(5000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("topFrame");
						//driver.switchTo().frame("main");
		
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));
						Thread.sleep(5000);
						driver.findElement(locator(Rprop.getProperty("borrower_tab"))).click();
						Thread.sleep(2000);

						test.log(LogStatus.PASS, "Clicked on Borrower");

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						
						//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='940010']")));
						//driver.findElement(locator(Rprop.getProperty("collections_link"))).click();
                         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='940010']/a")));
                         driver.findElement(By.xpath("//*[@id='940010']/a")).click();
                         test.log(LogStatus.PASS, "Clicked on Courtesy Call Link");
                         Thread.sleep(5000);
                     	driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
                         driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
 						test.log(LogStatus.PASS, "Product Type Selected as :" + ProductType);
 						Thread.sleep(500);
						driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[28]/td[1]/input")).click();
						                             
						test.log(LogStatus.PASS, "Clicked on Customer search radiobutton");
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@id='ach12']/option[6]")).click();
						                         
						test.log(LogStatus.PASS, "Loan Nbr selected from List");
						Thread.sleep(1000);
						driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_number);
						test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
						Thread.sleep(2000);
 						driver.findElement(By.name("searchajax")).click();
						test.log(LogStatus.PASS, "Clicked on Search button");
						Thread.sleep(10000);
						Thread.sleep(8000);
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SearchResults']/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input")));
						driver.findElement(By.xpath("//*[@id='SearchResults']/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input")).click();
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(5000);	
                        driver.findElement(By.name("transfertocoll")).click();
                        test.log(LogStatus.PASS, "Clicked on transfer to Collection");
                        Thread.sleep(5000);
                        for(String winHandle : driver.getWindowHandles()){
							if(!mainwindow.equalsIgnoreCase(winHandle))
							{
						    driver.switchTo().window(winHandle);
						    driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")).sendKeys(ReasonsforTransfer);
							test.log(LogStatus.PASS, "ReasonsforTransfer :" + ReasonsforTransfer);
							 Thread.sleep(500);
							driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[6]/td[2]/textarea")).sendKeys(Comments);
					        test.log(LogStatus.PASS, "Comment is "+Comments);
					        Thread.sleep(5000);
					        driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[8]/td/input[2]")).click();
					        test.log(LogStatus.PASS, "Clicked on Submit");
					        Thread.sleep(5000);
							try {
								Alert alert = driver.switchTo().alert();

								alert.accept();
								// if alert present, accept and move on.

							} catch (NoAlertPresentException e) {
								// do what you normally would if you didn't have the
								// alert.
							}
							test.log(LogStatus.PASS, "Transfered to Collection");
					        driver.close();
							break;
							}
					    }
							driver.switchTo().window(mainwindow);
                        
							Thread.sleep(10000);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("topFrame");
			// -----------------------------------
							// driver.switchTo().frame("topFrame");
							wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));

							driver.findElement(locator(Rprop.getProperty("borrower_tab"))).click();
							Thread.sleep(2000);

							test.log(LogStatus.PASS, "Clicked on Borrower");

							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='903000']")));
							driver.findElement(locator(Rprop.getProperty("collections_link"))).click();

							test.log(LogStatus.PASS, "Clicked on Collection");
							//Thread.sleep(5000);
 					    Thread.sleep(5000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("name=requestBean.installmentType")));
						Thread.sleep(500);
						driver.findElement(By.name("requestBean.installmentType")).sendKeys(ProductType);
						test.log(LogStatus.PASS, "Product Type Selected as :" + ProductType);
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[22]/td[1]/input")).click();
						test.log(LogStatus.PASS, "Clicked on Customer search radiobutton");
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@id='ach12']/option[6]")).click();
						test.log(LogStatus.PASS, "Loan Nbr selected from List");
						Thread.sleep(2000);
						driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
						test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
						Thread.sleep(1000);
						driver.findElement(By.name("Button3")).click();
						test.log(LogStatus.PASS, "Clicked on Search button");
						//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("name=requestBean.installmentType")));
						Thread.sleep(10000);	
						Thread.sleep(8000);
						driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[19]/input[4]")).click();
						//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(5000);	
						//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[14]/td[2]/table/tbody/tr[2]/td[2]/input")).click();
						//test.log(LogStatus.PASS, "Clicked on Go Writeoff");
						driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[12]/td[2]/table/tbody/tr[2]/td[3]/input")).click();
						test.log(LogStatus.PASS, "Clicked on WriteOff");
						Thread.sleep(10000);
						
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