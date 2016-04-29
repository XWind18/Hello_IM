package hello.server.Servercore;

import hello.entity.Constants;
import hello.entity.MyDate;
import hello.server.ui.ServerFrame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Server {
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private ExecutorService executorService = null;
	private boolean isStarted = true;//是否循环等待  

	
	public Server (){
		try {
			executorService = Executors.newFixedThreadPool(50);
			serverSocket = new ServerSocket(Constants.SERVER_PORT);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			quit(); 
		}
	}

	public void start() {
		try {
			while(isStarted){
				socket = serverSocket.accept();
				String ip =  socket.getInetAddress().toString();
				String conMessage = MyDate.getDateCN()+"用户："+ ip +"已建立连接.\n";
				ServerFrame serverFrame = (ServerFrame)ThreadMap.getThreadMap("serverFrame");
				serverFrame.showMessage(conMessage);
				if(socket.isConnected()){
					executorService.execute(new SocketTask(socket));
				}
			}
			if(socket != null){
				socket.close();
			}
			if(serverSocket != null){
				serverSocket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isStarted = false;
		}
	}
	public void quit(){
		try {
			this.isStarted = false;
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
