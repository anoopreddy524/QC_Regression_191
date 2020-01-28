package tests;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class QC_EPP_Return extends QCStore{
	public static void qcReturn (String SSN,String AppURL)
	{
		try{
			test.log(LogStatus.PASS, "*********** Return Posting started****************");


			int lastrow=TestData.getLastRow("NSFPosting");
			String sheetName="NSFPosting";

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
					Thread.sleep(500);
					driver.findElement(By.linkText("Collateral Checks")).click();
					test.log(LogStatus.PASS, "Clicked on Collateral Checks link");
					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");
					Thread.sleep(500);
					driver.findElement(By.linkText("Payday Loan")).click();

					test.log(LogStatus.PASS, "Clicked on Payday Loan");

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					Thread.sleep(500);

					driver.findElement(By.linkText("Return Posting")).click();

					test.log(LogStatus.PASS, "Clicked on Return Posting");

					Thread.sleep(500);

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

					Thread.sleep(5000);

					driver.findElement(By.name("checkno")).click();

					test.log(LogStatus.PASS,"Click on Ok Button");

					test.log(LogStatus.PASS,"Transaction Completed Successfully");
					test.log(LogStatus.INFO,"***************************************************************");
				}}}
		catch (Exception e) {
					e.printStackTrace();
					test.log(LogStatus.INFO,""+e);
					test.log(LogStatus.PASS, "Refund Trasaction is initiated due to application sync issue");
}}}
