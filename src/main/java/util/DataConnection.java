package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {

	private static final String SqliteDBDRIVER = "org.sqlite.JDBC";
	private static final String MySQLDBDRIVER = "com.mysql.jdbc.Driver";
	private static final String SQLServerDBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	private static final String SqliteDBURL = "jdbc:sqlite:guitar.db";
	private static final String MysqlDBURL = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8";
	private static final String SQLServerDBURL = "jdbc:sqlserver://localhost:1433;DatabaseName=guitar";

	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "123456";
	private static final String userName = "sa";
	private static final String userPwd = "123456";

	private static Connection conn;

	public static Connection getConnection(String type) throws Exception {

		if (type.equals("sqlite")) {
			//System.out.println("数据库是sqlite");
			Class.forName(SqliteDBDRIVER);
			conn = DriverManager.getConnection(SqliteDBURL);
		} else if (type.equals("mysql")) {
			//System.out.println("数据库是mysql");
			Class.forName("MySQLDBDRIVER");
			conn = DriverManager.getConnection(MysqlDBURL, DBUSER, DBPASSWORD);
		} else if (type.equals("sqlserver")) {
			//System.out.println("数据库是sqlserver");
			Class.forName("SQLServerDBDRIVER");
			conn = DriverManager.getConnection(SQLServerDBURL, userName, userPwd);
		}
		return conn;
	}

	public void close() throws Exception {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
