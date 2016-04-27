package hello.client.clientcore;

import hello.client.ui.GroupChat;
import hello.client.ui.HelloRoom;
import hello.client.ui.MainPanel;
import hello.client.ui.找回密码;
import hello.client.ui.注册界面;
import hello.client.ui.登录界面;
import hello.entity.Member;
import hello.entity.TranObject;

import java.net.Socket;
import java.util.ArrayList;

public class ClientThread extends Thread{
	private InputThread in;
	private OutputThread out;
	private boolean isStart;
	
	
	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	public ClientThread(Socket socket) {
		in = new InputThread(socket);
		out= new OutputThread(socket);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		in.setStart(true);
		out.setStart(true);
		in.setPriority(7);
		in.start();
		out.start();
		while(isStart){
			if(in.isMessageLin()){
				TranObject message = in.getMessage();
				in.setMessageLin(false);
				if(message != null){
					switch(message.getType()){
					case REGISTER:
						注册界面 RegisterFrame = new 注册界面();
						RegisterFrame = (注册界面)ThreadMap.getThreadMap("RegisterFrame");
						if("rbid".equals(message.getCmd())){
							RegisterFrame.setRbidTxt((String) message.getObject());
						}else if("txts".equals(message.getCmd())) {
							RegisterFrame.setTxtstxt((String) message.getObject());
						}
						
						break;
					case LOGIN:
						登录界面 loginFrame = (登录界面)ThreadMap.getThreadMap("loginFrame");
						loginFrame.setRbpwdTxt("");
						loginFrame.setRbidTxt("");
						if("true".equals(message.getCmd())){
							//  登录成功
							loginFrame.dispose();
							//新建主窗口
							MainPanel mainpanel = new MainPanel((Member)message.getObject());//新建好友列表页面
							mainpanel.setVisible(true);
							ThreadMap.addThreadMap("mainpanel", mainpanel);
						}else if("rbpwd".equals(message.getCmd())){
							loginFrame.setRbpwdTxt("密码错误");
						}else {
							loginFrame.setRbidTxt("账号不存在");
						}
						break;
						
					case FORGETPWD:
						找回密码 forgetPwd = (找回密码)ThreadMap.getThreadMap("fotgetPwd");
						forgetPwd.setJxgTxt((String) message.getObject());
						break;
					case MESSAGE:
						HelloRoom helloRoom = null;
						Member friend = null;
						Member mySelf = null;
						if(ThreadMap.getThreadMap("helloRoom_"+message.getFromUser()) != null){
							helloRoom = (HelloRoom)ThreadMap.getThreadMap("helloRoom");
						}else{
							for (int i = 0; i < FriendList.getSize(); i++) {
								if(FriendList.getFriendList(i).getMemberId()==message.getFromUser()){
									friend = FriendList.getFriendList(i);
								}
							}
							for (int i = 0; i < FriendList.getSize(); i++) {
								if(FriendList.getFriendList(i).getMemberId()==message.getToUser()){
									mySelf = FriendList.getFriendList(i);
								}
							}
							if(friend != null && mySelf != null){
								helloRoom = new HelloRoom(mySelf,friend);
								helloRoom.setVisible(true);
								ThreadMap.addThreadMap("helloRoom_"+friend.getMemberId(), helloRoom);
							}
						}
						if(helloRoom != null){
							helloRoom.showMessage(message);
						}
						break;
						
					case GROUPMESSAGE:
						GroupChat groupChat = (GroupChat) ThreadMap.getThreadMap("groupChat");
						groupChat.setJTextFIeld1Text(message);
						break;
					case FRIENDLOGIN:
					case REFRESH:
						FriendList.setFriendList((ArrayList)message.getObject());
						if(FriendList.getSize()>0){
							MainPanel.listModel((ArrayList<Member>)FriendList.getFriendListAll());
						}
						break;
					default:
						break;
					}
				}
			}
		}
		
	}

	public InputThread getIn() {
		return in;
	}

	public OutputThread getOut() {
		return out;
	}
	
	
}
