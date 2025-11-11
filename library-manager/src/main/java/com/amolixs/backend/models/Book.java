package com.amolixs.backend.models;

import java.util.UUID;

import com.amolixs.backend.enums.BookReadStatus;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;


@Data
public class Book {
    @Setter(AccessLevel.NONE)
    private String uuid = UUID.randomUUID().toString();
    private String title;
    private String author;
    private double price;
    private int numberOfPages;
    private int currentPages;
    private BookReadStatus readStatus;

    public Book(String title, String author, double price, int numberOfPages, int currentPages, BookReadStatus readStatus) {
        this.uuid = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.currentPages = currentPages;
        this.readStatus = readStatus;
    }

    public String getReadStatus() {
        if (this.readStatus == BookReadStatus.NOT_STARTED) {
            return "Book has not been started";
        } else if (this.readStatus == BookReadStatus.STARTED) {
            return "Book has been started";
        } else {
            return "Book has been finished";
        }
    }

    @Override
    public String toString() {
        return "Title : " + this.title + 
            ", Author : " + this.author + ", Price : " + this.price + ", Number Total of pages : " + 
            numberOfPages + ", Current Pages Number : " + 
            this.currentPages + ", Read Status : " + this.readStatus;
    }
}
