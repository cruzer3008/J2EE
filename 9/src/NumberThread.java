import java.util.*;
public class NumberThread implements Runnable{
	HashMap<Integer,String> hm = new HashMap<> ();
	NumberThread(){
		hm.put(1,"One");
		hm.put(2,"Two");
		hm.put(3,"Three");
		hm.put(4,"Four");
		hm.put(5,"Five");
		hm.put(6,"Six");
		hm.put(7,"Seven");
		hm.put(8,"Eight");
		hm.put(9,"Nine");
		hm.put(0,"Zero");
	}
	public void run() {
		System.out.println("Enter a four digit number");
		@SuppressWarnings("resource")
		Scanner sc  = new Scanner(System.in);
		String num = sc.next();
		for(int i = 0 ; i<num.length();i++)
		{
			int digit = Integer.parseInt(""+num.charAt(i));
			System.out.println(digit+" : "+hm.get(digit));
		}
	}
	
}
