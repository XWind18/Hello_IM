package hello.server.dao;

import hello.entity.Member;
import hello.server.util.JDBCUtils;

import java.util.Iterator;
import java.util.List;


public class MemberDao {
	public int delete(int id){
		String sql = "delete from member where memberId = ?";
		return JDBCUtils.update(sql, id);
	}

	public String query(){
		String result = "";
		String sql = "select * from member";
		List<Member> list = JDBCUtils.queryForList(sql, Member.class);
		Iterator<Member> it = list.iterator();
		while(it.hasNext()){
			result = result + it.next().toString()+ "\n";
		}
		return result;
	}
	
}
