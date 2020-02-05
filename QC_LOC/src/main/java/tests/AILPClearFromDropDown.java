package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.relevantcodes.extentreports.LogStatus;

public class AILPClearFromDropDown extends QCStore{


	public static void clearDropdown(String SSN,String AppURL) throws InterruptedException
	{


		int lastrow=TestData.getLastRow("Deposit");
		String sheetName="Deposit";

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);		       

				Thread.sleep(1000);

				test.log(LogStatus.INFO, "Clear Ach from CSR has initiated");

				driver.switchTo().defaultContent();	

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
				driver.findElement(By.cssSelector("li[id='910000']")).click();		
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();			
				test.log(LogStatus.PASS, "Clicked on Transactions");		
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");		

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button under search results");

				String loan_nbr= driver.findElement(locator(Aprop.getProperty("loan_nbr"))).getText();
				test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
				driver.findElement(locator(Aprop.getProperty("clear_go"))).click();
				test.log(LogStatus.PASS, "Clicked on Go button under Loans section");


				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys("ACH Clear");
				test.log(LogStatus.PASS, "Transaction type is selected ACH Clear");
				driver.findElement(By.id("go_Button")).click();
				test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
				
				//html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[1]/tbody/tr[5]/td[3]

				List<WebElement> rows = driver.findElements(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[1]/tbody/tr")); 

				int n=rows.size();
				for(int i=5;i<=n;i++){
					String loannofromtable=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[1]/tbody/tr["+i+"]/td[3]")).getText();

					test.log(LogStatus.PASS, "getting loan number from table"+loannofromtable);
					test.log(LogStatus.PASS, "Loan number is"+loan_nbr);
					Thread.sleep(3000);
					if(loannofromtable.equals(loan_nbr)){
						test.log(LogStatus.PASS, "loan number condition satisfied");
						driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[1]/tbody/tr["+i+"]/td[1]/input[2]")).click();
						test.log(LogStatus.PASS, "Clicked on check box ");
							
						driver.findElement(By.id("CmdReturnPosting")).click();
						test.log(LogStatus.PASS, "Clicked on finish  clear ");

			}
		}}}}}