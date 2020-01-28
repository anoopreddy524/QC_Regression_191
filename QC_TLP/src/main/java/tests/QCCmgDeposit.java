package tests;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import com.relevantcodes.extentreports.LogStatus;

public class QCCmgDeposit extends QCStore {
	public static void CmgDeposit(String SSN,String AppURL)
	{
		try{
			int lastrow=TestData.getLastRow((prop.getProperty("Deposit")));
			String sheetName=prop.getProperty("Deposit");
			System.out.println("...."+sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				
				System.out.println("...."+RegSSN);
				if(SSN.equals(RegSSN))
				{
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				String CheckNbr = TestData.getCellData(sheetName,"CheckNbr",row);
		    
		       Thread.sleep(4000);
				test.log(LogStatus.INFO, "CmgDeposit from CSR has initiated");
				for(String winHandle1 : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle1);
					}				    
				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(prop.getProperty("cash_management"))).click();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				Actions action = new Actions(driver);  
				WebElement safe=driver.findElement(locator(prop.getProperty("safe")));
				action.moveToElement(safe).build().perform();
				test.log(LogStatus.PASS, " Mouse hover on safe menu");
				Thread.sleep(3000);
				driver.findElement(locator(prop.getProperty("CmgDeposite"))).click();
				test.log(LogStatus.PASS, " click on CmgDeposite menu");
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				String check_Nbr=driver.findElement(locator(prop.getProperty("cmg_checkNbr"))).getText();
				System.out.println("******"+check_Nbr);
				test.log(LogStatus.INFO, "Check number is "+check_Nbr);
				if(check_Nbr.toLowerCase().trim().equalsIgnoreCase(CheckNbr.toLowerCase().trim()))
				{
				driver.findElement(locator(prop.getProperty("CmgDeposite_select"))).click();
				test.log(LogStatus.PASS, " click on CmgDeposite_select menu");
				driver.findElement(locator(prop.getProperty("cmgDeposite_pin"))).sendKeys(PIN);
				test.log(LogStatus.PASS, "Enter cmgDeposite_pin menu");
				driver.findElement(locator(prop.getProperty("cmgFinishDeposite"))).click();
				test.log(LogStatus.PASS, " click on cmg Finish Deposite button");
				driver.findElement(locator(prop.getProperty("cmgFinishDeposite"))).click();
				test.log(LogStatus.PASS, " click on cash Management Finish Deposite through CSR Successfull");
				if(driver.findElement(locator(prop.getProperty("cmgSuccess"))).isDisplayed())
				{
					test.log(LogStatus.PASS, " cash Management Deposite from CSR is successfull");
					test.log(LogStatus.PASS, "********************************************** ");
				}
				}
				break;
				}
				
				 
			}
			
		}catch(Exception e){
						e.printStackTrace();
						test.log(LogStatus.FAIL, "Check Cmg Deposite from CSR is failed");

		}
			
		
	}
}
