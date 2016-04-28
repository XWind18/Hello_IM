package hello.client.clientcore;

import hello.client.ui.ForgetPwd;
import hello.client.ui.GroupChat;
import hello.client.ui.HelloRoom;
import hello.client.ui.LoginFrame;
import hello.client.ui.MainPanel;
import hello.client.ui.RegisterFrame;
import hello.entity.Member;
import hello.entity.TranObject;
import hello.entity.TranObjectType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class InputThread extends Thread{
	private Socket socket;
	private ObjectInputStream ois;
	private TranObject message;
	private boolean isStart;
	private boolean messageLin = false;
	private Member myself;

	public boolean isMessageLin() {
		return messageLin;
	}

	public void setMessageLin(boolean messageLin) {
		this.messageLin = messageLin;
	}

	public InputThread(Socket socket) {
		this.socket = socket;
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
	public TranObject getMessage() {
		TranObject message = this.message;
		synchronized (this) {
			notify();
		}
		return message;
	}

	@Override
	public void run() {

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
		TranObject message = (TranObject) ois.readObject();
		System.out.println(message);
		switch(message.getType()){
		case REGISTER:
			RegisterFrame RegisterFrame = new RegisterFrame();
			RegisterFrame = (RegisterFrame)ThreadMap.getThreadMap("RegisterFrame");
			if("rbid".equals(message.getCmd())){
				RegisterFrame.setRbidTxt((String) message.getObject());
			}else if("txts".equals(message.getCmd())) {
				RegisterFrame.setTxtstxt((String) message.getObject());
			}
			
			break;
		case LOGIN:
			LoginFrame loginFrame = (LoginFrame)ThreadMap.getThreadMap("loginFrame");
			loginFrame.setRbpwdTxt("");
			loginFrame.setRbidTxt("");
			if("true".equals(message.getCmd())){
				//  登录成功
				loginFrame.dispose();
				//新建主窗口
				myself = (Member)message.getObject();
				MainPanel mainpanel = new MainPanel(myself);//新建好友列表页面
				mainpanel.setVisible(true);
				ThreadMap.addThreadMap("mainpanel", mainpanel);
				getFriendList();
			}else if("rbpwd".equals(message.getCmd())){
				loginFrame.setRbpwdTxt("密码错误");
			}else {
				loginFrame.setRbidTxt("账号不存在");
			}
			break;
			
		case FORGETPWD:
			ForgetPwd forgetPwd = (ForgetPwd)ThreadMap.getThreadMap("fotgetPwd");
			forgetPwd.setJxgTxt((String) message.getObject());
			break;
		case MESSAGE:
			HelloRoom helloRoom = null;
			Member friend = null;
			Member mySelf = null;
			if(ThreadMap.getThreadMap("helloRoom_"+message.getFromUser()) != null){
				helloRoom = (HelloRoom)ThreadMap.getThreadMap("helloRoom_"+message.getFromUser());
				if(!helloRoom.isVisible()){
					helloRoom.setVisible(true);
				}
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
			GroupChat groupChat = null;
			if(ThreadMap.getThreadMap("groupChat") != null){
				groupChat = (GroupChat) ThreadMap.getThreadMap("groupChat");
				if(!groupChat.isVisible()){
					groupChat.setVisible(true);
				}
			}else{
				groupChat = new GroupChat(myself);
				groupChat.setVisible(true);
				ThreadMap.addThreadMap("groupChat", groupChat);
			}
			if(groupChat != null){
				groupChat.setJTextFIeld1Text(message);
			}
			break;
		case FRIENDLOGIN:
			for (int i = 0; i < FriendList.getSize(); i++) {
				if(FriendList.getFriendList(i).equals((Member)message.getObject())){
					break;
				}
			}
				
			FriendList.addFriendList((Member) message.getObject());
			MainPanel.listModel((ArrayList<Member>)FriendList.getFriendListAll());
			break;
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
	public void getFriendList(){
		TranObject getOnlineFriend = new TranObject();
		getOnlineFriend.setType(TranObjectType.REFRESH); 
		ClientThread clientThread = (ClientThread)ThreadMap.getThreadMap("clientThread");
		clientThread.getOut().setmessage(getOnlineFriend);		
	}
}
