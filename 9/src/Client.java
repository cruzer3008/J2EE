
public class Client{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberThread nt = new NumberThread();
		VowelThread vt = new VowelThread();
		
		Thread t1 = new Thread(nt);
		Thread t2 = new Thread(vt);
		
		t1.start();
		try {
			t1.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}

}
