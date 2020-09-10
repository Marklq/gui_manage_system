package system.sqlserverConn;

import java.sql.*;

/**
 * 类方法获取连接CONN
 */

public class GetSqlConn {
	
	//sql基本信息
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/market";
    private static String username = "root";
    private static String password = "root";
    
    private static Connection conn = null;
    
    static{
    	try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
//			System.out.println("成功获取连接！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    }
    
    //获取sql连接
    public static Connection getConn() {
		return conn;
		}
    
    //关闭sql连接
    public static void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}  
}
