package tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class AAdminStartDateLOC1 extends QCStore{
	static String startdate;

	public static void toStartdateForEOD1(String SSN,String AppURL) throws InterruptedException, ParseException
	{

				String StoreID ="503";                                                       
				
					startdate="06/01/2018";
				
				
				//String Days=TestData.getCellData(sheetName,"Days",2);	
				int GraceDaysInt=0;
				
				Thread.sleep(5000);
				driver.switchTo().defaultContent();

				driver.switchTo().frame("topFrame");

				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id='100000']/a")).click();

				test.log(LogStatus.PASS, "Clicked on Store tab");

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='101000']/a")).click();

				test.log(LogStatus.PASS, "Clicked on Store Config link");

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");
				Thread.sleep(3000);
			
				driver.findElement(By.xpath("//*[@id='101020']/a")).click();

				test.log(LogStatus.PASS, "Clicked on Store Edit");

				Actions action = new Actions(driver);
				action.moveByOffset(200,100).perform();
				Thread.sleep(2000);
				action.click();

				driver.switchTo().frame("main");



				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td/table/tbody/tr[1]/td/b/input")).sendKeys(StoreID);

				test.log(LogStatus.PASS, "Entered Store number "+StoreID);

				//Thread.sleep(1500);
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td/table/tbody/tr[3]/td/input[1]")).click();

				test.log(LogStatus.PASS, "Clicked on Submit button");


				Thread.sleep(1000);


				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");


				driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[1]/tbody/tr[4]/td/table[1]/tbody/tr[3]/td[1]/select")).sendKeys("Open");

				test.log(LogStatus.PASS, "Store status set as Open"); 
				String business_unit=driver.findElement(By.name("locationBean.businessUnitCd")).getAttribute("value");
				
				DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
				//String storedate[] =Demodate.split("/");
				
				Date DDueDateminus1 = df.parse(startdate);

				Calendar cal = Calendar.getInstance();

				cal.setTime(DDueDateminus1);

				cal.add(Calendar.DATE, GraceDaysInt);
			

				Date DDueDate1= cal.getTime();

				String DueDate =df.format(DDueDate1);

				String storedate1[] =DueDate.split("/");

				
				 Date1 = storedate1[0];

				 Date2 = storedate1[1];

				 Date3 = storedate1[2];
				
			WebElement	e1=driver.findElement(By.name("procDt1"));
			e1.clear();
			e1.sendKeys(Date1);
			test.log(LogStatus.PASS, "Enterd Month as"+Date1); 
			WebElement	e2=driver.findElement(By.name("procDt2"));
			e2.clear();
			e2.sendKeys(Date2);
			test.log(LogStatus.PASS, "Enterd date as"+Date2);
			WebElement	e3=driver.findElement(By.name("procDt3"));
			e3.clear();
			e3.sendKeys(Date3);
			test.log(LogStatus.PASS, "Enterd year as"+Date3);
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[3]")).click();

				test.log(LogStatus.PASS, "Clicked on Submit"); 
				Thread.sleep(2000);

				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();
					test.log(LogStatus.PASS, "Handled the alert"); 
					//if alert present, accept and move on.														

				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}
				try{
					if(business_unit.equalsIgnoreCase("1"))
					{
						Thread.sleep(2000);

						driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[1]/tbody/tr[4]/td/table[1]/tbody/tr[2]/td[1]/select")).sendKeys("2");
					}
					else
					{
						Thread.sleep(2000);

						driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[1]/tbody/tr[4]/td/table[1]/tbody/tr[2]/td[1]/select")).sendKeys("1");
					}
					test.log(LogStatus.PASS, "Changed business unit"); 
					Thread.sleep(1000);
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[3]")).click();

					test.log(LogStatus.PASS, "Clicked on Submit"); 
				}
				catch(Exception e)
				{

				}
			
				test.log(LogStatus.PASS, "Store Setup is successful");
				test.log(LogStatus.PASS, "***********************************************");	
}
	
	public static void toStartdateForEOD2(String SSN,String AppURL) throws InterruptedException, ParseException
	{

				String StoreID ="552";                                                       
				
					startdate="05/01/2018";
				
				
				//String Days=TestData.getCellData(sheetName,"Days",2);	
				int GraceDaysInt=0;
				
				Thread.sleep(5000);
				driver.switchTo().defaultContent();

				driver.switchTo().frame("topFrame");

				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id='100000']/a")).click();

				test.log(LogStatus.PASS, "Clicked on Store tab");

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='101000']/a")).click();

				test.log(LogStatus.PASS, "Clicked on Store Config link");

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");
				Thread.sleep(3000);
			
				driver.findElement(By.xpath("//*[@id='101020']/a")).click();

				test.log(LogStatus.PASS, "Clicked on Store Edit");

				Actions action = new Actions(driver);
				action.moveByOffset(200,100).perform();
				Thread.sleep(2000);
				action.click();

				driver.switchTo().frame("main");



				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td/table/tbody/tr[1]/td/b/input")).sendKeys(StoreID);

				test.log(LogStatus.PASS, "Entered Store number "+StoreID);

				//Thread.sleep(1500);
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td/table/tbody/tr[3]/td/input[1]")).click();

				test.log(LogStatus.PASS, "Clicked on Submit button");


				Thread.sleep(1000);


				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");


				driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[1]/tbody/tr[4]/td/table[1]/tbody/tr[3]/td[1]/select")).sendKeys("Open");

				test.log(LogStatus.PASS, "Store status set as Open"); 
				String business_unit=driver.findElement(By.name("locationBean.businessUnitCd")).getAttribute("value");
				
				DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
				//String storedate[] =Demodate.split("/");
				
				Date DDueDateminus1 = df.parse(startdate);

				Calendar cal = Calendar.getInstance();

				cal.setTime(DDueDateminus1);

				cal.add(Calendar.DATE, GraceDaysInt);
			

				Date DDueDate1= cal.getTime();

				String DueDate =df.format(DDueDate1);

				String storedate1[] =DueDate.split("/");

				
				 Date1 = storedate1[0];

				 Date2 = storedate1[1];

				 Date3 = storedate1[2];
				
			WebElement	e1=driver.findElement(By.name("procDt1"));
			e1.clear();
			e1.sendKeys(Date1);
			test.log(LogStatus.PASS, "Enterd Month as"+Date1); 
			WebElement	e2=driver.findElement(By.name("procDt2"));
			e2.clear();
			e2.sendKeys(Date2);
			test.log(LogStatus.PASS, "Enterd date as"+Date2);
			WebElement	e3=driver.findElement(By.name("procDt3"));
			e3.clear();
			e3.sendKeys(Date3);
			test.log(LogStatus.PASS, "Enterd year as"+Date3);
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[3]")).click();

				test.log(LogStatus.PASS, "Clicked on Submit"); 
				Thread.sleep(2000);

				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();
					test.log(LogStatus.PASS, "Handled the alert"); 
					//if alert present, accept and move on.														

				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}
				try{
					if(business_unit.equalsIgnoreCase("1"))
					{
						Thread.sleep(2000);

						driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[1]/tbody/tr[4]/td/table[1]/tbody/tr[2]/td[1]/select")).sendKeys("2");
					}
					else
					{
						Thread.sleep(2000);

						driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[1]/tbody/tr[4]/td/table[1]/tbody/tr[2]/td[1]/select")).sendKeys("1");
					}
					test.log(LogStatus.PASS, "Changed business unit"); 
					Thread.sleep(1000);
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[3]")).click();

					test.log(LogStatus.PASS, "Clicked on Submit"); 
				}
				catch(Exception e)
				{

				}
			
				test.log(LogStatus.PASS, "Store Setup is successful");
				test.log(LogStatus.PASS, "***********************************************");	
}
	public static void toStartdateForEOD3(String SSN,String AppURL) throws InterruptedException, ParseException
	{

				String StoreID ="1251";                                                       
				
					startdate="05/01/2018";
				
				
				//String Days=TestData.getCellData(sheetName,"Days",2);	
				int GraceDaysInt=0;
				
				Thread.sleep(5000);
				driver.switchTo().defaultContent();

				driver.switchTo().frame("topFrame");

				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id='100000']/a")).click();

				test.log(LogStatus.PASS, "Clicked on Store tab");

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='101000']/a")).click();

				test.log(LogStatus.PASS, "Clicked on Store Config link");

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");
				Thread.sleep(3000);
			
				driver.findElement(By.xpath("//*[@id='101020']/a")).click();

				test.log(LogStatus.PASS, "Clicked on Store Edit");

				Actions action = new Actions(driver);
				action.moveByOffset(200,100).perform();
				Thread.sleep(2000);
				action.click();

				driver.switchTo().frame("main");



				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td/table/tbody/tr[1]/td/b/input")).sendKeys(StoreID);

				test.log(LogStatus.PASS, "Entered Store number "+StoreID);

				//Thread.sleep(1500);
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td/table/tbody/tr[3]/td/input[1]")).click();

				test.log(LogStatus.PASS, "Clicked on Submit button");


				Thread.sleep(1000);


				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");


				driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[1]/tbody/tr[4]/td/table[1]/tbody/tr[3]/td[1]/select")).sendKeys("Open");

				test.log(LogStatus.PASS, "Store status set as Open"); 
				String business_unit=driver.findElement(By.name("locationBean.businessUnitCd")).getAttribute("value");
				
				DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
				//String storedate[] =Demodate.split("/");
				
				Date DDueDateminus1 = df.parse(startdate);

				Calendar cal = Calendar.getInstance();

				cal.setTime(DDueDateminus1);

				cal.add(Calendar.DATE, GraceDaysInt);
			

				Date DDueDate1= cal.getTime();

				String DueDate =df.format(DDueDate1);

				String storedate1[] =DueDate.split("/");

				
				 Date1 = storedate1[0];

				 Date2 = storedate1[1];

				 Date3 = storedate1[2];
				
			WebElement	e1=driver.findElement(By.name("procDt1"));
			e1.clear();
			e1.sendKeys(Date1);
			test.log(LogStatus.PASS, "Enterd Month as"+Date1); 
			WebElement	e2=driver.findElement(By.name("procDt2"));
			e2.clear();
			e2.sendKeys(Date2);
			test.log(LogStatus.PASS, "Enterd date as"+Date2);
			WebElement	e3=driver.findElement(By.name("procDt3"));
			e3.clear();
			e3.sendKeys(Date3);
			test.log(LogStatus.PASS, "Enterd year as"+Date3);
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[3]")).click();

				test.log(LogStatus.PASS, "Clicked on Submit"); 
				Thread.sleep(2000);

				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();
					test.log(LogStatus.PASS, "Handled the alert"); 
					//if alert present, accept and move on.														

				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}
				try{
					if(business_unit.equalsIgnoreCase("1"))
					{
						Thread.sleep(2000);

						driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[1]/tbody/tr[4]/td/table[1]/tbody/tr[2]/td[1]/select")).sendKeys("2");
					}
					else
					{
						Thread.sleep(2000);

						driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[1]/tbody/tr[4]/td/table[1]/tbody/tr[2]/td[1]/select")).sendKeys("1");
					}
					test.log(LogStatus.PASS, "Changed business unit"); 
					Thread.sleep(1000);
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table[2]/tbody/tr/td/input[3]")).click();

					test.log(LogStatus.PASS, "Clicked on Submit"); 
				}
				catch(Exception e)
				{

				}
			
				test.log(LogStatus.PASS, "Store Setup is successful");
				test.log(LogStatus.PASS, "***********************************************");	
}


}
