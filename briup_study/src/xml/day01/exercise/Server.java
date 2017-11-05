package xml.day01.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.sql.rowset.spi.XmlReader;

import org.xml.sax.helpers.XMLReaderFactory;


public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket;
		Socket socket;
		try {
			serverSocket = new ServerSocket(11111);
			while (true) {
				socket = serverSocket.accept();
				new MyThread(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class MyThread extends Thread {
	private Socket socket;
	private BufferedReader br;
	private XmlReader parser;

	public MyThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str=null;
			while((str=br.readLine())!=null){
				System.out.println(str);
			}
			
//			parser=XMLReaderFactory.createXMLReader();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
