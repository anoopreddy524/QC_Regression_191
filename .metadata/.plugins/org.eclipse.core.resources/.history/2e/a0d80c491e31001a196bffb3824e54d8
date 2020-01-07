package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class QCDepositMenu extends QCStore{
	public static void depositMenu(String SSN,String AppURL) throws Exception
	{
		int i;
		for(i=0;i<3;i++)
		{
			
			driver.get(prop.getProperty("login_page"));  
		try{
			//String FileName= prop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Deposit");
				String sheetName="Deposit";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
					
			        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			    
			       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
			       String RepresentmentType = TestData.getCellData(sheetName,"RepresentmentType",row);
						   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
				
			       Thread.sleep(4000);
					//test.log(LogStatus.INFO, MarkupHelper.createLabel("Deposit from CSR has initiated", ExtentColor.BLUE));
					test.log(LogStatus.INFO, "Deposit from CSR has initiated");

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
					/*driver.switchTo().defaultContent();				
					driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();	*/		
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
				    
				    
				  // String loan_nbr= driver.findElement(locator(prop.getProperty("csr_loan_nbr"))).getText();
				  // test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
					// driver.findElement(By.name("button")).click();
					
				for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					   // driver.findElement(By.name("button")).click();
					    
					  if(ProductID.equals("PDL"))
						 {
					    driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
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
						
							
							// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Transactions')]")));
						    // driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();	
							// test.log(LogStatus.PASS, "Clicked on Transactions");
				
								//driver.switchTo().defaultContent();
								//driver.switchTo().frame("mainFrame");
								
							
							if(ESign_CollateralType.equalsIgnoreCase("ACH"))
							{
								 driver.findElement(By.linkText("ACH")).click();
								 Thread.sleep(2000);
								 test.log(LogStatus.PASS, "Clicked on ACH");
								 driver.findElement(locator(prop.getProperty("deposit_ach_pdl"))).click();
							 test.log(LogStatus.PASS, "Clicked on PayDay Loan");
							 Thread.sleep(2000);
							 driver.findElement(locator(prop.getProperty("deposit_ach_pdl_ach_deposit"))).click();
							 test.log(LogStatus.PASS, "Clicked on ACH deposit");
							 Thread.sleep(2000);
							 
							 driver.switchTo().defaultContent();
							    driver.switchTo().frame("mainFrame");
							    driver.switchTo().frame("main");
							 driver.findElement(locator(prop.getProperty("deposit_loan_nbr"))).sendKeys(loan_nbr);
							 test.log(LogStatus.PASS, "Entered Loan number as "+ loan_nbr);
							 driver.findElement(locator(prop.getProperty("deposit_submit_btn"))).click();
							 test.log(LogStatus.PASS, "Clicked on Submit button ");
							 driver.findElement(locator(prop.getProperty("deposit_check_box"))).click();
							 test.log(LogStatus.PASS, "Selected the radio button ");
							 driver.findElement(locator(prop.getProperty("finish_ach_deposit"))).click();
							 test.log(LogStatus.PASS, "Clicked on  "+ESign_CollateralType+"Deposit button");
								//test.log(LogStatus.PASS, MarkupHelper.createLabel(ESign_CollateralType+" Deposit from CSR is successfull", ExtentColor.GREEN));
								test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
								test.log(LogStatus.PASS, "********************************************** ");

							}
							
							if(ESign_CollateralType.equalsIgnoreCase("CHECK"))
							{
								Actions action = new Actions(driver);  
								 WebElement collateral=driver.findElement(locator(prop.getProperty("deposite_collateral_check")));
								 action.moveToElement(collateral).build().perform();
								 test.log(LogStatus.PASS, " Mouse hover on collateral check menu");
								 Thread.sleep(2000);
								 WebElement pdl=driver.findElement(locator(prop.getProperty("deposite_menu_pdl")));
								 action.moveToElement(pdl).build().perform();
								 test.log(LogStatus.PASS, " Mouse hover on payday loan menu");
								 Thread.sleep(5000);
								 driver.findElement(locator(prop.getProperty("menu_deposite"))).click();
								 test.log(LogStatus.PASS, " click on deposite menu");
								 Thread.sleep(2000);
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 driver.findElement(locator(prop.getProperty("deposite_menu_loannbr"))).sendKeys(loan_nbr);
								 driver.findElement(locator(prop.getProperty("deposite_menu_submit"))).click();
								 test.log(LogStatus.PASS, "Clicked on submit button");
								 driver.findElement(locator(prop.getProperty("deposit_check_box"))).click();
								 driver.findElement(locator(prop.getProperty("deposite_menu_check_dropdown"))).sendKeys(RepresentmentType);
								 driver.findElement(locator(prop.getProperty("finish_ach_deposit"))).click();
								 test.log(LogStatus.PASS, "Clicked on  "+ESign_CollateralType+"Deposit button");
								 test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
								 test.log(LogStatus.PASS, "********************************************** ");

							}
							if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
							{
								 driver.findElement(By.linkText("Collateral Checks")).click();
								 Thread.sleep(2000);
								 test.log(LogStatus.PASS, "Clicked on Collateral Checks");
								 driver.findElement(locator(prop.getProperty("deposit_check_pdl"))).click();
							 test.log(LogStatus.PASS, "Clicked on PayDay Loan");
							 Thread.sleep(2000);
							 driver.findElement(locator(prop.getProperty("deposit_check_pdl_check_deposit"))).click();
							 test.log(LogStatus.PASS, "Clicked on deposit");
							 Thread.sleep(2000);
							 
							 driver.switchTo().defaultContent();
							    driver.switchTo().frame("mainFrame");
							    driver.switchTo().frame("main");
							 driver.findElement(locator(prop.getProperty("deposit_loan_nbr"))).sendKeys(loan_nbr);
							 test.log(LogStatus.PASS, "Entered Loan number as "+ loan_nbr);
							 driver.findElement(locator(prop.getProperty("deposit_submit_btn"))).click();
							 test.log(LogStatus.PASS, "Clicked on Submit button ");
							 driver.findElement(locator(prop.getProperty("deposit_check_box"))).click();
							 test.log(LogStatus.PASS, "Selected the radio button ");
							 driver.findElement(locator(prop.getProperty("finish_ach_deposit"))).click();
							 test.log(LogStatus.PASS, "Clicked on  "+ESign_CollateralType+"Deposit button");
								//test.log(LogStatus.PASS, MarkupHelper.createLabel(ESign_CollateralType+" Deposit from CSR is successfull", ExtentColor.GREEN));
								test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
								test.log(LogStatus.PASS, "********************************************** ");

							}
						 
						 
						 break;
						 
					}
				}
				break;
}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Deposit from CSR is failed", ExtentColor.RED));
			test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
			String screenshotPath = getScreenhot(driver, "Exception");
							test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "Deposit Menu from CSR is intiated again due to Application sync issue");
			continue;


		}




}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "Deposit Menu is failed");
	
		}

	}
}



