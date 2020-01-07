package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;





public class ARepaymentInfo extends ATestBase {
	
	

    public static void repaymentInformation(String SSN,String AppURL) throws Exception
  {
    	
    	
    	test.log(LogStatus.PASS, "Enterd into Repayment info page");
    	
          String FileName= "Registration_Lend_Nation.xls";
                Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);              
                int lastrow=TestData.getLastRow("Data");
                String sheetName="Testdata";
                WebDriverWait wait = new WebDriverWait(driver, 30000);

                for(int row=2;row<=lastrow;row++)
                {               
                        String RegSSN = TestData.getCellData(sheetName,"SSN",row);
                        if(SSN.equals(RegSSN))
                        {       
                String RepaymentMethod = TestData.getCellData(sheetName,"RepaymentMethod",row);
                String DebitCardNo = TestData.getCellData(sheetName,"Debit Card No",row);
                String CVV =TestData.getCellData(sheetName,"CVV",row);
                String CardType =TestData.getCellData(sheetName,"Card Type",row);
                String ExpiryMonth =TestData.getCellData(sheetName,"Expiry Month",row);
                String ExpiryYear =TestData.getCellData(sheetName,"Expiry Year",row);
                String fname = TestData.getCellData(sheetName,"FirstName",row);
                String lname = TestData.getCellData(sheetName,"LastName",row);
           	 
           	 String billingAdress = TestData.getCellData(sheetName,"Pcity",row);
                String ZipCode = TestData.getCellData(sheetName,"Ppostalcode",row);
           	 
                Thread.sleep(10000);
                
                
                if(RepaymentMethod.equals("ACH")) {
                driver.findElement(By.name("rRepaymentMethodType")).sendKeys(RepaymentMethod);
                  test.log(LogStatus.PASS, "Selected repayment type " + RepaymentMethod);
                }
                else{
                	driver.findElement(By.name("rRepaymentMethodType")).sendKeys(RepaymentMethod);
                	  test.log(LogStatus.PASS, "Selected repayment type " + RepaymentMethod);
                	  
                	  test.log(LogStatus.PASS, "Entering card details " );
                	  
                	  driver.findElement(By.id("rCardHolderFirstName")).sendKeys(fname);
                	 test.log(LogStatus.PASS, "Enterd First name " + fname);
                	 
                	 driver.findElement(By.id("rCardHolderLastName")).sendKeys(lname);
                	 test.log(LogStatus.PASS, "Enterd last name " + lname);
                	 
                	 driver.findElement(By.id("rCardNumber")).sendKeys(DebitCardNo);
                	 test.log(LogStatus.PASS, "Enterd card Number " + DebitCardNo);
                	 
                	
                	 driver.findElement(By.id("rCardHolderStreetAddress")).sendKeys(billingAdress);
                	 test.log(LogStatus.PASS, "Enterd Billing address " + billingAdress);
                	 
                	 driver.findElement(By.id("rCardHolderPostalCode")).sendKeys(ZipCode);
                	 test.log(LogStatus.PASS, "Enterd Zip Code " + ZipCode);
                	 
                /*	 driver.findElement(By.id("rCardType")).sendKeys(CardType);
                	 test.log(LogStatus.PASS, "Enterd card Type " + CardType);*/
                	 
                	 driver.findElement(By.id("rCVVNumber")).sendKeys(CVV);
                	 test.log(LogStatus.PASS, "Enterd CVV " + CVV);
                	 
                	 driver.findElement(By.id("rMonth")).sendKeys(ExpiryMonth);
                	 test.log(LogStatus.PASS, "Enterd Expiry month " + CVV);
                	 
                	 driver.findElement(By.id("rYear")).sendKeys(ExpiryYear);
                	 test.log(LogStatus.PASS, "Enterd Expiry year " + ExpiryYear);
                	 
                }
                
                
                test.log(LogStatus.PASS, "Card details enterd sucessfully " );

                driver.findElement(By.xpath("//div[@class='pull-right']/button")).click();
                  test.log(LogStatus.PASS, "Click on Submit " );

                  /*wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("loanAmt"))));
                  Thread.sleep(20000);
                  if( driver.findElement(By.name("loanAmt")).isEnabled())
                  {
                                test.log(LogStatus.PASS, "Repayment Information Entered Successfully with SSN " +SSN);                                          
                          }
                                else
                                {
                                test.log(LogStatus.FAIL, "Repayment Information is not entered Successfully with SSN  " +SSN);
                                }
                */
                
                        }
                }
  }
	

}
