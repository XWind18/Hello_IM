package hello.common;

import hello.entity.Member;

import java.io.Serializable;
import java.util.List;

/** 
 * 传输的对象,直接通过Socket传输的最大对象 
 *  
 * @author 
 */  
public class TranObject<T> implements Serializable {  
    /** 
     *  
     */  
    private static final long serialVersionUID = 1L;  
  
    private TranObjectType type;// 发送的消息类型  
	private int fromUser;// 来自哪个用户  
    private int toUser;// 发往哪个用户  
    private T object;// 传输的对象，这个对象我们可以自定义任何  
    private List<Integer> group;// 群发给哪些用户  
    private Member fromMember;
    private String sendTime;
    private String cmd;
    
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public TranObjectType getType() {
		return type;
	}
	public void setType(TranObjectType type) {
		this.type = type;
	}
	public int getFromUser() {
		return fromUser;
	}
	public void setFromUser(int fromUser) {
		this.fromUser = fromUser;
	}
	public int getToUser() {
		return toUser;
	}
	public void setToUser(int toUser) {
		this.toUser = toUser;
	}
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	public List<Integer> getGroup() {
		return group;
	}
	public void setGroup(List<Integer> group) {
		this.group = group;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public Member getFromMember() {
		return fromMember;
	}
	public void setFromMember(Member fromMember) {
		this.fromMember = fromMember;
	}
	@Override
	public String toString() {
		return "TranObject [type=" + type + ", fromUser=" + fromUser
				+ ", toUser=" + toUser + ", object=" + object + ", group="
				+ group + ", fromMember=" + fromMember + ", sendTime="
				+ sendTime + ", cmd=" + cmd + "]";
	}
    
}
