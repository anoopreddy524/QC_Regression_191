package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCACHReturn extends QCStore {
	
	public static void ACHReturn(String SSN,String AppURL)
	{
		try{
			int lastrow=TestData.getLastRow((prop.getProperty("ACHReturn")));
			String sheetName=prop.getProperty("ACHReturn");
			System.out.println("...."+sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				String Return_For_Reason = TestData.getCellData(sheetName,"Return_For_Reason",row);
				System.out.println("...."+RegSSN);
				if(SSN.equals(RegSSN))
				{
				
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		       	        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				       		       
				
		       Thread.sleep(4000);
				test.log(LogStatus.INFO, "ACH Return from CSR has initiated");
				driver.switchTo().frame("bottom");
				String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
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
					  driver.findElement(locator(prop.getProperty("clear_go"))).click();
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
				     String loan_nbr= driver.findElement(locator(prop.getProperty("csr_loan_nbr"))).getText();
					  test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
					   driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");

						Thread.sleep(2000);
		
							Actions action = new Actions(driver);  
							 WebElement collateral=driver.findElement(locator(prop.getProperty("ACH")));
							 action.moveToElement(collateral).build().perform();
							 test.log(LogStatus.PASS, " Mouse hover on ACH menu");
							 Thread.sleep(2000);
							 WebElement pdl=driver.findElement(locator(prop.getProperty("deposit_ach_pdl")));
							 action.moveToElement(pdl).build().perform();
							 test.log(LogStatus.PASS, " Mouse hover on payday loan menu");
							 Thread.sleep(3000);
							 driver.findElement(locator(prop.getProperty("ACH_Return"))).click();
							 test.log(LogStatus.PASS, " click on clear menu");
							 Thread.sleep(2000);
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 driver.findElement(locator(prop.getProperty("deposite_menu_loannbr"))).sendKeys(loan_nbr);
							 driver.findElement(locator(prop.getProperty("ACH_submit"))).click();
							 test.log(LogStatus.PASS, "Clicked on submit button");
							 driver.findElement(locator(prop.getProperty("deposit_check_box"))).click();
							 driver.findElement(locator(prop.getProperty("ACH_Return_reason"))).sendKeys(Return_For_Reason);
							 driver.findElement(locator(prop.getProperty("finish_ach_deposit"))).click();
							 test.log(LogStatus.PASS, "Clicked on  ACH Return button");
							 if(driver.findElement(locator(prop.getProperty("ACH_Return_success"))).isDisplayed()){
							 test.log(LogStatus.PASS, " ACH Return menu from CSR is successfull");
							 test.log(LogStatus.PASS, "********************************************** ");
							 }
						break;
				}
				
				 
			}
			
		}catch(Exception e){
						e.printStackTrace();
						test.log(LogStatus.FAIL, "ACH Return from CSR is failed");

		}
			
		
	}

}
