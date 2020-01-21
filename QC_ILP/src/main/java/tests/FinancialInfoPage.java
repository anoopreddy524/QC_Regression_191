package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;




public class FinancialInfoPage extends TestBase {
	
	
		
		public static void financialInformation(String SSN,String AppURL) throws Exception
		  {
			
			test.log(LogStatus.PASS, "Enterd into Financial information page");
			
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
		                        	Thread.sleep(3000);
		                String IncomeSourse = TestData.getCellData(sheetName,"IncomeSourse",row);
		                String EmployerName = TestData.getCellData(sheetName,"EmployerName",row);
		                String EmployerIndustry = TestData.getCellData(sheetName,"EmployerIndustry",row);
		                String WorkPhone = TestData.getCellData(sheetName,"WorkPhone",row);
		                String TimeAtJob = TestData.getCellData(sheetName,"TimeAtJob",row);
		                String Income_GrossIncome = TestData.getCellData(sheetName,"Income_GrossIncome",row);
		                String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
		                String PayMethod = TestData.getCellData(sheetName,"PayMethod",row);
		                String PaidDay = TestData.getCellData(sheetName,"PaidDay",row);
		                String TakeHome = TestData.getCellData(sheetName,"TakeHome",row);
		                String ReceiveType = TestData.getCellData(sheetName,"ReceiveType",row);
		                
		                String AccountType = TestData.getCellData(sheetName,"AccountType",row);
		                String AccountNumber = TestData.getCellData(sheetName,"AccountNumber",row);
		                String Bank_ABARoutingNbr = TestData.getCellData(sheetName,"Bank_ABARoutingNbr",row);



		          
		          
		Thread.sleep(30000);
		          driver.findElement(By.name("iIncomeType")).sendKeys(IncomeSourse);
		          test.log(LogStatus.PASS, "Selected Income source " + IncomeSourse);
		          Thread.sleep(3000);
		          driver.findElement(By.name("iEmployerName")).sendKeys(EmployerName);
		          test.log(LogStatus.PASS, "Entered Employer Name " + EmployerName);

		          driver.findElement(By.name("iIndustryType")).sendKeys(EmployerIndustry);
		          test.log(LogStatus.PASS, "Selected Emmployer Industry " + EmployerIndustry);
		          Thread.sleep(3000);
		          driver.findElement(By.name("iEmployerPhone")).sendKeys(WorkPhone);
		          test.log(LogStatus.PASS, "Enterted Employer phone no " + WorkPhone);

		          driver.findElement(By.name("iSelectedTimeAtEmployer")).sendKeys(TimeAtJob);
		          test.log(LogStatus.PASS, "Selected Time at employer " + TimeAtJob);
		          Thread.sleep(3000);
		          driver.findElement(By.name("iPayPeriodType")).sendKeys(Income_PayFrequency);
		          test.log(LogStatus.PASS, "Selected Pay frequency " + Income_PayFrequency);

		          driver.findElement(By.name("iPayMethodType")).sendKeys(PayMethod);
		          test.log(LogStatus.PASS, "Selected Income method type " + PayMethod);
		          Thread.sleep(2000);
		          driver.findElement(By.name("incomeWeekPaid0")).sendKeys(PaidDay);
		          test.log(LogStatus.PASS, "Selected Income paid day " + PaidDay);

		          Thread.sleep(2000);
		          driver.findElement(By.id("first")).click();
		          test.log(LogStatus.PASS, "Selected Next pay date " );

		          
		          driver.findElement(By.name("iGrossPay")).sendKeys(Income_GrossIncome);
		          test.log(LogStatus.PASS, "Enterted Gross pay amount is " + Income_GrossIncome);

		          driver.findElement(By.name("iNetPay")).sendKeys(TakeHome);
		          test.log(LogStatus.PASS, "Entered Net pay amount is  " + TakeHome);
		          
		          driver.findElement(By.id("addInc")).click();
		    	  test.log(LogStatus.PASS, "Added Income " );
		    	  Thread.sleep(2000);
		    	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("disbType"))));
		    	  driver.findElement(By.name("disbType")).sendKeys(ReceiveType);
		    	  test.log(LogStatus.PASS, "Selected Receive type " + ReceiveType);

		    	  driver.findElement(By.id("incomeSubmitBtn")).click();
		    	  test.log(LogStatus.PASS, "Submitted income " + IncomeSourse);

		    	  
		    	  driver.findElement(By.name("fAccountType")).sendKeys(AccountType);
		    	  test.log(LogStatus.PASS, "Selected account type " + AccountType );
		    	 
		    	  driver.findElement(By.name("fRoutingNumber")).sendKeys(Bank_ABARoutingNbr);
		    	  test.log(LogStatus.PASS, "entered ABA number " + Bank_ABARoutingNbr);
		    	  driver.findElement(By.name("fAccountNumber")).sendKeys(AccountNumber);
		    	  test.log(LogStatus.PASS, "entered Account number " + AccountNumber);

		    	  driver.findElement(By.name("fAccountNumberConfirm")).sendKeys(AccountNumber);
		    	  test.log(LogStatus.PASS, "Confirmed account number " + AccountNumber);


		    	  driver.findElement(By.id("incomeSubmitBtn")).click();
		    	  test.log(LogStatus.PASS, "Clikced on Continue " );
		    	  Thread.sleep(20000);
		    	  
		    	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("rRepaymentMethodType"))));

		    	  if( driver.findElement(By.name("rRepaymentMethodType")).isEnabled())
		    	  {
		    			test.log(LogStatus.PASS, "finanacial Information Entered Successfully with SSN " +SSN);						
		    		 	}
		    			else
		    			{
		    			test.log(LogStatus.FAIL, "Financial Information is not entered Successfully with SSN  " +SSN);
		    			}
		      




		    	  
		    	  
		    	  
		    			}
		         

		          
		                        }


	}}
	
	
	


