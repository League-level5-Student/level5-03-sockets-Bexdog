package _02_Chat_Application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import javax.swing.JOptionPane;

import _01_Intro_To_Sockets.server.ServerGreeter;

public class ChatServer {
	ServerSocket ss;
	public ChatServer() {
			try {
				ss = new ServerSocket(8080);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void run() throws IOException {
			boolean b = true;
			System.out.println("*robotic voice*\nWaiting for client to connect");
			Socket sc= ss.accept();
			DataInputStream dis = new DataInputStream(sc.getInputStream());
			DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
				while(b) {					
						System.out.println("The client has connected");
						JOptionPane.showMessageDialog(null, "Client: "+dis.readUTF());	
						String output = JOptionPane.showInputDialog("Message:");
					dos.writeUTF(output);					
				}
		}
		public static void main(String[] args) {
			Thread i = new Thread(()-> {
				try {
					ChatServer sg = new ChatServer();
					sg.run();
				} catch(IOException e1){
					e1.printStackTrace();
				}
			});
			i.start();
		}
	}