import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {
	public static void main(String[] args) {
		System.out.println("\nSERVIDOR INICIADO!");
		System.out.println("....................\n");
		
		try {
			DatagramSocket serverSocket = new DatagramSocket(3000);
			while(true) {
				byte[] receiveData = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);
				
				String sentence = new String(receivePacket.getData());
				
				if(sentence.substring(0, 4).equalsIgnoreCase("sair")) {
					break;
				}
				InetAddress IpAddress = receivePacket.getAddress();
				
				System.out.println("Recebido de " + IpAddress.getHostAddress() + ": " + sentence.trim());
			}
			serverSocket.close();
			System.out.println("-----------------");
			System.out.println("Servidor Finalizado.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
