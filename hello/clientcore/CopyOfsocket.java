package hello.clientcore;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class CopyOfsocket {
	public Socket socket = null;
	PrintWriter pw = null;

	public CopyOfsocket() {
		try {
			socket = new Socket("localhost", 7777);
			pw = new PrintWriter(socket.getOutputStream());//获得该socket输出流
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void socketDemo(String str) {//将从界面获得的数据发送到服务器
		// 控制台输入
		pw.println(str);
		pw.flush();

	}

}
