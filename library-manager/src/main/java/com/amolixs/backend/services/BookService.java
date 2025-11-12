package com.amolixs.backend.services;

import java.util.List;

import com.amolixs.backend.models.Book;

public class BookService {
    private List<Book> books;

    public BookService(List<Book> books) {
        this.books = books;
    }

    public void addABook(Book newBook) {
        books.add(newBook);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getABook(int bookIndex) {
        return this.books.get(bookIndex);
    }

    public void updateABook(Book oldBook, Book newBook) {
        books.set(books.indexOf(oldBook), newBook);
    }

    public void deleteABook(Book bookToDelete) {
        books.remove(bookToDelete);
    }
}
