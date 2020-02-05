package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import com.relevantcodes.extentreports.LogStatus;


public class JQCAgeStore extends QCStore{

	public static void ageStore(String SSN,String AppURL){
		
		 
		try{
			int lastrow=TestData.getLastRow("New_Loan");
				String sheetName="New_Loan";

					for(int row=2;row<=lastrow;row++)
							{		
								String RegSSN = TestData.getCellData(sheetName,"SSN",row);
								if(SSN.equals(RegSSN))
								{
										
						        

								        String SSN1 = SSN.substring(0, 3);
								        String SSN2 = SSN.substring(3,5);
								        String SSN3 = SSN.substring(5,9);			       
								
								        
						       Thread.sleep(4000);

								test.log(LogStatus.INFO, "Age Store process is initiated");

								driver.switchTo().defaultContent();	
								
						        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
								driver.switchTo().frame("topFrame");
								wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
						        driver.findElement(By.cssSelector("li[id='910000']")).click();	
	
								test.log(LogStatus.PASS, "Clicked on Loan Transactions");
								Thread.sleep(1000);
								driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
								driver.switchTo().defaultContent();
								driver.switchTo().frame("mainFrame");
								driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
	
							    driver.findElement(By.name("button")).click();
								test.log(LogStatus.PASS, "Clicked on GO Button under Search results");
						
									  driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
									  test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
								   
								    Thread.sleep(5000);

										 NextDueDate = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form[1]/table[2]/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[2]/td[4]")).getText();
  									
									 System.out.println(NextDueDate);
									 test.log(LogStatus.PASS, "Age Store Date is :"+NextDueDate);
									 Thread.sleep(5000);
									 
										
										for(String winHandle1 : driver.getWindowHandles()){
											    driver.switchTo().window(winHandle1);
												}				    
										driver.switchTo().defaultContent();
										 driver.switchTo().frame("topFrame");
									 driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
												 test.log(LogStatus.PASS, "Clicked on Cash Management");
												 driver.switchTo().defaultContent();
												driver.switchTo().frame("mainFrame");							
												driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
												test.log(LogStatus.PASS, "Clicked on Start Scheduler");
												Thread.sleep(5000);
												for( String winHandle1 : driver.getWindowHandles())
												{
												    driver.switchTo().window(winHandle1);
												}			
												 driver.switchTo().defaultContent();
												 driver.switchTo().frame("mainFrame");
												 driver.switchTo().frame("main");
												String Due_Date[] =NextDueDate.split("/");
										        String Due_Date1 = Due_Date[0];
										        String Due_Date2 = Due_Date[1];
										        String Due_Date3 = Due_Date[2];
										        driver.findElement(By.name("endMonth")).sendKeys(Due_Date1);
										        test.log(LogStatus.PASS, "Month is entered: "+Due_Date1);
												driver.findElement(By.name("endDay")).sendKeys(Due_Date2);
												test.log(LogStatus.PASS, "Date is entered: "+Due_Date2);
												driver.findElement(By.name("endYear")).sendKeys(Due_Date3);
												test.log(LogStatus.PASS, "Year is entered: "+Due_Date3);
												driver.findElement(By.name("runSchedulerBtn")).click();
												test.log(LogStatus.PASS, "Clicked on Run Scheduler");
												Thread.sleep(500);

												 
												 try { 
													    Alert alert = driver.switchTo().alert();
													
													    alert.accept();
													    //if alert present, accept and move on.														
														
													}
													catch (Exception e) {
													    //do what you normally would if you didn't have the alert.
													}
												 Thread.sleep(30000);
												
												 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ok")));
												 Thread.sleep(5000);
												 driver.findElement(By.name("ok")).click();

												 test.log(LogStatus.PASS,"<FONT color=green style=Arial> Clicked on Scheduler Ok Successfully");
												 test.log(LogStatus.PASS,"************************************************");

												 Thread.sleep(5000);
												 driver.close();
							
							
						 
					}
				}
			



					
				
		}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Borrower Registration is failed", ExtentColor.RED));
					test.log(LogStatus.FAIL, "Borrower Registration is failed");


				}

	}
}