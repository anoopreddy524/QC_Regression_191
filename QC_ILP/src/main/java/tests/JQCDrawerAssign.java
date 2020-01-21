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
				Thread.sleep(1000);
				try {
					Alert alert = driver.switchTo().alert();
					alert.accept();
					test.log(LogStatus.PASS," Alert accepted ");

				}
				catch (NoAlertPresentException e) {


				}
				test.log(LogStatus.PASS,"Drawer assigned successfully");
				Thread.sleep(3000);


				/*driver.findElement(By.name("done")).click();

				test.log(LogStatus.PASS,"clicked on Ok ");*/
			}
			else{
				continue;
			}


			break; 
		}
	}

}

