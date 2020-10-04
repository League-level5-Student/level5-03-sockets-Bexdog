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
		
			//2. Initialize the ServerSocket object. In the parameters,
			//   you must define the port at which the server will listen for connections.
			try {
				ss = new ServerSocket(8080);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//*OPTIONAL* you can set a time limit for the server to wait by using the 
			//  ServerSocket's setSoTimeout(int timeInMilliSeconds) method
		}
//Ok this is fine
		public void run() throws IOException {
			//3. Create a boolean variable and initialize it to true.
			boolean b = true;
			//4. Make a while loop that continues looping as long as the boolean created in the previous step is true.
			System.out.println("*robotic voice*\nWaiting for client to connect");
			Socket sc= ss.accept();
			DataInputStream dis = new DataInputStream(sc.getInputStream());
			DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
				while(b) {
					try {
						System.out.println("The client has connected");
						JOptionPane.showMessageDialog(null, "Client: "+dis.readUTF());	
						String output = JOptionPane.showInputDialog("Message:");
					dos.writeUTF(output);
					}
					catch(SocketTimeoutException e) {
						System.out.println("Error Error Error Error\nsocket timeout exception");
						b = false;
					}
					catch(IOException e) {
						System.out.println("Error Error Error Error\nIO Exception");
						b = false;
					}
					
				}
		}

		public static void main(String[] args) {
			//16. In a new thread, create an object of the ServerGreeter class and start the thread. Don't forget the try-catch.
			Thread i = new Thread(()-> {
				try {
					ServerGreeter sg = new ServerGreeter();
					sg.run();
				} catch(IOException e1){
					e1.printStackTrace();
				}
			});
			i.start();
		}
	}