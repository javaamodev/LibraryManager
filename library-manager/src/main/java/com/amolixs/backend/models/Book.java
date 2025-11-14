package com.amolixs.backend.models;

import java.util.UUID;

import com.amolixs.backend.enums.BookReadStatus;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;


@Data
public class Book {
    @Setter(AccessLevel.NONE)
    private String uuid;
    private String title;
    private String author;
    private double price;
    private int numberOfPages;
    private BookReadStatus readStatus;

    public Book(String title, String author, double price, int numberOfPages, BookReadStatus readStatus) {
        this.uuid = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.readStatus = readStatus;
    }

    public String getReadStatus() {
        if (this.readStatus == BookReadStatus.NOT_STARTED) {
            return "Le livre n'a pas été commencé !";
        } else if (this.readStatus == BookReadStatus.STARTED) {
            return "Le livre à été commencé";
        } else {
            return "Le livre à été terminé !";
        }
    }

    @Override
    public String toString() {
        String bookDescription = "";
        bookDescription += "================" + this.title + "=============== \n";
        bookDescription += "Titre : " + this.title + "\n";
        bookDescription += "Auteur : " + this.author + "\n";
        bookDescription += "Prix : " + this.price + "\n";
        bookDescription += "Nombre de pages : " + this.numberOfPages + "\n";
        bookDescription += "Status de lecture : " + this.getReadStatus() + "\n"; 
        bookDescription += "================================================= \n";
        return bookDescription;
    }
}
