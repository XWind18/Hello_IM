package hello.client.clientcore;

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
		in.setPriority(7);
		in.start();
		out.start();
		
		
	}

	public InputThread getIn() {
		return in;
	}

	public OutputThread getOut() {
		return out;
	}
	
	
}
