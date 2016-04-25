/*
 * 这是与好友聊天的界面
 * 因为客户端要处于读取的状态，因此把它做成一个线程
 */
package hello.client.ui;

import hello.clientcore.ChatMap;
import hello.clientcore.Client;
import hello.common.Constants;
import hello.common.MyDate;
import hello.common.TranObject;
import hello.common.TranObjectType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class QqChat extends JFrame implements ActionListener {

	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	JScrollPane jsp;
	int ownerId;
	int friendId;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqChat qqChat=new QqChat(1,2);
		ChatMap.addChatMap("qqchat", qqChat);
		Client client= new Client(Constants.SERVER_IP, Constants.SERVER_PORT);
		client.start();
		ChatMap.addChatMap("client", client);
	}
	public QqChat(int ownerId,int friend)
	{
		this.ownerId=ownerId;
		this.friendId=friend;
		jta=new JTextArea();
		jtf=new JTextField(25);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp=new JPanel();
		jsp=new JScrollPane(jta);
		jp.add(jtf);
		jp.add(jb);
		
		this.setTitle(ownerId+"正在和"+friend+"聊天");
		this.add(jsp,"Center");
		this.add(jp,"South");
		this.setSize(400,300);
		this.setIconImage((new ImageIcon("image/头像.GIF").getImage()));
		this.setVisible(true);
		
	}
	//写一个方法，让它显示消息
	public void showMessage(TranObject message)
	{
		String info=message.getFromUser()+" 对 "+message.getToUser()+" 说： "+MyDate.getDate()+"\n"+message.getObject()+"\r\n";
		this.jta.append(info);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb)
		{
			//如果用户点击了发送按钮
			TranObject m=new TranObject();
			m.setType(TranObjectType.MESSAGE);
			m.setFromUser(this.ownerId);
			m.setToUser(this.friendId);
			m.setObject(jtf.getText());
			m.setSendTime(MyDate.getDate());
			//发送给服务器
			try {
				Client client = (Client) ChatMap.getChatMap("client");
				client.getOutputThread().setmessage(m);
				
			} catch (Exception b) {
				// TODO: handle exception
				b.printStackTrace();
			}
			String info1=m.getFromUser()+" 对 "+m.getToUser()+"  "+m.getSendTime()+"\n"+m.getObject()+"\r\n";
			this.jta.append(info1);
			this.jtf.setText("");
		}
	}
}
