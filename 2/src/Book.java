import java.util.*;
public class Book implements Comparable<Book>{
	String title,author,publisher;
	Integer price;
	Book(String t, String a, String p, int pr){
		title = t;
		author = a;
		publisher = p;
		price = pr;
	}
	
	public int compareTo(Book b)
	{
		return price.compareTo(b.price);
	}
	
	public String toString()
	{
		return "Book title is: "+title+" written by "+author+" and published by "+publisher+" and is sold at a price of "+price; 
	}
	
	public static void main(String[] args) {
		ArrayList<Book> ab = new ArrayList<Book>();
		Book b1 = new Book("Java","Herbert","Penguin",1000);
		Book b2 = new Book("OS","Marsland","Arihant",1500);
		Book b3 = new Book("DBMS","Dhamdhere","McGrawHill",1700);
		Book b4 = new Book("OOADP","Shalloway","Pearson",1700);
		ab.add(b1);
		ab.add(b2);
		ab.add(b3);
		ab.add(b4);

		System.out.println("Books before sorting by price are");
		for(Book b:ab) {
			System.out.println(b);
		}
		
		ArrayList<Book> sortedab = new ArrayList<Book>();
		sortedab.addAll(ab);
		Collections.sort(sortedab);
		System.out.println("Books after sorting are");
		for(Book b:sortedab) {
			System.out.println(b);
		}
	}
}
