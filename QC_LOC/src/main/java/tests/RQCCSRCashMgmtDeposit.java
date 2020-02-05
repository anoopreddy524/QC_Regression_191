package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import com.relevantcodes.extentreports.LogStatus;

public class RQCCSRCashMgmtDeposit extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static void cashmgmtdeposit(String SSN, String AppURL) throws InterruptedException {


			
			int lastrow = TestData.getLastRow("CmgDeposit");
			String sheetName = "CmgDeposit";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String Action = TestData.getCellData(sheetName, "Action", row);
				String CountofDollarCoins = TestData.getCellData(sheetName, "CountofDollarCoins", row);
				String BankerPIN = TestData.getCellData(sheetName, "BankerPIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);
				

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "CSR Login For Cash Mgmt Deposit");
				
					for (String winHandle1 : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle1);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("topFrame");

				

					try {
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@id='930000']/a")).click();
						test.log(LogStatus.PASS, "Clicked on Cash Management");
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@id='932000']/a")).click();
						test.log(LogStatus.PASS, "Clicked on Safe");
						Thread.sleep(500);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@id='932050']/a")).click();
						test.log(LogStatus.PASS, "Clicked on Deposit");
					} catch (Exception e) {
						driver.get(csrloginpage);
						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("topFrame");
						driver.findElement(By.xpath("//*[@id='930000']/a")).click();
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.findElement(By.xpath("//*[@id='932000']/a")).click();
						
						Thread.sleep(500);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						Thread.sleep(500);
						driver.findElement(By.xpath("//*[@id='932050']/a")).click();
						test.log(LogStatus.PASS, "Clicked on Deposit");
						Thread.sleep(500);
					}
					Thread.sleep(500);
					for (String winHandle1 : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle1);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					
					driver.findElement(By.name("safeDepositRequestBean.noOfDollars")).sendKeys(CountofDollarCoins);
					test.log(LogStatus.PASS, "Coin Entered is :" + CountofDollarCoins);
					driver.findElement(By.name("locSlipNbrs")).click();
					test.log(LogStatus.PASS, "Clicked on WebCheckbox");
					Thread.sleep(500);
					driver.findElement(By.name("safeDepositRequestBean.password")).sendKeys(BankerPIN);
					
					test.log(LogStatus.PASS, "Banker Pin Entered is :" + BankerPIN);
					Thread.sleep(500);
					driver.findElement(By.name("finishdeposit")).click();
					test.log(LogStatus.PASS, "Clicked on Finish Deposit");
					Thread.sleep(5000);
					try {
						Alert alert = driver.switchTo().alert();

						alert.accept();
						// if alert present, accept and move on.

					} catch (NoAlertPresentException e) {
						// do what you normally would if you didn't have the
						// alert.
					}
					Thread.sleep(5000);
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/input")).click();
					test.log(LogStatus.PASS, "Click on Finish Deposit");
					Thread.sleep(500);
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input")).click();
					test.log(LogStatus.PASS, "Click on Ok");
					test.log(LogStatus.PASS, "Deposit Completed Successfully");

					
				}
			}
			// }

		
	}

}
