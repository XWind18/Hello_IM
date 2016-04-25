package hello.dao;

import hello.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class 改密码dao {
	public static void main(String[] args) {
		 
		Connection con = null;
		PreparedStatement st = null;
		con = JDBCUtils.getConnection();
		
		String sql = "update member set loginPwd=? where phone=?";
//		UPDATE t_user SET password=123 WHERE id=3;	修改
		try {
			st = con.prepareStatement(sql);
			st.executeUpdate();
			JDBCUtils.close(null, st, con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public boolean upDate(String password,String phone){
		boolean flag = false;
		Connection con = null;
		PreparedStatement st = null;
		con = JDBCUtils.getConnection();
		String sql = "update member set loginPwd=? where phone=?";
		
		try {
			st = con.prepareStatement(sql);
			st.setString(1,password);
			st.setString(2,phone);
			int i = st.executeUpdate();
			
			flag = i>0 ? true:false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, st, con);
		}
		
		return flag;
	}
	
}
