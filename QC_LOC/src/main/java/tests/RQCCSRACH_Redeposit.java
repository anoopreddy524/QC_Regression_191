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


public class RQCCSRACH_Redeposit extends QCStore{
	

	public static void achredeposit(String SSN,String AppURL){
	
	
		int i;
		for(i=0;i<3;i++)
		{
			
		try{
			
				int lastrow=TestData.getLastRow("ACH_Redeposit");
				String sheetName="ACH_Redeposit";

					for(int row=2;row<=lastrow;row++)
							{		
								String RegSSN = TestData.getCellData(sheetName,"SSN",row);
								if(SSN.equals(RegSSN))
								{
								
						        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
						        String ReasonForReturn = TestData.getCellData(sheetName,"ReasonForReturn",row);
						        
						        encryption_store_no = TestData.getCellData(sheetName, "encryption_store_no", row);
						       
								        String SSN1 = SSN.substring(0, 3);
								        String SSN2 = SSN.substring(3,5);
								        String SSN3 = SSN.substring(5,9);
						       Thread.sleep(4000);
								//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
								test.log(LogStatus.INFO, "ACH Redeposit process is initiated");
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
										
	                                  //ACH Redeposit Start
											Thread.sleep(1000);
											driver.switchTo().defaultContent();
											driver.switchTo().frame("mainFrame");
											driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
											
											driver.findElement(By.linkText("ACH")).click();
											
											test.log(LogStatus.PASS, "Clicked on ACH tab");
											
											//driver.switchTo().frame("main");
											
											Thread.sleep(5000);
											
											driver.findElement(By.xpath("//*[@id='9881909175']/a")).click();
											//*[@id="9881909175"]/a
											
											test.log(LogStatus.PASS, "Clicked on LOC link");
											
											Thread.sleep(5000);
											
											driver.findElement(By.xpath("//*[@id='9881909178']/a")).click();
											
											test.log(LogStatus.PASS, "Clicked on Redeposit");
											
											Thread.sleep(5000);
											
											driver.switchTo().frame("main");
											
											driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_number);
											
											test.log(LogStatus.PASS, "Loan Number entered is :" +loan_number);
											
											Thread.sleep(1000);
											
											driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table[2]/tbody/tr/td[2]/input")).click();
											
											test.log(LogStatus.PASS, "Clicked on Submit Button");
											
											Thread.sleep(8000);
											
											Thread.sleep(500);

											driver.switchTo().defaultContent();

											driver.switchTo().frame("mainFrame");

											driver.switchTo().frame("main");
											
											Thread.sleep(500);

											driver.findElement(By.name("requestBean.chkName")).click();
											
											test.log(LogStatus.PASS, "Clicked on WebCheck box");
											
											driver.findElement(By.name("CmdReturnPosting")).click();
											
											test.log(LogStatus.PASS, "Clicked on Finish LOC ACH Redeposit");
											
											driver.findElement(By.name("Ok")).click();
											
											test.log(LogStatus.PASS, "Clicked on ACH Redeposit Successfull Ok");
											
											test.log(LogStatus.PASS, "<FONT color=green style=Arial> ACH Redeposit Completed Successfully");
											
											
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
					test.log(LogStatus.INFO, "ACH Redeposit process is initiated again due to Application sync issue");
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