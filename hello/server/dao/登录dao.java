package hello.server.dao;

import hello.server.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class 登录dao {
	public static void main(String[] args) {
		 
		Connection con = null;
		PreparedStatement st = null;
		con = JDBCUtils.getConnection();
//		查	select * from 表 where 字段 like '%值%'
		String sql = "select password  from t_zhuce where phone=?";
		 
		try {
			st = con.prepareStatement(sql);
			st.executeUpdate();
			JDBCUtils.close(null, st, con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
	public String Select(String phone){
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pwd = null;
		try {
			con = JDBCUtils.getConnection();
			ps =  con.prepareStatement("select loginPwd from member where phone=?");
			ps.setString(1, phone);
			rs = ps.executeQuery();
			
			while(rs.next()){
				pwd = rs.getString("loginPwd");
				
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, con);
		}
		return pwd ;
	}	
	public boolean phone(String phone){
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String phon = null;
		try {
			con = JDBCUtils.getConnection();
			ps =  con.prepareStatement("select phone from member");
//			ps.setString(1, phone);
			rs = ps.executeQuery();
			
			while(rs.next()){
				phon = rs.getString("phone");
				if(phone.equals(phon)){
					return true ;
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, con);
		}
		return false;
	}
}
