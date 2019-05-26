import java.util.Calendar;

public class MissedCallDetails {
	Calendar calObj;
	Long tel_num;
	String name;
	
	MissedCallDetails(Calendar cob,Long tn, String n){
		calObj = cob;
		tel_num = tn;
		name = n;
	}
	void display() {
		calObj.add(Calendar.DATE, 1);
		System.out.println("Current time is "+calObj.getTime());
		System.out.println("Telephone number is "+tel_num);
		System.out.println("Name is "+name);
	}
}
