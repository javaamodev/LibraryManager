package com.amolixs.frontend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.amolixs.backend.enums.BookReadStatus;
import com.amolixs.backend.models.Book;
import com.amolixs.backend.services.BookService;


public class Menu {
    private Scanner scanner;
    private BookView bookView;
    private BookService bookService;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.bookService = new BookService(new ArrayList<>(Arrays.asList(
        new Book(
            "Le Rouge et le Noir", 
            "Stendhal",
            9.99, 
            50, 
            BookReadStatus.NOT_STARTED)
        )));
        this.bookView = new BookView(this.bookService);
    }

    public void start() {
        int userChoice = 0;
        do {
           displayMenu();
           userChoice = getUserChoice();
           userChoiceManager(userChoice);
        } while (userChoice != 6);
    }

    public void displayMenu() {
        System.out.println("1-Ajouter un livre");
        System.out.println("2-Afficher les livres");
        System.out.println("3-Afficher un livre");
        System.out.println("4-Modifier un livre");
        System.out.println("5-Supprimer un livre");
        System.out.println("6-Quitter");
        System.out.print("[*] Votre choix : ");
    }

    public int getUserChoice() {
        int userChoice = 0;
        try {
            userChoice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Veuillez entrez un choix valide !");
        }
        return userChoice;
    }

    public void userChoiceManager(int userChoice) {
        switch (userChoice) {
            case 1:
                this.bookView.addABook();
                break;
            case 2:
                this.bookView.displayAllBooks();
                break;
            case 3:
                this.bookView.displayABook();
                break;
            case 4:
                this.bookView.updateABook();
                break;
            case 5:
                this.bookView.deleteABook();
                break;
        }
    }
}
