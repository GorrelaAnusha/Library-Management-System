package librarysystem;

import java.util.ArrayList;

//Interface defining book operations
interface BookOperations 
{
 void addBook(Book book);
 void displayBooks();
}

//Abstract class defining a Library
abstract class Library 
{
 abstract void welcomeMessage();
}



public class Book {
	
	private String title;
	private String author;
	private int bookId;
	private  static int bookCount=0;
	
	public Book(String title,String author)
	{
		this.title=title;
		this.author=author;
		this.bookId=++bookCount;
	}
	
	 public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getBookId() {
        return bookId;
    }
    
    @Override
    public String toString()
    {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}


class LibraryManagement extends Library implements BookOperations {
 private ArrayList<Book> books = new ArrayList<>();

 // Implementing abstract method
 @Override
 void welcomeMessage() {
     System.out.println("Welcome to the Library Management System!");
 }

 // Implementing interface methods
 @Override
 public void addBook(Book book) {
     books.add(book);
     System.out.println("Book Added: " + book.getTitle());
 }

 @Override
 public void displayBooks() {
     if (books.isEmpty()) {
         System.out.println("No books available.");
     } else {
         books.forEach(System.out::println);  // Lambda Expression
     }
 }

 // Method Overloading - Search Book by title or author
 public void searchBook(String keyword) {
     books.stream()
          .filter(book -> book.getTitle().equalsIgnoreCase(keyword) || book.getAuthor().equalsIgnoreCase(keyword))
          .forEach(System.out::println);
 }
}

//Custom Exception for Book Not Found
class BookNotFoundException extends Exception {
 public BookNotFoundException(String message) {
     super(message);
 }
}


