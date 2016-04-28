package hello.client.ui;

import hello.client.clientcore.ClientThread;
import hello.client.clientcore.OutputThread;
import hello.client.clientcore.ThreadMap;
import hello.entity.Member;
import hello.entity.MyDate;
import hello.entity.TranObject;
import hello.entity.TranObjectType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class HelloRoom extends JFrame implements ActionListener {
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	JScrollPane jsp;
	Member myself;
	Member toMember;
	String ownerId;
	String friendId;

	public HelloRoom(Member myself, Member toMember)
	{
		this.myself = myself;
		this.toMember = toMember;
		this.ownerId=""+myself.getMemberId();
		this.friendId=""+toMember.getMemberId();
		jta=new JTextArea();
		jtf=new JTextField(25);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp=new JPanel();
		jsp=new JScrollPane(jta);
		jp.add(jtf);
		jp.add(jb);
		
		this.setTitle(myself.getName()+"正在和"+toMember.getName()+"聊天");
		this.add(jsp,"Center");
		this.add(jp,"South");
		this.setSize(400,300);
		this.setIconImage((new ImageIcon("image/头像.GIF").getImage()));
		this.setVisible(true);
	}
	
	 
	
	//写一个方法，让它显示消息
	public void showMessage(TranObject m)
	{
		String info=toMember.getName()+" 说： "+m.getSendTime()+"\n"+m.getObject()+"\r\n";
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
			m.setFromUser(myself.getMemberId());
			m.setToUser(toMember.getMemberId());
			m.setObject(jtf.getText());
			m.setSendTime(MyDate.getDate());
			ClientThread clientThread = (ClientThread)ThreadMap.getThreadMap("clientThread");
			OutputThread out = clientThread.getOut();
			out.setmessage(m);//将数据发送到服务器
			
			String info1=myself.getName()+" 说：  "+m.getSendTime()+"\n"+m.getObject()+"\r\n";
			this.jta.append(info1);
			this.jtf.setText("");
		}
	}
}