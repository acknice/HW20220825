import java.util.ArrayList;

public class Library 
{
	static String openingHours = "9 AM to 5 PM daily";
	String address;
	ArrayList<Object> availableBooks = new ArrayList<Object>();
	
	public Library(String address) 
	{
		this.address = address;
	}
	
	static void printOpeningHours() 
	{
		System.out.println(openingHours);
	}
	
	public void printAddress() 
	{
		System.out.println(this.address);
	}
	
	public void addBook(Book newBook) 
	{
		this.availableBooks.add(newBook);
	}
	
	public void printAvailableBooks()
	{
		if (this.availableBooks.isEmpty() == true) System.out.println("No books in our catalog.");
		else for (int i = 0; i < this.availableBooks.size(); i++)
		{
			Book isAvailable = (Book)this.availableBooks.get(i);
			if (isAvailable.borrowed != true) System.out.println(isAvailable.title);		
		}
	}
	
	public void borrowBook(String request) 
	{
		Book requestedBook = null;
		for (int i = 0; i < this.availableBooks.size(); i++)
		{
			Book inCollection = (Book)this.availableBooks.get(i);
			if (request.equals(inCollection.title))
			{
				requestedBook = inCollection;
				continue;
			}
		}
		if (requestedBook == null) 
		{
			System.out.println("Sorry, this book is not in our catalog.");
		}
		else
		{
			if (requestedBook.isBorrowed() == true)
			{
				System.out.println("Sorry, this book is already borrowed.");
			}
			else 
			{
				System.out.println("You successfully borrowed " + request);
				requestedBook.borrowed();
			}
		}
	}
		
		
	public void returnBook(String dropOff) 
	{
		Book droppedBook = null;
		for (int i = 0; i < this.availableBooks.size(); i++)
		{
			Book inCollection = (Book)this.availableBooks.get(i);
			if (dropOff.equals(inCollection.title))
			{
				droppedBook = inCollection;
				continue;
			}
		}
		if (droppedBook.isBorrowed() == true)
		{
			System.out.println("You successfully returned " + dropOff);
			droppedBook.returned();	
		}
		else System.out.println("Sorry, this book doesn't belong to us.");
	}	
	
	public static void main(String[] args) 
	{
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

      
        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
        
        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
        
        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();
        
        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();
  
        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();
  
        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    	
    }
    
} 

