package Homework2;

public class TextBook extends Book {
	
	public TextBook(String name, float cost) {
		super(name, cost);
	}

	
	
	public static void main(String[] args) {
		TextBook myBook = new TextBook("Java Programming", 100);
		System.out.println("Book name: " + myBook.getName());
		System.out.println("Book Cost: " + myBook.getCost());
	}

}
