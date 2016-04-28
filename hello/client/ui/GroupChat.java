/*
 * mainJFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package hello.client.ui;

import hello.client.clientcore.ClientThread;
import hello.client.clientcore.OutputThread;
import hello.client.clientcore.ThreadMap;
import hello.entity.Member;
import hello.entity.MyDate;
import hello.entity.TranObject;
import hello.entity.TranObjectType;

/**
 * 
 * @author __USER__
 */
public class GroupChat extends javax.swing.JFrame {
//	CopyOfsocket client = null;
	private Member member;
	
	
	

	public int getMemberId() {
		return member.getMemberId();

	}
	/** Creates new form mainJFrame */

	public GroupChat(Member member){
		this.member = member;
		initComponents();
	}

	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
		jPanel5 = new javax.swing.JPanel();
		txtinp = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextField1 = new javax.swing.JTextArea();
		jMenuBar1 = new javax.swing.JMenuBar();
		setTitle(member.getName()+"的群聊");
		jTextField1.setColumns(20);
		jTextField1.setRows(5);
		jScrollPane1.setViewportView(jTextField1);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(51, 51, 51));

		jPanel2.setBackground(new java.awt.Color(102, 102, 102));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 597,
				Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 17,
				Short.MAX_VALUE));

		jPanel4.setBackground(new java.awt.Color(204, 204, 204));

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 110,
				Short.MAX_VALUE));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 161,
				Short.MAX_VALUE));

		jPanel5.setBackground(new java.awt.Color(204, 204, 204));

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 110,
				Short.MAX_VALUE));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 128,
				Short.MAX_VALUE));

		txtinp.setBackground(new java.awt.Color(204, 204, 204));
		txtinp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtinpActionPerformed(evt);
			}
		});
		txtinp.addAncestorListener(new javax.swing.event.AncestorListener() {
			public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
			}

			public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
				txtinpAncestorAdded(evt);
			}

			public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
			}
		});

		

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel2,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																468,
																Short.MAX_VALUE)
														.addComponent(
																txtinp,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																468,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jPanel5,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jPanel4,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addComponent(
												jPanel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				248,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				txtinp,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				41,
																				Short.MAX_VALUE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jPanel4,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jPanel5,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(58, Short.MAX_VALUE)));

		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}// </editor-fold>
		// GEN-END:initComponents

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {

		// TODO add your handling code here:
	}

	private void txtinpActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if("".equals(txtinp.getText())){
			jTextField1.append("系统消息：发送内容不能为空。\n");
			return;
		}
		ClientThread clientThread = (ClientThread)ThreadMap.getThreadMap("clientThread");
		OutputThread out = clientThread.getOut();
		String str = txtinp.getText();//获得输入框的数据
		TranObject sendMessage = new TranObject();
		sendMessage.setObject(str);
		sendMessage.setType(TranObjectType.GROUPMESSAGE);
		sendMessage.setFromUser(member.getMemberId());
		sendMessage.setFromMember(member);
		sendMessage.setSendTime(MyDate.getDate());
		out.setmessage(sendMessage);//将数据发送到服务器
		jTextField1.append(member.getName()+" "+ sendMessage.getSendTime()+":\n"+str+"\n");
		txtinp.setText("");//清空输入框
	}

	private void txtinpAncestorAdded(javax.swing.event.AncestorEvent evt) {
		// TODO add your handling code here:

	}

	private void jLabel1AncestorAdded(javax.swing.event.AncestorEvent evt) {
		// TODO add your handling code here:

	}
	public void setJTextFIeld1Text(TranObject message){
		jTextField1.append(message.getFromMember().getName()+" "+ message.getSendTime()+":\n"+message.getObject()+"\n");//设置jTextField1的文本为原来的文本加上服务器发送的数据
	}



	/**
	 * @param args
	 *            the command line arguments
	 */


	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextField1;
	private javax.swing.JTextField txtinp;
	// End of variables declaration//GEN-END:variables

}