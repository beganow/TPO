package classes;
import classes.Book;
public class BookArray {
    private Book[] books;

    public BookArray(Book[] books) {
        this.books = books;
    }

    public void printBooksByAuthor(String author) {
        System.out.println("Books by author " + author + ":");
        for (Book book : books) {
            for (String bookAuthor : book.getAuthors()) {
                if (bookAuthor.equals(author)) {
                    System.out.println(book);
                    break;
                }
            }
        }
    }

    public void printBooksByPublisher(String publisher) {
        System.out.println("Books published by " + publisher + ":");
        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                System.out.println(book);
            }
        }
    }

    public void printBooksPublishedAfterYear(int year) {
        System.out.println("Books published after " + year + ":");
        for (Book book : books) {
            if (book.getYear() > year) {
                System.out.println(book);
            }
        }
    }
}