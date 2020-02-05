package tests;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class SCSRMidDayDeposit extends QCStore {

	public static void middeposit(String SSN,String AppURL) throws InterruptedException{
		
			int lastrow=TestData.getLastRow("MidDeposit");
			String sheetName="MidDeposit";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				
				if(SSN.equals(RegSSN))
				{
				
				String Password = TestData.getCellData(sheetName,"PIN",row);
		  
		       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);

		test.log(LogStatus.INFO, "****Performing Mid day deposit scenario******");
		Thread.sleep(2000);
		driver.switchTo().frame("topFrame");
		driver.findElement(By.linkText("Cash Management")).click();
		//driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
		test.log(LogStatus.PASS, "Clicked on Cash Management");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		//driver.findElement(By.xpath("//*[@id='932000']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Safe")).click();
		test.log(LogStatus.PASS, "Clicked on Safe button");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='932050']/a")).click();
		driver.findElement(By.linkText("Deposit")).click();
		test.log(LogStatus.PASS, "Clicked on Deposit button");
		Thread.sleep(3000);
		driver.switchTo().frame("main");
		WebElement e= driver.findElement(By.name("safeDepositRequestBean.noOfDollars"));
		e.click();
		e.sendKeys("0");
		test.log(LogStatus.PASS, "Enterd count of dollar coins :"+"0");
		test.log(LogStatus.INFO, "ESign_CollateralType "+ESign_CollateralType);
		
		if(ESign_CollateralType.equalsIgnoreCase("ACH"))
		{
		
		List<WebElement>  rows = driver.findElements(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr")); 

		int n=rows.size();
		
		for(int i=0;i<=(n+1);i++){

				test.log(LogStatus.PASS, "name condition satisfied ");
				try{
					WebElement e4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/input"));e4.click();
					test.log(LogStatus.PASS, "Clicked on check box ");
				}
				catch(Exception e1)
				{
					continue;
				}
			
		}
				driver.findElement(By.name("safeDepositRequestBean.password")).sendKeys(Password);
				test.log(LogStatus.PASS, "password enterd as :"+Password);
				
				
				Thread.sleep(2000);
				
				driver.findElement(By.name("finishdeposit")).click();
				test.log(LogStatus.PASS, "Clicked on Finish button in safe deposit page");
                
				Thread.sleep(2000);
				
				try { 
				    Alert alert = driver.switchTo().alert();
				
				    alert.accept();
				    //if alert present, accept and move on.														
					
				}
				catch (Exception e5) {
				    //do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(3000);
				
				driver.findElement(By.name("finishdeposit")).click();
				test.log(LogStatus.PASS, "Clicked on Finish button in deposit  verification page");
					
			/*}*/			
		/*}*/
		Thread.sleep(6000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");
		if(driver.findElement(By.xpath("//input[@type='submit'and@value='Ok']")).isDisplayed())
		{	
			driver.findElement(By.xpath("//input[@type='submit'and@value='Ok']")).click();
			test.log(LogStatus.PASS, "Dispalying ok button condition satisfied");   
			test.log(LogStatus.PASS, ESign_CollateralType+"<FONT color=green style=Calibri> Mid day deposit completed successfully");
			test.log(LogStatus.PASS, "********************************************** ");
			break;

		}
		else
		{
			test.log(LogStatus.INFO, "Dispalying ok button condition not satisfied");   
			test.log(LogStatus.FAIL, ESign_CollateralType+"<FONT color=Red style=Calibri> Mid day deposit is failed");
			test.log(LogStatus.FAIL, "********************************************** ");

		}
		}
		
		if(ESign_CollateralType.equalsIgnoreCase("Debit Card"))
		{
			List<WebElement>  rows = driver.findElements(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr")); 
			
			int n=rows.size();
			
			for(int i=0;i<=(n+1);i++){
				

					test.log(LogStatus.PASS, "name condition satisfied ");
					try{
					WebElement e4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/input"));
					e4.click();
					test.log(LogStatus.PASS, "Clicked on check box ");
					}
					catch(Exception e1)
					{
						continue;
					}
				
			}
					driver.findElement(By.name("safeDepositRequestBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "password enterd as :"+Password);

					driver.findElement(By.name("finishdeposit")).click();
					test.log(LogStatus.PASS, "Clicked on Finish button in safe deposit page");
					
					Thread.sleep(2000);
					
					try { 
					    Alert alert = driver.switchTo().alert();
					
					    alert.accept();
					    //if alert present, accept and move on.														
						
					}
					catch (Exception e5) {
					    //do what you normally would if you didn't have the alert.
					}
					
					
					
					Thread.sleep(3000);
					driver.findElement(By.name("finishdeposit")).click();
					test.log(LogStatus.PASS, "Clicked on Finish button in deposit  verification page");
						
				}			
			}else{
				continue;
			}
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			if(driver.findElement(By.xpath("//input[@type='submit'and@value='Ok']")).isDisplayed())
			{	
				driver.findElement(By.xpath("//input[@type='submit'and@value='Ok']")).click();
				test.log(LogStatus.PASS, "Dispalying ok button condition satisfied");   
				test.log(LogStatus.PASS, ESign_CollateralType+" <FONT color=green style=Calibri>Mid day deposit completed successfully");
				test.log(LogStatus.PASS, "********************************************** ");
				break;

			}
			else
			{
				test.log(LogStatus.INFO, "Dispalying ok button condition not satisfied");   
				test.log(LogStatus.FAIL, ESign_CollateralType+"<FONT color=Red style=Calibri> Mid day deposit is failed");
				test.log(LogStatus.FAIL, "********************************************** ");

			}
			}
				}
			
		
	}
