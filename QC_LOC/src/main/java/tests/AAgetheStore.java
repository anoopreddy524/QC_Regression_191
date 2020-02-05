package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class AAgetheStore extends QCStore{
	public static void rescind(String SSN,String AppURL) throws Exception{

		test.log(LogStatus.INFO, "***** Performing Rescind Transaction *****");	

	
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";		
		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String TxnType=TestData.getCellData(sheetName,"TxnType",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);	
				String ProductID=TestData.getCellData(sheetName,"ProductID",row);
				String Password = TestData.getCellData(sheetName,"Password",row);

				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				driver.switchTo().defaultContent();		
			
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
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on GO Button under search results");
				Thread.sleep(4000);
	
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
							
			
				driver.findElement(By.name("transactionList")).sendKeys(TxnType);
				test.log(LogStatus.PASS, "Transaction type is selected"+TxnType);
				driver.findElement(By.id("go_Button")).click();
				test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
							
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				if(ProductID.equals("PDL"))
				{
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender type is selected"+TenderType);
					String Pmt= driver.findElement(By.xpath(" /html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[3]/td[1]")).getText();						
					System.out.println(Pmt);
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Pmt);
					test.log(LogStatus.PASS, "Tender Amt is entered as "+Pmt);
					driver.findElement(By.name("transactionDataBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Password is selected as "+Password);
					driver.findElement(By.name("Submit23")).click();
					test.log(LogStatus.PASS, "Clicked on Rescind  Loan button ");
				}
				if(ProductID.equals("ILP"))
				{
					driver.findElement(By.name("tenderType")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender type selected as "+TenderType);
					driver.findElement(By.name("requestBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Password is selected as "+Password);
					driver.findElement(By.name("finish")).click();
					
				}
				
				if(ProductID.equals("TLP"))
				{	
					driver.findElement(By.name("tenderType")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender type selected as "+TenderType);
					driver.findElement(By.name("requestBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Password is selected as "+Password);
					driver.findElement(By.name("finish")).click();
				}	
				
				
				 	try { 
					 Alert alert = driver.switchTo().alert();
					 alert.accept();
					 test.log(LogStatus.PASS, "Alert Handeled and clicked on yes ");
					 //if alert present, accept and move on.														

				 }
				 catch (NoAlertPresentException e) {
					 //do what you normally would if you didn't have the alert.
				 }
						
				 driver.switchTo().defaultContent();
				 driver.switchTo().frame("mainFrame");
				 driver.switchTo().frame("main");
				 Thread.sleep(3000);
				 if(ProductID.equals("ILP"))
				 {

					 if(driver.findElement(By.name("checkyes")).isDisplayed())
					 {
						 test.log(LogStatus.PASS, "Rescind Loan is Completed Successfully ");
						
					 }
					 else
					 {
						 test.log(LogStatus.INFO, "Rescind Loan is  Completed Successfully ");
					 }
				 }
				 if(ProductID.equals("TLP"))
				 {

					 if(driver.findElement(By.name("Ok")).isDisplayed())
					 {
						 test.log(LogStatus.PASS, "Rescind Loan is Completed Successfully ");
						 
					 }
					 else
					 {
						 test.log(LogStatus.INFO, "Rescind Loan is not Completed Successfully ");
					 }
				 }
				 if(ProductID.equals("PDL"))
				 {

					 if(driver.findElement(By.name("checkyes")).isDisplayed())
					 {
						 test.log(LogStatus.PASS, "Rescind Loan is Completed Successfully ");
						

					 }
					 else
					 {
						 test.log(LogStatus.INFO, "Rescind Loan is not Completed Successfully ");
					 }
				 }
			}

		}
	}
	//*******************************************************************************************************************
	/*   store date+grace days */
	public static  void ageGracedays(String SSN,String AppURL) throws Exception{


		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";		
		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String GraceDays=TestData.getCellData(sheetName,"GraceDays",row);
				test.log(LogStatus.INFO, "******Performing age the store to grace days ******");
				driver.switchTo().frame("bottom");
				String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();			
				test.log(LogStatus.PASS, "Current store date is "+Str_date);

				int GraceDaysInt=Integer.parseInt(GraceDays);
				String spagedate[]=Str_date.split(":");
				//String text=spagedate[0];
				//this is month
				String day=spagedate[1].trim();

				// -----------------------------------
				SimpleDateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
				Date ndate = df.parse(day);
				Calendar cal = Calendar.getInstance();
				cal.setTime(ndate);
				cal.add(Calendar.DATE, GraceDaysInt);
				Date DDueDate1= cal.getTime();
				day =df.format(DDueDate1);
				test.log(LogStatus.PASS, "Updated store date is "+day);
				//------------------------------------------

				String age_Date[] =day.split("/");
				 age_Date1 = age_Date[0];
				 age_Date2 = age_Date[1];
				 age_Date3 = age_Date[2];
				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
				test.log(LogStatus.PASS, "Clicked on Cash Management");
				Thread.sleep(5000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");							
				driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
				test.log(LogStatus.PASS, "Clicked on Start Scheduler");
				Thread.sleep(5000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				test.log(LogStatus.INFO, "******Entering date Into the feilds ******");
				driver.findElement(By.name("endMonth")).sendKeys(age_Date1);
				test.log(LogStatus.PASS, "Month is entered: "+age_Date1);
				driver.findElement(By.name("endDay")).sendKeys(age_Date2);
				test.log(LogStatus.PASS, "Date is entered: "+age_Date2);
				driver.findElement(By.name("endYear")).sendKeys(age_Date3);
				test.log(LogStatus.PASS, "Year is entered: "+age_Date3);
				driver.findElement(By.name("runSchedulerBtn")).click();
				test.log(LogStatus.PASS, "Clicked on Run Scheduler");

				try { 
					Alert alert = driver.switchTo().alert();

					alert.accept();
					test.log(LogStatus.PASS, "accepting the alert");
					//if alert present, accept and move on.														

				}
				catch (Exception e) {
					//do what you normally would if you didn't have the alert.
				}
				 Thread.sleep(30000);
					
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ok")));
				 Thread.sleep(5000);
				 driver.findElement(By.name("ok")).click();
				//test.log(Status.PASS, "Clicked on Scheduler Ok");
				test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
				test.log(LogStatus.INFO, "<FONT color=green> ****Scheduler completed******");
				test.log(LogStatus.INFO, "<FONT color=green> Logout Successfully");
				driver.close();
				//Thread.sleep(1000);

			}

		}
	}

	
	/*   store date+grace days */
	public static  void age1day(String SSN,String AppURL) throws Exception{


		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";		
		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String GraceDays="1";
				test.log(LogStatus.INFO, "******Performing age the store to grace days ******");
				driver.switchTo().frame("bottom");
				String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();			
				test.log(LogStatus.PASS, "Current store date is "+Str_date);

				int GraceDaysInt=Integer.parseInt(GraceDays);
				String spagedate[]=Str_date.split(":");
				//String text=spagedate[0];
				//this is month
				String day=spagedate[1].trim();

				// -----------------------------------
				SimpleDateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
				Date ndate = df.parse(day);
				Calendar cal = Calendar.getInstance();
				cal.setTime(ndate);
				cal.add(Calendar.DATE, GraceDaysInt);
				Date DDueDate1= cal.getTime();
				day =df.format(DDueDate1);
				test.log(LogStatus.PASS, "Updated store date is "+day);
				//------------------------------------------

				String age_Date[] =day.split("/");
				String age_Date1 = age_Date[0];
				String age_Date2 = age_Date[1];
				String age_Date3 = age_Date[2];
				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
				test.log(LogStatus.PASS, "Clicked on Cash Management");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");							
				driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
				test.log(LogStatus.PASS, "Clicked on Start Scheduler");
				Thread.sleep(2000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				test.log(LogStatus.INFO, "******Entering date Into the feilds ******");
				driver.findElement(By.name("endMonth")).sendKeys(age_Date1);
				test.log(LogStatus.PASS, "Month is entered: "+age_Date1);
				driver.findElement(By.name("endDay")).sendKeys(age_Date2);
				test.log(LogStatus.PASS, "Date is entered: "+age_Date2);
				driver.findElement(By.name("endYear")).sendKeys(age_Date3);
				test.log(LogStatus.PASS, "Year is entered: "+age_Date3);
				driver.findElement(By.name("runSchedulerBtn")).click();
				test.log(LogStatus.PASS, "Clicked on Run Scheduler");

				try { 
					Alert alert = driver.switchTo().alert();

					alert.accept();
					test.log(LogStatus.PASS, "accepting the alert");
					//if alert present, accept and move on.														

				}
				catch (Exception e) {
					//do what you normally would if you didn't have the alert.
				}
				Thread.sleep(5000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ok")));
				//Thread.sleep(5000);
				driver.findElement(By.name("ok")).click();
				//test.log(Status.PASS, "Clicked on Scheduler Ok");
				test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
				test.log(LogStatus.INFO, "<FONT color=green> ****Scheduler completed******");
				test.log(LogStatus.INFO, "<FONT color=green> Logout Successfully");
				driver.close();
				//Thread.sleep(1000);

			}

		}
	}

	//age to 30 days
	public static  void age180day(String SSN,String AppURL) throws Exception{


		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";		
		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String GraceDays="181";
				test.log(LogStatus.INFO, "******Performing age the store to grace days ******");
				driver.switchTo().frame("bottom");
				String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();			
				test.log(LogStatus.PASS, "Current store date is "+Str_date);

				int GraceDaysInt=Integer.parseInt(GraceDays);
				String spagedate[]=Str_date.split(":");
				//String text=spagedate[0];
				//this is month
				String day=spagedate[1].trim();

				// -----------------------------------
				SimpleDateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
				Date ndate = df.parse(day);
				Calendar cal = Calendar.getInstance();
				cal.setTime(ndate);
				cal.add(Calendar.DATE, GraceDaysInt);
				Date DDueDate1= cal.getTime();
				day =df.format(DDueDate1);
				test.log(LogStatus.PASS, "Updated store date is "+day);
				//------------------------------------------

				String age_Date[] =day.split("/");
				String age_Date1 = age_Date[0];
				String age_Date2 = age_Date[1];
				String age_Date3 = age_Date[2];
				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
				test.log(LogStatus.PASS, "Clicked on Cash Management");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");							
				driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
				test.log(LogStatus.PASS, "Clicked on Start Scheduler");
				Thread.sleep(2000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				test.log(LogStatus.INFO, "******Entering date Into the feilds ******");
				driver.findElement(By.name("endMonth")).sendKeys(age_Date1);
				test.log(LogStatus.PASS, "Month is entered: "+age_Date1);
				driver.findElement(By.name("endDay")).sendKeys(age_Date2);
				test.log(LogStatus.PASS, "Date is entered: "+age_Date2);
				driver.findElement(By.name("endYear")).sendKeys(age_Date3);
				test.log(LogStatus.PASS, "Year is entered: "+age_Date3);
				driver.findElement(By.name("runSchedulerBtn")).click();
				test.log(LogStatus.PASS, "Clicked on Run Scheduler");

				try { 
					Alert alert = driver.switchTo().alert();

					alert.accept();
					test.log(LogStatus.PASS, "accepting the alert");
					//if alert present, accept and move on.														

				}
				catch (Exception e) {
					//do what you normally would if you didn't have the alert.
				}
				Thread.sleep(5000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ok")));
				//Thread.sleep(5000);
				driver.findElement(By.name("ok")).click();
				//test.log(Status.PASS, "Clicked on Scheduler Ok");
				test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
				test.log(LogStatus.INFO, "<FONT color=green> ****Scheduler completed******");
				test.log(LogStatus.INFO, "<FONT color=green> Logout Successfully");
				driver.close();
				//Thread.sleep(1000);

			}

		}
	}
	

}
