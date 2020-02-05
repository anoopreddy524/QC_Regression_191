package tests;

import java.text.DateFormat;
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


public class VQC_LOC_History extends QCStore{
	//public static String ACH_type;
	

	public static void history(String SSN,String AppURL)
	{
		try{
	
		//String FileName= Vprop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Vprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("Borrower_Registration");
			String sheetName="Borrower_Registration";
			String sheetName_calc="HistoryFieldsValidation";
			String sheetName_new_loan="New_Loan";
			

			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String UserName = TestData.getCellData(sheetName,"UserName",row);
					String Password = TestData.getCellData(sheetName,"Password",row);
			       // System.out.println(Password);
			        String StoreId = TestData.getCellData(sheetName,"StoreID",row);
			        String ProductID = TestData.getCellData(sheetName_new_loan,"ProductID",row);
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
			       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
			       String courtesy_consent=TestData.getCellData(sheetName_new_loan,"ESign_CourtesyCallConsent",row);
			     //  String courtesy_consent_status=TestData.getCellData(sheetName_new_loan,"ESign_Preference",row);
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
			       
			       
			       
			       
			       String campaign_name=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",28);
			       String promotion_code=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",29);
			      
			       String total_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",2);
			       String advance_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",3);
			       String advance_fees=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",4);
			       String NSF_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",5);
			       String WO_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",6);
			       String interest_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",7);
			       String origination_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",8);
			       String credit_or_verification_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",9);
			       String EPP_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",10);
			    //Details values   
			       
	 //ACH collateral details from sheet
			      if(ESign_CollateralType.equals("ACH"))
			      {
				    	//To read from Excel
			    	 /* ACH_type=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",2);
				       ACH_transaction=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",3);
				        ACH_status=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",4);
				       ACH_amount=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",5);
				       ACH_ABA_code=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",6);
				       ACH_check_acc_no=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",7);
				       */
			
			      }

			     
						
						   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					        
					        String SSNverify="XXX-XX-"+SSN3;
					
					       
					        
					Thread.sleep(4000);
				//	test.log(LogStatus.INFO, MarkupHelper.createLabel("Transaction History validation has started", ExtentColor.BLUE));
					test.log(LogStatus.INFO, "Transaction History validation has started");

					driver.switchTo().frame("bottom");
					String Str_date = driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					String store_date[] = Str_date.split(":");
					business_date = store_date[1].trim();
					test.log(LogStatus.PASS, "Business date is :" + business_date);

					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
							
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
				    
				    
				  // String loan_nbr= driver.findElement(locator(Vprop.getProperty("csr_loan_nbr"))).getText();
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
					
					     String loan_nbr= driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")).getText();
						 test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
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
						 
							 String Status = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[3]/table/tbody/tr[2]/td/span[2]"))
										.getText();			
							 
							 test.log(LogStatus.PASS, "LOC_status is :" + Status);


						
						  
							//test.log(LogStatus.INFO, MarkupHelper.createLabel("Validating the field values with Actual and Expected",ExtentColor.BLUE));
							//test.log(LogStatus.INFO, "Validating the field values with Actual and Expected");


						
						
							
							
												test.log(LogStatus.PASS, "History Transaction is successful");
							test.log(LogStatus.PASS, "**********************************************");

							break;
							
 }
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//test.log(LogStatus.FAIL, MarkupHelper.createLabel("History is failed", ExtentColor.RED));
			test.log(LogStatus.FAIL,"History is failed");


		}
	}
}
	



	
			
		
	

			
		
		

				
				