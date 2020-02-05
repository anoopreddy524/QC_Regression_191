package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class QCAdminACHReturn extends QCStore {

	public static void achreturn(String SSN, String AppURL) throws Exception {

			
			int lastrow = TestData.getLastRow("ReturnPosting");
			String sheetName = "ReturnPosting";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				if (SSN.equals(RegSSN)) {
					
					String StoreID = bstoreid;
							//TestData.getCellData(sheetName,"StoreID",row);
					String ReasonForReturn = TestData.getCellData(sheetName,"ReasonForReturn",row);
					String Esign_CollateralType = TestData.getCellData(sheetName,"Esign_CollateralType",row);

					test.log(LogStatus.INFO,"Admin Application is launched For Return Posting");

					Thread.sleep(3000);
		driver.switchTo().defaultContent();

		driver.switchTo().frame("topFrame");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='500000']/a")).click(); 
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Clicked on Transaction tab");
		
		Thread.sleep(3000);
		
		
		if(Esign_CollateralType.equalsIgnoreCase("ACH"))
		{
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

			driver.switchTo().defaultContent();

			driver.switchTo().frame("mainFrame");

			
			Thread.sleep(5000);
		
				
			
			driver.findElement(By.linkText("ACH")).click();

			test.log(LogStatus.PASS, "Clicked on ACH link");
			Thread.sleep(5000);
			
			Thread.sleep(5000);
			
			driver.findElement(By.linkText("LOC")).click();

			test.log(LogStatus.PASS, "Clicked on LOC");
			
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[@id='988190514']/a")).click();
			test.log(LogStatus.PASS, "ACH Return");
			//*[@id="988190514"]/a
			
				
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			Thread.sleep(500);
			driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);
			test.log(LogStatus.PASS, "Store ID is entered: "+StoreID);
			
			driver.findElement(By.name("submit")).click();
			test.log(LogStatus.PASS, "Clicked on Submit");
			Thread.sleep(5000);
			
			driver.findElement(By.name("requestBean.chkName")).click();
			test.log(LogStatus.PASS, "Clicked on WebCheck box");
			
			driver.switchTo().defaultContent();

			driver.switchTo().frame("mainFrame");
			
			driver.switchTo().frame("main");
			
			Thread.sleep(5000);
			
			driver.findElement(By.name("rtnReasonId")).sendKeys(ReasonForReturn);
			test.log(LogStatus.PASS, "Return For Reason is: "+ReasonForReturn);
			
			driver.findElement(By.name("CmdReturnPosting")).click();
			test.log(LogStatus.PASS, "Clicked on Finish Return Posting");
			
			driver.findElement(By.name("Ok")).click();
			test.log(LogStatus.PASS, "Clicked on Ok Button");
			test.log(LogStatus.PASS, "Transaction Completed Successfully");						
			driver.close();
			break;
					}
				}

				
			}
			// }

		
	}
}
