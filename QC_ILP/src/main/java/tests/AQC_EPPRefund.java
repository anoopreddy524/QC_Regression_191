package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class AQC_EPPRefund extends QCStore{


	public static void qcRefund (String SSN,String AppURL) throws InterruptedException
	{
		
			test.log(LogStatus.PASS, "************EPP Transaction started****************");
			

			int lastrow=TestData.getLastRow("Refund");
			String sheetName="Refund";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{

					String TxnType = TestData.getCellData(sheetName,"TxnType",row);

					String ProductID = TestData.getCellData(sheetName,"ProductID",row);

					String  DisbType=TestData.getCellData(sheetName,"DisbType",row);

					DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);


					Thread.sleep(4000);
					//test.log(LogStatus.INFO, MarkupHelper.createLabel("Transaction Void has started", ExtentColor.BLUE));
					test.log(LogStatus.INFO, "Transaction Refund has started");

					driver.switchTo().frame("bottom");
					String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					String store_date[]=Str_date.split(":");
					String business_date=store_date[1];
					test.log(LogStatus.PASS, "Business date is :"+business_date);

					driver.switchTo().defaultContent();	

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					driver.findElement(By.cssSelector("li[id='910000']")).click();	

					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(1000);

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


					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					// driver.findElement(By.name("button")).click();

					if(ProductID.equals("PDL"))
					{
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

						//driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					}


					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as "+TxnType);
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
					Thread.sleep(3000);


					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					if(ProductID.equals("PDL"))
					{

						driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(DisbType);
						test.log(LogStatus.PASS, " Selected Disb_Type as "+DisbType);

						driver.findElement(By.name("finish")).click();
						test.log(LogStatus.PASS, " Click on finish Refund button");

						if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
						{
							// test.log(LogStatus.PASS, " ACH Deposit completed sucessfully");

							test.log(LogStatus.PASS, " Refund is successfull");
							test.log(LogStatus.PASS, "********************************************** ");
						}
					}



					break;			 								
				}

			}

		

	}

}
