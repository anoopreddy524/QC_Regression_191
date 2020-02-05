package tests;

import org.openqa.selenium.By;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.relevantcodes.extentreports.LogStatus;

public class AReviseCredit extends QCStore{

	public static String revisemsg;
	 public static String reviseamountafterincrease;
	 public static String SSN1;
	 public static String SSN2;
	 public static String SSN3;
	 public static String reviseamount;
	 
		public static void revisecredit(String SSN,String AppURL) throws InterruptedException{

			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";

				for(int row=2;row<=lastrow;row++)
						{		
							String RegSSN = TestData.getCellData(sheetName,"SSN",row);
							if(SSN.equals(RegSSN))
							{
   
								
								SSN1 = SSN.substring(0, 3);
								SSN2 = SSN.substring(3,5);
								SSN3 = SSN.substring(5,9);
					       Thread.sleep(2000);
						
							test.log(LogStatus.INFO, "Revise credit transaction has intiated");

							driver.switchTo().frame("bottom");
							String Str_date = driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]"))
									.getText();
							String store_date[] = Str_date.split(":");
							business_date = store_date[1].trim();
							test.log(LogStatus.PASS, "Business date is :" + business_date);

							driver.switchTo().defaultContent();

							
					        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
							driver.switchTo().frame("topFrame");
							wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					        driver.findElement(By.cssSelector("li[id='910000']")).click();	
								
							test.log(LogStatus.PASS, "Clicked on Loan Transactions");
							Thread.sleep(1000);
						
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='1200003']")));
					        driver.findElement(By.cssSelector("li[id='1200003']")).click();	
					        test.log(LogStatus.PASS, "Clicked on Loan Line of credit menu");
					        
					    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='1200004']")));
					        driver.findElement(By.cssSelector("li[id='1200004']")).click();	
					        test.log(LogStatus.PASS, "Clicked on Revise credit limit");
					        
					        /*Actions action = new Actions(driver);
							action.moveByOffset(200,100).perform();
							Thread.sleep(800);
							action.click();*/
							
							driver.switchTo().frame("main");	
							Thread.sleep(1000);
							driver.findElement(By.name("ssn1")).sendKeys(SSN1);
							test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
							driver.findElement(locator(Aprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
							test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
							driver.findElement(locator(Aprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
							test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
							driver.findElement(By.name("button")).click();
							test.log(LogStatus.PASS, "Click on submit Button");	
					        
					        
					        driver.findElement(By.name("button")).click();
					        test.log(LogStatus.PASS, "Click on Go button under search results");
					        											
					        /*revisemsg=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/b")).getText();
					        test.log(LogStatus.PASS, "Revise message is"+revisemsg);*/
						
						        
					}
				}
	
}

	public static void revisecreditafterIncrease(String SSN,String AppURL) throws InterruptedException{

		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";

			for(int row=2;row<=lastrow;row++)
					{		
						String RegSSN = TestData.getCellData(sheetName,"SSN",row);
						if(SSN.equals(RegSSN))
						{
							
							SSN1 = SSN.substring(0, 3);
							SSN2 = SSN.substring(3,5);
							SSN3 = SSN.substring(5,9);

				       Thread.sleep(2000);
					
						test.log(LogStatus.INFO, "Revise credit transaction has intiated");

						driver.switchTo().frame("bottom");
						String Str_date = driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]"))
								.getText();
						String store_date[] = Str_date.split(":");
						business_date = store_date[1].trim();
						test.log(LogStatus.PASS, "Business date is :" + business_date);

						driver.switchTo().defaultContent();

						
				        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
						driver.switchTo().frame("topFrame");
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
				        driver.findElement(By.cssSelector("li[id='910000']")).click();	
							
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");
						Thread.sleep(1000);
					
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='1200003']")));
				        driver.findElement(By.cssSelector("li[id='1200003']")).click();	
				        test.log(LogStatus.PASS, "Clicked on Loan Line of credit menu");
				        
				    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='1200004']")));
				        driver.findElement(By.cssSelector("li[id='1200004']")).click();	
				        test.log(LogStatus.PASS, "Clicked on Revise credit limit");
						
				        /*Actions action = new Actions(driver);
						action.moveByOffset(200,100).perform();
						Thread.sleep(800);
						action.click();*/
						
						driver.switchTo().frame("main");	
						Thread.sleep(1000);
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
						driver.findElement(locator(Aprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
						driver.findElement(locator(Aprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
						driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Click on submit Button");	
				        
				        
				        driver.findElement(By.name("button")).click();
				        test.log(LogStatus.PASS, "Click on Go button under search results");
				        
				        reviseamountafterincrease=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[2]/td[3]/input")).getAttribute("value");
				        test.log(LogStatus.PASS, "Revise limit amount after increase is "+reviseamountafterincrease);
				        
				        
			}
		}

}

	public static void revisecreditafterDecrease(String SSN,String AppURL) throws InterruptedException{

		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";

			for(int row=2;row<=lastrow;row++)
					{		
						String RegSSN = TestData.getCellData(sheetName,"SSN",row);
						if(SSN.equals(RegSSN))
						{

				       Thread.sleep(2000);
					
						test.log(LogStatus.INFO, "Revise credit transaction has intiated");

						driver.switchTo().frame("bottom");
						String Str_date = driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]"))
								.getText();
						String store_date[] = Str_date.split(":");
						business_date = store_date[1].trim();
						test.log(LogStatus.PASS, "Business date is :" + business_date);

						driver.switchTo().defaultContent();

						
				        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
						driver.switchTo().frame("topFrame");
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
				        driver.findElement(By.cssSelector("li[id='910000']")).click();	
							
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");
						Thread.sleep(1000);
					
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='1200003']")));
				        driver.findElement(By.cssSelector("li[id='1200003']")).click();	
				        test.log(LogStatus.PASS, "Clicked on Loan Line of credit menu");
				        
				    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='1200004']")));
				        driver.findElement(By.cssSelector("li[id='1200004']")).click();	
				        test.log(LogStatus.PASS, "Clicked on Revise credit limit");
						
				        driver.switchTo().frame("main");
				        driver.findElement(By.name("requestBean.ssn")).sendKeys(SSN);
				        test.log(LogStatus.PASS, "Enterd SSN number is"+SSN);
				        
				        driver.findElement(By.name("button")).click();
				        test.log(LogStatus.PASS, "Click on submit button");
				        
				      String limitamount=  driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table[2]/tbody/tr[4]/td[4]")).getText();
				      if(limitamount.equals("780")){
				        driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table[2]/tbody/tr[4]/td[8]/input")).click();
				      }
				      else{
				    	  driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table[2]/tbody/tr[5]/td[8]/input")).click();
				      }
				        test.log(LogStatus.PASS, "Click on Go button");
				        //html/body/form/table/tbody/tr/td/table[2]/tbody/tr[4]/td[8]/input
				         reviseamountafterincrease=driver.findElement(By.xpath(" /html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[1]/td[3]")).getText();
				        test.log(LogStatus.PASS, "Revise amount after Decrease is"+reviseamountafterincrease);
				        test.log(LogStatus.PASS, "Revise amount is"+reviseamount);
				        
				        float reviseamountInt=Float.valueOf(reviseamount);
				        float reviseamountafterincreaseInt=Float.valueOf(reviseamountafterincrease);
				       
				        
				        if(reviseamountafterincreaseInt<reviseamountInt){
				        	 test.log(LogStatus.PASS, "Revise amount is Decreased");
				        	
				        }
				        else{
				        	 test.log(LogStatus.FAIL, "Revise amount is not changed");
				        }
				        
			}
		}

}
	
	
}