package hello.dao;

import hello.entity.Member;

import java.util.ArrayList;

public class ShowMemberDao {
	public static ArrayList<String> ShowMemberNameList(ArrayList<Member> listUser){
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			con = JDBCUtil.getConnect();
//			String sql = "select CnName from t_hero";
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			ArrayList<String> list = new ArrayList<String>();
//			while(rs.next()){
//				list.add(rs.getString(1));
//			}
//			return list;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			JDBCUtil.getClose(con, ps, rs);
//		}
//		return null;
//-----------------------------------------------------------		
		ArrayList<String> nameList = new ArrayList<String>();
		for(int i =0;i<listUser.size();i++){
			nameList.add(listUser.get(i).getMemberId()+" "+listUser.get(i).getName());
		}
		return nameList;
	}
//	public static void main(String[] args) {
//		String[] str = ShowMemberNameArray();
//		for(String s:str){
//			System.out.println(s);
//		}
//	}
	public String[] ShowMemberNameArray(ArrayList<Member> listUser){
		ArrayList<String> list = ShowMemberNameList(listUser);
		String[] str = new String[list.size()];
		for(int i = 0;i<list.size();i++){
			str[i] = list.get(i);
		}
		return str;
	}
}
