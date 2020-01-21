package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
@Listeners(tests.TestListeners.class)
public class QCStore {

	public static WebDriverWait wait;
	public static WebDriver driver;
	public static WebDriver driver1;
	String appUrl;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
	public static Properties prop;
	public static String loan_number;
	public static ExtentReports reports;
	public static ExtentReports Breports;
	public static ExtentReports Jreports;
	public static ExtentReports Rreports;
	public static ExtentReports Areports;
	public static ExtentTest test;
	public static String Eankey = null;
	public static String encryption_store_no = null;
	public static String encryption_transaction_nbr = null;
	public static String FileName;
	public static ExcelNew TestData;

	public static String loan_nbr;
	public static String NextDueDate;
	public static String AppURL = "http://192.168.2.203/cc/demoIndex.do";
	public static String business_date;
	public static String No_of_Installments;
	public static String transaction_date;

	public static String ESign_CheckNbr;
	public static String Password;
	public static String ESign_CollateralType;
	public static String appdate;
	public static String Date1;
	public static String Date2;
	public static String Date3;
	public static String customer_number;

	public static String Drawer_OverShort_Amount;

	public static String Due_Date1;
	public static String Due_Date2;
	public static String Due_Date3;
	public static String passwrd;
	public static String FirstName;
	public static String AdminURL;
	public static String BAdminURL;
	public static String csr_url;
	public static String csrloginpage;

	
	//============================================================================================================
	// Anoop Transactions

	@Test(priority = 12, enabled = true, groups = "Anoop")

	public void ILP_voidRefinance() throws Exception {

		FileName = "ILP_Refinancevoid.xls";
		test = reports.startTest("ILP_Refinancevoid",
				"Loan->Age store for 12 days->Make Payment less than interest amount->Age Store for 10 Days->Refinance->Void Refinance");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.age10days(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILPRefinanceprocess.Refinance(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				
			}
		}
	}
	
	@Test(priority = 11, enabled = true, groups = "Anoop")
	public void ILP_borrowregNewloan() throws Exception {
		FileName = "QC_BorrowerRegistration_NewLoan.xls";
		test = reports.startTest("QC_BorrowerRegistration_NewLoan",
				"Login-->Home Screen-->Borrower Registration-->New Loan");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}
	}
	
	
//Dont execute this one 
	//@Test(priority = 12, enabled = true, groups = "Anoopsss")

	public void ILP_ACHAutoClear() throws Exception {

		FileName = "ILP_ACHAutoClear.xls";
		test = reports.startTest("ILP_Scenario_NO.34",
				"Loan -->Age the store upto duedate --> perform deposit--> age the store -->ACH Auto clear");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				ILPACHProcessing.achProcess(SSN, SSN);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AutoclearCheck.autoclear(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				
			}
		}
	}

	@Test(priority = 13, enabled = true, groups = "Anoop")

	public void ILP_CheckAutoClear() throws Exception {

		FileName = "ILP_CheckAutoClear.xls";
		test = reports.startTest("ILP_Loan_deposit_AutoClear",
				"Loan -->Age the store upto duedate --> perform deposit--> age the store -->Check Auto clear");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);
				
				ACSRLoginLogout.login(SSN, AppURL);	
				AutoclearCheck.autoclear(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory_Autoclear.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			
			}
		}
	}

	@Test(priority = 10, enabled = true, groups = "Anoop")

	public void ILP_ProcessClear() throws Exception {

		FileName = "ILP_ProcessClear.xls";
		test = reports.startTest("QC_Loan_deposit_ClearFromDropDown",
				"Loan -->Age the store upto duedate --> perform deposit--> age the store -->process Clear from drop Down");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILPClearFromDropDown.clearDropdown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				
			}
		}
	}

	@Test(priority = 0, enabled = true, groups = "Anoop_StdownVoid")
	// This is date dependency make it 03/12/2018
	public void ILP_RefinanceStepDown_void() throws Exception {
		FileName = "QC_ILP_StepDown_Void.xls";
		test = reports.startTest("QC_ILP_StepDown_Void","Login-->Age the Store_payment_Age store to Duedate_Refinance Step Down Void");

		TestData = new ExcelNew(System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Refinance_StepDown.StepDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				
			}
		}
	}

	@Test(priority = 15, enabled = true, groups = "Anoop_stDown")
	// This is date dependency make it 03/12/2018
	public void ILP_RefinanceStepDown() throws Exception {

		FileName = "QC_ILP_StepDown.xls";
		test = reports.startTest("QC_ILP_StepDown",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Step Down");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Refinance_StepDown.StepDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				
			}
		}
	}

	@Test(priority = 9, enabled = true, groups = "Anoop")

	public void ILP_RefinanceStepSame_Void() throws Exception {

		FileName = "QC_ILP_StepSame_Void.xls";
		test = reports.startTest("QC_Refinance_Stepsame_Void",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Step Same Void");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Refinance_StepSame.StepSame(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				
			}
		}
	}

	@Test(priority = 7, enabled = true, groups = "Anoop")

	public void ILP_RefinanceStepSame() throws Exception {

		FileName = "QC_ILP_StepSame.xls";
		test = reports.startTest("QC_Refinance_Stepsame",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Step Same");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Refinance_StepSame.StepSame(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				

			}
		}
	}

	@Test(priority = 8, enabled = true, groups = "Anoop")

	public void ILP_RefinanceStepUpVoid() throws Exception {

		FileName = "QC_ILP_StepupVoid.xls";
		test = reports.startTest("QC_Loan_StepUP_Void",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Step Up void");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_RefinanceStepup.StepUp(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				
			}
		}
	}

	@Test(priority = 6, enabled = true, groups = "Anoop1")

	public void ILP_RefinanceStepup() throws Exception {

		FileName = "QC_ILP_StepUp.xls";
		test = reports.startTest("ILP_Refinance_stepUP",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Stepup");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_RefinanceStepup.StepUp(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			
			}
		}
	}

	@Test(priority = 1, enabled = true, groups = "Anoop")

	public void ILP_Redeposit() throws Exception {

		FileName = "QC_ILP_Redeposit.xls";
		test = reports.startTest("QC_ILP_Redeposit",
				"Loan->Age store till first installment due date->Check Deposit->Age store for 2 days->Return Check->Age store for 2 days->Redeposit");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				/*QCCSRLoginLogout.adminLogin(SSN, SSN);
				AAdminStartDate.toStartdateSc1(SSN, SSN);
				QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
				AProc1.proc();*/

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ILP_DepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				AQCAdminLoginLogout.login(SSN, AppURL);
				ILP_ReturnPosting.qcReturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ILP_Redeposit.redeposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			
			}
		}
	}

	@Test(priority = 5, enabled = true, groups = "Anoop")

	public void ILP_agerescindtest() throws Exception {
		test = reports.startTest("QC_AgeStore_Rescind Loan", "Login-->Age the loan to rescind days--->Rescind loan");
		FileName = "QC_NewLoan_AgeRescind.xls";

		TestData = new ExcelNew(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.rescind(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				

			}
		}
	}

	@Test(priority = 4, enabled = true, groups = "Anoop")

	public void ILP_rescindloan() throws Exception {
		test = reports.startTest("QC_Rescind", "Loan->Rescind");
		FileName = "QC_NewLoan_Rescind.xls";

		TestData = new ExcelNew(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.rescind(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			

			}
		}
	}

	@Test(priority = 3, enabled = true, groups = "Anoop")

	public void ILP_maxloanCount() throws Exception {
		FileName = "QC_MaxLoanCount.xls";
		test = reports.startTest("QC_MaxLoanCount", "Login-->Borrower-->Max loan count");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();

				for (int i = 1; i <= 2; i++) {

					ACSRLoginLogout.login(SSN, AppURL);
					MaxLoanCount.maxLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					if (!(i == 2)) {
						test.log(LogStatus.INFO, "******Customer loan Number " + i + "is approved successfully*****");
						break;
					} else {
						test.log(LogStatus.INFO, "******Customer loan Number " + i + "is denied*****");
						break;
					}
				}
			
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}

		}

	}

	@Test(priority = 2, enabled = true, groups = "Anoop")
	public void ILP_inactiveNewloan() throws Exception {
		FileName = "QC_NewLoan_InactiveCustomer.xls";
		test = reports.startTest("QC_NewLoan_InactiveCustomer", "Login-->Home Screen-->In active customer-->New Loan");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				CSRNewLoanInactivecust.newLoanInact(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}
	}

//-------------------------------------------------------------------------------------------------------------------
	//samatha Scenarios
	
	@Test(priority=1, groups = "Brahmith1")

	public static void QC_NewLoan_Promotion_Txn() throws Exception {
		

			test = reports.startTest("QC_ILP_NewLoan_Promotion","Login->Borrower Registration->New Loan with Promotion");

			FileName = "QC_ILP_NewLoan_Promotion_Txn.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
		
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					/*
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					BAdminStartDate.toStartdate(SSN, SSN);
					QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
					BProc3.proc();*/

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		
	}

	@Test(priority=2, groups = "Brahmith")

	public static void QC_NewLoan_Void_Txn() throws Exception {
		
			
			test = reports.startTest("QC_ILP_NewLoan_Void","Login->Borrower Registration->New Loan->Void");

			FileName = "QC_TLP_NewLoan_Void_Txn.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);				

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 54, groups = "Brahmith")

	public static void QC_AgeStore_Void_Txn() throws Exception {
		
			
			test = reports.startTest("QC_ILP_AgeStore_Void_Txn",
					"Login->Borrower Registratino->New Loan->AgeStore->Void");

			FileName = "QC_ILP_AgeStore_Void_Txn.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCEncryptionDetails.readEncryptionDetails(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				    QCAdminEncryption.getEncryption(driver, SSN, AppURL);
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCAgeStoreVoid.ageStoreVoid(SSN, AppURL);

					//QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 21, groups = "Brahmith")

	public static void QC_Installmentpayment_Txn() throws Exception {
		
			test = reports.startTest("QC_ILP_Installmentpayment",
					"Login->Borrower Registratino->New Loan->AgeStore->PartialPayment Pay Installment Amt");

			FileName ="QC_ILP_Installmentpayment_Txn.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

		
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 22, groups = "Brahmith")

	public static void QC_Installmentpayment_Void_Txn() throws Exception {
		
			test = reports.startTest("QC_ILP_Installmentpayment_Void",
					"Login->Borrower Registratino->New Loan->AgeStore->PartialPayment Pay Installment Amt->Void");

			FileName = "QC_ILP_Installmentpayment_Void_Txn.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

		
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);

				
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 23, groups = "Brahmith")

	public static void QC_PayAnyotherAmount_Txn() throws Exception {
		
			test = reports.startTest("QC_ILP_Payanyotheramount",
					"Login->Borrower Registratino->New Loan->AgeStore->PartialPayment Payanyotheramount");
			
			FileName = "QC_ILP_Payanyotheramount_Txn.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);
			
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				    QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
			}

	@Test(priority = 24, groups = "Brahmith")

	public static void QC_PayAnyotherAmount_Void_Txn() throws Exception {
		
			test = reports.startTest("QC_ILP_Payanyotheramount_Void",
					"Login->Borrower Registratino->New Loan->AgeStore->PartialPayment Payanyotheramount-> Void");

			FileName = "QC_ILP_Payanyotheramount_Void_Txn.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

		
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
			
				if (RunFlag.equals("Y")) {
					
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 31, groups = "Brahmith")

	public static void QC_ILP_Return_Menu_Txn() throws Exception {
		
			test = reports.startTest("QC_ILP_Return_Menu",
					"Login->Borrower Registratino->New Loan->AgeStore due date->Deposit Menu-> Age Store to gracedays->Return");

			

			FileName ="QC_ILP_Return_Menu_Txn.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);

					QCCSRLoginLogout.adminLogin(SSN, AppURL);
					QCReturnCheck.qcRturn(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 32, groups = "Brahmith")

	public static void QC_ILP_clear_Menu_Txn() throws Exception {
		
			test = reports.startTest("QC_ILP_clear_Menu",
					"Login->Borrower Registratino->New Loan->AgeStore due date->Deposit Menu-> Age Store to gracedays->->Return->clear");

			FileName =  "QC_ILP_clear_Menu_Txn.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					QCCSRLoginLogout.adminLogin(SSN, AppURL);
					QCReturnCheck.qcRturn(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCClearMenu.clearMenu(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 35, groups = "Brahmith")

	public static void QC_ILP_Deposit_Return_Txn() throws Exception {
		
			test = reports.startTest("QC_ILP_Deposit_Return",
					"Login->Borrower Registratino->New Loan->AgeStore due date->Deposit Menu-> Internal transfer->Cash Management->Return");

			FileName = "QC_ILP_Deposit_Return_Txn.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCDepositDropdown.depositDropDown(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCInternalTransfer.internalTransfer(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.adminLogin(SSN, AppURL);
					QCReturnCheck.qcRturn(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 55, groups = "Brahmith")

	public static void QC_ILP_NewLoanInstallmentDeposit_Txn() throws Exception {
		
			test = reports.startTest("QC_ILP_NewLoanInstallmentDeposit_Txn_Scenario",
					"Login->Borrower Registratino->New Loan->AgeStore due date to 1st installment->Deposit dropdown-> Continue till final installment");

			FileName = "QC_ILP_NewLoanInstallmentDeposit_Txn.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					//int No_of_Installments_Int = Integer.parseInt(No_of_Installments);
					int No_of_Installments_Int =20;
					int j;
					for (j = 1; j <= No_of_Installments_Int; j++) {
						test.log(LogStatus.INFO, "**********************************************");
						test.log(LogStatus.INFO, "Process has started for the installment no " + j);
						System.out.println("Process has started for the installment no " + j);
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						QCCSRLoginLogout.login(SSN, AppURL);

						QCDepositDropdown.depositDropDown(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
					}
					test.log(LogStatus.INFO, "Completed installment deposits for " + (j-1) + " installments");

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		
	}

	@Test(priority = 47, groups = "Brahmith")

	public static void QC_InstallPayment_Ref_Rescind_Txn() throws Exception {
		
			test = reports.startTest("QC_InstallPayment_Ref_Rescind",
					"Login->Borrower Registratino->New Loan->AgeStore due date ->Partial Payment->Refinance->Rescind");

			FileName ="QC_InstallPayment_Ref_Rescind_Txn.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCRefinanceprocess.Refinance(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCRescind.Rescind(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		
	}

	@Test(priority = 53, groups = "Brahmith")

	public static void QC_NewLoan_TLPConversion_Txn() throws Exception {
		
			test = reports.startTest("QC_NewLoan_TLPConversion",
					"Login->Borrower Registration->New Loan->AgeStore to 15 days ->TLP Conversion");

			FileName =  "QC_NewLoan_TLPConversion_Txn.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
			
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRTLPConversion.conversion(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory_Conversion.historyconversion(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		
	}

	@Test(priority = 51, groups = "Brahmith")

	public static void QC_LessInterest_VoidFullPayment_Txn() throws Exception {
		
			test = reports.startTest("QC_NewLoan_TLPConversion_Txn",
					"Login->Borrower Registration->New Loan->AgeStore to 12 days -> Less Than Interest Amount ->AgeStore to 12 days ->PartialPayment Pay Off the balance->Void");


			FileName = "QC_LessInterest_VoidFullPayment_Txn.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.paymentTwice(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		
	}

	@Test(priority = 16, groups = "Brahmith")

	public static void QC_ILP_Buyback_Txn() throws Exception {
		
			test = reports.startTest("QC_ILP_Buyback_Void_Txn",
					"Login->Borrower Registratino->New Loan->AgeStore->Pay Off the balance");

			FileName = "QC_ILP_Buyback_Txn.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
			
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);					

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 17, groups = "Brahmith")

	public static void QC_ILP_Buyback_Void_Txn() throws Exception {
		
			test = reports.startTest("QC_ILP_Buyback_Void_Txn",
					"Login->Borrower Registratino->New Loan->AgeStore->Payment Pay Off the balance-> Void");
			
			FileName =  "QC_ILP_Buyback_Void_Txn.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
			     if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);
				
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}




	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		try {

			BufferedReader reader;
			

			

			try {
				reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/test/java/tests/Objects.properties"));
				prop = new Properties();
				prop.load(reader);
				reader.close();
				String Afilename = prop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + Afilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}
		
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");

		}

		catch (Exception e) {

			test.log(LogStatus.ERROR, "Unable to setup for the QC Store ");

		}

	}

	@BeforeMethod(alwaysRun = true)

	public void killProcess() throws Exception {

		try {

			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			//Runtime.getRuntime().exec("taskkill /IM iexplore.exe /F");

			Thread.sleep(2000); // Allow OS to kill the process
			System.out.println("killed the process ILP scenarios");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/ILP/FailedTestsScreenshots/"
				+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);

				return destination;

		/*reports.flush();
		driver.quit();*/

		
	}

	@AfterMethod(alwaysRun = true)

	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			 test.log(LogStatus.FAIL, "Test Case Failed is"+result.getThrowable());

			String screenshotPath = getScreenhot(driver, result.getName());
			// To add it in the extent report
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " Test Case is Passed");
		}
		reports.flush();
		driver.quit();

	}

	@AfterMethod(alwaysRun = true)

	public void endReport() {

		// reports.endTest(test);
		// reports.flush();

		// driver.quit();
		// extent.flush();

	}

	public static By locator(String obj) {

		String loctype = null;
		String locname = null;
		By locator = null;
		String[] locobj = obj.split("%%");
		loctype = locobj[0];
		locname = locobj[1];
		

		if (loctype.equalsIgnoreCase("id"))
			return locator = By.id(locname);
		else if (loctype.equalsIgnoreCase("name"))
			return locator = By.name(locname);
		else if (loctype.equalsIgnoreCase("linkText"))
			return locator = By.linkText(locname);
		else if (loctype.equalsIgnoreCase("partialLinkText"))
			return locator = By.partialLinkText(locname);
		else if (loctype.equalsIgnoreCase("xpath"))
			return locator = By.xpath(locname);
		else if (loctype.equalsIgnoreCase("cssSelector"))
			return locator = By.cssSelector(locname);
		return locator;

		

	}

}