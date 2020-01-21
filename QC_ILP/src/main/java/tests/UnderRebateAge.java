package tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class UnderRebateAge extends QCStore {

	public static  void agerescind() throws Exception{
		test.log(LogStatus.INFO, "******Performing age the store to 2 days  ******");
		driver.switchTo().frame("bottom");
		String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
		System.out.println(Str_date);
		test.log(LogStatus.PASS, "Current store date is "+Str_date);

		// int GraceDaysInt=Integer.parseInt(GraceDays);
		String spagedate[]=Str_date.split(":");
		
		//this is month
		String day=spagedate[1].trim();

		// -----------------------------------
		SimpleDateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
		Date ndate = df.parse(day);
		Calendar cal = Calendar.getInstance();
		cal.setTime(ndate);
		cal.add(Calendar.DATE, 2);
		Date DDueDate1= cal.getTime();
		day =df.format(DDueDate1);
		test.log(LogStatus.PASS, "Updated store date is "+day);
		//------------------------------------------
		String age_Date[] =day.split("/");
		String age_Date1 = age_Date[0];
		String age_Date2 = age_Date[1];
		String age_Date3 = age_Date[2];
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topFrame");
		driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
		test.log(LogStatus.PASS, "Clicked on Cash Management");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");							
		driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
		test.log(LogStatus.PASS, "Clicked on Start Scheduler");
		Thread.sleep(2000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");

		test.log(LogStatus.INFO, "******Entering date Into the feilds ******");
		driver.findElement(By.name("endMonth")).sendKeys(age_Date1);
		test.log(LogStatus.PASS, "Month is entered: "+age_Date1);
		driver.findElement(By.name("endDay")).sendKeys(age_Date2);
		test.log(LogStatus.PASS, "Date is entered: "+age_Date2);
		driver.findElement(By.name("endYear")).sendKeys(age_Date3);
		test.log(LogStatus.PASS, "Year is entered: "+age_Date3);
		driver.findElement(By.name("runSchedulerBtn")).click();
		test.log(LogStatus.PASS, "Clicked on Run Scheduler");

		try { 
			Alert alert = driver.switchTo().alert();

			alert.accept();
			test.log(LogStatus.PASS, "accepting the alert");
			//if alert present, accept and move on.														

		}
		catch (Exception e) {
			//do what you normally would if you didn't have the alert.
		}
		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ok")));
		//Thread.sleep(5000);
		driver.findElement(By.name("ok")).click();
		//test.log(Status.PASS, "Clicked on Scheduler Ok");
		test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
		test.log(LogStatus.INFO, "<FONT color=green> ****Scheduler completed******");
		test.log(LogStatus.INFO, "<FONT color=green> Logout Successfully");
		//Thread.sleep(1000);

	}


}


