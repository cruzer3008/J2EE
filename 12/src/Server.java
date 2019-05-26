import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1999);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String k = dis.readUTF();
			System.out.println("File transfered");
			FileOutputStream fos = new FileOutputStream("/home/default/eclipse-workspace/12/Untitled.txt");
			byte[] b = k.getBytes();
			fos.write(b);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
