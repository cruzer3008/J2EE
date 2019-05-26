import java.util.Calendar;
import java.util.LinkedList;
import java.util.Scanner;

public class RecordManageMissedCall {
	static LinkedList<MissedCallDetails> amiss;
	static Scanner sc = new Scanner(System.in);
	static void HandleMissedCallActivities() {
		amiss = new LinkedList<MissedCallDetails>();
		while(true) {
			System.out.println("Enter a choice");
			System.out.println("Enter 1 to Add Missed Call\nEnter 2 to Display and delete on request\nEnter 3 to delete based on number\nEnter 4 to Print");
			int choice = sc.nextInt();
			switch(choice) {
			case 1://Add a missed call
				Calendar inst = Calendar.getInstance();
				Long num;
				String name;
				System.out.println("Enter the telephone number");
				num = sc.nextLong();
				if(DataBaseCallers.hm.containsKey(num)){
					name = DataBaseCallers.hm.get(num);
				}
				else {
					name = "Private Caller";
				}
				MissedCallDetails mcd = new MissedCallDetails(inst,num,name);
				if(amiss.size()==10) {
					amiss.removeLast();
				}
				amiss.addFirst(mcd);
			case 2:
				
			}
		}
	}
}
