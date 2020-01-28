package tests;
//This class contains methods for login and logout functionality

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class ACSRLoginLogout extends QCStore{
	public static void login(String SSN,String AppURL ) throws Exception{

		test.log(LogStatus.PASS, "********Performing Login functionality********");
			//test.log(LogStatus.PASS, "Getting values from file"+FileName);
			String sheetName="Login";
			int lastrow=TestData.getLastRow("Login");

			for(int row=2;row<=lastrow;row++){

				String RegSSN = TestData.getCellData(sheetName,"SSN",row);

				if(SSN.equals(RegSSN))

				{
					/*String uname=TestData.getCellData(sheetName,"UserName",row);
					passwrd=TestData.getCellData(sheetName,"Password",row);
					Storeid=TestData.getCellData(sheetName,"StoreID",row);*/
					String uname="csr1706";
					passwrd=TestData.getCellData(sheetName,"Password",row);
					Storeid="1706";
					
					if(prop.getProperty("login_method").equalsIgnoreCase("local"))
					{
						driver = new InternetExplorerDriver();
					}
					else
					{
						String Node = "http://192.168.2.48:5555/wd/hub";
						 //String Node2 = "http://192.168.0.238:5566/wd/hub";
						 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
						 driver = new RemoteWebDriver(new URL(Node), cap);	
					}
					
				 
					 wait = new WebDriverWait(driver, 40000);

					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.get(prop.getProperty("csrURL"));
					test.log(LogStatus.PASS, "Application Launched with URL"+prop.getProperty("csrURL"));
					
					String passwordId = "loginRequestBean.password";
					String StoreId = "loginRequestBean.locNbr";
					String Login = "login";		
					driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(uname);
					test.log(LogStatus.PASS, "Username is entered: "+uname);

					driver.findElement(By.name(passwordId)).sendKeys(passwrd);
					test.log(LogStatus.PASS, "Password is entered: "+passwrd);	        	       
					driver.findElement(By.name(StoreId)).sendKeys(Storeid);
					test.log(LogStatus.PASS, "Storenumber is entered: "+Storeid);
					//Click Login Button
					driver.findElement(By.name(Login)).click();
					test.log(LogStatus.PASS, "Clicked on Submit button");

					test.log(LogStatus.INFO, "<FONT color=green> Login Sucessfully");
					test.log(LogStatus.INFO, "******************************************************** ");
					Thread.sleep(5000);

				}	

			}
	}
	public static void logout(){

		try{
			driver.switchTo().defaultContent();
			driver.switchTo().frame("topFrame");

			driver.findElement(By.xpath("//*[@id='icons']/li[7]/a")).click();
			test.log(LogStatus.PASS, "Clicked On logout Button");
			if(driver.getTitle().contains("Login")){
				test.log(LogStatus.PASS, "<FONT color=green> Logout Successfully"); 
				test.log(LogStatus.INFO, "******************************************************** ");
				driver.close();
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

