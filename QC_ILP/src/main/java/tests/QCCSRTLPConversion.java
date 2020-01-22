package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class QCCSRTLPConversion extends QCStore {
public static int rnum;
public static int cnum;
public static String PhoneNbr3;
public static String PhoneNbr2;
public static String PhoneNbr1;
public static String PhoneNbr;
public static String InsuranceExpiryDate;
public static String InsuranceExpiryDate0[] = null;
public static String InsuranceExpiryDate3;
public static String InsuranceExpiryDate2;
public static String InsuranceExpiryDate1;
	public static void conversion(String SSN, String AppURL) throws Exception
	{
	
		try {
			
			int lastrow = TestData.getLastRow("TLPConversion");
			String sheetName = "TLPConversion";

			for (int row = 2; row <= lastrow; row++) {

				
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				if (SSN.equals(RegSSN)) {
					String UserName = TestData.getCellData(sheetName, "UserName", row);
					String Password = TestData.getCellData(sheetName, "Password", row);
					String PIN = TestData.getCellData(sheetName, "PIN", row);
					
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String ProductType = TestData.getCellData(sheetName, "ProductType", row);
					String stateProductType = StateID + " " + ProductType;
					String TxnType = TestData.getCellData(sheetName, "TxnType", row);
					String DisbType = TestData.getCellData(sheetName, "DisbType", row);
					String TenderType = TestData.getCellData(sheetName, "TenderType", row);
					String VehicleType = TestData.getCellData(sheetName, "VehicleType", row);
					String VIN = TestData.getCellData(sheetName, "VIN", row);
					String NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
					String Miles = TestData.getCellData(sheetName, "Miles", row);
					String NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
					String TitleNumber = TestData.getCellData(sheetName, "TitleNumber", row);
					String VehicleMake = TestData.getCellData(sheetName, "VehicleMake", row);
					String VehicleModel = TestData.getCellData(sheetName, "VehicleModel", row);
					String VehicleYear = TestData.getCellData(sheetName, "VehicleYear", row);
					String License_Plate_Number = TestData.getCellData(sheetName, "License_Plate_Number", row);
					String ExteriorColor = TestData.getCellData(sheetName, "ExteriorColor", row);
					String VehicleGrade = TestData.getCellData(sheetName, "VehicleGrade", row);
					String InsuranceCoverage = TestData.getCellData(sheetName, "InsuranceCoverage", row);
					String InsuranceCompany = TestData.getCellData(sheetName, "InsuranceCompany", row);
					String PolicyNumber = TestData.getCellData(sheetName, "PolicyNumber", row);
					String InsuranceExpiryDate = TestData.getCellData(sheetName, "InsuranceExpiryDate", row);
					String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent", row);
					String Selectcard = TestData.getCellData(sheetName, "Selectcard", row);
					String CardType = TestData.getCellData(sheetName, "CardType", row);
					String CardNbr = TestData.getCellData(sheetName, "CardNbr", row);
					String Expmonth = TestData.getCellData(sheetName, "Expmonth", row);
					String Expyear = TestData.getCellData(sheetName, "Expyear", row);
					String CVV = TestData.getCellData(sheetName, "CVV", row);
					String CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);
					
					
					
					
					
					
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3, 5);
					String SSN3 = SSN.substring(5, 9);

					Thread.sleep(4000);
					
					test.log(LogStatus.INFO, "conversion has Started");
					driver.switchTo().defaultContent();

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					Thread.sleep(4000);
					driver.findElement(By.cssSelector("li[id='910000']")).click();

					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(4000);

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")).click();
					test.log(LogStatus.PASS, "Clicked on Transactions");
					driver.switchTo().frame("main");
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
					driver.findElement(By.name("ssn2")).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
					driver.findElement(By.name("ssn3")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
					driver.findElement(By.name("submit1")).click();
					test.log(LogStatus.PASS, "Click on submit Button");
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					Thread.sleep(4000);
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
				

					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					
                   				
					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='go_Button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					//Thread.sleep(30000);
					 
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					
					driver.findElement(By.id("go_Button")).click();
					test.log(LogStatus.PASS, "Clicked on Continue button");
					//Thread.sleep(5000);
					
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("vehicleType_dd"))));
					driver.findElement(By.name("vehicleType_dd")).sendKeys(VehicleType);
					test.log(LogStatus.PASS, "Vehicle Type is :" +VehicleType);
					driver.findElement(By.name("existingVin")).sendKeys(VIN);
					test.log(LogStatus.PASS, "VIN Type is :" +VIN);
					driver.findElement(By.name("newVinNbr")).sendKeys(NewVIN);
					test.log(LogStatus.PASS, "New VIN nbr is :" +NewVIN);
					driver.findElement(By.name("miles")).sendKeys(Miles);
					test.log(LogStatus.PASS, "Miles entered is :" +Miles);
					driver.findElement(By.name("bbHit_Button")).click();
					test.log(LogStatus.PASS, "Clicked on HitBlackBook Button");
					wait.until(ExpectedConditions.elementToBeClickable(By.name("button2")));
	//==============================================================================================
					test.log(LogStatus.PASS, "getting product name ");

					List<WebElement> rows = driver.findElements(
							By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"));

					int n = rows.size();

					for (int i = 2; i <= n; i++) {

						String Pname = driver.findElement(
								By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[" + i
										+ "]/td[2]"))
								.getText();

						test.log(LogStatus.PASS, "getting product name " + Pname);

						if (Pname.equals(stateProductType))

						{

							if (NewLoan_Term.equals("Term1"))

							{

								driver.findElement(By
										.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["
												+ i + "]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input")).click();

								test.log(LogStatus.PASS, "Selected check box as " + NewLoan_Term);
								Thread.sleep(3000);
								driver.findElement(By.xpath("//*[@id='LoanButtonId']")).click();
								test.log(LogStatus.PASS, "Clicked on Conversion");
								
								wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='titleNumber']")));
								driver.findElement(By.xpath("//*[@id='titleNumber']")).clear();
								Thread.sleep(1000);
								driver.findElement(By.xpath("//*[@id='titleNumber']")).sendKeys(TitleNumber);
								test.log(LogStatus.PASS, "title number is :" +TitleNumber);
								Thread.sleep(1000);
								driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table[2]/tbody/tr[4]/td/input")).click();
								test.log(LogStatus.PASS, "Clicked on Update");
								wait.until(ExpectedConditions.elementToBeClickable(By.name("requestBean.vehicleMake")));
								Thread.sleep(3000);
								driver.findElement(By.name("requestBean.vehicleMake")).clear();
								driver.findElement(By.name("requestBean.vehicleMake")).sendKeys(VehicleMake);
								Thread.sleep(5000);
								driver.findElement(By.name("requestBean.vehicleMake")).sendKeys(VehicleMake);
								test.log(LogStatus.PASS, "Vehicle Make is :" +VehicleMake);
								Thread.sleep(1000);
								//driver.findElement(By.name("requestBean.vehicleModel")).clear();
								driver.findElement(By.name("requestBean.vehicleModel")).sendKeys(VehicleModel);
								test.log(LogStatus.PASS, "Vehicle Model is :" +VehicleModel);
								Thread.sleep(500);
								//driver.findElement(By.name("requestBean.vehicleYear")).clear();
								driver.findElement(By.name("requestBean.vehicleYear")).sendKeys(VehicleYear);
								test.log(LogStatus.PASS, "Vehicle Year is :" +VehicleYear);
								Thread.sleep(500);
								//driver.findElement(By.name("requestBean.licensePltNbr")).clear();
								driver.findElement(By.name("requestBean.licensePltNbr")).sendKeys(License_Plate_Number);
								test.log(LogStatus.PASS, "License number is :" +License_Plate_Number);
								Thread.sleep(500);
								driver.findElement(By.name("requestBean.extClr")).sendKeys(ExteriorColor);
								test.log(LogStatus.PASS, "Exterior Color is :" +ExteriorColor);
								Thread.sleep(500);
								//driver.findElement(By.name("requestBean.vehicleGrade")).clear();
								driver.findElement(By.name("requestBean.vehicleGrade")).sendKeys(VehicleGrade);
								test.log(LogStatus.PASS, "Vehicle grade is :" +VehicleGrade);
								Thread.sleep(500);
								//driver.findElement(By.name("requestBean.coverageType")).clear();
								driver.findElement(By.name("requestBean.coverageType")).sendKeys(InsuranceCoverage);
								test.log(LogStatus.PASS, "Insurance is :" +InsuranceCoverage);
								Thread.sleep(500);
								driver.findElement(By.name("requestBean.companyName")).clear();
								driver.findElement(By.name("requestBean.companyName")).sendKeys(InsuranceCompany);
								test.log(LogStatus.PASS, "Insurance Company is :" +InsuranceCompany);
								Thread.sleep(500);
								driver.findElement(By.name("requestBean.polocyNbr")).clear();
								driver.findElement(By.name("requestBean.polocyNbr")).sendKeys(PolicyNumber);
								test.log(LogStatus.PASS, "Policy Number is :" +PolicyNumber);
								
								PhoneNbr  = TestData.getCellData(sheetName, "PhoneNbr", row);
								PhoneNbr1 = PhoneNbr.substring(0, 3);
								PhoneNbr2 = PhoneNbr.substring(3, 6);
								PhoneNbr3 = PhoneNbr.substring(6, 10);
								driver.findElement(By.name("iPhoneNbr1")).clear();
								driver.findElement(By.name("iPhoneNbr1")).sendKeys(PhoneNbr1);
								test.log(LogStatus.PASS, "Entereted phone number field 1 as  " + PhoneNbr1);
								Thread.sleep(500);
								driver.findElement(By.name("iPhoneNbr2")).clear();
								driver.findElement(By.name("iPhoneNbr2")).sendKeys(PhoneNbr2);
								test.log(LogStatus.PASS, "Entereted phone number field 2 as  " + PhoneNbr2);
								Thread.sleep(500);
								driver.findElement(By.name("iPhoneNbr3")).clear();
								driver.findElement(By.name("iPhoneNbr3")).sendKeys(PhoneNbr3);
								test.log(LogStatus.PASS, "Entereted phone number field 3 as  " + PhoneNbr3);
								driver.findElement(By.name("requestBean.companyName")).clear();
								driver.findElement(By.name("requestBean.companyName")).sendKeys(InsuranceCompany);
								test.log(LogStatus.PASS, "Entered Insurance company as " + InsuranceCompany);
								InsuranceExpiryDate0 = InsuranceExpiryDate.split("/");
								InsuranceExpiryDate1 = InsuranceExpiryDate0[0];
								InsuranceExpiryDate2 = InsuranceExpiryDate0[1];
								InsuranceExpiryDate3 = InsuranceExpiryDate0[2];
								Thread.sleep(500);
								driver.findElement(By.name("iexpiry1")).clear();
								driver.findElement(By.name("iexpiry1")).sendKeys(InsuranceExpiryDate1);									
								test.log(LogStatus.PASS, "Entereted Insurance expiry date field 1 as  " + InsuranceExpiryDate1);
								Thread.sleep(500);
								driver.findElement(By.name("iexpiry2")).clear();
								driver.findElement(By.name("iexpiry2")).sendKeys(InsuranceExpiryDate2);
								
								test.log(LogStatus.PASS, "Entereted Insurance expiry date field 2 as  " + InsuranceExpiryDate2);
								Thread.sleep(500);
								driver.findElement(By.name("iexpiry3")).clear();
								driver.findElement(By.name("iexpiry3")).sendKeys(InsuranceExpiryDate3);
								
								test.log(LogStatus.PASS, "Entereted Insurance expiry date field 3 as  " + InsuranceExpiryDate3);
								//driver.findElement(By.name("requestBean.polocyNbr")).clear();
								//driver.findElement(By.name("requestBean.polocyNbr")).sendKeys(PolicyNumber);
								//test.log(LogStatus.PASS, "Entered policy number as " + PolicyNumber);
								Thread.sleep(6000);
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("button2")));
								driver.findElement(By.name("button2")).click();
								Thread.sleep(1000);
								driver.findElement(By.name("button2")).click();
								//driver.findElement(By.xpath("//*[@id='vehicleInformation']/td/table/tbody/tr[10]/td/input")).clear();
								test.log(LogStatus.PASS, "Clicked on update button ");
								Thread.sleep(5000);

								wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("process")));
								driver.findElement(By.name("process")).click();

								test.log(LogStatus.PASS, "click on process Loan button ");							
								Thread.sleep(5000);
								try{
								driver.findElement(By.xpath("//input[@value='Yes']")).click();
								}
								catch(Exception e)
								{
									
								}
								Thread.sleep(1000);
                                wait.until(ExpectedConditions.elementToBeClickable(By.name("qualify")));
                                driver.findElement(By.name("qualify")).click();
                                test.log(LogStatus.PASS, "Clicked on Qualify button ");
                                Thread.sleep(5000);
                                wait.until(ExpectedConditions.elementToBeClickable(By.name("requestBean.siilBean.tenderTypeFirst")));
                                 Thread.sleep(5000);
                               
                                driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
                                String PaymentAmt = driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
    							test.log(LogStatus.PASS, "PaymentAmt is :" + PaymentAmt);
    							Thread.sleep(500);
    							driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).clear();
    							driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(PaymentAmt);
    							test.log(LogStatus.PASS, "TenderAmt is :" + PaymentAmt);
    							Thread.sleep(5000);
    							
    							 if (ESign_CollateralType.equals("DEBIT CARD")) {
    								 driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
    	    						 test.log(LogStatus.PASS, "collateralType is :" + ESign_CollateralType);
    	    						 Thread.sleep(500);
    	    						 
    	    						 
    	    						 
    	    						 //driver.findElement(By.name("cardNmbr")).sendKeys(Selectcard);
    	    						 driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys(Selectcard);

    	    							test.log(LogStatus.PASS, "Select card as : " + "Selectcard");
    	    							Thread.sleep(500);
    	    							driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(CardNbr);

    	    							test.log(LogStatus.PASS, "Card number is :" + CardNbr);
    	    							Thread.sleep(500);
    	    							driver.findElement(By.xpath("//*[@id='cardType']/select")).sendKeys(CardType);

    	    							test.log(LogStatus.PASS, "Enterd card Type : " + CardType);
    	    							Thread.sleep(500);
    	    							driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(Expmonth);

    	    							test.log(LogStatus.PASS, "Enterd Expiry month " + Expmonth);
    	    							Thread.sleep(500);
    	    							driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(Expyear);
    	    							Thread.sleep(500);
    	    							test.log(LogStatus.PASS, "Enterd Expiry year " + Expyear);

    	    							driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(CVV);

    	    							test.log(LogStatus.PASS, "Enterd CVV " + CVV);

    	    							driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);

    	    							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
    	    						 
    	    							/*
    	    							 * driver.findElement(By .xpath(
    	    							 * "//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]"
    	    							 * )) .click();
    	    							 */
    	    							driver.findElement(
    	    									By.xpath("//input[@class='sortbuttons' and @onclick='this.disabled=true;addCard(this);']")).click();

    	    							test.log(LogStatus.PASS, "Clicked on add card button ");

    	    							Thread.sleep(30000);
    	    							wait.until(ExpectedConditions.elementToBeClickable(By.name("requestBean.siilBean.courtesyCallFlag")));
    	    							driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
    	    							test.log(LogStatus.PASS, "Courtesy call selected : "+ESign_CourtesyCallConsent);
    								 
    							 }
    							 else{
    								 driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
    	    						 test.log(LogStatus.PASS, "collateralType is :" + ESign_CollateralType);
    	    						 Thread.sleep(5000);
    	    						 try{
    	    						String totaldisbamt=driver.findElement(By.id("refinanceLoanAmt")).getAttribute("value");
    	    						test.log(LogStatus.PASS, "Total Disb Amt is : "+totaldisbamt); 
    	    						 Thread.sleep(500);
    	    						 driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys("Cash");
    	    						 test.log(LogStatus.PASS, "Disb Type is Cash");
    	    						 Thread.sleep(500);
    	    						 }
    	    						 catch(Exception e)
    	    						 {
    	    							 test.log(LogStatus.PASS, "Disb Type is not available for this");
    	    						 }
    	    						 //driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(totaldisbamt);
    	    						 //test.log(LogStatus.PASS, "Disb Amount Entered as:"+totaldisbamt);
    	    						 Thread.sleep(500);
    	    						 driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
 	    							test.log(LogStatus.PASS, "Courtesy call selected : "+ESign_CourtesyCallConsent);   								 
    								 
    							 }
    								    							     							 
    							 Thread.sleep(5000);
    							driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
    							test.log(LogStatus.PASS, "Pin Entered :"+PIN);
    							driver.findElement(By.name("finishLoan")).click();
    							test.log(LogStatus.PASS, "Clicked on Finish Conversion");
    							Thread.sleep(30000);
    							wait.until(ExpectedConditions.elementToBeClickable(By.name("OKBut")));
    							driver.findElement(By.name("OKBut")).click();
    							test.log(LogStatus.PASS, "Clicked on Yes");
    							Thread.sleep(500);
    							test.log(LogStatus.PASS, "Conversion Completed Successfully");
    							//driver.close();
    							
    							
    							
    							
    							
								
							}

					
							
							/*else if (NewLoan_Term.equals("Term2"))

							{

								driver.findElement(By
										.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["
												+ rnum + "]/td[5]/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/b/input"))
										.click();

								test.log(LogStatus.PASS, "Selected check box as " + NewLoan_Term);

							}

						}

						else {

							continue;

						}*/
	

					break;
				}
			}

		}
	}
		}

		catch (Exception e) {
		
			test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
			String screenshotPath = getScreenhot(driver, "Exception");
							test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "Conversion failed");

		}

	}
}

