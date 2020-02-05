package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;


public class RQCCSR_LOC_ManualDefault_EOD extends QCStore{
	

	public static void manualdefaulteod(String SSN,String AppURL){
	
	
		int i;
		for(i=0;i<3;i++)
		{
			
		try{
			
				int lastrow=TestData.getLastRow("ManualDefault");
				String sheetName="ManualDefault";

					for(int row=2;row<=lastrow;row++)
							{		
								String RegSSN = TestData.getCellData(sheetName,"SSN",row);
								if(SSN.equals(RegSSN))
								{
								
						        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
						        encryption_store_no = TestData.getCellData(sheetName, "encryption_store_no", row);
						       
								        String SSN1 = SSN.substring(0, 3);
								        String SSN2 = SSN.substring(3,5);
								        String SSN3 = SSN.substring(5,9);
						       Thread.sleep(4000);
								//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
								test.log(LogStatus.INFO, "Manual Default process is initiated");
								driver.switchTo().frame("bottom");
								String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
								String store_date[]=Str_date.split(":");
								String business_date=store_date[1].trim();
								test.log(LogStatus.PASS, "Business date is :"+business_date);
								driver.switchTo().defaultContent();	
								
						        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
								driver.switchTo().frame("topFrame");
								wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
						        driver.findElement(By.cssSelector("li[id='910000']")).click();	
									
								test.log(LogStatus.PASS, "Clicked on Loan Transactions");
								Thread.sleep(1000);
								try{
								driver.switchTo().defaultContent();
								driver.switchTo().frame("mainFrame");
								driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
								driver.findElement(By.cssSelector("li[id='911101']")).click();			
								test.log(LogStatus.PASS, "Clicked on Transactions");
								}
								catch(Exception e)
								{
									driver.get(csrloginpage);
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
								driver.switchTo().frame("main");		
								driver.findElement(By.name("ssn1")).sendKeys(SSN1);
								test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
								driver.findElement(By.name("ssn2")).sendKeys(SSN2);
								test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
								driver.findElement(By.name("ssn3")).sendKeys(SSN3);
								test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
								driver.findElement(By.name("submit1")).click();
								test.log(LogStatus.PASS, "Click on submit Button");		
								for(String winHandle : driver.getWindowHandles()){
							    driver.switchTo().window(winHandle);
								}
							    driver.switchTo().defaultContent();
							    driver.switchTo().frame("mainFrame");
							    driver.switchTo().frame("main");
							   
							    String mainwindow=driver.getWindowHandle();
							            customer_number=driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).getText();
							            test.log(LogStatus.PASS, "Customer Nbr is :" +customer_number);
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
											//NextDueDate=driver.findElement(By.xpath("//*[@id='all']/div[1]/table[1]/tbody/tr[3]/td[5]")).getText();
									        //test.log(LogStatus.PASS, "Next due date is "+NextDueDate);
									        driver.close();
											break;
											}
									    }
											driver.switchTo().window(mainwindow);
										
	                                  //Manual Default Start
											Thread.sleep(1000);
											driver.switchTo().defaultContent();
											driver.switchTo().frame("mainFrame");
											driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
											
											driver.findElement(By.xpath("//*[@id='9881908122']/a")).click();
											test.log(LogStatus.PASS, "Clicked on Manual Default tab");
											
											driver.switchTo().frame("main");
											
											driver.findElement(By.name("requestBean.cusNbr")).sendKeys(customer_number);
											test.log(LogStatus.PASS, "Customer Nbr Entered is :" +customer_number);
											
											driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_number);
											test.log(LogStatus.PASS, "Loan Nbr Entered is :" +loan_number);
											
											driver.findElement(By.name("submit")).click();
											test.log(LogStatus.PASS, "Clicked on Submit");
											Thread.sleep(8000);
											encryption_transaction_nbr = driver.findElement(By.name("requestBean.origTranNbr")).getAttribute("value");				
											test.log(LogStatus.PASS, "Trans Number is" + encryption_transaction_nbr);
											
							//Admin Login For Getting Encryption Key
											
											// driver1 = new InternetExplorerDriver();
											 RAdminLoginForEncryption.getEncryption(driver,SSN, AppURL);
											 Thread.sleep(5000);
											 driver.switchTo().defaultContent();
											 driver.switchTo().frame("mainFrame");
											 driver.switchTo().frame("main");
											 Thread.sleep(5000);
											 driver.findElement(By.name("requestBean.encryptionKey")).sendKeys(Eankey);
											 test.log(LogStatus.PASS, "Encryption number enter is :" +Eankey);
											 Thread.sleep(5000);
											 driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[4]/tbody/tr[4]/td/input")).click();
											 test.log(LogStatus.PASS, "Clicked on Finish Manual Default");
											 Thread.sleep(5000);
											 driver.findElement(By.name("Ok")).click();
											 test.log(LogStatus.PASS, "Clicked on Transaction Completed Successfully Ok");
											 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Manual Default Completed Successfully");
											 driver.close();
											
						
								
							break;
							
						 
					}
				}
			



			break;		
				
		}
				
		catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Borrower Registration is failed", ExtentColor.RED));
					test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
					test.log(LogStatus.INFO, "Age store Due Date is process is initiated again due to Application sync issue");
					driver.get(csrloginpage);
					continue;


				}

	}
		if(i==3)
		{
			//Assert.assertTrue(false);
			test.log(LogStatus.FAIL, "Manual Default  is failed");
			Assert.assertTrue(false);
			
	
		}
}
}