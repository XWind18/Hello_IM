package hello.server.dao;

import hello.server.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class 登录dao {
	

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
