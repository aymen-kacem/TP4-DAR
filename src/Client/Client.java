package Client;

import java.net.DatagramSocket;
import java.io.IOException;
import java.net.DatagramPacket;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.InetSocketAddress;


public class Client {
  private static byte[] buffer =new byte[1024];
 private static int PORT=1234;
	public static void main(String[] args) throws IOException {
		  String username;
		DatagramSocket socket =new DatagramSocket();
		System.out.println("Demarrage de client");
		Scanner s=new Scanner(System.in);
		username=s.nextLine();
		DatagramPacket name=new DatagramPacket(username.getBytes(),
				username.length(),InetAddress.getByName("localhost"),PORT);
		socket.send(name);
		DatagramPacket packet=new DatagramPacket(buffer,buffer.length);
		socket.receive(packet);
		System.out.println("Server:"+new String(packet.getData(),0,packet.getLength()));
	

	}

}
