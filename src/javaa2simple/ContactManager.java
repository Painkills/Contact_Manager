/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaa2simple;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author d4tic
 */
public class ContactManager {
   private List<Contact> contactList;

    public ContactManager() {
        contactList = new ArrayList<>();
    }

    
    public int addContact(String fName, String lName, String email, String hPhone, String wPhone, Address address, MyDate birthday, String notes) {
        if (findContactByName(fName, lName) != -1) return -2; // error 2: Contact with that name already exists.
        Contact c = new Contact(fName, lName, email, hPhone, wPhone, address, birthday, notes);        
        if (!contactList.add(c)) return -1; // error 1: Could not add contact.
        return 0; // success
    }
    
    public int findContactByName(String fName, String lName) { // searches by first and last name and returns index of the contact
        for (int i = 0; i < contactList.size(); i++) {
            Contact c = contactList.get(i);
            if (c.getfName().equals(fName) && c.getlName().equals(lName)) return i; 
        }
        return -1;
        
        
    }    
    
    public Contact getContact(int index) { // takes the index given and returns the contact at that location
        return contactList.get(index);
    }
    
    public int editContact(int index, String fName, String lName, String hPhone, String wPhone, Address address, String email, MyDate birthday, String notes) {
        Contact c = getContact(index);
        if (c != null) {
            c.editContact(fName, lName, email, hPhone, wPhone, address, birthday, notes);
            return 0; // success
        }
        return -1;  // error 1, couldn't find contact
    }
    
    public int deleteContact(Contact contact) {
        int cIndex = findContactByName(contact.getfName(), contact.getlName());
        if (contactList.remove(cIndex) != null) return 0; // success
        return -1; // deletion failed
    }
    
    public List<Contact> getContactsByCity(String city) { // searches by city and returns a list of contacts in that city.
        if (city.isEmpty()) return contactList;
        List<Contact> cInCity = new ArrayList<>();
        for (int i = 0; i < contactList.size(); i++) {
            Contact c = contactList.get(i);
            if (c.getAddress().getCity().equals(city)) {
                cInCity.add(c);
            } 
        }
        return cInCity;
    }
    
    public List<Contact> getContactsByName(String name) { // searches by city and returns a list of contacts in that city.
        if (name.isEmpty()) return contactList;  
        String[] splitName;
        List<Contact> byName = new ArrayList<>();
        if (name.contains(" ")) {
            splitName = name.split("\\s+");
        } else {
            splitName = new String[]{name, ""};
        }
        for (int i = 0; i < contactList.size(); i++) {
            Contact c = contactList.get(i);
            if (c.getfName().equals(splitName[0]) || c.getlName().equals(splitName[1]) || c.getlName().equals(splitName[0])) {
                byName.add(c);
            } 
        }
        return byName;
    }
   

    @Override
    public String toString() {
        String s = "-----Contacts:-----";
        for (Contact contact : contactList) {
            s += contact.toString() + "\n";
        }
        return s;
    } 
    
    public List<Contact> getContactList() {
        return contactList;
    }
}
