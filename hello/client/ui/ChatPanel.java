/*
 * ChatPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package hello.client.ui;

/**
 *
 * @author  __USER__
 */
public class ChatPanel extends javax.swing.JFrame {

	/** Creates new form ChatPanel */
	public ChatPanel() {
		initComponents();
		setDefaultCloseOperation(ChatPanel.DISPOSE_ON_CLOSE);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		pnlChat = new javax.swing.JPanel();
		pnlMainChat = new javax.swing.JPanel();
		LbeShowName = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		
		javax.swing.GroupLayout pnlMainChatLayout = new javax.swing.GroupLayout(
				pnlMainChat);
		pnlMainChat.setLayout(pnlMainChatLayout);
		pnlMainChatLayout.setHorizontalGroup(pnlMainChatLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						pnlMainChatLayout.createSequentialGroup()
								.addContainerGap(233, Short.MAX_VALUE)
								.addComponent(LbeShowName)
								.addGap(126, 126, 126)));
		pnlMainChatLayout.setVerticalGroup(pnlMainChatLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						pnlMainChatLayout.createSequentialGroup()
								.addGap(70, 70, 70).addComponent(LbeShowName)
								.addContainerGap(213, Short.MAX_VALUE)));

		javax.swing.GroupLayout pnlChatLayout = new javax.swing.GroupLayout(
				pnlChat);
		pnlChat.setLayout(pnlChatLayout);
		pnlChatLayout.setHorizontalGroup(pnlChatLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				pnlMainChat, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		pnlChatLayout.setVerticalGroup(pnlChatLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				pnlMainChat, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				pnlChat, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				pnlChat, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ChatPanel().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel LbeShowName;
	private javax.swing.JPanel pnlChat;
	private javax.swing.JPanel pnlMainChat;
	// End of variables declaration//GEN-END:variables

}