package tests;
//This class is for age the store to due date
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class CSRACHDeposit extends QCStore {


	public static void achDeposit(String SSN,String AppURL) throws Exception{
		
		test.log(LogStatus.INFO, "****performing Ach deposit******");	
		
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";		
		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String ESign_Password=TestData.getCellData(sheetName,"ESign_Password",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				String TxnType=TestData.getCellData(sheetName,"TxnType",row);

				String ProductID=TestData.getCellData(sheetName,"ProductID",row);


				driver.switchTo().defaultContent();		
				//Thread.sleep(5000);
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
				Thread.sleep(4000);
								    
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				if(ProductID.equals("PDL"))
				{
					driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
				}
				if(ProductID.equals("TLP"))
				{
					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
				}
				
				if(ProductID.equals("ILP"))
				{									
					driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
				}

				
				test.log(LogStatus.PASS, "Click on GO Button under loan section");
							
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys(TxnType);
				test.log(LogStatus.PASS, "Transaction type is selected"+TxnType);
				driver.findElement(By.id("go_Button")).click();
				test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
				driver.findElement(By.name("requestBean.chkName")).click();
				test.log(LogStatus.PASS, " Selected checkbox under checks to be ACHD option");
				driver.findElement(By.name("CmdReturnPosting")).click();
				test.log(LogStatus.PASS, " clik on next button");
				driver.findElement(By.name("transactionDataBean.password")).sendKeys(ESign_Password);
				test.log(LogStatus.PASS, " Entered password");
				driver.findElement(By.name("Submit22")).click();
				test.log(LogStatus.PASS, " clik on finsish ACH deposit button");
				if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
				{
					test.log(LogStatus.PASS, " ACH Deposit completed sucessfully");
				}
			}

		}}}

