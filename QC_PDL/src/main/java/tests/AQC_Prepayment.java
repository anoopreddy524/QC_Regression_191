package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class AQC_Prepayment extends QCStore{

	public static void Prepayment(String SSN,String AppURL) throws InterruptedException
	{

			test.log(LogStatus.PASS, "************EPP Pre-Payment started****************");
		

			int lastrow=TestData.getLastRow("Prepayment");
			String sheetName="Prepayment";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					String Tender_Type = TestData.getCellData(sheetName,"Tender_Type",row);


					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);

					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);
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
					for(String winHandle : driver.getWindowHandles()){
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
					// driver.findElement(By.name("button")).click();

					for(String winHandle : driver.getWindowHandles()){
						driver.switchTo().window(winHandle);
					}				    
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					// driver.findElement(By.name("button")).click();

					if(ProductID.equals("PDL"))
					{
						driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					}
					if(ProductID.equals("TLP"))
					{
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
					}

					Thread.sleep(5000);
					if(ProductID.equals("LOC"))
					{

						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					}



					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("transactionList")).sendKeys(ESign_CollateralType);
					test.log(LogStatus.PASS, "Transaction type is selected"+ESign_CollateralType);
					driver.findElement(By.id("go_Button")).click();
					test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");


					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");


					String tenderamunt=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[7]/td[1]/table[2]/tbody/tr[1]/td/table/tbody/tr[1]/td[3]/input")).getAttribute("value");
					test.log(LogStatus.PASS, " payment amount is"+tenderamunt);

					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(Tender_Type);
					test.log(LogStatus.PASS, " Select the Deposit_Type as"+Tender_Type);
					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(tenderamunt);
					test.log(LogStatus.PASS, " Enterd tender amount is"+tenderamunt);


					driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					test.log(LogStatus.PASS, " Entered password "+PIN);

					driver.findElement(By.name("Submit22")).click();
					test.log(LogStatus.PASS, " click on finish deposit button");
					try {
		                Alert alert = driver.switchTo().alert();
		               String almsg= alert.getText();

		                alert.accept();
		                test.log(LogStatus.PASS, "alert handled "+almsg);
				}
		            catch (NoAlertPresentException e) {
		                //do what you normally would if you didn't have the alert.
		            }
					Thread.sleep(8000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
					{
						
						
						test.log(LogStatus.PASS, " EPP Prepayment  is successfull");
						test.log(LogStatus.PASS, "********************************************** ");
					}
					else
					{
						test.log(LogStatus.FAIL, " EPP Prepayment  is not successfull");
						test.log(LogStatus.FAIL, "********************************************** ");
					}

				}
				else{
					test.log(LogStatus.FAIL, "RegSSN and SSN not matching ");
				}
				break;

			}
		
	}
}
