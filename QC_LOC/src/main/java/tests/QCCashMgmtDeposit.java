package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import com.relevantcodes.extentreports.LogStatus;

public class QCCashMgmtDeposit extends QCStore {
	
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static void cashmgmtDeposit(String SSN, String AppURL) throws Exception {


			
			int lastrow = TestData.getLastRow("CmgDeposit");
			String sheetName = "CmgDeposit";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			
				
				if (SSN.equals(RegSSN)) {
				
					String CountofDollarCoins = TestData.getCellData(sheetName, "CountofDollarCoins", row);
					String PIN = TestData.getCellData(sheetName, "PIN", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, " Cash Management Deposit process has started");
				
					for (String winHandle1 : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle1);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("topFrame");

					// Using try/catch for clicking elements 2nd time if it is
					// not able to click in 1st attempt

					try {
						driver.findElement(By.xpath("//*[@id='930000']/a")).click();
						test.log(LogStatus.PASS, "Clicked on Cash Management");
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.findElement(By.xpath("//*[@id='932000']/a")).click();
						test.log(LogStatus.PASS, "Clicked on Safe");
						Thread.sleep(500);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						Thread.sleep(500);
						driver.findElement(By.xpath("//*[@id='932050']/a")).click();
						test.log(LogStatus.PASS, "Clicked on Deposit");
					} catch (Exception e) {
						driver.get(Aprop.getProperty("login_page"));
						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("topFrame");
						driver.findElement(By.xpath("//*[@id='930000']/a")).click();
						//test.log(LogStatus.PASS, "Clicked on Cash Management");
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.findElement(By.xpath("//*[@id='932000']/a")).click();
						//test.log(LogStatus.PASS, "Clicked on Safe");
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
					// driver.findElement(By.name("D1")).sendKeys(Action);
					// test.log(LogStatus.PASS, "Action Type is :"+Action);
					driver.findElement(By.name("safeDepositRequestBean.noOfDollars")).sendKeys(CountofDollarCoins);
					test.log(LogStatus.PASS, "Coin Entered is :" + CountofDollarCoins);
					Thread.sleep(3000);
					driver.findElement(By.name("locSlipNbrs")).click();					
					test.log(LogStatus.PASS, "Clicked on WebCheckbox");
					Thread.sleep(1000);
					driver.findElement(By.name("safeDepositRequestBean.password")).sendKeys(PIN);
					test.log(LogStatus.PASS, "Banker Pin Entered is :" + PIN);
					Thread.sleep(3000);
					driver.findElement(By.name("finishdeposit")).click();
					test.log(LogStatus.PASS, "Clicked on Finish Deposit");
					try {
						Alert alert = driver.switchTo().alert();

						alert.accept();
						// if alert present, accept and move on.

					} catch (NoAlertPresentException e) {
						// do what you normally would if you didn't have the
						// alert.
					}
					Thread.sleep(500);
					try {
						Alert alert = driver.switchTo().alert();

						alert.accept();
						// if alert present, accept and move on.

					} catch (NoAlertPresentException e) {
						// do what you normally would if you didn't have the
						// alert.
					}
					driver.findElement(By.name("finishdeposit")).click();
					test.log(LogStatus.PASS, "Click on Finish Deposit");
					Thread.sleep(500);
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input")).click();
					test.log(LogStatus.PASS, "Click on Ok");
					test.log(LogStatus.PASS, "Cash Management Deposit Completed Successfully");
					test.log(LogStatus.PASS, "*********************************");

					
				}
			}

			}

}
