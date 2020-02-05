package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class SQCDepositMenu extends QCStore{
	public static void depositMenu(String SSN,String AppURL) throws InterruptedException
	{
		 
				int lastrow=TestData.getLastRow("Deposit");
				String sheetName="Deposit";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
					
					String RepresentmentType = TestData.getCellData(sheetName,"RepresentmentType",row);
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			        String StateID = TestData.getCellData(sheetName,"StateID",row);
			        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
			        String Header = StateID+ "_" + ProductID;	      
			        String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
			        System.out.println(columnname);
			       String LastName = TestData.getCellData(sheetName,"LastName",row);
			 	       
			       String Ctc_PrimaryPhone = TestData.getCellData(sheetName,"Ctc_PrimaryPhone",row);
	
			  
			       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
			  
						   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					        String PP1 = Ctc_PrimaryPhone.substring(0, 3);
					        String PP2 = Ctc_PrimaryPhone.substring(3, 6);
					        String PP3 = Ctc_PrimaryPhone.substring(6, 10);
					     		       
					
			       Thread.sleep(4000);
					//test.log(LogStatus.INFO, MarkupHelper.createLabel("Deposit from CSR has initiated", ExtentColor.BLUE));
					test.log(LogStatus.INFO, "Deposit_Bulk(Menu) from CSR has initiated");

					driver.switchTo().frame("bottom");
					String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					String store_date[]=Str_date.split(":");
					String business_date=store_date[1];
					test.log(LogStatus.PASS, ""+Str_date);
					
					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
					/*driver.switchTo().defaultContent();				
					driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();	*/		
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
				
					driver.findElement(By.cssSelector("li[id='911101']")).click();			
					test.log(LogStatus.PASS, "Clicked on Transactions");		
					driver.switchTo().frame("main");		
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(By.name("ssn2")).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(By.name("ssn3")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(By.name("submit1")).click();
					test.log(LogStatus.PASS, "Click on submit Button");		
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					
								String mainwindow=driver.getWindowHandle();
								
							    driver.switchTo().defaultContent();
							    driver.switchTo().frame("mainFrame");
							    driver.switchTo().frame("main");
							    driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).click();
							    test.log(LogStatus.PASS, "Clicked on Customer number link");
								
							    for (String winHandle : driver.getWindowHandles()) {
									if(!mainwindow.equalsIgnoreCase(winHandle)) {
										driver.switchTo().window(winHandle);
										
				   loan_nbr= driver.findElement(locator(Aprop.getProperty("csr_loan_nbr"))).getText();
				   test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
				   driver.close();
				   break;
									}
								}
								driver.switchTo().window(mainwindow);
								Thread.sleep(2000);
								 driver.switchTo().defaultContent();
								    driver.switchTo().frame("mainFrame");
								    driver.switchTo().frame("main");
				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
					    driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					
					    Thread.sleep(1000);
					    
						   driver.switchTo().defaultContent();
						   driver.switchTo().frame("mainFrame");
						
							
							if(ESign_CollateralType.equalsIgnoreCase("ACH"))
							{
							// driver.findElement(By.xpath("//*[@id='913000']/a")).click();
							 driver.findElement(By.linkText("ACH")).click();
							 test.log(LogStatus.PASS, "Mouse hover on collateral Clicked on ACH");
							 Thread.sleep(3000);
							 //driver.findElement(By.xpath("//*[@id='9881909175']/a")).click();
							 driver.findElement(By.linkText("LOC")).click();
							 test.log(LogStatus.PASS, " Clicked on LOC");
							 Thread.sleep(3000);
							 //driver.findElement(By.xpath("//*[@id='9881909177']/a")).click();
							 driver.findElement(By.linkText("ACH Deposit")).click();
							 test.log(LogStatus.PASS, "Clicked on ACH deposit");
							 Thread.sleep(3000);
							 							 
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 driver.findElement(locator(Aprop.getProperty("deposit_loan_nbr"))).sendKeys(loan_nbr);
							 test.log(LogStatus.PASS, "Entered Loan number as "+ loan_nbr);
							 driver.findElement(locator(Aprop.getProperty("deposit_submit_btn"))).click();
							 test.log(LogStatus.PASS, "Clicked on Submit button ");
							
							 driver.findElement(locator(Aprop.getProperty("deposit_check_box"))).click();
							 test.log(LogStatus.PASS, "Selected the radio button ");
							 
							 //driver.findElement(locator(Aprop.getProperty("finish_ach_deposit"))).click();
							 driver.findElement(By.xpath("//*[@id='CmdReturnPosting']")).click();
							 test.log(LogStatus.PASS, "Clicked on  "+ESign_CollateralType+"Deposit button");
							 Thread.sleep(800);
							 if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/p")).isDisplayed()){
								 String status=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/p")).getText();
								 test.log(LogStatus.PASS,"Status is" +status);
								 
								 test.log(LogStatus.PASS, " <FONT color=green style=Arial> Deposit_Bulk from CSR is Completed successfully With"+ ESign_CollateralType);
							     test.log(LogStatus.PASS, "********************************************** ");
							 }
							 else
							 {
								 test.log(LogStatus.FAIL,"Status Message Not displayed"); 
							 }
							 
							}
							
					
							
							if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
							{
								 //driver.findElement(locator(Aprop.getProperty("DC"))).click();
								 driver.findElement(By.linkText("Debit Cards")).click();
								 test.log(LogStatus.PASS, " Mouse hover on collateral Debit Card menu");
								 Thread.sleep(3000);
								 //driver.findElement(locator(Aprop.getProperty("DC_LOC"))).click();
								 driver.findElement(By.linkText("LOC")).click();
								 test.log(LogStatus.PASS, " Clicked on LOC menu");
								 Thread.sleep(3000);
								 //driver.findElement(locator(Aprop.getProperty("DC_LOC_Deposit"))).click();
								 driver.findElement(By.linkText("Deposit")).click();
								 test.log(LogStatus.PASS, " click on LOC_Deposit menu");
								 Thread.sleep(3000);
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 driver.findElement(locator(Aprop.getProperty("deposit_loan_nbr"))).sendKeys(loan_nbr);
								 test.log(LogStatus.PASS, "Entered Loan number as "+ loan_nbr);
								 driver.findElement(locator(Aprop.getProperty("admin_search"))).click();
								 test.log(LogStatus.PASS, "Clicked on submit button");
								 Thread.sleep(2000);
								 driver.findElement(locator(Aprop.getProperty("deposit_check_box"))).click();
								 test.log(LogStatus.PASS, "Clicked on Check_Box");
								 driver.findElement(locator(Aprop.getProperty("Finish_LOC_Deposit"))).click();
								 test.log(LogStatus.PASS, "Clicked on  "+ESign_CollateralType+"Fnish Deposit Button");
								 
								 Thread.sleep(800);
								 if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input")).isDisplayed()){
									driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input")).click();
									test.log(LogStatus.PASS,"Transaction Completed Sucsessfully");
									 
									 test.log(LogStatus.PASS, " <FONT color=green style=Arial> Deposit_Bulk from CSR is Completed successfully With" +ESign_CollateralType);
								     test.log(LogStatus.PASS, "********************************************** ");
								 }
								 else
								 {
									 test.log(LogStatus.FAIL,"Status Message Not displayed"); 
								 }
								 
								}						 
					}
				}
				

	}

	}



