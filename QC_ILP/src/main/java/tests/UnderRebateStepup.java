package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;


public class UnderRebateStepup extends QCStore{

	public static String paymentAmount;
	public static void StepUp(String SSN,String AppURL) throws Exception{

		String sheetName="ReFinance";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))

			{		
				String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
				String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
				String ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
				String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);
				String No_of_checks = TestData.getCellData(sheetName,"No_of_checks",row);
				String ESign_Password = TestData.getCellData(sheetName,"ESign_Password",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************RefinanceStepUp  started**************");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(2000);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(prop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(prop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(2000);					  

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys("Refinance");
				test.log(LogStatus.PASS, "Transaction Type is selected as Refinance");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(500);	

				driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
				test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr/td/input[4]")).click();	
				test.log(LogStatus.PASS, "Clicked on History button ");
				String Pbal;
				String mainWindow=driver.getWindowHandle();
				for(String winHandle : driver.getWindowHandles())
				{
					if(!mainWindow.equalsIgnoreCase(winHandle))
					{
						driver.switchTo().window(winHandle);
						Pbal= driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[15]/td/span[2]")).getText();
						test.log(LogStatus.PASS, "principle balance is : "+Pbal);
						paymentAmount=driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[16]/td/span[2]")).getText();
						test.log(LogStatus.PASS, "Payment amount is "+paymentAmount);
						driver.close();
						driver.switchTo().window(mainWindow);
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
					
						float PbalInt=Float.valueOf(Pbal);
						PbalInt=PbalInt+10;
						String pbalstr=Float.toString(PbalInt);
						test.log(LogStatus.PASS, "payble loan amount is : "+pbalstr);
						Thread.sleep(3000);
						WebElement e=driver.findElement(By.name("transactionDataBean.advAmt"));
						e.clear();
						e.sendKeys(pbalstr);
						driver.findElement(By.name("qualify")).click();
						test.log(LogStatus.PASS, "Clicked on qualify button ");
						Thread.sleep(8000);
						String stpamt=driver.findElement(By.name("htmlAdvanceAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "StepUp amount is "+stpamt);

						

						driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
						test.log(LogStatus.PASS, "Chkg Acct Number enterd"+last4cheknum);


						driver.findElement(By.xpath(" /html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/table/tbody/tr[8]/td[2]/select")).sendKeys(ESign_CourtesyCallConsent);
						test.log(LogStatus.PASS, "Courtesy Call Consent selected as "+ESign_CourtesyCallConsent);


						driver.findElement(By.xpath(" //*[@id='preferenceCall']")).click();
						test.log(LogStatus.PASS, "Esign preference selected as "+ESign_Preference);

						driver.findElement(By.xpath(" //*[@id='disbursementType']/td[2]/select")).sendKeys(ESign_DisbType);
						test.log(LogStatus.PASS, "Disb type selected as "+ESign_DisbType);

						driver.findElement(By.xpath(" /html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr/td/select")).sendKeys(No_of_checks);
						test.log(LogStatus.PASS, "Number of checks "+No_of_checks);

						driver.findElement(By.xpath(" //*[@id='chkNbr0']")).sendKeys(ESign_CheckNbr);
						test.log(LogStatus.PASS, "Check number enterd as "+ESign_CheckNbr);
						Thread.sleep(2000);
						/*String paymentAmount=driver.findElement(By.xpath("/html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[6]/td[2]/table/tbody/tr[10]/td[2]/input")).getText();
									 test.log(LogStatus.PASS, "Payment amount is "+paymentAmount);*/

						driver.findElement(By.xpath("//*[@id='tenderTypeId']/select")).sendKeys(TenderType);
						test.log(LogStatus.PASS, "Tender type is"+TenderType);

					
						driver.findElement(By.xpath("//*[@id='tenderAmtStyle']/td[2]/input")).sendKeys(paymentAmount);
						test.log(LogStatus.PASS, "Tender amount is "+paymentAmount);

						String rebate= driver.findElement(locator(prop.getProperty("refinance_rebate_amount"))).getAttribute("value");
						test.log(LogStatus.PASS, "Rebate amount is "+rebate);

						driver.findElement(By.xpath(" /html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);
						test.log(LogStatus.PASS, "Password eneterd as: "+ESign_Password);


						driver.findElement(By.xpath(" /html/body/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr/td/input[5]")).click();
						test.log(LogStatus.PASS, "clicked on finsish refinance button ");


						String confirm_text=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[4]/td")).getText();
						test.log(LogStatus.PASS, ""+confirm_text);
						driver.findElement(locator(prop.getProperty("refinance_yes_button"))).click();
						test.log(LogStatus.PASS, "Clicked on Yes button under Confirm screen");
						test.log(LogStatus.PASS, "Refinance is successful");
						test.log(LogStatus.PASS, "********************************************");
					}
				}
			}
		}
	}
}









