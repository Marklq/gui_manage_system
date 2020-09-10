package system.sqlserverConn;

import java.sql.*;

/**
 * �෽����ȡ����CONN
 */

public class GetSqlConn {
	
	//sql������Ϣ
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/market";
    private static String username = "root";
    private static String password = "root";
    
    private static Connection conn = null;
    
    static{
    	try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
//			System.out.println("�ɹ���ȡ���ӣ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    }
    
    //��ȡsql����
    public static Connection getConn() {
		return conn;
		}
    
    //�ر�sql����
    public static void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}  
}
