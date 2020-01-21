package tests;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;
public class JCSRMidDayDeposit extends QCStore {
	public static String Duedate;
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

		driver.switchTo().frame("topFrame");
		driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
		test.log(LogStatus.PASS, "Clicked on Cash Management");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.xpath("//*[@id='932000']/a")).click();	
		test.log(LogStatus.PASS, "Clicked on Safe button");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='932050']/a")).click();	
		test.log(LogStatus.PASS, "Clicked on Deposit button");
		Thread.sleep(3000);
		driver.switchTo().frame("main");
		WebElement e= driver.findElement(By.name("safeDepositRequestBean.noOfDollars"));
		e.click();
		e.sendKeys("0");
		test.log(LogStatus.PASS, "Enterd count of dollar coins :"+"0");
		test.log(LogStatus.INFO, "ESign_CollateralType "+ESign_CollateralType);
		//String NextDueDate="05/06/2019";
		test.log(LogStatus.PASS, "Next Duedate is "+NextDueDate);
		
		if(ESign_CollateralType.equalsIgnoreCase("ACH"))
		{
		
		List<WebElement>  rows = driver.findElements(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr")); 

		int n=rows.size();
		
		for(int i=5;i<=n;i++){
									
			try{
			 Duedate=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[4]")).getText();
			test.log(LogStatus.PASS, "Getting check number for the check box to check condition"+Duedate);
			}
			catch(Exception e5){
				continue;
			}
			
			test.log(LogStatus.PASS, "Next DueDate is "+NextDueDate);
			Thread.sleep(3000);	
			
			if(Duedate.contains(NextDueDate)){

				test.log(LogStatus.PASS, "name condition satisfied ");				
				WebElement e4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[6]/input"));			
				e4.click();
				test.log(LogStatus.PASS, "Clicked on check box ");
				
				driver.findElement(By.name("safeDepositRequestBean.password")).sendKeys(Password);
				test.log(LogStatus.PASS, "password enterd as :"+Password);

				driver.findElement(By.name("finishdeposit")).click();
				test.log(LogStatus.PASS, "Clicked on Finish button in safe deposit page");
				Thread.sleep(500);	
				try { 
				    Alert alert = driver.switchTo().alert();
				
				    alert.accept();
				    //if alert present, accept and move on.														
					
				}
				catch (Exception ele) {
				    //do what you normally would if you didn't have the alert.
				}
				Thread.sleep(3000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				
				driver.findElement(By.name("finishdeposit")).click();
				test.log(LogStatus.PASS, "Clicked on Finish button in deposit  verification page");
				
			}
		
		}
		Thread.sleep(4000);
		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");*/
		if(driver.findElement(By.xpath("//p[contains(text(),'successfully')]")).isDisplayed())
		{	
			
			driver.findElement(By.xpath("//input[@value='Ok' and @type='submit']")).click();
			test.log(LogStatus.PASS, "Dispalying ok button condition satisfied");   
			test.log(LogStatus.PASS, ESign_CollateralType+" Mid day deposit completed successfully");
			test.log(LogStatus.PASS, "********************************************** ");

			break;
			}
		else
		{
			test.log(LogStatus.INFO, "Dispalying ok button condition satisfied");   
			test.log(LogStatus.PASS, ESign_CollateralType+" Mid day deposit completed successfully");

		}
		}
		else if(ESign_CollateralType.equalsIgnoreCase("CHECK"))
		{
			List<WebElement>  rows = driver.findElements(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr")); 
			
			int n=rows.size();
			
			for(int i=4;i<=n;i++){
				try{
				 Duedate=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[4]")).getText();
				test.log(LogStatus.PASS, "Getting check number for the check box to check condition "+Duedate);	
			}
			catch(Exception e5){
				continue;
			}
				test.log(LogStatus.PASS, "Next Duedate is "+NextDueDate);
				Thread.sleep(3000);	
				if(Duedate.contains(NextDueDate)){

					test.log(LogStatus.PASS, "name condition satisfied ");
					WebElement e4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[6]/input"));			
					e4.click();
					test.log(LogStatus.PASS, "Clicked on check box ");

					WebElement e1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/select"));
																
					Select dropdown = new Select(e1);
					dropdown.selectByVisibleText("Manual");
					test.log(LogStatus.PASS, "Select deposit type as Manual");

					driver.findElement(By.name("safeDepositRequestBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "password enterd as :"+Password);

					driver.findElement(By.name("finishdeposit")).click();
					test.log(LogStatus.PASS, "Clicked on Finish button in safe deposit page");
					try { 
					    Alert alert = driver.switchTo().alert();
					
					    alert.accept();
					    //if alert present, accept and move on.														
						
					}
					catch (Exception ele) {
					    //do what you normally would if you didn't have the alert.
					}
					Thread.sleep(1000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					
					driver.findElement(By.name("finishdeposit")).click();
					test.log(LogStatus.PASS, "Clicked on Finish button in deposit  verification page");
					
				}	
			}
			Thread.sleep(4000);
			/*driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");*/
			if(driver.findElement(By.xpath("//p[contains(text(),'successfully')]")).isDisplayed())
			{	
				
				driver.findElement(By.xpath("//input[@value='Ok' and @type='submit']")).click();
				test.log(LogStatus.PASS, "<FONT color=green style=Arial>Dispalying ok button condition satisfied");   
				test.log(LogStatus.PASS, "<FONT color=green style=Arial>"+ESign_CollateralType+" Mid day deposit completed successfully");
				break;
			}
			else
			{
				test.log(LogStatus.INFO, "Dispalying ok button condition satisfied");   
				test.log(LogStatus.PASS, "<FONT color=green style=Arial>"+ESign_CollateralType+" Mid day deposit completed successfully");

			}
			
		}break;
				}
			
			}

	}}
