package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class AQCDepositDropdown extends QCStore{

	public static void depositDropDown(String SSN,String AppURL) throws InterruptedException
	{


		int lastrow=TestData.getLastRow("Deposit");
		String sheetName="Deposit";

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String Deposit_Type = TestData.getCellData(sheetName,"RepresentmentType",row);

				String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);

				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);		       

				Thread.sleep(1000);

				test.log(LogStatus.INFO, "Deposit through from CSR has initiated");

				driver.switchTo().frame("bottom");
				String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
				test.log(LogStatus.PASS, ""+Str_date);

				driver.switchTo().defaultContent();	

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
				driver.findElement(By.cssSelector("li[id='910000']")).click();		
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

				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button under search results");

				String loan_nbr= driver.findElement(locator(Aprop.getProperty("loan_nbr"))).getText();
				test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
				driver.findElement(locator(Aprop.getProperty("clear_go"))).click();
				test.log(LogStatus.PASS, "Clicked on Go button under Loans section");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				if(ESign_CollateralType.equalsIgnoreCase("ACH"))
				{

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("transactionList")).sendKeys(ESign_CollateralType+" Deposit");
					test.log(LogStatus.PASS, "Transaction type is selected "+ESign_CollateralType+" Deposit");
					driver.findElement(By.id("go_Button")).click();
					test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					driver.findElement(locator(Aprop.getProperty("clear_finish"))).click();
					test.log(LogStatus.PASS, "Click on ACH deposit button ");

					test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
					test.log(LogStatus.PASS, "********************************************** ");
				}

				if(ESign_CollateralType.equalsIgnoreCase("CHECK"))
				{

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("transactionList")).sendKeys(ESign_CollateralType+" Deposit");
					test.log(LogStatus.PASS, "Transaction type is selected"+ESign_CollateralType+" Deposit");
					driver.findElement(By.id("go_Button")).click();
					test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");								 
					driver.findElement(locator(Aprop.getProperty("deposite_ilp_dstype"))).sendKeys(Deposit_Type);								 
					test.log(LogStatus.PASS, " Select the Deposit_Type as"+Deposit_Type);
					driver.findElement(locator(Aprop.getProperty("clear_finish"))).click();
					test.log(LogStatus.PASS, "Click on Check deposit button ");								 					

					test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
					test.log(LogStatus.PASS, "********************************************** ");

				}
				if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
				{

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("transactionList")).sendKeys("DebitCard Deposit");
					test.log(LogStatus.PASS, "Transaction type is selected"+ESign_CollateralType+" Deposit");
					driver.findElement(By.id("go_Button")).click();
					test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					driver.findElement(locator(Aprop.getProperty("clear_finish"))).click();
					test.log(LogStatus.PASS, "Click on Debit Card deposit button ");
					test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
					test.log(LogStatus.PASS, "********************************************** ");

				}

				break;

			}

		}









	}
}






