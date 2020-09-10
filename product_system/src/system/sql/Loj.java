package system.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import system.sqlserverConn.GetSqlConn;
//登录注册日志
public class Loj {

	String sql;
	Connection conn =GetSqlConn.getConn();
	PreparedStatement prepstmt;
	boolean result = false;
	ResultSet rs;
	String lojText;
	String loj1;
	String manage;

	List<String> allLoj =null;
	List<String> allmanage =null;


	//插入日志
	public boolean setLog(String username,String actionLoj,String date ) {
		sql = "insert into loj values(?,?,?)";
		try {

			prepstmt = conn.prepareStatement(sql);

			prepstmt.setString(1,username);
			prepstmt.setString(2,actionLoj);
			prepstmt.setString(3,date);


			if(prepstmt.executeUpdate()>0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//获取日志
	public List<String> getAllLoj(){
		allLoj = new ArrayList<String>();
		sql = "select * from loj";
		try {
			prepstmt = conn.prepareStatement(sql);
			rs = prepstmt.executeQuery();
			while(rs.next()){
				loj1 = rs.getString(1) +"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+"\n";
				allLoj.add(loj1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allLoj;
	}

	//删除日志
	public boolean delLoj(String name){
		sql = "delete from loj where username = ?";
		try {
			prepstmt = conn.prepareStatement(sql);
			prepstmt.setString(1, name);
			if(prepstmt.executeUpdate()>0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	//删除所有记录
	public void delAllLoj() {
		sql = "delete from loj";
		try {
			prepstmt = conn.prepareStatement(sql);
			if(prepstmt.executeUpdate()>0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	//获取所有管理用户的信息
	public List<String> getmanageInfo() {
		allmanage = new ArrayList<String>();
		sql = "select name from user";
		try {
			prepstmt = conn.prepareStatement(sql);

			rs = prepstmt.executeQuery();
			while(rs.next()){
				manage = rs.getString(1)+"\n";
				allmanage.add(manage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allmanage;
	}



	//删除指定名字用户
	public boolean delmanageInfo(String manageName){
		sql = "delete from user where name = ?";
		try {
			prepstmt = conn.prepareStatement(sql);
			prepstmt.setString(1, manageName);
			if(prepstmt.executeUpdate()>0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//删除所有用户信息
	public void delAllManage() {
		sql = "delete from user";
		try {
			prepstmt = conn.prepareStatement(sql);
			if(prepstmt.executeUpdate()>0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
