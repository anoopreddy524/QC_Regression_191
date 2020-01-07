package tests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class AQC_EPP_Return extends QCStore{
	public static void qcReturn (String SSN,String AppURL) throws InterruptedException
	{
	
			test.log(LogStatus.PASS, "************EPP Return posting Transaction started****************");
			

			int lastrow=TestData.getLastRow("Return");
			String sheetName="Return";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String  StoreID=TestData.getCellData(sheetName,"StoreID",row);
					String  ReasonForReturn=TestData.getCellData(sheetName,"ReasonForReturn",row);

					driver.switchTo().frame("topFrame");
					driver.findElement(By.partialLinkText("Transactions")).click();   
					test.log(LogStatus.PASS, "Clicked on Transactions");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					Thread.sleep(1500);
					driver.findElement(By.linkText("Collateral Checks")).click();
					test.log(LogStatus.PASS, "Clicked on Collateral Checks link");
					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");
					Thread.sleep(500);
					driver.findElement(By.linkText("Payday Loan")).click();

					test.log(LogStatus.PASS, "Clicked on Payday Loan");
					Thread.sleep(1500);

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.findElement(By.linkText("Return Posting")).click();

					test.log(LogStatus.PASS, "Clicked on Return Posting");

					Thread.sleep(1500);

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");

					driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);
					test.log(LogStatus.PASS, "Store ID is entered: "+StoreID);

					driver.findElement(By.name("button")).click();   
					test.log(LogStatus.PASS, "Clicked on Submit Button");

					Thread.sleep(1500);

										
					List<WebElement>  rows = driver.findElements(By.xpath("/html/body/table/tbody/tr/td/table[2]/tbody/tr")); 
					//ESign_CheckNbr="951614";
					int n=rows.size();
					
					Assert.assertTrue(n!=0,"No records returned message showing");
					
					for(int i=4;i<=n;i++){
					String Checknumber=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[2]/tbody/tr["+i+"]/td[8] ")).getText();
							
					test.log(LogStatus.PASS, "Getting check number for the check box to check condition"+Checknumber);
					test.log(LogStatus.PASS, "Check number is"+ESign_CheckNbr);
					Thread.sleep(1500);
							 
					if(Checknumber.contains(ESign_CheckNbr)){
					test.log(LogStatus.PASS, "name condition satisfied ");
					driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[2]/tbody/tr["+i+"]/td[1]/input")).click();
					test.log(LogStatus.PASS, "Clicked on check box ");
							
					Thread.sleep(1500);

					driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[2]/tbody/tr["+i+"]/td[11]/select")).sendKeys(ReasonForReturn);
					test.log(LogStatus.PASS, "Return For Reason is: "+ReasonForReturn);

					driver.findElement(By.name("CmdReturnPosting")).click();

					
					test.log(LogStatus.PASS, "Clicked on Finish return check posting");

					Thread.sleep(5000);

					driver.findElement(By.name("checkno")).click();

					test.log(LogStatus.PASS,"Click on Ok Button");

					test.log(LogStatus.PASS,"Transaction Completed Successfully");
					test.log(LogStatus.INFO,"***************************************************************");
					
					break;
					}
					else{
						continue;
						//test.log(LogStatus.FAIL,"Check number checking condtion failed");
						
					}
					}
					
					
					}}}}
