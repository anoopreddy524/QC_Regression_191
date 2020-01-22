package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;




public class SubmitApplicationPage extends TestBase {

	
	

	
	public static void submitApplication(String SSN, String AppURL) throws InterruptedException{
		
		
		
		test.log(LogStatus.PASS, "Enterd into Submit application page");
		  
		
		String loanAmount="300";
		  Thread.sleep(30000);
		  driver.findElement(By.xpath("//*[@id='loanAmt']")).sendKeys(loanAmount);
		  test.log(LogStatus.PASS, "Loan Amount has enterd " +loanAmount);
		  Thread.sleep(30000);
		  
		 
		//driver.findElement(By.xpath("//input[@ng-click='showReqDocs(3);']")).click();
		  test.log(LogStatus.PASS, "RequiredDocuments checkbox checked " );
		  Thread.sleep(5000);
		 driver.findElement(By.name("aEmailVerificationCode")).sendKeys("123");
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//*[@id='loanRateChartChk']")).click();
		  test.log(LogStatus.PASS, "Lend NAtion decloure checked" );
		  Thread.sleep(5000);
		  
		  driver.findElement(By.xpath("//*[@id='abilityToRepayChk']")).click();
		   test.log(LogStatus.PASS, "abilityToRepay checked" );
		   Thread.sleep(5000);
		   WebElement e2=driver.findElement(By.xpath("//tr[@id='custDocButtons']/div[3]/input"));
			wait.until(ExpectedConditions.elementToBeClickable(e2));
			e2.click();
		   driver.findElement(By.id("productSubmitBtn")).click();
		   
		   test.log(LogStatus.PASS, " Submit Button clicked" );
		   
		  
	  }
	 
	 

	
	
	
}
