package org.example;


import org.example.Forms.SaveButtonListener;
import org.example.Forms.SpringInitializer;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Launch the book editor form
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SpringInitializer springInitializer = new SpringInitializer();

                springInitializer.setVisible(true);


//                springInitializer.setSaveButtonListener(new SaveButtonListener() {
////
//                });
            }
        });
    }
}