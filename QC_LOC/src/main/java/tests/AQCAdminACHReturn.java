package tests;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AQCAdminACHReturn extends QCStore {

	public static void achreturn(String SSN, String AppURL) throws InterruptedException {

		int lastrow = TestData.getLastRow("ReturnPosting");
		String sheetName = "ReturnPosting";

		for (int row = 2; row <= lastrow; row++) {
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			if (SSN.equals(RegSSN)) {

				String StoreID = TestData.getCellData(sheetName,"StoreID",row);
				String ReasonForReturn = TestData.getCellData(sheetName,"ReasonForReturn",row);
				String Esign_CollateralType = TestData.getCellData(sheetName,"Esign_CollateralType",row);

				test.log(LogStatus.INFO,"Admin Application is launched For Return Posting");

				test.log(LogStatus.INFO,"Reading encryption details from Admin has initiated");

				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");

				driver.findElement(By.xpath("//*[@id='500000']/a")).click(); 
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

					driver.findElement(By.linkText("ACH Return")).click();
					test.log(LogStatus.PASS, "Clicked on ACH Return");

					Actions action = new Actions(driver);
					action.moveByOffset(200,100).perform();
					Thread.sleep(10000);
					action.click();
					Thread.sleep(5000);

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Thread.sleep(500);
					WebElement e=driver.findElement(By.name("requestBean.locationNbr"));
					e.click();

					e.sendKeys(StoreID);
					test.log(LogStatus.PASS, "Store ID is entered: "+StoreID);

					driver.findElement(By.name("submit")).click();
					test.log(LogStatus.PASS, "Clicked on Submit");
					Thread.sleep(5000);

					driver.findElement(By.name("requestBean.chkName")).click();
					test.log(LogStatus.PASS, "Clicked on WebCheck box");

					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");

					Thread.sleep(500);

					driver.findElement(By.name("rtnReasonId")).sendKeys(ReasonForReturn);
					test.log(LogStatus.PASS, "Return For Reason is: "+ReasonForReturn);

					driver.findElement(By.name("CmdReturnPosting")).click();
					test.log(LogStatus.PASS, "Clicked on Finish Return Posting");

					driver.findElement(By.name("Ok")).click();
					test.log(LogStatus.PASS, "Clicked on Ok Button");
					test.log(LogStatus.PASS, "Transaction Completed Successfully");						
					//driver.close();
					break;
				}
			}


		}




	}
}
