package org.example.Forms;

import org.example.BookHubCode.Controller.springController;
import org.example.BookHubCode.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpringInitializer extends JFrame{
    private JPanel contentPane;
    private JTextField artifactNameField;
    private JTextField nameField;
    private JTextField packagingField;
    private JTextField descriptionField;
    private JTextField groupField;

    private JComboBox<Language> languageCombobox;
    private JComboBox<SpringBootVersion> springBootCombobox;
    private JComboBox<TypeBox> typeCombobox;
    private JComboBox<JavaVersion> javaCombobox;
    private JComboBox<Dependency> dependencyCombobox;
    private JRadioButton packagingRadioButton;



    private JButton saveButton;
    private JButton cancelButton;
    private SaveButtonListener saveButtonListener;

    public SpringInitializer() {
//        library = new Library();
        setTitle("Spring Initalizer");
//        setIconImage(image);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();

        // Populate the combo boxes
        populateSpringVersionComboBox();
        populateDependencyComboBox();
        populateJavaVersionComboBox();
        populateLanguageVersionComboBox();
        populateTypeVersionComboBox();


        // Set the frame location to the center of the screen
        setLocationRelativeTo(null);

        // Save button event listener
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveChanges();
            }
        });

        // Cancel button event listener
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelChanges();
            }
        });

        // Set the frame visible
        setVisible(true);
    }
    public void setSaveButtonListener(SaveButtonListener listener) {
        this.saveButtonListener = listener;
    }
    private void saveChanges() {

        String groupName = groupField.getText();
        String name = nameField.getText();
        JavaVersion javaVersion = (JavaVersion) javaCombobox.getSelectedItem();
        SpringBootVersion springBootVersion = (SpringBootVersion) springBootCombobox.getSelectedItem();
        TypeBox typeBox = (TypeBox) typeCombobox.getSelectedItem();
        Language language = (Language) languageCombobox.getSelectedItem();


        System.out.println("groupName: "+groupName+"\nProject Name: "+name+"\nJava version: "+javaVersion+"\nSpringBootVersion: "+springBootVersion+"\nBuild Type: "+ typeBox+"\nLanguage: "+language);


//        List<Dependency> dependencyList = (List<Dependency>) dependencyCombobox.getSelectedItem();

//        String authorName = authorNameField.getText();
//        String bookName = bookNameField.getText();
//        Genre genre = (Genre) genreComboBox.getSelectedItem();
//        boolean isTaken = isTakenCheckBox.isSelected();



        // Create Author object
//        Author author = new Author(authorName, ""); // Set the author name
//
//        // Create Book object
//        Book book = new Book(author, genre, null, bookName);
//        book.setTaken(isTaken);

        // Notify the listener with the book object
        if (saveButtonListener != null) {
//            saveButtonListener.onSaveClicked(book);
            springController.getRequest(groupName, name,javaVersion,springBootVersion,typeBox,language);
        }

        // Reset fields
//        authorNameField.setText("");
//        bookNameField.setText("");
//        genreComboBox.setSelectedIndex(0);
//        isTakenCheckBox.setSelected(false);
    }


    private void cancelChanges() {
        // Reset fields
//        bookNameField.setText("");
//        genreComboBox.setSelectedIndex(0);
//        isTakenCheckBox.setSelected(false);
    }

    private void populateSpringVersionComboBox() {
        // Get the combo box model
        DefaultComboBoxModel<SpringBootVersion> springBootVersionDefaultComboBoxModel = (DefaultComboBoxModel<SpringBootVersion>) springBootCombobox.getModel();

        // Add genre values to the combo box model
        for (SpringBootVersion sp : SpringBootVersion.values()) {
            springBootVersionDefaultComboBoxModel.addElement(sp);
        }
    }

    private void populateDependencyComboBox(){
        DefaultComboBoxModel<Dependency> dependencyDefaultComboBoxModel = (DefaultComboBoxModel<Dependency>) dependencyCombobox.getModel();
        for (Dependency dp : Dependency.values()) {
            dependencyDefaultComboBoxModel.addElement(dp);
        }

    }
    private void populateJavaVersionComboBox(){
        DefaultComboBoxModel<JavaVersion> javaVersionDefaultComboBoxModel = (DefaultComboBoxModel<JavaVersion>) javaCombobox.getModel();
        for (JavaVersion javaVersion : JavaVersion.values()) {
            javaVersionDefaultComboBoxModel.addElement(javaVersion);
        }
    }

    private void populateLanguageVersionComboBox(){
        DefaultComboBoxModel<Language> languageDefaultComboBoxModel = (DefaultComboBoxModel<Language>) languageCombobox.getModel();
        for (Language language : Language.values()) {
            languageDefaultComboBoxModel.addElement(language);
        }
    }
    private void populateTypeVersionComboBox(){
        DefaultComboBoxModel<TypeBox> typeBoxDefaultComboBoxModel = (DefaultComboBoxModel<TypeBox>) typeCombobox.getModel();
        for (TypeBox typeBox : TypeBox.values()) {
            typeBoxDefaultComboBoxModel.addElement(typeBox);
        }
    }

}