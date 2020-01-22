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

public class RQCCSRReturnPosting extends QCStore {

	public static void returnposting(String SSN, String AppURL) {
		try {
			// String FileName= prop.getProperty("QC_Store_NewLoan_file_name");

			// ExcelNew TestData = new
			// ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");
			int lastrow = TestData.getLastRow("ReturnPosting");
			String sheetName = "ReturnPosting";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				if (SSN.equals(RegSSN)) {
					String AdminUserName = TestData.getCellData(sheetName, "AdminUserName", row);
					String AdminPassword = TestData.getCellData(sheetName, "AdminPassword", row);
					String AdminURL = TestData.getCellData(sheetName, "AdminURL", row);
					String PIN = TestData.getCellData(sheetName, "PIN", row);
					String StoreID = TestData.getCellData(sheetName, "StoreID", row);
					String ReasonForReturn = TestData.getCellData(sheetName, "ReasonForReturn", row);
					String Esign_CollateralType = TestData.getCellData(sheetName, "Esign_CollateralType", row);

					test.log(LogStatus.INFO, "Admin Application is launched For Return Posting");

					driver = new InternetExplorerDriver();
					wait = new WebDriverWait(driver, 40000);

					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);

					driver.get(AdminURL);
					test.log(LogStatus.INFO, "Opened the Admin URL" + AdminURL);
					test.log(LogStatus.INFO, "Reading encryption details from Admin has initiated" + AdminURL);

					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

					driver.findElement(By.name("loginRequestBean.userId")).sendKeys(AdminUserName);

					test.log(LogStatus.PASS, "Username is entered: " + AdminUserName);

					driver.findElement(By.name("loginRequestBean.password")).sendKeys(AdminPassword);

					test.log(LogStatus.PASS, "Password is entered: " + AdminPassword);

					// Click Login Button

					driver.findElement(By.name("login")).click();

					test.log(LogStatus.PASS, "Clicked on Submit button");

					Thread.sleep(1000);

					driver.switchTo().defaultContent();

					driver.switchTo().frame("topFrame");

					driver.findElement(By.xpath("//*[@id='500000']/a")).click();

					test.log(LogStatus.PASS, "Clicked on Transaction tab");

					Thread.sleep(1000);

					// .....................Colateral
					// TYPE...........................

					if (Esign_CollateralType.equals("CHECK")) {
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");

						driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
						Thread.sleep(5000);
						driver.findElement(By.linkText("Collateral Checks")).click();

						test.log(LogStatus.PASS, "Clicked on Collateral Checks link");

						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");
						Thread.sleep(5000);
						driver.findElement(By.linkText("Payday Loan")).click();

						test.log(LogStatus.PASS, "Clicked on Payday Loan");

						// Thread.sleep(2000);

						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");

						Thread.sleep(5000);

						driver.findElement(By.linkText("Return Posting")).click();

						test.log(LogStatus.PASS, "Clicked on Return Posting");

						Thread.sleep(500);

						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");

						driver.switchTo().frame("main");

						driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);
						test.log(LogStatus.PASS, "Store ID is entered: " + StoreID);

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
						test.log(LogStatus.PASS, "Return For Reason is: " + ReasonForReturn);

						driver.findElement(By.name("CmdReturnPosting")).click();

						Thread.sleep(500);

						test.log(LogStatus.PASS, "Clicked on Finish return check posting");

						Thread.sleep(5000);

						driver.findElement(By.name("checkno")).click();

						test.log(LogStatus.PASS, "Click on Ok Button");

						test.log(LogStatus.PASS, "Transaction Completed Successfully");
						driver.close();

					}
					if (Esign_CollateralType.equalsIgnoreCase("ACH")) {
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");

						Thread.sleep(5000);

						driver.findElement(By.linkText("ACH")).click();

						test.log(LogStatus.PASS, "Clicked on ACH link");
						Thread.sleep(5000);

						driver.findElement(By.linkText("Payday Loan")).click();

						test.log(LogStatus.PASS, "Clicked on Payday Loan");

						Thread.sleep(5000);

						Thread.sleep(5000);

						driver.findElement(By.linkText("ACH Processing(NACHA)")).click();
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

						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						// business_date="08/08/2018";
						String App_date[] = business_date.split("/");
						System.out.println("business_date");

						String Date1 = App_date[0];
						System.out.println("Date 1" + Date1);
						String Date2 = App_date[1];
						String Date3 = App_date[2];

						driver.findElement(By.name("fromDate1")).clear();
						Thread.sleep(500);
						driver.findElement(By.name("fromDate1")).sendKeys(Date1.trim());
						test.log(LogStatus.PASS, "Month is entered: " + Date1);

						driver.findElement(By.name("fromDate2")).clear();
						Thread.sleep(500);
						driver.findElement(By.name("fromDate2")).sendKeys(Date2.trim());
						test.log(LogStatus.PASS, "Date is entered: " + Date2);
						driver.findElement(By.name("fromDate3")).clear();
						Thread.sleep(500);

						driver.findElement(By.name("fromDate3")).sendKeys(Date3.trim());
						test.log(LogStatus.PASS, "Year is entered: " + Date3);
						Thread.sleep(500);
						String Todate1 = App_date[0];
						String Todate2 = App_date[1];
						String Todate3 = App_date[2];
						System.out.println("Todate1" + Todate1);

						driver.findElement(By.name("toDate1")).clear();
						driver.findElement(By.name("toDate1")).sendKeys(Todate1.trim());
						test.log(LogStatus.PASS, "Month is entered: " + Todate1);
						driver.findElement(By.name("toDate2")).clear();
						driver.findElement(By.name("toDate2")).sendKeys(Todate2.trim());
						test.log(LogStatus.PASS, "Date is entered: " + Todate2);
						driver.findElement(By.name("toDate3")).clear();
						driver.findElement(By.name("toDate3")).sendKeys(Todate3.trim());
						test.log(LogStatus.PASS, "Year is entered: " + Todate3);
						Thread.sleep(500);
						driver.findElement(By
								.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[3]/tbody/tr/td[2]/input"))
								.click();
						test.log(LogStatus.PASS, "Clicked on Search Button");
						Thread.sleep(500);
						driver.findElement(By.name("CmdReturnPosting")).click();
						test.log(LogStatus.PASS, "Clicked on Process Button");
						Thread.sleep(5000);
						test.log(LogStatus.PASS, "ACH Files created successfully");
						driver.close();
						break;
					}
				}

				
			}
			// }

		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Return Posting from Admin is failed");

		}

	}
}
