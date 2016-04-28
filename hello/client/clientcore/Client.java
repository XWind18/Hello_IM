package hello.client.clientcore;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
	private Socket socket;
	private ClientThread clientThread;
	private String ip;
	private int port;
	public Client(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	public boolean start(){
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(ip,port),3000);
			//判断是否有连接  如果有连接就新建一个线程，将线程加入ThreadMap 启动线程
			if(socket.isConnected()){
				clientThread = new ClientThread(socket);
				ThreadMap.addThreadMap("clientThread", clientThread);
				clientThread.setStart(true);
				clientThread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public InputThread getInputThread(){
		return clientThread.getIn();
	}
	public OutputThread getOutputThread(){
		return clientThread.getOut();
	}
	public void setIstart (boolean isStart){
		clientThread.getIn().setStart(isStart);
		clientThread.getOut().setStart(isStart);
	}
}
