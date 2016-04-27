package hello.server.Servercore;


import java.net.Socket;



public class SocketTask implements Runnable{
	private Socket socket = null;
	private InputThread in;
	private OutputThread out;
	private OutputThreadMap map;

	
	public SocketTask(Socket socket) {
		this.socket = socket;
		map = OutputThreadMap.getInstance();
	}

	@Override
	public void run() {
		out = new OutputThread(socket , map);
		in = new InputThread(socket, out, map);
		out.setStart(true);
		out.setPriority(6);
		in.setStart(true);
		out.start();
		in.start();

		
	}
	
}
