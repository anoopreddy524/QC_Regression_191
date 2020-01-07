package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class QCSafeAssign extends QCStore{
	public static void safeAssign(String SSN,String AppURL) throws Exception
	{
		int i;
		for(i=0;i<3;i++)
		{
			driver.get(prop.getProperty("login_page")); 
		try{
			//String FileName= prop.getProperty("QC_Store_NewLoan_file_name");
			
		//	ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("SafeAssign");
				String sheetName="SafeAssign";
				//String sheetName_new="Login";

				for(int row=2;row<=lastrow;row++)
				{		
					
				
						//test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR Application is launched", ExtentColor.BLUE));
						String RegSSN = TestData.getCellData(sheetName,"SSN",row);
						if(SSN.equals(RegSSN))
						{
						//String UserName = TestData.getCellData(sheetName,"UserName",row);
						String Password = TestData.getCellData(sheetName,"Password",row);
						String NoOfDollarsAmount = TestData.getCellData(sheetName,"NoOfDollarsAmount",row);

						test.log(LogStatus.INFO, "Safe assign process initiated" );
						Thread.sleep(4000);
						driver.switchTo().defaultContent();				
						driver.switchTo().frame("topFrame");
						Thread.sleep(4000);
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Cash Management')]")));

						driver.findElement(By.xpath("//*[contains(text(),'Cash Management')]")).click();			
						test.log(LogStatus.PASS, "Clicked on Cash Management");
						Thread.sleep(4000);
					
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						
						//driver.findElement(By.cssSelector("li[id='911101']")).click();	
						driver.findElement(By.linkText("Safe")).click();
						test.log(LogStatus.PASS, "Clicked on Safe");	
						Thread.sleep(4000);
						//driver.findElement(By.xpath("//*[@id="931010"]/a']")).click();
						//driver.findElement(By.linkText("Drawer")).click();
						driver.findElement(locator(prop.getProperty("safe_assign_assign_link"))).click();
						
						
						test.log(LogStatus.PASS, "Clicked on Assign");
						

											//login.Login(UserName, Password, StoreId, driver, AppURL, test);
						 Thread.sleep(5000);

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						
						try{
							Thread.sleep(4000);
							driver.findElement(locator(prop.getProperty("safe_click_somewhere"))).click();
							driver.findElement(locator(prop.getProperty("safe_assign_next"))).click();
							
							
							test.log(LogStatus.PASS, "Clicked on Next button");
							
							
							try{
								Thread.sleep(5000);
								driver.findElement(locator(prop.getProperty("safe_assign_yes_btn"))).click();
								test.log(LogStatus.PASS, "Clicked on Yes button ");
							}
							catch(Exception e)
							{
								System.out.println("unable to click yes button");
							}
							
							//driver.findElement(locator(prop.getProperty("safe_assign_yes_btn"))).click();
							
							Thread.sleep(5000);
							driver.switchTo().defaultContent();				
							driver.switchTo().frame("topFrame");
							driver.findElement(By.xpath("//*[contains(text(),'Cash Management')]")).click();			
							test.log(LogStatus.PASS, "Clicked on Cash Management");
							Thread.sleep(5000);
						
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							Thread.sleep(4000);
							//driver.findElement(By.cssSelector("li[id='911101']")).click();	
							driver.findElement(By.linkText("Safe")).click();
							test.log(LogStatus.PASS, "Clicked on Safe");	
							Thread.sleep(4000);
							//driver.findElement(By.xpath("//*[@id="931010"]/a']")).click();
							//driver.findElement(By.linkText("Drawer")).click();
							driver.findElement(locator(prop.getProperty("safe_assign_assign_link"))).click();
							Thread.sleep(4000);
							
							test.log(LogStatus.PASS, "Clicked on Assign");
							

												//login.Login(UserName, Password, StoreId, driver, AppURL, test);
							 Thread.sleep(1000);

							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
						}
						catch (Exception e) {
							// TODO: handle exception
						}
						Thread.sleep(4000);
						driver.findElement(By.name("safeAssignRequestBean.empPwd")).sendKeys(Password);
						
						test.log(LogStatus.PASS, "Entered the Password: "+Password);
						Thread.sleep(4000);
						driver.findElement(By.name("safeAssignRequestBean.noOf100Dollars")).sendKeys(NoOfDollarsAmount);

						test.log(LogStatus.PASS, "Entered the amount 500 under No of Dollars");
						Thread.sleep(4000);
						driver.findElement(By.name("safeassign")).click();
						test.log(LogStatus.PASS, "Clicked on Finish Safe");
						try { 
						    Alert alert = driver.switchTo().alert();
						    alert.accept();
						    //if alert present, accept and move on.														
							
						}
						catch (NoAlertPresentException e) {
						    //do what you normally would if you didn't have the alert.
							
						}
						
						try{
							Thread.sleep(4000);
							driver.findElement(By.name("safeAssignRequestBean.empPwd")).sendKeys(Password);
							
							test.log(LogStatus.PASS, "Entered the Password: "+Password);
							Thread.sleep(2000);
							driver.findElement(By.name("safeAssignRequestBean.noOf100Dollars")).sendKeys(NoOfDollarsAmount);

							test.log(LogStatus.PASS, "Entered the amount 500 under No of Dollars");
							driver.findElement(By.name("safeassign")).click();
							test.log(LogStatus.PASS, "Clicked on Finish Safe");
							try { 
							    Alert alert = driver.switchTo().alert();
							    alert.accept();
							    //if alert present, accept and move on.														
								
							}
							catch (NoAlertPresentException e) {
							    //do what you normally would if you didn't have the alert.
								
							}
						}
						catch(Exception e)
						{
							
						}
						try{
							//driver.findElement(By.name("safeAssignRequestBean.empPwd")).sendKeys(Password);
							
						//	test.log(LogStatus.PASS, "Entered the Password: "+Password);

							Thread.sleep(4000);
							driver.findElement(By.name("safeassign")).click();
							test.log(LogStatus.PASS, "Clicked on Finish Safe");
							try { 
							    Alert alert = driver.switchTo().alert();
							    alert.accept();
							    //if alert present, accept and move on.														
								
							}
							catch (NoAlertPresentException e) {
							    //do what you normally would if you didn't have the alert.
								
							}
						}
						catch(Exception e)
						{
							
						}

						try { 
						    Alert alert = driver.switchTo().alert();
						    alert.accept();
						    //if alert present, accept and move on.														
							
						}
						catch (NoAlertPresentException e) {
						    //do what you normally would if you didn't have the alert.
							
						}
						Thread.sleep(20000);
					

						 driver.switchTo().defaultContent();
						    driver.switchTo().frame("mainFrame");
						    driver.switchTo().frame("main");
						    
						    if(driver.findElement(By.xpath("//input[(@type='submit') and (@value='Ok')]")).isDisplayed())
						    {
						    	Thread.sleep(3000);
						    	 driver.findElement(By.xpath("//input[(@type='submit') and (@value='Ok')]")).click();
						    	 test.log(LogStatus.PASS,"Clicked on OK button");
						    	 test.log(LogStatus.PASS,"Safe assigned successfully with over/short.");
						    	
						    }
						    else
						    {
						    	test.log(LogStatus.FAIL,"Safe not assigned successfully with over/short.");
						    }
						 
						    break;
}
						
				
				}
				break;  // break for FOR loop		
		}

			catch (Exception e) {
				// TODO Auto-generated catch block
				//test.log(LogStatus.FAIL, MarkupHelper.createLabel("CSR login is failed", ExtentColor.RED));
			//	test.log(LogStatus.FAIL,"Safe assign is failed");
				test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
				String screenshotPath = getScreenhot(driver, "Exception");
								test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.INFO, "Safe assign process is initiated again due to Application sync issue");



				e.printStackTrace();
				continue;
			}

		}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "Safe assign is failed");
	
		}
}
}
		