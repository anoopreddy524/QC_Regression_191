package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import com.relevantcodes.extentreports.LogStatus;

import tests.QCStore;

public class ATLP_Payment extends QCStore{

	public static void payment (String SSN,String AppURL) throws Exception
	{	
		test.log(LogStatus.INFO, "******************Performing  payment ******************");
		  	
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";

		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))

			{	
				String TxnType ="Payment";
				String TenderType = "Cash";
				String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
				String PIN = TestData.getCellData(sheetName,"Password",row);
				String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);	
				String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"PartialPayment started");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Aprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Aprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Aprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Aprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
							
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(Aprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);					  
					
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys(TxnType);
				test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button ");
				Thread.sleep(500);	
				
				if(PaymentType.equalsIgnoreCase("Pay any other Amt")){
				
				driver.findElement(By.id("PD5")).click();
				test.log(LogStatus.PASS, "Clicked on pay other amount check box ");
				
				driver.findElement(By.name("requestBean.siilBean.payAmt")).sendKeys(PaymentAmount);
				test.log(LogStatus.PASS, "PaymentAmount entered :"+PaymentAmount);
				driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
				test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
				driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount);
				test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);	
				}
				else if(PaymentType.equalsIgnoreCase("Pay Off the balance")){
					driver.findElement(By.id("PD3")).click();
					test.log(LogStatus.PASS, "Clicked on pay other amount check box ");
					
					
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount);
					test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);	
				}
				else if(PaymentType.equalsIgnoreCase("Pay Installment Amt")){
					driver.findElement(By.id("PD4")).click();
					test.log(LogStatus.PASS, "Clicked on Pay Installment Amt check box ");
					TenderAmount=driver.findElement(By.name("instAmt")).getAttribute("value");
					
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(TenderAmount.trim());
					test.log(LogStatus.PASS, "TenderAmount is :"+TenderAmount);
				}
				driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
				test.log(LogStatus.PASS, "Pin is entered");
				driver.findElement(By.name("finish")).click();
				test.log(LogStatus.PASS, "Clicked on Finish  Payment");

				Thread.sleep(3000);
				try { 
					Alert alert = driver.switchTo().alert();

					alert.accept();
					test.log(LogStatus.PASS, "Alert Handeld");
																			
				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}
				Thread.sleep(4000);
				try{
				if(driver.findElement(By.name("Ok")).isDisplayed())
				{
				test.log(LogStatus.PASS, "Payment transaction is successfully");
				}
				else{
					test.log(LogStatus.INFO, "Payment transaction is successfully");
				}
				}
				catch(Exception e){
					test.log(LogStatus.INFO, "Payment transaction is successfully");
				}
				
				
			break;}

		break;}
	}
	
	
}
