package tests;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCInternalTransfer extends QCStore {

	public static void InternalTransfer(String SSN,String AppURL) throws InterruptedException
	{
		
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
					driver.findElement(locator(prop.getProperty("Internal_Transfer_Action"))).sendKeys(Action);
					test.log(LogStatus.PASS, "Select the Internal_Transfer_Action  is"+Action);
					driver.findElement(locator(prop.getProperty("Count_Coins"))).sendKeys(CountofDollarCoins);
					test.log(LogStatus.PASS, "Enter the CountofDollarCoins "+CountofDollarCoins);
					Thread.sleep(2000);
					List<WebElement>  rows = driver.findElements(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table[1]/tbody/tr[9]/td/table/tbody/tr")); 
					int n=rows.size();
					
					for(int i=2;i<=n;i++){
																	
						String check_Nbr=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table[1]/tbody/tr[9]/td/table/tbody/tr["+i+"]/td[1]")).getText();
						test.log(LogStatus.PASS, "Getting check number for the check box to check condition"+check_Nbr);
						
						test.log(LogStatus.PASS, "Next Due Date is"+NextDueDate);
						Thread.sleep(3000);		
						if(check_Nbr.contains(CheckNbr)){

							test.log(LogStatus.PASS, "name condition satisfied ");
							WebElement e4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table[1]/tbody/tr[9]/td/table/tbody/tr["+i+"]/td[3]/input"));										
							e4.click();
							test.log(LogStatus.PASS, "Clicked on check box ");
							driver.findElement(locator(prop.getProperty("Internal_Banker_Pin"))).sendKeys(BankerPIN);
							test.log(LogStatus.PASS, "Enter Banker PIN is "+BankerPIN);
							driver.findElement(locator(prop.getProperty("Internal_transfer"))).click();
							test.log(LogStatus.PASS, " Click on Internal_transfer button");
						if(driver.findElement(locator(prop.getProperty("Internal_ok"))).isDisplayed())
						{
							driver.findElement(locator(prop.getProperty("Internal_ok"))).click();
							test.log(LogStatus.PASS, " Internal from CSR is successfull");
							test.log(LogStatus.PASS, "********************************************** ");
							driver.close();
							break;
						}else{
							Thread.sleep(100);
							test.log(LogStatus.PASS, " Internal from CSR is successfull");
							test.log(LogStatus.PASS, "********************************************** ");
							driver.close();	
							break;
						}
						}
					}

					break;
				}						
			}




		


	}
}
