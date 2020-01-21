package tests;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.omg.stub.java.rmi._Remote_Stub;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.relevantcodes.extentreports.LogStatus;
public class QC_NVState_NewLoan extends QCStore{
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
	public static String ESign_CollateralType;
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
	public static String SSN ;
	 
	public static void getSSN() throws Exception{
		//String FileName= "QC_BorrowerReg_NewLoan_AchDeposit_Txn_Testdata.xls";
	    // test.log(LogStatus.PASS, "Registration of Lend Nation started ");
	     Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/CSR/"+FileName);
	           int lastrow=TestData.getLastRow("Start");
	           String sheetName="Start";
	           //int lastrow=TestData.getLastRow("Borrower");
	           System.out.println(lastrow);
	           for(int row=2;row<=lastrow;row++)
	           {
	                   String RunFlag = TestData.getCellData(sheetName,"Run",row);
	                   //System.out.println(RunFlag);
	           if(RunFlag.equals("Y"))
	           {
	                   //driver.get(appUrl);
	                   //test.log(LogStatus.INFO, "Application is launched");
	                   //driver.manage().window().maximize();
	                            
	                            SSN = TestData.getCellData(sheetName,"SSN",row);
	                          // System.out.println(AppURL);
		 }}}

public static void newLoan() throws Exception
	{
		 getSSN();//calling this method to get SSN
	test.log(LogStatus.INFO, "*****Performing  New Loan transaction *****");
			//String FileName= "QC_BorrowerReg_NewLoan_AchDeposit_Txn_Testdata.xls";
			
			Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/CSR/"+FileName);  	
			
				int lastrow=TestData.getLastRow("NewLoan");
				String sheetName="NewLoan";

				for(int row=2;row<=lastrow;row++)
				{	
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					
					if(SSN.equals(RegSSN))
					{		
						
						 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
						State = TestData.getCellData(sheetName,"StateID",row);
						 ProductID=TestData.getCellData(sheetName,"ProductID",row);
						System.out.println(ProductID);
						 UserName = TestData.getCellData(sheetName,"UserName",row);
						 Password = TestData.getCellData(sheetName,"Password",row);
						ProductType = TestData.getCellData(sheetName,"ProductType",row);
						 NewLoan_ProductName = TestData.getCellData(sheetName,"NewLoan_ProductName",row);
						 NewLoan_Term = TestData.getCellData(sheetName,"NewLoan_Term",row);
						 VehicleType= TestData.getCellData(sheetName,"VehicleType",row);
						 NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
						//System.out.println(Term);
						//String StoreId = TestData.getCellData(sheetName,"StoreID",row);
						 StoreID = TestData.getCellData(sheetName,"StoreID",row);
						 stateProduct=State+" "+ProductID;
						 stateProductType=State+" "+ProductType;
						 ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
						System.out.println(ESign_CollateralType);
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
						 TitleNumber= TestData.getCellData(sheetName,"TitleNumber",row);
						AppraisalValue= TestData.getCellData(sheetName,"Appraisal Value",row);
						ExteriorColor=TestData.getCellData(sheetName,"ExteriorColor",row);
						LicensePlateNumber=TestData.getCellData(sheetName,"License Plate Number",row);
							//String VehicleGrade=TestData.getCellData(sheetName,"Vehicle Grade",row);
						LicensePlateExp=TestData.getCellData(sheetName,"License Plate Expiry",row);
							InsuranceCoverage=TestData.getCellData(sheetName,"Insurance Coverage",row);
						 PhoneNbr=TestData.getCellData(sheetName,"Phone Nbr",row);
						 PhoneNbr1 = PhoneNbr.substring(0, 3);
					       PhoneNbr2 = PhoneNbr.substring(3, 6);
					       PhoneNbr3 = PhoneNbr.substring(6, 10);
					       InsuranceCompany =TestData.getCellData(sheetName,"Insurance Company",row);
					       InsuranceExpiryDate=TestData.getCellData(sheetName,"Insurance Expiry Date",row);
					     PolicyNumber=TestData.getCellData(sheetName,"Policy Number",row);
					     InsuranceExpiryDate0 =InsuranceExpiryDate.split("/");
					     InsuranceExpiryDate1 = InsuranceExpiryDate0[0];
					     InsuranceExpiryDate2 = InsuranceExpiryDate0[1];
					   InsuranceExpiryDate3 = InsuranceExpiryDate0[2];
					   test.log(LogStatus.PASS, "Values loaded from excel");
						Thread.sleep(3000);
					   driver.switchTo().frame("topFrame");
						driver.findElement(locator(Aprop.getProperty("transactions_tab"))).click();			
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						
						driver.findElement(locator(Aprop.getProperty("csr_new_loan_link"))).click();			
						test.log(LogStatus.PASS, "Clicked on New Loan");		
						driver.switchTo().frame("main");	
						Thread.sleep(4000);
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
						driver.findElement(locator(Aprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
						driver.findElement(locator(Aprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
						driver.findElement(locator(Aprop.getProperty("csr_new_loan_submit_button"))).click();
						test.log(LogStatus.PASS, "Click on submit Button");		
						for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);				
					    driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					    driver.findElement(locator(Aprop.getProperty("csr_new_loan_go_button"))).click();
						test.log(LogStatus.PASS, "Click on GO Button");
						
						
						for( String winHandle1 : driver.getWindowHandles())
						{
						    driver.switchTo().window(winHandle1);
						}			
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						 //	Selection of Product based on the Name provided in Test Data
						 if(driver.findElement(By.id("LoanButtonId")).isEnabled())
						 {
							 
						    WebElement htmltable=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table"));
						    													//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table
						    
							rows=htmltable.findElements(By.tagName("tr"));
							
							count=0;							
							 count=driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")).size();	
							 									//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[1]
							 System.out.println("current row num "+count);	
							 System.out.println(" rows num "+ rows.size());
								
														
													if(ProductID.equals("PDL"))
													 {
													 PDL();
													 
													 }
													 if(ProductID.equals("ILP"))
													 {
													 ILP();
													 break;
													 }
													 
													 if(ProductID.equals("TLP"))
													 {
													 TLP();
													 break;
													 }
													 if(ProductID.equals("LOC"))
													 {
													 LOC();
													 break;
													 }																																
												}
												
											}
							
							
					
						 	}
							
					}
					//break;
					

			
				
			}

	
public static void PDL() throws InterruptedException
	{
	/* for(rnum=1;rnum<=count;rnum++)
		{
			System.out.println("current row num "+rnum);						
		List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));							
		
		System.out.println("columns Count "+columns.size());
			
					for(cnum=0;cnum<columns.size();cnum++)//columns.size()
					{					
						product_name=columns.get(cnum).getText();						
						System.out.println(product_name);
						
	if(product_name.equals(stateProduct))
	{
		rnum=rnum+1;														
		System.out.println("product equals state product ");
		driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+rnum+"]/td[2]/input")).click();								
		//driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input")).click();														
		System.out.println(" end of product equals state product ");
	}
					}
		}*/
	if(ProductID.equals("PDL"))
	{					
		rnum=rnum+1;														
		try{driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input")).click();
		
		
		//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input
		}	
		catch(Exception e){
			test.log(LogStatus.PASS, "CustomerReached maximum Loan amounts");
			ACSRLoginLogout.logout();
			
		}
		System.out.println(" after product ID");
	}
	test.log(LogStatus.PASS, "Product selected as "+stateProduct);
	
		
	 driver.findElement(By.id("LoanButtonId")).click();
	 

	 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
			test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
			if(!(ESign_LoanAmt.isEmpty()))
			{
				driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[13]/td[3]/input")).sendKeys(ESign_LoanAmt);
				test.log(LogStatus.PASS, "Loan amount is enterted as "+ESign_LoanAmt);
			}
			/*driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
			test.log(LogStatus.PASS, "	Chkg Acct Nbr(Last 4 Digits Only) is enterted as "+last4cheknum);					*/
			driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys(ESign_DisbType);
			test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
			//Thread.sleep(5000);
			//String Instamt=driver.findElement(locator(Aprop.getProperty("advanceRequestBean.advanceAmt")).getAttribute("value");
			//System.out.println(Instamt);
			//driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(Instamt);					
			//test.log(LogStatus.PASS, "Disb Amt is enterted as "+Instamt);
			Thread.sleep(5000);
			driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
			test.log(LogStatus.PASS, "Payment Reminder Consent is selected as "+ESign_CourtesyCallConsent);
			//driver.findElement(By.name("advanceRequestBean.emailConsentFlag")).sendKeys(ESign_CourtesyCallConsent);
			//test.log(LogStatus.PASS, "Electronic Communication Consent is selected as "+ESign_CourtesyCallConsent);
			
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
			if(AllowPromotion.equals("Yes"))
			{
				driver.findElement(By.xpath("//*[@id='allowCoupons']/td[3]/input")).click();
				test.log(LogStatus.PASS, "Allow Promotion is selected ");
				driver.findElement(By.xpath("//*[@id='coupon']/td[3]/div[1]/input")).sendKeys(CouponNbr);
				test.log(LogStatus.PASS, "CouponNbr is selected as "+CouponNbr);
			}
			
			//'''''''''''''''''''''''''''''''''''''''''''''''//'''''''''''''''''''''''''''''''''''''''''''''//
			
			
			if (ESign_CollateralType.equals("CHECK"))
			{
			
			//driver.findElement(By.xpath("//*[@id='idNoChecks']/td[3]/select")).sendKeys(ESign_Checks);
			//test.log(Status.PASS, "ESign_Checks is selected as "+ESign_Checks);
			//WebDriverWait wait = new WebDriverWait(driver, 1000);	
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='chkNbr0']")));
			//driver.findElement(By.xpath("//*[@id='chkNbr0']")).sendKeys(ESign_CheckNbr);
			
			
			driver.findElement(By.name("requestBean.noOfChecks")).sendKeys(No_of_checks);
			driver.findElement(By.name("requestBean.noOfChecks")).sendKeys(Keys.ENTER);
			 driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
				test.log(LogStatus.PASS, "	Chkg Acct Nbr(Last 4 Digits Only) is enterted as "+last4cheknum);	
			Thread.sleep(2000);
			driver.findElement(By.name("chkNbr0")).sendKeys(ESign_CheckNbr);
			test.log(LogStatus.PASS, "Check number is "+ESign_CheckNbr);
			//driver.findElement(By.name("chkBoxNbr0")).click();
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
			
			Thread.sleep(3000);
			driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(ESign_Password);
			
			test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
		//	for(int i=1;i<=3;i++){
			//	driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(Keys.TAB);;
			//	}
			//	driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(Keys.ENTER);
				//driver.findElement(By.name("finishadvance")).click();
				
			driver.findElement(By.name("finishadvance")).click();
			test.log(LogStatus.PASS, "click on Finish Loan button ");
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
				
			}
			

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

            for( String winHandle1 : driver.getWindowHandles())
            {
                driver.switchTo().window(winHandle1);
            }
             driver.switchTo().defaultContent();
             driver.switchTo().frame("mainFrame");
             driver.switchTo().frame("main");
             Thread.sleep(3000);


             //driver.findElement(By.tagName("body")).sendKeys(Keys.TAB);
             //driver.findElement(By.tagName("body")).sendKeys(Keys.ENTER);
             String e="/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input[1]";
             //wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath(e))));
             driver.findElement(By.xpath(e)).click();
            //driver.findElement(By.xpath("//*[@id='OKBut']")).click();
            test.log(LogStatus.PASS, "click on Yes button ");
            for( String winHandle1 : driver.getWindowHandles())
            {
                driver.switchTo().window(winHandle1);
            }
             driver.switchTo().defaultContent();
             driver.switchTo().frame("mainFrame");
             driver.switchTo().frame("bdyLoad");
            if(driver.findElement(By.name("Ok")).isDisplayed())
            {
                    
                    test.log(LogStatus.PASS, "<FONT color=green style=Arial> New Loan is Completed Successfully");
                   
            		

            }
               else
            {
                    test.log(LogStatus.FAIL, "<FONT color=green style=Arial>New Loan is not Completed Successfully ");
            }
    }

public static void ILP()
{
try{

    System.out.println("IN ILP/TLP");
    String Pname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+rnum+"]/td[2]")).getText();
    System.out.println("current row of table"+Pname);
    if(Pname.equals(stateProductType))
    {
            if(NewLoan_Term.equals("Term1"))
            {
            driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+rnum+"]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input")).click();
            }
            if(NewLoan_Term.equals("Term2"))
            {
                    driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+rnum+"]/td[5]/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/b/input")).click();
            }
    }
    test.log(LogStatus.PASS, "Product selected as "+stateProductType+" Term Selected as "+NewLoan_Term);


            driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
            test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
            driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
            test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
            String Instamt=driver.findElement(By.name("advanceRequestBean.advanceAmt")).getAttribute("value");
            System.out.println(Instamt);
            driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(Instamt);
            test.log(LogStatus.PASS, "Disb Amt is enterted as "+Instamt);
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
            if(AllowPromotion.equals("Yes"))
            {
                    driver.findElement(By.name("allowPromotion")).click();
                    test.log(LogStatus.PASS, "AllowPromotion is selected ");
                    //String mwh=driver.getWindowHandle();
                    driver.findElement(By.name("requestBean.siilBean.couponNbr")).sendKeys(CouponNbr);
                    test.log(LogStatus.PASS, "CouponNbr is selected as "+CouponNbr);
                    //String winHandle = driver.getWindowHandle(); //Get current window handle.
            }
             WebElement ele = driver.findElement(By.name("requestBean.siilBean.nbrOfInst"));
            String NumofInst=ele.getAttribute("value");
            //*[@id="errorMessage"]/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[5]/td[2]/input
            System.out.println(NumofInst);
            int installments = Integer.parseInt(NumofInst);
            for(int i=0;i<installments;i++)
            {
                     Random rand = new Random();
                     int rand1 = rand.nextInt(100000);
                     String chknum = Integer.toString(rand1);
                    driver.findElement(By.id("checkNbrs"+i)).sendKeys(chknum);

            }
            driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
            //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);
            test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
            driver.findElement(By.name("finishLoan")).click();
            //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[1]/td[5]/input")).click();
            test.log(LogStatus.PASS, "click on Finish Loan button ");
            try {
                Alert alert = driver.switchTo().alert();
                alert.accept();
                //if alert present, accept and move on.

            }
            catch (NoAlertPresentException e) {
                //do what you normally would if you didn't have the alert.
            }
            //for( String winHandle1 : driver.getWindowHandles())
            //{
               // driver.switchTo().window(winHandle1);
            //}
             driver.switchTo().defaultContent();
             driver.switchTo().frame("mainFrame");
             driver.switchTo().frame("main");
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("OKBut")));
             driver.findElement(By.name("OKBut")).click();
            //driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input[1]")).click();
            test.log(LogStatus.PASS, "click on Yes button ");
            for( String winHandle1 : driver.getWindowHandles())
            {
                driver.switchTo().window(winHandle1);
            }
             driver.switchTo().defaultContent();
             driver.switchTo().frame("mainFrame");
             driver.switchTo().frame("main");
            if(driver.findElement(By.name("ok")).isDisplayed())
            {
                    test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
                    //driver.findElement(By.name("ok")).click();
            }
            else
            {
                    test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
            }



}
catch(Exception e)
{

}
}

public static void TLP()
{
try {
    System.out.println("IN ILP/TLP");
    String Pname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+rnum+"]/td[2]")).getText();
    System.out.println("current row of table"+Pname);
    if(Pname.equals(stateProductType))
    {
            if(NewLoan_Term.equals("Term1"))
            {
            driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+rnum+"]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input")).click();
            }
            if(NewLoan_Term.equals("Term2"))
            {
                    driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+rnum+"]/td[5]/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/b/input")).click();
            }
    }
    test.log(LogStatus.PASS, "Product selected as "+stateProductType+" Term Selected as "+NewLoan_Term);


            driver.findElement(By.name("requestBean.titleNumber")).sendKeys(TitleNumber);
            driver.findElement(By.xpath("//*[@id='appraisal']")).sendKeys(AppraisalValue);
    //      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.findElement(By.name("button1")).click();
            test.log(LogStatus.PASS, "click on Update 1 button ");
            //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            //WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("requestBean.extClr")));
    //      for( String winHandle1 : driver.getWindowHandles())
    //      {
    //          driver.switchTo().window(winHandle1);
    //      }
            // driver.switchTo().defaultContent();
            // driver.switchTo().frame("mainFrame");
            // driver.switchTo().frame("main");
            driver.findElement(By.name("requestBean.extClr")).sendKeys(ExteriorColor);
            driver.findElement(By.name("requestBean.licensePltNbr")).sendKeys(LicensePlateNumber);
            driver.findElement(By.name("requestBean.licensePltExpire")).sendKeys(LicensePlateExp);
            driver.findElement(By.name("requestBean.paintCondition")).sendKeys("Clean");
            driver.findElement(By.name("requestBean.bodyCondition")).sendKeys("Clean");
            driver.findElement(By.name("requestBean.glassCondition")).sendKeys("Clean");
            driver.findElement(By.name("requestBean.tiresCondition")).sendKeys("Clean");
            driver.findElement(By.name("requestBean.coverageType")).sendKeys(InsuranceCoverage);
            driver.findElement(By.name("iPhoneNbr1")).sendKeys(PhoneNbr1);
            driver.findElement(By.name("iPhoneNbr2")).sendKeys(PhoneNbr2);
            driver.findElement(By.name("iPhoneNbr3")).sendKeys(PhoneNbr3);
            driver.findElement(By.name("requestBean.companyName")).sendKeys(InsuranceCompany);
            driver.findElement(By.name("iexpiry1")).sendKeys(InsuranceExpiryDate1);
            driver.findElement(By.name("iexpiry2")).sendKeys(InsuranceExpiryDate2);
            driver.findElement(By.name("iexpiry3")).sendKeys(InsuranceExpiryDate3);
            driver.findElement(By.name("requestBean.polocyNbr")).sendKeys(PolicyNumber);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("button2")));
            driver.findElement(By.name("button2")).click();
            driver.findElement(By.name("button2")).click();
            //driver.findElement(By.name("button2")).click();
            //driver.findElement(By.name("button2")).click();
            test.log(LogStatus.PASS, "click on Update 2 button ");
            Thread.sleep(8000);
            //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            /*for( String winHandle1 : driver.getWindowHandles())
            {
                driver.switchTo().window(winHandle1);
            }
             driver.switchTo().defaultContent();
             driver.switchTo().frame("mainFrame");
             driver.switchTo().frame("main");*/
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("process")));
            driver.findElement(By.name("process")).click();
            //driver.findElement(By.name("process")).click();
            //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[1]/td[5]/input")).click();
            test.log(LogStatus.PASS, "click on process Loan button ");
            try {
                Alert alert = driver.switchTo().alert();
                alert.accept();
                //if alert present, accept and move on.

            }
            catch (NoAlertPresentException e) {
                //do what you normally would if you didn't have the alert.
            }
            Thread.sleep(5000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("collateralType")));
            driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
            //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
            test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
            driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
            test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
            String Instamt=driver.findElement(By.name("cashToCust")).getAttribute("value");
            System.out.println(Instamt);
            driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(Instamt);
            test.log(LogStatus.PASS, "Disb Amt is enterted as "+Instamt);
            //driver.findElement(By.name("vehicleKey")).sendKeys("Yes");

            driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);

            test.log(LogStatus.PASS, "Payment Reminder Consent is selected as "+ESign_CourtesyCallConsent);
            driver.findElement(By.name("requestBean.siilBean.emailConsentFlag")).sendKeys(ESign_CourtesyCallConsent);
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
            if(AllowPromotion.equals("Yes"))
            {
                    driver.findElement(By.name("allowPromotion")).click();
                    test.log(LogStatus.PASS, "AllowPromotion is selected ");
                    //String mwh=driver.getWindowHandle();
                    driver.findElement(By.name("requestBean.siilBean.couponNbr")).sendKeys(CouponNbr);
                    test.log(LogStatus.PASS, "CouponNbr is selected as "+CouponNbr);
                    //String winHandle = driver.getWindowHandle(); //Get current window handle.
            }
            driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
            driver.findElement(By.name("finishLoan")).click();
            test.log(LogStatus.PASS, "Click on Finish Loan Button");
            for( String winHandle1 : driver.getWindowHandles())
            {
                driver.switchTo().window(winHandle1);
            }
             driver.switchTo().defaultContent();
             driver.switchTo().frame("mainFrame");
             driver.switchTo().frame("main");
             driver.findElement(By.xpath("//*[@id='OKBut']")).click();
             //driver.findElement(By.name("OKBut")).click();
            //driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input[1]")).click();
            test.log(LogStatus.PASS, "click on Yes button ");
            for( String winHandle1 : driver.getWindowHandles())
            {
                driver.switchTo().window(winHandle1);
            }
             driver.switchTo().defaultContent();
             driver.switchTo().frame("mainFrame");
             driver.switchTo().frame("main");
            if(driver.findElement(By.name("ok")).isDisplayed())
            {
                    test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
                    driver.findElement(By.name("ok")).click();
            }
           
} catch (Exception e) {
    // TODO: handle exception
}
}
public static void LOC()
{
try {


            driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
            test.log(LogStatus.PASS, "CollateralType is selected as "+ESign_CollateralType);
            Thread.sleep(5000);
            driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
            test.log(LogStatus.PASS, "Payment Reminder Consent is selected as "+ESign_CourtesyCallConsent);
            driver.findElement(By.name("advanceRequestBean.emailConsentFlag")).sendKeys(ESign_CourtesyCallConsent);
            test.log(LogStatus.PASS, "Payment Reminder Consent is selected as "+ESign_CourtesyCallConsent);
            driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
            driver.findElement(By.name("finishadvance")).click();
            test.log(LogStatus.PASS, "Click on Finish LOC Button");
            for( String winHandle1 : driver.getWindowHandles())
            {
                driver.switchTo().window(winHandle1);
            }
             driver.switchTo().defaultContent();
             driver.switchTo().frame("mainFrame");
             driver.switchTo().frame("main");
             driver.findElement(By.xpath("//*[@id='OKBut']")).click();
             //driver.findElement(By.name("OKBut")).click();
            //driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input[1]")).click();
            test.log(LogStatus.PASS, "click on Yes button ");
            for( String winHandle1 : driver.getWindowHandles())
            {
                driver.switchTo().window(winHandle1);
            }
             driver.switchTo().defaultContent();
             driver.switchTo().frame("mainFrame");
             driver.switchTo().frame("main");

            if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td/table[2]/tbody/tr/td[2]/input")).isDisplayed())
            {
                    test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
                    driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td/table[2]/tbody/tr/td[2]/input")).click();
            }
            else
            {
                    test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
            }

} catch (Exception e) {
    // TODO: handle exception
}
}
}

