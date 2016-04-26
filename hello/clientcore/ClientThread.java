package hello.clientcore;

import hello.Servercore.FriendList;
import hello.client.ui.GroupChat;
import hello.client.ui.MainPanel;
import hello.client.ui.QqChat;
import hello.client.ui.找回密码;
import hello.client.ui.注册界面;
import hello.client.ui.登录界面;
import hello.common.TranObject;

import java.net.Socket;

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
		in.start();
		out.start();
		while(isStart){
			if(in.isMessageLin()){
				TranObject message = in.getMessage();
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
						System.out.println(message.getCmd());
						if("true".equals(message.getCmd())){
							//  登录成功
							System.out.println(2);
							loginFrame.dispose();
							MainPanel mainpanel = new MainPanel();//新建好友列表页面
							
							
							
						}else if("rbpwd".equals(message.getCmd())){
							loginFrame.setRbpwdTxt("密码错误");
							System.out.println(3);
						}else {
							loginFrame.setRbidTxt("账号不存在");
							System.out.println(4);
						}
						break;
						
					case FORGETPWD:
						找回密码 forgetPwd = (找回密码)ThreadMap.getThreadMap("fotgetPwd");
						forgetPwd.setJxgTxt((String) message.getObject());
						break;
					case MESSAGE:
						
						QqChat qqChat = (QqChat) ChatMap.getChatMap("qqchat");
						
						qqChat.showMessage(message);
						break;
						
					case GROUPMESSAGE:
						GroupChat groupChat = (GroupChat) ThreadMap.getThreadMap("groupChat");
						String txt = "" + message.getFromMember().getName()+"\n"+message.getObject()+"\n";
						groupChat.setJTextFIeld1Text(txt);
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