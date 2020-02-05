package tests;




import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import tests.QCStore;

public class VQCCSRLogin2997 extends QCStore
{
	public static void login(String SSN,String AppURL)
	{
		try{
			//String FileName= Aprop.getProperty("QC_Store_NewLoan_file_name");
			
		//	ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Login");
				String sheetName="Login";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					//String csr_url = TestData.getCellData(sheetName,"csr_url",row);
					String csr_url="https://qclocalauto.qfund.net/cc/demoIndex.do"; 

					//String username = TestData.getCellData(sheetName,"UserName",row);
					String username = "admin";
					//String password = TestData.getCellData(sheetName,"Password",row);
					String password = "advance";
					//String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String store_id = "2997";
					


					if(SSN.equals(RegSSN))
					{	
				
						Thread.sleep(4000);
						//test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);
						//test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR login has started", ExtentColor.BLUE));

						//test.log(LogStatus.INFO, MarkupHelper.createLabel("Opened the CSR URL " +AppURL, ExtentColor.BLUE));
						test.log(LogStatus.INFO, "<FONT color=green style=Calibri > Opened the CSR URL " +csr_url);



						test.log(LogStatus.INFO, "CSR Application is launched " );
						//test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR Application is launched", ExtentColor.BLUE));

						if(Aprop.getProperty("login_method").equalsIgnoreCase("local"))
						{
							driver = new InternetExplorerDriver();
						}
						else
						{
							String Node = Aprop.getProperty("login_node");  // Added in jan21.1
							 //String Node2 = "http://192.168.0.238:5566/wd/hub";
							 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
							 driver = new RemoteWebDriver(new URL(Node), cap);	
						}
						 wait = new WebDriverWait(driver, 40000);

						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
						driver.get(csr_url);
						
						
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
				        
				       Thread.sleep(8000);
				       break;
}
					
	}
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		//test.log(LogStatus.FAIL, MarkupHelper.createLabel("CSR login is failed", ExtentColor.RED));
		test.log(LogStatus.FAIL,"CSR login is failed");


		e.printStackTrace();
	}

}
	
	public static void logout(){

		try{
			driver.switchTo().defaultContent();
			driver.switchTo().frame("topFrame");

			driver.findElement(By.xpath("//*[@id='icons']/li[7]/a")).click();
			test.log(LogStatus.PASS, "Clicked On logout Button");
			if(driver.findElement(By.xpath("//*[@id='signoutArea']/div[1]")).getText().contains("Sign out")){
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
	}	
	public static void adminLogin(WebDriver driver,String SSN,String csr_url){
					
					
		try{
			int lastrow=TestData.getLastRow("Login");
			String sheetName="Login";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
				String UserName = TestData.getCellData(sheetName,"AdminUserName",row);
				String Password = TestData.getCellData(sheetName,"AdminPassword",row);
				//String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
				String AdminURL = "https://qclocalauto.qfund.net/cc/adminIndex.do";
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				String Tran_cd = TestData.getCellData(sheetName,"Tran_cd",row);
                

				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Admin Application is launched", ExtentColor.BLUE));
				test.log(LogStatus.INFO, "********Admin Application is launched********");


				driver = new InternetExplorerDriver();
				wait = new WebDriverWait(driver, 40000);

				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
			
				driver.get(AdminURL);
				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Opened the Admin URL"+ AdminURL, ExtentColor.BLUE));
			//	test.log(LogStatus.INFO, "Opened the Admin URL" + AdminURL);

/*	driver.findElement(By.name("loginRequestBean.userId")).sendKeys(UserName);

	test.log(LogStatus.PASS, "Username is entered: "+UserName); 

	driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

	test.log(LogStatus.PASS, "Password is entered: "+Password); 

	//Click Login Button

	driver.findElement(By.name("login")).click();

	test.log(LogStatus.PASS, "Clicked on Submit button");
	
	driver.switchTo().defaultContent();

	driver.switchTo().frame("topFrame");

	driver.findElement(locator(Aprop.getProperty("admin_store_setup_tab"))).click(); 

	test.log(LogStatus.PASS, "Clicked on Store tab");

				       break;*/
}
					
	}
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		//test.log(LogStatus.FAIL, MarkupHelper.createLabel("CSR login is failed", ExtentColor.RED));
		test.log(LogStatus.FAIL,"Admin login is failed");


		e.printStackTrace();
	}


	
}	
	public static void adminLogout(WebDriver driver,String SSN,String csr_url){
		
		
		try{
			
			
			driver.switchTo().defaultContent();
			 driver.switchTo().frame("topFrame");
			
	driver.findElement(locator(Aprop.getProperty(("admin_logout_link")))).click();
	     test.log(LogStatus.PASS, "Clicked On logout Button");
	     if(driver.getTitle().contains("Login")){
	    	 test.log(LogStatus.PASS, "Logout is Successfully"); 
	    	 //test.log(LogStatus.INFO, MarkupHelper.createLabel("loggged out from the Admin Application", ExtentColor.BLUE));
	    	 test.log(LogStatus.INFO, "loggged out from the Admin Application");

	     driver.close();
	     }
	    else{
	    	 test.log(LogStatus.FAIL, "Logout was unsuccessfull"); 
	     }


	     	
	}
				
	


catch(Exception e)
{
	//test.log(LogStatus.ERROR, MarkupHelper.createLabel("CSR logout is failed", ExtentColor.RED));
	test.log(LogStatus.ERROR,"Admin logout is failed");


	e.printStackTrace();
}

}
}


