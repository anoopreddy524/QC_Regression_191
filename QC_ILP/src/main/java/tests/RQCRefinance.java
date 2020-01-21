package tests;

import java.text.DateFormat;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import tests.QCStore;

public class RQCRefinance extends QCStore{

	public static String cardType;
	public static String cardNumber;
	public static String  cardEx_month;
	public static String cardEx_Year;
	public static String cvv;
	public static String CardHolderName;

	public static String paymentAmount;

	public static void StepUp(String SSN,String AppURL) throws Exception{

		String sheetName="ReFinance";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))

			{		

				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String ESign_Preference = TestData.getCellData(sheetName,"Esign_Preference",row);

				String ESign_Password = TestData.getCellData(sheetName,"PIN",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Esign_DisbType = TestData.getCellData(sheetName,"Esign_DisbType",row);
				String LoanAmount = TestData.getCellData(sheetName,"LoanAmount",row);
				String Actual_DisbAmount = TestData.getCellData(sheetName,"Actual_DisbAmount",row);
				

				cardType=TestData.getCellData(sheetName,"Card Type ",row);
				cardNumber=TestData.getCellData(sheetName,"Debit Card No",row);
				cardEx_month=TestData.getCellData(sheetName,"Expiry Month",row);
				cardEx_Year=TestData.getCellData(sheetName,"Expiry Year",row);
				cvv=TestData.getCellData(sheetName,"CVV",row);
				CardHolderName=TestData.getCellData(sheetName,"CardHolderName",row);

				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************RefinanceStepUp  started**************");
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
				Thread.sleep(1000);
				try{							
					//driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[2]")).click();
					driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
					test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
				}
				catch(Exception e){
					//normal flow
				}
				Thread.sleep(8000);	
				//driver.findElement(By.name("qualify")).click();
				//test.log(LogStatus.PASS, "Clicked on qualify button ");
				//String paymentamount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");			
				//test.log(LogStatus.PASS, "Getting payment amount "+paymentamount);
				//Thread.sleep(10000);
				
				WebElement e1=driver.findElement(By.name("requestBean.siilBean.advAmt"));
				e1.clear();
				Thread.sleep(500);
				e1.sendKeys(LoanAmount);
				test.log(LogStatus.PASS, "Entered Loan amount as  :"+LoanAmount);
				Thread.sleep(10000);
				driver.findElement(By.name("qualify")).click();
				   //test.log(LogStatus.PASS, "Clicked on qualify button ");
				Thread.sleep(10000);
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Clicked on qualify button ");
				Thread.sleep(5000);
				driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
                
				test.log(LogStatus.PASS, "Select tender type as "+TenderType);
				
				String PrincipalBalance=driver.findElement(By.name("requestBean.siilBean.balancePrincipal")).getAttribute("value");			
				test.log(LogStatus.PASS, "Getting Principal Balance : "+PrincipalBalance);
				Thread.sleep(500);
				//String DisbAmount=driver.findElement(By.name("requestBean.siilBean.balancePrincipal")).getAttribute("value");
				String DisbAmount=driver.findElement(By.id("refinanceLoanAmt")).getAttribute("value");
				 if (Actual_DisbAmount.trim().equalsIgnoreCase(DisbAmount.trim())) {
						//test.log(LogStatus.PASS, "Getting Disb amount : "+DisbAmount);
						test.log(LogStatus.PASS, "<FONT color=green style=Arial>Getting Disb amount : "+DisbAmount );
						}
						else{
							test.log(LogStatus.FAIL, " Disb amount mismatched ");
							
							
							break;
							
							
						}
				test.log(LogStatus.PASS, "Getting Disb amount : "+DisbAmount);
				Thread.sleep(500);
				String AmountDue=driver.findElement(By.name("requestBean.payOffAmt")).getAttribute("value");
				test.log(LogStatus.PASS, "Getting Due amount : "+AmountDue);
				Thread.sleep(500);				
				String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
				test.log(LogStatus.PASS, "getting stepup message  : "+stepupmsg);
				Thread.sleep(5000);

				if(stepupmsg.contains("Stepped Up by Amount")){

					if(ESign_CollateralType.equalsIgnoreCase("Check")){

						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						test.log(LogStatus.INFO, "Performing  check transactions");
						int chkno=987654;

						String instamnts=driver.findElement(By.name("requestBean.siilBean.nbrOfInst")).getAttribute("value");
						int instamntsno=Integer.parseInt(instamnts)+1;
						for(int j=2;j<=instamntsno;j++){
							chkno=chkno+1;
							String str1 = Integer.toString(chkno); 
							driver.findElement(By.xpath("//*[@id='checkNbrs"+(j-2)+"']")).sendKeys(str1);

							test.log(LogStatus.PASS, "Check number enterd as "+chkno);

						}

					}

					if(ESign_CollateralType.equalsIgnoreCase("ACH")){
						//test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						Thread.sleep(500);
						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						Thread.sleep(500);
						driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(Esign_DisbType);
						test.log(LogStatus.PASS, "Disb Type is enterted as "+Esign_DisbType);
						
						driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(DisbAmount);
						test.log(LogStatus.PASS, "Disb Amount is enterted as "+DisbAmount);
						
						

					}
					if(ESign_CollateralType.equalsIgnoreCase("Debit card")){


						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
						test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

						driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
						test.log(LogStatus.PASS, "Card number is :" + cardNumber);

						driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);
						test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
						driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
						test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

						driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);
						test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

						driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
						test.log(LogStatus.PASS, "Enterd CVV " + cvv);
						driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
						test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

						driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]")).click();
						test.log(LogStatus.PASS, "Clicked on add card button ");	
						Thread.sleep(30000);

					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
					{
						if(ESign_Preference.equalsIgnoreCase("Call"))
						{
							driver.findElement(By.id("preferenceCall")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equalsIgnoreCase("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equalsIgnoreCase("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");



					driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
					test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);

					driver.findElement(By.name("finishLoan")).click();
					test.log(LogStatus.PASS, "click on Finish Loan button ");

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

					String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[1]")).getText();

					String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[2]")).getText();
					String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[3]")).getText();
					String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();

					test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an "+confirm_text2+" of "+confirm_text3+" First payment date is "+confirm_text4);

					driver.findElement(By.name("OKBut")).click();

					test.log(LogStatus.PASS, "click on Yes button ");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					if(driver.findElement(By.name("ok")).isDisplayed())
					{
						test.log(LogStatus.PASS, " Refinance Stepup is pass ");
						test.log(LogStatus.INFO, "**********************************************************************************");

					}
					else
					{
						test.log(LogStatus.INFO, "Refinance Stepup is pass ");
						test.log(LogStatus.INFO, "**********************************************************************************");
					}
				}
				else{
					test.log(LogStatus.FAIL, " Refinance Stepup message is not displayed ");
				}
				break;}
			break;}
	}

	public static void StepUp_LoanAmt_Edit(String SSN,String AppURL) throws Exception{

		String sheetName="ReFinance";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))

			{		

				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String ESign_Preference = TestData.getCellData(sheetName,"Esign_Preference",row);

				String ESign_Password = TestData.getCellData(sheetName,"PIN",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Esign_DisbType = TestData.getCellData(sheetName,"Esign_DisbType",row);
				String LoanAmount = TestData.getCellData(sheetName,"LoanAmount",row);
				String Actual_DisbAmount = TestData.getCellData(sheetName,"Actual_DisbAmount",row);
				
				

				cardType=TestData.getCellData(sheetName,"Card Type ",row);
				cardNumber=TestData.getCellData(sheetName,"Debit Card No",row);
				cardEx_month=TestData.getCellData(sheetName,"Expiry Month",row);
				cardEx_Year=TestData.getCellData(sheetName,"Expiry Year",row);
				cvv=TestData.getCellData(sheetName,"CVV",row);
				CardHolderName=TestData.getCellData(sheetName,"CardHolderName",row);

				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************RefinanceStepUp  started**************");
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
				Thread.sleep(1000);
				try{							
					//driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[2]")).click();
					driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
					test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
				}
				catch(Exception e){
					//normal flow
				}
				Thread.sleep(8000);	
				//driver.findElement(By.name("qualify")).click();
				//test.log(LogStatus.PASS, "Clicked on qualify button ");
				//String paymentamount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");			
				//test.log(LogStatus.PASS, "Getting payment amount "+paymentamount);
				//Thread.sleep(10000);
				
				WebElement e1=driver.findElement(By.name("requestBean.siilBean.advAmt"));
				e1.clear();
				Thread.sleep(500);
				e1.sendKeys(LoanAmount);
				test.log(LogStatus.PASS, "Entered Loan amount as  :"+LoanAmount);
				Thread.sleep(10000);
				driver.findElement(By.name("qualify")).click();
				   //test.log(LogStatus.PASS, "Clicked on qualify button ");
				Thread.sleep(10000);
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Clicked on qualify button ");
				Thread.sleep(5000);
				driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
                
				test.log(LogStatus.PASS, "Select tender type as "+TenderType);
				
				String PrincipalBalance=driver.findElement(By.name("requestBean.siilBean.balancePrincipal")).getAttribute("value");			
				test.log(LogStatus.PASS, "Getting Principal Balance : "+PrincipalBalance);
				Thread.sleep(500);
			    
				String DisbAmount=driver.findElement(By.id("refinanceLoanAmt")).getAttribute("value");
				//if(DisbAmount.equalsIgnoreCase("Actual_DisbAmount")){
			    if (Actual_DisbAmount.trim().equalsIgnoreCase(DisbAmount.trim())) {
				//test.log(LogStatus.PASS, "Getting Disb amount : "+DisbAmount);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial>Getting Disb amount : "+DisbAmount );
				}
				else{
					test.log(LogStatus.FAIL, " Disb amount mismatched ");
					
					
					break;
					
					
				}
			   
			    
				Thread.sleep(500);
				
				String AmountDue=driver.findElement(By.name("requestBean.payOffAmt")).getAttribute("value");
				test.log(LogStatus.PASS, "Getting Due amount : "+AmountDue);
				Thread.sleep(500);
				String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
				test.log(LogStatus.PASS, "getting stepup message  : "+stepupmsg);
				Thread.sleep(5000);

				if(stepupmsg.contains("Stepped Up by Amount")){

					if(ESign_CollateralType.equalsIgnoreCase("Check")){

						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						test.log(LogStatus.INFO, "Performing  check transactions");
						int chkno=987654;

						String instamnts=driver.findElement(By.name("requestBean.siilBean.nbrOfInst")).getAttribute("value");
						int instamntsno=Integer.parseInt(instamnts)+1;
						for(int j=2;j<=instamntsno;j++){
							chkno=chkno+1;
							String str1 = Integer.toString(chkno); 
							driver.findElement(By.xpath("//*[@id='checkNbrs"+(j-2)+"']")).sendKeys(str1);

							test.log(LogStatus.PASS, "Check number enterd as "+chkno);

						}

					}

					if(ESign_CollateralType.equalsIgnoreCase("ACH")){
						//test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						Thread.sleep(500);
						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						Thread.sleep(500);
						driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(Esign_DisbType);
						test.log(LogStatus.PASS, "Disb Type is enterted as "+Esign_DisbType);
						
						driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(DisbAmount);
						test.log(LogStatus.PASS, "Disb Amount is enterted as "+DisbAmount);
						
						

					}
					if(ESign_CollateralType.equalsIgnoreCase("Debit card")){


						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
						test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

						driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
						test.log(LogStatus.PASS, "Card number is :" + cardNumber);

						driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);
						test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
						driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
						test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

						driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);
						test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

						driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
						test.log(LogStatus.PASS, "Enterd CVV " + cvv);
						driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
						test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

						driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]")).click();
						test.log(LogStatus.PASS, "Clicked on add card button ");	
						Thread.sleep(30000);

					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
					{
						if(ESign_Preference.equalsIgnoreCase("Call"))
						{
							driver.findElement(By.id("preferenceCall")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equalsIgnoreCase("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equalsIgnoreCase("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");



					driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
					test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);

					driver.findElement(By.name("finishLoan")).click();
					test.log(LogStatus.PASS, "click on Finish Loan button ");

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

					String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[1]")).getText();

					String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[2]")).getText();
					String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[3]")).getText();
					String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();

					test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an "+confirm_text2+" of "+confirm_text3+" First payment date is "+confirm_text4);

					driver.findElement(By.name("OKBut")).click();

					test.log(LogStatus.PASS, "click on Yes button ");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					if(driver.findElement(By.name("ok")).isDisplayed())
					{
						test.log(LogStatus.PASS, " Refinance Stepup is pass ");
						test.log(LogStatus.INFO, "**********************************************************************************");

					}
					else
					{
						test.log(LogStatus.INFO, "Refinance Stepup is pass ");
						test.log(LogStatus.INFO, "**********************************************************************************");
					}
				}
				else{
					test.log(LogStatus.FAIL, " Refinance Stepup message is not displayed ");
				}
				break;}
			break;}
		
	}


	public static void StepUp_CashOut_No(String SSN,String AppURL) throws Exception{

		String sheetName="ReFinance";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))

			{		

				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String ESign_Preference = TestData.getCellData(sheetName,"Esign_Preference",row);

				String ESign_Password = TestData.getCellData(sheetName,"PIN",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Esign_DisbType = TestData.getCellData(sheetName,"Esign_DisbType",row);
				String LoanAmount = TestData.getCellData(sheetName,"LoanAmount",row);
				String Actual_DisbAmount = TestData.getCellData(sheetName,"Actual_DisbAmount",row);
				

				cardType=TestData.getCellData(sheetName,"Card Type ",row);
				cardNumber=TestData.getCellData(sheetName,"Debit Card No",row);
				cardEx_month=TestData.getCellData(sheetName,"Expiry Month",row);
				cardEx_Year=TestData.getCellData(sheetName,"Expiry Year",row);
				cvv=TestData.getCellData(sheetName,"CVV",row);
				CardHolderName=TestData.getCellData(sheetName,"CardHolderName",row);

				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************RefinanceStepUp  started**************");
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
				Thread.sleep(1000);
				try{							
					//driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[2]")).click();
					driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
					test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
				}
				catch(Exception e){
					//normal flow
				}
				Thread.sleep(8000);	
				//driver.findElement(By.name("qualify")).click();
				//test.log(LogStatus.PASS, "Clicked on qualify button ");
				//String paymentamount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");			
				//test.log(LogStatus.PASS, "Getting payment amount "+paymentamount);
				//Thread.sleep(10000);
				
				WebElement e1=driver.findElement(By.name("requestBean.siilBean.advAmt"));
				e1.clear();
				Thread.sleep(500);
				e1.sendKeys(LoanAmount);
				test.log(LogStatus.PASS, "Entered Loan amount as  :"+LoanAmount);
				Thread.sleep(10000);
				driver.findElement(By.name("qualify")).click();
				   //test.log(LogStatus.PASS, "Clicked on qualify button ");
				Thread.sleep(10000);
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Clicked on qualify button ");
				Thread.sleep(5000);
				driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
                
				test.log(LogStatus.PASS, "Select tender type as "+TenderType);
				
				String PrincipalBalance=driver.findElement(By.name("requestBean.siilBean.balancePrincipal")).getAttribute("value");			
				test.log(LogStatus.PASS, "Getting Principal Balance : "+PrincipalBalance);
				Thread.sleep(500);
				//String DisbAmount=driver.findElement(By.name("requestBean.siilBean.balancePrincipal")).getAttribute("value");
				String DisbAmount=driver.findElement(By.id("refinanceLoanAmt")).getAttribute("value");
				if (Actual_DisbAmount.trim().equalsIgnoreCase(DisbAmount.trim())) {
					//test.log(LogStatus.PASS, "Getting Disb amount : "+DisbAmount);
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Getting Disb amount : "+DisbAmount );
					}
					else{
						test.log(LogStatus.FAIL, " Disb amount mismatched ");
						
						
						break;
						
						
					}
				
				Thread.sleep(500);
				
				String AmountDue=driver.findElement(By.name("requestBean.payOffAmt")).getAttribute("value");
				test.log(LogStatus.PASS, "Getting Due amount : "+AmountDue);
				Thread.sleep(500);
				String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
				test.log(LogStatus.PASS, "getting stepup message  : "+stepupmsg);
				Thread.sleep(5000);

				if(stepupmsg.contains("Stepped Up by Amount")){

					if(ESign_CollateralType.equalsIgnoreCase("Check")){

						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						test.log(LogStatus.INFO, "Performing  check transactions");
						int chkno=987654;

						String instamnts=driver.findElement(By.name("requestBean.siilBean.nbrOfInst")).getAttribute("value");
						int instamntsno=Integer.parseInt(instamnts)+1;
						for(int j=2;j<=instamntsno;j++){
							chkno=chkno+1;
							String str1 = Integer.toString(chkno); 
							driver.findElement(By.xpath("//*[@id='checkNbrs"+(j-2)+"']")).sendKeys(str1);

							test.log(LogStatus.PASS, "Check number enterd as "+chkno);

						}

					}

					if(ESign_CollateralType.equalsIgnoreCase("ACH")){
						//test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						Thread.sleep(500);
						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						Thread.sleep(500);
						driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(Esign_DisbType);
						test.log(LogStatus.PASS, "Disb Type is enterted as "+Esign_DisbType);
						
						driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(DisbAmount);
						test.log(LogStatus.PASS, "Disb Amount is enterted as "+DisbAmount);
						
						

					}
					if(ESign_CollateralType.equalsIgnoreCase("Debit card")){


						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
						test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

						driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
						test.log(LogStatus.PASS, "Card number is :" + cardNumber);

						driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);
						test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
						driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
						test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

						driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);
						test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

						driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
						test.log(LogStatus.PASS, "Enterd CVV " + cvv);
						driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
						test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

						driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]")).click();
						test.log(LogStatus.PASS, "Clicked on add card button ");	
						Thread.sleep(30000);

					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
					{
						if(ESign_Preference.equalsIgnoreCase("Call"))
						{
							driver.findElement(By.id("preferenceCall")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equalsIgnoreCase("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equalsIgnoreCase("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");



					driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
					test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);

					driver.findElement(By.name("finishLoan")).click();
					test.log(LogStatus.PASS, "click on Finish Loan button ");

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

					String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[1]")).getText();

					String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[2]")).getText();
					String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[3]")).getText();
					String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();

					test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an "+confirm_text2+" of "+confirm_text3+" First payment date is "+confirm_text4);

					driver.findElement(By.name("OKBut")).click();

					test.log(LogStatus.PASS, "click on Yes button ");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					if(driver.findElement(By.name("ok")).isDisplayed())
					{
						test.log(LogStatus.PASS, " Refinance Stepup is pass ");
						test.log(LogStatus.INFO, "**********************************************************************************");

					}
					else
					{
						test.log(LogStatus.INFO, "Refinance Stepup is pass ");
						test.log(LogStatus.INFO, "**********************************************************************************");
					}
				}
				else{
					test.log(LogStatus.FAIL, " Refinance Stepup message is not displayed ");
				}
				break;}
			break;}
	}



}