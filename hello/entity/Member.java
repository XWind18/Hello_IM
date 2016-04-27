package hello.entity;

import java.io.Serializable;
import java.util.Date;

public class Member  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private int memberId;
	private String name;
	private String loginPwd;
	private String sex;
	private int age;
	private Date time;
	private int statu;
	private String phone;
	
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
		
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Member() {
		this.statu = 1;
	}
	public Member(String name, String loginPwd, String sex, int age) {
		this.name = name;
		this.loginPwd = loginPwd;
		this.sex = sex;
		this.age = age;
		this.statu = 1;
		time = new Date();
	}
	@Override
	public String toString() {
		String str = "true";
		if(this.statu == 0){
			str = "false";
		}
		return "[HelloID：" + memberId + "\t用户名：" + name
				+ "\t性别：" + sex + "\t年龄：" + age+
				"\tstatu：" + str + "]";
	}
	
	
	
	
}
