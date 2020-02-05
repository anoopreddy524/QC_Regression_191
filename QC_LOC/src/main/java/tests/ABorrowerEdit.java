package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class ABorrowerEdit extends QCStore{
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;
	
	public static void borrowerIncreaseNet (String SSN,String AppURL) throws Exception
	{	
		test.log(LogStatus.INFO, "*****Borrower edit Transaction *****");
		
		String sheetName="Borrower_Registration";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))

			{		
				String Income_NetIncomeAmt = TestData.getCellData(sheetName,"Income_NetIncomeAmt",row);
				String Income_GrossIncome = TestData.getCellData(sheetName,"Income_GrossIncome",row);
				
				
				driver.switchTo().frame("bottom");
				 Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
	
				test.log(LogStatus.PASS, "Current store date is "+Str_date);


				driver.switchTo().defaultContent();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");	   
				//driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')])")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));
				driver.findElement(By.cssSelector("li[id='900000']")).click();	
				//driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Borrower");
				//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");			 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='902000']")));
				driver.findElement(By.cssSelector("li[id='902000']")).click();			
				test.log(LogStatus.PASS, "Clicked on Registration");
				//---------------------------------------------------------------------------------------
			
				SSN1 = SSN.substring(0, 3);
				SSN2 = SSN.substring(3,5);
				SSN3 = SSN.substring(5,9);
				
				driver.switchTo().frame("main");	
				Thread.sleep(1000);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Aprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Aprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Aprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Click on submit Button");		

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(locator(Aprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Click on GO Button");

				int netIncome=Integer.parseInt(Income_NetIncomeAmt);
				netIncome=netIncome+200;
				String netIncomeString = Integer.toString(netIncome);
				driver.findElement(By.name("customerBean.incomeAmtDisp")).clear();
				driver.findElement(By.name("customerBean.incomeAmtDisp")).sendKeys(netIncomeString);
				test.log(LogStatus.PASS, "NetIncomeAmt is entered: "+netIncomeString);
				
				int grossIncome=Integer.parseInt(Income_GrossIncome);
				grossIncome=grossIncome+200;
				String grossIncomeString = Integer.toString(grossIncome);
				driver.findElement(By.name("customerBean.grossAmtDisp")).clear();
				driver.findElement(By.name("customerBean.grossAmtDisp")).sendKeys(grossIncomeString);
				test.log(LogStatus.PASS, "GrossIncome is entered: "+grossIncomeString);
				
				
				driver.findElement(By.xpath("//*[@id='btnShowModalExit']")).sendKeys(Keys.ENTER);
				test.log(LogStatus.PASS, "Clicked on Save & Exit");
				Thread.sleep(4000);
				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();
					// if alert present, accept and move on.												

				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}

				for(String winHandle : driver.getWindowHandles()){

					driver.switchTo().window(winHandle);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					Thread.sleep(3000);
					String elementname= driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/b/font")).getText();
					test.log(LogStatus.INFO, "Registration Success Screen::"+elementname);
					test.log(LogStatus.PASS, "<FONT color=green> Borrower is Registered Successfully with SSN as " +SSN);	

				}

			break;}

		}	}
	

	public static void borrowerDecreaseNet (String SSN,String AppURL) throws Exception
	{	
		
		test.log(LogStatus.INFO, "*****Borrower edit Transaction *****");
		String sheetName="Borrower_Registration";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))

			{		
				String Income_NetIncomeAmt = TestData.getCellData(sheetName,"Income_NetIncomeAmt",row);
				String Income_GrossIncome = TestData.getCellData(sheetName,"Income_GrossIncome",row);
				
				
				driver.switchTo().frame("bottom");
				 Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
	
				test.log(LogStatus.PASS, "Current store date is "+Str_date);


				driver.switchTo().defaultContent();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");	   
				//driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')])")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));
				driver.findElement(By.cssSelector("li[id='900000']")).click();	
				//driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Borrower");
				//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");			 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='902000']")));
				driver.findElement(By.cssSelector("li[id='902000']")).click();			
				test.log(LogStatus.PASS, "Clicked on Registration");
				//---------------------------------------------------------------------------------------
			
				SSN1 = SSN.substring(0, 3);
				SSN2 = SSN.substring(3,5);
				SSN3 = SSN.substring(5,9);
				
				driver.switchTo().frame("main");	
				Thread.sleep(1000);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Aprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Aprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Aprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Click on submit Button");		

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(locator(Aprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Click on GO Button");

				int netIncome=Integer.parseInt(Income_NetIncomeAmt);
				netIncome=netIncome-100;
				String netIncomeString = Integer.toString(netIncome);
				driver.findElement(By.name("customerBean.incomeAmtDisp")).clear();
				driver.findElement(By.name("customerBean.incomeAmtDisp")).sendKeys(netIncomeString);
				test.log(LogStatus.PASS, "NetIncomeAmt is entered: "+netIncomeString);
				
				int grossIncome=Integer.parseInt(Income_GrossIncome);
				grossIncome=grossIncome-100;
				String grossIncomeString = Integer.toString(grossIncome);
				driver.findElement(By.name("customerBean.grossAmtDisp")).clear();
				driver.findElement(By.name("customerBean.grossAmtDisp")).sendKeys(grossIncomeString);
				test.log(LogStatus.PASS, "GrossIncome is entered: "+grossIncomeString);
				
				
				driver.findElement(By.xpath("//*[@id='btnShowModalExit']")).sendKeys(Keys.ENTER);
				test.log(LogStatus.PASS, "Clicked on Save & Exit");
				Thread.sleep(4000);
				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();
					// if alert present, accept and move on.												

				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}

				for(String winHandle : driver.getWindowHandles()){

					driver.switchTo().window(winHandle);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					Thread.sleep(3000);
					String elementname= driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/b/font")).getText();
					test.log(LogStatus.INFO, "Registration Success Screen::"+elementname);
					test.log(LogStatus.PASS, "<FONT color=green> Borrower is Registered Successfully with SSN as " +SSN);	

				}

			break;}

		}	}
	
	
}
