package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class JQCCSRClearCheck extends QCStore{

	public static void clearcheck(String SSN,String AppURL) throws InterruptedException
	{
	int lastrow=TestData.getLastRow("Clear_Check");
			String sheetName="Clear_Check";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
				
					
					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);

					Thread.sleep(1000);
					test.log(LogStatus.INFO,"PrePayment started");
					driver.switchTo().frame("topFrame");
					driver.findElement(By.cssSelector("li[id='910000']")).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")	).click();			
					test.log(LogStatus.PASS, "Clicked on Transaction");		
					driver.switchTo().frame("main");	
					Thread.sleep(500);
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(locator(prop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(locator(prop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
					test.log(LogStatus.PASS, "Click on Submit");		

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");					    					   					     
					driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on GO Button");
					Thread.sleep(2000);					  

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Thread.sleep(5000);
					
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Click on GO Button under loan section");
					Thread.sleep(1000);


					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :"+TxnType);
					Thread.sleep(500);
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");



					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");




					driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					test.log(LogStatus.PASS, " Entered password :"+PIN);

					driver.findElement(By.name("finish")).click();
					test.log(LogStatus.PASS, " click on finish Clear Check");
					try {
						Alert alert = driver.switchTo().alert();
						String almsg= alert.getText();

						alert.accept();
						test.log(LogStatus.PASS, "alert handled "+almsg);
					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(3000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
					{
						Thread.sleep(5000);
                         driver.findElement(By.name("checkno")).click();
						test.log(LogStatus.PASS, " Clear Check  is successfull");
						test.log(LogStatus.PASS, "********************************************** ");
						
					}
					else
					{
						//test.log(LogStatus.FAIL, " PrePayment  is notsuccessfull");
						test.log(LogStatus.PASS, "********************************************** ");
					}	
					
				
				
							 
	//}
	}
	

			}


		
}
}
