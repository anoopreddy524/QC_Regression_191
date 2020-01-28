package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.relevantcodes.extentreports.LogStatus;

public class QCPrePayment extends QCStore{


	public static void prePayment(String SSN,String AppURL) throws Exception{
		int i;
		for(i=0;i<3;i++)
		{


			try{
				int lastrow=TestData.getLastRow("Pre_Payment");
				String sheetName= "Pre_Payment";
				//test.log(LogStatus.PASS, "*****************"+sheetName);
				for(int row=2;row<=lastrow;row++)
				{
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
						String ProductID = TestData.getCellData(sheetName,"ProductID",row);
						String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
						String PIN = TestData.getCellData(sheetName,"PIN#",row);
						String Tender_Type = TestData.getCellData(sheetName,"TenderType",row);
						String Tender_Amount = TestData.getCellData(sheetName,"TenderAmount",row);
						String CCMONbr = TestData.getCellData(sheetName,"CCMONbr",row);
						String CardType = TestData.getCellData(sheetName,"sCardType",row);
						String CardNbr = TestData.getCellData(sheetName,"CardNumber",row);
						String ExpMonth = TestData.getCellData(sheetName,"ExpMonth",row);
						String ExpYear = TestData.getCellData(sheetName,"ExpYear",row);
						String CVVNbr = TestData.getCellData(sheetName,"CVVNbr",row);
						String CCName = TestData.getCellData(sheetName,"CardHolderName",row);
						String ChkAcctNumber = TestData.getCellData(sheetName,"ChkAcctNumber",row);
						String Scenario = TestData.getCellData(sheetName,"Scenario",row);


						DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
						String SSN1 = SSN.substring(0, 3);
						String SSN2 = SSN.substring(3,5);
						String SSN3 = SSN.substring(5,9);		       

						Thread.sleep(4000);
						test.log(LogStatus.INFO, "PrePayment from CSR has initiated");

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
						if(ProductID.equals("PDL"))
						{
							driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

							//driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
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

						String loan_nbr= driver.findElement(locator(prop.getProperty("csr_loan_nbr"))).getText();
						test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						if(ESign_CollateralType.equalsIgnoreCase("ACH"))
						{
							for( String winHandle1 : driver.getWindowHandles())
							{
								driver.switchTo().window(winHandle1);
							}			
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							if(Scenario.equalsIgnoreCase("EPP"))
							{
							driver.findElement(By.name("transactionList")).sendKeys("EPP Payment");
							test.log(LogStatus.PASS, "Transaction type is selected EPP Pre-Payment");
							}
							else
							{
								driver.findElement(By.name("transactionList")).sendKeys("ACH Pre-Payment");
								test.log(LogStatus.PASS, "Transaction type is selected ACH Pre-Payment");	
							}
							driver.findElement(By.id("go_Button")).click();
							test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");	

							driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(Tender_Type);
							test.log(LogStatus.PASS, " Selected the Tender_Type as " +Tender_Type);

							if(Tender_Type.equalsIgnoreCase("Cash"))
							{

								driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Tender_Amount);
								test.log(LogStatus.PASS, " Enter the Tender Amooumt " +Tender_Amount);
								driver.findElement(By.name("transactionDataBean.chkgAcctNbr")).sendKeys(ChkAcctNumber);
								test.log(LogStatus.PASS, " Enter the Checking account number as  " +ChkAcctNumber);
								// driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
								driver.findElement(By.name("password")).sendKeys(PIN);
								test.log(LogStatus.PASS, " Entered password");
								driver.findElement(By.name("Submit22")).click();
								test.log(LogStatus.PASS, " Cliked on finish ACH pre-payment button");
								Thread.sleep(5000);
								try { 
									Alert alert = driver.switchTo().alert();
									alert.accept();
									// if alert present, accept and move on.													
								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
								Thread.sleep(5000);
								if(driver.findElement(By.xpath("//*[text()='ACH Pre-Payment Completed Successfully.']")).isDisplayed())
								{

									test.log(LogStatus.PASS, ESign_CollateralType+" Pre-Payement from CSR is successfull");
									test.log(LogStatus.PASS, "********************************************** ");

								}
							} 
							else if(Tender_Type.equalsIgnoreCase("Cashiers Check"))
							{

								driver.findElement(By.name("transactionDataBean.ccmoNbrFirst")).sendKeys(CCMONbr);
								driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Tender_Amount);
								test.log(LogStatus.PASS, " Enter the Tender Amooumt " +Tender_Amount);
								driver.findElement(By.name("transactionDataBean.chkgAcctNbr")).sendKeys(ChkAcctNumber);
								test.log(LogStatus.PASS, " Enter the Checking account number as  " +ChkAcctNumber);
								driver.findElement(By.name("password")).sendKeys(PIN);
								test.log(LogStatus.PASS, " Entered password");
								driver.findElement(By.name("Submit22")).click();
								test.log(LogStatus.PASS, " cliked on finish ACH pre-payment button");
								Thread.sleep(5000);
								// if(driver.findElement(By.xpath("//*[text()='ACH Pre-Payment Completed Successfully.']")).isDisplayed())
								if(driver.findElement(By.name("checkno")).isDisplayed())
								{

									test.log(LogStatus.PASS, ESign_CollateralType+" Pre-Payement from CSR is successfull");
									test.log(LogStatus.PASS, "********************************************** ");

								}
							}

							else if(Tender_Type.equalsIgnoreCase("Money Order"))
							{
								Thread.sleep(1000);
								driver.findElement(By.name("transactionDataBean.ccmoNbrFirst")).sendKeys(CCMONbr);
								driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Tender_Amount);
								test.log(LogStatus.PASS, " Enter the Tender Amooumt " +Tender_Amount);
								driver.findElement(By.name("transactionDataBean.chkgAcctNbr")).sendKeys(ChkAcctNumber);
								test.log(LogStatus.PASS, " Enter the Checking account number as  " +ChkAcctNumber);
								driver.findElement(By.name("password")).sendKeys(PIN);
								test.log(LogStatus.PASS, " Entered password");
								driver.findElement(By.name("Submit22")).click();
								test.log(LogStatus.PASS, " cliked on finish ACH pre-payment button");
								Thread.sleep(5000);
								if(driver.findElement(By.xpath("//*[text()='ACH Pre-Payment Completed Successfully.']")).isDisplayed())
								{

									test.log(LogStatus.PASS, ESign_CollateralType+" Pre-Payement from CSR is successfull");
									test.log(LogStatus.PASS, "********************************************** ");

								}
							}
							else if(Tender_Type.equalsIgnoreCase("Debit Card"))
							{

								driver.findElement(By.name("transactionDataBean.cardIssuerId")).sendKeys(CardType);
								driver.findElement(By.name("ccnumber")).sendKeys(CardNbr);
								test.log(LogStatus.PASS, " Enter the Card Number " +CardNbr);
								driver.findElement(By.name("expmonth")).sendKeys(ExpMonth);
								test.log(LogStatus.PASS, " Enter the Exp Month " +ExpMonth);
								driver.findElement(By.name("expyear")).sendKeys(ExpYear);
								test.log(LogStatus.PASS, " Enter the Exp Year " +ExpYear);
								driver.findElement(By.name("cvvnumber")).sendKeys(CVVNbr);
								test.log(LogStatus.PASS, " Enter the CVV number " +CVVNbr);
								driver.findElement(By.name("ccname")).sendKeys(CCName);
								test.log(LogStatus.PASS, " Enter the card holder name " +CCName);
								driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Tender_Amount);
								test.log(LogStatus.PASS, " Enter the Tender Amooumt " +Tender_Amount);
								driver.findElement(By.name("transactionDataBean.chkgAcctNbr")).sendKeys(ChkAcctNumber);
								test.log(LogStatus.PASS, " Enter the Checking account number as  " +ChkAcctNumber);
								driver.findElement(By.name("password")).sendKeys(PIN);
								test.log(LogStatus.PASS, " Entered password");
								driver.findElement(By.name("Submit22")).click();
								test.log(LogStatus.PASS, " cliked on finish ACH pre-payment button");
								Thread.sleep(5000);
								if(driver.findElement(By.xpath("//*[text()='ACH Pre-Payment Completed Successfully.']")).isDisplayed())
								{

									test.log(LogStatus.PASS, ESign_CollateralType+" Pre-Payement from CSR is successfull");
									test.log(LogStatus.PASS, "********************************************** ");

								}
							}
						}
						if(ESign_CollateralType.equalsIgnoreCase("CHECK"))
						{
							for( String winHandle1 : driver.getWindowHandles())
							{
								driver.switchTo().window(winHandle1);
							}			
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							driver.findElement(By.name("transactionList")).sendKeys(" Pre-Payment");
							test.log(LogStatus.PASS, "Transaction type is selected Pre-Payment");
							driver.findElement(By.id("go_Button")).click();
							test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");	

							driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(Tender_Type);
							test.log(LogStatus.PASS, " Selected the Tender_Type as " +Tender_Type);

							if(Tender_Type.equalsIgnoreCase("Cash"))
							{
								driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Tender_Amount);
								test.log(LogStatus.PASS, " Enter the Tender Amooumt " +Tender_Amount);
								driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
								test.log(LogStatus.PASS, " Entered password");
								driver.findElement(By.name("Submit22")).click();
								test.log(LogStatus.PASS, " cliked on finish pre-payment button");
								Thread.sleep(5000);
								try { 

									Alert alert = driver.switchTo().alert();
									alert.accept();
									// if alert present, accept and move on.													
								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
								Thread.sleep(5000);



								if(driver.findElement(By.xpath("//input[@name='checkyes']")).isDisplayed())

								{

									test.log(LogStatus.PASS, ESign_CollateralType+" Pre-Payement from CSR is successfull");
									test.log(LogStatus.PASS, "********************************************** ");

								}
							} 
							else if(Tender_Type.equalsIgnoreCase("Cashiers Check"))
							{

								driver.findElement(By.name("transactionDataBean.ccmoNbrFirst")).sendKeys(CCMONbr);
								driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Tender_Amount);
								test.log(LogStatus.PASS, " Enter the Tender Amooumt " +Tender_Amount);
								driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
								test.log(LogStatus.PASS, " Entered password");
								driver.findElement(By.name("Submit22")).click();
								test.log(LogStatus.PASS, " cliked on finish pre-payment button");
								Thread.sleep(5000);

								if(driver.findElement(By.xpath("//input[@name='checkyes']")).isDisplayed())

								{

									test.log(LogStatus.PASS, ESign_CollateralType+" Pre-Payement from CSR is successfull");
									test.log(LogStatus.PASS, "********************************************** ");

								}
							}

							else if(Tender_Type.equalsIgnoreCase("Money Order"))
							{
								Thread.sleep(1000);
								driver.findElement(By.name("transactionDataBean.ccmoNbrFirst")).sendKeys(CCMONbr);
								driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Tender_Amount);
								test.log(LogStatus.PASS, " Enter the Tender Amooumt " +Tender_Amount);
								driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
								test.log(LogStatus.PASS, " Entered password");
								driver.findElement(By.name("Submit22")).click();
								test.log(LogStatus.PASS, " cliked on finish pre-payment button");
								Thread.sleep(5000);
								if(driver.findElement(By.xpath("//input[@name='checkyes']")).isDisplayed())
								{

									test.log(LogStatus.PASS, ESign_CollateralType+" Pre-Payement from CSR is successfull");
									test.log(LogStatus.PASS, "********************************************** ");

								}
							}
							else if(Tender_Type.equalsIgnoreCase("Debit Card"))
							{

								driver.findElement(By.name("transactionDataBean.cardIssuerId")).sendKeys(CardType);
								driver.findElement(By.name("ccnumber")).sendKeys(CardNbr);
								test.log(LogStatus.PASS, " Enter the Card Number " +CardNbr);
								driver.findElement(By.name("expmonth")).sendKeys(ExpMonth);
								test.log(LogStatus.PASS, " Enter the Exp Month " +ExpMonth);
								driver.findElement(By.name("expyear")).sendKeys(ExpYear);
								test.log(LogStatus.PASS, " Enter the Exp Year " +ExpYear);
								driver.findElement(By.name("cvvnumber")).sendKeys(CVVNbr);
								test.log(LogStatus.PASS, " Enter the CVV number " +CVVNbr);
								driver.findElement(By.name("ccname")).sendKeys(CCName);
								test.log(LogStatus.PASS, " Enter the card holder name " +CCName);
								driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Tender_Amount);
								test.log(LogStatus.PASS, " Enter the Tender Amooumt " +Tender_Amount);
								driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
								test.log(LogStatus.PASS, " Entered password");
								driver.findElement(By.name("Submit22")).click();
								test.log(LogStatus.PASS, " cliked on finish pre-payment button");
								Thread.sleep(5000);
								if(driver.findElement(By.xpath("//input[@name='checkyes']")).isDisplayed())
								{

									test.log(LogStatus.PASS, ESign_CollateralType+" Pre-Payement from CSR is successfull");
									test.log(LogStatus.PASS, "********************************************** ");

								}
							}
						}
						break;
					}

				}
				break;
			}
			catch(Exception e){
				e.printStackTrace();
				//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Deposit from CSR is failed", ExtentColor.RED));
				test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
				String screenshotPath = getScreenhot(driver, "Prepayment");
								test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.INFO, "Pre Payment CSR is intiated again due to Application sync issue");
				driver.get(prop.getProperty("login_page"));   
				continue;
			}
		} 
		if(i==3)
		{
			test.log(LogStatus.FAIL, "Deposit through dropdown is failed");

		}
	}
}
