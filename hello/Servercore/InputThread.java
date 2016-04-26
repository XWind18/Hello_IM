package hello.Servercore;

import hello.common.TranObject;
import hello.common.TranObjectType;
import hello.dao.手机dao;
import hello.dao.改密码dao;
import hello.dao.注册dao;
import hello.dao.登录dao;
import hello.entity.Member;
import hello.util.JDBCUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;




public class InputThread extends Thread{
	private Socket socket ;
	private OutputThread out;
	private OutputThreadMap map;
	private ObjectInputStream ois;
	private boolean isStart = true;
	
	public InputThread(Socket socket, OutputThread out, OutputThreadMap map){
		this.socket = socket;
		this.out = out;
		this.map = map;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(isStart){
				readMessage();
			}
			if(ois != null){
				ois.close();
			}
			if(socket != null){
				socket.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	public void readMessage() throws Exception{
		TranObject readObject = (TranObject) ois.readObject();
		TranObjectType tType = readObject.getType();
		switch(tType){
		case REGISTER:
			Member memberReg = (Member)readObject.getObject();
			TranObject objReg = new TranObject();
			System.out.println(12);
			注册dao daoRegister = new 注册dao();
			手机dao daoPhone = new 手机dao();
			boolean yz = daoPhone.yanzheng(memberReg.getPhone());
			String ti1 = yz ? "该手机号已注册" : "";
			if (yz) {
				objReg.setCmd("rbid");	
				System.out.println(2);
			} else {
				boolean saveFlag = daoRegister.inSert(memberReg.getName(), memberReg.getLoginPwd(),
						memberReg.getSex(), memberReg.getAge(), memberReg.getPhone());
				objReg.setCmd("txts");
				if (saveFlag) {
					objReg.setObject("注册成功");
					System.out.println(3);
				} else {
					objReg.setObject("注册失败");
					System.out.println(4);
				}
			}

		
			break;
		case LOGIN:
			Member member = (Member) readObject.getObject();
			TranObject sendObject = new TranObject();
			sendObject.setType(TranObjectType.LOGIN);
			登录dao dao = new 登录dao();
			String pwd = dao.Select(member.getPhone());
			boolean ph = dao.phone(member.getPhone());
			if (ph) {
				
				if (pwd.equals(member.getLoginPwd())) {
					System.out.println("登录成功");
					sendObject.setCmd("true");
					sendObject.setObject("登录成功");
					Member memLogin = JDBCUtils.queryForObject("select * from member where phone = ?", Member.class, member.getPhone());
					memLogin.setLoginPwd("");
					sendObject.setObject(memLogin);
					out.setMessage(sendObject);
					
					//登录成功处理事件,通知好友上线
					TranObject loginmessage = new TranObject();
					loginmessage.setType(TranObjectType.FRIENDLOGIN);
					loginmessage.setObject(memLogin);
					List<OutputThread> list = map.getAll();
					for (OutputThread outputThread : list) {
						outputThread.setMessage(loginmessage);
					}
					map.add(memLogin.getMemberId(), out);
					
					//  获取在线好友
					TranObject getOnlineFriend = new TranObject();
					getOnlineFriend.setType(TranObjectType.LOGIN);
					getOnlineFriend.setObject(FriendList.getFriendListAll());
					out.setMessage(getOnlineFriend);
					
					
					FriendList.addFriendList(memLogin);
					
				} else {
					sendObject.setCmd("rbpwd");
					sendObject.setObject("密码错误");
					out.setMessage(sendObject);
				}
			} else {
				sendObject.setCmd("rbid");
				sendObject.setObject("账号不存在");
				out.setMessage(sendObject);
			}
			break;
		case FORGETPWD:
			Member memForgetPwd = (Member)readObject.getObject();
			TranObject ForgetPwdObject = new TranObject();
			改密码dao daoForget = new 改密码dao();
			boolean gm = daoForget.upDate(memForgetPwd.getLoginPwd(), memForgetPwd.getPhone());
			ForgetPwdObject.setCmd("jxg");
			if (gm) {
				ForgetPwdObject.setObject("修改成功");
			} else {
				ForgetPwdObject.setObject("修改失败");
			}
			out.setMessage(ForgetPwdObject);

			
			
			
			break;
		case GROUPMESSAGE:
			Member memGroup = readObject.getFromMember();
			if(map.getById(memGroup.getMemberId()) == null){
				map.add(memGroup.getMemberId(), out);
				System.out.println(23);
			}
			ArrayList<OutputThread> list = (ArrayList<OutputThread>) map.getAll();
			for (OutputThread outputThread : list) {
				if(!outputThread.equals(out)){
					outputThread.setMessage(readObject);
					System.out.println(4);
				}
			}
			System.out.println(1);
			System.out.println(map.getAll());
			break;
		case MESSAGE:
			out.setMessage(readObject);
			String info1=readObject.getFromUser()+" 对 "+readObject.getToUser()+"  "+readObject.getSendTime()+"\n"+readObject.getObject()+"\r\n";
			System.out.println(info1);
			break;
		
			
		default:
			break;
		}
	}
	
	
}
