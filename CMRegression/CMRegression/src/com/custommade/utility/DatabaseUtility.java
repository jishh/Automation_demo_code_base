package com.custommade.utility;

import java.sql.*;

/**
 * 
 * @author anokh ClassName:DatabaseUtility Description: This class is for
 *         connecting to a database, executing the query and getting the result
 *         string.
 */
public class DatabaseUtility {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String user;
	private static String pass;
	private static String dbUrl;
	private static String queryOutput;
	static String sqlQuery;

	/*
	 * Method Name: dataBaseReadingMethod() Description: This function is
	 * executing a query and getting the result.
	 */
	public static String executeQuery(String query) {
		PropertyUtility propertyReadingUtilityObj = new PropertyUtility();
		user = propertyReadingUtilityObj.getProperty("Dbusername");
		pass = propertyReadingUtilityObj.getProperty("Dbpassword");
		dbUrl = propertyReadingUtilityObj.getProperty("Dburl");
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, user, pass);
			stmt = conn.createStatement();
			sqlQuery = query;
			ResultSet rs = stmt.executeQuery(sqlQuery);
			queryOutput = rs.getString("result");
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return queryOutput;
	}
}
