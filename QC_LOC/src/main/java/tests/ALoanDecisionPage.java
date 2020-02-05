package tests;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class ALoanDecisionPage extends QCStore{

	
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
				
					

					
						if(ProductID.equals("LOC"))
						{
							rnum=rnum+1;
							if(State.equals("KS")){
								String s1=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]")).getText();
								if(s1.trim().equalsIgnoreCase("Eligible")){								
									//driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input")).click();
									
									test.log(LogStatus.PASS, "Product selected as "+stateProduct);
									
									String LOCamount=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[5]/table/tbody/tr[1]/td[2]")).getText();
									test.log(LogStatus.PASS, "LOC amount is : "+LOCamount);
									String interesrrate=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[5]/table/tbody/tr[2]/td[2]")).getText();
									test.log(LogStatus.PASS, "Interest rate is : "+interesrrate);
									String minAmountDue=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[5]/table/tbody/tr[3]/td[2]")).getText();
									test.log(LogStatus.PASS, "Minimum amount due is : "+minAmountDue);
									 Statementdate=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[5]/table/tbody/tr[4]/td[2]")).getText();
									test.log(LogStatus.PASS, "Statement date is : "+Statementdate);
									String MinLOCamount=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[5]/table/tbody/tr[5]/td[2]")).getText();
									test.log(LogStatus.PASS, "Minimum LOC amount is : "+MinLOCamount);
									String MaxLOCamount=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[5]/table/tbody/tr[6]/td[2]")).getText();
									test.log(LogStatus.PASS, "Maximum Loc amount is : "+MaxLOCamount);

									if(minAmountDue.equals("718.75")||minAmountDue.equals("50.00")){
										test.log(LogStatus.PASS, " Minimum amount due Condition satisfied ");
										driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input")).click();
										driver.findElement(By.id("LoanButtonId")).click();
										ACSRLoginLogout.logout();
										break;
									}
									else{
										test.log(LogStatus.FAIL, " Minimum amount due Condition Not satisfied ");
									}
										

						}				
			}

		}
	}


	
		}}
	
	
}
