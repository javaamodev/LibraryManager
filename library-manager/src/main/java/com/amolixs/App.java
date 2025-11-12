package com.amolixs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.amolixs.backend.enums.BookReadStatus;
import com.amolixs.backend.models.Book;
import com.amolixs.backend.services.BookService;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Book bookTwo = new Book("Crime And Punishement", "Dostoievksy", 11.50, 700, 45, BookReadStatus.STARTED);
        Book bookThree = new Book("Le Rouge et le Noir", "Stendhal", 9.99, 520, 0, BookReadStatus.NOT_STARTED);
        Book bookFour = new Book("L'Étranger", "Albert Camus", 7.50, 185, 185, BookReadStatus.FINISHED);
        List<Book> booksListTwo = new ArrayList<Book>(Arrays.asList(bookThree, bookFour));
        BookService bookService = new BookService(booksListTwo);
    }
}
