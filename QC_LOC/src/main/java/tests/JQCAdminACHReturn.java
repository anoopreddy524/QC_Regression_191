package tests;


import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class JQCAdminACHReturn extends QCStore {

	public static void achreturn(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("ReturnPosting");
			String sheetName = "ReturnPosting";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				if (SSN.equals(RegSSN)) {
					String AdminUserName = TestData.getCellData(sheetName,"AdminUserName",row);
					String AdminPassword = TestData.getCellData(sheetName,"AdminPassword",row);
					//String AdminURL = TestData.getCellData(sheetName, "AdminURL", row);
					String StoreID = TestData.getCellData(sheetName,"StoreID",row);
					String ReasonForReturn = TestData.getCellData(sheetName,"ReasonForReturn",row);
					String Esign_CollateralType = TestData.getCellData(sheetName,"Esign_CollateralType",row);

					test.log(LogStatus.INFO,"Admin Application is launched For Return Posting");

					driver = new InternetExplorerDriver();
					
						/*String Node = "http://192.168.2.164:5555/wd/hub";
					  DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
					 
					 
						System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");

						driver = new RemoteWebDriver(new URL(Node), cap);*/
						
					wait = new WebDriverWait(driver, 40000);

					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
				
					driver.get(AdminURL);
					test.log(LogStatus.INFO,"Opened the Admin URL"+ AdminURL);
					test.log(LogStatus.INFO,"Reading encryption details from Admin has initiated"+ AdminURL);


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
		
		Thread.sleep(2000);
		
		
		if(Esign_CollateralType.equalsIgnoreCase("ACH"))
		{
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

			driver.switchTo().defaultContent();

			driver.switchTo().frame("mainFrame");

			
			Thread.sleep(2000);
		
			Actions action = new Actions(driver);  
			 WebElement collateral=driver.findElement(By.linkText("ACH"));
			 action.moveToElement(collateral).build().perform();
			 test.log(LogStatus.PASS, " Mouse hover on ACH menu");
			 Thread.sleep(2000);
			 WebElement loc=driver.findElement(By.linkText("LOC"));
			 action.moveToElement(loc).build().perform();
			 test.log(LogStatus.PASS, " Mouse hover on LOC menu");	
			 Thread.sleep(3000);
			 driver.findElement(By.linkText("ACH Return")).click();
			test.log(LogStatus.PASS, "Click on ACH Return");
			
			Thread.sleep(2000);
			 driver.switchTo().defaultContent();
			 driver.switchTo().frame("mainFrame");
			 driver.switchTo().frame("main");
			Thread.sleep(500);
			action.moveByOffset(200,100).perform();
			action.click();
			driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);
			test.log(LogStatus.PASS, "Store ID is entered: "+StoreID);
			
			driver.findElement(By.name("submit")).click();
			test.log(LogStatus.PASS, "Clicked on Submit");
			Thread.sleep(2000);
			
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
			test.log(LogStatus.PASS, "********************************************** ");
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
