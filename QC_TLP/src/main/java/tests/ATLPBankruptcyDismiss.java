package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class ATLPBankruptcyDismiss extends QCStore{
	public static String casenumber;
	
	
	public static void dismiss(String SSN,String AppURL) throws InterruptedException{
		
		
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";		
		for(int row=2;row<=lastrow;row++)
		{	Storeid="1706";
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				casenumber="8096";
			
		test.log(LogStatus.INFO, "Bankruptc has started");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topFrame");
		driver.findElement(By.linkText("Transactions")).click();
		test.log(LogStatus.PASS, "Clicked on Transactions");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		
		Thread.sleep(2500);
		driver.findElement(By.linkText("Borrower")).click();
		test.log(LogStatus.PASS, " Mouse hover on Borrower Link");
		Thread.sleep(3500);
		WebElement e2=driver.findElement(By.xpath("//*[@id='988190496']/a"));
		e2.click();
		
		test.log(LogStatus.PASS, "Clicked on Bankrupt");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");
		
		
		WebElement e5=driver.findElement(By.name("requestBean.bnklocnbr"));
		e5.click();		
		e5.sendKeys(Storeid);
		test.log(LogStatus.PASS, "Store number enterd as :"+Storeid);

		driver.findElement(By.name("requestBean.dealNbr")).sendKeys(loan_nbr);
		test.log(LogStatus.PASS, "Loan number enterd as :"+loan_nbr);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveByOffset(200,100).perform();
		Thread.sleep(10000);
		action.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td[1]/form/table[3]/tbody/tr/td[2]/input")).click();
		                             
		test.log(LogStatus.PASS, "Clicked on Submit");
		
		/*driver.findElement(By.name("submit")).click();
		test.log(LogStatus.PASS, "Clicked on submit button");*/
		
		driver.findElement(By.name("button")).click();
		test.log(LogStatus.PASS, "Clicked on submit button under search results");
		
		
		/*driver.findElement(By.name("requestBean.bnkStatus")).sendKeys("Active");
		test.log(LogStatus.PASS, "Select status as active");
		
		
		
		test.log(LogStatus.INFO, "******Entering date Into the feilds ******");
		driver.findElement(By.name("bankruptcyFilingDate1")).sendKeys(age_Date1);
		test.log(LogStatus.PASS, "Month is entered: "+age_Date1);
		driver.findElement(By.name("bankruptcyFilingDate2")).sendKeys(age_Date2);
		test.log(LogStatus.PASS, "Date is entered: "+age_Date2);
		driver.findElement(By.name("bankruptcyFilingDate3")).sendKeys(age_Date3);
		test.log(LogStatus.PASS, "Year is entered: "+age_Date3);
		
		driver.findElement(By.name("bkrCaseNbr")).sendKeys(casenumber);
		test.log(LogStatus.PASS, "Case number enterd as : "+casenumber);
		
		driver.findElement(By.name("requestBean.typeOfBankruptcy")).sendKeys("chapter7");
		test.log(LogStatus.PASS, "Bnk chapter selected as chapter 7");
		
		driver.findElement(By.name("attorneyName")).sendKeys(FirstName);
		test.log(LogStatus.PASS, "Attorney name is : "+FirstName);
		
		driver.findElement(By.name("debtorAttorneyPhone1")).sendKeys(Ctc_PrimaryPhone);
		test.log(LogStatus.PASS, "Attorney phone number enterd as : "+Ctc_PrimaryPhone);
		
		driver.findElement(By.name("bt_AddBankruptcy")).click();
		test.log(LogStatus.PASS, " Click on save button");*/
		
		/*driver.findElement(By.name("bkrCaseNbr")).sendKeys(casenumber);
		test.log(LogStatus.PASS, "Case number enterd as : "+casenumber);
		
		driver.findElement(By.name("bkrCaseNbr")).sendKeys(casenumber);
		test.log(LogStatus.PASS, "Case number enterd as : "+casenumber);*/
		
		
			String status=driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr[9]/td/table/tbody/tr[3]/td[2]")).getText();
			if(status.equalsIgnoreCase("Active"))
			{
				test.log(LogStatus.PASS, " BNK status is active");
				driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr[9]/td/table/tbody/tr[3]/td[8]/input")).click();
				test.log(LogStatus.PASS, " Click on Edit and go button");
				Thread.sleep(3000);
				driver.findElement(By.name("requestBean.bnkStatus")).sendKeys("Dismissed");
				test.log(LogStatus.PASS, "Select status as Dismissed");
				
				test.log(LogStatus.INFO, "******Entering Dissmissal date Into the feilds ******");
				driver.findElement(By.name("ubnkDate1")).sendKeys(age_Date1);
				test.log(LogStatus.PASS, "Month is entered: "+age_Date1);
				driver.findElement(By.name("ubnkDate2")).sendKeys(age_Date2);
				test.log(LogStatus.PASS, "Date is entered: "+age_Date2);
				driver.findElement(By.name("ubnkDate3")).sendKeys(age_Date3);
				test.log(LogStatus.PASS, "Year is entered: "+age_Date3);
				
				driver.findElement(By.name("bt_AddBankruptcy")).click();
				test.log(LogStatus.PASS, " Click on save button");
				
				
			}
			else{
				test.log(LogStatus.FAIL, " BNK status is In-active");
			}
	break;}
		break;}}
}
