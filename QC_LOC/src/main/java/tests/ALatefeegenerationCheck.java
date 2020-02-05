package tests;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.relevantcodes.extentreports.LogStatus;

public class ALatefeegenerationCheck extends QCStore{
	public static String NextDueDate;

	public static void transactioncheck(String SSN,String AppURL) throws InterruptedException{

				int lastrow=TestData.getLastRow("NewLoan");
				String sheetName="NewLoan";

					for(int row=2;row<=lastrow;row++)
							{		
								String RegSSN = TestData.getCellData(sheetName,"SSN",row);
								if(SSN.equals(RegSSN))
								{
								
						       // String ProductID = TestData.getCellData(sheetName,"ProductID",row);
						       
								        String SSN1 = SSN.substring(0, 3);
								        String SSN2 = SSN.substring(3,5);
								        String SSN3 = SSN.substring(5,9);
						       Thread.sleep(4000);
								//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
								test.log(LogStatus.INFO, "Age Store Due Date process is initiated");

								driver.switchTo().frame("bottom");
								String Str_date = driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]"))
										.getText();
								String store_date[] = Str_date.split(":");
								business_date = store_date[1].trim();
								test.log(LogStatus.PASS, "Business date is :" + business_date);

								driver.switchTo().defaultContent();

								
						        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
								driver.switchTo().frame("topFrame");
								wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
						        driver.findElement(By.cssSelector("li[id='910000']")).click();	
									
								test.log(LogStatus.PASS, "Clicked on Loan Transactions");
								
							
								driver.switchTo().defaultContent();
								Thread.sleep(1000);
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
								test.log(LogStatus.PASS, "Clicked on GO Button under search results");
								Thread.sleep(1000);
								driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
								test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
								Thread.sleep(1000);
								driver.findElement(By.name("transactionList")).sendKeys("History");
								test.log(LogStatus.PASS, "Transaction Type is selected as History");
								driver.findElement(By.name("button")).click();
								test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
								NextDueDate =  driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[4]/td/span[2]")).getText();
								test.log(LogStatus.PASS, "Next due date is " + NextDueDate);
								
								String transaction=driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr[8]/td[4]")).getText();
								if(transaction.equalsIgnoreCase("Late Fee")){
									
									test.log(LogStatus.PASS, "Late Fee transaction is suceesfull" );
								}
								else{
									test.log(LogStatus.FAIL, "Late fee transaction failed");
								}	 
										
												 test.log(LogStatus.PASS,"************************************************");

												
												
							break;
							
						 
					}
				}
			



					
				
		
	
}
}