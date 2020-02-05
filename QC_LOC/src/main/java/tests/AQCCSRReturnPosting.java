package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AQCCSRReturnPosting extends QCStore {

	public static void returnposting(String SSN, String AppURL) throws InterruptedException {
		
						int lastrow = TestData.getLastRow("ReturnPosting");
						String sheetName = "ReturnPosting";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				if (SSN.equals(RegSSN)) {
					
					/*Due_Date1="09";
					Due_Date2="12";
					Due_Date3="2018";*/
					
					
					String StoreID = TestData.getCellData(sheetName, "StoreID", row);
					
					String Esign_CollateralType = TestData.getCellData(sheetName, "Esign_CollateralType", row);

					test.log(LogStatus.INFO, "Admin Application is launched For Return Posting");

					

					driver.switchTo().defaultContent();

					driver.switchTo().frame("topFrame");

					driver.findElement(By.xpath("//*[@id='500000']/a")).click();

					test.log(LogStatus.PASS, "Clicked on Transaction tab");

					Thread.sleep(1000);

					// .....................Colateral
					// TYPE...........................


					if (Esign_CollateralType.equalsIgnoreCase("ACH")) {
						

						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");

						Thread.sleep(5000);

						driver.findElement(By.linkText("ACH")).click();

						test.log(LogStatus.PASS, "Clicked on ACH link");
						Thread.sleep(5000);

						driver.findElement(By.linkText("LOC")).click();

						test.log(LogStatus.PASS, "Clicked on LOC");

						Thread.sleep(5000);

						Thread.sleep(500);

						driver.findElement(By.linkText("ACH Processing(NACHA))")).click();
						// driver.findElement(By.xpath("//*[@id='503019']/a")).click();

						test.log(LogStatus.PASS, "Clicked on ACH Processing(NACHA)");

						Thread.sleep(3000);

						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");

						driver.switchTo().frame("main");

						driver.findElement(By
								.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[1]/font/b/input"))
								.click();
						                
						test.log(LogStatus.PASS, "Clicked on Radiobutton Button");

						Thread.sleep(3000);

						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");

						driver.switchTo().frame("main");

						driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);
						test.log(LogStatus.PASS, "Store ID is entered: " + StoreID);

						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						//NextDueDate="10/08/2018";
						/*test.log(LogStatus.PASS, "Next due date is " + NextDueDate);
						NextDueDate=NextDueDate.trim();
						String App_date[] = NextDueDate.split("/");*/
						

						 /*Date1 = App_date[0];
						
						 Date2 = App_date[1];
						String Date3 = App_date[2];*/

						driver.findElement(By.name("fromDate1")).clear();
						Thread.sleep(500);
						driver.findElement(By.name("fromDate1")).sendKeys(Due_Date1.trim());
						test.log(LogStatus.PASS, "Month is entered: " + Due_Date1);

						driver.findElement(By.name("fromDate2")).clear();
						Thread.sleep(500);
						driver.findElement(By.name("fromDate2")).sendKeys(Due_Date2.trim());
						test.log(LogStatus.PASS, "Date is entered: " + Due_Date2);
						driver.findElement(By.name("fromDate3")).clear();
						Thread.sleep(500);

						driver.findElement(By.name("fromDate3")).sendKeys(Due_Date3.trim());
						test.log(LogStatus.PASS, "Year is entered: " + Due_Date3);
						Thread.sleep(500);
						/*String Todate1 = App_date[0];
						String Todate2 = App_date[1];
						String Todate3 = App_date[2];
						System.out.println("Todate1" + Todate1);*/

						driver.findElement(By.name("toDate1")).clear();
						driver.findElement(By.name("toDate1")).sendKeys(Due_Date1.trim());
						test.log(LogStatus.PASS, "Month is entered: " + Due_Date1);
						driver.findElement(By.name("toDate2")).clear();
						driver.findElement(By.name("toDate2")).sendKeys(Due_Date2.trim());
						test.log(LogStatus.PASS, "Date is entered: " + Due_Date2);
						driver.findElement(By.name("toDate3")).clear();
						driver.findElement(By.name("toDate3")).sendKeys(Due_Date3.trim());
						test.log(LogStatus.PASS, "Year is entered: " + Due_Date3);
						Thread.sleep(500);
						driver.findElement(By
								.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[3]/tbody/tr/td[2]/input"))
								.click();
						test.log(LogStatus.PASS, "Clicked on Search Button");
						Thread.sleep(2500);
						driver.findElement(By.name("CmdReturnPosting")).click();
						test.log(LogStatus.PASS, "Clicked on Process Button");
						//Thread.sleep(5000);
						test.log(LogStatus.PASS, "ACH Files created successfully");
						//driver.close();
						break;
					}
				}

				
			}
		

		

	}
}
