package system.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import system.sqlserverConn.GetSqlConn;

/**
 * ��������ĵ�¼��ע�����
 *
 */
public class User {
	private String sql;
	private boolean result = false;
	private PreparedStatement prepstmt;
	private ResultSet rs;
	private Connection conn = GetSqlConn.getConn();
	
	//�жϵ�¼�����и��˻����룬����true
	public boolean isLogin(String name,String password) {
		
		sql = "select * from user where name=?  and password=?";
		
		try {
			prepstmt = conn.prepareStatement(sql);
			prepstmt.setString(1, name);
			prepstmt.setString(2, password);
			rs = prepstmt.executeQuery();
			if(rs.next()){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//ע�ᣬ�ɹ�����true
	public boolean isReg(String name,String password){
		
		sql = "insert into user(name,password)values(?,?)";
		
		try {
			prepstmt = conn.prepareStatement(sql);
			prepstmt.setString(1, name);
			prepstmt.setString(2, password);
			int i = prepstmt.executeUpdate();
			if(i!=0){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;}
	
}
