package tests;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class JQCRescind extends QCStore {
	
	public static void Rescind(String SSN,String AppURL) throws Exception
	{
		/*try{*/
			int lastrow=TestData.getLastRow((Aprop.getProperty("Rescind")));
			String sheetName=Aprop.getProperty("Rescind");
			System.out.println("...."+sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				
				System.out.println("...."+RegSSN);
				if(SSN.equals(RegSSN))
				{
					
				String Scenario = TestData.getCellData(sheetName,"Scenario",row);
				String TxnType = TestData.getCellData(sheetName,"TxnType",row);
				String PIN = TestData.getCellData(sheetName,"PIN#",row);
				
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
		       	      
		        String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
		        System.out.println(columnname);
		       
		       String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					 
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        		       
				
		       Thread.sleep(4000);
				test.log(LogStatus.INFO, "Rescind from CSR has initiated");
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
				Thread.sleep(2000);
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button under search results");
				Thread.sleep(1000);		    

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    
				     String loan_nbr= driver.findElement(locator(Aprop.getProperty("loan_nbr"))).getText();
					 test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
					 
					 if(Scenario.equalsIgnoreCase("Rescind"))
					 {
					 Thread.sleep(1000);	
					 driver.findElement(locator(Aprop.getProperty("transactionList"))).sendKeys(TxnType);
					 test.log(LogStatus.PASS, "Transaction type is selected as" +TxnType);
					 Thread.sleep(1000);	
					 driver.findElement(By.xpath("//input[@value='Go' and @name='button']")).click();
					 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
					 Thread.sleep(8000);
							 
						
							 driver.findElement(locator(Aprop.getProperty("Refinance_tenderType"))).sendKeys(TenderType);
							 test.log(LogStatus.PASS, "Tender type is entered as "+TenderType);
							 driver.findElement(locator(Aprop.getProperty("Refinance_tenderAmt"))).sendKeys(LOCamount);
							 test.log(LogStatus.PASS, "Tender Amt is entered as "+LOCamount);
							 driver.findElement(locator(Aprop.getProperty("Rescind_PIN"))).sendKeys(PIN);
							 test.log(LogStatus.PASS, "Password is selected as "+PIN);
							 driver.findElement(locator(Aprop.getProperty("Rescind_finish"))).click();
							 test.log(LogStatus.PASS, "Clicked on Rescind Loan button ");
							 try { 
								    Alert alert = driver.switchTo().alert();
								    alert.accept();
								    //if alert present, accept and move on.															
								}
								catch (NoAlertPresentException e) {
								    //do what you normally would if you didn't have the alert.
								}
							 Thread.sleep(2000);
							 
							 if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr/td/b")).getText().contains("successfully"))
								{
							 						
								 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Rescind is  Completed successfully");
								 driver.findElement(By.xpath("//input[@value='Ok' and @class='sortbuttons']")).click();
															 
								}else
								{
									test.log(LogStatus.INFO, "<FONT color=green style=Arial> Rescind is  Completed Successfully ");
								}
 	
					 }
					 else if(Scenario.equalsIgnoreCase("After Rescind"))
					 {
						 String loan_status= driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]")).getText();
						 test.log(LogStatus.PASS, "Loan Status is " + loan_status);
						 Select tList = new Select(driver.findElement(By.name("transactionList")));
						 List<WebElement> ele=tList.getOptions();
						 for(int i=0;i<ele.size();i++){
							 
							 String drop_down_values=ele.get(i).getText();
							 if(!drop_down_values.equals("Rescind")){
								 
								 test.log(LogStatus.INFO,"dropdown values are "+drop_down_values);				 
							 }else{
									test.log(LogStatus.INFO, "<FONT color=red style=Arial> After Rescind Days is  Completed Successfully ");
								}
							 
							 }
						 if(loan_status.equalsIgnoreCase("Open")){
						 test.log(LogStatus.PASS, "<FONT color=green style=Arial> After Rescind Days is  Completed successfully");
						 
						 Thread.sleep(5000);
						 
						 driver.quit();
						 
						 }
					}
						//break;
				}
				
				 
			}
			
		/*}catch(Exception e){
						e.printStackTrace();
						test.log(LogStatus.FAIL, "Rescind from CSR is failed");

		}*/
			
		
	}

}
