package _02_Chat_Application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ChatClient {
	public static void main(String [] args) throws UnknownHostException, IOException {
		  String ip = "192.168.1.240";
	      //2. Create an integer for the server's port number
	      int pn = 8080;
	      //3. Surround steps 4-9 in a try-catch block that catches any IOExceptions.
	    boolean i = true;
	    Socket s;
		
	    DataOutputStream DOS;
	    DataInputStream DIS;
		
			s = new Socket(ip,pn);
			DOS = new DataOutputStream(s.getOutputStream());
			DIS = new DataInputStream(s.getInputStream());
		
	   
	    	 //4. Create an object of the Socket class. When initializing the object, pass in the ip address and the port number
	    while(i) {
	      try {
			String output = JOptionPane.showInputDialog("Message:");
	        DOS.writeUTF(output);
	         //8. Use the DataInputStream object to print a message from the server using the readUTF() method.
	         JOptionPane.showMessageDialog(null, "Server: "+DIS.readUTF());
	         //9. Close the client's server object
	         s.close();
	      }catch (IOException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  		i = false;
	  	}
	   }
	}
}