package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class AMainMethodForTest {
	
	 public static WebDriver driver;
	public static void main(String args []) throws InterruptedException, ParseException{
		
		
		/* //System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/IEDriverServer.exe");
         System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
         //driver = new InternetExplorerDriver();
        // driver=new WebDriver();
         driver.manage().window().maximize();    
         driver.get("https://www.google.com/?gws_rd=ssl");
        // Thread.sleep(2000);
         //driver=new ChromeDriver();
     	
     	
         
         driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"n");
         driver.navigate().to("http://192.168.2.203/cc/login/index.jsp");
         int n = driver.getWindowHandles().size();
         System.out.println(n);
	*/
		
	String date="12/31/2018";
	
	 SimpleDateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
     Date ndate = df.parse(date);
		Calendar cal = Calendar.getInstance();
		 cal.setTime(ndate);
		 cal.add(Calendar.DATE, 1);
		 Date DDueDate1= cal.getTime();
		 date =df.format(DDueDate1);
		 System.out.println(date);
	
	}

}
