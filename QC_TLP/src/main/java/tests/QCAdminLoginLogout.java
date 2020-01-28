package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class QCAdminLoginLogout extends QCStore {
	

	public static void login(String SSN, String AppURL)
	{
		try{
			
			int lastrow=TestData.getLastRow((prop.getProperty("Login")));
			String sheetName=prop.getProperty("Login");
			System.out.println("...."+sheetName);
			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				String admin_url = TestData.getCellData(sheetName,"AdminURL",row);
				//String admin_url="https://qcuat.qfund.net/cc/adminIndex.do";

				String uname = TestData.getCellData(sheetName,"AdminUserName",row);
				String pwd = TestData.getCellData(sheetName,"AdminPassword",row);
				
				if(SSN.equals(RegSSN))
				{	
			
					Thread.sleep(4000);
					test.log(LogStatus.INFO, "Opened the CSR URL " +admin_url);
					test.log(LogStatus.INFO, "admin Application is launched " );
					driver = new InternetExplorerDriver();
					wait = new WebDriverWait(driver, 40000);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);				
					driver.get(admin_url);
					driver.findElement(locator(prop.getProperty("admin_uname"))).clear();
					driver.findElement(locator(prop.getProperty("admin_uname"))).sendKeys(uname);
				    test.log(LogStatus.PASS, "Username is entered: "+uname);
				    driver.findElement(locator(prop.getProperty("admin_pwd"))).clear();
					driver.findElement(locator(prop.getProperty("admin_pwd"))).sendKeys(pwd);
				    test.log(LogStatus.PASS, "Password is entered: "+pwd);
				    driver.findElement(locator(prop.getProperty("admin_submit_btn"))).click();
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
	public static void logout(String SSN, String AppURL)
	{
			
			try{
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
			    System.out.println("Enterd into top frame");
			    driver.findElement(locator(prop.getProperty(("admin_logout_link")))).click();
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
