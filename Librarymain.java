package librarysystem;

import java.util.Scanner;

public class Librarymain {

	public static void main(String[] args) {
		
		LibraryManagement library = new LibraryManagement();
        library.welcomeMessage();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book\n2.Display Books\n3. Search Book\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author Name: ");
                        String author = scanner.nextLine();
                        library.addBook(new Book(title, author));
                        break;

                    case 2:
                        library.displayBooks();
                        break;

                    case 3:
                        System.out.print("Enter Book Title or Author to Search: ");
                        String search = scanner.nextLine();
                        library.searchBook(search);
                        break;

                    case 4:
                        System.out.println("Exiting... Thank you!");
                        scanner.close();
                        System.exit(0);

                    default:
                        throw new IllegalArgumentException("Invalid choice! Please enter a valid option.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    
	}
}
