package tests;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleTypes;

public class BProc3 {

	public static void proc() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;

		// Object of ResultSet => 'It maintains a cursor that points to the
		// current row in the result set'
		ResultSet resultSet = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("before conn");
		// Open a connection
		try {

			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QCHPROD_QTP_03122019",
					"QCHPROD_QTP_03122019");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		System.out.println("after conn");
		try {
                                     

			resultSet = stmt.executeQuery("Delete  From   Bo_Phone Where Bo_Code In (Select Bo_Code From Bo_Master Where Ssn IN  ( select ssn from QC_SSN_THREE_LOC ))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Other_Info Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC) )");
			resultSet = stmt.executeQuery("Delete  From   Bo_Income Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN (select ssn from QC_SSN_THREE_LOC) )");
			resultSet = stmt.executeQuery("Delete  From   Bo_Address Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC) )");
			resultSet = stmt.executeQuery("Delete  From   Bo_Bank_Acnt Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC) )");
			resultSet = stmt.executeQuery("Delete  From   Bo_Reference Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Notes Where Bo_Code In (Select Bo_Code  From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC))");
			resultSet = stmt.executeQuery("Delete  From   ACH_STAGING Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC))");
			resultSet = stmt.executeQuery(" Delete  From   st_il_master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC))");
			resultSet = stmt.executeQuery("DELETE FROM   ST_LC_MINPAY WHERE LC_TRAN_CODE IN  ( SELECT T.LC_TRAN_CODE FROM ST_LC_TRANS T WHERE T.LC_CODE IN ((SELECT LC_CODE  From   st_lc_master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC)))))");
			resultSet = stmt.executeQuery("DELETE FROM   ST_LC_STATEMENT WHERE LC_TRAN_CODE IN  ( SELECT T.LC_TRAN_CODE FROM ST_LC_TRANS T WHERE T.LC_CODE IN ((SELECT LC_CODE  From   st_lc_master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC)))))");
			resultSet = stmt.executeQuery("DELETE FROM   ST_LC_APPORTIONS WHERE LC_TRAN_CODE IN  ( SELECT T.LC_TRAN_CODE FROM ST_LC_TRANS T WHERE T.LC_CODE IN ((SELECT LC_CODE  From   st_lc_master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC)))))");
			resultSet = stmt.executeQuery("DELETE FROM   ST_LC_RCPT WHERE LC_TRAN_CODE IN  ( SELECT T.LC_TRAN_CODE FROM ST_LC_TRANS T WHERE T.LC_CODE IN ((SELECT LC_CODE  From   st_lc_master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC)))))");
			resultSet = stmt.executeQuery("DELETE FROM   ST_LC_DISB WHERE LC_TRAN_CODE IN  ( SELECT T.LC_TRAN_CODE FROM ST_LC_TRANS T WHERE T.LC_CODE IN ((SELECT LC_CODE  From   st_lc_master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC)))))");
			resultSet = stmt.executeQuery("DELETE FROM   ST_LC_TRANS WHERE LC_CODE IN ((SELECT LC_CODE  From   st_lc_master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC))))");
			resultSet = stmt.executeQuery(" DELETE  From   st_lc_master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC))");
			resultSet = stmt.executeQuery("Delete  From   bo_card_details Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC))");
			resultSet = stmt.executeQuery("Delete  From   REPAY_DEPOSIT_SCHEDULE Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC))");
			
			resultSet = stmt.executeQuery("Delete FROM    ca_closing_history where trunc(business_date)>TO_DATE('05-DEC-2017','dd-mon-yy') and st_code in (505)");
			resultSet = stmt.executeQuery("Delete  From   REPAY_DATA_LOG Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QC_SSN_THREE_LOC))");
			resultSet = stmt.executeQuery("Delete FROM    st_daily_summary where trunc(business_date)>TO_DATE('05-DEC-2017','dd-mon-yy') and st_code in (505)");

			resultSet = stmt.executeQuery("Commit");

			 while (resultSet .next())
			{
				System.out.println(
						/*resultSet .getString(1) + "  " +
									 * resultSet.getString(2) + "  " +
									 * resultSet.getString(3) + "  " +
									 * resultSet.getString(4) + "  " +
									 * resultSet.getString(5)
									 */);
			}
			System.out.println("after query");

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		} catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}

}
