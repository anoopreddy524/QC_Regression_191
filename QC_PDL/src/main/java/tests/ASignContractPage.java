package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;





public class ASignContractPage extends APersonalInfoPage{

	public static void signContract(String SSN,String AppURL) throws Exception
	{      
	
		test.log(LogStatus.PASS, "Enterd in Signin Contract Page ");

				String Signaturename=firstname+" "+lastname;
				
				
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,250)");
				test.log(LogStatus.PASS, "Scrool  down worked "+Signaturename);

				//Thread.sleep(5000);
				
				Thread.sleep(50000);
				WebElement e3=driver.findElement(By.xpath("//*[@id='checkBox0']"));
				wait.until(ExpectedConditions.elementToBeClickable(e3));
				e3.click();
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(5000);
				driver.findElement(By.id("checkBox1")).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(5000);
				driver.findElement(By.id("checkBox2")).click();
				test.log(LogStatus.PASS, "Checked the third checkbox");
				Thread.sleep(5000);
				driver.findElement(By.id("checkBox3")).click();
				test.log(LogStatus.PASS, "Checked the fourth checkbox");
				
				Thread.sleep(5000);
				driver.findElement(By.id("SignatureRequired0")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the first Signature field details "+Signaturename);
				Thread.sleep(5000);
				driver.findElement(By.id("checkBox4")).click();
				test.log(LogStatus.PASS, "Checked the Fifth checkbox");
				
				Thread.sleep(5000);
				driver.findElement(By.id("SignatureRequired1")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the Second Signature field details "+Signaturename);
				Thread.sleep(5000);
				driver.findElement(By.id("getLoanNowButton")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				
				test.log(LogStatus.INFO, "********************Moving on SignContract to verify by phone page******************");
				Thread.sleep(15000);
				String applicationNbr=driver.findElement(By.id("appNo")).getText();
				
				test.log(LogStatus.PASS, " Customer With SSN:"+SSN +"  "+"Application number is"+applicationNbr);
			  }
				
				
				

	
	
}
