package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCSafeAssign extends QCStore{
	public static void safeAssign(String SSN,String AppURL) throws InterruptedException
	{
		int lastrow=TestData.getLastRow("SafeAssign");
		String sheetName="SafeAssign";

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				//String UserName = TestData.getCellData(sheetName,"UserName",row);
				String Password = TestData.getCellData(sheetName,"Password",row);
				String NoOfDollarsAmount = TestData.getCellData(sheetName,"NoOfDollarsAmount",row);

				test.log(LogStatus.INFO, "Safe assign process initiated" );
				Thread.sleep(2000);
				driver.switchTo().defaultContent();				
				driver.switchTo().frame("topFrame");

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Cash Management')]")));

				driver.findElement(By.xpath("//*[contains(text(),'Cash Management')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Cash Management");
				Thread.sleep(1500);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.linkText("Safe")).click();
				test.log(LogStatus.PASS, "Clicked on Safe");	
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id='932010']/a")).click();

				test.log(LogStatus.PASS, "Clicked on Assign");

				Actions action = new Actions(driver);
				action.moveByOffset(200,100).perform();
				Thread.sleep(5000);
				action.click();

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				try{
				
					Thread.sleep(500);
					
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[6]/td/input")).click();

					test.log(LogStatus.PASS, "Clicked on Next button");


					try{
						Thread.sleep(1500);
						
						driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td[1]/input")).click();
						test.log(LogStatus.PASS, "Clicked on Yes button ");
					}
					catch(Exception e)
					{
						System.out.println("unable to click yes button");
					}

					

					Thread.sleep(2000);
					driver.switchTo().defaultContent();				
					driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[contains(text(),'Cash Management')]")).click();			
					test.log(LogStatus.PASS, "Clicked on Cash Management");
					Thread.sleep(500);

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.findElement(By.linkText("Safe")).click();
					test.log(LogStatus.PASS, "Clicked on Safe");	
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='932010']/a")).click();
					test.log(LogStatus.PASS, "Clicked on Assign");

					Actions action1 = new Actions(driver);
					action1.moveByOffset(200,100).perform();
					Thread.sleep(2000);
					action1.click();

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				Thread.sleep(2500);
				driver.findElement(By.name("safeAssignRequestBean.empPwd")).sendKeys(Password);

				test.log(LogStatus.PASS, "Entered the Password: "+Password);
				Thread.sleep(500);
				driver.findElement(By.name("safeAssignRequestBean.noOf100Dollars")).sendKeys(NoOfDollarsAmount);
				test.log(LogStatus.PASS, "Entered the amount 500 under No of Dollars");
				Thread.sleep(500);
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
					Thread.sleep(500);
					driver.findElement(By.name("safeAssignRequestBean.empPwd")).sendKeys(Password);

					test.log(LogStatus.PASS, "Entered the Password: "+Password);
					Thread.sleep(500);
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
				Thread.sleep(3000);


				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				if(driver.findElement(By.xpath("//input[(@type='submit') and (@value='Ok')]")).isDisplayed())
				{
					Thread.sleep(2000);
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


	}
}
