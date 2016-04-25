package hello.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {
	public static final String DRIVER ="com.mysql.jdbc.Driver";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";
	public static final String URL = "jdbc:mysql://localhost:3306/kf17";
	
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnect(){
	Connection con = null;
	try {
		con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	}
	//增删改
	public static int addDeleteUpdate(String sql,Object ... args){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con=getConnect();
			ps = con.prepareStatement(sql);
			if(args!=null){
				for(int i=0;i<args.length;i++){
					ps.setObject(i+1,args[i]);
				}
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}finally{
			JDBCUtil.getClose(con, ps, null);
		}
		return 0;
	}
	
//	public static ResultSet query(String sql, Object ... obj){
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs =null;
//		try {
//			ps = con.prepareStatement(sql);
//			if(obj!=null){
//				for(int i=0;i<obj.length;i++){
//				ps.setObject(i+1, obj[i]);
//				}
//			}
//			rs = ps.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
	//list里存放map
	public static List queryforList(String sql,Object ... obj){
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		con =JDBCUtil.getConnect();
		try {
			ps = con.prepareStatement(sql);
			
			if(obj != null){
				for(int i=0;i<obj.length;i++){
					ps.setObject(i+1, obj[i]);
				}
			}
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int coulumcount = rsmd.getColumnCount();
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			while(rs.next()){
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < coulumcount; i++) {
					String key = rsmd.getColumnLabel(i+1);
				    Object value = rs.getObject(key);
				    map.put(key, value);
				}
				list.add(map);
			}
			if(list != null && list.size()>0){
				return list;
			}else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.getClose(con, ps, rs);
		}
		return null;
	}
	public static Map<String, Object> queryforMAP(String sql,Object ... obj){
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		con =JDBCUtil.getConnect();
		try {
			ps = con.prepareStatement(sql);
			
			if(obj != null){
				for(int i=0;i<obj.length;i++){
					ps.setObject(i+1, obj[i]);
				}
			}
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int coulumcount = rsmd.getColumnCount();
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			while(rs.next()){
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < coulumcount; i++) {
					String key = rsmd.getColumnLabel(i+1);
				    Object value = rs.getObject(key);
				    map.put(key, value);
				}
				list.add(map);
			}
			if(list != null && list.size()>0){
				return list.get(0);
			}else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.getClose(con, ps, rs);
		}
		return null;
	}
	
	public static void getClose(Connection con,PreparedStatement ps,ResultSet rs){
		try {
			try{
				if(rs!=null){
					rs.close();
				}
			}finally{
				try{
				if(ps!=null){
					ps.close();
				}
				}finally{
					con.close();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}
