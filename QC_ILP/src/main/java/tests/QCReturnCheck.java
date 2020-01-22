package tests;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class QCReturnCheck extends QCStore{


	public static void qcRturn(String SSN,String AppURL) throws Exception
	{
		int i;
		for(i=0;i<3;i++)
		{
			
		
		try{
			
				int lastrow=TestData.getLastRow("ReturnPosting");
				String sheetName="ReturnPosting";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
						
						
						String StoreID = "1709";
						String ReasonForReturn = TestData.getCellData(sheetName,"ReasonForReturn",row);
						String Esign_CollateralType = TestData.getCellData(sheetName,"Esign_CollateralType",row);
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);

						test.log(LogStatus.INFO,"Return Posting process has started");
						
						driver.switchTo().frame("topFrame");
						driver.findElement(By.partialLinkText("Transactions")).click();   
						test.log(LogStatus.PASS, "Clicked on Transactions");

						if (Esign_CollateralType.equals("CHECK"))
						{
							
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						Thread.sleep(1500);
						driver.findElement(By.linkText("Collateral Checks")).click();
						test.log(LogStatus.PASS, "Clicked on Collateral Checks link");
						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");
						Thread.sleep(2500);
						driver.findElement(By.linkText("Installment Loan")).click();

						test.log(LogStatus.PASS, "Clicked on Installment Loan");

						driver.switchTo().defaultContent();

						driver.switchTo().frame("mainFrame");

						Thread.sleep(1500);

						driver.findElement(By.linkText("Return Posting")).click();

						test.log(LogStatus.PASS, "Clicked on Return Posting");

						Thread.sleep(500);
						//.....................Colateral TYPE...........................
						Actions action = new Actions(driver);
						action.moveByOffset(200,100).perform();
						Thread.sleep(10000);
						action.click();

						
							
							Thread.sleep(500);
							
							driver.switchTo().defaultContent();

							driver.switchTo().frame("mainFrame");

							driver.switchTo().frame("main");
							WebElement e3=driver.findElement(By.name("requestBean.locationNbr"));
							e3.click();
							Thread.sleep(2000);
							e3.sendKeys(StoreID);
							test.log(LogStatus.PASS, "Store ID is entered: "+StoreID);
							Thread.sleep(1000);
							driver.findElement(By.name("submit")).click();   
							test.log(LogStatus.PASS, "Clicked on Submit Button");
						    Thread.sleep(3000);
						   
							Thread.sleep(500);
							
							List<WebElement>  rows = driver.findElements(By.xpath("/html/body/table/tbody/tr/td/table[2]/tbody/tr")); 
							//ESign_CheckNbr="987655";
							int n=rows.size();
							for(int j=4;j<=n;j++){
								//loan_nbr="7780256";
								
							String req_loan_number=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[2]/tbody/tr["+j+"]/td[4] ")).getText();
									
							test.log(LogStatus.PASS, "loan number for the check box to check condition "+req_loan_number);

						    if(loan_nbr.toLowerCase().trim().equalsIgnoreCase(req_loan_number.toLowerCase().trim()))
						    {
						    	 test.log(LogStatus.PASS, "Loan number verification successfull");
						    }
						    else
						    {
						    	 test.log(LogStatus.FAIL, "Loan number verification is not successfull");
						    }
						    
						    driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[2]/tbody/tr["+j+"]/td[1]/input")).click();
							test.log(LogStatus.PASS, "Clicked on check box ");
									
							Thread.sleep(500);
							
							driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[2]/tbody/tr["+j+"]/td[9]/select")).sendKeys(ReasonForReturn);
							test.log(LogStatus.PASS, "Return For Reason is: "+ReasonForReturn);

							driver.findElement(By.name("CmdReturnPosting")).click();

							
							test.log(LogStatus.PASS, "Clicked on Finish return check posting");

							Thread.sleep(5000);
						    
							break;
							}
						    
					
						    Thread.sleep(5000);
							
							/*driver.findElement(By.name("checkno")).click();
							 
							test.log(LogStatus.PASS,"Click on Ok Button");*/
							 
							test.log(LogStatus.PASS," Return posting Transaction Completed Successfully");
							test.log(LogStatus.PASS,"***********************************");
							driver.close();
							
						
						}
						if(Esign_CollateralType.equalsIgnoreCase("ACH"))
						{
					

							driver.switchTo().defaultContent();

							driver.switchTo().frame("mainFrame");

							
							Thread.sleep(3000);
							
							driver.findElement(By.linkText("ACH")).click();

							test.log(LogStatus.PASS, "Clicked on ACH link");
							Thread.sleep(5000);
							
							
							
							driver.findElement(By.linkText("Installment Loan")).click();

							test.log(LogStatus.PASS, "Clicked on Installment Loan");		
							

							Thread.sleep(5000);
							
							
							
							Thread.sleep(5000);
							
							
							driver.findElement(By.linkText("ACH Processing(NACHA)")).click();
							//driver.findElement(By.xpath("//*[@id='503019']/a")).click();

							test.log(LogStatus.PASS, "Clicked on ACH Processing(NACHA)");
							
							Thread.sleep(3000);
							
							driver.switchTo().defaultContent();

							driver.switchTo().frame("mainFrame");

							driver.switchTo().frame("main");
							
							driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[1]/font/b/input")).click();
							test.log(LogStatus.PASS, "Clicked on Radiobutton Button");
							
					        Thread.sleep(3000);
							
							driver.switchTo().defaultContent();

							driver.switchTo().frame("mainFrame");

							driver.switchTo().frame("main");
							
							driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);
							test.log(LogStatus.PASS, "Store ID is entered: "+StoreID);
							
							for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							//String business_date="05/14/2018";
							String App_date[] =business_date.split("/");
							System.out.println("business_date");
							
					        String Date1 = App_date[0];
					        System.out.println("Date 1"+Date1);
					        String Date2 = App_date[1];
					        String Date3 = App_date[2];
					        
					        driver.findElement(By.name("fromDate1")).clear();
					        Thread.sleep(500);
					        driver.findElement(By.name("fromDate1")).sendKeys(Date1.trim());
					        test.log(LogStatus.PASS, "Month is entered: "+Date1);
					       
					      
					        driver.findElement(By.name("fromDate2")).clear();
					        Thread.sleep(500);
							driver.findElement(By.name("fromDate2")).sendKeys(Date2.trim());
							test.log(LogStatus.PASS, "Date is entered: "+Date2);
							driver.findElement(By.name("fromDate3")).clear();
							 Thread.sleep(500);
							
							 driver.findElement(By.name("fromDate3")).sendKeys(Date3.trim());
							test.log(LogStatus.PASS, "Year is entered: "+Date3);
							Thread.sleep(500);
							String Todate1 = App_date[0];
					        String Todate2 = App_date[1];
					        String Todate3 = App_date[2];
					        System.out.println("Todate1"+Todate1);

					        driver.findElement(By.name("toDate1")).clear();
					        driver.findElement(By.name("toDate1")).sendKeys(Todate1.trim());
					        test.log(LogStatus.PASS, "Month is entered: "+Todate1);
					        driver.findElement(By.name("toDate2")).clear();
							driver.findElement(By.name("toDate2")).sendKeys(Todate2.trim());
							test.log(LogStatus.PASS, "Date is entered: "+Todate2);
							driver.findElement(By.name("toDate3")).clear();
							driver.findElement(By.name("toDate3")).sendKeys(Todate3.trim());
							test.log(LogStatus.PASS, "Year is entered: "+Todate3);
							Thread.sleep(500);
							driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[3]/tbody/tr/td[2]/input")).click();
							test.log(LogStatus.PASS, "Clicked on Search Button");
							Thread.sleep(500);
							driver.findElement(By.name("CmdReturnPosting")).click();
							test.log(LogStatus.PASS, "Clicked on Process Button");
							Thread.sleep(5000);
							test.log(LogStatus.PASS, "ACH Files created successfully");
							test.log(LogStatus.PASS, "*********************************");
						    driver.close();
							
						}
						break;
						}
							 								
				}
		
				
				break;
		}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Void Trasaction is failed", ExtentColor.RED));
					test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
					String screenshotPath = getScreenhot(driver, "Exception");
									test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					test.log(LogStatus.INFO, "Return Posting Trasaction is initiated due to application sync issue");
					driver.get(prop.getProperty("login_page"));   
					continue;

				}

	}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "Return Posting is failed");
			Assert.assertTrue(false);
	
		}
}
}