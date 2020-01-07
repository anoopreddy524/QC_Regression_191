package tests;




import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebDriver;

/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import tests.QCStore;

public class JQCCSRLoginLogout extends QCStore
{
	public static void login(String SSN,String AppURL) throws InterruptedException, MalformedURLException
	{
	
				int lastrow=TestData.getLastRow("Login");
				System.out.println(lastrow);
				String sheetName="Login";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					System.out.println(RegSSN);										

					if(SSN.equals(RegSSN))
					{	
				
						//String csr_url = TestData.getCellData(sheetName,"AppURL",row);
						String csr_url =Jprop.getProperty("csr_url");

						String username = TestData.getCellData(sheetName,"UserName",row);
						System.out.println("ÜN"+username);
						String password = TestData.getCellData(sheetName,"Password",row);
						System.out.println("PWD"+password);
						String store_id = TestData.getCellData(sheetName,"StoreID",row);
						System.out.println("St"+store_id);
						Thread.sleep(4000);
						
						test.log(LogStatus.INFO, "Opened the CSR URL " +csr_url);



						test.log(LogStatus.INFO, "CSR Application is launched " );
						
						if(Jprop.getProperty("login_method").equalsIgnoreCase("local"))
						{
							driver = new InternetExplorerDriver();
							
							//=========== For Browser info in report ===============
							Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

							String browserName = cap.getBrowserName();

							reports.addSystemInfo("Browser",browserName);
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
					
						driver.get(csr_url);
						
					    driver.findElement(locator(Jprop.getProperty("csr_username"))).sendKeys(username);
				        test.log(LogStatus.PASS, "Username is entered: "+username);
				        
				        

					    driver.findElement(locator(Jprop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(Jprop.getProperty("csr_password"))).sendKeys(password);
				        test.log(LogStatus.PASS, "Password is entered: "+password);
				        
				       
				        driver.findElement(locator(Jprop.getProperty("csr_storeid"))).sendKeys(store_id);
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id);
				        //Click Login Button
				        driver.findElement(locator(Jprop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");
				        
				       Thread.sleep(6000);
				       break;
}
					
	}
	}
	
	
public static void logout(String SSN,String AppURL){
		
/*	WebElement webElement = driver.findElement(By.tagName("body"));
	webElement.sendKeys(Keys.TAB);
	webElement.sendKeys(Keys.ENTER);*/
						
			
					
					
					driver.switchTo().defaultContent();
					 driver.switchTo().frame("topFrame");
				     System.out.println("Enterd into top frame");
				     driver.findElement(locator(Jprop.getProperty(("csr_logout_link")))).click();
			     test.log(LogStatus.PASS, "Clicked On logout Button");
			     System.out.println("clicked on logout");
			     
			     
			     //driver.close();
			     driver.quit();


			     	
			}
						
			
		
	
	
	public static void adminLogout(String SSN,String AppURL){
					
					
					try{
						
						
						driver.switchTo().defaultContent();
						 driver.switchTo().frame("topFrame");
						
				driver.findElement(locator(Jprop.getProperty(("admin_logout_link")))).click();
				     test.log(LogStatus.PASS, "Clicked On logout Button");
				     
				     driver.quit();

				     	
				}
							
				
			
			
			catch(Exception e)
			{
				//test.log(LogStatus.ERROR, MarkupHelper.createLabel("CSR logout is failed", ExtentColor.RED));
				test.log(LogStatus.ERROR,"CSR logout is failed");


				e.printStackTrace();
			}
	
}	
}


