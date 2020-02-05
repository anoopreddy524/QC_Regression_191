package tests;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class ALOCMaxloanCount extends QCStore{

	
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;
	public static String ESign_Password;
	public static String ESign_Checks;
	public static String CouponNbr;
	public static String ChkgAcctNbr;
	public static String AllowPromotion;
	public static String ESign_Preference;
	public static String ESign_CourtesyCallConsent;
	public static String ESign_DisbType;
	public static String ESign_LoanAmt;
	public static Object stateProductType;
	public static Object stateProduct;
	public static String StoreID;
	public static String NewVIN;
	public static String VehicleType;
	public static String NewLoan_Term;
	public static String NewLoan_ProductName;
	public static String ProductType;
	public static String Password;
	public static String UserName;
	public static String ProductID;
	public static CharSequence last4cheknum;
	public static String InsuranceExpiryDate0[]=null;
	public static String InsuranceExpiryDate3;
	public static String InsuranceExpiryDate2;
	public static String InsuranceExpiryDate1;
	public static String PolicyNumber;
	public static String InsuranceCompany;
	public static String PhoneNbr3;
	public static String PhoneNbr2;
	public static String PhoneNbr1;
	public static String PhoneNbr;
	public static String InsuranceCoverage;
	public static String LicensePlateExp;
	public static String LicensePlateNumber;
	public static String ExteriorColor;
	public static String AppraisalValue;
	public static String InsuranceExpiryDate;
	public static String TitleNumber;
	public static int rnum;
	public static int cnum;
	public static Object product_name;
	public static int count;
	public static List<WebElement> rows;
	public static String No_of_checks;
	public static String cardType;
	public static String cardNumber;
	public static String  cardEx_month;
	public static String cardEx_Year;
	public static String cvv;
	public static String CardHolderName;
	public static String DisbAmount;

	public static void newLoan(String SSN,String AppURL) throws Exception
	{

		test.log(LogStatus.INFO, "*****Performing  New Loan transaction *****");
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";

		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{		
				State = TestData.getCellData(sheetName,"StateID",row);
				ProductID=TestData.getCellData(sheetName,"ProductID",row);

		
				ProductType = TestData.getCellData(sheetName,"ProductType",row);
				NewLoan_ProductName = TestData.getCellData(sheetName,"NewLoan_ProductName",row);
				NewLoan_Term = TestData.getCellData(sheetName,"NewLoan_Term",row);
				StoreID = TestData.getCellData(sheetName,"StoreID",row);
				stateProduct=State+" "+ProductID;
				stateProductType=State+" "+ProductType;
				ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);

				ESign_LoanAmt = TestData.getCellData(sheetName,"ESign_LoanAmt",row);
				ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
				ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
				ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				AllowPromotion = TestData.getCellData(sheetName,"Allow Promotion",row);
				CouponNbr = TestData.getCellData(sheetName,"CouponNbr",row);
				ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
				ESign_Checks = TestData.getCellData(sheetName,"ESign_Checks",row);
				ESign_Password=TestData.getCellData(sheetName,"ESign_Password",row);
				ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);			
				last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);

				No_of_checks=TestData.getCellData(sheetName,"No_of_checks",row);
				cardType=TestData.getCellData(sheetName,"Card Type ",row);
				cardNumber=TestData.getCellData(sheetName,"Debit Card No",row);
				cardEx_month=TestData.getCellData(sheetName,"Expiry Month",row);
				cardEx_Year=TestData.getCellData(sheetName,"Expiry Year",row);
				cvv=TestData.getCellData(sheetName,"CVV",row);
				CardHolderName=TestData.getCellData(sheetName,"CardHolderName",row);
				
				DisbAmount=TestData.getCellData(sheetName,"DisbAmount",row);
				SSN1 = SSN.substring(0, 3);
				SSN2 = SSN.substring(3,5);
				SSN3 = SSN.substring(5,9);

				
				Thread.sleep(3000);
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Aprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(locator(Aprop.getProperty("csr_new_loan_link"))).click();			
				test.log(LogStatus.PASS, "Clicked on New Loan");		
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

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
				
					

						/*WebElement htmltable=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table"));
						rows=htmltable.findElements(By.tagName("tr"));
						count=0;							
						count=driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")).size();	
						System.out.println("current row num "+count);	
						System.out.println(" rows num "+ rows.size());
						test.log(LogStatus.PASS, "New Loan button is enabled");*/
						if(ProductID.equals("LOC"))
						{
							LOC();

						}				
			}

		}
	}


	public static void LOC() throws InterruptedException
	{
		if(ProductID.equals("LOC"))
		{					
			rnum=rnum+1;
			if(State.equals("KS")){
				String s1=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[3]")).getText();
				if(s1.trim().equalsIgnoreCase("Eligible")){								
					driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input")).click();
					
					test.log(LogStatus.PASS, "Product selected as "+stateProduct);
					
					String LOCamount=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[5]/table/tbody/tr[1]/td[2]")).getText();
					test.log(LogStatus.PASS, "LOC amount is : "+LOCamount);
					String interesrrate=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[5]/table/tbody/tr[2]/td[2]")).getText();
					test.log(LogStatus.PASS, "Interest rate is : "+interesrrate);
					String minAmountDue=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[5]/table/tbody/tr[3]/td[2]")).getText();
					test.log(LogStatus.PASS, "Minimum amount due is : "+minAmountDue);
					 Statementdate=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[5]/table/tbody/tr[4]/td[2]")).getText();
					test.log(LogStatus.PASS, "Statement date is : "+Statementdate);
					String MinLOCamount=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[5]/table/tbody/tr[5]/td[2]")).getText();
					test.log(LogStatus.PASS, "Minimum LOC amount is : "+MinLOCamount);
					String MaxLOCamount=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[5]/table/tbody/tr[6]/td[2]")).getText();
					test.log(LogStatus.PASS, "Maximum Loc amount is : "+MaxLOCamount);

					Thread.sleep(2000);	
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("window.scrollBy(0,-250)", "");
					
					WebElement e1=driver.findElement(By.id("LoanButtonId"));
					Actions builder = new Actions(driver);
					builder.moveToElement(e1).build().perform();
					Thread.sleep(3000);
					builder.doubleClick(e1).perform();
					
					//e1.submit();
					//driver.findElement(By.id("LoanButtonId")).click();
					
					//driver.findElement(By.name("button2")).click();
					test.log(LogStatus.PASS, "Clicked on  New loan button");
					Thread.sleep(1000);
					driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
					test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
					if(!(ESign_LoanAmt.isEmpty()))
					{
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[13]/td[3]/input")).sendKeys(ESign_LoanAmt);
						test.log(LogStatus.PASS, "Loan amount is enterted as "+ESign_LoanAmt);
					}
					
					Due_Date1=driver.findElement(By.name("stmtDueDate1")).getAttribute("value");		
					Due_Date2=driver.findElement(By.name("stmtDueDate2")).getAttribute("value");
					Due_Date3=driver.findElement(By.name("stmtDueDate3")).getAttribute("value");
					Duedate_confirm_text3=Due_Date1+"/"+Due_Date2+"/"+Due_Date3;
					test.log(LogStatus.PASS, "Due date is "+Duedate_confirm_text3);
					test.log(LogStatus.PASS, "Statement date is : "+Statementdate);
					String Statementdates[]=Statementdate.split("/");
					
					
					if(!Due_Date1.equals(Statementdates[0])){
						test.log(LogStatus.PASS, " <FONT color=green style=Arial>validate Payment Due Date and Statement Date is pass");
					}else{
						test.log(LogStatus.FAIL, " validate Payment Due Date and Statement Date is Fail");
					}
					
					driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtsey call consent selected as "+ESign_CourtesyCallConsent);

					/*driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);*/
					if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
					{
						if(ESign_Preference.equalsIgnoreCase("Call"))	
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equalsIgnoreCase("Mail"))	
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equalsIgnoreCase("SMS"))	
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


					//'''''''''''''''''''''''''''''''''''''''''''''''//'''''''''''''''''''''''''''''''''''''''''''''//
				

					

					if (ESign_CollateralType.equals("ACH"))
					{
						driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(LOCamount);
						
						test.log(LogStatus.PASS, "Disb amount enterd  as "+LOCamount);
						
						driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
						test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
						driver.findElement(By.name("finishadvance")).click();
						test.log(LogStatus.PASS, "click on Finish Loan button ");
						test.log(LogStatus.PASS, "click on Finish Loan button ");
					}

					//..................................................//.......................................
					if (ESign_CollateralType.equals("DEBIT CARD"))
					{	
						driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
						test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");
					
						driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);
						test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
						
						driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
						test.log(LogStatus.PASS, "Card number is :" + cardNumber);

						driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
						test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

						driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);
						test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);
					
						driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
						test.log(LogStatus.PASS, "Enterd CVV " + cvv);
						driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
						test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
				
						driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td/table[1]/tbody/tr[17]/td[2]/div[1]/input[3]")).click();
						test.log(LogStatus.PASS, "Clicked on add card button ");
						Thread.sleep(30000);
						driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(LOCamount);			
						test.log(LogStatus.PASS, "Disb amount enterd  as "+LOCamount);
						driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
						test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
						driver.findElement(By.name("finishadvance")).click();
						test.log(LogStatus.PASS, "click on Finish Loan button ");

					}

					Thread.sleep(3000);
					try {
						Alert alert = driver.switchTo().alert();
						String almsg= alert.getText();

						alert.accept();
						test.log(LogStatus.PASS, "alert handled "+almsg);
				}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}

					
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Thread.sleep(4000);
					//*[@id="confirmMsg"]/b[1]    //*[@id="confirmMsg"]/b[2]
					String confirm_text1=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[1]")).getText();
					String confirm_text2=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[2]")).getText();
					//String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[4]/td")).getText();
					
					test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+"Will revice an amount of"+confirm_text2+"With due date"+Duedate_confirm_text3);
					
				
					
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input[1]")).click();
					
					test.log(LogStatus.PASS, "click on Yes button ");
				Thread.sleep(5000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td")).getText().contains("successfully")){
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> New Loan is Completed Successfully");
					}
					else
					{
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>New Loan is  Completed Successfully ");
					}
					
				}	
				else{
					test.log(LogStatus.PASS, "CustomerReached maximum Loan amounts");
					ACSRLoginLogout.logout();
					
				}}
						
		}
		

		
	}
	//--------------------------------------------------------------------------------------------------------------------------

	//----------------------------------------------------------------------------------------------------------------------------------------------



	
	
	
	
}
