package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import com.relevantcodes.extentreports.LogStatus;

public class QCNSFPayment extends QCStore{

	public static void nsfpayment(String SSN,String AppURL) throws Exception
	{
		int i;
		for (i = 0; i < 3; i++) {
		
		try{

			
			int lastrow=TestData.getLastRow("NsfPayment");
			String sheetName="NsfPayment";

			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				String Scenario = TestData.getCellData(sheetName,"Scenario",row);

				if(SSN.equals(RegSSN))
				{

					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);
					Thread.sleep(1000);
					test.log(LogStatus.INFO,Scenario+" payment has started");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
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

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Click on GO Button under loan section");
					Thread.sleep(1000);


					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as "+TxnType);

					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");


					String tenderamunt=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[7]/td[1]/table[2]/tbody/tr[1]/td/table/tbody/tr[1]/td[3]/input")).getAttribute("value");
					test.log(LogStatus.PASS, " payment amount is"+tenderamunt);

					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, " Select the Deposit_Type as "+TenderType);
					//Thread.sleep(1000);
					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[7]/td[1]/table[2]/tbody/tr[1]/td/table/tbody/tr[12]/td[3]/input")).sendKeys(tenderamunt);
					test.log(LogStatus.PASS, " Enterd tender amount is "+tenderamunt);

					driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					test.log(LogStatus.PASS, " Entered password "+PIN);

					driver.findElement(By.name("Submit22")).click();
					test.log(LogStatus.PASS, " Clicked on finish "+Scenario+" button");
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


						test.log(LogStatus.PASS, Scenario+"   is successfull");
						test.log(LogStatus.PASS, "********************************************** ");
					}
					else
					{
						test.log(LogStatus.FAIL, Scenario+"  is not successfull");
						test.log(LogStatus.PASS, "********************************************** ");
					}



					break;



				}
				}
			break;
				}
		catch (Exception e) {

			test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
			String screenshotPath = getScreenhot(driver, "Exception");
							test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO,  " Process intiated again due to Application sync issue");
			driver.get(prop.getProperty("login_page"));  
			continue;

		}			 

	}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "payment is failed");
	
		}

}
}
