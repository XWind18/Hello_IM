package hello.server.dao;

import hello.entity.Member;

import java.util.ArrayList;

public class ShowMemberDao {
	public static ArrayList<String> ShowMemberNameList(ArrayList<Member> listUser){
		ArrayList<String> nameList = new ArrayList<String>();
		for(int i =0;i<listUser.size();i++){
			nameList.add(listUser.get(i).getMemberId()+" "+listUser.get(i).getName());
		}
		return nameList;
	}
	public String[] ShowMemberNameArray(ArrayList<Member> listUser){
		ArrayList<String> list = ShowMemberNameList(listUser);
		String[] str = new String[list.size()];
		for(int i = 0;i<list.size();i++){
			str[i] = list.get(i);
		}
		return str;
	}
}
