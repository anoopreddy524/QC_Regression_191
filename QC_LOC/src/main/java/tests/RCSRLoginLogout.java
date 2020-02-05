package tests;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class RCSRLoginLogout extends QCStore{
	public static void login(String SSN,String AppURL ) throws Exception{

		test.log(LogStatus.PASS, "********Performing Login functionality********");
			//test.log(LogStatus.PASS, "Getting values from file"+FileName);
			
			int lastrow=TestData.getLastRow("Login");
			String sheetName="Login";

			for(int row=2;row<=lastrow;row++){

				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			

				if(SSN.equals(RegSSN))

				{
					
					String username = TestData.getCellData(sheetName,"UserName",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);

				
					
					test.log(LogStatus.INFO,"CSR login has started");

					test.log(LogStatus.INFO,"Opened the CSR URL " +csr_url);


					//test.log(LogStatus.INFO, "CSR Application is launched " );
					test.log(LogStatus.INFO,"CSR Application is launched");

					if(Aprop.getProperty("login_method").equalsIgnoreCase("local"))
					{
						driver = new InternetExplorerDriver();
					}
					else
					{
						String Node = "http://192.168.2.66:5555/wd/hub";
						 //String Node2 = "http://192.168.0.238:5566/wd/hub";
						 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
						 driver = new RemoteWebDriver(new URL(Node), cap);	
					}
					 wait = new WebDriverWait(driver, 40000);

					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
				
					driver.get(Aprop.getProperty("csrURL"));
					 driver.findElement(locator(Aprop.getProperty("csr_username"))).sendKeys(username);
				        test.log(LogStatus.PASS, "Username is entered: "+username);
				        
				        

					    driver.findElement(locator(Aprop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(Aprop.getProperty("csr_password"))).sendKeys(password);
				        test.log(LogStatus.PASS, "Password is entered: "+password);
				        
				       
				        driver.findElement(locator(Aprop.getProperty("csr_storeid"))).sendKeys(store_id);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id);
				        //Click Login Button
				        driver.findElement(locator(Aprop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");
				        
				        

					test.log(LogStatus.INFO, "<FONT color=green> Login Sucessfully");
					test.log(LogStatus.INFO, "******************************************************** ");
					
					Thread.sleep(5000);
					
					driver.get(csrloginpage);
					            
					Thread.sleep(3000);

				}	

			}
	}
	public static void logout(){

		try{
			driver.switchTo().defaultContent();
			driver.switchTo().frame("topFrame");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='icons']/li[7]/a")).click();
			test.log(LogStatus.PASS, "Clicked On logout Button");
			//if(driver.findElement(By.xpath("//*[@id='signoutArea']/div[1]")).getText().contains("Sign out"))
			{
				test.log(LogStatus.PASS, "<FONT color=green> Logout Successfully"); 
				test.log(LogStatus.INFO, "******************************************************** ");
				Thread.sleep(5000);
				//driver.close();
				//Thread.sleep(5000);
				driver.quit();
			}
			/*else{
				test.log(LogStatus.PASS, "<FONT color=Red> Logout was unsuccessfull"); 
			}*/

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}}

