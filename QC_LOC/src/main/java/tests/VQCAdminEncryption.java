package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class VQCAdminEncryption extends QCStore
{
	public static String Tran_Nbr;
	public static void getEncryption(WebDriver driver,String SSN,String AppURL) throws InterruptedException
	{
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
				String AdminURL="https://qclocalauto.qfund.net/cc/adminIndex.do";
				// String AdminURL="https://qclocalreg.qfund.net/cc/adminIndex.do";
				//driver.get("AdminURL");
			
				String Tran_cd = TestData.getCellData(sheetName,"Tran_cd",row);
                String Store_no= TestData.getCellData(sheetName,"Store_no",row);
                
				

				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Admin Application is launched", ExtentColor.BLUE));
				test.log(LogStatus.INFO, "********Admin Application is launched********");
				driver = new InternetExplorerDriver();
				wait = new WebDriverWait(driver, 40000);

			
				driver.get(Aprop.getProperty("adminURL"));
				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Opened the Admin URL"+ AdminURL, ExtentColor.BLUE));
				test.log(LogStatus.INFO, "Opened the Admin URL" + Aprop.getProperty("adminURL"));

				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Reading encryption details from Admin has initiated"+ AdminURL, ExtentColor.BLUE));
				test.log(LogStatus.INFO, "Reading encryption details from Admin has initiated"+ Aprop.getProperty("adminURL")); 


				String mainwindow2=driver.getWindowHandle();
			
				System.out.println("In Admin"+ mainwindow2);
	
	DateFormat df=new SimpleDateFormat("MM/dd/yyyy"); 

	driver.findElement(By.name("loginRequestBean.userId")).sendKeys(UserName);

	test.log(LogStatus.PASS, "Username is entered: "+UserName); 

	driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

	test.log(LogStatus.PASS, "Password is entered: "+Password); 

	//Click Login Button

	driver.findElement(By.name("login")).click();

	test.log(LogStatus.PASS, "Clicked on Submit button");

	Thread.sleep(8000);


	driver.switchTo().defaultContent();

	driver.switchTo().frame("topFrame");

	driver.findElement(By.xpath("//*[contains(text(),'Employee')]")).click(); 

	test.log(LogStatus.PASS, "Clicked on Employee tab");

	

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 

	driver.findElement(By.linkText("Encryption Key")).click();

	test.log(LogStatus.PASS, "Clicked on Encryption Key link");



	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.findElement(By.linkText("Encryption")).click();

	test.log(LogStatus.PASS, "Clicked on Encryption");

	Thread.sleep(5000);


	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.switchTo().frame("main");

	driver.findElement(By.name("requestBean.locationNbr")).sendKeys(Store_no);

	test.log(LogStatus.PASS, "Store number Entered"+Store_no); 

	Thread.sleep(1000);

	//driver.findElement(By.name("requestBean.tranNbr")).sendKeys(Tran_Nbr);encryption_transaction_nbr
	driver.findElement(By.name("requestBean.tranNbr")).sendKeys(encryption_transaction_nbr);

	test.log(LogStatus.PASS, "Tran number Entered as: " +encryption_transaction_nbr); 

	Thread.sleep(1000);
	
	driver.findElement(By.name("trancd")).sendKeys(Tran_cd);

	test.log(LogStatus.PASS, "Trancd selected as: "+Tran_cd);

	Thread.sleep(1000);
	
	driver.findElement(By.name("GetKey")).click();

	test.log(LogStatus.PASS, "GetKey clicked");
	

	Thread.sleep(5000);
	
	Eankey = driver.findElement(By.name("EanKey")).getAttribute("value");

	//test.log(LogStatus.PASS, MarkupHelper.createLabel("GetKey captured as:" +Eankey, ExtentColor.GREEN));
	test.log(LogStatus.PASS, "GetKey captured as:" +Eankey);
	test.log(LogStatus.PASS, "..................");
	driver.close();

break;
}
			}	
	
}
}
