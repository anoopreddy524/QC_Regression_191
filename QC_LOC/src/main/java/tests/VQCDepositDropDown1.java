package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class VQCDepositDropDown1 extends QCStore{
	public static void depositDropDown(String SSN,String AppURL)
	 {
	   
	  try{
	    test.log(LogStatus.PASS, "************depositDropDown started****************");
	    //Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/CSR/"+FileName);
	    
	    int lastrow=TestData.getLastRow("Deposit");
	    String sheetName="Deposit";
	    for(int row=2;row<=lastrow;row++)
	    {  
	     String RegSSN = TestData.getCellData(sheetName,"SSN",row);
	     if(SSN.equals(RegSSN))
	     {
	     String PIN = TestData.getCellData(sheetName,"PIN",row);
	     String Deposit_Type = TestData.getCellData(sheetName,"Deposit_Type",row);
	         
	           
	           String ProductID = TestData.getCellData(sheetName,"ProductID",row);
	          String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
	         
	             String SSN1 = SSN.substring(0, 3);
	             String SSN2 = SSN.substring(3,5);
	             String SSN3 = SSN.substring(5,9);
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
	     driver.switchTo().frame("topFrame");
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
	           driver.findElement(By.cssSelector("li[id='910000']")).click(); 
	 
	     test.log(LogStatus.PASS, "Clicked on Loan Transactions");
	     Thread.sleep(3000);
	     driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	     driver.switchTo().defaultContent();
	     driver.switchTo().frame("mainFrame");
	    
	     driver.findElement(By.cssSelector("li[id='911101']")).click();   
	     test.log(LogStatus.PASS, "Clicked on Transactions");  
	     driver.switchTo().frame("main");  
	     driver.findElement(By.name("ssn1")).sendKeys(SSN1);
	     test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
	     driver.findElement(By.name("ssn2")).sendKeys(SSN2);
	     test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
	     driver.findElement(By.name("ssn3")).sendKeys(SSN3);
	     test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
	     driver.findElement(By.name("submit1")).click();
	     test.log(LogStatus.PASS, "Click on submit Button");  
	     for(String winHandle : driver.getWindowHandles()){
	        driver.switchTo().window(winHandle);
	     }
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame("mainFrame");
	        driver.switchTo().frame("main");
	    
	        driver.findElement(By.name("button")).click();
	     test.log(LogStatus.PASS, "Clicked on Go button under search results");
	     // driver.findElement(By.name("button")).click();
	     
	           
	         driver.switchTo().defaultContent();
	         driver.switchTo().frame("mainFrame");
	         driver.switchTo().frame("main");
	        // driver.findElement(By.name("button")).click();
	         
	    
	          //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
	         driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
			 test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
			 Thread.sleep(8000);
	         driver.findElement(By.name("transactionList")).sendKeys( "ACH Deposit");
	         test.log(LogStatus.PASS, "Transaction type is selected as ACH Deposit");
	         //driver.findElement(By.id("go_Button")).click();
	         driver.findElement(By.name("button")).click();
	         test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
	         driver.findElement(By.name("requestBean.chkName")).click();
	         test.log(LogStatus.PASS, " Selected checkbox under Checks to be ACHD");
	         
	         
	         driver.findElement(By.name("CmdReturnPosting")).click();
	         test.log(LogStatus.PASS, " Cliked on next button");
	         
	         driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
	         test.log(LogStatus.PASS, " Entered password");
	         
	         driver.findElement(By.name("Submit22")).click();
	         test.log(LogStatus.PASS, " cliked on finish ACH deposit button");
	         Thread.sleep(2000);
      if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
	         {
	        test.log(LogStatus.PASS, " Deposit from CSR is successfull");
	        test.log(LogStatus.PASS, "********************************************** ");
	       }
      else{
    	  test.log(LogStatus.INFO, ESign_CollateralType+" Deposit from CSR is Not successfull");
	        test.log(LogStatus.PASS, "********************************************** ");
      }
	     }
	    }
	  }
	       
	       
	      
	      /* {
	        for( String winHandle1 : driver.getWindowHandles())
	        {
	            driver.switchTo().window(winHandle1);
	        }*/   
	    /*     driver.switchTo().defaultContent();
	         driver.switchTo().frame("mainFrame");
	         driver.switchTo().frame("main");
	         String loan_number= driver.findElement(locator(Vprop.getProperty("csr_loan_nbr"))).getText();
	         test.log(LogStatus.PASS, "Loan Number is" + loan_number);
	         driver.findElement(By.name("transactionList")).sendKeys(ESign_CollateralType+" Deposit");
	         test.log(LogStatus.PASS, "Transaction type is selected"+ESign_CollateralType+" Deposit");
	         driver.findElement(By.id("go_Button")).click();
	         test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
	         
	         driver.findElement(By.name("transactionDataBean.chk21ReDepType")).sendKeys(Deposit_Type);
	         test.log(LogStatus.PASS, " Select the Deposit_Type as"+Deposit_Type);
	         
	        
	         driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
	         test.log(LogStatus.PASS, " Entered password "+PIN);
	         
	         driver.findElement(By.name("finish")).click();
	         test.log(LogStatus.PASS, " click on finish deposit button");
	     }
	    */
	  
	     
	    
	         
	       /*  if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
	         {
	        // test.log(LogStatus.PASS, " ACH Deposit completed sucessfully");
	      
	        //test.log(LogStatus.PASS, MarkupHelper.createLabel(ESign_CollateralType+" Deposit from CSR is successfull", ExtentColor.GREEN));
	        test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
	        test.log(LogStatus.PASS, "********************************************** ");
	         }*/
	       
	/*       if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
	       {
	        for( String winHandle1 : driver.getWindowHandles())
	        {
	            driver.switchTo().window(winHandle1);
	        }   
	         driver.switchTo().defaultContent();
	         driver.switchTo().frame("mainFrame");
	         driver.switchTo().frame("main");
	         driver.findElement(By.name("transactionList")).sendKeys("DebitCard Deposit");
	         test.log(LogStatus.PASS, "Transaction type is selected"+ESign_CollateralType+" Deposit");
	         driver.findElement(By.id("go_Button")).click();
	         test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
	         driver.findElement(locator(Vprop.getProperty("ACH_process_now"))).click();
	         
	         test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
	         test.log(LogStatus.PASS, "********************************************** ");
	        
	       }
	       
	       break;
	       
	     }
	     else{
	     // test.log(LogStatus.FAIL, "RegSSN and SSN not matching ");
	     }
	    
	     }
	    
	  
	    
	  }*/
	  catch (Exception e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	   //test.log(LogStatus.FAIL, MarkupHelper.createLabel("Deposit from CSR is failed", ExtentColor.RED));
	   test.log(LogStatus.FAIL, "Deposit from CSR is failed");

	  }
	 
	 }
}
	 

	

