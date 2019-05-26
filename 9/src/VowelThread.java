import java.util.*;
public class VowelThread implements Runnable{
	ArrayList<Character> vowel = new ArrayList<>();
	VowelThread(){
		vowel.add('a');
		vowel.add('e');
		vowel.add('i');
		vowel.add('o');
		vowel.add('u');
		vowel.add('A');
		vowel.add('E');
		vowel.add('I');
		vowel.add('O');
		vowel.add('U');
	}
	public void run() {
		System.out.println("Enter a word");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String Oldword = sc.nextLine();
		String word = Oldword.replaceAll(" ","");
		int c=0,v=0;
		for(int i=0;i<word.length();i++)
		{
			char ch = word.charAt(i);
			if(vowel.contains(ch)) {
				v++;
			}
			else{
				c++;
			}
		}	
		System.out.println("Vowels: "+v);
		System.out.println("Consonants: "+c);
	}
	
}
