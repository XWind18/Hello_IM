package hello.server.Servercore;

import hello.entity.Member;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FriendList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static List<Member>  friendList = new ArrayList<Member>();
	public static int getSize(){
		return friendList.size();
	}
	public static void setFriendList(List<Member> friendList) {
		FriendList.friendList = friendList;
	}
	public static Member getFriendList(int index){
		if(friendList.size()>0){
			return friendList.get(index);
		}
		return null;
	}
	public static void addFriendList(Member member){
		if(!friendList.contains(member)){
			friendList.add(member);
		}
	}
	public static List<Member> getFriendListAll(){
		return friendList;
	}
	public static void removeFriendList(int idLogout){
		for (int i = 0; i < getSize(); i++) {
			if(friendList.get(i).getMemberId()==(idLogout)){
				friendList.remove(i);
				break;
			}
		}
	}
}
