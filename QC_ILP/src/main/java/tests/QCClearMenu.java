package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class QCClearMenu extends QCStore {
	public static void clearMenu(String SSN,String AppURL) throws Exception
	{
		try{
			int lastrow=TestData.getLastRow("Clear");
			String sheetName="Clear";
			System.out.println("...."+sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
		
				if(SSN.equals(RegSSN))
				{
				
				String PIN = TestData.getCellData(sheetName,"PIN#",row);
		
		    
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		         String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
		       
					   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				     
		       Thread.sleep(4000);
				test.log(LogStatus.INFO, "Clear through Menu  from CSR has initiated");
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

			    String loan_nbr= driver.findElement(locator(prop.getProperty("loan_nbr"))).getText();
				test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
				
			for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}				    
				 	driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
				    
				  if(ProductID.equals(prop.getProperty("ILP")))
					 {
					  driver.findElement(locator(prop.getProperty("clear_go"))).click();				   
					  test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    }
				   
				    Thread.sleep(5000);
				   
					   driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
					
						Thread.sleep(2000);
						if(ESign_CollateralType.equalsIgnoreCase("CHECK"))
						{
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							Thread.sleep(1500);
							driver.findElement(By.linkText("Collateral Checks")).click();
							test.log(LogStatus.PASS, "Clicked on Collateral Checks link");
							driver.switchTo().defaultContent();

							driver.switchTo().frame("mainFrame");
							Thread.sleep(2500);
							driver.findElement(By.linkText("Installment Loan")).click();

							test.log(LogStatus.PASS, "Clicked on Installment Loan");

							driver.switchTo().defaultContent();

							driver.switchTo().frame("mainFrame");

							Thread.sleep(1500);

							driver.findElement(By.linkText("Clear")).click();

							 test.log(LogStatus.PASS, " click on clear menu");
							 Thread.sleep(2000);
							 Actions action = new Actions(driver);
								action.moveByOffset(200,100).perform();
								Thread.sleep(10000);
								action.click();
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 driver.findElement(locator(prop.getProperty("deposite_menu_loannbr"))).sendKeys(loan_nbr);
							 driver.findElement(By.name("submit")).click();
							 test.log(LogStatus.PASS, "Clicked on submit button");
							 driver.findElement(locator(prop.getProperty("deposit_check_box"))).click();
							 driver.findElement(locator(prop.getProperty("finish_ach_deposit"))).click();
							 test.log(LogStatus.PASS, "Clicked on  "+ESign_CollateralType+" Clear button");
							 test.log(LogStatus.PASS, ESign_CollateralType+" Clear menu from CSR is successfull");
							 test.log(LogStatus.PASS, "********************************************** ");
							} 
						else if(ESign_CollateralType.equalsIgnoreCase("ACH"))
						{
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							Thread.sleep(1500);
							driver.findElement(By.linkText("ACH")).click();
							test.log(LogStatus.PASS, "Clicked on ACH link");
							driver.switchTo().defaultContent();

							driver.switchTo().frame("mainFrame");
							Thread.sleep(2500);
							driver.findElement(By.linkText("Installment Loan")).click();

							test.log(LogStatus.PASS, "Clicked on Installment Loan");

							driver.switchTo().defaultContent();

							driver.switchTo().frame("mainFrame");

							Thread.sleep(1500);

							driver.findElement(By.linkText("ACH Clear")).click();

							 test.log(LogStatus.PASS, " Clicked on clear menu");
							 Actions action = new Actions(driver);
								action.moveByOffset(200,100).perform();
								Thread.sleep(10000);
								action.click();
							 Thread.sleep(2000);
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 driver.findElement(locator(prop.getProperty("deposite_menu_loannbr"))).sendKeys(loan_nbr);
							 driver.findElement(By.name("submit")).click();
							 test.log(LogStatus.PASS, "Clicked on submit button");
							 driver.findElement(locator(prop.getProperty("deposit_check_box"))).click();
							 driver.findElement(locator(prop.getProperty("finish_ach_deposit"))).click();
							 test.log(LogStatus.PASS, "Clicked on  "+ESign_CollateralType+" Clear button");
							 test.log(LogStatus.PASS, ESign_CollateralType+" Clear menu from CSR is successfull");
							 test.log(LogStatus.PASS, "********************************************** ");
							}
						break;
				}
				
				 
			}
			
		}catch(Exception e){
			test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
			String screenshotPath = getScreenhot(driver, "Exception");
							test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
						test.log(LogStatus.FAIL, "Check Clear from CSR is failed");

		}
			
		
	}


}
