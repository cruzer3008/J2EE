import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",1999);
			FileReader f = new FileReader("/home/default/eclipse-workspace/12/Untitled.txt");
			BufferedReader reader = new BufferedReader(f);
			byte[] b = new byte[30];
			String k = reader.readLine();
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF(k);
			System.out.println("Transfer Complete");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
