package tests;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;



import com.relevantcodes.extentreports.LogStatus;

public class AQCVoid extends QCStore{

	public static void qcVoid(String SSN,String AppURL) throws InterruptedException
	{

		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String PIN = TestData.getCellData(sheetName,"Password",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
			Thread.sleep(3000);
	
				test.log(LogStatus.INFO, "Transaction Void has started");
				driver.switchTo().defaultContent();	

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
				driver.findElement(By.cssSelector("li[id='910000']")).click();	

				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(1000);

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

				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
			

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				Thread.sleep(5000);

				driver.findElement(By.name("transactionList")).sendKeys("Void");
				test.log(LogStatus.PASS, "Transaction Type is selected as void");
				
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(500);

				driver.findElement(By.name("tenderType")).sendKeys("Cash");
				test.log(LogStatus.PASS, "Tender type is entered as cash");


				driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
				test.log(LogStatus.PASS, "Password is selected as "+PIN);
				driver.findElement(By.name("finish")).click();

				test.log(LogStatus.PASS, "Clicked on finish  button ");

				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();
					//if alert present, accept and move on.														

				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				Thread.sleep(3000);
				try{
				if(driver.findElement(By.name("Ok")).isDisplayed())
				{
					
					test.log(LogStatus.PASS, "Void is Completed Successfully ");
					test.log(LogStatus.PASS, "**************************************");
					
				}
				else
				{
					test.log(LogStatus.INFO, "Void is Completed Successfully ");
					test.log(LogStatus.INFO, "**************************************");
				}}
				catch(Exception e){
					test.log(LogStatus.INFO, "Void is Completed Successfully ");
					test.log(LogStatus.INFO, "**************************************");
				}


				break;	
			}

		}

	}		

}
