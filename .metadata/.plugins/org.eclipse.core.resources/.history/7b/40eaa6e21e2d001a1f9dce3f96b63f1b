package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class JQCAdminLoginLogout extends QCStore {
	

	public static void login(String SSN, String NextDueDate)
	{
		try{
			
			int lastrow=TestData.getLastRow((Jprop.getProperty("Login")));
			String sheetName=Jprop.getProperty("Login");
			System.out.println("...."+sheetName);
			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				//String admin_url = TestData.getCellData(sheetName,"AdminURL",row);
				String admin_url =Jprop.getProperty("AdminURL");

				String uname = TestData.getCellData(sheetName,"AdminUserName",row);
				String pwd = TestData.getCellData(sheetName,"AdminPassword",row);
				
				if(SSN.equals(RegSSN))
				{	
			
					Thread.sleep(4000);
					test.log(LogStatus.INFO, "Opened the CSR URL " +admin_url);
					test.log(LogStatus.INFO, "admin Application is launched " );
					if(Jprop.getProperty("login_method").equalsIgnoreCase("local"))
					{
						driver = new InternetExplorerDriver();
					}
					else
					{
						String Node = "http://192.168.1.182:5555/wd/hub";
						 //String Node2 = "http://192.168.0.238:5566/wd/hub";
						 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
						 driver = new RemoteWebDriver(new URL(Node), cap);	
					}
					
						/*String Node = "http://192.168.2.164:5555/wd/hub";
					  DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
					 
					 
						System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");

						driver = new RemoteWebDriver(new URL(Node), cap);*/
					wait = new WebDriverWait(driver, 40000);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);				
					driver.get(admin_url);
					driver.findElement(locator(Jprop.getProperty("admin_uname"))).clear();
					driver.findElement(locator(Jprop.getProperty("admin_uname"))).sendKeys(uname);
				    test.log(LogStatus.PASS, "Username is entered: "+uname);
				    driver.findElement(locator(Jprop.getProperty("admin_pwd"))).clear();
					driver.findElement(locator(Jprop.getProperty("admin_pwd"))).sendKeys(pwd);
				    test.log(LogStatus.PASS, "Password is entered: "+pwd);
				    driver.findElement(locator(Jprop.getProperty("admin_submit_btn"))).click();
				    test.log(LogStatus.PASS, "Clicked on login button");  
				    Thread.sleep(5000);
				    break;
				}
			}
			}		
		catch (Exception e) {
			test.log(LogStatus.FAIL,"admin login is failed");
			e.printStackTrace();
		}
	}
	public static void logout(String SSN, String NextDueDate)
	{
			
			try{
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
			    System.out.println("Enterd into top frame");
			    driver.findElement(locator(Jprop.getProperty(("admin_logout_link")))).click();
		        test.log(LogStatus.PASS, "Clicked On logout Button");
		        System.out.println("clicked on logout"); 
		     
		     if(driver.getTitle().contains("Login")){
		    	 test.log(LogStatus.PASS, "Logout is Successfully"); 
		    	 test.log(LogStatus.INFO, "loggged out from the Admin Application");

		     driver.close();
		     }
		    else{
		    	 test.log(LogStatus.PASS, "Logout was unsuccessfull"); 
		     }

			}		
		catch (Exception e) {
			test.log(LogStatus.FAIL,"admin login is failed");
			e.printStackTrace();
		}
	}
}
