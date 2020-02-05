package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class SQCDrawerAssign extends QCStore{
	public static void drawerAssign(String SSN,String AppURL) throws InterruptedException
	{
		
		
				int lastrow=TestData.getLastRow("NewLoan");
				String sheetName="NewLoan";
				//String sheetName_new="Login";

				for(int row=2;row<=lastrow;row++)
				{		
					
				
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);	
						//test.log(LogStatus.INFO, MarkupHelper.createLabel("CSR Application is launched", ExtentColor.BLUE));
						
						if(SSN.equals(RegSSN))
						{
						
						//String UserName = TestData.getCellData(sheetName,"UserName",row);
						String Password = TestData.getCellData(sheetName,"Password",row);
						
						String NoOfDollarsAmount = TestData.getCellData(sheetName,"NoOfDollarsAmount",row);
						

						
						test.log(LogStatus.INFO, "Drawer assign process initiated" );
						 Thread.sleep(4000);
						 driver.switchTo().defaultContent();
		                    driver.switchTo().frame("topFrame");
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Cash Management')]")));

		                    driver.findElement(By.xpath("//*[contains(text(),'Cash Management')]")).click();
		                    test.log(LogStatus.PASS, "Clicked on Cash Management");
		                    Thread.sleep(5000);
		                 
		                    driver.switchTo().defaultContent();
		                    driver.switchTo().frame("mainFrame");
		                    //driver.switchTo().frame("main");
		                 
		                    //driver.findElement(By.cssSelector("li[id='911101']")).click();
		                    driver.findElement(By.linkText("Drawer")).click();
		                    test.log(LogStatus.PASS, "Clicked on Drawer");
		                    //driver.findElement(By.xpath("//*[@id="931010"]/a']")).click();
		                    //driver.findElement(By.linkText("Drawer")).click();
		                    driver.switchTo().defaultContent();
		                    driver.switchTo().frame("mainFrame");
		                    //driver.switchTo().frame("main");
		                    Thread.sleep(3000);
		                    driver.findElement(By.linkText("Assign")).click();
		                    test.log(LogStatus.PASS, "Clicked on Assign");
		                    Thread.sleep(4000);
		                    driver.switchTo().defaultContent();
		                    driver.switchTo().frame("mainFrame");
		                    driver.switchTo().frame("main");

		                    driver.findElement(By.name("drawerAssignRequestBean.noOf100Dollars")).sendKeys(NoOfDollarsAmount);
		                    test.log(LogStatus.PASS,"Count of Dollar Coins is entered as 500");
		                    Thread.sleep(4000);
		                    driver.findElement(By.name("drawerAssignRequestBean.password")).sendKeys(Password);
		                    test.log(LogStatus.PASS,"Entered the Password as: "+Password);
		                    driver.findElement(By.name("drawerassign")).click();
		                    test.log(LogStatus.PASS,"Clicked on Drawer assign ");
		                    try {
		                            Alert alert = driver.switchTo().alert();
		                            alert.accept();
		                            test.log(LogStatus.PASS," Alert accepted ");

		                    }
		                    catch (NoAlertPresentException e) {
		                        

		                    }
		                   // if(driver.findElement(By.xpath("//input[(@type='button') and (@value='Ok')]")).isDisplayed())
						    {
						    		Thread.sleep(10000);
						    	 test.log(LogStatus.PASS,"Drawer assigned successfully");
						    	// driver.findElement(By.xpath("//input[(@type='button') and (@value='Ok')]")).click();
						    	 driver.findElement(By.name("done")).click();
						    	 //driver.findElement(By.name("done")).click();
						    }
						  //  else
						    {
						 //   	test.log(LogStatus.PASS,"Drawer not assigned successfully");
						    }
						    
		                  break; 
						}
				}
		
				
		
		
	
}
}
		