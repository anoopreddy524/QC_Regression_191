package tests;

import org.openqa.selenium.By;
import tests.QCStore;
import com.relevantcodes.extentreports.LogStatus;

public class ILP_Redeposit extends QCStore{
	public static void redeposit(String SSN,String AppURL) throws InterruptedException
	{

		test.log(LogStatus.PASS, "************ Redeposit Transaction started****************");
		int lastrow=TestData.getLastRow("Redeposit");
		String sheetName="Redeposit";

		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{

				String RepresentmentType = TestData.getCellData(sheetName,"RepresentmentType",row);
				driver.switchTo().frame("topFrame");
				Thread.sleep(1500);
				driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				driver.switchTo().defaultContent();
				Thread.sleep(1500);
				driver.switchTo().frame("mainFrame");				
				driver.findElement(By.partialLinkText("Collateral Checks")).click();
				test.log(LogStatus.PASS, "Clicked on collateral check types");
				Thread.sleep(1500);
				driver.findElement(By.partialLinkText("Installment Loan")).click();
				test.log(LogStatus.PASS, "Clicked on Installment Loan");
				Thread.sleep(1500);
				driver.findElement(By.partialLinkText("ReDeposit")).click();
				test.log(LogStatus.PASS, "Clicked on Redeposit");
				//loan_nbr="10761111";
				Thread.sleep(1500);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_nbr);
				test.log(LogStatus.PASS, "Enterd loan number is :"+loan_nbr);
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on submit button");
				Thread.sleep(1500);
				String loanno=driver.findElement(By.xpath("//*[@id='dealNbrId0']")).getText();
				test.log(LogStatus.PASS, "Getting loan number from table"+loanno);
				if(loanno.equals(loan_nbr)){

					driver.findElement(By.name("requestBean.chkName")).click();
					test.log(LogStatus.PASS, "clicking on check box to selcet customet having loan number"+loan_nbr);

					driver.findElement(By.name("dispRepresentmentType")).sendKeys(RepresentmentType);;

					test.log(LogStatus.PASS, "Selected representment type as :"+RepresentmentType);

					driver.findElement(By.name("CmdReturnPosting")).click();
					test.log(LogStatus.PASS, "Click on submit button");
					
					
					String Norecrds=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/h3/font/ul")).getText();
					System.out.println("String is"+Norecrds);
					
					if(Norecrds.equalsIgnoreCase("No records returned.")){
						test.log(LogStatus.PASS, " Deposit from CSR is successfull");
						test.log(LogStatus.PASS, "********************************************** ");
						
					}
					
					else {
						test.log(LogStatus.FAIL, " Deposit from CSR is Failed");
					}
					
					
				}
				else{
					test.log(LogStatus.FAIL, " loan number didn't match");
				}


				test.log(LogStatus.PASS, " EPP Redeposit  is successfull");
				test.log(LogStatus.PASS, "********************************************** ");
				break;
			}else
			{
				test.log(LogStatus.FAIL, "RegSSN and SSN not matching ");
			}}			 }
}
