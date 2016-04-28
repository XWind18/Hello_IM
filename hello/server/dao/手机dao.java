package hello.server.dao;

import hello.server.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 手机dao {
	
	public boolean shouji(String mobiles){
//		 ^1[3|4|5|8][0-9]\d{8}$
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");  
		Matcher m = p.matcher(mobiles);  
		return m.matches();  
	}
	public boolean yanzheng(String i){
		boolean flag = true;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = JDBCUtils.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from member");
			while(rs.next()){
				String phone =rs.getString("phone");
				if(phone != null){
					if(phone.equals(i)){
						flag = true;
						return flag;
					}else{
						flag = false;
					}
				}
			}
			JDBCUtils.close(rs, st, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
