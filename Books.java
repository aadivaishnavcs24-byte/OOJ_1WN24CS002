import java.util.Scanner;

class Book {
    String name;
    String author;
    double price;
    int numPages;

    Book(String name, String author, double price, int numPages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }

    void setDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter author name: ");
        this.author = scanner.nextLine();
        System.out.print("Enter price: ");
        this.price = scanner.nextDouble();
        System.out.print("Enter number of pages: ");
        this.numPages = scanner.nextInt();
        scanner.nextLine();  // consume leftover newline
    } // ✅ ← Missing this closing brace!

    void getDetails() {
        System.out.println("Book Name: " + name);
        System.out.println("Author: " + author);
        System.out.println("Price: Rs " + price);
        System.out.println("Number of Pages: " + numPages);
    }

    public String toString() {
        return "Book Details:\n" +
                "Name: " + name + "\n" +
                "Author: " + author + "\n" +
                "Price: Rs " + price + "\n" +
                "Number of Pages: " + numPages;
    }
}

class Books {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of books: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Book " + (i + 1) + ":");
            books[i] = new Book("", "", 0.0, 0);
            books[i].setDetails();
        }

        System.out.println("\nDetails of all books:");
        for (int i = 0; i < n; i++) {
            System.out.println("\nBook " + (i + 1) + ":");
            books[i].getDetails();
        }

        scanner.close();
    }
}
