package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class SQC_LOC_History extends QCStore{
	public static String ACH_type;
	public static String ACH_transaction;
	public static String ACH_status;
	public static String ACH_amount;
	public static String ACH_ABA_code;
	public static String ACH_check_acc_no;
	public static String ach_history_ach_type;
	public static String ach_history_ach_transaction;
	public static String ach_history_ach_effective_date;
	public static String ach_history_ach_status;
	public static String ach_history_ach_amt;
	public static String ach_history_ach_check_acc_no;
	public static String ach_history_ach_ABA_code;
	public static String loc_history_transaction;
	public static String loc_history_tendertype;
	public static String loc_history_Tran_Amt;
	public static String loc_history_Int_Amt;
	public static String loc_history_adv_Amt;
	public static String loc_history_Lien_Amt;
	public static String loc_history_LateFee_Amt;
	public static String loc_history_Stmt_Nbr;
	public static String loc_history_Stmt_Date;
	public static String loc_history_Statement_Closing_Date;
	public static String loc_history_Previous_Balance;
	public static String loc_history_Min_Payment_Amt;
	public static String loc_history_New_Balance;
	public static String loc_history_Payment_Due_Date;
	public static String loc_history_Capitalization_Interest;
	public static String loc_history_Paid_Flag;
	public static String ACH_effective_date;

	public static void history(String SSN,String AppURL) throws InterruptedException
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
			       String Ctc_PrimaryPhone = TestData.getCellData(sheetName,"Ctc_PrimaryPhone",row);
			       String Ctc_PhoneType = TestData.getCellData(sheetName,"Ctc_PhoneType",row);
			       String Misc_PhotoIDNbr = TestData.getCellData(sheetName,"Misc_PhotoIDNbr",row);
			       String Misc_IDExpDate = TestData.getCellData(sheetName,"Misc_IDExpDate",row);	   
			       String Misc_PhotoIDType = TestData.getCellData(sheetName,"Misc_PhotoIDType",row);
			       String BorrDOB = TestData.getCellData(sheetName,"Misc_DOB",row);
			       String Income_IncomeType = TestData.getCellData(sheetName,"Income_IncomeType",row);
			       String ESign_CollateralType = TestData.getCellData(sheetName_new_loan,"ESign_CollateralType",row);
			       String courtesy_consent=TestData.getCellData(sheetName_new_loan,"ESign_CourtesyCallConsent",row);
			       String collateral_type=TestData.getCellData(sheetName_new_loan,"ESign_CollateralType",row);
			       String primary_source_of_income = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",4);

System.out.println(sheetName_calc);
System.out.println(columnname+"_TxnHistory_FieldValue");

			       String Income_Employer = TestData.getCellData(sheetName,"Income_Employer",row);
			       String Income_WorkPhone = TestData.getCellData(sheetName,"Income_WorkPhone",row);
			       String NetIncomeAmt = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",2);
			       String GrossIncome = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",3);
			       String pay_frequency=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",7);
			       String loan_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",4);
			       String check_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",5);
			       String due_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",6);
			       String latest_payment_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",7);
			       String product_name=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",9);
			       String product_type=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",10);
			       String loan_amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",11);
			       String finance_charge=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",12);
			       String interest_rate=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",13);
			       String loan_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",14);
			       String min_pay_amt=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",15);
			       String loan_frequency=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",17);
			       String credot_or_verification_fee=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",18);
			       String available_credit=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",18);
			       String loan_balance_inf_Earned_and_unpaid_interest_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",20);
			       String loan_balance_inf_Return_Fee_Due_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",21);
			       String loan_balance_inf_Late_Fee_Due_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",22);
			       String loan_balance_inf_Pay_Off_Amt_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",23);
			       String loan_balance_inf_Past_Due_Amt_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",24);
			       String loan_balance_inf_Remaining_Current_Payment_Amount_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",25);
			       String loan_balance_inf_Remaining_Min_Payment_Amount_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",26);
			       String loan_balance_inf_Statement_Payment_Amount_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",27);
			       String loan_balance_inf_Current_Principal_Balance_test=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",28);
			       String principal_paid_to_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",30);
			       String fee_paid_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",31);
			       String return_paid_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",32);
			       String late_paid_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",33);
			       String total_paid_amountc=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",34);
			       String repo_fee_paid=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",35);
			       
			       
			    //........Detailed History Field values Validations......\\
			       
			       loc_history_transaction=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",2);
			       loc_history_tendertype=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",3);
			       loc_history_Tran_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",4);
			       loc_history_adv_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",5);
			       loc_history_Int_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",6);
			       loc_history_Lien_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",7);
			       loc_history_LateFee_Amt=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",8);
			       
			       //......Statement Field Values validation.......\\
			       
			       loc_history_Stmt_Nbr=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",2);
			       loc_history_Stmt_Date=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",3);
			       loc_history_Min_Payment_Amt=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",4);
			       loc_history_Payment_Due_Date=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",5);
			       loc_history_New_Balance=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",6);
			       loc_history_Previous_Balance=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",7);
			       loc_history_Paid_Flag=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",8);
			       loc_history_Capitalization_Interest=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",9);
			       loc_history_Statement_Closing_Date=TestData.getCellData(sheetName_calc,columnname+"_Statement_FieldValue",10);
			       
	 //......ACH Collateral Details From Sheet.......//
			     
			       if(ESign_CollateralType.equals("ACH"))
			      {
				    	//To Read from Excel
			    	   
			    	   ACH_type=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",2);
				       ACH_transaction=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",3);
				       ACH_effective_date=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",4);
				       ACH_status=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",5);
				       ACH_amount=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",6);
				       ACH_ABA_code=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",7);
				       ACH_check_acc_no=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",8);
				       
			
			      }

			     
						
						   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					        
					        String SSNverify="XXX-XX-"+SSN3;
					
					       
					        
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
				
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
			
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
					
				for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					   					    
					    Thread.sleep(5000);
					    
					    	 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
							    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					
					   //  String loan_nbr= driver.findElement(locator(Aprop.getProperty("csr_loan_nbr"))).getText();
						//   test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 
						
						 Thread.sleep(3000);
			 //Validations
						 for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
						 
						/*String cust_inf_customer_name= driver.findElement(locator(Aprop.getProperty("cust_inf_customer_name"))).getText();
						String cust_inf_customer_nbr = driver.findElement(locator(Aprop.getProperty("cust_inf_customer_nbr"))).getText();
						String cust_inf_customer_SSN= driver.findElement(locator(Aprop.getProperty("cust_inf_customer_SSN"))).getText();
						String cust_inf_customer_primary_phone= driver.findElement(locator(Aprop.getProperty("cust_inf_customer_primary_phone"))).getText();
						String cust_inf_customer_phone_type= driver.findElement(locator(Aprop.getProperty("cust_inf_customer_phone_type"))).getText();
						String cust_inf_customer_state= driver.findElement(locator(Aprop.getProperty("cust_inf_customer_state"))).getText();
						String cust_inf_customer_email= driver.findElement(locator(Aprop.getProperty("cust_inf_customer_email"))).getText();
						String cust_inf_customer_type= driver.findElement(locator(Aprop.getProperty("cust_inf_customer_type"))).getText();
						String employer_inf_source_of_income= driver.findElement(locator(Aprop.getProperty("employer_inf_source_of_income"))).getText();
						String employer_inf_current_employer= driver.findElement(locator(Aprop.getProperty("employer_inf_current_employer"))).getText();*/
						String employer_inf_netpay= driver.findElement(locator(Aprop.getProperty("employer_inf_netpay"))).getText();
						String employer_inf_grosspay= driver.findElement(locator(Aprop.getProperty("employer_inf_grosspay"))).getText();
						String employer_inf_pay_frequency= driver.findElement(locator(Aprop.getProperty("employer_inf_pay_frequency"))).getText();
						//String employer_inf_employer_ph_nbr= driver.findElement(locator(Aprop.getProperty("employer_inf_employer_ph_nbr"))).getText();
						String courtesy_inf_courtesy_consent= driver.findElement(locator(Aprop.getProperty("courtesy_inf_courtesy_consent"))).getText();
						//String courtesy_inf_courtesy_type= driver.findElement(locator(Aprop.getProperty("courtesy_inf_courtesy_type"))).getText();
						//String courtesy_inf_courtesy_status= driver.findElement(locator(Aprop.getProperty("courtesy_inf_courtesy_status"))).getText();
						String loan_status_inf_loan_status= driver.findElement(locator(Aprop.getProperty("loan_status_inf_loan_status"))).getText();
						String loan_status_inf_checkstatus= driver.findElement(locator(Aprop.getProperty("loan_status_inf_checkstatus"))).getText();
						String loan_status_inf_due_date= driver.findElement(locator(Aprop.getProperty("loan_status_inf_due_date"))).getText();
						String loan_account_inf_product_name= driver.findElement(locator(Aprop.getProperty("loan_account_inf_product_name"))).getText();
						String loan_account_inf_product_type= driver.findElement(locator(Aprop.getProperty("loan_account_inf_product_type"))).getText();
						String loan_account_inf_Credit_Limit= driver.findElement(locator(Aprop.getProperty("loan_account_inf_Credit_Limit"))).getText();
						String loan_account_inf_loc_amount= driver.findElement(locator(Aprop.getProperty("loan_account_inf_loc_amount"))).getText();
						String loan_account_inf_interest_rate= driver.findElement(locator(Aprop.getProperty("loan_account_inf_interest_rate"))).getText();
						String loan_account_inf_loan_date= driver.findElement(locator(Aprop.getProperty("loan_account_inf_loan_date"))).getText();
						String loan_account_inf_collateral_type= driver.findElement(locator(Aprop.getProperty("loan_account_inf_collateral_type"))).getText();
						String loan_account_inf_loan_frequency= driver.findElement(locator(Aprop.getProperty("loan_account_inf_loan_frequency"))).getText();
						//String loan_account_inf_origination= driver.findElement(locator(Aprop.getProperty("loan_account_inf_origination"))).getText();
						String loan_account_inf_available_credit= driver.findElement(locator(Aprop.getProperty("loan_account_inf_available_credit"))).getText();
						//String cust_underwriting_veritec_tran_nbr= driver.findElement(locator(Aprop.getProperty("cust_underwriting_veritec_tran_nbr"))).getText();

						//.....Loan Paid To Date Summary......//
						
						String loan_paid_summary_principal_paid_date= driver.findElement(locator(Aprop.getProperty("loan_paid_summary_principal_paid_date"))).getText();
						String loan_paid_summary_fee_paid_date= driver.findElement(locator(Aprop.getProperty("loan_paid_summary_fee_paid_date"))).getText();
						String loan_paid_summary_return_paid_date= driver.findElement(locator(Aprop.getProperty("loan_paid_summary_return_paid_date"))).getText();
						String loan_paid_summary_late_paid_date= driver.findElement(locator(Aprop.getProperty("loan_paid_summary_late_paid_date"))).getText();
						
						//......Transaction Table validation.......//
						
					        List<WebElement> option=driver.findElements(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr"));
							int n=option.size();
							
							
							String loc_history_transaction_test= driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+n+"]/td[4]")).getText();
							String loc_history_tendertype_test= driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+n+"]/td[5]")).getText();
							String loc_history_Tran_Amt_test= driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+n+"]/td[6]")).getText();
							String loc_history_adv_Amt_test= driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+n+"]/td[7]")).getText();
							String loc_history_Int_Amt_test= driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+n+"]/td[8]")).getText();
							String loc_history_Lien_Amt_test= driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+n+"]/td[9]")).getText();
							String loc_history_LateFee_Amt_test= driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+n+"]/td[12]")).getText();
							
							//......Statement Table validation.......//
							
							List<WebElement> option2=driver.findElements(By.xpath("//*[@id='statementsGeneratedTable']/tbody/tr"));
							int m=option2.size();
							
							String loc_history_Stmt_Nbr_test= driver.findElement(By.xpath("//*[@id='statementsGeneratedTable']/tbody/tr["+m+"]/td[1]")).getText();
							String loc_history_Stmt_Date_test= driver.findElement(By.xpath("//*[@id='statementsGeneratedTable']/tbody/tr["+m+"]/td[2]")).getText();
							String loc_history_Min_Payment_Amt_test= driver.findElement(By.xpath("//*[@id='statementsGeneratedTable']/tbody/tr["+m+"]/td[3]")).getText();
							String loc_history_Payment_Due_Date_test= driver.findElement(By.xpath("//*[@id='statementsGeneratedTable']/tbody/tr["+m+"]/td[4]")).getText();
							String loc_history_New_Balance_test= driver.findElement(By.xpath("//*[@id='statementsGeneratedTable']/tbody/tr["+m+"]/td[5]")).getText();
							String loc_history_Previous_Balance_test= driver.findElement(By.xpath("//*[@id='statementsGeneratedTable']/tbody/tr["+m+"]/td[6]")).getText();
							String loc_history_Paid_Flag_test= driver.findElement(By.xpath("//*[@id='statementsGeneratedTable']/tbody/tr["+m+"]/td[7]")).getText();
							String loc_history_Capitalization_Interest_test= driver.findElement(By.xpath("//*[@id='statementsGeneratedTable']/tbody/tr["+m+"]/td[8]")).getText();
							String loc_history_Statement_Closing_Date_test= driver.findElement(By.xpath("//*[@id='statementsGeneratedTable']/tbody/tr["+m+"]/td[9]")).getText();
												
						    String loan_status_inf_latest_payment_date= driver.findElement(locator(Aprop.getProperty("loan_status_inf_latest_payment_date"))).getText();
						    //String loan_account_inf_min_pay_amt= driver.findElement(locator(Aprop.getProperty("loan_account_inf_min_pay_amt"))).getText();
						    String loan_paid_summary_total_paid_amt= driver.findElement(locator(Aprop.getProperty("loan_paid_summary_total_paid_amt"))).getText();
						    String loan_paid_summary_repo_fee_paid=driver.findElement(locator(Aprop.getProperty("loan_paid_summary_repo_fee_paid"))).getText();
						
						//Loan Balance Summary
						    String loan_balance_inf_Earned_and_unpaid_interest= driver.findElement(locator(Aprop.getProperty("loan_balance_inf_Earned_and_unpaid_interest"))).getText();
						    String loan_balance_inf_Return_Fee_Due= driver.findElement(locator(Aprop.getProperty("loan_balance_inf_Return_Fee_Due"))).getText();
						    String loan_balance_inf_Late_Fee_Due= driver.findElement(locator(Aprop.getProperty("loan_balance_inf_Late_Fee_Due"))).getText();
						    String loan_balance_inf_Pay_Off_Amt= driver.findElement(locator(Aprop.getProperty("loan_balance_inf_Pay_Off_Amt"))).getText();
						    String loan_balance_inf_Past_Due_Amt= driver.findElement(locator(Aprop.getProperty("loan_balance_inf_Past_Due_Amt"))).getText();
						    //String loan_balance_inf_Remaining_Current_Payment_Amount= driver.findElement(locator(Aprop.getProperty("loan_balance_inf_Remaining_Current_Payment_Amount"))).getText();
						    String loan_balance_inf_Remaining_Min_Payment_Amount= driver.findElement(locator(Aprop.getProperty("loan_balance_inf_Remaining_Min_Payment_Amount"))).getText();
						    String loan_balance_inf_Statement_Payment_Amount=driver.findElement(locator(Aprop.getProperty("loan_balance_inf_Statement_Payment_Amount"))).getText();
						    String loan_balance_inf_Current_Principal_Balance=driver.findElement(locator(Aprop.getProperty("loan_balance_inf_Current_Principal_Balance"))).getText();
						
						
						  if(ESign_CollateralType.equals("ACH"))
					      {
						    						       
						        //.......To Read from ACH Table.......//       
						        ach_history_ach_type= driver.findElement(locator(Aprop.getProperty("ach_history_ach_type"))).getText();
								ach_history_ach_transaction= driver.findElement(locator(Aprop.getProperty("ach_history_ach_transaction"))).getText();
								ach_history_ach_effective_date= driver.findElement(locator(Aprop.getProperty("ach_history_ach_eff_date"))).getText();
								ach_history_ach_status= driver.findElement(locator(Aprop.getProperty("ach_history_ach_status"))).getText();
								ach_history_ach_amt= driver.findElement(locator(Aprop.getProperty("ach_history_ach_amt"))).getText();
								ach_history_ach_ABA_code= driver.findElement(locator(Aprop.getProperty("ach_history_ach_ABA_code"))).getText();
								ach_history_ach_check_acc_no= driver.findElement(locator(Aprop.getProperty("ach_history_ach_check_acc_no"))).getText();
					      }
						
						
						    test.log(LogStatus.PASS, "loan date is "+loan_account_inf_loan_date);
							test.log(LogStatus.INFO, "Validating the field values with Actual and Expected");

							//........History Field values Validation Text Logs.......//
							
							if(NetIncomeAmt.equalsIgnoreCase(employer_inf_netpay))
							{
								test.log(LogStatus.PASS, "NetIncomeAmt->Expected value:"+NetIncomeAmt +"; == Actual value:"+employer_inf_netpay);
							}
							else
							{
								test.log(LogStatus.FAIL, "NetIncomeAmt->Expected value:"+NetIncomeAmt +"; != Actual value:"+employer_inf_netpay);

							}
							if(GrossIncome.equalsIgnoreCase(employer_inf_grosspay))
							{
								test.log(LogStatus.PASS, "GrossIncome->Expected value:"+GrossIncome +"; == Actual value:"+employer_inf_grosspay);
							}
							else
							{
								test.log(LogStatus.FAIL, "GrossIncome->Expected value:"+GrossIncome +"; != Actual value:"+employer_inf_grosspay);

							}
							if(Income_PayFrequency.equalsIgnoreCase(employer_inf_pay_frequency))
							{
								test.log(LogStatus.PASS, "Income_PayFrequency->Expected value:"+Income_PayFrequency +"; == Actual value:"+employer_inf_pay_frequency);
							}
							else
							{
								test.log(LogStatus.FAIL, "Income_PayFrequency->Expected value:"+Income_PayFrequency +"; != Actual value:"+employer_inf_pay_frequency);

							}
							if(loan_status.equalsIgnoreCase(loan_status_inf_loan_status))
							{
								test.log(LogStatus.PASS, "LOC_status->Expected value:"+loan_status +"; == Actual value:"+loan_status_inf_loan_status);
							}
							else
							{
								test.log(LogStatus.FAIL, "LOC_status->Expected value:"+loan_status +"; != Actual value:"+loan_status_inf_loan_status);

							}
							if(check_status.equalsIgnoreCase(loan_status_inf_checkstatus))
							{
								test.log(LogStatus.PASS, "Balance_status->Expected value:"+check_status +"; == Actual value:"+loan_status_inf_checkstatus);
							}
							else
							{
								test.log(LogStatus.FAIL, "Balance_status->Expected value:"+check_status +"; != Actual value:"+loan_status_inf_checkstatus);

							}
							if(due_date.equalsIgnoreCase(loan_status_inf_due_date))
							{
								test.log(LogStatus.PASS, "due_date->Expected value:"+due_date +"; == Actual value:"+loan_status_inf_due_date);
							}
							else
							{
								test.log(LogStatus.FAIL, "due_date->Expected value:"+due_date +"; != Actual value:"+loan_status_inf_due_date);

							}
							if(latest_payment_date.equalsIgnoreCase(loan_status_inf_latest_payment_date))
							{
								test.log(LogStatus.PASS, "latest_payment_date->Expected value:"+latest_payment_date +"; == Actual value:"+loan_status_inf_latest_payment_date);
							}
							else
							{
								test.log(LogStatus.FAIL, "latest_payment_date->Expected value:"+latest_payment_date +"; != Actual value:"+loan_status_inf_latest_payment_date);

							}
							
							
							if(product_name.equalsIgnoreCase(loan_account_inf_product_name))
							{
								test.log(LogStatus.PASS, "product_name->Expected value:"+product_name +"; == Actual value:"+loan_account_inf_product_name);
							}
							else
							{
								test.log(LogStatus.FAIL, "product_name->Expected value:"+product_name +"; != Actual value:"+loan_account_inf_product_name);

							}
							if(product_type.equalsIgnoreCase(loan_account_inf_product_type))
							{
								test.log(LogStatus.PASS, "product_type->Expected value:"+product_type +"; == Actual value:"+loan_account_inf_product_type);
							}
							else
							{
								test.log(LogStatus.FAIL, "product_type->Expected value:"+product_type +"; != Actual value:"+loan_account_inf_product_type);

							}
							if(loan_amount.equalsIgnoreCase(loan_account_inf_Credit_Limit))
							{
								test.log(LogStatus.PASS, "Credit_Limit->Expected value:"+loan_amount +"; == Actual value:"+loan_account_inf_Credit_Limit);
							}
							else
							{
								test.log(LogStatus.FAIL, "Credit_Limit->Expected value:"+loan_amount +"; != Actual value:"+loan_account_inf_Credit_Limit);

							}
							if(finance_charge.equalsIgnoreCase(loan_account_inf_loc_amount))
							{
								test.log(LogStatus.PASS, "LOC_Amt->Expected value:"+finance_charge +"; == Actual value:"+loan_account_inf_loc_amount);
							}
							else
							{
								test.log(LogStatus.FAIL, "LOC_Amt->Expected value:"+finance_charge +"; != Actual value:"+loan_account_inf_loc_amount);

							}
							if(interest_rate.equalsIgnoreCase(loan_account_inf_interest_rate))
							{
								test.log(LogStatus.PASS, "interest_rate->Expected value:"+interest_rate +"; == Actual value:"+loan_account_inf_interest_rate);
							}
							else
							{
								test.log(LogStatus.FAIL, "interest_rate->Expected value:"+interest_rate +"; != Actual value:"+loan_account_inf_interest_rate);

							}
							if(loan_date.equalsIgnoreCase(loan_account_inf_loan_date))
							{
								test.log(LogStatus.PASS, "loan_date->Expected value:"+loan_date +"; == Actual value:"+loan_account_inf_loan_date);
							}
							else
							{
								test.log(LogStatus.FAIL, "loan_date->Expected value:"+loan_date +"; != Actual value:"+loan_account_inf_loan_date);

							}
							//........min_pay_amt.......//***15-10-2019
							
							/*if(min_pay_amt.equalsIgnoreCase(loan_account_inf_min_pay_amt))
							{
								test.log(LogStatus.PASS, "min_pay_amt->Expected value:"+min_pay_amt +"; == Actual value:"+loan_account_inf_min_pay_amt);
							}
							else
							{
								test.log(LogStatus.FAIL, "min_pay_amt->Expected value:"+min_pay_amt +"; != Actual value:"+loan_account_inf_min_pay_amt);

							}*/
							
	                    	//........Loan Balance Summary.......//
							
							if(loan_balance_inf_Earned_and_unpaid_interest_test.equalsIgnoreCase(loan_balance_inf_Earned_and_unpaid_interest))
							{
								test.log(LogStatus.PASS, "Earned_and_unpaid_interest->Expected value:"+loan_balance_inf_Earned_and_unpaid_interest_test +"; == Actual value:"+loan_balance_inf_Earned_and_unpaid_interest);
							}
							else
							{
								test.log(LogStatus.FAIL, "Earned_and_unpaid_interest->Expected value:"+loan_balance_inf_Earned_and_unpaid_interest_test +"; != Actual value:"+loan_balance_inf_Earned_and_unpaid_interest);

							}
							if(loan_balance_inf_Return_Fee_Due_test.equalsIgnoreCase(loan_balance_inf_Return_Fee_Due))
							{
								test.log(LogStatus.PASS, "Return_Fee_Due->Expected value:"+loan_balance_inf_Return_Fee_Due_test +"; == Actual value:"+loan_balance_inf_Return_Fee_Due);
							}
							else
							{
								test.log(LogStatus.FAIL, "Return_Fee_Due->Expected value:"+loan_balance_inf_Return_Fee_Due_test +"; != Actual value:"+loan_balance_inf_Return_Fee_Due);

							}
							if(loan_balance_inf_Late_Fee_Due_test.equalsIgnoreCase(loan_balance_inf_Late_Fee_Due))
							{
								test.log(LogStatus.PASS, "Late_Fee_Due->Expected value:"+loan_balance_inf_Late_Fee_Due_test +"; == Actual value:"+loan_balance_inf_Late_Fee_Due);
							}
							else
							{
								test.log(LogStatus.FAIL, "Late_Fee_Due->Expected value:"+loan_balance_inf_Late_Fee_Due_test +"; != Actual value:"+loan_balance_inf_Late_Fee_Due);

							}
							if(loan_balance_inf_Pay_Off_Amt_test.equalsIgnoreCase(loan_balance_inf_Pay_Off_Amt))
							{
								test.log(LogStatus.PASS, "Pay_Off_Amt->Expected value:"+loan_balance_inf_Pay_Off_Amt_test +"; == Actual value:"+loan_balance_inf_Pay_Off_Amt);
							}
							else
							{
								test.log(LogStatus.FAIL, "Pay_Off_Amt->Expected value:"+loan_balance_inf_Pay_Off_Amt_test +"; != Actual value:"+loan_balance_inf_Pay_Off_Amt);

							}
							if(loan_balance_inf_Past_Due_Amt_test.equalsIgnoreCase(loan_balance_inf_Past_Due_Amt))
							{
								test.log(LogStatus.PASS, "Amount Due at Refi->Expected value:"+loan_balance_inf_Past_Due_Amt_test +"; == Actual value:"+loan_balance_inf_Past_Due_Amt);
							}
							else
							{
								test.log(LogStatus.FAIL, "Amount Due at Refi->Expected value:"+loan_balance_inf_Past_Due_Amt_test +"; != Actual value:"+loan_balance_inf_Past_Due_Amt);

							}
							
							//........Remaining_Current_Payment_Amount.......//***15-10-2019
							
							/*if(loan_balance_inf_Remaining_Current_Payment_Amount_test.equalsIgnoreCase(loan_balance_inf_Remaining_Current_Payment_Amount))
							{
								test.log(LogStatus.PASS, "Remaining_Current_Payment_Amount->Expected value:"+loan_balance_inf_Remaining_Current_Payment_Amount_test +"; == Actual value:"+loan_balance_inf_Remaining_Current_Payment_Amount);
							}
							else
							{
								test.log(LogStatus.FAIL, "Remaining_Current_Payment_Amount->Expected value:"+loan_balance_inf_Remaining_Current_Payment_Amount_test +"; != Actual value:"+loan_balance_inf_Remaining_Current_Payment_Amount);

							}*/
							if(loan_balance_inf_Remaining_Min_Payment_Amount_test.equalsIgnoreCase(loan_balance_inf_Remaining_Min_Payment_Amount))
							{
								test.log(LogStatus.PASS, "Remaining_Min_Payment_Amount->Expected value:"+loan_balance_inf_Remaining_Min_Payment_Amount_test +"; == Actual value:"+loan_balance_inf_Remaining_Min_Payment_Amount);
							}
							else
							{
								test.log(LogStatus.FAIL, "Remaining_Min_Payment_Amount->Expected value:"+loan_balance_inf_Remaining_Min_Payment_Amount_test +"; != Actual value:"+loan_balance_inf_Remaining_Min_Payment_Amount);

							}
							if(loan_balance_inf_Statement_Payment_Amount_test.equalsIgnoreCase(loan_balance_inf_Statement_Payment_Amount))
							{
								test.log(LogStatus.PASS, "Statement_Payment_Amount->Expected value:"+loan_balance_inf_Statement_Payment_Amount_test +"; == Actual value:"+loan_balance_inf_Statement_Payment_Amount);
							}
							else
							{
								test.log(LogStatus.FAIL, "Statement_Payment_Amount->Expected value:"+loan_balance_inf_Statement_Payment_Amount_test +"; != Actual value:"+loan_balance_inf_Statement_Payment_Amount);

							}
							if(loan_balance_inf_Current_Principal_Balance_test.equalsIgnoreCase(loan_balance_inf_Current_Principal_Balance))
							{
								test.log(LogStatus.PASS, "Current_Principal_Balance->Expected value:"+loan_balance_inf_Current_Principal_Balance_test +"; == Actual value:"+loan_balance_inf_Current_Principal_Balance);
							}
							else
							{
								test.log(LogStatus.FAIL, "Current_Principal_Balance->Expected value:"+loan_balance_inf_Current_Principal_Balance_test +"; != Actual value:"+loan_balance_inf_Current_Principal_Balance);

							}
																					
							
							if(collateral_type.equalsIgnoreCase(loan_account_inf_collateral_type))
							{
								test.log(LogStatus.PASS, "collateral_type->Expected value:"+collateral_type +"; == Actual value:"+loan_account_inf_collateral_type);
							}
							else
							{
								test.log(LogStatus.FAIL, "collateral_type->Expected value:"+collateral_type +"; != Actual value:"+loan_account_inf_collateral_type);

							}
							if(loan_frequency.toLowerCase().trim().equalsIgnoreCase(loan_account_inf_loan_frequency.toLowerCase().trim()))
							{
								test.log(LogStatus.PASS, "loan_frequency->Expected value:"+loan_frequency +"; == Actual value:"+loan_account_inf_loan_frequency);
							}
							else
							{
								test.log(LogStatus.FAIL, "loan_frequency->Expected value:"+loan_frequency +"; != Actual value:"+loan_account_inf_loan_frequency);

							}

							if(available_credit.equalsIgnoreCase(loan_account_inf_available_credit))
							{
								test.log(LogStatus.PASS, "available_credit->Expected value:"+available_credit +"; == Actual value:"+loan_account_inf_available_credit);
							}
							else
							{
								test.log(LogStatus.FAIL, "available_credit->Expected value:"+available_credit +"; != Actual value:"+loan_account_inf_available_credit);

							}
							if(courtesy_consent.equalsIgnoreCase(courtesy_inf_courtesy_consent))
							{
								test.log(LogStatus.PASS, "courtesy_consent->Expected value:"+courtesy_consent +"; == Actual value:"+courtesy_inf_courtesy_consent);
							}
							else
							{
								test.log(LogStatus.FAIL, "courtesy_consent->Expected value:"+courtesy_consent +"; != Actual value:"+courtesy_inf_courtesy_consent);

							}

							if(principal_paid_to_date.equalsIgnoreCase(loan_paid_summary_principal_paid_date))
							{
								test.log(LogStatus.PASS, "principal_paid_to_date->Expected value:"+principal_paid_to_date +"; == Actual value:"+loan_paid_summary_principal_paid_date);
							}
							else
							{
								test.log(LogStatus.FAIL, "principal_paid_to_date->Expected value:"+principal_paid_to_date +"; != Actual value:"+loan_paid_summary_principal_paid_date);

							}
							if(fee_paid_date.equalsIgnoreCase(loan_paid_summary_fee_paid_date))
							{
								test.log(LogStatus.PASS, "fee_paid_date->Expected value:"+fee_paid_date +"; == Actual value:"+loan_paid_summary_fee_paid_date);
							}
							else
							{
								test.log(LogStatus.FAIL, "fee_paid_date->Expected value:"+fee_paid_date +"; != Actual value:"+loan_paid_summary_fee_paid_date);

							}
							if(return_paid_date.equalsIgnoreCase(loan_paid_summary_return_paid_date))
							{
								test.log(LogStatus.PASS, "return_paid_date->Expected value:"+return_paid_date +"; == Actual value:"+loan_paid_summary_return_paid_date);
							}
							else
							{
								test.log(LogStatus.FAIL, "return_paid_date->Expected value:"+return_paid_date +"; != Actual value:"+loan_paid_summary_return_paid_date);

							}
							if(late_paid_date.equalsIgnoreCase(loan_paid_summary_late_paid_date))
							{
								test.log(LogStatus.PASS, "late_paid_date->Expected value:"+late_paid_date +"; == Actual value:"+loan_paid_summary_late_paid_date);
							}
							else
							{
								test.log(LogStatus.FAIL, "late_paid_date->Expected value:"+late_paid_date +"; != Actual value:"+loan_paid_summary_late_paid_date);

							}
							
							if(total_paid_amountc.equalsIgnoreCase(loan_paid_summary_total_paid_amt))
							{
								test.log(LogStatus.PASS, "total_paid_amount->Expected value:"+total_paid_amountc +"; == Actual value:"+loan_paid_summary_total_paid_amt);
							}
							else
							{
								test.log(LogStatus.FAIL, "total_paid_amount->Expected value:"+total_paid_amountc +"; != Actual value:"+loan_paid_summary_total_paid_amt);

							} 
							if(repo_fee_paid.equalsIgnoreCase(loan_paid_summary_repo_fee_paid))
							{
								test.log(LogStatus.PASS, "repo_fee_paid->Expected value:"+repo_fee_paid +"; == Actual value:"+loan_paid_summary_repo_fee_paid);
							}
							else
							{
								test.log(LogStatus.FAIL, "repo_fee_paid->Expected value:"+repo_fee_paid +"; != Actual value:"+loan_paid_summary_repo_fee_paid);

							}
											
							
							//......Details Field Values Verification.......//		
							
							
							if(loc_history_transaction.equalsIgnoreCase(loc_history_transaction_test))
							{
								test.log(LogStatus.PASS, "loc_transaction->Expected value:"+loc_history_transaction +"; == Actual value:"+loc_history_transaction_test);
							}
							else
							{
								test.log(LogStatus.FAIL, "loc_transaction->Expected value:"+loc_history_transaction +"; != Actual value:"+loc_history_transaction_test);

							}
							if(loc_history_tendertype.equalsIgnoreCase(loc_history_tendertype_test))
							{
								test.log(LogStatus.PASS, "loc_tendertype->Expected value:"+loc_history_tendertype +"; == Actual value:"+loc_history_tendertype_test);
							}
							else
							{
								test.log(LogStatus.FAIL, "loc_tendertype->Expected value:"+loc_history_tendertype +"; != Actual value:"+loc_history_tendertype_test);

							}
							
							if(loc_history_Tran_Amt.equalsIgnoreCase(loc_history_Tran_Amt_test))
							{
								test.log(LogStatus.PASS, "loc_Tran_Amt->Expected value:"+loc_history_Tran_Amt +"; == Actual value:"+loc_history_Tran_Amt_test);
							}
							else
							{
								test.log(LogStatus.FAIL, "loc_Tran_Amt->Expected value:"+loc_history_Tran_Amt +"; != Actual value:"+loc_history_Tran_Amt_test);

							}
							if(loc_history_adv_Amt.equalsIgnoreCase(loc_history_adv_Amt_test))
							{
								test.log(LogStatus.PASS, "loc_adv_Amt->Expected value:"+loc_history_adv_Amt +"; == Actual value:"+loc_history_adv_Amt_test);
							}
							else
							{
								test.log(LogStatus.FAIL, "loc_adv_Amt->Expected value:"+loc_history_adv_Amt +"; != Actual value:"+loc_history_adv_Amt_test);

							}
							if(loc_history_Int_Amt.equalsIgnoreCase(loc_history_Int_Amt_test))
							{
								test.log(LogStatus.PASS, "loc_Int_Amt->Expected value:"+loc_history_Int_Amt +"; == Actual value:"+loc_history_Int_Amt_test);
							}
							else
							{
								test.log(LogStatus.FAIL, "loc_Int_Amt->Expected value:"+loc_history_Int_Amt +"; != Actual value:"+loc_history_Int_Amt_test);

							}
							if(loc_history_Lien_Amt.equalsIgnoreCase(loc_history_Lien_Amt_test))
							{
								test.log(LogStatus.PASS, "loc_Lien_Amt->Expected value:"+loc_history_Lien_Amt +"; == Actual value:"+loc_history_Lien_Amt_test);
							}
							else
							{
								test.log(LogStatus.FAIL, "loc_Lien_Amt->Expected value:"+loc_history_Lien_Amt +"; != Actual value:"+loc_history_Lien_Amt_test);

							}
							if(loc_history_LateFee_Amt.equalsIgnoreCase(loc_history_LateFee_Amt_test))
							{
								test.log(LogStatus.PASS, "loc_LateFee_Amt->Expected value:"+loc_history_LateFee_Amt +"; == Actual value:"+loc_history_LateFee_Amt_test);
							}
							else
							{
								test.log(LogStatus.FAIL, "loc_LateFee_Amt->Expected value:"+loc_history_LateFee_Amt +"; != Actual value:"+loc_history_LateFee_Amt_test);

							}
							
							
							//.......Statement Table validations Text Logs.......//
							
							if(loc_history_Stmt_Nbr.equalsIgnoreCase(loc_history_Stmt_Nbr_test))
							{
								test.log(LogStatus.PASS, "loc_history_Stmt_Nbr->Expected value:"+loc_history_Stmt_Nbr +"; == Actual value:"+loc_history_Stmt_Nbr_test);
							}
							else
							{
								test.log(LogStatus.FAIL, "loc_history_Stmt_Nbr->Expected value:"+loc_history_Stmt_Nbr +"; != Actual value:"+loc_history_Stmt_Nbr_test);

							}
							
							if(loc_history_Stmt_Date.equalsIgnoreCase(loc_history_Stmt_Date_test))
							{
								test.log(LogStatus.PASS, "loc_history_Stmt_Date->Expected value:"+loc_history_Stmt_Date +"; == Actual value:"+loc_history_Stmt_Date_test);
							}
							else
							{
								test.log(LogStatus.FAIL, "loc_history_Stmt_Date->Expected value:"+loc_history_Stmt_Date +"; != Actual value:"+loc_history_Stmt_Date_test);

							}
							if(loc_history_Min_Payment_Amt.equalsIgnoreCase(loc_history_Min_Payment_Amt_test))
							{
								test.log(LogStatus.PASS, "loc_history_Min_Payment_Amt->Expected value:"+loc_history_Min_Payment_Amt +"; == Actual value:"+loc_history_Min_Payment_Amt_test);
							}
							else
							{
								test.log(LogStatus.FAIL, "loc_history_Min_Payment_Amt->Expected value:"+loc_history_Min_Payment_Amt +"; != Actual value:"+loc_history_Min_Payment_Amt_test);

							}
							if(loc_history_Payment_Due_Date.equalsIgnoreCase(loc_history_Payment_Due_Date_test))
							{
								test.log(LogStatus.PASS, "loc_history_Payment_Due_Date->Expected value:"+loc_history_Payment_Due_Date +"; == Actual value:"+loc_history_Payment_Due_Date_test);
							}
							else
							{
								test.log(LogStatus.FAIL, "loc_history_Payment_Due_Date->Expected value:"+loc_history_Payment_Due_Date +"; != Actual value:"+loc_history_Payment_Due_Date_test);

							}
							if(loc_history_New_Balance.equalsIgnoreCase(loc_history_New_Balance_test))
							{
								test.log(LogStatus.PASS, "loc_history_New_Balance->Expected value:"+loc_history_New_Balance +"; == Actual value:"+loc_history_New_Balance_test);
							}
							else
							{
								test.log(LogStatus.FAIL, "loc_history_New_Balance->Expected value:"+loc_history_New_Balance +"; != Actual value:"+loc_history_New_Balance_test);

							}
							if(loc_history_Previous_Balance.equalsIgnoreCase(loc_history_Previous_Balance_test))
							{
								test.log(LogStatus.PASS, "loc_history_Previous_Balance->Expected value:"+loc_history_Previous_Balance +"; == Actual value:"+loc_history_Previous_Balance_test);
							}
							else
							{
								test.log(LogStatus.FAIL, "loc_history_Previous_Balance->Expected value:"+loc_history_Previous_Balance +"; != Actual value:"+loc_history_Previous_Balance_test);

							}
							if(loc_history_Paid_Flag.equalsIgnoreCase(loc_history_Paid_Flag_test))
							{
								test.log(LogStatus.PASS, "loc_history_Paid_Flag->Expected value:"+loc_history_Paid_Flag +"; == Actual value:"+loc_history_Paid_Flag_test);
							}
							else
							{
								test.log(LogStatus.FAIL, "loc_history_Paid_Flag->Expected value:"+loc_history_Paid_Flag +"; != Actual value:"+loc_history_Paid_Flag_test);

							}
							if(loc_history_Capitalization_Interest.equalsIgnoreCase(loc_history_Capitalization_Interest_test))
							{
								test.log(LogStatus.PASS, "loc_history_Capitalization_Interest->Expected value:"+loc_history_Capitalization_Interest +"; == Actual value:"+loc_history_Capitalization_Interest_test);
							}
							else
							{
								test.log(LogStatus.FAIL, "loc_history_Capitalization_Interest->Expected value:"+loc_history_Capitalization_Interest +"; != Actual value:"+loc_history_Capitalization_Interest_test);

							}
							if(loc_history_Statement_Closing_Date.equalsIgnoreCase(loc_history_Statement_Closing_Date_test))
							{
								test.log(LogStatus.PASS, "loc_history_Statement_Closing_Date->Expected value:"+loc_history_Statement_Closing_Date +"; == Actual value:"+loc_history_Statement_Closing_Date_test);
							}
							else
							{
								test.log(LogStatus.FAIL, "loc_history_Statement_Closing_Date->Expected value:"+loc_history_Statement_Closing_Date +"; != Actual value:"+loc_history_Statement_Closing_Date_test);

							}
						
							//.......ACH Table Validation Text Logs.......//
							
							if(ESign_CollateralType.equals("ACH"))
							{
								if(ACH_type.equalsIgnoreCase(ach_history_ach_type))
								{
									test.log(LogStatus.PASS, "ACH_type->Expected value:"+ACH_type +"; == Actual value:"+ach_history_ach_type);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_type->Expected value:"+ACH_type +"; != Actual value:"+ach_history_ach_type);

								}
								if(ACH_transaction.equalsIgnoreCase(ach_history_ach_transaction))
								{
									test.log(LogStatus.PASS, "ACH_transaction->Expected value:"+ACH_transaction +"; == Actual value:"+ach_history_ach_transaction);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_transaction->Expected value:"+ACH_transaction +"; != Actual value:"+ach_history_ach_transaction);
	
								}
								if(ACH_effective_date.equalsIgnoreCase(ach_history_ach_effective_date))
								{
									test.log(LogStatus.PASS, "ACH_effective_date->Expected value:"+ACH_effective_date +"; == Actual value:"+ach_history_ach_effective_date);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_effective_date->Expected value:"+ACH_effective_date +"; != Actual value:"+ach_history_ach_effective_date);
	
								}
	
								if(ACH_status.equalsIgnoreCase(ach_history_ach_status))
								{
									test.log(LogStatus.PASS, "ACH_status->Expected value:"+ACH_status +"; == Actual value:"+ach_history_ach_status);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_status->Expected value:"+ACH_status +"; != Actual value:"+ach_history_ach_status);
	
								}
								if(ACH_amount.equalsIgnoreCase(ach_history_ach_amt))
								{
									test.log(LogStatus.PASS, "ACH_amount->Expected value:"+ACH_amount +"; == Actual value:"+ach_history_ach_amt);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_amount->Expected value:"+ACH_amount +"; != Actual value:"+ach_history_ach_amt);
	
								}

								if(Bank_ChkgAcctNbr.equalsIgnoreCase(ach_history_ach_check_acc_no))
								{
									test.log(LogStatus.PASS, "ACH_check_acc_no->Expected value:"+Bank_ChkgAcctNbr +"; == Actual value:"+ach_history_ach_check_acc_no);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_check_acc_no->Expected value:"+Bank_ChkgAcctNbr +"; != Actual value:"+ach_history_ach_check_acc_no);
	
								}
					
								
								
								
							}	
							test.log(LogStatus.PASS, "History Transaction is successful");
							test.log(LogStatus.PASS, "**********************************************");

							break;
							
}
			}
		
		
			}
}