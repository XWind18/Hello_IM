/*
 * 注册界面.java
 *
 * Created on __DATE__, __TIME__
 */

package hello.client.ui;

import hello.client.clientcore.ChatMap;
import hello.client.clientcore.Client;
import hello.client.clientcore.ThreadMap;
import hello.entity.Member;
import hello.entity.TranObject;
import hello.entity.TranObjectType;
import hello.server.dao.手机dao;
import hello.server.dao.注册dao;

/**
 *
 * @author  __USER__
 */
public class RegisterFrame extends javax.swing.JFrame {

	/** Creates new form 注册界面 */
	public RegisterFrame() {
		initComponents();
	}
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		txtname = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		txtpwd = new javax.swing.JPasswordField();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		txtage = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		rbboy = new javax.swing.JRadioButton();
		rbgirl = new javax.swing.JRadioButton();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		txtid = new javax.swing.JTextField();
		javax.swing.JLabel lblTip = new javax.swing.JLabel();
		rbid = new javax.swing.JLabel();
		rbpwd = new javax.swing.JLabel();
		txts = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		txtnewpwd = new javax.swing.JPasswordField();
		jButton3 = new javax.swing.JButton();
		buttonGroup1.add(rbboy);
		buttonGroup1.add(rbgirl);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("\u7528\u6237\u540d");

		jLabel2.setText("\u5bc6\u7801");

		jLabel3.setText("\u786e\u8ba4\u5bc6\u7801");

		jLabel4.setText("\u5e74\u9f84");

		jButton1.setText("\u63d0\u4ea4");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		rbboy.setSelected(true);
		rbboy.setText("\u7537");
		rbboy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				rbboyActionPerformed(evt);
			}
		});

		rbgirl.setText("\u5973");
		rbgirl.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				rbgirlActionPerformed(evt);
			}
		});

		jLabel5.setText("\u6027\u522b");

		jLabel6.setText("\u624b\u673a\u53f7");

		txtid.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtidActionPerformed(evt);
			}
		});

		jButton2.setText("\u91cd\u65b0\u8f93\u5165");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("\u8fd4\u56de\u767b\u5f55\u754c\u9762");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout
										.createSequentialGroup()
										.addGap(52, 52, 52)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel1)
														.addComponent(jLabel6)
														.addComponent(jLabel2)
														.addComponent(jLabel3)
														.addComponent(jLabel4)
														.addComponent(jLabel5))
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								txtage,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								112,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												rbboy)
																										.addGap(18,
																												18,
																												18)
																										.addComponent(
																												rbgirl)
																										.addGap(20,
																												20,
																												20))
																						.addComponent(
																								txtnewpwd,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								114,
																								Short.MAX_VALUE)))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(20,
																				20,
																				20)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								txtpwd,
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								txtname,
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								txtid,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								112,
																								Short.MAX_VALUE))))
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				8,
																				Short.MAX_VALUE)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGap(42,
																												42,
																												42)
																										.addComponent(
																												rbid,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGap(35,
																												35,
																												35)
																										.addComponent(
																												rbpwd,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												144,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				51,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblTip))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				txts,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				146,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap())
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(69, 69, 69)
										.addComponent(jButton1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jButton2)
										.addGap(261, 261, 261))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout.createSequentialGroup()
										.addContainerGap(314, Short.MAX_VALUE)
										.addComponent(jButton3)
										.addGap(61, 61, 61)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel6)
																						.addComponent(
																								txtid,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel1)
																						.addComponent(
																								txtname,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(24,
																				24,
																				24)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel2)
																						.addComponent(
																								txtpwd,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(26,
																				26,
																				26)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE,
																								false)
																						.addComponent(
																								lblTip)
																						.addComponent(
																								jLabel3)
																						.addComponent(
																								txtnewpwd,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				rbid,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				21,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				rbpwd,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				20,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(29,
																				29,
																				29)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								txtage,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(5,
																				5,
																				5)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel5)
																						.addComponent(
																								rbboy)
																						.addComponent(
																								rbgirl))
																		.addGap(28,
																				28,
																				28)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jButton1,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								23,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(51,
																				51,
																				51))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(35,
																				35,
																				35)
																		.addComponent(
																				txts,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				16,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				96,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButton3)
																		.addGap(9,
																				9,
																				9)))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));

		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		this.dispose();
		LoginFrame loginFrame = (LoginFrame)ThreadMap.getThreadMap("loginFrame");
		loginFrame.setVisible(true);

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		this.txtage.setText("");
		this.txtid.setText("");
		this.txtname.setText("");
		this.txtnewpwd.setText("");
		this.txtpwd.setText("");
	}

	private void txtidActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		//		手机号
		//		手机号正则表达式  ^1[3|4|5|8][0-9]\d{8}$ ;

	}

	private void rbgirlActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	void rbboyActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		//		提交
		//		String pwd1 = this.txtpwd.getText();
		//		String pwd2 = this.txtnewpwd.getText();
		//		
		//		if (!pwd1.equals(pwd2)) {
		//			this.lblTip.setText("两次密码不一致");
		//
		//		} else {
		//
		//		}
		Member member = new Member();
		this.rbid.setText("");
		this.rbpwd.setText("");
		this.txts.setText("");
		
		try {
			String name = null;
			String pwd = null;
			String newpwd = null;
			String phone = null;
			int age = 0;
			String sex = null;
			if (this.rbboy.isSelected()) {
				sex = "男";
			} else {
				sex = "女";
			}
			name = this.txtname.getText().toString();
			pwd = this.txtpwd.getText().toString();
			newpwd = this.txtnewpwd.getText().toString();
			if(this.txtage.getText() != null || this.txtage.getText() != ""){
				age = Integer.parseInt(this.txtage.getText());
			}
			phone = this.txtid.getText().toString();
			if (pwd.equals(newpwd)) {	
				member.setLoginPwd(pwd);	
			} else {
				this.rbpwd.setText("两次密码不一样");
				pwd = null;
				return;
			}
			注册dao dao = new 注册dao();
			手机dao da = new 手机dao();
			boolean sh = da.shouji(phone);
			String ti2 = sh ? "" : "手机号码出错";
			if (sh) {
				member.setPhone(phone);
			} else {
				this.rbid.setText(ti2);
				phone = null;
				return;
			}
			member.setSex(sex);
			member.setName(name);
			member.setAge(age);
			
			TranObject sendObject = new TranObject();
			sendObject.setType(TranObjectType.REGISTER);
			sendObject.setObject(member);
			
			Client client = (Client)ChatMap.getChatMap("client");
			client.getOutputThread().setmessage(sendObject);

			
//			boolean saveFlag = dao.inSert(name, pwd, sex, age, phone);
//			if (saveFlag) {
//				this.txts.setText("注册成功");
////				new 登录界面().setVisible(true);
////				this.dispose();
//			} else {
//				this.txts.setText("注册失败");
//
//			}
		} catch (Exception e) {
			// TODO: handle exception
//			System.out.println("注册失败");
			e.printStackTrace();

		}
	}

	/**
	 * @param args the command line arguments
	 */
//	public static void main(String args[]) {
//		java.awt.EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				new 注册界面().setVisible(true);
//			}
//		});
//	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JRadioButton rbboy;
	private javax.swing.JRadioButton rbgirl;
	private javax.swing.JLabel rbid;
	private javax.swing.JLabel rbpwd;
	private javax.swing.JTextField txtage;
	private javax.swing.JTextField txtid;
	private javax.swing.JTextField txtname;
	private javax.swing.JPasswordField txtnewpwd;
	private javax.swing.JPasswordField txtpwd;
	private javax.swing.JLabel txts;
	// End of variables declaration//GEN-END:variables
	public void setRbidTxt(String str) {
		this.rbid.setText(str);
	}

	public void setRbpwdTxt(String str) {
		this.rbpwd.setText(str);
	}
	public void setTxtstxt (String str){
		this.txts.setText(str);
	}
}