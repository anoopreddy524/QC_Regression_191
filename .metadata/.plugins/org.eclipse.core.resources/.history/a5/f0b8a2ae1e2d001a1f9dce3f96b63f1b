package tests;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class JQC_NewLoan_Veritec extends QCStore{

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

	public static String Check_Count;

	public static String cardType;

	public static String cardNumber;

	public static String cardEx_month;

	public static String cardEx_Year;

	public static String cvv;

	public static String CardHolderName;

	public static String VeritecRule;
	public static String ESign_CollateralType;
	public static String ESign_CheckNbr;
	
	public static void newLoan(String SSN,String AppURL) throws Exception

	{


		test.log(LogStatus.INFO, "*****Performing New Loan transaction *****");

		int lastrow=TestData.getLastRow("New_Loan");

		String sheetName="New_Loan";


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

				ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);

				ESign_Checks = TestData.getCellData(sheetName,"ESign_Checks",row);

				ESign_Password=TestData.getCellData(sheetName,"ESign_Password",row);

				String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row); 

				last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);

				Check_Count=TestData.getCellData(sheetName,"CC_Password",row);
				System.out.println(Check_Count);

				cardType=TestData.getCellData(sheetName,"Card Type ",row);

				cardNumber=TestData.getCellData(sheetName,"Debit Card No",row);

				cardEx_month=TestData.getCellData(sheetName,"Expiry Month",row);

				cardEx_Year=TestData.getCellData(sheetName,"Expiry Year",row);

				cvv=TestData.getCellData(sheetName,"CVV",row);

				CardHolderName=TestData.getCellData(sheetName,"CardHolderName",row);


				SSN1 = SSN.substring(0, 3);

				SSN2 = SSN.substring(3,5);

				SSN3 = SSN.substring(5,9);


				test.log(LogStatus.PASS, "Values loaded from excel");

				Thread.sleep(3000);

				driver.switchTo().frame("topFrame");

				driver.findElement(locator(Jprop.getProperty("transactions_tab"))).click(); 

				test.log(LogStatus.PASS, "Clicked on Loan Transactions");


				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");


				driver.findElement(locator(Jprop.getProperty("csr_new_loan_link"))).click(); 

				test.log(LogStatus.PASS, "Clicked on New Loan"); 

				driver.switchTo().frame("main"); 

				Thread.sleep(1000);

				driver.findElement(By.name("ssn1")).sendKeys(SSN1);

				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);

				driver.findElement(locator(Jprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);

				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);

				driver.findElement(locator(Jprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);

				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);

				driver.findElement(locator(Jprop.getProperty("csr_new_loan_submit_button"))).click();

				test.log(LogStatus.PASS, "Click on submit Button"); 


				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(locator(Jprop.getProperty("csr_new_loan_go_button"))).click();

				test.log(LogStatus.PASS, "Click on GO Button");


				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				// Selection of Product based on the Name provided in Test Data

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


					{


					}


					{

					}

					{

					} 

				}

			}

		}

	}

	public static void PDL() throws InterruptedException

	{

		if(ProductID.equals("PDL"))

		{ 

			driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input")).click();
			System.out.println(" after product ID");

		}

		test.log(LogStatus.PASS, "Product selected as "+stateProduct);
		driver.findElement(By.id("LoanButtonId")).click();
	   
		VeritecRule=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[1]/tbody/tr[1]/td/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[4]")).getText();
	    test.log(LogStatus.PASS, "Captured The Veritec Rule Eligabilty as "+VeritecRule);
	   
	    if(VeritecRule.contains("Veritec could not hit due to process date mismatch")){
	    	
	    
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

		driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys(ESign_DisbType);
		test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

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

			driver.findElement(locator(Jprop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);
			test.log(LogStatus.PASS, "Promotion button is clicked ");

			Thread.sleep(10000);

			for (String winHandle1 : driver.getWindowHandles()) {
				if (!main_window.equalsIgnoreCase(winHandle1)) {

					Thread.sleep(5000);

					driver.switchTo().window(winHandle1);

					Thread.sleep(5000);


					driver.findElement(locator(Jprop.getProperty("csr_new_loan_promotion_radio_btn"))).click();
					test.log(LogStatus.PASS, "Promotion radio button is selected ");

					driver.findElement(locator(Jprop.getProperty("csr_new_loan_promo_ok_btn"))).click();
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


			driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
			test.log(LogStatus.PASS, " Chkg Acct Nbr(Last 4 Digits Only) is enterted as "+last4cheknum); 

			driver.findElement(By.xpath("//*[@id='idNoChecks']/td[3]/select")).sendKeys(Check_Count);
			test.log(LogStatus.PASS, " Number of checkes enterted as "+Check_Count);
			
			Thread.sleep(2000);

			driver.findElement(By.name("chkNbr0")).sendKeys(ESign_CheckNbr);
			test.log(LogStatus.PASS, "Check number is "+ESign_CheckNbr);

			driver.findElement(By.name("Print0")).click();

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

			driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
			test.log(LogStatus.PASS, "Payment Reminder Consent is selected as "+ESign_CourtesyCallConsent);
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
			//Thread.sleep(3000);

			driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(ESign_Password);
			test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);

			if(driver.findElement(By.name("finishadvance")).isEnabled())
			{
				driver.findElement(By.name("finishadvance")).click();

				test.log(LogStatus.PASS, "click on Finish Loan button ");
			}
			else{
				   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
				   LocalDateTime now = LocalDateTime.now();  
				   String date=dtf.format(now);
				   System.out.println(dtf.format(now)); 
				   test.log(LogStatus.PASS, "Getting the Current System date "+date);
				
				for(String winHandle1 : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle1);
					}				    
			driver.switchTo().defaultContent();
			 driver.switchTo().frame("topFrame");
		 driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
					 test.log(LogStatus.PASS, "Clicked on Cash Management");
					 driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");							
					driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
					test.log(LogStatus.PASS, "Clicked on Start Scheduler");
					Thread.sleep(5000);
					for( String winHandle1 : driver.getWindowHandles())
					{
					    driver.switchTo().window(winHandle1);
					}			
					 driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					String Due_Date[] =date.split("/");
			        String Due_Date1 = Due_Date[0];
			        String Due_Date2 = Due_Date[1];
			        String Due_Date3 = Due_Date[2];
			        driver.findElement(By.name("endMonth")).sendKeys(Due_Date1);
			        test.log(LogStatus.PASS, "Month is entered: "+Due_Date1);
					driver.findElement(By.name("endDay")).sendKeys(Due_Date2);
					test.log(LogStatus.PASS, "Date is entered: "+Due_Date2);
					driver.findElement(By.name("endYear")).sendKeys(Due_Date3);
					test.log(LogStatus.PASS, "Year is entered: "+Due_Date3);
					driver.findElement(By.name("runSchedulerBtn")).click();
					test.log(LogStatus.PASS, "Clicked on Run Scheduler");
					Thread.sleep(500);
					 
					 try { 
						    Alert alert = driver.switchTo().alert();
						
						    alert.accept();
						    //if alert present, accept and move on.														
							
						}
						catch (Exception e) {
						    //do what you normally would if you didn't have the alert.
						}
					 
					 //Thread.sleep(30000);
					
					 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ok")));
					 Thread.sleep(5000);
					 driver.findElement(By.name("ok")).click();
					 test.log(LogStatus.PASS,"Clicked on Scheduler Ok Successfully");
					 test.log(LogStatus.PASS,"************************************************");

					 Thread.sleep(5000);
					 driver.close();
			}
			

			
		
		}

		//'''''''''''''''''''''''''''''''''''''''''''''//'''''''''''''''''''''''''''''''''''''''''''''''//


		if (ESign_CollateralType.equals("ACH"))

		{

			driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(ESign_Password);
			test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);

			driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
			test.log(LogStatus.PASS, " Chkg Acct Nbr(Last 4 Digits Only) is enterted as "+last4cheknum); 

			Thread.sleep(6000);

			for(int i=1;i<=3;i++){

			driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(Keys.TAB);;}
			driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(Keys.ENTER);

			test.log(LogStatus.PASS, "click on Finish Loan button ");

		}


		//..................................................//.......................................

		if (ESign_CollateralType.equals("DEBIT CARD"))

		{ 

			driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
			test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");


			driver.findElement(By.xpath("//*[@id='cardType1']/select")).sendKeys(cardType);

			test.log(LogStatus.PASS, "Enterd card Type : " + cardType);


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



		driver.switchTo().defaultContent();

		driver.switchTo().frame("mainFrame");

		driver.switchTo().frame("main");

		Thread.sleep(2000);

		String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[2]/td")).getText();

		String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[3]/td")).getText();

		String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[4]/td")).getText();

		test.log(LogStatus.PASS, "confirm text is "+confirm_text1+confirm_text2+confirm_text3);

		String e="/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input[1]";

		//wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath(e))));

		driver.findElement(By.xpath(e)).click();

		//driver.findElement(By.xpath("//*[@id='OKBut']")).click();

		test.log(LogStatus.PASS, "click on Yes button ");

		/*for( String winHandle1 : driver.getWindowHandles())

	{

	driver.switchTo().window(winHandle1);

	}*/

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
	
}
	}
}