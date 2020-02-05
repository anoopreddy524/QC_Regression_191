package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class VQCCSRWriteOffDepositReturn extends QCStore {
	public static void writeoff(String SSN, String AppURL) {
		
			try {
				
				int lastrow = TestData.getLastRow("writeoff_Deposit");
				String sheetName = "writeoff_Deposit";

				for (int row = 2; row <= lastrow; row++) {

					// test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR
					// Application is launched", ExtentColor.BLUE));
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					String ProductType=TestData.getCellData(sheetName, "ProductType", row);
					String ReasonsforTransfer = TestData.getCellData(sheetName, "ReasonsforTransfer", row);
					String Comments = TestData.getCellData(sheetName, "Comments", row);
					if (SSN.equals(RegSSN)) {
						 String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					
		       Thread.sleep(4000);
				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
				test.log(LogStatus.INFO, "Deposit_Write off Loan process is initiated");

				driver.switchTo().defaultContent();

		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='940000']")));
		        driver.findElement(By.cssSelector("li[id='940000']")).click();	
					
				test.log(LogStatus.PASS, "Clicked on Account Management");
				Thread.sleep(1000);
				try{
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("li[id='940003']")).click();			
				test.log(LogStatus.PASS, "Clicked on Collection Management");
				}
				catch(Exception e)
				{
					//driver.get("http://192.168.2.203/cc/login/index.jsp");
					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
						
					Thread.sleep(1000);	
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					driver.findElement(By.cssSelector("li[id='911101']")).click();	
					test.log(LogStatus.PASS, "Clicked on Transactions");
				}

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
						Thread.sleep(6000);
						driver.findElement(By.xpath("//*[@id='ach12']/option[6]")).click();
						test.log(LogStatus.PASS, "Loan Nbr selected from List");
						Thread.sleep(6000);
						loan_nbr="10508445";
						//driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_nbr);
						driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_nbr);
						test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_nbr);
						Thread.sleep(500);
						driver.findElement(By.name("Button3")).click();
						test.log(LogStatus.PASS, "Clicked on Search button");
						
						Thread.sleep(10000);									
						
						driver.findElement(By.xpath("//input[@name='myButton' and @class='sortbuttons']")).click();
						
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(5000);	
						
						driver.findElement(By.xpath("//input[@name='button' and @value='WriteOff']")).click();

						test.log(LogStatus.PASS, "Clicked on WriteOff");
						Thread.sleep(10000);
						
						encryption_transaction_nbr = driver.findElement(By.name("customerBean.randomNbr1")).getAttribute("value");				
						test.log(LogStatus.PASS, "Trans Number is" + encryption_transaction_nbr);
						
						
		//Admin Login For Getting Encryption Key
						
						
						String mainwindow2=driver.getWindowHandle();
						VQCAdminEncryption.getEncryption(driver1, SSN, AppURL);
						 Thread.sleep(5000);
						 driver.switchTo().window(mainwindow2);
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

						 
