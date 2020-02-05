package tests;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class JQCAdminCCKReturn extends QCStore {

	public static void cckreturn(String SSN, String AppURL) throws InterruptedException {
		
			int lastrow = TestData.getLastRow("Return");
			String sheetName = "Return";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				if (SSN.equals(RegSSN)) {										
				
					String StoreID = "523";
							//TestData.getCellData(sheetName,"StoreID",row);
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String CCKReasonForReturn = TestData.getCellData(sheetName,"CCKReasonForReturn",row);
					String Esign_CollateralType = TestData.getCellData(sheetName,"Esign_CollateralType",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
                    
					
					test.log(LogStatus.INFO,"Admin Application is launched For Return Posting");

			
			
					test.log(LogStatus.INFO,"Reading encryption details from Admin has initiated");




		driver.switchTo().defaultContent();

		driver.switchTo().frame("topFrame");

		driver.findElement(By.xpath("//*[@id='500000']/a")).click(); 
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Clicked on Transaction tab");
		
		Thread.sleep(3000);
		
		
		if(Esign_CollateralType.equalsIgnoreCase("ACH"))
		{
		driver.switchTo().defaultContent();

			driver.switchTo().frame("mainFrame");

			
			Thread.sleep(5000);
		
			driver.findElement(By.linkText("Payment Check Return Posting")).click();

			test.log(LogStatus.PASS, "Clicked on Payment Check Return Posting link");
			
			Thread.sleep(5000);			
						
			driver.switchTo().frame("main");
			
			driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);
			
			test.log(LogStatus.PASS, "Store nbr entered is :" +StoreID);
		
			//loan_nbr="10207994";
			driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_nbr);
			
			test.log(LogStatus.PASS, "Loan nbr entered is :" +loan_nbr);
			
			driver.findElement(By.name("requestBean.pmtTenderType")).sendKeys(TenderType);
			
			test.log(LogStatus.PASS, "Payment Tender Type select as :" +TenderType);
			
			driver.findElement(By.name("requestBean.productType")).sendKeys(ProductID);
			
			test.log(LogStatus.PASS, "Product Type Select as :" +ProductID);
			
			driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[4]/tbody/tr[2]/td[2]/table[2]/tbody/tr[2]/td[2]/input")).click();
			
			test.log(LogStatus.PASS, "Clicked on Submit");
			
			Thread.sleep(5000);
			
			driver.findElement(By.name("requestBean.chkName")).click();
			
			test.log(LogStatus.PASS, "Clicked on WebCheck box");
			
			Thread.sleep(500);
			
			driver.findElement(By.name("rtnReasonId")).sendKeys(CCKReasonForReturn);
			
			test.log(LogStatus.PASS, "return For Reason Select as :" +CCKReasonForReturn );
			
			Thread.sleep(500);
			
			driver.findElement(By.name("CmdReturnPosting")).click();
			
			test.log(LogStatus.PASS, "Clicked on Finish Return Check Posting");
			
			Thread.sleep(5000);
			
			driver.findElement(By.name("checkno")).click();
			
			test.log(LogStatus.PASS, "Clicked on Transaction Completed Successfully Ok");
			
			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Check Return Posting Completed Successfully");
			
			
			driver.close();
			break;
					}
				}

				
			}
			// }

		
	}
}
