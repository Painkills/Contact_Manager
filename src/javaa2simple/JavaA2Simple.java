/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaa2simple;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author d4tic
 */
public class JavaA2Simple extends Application {
    
    Stage window;
    Scene scene1, scene2;
    private Contact source;
    static ContactManager cManager;
    static TextField txtfName, txtlName, txtemail, txthPhone, txtwPhone, txtcity,
            txtstreetLine1, txtstreetLine2, txtprovince, txtcountry, txtpostalCode,
            txtbirthDay, txtbirthMonth, txtbirthYear, txtnotes;
    static Label resultLabel;
    static Label secondTitle;
    static VBox viewPane;
    
    @Override
    public void start(Stage primaryStage) throws Exception { 
        window = primaryStage;
        
        // Create contact manager
        cManager = new ContactManager();
        cManager.addContact("David", "Fortich", "me@gmail.com", "6478419871", "6476987413", new Address("100 Main", "House 1", "Toronto", "Ontario", "Canada", "M4M1M1"), new MyDate(7,9,1988), "");
        cManager.addContact("David", "Daniels", "me@gmail.com", "6478419871", "6476987413", new Address("100 Main", "House 1", "Toronto", "Ontario", "Canada", "M4M1M1"), new MyDate(7,9,1988), "");
        cManager.addContact("John", "Shawarma", "me@gmail.com", "6478419871", "6476987413", new Address("100 Main", "House 1", "Toronto", "Ontario", "Canada", "M4M1M1"), new MyDate(7,9,1988), "");

        // Create main Scene
        VBox mainLayout = new VBox(5);
        mainLayout.setPadding(new Insets(20));
        
        // Create title
        Label title = new Label("-----Contact List-----");

        
        // Create search bar
        HBox searchBar = new HBox(3);
        Button searchCityButton = new Button("Search City");        
        TextField searchTxt = new TextField();
        Button searchNameButton = new Button("Search Name");
        
        
        searchBar.getChildren().addAll(searchCityButton, searchTxt, searchNameButton);

        
        // Create View Pane        
        viewPane = new VBox(cManager.getContactList().size());
        updateViewPane(viewPane, cManager.getContactList());
        

        
        // Create result bar
        resultLabel = new Label("\nContacts loaded.");

        
        // Create navigation bar and buttons
        HBox navBar = new HBox(2);
        Button addContact = new Button("Add Contact");        
        
        Button exitProgram = new Button("Exit Program");

        navBar.getChildren().addAll(addContact, exitProgram);
        
        // Add all to main layout
        mainLayout.getChildren().addAll(title, searchBar, viewPane, resultLabel, navBar);
        scene1 = new Scene(mainLayout, 800, 800);
        
        
        
        
        
        // Create second Scene
        VBox addContactLayout = new VBox(4);
        addContactLayout.setPadding(new Insets(20));
        
        // create Title
        secondTitle = new Label();
        updateSecondTitle(source);
        
        // create Fields
        HBox fieldArea = new HBox(2);
        fieldArea.setSpacing(10);
        
        VBox labelColumn = new VBox(15);
        labelColumn.setSpacing(25);
        labelColumn.setPadding(new Insets(5, 0, 0, 0));
        Label fn = new Label("First Name:  ");
        Label ln = new Label("Last Name:  ");
        Label el = new Label("Email:  ");
        Label hp = new Label("Home Phone:  ");
        Label wp = new Label("Work Phone:  ");        
        Label s1 = new Label("Street Line 1:  ");
        Label s2 = new Label("Street Line 2:  ");
        Label c = new Label("City:  ");
        Label pro = new Label("Province:  ");
        Label co = new Label("Country:  ");
        Label po = new Label("Postal Code:  ");
        Label bd = new Label("Day of Birth:  ");
        Label bm = new Label("Month of Birth:  ");
        Label by = new Label("Year of Birth:  ");
        Label n = new Label("Notes:  ");
        labelColumn.getChildren().addAll(fn, ln, el, hp, wp, s1, s2, c, pro, co, po, bd, bm, by, n);
        
        // Create textColumns
        VBox textColumn = new VBox(15);        
        txtfName = new TextField();
        txtlName = new TextField();
        txtemail = new TextField();
        txthPhone = new TextField();
        txtwPhone = new TextField();
        txtstreetLine1 = new TextField();
        txtstreetLine2 = new TextField();
        txtcity = new TextField();
        txtprovince = new TextField();
        txtcountry = new TextField();
        txtpostalCode = new TextField();
        txtbirthDay = new TextField();
        txtbirthMonth = new TextField();
        txtbirthYear = new TextField();
        txtnotes = new TextField();
        updateTextColumn(source);
        textColumn.getChildren().addAll(txtfName, txtlName, txtemail, txthPhone, txtwPhone, txtstreetLine1, txtstreetLine2, txtcity, txtprovince, txtcountry, txtpostalCode, txtbirthDay, txtbirthMonth, txtbirthYear, txtnotes);
        //updateTextColumn(textColumn, source);
        
        
        fieldArea.getChildren().addAll(labelColumn, textColumn);
        
        // create result label for adding
        Label addResultLabel = new Label();
        
        // Create navigation bar and buttons
        HBox navBar2 = new HBox(2);
        Button saveContact = new Button("Save Contact");
        
        
        
        Button backToMenu = new Button("Return to Menu");
        navBar2.getChildren().addAll(saveContact, backToMenu);
        
        
        
        // Add all to the add contact scene
        addContactLayout.getChildren().addAll(secondTitle, fieldArea, addResultLabel, navBar2);
        scene2 = new Scene(addContactLayout, 800, 800);
        
        
        
        
        
        
        
        
        

        
        // Set Scene
        window.setTitle("Contact List");
        window.setScene(scene1);
        window.show();
        
        
        
        
        // Save Contact Button Action
        
        saveContact.setOnAction(e -> {
            String fName = txtfName.getText();
            String lName = txtlName.getText();
            String email = txtemail.getText();
            String hPhone = txthPhone.getText();
            String wPhone = txtwPhone.getText();
            String streetLine1 = txtstreetLine1.getText();
            String streetLine2 = txtstreetLine2.getText();
            String city = txtcity.getText();
            String province = txtprovince.getText();
            String country = txtcountry.getText();
            String postalCode = txtpostalCode.getText();
            String birthDay = txtbirthDay.getText();
            String birthMonth = txtbirthMonth.getText();
            String birthYear = txtbirthYear.getText();
            String notes = txtnotes.getText();
           
            if (fName.equals("") || lName.equals("") || 
                    email.equals("") || hPhone.equals("") || 
                    wPhone.equals("") || streetLine1.equals("") || 
                    streetLine2.equals("") || city.equals("") || 
                    province.equals("") || country.equals("")  || postalCode.equals("")
                    || birthDay.equals("") || birthMonth.equals("") || birthYear.equals("")) {
                addResultLabel.setText("Please fill in ALL fields.");
            } else {
                int intBD = Integer.parseInt(birthDay);
                int intBM = Integer.parseInt(birthMonth);
                int intBY = Integer.parseInt(birthYear);
                int result;
                if (source == null) {
                    result = cManager.addContact(fName, lName, email, hPhone, wPhone, new Address(streetLine1, 
                        streetLine2, city, province, country, postalCode), new MyDate(intBD,
                        intBM, intBY), notes);
                } else {
                    result = 0;
                    source.setfName(fName);
                    source.setlName(lName);
                    source.setEmail(email);
                    source.sethPhone(hPhone);
                    source.setwPhone(wPhone);
                    source.getAddress().setStreet1(streetLine1);
                    source.getAddress().setStreet2(streetLine2);
                    source.getAddress().setCity(city);
                    source.getAddress().setProvince(province);
                    source.getAddress().setCountry(country);
                    source.getAddress().setPostalCode(postalCode);
                    source.getBirthday().setDay(intBD);
                    source.getBirthday().setMonth(intBM);
                    source.getBirthday().setYear(intBY);
                    source.setNotes(notes);
                }
                if (result == 0) { 
                    addResultLabel.setText("Contact added successfully.");
                    txtfName.setText("");
                    txtlName.setText("");
                    txtemail.setText("");
                    txthPhone.setText("");
                    txtwPhone.setText("");
                    txtstreetLine1.setText("");
                    txtstreetLine2.setText("");
                    txtcity.setText("");
                    txtprovince.setText("");
                    txtcountry.setText("");
                    txtpostalCode.setText("");
                    txtbirthDay.setText("");
                    txtbirthMonth.setText("");
                    txtbirthYear.setText("");
                    txtnotes.setText("");
                }
                if (result == -1) { addResultLabel.setText("Contact could not be added.");}
                if (result == -2) { addResultLabel.setText("A contact with that name already exists.");}
            }
        });
        
        // return to menu button action
        backToMenu.setOnAction(e -> {
            primaryStage.setScene(scene1);
            updateViewPane(viewPane, cManager.getContactList());
            resultLabel.setText("Contact List updated.");
            source = null;
        });
        // add contact button action
        addContact.setOnAction(e -> {
            updateSecondTitle(source);
            updateTextColumn(source);
            window.setScene(scene2);            
        });
        // exit program button action
        exitProgram.setOnAction(e -> {
            System.exit(0);
        });
        // search city button action
        searchCityButton.setOnAction(e -> {
            List<Contact> cList = cManager.getContactsByCity(searchTxt.getText());
            window.setScene(scene1);
            updateViewPane(viewPane, cList);
            resultLabel.setText("Contact List updated.");
        });
        // search name button action
        searchNameButton.setOnAction(e -> {
            List<Contact> nList = cManager.getContactsByName(searchTxt.getText());
            window.setScene(scene1);
            updateViewPane(viewPane, nList);
            resultLabel.setText("Contact List updated.");
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void updateViewPane(VBox viewPane, List<Contact> list){
        viewPane.getChildren().clear();
        for (Contact contact : list) {
            
            HBox showRow = new HBox(3);
            showRow.setPadding(new Insets(20));
            Label showContact = new Label(contact.toString());
            Region space = new Region();
            HBox.setHgrow(space, Priority.ALWAYS);
            Button editContact = new Button("Edit");
            editContact.setOnAction(e -> {
                assignSource(contact, 1);
                updateSecondTitle(source);
                updateTextColumn(source);
                window.setScene(scene2); 
                
            });
            Button deleteContact = new Button("Delete");
            deleteContact.setOnAction(e -> {
                assignSource(contact, 2);  
            });
            
            showRow.getChildren().addAll(showContact, space, editContact, deleteContact);
            viewPane.getChildren().add(showRow); 
        }       
    }
    
    public void assignSource(Contact contact, int command) {
        if (command == 2) {
            if (cManager.deleteContact(contact) == 0) {
                resultLabel.setText("Contact deleted successfully. Click Search to update View.");
            } else {
                resultLabel.setText("Contact was not deleted.");
            }   
        }
        source = contact;        
    }
    
    public void updateSecondTitle(Contact contact) {
        if (contact != null) {
            secondTitle.setText("----- Edit Contact -----");
        } else {
            secondTitle.setText("----- Add Contact -----");
        }
    }
    
    public void updateTextColumn (Contact contact) {
        if (source == null) return;
        txtfName.setText(contact.getfName());
        txtlName.setText(contact.getlName());
        txtemail.setText(contact.getEmail());
        txthPhone.setText(contact.gethPhone());
        txtwPhone.setText(contact.getwPhone());
        txtstreetLine1.setText(contact.getAddress().getStreet1());
        txtstreetLine2.setText(contact.getAddress().getStreet2());
        txtcity.setText(contact.getAddress().getCity());
        txtprovince.setText(contact.getAddress().getProvince());
        txtcountry.setText(contact.getAddress().getCountry());
        txtpostalCode.setText(contact.getAddress().getPostalCode());
        txtbirthDay.setText(contact.getBirthday().getDay());
        txtbirthMonth.setText(contact.getBirthday().getMonth());
        txtbirthYear.setText(contact.getBirthday().getYear());
        txtnotes.setText(contact.getNotes());
    }
    
//    updateInputList(){
//        fName = txtfName.getText();
//        lName = txtlName.getText();
//        email = txtemail.getText();
//        hPhone = txthPhone.getText();
//        wPhone = txtwPhone.getText();
//        streetLine1 = txtstreetLine1.getText();
//        streetLine2 = txtstreetLine2.getText();
//        city = txtcity.getText();
//        province = txtprovince.getText();
//        country = txtcountry.getText();
//        postalCode = txtpostalCode.getText();
//        birthDay = txtbirthDay.getText();
//        birthMonth = txtbirthMonth.getText();
//        birthYear = txtbirthYear.getText();
//        notes = txtnotes.getText();
//    }
    
    
}
