package tests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

import tests.QCStore;

public class ILP_ReturnPosting extends QCStore{
	public static void qcReturn (String SSN,String AppURL) throws InterruptedException
	{
	
			test.log(LogStatus.PASS, "************ Return posting Transaction started****************");
			

			int lastrow=TestData.getLastRow("Return");
			String sheetName="Return";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					//String  StoreID=TestData.getCellData(sheetName,"StoreID",row);
					String  StoreID="1705";
					String  ReasonForReturn=TestData.getCellData(sheetName,"ReasonForReturn",row);
					Thread.sleep(1000);
					driver.switchTo().frame("topFrame");
					driver.findElement(By.partialLinkText("Transactions")).click();   
					test.log(LogStatus.PASS, "Clicked on Transactions");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					Thread.sleep(3000);
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

					driver.findElement(By.linkText("Return Posting")).click();

					test.log(LogStatus.PASS, "Clicked on Return Posting");

					Thread.sleep(2500);

						Actions action = new Actions(driver);
						action.moveByOffset(200,100).perform();
						Thread.sleep(2000);
						action.click();
					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");

					WebElement e2=driver.findElement(By.name("requestBean.locationNbr"));
					e2.click();
					Thread.sleep(2500);
					e2.sendKeys(StoreID);
					test.log(LogStatus.PASS, "Store ID is entered: "+StoreID);
					Thread.sleep(1000);
					driver.findElement(By.name("submit")).click();   
					test.log(LogStatus.PASS, "Clicked on Submit Button");

					Thread.sleep(1500);

										
					List<WebElement>  rows = driver.findElements(By.xpath("/html/body/table/tbody/tr/td/table[2]/tbody/tr")); 
					//ESign_CheckNbr="987655";
					int n=rows.size();
					for(int i=4;i<=n;i++){
						
					String loannumber=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[2]/tbody/tr["+i+"]/td[4] ")).getText();
							
					test.log(LogStatus.PASS, "Getting loan number for the check box to check condition"+loannumber);
					test.log(LogStatus.PASS, "loan number is"+loan_nbr);
					Thread.sleep(3000);
							 
					if(loannumber.equals(loan_nbr)){
					test.log(LogStatus.PASS, "name condition satisfied ");
					
					driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[2]/tbody/tr["+i+"]/td[1]/input")).click();
					test.log(LogStatus.PASS, "Clicked on check box ");
							
					Thread.sleep(500);
					
					driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[2]/tbody/tr["+i+"]/td[9]/select")).sendKeys(ReasonForReturn);
					test.log(LogStatus.PASS, "Return For Reason is: "+ReasonForReturn);

					driver.findElement(By.name("CmdReturnPosting")).click();

					
					test.log(LogStatus.PASS, "Clicked on Finish return check posting");

					Thread.sleep(5000);

					/*driver.findElement(By.name("checkno")).click();

					test.log(LogStatus.PASS,"Click on Ok Button");*/

					test.log(LogStatus.PASS,"Transaction Completed Successfully");
					test.log(LogStatus.INFO,"***************************************************************");
					
					break;}
					else{
						test.log(LogStatus.FAIL,"Loan Number doesn't match");
					}
					break;}	break;}}}
}
