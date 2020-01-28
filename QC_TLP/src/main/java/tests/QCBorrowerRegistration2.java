package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import tests.QCStore;

public class QCBorrowerRegistration2 extends QCStore {
	


	public static void borrowerRegistration(String SSN,String AppURL) throws Exception
	{
		int i;
		for(i=0;i<3;i++)
		{
			
		try{
			//String FileName= prop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Borrower_Registration");
				String sheetName="Borrower_Registration";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					
					


					if(SSN.equals(RegSSN))
					{	
				
						test.log(LogStatus.INFO, "Borrower Registration has started");
						
						//test.log(LogStatus.INFO, MarkupHelper.createLabel("Borrower Registration has started", ExtentColor.BLUE));
							          
				
						String UserName = TestData.getCellData(sheetName,"UserName",row);
						String Password = TestData.getCellData(sheetName,"Password",row);
				       // System.out.println(Password);
				        String StoreId = TestData.getCellData(sheetName,"StoreID",row);
				        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				        String StateID = TestData.getCellData(sheetName,"StateID",row);
				      	
				        String Header = StateID+ "_" + ProductID;	      
				        String ProductType= TestData.getCellData(sheetName,"ProductType",row);         
				       String LastName = TestData.getCellData(sheetName,"LastName",row);
				       String FirstName = TestData.getCellData(sheetName,"FirstName",row);
				       String AddressLine = TestData.getCellData(sheetName,"AddressLine",row);
				       String City = TestData.getCellData(sheetName,"City",row);
				       String State = TestData.getCellData(sheetName,"State",row);	      
				       String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);
				       String MonthsAtAddress = TestData.getCellData(sheetName,"MonthsAtAddress",row);	     
				       String Bank_ABARoutingNbr = TestData.getCellData(sheetName,"Bank_ABARoutingNbr",row);
				       String Bank_ChkgAcctNbr = TestData.getCellData(sheetName,"Bank_ChkgAcctNbr",row);	       
				       String Ctc_PrimaryPhone = TestData.getCellData(sheetName,"Ctc_PrimaryPhone",row);
				       String Ctc_PhoneType = TestData.getCellData(sheetName,"Ctc_PhoneType",row);
				       String Misc_PhotoIDNbr = TestData.getCellData(sheetName,"Misc_PhotoIDNbr",row);
				       String Misc_IDExpDate = TestData.getCellData(sheetName,"Misc_IDExpDate",row);	   
				       String Misc_PhotoIDType = TestData.getCellData(sheetName,"Misc_PhotoIDType",row);
				       String BorrDOB = TestData.getCellData(sheetName,"Misc_DOB",row);
				       String Income_IncomeType = TestData.getCellData(sheetName,"Income_IncomeType",row);
				       String Income_Employer = "employer";
				    		   //TestData.getCellData(sheetName,"Income_Employer",row);
				       String Income_WorkPhone = TestData.getCellData(sheetName,"Income_WorkPhone",row);
				       String Income_NetIncomeAmt = TestData.getCellData(sheetName,"Income_NetIncomeAmt",row);
				       String Income_GrossIncome = TestData.getCellData(sheetName,"Income_GrossIncome",row);
				       String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				       String Income_HireDt = TestData.getCellData(sheetName,"Income_HireDt",row);
				       String Income_DirectDeposit=TestData.getCellData(sheetName,"Income_DirectDeposit",row);	       
				       String PrimaryRef_LastName = TestData.getCellData(sheetName,"PrimaryRef_LastName",row);
				       String PrimaryRef_FirstName = TestData.getCellData(sheetName,"PrimaryRef_FirstName",row);
				       String PrimaryRef_Relationship = TestData.getCellData(sheetName,"PrimaryRef_Relationship",row);
				       String PrimaryRef_PhoneNbr=TestData.getCellData(sheetName,"PrimaryRef_PhoneNbr",row);
				       String Ref_LastName = TestData.getCellData(sheetName,"Ref_LastName",row);
				       String Ref_FirstName = TestData.getCellData(sheetName,"Ref_FirstName",row);
				       String Ref_Relationship = TestData.getCellData(sheetName,"Ref_Relationship",row);
				       String Ref_PhoneNbr=TestData.getCellData(sheetName,"Ref_PhoneNbr",row);	       
				       String Bankruptcy=TestData.getCellData(sheetName,"Bankruptcy",row);	     
						//	test.log(LogStatus.INFO, "Borrower Registration-SSN: " +SSN);
							
							   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
						        String SSN1 = SSN.substring(0, 3);
						        String SSN2 = SSN.substring(3,5);
						        String SSN3 = SSN.substring(5,9);
						        String PP1 = Ctc_PrimaryPhone.substring(0, 3);
						        String PP2 = Ctc_PrimaryPhone.substring(3, 6);
						        String PP3 = Ctc_PrimaryPhone.substring(6, 10);
						        String IncomeP1 = Income_WorkPhone.substring(0, 3);
						        String IncomeP2 = Income_WorkPhone.substring(3, 6);
						        String IncomeP3 = Income_WorkPhone.substring(6, 10);
						        String PrimaryRef_PhoneNbr1 = PrimaryRef_PhoneNbr.substring(0, 3);
						        String PrimaryRef_PhoneNbr2 = PrimaryRef_PhoneNbr.substring(3, 6);
						        String PrimaryRef_PhoneNbr3 = PrimaryRef_PhoneNbr.substring(6, 10);
						        String Ref_PhoneNbr1 = Ref_PhoneNbr.substring(0, 3);
						        String Ref_PhoneNbr2 = Ref_PhoneNbr.substring(3, 6);
						        String Ref_PhoneNbr3 = Ref_PhoneNbr.substring(6, 10);			       
						        System.out.println(Misc_IDExpDate);
						        Date Misc_IDExpDt = df.parse(Misc_IDExpDate);
						        String IDExpDate0 =df.format(Misc_IDExpDt);	
						        System.out.println(IDExpDate0);
						        String IDExpDate[] =IDExpDate0.split("/");
						        String IDExpD1 = IDExpDate[0];
						        String IDExpD2 = IDExpDate[1];
						        String IDExpD3 = IDExpDate[2];
						        String DOB[] =BorrDOB.split("/");
						        String DOB1 = DOB[0];
						        String DOB2 = DOB[1];
						        String DOB3 = DOB[2];	
						        String Monthly_Type= TestData.getCellData(sheetName,"MonthlyType",row);
						        String Monthly_payWeek=TestData.getCellData(sheetName,"MonthlyPayWeek",row);
						        String Monthly_payWeekDay=TestData.getCellData(sheetName,"MonthlyPayWeekDay",row);
						        String Monthly_payday= TestData.getCellData(sheetName,"MonthlyPayDay",row);
						       
						      
						        driver.switchTo().frame("bottom");
								String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
								String store_date[]=Str_date.split(":");
								business_date=store_date[1].trim();
								business_date=store_date[1].trim();
								test.log(LogStatus.PASS, "Business date is :"+business_date);
								Thread.sleep(2000);
								driver.switchTo().defaultContent();	      
						  
						// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));

				        driver.switchTo().frame("topFrame");	        
				        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));
				       
				        driver.findElement(locator(prop.getProperty("borrower_tab"))).click();	
				        Thread.sleep(2000);
						//driver.findElement(By.xpath("//*[contains(text(),'Borrower')]")).click();			
						test.log(LogStatus.PASS, "Clicked on Borrower");
						 Thread.sleep(2000);
					
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");			 
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='901000']")));
						driver.findElement(locator(prop.getProperty("registration_link"))).click();
					
						test.log(LogStatus.PASS, "Clicked on Registration");			
						driver.switchTo().frame("main");	
						driver.findElement(By.name("customerBean.custProdType")).sendKeys(ProductType);
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						 test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
						driver.findElement(locator(prop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
						driver.findElement(locator(prop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
						driver.findElement(locator(prop.getProperty("CSR_SSN_cfm_first_field"))).sendKeys(SSN1);
						test.log(LogStatus.PASS, "Confirm SSN1 is entered: "+SSN1);
						driver.findElement(locator(prop.getProperty("CSR_SSN_cfm_second_field"))).sendKeys(SSN2);
						test.log(LogStatus.PASS, "Confirm SSN2 is entered: "+SSN2);
						driver.findElement(locator(prop.getProperty("CSR_SSN_cfm_third_field"))).sendKeys(SSN3);
						test.log(LogStatus.PASS, "Confirm SSN3 is entered: "+SSN3);		
						
						driver.findElement(locator(prop.getProperty("CSR_lastname"))).sendKeys(LastName);
						test.log(LogStatus.PASS, "LastName is entered: "+LastName);
						driver.findElement(locator(prop.getProperty("CSR_firstname"))).sendKeys(FirstName);
						test.log(LogStatus.PASS, "FirstName is entered: "+FirstName);
						driver.findElement(locator(prop.getProperty("CSR_reg_addressline"))).sendKeys(AddressLine);
						test.log(LogStatus.PASS, "AddressLine is entered: "+AddressLine);
						driver.findElement(locator(prop.getProperty("CSR_reg_city"))).sendKeys(City);
						test.log(LogStatus.PASS, "City is entered: "+City);
						driver.findElement(locator(prop.getProperty("CSR_reg_state"))).sendKeys(State);
						test.log(LogStatus.PASS, "State is entered: "+State);
						driver.findElement(locator(prop.getProperty("CSR_reg_zipcode"))).sendKeys(ZipCode);
						test.log(LogStatus.PASS, "ZipCode is entered: "+ZipCode);
						driver.findElement(locator(prop.getProperty("CSR_reg_months_at_address"))).sendKeys(MonthsAtAddress);
						test.log(LogStatus.PASS, "MonthsAtAddress is entered: "+MonthsAtAddress);
						driver.findElement(locator(prop.getProperty("CSR_reg_primary_phone1"))).sendKeys(PP1);
						test.log(LogStatus.PASS, "PP1 is entered: "+PP1);
						driver.findElement(locator(prop.getProperty("CSR_reg_primary_phone2"))).sendKeys(PP2);
						test.log(LogStatus.PASS, "PP2 is entered: "+PP2);
						driver.findElement(locator(prop.getProperty("CSR_reg_primary_phone3"))).sendKeys(PP3);
						test.log(LogStatus.PASS, "PP3 is entered: "+PP3);
						//driver.findElement(locator(prop.getProperty("phoneNbr3"))(PP3);
						//test.log(LogStatus.PASS, "PP3 is entered: "+PP3);
						Select PhoneType  = new Select(driver.findElement(locator(prop.getProperty("CSR_reg_phonetype"))));
						PhoneType.selectByVisibleText(Ctc_PhoneType);
						test.log(LogStatus.PASS, "Phone Type is selected as: "+Ctc_PhoneType);
						driver.findElement(locator(prop.getProperty("CSR_reg_email_option_no"))).click();
						test.log(LogStatus.PASS, "Does not have e-mail selected");
						driver.findElement(locator(prop.getProperty("CSR_reg_photoID"))).sendKeys(Misc_PhotoIDNbr);
						test.log(LogStatus.PASS, "PhotoIDNbr is entered: "+Misc_PhotoIDNbr);
						driver.findElement(locator(prop.getProperty("CSR_reg_state_cust"))).sendKeys(State);
						test.log(LogStatus.PASS, "ID State is entered: "+State);
						driver.findElement(locator(prop.getProperty("CSR_reg_exp_date1"))).sendKeys(IDExpD1);
						test.log(LogStatus.PASS, "ID Expiration Date1 is entered: "+IDExpD1);
						driver.findElement(locator(prop.getProperty("CSR_reg_exp_date2"))).sendKeys(IDExpD2);
						test.log(LogStatus.PASS, "ID Expiration Date1 is entered: "+IDExpD2);
						driver.findElement(locator(prop.getProperty("CSR_reg_exp_date3"))).sendKeys(IDExpD3);
						test.log(LogStatus.PASS, "ID Expiration Date1 is entered: "+IDExpD3);
						driver.findElement(locator(prop.getProperty("CSR_reg_photoID_type"))).sendKeys(Misc_PhotoIDType);
						test.log(LogStatus.PASS, "PhotoIDType is entered: "+Misc_PhotoIDType);
						driver.findElement(locator(prop.getProperty("CSR_reg_zipcode_cust"))).sendKeys(ZipCode);
						test.log(LogStatus.PASS, "ZipCode is entered: "+ZipCode);
						driver.findElement(locator(prop.getProperty("CSR_reg_dob_field1"))).sendKeys(DOB1);
						test.log(LogStatus.PASS, "DOB1 Date1 is entered: "+DOB1);
						driver.findElement(locator(prop.getProperty("CSR_reg_dob_field2"))).sendKeys(DOB2);
						test.log(LogStatus.PASS, "DOB3 is entered: "+DOB2);
						driver.findElement(locator(prop.getProperty("CSR_reg_dob_field3"))).sendKeys(DOB3);
						test.log(LogStatus.PASS, "DOB3 is entered: "+DOB3);
						//driver.findElement(locator(prop.getProperty("PhoneNbr2")).sendKeys(PP3);
						driver.findElement(locator(prop.getProperty("CSR_reg_income_type"))).sendKeys(Income_IncomeType);
						test.log(LogStatus.PASS, "IncomeType is entered: "+Income_IncomeType);
						driver.findElement(locator(prop.getProperty("CSR_reg_employer"))).sendKeys(Income_Employer);
						test.log(LogStatus.PASS, "Employer is entered: "+Income_Employer);
						driver.findElement(locator(prop.getProperty("CSR_reg_work_phone1"))).sendKeys(IncomeP1);
						test.log(LogStatus.PASS, "PP1 is entered: "+IncomeP1);
						driver.findElement(locator(prop.getProperty("CSR_reg_work_phone2"))).sendKeys(IncomeP2);
						test.log(LogStatus.PASS, "PP2 is entered: "+IncomeP2);
						driver.findElement(locator(prop.getProperty("CSR_reg_work_phone3"))).sendKeys(IncomeP3);
						test.log(LogStatus.PASS, "PP3 is entered: "+IncomeP3);
						Thread.sleep(2000);
						driver.findElement(locator(prop.getProperty("CSR_reg_net_income"))).sendKeys(Income_NetIncomeAmt);
						test.log(LogStatus.PASS, "Income_NetIncomeAmt is entered: "+Income_NetIncomeAmt);
						driver.findElement(locator(prop.getProperty("CSR_reg_gross_income"))).sendKeys(Income_GrossIncome);
						test.log(LogStatus.PASS, "Income_GrossIncome is entered: "+Income_GrossIncome);
						/*driver.findElement(locator(prop.getProperty("CSR_reg_pay_frequency"))).sendKeys(Income_PayFrequency);
						test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);*/
						
						if(Income_PayFrequency.equals("Bi-Weekly")){
							driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
							test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);	
							driver.findElement(By.id("rad_wk4")).click();
							 test.log(LogStatus.PASS, "Clicked on wednsday button ");
						}
						if(Income_PayFrequency.equals("Monthly")){
							driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
							test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);	
							
							if(Monthly_Type.equals("1")){
								 test.log(LogStatus.PASS, "Monthly type selected: "+Monthly_Type);	
							 driver.findElement(By.name("customerBean.monthlyDate")).sendKeys(Monthly_payday);
							 test.log(LogStatus.PASS, "DAY OF MONTH HAS ENTERD: "+Monthly_payday);	
							}
							else if(Monthly_Type.equals("2")){
								 test.log(LogStatus.PASS, "Monthly type selected: "+Monthly_Type);	
								 driver.findElement(By.id("rad_monthly2")).click();
								 test.log(LogStatus.PASS, "Clicked on monthly type: "+Monthly_Type);
								 driver.findElement(By.name("customerBean.monthlyWeek")).sendKeys(Monthly_payWeek);
								 test.log(LogStatus.PASS, "Monthly pay week is selected : "+Monthly_payWeek);
								 driver.findElement(By.name("customerBean.monthlyDay")).sendKeys(Monthly_payWeekDay);
								 test.log(LogStatus.PASS, "Monthly pay week is selected : "+Monthly_payWeekDay);
								}}
						else if(Income_PayFrequency.equals("Semi-Monthly"))
						{
							driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
							test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);	
							 driver.findElement(By.id("rad_semi1")).click();
							 test.log(LogStatus.PASS, "Clicked on 1st and 16th of check box  ");
							 
						}
						
						else if(Income_PayFrequency.equals("Weekly")){
							driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
							test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);	
							driver.findElement(By.id("rad_wk4")).click();
							 test.log(LogStatus.PASS, "Clicked on wednsday button ");
							
						}
						
						
						
						
						
						
						
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("bottom");
						 String  BusinessDt= driver.findElement(locator(prop.getProperty(("CSR_reg_business_date")))).getText();
						 String Busdate[]=BusinessDt.split(":");
						// String date = Busdate[1];
						 String date1 = Busdate[1].replaceAll("\\s", "");
							String date = date1.substring(1, date1.length());
							
						 Date d1 = df.parse(date);
						 Calendar cal = Calendar.getInstance();
						 cal.setTime(d1);
						 cal.add(Calendar.DATE, -20);
						 Date PayStubReviewedDate1= cal.getTime();
						 
						 String PayStubReviewedDate =df.format(PayStubReviewedDate1);
								 //Date D=Add(date1,7);
						 //System.out.println(date);
						
						 //System.out.println(PayStubReviewedDate);
						 
						 	String PayStubReviewedDate0[] =PayStubReviewedDate.split("/");
					        String PayStubReviewedDate2 = PayStubReviewedDate0[0];
					        String PayStubReviewedDate3 = PayStubReviewedDate0[1];
					        String PayStubReviewedDate4 = PayStubReviewedDate0[2];
					        driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
					        driver.findElement(locator(prop.getProperty("CSR_reg_paystub_review1"))).sendKeys(PayStubReviewedDate2);
							test.log(LogStatus.PASS, "PayStubReviewed1 is entered: "+PayStubReviewedDate2);
							driver.findElement(locator(prop.getProperty("CSR_reg_paystub_review2"))).sendKeys(PayStubReviewedDate3);
							test.log(LogStatus.PASS, "PayStubReviewed2 is entered: "+PayStubReviewedDate3);
							driver.findElement(locator(prop.getProperty("CSR_reg_paystub_review3"))).sendKeys(PayStubReviewedDate4);
							test.log(LogStatus.PASS, "PayStubReviewed3 is entered: "+PayStubReviewedDate4);
							
							cal.add(Calendar.DATE, -30);
							 Date PayStubDate1= cal.getTime();
							 
							 String PayStubDate =df.format(PayStubDate1);
									 //Date D=Add(date1,7);
							 //System.out.println(date);
							
							 //System.out.println(PayStubReviewedDate);
							 
							 	String PayStubDate0[] =PayStubDate.split("/");
						        String PayStubDate2 = PayStubDate0[0];
						        String PayStubDate3 = PayStubDate0[1];
						        String PayStubDate4 = PayStubDate0[2];
						        driver.findElement(locator(prop.getProperty("CSR_reg_paystub_date1"))).sendKeys(PayStubDate2);
								test.log(LogStatus.PASS, "payStubDate1 is entered: "+PayStubDate2);
								driver.findElement(locator(prop.getProperty("CSR_reg_paystub_date2"))).sendKeys(PayStubDate3);
								test.log(LogStatus.PASS, "payStubDate2 is entered: "+PayStubDate3);
								driver.findElement(locator(prop.getProperty("CSR_reg_paystub_date3"))).sendKeys(PayStubDate4);
								test.log(LogStatus.PASS, "payStubDate3 is entered: "+PayStubDate4);
								
								String Income_HireDt0[] =Income_HireDt.split("/");
						        String Income_HireDt1 = Income_HireDt0[0];
						        String Income_HireDt2 = Income_HireDt0[1];
						        String Income_HireDt3 = Income_HireDt0[2];
						        
						        driver.findElement(locator(prop.getProperty("CSR_reg_hiredate1"))).sendKeys(Income_HireDt1);
								test.log(LogStatus.PASS, "hireDate1 is entered: "+Income_HireDt1);
								driver.findElement(locator(prop.getProperty("CSR_reg_hiredate2"))).sendKeys(Income_HireDt2);
								test.log(LogStatus.PASS, "hireDate2 is entered: "+Income_HireDt2);
								driver.findElement(locator(prop.getProperty("CSR_reg_hiredate3"))).sendKeys(Income_HireDt3);
								test.log(LogStatus.PASS, "hireDate3 is entered: "+Income_HireDt3);
					
						driver.findElement(locator(prop.getProperty("CSR_reg_direct_deposit"))).sendKeys(Income_DirectDeposit);
						test.log(LogStatus.PASS, "DirectDeposit is entered: "+Income_DirectDeposit);
						cal.add(Calendar.DATE, -60);
						 Date Bank_AcctVerificationDt0= cal.getTime();
							 
							    String Bank_AcctVerificationDt =df.format(Bank_AcctVerificationDt0);
							    String Bank_AcctVerificationDt1[] =Bank_AcctVerificationDt.split("/");
						        String Bank_AcctVerificationDt2 = Bank_AcctVerificationDt1[0];
						        String Bank_AcctVerificationDt3 = Bank_AcctVerificationDt1[1];
						        String Bank_AcctVerificationDt4 = Bank_AcctVerificationDt1[2];
								driver.findElement(locator(prop.getProperty("CSR_reg_acc_verify_date1"))).sendKeys(Bank_AcctVerificationDt2);
								test.log(LogStatus.PASS, "Bank_AcctVerificationDt1 is entered: "+Bank_AcctVerificationDt2);
								driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
								driver.findElement(locator(prop.getProperty("CSR_reg_acc_verify_date2"))).sendKeys(Bank_AcctVerificationDt3);
								test.log(LogStatus.PASS, "Bank_AcctVerificationDt2 is entered: "+Bank_AcctVerificationDt3);
								driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
								driver.findElement(locator(prop.getProperty("CSR_reg_acc_verify_date3"))).sendKeys(Bank_AcctVerificationDt4);
								test.log(LogStatus.PASS, "Bank_AcctVerificationDt3 is entered: "+Bank_AcctVerificationDt4);
							
						 //driver.findElement(locator(prop.getProperty("customerBean.abaNbrDisp")).sendKeys(Bank_ABARoutingNbr);
						//driver.findElement(locator(prop.getProperty("phoneNbr3"))(PP3);
						//test.log(LogStatus.PASS, "PP3 is entered: "+PP3);
								driver.findElement(locator(prop.getProperty("CSR_reg_ABA_number"))).sendKeys(Bank_ABARoutingNbr);
								test.log(LogStatus.PASS, "Bank_ABARoutingNbr is entered: "+Bank_ABARoutingNbr);
								driver.findElement(locator(prop.getProperty("CSR_reg_confirm_ABA_number"))).sendKeys(Bank_ABARoutingNbr);
								test.log(LogStatus.PASS, "Confirm ABA/Routing Nbr is entered: "+Bank_ABARoutingNbr);
								driver.findElement(locator(prop.getProperty("CSR_reg_acc_number"))).sendKeys(Bank_ChkgAcctNbr);
								test.log(LogStatus.PASS, "Chkg Acct Nbr is entered: "+Bank_ChkgAcctNbr);			
								driver.findElement(locator(prop.getProperty("CSR_reg_confirm_acc_number"))).sendKeys(Bank_ChkgAcctNbr);
								test.log(LogStatus.PASS, "Confirm Chkg Acct Nbr is entered: "+Bank_ChkgAcctNbr);			
						//driver.findElement(locator(prop.getProperty("customerBean.drivingZipcode")).sendKeys(Bank_ChkgAcctNbr);
						//test.log(LogStatus.PASS, "drivingZipcode is entered: "+MiscZipCode);
						
						//Primary Reference Details
						
						
								driver.findElement(locator(prop.getProperty("CSR_reg_primary_ref_lastname"))).sendKeys(PrimaryRef_LastName);
								test.log(LogStatus.PASS, "PRLast Name is entered: "+PrimaryRef_LastName);
								driver.findElement(locator(prop.getProperty("CSR_reg_primary_ref_firstname"))).sendKeys(PrimaryRef_FirstName);
								test.log(LogStatus.PASS, "PRFirst Name is entered: "+PrimaryRef_FirstName);
						
						//driver.findElement(locator(prop.getProperty("customerBean.contName")).sendKeys(PrimaryRef_LastName);
								driver.findElement(locator(prop.getProperty("CSR_reg_primary_relation"))).sendKeys(PrimaryRef_Relationship);
								test.log(LogStatus.PASS, "Contactrelation is entered: "+PrimaryRef_Relationship);
								driver.findElement(locator(prop.getProperty("CSR_reg_primary_ref_phone1"))).sendKeys(PrimaryRef_PhoneNbr1);
								test.log(LogStatus.PASS, "PrimaryReference Phone Nbr1 is entered: "+PrimaryRef_PhoneNbr1);
								driver.findElement(locator(prop.getProperty("CSR_reg_primary_ref_phone2"))).sendKeys(PrimaryRef_PhoneNbr2);
								test.log(LogStatus.PASS, "PrimaryReference Phone Nbr1 is entered: "+PrimaryRef_PhoneNbr2);
								driver.findElement(locator(prop.getProperty("CSR_reg_primary_ref_phone3"))).sendKeys(PrimaryRef_PhoneNbr3);
								test.log(LogStatus.PASS, "PrimaryReference Phone Nbr1 is entered: "+PrimaryRef_PhoneNbr3);
						//Thread.sleep(10000);
						// Reference Details
								//driver.findElement(locator(prop.getProperty("bt_Reference")).click();			
								//test.log(LogStatus.PASS, "Clicked on ADD Reference");
							
								driver.findElement(locator(prop.getProperty("CSR_reg_secondary_ref_lastname"))).sendKeys(Ref_LastName);
								test.log(LogStatus.PASS, "RLast Name is entered: "+Ref_LastName);
								driver.findElement(locator(prop.getProperty("CSR_reg_secondary_ref_firstname"))).sendKeys(Ref_FirstName);
								test.log(LogStatus.PASS, "RFirst Name is entered: "+Ref_FirstName);
							    driver.findElement(locator(prop.getProperty("CSR_reg_secondary_relation"))).sendKeys(Ref_Relationship);
								test.log(LogStatus.PASS, "reference relation is entered: "+Ref_Relationship);
								driver.findElement(locator(prop.getProperty("CSR_reg_secondary_ref_phone1"))).sendKeys(Ref_PhoneNbr1);
								test.log(LogStatus.PASS, "Reference Phone Nbr1 is entered: "+Ref_PhoneNbr1);
								driver.findElement(locator(prop.getProperty("CSR_reg_secondary_ref_phone2"))).sendKeys(Ref_PhoneNbr2);
								test.log(LogStatus.PASS, "Reference Phone Nbr1 is entered: "+Ref_PhoneNbr2);
								driver.findElement(locator(prop.getProperty("CSR_reg_secondary_ref_phone3"))).sendKeys(Ref_PhoneNbr3);
								test.log(LogStatus.PASS, "Reference Phone Nbr1 is entered: "+Ref_PhoneNbr3);
								//Thread.sleep(10000);

								driver.findElement(locator(prop.getProperty("CSR_reg_add_reference_button"))).click();			
								test.log(LogStatus.PASS, "Clicked on ADD Reference");
						
								Thread.sleep(3000);
								driver.findElement(locator(prop.getProperty("CSR_reg_bunkrupty_selection"))).sendKeys(Bankruptcy);
								test.log(LogStatus.PASS, "Bankrupty is selected as: "+Bankruptcy);
								 
								 for(int j=1;j<=7;j++){       //''''''For Performed on Save&Exit Button
								 driver.findElement(locator(prop.getProperty("CSR_reg_bunkrupty_selection"))).sendKeys(Keys.TAB);
								 break;
								 }
								 
								driver.findElement(By.xpath("//*[@id='btnShowModalExit']")).sendKeys(Keys.ENTER);
								test.log(LogStatus.PASS, "Clicked on Save & Exit");
							
								Thread.sleep(2000);
									try { 
									    Alert alert = driver.switchTo().alert();
									    alert.accept();
									   // if alert present, accept and move on.												
										
									}
									catch (NoAlertPresentException e) {
									    //do what you normally would if you didn't have the alert.
									}
										
									   
								for(String winHandle : driver.getWindowHandles()){
									    
								  driver.switchTo().window(winHandle);
								  driver.switchTo().defaultContent();
								  driver.switchTo().frame("mainFrame");
								  driver.switchTo().frame("main");
									 
									 Thread.sleep(10000);
									 String elementname= driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/b/font")).getText();
									 test.log(LogStatus.PASS, "Registration Success Screen::"+elementname);
							
								
							    if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/b/font")).isDisplayed())
							    	
							 	{
								
								   test.log(LogStatus.PASS, "Borrower is Registered Successfully with SSN as " +SSN);	
								   test.log(LogStatus.PASS, "**********************************************" );
									// test.log(LogStatus.PASS, MarkupHelper.createLabel("Borrower is Registered Successfully with SSN as " +SSN, ExtentColor.GREEN) );

							 	}
							 	else
								{
								test.log(LogStatus.FAIL, "Borrower is not Registered Successfully with SSN as " +SSN);
								// test.log(LogStatus.FAIL, MarkupHelper.createLabel("Borrower is not Registered Successfully with SSN as " +SSN, ExtentColor.RED) );

								}
							 	
								}
				
								 
								   driver.switchTo().defaultContent();
								   driver.switchTo().frame("topFrame");
									
								try { 
								    Alert alert = driver.switchTo().alert();
								    alert.accept();
								    //if alert present, accept and move on.														
									
								}
								catch (NoAlertPresentException e) {
								    //do what you normally would if you didn't have the alert.
								}
							break;
							}
					
					}	
			break;
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Borrower Registration is failed", ExtentColor.RED));
				test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
				String screenshotPath = getScreenhot(driver, "Borrower");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.INFO, "Borrower Registration process is initiated again due to Application sync issue");
				driver.get(prop.getProperty("login_page"));  
				continue;

			}
		

}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "Borrower Registration is failed");
			Assert.assertTrue(false);
	
		}
	}
	}

