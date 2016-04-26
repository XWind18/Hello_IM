/*
 * MainPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package hello.client.ui;

import hello.clientcore.ThreadMap;
import hello.dao.ShowMemberDao;
import hello.entity.Member;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;

//import com.hello.Dao.ShowMemberDao;
//import com.hello.Dao.User;

/**
 *
 * @author  __USER__
 */
public class MainPanel extends javax.swing.JFrame {
	static String strings[] = new String[50];
	private Member mySelf;

	/** Creates new form MainPanel */
	public MainPanel(Member logMember) {

		initComponents();
		mySelf = logMember;
		mySelf(mySelf.getName());
	}

	public static void listModel(ArrayList<Member> list) {
		strings = new ShowMemberDao().ShowMemberNameArray(list);
		listShowMember.setModel(new javax.swing.AbstractListModel() {
			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
	}



	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		PnlTop = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		pnlMySelf = new javax.swing.JPanel();
		labMyself = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		listShowMember = new javax.swing.JList();
		BtnGroup = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel1.setText("Hello");

		javax.swing.GroupLayout PnlTopLayout = new javax.swing.GroupLayout(
				PnlTop);
		PnlTop.setLayout(PnlTopLayout);
		PnlTopLayout.setHorizontalGroup(PnlTopLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				PnlTopLayout
						.createSequentialGroup()
						.addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 97,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(163, Short.MAX_VALUE)));
		PnlTopLayout.setVerticalGroup(PnlTopLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42,
				Short.MAX_VALUE));

		pnlMySelf.setBackground(new java.awt.Color(153, 153, 153));

		labMyself.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		labMyself.setText("jLabel2");

		javax.swing.GroupLayout pnlMySelfLayout = new javax.swing.GroupLayout(
				pnlMySelf);
		pnlMySelf.setLayout(pnlMySelfLayout);
		pnlMySelfLayout.setHorizontalGroup(pnlMySelfLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				pnlMySelfLayout
						.createSequentialGroup()
						.addComponent(labMyself,
								javax.swing.GroupLayout.PREFERRED_SIZE, 82,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(178, Short.MAX_VALUE)));
		pnlMySelfLayout.setVerticalGroup(pnlMySelfLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				pnlMySelfLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(labMyself,
								javax.swing.GroupLayout.DEFAULT_SIZE, 40,
								Short.MAX_VALUE)));

		jScrollPane1.setBackground(new java.awt.Color(102, 102, 102));

		listShowMember.setBackground(new java.awt.Color(102, 102, 102));
		listShowMember.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		listShowMember.setForeground(new java.awt.Color(255, 255, 255));
		listShowMember.setModel(new javax.swing.AbstractListModel() {

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		listShowMember.setSelectionBackground(new java.awt.Color(51, 51, 51));
		listShowMember.setSelectionForeground(new java.awt.Color(0, 153, 204));
		listShowMember.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				listShowMemberMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(listShowMember);

		BtnGroup.setText("\u7fa4\u804a\u5927\u5385");
		BtnGroup.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BtnGroupActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1,
						javax.swing.GroupLayout.DEFAULT_SIZE, 260,
						Short.MAX_VALUE)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel3Layout.createSequentialGroup().addContainerGap()
								.addComponent(BtnGroup)));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												322,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(BtnGroup)
										.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(PnlTop, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(pnlMySelf, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(PnlTop,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pnlMySelf,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel3,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents
	//群聊

	private void BtnGroupActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		GroupChat groupChat = new GroupChat();
		groupChat.setVisible(true);
		ThreadMap.addThreadMap("groupChat", groupChat);

	}

	private void listShowMemberMouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			Member friend = new Member();
			Object listValue = ((JList) e.getSource()).getSelectedValue();
			int friendID = Integer.parseInt(listValue.toString().split(" ")[0]);
			friend.setMemberId(friendID);
			new ChatPanel().setVisible(true);
		}
	}

	public static void mySelf(String name) {
		Member mySelf = new Member();
		mySelf.setName(name);
		labMyself.setText(mySelf.getName());
	}

	/**
	 * @param args the command line arguments
	 */
//	public static void main(String args[]) {
//		java.awt.EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				new MainPanel(member).setVisible(true);
//				//			listModel(FriendList.getFriendListAll());
//				//			init();
//			}
//		});
//	}

	private javax.swing.JPanel PnlTop;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private static javax.swing.JLabel labMyself;
	private static javax.swing.JList listShowMember;
	private javax.swing.JPanel pnlMySelf;
	private JButton BtnGroup;

}