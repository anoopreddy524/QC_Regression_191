package tests;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class AQCRedeposit extends QCStore {

	public static void redeposit(String SSN, String AppURL) throws InterruptedException {
	

			int lastrow = TestData.getLastRow("Redeposit");
			String sheetName = "Redeposit";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);

				if (SSN.equals(RegSSN)) {
					//loan_nbr="10212770";
					String Representation_Type = TestData.getCellData(sheetName, "Representation_Type", row);

					test.log(LogStatus.PASS, "Re Deposit has started");

					driver.switchTo().frame("topFrame");
					driver.findElement(locator(Aprop.getProperty("transactions_tab"))).click();
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.findElement(By.partialLinkText("ACH")).click();
					test.log(LogStatus.PASS, "Clicked on ACH");
					driver.findElement(By.partialLinkText("LOC")).click();
					test.log(LogStatus.PASS, "Clicked on LOC");
					driver.findElement(By.partialLinkText("ReDeposit")).click();
					test.log(LogStatus.PASS, "Clicked on Redeposit");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Enterd loan number is :" + loan_number);
					driver.findElement(By.name("submit")).click();
					test.log(LogStatus.PASS, "Click on submit button");
					Thread.sleep(3000);
					driver.findElement(By.name("requestBean.chkName")).click();
					test.log(LogStatus.PASS, "Selected the check box");
					//driver.findElement(By.name("dispRepresentmentType")).sendKeys(Representation_Type);
					//test.log(LogStatus.PASS, "Selected the Representation Type as "+Representation_Type);
					driver.findElement(By.name("CmdReturnPosting")).click();
					test.log(LogStatus.PASS, "Clicked on Finish Deposit button "+Representation_Type);
					test.log(LogStatus.PASS, "Re Deposit is successful");
					test.log(LogStatus.PASS, "*************************************");


					break;
				}

			}
	

	}
		
	}

