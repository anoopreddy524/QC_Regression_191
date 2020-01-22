package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCDrawerAssign extends QCStore{
	public static void drawerAssign(String SSN,String AppURL) throws InterruptedException
	{
		int lastrow=TestData.getLastRow("Drawer_Assign");
		String sheetName="Drawer_Assign";
		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);	

			if(SSN.equals(RegSSN))
			{

				String Password = TestData.getCellData(sheetName,"Password",row);

				String NoOfDollarsAmount = TestData.getCellData(sheetName,"CountofDollarCoins",row);

				test.log(LogStatus.INFO, "Drawer assign process initiated" );
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Cash Management')]")));

				driver.findElement(By.xpath("//*[contains(text(),'Cash Management')]")).click();
				test.log(LogStatus.PASS, "Clicked on Cash Management");
				Thread.sleep(1000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
		
				driver.findElement(By.linkText("Drawer")).click();
				test.log(LogStatus.PASS, "Clicked on Drawer");
	
				Thread.sleep(500);
				driver.findElement(By.linkText("Assign")).click();
				test.log(LogStatus.PASS, "Clicked on Assign");
				
				Actions action = new Actions(driver);
				action.moveByOffset(200,100).perform();
				Thread.sleep(2000);
				action.click();
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.name("drawerAssignRequestBean.noOf100Dollars")).sendKeys(NoOfDollarsAmount);
				test.log(LogStatus.PASS,"Count of Dollar Coins is entered as 500");
				Thread.sleep(500);
				driver.findElement(By.name("drawerAssignRequestBean.password")).sendKeys(Password);
				test.log(LogStatus.PASS,"Entered the Password as: "+Password);
				driver.findElement(By.name("drawerassign")).click();
				test.log(LogStatus.PASS,"Clicked on Drawer assign ");
				Thread.sleep(5000);
				//try {
					Alert alert = driver.switchTo().alert();
					String almsg=alert.getText();
					test.log(LogStatus.PASS,"alert with message"+almsg);
					
					if (almsg.contains("Warning")){
						
					alert.accept();
					test.log(LogStatus.PASS,"alert handled" );
					
					Thread.sleep(20000);
					driver.findElement(By.name("done")).click();
					test.log(LogStatus.PASS,"clicked on Ok ");
					test.log(LogStatus.PASS,"Drawer assigned successfully");
					
					
					}
					else
					{
						alert.accept();
						test.log(LogStatus.PASS,"alert handled with messgae safe doesn't contain cash " );
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.findElement(By.linkText("Safe")).click();
						test.log(LogStatus.PASS, "Clicked on Safe");	
						Thread.sleep(3000);
						
						driver.findElement(By.xpath("//*[@id='406']/a")).click();

						test.log(LogStatus.PASS, "Clicked on safe cash-In");

						Actions action1 = new Actions(driver);
						action1.moveByOffset(200,100).perform();
						Thread.sleep(3000);
						action1.click();

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						
						driver.findElement(By.name("safeCashInRequestBean.noOf100Dollars")).sendKeys("500");
						test.log(LogStatus.PASS,"Count of Dollar Coins is entered as 500");
						
						driver.findElement(By.name("safeCashInRequestBean.password")).sendKeys(Password);
						test.log(LogStatus.PASS,"Entered the Password as: "+Password);
						driver.findElement(By.name("cashIn")).click();
						test.log(LogStatus.PASS,"Clicked on finish");
						
						try { 
							Alert alert1 = driver.switchTo().alert();
							test.log(LogStatus.PASS, "Accepting alert with message"+alert.getText());
							alert1.accept();
							
							//if alert present, accept and move on.														

						}
						catch (NoAlertPresentException e) {
							//do what you normally would if you didn't have the alert.

						}
						Thread.sleep(2500);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						if(driver.findElement(By.xpath("//input[(@type='submit') and (@value='Ok')]")).isDisplayed())
						{
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[(@type='submit') and (@value='Ok')]")).click();
							test.log(LogStatus.PASS,"Clicked on OK button");
							test.log(LogStatus.PASS,"Safe cash in successfully");

						}
						else
						{
							test.log(LogStatus.FAIL,"Safe cash -In failed");
						}
						Thread.sleep(2000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
				
						driver.findElement(By.linkText("Drawer")).click();
						test.log(LogStatus.PASS, "Clicked on Drawer");
			
						Thread.sleep(500);
						driver.findElement(By.linkText("Assign")).click();
						test.log(LogStatus.PASS, "Clicked on Assign");
						
						Actions action2 = new Actions(driver);
						action2.moveByOffset(200,100).perform();
						Thread.sleep(2000);
						action2.click();
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						driver.findElement(By.name("drawerAssignRequestBean.noOf100Dollars")).sendKeys(NoOfDollarsAmount);
						test.log(LogStatus.PASS,"Count of Dollar Coins is entered as 500");
						Thread.sleep(500);
						driver.findElement(By.name("drawerAssignRequestBean.password")).sendKeys(Password);
						test.log(LogStatus.PASS,"Entered the Password as: "+Password);
						driver.findElement(By.name("drawerassign")).click();
						test.log(LogStatus.PASS,"Clicked on Drawer assign ");
						Thread.sleep(6000);
						try {
							Alert alert5 = driver.switchTo().alert();
							test.log(LogStatus.PASS, "Accepting alert with message"+alert5.getText());
							alert5.accept();
							test.log(LogStatus.PASS," Alert accepted ");

						}
						catch (NoAlertPresentException e) {
						}
						Thread.sleep(20000);
						driver.findElement(By.name("done")).click();
						test.log(LogStatus.PASS,"clicked on Ok ");
						test.log(LogStatus.PASS,"Drawer assigned successfully");
						Thread.sleep(1500);
	
					}
					//test.log(LogStatus.PASS," Alert accepted ");

				/*}
				catch (NoAlertPresentException e) {


				}
*/				
			}


			break; 
		}
	}

}


