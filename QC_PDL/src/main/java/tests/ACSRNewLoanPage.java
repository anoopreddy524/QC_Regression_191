package tests;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;


import com.relevantcodes.extentreports.LogStatus;
public class ACSRNewLoanPage extends QCStore{
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

				UserName = TestData.getCellData(sheetName,"UserName",row);
				Password = TestData.getCellData(sheetName,"Password",row);
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

				SSN1 = SSN.substring(0, 3);
				SSN2 = SSN.substring(3,5);
				SSN3 = SSN.substring(5,9);

			
				Thread.sleep(3000);
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(locator(prop.getProperty("csr_new_loan_link"))).click();			
				test.log(LogStatus.PASS, "Clicked on New Loan");		
				driver.switchTo().frame("main");	
				Thread.sleep(1000);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(prop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(prop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Click on submit Button");		
				
				Thread.sleep(2000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
					test.log(LogStatus.PASS, "Click on GO Button");
					Thread.sleep(1000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					//	Selection of Product based on the Name provided in Test Data
					if(driver.findElement(By.id("LoanButtonId")).isEnabled())
					{

						WebElement htmltable=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table"));
						rows=htmltable.findElements(By.tagName("tr"));
						count=0;							
						count=driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")).size();	
						System.out.println("current row num "+count);	
						System.out.println(" rows num "+ rows.size());
						test.log(LogStatus.PASS, "New Loan button is enabled");
						if(ProductID.equals("PDL"))
						{
							PDL();

						}
						else if(ProductID.equals("ILP"))
						{

							ILP();
							break;
						}

						else if(ProductID.equals("TLP"))
						{
							//TLP();
							//break;
						}
						if(ProductID.equals("LOC"))
						{
							//LOC();
							//break;
						}																																
					}

				
			}

		}
	}


	public static void PDL() throws InterruptedException
	{
		if(ProductID.equals("PDL"))
		{					
			rnum=rnum+1;
			if(State.equals("MO")){
				try{
					driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input")).click();
				}	
				catch(Exception e){
					test.log(LogStatus.PASS, "CustomerReached maximum Loan amounts");
					ACSRLoginLogout.logout();

				}}
			else if(State.equals("NV")){
				try{
					driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]/input")).click();
				}	
				catch(Exception e){
					test.log(LogStatus.PASS, "CustomerReached maximum Loan amounts");
					ACSRLoginLogout.logout();

				}
			}

			System.out.println(" after product ID");
		}
		test.log(LogStatus.PASS, "Product selected as "+stateProduct);

		Thread.sleep(1000);
		driver.findElement(By.id("LoanButtonId")).click();


		driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
		test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
		if(!(ESign_LoanAmt.isEmpty()))
		{
			driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[13]/td[3]/input")).sendKeys(ESign_LoanAmt);
			test.log(LogStatus.PASS, "Loan amount is enterted as "+ESign_LoanAmt);
		}
		
		driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys(ESign_DisbType);
		test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

		driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
		test.log(LogStatus.PASS, "Payment Reminder Consent is selected as "+ESign_CourtesyCallConsent);
		
		Thread.sleep(8000);

		driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys(ESign_DisbType);
		test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
		Thread.sleep(2000);
		if(ESign_CourtesyCallConsent.equals("Yes"))
		{
			Thread.sleep(2000);
			if(ESign_Preference.equals("Call"))	
			{
				driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
				test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
			}
			if(ESign_Preference.equals("Mail"))	
			{
				driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
				test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
			}
			if(ESign_Preference.equals("SMS"))	
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
		if (AllowPromotion.equals("Yes")) {


			String main_window = driver.getWindowHandle();

			driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

			test.log(LogStatus.PASS, "Promotion button is clicked ");

			Thread.sleep(10000);


			for (String winHandle1 : driver.getWindowHandles()) {

				if (!main_window.equalsIgnoreCase(winHandle1)) {

					Thread.sleep(5000);

					driver.switchTo().window(winHandle1);

					Thread.sleep(5000);

					driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

					test.log(LogStatus.PASS, "Promotion radio button is selected ");

					driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

					test.log(LogStatus.PASS, "OK button is clicked ");


					driver.switchTo().window(main_window);

					try {

						Alert alert = driver.switchTo().alert();

						String almsg = alert.getText();


						alert.accept();

						test.log(LogStatus.PASS, "Alert handled " + almsg);

						test.log(LogStatus.PASS, "Alert accepted");

						Thread.sleep(5000);

						driver.switchTo().window(main_window);

						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");

						driver.switchTo().frame("main");

						// if alert present, accept and move on.


					} catch (Exception e) {


					}

					break;

				}


			}


		}

		//'''''''''''''''''''''''''''''''''''''''''''''''//'''''''''''''''''''''''''''''''''''''''''''''//
		driver.switchTo().defaultContent();

		driver.switchTo().frame("mainFrame");

		driver.switchTo().frame("main");

		if (ESign_CollateralType.equals("CHECK"))
		{

			driver.findElement(By.name("requestBean.noOfChecks")).sendKeys(No_of_checks);
			Thread.sleep(500);
			driver.findElement(By.name("requestBean.noOfChecks")).sendKeys(Keys.ENTER);
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
			Thread.sleep(500);
			test.log(LogStatus.PASS, "	Chkg Acct Nbr(Last 4 Digits Only) is enterted as "+last4cheknum);	
			Thread.sleep(2000);
			driver.findElement(By.name("chkNbr0")).sendKeys(ESign_CheckNbr);
			test.log(LogStatus.PASS, "Check number is "+ESign_CheckNbr);
			Thread.sleep(1000);
			//driver.findElement(By.name("chkBoxNbr0")).click();
			driver.findElement(By.name("Print0")).click();
			Thread.sleep(3000);
			try { 
				Alert alert = driver.switchTo().alert();
				String almsg= alert.getText();

				alert.accept();
				test.log(LogStatus.PASS, "alert handled "+almsg);

				//if alert present, accept and move on.														

			}
			catch (NoAlertPresentException e) {
				//do what you normally would if you didn't have the alert.
			}

			Thread.sleep(3000);
			driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(ESign_Password);

			test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
			//	for(int i=1;i<=3;i++){
			//	driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(Keys.TAB);;
			//	}
			//	driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(Keys.ENTER);
			//driver.findElement(By.name("finishadvance")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("finishadvance")).click();
			test.log(LogStatus.PASS, "click on Finish Loan button ");
			Thread.sleep(5000);
		}

		//'''''''''''''''''''''''''''''''''''''''''''''//'''''''''''''''''''''''''''''''''''''''''''''''//

		if (ESign_CollateralType.equals("ACH"))
		{
			driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(ESign_Password);
			//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);
			test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
			driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
			test.log(LogStatus.PASS, "	Chkg Acct Nbr(Last 4 Digits Only) is enterted as "+last4cheknum);	
			Thread.sleep(6000);
			for(int i=1;i<=3;i++){
				driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(Keys.TAB);;}
			driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(Keys.ENTER);
			//driver.findElement(By.name("finishadvance")).click();
			test.log(LogStatus.PASS, "click on Finish Loan button ");
			Thread.sleep(5000);
		}

		//..................................................//.......................................
		if (ESign_CollateralType.equals("DEBIT CARD"))
		{	
			driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
			test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

			driver.findElement(By.xpath("//*[@id='cardType1']/select")).sendKeys(cardType);
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

			driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[12]/td[3]/div[1]/input[3]")).click();
			test.log(LogStatus.PASS, "Clicked on add card button ");
			Thread.sleep(30000);
			driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(ESign_Password);
			test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
			driver.findElement(By.name("finishadvance")).click();
			test.log(LogStatus.PASS, "click on Finish Loan button ");
			Thread.sleep(5000);
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

		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");
		
		
		String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[2]/td")).getText();
		String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[3]/td")).getText();
		String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[4]/td")).getText();
		
		test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+confirm_text2+confirm_text3);
		
		String e="/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input[1]";
		
		driver.findElement(By.xpath(e)).click();
		
		test.log(LogStatus.PASS, "click on Yes button ");
		Thread.sleep(3000);
	
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");
		if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr/td/b")).getText().contains("Advance Completed Successfully")){
			test.log(LogStatus.PASS, "<FONT color=green style=Arial> New Loan is Completed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "<FONT color=red style=Arial>New Loan is not Completed Successfully ");
		}

		
	}
	//--------------------------------------------------------------------------------------------------------------------------
	public static void ILP() throws InterruptedException
	{
		test.log(LogStatus.PASS, "getting product name ");
		List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")); 
		int n=rows.size();
		for(int i=2;i<=n;i++){
			String Pname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
			test.log(LogStatus.PASS, "getting product name "+Pname);

			if(Pname.equals(stateProductType))
			{
				if(NewLoan_Term.equals("Term1"))
				{
					driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input")).click();
					test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
				}
				else if(NewLoan_Term.equals("Term2"))
				{
					driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+rnum+"]/td[5]/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/b/input")).click();
					test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
				}
			}
			else{
				continue;
			}

			driver.findElement(By.id("LoanButtonId")).click();
			test.log(LogStatus.PASS, "Clicked on new loan button ");

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String relamount=driver.findElement(By.name("requestBean.siilBean.advAmt")).getAttribute("value");
			test.log(LogStatus.PASS, "getting request loan amount "+relamount);
			//--------------------------------------------------------------------------------------------------------------	

			if(ESign_CollateralType.equalsIgnoreCase("ACH")){

				driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

				if(ESign_DisbType.equalsIgnoreCase("Cash")){


					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					if(ESign_CourtesyCallConsent.equals("Yes"))
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
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
					if (AllowPromotion.equals("Yes")) {


						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);


						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");


								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();

									alert.accept();

									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

									// if alert present, accept and move on.

								} catch (Exception e) {

							}

								break;
							}

						}
				}

				}

				else if(ESign_DisbType.equalsIgnoreCase("Check")){

					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);

					if(ESign_CourtesyCallConsent.equals("Yes"))
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}

					}
					if (AllowPromotion.equals("Yes")) {


						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);


						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");


								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();


									alert.accept();

									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

									// if alert present, accept and move on.


								} catch (Exception e) {


								}

								break;

							}
						}

					}
					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");
					driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);
					test.log(LogStatus.PASS, "Number of checks selected as "+No_of_checks);

					driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
					test.log(LogStatus.PASS, "check box selected ");

					driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Enterd amount is "+relamount);

				}
				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
				//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);
				test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
				driver.findElement(By.name("finishLoan")).click();
				//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[1]/td[5]/input")).click();
				test.log(LogStatus.PASS, "click on Finish Loan button ");
				Thread.sleep(5000);
			}

			//--------------------------------------------------------------------------------------------------------

			if(ESign_CollateralType.equalsIgnoreCase("Debit Card")){


				driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

				if(ESign_DisbType.equalsIgnoreCase("Cash")){


					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);



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
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					if(ESign_CourtesyCallConsent.equals("Yes"))
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
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
					if (AllowPromotion.equals("Yes")) {


						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);


						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");


								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();
									alert.accept();

									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

									// if alert present, accept and move on.


								} catch (Exception e) {


								}

								break;

							}


						}
	}

				}

				else if(ESign_DisbType.equalsIgnoreCase("Check")){

					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);

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
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);

					if(ESign_CourtesyCallConsent.equals("Yes"))
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
					}
					if (AllowPromotion.equals("Yes")) {

						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);

						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");

								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();

									alert.accept();
									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

									// if alert present, accept and move on.


								} catch (Exception e) {

								}
								break;
							}
						}

					}
					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");
					driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);
					test.log(LogStatus.PASS, "Number of checks selected as "+No_of_checks);

					driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
					test.log(LogStatus.PASS, "check box selected ");

					driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Enterd amount is "+relamount);

				}
				driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
				test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
				driver.findElement(By.name("finishLoan")).click();
				test.log(LogStatus.PASS, "click on Finish Loan button ");
				Thread.sleep(5000);
			}
			//-----------------------------------------------------------------------------------------------------------------------------------	
			if(ESign_CollateralType.equalsIgnoreCase("Check")){
				driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

				if(ESign_DisbType.equalsIgnoreCase("Cash")||ESign_DisbType.equalsIgnoreCase("check")){


					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					if(ESign_CourtesyCallConsent.equals("Yes"))
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equals("SMS"))
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
					else{
						test.log(LogStatus.PASS, "Esign preference selected as NO ");
					}
					if (AllowPromotion.equals("Yes")) {

						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);

						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");


								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();


									alert.accept();

									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

								} catch (Exception e) {
								}
								break;
							}
					}
					}
					else
					{
						test.log(LogStatus.PASS, "Allow promotions not selected");
					}
				}
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
			driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				
				if(ESign_DisbType.equalsIgnoreCase("Check")){
				driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);
				test.log(LogStatus.PASS, "Number of checks selected as "+No_of_checks);

				driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
				test.log(LogStatus.PASS, "check box selected ");

				driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);
				test.log(LogStatus.PASS, "Enterd amount is "+relamount);
				}
				driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
				test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
				
				driver.findElement(By.name("finishLoan")).click();
				test.log(LogStatus.PASS, "click on Finish Loan button ");
				Thread.sleep(5000);
			}


			//------------------------------------------------------------------------------------------------------------		
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
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			if(driver.findElement(By.name("ok")).isDisplayed())
			{
				test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
				test.log(LogStatus.INFO, "**********************************************************************************");
				//driver.findElement(By.name("ok")).click();
			}
			else
			{
				test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
			}
			break;
		}
	}
	//----------------------------------------------------------------------------------------------------------------------------------------------


}

