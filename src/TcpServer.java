import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) {
		try {
			System.out.println("--------------------------");
			System.out.println(":: SERVIDOR INICIADO ::");
			System.out.println("-------------------------");
			
			int port = 2500;
			ServerSocket socketServidor = new ServerSocket(port);
			Socket socketClient = socketServidor.accept();
			
			PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
			
			String entrada;
			
			while((entrada = in.readLine()) != null) {
				System.out.println("Recebido do cliente: " + entrada);
				out.println(entrada.toUpperCase());
				
				if(entrada.equalsIgnoreCase("sair")) break;
			}
			out.close();
			in.close();
			socketClient.close();
			socketServidor.close();
			
			System.out.println("\nCliente digitou SAIR....");
			System.out.println("___________________________");
			System.out.println("Servidor TCP finalizado.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
