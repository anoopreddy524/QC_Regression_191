package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCAutoClear extends QCStore{
	public static void autoClear(String SSN,String AppURL)
	{
		try{
			int lastrow=TestData.getLastRow((prop.getProperty("Deposit")));
			String sheetName=prop.getProperty("Deposit");
			System.out.println("...."+sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				System.out.println("...."+RegSSN);
				if(SSN.equals(RegSSN))
				{
				String loan_Status = TestData.getCellData(sheetName,"LoanStatus",row);	
				String UserName = TestData.getCellData(sheetName,"UserName",row);
				String Password = TestData.getCellData(sheetName,"Password",row);
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				String Deposit_Type = TestData.getCellData(sheetName,"Deposit_Type",row);
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
		       String customer_name=LastName+FileName;
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
		     //  String Misc_IDExpDate = TestData.getCellData(sheetName,"Misc_IDExpDate",row);	   
		       String Misc_PhotoIDType = TestData.getCellData(sheetName,"Misc_PhotoIDType",row);
		       String BorrDOB = TestData.getCellData(sheetName,"Misc_DOB",row);
		       String Income_IncomeType = TestData.getCellData(sheetName,"Income_IncomeType",row);
		       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
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
		       String Income_Employer = TestData.getCellData(sheetName,"Income_Employer",row);
		       String Income_WorkPhone = TestData.getCellData(sheetName,"Income_WorkPhone",row);
		       String TenderType = TestData.getCellData(sheetName,"TenderType",row);
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
				
		       Thread.sleep(4000);
				test.log(LogStatus.INFO, "Clear through from CSR has initiated");
				driver.switchTo().frame("bottom");
				String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
				String store_date[]=Str_date.split(":");
				String business_date=store_date[1];
				test.log(LogStatus.PASS, ""+Str_date);
				
				driver.switchTo().defaultContent();	
				
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
		        driver.findElement(By.cssSelector("li[id='910000']")).click();	
				
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
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
			    
			    driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button under search results");
				
			for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}				    
				 	driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
				    
				  if(ProductID.equals(prop.getProperty("PDL")))
					 {
				    //driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					  driver.findElement(locator(prop.getProperty("go_button"))).click();
					  test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    }
				    if(ProductID.equals(prop.getProperty("TLP")))
					 {
				    	driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
					 }
				    
				    if(ProductID.equals(prop.getProperty("LOC")))
					 {
				    		
				    	 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					 }
				    Thread.sleep(5000);
				   
						String status= driver.findElement(locator(prop.getProperty("loan_status"))).getText();
						test.log(LogStatus.PASS, "Loan Status is " + status);
						test.log(LogStatus.PASS, "Loan Status is..... " + loan_Status);
						//if(loan_Status.toLowerCase().trim().equalsIgnoreCase(status.toLowerCase().trim()))	
						if(loan_Status.equalsIgnoreCase(status))
						{
							 test.log(LogStatus.PASS, ESign_CollateralType+" Auto Clear from CSR is successfull");
							 test.log(LogStatus.PASS, "********************************************** ");
						} 
						break;
				}
				
				 
			}
			
		}catch(Exception e){
						e.printStackTrace();
						test.log(LogStatus.FAIL, "Check Clear from CSR is failed");

		}
			
		
	}

}
