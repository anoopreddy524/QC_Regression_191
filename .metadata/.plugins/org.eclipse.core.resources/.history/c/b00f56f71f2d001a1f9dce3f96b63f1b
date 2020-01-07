package tests;



import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import com.relevantcodes.extentreports.LogStatus;

public class JQCCmgDeposit extends QCStore {
	public static void CmgDeposit(String SSN,String AppURL) throws Exception
	{
			int lastrow=TestData.getLastRow((Jprop.getProperty("Deposit")));
			String sheetName=Jprop.getProperty("Deposit");
			System.out.println("...."+sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				
				System.out.println("...."+RegSSN);
				if(SSN.equals(RegSSN))
				{
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				String CheckNbr = TestData.getCellData(sheetName,"CheckNbr",row);
		    
		       Thread.sleep(1000);
				test.log(LogStatus.INFO, "CmgDeposit from CSR has initiated");
				for(String winHandle1 : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle1);
					}				    
				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Jprop.getProperty("cash_management"))).click();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				Actions action = new Actions(driver);  
				WebElement safe=driver.findElement(locator(Jprop.getProperty("safe")));
				action.moveToElement(safe).build().perform();
				test.log(LogStatus.PASS, " Mouse hover on safe menu");
				Thread.sleep(2000);
				driver.findElement(locator(Jprop.getProperty("CmgDeposite"))).click();
				test.log(LogStatus.PASS, " click on CmgDeposite menu");
				Thread.sleep(4000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				
				List<WebElement>  rows = driver.findElements(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr")); 
				int n=rows.size();
				
				for(int i=4;i<=n;i++){

					String check_Nbr=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
					test.log(LogStatus.PASS, "Getting check number for the check box to check condition "+check_Nbr);				
					test.log(LogStatus.PASS, "Check number is "+CheckNbr);
					Thread.sleep(2500);	
					
					if(check_Nbr.contains(CheckNbr)){
						
					WebElement e4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/input"));			
					e4.click();
					test.log(LogStatus.PASS, "Clicked on check box ");
				test.log(LogStatus.PASS, " click on CmgDeposite_select menu");
				driver.findElement(locator(Jprop.getProperty("cmgDeposite_pin"))).sendKeys(PIN);
				test.log(LogStatus.PASS, "Enter cmgDeposite_pin menu");
				driver.findElement(locator(Jprop.getProperty("cmgFinishDeposit"))).click();
				test.log(LogStatus.PASS, " click on cmg Finish Deposite button");
				Thread.sleep(9000);
				try { 
				    Alert alert = driver.switchTo().alert();
				    alert.accept();
															
					
				}
				catch (NoAlertPresentException e) {
				    //do what you normally would if you didn't have the alert.
				}
				Thread.sleep(2000);
				driver.findElement(locator(Jprop.getProperty("cmgFinishDeposit"))).click();
				test.log(LogStatus.PASS, " click on cash Management Finish Deposite through CSR Successfull");
				if(driver.findElement(locator(Jprop.getProperty("cmgSuccess"))).isDisplayed())
				{
					test.log(LogStatus.PASS, " cash Management Deposite from CSR is successfull");
					test.log(LogStatus.PASS, "********************************************** ");
					break;
				}else{
					test.log(LogStatus.INFO, " cash Management Deposite from CSR is successfull");
					test.log(LogStatus.PASS, "********************************************** ");
				}
			}
		
		}			
				break;
				}
				
				}
	}
}
