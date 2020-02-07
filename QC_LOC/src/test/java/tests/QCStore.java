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
	//public static Properties prop;
	public static Properties Aprop;
	
	public static String loan_number;
	public static ExtentReports reports;
	public static ExtentTest test;	
	public static String Eankey = null;
	public static String encryption_store_no = null;
	public static String encryption_transaction_nbr = null;
	public static String FileName;
	public static ExcelNew TestData;
	public static String loan_nbr;
	public static String NextDueDate;
	public static String AppURL;
	public static String BAdminURL;
	public static String AdminURL;
	public static String business_date;
	public static String No_of_Installments;
	public static String FirstName;
	public static String passwrd;
	public static String report_filename;
	public static String LastName;
	public static String ESign_CheckNbr;
	public static String ESign_CollateralType;
	public static String Due_Date1;
	public static String Due_Date2;
	public static String Due_Date3;
	public static String Str_date;
	public static String Ctc_PrimaryPhone;
	public static String Storeid;
	public static String SSN;
	public static String PP1;
	public static String PP2;
	public static String PP3;
	public static String age_Date1;
	public static String age_Date2;
	public static String age_Date3;
	public static String Statementdate;
	public static String Duedate_confirm_text3;
	public static String customer_number;
	public static String Drawer_OverShort_Amount; 
	public static String Date1;
	public static String csr_url;
	public static String csrloginpage;
	public static String Date2;
	public static String Date3;
	public static String Password;
	public static String LOCamount;
	private static final String QCAdmin_Deceased = null;
	private static final QCCSRHistory VQC_LOC_History = null;
	public static String Bank_Status;
	public static String App_date1;
	public static String logout;
	private static Object rescind;
	public static String bstoreid="505";
	public static String busername="csr505";	
	public static String vstoreid="508";
	public static String vusername="csr508";	
	public static String nstoreid="581";
	public static String nusername="csr581";
	
	//Anoop scenarios

	@Test(priority=4, enabled = true, groups = "Anoop_EOD3")

	public void PaymentDepositEODReDeposit() throws Exception {
		FileName = "QC_PaymentDepositEODReDeposit.xls";
		test = reports.startTest("QC_PaymentDepositEODReDeposit",
				"LOC-->Payment less than Min Payment Amt -->Deposit -->EOD-->Return-->Redeposit");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AAgetheStore.ageGracedays(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				ALOCPayments.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

			
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSR_Deposit.deposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQCCSRReturnPosting.returnposting(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQCAdminACHReturn.achreturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCRedeposit.redeposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority=3, enabled = true, groups = "Anoop_EOD3")

	public void DepositEODReDeposit() throws Exception {
		FileName = "QC_DepositEODReDeposit.xls";
		test = reports.startTest("QC_DepositEODReDeposit", "LOC – Deposit-->EOD-->Return-->Redeposit");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSR_Deposit.deposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQCCSRReturnPosting.returnposting(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQCAdminACHReturn.achreturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCRedeposit.redeposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority=2, enabled = true, groups = "Anoop_EOD3")

	public void SignatureNewLoan_EODTwice() throws Exception {
		FileName = "QC_LOC_SignatureLoan_EOD.xls";
		test = reports.startTest("QC_LOC_SignatureLoan_EOD",
				"New LOC for signature collateral –-> EOD on Payment Due Date- Age the store to 10 days-->EOD on 2nd Payment Due Date) ");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
				AQCCSRNewloanSignature.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AAgetheStore.ageGracedays(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				ALatefeegenerationCheck.transactioncheck(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				
			}
		}
	}
	@Test(priority=1, enabled = true, groups = "Anoop_EOD3")

	public void Clear_Return_EODTwice() throws Exception {
		FileName = "QC_LOC_clearReturnEODTwice.xls";
		test = reports.startTest("QC_LOC_clearReturnEODTwice",
				"New LOC – EOD on Payment Due Date(including collateral Deposit) - Age the store - clear -EOD on 2nd Payment Due Date(including collateral Deposit) - Age the store - Return - EOD on 3nd Payment Due Date(including collateral Deposit) ");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSR_Deposit.deposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AAgetheStore.ageGracedays(SSN, AppURL);

				
				AQCAdminLoginLogout.login(SSN, AppURL);
				AQCCSRReturnPosting.returnposting(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCClearDropdown.clearDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSR_Deposit.deposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AAgetheStore.ageGracedays(SSN, AppURL);

				
				AQCAdminLoginLogout.login(SSN, AppURL);
				AQCCSRReturnPosting.returnposting(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQCAdminACHReturn.achreturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				
			}
		}
	}
//---------------------------------------------------------------------------------------------------------------


	@Test(priority=4, enabled = true, groups = "Anoop_EOD2")

	public void Deposit_DrawEODTwice() throws Exception {
		FileName = "QC_LOC_Draw_EODTwice.xls";
		test = reports.startTest("QC_LOC_Draw_EODTwice",
				"New LOC-->EOD on Payment Due Date(including collateral Deposit)-->Age the store-->Draw -EOD on 2nd Payment Due Date(including collate ral Deposit)");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
				ADrawNewLoanMinamount.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSR_Deposit.deposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQCCSRReturnPosting.returnposting(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCClearDropdown.clearDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCDraw.draw(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSR_Deposit.deposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				
			}
		}
	}

	@Test(priority=3, enabled = true, groups = "Anoop_EOD2")

	public void DepositEODTwice() throws Exception {
		FileName = "QC_LOC_DepositEODTwice.xls";
		test = reports.startTest("QC_LOC_DepositEODTwice",
				"New LOC-->EOD on Payment Due Date(including collateral Deposit)-->EOD on 2nd Payment Due Date(including collateral Deposit)");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSR_Deposit.deposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSR_Deposit.deposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				
			}
		}
	}

	@Test(priority=2, enabled = true, groups = "Anoop_EOD2")

	public void PaymentdrawVoidEOD() throws Exception {
		FileName = "QC_LOC_paymentDraw_Void_EOD.xls";
		test = reports.startTest("QC_LOC_paymentDraw_Void_EOD",
				"New LOC--> Payment-->Draw(LOC Increment amt)--->Void-->EOD on Payment Due Date");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AAgetheStore.ageGracedays(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				// This is normal payment
				AQCPayment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCDraw.draw(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCDrawVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				
			}
		}
	}
	@Test(priority=1, enabled = true, groups = "Anoop_EOD2")

	public void PaymentAndDraw() throws Exception {
		FileName = "QC_LOC_payment_Draw.xls";
		test = reports.startTest("QC_LOC_payment_Draw",
				"New LOC--> Payment-->Draw(LOC Increment amt)-->EOD on Payment Due Date");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AAgetheStore.ageGracedays(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				// This is normal payment
				AQCPayment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCDraw.draw(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				
			}
		}
	}

//------------------------------------------------------------------------------------------------------------------
	@Test(priority=7, enabled = true, groups = "Anoop_EOD1")

	public void DrawAndEOD() throws Exception {
		FileName = "QC_LOC_Draw_EOD.xls";
		test = reports.startTest("QC_LOC_Draw_EOD", "New LOC-->Draw(LOC Increment amt)-->EOD on Payment Due Date");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
				ADrawNewLoanMinamount.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AAgetheStore.ageGracedays(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDraw.draw(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Draw and EOD  is pass******");
			}
		}
	}

	@Test(priority=6, enabled = true, groups = "Anoop_EOD1")

	public void DepositAndEOD() throws Exception {
		FileName = "QC_LOC_Deposit_EOD.xls";
		test = reports.startTest("QC_LOC_Deposit_EOD", "New LOC -->Deposit--> EOD on Payment Due Date");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSR_Deposit.deposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Deposit and EOD  is pass******");
			}
		}
	}

	@Test(priority=5, enabled = true, groups = "Anoop_EOD1")

	public void PayOFFandEod() throws Exception {
		FileName = "QC_LOC_PayOff_EOD.xls";
		test = reports.startTest("QC_LOC_PayOff_EOD", "New LOC -->Payoff--> EOD on Payment Due Date");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AAgetheStore.ageGracedays(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCPayOff.payoff(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for PayOff and EOD  is pass******");
			}
		}
	}

	@Test(priority=4, enabled = true, groups = "Anoop_EOD1")

	public void VoidandEod() throws Exception {
		FileName = "QC_LOC_Void_EOD.xls";
		test = reports.startTest("QC_LOC_Void_EOD", "New LOC-->Payment --> Void --> EOD on payment Due Date");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AAgetheStore.ageGracedays(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				// This is normal payment
				AQCPayment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				test.log(LogStatus.INFO, "****Test Scenario for Payment void and EOD is pass******");
			}
		}
	}

	@Test(priority=3, enabled = true, groups = "Anoop_EOD1")

	public void HigherPaymentAndEod() throws Exception {
		FileName = "QC_LOC_MorePayment_EOD.xls";
		test = reports.startTest("QC_LOC_MorePayment_EOD",
				"New LOC-->Payment More than Min Payment Amt after Rescind Period -->EOD on Payment Due Date");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AAgetheStore.ageGracedays(SSN, AppURL);

				
				ACSRLoginLogout.login(SSN, AppURL);
				// This is conditional payment
				ALOCPayments.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				
				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Higher Payment and EOD  is pass******");
			}
		}
	}

	@Test(priority=2, enabled = true, groups = "Anoop_EOD1")

	public void PaymentAndEod() throws Exception {
		FileName = "QC_LOC_Payment_EOD.xls";
		test = reports.startTest("QC_LOC_Payment_EOD",
				"New LOC-->Payment less than Min Payment Amt after Rescind Period -->EOD on Payment Due Date");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AAgetheStore.ageGracedays(SSN, AppURL);

			
				ACSRLoginLogout.login(SSN, AppURL);
				ALOCPayments.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

			
				// EOD Process
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Payment and EOD  is pass******");
			}
		}
	}

	@Test(priority=1, enabled = true, groups = "Anoop_EOD1")

	public void EODOnDueDate() throws Exception {
		FileName = "QC_LOC_EODDuedate.xls";
		test = reports.startTest("QC_LOC_EODDuedate", "New LOC – EOD on Payment Due Date");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				
				/*QCCSRLoginLogout.adminLogin(SSN, SSN);
				AAdminStartDateLOC1.toStartdateForEOD1(SSN, AppURL);
				AAdminStartDateLOC1.toStartdateForEOD2(SSN, AppURL);
				AAdminStartDateLOC1.toStartdateForEOD3(SSN, AppURL);
				QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
				AProc1.proc();*/

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				// EOD Process
				
				ACSRLoginLogout.login(SSN, AppURL);
				AQCEODDeposit.eodDeposit(SSN, AppURL);
				AQCAdminStoreSetup.storeSetup(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCSafeAssign.safeAssign(SSN, AppURL);
				AQCDrawerAssign.drawerAssign(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				test.log(LogStatus.INFO, "****Test Scenario for EOD on Due date is pass******");
			}
		}
	}


	
	//****************************************Anoop-Scenarios-NonEOD****************************************//
	
	@Test(priority = 487, enabled = true, groups = "NonEOD")

	public void MinLocAmounts() throws Exception {
		FileName = "QC_LOC_NewLoan_monthly_MinAmount.xls";
		test = reports.startTest("QC_LOC_MinAmount_Counts",
				"New LOC for  Minimum amount LOC amts to validate Minimum Payment Amt");

		TestData = new ExcelNew(System.getProperty("user.dir") + "/TestData/QCStore/ALOC/" + FileName);
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
				ALoanDecisionPage.newLoan(SSN, AppURL);

				test.log(LogStatus.INFO,
						"****Test Scenario for Monthly pay frequence to validate Minimum payment amount  is pass******");
			}
		}
	}

	@Test(priority = 488, enabled = true, groups = "NonEOD")

	public void MaxLocAmounts() throws Exception {
		FileName = "QC_LOC_NewLoan_monthly_Maxamount.xls";
		test = reports.startTest("QC_LOC_Maxamount_Counts",
				"New LOC for  Max amount LOC amts to validate Minimum Payment Amt");

		TestData = new ExcelNew(System.getProperty("user.dir") + "/TestData/QCStore/ALOC/" + FileName);
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
				ALoanDecisionPage.newLoan(SSN, AppURL);

				test.log(LogStatus.INFO,
						"****Test Scenario for Monthly pay frequence to validate Minimum payment amount  is pass******");
			}
		}
	}

	@Test(priority = 489, enabled = true, groups = "NonEOD")

	public void LOC_maxloanCount() throws Exception {
		FileName = "QC_LOC_MaxLoan.xls";
		test = reports.startTest("QC_LOC_MaxLoan_Count ", "Login-->Borrower-->Max loan count");

		TestData = new ExcelNew(System.getProperty("user.dir") + "/TestData/QCStore/ALOC/" + FileName);
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

				for (int i = 1; i <= 3; i++) {

					ACSRLoginLogout.login(SSN, AppURL);
					LOCMaxloanCount.newLoan(SSN, AppURL);
					if (!(i == 3)) {
						test.log(LogStatus.INFO, "******Customer loan Number " + i + "is approved successfully*****");
					} else {
						test.log(LogStatus.INFO, "******Customer loan Number " + i + "is denied*****");
					}
				}
				test.log(LogStatus.INFO, "****Test Scenario for max loan amount is pass******");

			}
		}
	}

@Test(priority = 490, enabled = true, groups = "NonEOD")

	public void NewLoanWeekly_Duedatevalidation() throws Exception {
		FileName = "QC_LOC_EndDate_Weekly_Duedate.xls";
		test = reports.startTest("QC_LOC_EndDate_Weekly",
				"New LOC for a customer with pay frequency Weekly and next pay date on End of the month  to validate Payment Due Date and Statement Date");

		TestData = new ExcelNew(System.getProperty("user.dir") + "/TestData/QCStore/ALOC/" + FileName);
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
				LOCMaxloanCount.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				test.log(LogStatus.INFO,
						"****Test Scenario for Weekly pay frequence new loan and Due date validation is pass******");
			}
		}
	}

	@Test(priority = 491, enabled = true, groups = "NonEOD")

	public void NewLoanSemiMonthly_Duedatevalidation() throws Exception {
		FileName = "QC_LOC_EndDate_Semimonthly_Duedate.xls";
		test = reports.startTest("QC_LOC_EndDate_Semimonthly",
				"New LOC for a customer with pay frequency Semi – monthly and next pay date on End of the month  to validate Payment Due Date and Statement Date");

		TestData = new ExcelNew(System.getProperty("user.dir") + "/TestData/QCStore/ALOC/" + FileName);
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
				LOCMaxloanCount.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				test.log(LogStatus.INFO,
						"****Test Scenario for Semi Monthly pay frequence new loan and Due date validation is pass******");
			}
		}
	}

@Test(priority = 492, enabled = true, groups = "NonEOD")

	public void NewLoanMonthly_Duedatevalidation() throws Exception {
		FileName = "QC_LOC_EndDate_monthly_Duedate.xls";
		test = reports.startTest("QC_LOC_EndDate_monthly",
				"New LOC for a customer with pay frequency monthly and next pay date on End of the month  to validate Payment Due Date and Statement Date");

		TestData = new ExcelNew(System.getProperty("user.dir") + "/TestData/QCStore/ALOC/" + FileName);
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
				LOCMaxloanCount.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				test.log(LogStatus.INFO,
						"****Test Scenario for Monthly pay frequence new loan and Due date validation is pass******");
			}
		}
	}

@Test(priority = 493, enabled = true, groups = "NonEOD")

	public void NewLoanBiweeklyPaymentDuedate() throws Exception {
		FileName = "QC_LOC_EndDate_Biweekly_Duedate.xls";
		test = reports.startTest("QC_LOC_EndDate_Biweekly",
				"New LOC for a customer with pay frequency Biweekly and next pay date on End of the month  to validate Payment Due Date and Statement Date");

		TestData = new ExcelNew(System.getProperty("user.dir") + "/TestData/QCStore/ALOC/" + FileName);
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
				LOCMaxloanCount.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				test.log(LogStatus.INFO,
						"****Test Scenario for BiWeekly pay frequence new loan and Due date validation is pass******");
			}
		}
	}

@Test(priority = 494, enabled = true, groups = "NonEOD")

	public void NewLoanWeekly() throws Exception {
		FileName = "QC_LOC_NewLoan_Weekly.xls";
		test = reports.startTest("QC_LOC_NewLoan_Weekly",
				"New LOC for a customer with pay frequency Weekly to validate LOC Eligible Amt");

		TestData = new ExcelNew(System.getProperty("user.dir") + "/TestData/QCStore/ALOC/" + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				test.log(LogStatus.INFO, "****Test Scenario for Weekley pay frequence new loan is pass******");
			}
		}
	}

@Test(priority = 495, enabled = true, groups = "NonEOD")

	public void NewLoanSemiMonthly() throws Exception {
		FileName = "QC_LOC_NewLoan_Semimonthly.xls";
		test = reports.startTest("QC_LOC_NewLoan_Semimonthly",
				"New LOC for a customer with pay frequency Semi monthly to validate LOC Eligible Amt");

		TestData = new ExcelNew(System.getProperty("user.dir") + "/TestData/QCStore/ALOC/" + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				test.log(LogStatus.INFO, "****Test Scenario for Semi Monthly pay frequence new loan is pass******");
			}
		}
	}

@Test(priority = 496, enabled = true, groups = "NonEOD")

	public void NewLoanMonthly() throws Exception {
		FileName = "QC_LOC_NewLoan_monthly.xls";
		test = reports.startTest("QC_LOC_NewLoan_monthly",
				"New LOC for a customer with pay frequency monthly to validate LOC Eligible Amt");

		TestData = new ExcelNew(System.getProperty("user.dir") + "/TestData/QCStore/ALOC/" + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				test.log(LogStatus.INFO, "****Test Scenario for Monthly pay frequence new loan is pass******");
			}
		}
	}

	@Test(priority = 497, enabled = true, groups = "NonEOD")

	public void NewLoanBiweekly() throws Exception {
		FileName = "QC_LOC_NewLoan_Biweekly.xls";
		test = reports.startTest("QC_LOC_NewLoan_Biweekly",
				"New LOC for a customer with pay frequency Biweekly to validate LOC Eligible Amt");

		TestData = new ExcelNew(System.getProperty("user.dir") + "/TestData/QCStore/ALOC/" + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for BiWeekly pay frequence new loan is pass******");
			}
		}
	}



	@Test(priority = 498, enabled = true, groups = "NonEOD")
	public void AReviseCredit_IncIncome() throws Exception {

		FileName = "QC_ ReviseCredit_IncreaseIncome.xls";
		test = reports.startTest("QC_ AReviseCredit_IncreaseIncome", " New LOC-->Increase Income-Revise credit ");

		TestData = new ExcelNew(System.getProperty("user.dir") + "/TestData/QCStore/ALOC_BiWeekly/" + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AReviseCredit.revisecredit(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ABorrowerEdit.borrowerIncreaseNet(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				SQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				// This is normal payment
				AQCPayment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AAgetheStore.ageGracedays(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				// This is normal payment
				AQCPayment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AReviseCredit.revisecreditafterIncrease(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();

			}
		}
	}

	@Test(priority = 499, enabled = true, groups = "NonEOD")
	public void AReviseCredit_PayofffIncreaseIncome() throws Exception {
		FileName = "QC_Payoff_AReviseCreditincreaseincome.xls";
		test = reports.startTest("QC_Payoff_AReviseCreditincreaseincome",
				" New LOC-->Payoff-->Auto closure-->Increase Income-->LOC-->Revise credit ");

		TestData = new ExcelNew(System.getProperty("user.dir") + "/TestData/QCStore/ALOC/" + FileName);
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
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AAgetheStore.ageGracedays(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCPayOff.payoff(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AAgetheStore.age180day(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AAutoclosure.autoclose(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AReviseCredit.revisecredit(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ABorrowerEdit.borrowerIncreaseNet(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				// This is normal payment
				AQCPayment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AAgetheStore.age1day(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				// This is normal payment
				AQCPayment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AReviseCredit.revisecreditafterIncrease(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_LOC_History.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}
	}

//---------------------------------------------------------------------------------------------------------
	//Ratikanta Scenarios

		@Test(priority=1, groups = "Ratikanta_LOC")
		public static void RQC_LOC_ManualDefault_Txn_Testdata() throws Exception {
		
				test = reports.startTest("New LOC - Manual Default","Login->Borrower Registration->New Loan->Age the Store Duedate->Manual Default");
				String FileName = "QC_LOC_ManualDefault_Txn_Testdata.xls";
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
			
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
					if (RunFlag.equals("Y")) {
						
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRHistory.history(SSN, AppURL);
						RCSRLoginLogout.logout();

					}
				}
			
		}

		@Test(priority=2, groups = "Ratikanta_LOC")
		public static void RQC_LOC_Deposit_Return_ManualDefault_Txn_Testdata() throws Exception {
			
				test = reports.startTest(("New LOC - Deposit - Return- Manual Default"),
						"Login->Borrower Registration->New Loan-->Duedate-->Deposit-->Return-->Manual Default");
				String FileName = "QC_LOC_Deposit_Return_ManualDefault_Txn_Testdata.xls";
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						RCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_Deposit.deposit(SSN, AppURL);
						
						RQCCSRReturnPosting.returnposting(SSN, AppURL);
						
						RQCAdminACHReturn.achreturn(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
						
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRHistory.history(SSN, AppURL);
						RCSRLoginLogout.logout();

					}
				}
			
		}

		@Test(priority=3, groups = "Ratikanta_LOC")
		public static void RQC_LOC_Deposit_Return_2ndDeposit_Clear_3rdDeposit_Return_Default_Txn_Testdata()
				throws Exception {
		
				test = reports.startTest(("New LOC-Deposit-Return-Deposit-Clear-Deposit-Return-Default(EOD/Auto EOD)"),
						"Login->Borrower Registration->New Loan-->Duedate-->Deposit-->Return-->2nd Deposit-->Clear-->3rd Deposit-->Return-->EOD");
				String FileName = "QC_LOC_Deposit_Return_2ndDeposit_Clear_3rdDeposit_Return_Default_Txn_Testdata.xls";
			
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
			
			
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_Deposit.deposit(SSN, AppURL);
						
						RQCCSRReturnPosting.returnposting(SSN, AppURL);
						RQCAdminACHReturn.achreturn(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_Deposit.deposit(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						     // RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
						RQCCSRReturnPosting.returnposting(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRACHClear.achclear(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_Deposit.deposit(SSN, AppURL);
						RQCCSRReturnPosting.returnposting(SSN, AppURL);
						RQCAdminACHReturn.achreturn(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						    // RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays3rdTime(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
						
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSREOD_Default.eoddefault(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRHistory.history(SSN, AppURL);
						RCSRLoginLogout.logout();

					}
				}
					}

		@Test(priority =4, groups = "Ratikanta_LOC")
		public static void RQC_LOC_2missedPayment_Default_EOD_Txn_Testdata() throws Exception {
		
				test = reports.startTest(
						("New LOC Signature Loan-2missed Payment-Default_EOD/AutoEOD"),
						"Login->Borrower Registration->Signature Loan-->2missed Payment-->Default_EOD/AutoEOD");
				String FileName = "QC_LOC_2missedPayment_Default_EOD_Txn_Testdata.xls";
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
			
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						RCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRSignatureLoan.signatureloan(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSREOD_Default.eoddefault(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRHistory.history(SSN, AppURL);
						RCSRLoginLogout.logout();

					}
				}
					}

	    @Test(priority=5, groups = "Ratikanta_LOC")
		public static void RQC_LOC_Default_DefaultPayment_Txn_Testdata() throws Exception {
			
				test = reports.startTest(("Default - Default Payment"),
						"Login->Borrower Registration->New Loan-->Age Store to Duedate-->Deposit-->Age store to 2 Gracedays-->reurn-->Age to 2nd due date-->Default-->Default Payment");
				String FileName = "QC_LOC_Default_DefaultPayment_Txn_Testdata.xls";
			
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
					if (RunFlag.equals("Y")) {
					
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						// Old Flow

						/*
						 * RCSRLoginLogout.login(SSN, AppURL);
						 * RQCBorrowerRegistration.borrowerRegistration(SSN,
						 * AppURL); RCSRLoginLogout.logout();
						 * RCSRLoginLogout.login(SSN, AppURL);
						 * RQCCSRNewLoan.newLoan(SSN, AppURL);
						 * RCSRLoginLogout.logout(); RCSRLoginLogout.login(SSN,
						 * AppURL); RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						 * RCSRLoginLogout.login(SSN, AppURL);
						 * RQCCSR_Deposit.deposit(SSN, AppURL);
						 * RQCCSRReturnPosting.returnposting(SSN, AppURL);
						 * RQCAdminACHReturn.achreturn(SSN, AppURL);
						 * RCSRLoginLogout.login(SSN, AppURL);
						 * RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						 * RCSRLoginLogout.login(SSN, AppURL);
						 * RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						 */
						

						// New Flow

						RCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
	//============ Scenario Changed On Dt.11.oct.2019 , now we are doing Default by Manual Default Only  ==================================			
						
						/*RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_Deposit.deposit(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						RQCCSRReturnPosting.returnposting(SSN, AppURL);
						RQCAdminACHReturn.achreturn(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);*/
	//==================================================================================					
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRHistory.history(SSN, AppURL);
						RCSRLoginLogout.logout();

					}
				}
					}

		@Test(priority=6, groups = "Ratikanta_LOC")
		public static void RQC_LOC_Default_DefaultPayment_Void_Txn_Testdata() throws Exception {
	
				test = reports.startTest(("Default - Default Payment - Void"),
						"Login->Borrower Registration->New Loan-->Age Store to Duedate-->Deposit-->Age store to 2 Grace days-->reurn-->Age to 2nd due date-->Default-->Default Payment-->Void");
				String FileName = "QC_LOC_Default_DefaultPayment_Void_Txn_Testdata.xls";
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
			
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
			//======================================================================		
						/*RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_Deposit.deposit(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						RQCCSRReturnPosting.returnposting(SSN, AppURL);
						RQCAdminACHReturn.achreturn(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);*/
		//============================================================================			
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRDefault_Void.defaultvoid(SSN, AppURL);
											    
						RCSRLoginLogout.login(SSN, AppURL);
						   //RQCCSRHistory.history(SSN, AppURL);
						RQCCSRDefault_PartialDefault_History.defaultpartialdefaulthistory(SSN, AppURL);					
						RCSRLoginLogout.logout();

					}
				}
					}

		@Test(priority=7, groups = "Ratikanta_LOC")
		public static void RQC_LOC_Default_PartialDefaultPayment_Void_Txn_Testdata() throws Exception {
	
				test = reports.startTest(("Default - Partial Default Payment - Void"),
						"Login->Borrower Registration->New Loan-->Age Store to Duedate-->Deposit-->Age store to 2 Grace days-->reurn-->Age to 2nd due date-->Default-->PartialDefault Payment-->Void");
				String FileName = "QC_LOC_Default_PartialDefaultPayment_Void_Txn_Testdata.xls";
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
					if (RunFlag.equals("Y")) {
					
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
		//===============================================================================				
						/*RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_Deposit.deposit(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						RQCCSRReturnPosting.returnposting(SSN, AppURL);
						RQCAdminACHReturn.achreturn(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);*/
		//===================================================================================				
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRPartialDefaultPayment.partialdefaultpayment(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRDefault_Void.defaultvoid(SSN, AppURL);
											     
						RCSRLoginLogout.login(SSN, AppURL);
						    //RQCCSRHistory.history(SSN, AppURL);
						RQCCSRDefault_PartialDefault_History.defaultpartialdefaulthistory(SSN, AppURL);
						       
						RCSRLoginLogout.logout();

					}
				}
					}

		@Test(priority =8, groups = "Ratikanta_LOC")
		public static void RQC_LOC_Default_DefaultPayment_Return_Txn_Testdata() throws Exception {
		
				test = reports.startTest(("Default - Default Payment(ACH/CCK/MO) - Return"),
						"Login->Borrower Registration->New Loan-->Age Store to Duedate-->Deposit-->Age store to 2 Grace days-->reurn-->Age to 2nd due date-->Default-->Default Payment-->Return");
				String FileName = "QC_LOC_Default_DefaultPayment_Return_Txn_Testdata.xls";
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
			
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);


						RCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
		//===========================================================================
						
						/*RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_Deposit.deposit(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						RQCCSRReturnPosting.returnposting(SSN, AppURL);
						RQCAdminACHReturn.achreturn(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);*/
	  //=================================================================================
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRDefaultPayment_CCK_Return.defaultpaymentreturn(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRInternalTransfer.internaltransfer(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RQCAdminCCKReturn.cckreturn(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRHistory.history(SSN, AppURL);
						RCSRLoginLogout.logout();

					}
				}
					}

		@Test(priority =9, groups = "Ratikanta_LOC")
		public static void RQC_LOC_Default_PartialDefaultPayment_FullDefaultPayment_Txn_Testdata() throws Exception {
		
				test = reports.startTest(("Default - Partial Default Payment - Full Default payment"),
						"Login->Borrower Registration->New Loan-->Age Store to Duedate-->Deposit-->reurn-->Age to 2nd due date-->Default-->PartialDefault Payment-->Full DefaultPayment");
				String FileName = "QC_LOC_Default_PartialDefaultPayment_FullDefaultPayment_Txn_Testdata.xls";
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						RCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
		//==============================================================================				
						/*RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_Deposit.deposit(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						RQCCSRReturnPosting.returnposting(SSN, AppURL);
						RQCAdminACHReturn.achreturn(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);*/
	//===================================================================================				
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRPartialDefaultPayment.partialdefaultpayment(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRHistory.history(SSN, AppURL);
						RCSRLoginLogout.logout();

					}
				}
			
		}

		@Test(priority=10, groups = "Ratikanta_LOC")
		public static void RQC_LOC_Default_PartialDefaultPayment_FullDefaultPayment_Void_Txn_Testdata() throws Exception {
		
				test = reports.startTest(("Default - Partial Default Payment - Full Default payment - Void"),
						"Login->Borrower Registration->New Loan-->Age Store to Duedate-->Deposit-->reurn-->Age to 2nd due date-->Default-->PartialDefault Payment-->Full DefaultPayment-->Void");
				String FileName = "QC_LOC_Default_PartialDefaultPayment_FullDefaultPayment_Void_Txn_Testdata.xls";
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
			
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
					
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
				
						RCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
	//====================================================================================					
						/*RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_Deposit.deposit(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						RQCCSRReturnPosting.returnposting(SSN, AppURL);
						RQCAdminACHReturn.achreturn(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);*/
	//=====================================================================================					
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRPartialDefaultPayment.partialdefaultpayment(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRDefault_Void.defaultvoid(SSN, AppURL);
											    
						RCSRLoginLogout.login(SSN, AppURL);
						      //RQCCSRHistory.history(SSN, AppURL);
						RQCCSRDefault_PartialDefault_History.defaultpartialdefaulthistory(SSN, AppURL);
						RCSRLoginLogout.logout();

					}
				}
					}

		@Test(priority=11, groups = "Ratikanta_LOC")
		public static void RQC_LOC_PayOff_Closure_Txn_Testdata() throws Exception {
		
				test = reports.startTest(("New LOC_Payoff_LOC Closure"),
						"Login->Borrower Registration->New Loan-->Age Store to Gracedays-->PayOff-->Closure");
				String FileName = "QC_LOC_PayOff_Closure_Txn_Testdata.xls";
			
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
			
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
					if (RunFlag.equals("Y")) {
				
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCPayOff.payoff(SSN, AppURL);
						    // RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_LOCClosure.locclosure(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRHistory.history(SSN, AppURL);
						RCSRLoginLogout.logout();

					}
				}
					}

		@Test(priority=12, groups = "Ratikanta_LOC")
		public static void RQC_LOC_Payment_PayOff_Closure_Void_Txn_Testdata() throws Exception {
	
				test = reports.startTest(("New LOC_Payment_Payoff_LOC Closure_Void"),
						"Login->Borrower Registration->New Loan-->Age Store to Gracedays-->Payment-->PayOff-->Closure-->Void");
				String FileName = "QC_LOC_Payment_PayOff_Closure_Void_Txn_Testdata.xls";
		
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
			
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
					if (RunFlag.equals("Y")) {
					
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						RCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCPayment.payment(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCPayOff.payoff(SSN, AppURL);
						
						         // RCSRLoginLogout.logout();
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_LOCClosure.locclosure(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_LOC_VoidClosure.locvoidclosure(SSN, AppURL);
											        
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRHistory.history(SSN, AppURL);
						RCSRLoginLogout.logout();

					}
				}
					}

		@Test(priority =13, groups = "Ratikanta_LOC")
		public static void RQC_LOC_PayOff_Closure_PayoffReturn_Txn_Testdata() throws Exception {

				test = reports.startTest(("New LOC_Payoff_LOC Closure_Payoff return"),
						"Login->Borrower Registration->New Loan-->Age Store to Gracedays-->PayOff-->Closure-->PayoffReturn(Internal Transfer-->Cmg Deposit-->Return)");
				String FileName = "QC_LOC_PayOff_Closure_PayoffReturn_Txn_Testdata.xls";
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
			
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
					if (RunFlag.equals("Y")) {
					
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						RCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_CashierCheck_Payoff.cashiercheckpayoff(SSN, AppURL);
						
						       // RCSRLoginLogout.logout();
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_LOCClosure.locclosure(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRInternalTransfer.internaltransfer(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RQCAdminCCKReturn.cckreturn(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRHistory.history(SSN, AppURL);
						RCSRLoginLogout.logout();

					}
				}
					}

		@Test(priority =14, groups = "Ratikanta_LOC")
		public static void RQC_LOC_PayOff_Agestore180days_AutoClosure_Txn_Testdata() throws Exception {
			
				test = reports.startTest(("New LOC_Payoff_Age the store to 180 days_Auto Closure"),
						"Login->Borrower Registration->New Loan-->Age Store to Gracedays-->PayOff-->Age Store to 180 days-->AutoClosure");
				String FileName = "QC_LOC_PayOff_Agestore180days_AutoClosure_Txn_Testdata.xls";
			
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
			
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
					
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						RCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCPayOff.payoff(SSN, AppURL);
						      
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
						      // RQCAgeStoreGraceDays.age180day(SSN, AppURL);
				
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRAutoClosure.autoclosure(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRHistory.history(SSN, AppURL);
						RCSRLoginLogout.logout();

					}
				}
					}
		
		

		@Test(priority = 215, groups = "Ratikanta_EOD")
		public static void RQC_LOC_ManualDefault_EOD_Txn_Testdata() throws Exception {
			try {
				test = reports.startTest(("New LOC_Manual Default_EOD on Payment Due Date"),
						"Login->Borrower Registration->New Loan-->Manual Default-->AgeStore to Duedate-->EOD");
				String FileName = "QC_LOC_ManualDefault_EOD_Txn_Testdata.xls";
				// String FileName=
				// Aprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
				// ExcelNew TestData;
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				// int lastrow=TestData.getLastRow("Borrower");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						// driver.get(appUrl);
						// test.log(LogStatus.INFO, "Application is launched");
						// driver.manage().window().maximize();
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						
						
						//QCCSRLoginLogout.adminLogin(SSN, AppURL);
						//RAdminStoreDate.toStartdate(SSN, AppURL);
						//QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);
						//RProcTest.proc();
						//Thread.sleep(8000);

						RCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCEODDeposit.eodDeposit(SSN, AppURL);
						
						RQCAdminStoreSetup.storeSetup(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCSafeAssign.safeAssign(SSN, AppURL);
						RQCDrawerAssign.drawerAssign(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRHistory.history(SSN, AppURL);
						RCSRLoginLogout.logout();

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				test.log(LogStatus.ERROR, "Unable to start scenarios ");

			}
		}

		@Test(priority = 216, groups = "Ratikanta_EOD")
		public static void RQC_LOC_Deposit_Return_2ndDeposit_Return_Default_Txn_Testdata() throws Exception {
			try {
				test = reports.startTest(("New LOC_Deposit_Return_2nd Deposit_Return_Default(EOD/Auto EOD)"),
						"Login->Borrower Registration->New Loan-->Duedate-->Deposit-->Return-->2nd Deposit-->Return-->EOD-->Verify Status as Default");
				String FileName = "QC_LOC_Deposit_Return_2ndDeposit_Return_Default_Txn_Testdata.xls";
				// String FileName=
				// Aprop.getProperty("QC_DefaultPayment_Txn_Testdata_Scenario")+".xls";
				// ExcelNew TestData;
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				// int lastrow=TestData.getLastRow("Borrower");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						// driver.get(appUrl);
						// test.log(LogStatus.INFO, "Application is launched");
						// driver.manage().window().maximize();
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						RCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RCSRLoginLogout.logout();
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_Deposit.deposit(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						RQCCSRReturnPosting.returnposting(SSN, AppURL);
						RQCAdminACHReturn.achreturn(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSR_Deposit.deposit(SSN, AppURL);
						RQCCSRReturnPosting.returnposting(SSN, AppURL);
						RQCAdminACHReturn.achreturn(SSN, AppURL);
						       
						        /* RCSRLoginLogout.login(SSN, AppURL);
						        * RQCEODDeposit.eodDeposit(SSN, AppURL);
						        * RQCAdminStoreSetup.storeSetup(SSN, AppURL);
						        * RCSRLoginLogout.login(SSN, AppURL);
						        * RQCSafeAssign.safeAssign(SSN, AppURL);
						        * RQCDrawerAssign.drawerAssign(SSN, AppURL);
						        * RCSRLoginLogout.logout();*/
						        
						RCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSREOD_Default.eoddefault(SSN, AppURL);
						
						RCSRLoginLogout.login(SSN, AppURL);
						RQCCSRHistory.history(SSN, AppURL);
						RCSRLoginLogout.logout();

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				test.log(LogStatus.ERROR, "Unable to start scenarios ");

			}
		}

		// ============================================================================================================
		
		//Janaki's (Ratikanta) scenarios

		@Test(priority=1, enabled = true, groups = "Ratikanta_LOC2")

		public static void JQC_LOC_New_Loan_Void_Txn() throws Exception {
		

				test = reports.startTest("QC_New_Loan_Void_Txn","Login->Borrower Registratino->New Loan ->Void");
				

				FileName ="QC_LOC_New_Loan_Void_Txn.xls";
			

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCVoid.qcVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

		@Test(priority =2, enabled = true, groups = "Ratikanta_LOC2")

		public static void JQC_LOC_New_Loan_Rescind_Txn() throws Exception {
			
				test = reports.startTest("QC_New_Loan_Rescind_Txn",
						"Login->Borrower Registratino->New Loan ->Rescind");

				FileName = "QC_LOC_New_Loan_Rescind_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
			
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRescind.Rescind(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

		
		@Test(priority =3, enabled = true, groups = "Ratikanta_LOC2")

		public static void JQC_LOC_New_Loan_Void_GraceDay_Txn() throws Exception {
		
				test = reports.startTest("QC_New_Loan_Void_GraceDay_Txn",
						"Login->Borrower Registratino->New Loan ->GraceDays_Void");

				FileName ="QC_LOC_New_Loan_Void_GraceDay_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCEncryptionDetails.readEncryptionDetails(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						
						JQCAdminEncryption.getEncryption(driver, SSN, AppURL);
						
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreVoid.ageStoreVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

		@Test(priority =4, enabled = true, groups = "Ratikanta_LOC2")

		public static void JQC_LOC_New_Loan_GraceDay_Rescind_Txn() throws Exception {
	
				test = reports.startTest("QC_New_Loan_GraceDay_Rescind_Txn",
						"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName = "QC_LOC_New_Loan_GraceDay_Rescind_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRescind.Rescind(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

		@Test(priority =5, enabled = true, groups = "Ratikanta_LOC2")

		public static void JQC_LOC_New_Loan_After_RescindDays_Txn() throws Exception {
		
				test = reports.startTest("QC_New_Loan_After_RescindDays_Txn",
						"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName = "QC_LOC_New_Loan_After_RescindDays_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRescind.Rescind(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

		@Test(priority =6, enabled = true, groups = "Ratikanta_LOC2")

		public static void JQC_LOC_Payment_After_Rescind_Txn() throws Exception {
	
				test = reports.startTest("QC_Payment_After_Rescind_Txn",
						"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName = "QC_LOC_Payment_After_Rescind_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
			
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCPayment.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

		@Test(priority =7, enabled = true, groups = "Ratikanta_LOC2")

		public static void JQC_LOC_Payment_OnDueDate_Txn() throws Exception {
	
				test = reports.startTest("QC_Payment_OnDueDate_Txn",
						"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName ="QC_LOC_Payment_OnDueDate_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
			
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCPayment.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
			
		}

	    @Test(priority =8, enabled = true, groups = "Ratikanta_LOC2")


		public static void JQC_LOC_LessThan_MinPayment_Txn() throws Exception {
		
				test = reports.startTest("QC_LessThan_MinPayment_Txn",
						"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName = "QC_LOC_LessThan_MinPayment_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
			
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JLOCPayments.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

		@Test(priority =9, enabled = true, groups = "Ratikanta_LOC2")

		public static void JQC_LOC_GreaterThan_MinPayment_Txn() throws Exception {
		
				test = reports.startTest("QC_GreaterThan_MinPayment_Txn",
						"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName ="QC_LOC_GreaterThan_MinPayment_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JLOCPayments.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}
		

		@Test(priority =10, enabled = true, groups = "Ratikanta_LOC2")
		public static void JQC_LOC_DueDate_GreaterThan_MinPayment_Txn() throws Exception {
		
				test = reports.startTest("QC_DueDate_GreaterThan_MinPayment_Txn",
						"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName = "QC_LOC_DueDate_GreaterThan_MinPayment_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						
						JQCCSRLoginLogout.login(SSN, AppURL);
					    ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JLOCPayments.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						 
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

		@Test(priority =11, enabled = true, groups = "Ratikanta_LOC2")
		public static void JQC_LOC_DueDate_LessThan_MinPayment_Txn() throws Exception {
		
				test = reports.startTest("QC_DueDate_LessThan_MinPayment_Txn",
						"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName =  "QC_LOC_DueDate_LessThan_MinPayment_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JLOCPayments.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

		@Test(priority=12, enabled = true, groups = "Ratikanta_LOC2")
		public static void JQC_LOC_Payment_void_Txn() throws Exception {
		
				test = reports.startTest("QC_Payment_void_Txn",
						"Login->Borrower Registratino->New Loan ->GraceDays_Rescind");

				FileName = "QC_LOC_Payment_void_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCPayment.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCVoid.qcVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

		@Test(priority =13, enabled = true, groups = "Ratikanta_LOC2")
		public static void JQC_LOC_Payment_void_NextBusinessDay_Txn() throws Exception {
			
				test = reports.startTest("QC_Payment_void_NextBusinessDay_Txn",
						"Login->Borrower Registratino->New Loan ->Payment -> void on NextBusinessDay");

				FileName = "QC_LOC_Payment_void_NextBusinessDay_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCPayment.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCEncryptionDetails.readEncryptionDetails(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						      // JQCAdminLoginLogout.login(SSN, AppURL);
						JQCAdminEncryption.getEncryption(driver, SSN, AppURL);
						      // JQCAdminLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreVoid.ageStoreVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

	    @Test(priority =14, enabled = true, groups = "Ratikanta_LOC2")
		public static void JQC_LOC_LessThan_MinPayment_Viod_Txn() throws Exception {
			
				test = reports.startTest("QC_LessThan_MinPayment_Void_Txn",
						"Login->Borrower Registratino->New Loan ->MinPayment --> Void");

				FileName =  "QC_LOC_LessThan_MinPayment_Void_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JLOCPayments.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCVoid.qcVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

		
		@Test(priority =15, enabled = true, groups = "Ratikanta_LOC2")
		public static void JQC_LOC_GreaterThan_MinPayment_Void_Txn() throws Exception {

		
				test = reports.startTest("QC_GreaterThan_MinPayment_Void_Txn",
						"Login->Borrower Registratino->New Loan ->GreaterThanMinPayment --> Void");

				FileName = "QC_LOC_GreaterThan_MinPayment_Void_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JLOCPayments.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCVoid.qcVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

		@Test(priority =16, enabled = true, groups = "Ratikanta_LOC2")
		public static void JQC_LOC_LessThan_MinPayment_Return_Txn() throws Exception {

				test = reports.startTest("QC_LessThan_MinPayment_Return_Txn",
						"Login->Borrower Registratino->New Loan ->MinPayment --> return");

				FileName = "QC_LOC_LessThan_MinPayment_Return_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JLOCPayments.payment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCInternalTransfer.internalTransfer(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCAdminLoginLogout.login(SSN, AppURL);
						JQCAdminCCKReturn.cckreturn(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

		@Test(priority =17, enabled = true, groups = "Ratikanta_LOC2")
		public static void JQC_LOC_GreaterThan_MinPayment_Return_Txn() throws Exception {
		
				test = reports.startTest("QC_GreaterThan_MinPayment_Return_Txn",
						"Login->Borrower Registratino->New Loan ->GreaterThan-> MinPayment-> Return");

				FileName =  "QC_LOC_GreaterThan_MinPayment_Return_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JLOCPayments.payment(SSN, AppURL);
					    JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCInternalTransfer.internalTransfer(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCAdminLoginLogout.login(SSN, AppURL);
						JQCAdminCCKReturn.cckreturn(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

		@Test(priority =18, enabled = true, groups = "Ratikanta_LOC2")
		public static void JQC_LOC_Refinance_StepSame_Txn() throws Exception {
			
				test = reports.startTest("QC_Refinance_StepSame_Txn",
						"Login->Borrower Registratino->New Loan ->Refinance_StepSame");

				FileName = "QC_LOC_Refinance_StepSame_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRefinance_StepSame.StepSame(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCVoid.qcVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

		@Test(priority =19, enabled = true, groups = "Ratikanta_LOC2")
		public static void JQC_LOC_Refinance_StepUp_Txn() throws Exception {
			
				test = reports.startTest("QC_Refinance_StepUp_Txn",
						"Login->Borrower Registratino->New Loan ->Refinance_StepUp");

				FileName = "QC_LOC_Refinance_StepUp_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JDrawNewLoanMinamount.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRefinance_StepUp.Stepup(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						      //JQCVoid.qcVoid(SSN, AppURL);
						JQCVoid.refinancestepupVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
					}
				}
					}

		@Test(priority =20, enabled = true, groups = "Ratikanta_LOC2")
		public static void JQC_LOC_Refinance_CABPayment_Return_Txn() throws Exception {
	
				test = reports.startTest("QC_Refinance_CABPayment_Return_Txn",
						"Login->Borrower Registratino->New Loan ->Refinance_CABPayment_Return");

				FileName = "QC_LOC_Refinance_CABPayment_Return_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRefinance_CABPayment.CABPayment(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCInternalTransfer.internalTransfer(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCAdminLoginLogout.login(SSN, AppURL);
						JQCAdminCCKReturn.cckreturn(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
					}

		@Test(priority =21, enabled = true, groups = "Ratikanta_LOC2")
		public static void JQC_LOC_Refinance_Stepdown_Txn() throws Exception {
		
				test = reports.startTest("QC_Refinance_Stepdown_Txn",
						"Login->Borrower Registratino->New Loan ->Refinance_Stepdown");

				FileName = "QC_LOC_Refinance_Stepdown_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRefinance_Stepdown.Stepdown(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCVoid.qcVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
					}
				}
					}

		@Test(priority =22, enabled = true, groups = "Ratikanta_LOC2")
		public static void JQC_LOC_Refinance_Latefee_Payment_Txn() throws Exception {
			
				test = reports.startTest("QC_Refinance_Latefee_Payment_Txn",
						"Login->Borrower Registratino->New Loan ->Refinance_Latefee_Payment");

				FileName =  "QC_LOC_Refinance_Latefee_Payment_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewloanSignature.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JRefinance_waive.waive(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCVoid.qcVoid(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
					}
				}
					}

		
		

		@Test(priority = 323, enabled = true, groups = "Ratikanta_LOC2_EOD")
		public static void JQC_LOC_Refinance_EOD_Payment_Txn() throws Exception {
		
				test = reports.startTest(Aprop.getProperty("QC_LOC_Refinance_EOD_Payment_Txn"),
						"Login->Borrower Regifstratino->New Loan ->Refinance_EOD_Payment");

				FileName = Aprop.getProperty("QC_LOC_Refinance_EOD_Payment_Txn_file_name") + ".xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				for (int row = 2; row <= lastrow; row++) {
					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					if (RunFlag.equals("Y")) {
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRNewLoan.newLoan(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCRefinance_StepSame.StepSame(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCEODDeposit.eodDeposit(SSN, AppURL);

						JQCAdminStoreSetup.storeSetup(SSN, AppURL);
						       // JQCAdminLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCSafeAssign.safeAssign(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCDrawerAssign.drawerAssign(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCSRHistory.history(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
					}
				}
					}

		
//---------------------------------------------------------------------------------
//indhu	
		@Test(priority =1, groups = "EOD")

		public static void LOC_ACHDeposit_EODs_Return_ReDeposit_Clear_Txn() throws Exception {
		

				test = reports.startTest("ACHDeposit_EODs_Return_ReDeposit_Clear",
						"LOC – Deposit – EOD – Return – Redeposit – Clear – EOD on 2nd Payment Due Date");
				FileName =  "LOC_ACHDeposit_EODs_Return_ReDeposit_Clear_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
					if (RunFlag.equals("Y")) {

						
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						ACSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();

						// first EOD
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCDepositDropdown.depositDropDown(SSN, SSN);
						ACSRLoginLogout.logout();

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

						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCCSRReturnPosting.returnposting(SSN, SSN);

						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCAdminACHReturn.achreturn(SSN, SSN);
						//=============================================
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCRedeposit.redeposit(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCCSRReturnPosting.returnposting(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCClearDropdown.clearDropDown(SSN, SSN);
						ACSRLoginLogout.logout();

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

		@Test(priority =2, groups = "EOD" )
		public static void LOC_ACHDeposit_EODs_Return_ReDeposit_Return_Txn() throws Exception {
			

				test = reports.startTest("ACHDeposit_EODs_Return_ReDeposit_Return",
						"LOC – Deposit – EOD – Return – Redeposit – Return – EOD on 2nd Payment Due Date");
				FileName =  "LOC_ACHDeposit_EODs_Return_ReDeposit_Return_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						
						String SSN = TestData.getCellData(sheetName, "SSN", row);

				
						ACSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();

						// first EOD
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCDepositDropdown.depositDropDown(SSN, SSN);
						ACSRLoginLogout.logout();

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

						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCCSRReturnPosting.returnposting(SSN, SSN);

						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCAdminACHReturn.achreturn(SSN, SSN);

						//=============================================
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						
						
						ACSRLoginLogout.login(SSN, AppURL);
						QCRedeposit.redeposit(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCCSRReturnPosting.returnposting(SSN, SSN);

						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCAdminACHReturn.achreturn(SSN, SSN);

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

		@Test(priority =3, groups = "EOD")
		public static void LOC_ACHDeposit_EODs_Return_Txn() throws Exception {
	

				test = reports.startTest("ACHDeposit_EODs_Return",
						"Login->Borrower Registratino->New LOC – EOD on Payment Due Date(including collateral Deposit) – Clear – EOD on 2nd Payment Due Date(including collateral Deposit) – Clear -  EOD on 3rd Payment Due Date(including collateral Deposit) – Clear -  EOD on 4th Payment Due Date(including collateral Deposit) – Return(Loan in Delinquent) – Draw ");
				FileName = "LOC_ACHDeposit_EODs_Return_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

					
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						ACSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						System.out.println("first EOD"); // first EOD
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCDepositDropdown.depositDropDown(SSN, SSN);
						ACSRLoginLogout.logout();

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

						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCCSRReturnPosting.returnposting(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCClearDropdown.clearDropDown(SSN, SSN);
						ACSRLoginLogout.logout(); // second EOD
						System.out.println("second EOD");
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCDepositDropdown.depositDropDown(SSN, SSN);
						ACSRLoginLogout.logout();

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

						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCCSRReturnPosting.returnposting(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCClearDropdown.clearDropDown(SSN, SSN);
						ACSRLoginLogout.logout();

						// third EOD
						System.out.println("third EOD");
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCDepositDropdown.depositDropDown(SSN, SSN);
						ACSRLoginLogout.logout();

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

						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCCSRReturnPosting.returnposting(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCClearDropdown.clearDropDown(SSN, SSN);
						ACSRLoginLogout.logout();

						// fourth EOD
						System.out.println("fourth EOD");
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCDepositDropdown.depositDropDown(SSN, SSN);
						ACSRLoginLogout.logout();

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
						System.out.println("Return");
						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCCSRReturnPosting.returnposting(SSN, SSN);

						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCAdminACHReturn.achreturn(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCDraw.draw(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();

					}
				}
					}

		@Test(priority =4, groups = "EOD2")
		public static void LOC_ACHDeposit_EOD_Return_EOD_Default_Redeposit_Txn() throws Exception {
		
				test = reports.startTest("ACHDeposit_EOD_Return_EOD_Default_Redeposit",
						"LOC – Deposit – EOD – Return – EOD on 2nd Payment Due Date - Deafult - ReDeposit");
				FileName ="LOC_ACHDeposit_EOD_Return_EOD_Default_Redeposit_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

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
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();

						// first EOD
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCDepositDropdown.depositDropDown(SSN, SSN);
						ACSRLoginLogout.logout();

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

						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCCSRReturnPosting.returnposting(SSN, SSN);

						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCAdminACHReturn.achreturn(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);

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
						
						// New CR
						ACSRLoginLogout.login(SSN, AppURL);
						RQCCSR_LOC_ManualDefault.manualdefault(SSN, SSN);
						
						
						ACSRLoginLogout.login(SSN, AppURL);
						QCDefaultStatus.defaultStatus(SSN, SSN);
						ACSRLoginLogout.logout();

						ACSRLoginLogout.login(SSN, AppURL);
						QCRedeposit.redeposit(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();

					}
				}
					}


		@Test(priority =5, groups ="EOD2")
		public static void LOC_ACHDeposit_EOD_Return_EOD_Redeposit_Txn() throws Exception {

			
				test = reports.startTest("ACHDeposit_EOD_Return_EOD_Redeposit",
						"LOC – Deposit – EOD – Return – EOD on 2nd Payment Due Date - ReDeposit");
				FileName = "LOC_ACHDeposit_EOD_Return_EOD_Redeposit_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

					
						String SSN = TestData.getCellData(sheetName, "SSN", row);					

						ACSRLoginLogout.login(SSN, AppURL);
						JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();

						// first EOD
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCDepositDropdown.depositDropDown(SSN, SSN);
						ACSRLoginLogout.logout();

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

						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCCSRReturnPosting.returnposting(SSN, SSN);

						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCAdminACHReturn.achreturn(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);

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
						QCRedeposit.redeposit(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();

					}
				}
					}
//-------------------------------------------------------------------------------------
//Jyothi
		
		@Test(priority =1, groups ="1stBatch")
		public static void LOC_Biweekly_NextPay_NotOn_End_Txn() throws Exception {
			

				test = reports.startTest("Biweekly_NextPay_NotOn_End",
						"Login->Borrower Registratino->New LOC for a Customer with income to validate LOC Amt ");

				FileName = "LOC_Biweekly_NextPay_NotOn_End_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
			
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}

		@Test(priority =2, groups = "1stBatch" )
		public static void LOC_monthly_NextPay_NotOn_End_Txn() throws Exception {

				test = reports.startTest("monthly_NextPay_NotOn_End",
						"Login->Borrower Registratino->New LOC for a monthly Customer with income to validate LOC Amt ");

				FileName ="LOC_monthly_NextPay_NotOn_End_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);


						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}

	    @Test(priority =3, groups ="1stBatch")
	 	public static void LOC_semimonthly_NextPay_NotOn_End_Txn() throws Exception {
			

				test = reports.startTest("semimonthly_NextPay_NotOn_End",
						"Login->Borrower Registratino->New LOC for a semimonthly Customer with income to validate LOC Amt ");

				FileName = "LOC_semimonthly_NextPay_NotOn_End_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
					if (RunFlag.equals("Y")) {

						
						String SSN = TestData.getCellData(sheetName, "SSN", row);					

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}

		@Test(priority =4, groups ="1stBatch")
		public static void LOC_weekly_NextPay_NotOn_End_Txn() throws Exception {
		
				test = reports.startTest("weekly_NextPay_NotOn_End",
						"Login->Borrower Registratino->New LOC for a weekly Customer with income to validate LOC Amt ");

				FileName ="LOC_weekly_NextPay_NotOn_End_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
		
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
					if (RunFlag.equals("Y")) {

						
						String SSN = TestData.getCellData(sheetName, "SSN", row);
					
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}
		@Test(priority =5, groups ="1stBatch")
		public static void LOC_Biweekly_Nextpay_Txn() throws Exception {

				test = reports.startTest("Biweekly_Nextpay",
						"Login->Borrower Registratino->New LOC for a Customer with income to validate Min LOC Amt ");

				FileName =  "LOC_Biweekly_Nextpay.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						 //AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);						

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();

						ACSRLoginLogout.login(SSN, AppURL);
						//QCCSRHistory.history(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();

					}
				}
			
		}
		
		@Test(priority =6, groups = "1stBatch")
		public static void LOC_PayOff_after_RescindPeriod_Txn() throws Exception {
		

				test = reports.startTest("PayOff_after_RescindPeriod",
						"Login->Borrower Registratino->New LOC – Payoff after Rescind Period ");

				FileName =  "LOC_PayOff_after_RescindPeriod_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCPayOff.payoff(SSN, AppURL);
	                    ACSRLoginLogout.logout();
	                    
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}
		
		
		@Test(priority =7, groups = "1stBatch")
		public static void LOC_PayOff_On_DueDate_Txn() throws Exception {
		

				test = reports.startTest("PayOff_On_DueDate",
						"Login->Borrower Registratino->New LOC – Payoff on due date");

				FileName = "LOC_PayOff_On_DueDate_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCPayOff.payoff(SSN, AppURL);
						ACSRLoginLogout.logout();

						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}
		
		@Test(priority=8, groups ="1stBatch")
		public static void LOC_Payment_PayOff_Txn() throws Exception {
		

				test = reports.startTest("Payment_PayOff",
						"Login->Borrower Registratino->New LOC – Payment -> DueDate->Payoff ");

				FileName = "LOC_Payment_PayOff_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCPayment.payment(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCPayOff.payoff(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}
		
		@Test(priority =9, groups = "1stBatch")
		public static void LOC_Payment_GraceDays_PayOff_Txn() throws Exception {


				test = reports.startTest("Payment_GraceDays_PayOff",
						"Login->Borrower Registratino->New LOC – Payment ->Gracedays->PayPayoff ");

				FileName ="LOC_Payment_GraceDays_PayOff_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCPayment.payment(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCPayOff.payoff(SSN, AppURL);
						ACSRLoginLogout.logout();

						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}

		@Test(priority =10, groups ="1stBatch")
		public static void LOC_Payment_Void_PayOff_Txn() throws Exception {
			
				test = reports.startTest("Payment_Void_PayOff",
						"Login->Borrower Registratino->New LOC – Payment -> Void->PPayoff ");

				FileName ="LOC_Payment_Void_PayOff_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						    // AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);						

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCPayment.payment(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCVoid.qcVoid(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCPayOff.payoff(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}
		@Test(priority=11, groups ="1stBatch")
		public static void LOC_PayOff_RescindPeriod_void_Txn() throws Exception {
			

				test = reports.startTest("PayOff_RescindPeriod_void",
						"Login->Borrower Registratino->New LOC – Payoff after Rescind Period->Void ");

				FileName =  "LOC_PayOff_RescindPeriod_void_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						
						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCPayOff.payoff(SSN, AppURL);

						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCVoid.qcVoid(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}

		@Test(priority =12, groups ="1stBatch")
		public static void LOC_Payment_PayOff_Void_Txn() throws Exception {
			

				test = reports.startTest("Payment_PayOff_Void",
						"Login->Borrower Registratino->New LOC – Payment -> DueDate->PayPayoff->Void ");

				FileName = "LOC_Payment_PayOff_Void_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCPayment.payment(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCPayOff.payoff(SSN, AppURL);

						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCVoid.qcVoid(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}

		@Test(priority =13, groups = "1stBatch")
		public static void LOC_Payment_Gracedays_PayOff_Void_Txn() throws Exception {
			

				test = reports.startTest("Payment_Gracedays_PayOff_Void",
						"Login->Borrower Registratino->New LOC – Payment -> Gracedays->PayPayoff->Void ");

				FileName =  "LOC_Payment_Gracedays_PayOff_Void_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCPayment.payment(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCPayOff.payoff(SSN, AppURL);

						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCVoid.qcVoid(SSN, SSN);
						ACSRLoginLogout.logout();

						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
					}


		@Test(priority =14, groups = "1stBatch" )
		public static void LOC_Payment_Void_PayOff_Void_Txn() throws Exception {
		

				test = reports.startTest("Payment_Void_PayOff_Void",
						"Login->Borrower Registratino->New LOC – Payment -> Void->Payoff-Void ");

				FileName = "LOC_Payment_Void_PayOff_Void_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);						

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCPayment.payment(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCVoid.qcVoid(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCPayOff.payoff(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCVoid.qcVoid(SSN, SSN);
						ACSRLoginLogout.logout();

						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
					}

		@Test(priority =15, groups = "1stBatch")
		public static void LOC_PayOff_Return_Txn() throws Exception {
			

				test = reports.startTest("PayOff_Return",
						"Login->Borrower Registratino->New LOC –>Grace days->PayOff check->Check Deposit->Internal transfer->Cash Managemnet->Return");

				FileName = "LOC_PayOff_Return_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);						

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						ACSRLoginLogout.login(SSN, AppURL);
						//QCCSRNewLoan.newLoan(SSN, SSN);
						VQCCSRNewLoan.newLoan(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						
						ACSRLoginLogout.login(SSN, AppURL);
						VQCPayoff.payoffcck(SSN, SSN);					
						 //QCPayOff.payoff(SSN, AppURL);
						ACSRLoginLogout.logout();
						
						ACSRLoginLogout.login(SSN, AppURL);
						QCInternalTransfer.internalTransfer(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCCashMgmtDeposit.cashmgmtDeposit(SSN, SSN);
						ACSRLoginLogout.logout();
						
						VQCAdminCCKReturn.cckreturn(SSN, AppURL);
						
						
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
					}

		@Test(priority =16, groups = "1stBatch" )
		public static void LOC_Payment_PayOff_Return_Txn() throws Exception {
			

				test = reports.startTest("Payment_PayOff_Return",
						"Login->Borrower Registratino->New LOC –Grace days->Payment check->->Payoff->Check Deposit->Internal transfer->Cash Managemnet->Return ");

				FileName = "LOC_Payment_PayOff_Return_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCPayment.payment(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						    //QCPayOff.payoff(SSN, AppURL);
						VQCPayoff.payoffcck(SSN, SSN);	

						ACSRLoginLogout.logout();

						ACSRLoginLogout.login(SSN, AppURL);
						QCInternalTransfer.internalTransfer(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCCashMgmtDeposit.cashmgmtDeposit(SSN, SSN);
						ACSRLoginLogout.logout();

						
						VQCAdminCCKReturn.cckreturn(SSN, AppURL);
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}

		@Test(priority =17, groups ="1stBatch")
		public static void LOC_Draw_Txn() throws Exception {
		

				test = reports.startTest("Draw",
						"Login->Borrower Registratino->New LOC –>Draw ");

				FileName ="LOC_Draw_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
					if (RunFlag.equals("Y")) {

						
						String SSN = TestData.getCellData(sheetName, "SSN", row);						

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCDraw.draw(SSN, SSN);
						ACSRLoginLogout.logout();

						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
					}

		@Test(priority =18, groups ="1stBatch")
		public static void LOC_Payment_Draw_Txn() throws Exception {
		

				test = reports.startTest("Payment_Draw",
						"Login->Borrower Registratino->New LOC –>Payment->Draw ");

				FileName ="LOC_Payment_Draw_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						 // AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);						

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCPaymentforDraw.paymentDraw(SSN, SSN);
						ACSRLoginLogout.logout();

						ACSRLoginLogout.login(SSN, AppURL);
						QCDraw.draw(SSN, SSN);
						ACSRLoginLogout.logout();

						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}

		@Test(priority =19, groups ="1stBatch")
		public static void LOC_PayOff_Draw_Txn() throws Exception {
			

				test = reports.startTest("PayOff_Draw",
						"Login->Borrower Registratino->New LOC –>PayOff->Draw ");

				FileName ="LOC_PayOff_Draw_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCPayOff.payoff(SSN, SSN);
						ACSRLoginLogout.logout();
						
						ACSRLoginLogout.login(SSN, AppURL);
						QCDraw.draw(SSN, SSN);
						ACSRLoginLogout.logout();

						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
		
		}

		@Test(priority =20, groups ="1stBatch")
		public static void LOC_Draw_Void_Txn() throws Exception {
			

				test = reports.startTest("Draw_Void",
						"Login->Borrower Registratino->New LOC –>Draw ->Void");

				FileName ="LOC_Draw_Void_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCDraw.draw(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCVoid.qcVoid(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}

		@Test(priority =21, groups ="1stBatch")
		public static void LOC_Payment_Draw_Void_Txn() throws Exception {
			

				test = reports.startTest("Payment_Draw_Void",
						"Login->Borrower Registratino->New LOC –>Payment->Draw -Void");

				FileName = "LOC_Payment_Draw_Void_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCPayment.payment(SSN, SSN);
						ACSRLoginLogout.logout();

						ACSRLoginLogout.login(SSN, AppURL);
						QCDraw.draw(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCVoid.qcVoid(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}

		@Test(priority =22, groups ="1stBatch")
		public static void LOC_PayOff_Draw_Void_Txn() throws Exception {
		

				test = reports.startTest("PayOff_Draw_Void",
						"Login->Borrower Registratino->New LOC –>PayOff->Draw->Void ");

				FileName = "LOC_PayOff_Draw_Void_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();

						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCPayOff.payoff(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCDraw.draw(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCVoid.qcVoid(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}

		@Test(priority =23, groups ="1stBatch")
		public static void LOC_Deposit_Return_PayOff_Txn() throws Exception {
			
				test = reports.startTest("Deposit_Return_PayOff",
						"Login->Borrower Registratino->New LOC=> Due Date-> ACH deposit->ACH return");
				FileName ="LOC_Deposit_Return_PayOff_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
			
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreDueDate.ageStoreDueDate(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCDepositDropdown.depositDropDown(SSN, SSN);
						ACSRLoginLogout.logout();
						QCCSRLoginLogout.adminLogin(SSN, SSN);
						QCCSRReturnPosting.returnposting(SSN, SSN);

						QCCSRLoginLogout.adminLogin(SSN, SSN);
						VQCAdminACHReturn.achreturn(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCDeliquentLoan.delinquent(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();

					}
				}
			
		}

		@Test(priority =24, groups ="1stBatch")
		public static void LOC_Payment_Return_PayOff_Txn() throws Exception {
		

				test = reports.startTest("Payment_Return_PayOff",
						"Login->Borrower Registratino->New LOC –Grace days->Payment check->Check Deposit->Internal transfer->Cash Managemnet->Return->Payoff ");

				FileName = "LOC_Payment_Return_PayOff_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
						ACSRLoginLogout.login(SSN, AppURL);
						QCPayment.payment(SSN, SSN);
						ACSRLoginLogout.logout();

						ACSRLoginLogout.login(SSN, AppURL);
						QCInternalTransfer.internalTransfer(SSN, SSN);

						ACSRLoginLogout.login(SSN, AppURL);
						QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
						ACSRLoginLogout.logout();

						     //QCCSRLoginLogout.adminLogin(SSN, AppURL);
						VQCAdminCCKReturn.cckreturn(SSN, AppURL);

						ACSRLoginLogout.login(SSN, AppURL);						
						QCPayOff.payoff(SSN, AppURL);
						ACSRLoginLogout.logout();

						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}
		@Test(priority =25, groups = "1stBatch")
		public static void LOC_NewLoan_MaxLOC_Txn() throws Exception {
		

				test = reports.startTest("NewLoan_MaxLOC",
						"Login->Borrower Registratino->New LOC for a Customer with income to validate Max LOC Amt ");

				FileName = "LOC_NewLoan_MaxLOC_Txn.xls";

				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				String sheetName = "Start";
				int lastrow = TestData.getLastRow("Start");
				
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {

						// AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						

						ACSRLoginLogout.login(SSN, AppURL);
						ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						LOCMaxloanCount.newLoan(SSN, SSN);
						ACSRLoginLogout.logout();
						ACSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.history(SSN, AppURL);
						ACSRLoginLogout.logout();
					}
				}
			
		}
//Jyothi2
		@Test(priority =26, enabled = true,groups = "Jyothi")

		public static void LOC_Writeoff() throws Exception {

			FileName = "LOC_Writeoff.xls";
			test = reports.startTest("VQC_Writeoff", "Login-->New LOC - Write off");

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
	
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					

					ACSRLoginLogout.login(SSN, AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRWriteOff.writeoff(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					              // VQCCSRHistory.history(SSN, AppURL);
					              //VQCCSRWriteoff_History.VQCCSRWriteoff_History(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					       //QCCSRHistory.history(SSN, AppURL);
					ACSRLoginLogout.logout();

				}
			}

		}

		@Test(priority =27, enabled = true,groups = "Jyothi")

		public static void LOC_WriteoffRecovery() throws Exception {

			FileName = "LOC_WriteoffRecovery.xls";
			test = reports.startTest("VQC_WriteoffRecovery", "Login-->New LOC - Write off - Write off recovery--Void");

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					// String AppURL = TestData.getCellData(sheetName,"AppURL",row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					

					ACSRLoginLogout.login(SSN, AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRWriteOff.writeoff(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRWriteOffRecovery_Partial.writeoffrecovery(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					VQCVoid.qcVoid(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					  //VQCCSRWriteoff_History.VQCCSRWriteoff_History(SSN, AppURL);
					  //VQCCSRHistory.history(SSN, AppURL);
					ACSRLoginLogout.logout();

				}
			}

		}

		@Test(priority =28, enabled = true,groups = "Jyothi")

		public static void LOC_PartialWriteoffRecovery() throws Exception {

			FileName = "LOC_PartialWriteoffRecovery.xls";
			test = reports.startTest("VQC_PartialWriteoffRecovery",
					"Login-->New LOC - Write off -  Partial Write off recovery");

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					// String AppURL = TestData.getCellData(sheetName,"AppURL",row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					

					ACSRLoginLogout.login(SSN, AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRWriteOff.writeoff(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRWriteOffRecovery_Partial.writeoffrecovery(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					      //VQCCSRWriteoff_History.VQCCSRWriteoff_History(SSN, AppURL);
					      //VQCCSRHistory.history(SSN, AppURL);
					ACSRLoginLogout.logout();
				}
			}

		}

		@Test(priority = 29, enabled = true,groups = "Jyothi")

		public static void LOC_PartialWriteoffRecoveryVoid() throws Exception {

			FileName = "LOC_PartialWriteoffRecoveryVoid.xls";
			test = reports.startTest("VQC_PartialWriteoffRecoveryVoid",
					"Login-->New LOC - Write off -  Partial Write off recovery—Void");

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					// String AppURL = TestData.getCellData(sheetName,"AppURL",row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					

					ACSRLoginLogout.login(SSN, AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRWriteOff.writeoff(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRWriteOffRecovery_Partial.writeoffrecovery(SSN, AppURL);
					
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					VQCVoid.qcVoid(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					//VQCCSRWriteoff_History.VQCCSRWriteoff_History(SSN, AppURL);
					//VQCCSRHistory.history(SSN, AppURL);
					ACSRLoginLogout.logout();

				}
			}

		}

		@Test(priority =30, enabled = true,groups = "Jyothi")

		public static void LOC_Bankrupt_Writeoff() throws Exception {

			FileName = "LOC _Bankrupt_Write off.xls";
			test = reports.startTest("VQC_Bankrupt_Writeoff", "Login-->New LOC - Bankrupt Write off");

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					 String AppURL = TestData.getCellData(sheetName,"AppURL",row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					

					ACSRLoginLogout.login(SSN, AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRBankruptcy.bankruptcy(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					VAdminLoginForBankruptcy.bankruptcy(driver, SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					VQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					     //VQCCSRHistory.history(SSN, AppURL);
					     //VQCCSRWriteoff_History.VQCCSRWriteoff_History(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					ACSRLoginLogout.logout();

				}
			}

		}

		@Test(priority =31, enabled = true,groups = "Jyothi")

		public static void LOC_Bankrupt_Writeoff_Dismissed() throws Exception {

			FileName = "LOC_Bankrupt_Writeoff_Dismissed.xls";
			test = reports.startTest("VQC_Bankrupt_Writeoff_Dismissed",
					"Login-->New LOC - Bankrupt Write off - Dismissed/Discharged");

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

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
					VQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRBankruptcy.bankruptcy(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					VAdminLoginForBankruptcy.bankruptcy(driver, SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					VQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();
					VDismissed_Admin.Dismissed(driver, SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					   //VQCCSRHistory.history(SSN, AppURL);
					   //VQCCSRWriteoff_History.VQCCSRWriteoff_History(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					ACSRLoginLogout.logout();

				}
			}

		}

		@Test(priority =32, enabled = true,groups = "Jyothi")
		public static void LOC_Deposit_Return_Writeoff() throws Exception {

			FileName = "LOC_Deposit_Return_Writeoff.xls";
			test = reports.startTest(" VQC_Deposit-Return-Writeoff", "Login-->New LOC - Deposit - Return- Write off");

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					// String AppURL = TestData.getCellData(sheetName,"AppURL",row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					

					ACSRLoginLogout.login(SSN, AppURL);
					ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSR_Deposit.deposit(SSN, AppURL);
					ACSRLoginLogout.logout();
					VQCCSRReturnPosting.returnposting(SSN, AppURL);	
					VQCAdminACHReturn.achreturn(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRWriteOff.writeoff(SSN, AppURL);
					ACSRLoginLogout.logout();
					
					      //VQCCSRLogin2997.login(SSN,AppURL );
					      //VQCCSRWriteOffDepositReturn.writeoff(SSN, AppURL);
					      //ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					      //VQCCSRWriteoff_History.VQCCSRWriteoff_History(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					     //VQCCSRHistory.history(SSN, AppURL);
					ACSRLoginLogout.logout();

				}
			}

		}

		@Test(priority=33, enabled = true,groups = "Jyothi")

		public static void LOC_Deposit2_Return_Writeoff() throws Exception {

			FileName = "LOC_Deposit2_Return_Writeoff.xls";
			test = reports.startTest(" VQC_Deposit2_Return_Writeoff",
					"Login-->New LOC - Deposit - Return- 2nd Deposit - Return - Write off");
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

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
					VQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSR_Deposit.deposit(SSN, AppURL);
					ACSRLoginLogout.logout();
					VQCCSRReturnPosting.returnposting(SSN, AppURL);
					VQCAdminACHReturn.achreturn(SSN, AppURL);

					ACSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);

					VQCCSR_Deposit.deposit(SSN, AppURL);
					ACSRLoginLogout.logout();
					VQCCSRReturnPosting.returnposting(SSN, AppURL);
					VQCAdminACHReturn.achreturn(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRWriteOff.writeoff(SSN, AppURL);
					ACSRLoginLogout.logout();

					ACSRLoginLogout.login(SSN, AppURL);
					    //VQCCSRHistory.history(SSN, AppURL);
					   //VQCCSRWriteoff_History.VQCCSRWriteoff_History(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					ACSRLoginLogout.logout();
				}
			}
		}

		@Test(priority=34, enabled = true,groups ="Jyothi")

		public static void LOC_WriteoffRecoveryReturn() throws Exception {

			FileName = "LOC_WriteoffRecoveryReturn.xls";
			test = reports.startTest("VQC_WriteoffRecoveryReturn",
					"Login-->New LOC - Write off - Write off recovery--Return");

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

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
					VQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

	  			    ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRWriteOff.writeoff(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCSRWriteOffRecovery.writeoffrecovery(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					VQCInternalTransfer.internalTransfer(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					VQCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
					ACSRLoginLogout.logout();
					VQCAdminCCKReturn.cckreturn(SSN, AppURL);

					ACSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					  //VQCCSRWriteoff_History.VQCCSRWriteoff_History(SSN, AppURL);
					 //VQCCSRHistory.history(SSN, AppURL);
					ACSRLoginLogout.logout();

				}
			}

		}

		//**************************************Shashi-Scenarios************************************//

		@Test(priority =1, enabled = true, groups = "Shashi")

		public void Deposit_Dropdown() throws Exception {
			FileName = "QC_LOC_Deposit_Dropdown.xls";
			test = reports.startTest("QC_LOC_Deposit_DropDown");

			TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
					SQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					SQCDepositDropdown.depositDropDown(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();

					test.log(LogStatus.INFO, "****Test Scenario for Deposit_DropDown_Sucsessfully******");
				}
			}
		}

		@Test(priority =2, enabled = true, groups = "Shashi")

		public void Deposit_Dropdown_Void() throws Exception {
			FileName = "QC_LOC_Deposit_DropDown_Void.xls";
			test = reports.startTest("QC_LOC_Deposit_DropDown_Void");

			TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
					SQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					SQCDepositDropdown.depositDropDown(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQCVoid.qcVoid(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();
					test.log(LogStatus.INFO, "****Test Scenario for Deposit_DropDown_Void_Sucsessfully******");
				}
			}
		}

		@Test(priority =3, enabled = true, groups = "Shashi")

		public void SQC_LOC_Deposit_Bulk() throws Exception {
			FileName = "QC_LOC_Deposit_Bulk.xls";
			test = reports.startTest("QC_LOC_Deposit_Bulk");

			TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			
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
					SQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					SQCDepositMenu.depositMenu(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();
					test.log(LogStatus.INFO, "****Test Scenario for Deposit_Bulk (Menu)_Sucsessfully******");
				}
			}
		}

		@Test(priority =4, enabled = true, groups = "Shashi")

		public void SQC_LOC_Deposit_Bulk_Void() throws Exception {
			FileName = "QC_LOC_Deposit_Bulk_Void.xls";
			test = reports.startTest("QC_LOC_Deposit_Bulk_Void");

			TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
					SQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					SQCDepositMenu.depositMenu(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQCVoid.qcVoid(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();
					test.log(LogStatus.INFO, "****Test Scenario for Deposit_Bulk (Menu)_Void_Sucsessfully******");
				}
			}
		}

	    @Test(priority =5, enabled = true, groups = "Shashi")

		public void MidDay_Deposit() throws Exception {
			FileName = "QC_LOC_MidDay_Deposit.xls";
			test = reports.startTest("QC_LOC_MidDay_Deposit");

			TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
					SQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					SCSRMidDayDeposit.middeposit(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();

					test.log(LogStatus.INFO, "****Test Scenario for MidDay_Deposit_Sucsessfully******");
				}
			}
		}

		@Test(priority =6, enabled = true, groups = "Shashi")

		public void MidDay_Void_Deposit() throws Exception {
			FileName = "QC_LOC_MidDay_Void_Deposit.xls";
			test = reports.startTest("QC_LOC_MidDay_Void_Deposit");

			TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
					SQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					SCSRMidDayDeposit.middeposit(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQCVoid.qcVoid(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();

					test.log(LogStatus.INFO,
							"****<FONT color=green style=Arial>Test Scenario for MidDay_Void_Deposit_Sucsessfully******");
				}
			}
		}

		@Test(priority =7, enabled = true, groups = "Shashi")

		public void SQC_LOC_LessMinPayment_Deposit() throws Exception {
			FileName = "QC_LOC_LessMinPayment_Deposit.xls";
			test = reports.startTest("QC_LOC_LessMinPayment_Deposit");

			TestData = new ExcelNew(System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
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
					SQCCSRNewLoan.newLoan(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					ACSRLoginLogout.login(SSN, AppURL);
					SLOCPayments.payment(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQCDepositDropdown.depositDropDown(SSN, AppURL);
					ACSRLoginLogout.logout();
					ACSRLoginLogout.login(SSN, AppURL);
					SQC_LOC_History.history(SSN, AppURL);
					ACSRLoginLogout.logout();
					test.log(LogStatus.INFO, "****Test Scenario for LessMinPaymentAmt_Deposit Sucsessfully******");
				}
			}
		}

//-------------------------------------------------------------------------------------		
	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		try {

			
			BufferedReader Areader;
		

			try {
				Areader = new BufferedReader(

						new FileReader(System.getProperty("user.dir")+"/src/test/java/tests/Objects.properties"));

				Aprop = new Properties();
				Aprop.load(Areader);
				Areader.close();
				String Afilename = Aprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Aprop.getProperty("QC_Store_extent_report_path") + Afilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

		

			

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");

		}

		catch (Exception e) {
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// setup for the QC Store " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to setup for the QC Store ");

		}

	}

	@BeforeMethod(alwaysRun = true)
	public void killProcess() throws Exception {

		try {

			//Runtime.getRuntime().exec("taskkill /IM iexplore.exe /F");
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			Thread.sleep(2000); // Allow OS to kill the process
			System.out.println("killed the IE process LOC process");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/LOC/FailedTestsScreenshots/"
				+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
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

	// @AfterMethod(alwaysRun = true)

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

		// System.out.println(locator);
		// return locator;

	}

}
