package tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class AQCCSRHistory extends QCStore{
	public static String ACH_type;
	public static String ACH_transaction;
	public static String ACH_status;
	public static String ACH_amount;
	public static String ACH_ABA_code;
	public static String ACH_check_acc_no;
	public static String ach_history_ach_type;
	public static String ach_history_ach_transaction;
	public static String ach_history_ach_status;
	public static String ach_history_ach_amt;
	public static String ach_history_ach_check_acc_no;
	public static String ach_history_ach_ABA_code;

	public static void history(String SSN,String AppURL) throws InterruptedException, ParseException
	{

				 
			int lastrow=TestData.getLastRow("Borrower_Registration");
			String sheetName="Borrower_Registration";
			String sheetName_calc="HistoryFieldsValidation";
			String sheetName_new_loan="NewLoan";
			

			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String UserName = TestData.getCellData(sheetName,"UserName",row);
					String Password = TestData.getCellData(sheetName,"Password",row);
			       // System.out.println(Password); 	
			        String StoreId = TestData.getCellData(sheetName,"StoreID",row);
			        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			        String StateID = TestData.getCellData(sheetName,"StateID",row);
			        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
			        String Header = StateID+ "_" + ProductID;	      
			        String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
			        System.out.println(columnname);
			       String LastName = TestData.getCellData(sheetName,"LastName",row);
			       String FirstName = TestData.getCellData(sheetName,"FirstName",row);
			       String customer_name=FirstName+" "+LastName;
			       String AddressLine = TestData.getCellData(sheetName,"AddressLine",row);
			       String City = TestData.getCellData(sheetName,"City",row);
			       String State = TestData.getCellData(sheetName,"State",row);	      
			       String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);
			       String MonthsAtAddress = TestData.getCellData(sheetName,"MonthsAtAddress",row);	     
			       String Bank_ABARoutingNbr = TestData.getCellData(sheetName,"Bank_ABARoutingNbr",row);
			       String Bank_ChkgAcctNbr = TestData.getCellData(sheetName,"Bank_ChkgAcctNbr",row);
			       Bank_ChkgAcctNbr= Bank_ChkgAcctNbr.substring(Bank_ChkgAcctNbr.length() - 4);
			       String Ctc_PrimaryPhone = TestData.getCellData(sheetName,"Ctc_PrimaryPhone",row);
			       String Ctc_PhoneType = TestData.getCellData(sheetName,"Ctc_PhoneType",row);
			       String Misc_PhotoIDNbr = TestData.getCellData(sheetName,"Misc_PhotoIDNbr",row);
			       String Misc_IDExpDate = TestData.getCellData(sheetName,"Misc_IDExpDate",row);	   
			       String Misc_PhotoIDType = TestData.getCellData(sheetName,"Misc_PhotoIDType",row);
			       String BorrDOB = TestData.getCellData(sheetName,"Misc_DOB",row);
			       String Income_IncomeType = TestData.getCellData(sheetName,"Income_IncomeType",row);
			       String ESign_CollateralType = TestData.getCellData(sheetName_new_loan,"ESign_CollateralType",row);
			       String courtesy_consent=TestData.getCellData(sheetName_new_loan,"ESign_CourtesyCallConsent",row);
			     //  String courtesy_consent_status=TestData.getCellData(sheetName_new_loan,"ESign_Preference",row);
			       String collateral_type=TestData.getCellData(sheetName_new_loan,"ESign_CollateralType",row);
			       
			       String primary_source_of_income = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",4);
			       System.out.println(sheetName_calc);
			       System.out.println(columnname+"_TxnHistory_FieldValue");

			       String Income_Employer = TestData.getCellData(sheetName,"Income_Employer",row);
			       String Income_WorkPhone = TestData.getCellData(sheetName,"Income_WorkPhone",row);
			       String NetIncomeAmt = TestData.getCellData(sheetName,"Income_NetIncomeAmt",row);
			       NetIncomeAmt=NetIncomeAmt+".00";
			       String GrossIncome = TestData.getCellData(sheetName,"Income_GrossIncome",row);
			       String pay_frequency=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",7);
			       String loan_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",8);
			       String check_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",9);
			       String product_type=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",11);
			       String loan_amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",12);
			       String finance_charge=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",13);
			       String apr=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",14);
			   //    String collateral_type=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",16);
			       String loan_frequency=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",17);
			       String credot_or_verification_fee=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",18);
			       String available_credit=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",19);
			       String courtesy_consent_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",21);
			       String principal_balance=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",22);
			       String fee_due=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",23);
			       String pay_off_amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",24);

			       String principal_paid_to_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",25);

			       String fee_paid_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",26);

			       //String total_paid_amountc=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",27);
			       String campaign_name=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",28);
			       String promotion_code=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",29);
			       String product_name=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",30);
			       String total_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",2);
			       String advance_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",3);
			       String advance_fees=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",4);
			       String NSF_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",5);
			       String WO_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",6);
			       String interest_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",7);
			       String origination_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",8);
			       String credit_or_verification_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",9);
			       String EPP_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",10);
	 //ACH collateral details from sheet
			      if(ESign_CollateralType.equals("ACH"))
			      {
				    	//To read from Excel
			    	  ACH_type=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",2);
				       ACH_transaction=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",3);
				        ACH_status=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",4);
				       ACH_amount=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",5);
				       ACH_ABA_code=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",6);
				       ACH_check_acc_no=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",7);
				       
			
			      }

			       
			      
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
						
						   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					        
					        String SSNverify="XXX-XX-"+SSN3;
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
					        
					Thread.sleep(4000);
				//	test.log(LogStatus.INFO, MarkupHelper.createLabel("Transaction History validation has started", ExtentColor.BLUE));
					test.log(LogStatus.INFO, "Transaction History validation has started");

					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
					/*driver.switchTo().defaultContent();				
					driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();	*/		
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					driver.findElement(By.cssSelector("li[id='911101']")).click();			
					test.log(LogStatus.PASS, "Clicked on Transactions");		
					driver.switchTo().frame("main");		
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(By.name("ssn2")).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(By.name("ssn3")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(By.name("submit1")).click();
					test.log(LogStatus.PASS, "Click on submit Button");		
					for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
				    
				    
				  // String loan_nbr= driver.findElement(locator(Aprop.getProperty("csr_loan_nbr"))).getText();
				  // test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");
					// driver.findElement(By.name("button")).click();
					
						    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					   // driver.findElement(By.name("button")).click();
					    
					  if(ProductID.equals("PDL"))
						 {
					   // driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					    }
					    if(ProductID.equals("TLP"))
						 {
					    	driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
						 }
					    
					    Thread.sleep(5000);
					    if(ProductID.equals("LOC"))
						 {
					    	///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
					    	 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						 }
					   
						/*for( String winHandle1 : driver.getWindowHandles())
						{
						    driver.switchTo().window(winHandle1);
						}			
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");*/
					     String loan_nbr= driver.findElement(locator(Aprop.getProperty("csr_loan_nbr"))).getText();
						   test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 
						
						 Thread.sleep(3000);
			 //Validations
							
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
						 
						String cust_inf_customer_name= driver.findElement(locator(Aprop.getProperty("cust_inf_customer_name"))).getText();
						String cust_inf_customer_nbr = driver.findElement(locator(Aprop.getProperty("cust_inf_customer_nbr"))).getText();
						String cust_inf_customer_SSN= driver.findElement(locator(Aprop.getProperty("cust_inf_customer_SSN"))).getText();
						String cust_inf_customer_primary_phone= driver.findElement(locator(Aprop.getProperty("cust_inf_customer_primary_phone"))).getText();
						String cust_inf_customer_phone_type= driver.findElement(locator(Aprop.getProperty("cust_inf_customer_phone_type"))).getText();
						String cust_inf_customer_state= driver.findElement(locator(Aprop.getProperty("cust_inf_customer_state"))).getText();
						String cust_inf_customer_email= driver.findElement(locator(Aprop.getProperty("cust_inf_customer_email"))).getText();
						String cust_inf_customer_type= driver.findElement(locator(Aprop.getProperty("cust_inf_customer_type"))).getText();
						String cust_bank_inf_accout_type= driver.findElement(locator(Aprop.getProperty("cust_bank_inf_accout_type"))).getText();
						String cust_bank_inf_ABA_nbr= driver.findElement(locator(Aprop.getProperty("cust_bank_inf_ABA_nbr"))).getText();
						String cust_bank_inf_account_nbr= driver.findElement(locator(Aprop.getProperty("cust_bank_inf_account_nbr"))).getText();
						String cust_bank_inf_check_nbr= driver.findElement(locator(Aprop.getProperty("cust_bank_inf_check_nbr"))).getText();
						String cust_bank_inf_account_status= driver.findElement(locator(Aprop.getProperty("cust_bank_inf_account_status"))).getText();
						String cust_bank_inf_bank_name= driver.findElement(locator(Aprop.getProperty("cust_bank_inf_bank_name"))).getText();
						String employer_inf_source_of_income= driver.findElement(locator(Aprop.getProperty("employer_inf_source_of_income"))).getText();
						String employer_inf_current_employer= driver.findElement(locator(Aprop.getProperty("employer_inf_current_employer"))).getText();
						String employer_inf_netpay= driver.findElement(locator(Aprop.getProperty("employer_inf_netpay"))).getText();
						String employer_inf_grosspay= driver.findElement(locator(Aprop.getProperty("employer_inf_grosspay"))).getText();
						String employer_inf_pay_frequency= driver.findElement(locator(Aprop.getProperty("employer_inf_pay_frequency"))).getText();
						String employer_inf_employer_ph_nbr= driver.findElement(locator(Aprop.getProperty("employer_inf_employer_ph_nbr"))).getText();
						String courtesy_inf_courtesy_consent= driver.findElement(locator(Aprop.getProperty("courtesy_inf_courtesy_consent"))).getText();
						String courtesy_inf_courtesy_type= driver.findElement(locator(Aprop.getProperty("courtesy_inf_courtesy_type"))).getText();
						String courtesy_inf_courtesy_status= driver.findElement(locator(Aprop.getProperty("courtesy_inf_courtesy_status"))).getText();
						String loan_status_inf_loan_status= driver.findElement(locator(Aprop.getProperty("loan_status_inf_loan_status"))).getText();
						String loan_status_inf_checkstatus= driver.findElement(locator(Aprop.getProperty("loan_status_inf_checkstatus"))).getText();
						String loan_status_inf_due_date= driver.findElement(locator(Aprop.getProperty("loan_status_inf_due_date"))).getText();
						String loan_balance_inf_principal_bal= driver.findElement(locator(Aprop.getProperty("loan_balance_inf_principal_bal"))).getText();
						String loan_balance_inf_fee_due= driver.findElement(locator(Aprop.getProperty("loan_balance_inf_fee_due"))).getText();
						String loan_balance_inf_return_fee_due= driver.findElement(locator(Aprop.getProperty("loan_balance_inf_return_fee_due"))).getText();
						String loan_balance_inf_late_fee_due= driver.findElement(locator(Aprop.getProperty("loan_balance_inf_late_fee_due"))).getText();
						String loan_balance_inf_pay_off_amt= driver.findElement(locator(Aprop.getProperty("loan_balance_inf_pay_off_amt"))).getText();
						String loan_account_inf_product_name= driver.findElement(locator(Aprop.getProperty("loan_account_inf_product_name"))).getText();
						String loan_account_inf_product_type= driver.findElement(locator(Aprop.getProperty("loan_account_inf_product_type"))).getText();
						String loan_account_inf_loan_nbr= driver.findElement(locator(Aprop.getProperty("loan_account_inf_loan_nbr"))).getText();
						String loan_account_inf_loan_amt= driver.findElement(locator(Aprop.getProperty("loan_account_inf_loan_amt"))).getText();
						String loan_account_inf_finance_charge= driver.findElement(locator(Aprop.getProperty("loan_account_inf_finance_charge"))).getText();
						String loan_account_inf_APR= driver.findElement(locator(Aprop.getProperty("loan_account_inf_APR"))).getText();
						String loan_account_inf_interest_rate= driver.findElement(locator(Aprop.getProperty("loan_account_inf_interest_rate"))).getText();
						String loan_account_inf_loan_date= driver.findElement(locator(Aprop.getProperty("loan_account_inf_loan_date"))).getText();
						String loan_account_inf_max_term_date= driver.findElement(locator(Aprop.getProperty("loan_account_inf_max_term_date"))).getText();
						String loan_account_inf_collateral_type= driver.findElement(locator(Aprop.getProperty("loan_account_inf_collateral_type"))).getText();
						String loan_account_inf_loan_frequency= driver.findElement(locator(Aprop.getProperty("loan_account_inf_loan_frequency"))).getText();
						String loan_account_inf_original_store= driver.findElement(locator(Aprop.getProperty("loan_account_inf_original_store"))).getText();
						String loan_account_inf_origination= driver.findElement(locator(Aprop.getProperty("loan_account_inf_origination"))).getText();
						String loan_account_inf_available_credit= driver.findElement(locator(Aprop.getProperty("loan_account_inf_available_credit"))).getText();
						
						String cust_underwriting_veritec_tran_nbr= driver.findElement(locator(Aprop.getProperty("cust_underwriting_veritec_tran_nbr"))).getText();
						String cust_underwriting_mla_status= driver.findElement(locator(Aprop.getProperty("cust_underwriting_mla_status"))).getText();
						String cust_underwriting_ofac_status= driver.findElement(locator(Aprop.getProperty("cust_underwriting_ofac_status"))).getText();
						String cust_promotion_campaign_name= driver.findElement(locator(Aprop.getProperty("cust_promotion_campaign_name"))).getText();
						String cust_promotion_coupon_code= "null";
						cust_promotion_coupon_code= driver.findElement(locator(Aprop.getProperty("cust_promotion_coupon_code"))).getText();
//Loan paid to date summary
						String loan_paid_summary_principal_paid_date= driver.findElement(locator(Aprop.getProperty("loan_paid_summary_principal_paid_date"))).getText();
						String loan_paid_summary_fee_paid_date= driver.findElement(locator(Aprop.getProperty("loan_paid_summary_fee_paid_date"))).getText();
						String loan_paid_summary_return_paid_date= driver.findElement(locator(Aprop.getProperty("loan_paid_summary_return_paid_date"))).getText();
						String loan_paid_summary_late_paid_date= driver.findElement(locator(Aprop.getProperty("loan_paid_summary_late_paid_date"))).getText();
						//String loan_paid_summary_total_paid_amt= driver.findElement(locator(Aprop.getProperty("loan_paid_summary_total_paid_date"))).getText();

					
						//cust documetn details
						String cust_doc_total_amount= driver.findElement(locator(Aprop.getProperty("cust_doc_total_amount"))).getText();
						String cust_doc_adv_amount= driver.findElement(locator(Aprop.getProperty("cust_doc_adv_amount"))).getText();
						String cust_doc_adv_fee= driver.findElement(locator(Aprop.getProperty("cust_doc_adv_fee"))).getText();
						String cust_doc_nsf_amount= driver.findElement(locator(Aprop.getProperty("cust_doc_nsf_amount"))).getText();
						String cust_doc_wo_amount= driver.findElement(locator(Aprop.getProperty("cust_doc_wo_amount"))).getText();
						String cust_doc_interest_fee= driver.findElement(locator(Aprop.getProperty("cust_doc_interest_fee"))).getText();
						String cust_doc_origination_fee= driver.findElement(locator(Aprop.getProperty("cust_doc_origination_fee"))).getText();
						String cust_doc_credit_or_verif_fee= driver.findElement(locator(Aprop.getProperty("cust_doc_credit_or_verif_fee"))).getText();
						String cust_doc_epp_fee= driver.findElement(locator(Aprop.getProperty("cust_doc_epp_fee"))).getText();
						
						
						  if(ESign_CollateralType.equals("ACH"))
					      {
						    						       
						//To read from application       
						       ach_history_ach_type= driver.findElement(locator(Aprop.getProperty("ach_history_ach_type"))).getText();
								ach_history_ach_transaction= driver.findElement(locator(Aprop.getProperty("ach_history_ach_transaction"))).getText();
								ach_history_ach_status= driver.findElement(locator(Aprop.getProperty("ach_history_ach_status"))).getText();
								ach_history_ach_amt= driver.findElement(locator(Aprop.getProperty("ach_history_ach_amt"))).getText();
								ach_history_ach_ABA_code= driver.findElement(locator(Aprop.getProperty("ach_history_ach_ABA_code"))).getText();
								ach_history_ach_check_acc_no= driver.findElement(locator(Aprop.getProperty("ach_history_ach_check_acc_no"))).getText();
					      }
						

						
						  test.log(LogStatus.PASS, "loan date is "+loan_account_inf_loan_date);
							//test.log(LogStatus.INFO, MarkupHelper.createLabel("Validating the field values with Actual and Expected",ExtentColor.BLUE));
							test.log(LogStatus.INFO, "Validating the field values with Actual and Expected");


						
						if(customer_name.toLowerCase().trim().equalsIgnoreCase(cust_inf_customer_name.toLowerCase().trim()))
						{
							test.log(LogStatus.PASS, "Customer Name->Expected value:"+customer_name +"; == Actual value:"+cust_inf_customer_name);
						}
						else
						{
							test.log(LogStatus.FAIL, "Customer Name->Expected value:"+customer_name.toLowerCase() +"; not equals to Actual value:"+cust_inf_customer_name.toLowerCase());

						}
							if(SSNverify.equalsIgnoreCase(cust_inf_customer_SSN))
							{
								test.log(LogStatus.PASS, "SSN->Expected value:"+SSNverify +"; == Actual value:"+cust_inf_customer_SSN);
							}
							else
							{
								test.log(LogStatus.FAIL, "SSN->Expected value:"+SSNverify +"; not equals to Actual value:"+cust_inf_customer_SSN);
	
							}
							
							if(Bank_ABARoutingNbr.equalsIgnoreCase(cust_bank_inf_ABA_nbr))
							{
								test.log(LogStatus.PASS, "Bank_ABARoutingNbr->Expected value:"+Bank_ABARoutingNbr +"; == Actual value:"+cust_bank_inf_ABA_nbr);
							}
							else
							{
								test.log(LogStatus.FAIL, "Bank_ABARoutingNbr->Expected value:"+Bank_ABARoutingNbr +"; not equals to Actual value:"+cust_bank_inf_ABA_nbr);

							}
						/*	if(Bank_ChkgAcctNbr.equalsIgnoreCase(cust_bank_inf_account_nbr))
							{
								test.log(LogStatus.PASS, "Bank_ChkgAcctNbr->Expected value:"+Bank_ChkgAcctNbr +"; == Actual value:"+cust_bank_inf_account_nbr);
							}
							else
							{
								test.log(LogStatus.FAIL, "Bank_ChkgAcctNbr->Expected value:"+Bank_ChkgAcctNbr +"; not equals to Actual value:"+cust_bank_inf_account_nbr);

							}*/
							
							if(primary_source_of_income.equalsIgnoreCase(employer_inf_source_of_income))
							{
								test.log(LogStatus.PASS, "primary_source_of_income->Expected value:"+primary_source_of_income +"; == Actual value:"+employer_inf_source_of_income);
							}
							else
							{
								test.log(LogStatus.FAIL, "primary_source_of_income->Expected value:"+primary_source_of_income +"; not equals to Actual value:"+employer_inf_source_of_income);

							}
							if(NetIncomeAmt.equalsIgnoreCase(employer_inf_netpay))
							{
								test.log(LogStatus.PASS, "NetIncomeAmt->Expected value:"+NetIncomeAmt +"; == Actual value:"+employer_inf_netpay);
							}
							else
							{
								test.log(LogStatus.FAIL, "NetIncomeAmt->Expected value:"+NetIncomeAmt +"; not equals to Actual value:"+employer_inf_netpay);

							}
							if(GrossIncome.equalsIgnoreCase(employer_inf_grosspay))
							{
								test.log(LogStatus.PASS, "GrossIncome->Expected value:"+GrossIncome +"; == Actual value:"+employer_inf_grosspay);
							}
							else
							{
								test.log(LogStatus.FAIL, "GrossIncome->Expected value:"+GrossIncome +"; not equals to Actual value:"+employer_inf_grosspay);

							}
							if(Income_PayFrequency.equalsIgnoreCase(employer_inf_pay_frequency))
							{
								test.log(LogStatus.PASS, "Income_PayFrequency->Expected value:"+Income_PayFrequency +"; == Actual value:"+employer_inf_pay_frequency);
							}
							else
							{
								test.log(LogStatus.FAIL, "Income_PayFrequency->Expected value:"+Income_PayFrequency +"; not equals to Actual value:"+employer_inf_pay_frequency);

							}
							if(loan_status.equalsIgnoreCase(loan_status_inf_loan_status))
							{
								test.log(LogStatus.PASS, "loan_status->Expected value:"+loan_status +"; == Actual value:"+loan_status_inf_loan_status);
							}
							else
							{
								test.log(LogStatus.FAIL, "loan_status->Expected value:"+loan_status +"; not equals to Actual value:"+loan_status_inf_loan_status);

							}
							if(check_status.equalsIgnoreCase(loan_status_inf_checkstatus))
							{
								test.log(LogStatus.PASS, "check_status->Expected value:"+check_status +"; == Actual value:"+loan_status_inf_checkstatus);
							}
							else
							{
								test.log(LogStatus.FAIL, "check_status->Expected value:"+check_status +"; not equals to Actual value:"+loan_status_inf_checkstatus);

							}
							
							if(product_type.equalsIgnoreCase(loan_account_inf_product_type))
							{
								test.log(LogStatus.PASS, "product_type->Expected value:"+product_type +"; == Actual value:"+loan_account_inf_product_type);
							}
							else
							{
								test.log(LogStatus.FAIL, "product_type->Expected value:"+product_type +"; not equals to Actual value:"+loan_account_inf_product_type);

							}
							if(loan_amount.equalsIgnoreCase(loan_account_inf_loan_amt))
							{
								test.log(LogStatus.PASS, "loan_amount->Expected value:"+loan_amount +"; == Actual value:"+loan_account_inf_loan_amt);
							}
							else
							{
								test.log(LogStatus.FAIL, "loan_amount->Expected value:"+loan_amount +"; not equals to Actual value:"+loan_account_inf_loan_amt);

							}
							if(finance_charge.equalsIgnoreCase(loan_account_inf_finance_charge))
							{
								test.log(LogStatus.PASS, "finance_charge->Expected value:"+finance_charge +"; == Actual value:"+loan_account_inf_finance_charge);
							}
							else
							{
								test.log(LogStatus.FAIL, "finance_charge->Expected value:"+finance_charge +"; not equals to Actual value:"+loan_account_inf_finance_charge);

							}
							if(apr.equalsIgnoreCase(loan_account_inf_APR))
							{
								test.log(LogStatus.PASS, "apr->Expected value:"+apr +"; == Actual value:"+loan_account_inf_APR);
							}
							else
							{
								test.log(LogStatus.FAIL, "apr->Expected value:"+apr +"; not equals to Actual value:"+loan_account_inf_APR);

							}
							if(collateral_type.equalsIgnoreCase(loan_account_inf_collateral_type))
							{
								test.log(LogStatus.PASS, "collateral_type->Expected value:"+collateral_type +"; == Actual value:"+loan_account_inf_collateral_type);
							}
							else
							{
								test.log(LogStatus.FAIL, "collateral_type->Expected value:"+collateral_type +"; not equals to Actual value:"+loan_account_inf_collateral_type);

							}
							if(loan_frequency.toLowerCase().trim().equalsIgnoreCase(loan_account_inf_loan_frequency.toLowerCase().trim()))
							{
								test.log(LogStatus.PASS, "loan_frequency->Expected value:"+loan_frequency +"; == Actual value:"+loan_account_inf_loan_frequency);
							}
							else
							{
								test.log(LogStatus.FAIL, "loan_frequency->Expected value:"+loan_frequency +"; not equals to Actual value:"+loan_account_inf_loan_frequency);

							}
							if(credot_or_verification_fee.equalsIgnoreCase(cust_doc_credit_or_verif_fee))
							{
								test.log(LogStatus.PASS, "credit_or_verification_fee->Expected value:"+credot_or_verification_fee +"; == Actual value:"+cust_doc_credit_or_verif_fee);
							}
							else
							{
								test.log(LogStatus.FAIL, "credit_or_verification_fee->Expected value:"+credot_or_verification_fee +"; not equals to Actual value:"+cust_doc_credit_or_verif_fee);

							}
							if(available_credit.equalsIgnoreCase(loan_account_inf_available_credit))
							{
								test.log(LogStatus.PASS, "available_credit->Expected value:"+available_credit +"; == Actual value:"+loan_account_inf_available_credit);
							}
							else
							{
								test.log(LogStatus.FAIL, "available_credit->Expected value:"+available_credit +"; not equals to Actual value:"+loan_account_inf_available_credit);

							}
							if(courtesy_consent.equalsIgnoreCase(courtesy_inf_courtesy_consent))
							{
								test.log(LogStatus.PASS, "courtesy_consent->Expected value:"+courtesy_consent +"; == Actual value:"+courtesy_inf_courtesy_consent);
							}
							else
							{
								test.log(LogStatus.FAIL, "courtesy_consent->Expected value:"+courtesy_consent +"; not equals to Actual value:"+courtesy_inf_courtesy_consent);

							}
							if(courtesy_consent_status.equalsIgnoreCase(courtesy_inf_courtesy_status))
							{
								test.log(LogStatus.PASS, "courtesy_consent_status->Expected value:"+courtesy_consent_status +"; == Actual value:"+courtesy_inf_courtesy_status);
							}
							else
							{
								test.log(LogStatus.FAIL, "courtesy_consent_status->Expected value:"+courtesy_consent_status +"; not equals to Actual value:"+courtesy_inf_courtesy_status);

							}
							if(principal_balance.equalsIgnoreCase(loan_balance_inf_principal_bal))
							{
								test.log(LogStatus.PASS, "principal_balance->Expected value:"+principal_balance +"; == Actual value:"+loan_balance_inf_principal_bal);
							}
							else
							{
								test.log(LogStatus.FAIL, "principal_balance->Expected value:"+principal_balance +"; not equals to Actual value:"+loan_balance_inf_principal_bal);

							}
							if(fee_due.equalsIgnoreCase(loan_balance_inf_fee_due))
							{
								test.log(LogStatus.PASS, "fee_due->Expected value:"+fee_due +"; == Actual value:"+loan_balance_inf_fee_due);
							}
							else
							{
								test.log(LogStatus.FAIL, "fee_due->Expected value:"+fee_due +"; not equals to Actual value:"+loan_balance_inf_fee_due);

							}
							if(pay_off_amount.equalsIgnoreCase(loan_balance_inf_pay_off_amt))
							{
								test.log(LogStatus.PASS, "pay_off_amount->Expected value:"+pay_off_amount +"; == Actual value:"+loan_balance_inf_pay_off_amt);
							}
							else
							{
								test.log(LogStatus.FAIL, "pay_off_amount->Expected value:"+pay_off_amount +"; not equals to Actual value:"+loan_balance_inf_pay_off_amt);

							}
							if(principal_paid_to_date.equalsIgnoreCase(loan_paid_summary_principal_paid_date))
							{
								test.log(LogStatus.PASS, "principal_paid_to_date->Expected value:"+principal_paid_to_date +"; == Actual value:"+loan_paid_summary_principal_paid_date);
							}
							else
							{
								test.log(LogStatus.FAIL, "principal_paid_to_date->Expected value:"+principal_paid_to_date +"; not equals to Actual value:"+loan_paid_summary_principal_paid_date);

							}
							if(fee_paid_date.equalsIgnoreCase(loan_paid_summary_fee_paid_date))
							{
								test.log(LogStatus.PASS, "fee_paid_date->Expected value:"+fee_paid_date +"; == Actual value:"+loan_paid_summary_fee_paid_date);
							}
							else
							{
								test.log(LogStatus.FAIL, "fee_paid_date->Expected value:"+fee_paid_date +"; not equals to Actual value:"+loan_paid_summary_fee_paid_date);

							}
							
				/*			if(total_paid_amountc.equalsIgnoreCase(loan_paid_summary_total_paid_amt))
							{
								test.log(LogStatus.PASS, "total_paid_amount->Expected value:"+total_paid_amountc +"; == Actual value:"+loan_paid_summary_total_paid_amt);
							}
							else
							{
								test.log(LogStatus.FAIL, "total_paid_amount->Expected value:"+total_paid_amountc +"; not equals to Actual value:"+loan_paid_summary_total_paid_amt);

							} */
							if(campaign_name.equalsIgnoreCase(cust_promotion_campaign_name))
							{
								test.log(LogStatus.PASS, "campaign_name->Expected value:"+campaign_name+"; == Actual value:"+cust_promotion_campaign_name);
							}
							else
							{
								test.log(LogStatus.FAIL, "campaign_name->Expected value:"+campaign_name +"; not equals to Actual value:"+cust_promotion_campaign_name);

							}
							if(promotion_code.equalsIgnoreCase(cust_promotion_coupon_code))
							{
								test.log(LogStatus.PASS, "promotion_code->Expected value:"+promotion_code +"; == Actual value:"+cust_promotion_coupon_code);
							}
							else
							{
								test.log(LogStatus.FAIL, "promotion_code->Expected value:"+promotion_code +"; not equals to Actual value:"+cust_promotion_coupon_code);

							}
							if(product_name.equalsIgnoreCase(loan_account_inf_product_name))
							{
								test.log(LogStatus.PASS, "product_name->Expected value:"+product_name +"; == Actual value:"+loan_account_inf_product_name);
							}
							else
							{
								test.log(LogStatus.FAIL, "product_name->Expected value:"+product_name +"; not equals to Actual value:"+loan_account_inf_product_name);

							}
							
							if(total_amount.equalsIgnoreCase(cust_doc_total_amount))
							{
								test.log(LogStatus.PASS, "total_amount->Expected value:"+total_amount +"; == Actual value:"+cust_doc_total_amount);
							}
							else
							{
								test.log(LogStatus.FAIL, "total_amount->Expected value:"+total_amount +"; not equals to Actual value:"+cust_doc_total_amount);

							}
							if(advance_amount.equalsIgnoreCase(cust_doc_adv_amount))
							{
								test.log(LogStatus.PASS, "advance_amount->Expected value:"+advance_amount +"; == Actual value:"+cust_doc_adv_amount);
							}
							else
							{
								test.log(LogStatus.FAIL, "advance_amount->Expected value:"+advance_amount +"; not equals to Actual value:"+cust_doc_adv_amount);

							}
							if(advance_fees.equalsIgnoreCase(cust_doc_adv_fee))
							{
								test.log(LogStatus.PASS, "advance_fees->Expected value:"+advance_fees +"; == Actual value:"+cust_doc_adv_fee);
							}
							else
							{
								test.log(LogStatus.FAIL, "advance_fees->Expected value:"+advance_fees +"; not equals to Actual value:"+cust_doc_adv_fee);

							}
							if(NSF_amount.equalsIgnoreCase(cust_doc_nsf_amount))
							{
								test.log(LogStatus.PASS, "NSF_amount->Expected value:"+NSF_amount +"; == Actual value:"+cust_doc_nsf_amount);
							}
							else
							{
								test.log(LogStatus.FAIL, "NSF_amount->Expected value:"+NSF_amount +"; not equals to Actual value:"+cust_doc_nsf_amount);

							}
							if(WO_amount.equalsIgnoreCase(cust_doc_wo_amount))
							{
								test.log(LogStatus.PASS, "WO_amount->Expected value:"+WO_amount +"; == Actual value:"+cust_doc_wo_amount);
							}
							else
							{
								test.log(LogStatus.FAIL, "WO_amount->Expected value:"+WO_amount +"; not equals to Actual value:"+cust_doc_wo_amount);

							}
							if(interest_fee.equalsIgnoreCase(cust_doc_interest_fee))
							{
								test.log(LogStatus.PASS, "interest_fee->Expected value:"+interest_fee +"; == Actual value:"+cust_doc_interest_fee);
							}
							else
							{
								test.log(LogStatus.FAIL, "interest_fee->Expected value:"+interest_fee +"; not equals to Actual value:"+cust_doc_interest_fee);

							}
							if(origination_fee.equalsIgnoreCase(cust_doc_origination_fee))
							{
								test.log(LogStatus.PASS, "origination_fee->Expected value:"+origination_fee +"; == Actual value:"+cust_doc_origination_fee);
							}
							else
							{
								test.log(LogStatus.FAIL, "origination_fee->Expected value:"+origination_fee +"; not equals to Actual value:"+cust_doc_origination_fee);

							}
							if(credit_or_verification_fee.equalsIgnoreCase(cust_doc_credit_or_verif_fee))
							{
								test.log(LogStatus.PASS, "credit_or_verification_fee->Expected value:"+credit_or_verification_fee +"; == Actual value:"+cust_doc_credit_or_verif_fee);
							}
							else
							{
								test.log(LogStatus.FAIL, "credit_or_verification_fee->Expected value:"+credit_or_verification_fee +"; not equals to Actual value:"+cust_doc_credit_or_verif_fee);

							}
							if(EPP_fee.equalsIgnoreCase(cust_doc_epp_fee))
							{
								test.log(LogStatus.PASS, "EPP_fee->Expected value:"+EPP_fee +"; == Actual value:"+cust_doc_epp_fee);
							}
							else
							{
								test.log(LogStatus.FAIL, "EPP_fee->Expected value:"+EPP_fee +"; not equals to Actual value:"+cust_doc_epp_fee);

							}
												
							
							//ACH validations
				
							if(ESign_CollateralType.equals("ACH"))
							{
								if(ACH_type.equalsIgnoreCase(ach_history_ach_type))
								{
									test.log(LogStatus.PASS, "ACH_type->Expected value:"+ACH_type +"; == Actual value:"+ach_history_ach_type);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_type->Expected value:"+ACH_type +"; not equals to Actual value:"+ach_history_ach_type);

								}
								if(ACH_transaction.equalsIgnoreCase(ach_history_ach_transaction))
								{
									test.log(LogStatus.PASS, "ACH_transaction->Expected value:"+ACH_transaction +"; == Actual value:"+ach_history_ach_transaction);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_transaction->Expected value:"+ACH_transaction +"; not equals to Actual value:"+ach_history_ach_transaction);
	
								}
								
	
								if(ACH_status.contains(ach_history_ach_status))
								{
									test.log(LogStatus.PASS, "ACH_status->Expected value:"+ACH_status +"; == Actual value:"+ach_history_ach_status);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_status->Expected value:"+ACH_status +"; not equals to Actual value:"+ach_history_ach_status);
	
								}
								if(ACH_amount.equalsIgnoreCase(ach_history_ach_amt))
								{
									test.log(LogStatus.PASS, "ACH_amount->Expected value:"+ACH_amount +"; == Actual value:"+ach_history_ach_amt);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_amount->Expected value:"+ACH_amount +"; not equals to Actual value:"+ach_history_ach_amt);
	
								}
								if(ACH_ABA_code.equalsIgnoreCase(ach_history_ach_ABA_code))
								{
									test.log(LogStatus.PASS, "ACH_ABA_code->Expected value:"+ACH_ABA_code +"; == Actual value:"+ach_history_ach_ABA_code);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_ABA_code->Expected value:"+ACH_ABA_code +"; not equals to Actual value:"+ach_history_ach_ABA_code);
	
								}
								/*if(Bank_ChkgAcctNbr.equalsIgnoreCase(ach_history_ach_check_acc_no))
								{
									test.log(LogStatus.PASS, "ACH_check_acc_no->Expected value:"+Bank_ChkgAcctNbr +"; == Actual value:"+ach_history_ach_check_acc_no);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_check_acc_no->Expected value:"+Bank_ChkgAcctNbr +"; not equals to Actual value:"+ach_history_ach_check_acc_no);
	
								}*/
							}	
						//	test.log(LogStatus.PASS, MarkupHelper.createLabel("History Transaction is successful", ExtentColor.GREEN));
							test.log(LogStatus.PASS, "History Transaction is successful");
							test.log(LogStatus.PASS, "**********************************************");

							break;
							
}
			}
		
			}
}