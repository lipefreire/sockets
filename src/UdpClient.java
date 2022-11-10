import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JOptionPane;

public class UdpClient {
	public static void main(String[] args) {
		try {
			DatagramSocket clientSocket = new DatagramSocket();
			
			byte[] sendData = new byte[1024];
			InetAddress IpAddress = InetAddress.getByName("10.105.2.48");
			int port = 3000;
			
			while(true) {
				String sentence = JOptionPane.showInputDialog("Digite: ");
				sendData = sentence.getBytes();
				
				DatagramPacket sendPacket = new DatagramPacket(sendData, sentence.length(), IpAddress, port);
				clientSocket.send(sendPacket);
				
				if(sentence.equalsIgnoreCase("sair")) {
					break;
				}
			}
			clientSocket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
