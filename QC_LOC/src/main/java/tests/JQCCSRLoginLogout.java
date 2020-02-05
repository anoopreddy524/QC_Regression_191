package tests;
//This class contains methods for login and logout functionality

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class JQCCSRLoginLogout extends QCStore{
	public static void login(String SSN,String AppURL ) throws Exception{

		test.log(LogStatus.PASS, "********Performing Login functionality********");
			String sheetName="Login";
			int lastrow=TestData.getLastRow("Login");

			for(int row=2;row<=lastrow;row++){

				String RegSSN = TestData.getCellData(sheetName,"SSN",row);

				if(SSN.equals(RegSSN))

				{
					//String csr_url = TestData.getCellData(sheetName,"AppURL",row);

					String username = "csr523";
						
					String password = TestData.getCellData(sheetName,"Password",row);
				
					String store_id = "523";
							
					Thread.sleep(4000);
					test.log(LogStatus.INFO, "Opened the CSR URL " +Aprop.getProperty("csrURL"));



					test.log(LogStatus.INFO, "CSR Application is launched " );

					driver = new InternetExplorerDriver();
					
			//============= For report purpose to get browser info =======
					Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

					String browserName = cap.getBrowserName();

					reports.addSystemInfo("Browser",browserName);

					wait = new WebDriverWait(driver, 40000);

					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
					driver.get(Aprop.getProperty("csrURL"));
					
				    driver.findElement(locator(Aprop.getProperty("csr_username"))).sendKeys(username);
			        test.log(LogStatus.PASS, "Username is entered: "+username);
			        
			        

				    driver.findElement(locator(Aprop.getProperty("csr_password"))).clear();
				    driver.findElement(locator(Aprop.getProperty("csr_password"))).sendKeys(password);
			        test.log(LogStatus.PASS, "Password is entered: "+password);
			        
			       
			        driver.findElement(locator(Aprop.getProperty("csr_storeid"))).sendKeys(store_id);
			        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id);
			        //Click Login Button
			        driver.findElement(locator(Aprop.getProperty("csr_login_button"))).click();
			        test.log(LogStatus.PASS, "Clicked on login button");
			        
			       Thread.sleep(5000);
			       
			       driver.get(Aprop.getProperty("csrURL"));
			       Thread.sleep(3000);
			       
			       test.log(LogStatus.PASS, "<FONT color=green> Login Successfully"); 
			       test.log(LogStatus.INFO, "******************************************************** ");
			       break;

				}	

			}
	}
	public static void logout(String SSN,String AppURL){

		try{
			driver.switchTo().defaultContent();
			driver.switchTo().frame("topFrame");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='icons']/li[7]/a")).click();
			test.log(LogStatus.PASS, "Clicked On logout Button");
			Thread.sleep(5000);
			if(driver.getTitle().contains("Login")){
		    	 test.log(LogStatus.PASS, "<FONT color=green> Logout Successfully"); 
		    	 test.log(LogStatus.INFO, "******************************************************** ");
		    	 Thread.sleep(3000);
		    	 //driver.quit();
		    	 driver.close();
		    	 Thread.sleep(3000);
		     }
		    else{
					test.log(LogStatus.PASS, "<FONT color=Red> Logout was unsuccessfull"); 
				}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}}

