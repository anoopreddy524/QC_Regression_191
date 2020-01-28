package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class QCSignaturLoanDefault extends QCStore {
	public static void signaturLoanDefault(String SSN, String AppURL) throws Exception {
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
					test.log(LogStatus.INFO, "Age Store Due Date process is initiated");

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
						driver.get("http://192.168.2.203/cc/login/index.jsp");
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
				    
				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");

					    String loan_nbr= driver.findElement(locator(prop.getProperty("loan_nbr"))).getText();
						test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						driver.findElement(locator(prop.getProperty("clear_go"))).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
						 String status= driver.findElement(locator(prop.getProperty("default"))).getText();
						 if(status.equalsIgnoreCase("Default")){
							 test.log(LogStatus.PASS,"Verify Default successfully");
					    	 test.log(LogStatus.PASS, "***********************************************");
						 }else{
							 test.log(LogStatus.FAIL,"Verify Default not successfully");
						 }
						 
						}
					}
	}
	}
	
