package com.amolixs;

import com.amolixs.backend.enums.BookReadStatus;
import com.amolixs.backend.models.Book;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Book newBook = new Book("Stoner", "Wiliam Johns", 23.50, 152, 10, BookReadStatus.FINISHED);
        System.out.println(newBook);
        System.out.println(newBook.getReadStatus());

    }
}
