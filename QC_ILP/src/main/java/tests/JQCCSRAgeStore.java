package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.LogStatus;

//public class QCCSRDueDate extends QCStore {

//}
public class JQCCSRAgeStore extends QCStore{
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;
	
	/*public static String ESign_CheckNbr;
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
	public static String stateProductType;
	public static String stateProduct;
	public static String StoreID;
	public static String NewVIN;
	public static String VehicleType;
	public static String NewLoan_Term;
	public static String NewLoan_ProductName;
	public static String ProductType;
	public static String Password;
	public static String UserName;
	public static String ProductID;
	public static String last4cheknum;
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
	public static String product_name;
	public static int count;
	public static List<WebElement> rows;
	public static String No_of_checks;
	 public static String cardType;
		public static String cardNumber;
		public static String  cardEx_month;
		public static String cardEx_Year;
		public static String cvv;
		public static String CardHolderName;*/




public static void agestore(String SSN,String AppURL)
	{
		 
		try{
			String FileName= prop.getProperty("QC_Store_NewLoan_file_name");
			
			ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("New_Loan");
				String sheetName="New_Loan";

				for(int row=2;row<=lastrow;row++)
				{	
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String StoreAge = TestData.getCellData(sheetName,"StoreAge",row);
					
					
					if(SSN.equals(RegSSN))
					{		
						State = TestData.getCellData(sheetName,"StateID",row);
						 //ProductID=TestData.getCellData(sheetName,"ProductID",row);
						//System.out.println(ProductID);
						 
		
						 SSN1 = SSN.substring(0, 3);
						 SSN2 = SSN.substring(3,5);
						 SSN3 = SSN.substring(5,9);
						
						 
						Thread.sleep(3000);
						test.log(LogStatus.INFO, "CSR Login To AgeStore");
					   /*driver.switchTo().frame("topFrame");
						driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
						test.log(LogStatusPASS, "Clicked on Loan Transactions");
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						
						driver.findElement(locator(prop.getProperty("csr_transaction_link"))).click();			
						test.log(LogStatusPASS, "Clicked on Transaction");		
						driver.switchTo().frame("main");	
						Thread.sleep(500);
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatusPASS, "SSN1 is entered: "+SSN1);
						driver.findElement(locator(prop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
						test.log(LogStatusPASS, "SSN2 is entered: "+SSN2);
						driver.findElement(locator(prop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
						test.log(LogStatusPASS, "SSN3 is entered: "+SSN3);
						driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
						test.log(LogStatusPASS, "Clicked on submit Button");		
						for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);				
					    driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");					    					   					     
					    driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
					    test.log(LogStatusPASS, "Clicked on GO Button");
					    Thread.sleep(5000);					  
						for( String winHandle1 : driver.getWindowHandles())
						{
						    driver.switchTo().window(winHandle1);
						}			
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						
						 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						 test.log(LogStatusPASS, "Clicked on GO Button");
						*/ Thread.sleep(5000);
						 //String Businessdate = driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
						driver.switchTo().frame("bottom");
						
						 String Businessdate=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();  
						
						 test.log(LogStatus.PASS, "Businessdate is :"+Businessdate);
						// -------------
						 						 
						 String NewBdate[]=Businessdate.split(":");
					 		String NewBdate1=NewBdate[1];						 						
							String Datesplit[]=NewBdate1.split("/");
							String date_field_Month=Datesplit[0];
							String date_field_Date=Datesplit[1];
							String date_field_Year=Datesplit[2];							
							
							int IStoreAge=Integer.parseInt(StoreAge);
							int date_field_int=Integer.parseInt(date_field_Date);
							
							date_field_int=date_field_int+IStoreAge;
							String DateAge = Integer.toString(date_field_int);
							
							
					    //System.out.println(date_field_int);
						 
						 
						 
						 
						 
						 
						 
						 //------------
						 /*String NextDueDate = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form[1]/table[2]/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[2]/td[4]")).getText();
						 System.out.println(NextDueDate);
						 test.log(LogStatusPASS, "DueDate is :"+NextDueDate);*/
						 
						 Thread.sleep(500);
						 //driver.switchTo().frame("topFrame");
						 for( String winHandle1 : driver.getWindowHandles())
							{
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
						Thread.sleep(500);
						for( String winHandle1 : driver.getWindowHandles())
						{
						    driver.switchTo().window(winHandle1);
						}			
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						//String Due_Date[] =NextDueDate.split("/");
				        //String Due_Date1 = Due_Date[0];
				        //String Due_Date2 = Due_Date[1];
				        //String Due_Date3 = Due_Date[2];
						 Thread.sleep(500);
				        driver.findElement(By.name("endMonth")).sendKeys(date_field_Month.trim());				        
				        test.log(LogStatus.PASS, "Month is entered: "+date_field_Month);
						driver.findElement(By.name("endDay")).sendKeys(DateAge);
						test.log(LogStatus.PASS, "Date is entered: "+DateAge);
						driver.findElement(By.name("endYear")).sendKeys(date_field_Year);
						test.log(LogStatus.PASS, "Year is entered: "+date_field_Year);
						driver.findElement(By.name("runSchedulerBtn")).click();
						test.log(LogStatus.PASS, "Clicked on Run Scheduler");
						Thread.sleep(500);
						 //String alert1=   driver.switchTo().alert().getText();
						 //test.log(LogLogStatusPASS, "Clicked on Finish Loan: "+alert1);
						 
						 try { 
							    Alert alert = driver.switchTo().alert();
							
							    alert.accept();
							    //if alert present, accept and move on.														
								
							}
							catch (NoAlertPresentException e) {
							    //do what you normally would if you didn't have the alert.
							}
						 Thread.sleep(5000);
						 WebDriverWait wait = new WebDriverWait(driver, 100000);	
						 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ok")));
						 Thread.sleep(5000);
						 driver.findElement(By.name("ok")).click();
						 //test.log(LogStatusPASS, "Clicked on Scheduler Ok");
						 test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
						 Thread.sleep(5000);
						 driver.close();
						}
					}
				//}
		
		}
		                  
						
						/*for( String winHandle1 : driver.getWindowHandles())
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
							// System.out.println("current row num "+count);	
							// System.out.println(" rows num "+ rows.size());
								
														
													if(ProductID.equals("PDL"))
													 {
													 PDL();
													 break;
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
							
							
					
						 	break;
						 	}
							
					}
			
			}*/

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				test.log(LogStatus.FAIL, "New Loan is failed");
				

			}
	
}
	
}

