package tests;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;
public class ACSRMidDayDeposit extends QCStore {

	public static void middeposit() throws InterruptedException{

		test.log(LogStatus.INFO, "****Performing Mid day deposit scenario******");
		Thread.sleep(1000);
		driver.switchTo().frame("topFrame");
		driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
		test.log(LogStatus.PASS, "Clicked on Cash Management");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.xpath("//*[@id='932000']/a")).click();	
		test.log(LogStatus.PASS, "Clicked on Safe button");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='932050']/a")).click();	
		test.log(LogStatus.PASS, "Clicked on Deposit button");
		Thread.sleep(3000);
		driver.switchTo().frame("main");
		WebElement e= driver.findElement(By.name("safeDepositRequestBean.noOfDollars"));
		e.click();
		e.sendKeys("0");
		test.log(LogStatus.PASS, "Enterd count of dollar coins :"+"0");
		Thread.sleep(2000);

		List<WebElement>  rows = driver.findElements(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr")); 

		int n=rows.size();
		//ESign_CheckNbr="951557";
		for(int i=4;i<=n;i++){

			String Checknumber=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();

			test.log(LogStatus.PASS, "Getting check number for the check box to check condition"+Checknumber);
			//FirstName="CHERYL";
			test.log(LogStatus.PASS, "Check number is"+ESign_CheckNbr);
			Thread.sleep(3000);
			//if(Cname.toLowerCase().trim().contains(FirstName.toLowerCase().trim()))
			if(Checknumber.contains(ESign_CheckNbr)){

				test.log(LogStatus.PASS, "name condition satisfied ");
				//driver.findElement(By.name("pdlCollateralAch")).click();
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[6]")).click();
				test.log(LogStatus.PASS, "Clicked on check box ");

				WebElement e1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/select"));

				Select dropdown = new Select(e1);
				dropdown.selectByVisibleText("Manual");
				test.log(LogStatus.PASS, "Select deposit type as Manual");

				driver.findElement(By.name("safeDepositRequestBean.password")).sendKeys(passwrd);
				test.log(LogStatus.PASS, "password enterd as :"+passwrd);

				driver.findElement(By.name("finishdeposit")).click();
				test.log(LogStatus.PASS, "Clicked on Finish button in safe deposit page");

				try { 
					Alert alert = driver.switchTo().alert();
					String almsg=alert.getText();
					
					alert.accept();
					test.log(LogStatus.PASS, "Alert accpted with message :"+almsg);
					// if alert present, accept and move on.												

				}
				catch (NoAlertPresentException e5) {
					//do what you normally would if you didn't have the alert.
				}
				Thread.sleep(3000);
				driver.findElement(By.name("finishdeposit")).click();
				test.log(LogStatus.PASS, "Clicked on Finish button in deposit  verification page");
				
				break;
			}
			else{
				test.log(LogStatus.PASS, "Checking the condtion");
			}
		}

		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");
		if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input")).isDisplayed())
		{	
			test.log(LogStatus.PASS, "Dispalying ok button condition satisfied");   
			test.log(LogStatus.PASS, "Mid day deposit completed successfully");

		}
		else
		{
			test.log(LogStatus.PASS, "Mid day deposit Failed");

		}

	}}
