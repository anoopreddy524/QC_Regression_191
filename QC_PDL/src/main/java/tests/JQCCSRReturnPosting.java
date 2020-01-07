package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import com.relevantcodes.extentreports.LogStatus;

public class JQCCSRReturnPosting extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;
	
	public static void ReturnPosting(String SSN, String AppURL) throws Exception {

			int lastrow = TestData.getLastRow("NSFPosting");
			String sheetName = "NSFPosting";

		
			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			    String ReasonForReturn=TestData.getCellData(sheetName, "ReasonForReturn", row);

				if (SSN.equals(RegSSN)) {
					String StoreID = TestData.getCellData(sheetName, "StoreID", row);
			
					   driver.switchTo().defaultContent();
					   driver.switchTo().frame("topFrame");
					   driver.findElement(By.xpath("//*[@id='500000']/a")).click();

						test.log(LogStatus.PASS, "Clicked on Transaction tab");
						Thread.sleep(2000);
					 
					   driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");

						driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
						Thread.sleep(500);
						driver.findElement(By.linkText("Collateral Checks")).click();

						test.log(LogStatus.PASS, "Clicked on Collateral Checks link");

						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");
						Thread.sleep(500);
						driver.findElement(By.linkText("Payday Loan")).click();

						test.log(LogStatus.PASS, "Clicked on Payday Loan");

						
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");
						
						Thread.sleep(2000);
						
						driver.findElement(By.linkText("Return Posting")).click();

						test.log(LogStatus.PASS, "Clicked on Return Posting");
						
						Thread.sleep(2500);
						
						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");

						driver.switchTo().frame("main");
						
						driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);
						test.log(LogStatus.PASS, "Store ID is entered: "+StoreID);
						
					    driver.findElement(By.name("button")).click();   
					    test.log(LogStatus.PASS, "Clicked on Submit Button");
					    
					    Thread.sleep(500);
					    
					    driver.findElement(By.name("requestBean.chkName")).click();
					    test.log(LogStatus.PASS, "Clicked on WebCheck box");
					    
					    driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");
						
						driver.switchTo().frame("main");
						
						Thread.sleep(500);
						
						driver.findElement(By.name("rtnReasonId")).sendKeys(ReasonForReturn);
						test.log(LogStatus.PASS, "Return For Reason is: "+ReasonForReturn);
						
						driver.findElement(By.name("CmdReturnPosting")).click();
						
						Thread.sleep(500);
						
						test.log(LogStatus.PASS, "Clicked on Finish return check posting");
						
						Thread.sleep(2500);
						
						driver.findElement(By.name("checkno")).click();
						 
						test.log(LogStatus.PASS,"Click on Ok Button");
						 
						test.log(LogStatus.PASS,"Transaction Completed Successfully");
						test.log(LogStatus.PASS,"*******************************************");
					   
				}
				//break;
				}
		}	

	
}		
	


