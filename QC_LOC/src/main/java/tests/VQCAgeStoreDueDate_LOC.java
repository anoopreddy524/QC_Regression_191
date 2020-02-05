package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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


public class VQCAgeStoreDueDate_LOC extends QCStore{
	public static String NextDueDate;

	public static void runscheduler(String SSN,String AppURL) throws Exception{

		test.log(LogStatus.INFO, "***** Performing Run Scheduler*****");	

		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/CSR/"+FileName);

		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";		
		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				
				String ProductID=TestData.getCellData(sheetName,"ProductID",row);
				
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				driver.switchTo().defaultContent();		
				//Thread.sleep(2000);
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
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
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on GO Button under search results");
				Thread.sleep(5000);
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
					
				}				    
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				if(ProductID.equals("PDL"))
				{
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					  test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					//driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
				}
				if(ProductID.equals("TLP"))
				{
					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
				}

				//  driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on GO Button under loan section");
				Thread.sleep(5000);
				String NextDueDate = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form[1]/table[2]/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[2]/td[4]")).getText();
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}	
				Thread.sleep(5000);
				// String NextDueDate = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form[1]/table[2]/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[2]/td[4]")).getText();
				System.out.println(NextDueDate);
				test.log(LogStatus.PASS, "DueDate is :"+NextDueDate);
				Thread.sleep(3000);
				//driver.switchTo().frame("topFrame");
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				//test.log(LogStatus.INFO, "****running scheduler******");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
				test.log(LogStatus.PASS, "Clicked on Cash Management");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");							
				driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
				test.log(LogStatus.PASS, "Clicked on Start Scheduler");
				Thread.sleep(3000);
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
				//String alert1=   driver.switchTo().alert().getText();
				//test.log(LogStatus.PASS, "Clicked on Finish Loan: "+alert1);

				try { 
					Alert alert = driver.switchTo().alert();

					alert.accept();
					//if alert present, accept and move on.														

				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}
				Thread.sleep(5000);
				WebDriverWait wait = new WebDriverWait(driver, 100000);	
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ok")));
				Thread.sleep(5000);
				driver.findElement(By.name("ok")).click();
				//test.log(Status.PASS, "Clicked on Scheduler Ok");
				test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
				Thread.sleep(5000);
				test.log(LogStatus.INFO, "<FONT color=green>  ****Scheduler completed******");
				test.log(LogStatus.INFO, "Logout Successfully");
				//CSRLoginLogout.login();

			}}}
}