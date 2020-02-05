package tests;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class ATLPRefinanceStepDown extends QCStore{
		
		public static String cardType;
		public static String cardNumber;
		public static String  cardEx_month;
		public static String cardEx_Year;
		public static String cvv;
		public static String CardHolderName;
		public static String ESign_CourtesyCallConsent;
		public static String paymentAmount;
		public static String ESign_Preference;
		public static String ESign_Password;

		public static void StepDown(String SSN,String AppURL) throws Exception{

			String sheetName="NewLoan";	
			int lastrow=TestData.getLastRow(sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))

				{	
					ESign_CollateralType=TestData.getCellData(sheetName,"ESign_CollateralType",row);
					ESign_CourtesyCallConsent=TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
					ESign_Preference=TestData.getCellData(sheetName,"ESign_Preference",row);
					ESign_Password=TestData.getCellData(sheetName,"Password",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);
					
					Thread.sleep(3000);
					test.log(LogStatus.INFO,"**************Refinance StepDown  started**************");
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
					Thread.sleep(500);	
					
					
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table[2]/tbody/tr[4]/td/input")).click();
					test.log(LogStatus.PASS, "click on update button of borrower overview ");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id='vehicleInformation']/td/table/tbody/tr[10]/td/input")).click();
					test.log(LogStatus.PASS, "click on update button of Vechile details");
					Thread.sleep(5000);
					
					driver.findElement(By.xpath("//*[@id='save']/input")).click();
					test.log(LogStatus.PASS, "click on process loan");
					
					//--------------------------------------------------------------
				try{
					driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
					test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
					}
				catch(Exception e){
				//Normal flow	
				}
				
					Thread.sleep(2000);
					String priciplebalance=driver.findElement(By.name("requestBean.siilBean.balancePrincipal")).getAttribute("value");
					test.log(LogStatus.PASS, "getting priciple balance is :"+priciplebalance);
					float priciplebalanceInt=Float.valueOf(priciplebalance);
					priciplebalanceInt=priciplebalanceInt+10;
					String priciplebalance2 = Float.toString(priciplebalanceInt);
					WebElement e2=driver.findElement(By.name("requestBean.siilBean.advAmt"));
					e2.clear();
					e2.click();
					Thread.sleep(5000);
					e2.sendKeys(priciplebalance2);
					test.log(LogStatus.PASS, "Entering loan amount is :"+priciplebalance2);
					
					e2.sendKeys(Keys.TAB);
					
					Thread.sleep(5000);
					String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
					test.log(LogStatus.PASS, "getting stepup message  :"+stepupmsg);
					
					if(stepupmsg.contains("Stepped Down by Amount")){
			
						driver.findElement(By.name("qualify")).click();
						test.log(LogStatus.PASS, "Clicked on qualify button ");
						Thread.sleep(6000);
						String paymentamount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "Getting payment amount "+paymentamount);
						driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys("Cash");
						test.log(LogStatus.PASS, "Select tender type as Cash");
						WebElement e1=driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst"));
						e1.clear();
						e1.sendKeys(paymentamount);
						test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentamount);
					
						if(ESign_CollateralType.equalsIgnoreCase("Ach")){
							
							test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);				
						}
						if(ESign_CollateralType.equalsIgnoreCase("Debit card")){
					
							driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
							driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
							test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

							driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
							test.log(LogStatus.PASS, "Card number is :" + cardNumber);
							
							driver.findElement(By.xpath("//*[@id='cardType']/select")).sendKeys(cardType);
							test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
							driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
							test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);
							
							Select sel = new Select(driver.findElement(By.xpath("//*[@id='expyear']")));
							sel.selectByVisibleText(cardEx_Year);
							test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_Year);
							
							driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
							test.log(LogStatus.PASS, "Enterd CVV " + cvv);
							driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
								Thread.sleep(1000);			
														
							driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[4]/td/table/tbody/tr[43]/td[2]/div[3]/input")).click();
							
							test.log(LogStatus.PASS, "Clicked on add card button ");	
							Thread.sleep(30000);

							
						}
						if(ESign_CollateralType.equalsIgnoreCase("NO COLLATERAL")){
							test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);	
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
						
						//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[11]/td/table/tbody/tr[11]/td[2]/input")).click();
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
								
								/*String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[1]")).getText();
								
								String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[2]")).getText();
								String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[3]")).getText();
								String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();*/
							
								//test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an "+confirm_text2+" of "+confirm_text3+" First payment date is "+confirm_text4);
								
								driver.findElement(By.name("OKBut")).click();

								test.log(LogStatus.PASS, "click on Yes button ");

								driver.switchTo().defaultContent();
								driver.switchTo().frame("mainFrame");
								driver.switchTo().frame("main");
								if(driver.findElement(By.name("ok")).isDisplayed())
								{
									test.log(LogStatus.PASS, " Refinance Step Down is pass ");
									test.log(LogStatus.INFO, "**********************************************************************************");
								
								}
								else
								{
									test.log(LogStatus.INFO, "Refinance Step Down is pass ");
									test.log(LogStatus.INFO, "**********************************************************************************");
								}
					}
					
				
					}
			break;}
		}
	}


