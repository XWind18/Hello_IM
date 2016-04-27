package hello.server.dao;
import hello.server.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;



public class 注册dao {
	
//	public static void main(String[] args) {
//		 
//		Connection con = null;
//		PreparedStatement st = null;
//		con = JDBCUtils.getConnection();
//		
//		String sql = "insert into member(id,name,password,sex,age,phone) values(?,?,?,?,?,?)";
//		 
//		try {
//			st = con.prepareStatement(sql);
//			st.executeUpdate();
//			JDBCUtils.close(null, st, con);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	public boolean inSert(String name,String password,String sex,int age,String phone){

		boolean flag = false;
		int i = 0;
		Connection con = null;
		PreparedStatement st = null;
		con = JDBCUtils.getConnection();
		String sql = "insert into member(name,LoginPwd,sex,age,phone,time) values(?,?,?,?,?,?)";
		
		try {
			st = con.prepareStatement(sql);
			st.setString(1,name);
			st.setString(2,password);
			st.setString(3,sex);
			st.setInt(4, age);
			st.setString(5,phone);
			st.setObject(6,new Date());
			i = st.executeUpdate();
			
			flag = i>0 ? true:false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, st, con);
		}
		
		return flag;
	}
}