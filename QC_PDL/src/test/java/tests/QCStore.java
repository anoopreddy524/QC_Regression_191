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
	public static ExtentTest test;	
	public static String Eankey = null;
	public static String encryption_store_no = null;
	public static String encryption_transaction_nbr = null;
	public static String FileName;
	public static ExcelNew TestData;
	public static String loan_nbr;
	public static String business_date;
	public static String AppURL;
	public static String AdminURL;
	public static String FirstName;
	public static String passwrd;
	public static String report_filename;
	public static String LastName;
	public static String ESign_CheckNbr;
	public static String ESign_CollateralType;
	public static String NextDueDate;



	@Test(priority=1, groups = "Brahmith")
	public static void QC_NewLoan_Promotion_Txn() throws Exception {


		test = reports.startTest("QC_NewLoan_Promotion_Txn","Login->Borrower Registratino->New Loan with Promotion");

		FileName = "QC_NewLoan_Promotion_Txn.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);


		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				/*QCCSRLoginLogout.adminLogin(SSN, SSN);
					BAdminStartDate.toStartdate(SSN, SSN);
					QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
					BProc3.proc();*/

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority=2, groups = "Brahmith" )
	public static void QC_RefinanceStepDown_Txn() throws Exception {


		test = reports.startTest("QC_RefinanceStepDown_Txn",
				"Login->Borrower Registration->New Loan->AgeStore to Gracedays->Partial Payment->Age Store to Duedate->Refinance Stepdown");

		FileName ="QC_RefinanceStepDown_Txn.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {


				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCPayment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCRefinance.refinanceStepDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}

	}
	@Test(priority=3, groups = "Brahmith" )
	public static void QC_RefinanceStepDown_Void_Txn() throws Exception {


		test = reports.startTest("QC_RefinanceStepDown_Void_Txn",
				"Login->Borrower Registration->New Loan->AgeStore to Gracedays->Partial Payment->Age Store to Duedate->Refinance Stepdown->Void");

		FileName = "QC_RefinanceStepDown_Void_Txn.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCPayment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCRefinance.refinanceStepDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}

	}

	@Test(priority=4, groups = "Brahmith1" )
	public static void QC_OpenLoan_NewLoan_Txn() throws Exception {

		test = reports.startTest("QC_OpenLoan_NewLoan_Txn", "Login->Borrower Registratino->Open Loan->New Loan");

		FileName ="QC_OpenLoan_NewLoan_Txn.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {


				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority=5, groups = "Brahmith1" )
	public static void QC_NewLoan_Void_Txn() throws Exception {


		test = reports.startTest("QC_NewLoan_Void_Txn", "Login->Borrower Registratino->New Loan->Void");

		FileName = prop.getProperty("QC_Store_NewLoan_Void_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";
		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {


				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}

	}
	@Test(priority=6, groups = "Brahmith" )
	public static void QC_AgeStore_Void_Txn() throws Exception {


		test = reports.startTest("QC_AgeStore_Void_Txn", "Login->Borrower Registratino->New Loan->AgeStore->Void");

		FileName = prop.getProperty("QC_Store_AgeStore_Void_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCEncryptionDetails.readEncryptionDetails(SSN, AppURL);
				ACSRLoginLogout.logout();
				QCCSRLoginLogout.adminLogin( SSN, AppURL);
				QCAdminEncryption.getEncryption(driver, SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreVoid.ageStoreVoid(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}

	}

	
	@Test(priority=7, groups = "Brahmith" )
	public static void QC_Deposit_Menu_Txn() throws Exception {

		test = reports.startTest("QC_Deposit_Menu_Txn",
				"Login->Borrower Registratino->New Loan->AgeStore->Deposit through Menu");

		FileName = prop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name") + ".xls";
		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";
		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCDepositMenu.depositMenu(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();


			}
		}

	}

	@Test(priority=8, groups = "Brahmith" )
	public static void QC_Deposit_GraceDays_Txn() throws Exception {


		test = reports.startTest("QC_Deposit_GraceDays_Txn",
				"Login->Borrower Registration->New Loan->AgeStore Duedate->AgeStore Gracedays->Deposit through dropdown");

		FileName = prop.getProperty("QC_Store_AgeStore_Deposit_GraceDays_Dropdown_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";
		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {


				String SSN = TestData.getCellData(sheetName, "SSN", row);


				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}

	}

	@Test(priority=9, groups = "Brahmith" )
	public static void QC_FutureDeposit_DropDown() throws Exception {


		test = reports.startTest("QC_FutureDeposit_DropDown",
				"Login->Borrower Registration->New Loan->AgeStore Duedate->Future Date->Age Store Gracedays->Deposit through dropdown");

		FileName = prop.getProperty("QC_FutureDeposit_DropDown_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";
		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {


				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCFutureDeposit.futureDeposit(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}

	}

	@Test(priority=10, groups = "Brahmith" )
	public static void QC_Epp_Deposit_Void_Txn() throws Exception {


		test = reports.startTest((prop.getProperty("QC_Epp_Deposit_Void_Txn_scenario")),
				"Login->Borrower Registration->New Loan->AgeStore to Due Date->EPP loan->AgeStore to Due Date->Deposit through dropdown->Void");

		FileName = prop.getProperty("QC_Epp_Deposit_Void_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {


				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCStoreEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}

	}

	@Test(priority=11, groups = "Brahmith" )
	public static void QC_Epp_PrePayment_Txn() throws Exception {


		test = reports.startTest("QC_Epp_PrePayment_Txn",
				"Login->Borrower Registration->New Loan->AgeStore to Due Date->EPP loan->AgeStore to Due Date->Deposit through dropdown->AgeStore to Due Date->Pre Payment");

		FileName = prop.getProperty("QC_Epp_PrePayment_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = 12;
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {


				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCStoreEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCPrePayment.prePayment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}

	}

	@Test(priority=12, groups = "Brahmith" )
	public static void QC_Epp_Check_Deposit_Clear_Txn() throws Exception {


		test = reports.startTest("QC_Epp_Check_Deposit_Clear_Txn",
				"Login->Borrower Registration->New Loan->AgeStore to Due Date->EPP loan->AgeStore to Due Date->Deposit through dropdown->Internal transfer->->Cash Management->Clear");

		FileName = prop.getProperty("QC_Epp_Deposit_Clear_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = 12;
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCStoreEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCInternalTransfer.internalTransfer(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCClearDropdown.clearDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}

	}

	@Test(priority=13, groups = "Brahmith" )
	public static void QC_EppDepositClear_Refund_Txn() throws Exception {

		test = reports.startTest("QC_EppDepositClear_Refund_Txn",
				"Login->Borrower Registration->New Loan->AgeStore to Due Date->EPP loan->AgeStore to Due Date->Deposit through dropdown->AgeStore to gracedays->Pre Payment->AgeStore to gracedays->Clear->Refund");

		FileName = prop.getProperty("QC_EppDepositClear_Refund_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = 12;
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCStoreEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCPrePayment.prePayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCClearDropdown.clearDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCRefund.qcRefund(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}

	}

	@Test(priority=14, groups = "Brahmith" )
	public static void QC_Epp_PrePayment_Return_Txn() throws Exception {


		test = reports.startTest("QC_Epp_PrePayment_Return_Txn",
				"Login->Borrower Registration->New Loan->AgeStore to Due Date->EPP loan->AgeStore to Due Date->Deposit through dropdown->AgeStore to Due Date->Pre Payment->Internal Transfer->Cash Management->Return Posting");

		FileName = prop.getProperty("QC_Epp_PrePayment_Return_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = 12;
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCStoreEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCPrePayment.prePayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCInternalTransfer.internalTransfer(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
				ACSRLoginLogout.logout();
				QCCSRLoginLogout.adminLogin(SSN, AppURL);
				QCReturnCheck.qcRturn(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}

	}

	@Test(priority=15, groups = "Brahmith" )
	public static void QC_Epp_Return_NSFPayment_Txn() throws Exception {


		test = reports.startTest("QC_Epp_Return_NSFPayment_Txn",
				"Login->Borrower Registration->New Loan->AgeStore to Due Date->EPP loan->AgeStore to Due Date->Deposit through dropdown->AgeStore to Due Date->Pre Payment->Internal Transfer->Cash Management->Return Posting->NSF Payment");

		FileName = prop.getProperty("QC_Epp_Return_NSFPayment_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = 12;
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCStoreEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCInternalTransfer.internalTransfer(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
				ACSRLoginLogout.logout();
				QCCSRLoginLogout.adminLogin(SSN, AppURL);
				QCReturnCheck.qcRturn(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCNSFPayment.nsfpayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}

	}

	@Test(priority=16, groups = "Brahmith" )
	public static void QC_Epp_Return_ReDeposit_Txn() throws Exception {


		test = reports.startTest("QC_Epp_Return_ReDeposit",
				"Login->Borrower Registration->New Loan->AgeStore to Due Date->EPP loan->AgeStore to Due Date->Deposit through dropdown->AgeStore to Due Date->Pre Payment->Internal Transfer->Cash Management->Re Deposit");

		FileName = prop.getProperty("QC_Epp_Return_ReDeposit_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = 12;
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {


				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCStoreEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				QCInternalTransfer.internalTransfer(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
				ACSRLoginLogout.logout();
				QCCSRLoginLogout.adminLogin(SSN, AppURL);
				QCReturnCheck.qcRturn(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCRedeposit.redeposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}

	}

	@Test(priority=17, groups = "Brahmith" )
	public static void QC_Void_FullReturnPayment_Txn() throws Exception {

		test = reports.startTest("QC_Void_FullReturnPayment",
				"Login->Borrower Registration->New Loan->AgeStore to Due Date->Deposit through dropdown->Internal Transfer->Cash Management->Return Posting->Re Deposit->Internal Transfer->Cash Management->->Return Posting->Partial Payment->Void->Full Return Payment->Void->Full Return Payment");

		FileName = prop.getProperty("QC_Void_FullReturnPayment_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = 12;
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {


				String SSN = TestData.getCellData(sheetName, "SSN", row);


				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				QCInternalTransfer.internalTransfer(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
				ACSRLoginLogout.logout();
				QCCSRLoginLogout.adminLogin(SSN, AppURL);
				QCReturnCheck.qcRturn(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCRedeposit.redeposit(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCInternalTransfer.internalTransfer(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
				ACSRLoginLogout.logout();
				QCCSRLoginLogout.adminLogin(SSN, AppURL);
				QCReturnCheck.qcRturn(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCPayment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCNSFPayment.nsfpayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCNSFPayment.nsfpayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}

	}

	@Test(priority=18, groups = "Brahmith" )
	public static void QC_PartialPayment_RefundVoid_Txn() throws Exception {

		test = reports.startTest("QC_PartialPayment_RefundVoid",
				"Login->Borrower Registration->New Loan->AgeStore to Due Date->Patial Payment->->Deposit through dropdown->Internal Transfer->Cash Management->Deposit clear>Refund->Void");

		FileName = prop.getProperty("QC_PartialPayment_RefundVoid_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = 12;
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {


				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCPayment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				QCInternalTransfer.internalTransfer(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCClearDropdown.clearDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCRefund.qcRefund(SSN, AppURL);

				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCVoid.qcVoid(SSN, AppURL);

				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}

	}

	

	
	@Test(priority = 201, groups = { "Rebate" })
	public static void QC_Refinance_StepDownURP_Txn() throws Exception {


		test = reports.startTest("QC_Refinance_StepDownURP",
				"Login->Borrower Registration->New Loan->AgeStore to Gracedays->Partial Payment->AgeStore to Gracedays->Refinance Stepdown->Rebate");

		FileName = prop.getProperty("QC_Refinance_StepDownURP_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";
		// int lastrow=TestData.getLastRow("Borrower");
		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {

				// String AppURL = TestData.getCellData(sheetName, "AppURL",
				// row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				QCCSRLoginLogout.adminLogin(SSN, SSN);
				BAdminRebateDate.toStartdate(SSN, SSN);
				QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
				BProc3.proc();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCPayment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCRefinance.refinanceStepDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}

	}

	@Test(priority = 202, groups = { "Rebate" })
	public static void QC_Refinance_StepDownVoidURP_Txn() throws Exception {


		test = reports.startTest("QC_Refinance_StepDownVoidURP",
				"Login->Borrower Registration->New Loan->AgeStore to Gracedays->Partial Payment->AgeStore to Gracedays->Refinance Stepdown->Rebate->Void");

		FileName = prop.getProperty("QC_Refinance_StepDownVoidURP_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";
		// int lastrow=TestData.getLastRow("Borrower");
		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {


				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCPayment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCRefinance.refinanceStepDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}

	}

	@Test(priority = 198, groups = { "Brahmith_NV" })
	public static void QC_Refinance_StepSameURP_Txn() throws Exception {


		test = reports.startTest("QC_Refinance_StepSameURP_Txn",
				"Login->Borrower Registration->New Loan->AgeStore to Gracedays->Partial Payment->AgeStore to Gracedays->Refinance StepSame->Rebate");

		FileName = prop.getProperty("QC_Refinance_StepSameURP_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {


				String SSN = TestData.getCellData(sheetName, "SSN", row);
				QCCSRLoginLogout.adminLogin(SSN, SSN);
				BAdminNVDate.toStartdate(SSN, SSN);
				QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
				BProc3.proc();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCPayment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCRefinance.refinanceStepSame(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}

	}

	@Test(priority = 199, groups = { "Brahmith_NV" })
	public static void QC_Refinance_StepSameVoidURP_Txn() throws Exception {


		test = reports.startTest("QC_Refinance_StepSameVoidURP",
				"Login->Borrower Registration->New Loan->AgeStore to Gracedays->Partial Payment->AgeStore to Gracedays->Refinance StepSame->Rebate->Void");

		FileName = prop.getProperty("QC_Refinance_StepSameVoidURP_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {


				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCPayment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCRefinance.refinanceStepSame(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}

	}

	@Test(priority = 281, groups = { "EOD" })
	public static void QC_EOD_Deposit_Txn() throws Exception {

		test = reports.startTest("QC_EOD_Deposit_Txn",
				"Login->Borrower Registration->New Loan->AgeStore Duedate->Deposit through EOD");

		FileName = prop.getProperty("QC_store_AgeStore_DueDate_Deposit_EOD_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {


				String SSN = TestData.getCellData(sheetName, "SSN", row);

				System.out.println(AppURL);

				QCCSRLoginLogout.adminLogin(SSN, SSN);
				BAdminEODDate.toStartdate(SSN, SSN);
				QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
				BProc3.proc();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCEODDeposit.eodDeposit(SSN, AppURL);
				// ACSRLoginLogout.logout();
				QCAdminStoreSetup.storeSetup(SSN, AppURL);
				QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCSafeAssign.safeAssign(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCDrawerAssign.drawerAssign(SSN, AppURL);

				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}

	}

	@Test(priority = 282, groups = { "EOD" })
	public static void QC_GraceDays_EODDeposit_Txn() throws Exception {


		test = reports.startTest("QC_GraceDays_EODDeposit_Txn",
				"Login->Borrower Registration->New Loan->AgeStore Duedate->Age Store Gracedays->Deposit through EOD");

		FileName = prop.getProperty("QC_GraceDays_EODDeposit_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";


		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {


				String SSN = TestData.getCellData(sheetName, "SSN", row);



				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCEODDeposit.eodDeposit(SSN, AppURL);

				QCAdminStoreSetup.storeSetup(SSN, AppURL);
				QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCSafeAssign.safeAssign(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCDrawerAssign.drawerAssign(SSN, AppURL);

				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}

	}

	@Test(priority = 283, groups = { "EOD" })
	public static void QC_FutureDeposit_EOD_Txn() throws Exception {

		test = reports.startTest("QC_FutureDeposit_EOD_Txn",
				"Login->Borrower Registration->New Loan->AgeStore Duedate->Future Date->Age Store Gracedays->Deposit through EOD");

		FileName = prop.getProperty("QC_FutureDeposit_EOD_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {


				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCFutureDeposit.futureDeposit(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCEODDeposit.eodDeposit(SSN, AppURL);

				QCAdminStoreSetup.storeSetup(SSN, AppURL);
				QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				QCSafeAssign.safeAssign(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCDrawerAssign.drawerAssign(SSN, AppURL);

				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				QCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}

	}
	//***************************************************************************************
	@Test(priority=1, enabled = true, groups = "Janaki")

	public static void JQC_AgeStore_Deposit_PrePayment_Txn() throws Exception {

		test = reports.startTest("QC_PrePayment","Login->Borrower Registratino->New Loan->AgeStore->ACH/Check Deposit-> AgeStore-> PrePayment");

		FileName ="QC_PrePayment_Txn_TestData.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCPrePayment.prePayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority=2, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_Deposit_PrePayment_Void_Txn() throws Exception {

		test = reports.startTest("QC_PrePayment_Void",
				"Login->Borrower Registratino->New Loan->AgeStore->ACH/Check Deposit-> AgeStore-> PrePayment-> Void");

		FileName = "QC_PrePayment_Void_Txn_TestData.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);



				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCPrePayment.prePayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCPrePaymentVoid.prePaymentVoid(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority=3, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_Deposit_ClearDropdown_Txn() throws Exception {

		test = reports.startTest("QC_Clear_Dropdown",
				"Login->Borrower Registratino->New Loan->AgeStore->ACH/Check Deposit-> AgeStore-> Clear");

		FileName ="QC_Clear_Dropdown_Txn_TestData.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";
		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);


				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				if (ESign_CollateralType.equalsIgnoreCase("CHECK")) {
					ACSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				} else if (ESign_CollateralType.equalsIgnoreCase("ACH")) {
					AQCAdminLoginLogout.login(SSN, AppURL);
					JQCACHProcessing.ACHProcess(SSN, NextDueDate);
					AQCAdminLoginLogout.logout(SSN, AppURL);
				}
				ACSRLoginLogout.login(SSN, AppURL);
				JQCClearDropdown.clearDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}

	}

	@Test(priority=4, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_Deposit_ClearMenu_Txn() throws Exception {

		test = reports.startTest("QC_Clear_Menu",
				"Login->Borrower Registratino->New Loan->AgeStore->ACH/Check Deposit-> AgeStore-> Clear");

		FileName ="QC_Clear_Menu_Txn_TestData.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String adminURL = TestData.getCellData(sheetName, "AdminURL", row);
				String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);


				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositMenu.depositMenu(SSN, AppURL);
				ACSRLoginLogout.logout();
				if (ESign_CollateralType.equalsIgnoreCase("CHECK")) {
					ACSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				} else if (ESign_CollateralType.equalsIgnoreCase("ACH")) {
					AQCAdminLoginLogout.login(SSN, AppURL);
					JQCACHProcessing.ACHProcess(SSN, NextDueDate);
					AQCAdminLoginLogout.logout(SSN, AppURL);
				}
				ACSRLoginLogout.login(SSN, AppURL);
				JQCClearMenu.clearMenu(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}

	}

	@Test(priority =5, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_Deposit_AutoClear_Txn() throws Exception {

		test = reports.startTest("QC_AutoClear",
				"Login->Borrower Registratino->New Loan->AgeStore->ACH/Check Deposit-> AgeStore-> AutoClear");


		FileName = "QC_AutoClear_Txn_TestData.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				if (ESign_CollateralType.equalsIgnoreCase("CHECK")) {
					ACSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				} else if (ESign_CollateralType.equalsIgnoreCase("ACH")) {
					AQCAdminLoginLogout.login(SSN, AppURL);
					JQCACHProcessing.ACHProcess(SSN, NextDueDate);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				}
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAutoClear.autoClear(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority =6, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_PrePayment_Return_Txn() throws Exception {

		test = reports.startTest("QC_PrePayment_Return",
				"Login->Borrower Registratino->New Loan->AgeStore->Deposit->AgeStore -> Pre-payment -> AgeStore -> Return");
		FileName = "QC_PrePayment_Return_Txn.xls";
		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String SSN = TestData.getCellData(sheetName, "SSN", row);

				String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCPrePayment.prePayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreGraceDays.secondAgeStoreGraceDays(SSN, AppURL);
				if (ESign_CollateralType.equalsIgnoreCase("CHECK")) {
					AQCAdminLoginLogout.login(SSN, AppURL);
					JQC_EPP_Return.qcReturn(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
				} else if (ESign_CollateralType.equalsIgnoreCase("ACH")) {
					AQCAdminLoginLogout.login(SSN, AppURL);
					JQCACHProcessing.ACHProcess(SSN, NextDueDate);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					JQCACHReturn.ACHReturn(SSN, AppURL);
					ACSRLoginLogout.logout();

				}
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}
	}

	@Test(priority=7, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_PrePayment_Clear_Txn() throws Exception {

		test = reports.startTest("QC_PrePayment_Clear",
				"Login->Borrower Registratino->New Loan->AgeStore->Deposit->AgeStore -> Pre-payment -> AgeStore -> Clear");
		FileName = "QC_PrePayment_Clear_Txn.xls";
		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCPrePayment.prePayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreGraceDays.secondAgeStoreGraceDays(SSN, AppURL);
				if (ESign_CollateralType.equalsIgnoreCase("ACH")) {
					AQCAdminLoginLogout.login(SSN, AppURL);
					JQCACHProcessing.ACHProcess(SSN, NextDueDate);
					AQCAdminLoginLogout.logout(SSN, AppURL);
				}
				ACSRLoginLogout.login(SSN, AppURL);
				JQCClearDropdown.clearDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}
	}
	@Test(priority =8, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_NSFPosting_Refinance_Rescind_Txn() throws Exception {

		test = reports.startTest("QC_NSFPosting_Refinance_Rescind",
				"Login->Borrower Registratino->New Loan->AgeStore->Deposit->NSFPosting->Refinance->Rescind");

		FileName ="QC_NSFPosting_Refinance_Rescind_Txn_TestData.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";


		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);



				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();
				AQCAdminLoginLogout.login(SSN, AppURL);
				JQC_EPP_Return.qcReturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCRefinance.Refinance(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCRescind.Rescind(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority =9, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_ACHReturn_Refinance_Rescind_Txn() throws Exception {

		test = reports.startTest("QC_ACHReturn_Refinance_Rescind",
				"Login->Borrower Registratino->New Loan->AgeStore->Deposit->ACHReturn->Refinance->Rescind");

		FileName = "QC_ACHReturn_Refinance_Rescind_Txn_TestData.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				AQCAdminLoginLogout.login(SSN, AppURL);
				JQCACHProcessing.ACHProcess(SSN, NextDueDate);
				AQCAdminLoginLogout.logout(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCACHReturn.ACHReturn(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCRefinance.Refinance(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCRescind.Rescind(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}


	@Test(priority=10,enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_Deposit_Return_Refinance_Txn() throws Exception {

		test = reports.startTest("QC_Deposit_Return_Refinance",
				"Login->Borrower Registratino->New Loan->AgeStore->Return->Deposit->Return->Refinance");

		FileName ="QC_Deposit_Return_Refinance_Txn.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);


				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				if (ESign_CollateralType.equalsIgnoreCase("ACH")) {
					AQCAdminLoginLogout.login(SSN, AppURL);
					JQCACHProcessing.ACHProcess(SSN, NextDueDate);
					AQCAdminLoginLogout.logout(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					JQCACHReturn.ACHReturn(SSN, AppURL);
					ACSRLoginLogout.logout();
				} else if (ESign_CollateralType.equalsIgnoreCase("CHECK")) {
					ACSRLoginLogout.login(SSN, AppURL);
					AInternalTfAndCashManagement.internaltf(SSN, AppURL);
					ACSRLoginLogout.logout();
					AQCAdminLoginLogout.login(SSN, AppURL);
					JQC_EPP_Return.qcReturn(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
				}
				ACSRLoginLogout.login(SSN, AppURL);
				JQCRefinance.Refinance(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority=11, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_Deposit_Return_Refinance_Void_Txn() throws Exception {

		test = reports.startTest("QC_Deposit_Return_Refinance_Void",
				"Login->Borrower Registratino->New Loan->AgeStore->Return->Deposit->Return->Refinance-> Void");

		FileName ="QC_Deposit_Return_Refinance_Void_Txn.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);


				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				if (ESign_CollateralType.equalsIgnoreCase("ACH")) {
					AQCAdminLoginLogout.login(SSN, AppURL);
					JQCACHProcessing.ACHProcess(SSN, NextDueDate);
					AQCAdminLoginLogout.logout(SSN, NextDueDate);
					ACSRLoginLogout.login(SSN, AppURL);
					JQCACHReturn.ACHReturn(SSN, AppURL);
					ACSRLoginLogout.logout();
				} else if (ESign_CollateralType.equalsIgnoreCase("CHECK")) {
					ACSRLoginLogout.login(SSN, AppURL);
					AInternalTfAndCashManagement.internaltf(SSN, AppURL);
					ACSRLoginLogout.logout();
					AQCAdminLoginLogout.login(SSN, AppURL);
					JQC_EPP_Return.qcReturn(SSN, AppURL);
					AQCAdminLoginLogout.logout(SSN, AppURL);
				}
				ACSRLoginLogout.login(SSN, AppURL);
				JQCRefinance.Refinance(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority=12, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_Refinance_Rescind_Txn() throws Exception {

		test = reports.startTest("QC_Refinance_Rescind",
				"Login->Borrower Registratino->New Loan->AgeStore->Return->Deposit->Return->Refinance");

		FileName = "QC_Refinance_Rescind_Txn.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCPayment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCRefinance.Refinance(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCRescind.Rescind(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority =13, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_Redeposit_Prepayment_Void_Prepayment_Return_Txn() throws Exception {

		test = reports.startTest("QC_Redeposit_Prepayment_Void_Return",
				"Login->Borrower Registratino->New Loan->AgeStore->Deposit->Return->ReDeposite->Prepayment->Void->Prepayment->Return");

		FileName ="QC_Redeposit_Prepayment_Void_Return_Txn.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++)

		{

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);


				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();
				AQCAdminLoginLogout.login(SSN, AppURL);
				JQC_EPP_Return.qcReturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCRedeposit.redeposit(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCPrePayment.prePayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCPrePaymentVoid.prePaymentVoid(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCPrePayment.prePayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();
				AQCAdminLoginLogout.login(SSN, AppURL);
				JQC_EPP_Return.qcReturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority =14, enabled = true, groups = "Janaki")
	public static void JQC_Return_ReDeposit_Clear_Txn() throws Exception {

		test = reports.startTest("QC_Return_ReDeposit_Clear",
				"Login->Borrower Registratino->New Loan with Promotion->JQC_Return_ReDeposit_Clear_Txn");
		FileName = "QC_Return_ReDeposit_Clear_Txn_Testdata.xls";
		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = 3;
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();
				AQCAdminLoginLogout.login(SSN, AppURL);
				JQC_EPP_Return.qcReturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCRedeposit.redeposit(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCClearDropdown.clearDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority =15, enabled = true, groups = "Janaki")
	public static void JQC_BuyBack_Txn_Testdata() throws Exception {

		test = reports.startTest("QC_BuyBack",
				"Login->Borrower Registration->New Loan->AgeStore to Duedate->BuyBack");
		String FileName = "QC_BuyBack_Txn_Testdata.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);


				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRBuyBack.buyback(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority =16, enabled = true, groups = "Janaki")
	public static void JQC_BuyBack_Void_Txn_Testdata() throws Exception {

		test = reports.startTest("QC_BuyBack_Void",
				"Login->Borrower Registration->New Loan->AgeStore to Duedate->BuyBack-->Void");
		String FileName ="QC_BuyBack_Void_Txn_Testdata.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);


				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRBuyBack.buyback(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRBuyBackVoid.buybackvoid(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}


	@Test(priority = 17, enabled = true, groups = "Janaki")
	public static void JQC_BuyBack_Rebate_Txn_Testdata() throws Exception {

		test = reports.startTest("QC_BuyBack_Rebate",
				"Login->Borrower Registration->New Loan->AgeStore->BuyBack Rebate");
		String FileName ="QC_BuyBack_Rebate_Txn_Testdata.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);


				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRBuyBackRebate.buybackrebate(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}
	@Test(priority = 18, enabled = true, groups = "Janaki")
	public static void JQC_BuyBack_Rebate_Void_Txn_Testdata() throws Exception {

		test = reports.startTest("QC_BuyBack_Rebate_Void",
				"Login->Borrower Registration->New Loan->AgeStore-->BuyBack Rebate-->Void");
		String FileName = "QC_BuyBack_Rebate_Void_Txn_Testdata.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRBuyBackRebate.buybackrebate(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRBuyBackVoid.buybackvoid(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority =19, enabled = true, groups = "Janaki")
	public static void JQC_ChkDeposit_RtnChk_ReDeposit_Payment_Void_Clear_Txn_Testdata() throws Exception {

		test = reports.startTest("QC_ChkDeposit_RtnChk_ReDeposit_Payment_Void_Clear",
				"Login->Borrower Registration->New Loan->AgeStore to Duedate->Chk deposi-->Return-->Redeposit-->Payment-->Void-->Payment-->Clear");
		String FileName = "QC_ChkDeposit_RtnChk_ReDeposit_Payment_Void_Clear_Txn_Testdata.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		int lastrow = TestData.getLastRow("Start");

		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);



				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();
				AQCAdminLoginLogout.login(SSN, AppURL);
				JQCCSRReturnPosting.ReturnPosting(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRRedeposit.redeposit(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRPrePayment.prepayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRWOVoid.writeoffvoid(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRPrePayment.prepayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRClearCheck.clearcheck(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}


	@Test(priority=20, enabled = true, groups = "Janaki")
	public static void JQC_Deposit_Return_EPP_Txn_Testdata() throws Exception {

		test = reports.startTest("QC_Deposit_Return_EPP",
				"Login->Borrower Registration->New Loan->AgeStore to Duedate->EPP->Deposit->Return");
		String FileName ="QC_Deposit_Return_EPP_Txn_Testdata.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		int lastrow = TestData.getLastRow("Start");

		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSREPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();
				AQCAdminLoginLogout.login(SSN, AppURL);
				JQCCSRReturnPosting.ReturnPosting(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}


	@Test(priority=21, enabled = true, groups = "Janaki")
	public static void JQC_EPP_AgestoreInstallmentwise_EPPPayment_Txn_Testdata() throws Exception {

		test = reports.startTest("QC_EPP_AgestoreInstallmentwise_EPPPayment",
				"Login->Borrower Registration->New Loan->AgeStore to Duedate->EPP-->Agestore Installmentwise-->EPP Payment");
		String FileName ="QC_EPP_AgestoreInstallmentwise_EPPPayment_Txn_Testdata.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		int lastrow = TestData.getLastRow("Start");

		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);



				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSREPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSREPP_Payment.epppayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSREPP_Payment.epppayment(SSN, AppURL);// 2
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSREPP_Payment.epppayment(SSN, AppURL);// 3
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSREPP_Payment.epppayment(SSN, AppURL);// 4
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}


	@Test(priority=22, enabled = true, groups = "Janaki")
	public static void JQC_PartialWORecovery_FullWORecovery_Void_Txn_Testdata() throws Exception {

		test = reports.startTest("QC_PartialWORecovery_FullWORecovery_Void",
				"Login->Borrower Registration->New Loan->AgeStore to Duedate->Chk deposit-->Internal Transfer-->Cashmgmt Deposit-->Writeoff-->WriteoffRecovery-->Void");
		String FileName = "QC_PartialWORecovery_FullWORecovery_Void_Txn_Testdata.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();
				AQCAdminLoginLogout.login(SSN, AppURL);
				JQCCSRReturnPosting.ReturnPosting(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRWriteOff.writeoff(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRWriteOffRecovery.writeoffrecovery(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRWOVoid.writeoffvoid(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority =23, enabled = true, groups = "Janaki")
	public static void JQC_EPP_Txn_Testdata() throws Exception {

		test = reports.startTest("QC_EPP",
				"Login->Borrower Registration->New Loan->AgeStore to Duedate->EPP");
		String FileName ="QC_EPP_Txn_Testdata.xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");

		String sheetName = "Start";

		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);



				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSREPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}
	}
	//**************************************************************************************************************
	@Test(priority = 410, enabled = true)
	public static void JQC_AgeStore_DCDeposit_Txn() throws Exception {

		test = reports.startTest((prop.getProperty("QC_DCDeposit_Dropdown_Txn")),
				"Login->Borrower Registratino->New Loan->AgeStore->DC Deposit");

		FileName = prop.getProperty("QC_DCDeposit_Dropdown_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);


				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}



	@Test(priority = 411, enabled = true)
	public static void JQC_AgeStore_DCDeposit_Menu_Txn() throws Exception {

		test = reports.startTest((prop.getProperty("QC_DCDeposit_Menu_Txn")),
				"Login->Borrower Registratino->New Loan->AgeStore->DC Deposit");

		FileName = prop.getProperty("QC_DCDeposit_Menu_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);


				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositMenu.depositMenu(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}



	@Test(priority = 412, enabled = true)
	public static void JQC_AgeStore_GraceDays_DCDeposit_Dropdown_Txn() throws Exception {

		test = reports.startTest((prop.getProperty("QC_GraceDays_DCDeposit_Dropdown_Txn")),
				"Login->Borrower Registratino->New Loan->AgeStore->DC Deposit");


		FileName = prop.getProperty("QC_GraceDays_DCDeposit_Dropdown_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				System.out.println(AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}



	@Test(priority = 413, enabled = true)
	public static void JQC_AgeStore_GraceDays_DCDeposit_Menu_Txn() throws Exception {

		test = reports.startTest((prop.getProperty("QC_GraceDays_DCDeposit_Menu_Txn")),
				"Login->Borrower Registratino->New Loan->AgeStore->DC Deposit");

		FileName = prop.getProperty("QC_GraceDays_DCDeposit_Menu_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				System.out.println(AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCDepositMenu.depositMenu(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority = 415, enabled = true)
	public static void JQC_NewLoan_Veritec_Txn() throws Exception {


		test = reports.startTest(prop.getProperty("QC_NewLoan_Veritec_Txn_file_name"),
				"Login->Borrower Registratino->New Loan with Veritec");

		FileName = prop.getProperty("QC_NewLoan_Veritec_Txn_file_name") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = 3;
		String sheetName = "Start";

		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {

				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);


				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQC_NewLoan_Veritec.newLoan(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				JQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}







	@Test(priority = 424, enabled = true)
	public static void JQC_ACH_PartialWORecovery_FullWORecovery_Void_Txn_Testdata() throws Exception {

		test = reports.startTest(
				(prop.getProperty("QC_ACH_PartialWORecovery_FullWORecovery_Void_Txn_Testdata_Scenario")),
				"Login->Borrower Registration->New Loan->AgeStore to Duedate->ACH deposit-->ACHReturn-->Writeoff-->WriteoffRecovery-->Void");
		String FileName = prop.getProperty("QC_ACH_PartialWORecovery_FullWORecovery_Void_Txn_Testdata") + ".xls";

		TestData = new ExcelNew(System.getProperty("user.dir")
				+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		int lastrow = TestData.getLastRow("Start");
		String sheetName = "Start";
		
		for (int row = 2; row <= lastrow; row++) {

			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				System.out.println(AppURL);
				String NextDueDate = "01/31/2018";

				/*
				 * ACSRLoginLogout.login(SSN, AppURL);
				 * JQCBorrowerRegistration.borrowerRegistration(SSN,
				 * AppURL); ACSRLoginLogout.logout();
				 * ACSRLoginLogout.login(SSN, AppURL);
				 * JQCCSRNewLoan.newLoan(SSN, AppURL);
				 * ACSRLoginLogout.logout();
				 * ACSRLoginLogout.login(SSN, AppURL);
				 * JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				 * ACSRLoginLogout.login(SSN, AppURL);
				 * JQCDepositDropdown.depositDropDown(SSN, AppURL);
				 * ACSRLoginLogout.logout();
				 */
				JQCAdminLoginLogout.login(SSN, AppURL);
				JQCACHProcessing.ACHProcess(SSN, NextDueDate);
				JQCAdminLoginLogout.logout(SSN, AppURL);
				/*
				 * JQCAdminACHReturn.achreturn(SSN, AppURL);
				 * ACSRLoginLogout.login(SSN, AppURL);
				 * JQCCSRWriteOff.writeoff(SSN, AppURL);
				 * ACSRLoginLogout.login(SSN, AppURL);
				 * JQCCSRWriteOffRecovery.writeoffrecovery(SSN, AppURL);
				 * ACSRLoginLogout.login(SSN, AppURL);
				 * JQCCSRWOVoid.writeoffvoid(SSN, AppURL);
				 * ACSRLoginLogout.login(SSN, AppURL);
				 * JQCCSRHistory.history(SSN, AppURL);
				 * ACSRLoginLogout.logout();
				 */

			}
		}
	}




	//***************************************************************************************
	// Anoop scenarios

	@Test(priority = 22, enabled=true, groups ="Anoop")

	public void AQC_EPP_Redeposit() throws Exception {

		FileName = "QC_EPP_Redeposit.xls";
		test = reports.startTest("QC_EPP_Redeposit", "EPP --> EPP payment ---> Deposit-->Return-->Redeposit");
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
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPPayment.epppayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQC_EPP_Return.qcReturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_Redeposit.redeposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "*************Test Scenario for EPP Redeposit is pass *************");
			}
		}
	}

	@Test(priority = 21, enabled=true, groups = "Anoop")

	public void AQC_EPP_nsfPayment() throws Exception {

		FileName = "QC_EPP_nsfPayment.xls";
		test = reports.startTest("QC_EPP_nsfPayment", "EPP --> EPP payment ---> Deposit-->Return-->NsfPayment");
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
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPPayment.epppayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQC_EPP_Return.qcReturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_NSFPayment.nsfpayment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				test.log(LogStatus.INFO, "*************Test Scenario for EPP Nsf Payment is pass *************");
			}
		}
	}

	@Test(priority = 20, enabled=true, groups = "Anoop")

	public void AQC_EPP_Return() throws Exception {

		FileName = "QC_EPP_Prepayment_Return.xls";
		test = reports.startTest("QC_EPP_Prepay_Return", "EPP --> EPP payment ---> Deposit--> prepayment --> Return");
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
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPPayment.epppayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_Prepayment.Prepayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQC_EPP_Return.qcReturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for EPP Return is pass******");
			}
		}
	}

	@Test(priority = 19, enabled=true, groups = "Anoop")

	public void AQC_EPP_refund() throws Exception {

		FileName = "QC_EPP_Refund.xls";
		test = reports.startTest("QC_EPP_Refund", "EPP --> EPP payment ---> Deposit--> prepayment --> clear--> refund");

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
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPPayment.epppayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_Prepayment.Prepayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AEPPClearOnly.eppClear(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPRefund.qcRefund(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for EPP refund is pass******");
			}
		}
	}

	@Test(priority = 18, enabled=true, groups = "Anoop")

	public void AQC_EPP_clear() throws Exception {

		FileName = "QC_EPP_Clear.xls";
		test = reports.startTest("QC_EPP_DepositClear", "EPP -->EPP payment-->Deposit--> clear");

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
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPClear.eppClear(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "************Test Scenario for EPP Clear is pass**************");
			}
		}
	}

	@Test(priority = 17, enabled=true, groups = "Anoop")

	public void AQC_EPP_Prepayment() throws Exception {

		FileName = "QC_EPP_Prepayment.xls";
		test = reports.startTest("QC_EPP_Prepayment", "EPP -->EPP payment--> Deposit---> prepayment");

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
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_Prepayment.Prepayment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for EPP Prepayment is pass******");
			}
		}
	}

	@Test(priority = 16, enabled=true, groups = "Anoop")

	public void AQC_EPPDeposit() throws Exception {

		FileName = "QC_EPPDeposit.xls";
		test = reports.startTest("QC_EPPDeposit", "Loan-EPP--> age the store upto 1st installment --> perform Deposit");

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
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.scheduler();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				test.log(LogStatus.INFO, "****Test Scenario for EPP deposit is pass******");
			}
		}
	}

	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void borrowregNewloan() throws Exception {
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

	@Test(priority = 2, enabled=true, groups = "Anoop")
	public void inactiveNewloan() throws Exception {
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
				ACSRNewLoanInactivecust.newLoanInact(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority = 6, enabled=true, groups = "Anoop")

	public void maxloanCount() throws Exception {
		FileName = "QC_MaxLoanCount_Testdata.xls";
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
				Thread.sleep(2000);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();

				for (int i = 1; i <= 11; i++) {

					ACSRLoginLogout.login(SSN, AppURL);
					AMaxLoanCount.maxLoan(SSN, AppURL);
					//ACSRLoginLogout.logout();
					if (!(i == 11)) {
						test.log(LogStatus.INFO, "******Customer loan Number " + i + "is approved successfully*****");
					} else {
						test.log(LogStatus.INFO, "******Customer loan Number " + i + "is denied*****");
						break;
					}
				}
			}
		}
	}

	@Test(priority = 4, enabled=true, groups = "Anoop")

	public void rescindloan() throws Exception {
		test = reports.startTest("QC_NewLoan_Rescind", "BorrowerRegistration-->New Loan->Rescind");
		FileName = "QC_BorrowerReg_NewLoan_Rescind_Txn_Testdata.xls";

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

				test.log(LogStatus.INFO, "****Test Scenario for  loan rescind  is pass******");

			}
		}
	}

	@Test(priority = 5, enabled=true, groups = "Anoop")

	public void agerescindtest() throws Exception {
		test = reports.startTest("QC_NewLoan_AgeStore_Rescind", "Login-->Age the loan to rescind days--->Rescind loan");
		FileName = "QC_BorrowerReg_NewLoan_AgeRescind_Txn_Testdata.xls";

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

				test.log(LogStatus.INFO, "****Test Scenario for age to store loan rescind  is pass******");

			}
		}
	}	
	@Test(priority = 3, enabled=true, groups = "Anoop")
	public void Achdeposit() throws Exception {
		test = reports.startTest("QC_NewLoan_Deposit", "Login-->Age the stote up to due date--->Perform deposit");
		FileName = "QC_BorrowerReg_NewLoan_AchDeposit_Txn_Testdata.xls";

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
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.achDeposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Ach Deposit  is pass******");
			}
		}
	}


	@Test(priority = 0, enabled=true, groups = "Anoop")
	public void middayDeposit() throws Exception {
		FileName = "QC_BorrowerReg_NewLoan_MidDayDeposit_Txn_Testdata.xls";
		test = reports.startTest("QC_NewLoan_MiddayDeposit",
				"Login-->Age the stote up to due date--->Perform Mid day deposit");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				/*AQCAdminLoginLogout.login(SSN, AppURL);
				AAdminStartDate.toStartdate(SSN, SSN);
				AAdminStartDate.toStartdateNV(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);
				AProc1.proc();*/


				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRMidDayDeposit.middeposit();
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for MidDay Deposit  is pass******");
			}
		}
	}


	@Test(priority = 7, enabled=true, groups = "Anoop")

	public void GracedaysMiddayDeposit() throws Exception {

		FileName = "QC_AgeStoretoduedate+Gracedays_MiddayDeposit.xls";
		test = reports.startTest("QC_NewLoan_AgeStore_MiddayDeposit",
				"Login-->Age the stote up to due date+Gracedays--->Perform Mid day deposit");

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
				ARunschedulerGracedays.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRMidDayDeposit.middeposit();
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for GraceDays MidDay Deposit  is pass******");
			}
		}
	}


	@Test(priority = 8, enabled=true, groups = "Anoop")

	public void GracedaysDepositMenu() throws Exception {

		FileName = "QC_AgeStoretoduedate+Gracedays_DepositMenu.xls";
		test = reports.startTest("QC_NewLoan_AgeStore_DepositMenu",
				"Login-->Age the stote up to due date+Gracedays--->Perform DepositMenu");

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
				ARunschedulerGracedays.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_CSRDepositMenu.depositMenu(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for GraceDays DepositMenu  is pass******");
			}
		}
	}


	@Test(priority = 9, enabled=true, groups = "Anoop_NV")

	public void RefinanceStepup() throws Exception {

		FileName = "QC_AgeStore_payment_AgetoDuedate_RefinanceStepUp.xls";
		test = reports.startTest("QC_Refinanace StepUp",
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
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ARefinanceStepup.StepUp(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Refinance Stepup  is pass******");
			}
		}
	}


	@Test(priority = 10, enabled=true, groups = "Anoop_NV")

	public void RefinanceStepSame() throws Exception {

		FileName = "QC_AgeStore_payment_AgetoDuedate_RefinanceStepSame.xls";
		test = reports.startTest("QC_Refinanace StepSame",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance StepSame");

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
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ARefinanceStepSame.StepSame(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Refinance StepSame  is pass******");
			}
		}
	}

	@Test(priority = 11, enabled=true, groups = "Anoop_NV")

	public void RefinanceStepupVoid() throws Exception {

		FileName = "QC_RefinanceStepup_void.xls";
		test = reports.startTest("QC_RefinanceStepup_void",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Stepup-->void");

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
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ARefinanceStepup.StepUp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Refinance Step up Void  is pass******");
			}
		}
	}

	@Test(priority = 12, enabled=true, groups = "Anoop_NV")

	public void RefinanceStepSameVoid() throws Exception {

		FileName = "QC_RefinanceStep_Same_void.xls";
		test = reports.startTest("QC_RefinanceStep_Same_void",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance StepSame void");

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
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ARefinanceStepSame.StepSame(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Refinance Step Same void is pass******");
			}
		}
	}


	@Test(priority = 1, enabled=true, groups = "Anoop")
	public void futureMidayDeposit() throws Exception {
		FileName = "QC_AgeStoretoduedate_FutureDeposit_MiddayDeposit.xls";
		test = reports.startTest("QC_Future MidDay Deposit",
				"Loan-->Age the store upto duedate--> perform future deposit—->age the store uptofuture deposit date--->perform Deposit(Mid Day)");

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
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRFutureDeposit.futureDeposit(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ARunschedulerGracedays.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRMidDayDeposit.middeposit();
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for future MidDay Deposit  is pass*****");
			}
		}
	}

	@Test(priority = 14, enabled=true, groups = "Anoop_NV")

	public void rebateStepup() throws Exception {

		FileName = "QC__RefinanceStepUp_rebate.xls";
		test = reports.startTest("QC_RefinanceStepUp_rebate",
				"Loan-Age the store--make a payment -- age the store-->do refinance(step up)(loan should be under rebate period)");

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
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AUnderRebateAge.agerescind();
				ACSRLoginLogout.login(SSN, AppURL);
				AUnderRebateStepup.StepUp(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO,
						"****Test Scenario for Refinance Stepup loan under rebate period  is pass******");
			}
		}
	}

	@Test(priority = 15, enabled=true, groups = "Anoop_NV")

	public void rebateStepupVoid() throws Exception {

		FileName = "QC__RefinanceStepUp_rebate_Void.xls";
		test = reports.startTest("QC_RefinanceStepUp_rebate_Void",
				"Loan-Age the store--make a payment -- age the store-->do refinance(step up)(loan should be under rebate period)-->Void");

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
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AUnderRebateAge.agerescind();
				ACSRLoginLogout.login(SSN, AppURL);
				AUnderRebateStepup.StepUp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO,
						"****Test Scenario for Refinance Stepup loan under rebate period and void is pass******");
			}
		}
	}


	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		BufferedReader reader;

		//Areader = new BufferedReader(new FileReader("C:/QC_Batch/QC_PDL/src/test/java/tests/AObjects.properties"));
		reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/test/java/tests/Objects.properties"));
		prop = new Properties();
		prop.load(reader);
		reader.close();
		String Afilename = prop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

		reports = new ExtentReports(System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + Afilename,true);

		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
		//System.out.println(System.getProperty("user.dir"));

	}





	@BeforeMethod(alwaysRun = true)
	public void killProcess() throws Exception {

		try {

			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			Thread.sleep(1000); // Allow OS to kill the process
			System.out.println("killed the process");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/FailedTestsScreenshots/"
				+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());

			String screenshotPath =getScreenhot(driver, result.getName());
			// To add it in the extent report
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));

		}
		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " Test Case is Passed");
		}


		reports.flush();
		driver.quit();

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