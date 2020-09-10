package system.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import system.sqlserverConn.GetSqlConn;

/**
 * 对主界面的登录、注册操作
 *
 */
public class User {
	private String sql;
	private boolean result = false;
	private PreparedStatement prepstmt;
	private ResultSet rs;
	private Connection conn = GetSqlConn.getConn();
	
	//判断登录，若有该账户密码，返回true
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
	
	//注册，成功返回true
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
