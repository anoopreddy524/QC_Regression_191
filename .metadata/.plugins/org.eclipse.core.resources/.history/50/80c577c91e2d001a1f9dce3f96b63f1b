package tests;

import java.net.URL;
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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class JQCAdminACHReturn extends QCStore {

	public static void achreturn(String SSN, String AppURL) {
		try {
			// String FileName= Jprop.getProperty("QC_Store_NewLoan_file_name");

			// ExcelNew TestData = new
			// ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");
			int lastrow = TestData.getLastRow("NSFPosting");
			String sheetName = "NSFPosting";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				if (SSN.equals(RegSSN)) {
					String AdminUserName = TestData.getCellData(sheetName,"AdminUserName",row);
					String AdminPassword = TestData.getCellData(sheetName,"AdminPassword",row);
					String AdminURL = TestData.getCellData(sheetName, "AdminURL", row);
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					String StoreID = TestData.getCellData(sheetName,"StoreID",row);
					String ReasonForReturn = TestData.getCellData(sheetName,"ReasonForReturn",row);
					String Esign_CollateralType = TestData.getCellData(sheetName,"Esign_CollateralType",row);

					test.log(LogStatus.INFO,"Admin Application is launched For Return Posting");

					//driver = new InternetExplorerDriver();
					String Node = "http://192.168.2.94:5555/wd/hub";
					  DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
					 
					 
						System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");

						driver = new RemoteWebDriver(new URL(Node), cap);
					wait = new WebDriverWait(driver, 40000);

					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
				
					driver.get(AdminURL);
					test.log(LogStatus.INFO,"Opened the Admin URL"+ AdminURL);
					test.log(LogStatus.INFO,"Reading encryption details from Admin has initiated"+ AdminURL);



		
		DateFormat df=new SimpleDateFormat("MM/dd/yyyy"); 

		driver.findElement(By.name("loginRequestBean.userId")).sendKeys(AdminUserName);

		test.log(LogStatus.PASS, "Username is entered: "+AdminUserName); 

		driver.findElement(By.name("loginRequestBean.password")).sendKeys(AdminPassword);

		test.log(LogStatus.PASS, "Password is entered: "+AdminPassword); 

		//Click Login Button

		driver.findElement(By.name("login")).click();

		test.log(LogStatus.PASS, "Clicked on Submit button");

		Thread.sleep(1000);


		driver.switchTo().defaultContent();

		driver.switchTo().frame("topFrame");

		driver.findElement(By.xpath("//*[@id='500000']/a")).click(); 
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Clicked on Transaction tab");
		
		Thread.sleep(3000);
		
		
		if(Esign_CollateralType.equalsIgnoreCase("ACH"))
		{
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

			driver.switchTo().defaultContent();

			driver.switchTo().frame("mainFrame");
			
			 Actions action = new Actions(driver);  
			 WebElement ACH=driver.findElement(locator(Jprop.getProperty("admin_ACH_menu")));
			 action.moveToElement(ACH).build().perform();
			 test.log(LogStatus.PASS, " Mouse hover on ACH menu");
			 Thread.sleep(2000);
			 WebElement pdl=driver.findElement(locator(Jprop.getProperty("admin_pdl")));
			 action.moveToElement(pdl).build().perform();
			 test.log(LogStatus.PASS, " Mouse hover on payday loan menu");
			 Thread.sleep(3000);
			 driver.findElement(locator(Jprop.getProperty("admin_ACH_return"))).click();
			 test.log(LogStatus.PASS, " click on ACH return");
			 Thread.sleep(3000);
			 for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}				    
			 driver.switchTo().defaultContent();
			 driver.switchTo().frame("mainFrame");
			 driver.switchTo().frame("main");
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
			
			Thread.sleep(500);
			
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

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Return Posting from Admin is failed");

		}

	}
}
