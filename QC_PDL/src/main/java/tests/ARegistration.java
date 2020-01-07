package tests;



import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;





public class ARegistration extends ATestBase {
	
	
	public static void registration(String SSN,String AppURL) throws Exception
	  {
	 System.out.println("Eneterd in reg");
	         String FileName= "Registration_Lend_Nation.xls";
	        Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);
	        int lastrow=TestData.getLastRow("Data");
	        String sheetName="Testdata";
	        System.out.println(lastrow);
	        for(int row=2;row<=lastrow;row++)
	        {
	                String RegSSN = TestData.getCellData(sheetName,"SSN",row);
	                if(SSN.equals(RegSSN))
	                {
	 
	                String state = TestData.getCellData(sheetName,"State",row);
	                String email1 = TestData.getCellData(sheetName,"Email",row);
	                String email2 = TestData.getCellData(sheetName,"EmailExt",row);
	                String email=email1.concat(email2);
	                String password = TestData.getCellData(sheetName,"Password",row);
	                  String SSN1 = SSN.substring(0, 3);
	              String SSN2 = SSN.substring(3,5);
	              String SSN3 = SSN.substring(5,9);
	                        String security_question_a = TestData.getCellData(sheetName,"SecurityQuestionA",row);
	                        String security_question_answer_a = TestData.getCellData(sheetName,"SecurityAnswerA",row);
	 
	                        String security_question_b = TestData.getCellData(sheetName,"SecurityQuestionB",row);
	                        String security_question_answer_b = TestData.getCellData(sheetName,"SecurityAnswerB",row);
	 
	                        String security_question_c = TestData.getCellData(sheetName,"SecurityQuestionC",row);
	                        String security_question_answer_c = TestData.getCellData(sheetName,"SecurityAnswerC",row);
	                       
	                System.out.println(state);
	 
	          driver.get(AppURL);
	          test.log(LogStatus.PASS, "Opened Lend Natino URL  "+AppURL);
	 
	          //System.out.println("under Registration");
	          driver.findElement(By.linkText("Automation")).click();
	 
	          test.log(LogStatus.PASS, "Clicked on Automation link ");
	 
	          Thread.sleep(4000);
	          try{
	                 //
	                  new Select(driver.findElement(By.xpath("//div[@id='StateConfirmation']/div/div/div/div[2]/select"))).selectByVisibleText(state);
	                  test.log(LogStatus.PASS, "Selected the state "+state);
	                  driver.findElement(By.xpath("//*[@id='StateConfirmation']/div/div/div/div[2]/button")).click();
	                  test.log(LogStatus.PASS, "clicked on Continue button ");
	 
	          }
	          catch(Exception e)
	          {
	                  System.out.println("under catch");
	                  //driver.findElement(By.xpath("//div[id='StateConfirmation']/div/div/div/div[2]/select")).click();
	          }
	 
	 
	 
	          //new Select(driver.findElement(By.xpath("//select[@class='form-control valid']"))).selectByVisibleText(state);
	          Thread.sleep(4000);
	 
	          driver.findElement(By.xpath("//div[@class='StartLoanButtonWrapper']/a")).click();
	          test.log(LogStatus.PASS, "Clicked on Start New Loan button");
	 
	          //driver.findElement(By.linkText("START LOAN APPLICATION ")).click();
	          Thread.sleep(4000);
	 
	          driver.findElement(By.name("applyEmail")).sendKeys(email);
	
	          test.log(LogStatus.PASS, "Entered Email "+email);
	 
	          driver.findElement(By.name("applyEmail1")).sendKeys(email);
	          test.log(LogStatus.PASS, "Entered Confirm email "+email);
	 
	 
	          driver.findElement(By.name("passId")).sendKeys(password);
	          test.log(LogStatus.PASS, "Entered Password "+password);
	 
	          driver.findElement(By.name("confirmPassword")).sendKeys(password);
	          test.log(LogStatus.PASS, "Entered Confirm password "+password);
	 
	 
	          driver.findElement(By.name("SSN1")).sendKeys(SSN1);
	          
	          driver.findElement(By.name("SSN2")).sendKeys(SSN2);
	          driver.findElement(By.name("SSN3")).sendKeys(SSN3);
	          test.log(LogStatus.PASS, "Entered SSN Number "+SSN);
	 
	          //new Select(driver.findElement(By.id("question0"))).selectByIndex(1);
	 
	          /*
	         try{
	                 new Select(driver.findElement(By.id("question0"))).selectByVisibleText(security_question);
	         }
	          catch(Exception e){
	                  new Select(driver.findElement(By.id("question0"))).selectByIndex(1);
	          }
	*/
	          int i_security_question_a=Integer.parseInt(security_question_a);
	          new Select(driver.findElement(By.id("question0"))).selectByIndex(i_security_question_a);
	          test.log(LogStatus.PASS, "Selected the first question "+i_security_question_a);
	 
	 
	          driver.findElement(By.name("answer0")).sendKeys(security_question_answer_a);
	          test.log(LogStatus.PASS, "Entered the first question answer "+ security_question_answer_a);
	 
	          int i_security_question_b=Integer.parseInt(security_question_b);
	          new Select(driver.findElement(By.id("question1"))).selectByIndex(i_security_question_b);
	          test.log(LogStatus.PASS, "Selected the second question "+ i_security_question_b);
	 
	          driver.findElement(By.name("answer1")).sendKeys(security_question_answer_b);
	          test.log(LogStatus.PASS, "Entered the second question answer "+ security_question_answer_b);
	 
	          int i_security_question_c=Integer.parseInt(security_question_c);
	          new Select(driver.findElement(By.id("question2"))).selectByIndex(i_security_question_c);
	          test.log(LogStatus.PASS, "Selected the third question "+ i_security_question_c);
	          driver.findElement(By.name("answer2")).sendKeys(security_question_answer_c);
	          test.log(LogStatus.PASS, "Entered the third question answer "+ security_question_answer_c);
	 
	          driver.findElement(By.xpath("//button[@type='submit']")).click();
	          test.log(LogStatus.PASS, "Clicked on Submit button ");
	          
	          //Moving To next page
	 
	          Thread.sleep(20000);
	          if( driver.findElement(By.name("pFirstName")).isEnabled())
	          {
	                        test.log(LogStatus.PASS, "Registered Successfully with SSN " +SSN);
	                        }
	                        else
	                        {
	                        test.log(LogStatus.FAIL, "Registered is not Successfull with SSN  " +SSN);
	                        }
	          Thread.sleep(10000);
	          
	          	                


	 
	  }
	        }
	  }


}
