package hello.Servercore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class serverThread {
	public static List<Socket> ss = new ArrayList<Socket>();//存放没一个客户端的socket

	public static void main(String[] args) {
		try {
			
			ServerSocket server = new ServerSocket(7777);
			System.out.println("服务器登陆成功");
			while (true) {
				Socket socket = server.accept();// 等待接收客户端数据
				ss.add(socket);
				Thread thread = new Thread(new threadClient(socket));// 每一个客户端就有一个线程
				thread.start();
				System.out.println("1 ok!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class threadClient implements Runnable {
	private Socket socket1;

	public threadClient(Socket socket) {
		this.socket1 = socket;// 表示客户端的socket
		System.out.println(socket);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {
			System.out.println("连接成功");
			// 接受客户端信息

			br = new BufferedReader(new InputStreamReader(socket1.getInputStream()));//获得该socket的输入流
			String sclient = null;
			while (true) {
				if((sclient = br.readLine())!=null){//取出输入流的一行数据(客户端想服务器向服务端发送的数据)并判断是否为空
					System.out.println(br);
				// 显示客户端信息
				System.out.println("sclient:" + sclient);
				for (Socket socket : serverThread.ss) {//遍历已连接socke 
					PrintWriter pw = new PrintWriter(socket.getOutputStream());//获得该socket的输出流
					pw.println(sclient);//将取出来的数据保存到流里
					pw.flush();//提交
					//pw.close();
				}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
