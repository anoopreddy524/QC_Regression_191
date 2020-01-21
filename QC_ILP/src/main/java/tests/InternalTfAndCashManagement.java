package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class InternalTfAndCashManagement extends QCStore{

	
	public static void internaltf(String SSN,String AppURL) throws InterruptedException{
		
			test.log(LogStatus.PASS, "************Intrnal transfer****************");
			

			int lastrow=TestData.getLastRow("Deposit");
			String sheetName="Deposit";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					
					driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
					test.log(LogStatus.PASS, "Clicked on Cash Management");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.findElement(By.xpath("//*[@id='932000']/a")).click();	
					test.log(LogStatus.PASS, "Clicked on Safe button");
					Thread.sleep(2000);

					driver.findElement(By.xpath("//*[@id='932040']/a")).click();
					test.log(LogStatus.PASS, "Clicked on Internal transfer button");
					driver.switchTo().frame("main");
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table[1]/tbody/tr[1]/td[2]/select")).sendKeys("Drawer 1212 to safe");;	
					test.log(LogStatus.PASS, "Selected drawere to safe option");
					Thread.sleep(3000);

					WebElement e= driver.findElement(By.name("requestBean.noOfDollars"));	
					e.click();
					e.sendKeys("0");
					test.log(LogStatus.PASS, "Enterd count of dollar coins :"+"0");

					driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table[1]/tbody/tr[9]/td/table/tbody/tr[2]/td[3]/input")).click();
					test.log(LogStatus.PASS, "click on check box ");


					driver.findElement(By.name("safeToDrawerRequestBean.password")).sendKeys(PIN);;
					test.log(LogStatus.PASS, "Entered password as :"+PIN);

					driver.findElement(By.name("internaltransfer")).click();
					test.log(LogStatus.PASS, "Clicked on Finish Internal transfer");
					test.log(LogStatus.INFO, "Internal Transfer Finished");
					test.log(LogStatus.INFO, "------------------------------------------------------------------------------------------");
					//-----------------------------------------------------------------------------------------------------
					
					test.log(LogStatus.INFO, "Deposit form safe started");
					Thread.sleep(3000);
					driver.switchTo().defaultContent();
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
					WebElement e1= driver.findElement(By.name("safeDepositRequestBean.noOfDollars"));
					e1.click();
					e1.sendKeys("0");
					test.log(LogStatus.PASS, "Enterd count of dollar coins :"+"0");
					
					
							
							
				List<WebElement>  rows = driver.findElements(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr")); 

					int n=rows.size();
					// System.out.println("No of rows are : " + n);
					//test.log(LogStatus.PASS, "First name is"+FirstName);
					//ESign_CheckNbr="951605";
					for(int i=4;i<=n;i++){

						String Checknumber=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();

						test.log(LogStatus.PASS, "Getting check number for the check box to check condition"+Checknumber);
						
						test.log(LogStatus.PASS, "Check number is"+ESign_CheckNbr);
						Thread.sleep(3000);
						//if(Cname.toLowerCase().trim().contains(FirstName.toLowerCase().trim()))
						if(Checknumber.contains(ESign_CheckNbr)){

							test.log(LogStatus.PASS, "name condition satisfied ");
														
							driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/input")).click();
							test.log(LogStatus.PASS, "Clicked on check box ");
							
							driver.findElement(By.name("safeDepositRequestBean.password")).sendKeys(PIN);
							test.log(LogStatus.PASS, "password enterd as :"+PIN);

							driver.findElement(By.name("finishdeposit")).click();
							test.log(LogStatus.PASS, "Clicked on Finish button in safe deposit page");
							driver.findElement(By.name("finishdeposit")).click();
							test.log(LogStatus.PASS, "Clicked on Finish button in deposit  verification page");
							test.log(LogStatus.INFO, "Deposit from safe has Finished");
							break;
						}}
}}
			}
}