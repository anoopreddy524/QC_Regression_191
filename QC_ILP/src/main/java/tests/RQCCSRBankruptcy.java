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

public class RQCCSRBankruptcy extends QCStore {
	
	
	public static void bankruptcy(String SSN, String AppURL) {
		
			try {
				
				int lastrow = TestData.getLastRow("Bankruptcy");
				String sheetName = "Bankruptcy";

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
						    
							
						    //loan_number= driver.findElement(locator(RRprop.getProperty("csr_loan_nbr"))).getText();
						    loan_number=driver.findElement(By.xpath("//*[@id='all']/div[1]/table[1]/tbody/tr[3]/td[2]")).getText();
							test.log(LogStatus.PASS, "Loan Number is" + loan_number);
						    //NextDueDate= driver.findElement(locator(RRprop.getProperty("csr_due_date"))).getText();
							NextDueDate=driver.findElement(By.xpath("//*[@id='all']/div[1]/table[1]/tbody/tr[3]/td[5]")).getText();
					        test.log(LogStatus.PASS, "Next due date is "+NextDueDate);
					        
					        driver.close();
							break;
							}
					    }
							driver.switchTo().window(mainwindow);
						
							Thread.sleep(4000);
							
							driver.switchTo().frame("bottom");
							
							 business_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();  
							
							 test.log(LogStatus.PASS, "Businessdate is :"+business_date);
							 String App_date1[] = business_date.split(":");
							 String App_date[] = App_date1[1].split("/");
								System.out.println("business_date");

								Date1 = App_date[0];
								System.out.println("Date 1" + Date1);
								Date2 = App_date[1];
								Date3 = App_date[2];
								Thread.sleep(4000);
				
						 driver.close();
						 
		// ------------------------------------
						
						 break;
					}
								}	
						
						
					}

									catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										test.log(LogStatus.FAIL,"bankrupt failed");

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