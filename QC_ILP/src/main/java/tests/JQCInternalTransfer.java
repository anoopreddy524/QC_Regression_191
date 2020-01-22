package tests;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCInternalTransfer extends QCStore {

	public static void InternalTransfer(String SSN,String AppURL)
	{
		try{
			int lastrow=TestData.getLastRow((prop.getProperty("Deposit")));
			String sheetName=prop.getProperty("Deposit");
			System.out.println("...."+sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				String Action = TestData.getCellData(sheetName,"Action",row);
				String CountofDollarCoins = TestData.getCellData(sheetName,"CountofDollarCoins",row);
				String CheckNbr = TestData.getCellData(sheetName,"CheckNbr",row);
				String BankerPIN= TestData.getCellData(sheetName,"PIN",row);
				System.out.println("...."+RegSSN);
				if(SSN.equals(RegSSN))
				{		       

					Thread.sleep(4000);
					test.log(LogStatus.INFO, "InternalTransfer from CSR has initiated");			
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
					test.log(LogStatus.PASS, " Click on safe menu");
					Thread.sleep(2000);
					driver.findElement(locator(prop.getProperty("Internal_Transfer"))).click();
					test.log(LogStatus.PASS, " click on Internal_Transfer menu");
					Thread.sleep(2000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(locator(prop.getProperty("Internal_Transfet_Action"))).sendKeys(Action);
					driver.findElement(locator(prop.getProperty("Count_Coins"))).sendKeys(CountofDollarCoins);
					String check_Nbr=driver.findElement(locator(prop.getProperty("Internal_check_Nbr"))).getText();
					System.out.println("******"+check_Nbr);
					test.log(LogStatus.INFO, "Check number is "+check_Nbr);
					if(check_Nbr.toLowerCase().trim().equalsIgnoreCase(CheckNbr.toLowerCase().trim()))
					{
						driver.findElement(locator(prop.getProperty("Internal_select"))).click();
						driver.findElement(locator(prop.getProperty("Internal_Banker_Pin"))).sendKeys(BankerPIN);
						driver.findElement(locator(prop.getProperty("Internal_transfer"))).click();
						test.log(LogStatus.PASS, " Internal_transfer from CSR is successfull");
						if(driver.findElement(locator(prop.getProperty("Internal_ok"))).isDisplayed())
						{
							test.log(LogStatus.PASS, " Internal from CSR is successfull");
							test.log(LogStatus.PASS, "********************************************** ");
						}
					}

					break;
				}						
			}




		}catch(Exception e){
			e.printStackTrace();
			test.log(LogStatus.FAIL, "InternalTransfer from CSR is failed");

		}


	}
}
