package com.amolixs.frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.amolixs.backend.enums.BookReadStatus;
import com.amolixs.backend.models.Book;
import com.amolixs.backend.services.BookService;

public class BookView {
    private BookService bookService;
    private Scanner scanner;

    public BookView(BookService bookService) {
        this.bookService = bookService;
        this.scanner = new Scanner(System.in);
    }

    public void addABook() {
        System.out.print("[+] Veuillez entrez le titre du livre : ");
        String title = scanner.nextLine();
        System.out.print("[+] Veuillez entrez l'auteur du livre : ");
        String author = scanner.nextLine();
        System.out.print("[+] Veuillez entrez le prix du livre : ");
        int price = scanner.nextInt();
        System.out.print("[+] Veuillez entrez le nombre de pages du livre : ");
        int numberOfPages = scanner.nextInt();
        System.out.print("[+] Veuillez entrez le status du livre : ");
        BookReadStatus readStatus = choiceBookReadStatusManager();
        Book newBook = new Book(
            title,
            author,
            price,
            numberOfPages,
            readStatus
        );
        bookService.addABook(newBook);
        System.out.println("Votre livre a correctement été ajouté : ");
        System.out.println(newBook.toString());
    }

    public BookReadStatus choiceBookReadStatusManager() {
        int choiceBookStatus = 0;
        do {
            choiceBookStatus = getChoiceBookReadStatus();
        } while (choiceBookStatus == -1 || choiceBookStatus > 2);
        switch (choiceBookStatus) {
            case 0:
                return BookReadStatus.NOT_STARTED;
            case 1:
                return BookReadStatus.STARTED;
            case 2:
                return BookReadStatus.FINISHED;
            default:
                return BookReadStatus.NOT_STARTED;
        }
    }

    public int getChoiceBookReadStatus() {
        System.out.println("Statuts disponibles :");
        int statusBookChoiceEnteredByUser = 0;
        BookReadStatus[] statuses = BookReadStatus.values();
        for (int i = 0; i < statuses.length; i++) {
            System.out.println("  [" + i + "] " + statuses[i]);
        }
        try {
            statusBookChoiceEnteredByUser = this.scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Veuillez entrez un choix de status valide !");
            return -1;
        }
        return statusBookChoiceEnteredByUser;
    }

    public void displayAllBooks() {
        System.out.println("=========================");
        System.out.println("        VOS LIVRES       ");
        System.out.println("=========================");
        if (this.bookService.getBooks().size() > 0) {
            this.bookService.getBooks().forEach(book -> {
                System.out.println("["+bookService.getBooks().indexOf(book)+"] "+ book.getTitle());
            });
        } else {
            System.out.println("Aucun livre");
        }
        System.out.println("");
    }

    public void displayABook() {
        this.displayAllBooks();
        if (this.bookService.getBooks().size() > 0) {
            System.out.print("[*] Veuillez entrez le numéro du livre à afficher : ");
            int userChoiceBookToDisplay = this.scanner.nextInt();
            System.out.println(this.bookService.getABook(userChoiceBookToDisplay).toString());
            // I add this line to reset my line scanner
            this.scanner.nextLine();
        } else {
            return;
        }
    }

    public void deleteABook() {
        this.displayAllBooks();
        int userChoiceBookToDelete = this.scanner.nextInt();
        this.bookService.deleteABook(this.bookService.getABook(userChoiceBookToDelete));        
    }

    public void updateABook() {
        this.displayAllBooks();
        if (this.bookService.getBooks().size() > 0) {
            System.out.print("[*] Veuillez entrez le numéro du livre à modifier : ");
            int userChoiceBookToUpdate = this.scanner.nextInt();
            // Reset scanner line
            this.scanner.nextLine();
            Book bookToUpdate = this.bookService.getABook(userChoiceBookToUpdate);
            
            System.out.print("[*] Veuillez entrez le nouveau titre (" + bookToUpdate.getTitle() + ") : ");
            String newTitle = this.scanner.nextLine();
            if (newTitle.isEmpty()) {
                newTitle = bookToUpdate.getTitle();
            }
            
            System.out.print("[*] Veuillez entrez le nouvel auteur (" + bookToUpdate.getAuthor() + ") : ");
            String newAuthor = this.scanner.nextLine();
            if (newAuthor.isEmpty()) {
                newAuthor = bookToUpdate.getAuthor();
            }
            
            System.out.print("[*] Veuillez entrez le nouveau prix (" + bookToUpdate.getPrice() + ") : ");
            String priceInput = this.scanner.nextLine();
            double newPrice = bookToUpdate.getPrice();
            if (!priceInput.isEmpty()) {
                try {
                    newPrice = Double.parseDouble(priceInput);
                } catch (NumberFormatException e) {
                    System.out.println("Prix invalide, utilisation du prix actuel.");
                }
            }
            
            System.out.print("[*] Veuillez entrez le nouveau nombre de pages (" + bookToUpdate.getNumberOfPages() + ") : ");
            String pagesInput = this.scanner.nextLine();
            int newNumberOfPages = bookToUpdate.getNumberOfPages();
            if (!pagesInput.isEmpty()) {
                try {
                    newNumberOfPages = Integer.parseInt(pagesInput);
                } catch (NumberFormatException e) {
                    System.out.println("Nombre de pages invalide, utilisation de la valeur actuelle.");
                }
            }
            
            System.out.print("[*] Veuillez entrez le nouveau statut de lecture : ");
            BookReadStatus newReadStatus = choiceBookReadStatusManager();
            
            Book updatedBook = new Book(
                newTitle,
                newAuthor,
                newPrice,
                newNumberOfPages,
                newReadStatus
            );
            
            this.bookService.updateABook(bookToUpdate, updatedBook);
            System.out.println("Le livre a été correctement modifié : ");
            System.out.println(updatedBook.toString());
        } else {
            return;
        }
    }
}
