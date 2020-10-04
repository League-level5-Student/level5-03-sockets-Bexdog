package _02_Chat_Application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ChatClient {
	public static void main(String [] args) throws UnknownHostException, IOException {
		 // String ip = "192.168.1.240";
		String ip = "192.168.1.227";
	      int pn = 8080;
	    boolean i = true;
	    Socket s;
	    DataOutputStream DOS;
	    DataInputStream DIS;
			s = new Socket(ip,pn);
			DOS = new DataOutputStream(s.getOutputStream());
			DIS = new DataInputStream(s.getInputStream());
		 while(i) {
	      try {
			String output = JOptionPane.showInputDialog("Message:");
	        DOS.writeUTF(output);
	         JOptionPane.showMessageDialog(null, "Server: "+DIS.readUTF());
	      }catch (IOException e) {
	  		e.printStackTrace();
	  		i = false;
	  	}
	   }
	}
}