package tests;
//This class contains methods for login and logout functionality

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class ATest_LoginLogout extends ATestBase{
	public static String SSN ;
	 
	public static void getSSN() throws Exception{
		String FileName= "QC_BorrowerRegistration_NewLoan_Txn_Testdata.xls";
	    // test.log(LogStatus.PASS, "Registration of Lend Nation started ");
	     Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/CSR/"+FileName);
	           int lastrow=TestData.getLastRow("Start");
	           String sheetName="Start";
	           //int lastrow=TestData.getLastRow("Borrower");
	           System.out.println(lastrow);
	           for(int row=2;row<=lastrow;row++)
	           {
	                   String RunFlag = TestData.getCellData(sheetName,"Run",row);
	                   //System.out.println(RunFlag);
	           if(RunFlag.equals("Y"))
	           {
	                   //driver.get(appUrl);
	                   //test.log(LogStatus.INFO, "Application is launched");
	                   //driver.manage().window().maximize();
	                            
	                            SSN = TestData.getCellData(sheetName,"SSN",row);
	                          // System.out.println(AppURL);
		 }}}

	
	public static void login() throws Exception{
		
	try{
		String FileName= "QC_BorrowerRegistration_NewLoan_Txn_Testdata.xls";
	
	Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/CSR/"+FileName);
	
	//int lastrow=TestData.getLastRow("CSRLogin");
	
	String sheetName="Login";
	int lastrow=TestData.getLastRow("Borrower_Registration");
	
	for(int row=2;row<=lastrow;row++){
	
	String RegSSN = TestData.getCellData(sheetName,"SSN",row);
   
	if(SSN.equals(RegSSN))
	
	{
	
	 String uname=TestData.getCellData(sheetName,"UserName",row);
	 String passwrd=TestData.getCellData(sheetName,"Password",row);
	 String Storeid=TestData.getCellData(sheetName,"StoreID",row);
	 //System.out.println(Appurl+" "+uname+" "+passwrd+""+Storeid);
	 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
	 driver.get(AppURL);
	 test.log(LogStatus.PASS, "Application Launched");
	// String usenameId = "loginRequestBean.userId";
	    String passwordId = "loginRequestBean.password";
	    String StoreId = "loginRequestBean.locNbr";
	    String Login = "login";		
	    driver.findElement(locator(Aprop.getProperty("csr_username"))).sendKeys(uname);
     test.log(LogStatus.PASS, "Username is entered: "+uname);
     //Enter Password	      
	    driver.findElement(By.name(passwordId)).sendKeys(passwrd);;
     test.log(LogStatus.PASS, "Password is entered: "+passwrd);	        	       
     driver.findElement(By.name(StoreId)).sendKeys(Storeid);;
     test.log(LogStatus.PASS, "Storenumber is entered: "+Storeid);
     //Click Login Button
     driver.findElement(By.name(Login)).click();
     test.log(LogStatus.PASS, "Clicked on Submit button");
     
     test.log(LogStatus.INFO, "Login Sucessfully");
	
	}	

}}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	public static void logout(){
		
		try{
			
			
			driver.switchTo().defaultContent();
			 driver.switchTo().frame("topFrame");
			
	driver.findElement(By.xpath("//*[@id='icons']/li[7]/a")).click();
	     test.log(LogStatus.PASS, "Clicked On logout Button");
	     if(driver.getTitle().contains("Login")){
	    	 test.log(LogStatus.PASS, "Logout Successfully"); 
	     //driver.close();
	     }
	    else{
	    	 test.log(LogStatus.PASS, "Logout was unsuccessfull"); 
	     }


	     	
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}}
	
