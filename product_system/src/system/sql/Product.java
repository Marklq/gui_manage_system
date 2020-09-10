package system.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import system.sqlserverConn.GetSqlConn;

//����Ʒ��sql��ɾ���
public class Product {

	String h = "\n";
	List<String> allInfo =null; 
	String proInfo = "û�������ݣ�";
	String sql;
	Connection conn =GetSqlConn.getConn();
	PreparedStatement prepstmt;
	ResultSet rs;
	boolean result = false;



	//�����ݿ����

	//��ȡһ����Ʒ��Ϣ
	public String getProInfo(String pname) {
		sql = "select * from product where p_name=?";
		try {
			prepstmt = conn.prepareStatement(sql);
			prepstmt.setString(1,pname);
			rs = prepstmt.executeQuery();
			while(rs.next()){
				proInfo = rs.getInt(1)+"\t"+rs.getString(2) +"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+h;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proInfo;
	}


	//��ӳɹ�����true
	public boolean addPro(int id, String name, int num, int price, String pclass,String pprduce, String ptime) {
		sql = "insert into product values(?,?,?,?,?,?,?)";
		try {

			prepstmt = conn.prepareStatement(sql);
			prepstmt.setInt(1, id);
			prepstmt.setString(2, name);
			prepstmt.setInt(3, num);
			prepstmt.setInt(4, price);
			prepstmt.setString(5, pclass);
			prepstmt.setString(6, pprduce);
			prepstmt.setString(7, ptime);
			
			if(prepstmt.executeUpdate()>0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//��ȡ�����Ͳ��ҵ��ļ���
	public List<String> getAllInfo(String pclass){
		allInfo = new ArrayList<String>();
		sql = "select * from product where p_clazz=?";
		try {
			prepstmt = conn.prepareStatement(sql);
			prepstmt.setString(1, pclass);
			rs = prepstmt.executeQuery();
			while(rs.next()){
				proInfo = rs.getInt(1)+"\t"+rs.getString(2) +"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+h;
				allInfo.add(proInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allInfo;
	}
	
	//��ȡ�����ز��ҵ��ļ���
	public List<String> getproduceInfo(String pproduce){
		allInfo = new ArrayList<String>();
		sql = "select * from product where p_produce=?";
		try {
			prepstmt = conn.prepareStatement(sql);
			prepstmt.setString(1, pproduce);
			rs = prepstmt.executeQuery();
			while(rs.next()){
				proInfo = rs.getInt(1)+"\t"+rs.getString(2) +"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+h;
				allInfo.add(proInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allInfo;
	}
	


	//��ȡ������Ʒ�ļ���
	public List<String> getAllPro(){
		allInfo = new ArrayList<String>();
		sql = "select * from product ";
		try {
			prepstmt = conn.prepareStatement(sql);

			rs = prepstmt.executeQuery();
			while(rs.next()){
				proInfo = rs.getInt(1)+"\t"+rs.getString(2) +"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+h;
				allInfo.add(proInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allInfo;
	}


	//��һɾ��
	public boolean delPro(String proName) {
		sql = "delete from product where p_name = ?";
		try {
			prepstmt = conn.prepareStatement(sql);
			prepstmt.setString(1, proName);
			if(prepstmt.executeUpdate()>0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	//����ɾ��
	public boolean delBatchPro(String pclass) {
		sql = "delete from product where p_clazz = ?";
		try {
			prepstmt = conn.prepareStatement(sql);
			prepstmt.setString(1, pclass);
			if(prepstmt.executeUpdate()>0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//ɾ�����л���
	public boolean delAllPro() {
		sql = "delete from product";
		try {
			prepstmt = conn.prepareStatement(sql);
			if(prepstmt.executeUpdate()>0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	

	//��һ����
	public boolean changePro( int num,int price,String pclass,String pname,String pprduce,int id) {
		sql = "UPDATE product SET p_num = ? , p_price = ? , p_clazz=? , p_name=?, p_produce = ?  WHERE p_id = ?";
		try {
			prepstmt = conn.prepareStatement(sql);
			prepstmt.setInt(1, num);
			prepstmt.setInt(2, price);
			prepstmt.setString(3, pclass);
			prepstmt.setString(4, pname);
			prepstmt.setString(5, pprduce);
			prepstmt.setInt(6, id);
			
			if(prepstmt.executeUpdate()>0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//��������
	public boolean changePro(String newclass,String pclass) {
		sql = "UPDATE product SET  p_clazz = ? WHERE p_clazz=?";
		try {
			prepstmt = conn.prepareStatement(sql);
			prepstmt.setString(1, newclass);
			prepstmt.setString(2, pclass);
			if(prepstmt.executeUpdate()>0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
