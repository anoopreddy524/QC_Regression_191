package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;




public class APersonalInfoPage extends ATestBase  {
	
	
	public static String firstname;
	public static String lastname;
	

	public static void personalInformation(String SSN,String AppURL) throws Exception{ 
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
		
		firstname = TestData.getCellData(sheetName,"FirstName",row);
	     String middlename = TestData.getCellData(sheetName,"MiddleName",row);
	     lastname = TestData.getCellData(sheetName,"LastName",row);

	     String pphone = TestData.getCellData(sheetName,"PrimaryPhone",row);
	     String sphone = TestData.getCellData(sheetName,"SecondaryPhone",row);
	     String aphone = TestData.getCellData(sheetName,"AlternativePhone",row);
	     String pphonetype = TestData.getCellData(sheetName,"PphoneType",row);
	     String sphonetype = TestData.getCellData(sheetName,"SphoneType",row);
	     String aphonetype = TestData.getCellData(sheetName,"AphoneType",row);

	     String Paddress = TestData.getCellData(sheetName,"Paddress",row);
	     String Pcity = TestData.getCellData(sheetName,"Pcity",row);
	     String Ppostalcode = TestData.getCellData(sheetName,"Ppostalcode",row);
	     String PstateName = TestData.getCellData(sheetName,"PstateName",row);
	     String PhomeType = TestData.getCellData(sheetName,"PhomeType",row);
	     String PtymeAtAddress = TestData.getCellData(sheetName,"PtymeAtAddress",row);

	     String date_of_birth = TestData.getCellData(sheetName,"DOB",row);
	     String DOB[] =date_of_birth.split("/");
	String DOB1 = DOB[0];
	String DOB2 = DOB[1];
	String DOB3 = DOB[2];
	     String Identification = TestData.getCellData(sheetName,"Identification",row);

	     String IDNumber = TestData.getCellData(sheetName,"IDNumber",row);
	     String date_of_exp = TestData.getCellData(sheetName,"IDExpDate",row);
	     String DOE[] =date_of_exp.split("/");
	String DOE1 = DOE[0];
	String DOE2 = DOE[1];
	String DOE3 = DOE[2];
	String ReferenceFirstNameA = TestData.getCellData(sheetName,"ReferenceFirstNameA",row);
	     String ReferenceLastNameA = TestData.getCellData(sheetName,"ReferenceLastNameA",row);
	     String RelationA = TestData.getCellData(sheetName,"RelationA",row);
	     String PhoneA = TestData.getCellData(sheetName,"PhoneA",row);
	     String ReferenceFirstNameB = TestData.getCellData(sheetName,"ReferenceFirstNameB",row);
	     String ReferenceLastNameB = TestData.getCellData(sheetName,"ReferenceLastNameB",row);
	     String RelationB = TestData.getCellData(sheetName,"RelationB",row);
	     String PhoneB = TestData.getCellData(sheetName,"PhoneB",row);
	     
	         Thread.sleep(30000);
	driver.findElement(By.name("pFirstName")).sendKeys(firstname);
    test.log(LogStatus.PASS, "Entered first name  " + firstname);

driver.findElement(By.name("pMiddleInitial")).sendKeys(middlename);
    test.log(LogStatus.PASS, "Entered middle name  " + middlename);

driver.findElement(By.name("pLastName")).sendKeys(lastname);
    test.log(LogStatus.PASS, "Entered last name  " +  lastname);

driver.findElement(By.name("optionMilitary")).click();
    test.log(LogStatus.PASS, "Selected Military as No  ");


driver.findElement(By.name("pPhone")).sendKeys(pphone);
    test.log(LogStatus.PASS, "Entered primary number  "+pphone);

new Select(driver.findElement(By.id("pPrimaryPhone"))).selectByVisibleText(pphonetype);
    test.log(LogStatus.PASS, "Selected Primary phone type as   "+  pphonetype);

driver.findElement(By.name("sPhone")).sendKeys(sphone);
    test.log(LogStatus.PASS, "Entered secondary phone number  "+sphone);

new Select(driver.findElement(By.id("sprephonetype"))).selectByVisibleText(sphonetype);
    test.log(LogStatus.PASS, "Selected secondary phone type as  " + sphonetype);

driver.findElement(By.name("aPhone")).sendKeys(aphone);
    test.log(LogStatus.PASS, "Alternative phone No  " + aphone);

new Select(driver.findElement(By.id("aprephonetype"))).selectByVisibleText(aphonetype);
    test.log(LogStatus.PASS, "Selercted Alternative phone type as "+ aphonetype);


driver.findElement(By.name("chk2")).click();

driver.findElement(By.name("pAddress")).sendKeys(Paddress);
    test.log(LogStatus.PASS, "Entered Address as  "+ Paddress);

driver.findElement(By.name("pCity")).sendKeys(Pcity);
    test.log(LogStatus.PASS, "Entered City as   "+ Pcity);

driver.findElement(By.name("pPostalCode")).sendKeys(Ppostalcode);
    test.log(LogStatus.PASS, "Entered Postal code as " + Ppostalcode);


new Select(driver.findElement(By.id("pStateName"))).selectByVisibleText(PstateName);
    test.log(LogStatus.PASS, "Selected State as   "+ PstateName);

new Select(driver.findElement(By.id("pHomeType"))).selectByVisibleText(PhomeType);
    test.log(LogStatus.PASS, "Selected Home type as "+ PhomeType);

new Select(driver.findElement(By.id("pTimeAtAddress"))).selectByVisibleText(PtymeAtAddress);
    test.log(LogStatus.PASS, "entered time at address as  " + PtymeAtAddress);

// Time at address

//Date of birth entering
driver.findElement(By.name("pDateOfBirthMonth")).sendKeys(DOB1);
driver.findElement(By.name("pDateOfBirthDay")).sendKeys(DOB2);
driver.findElement(By.name("pDateOfBirthYear")).sendKeys(DOB3);
    test.log(LogStatus.PASS, "Entered DOB as  "+ date_of_birth);


//Identification selection
driver.findElement(By.name("pidentification")).sendKeys(Identification);
    test.log(LogStatus.PASS, "Entered identification   "+ Identification);


//entering id number
driver.findElement(By.name("pId")).sendKeys(IDNumber);
    test.log(LogStatus.PASS, "Entered ID No as "+ IDNumber);

driver.findElement(By.name("garnishDateMonth")).sendKeys(DOE1);
driver.findElement(By.name("garnishDateDay")).sendKeys(DOE2);
driver.findElement(By.name("garnishDateYear")).sendKeys(DOE3);
    test.log(LogStatus.PASS, "Entered Expiry date as  "+ date_of_exp);

//1st Reference details entering

driver.findElement(By.name("fname")).sendKeys(ReferenceFirstNameA);
    test.log(LogStatus.PASS, "Entered first reference name as  "+ ReferenceFirstNameA);

driver.findElement(By.name("lname")).sendKeys(ReferenceLastNameA);
    test.log(LogStatus.PASS, "Entered first reference last name as  "+ ReferenceLastNameA);

    driver.findElement(By.name("relation1")).sendKeys(RelationA);
    test.log(LogStatus.PASS, "Entered first reference relation as  "+ RelationA);

driver.findElement(By.name("phone")).sendKeys(PhoneA);
    test.log(LogStatus.PASS, "Entered first reference phone number  as  "+ PhoneA);

//2nd Reference details entering

driver.findElement(By.name("firstName")).sendKeys(ReferenceFirstNameB);
    test.log(LogStatus.PASS, "Entered second reference name as  "+ ReferenceFirstNameB);

    driver.findElement(By.name("lastName")).sendKeys(ReferenceLastNameB);
    test.log(LogStatus.PASS, "Entered second reference last name as  "+ ReferenceLastNameB);

    driver.findElement(By.name("relation2")).sendKeys(RelationB);
    test.log(LogStatus.PASS, "Entered second reference relation as  "+ RelationB);

    driver.findElement(By.name("phone1")).sendKeys(PhoneB);
    test.log(LogStatus.PASS, "Entered second reference phone number  as  "+ PhoneB);
    
    Thread.sleep(5000);
    
    driver.findElement(By.id("scrollDiv1")).click();

     WebElement element = driver.findElement(By.id("scrollDiv1"));

    Actions action = new Actions(driver);

    action.moveToElement(element);
    

    for(int i=1;i<=4;i++){

        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        }

    test.log(LogStatus.PASS, "Reviwed Electronic consent document  ");
    
    Thread.sleep(5000);
    
    driver.findElement(By.xpath("//*[@id='chk3']")).click();
    Thread.sleep(4000);
    test.log(LogStatus.PASS, "Acceted the Electronic consent ");
    
    driver.findElement(By.id("scrollDiv2")).click();
    
    WebElement element1 = driver.findElement(By.id("scrollDiv2"));

    Actions action1 = new Actions(driver);

    action1.moveToElement(element1);
    
    for(int i=1;i<=7;i++){

    action1.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    test.log(LogStatus.PASS, "Reviwed Privacy policy document  ");
    Thread.sleep(5000);
    
    driver.findElement(By.id("chk4")).click();
    Thread.sleep(3000);
    test.log(LogStatus.PASS, "Accepeted the privacy policy  ");
    
    driver.findElement(By.xpath("//*[@id='frmPersonal']/div[36]/div[2]/div/button")).click();
    test.log(LogStatus.PASS, "Click on continue to go financial page  ");


}}}

}
