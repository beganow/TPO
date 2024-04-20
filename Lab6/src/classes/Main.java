package classes;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "Book 1", new String[]{"Author 1"}, "Publisher A", 2000, 200, 19.99, "Hardcover"),
                new Book(2, "Book 2", new String[]{"Author 2", "Author 3"}, "Publisher B", 1999, 150, 14.99, "Paperback"),
                new Book(3, "Book 3", new String[]{"Author 1", "Author 2"}, "Publisher C", 2005, 300, 24.99, "Hardcover"),
                // Добавьте остальные объекты Book по аналогии
        };

        BookArray bookArray = new BookArray(books);

        bookArray.printBooksByAuthor("Author 1");
        System.out.println();

        bookArray.printBooksByPublisher("Publisher B");
        System.out.println();

        bookArray.printBooksPublishedAfterYear(2000);
    }
}
