package org.example;


import org.example.BookHubCode.Book;
import org.example.Forms.BookHub;
import org.example.Forms.SaveButtonListener;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Launch the book editor form
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BookHub bookHub = new BookHub();
                bookHub.setVisible(true);


                bookHub.setSaveButtonListener(new SaveButtonListener() {
                @Override
                    public void onSaveClicked(Book book) {
                        System.out.println("Entered Book Details:");
                        System.out.println("Book Title: " + book.getName());
                        System.out.println("Author: " + book.getAuthor().getName());
                        System.out.println("Genre: " + book.getGenre());
                        System.out.println("Is Unavailable: " + book.isTaken());
                    }
                });
            }
        });
    }
}