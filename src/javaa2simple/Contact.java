/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaa2simple;

/**
 *
 * @author d4tic
 */
public class Contact {
    private String fName;
    private String lName;
    private String email;
    private String hPhone;
    private String wPhone;
    private Address address;    
    private MyDate birthday;
    private String notes;

    public Contact(String fName, String lName, String email, String hPhone, String wPhone, Address address,  MyDate birthday, String notes) {
        this.fName = fName;
        this.lName = lName;
        this.hPhone = hPhone;
        this.wPhone = wPhone;
        this.address = address;
        this.email = email;
        this.birthday = birthday;
        this.notes = notes;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String gethPhone() {
        return hPhone;
    }

    public String getwPhone() {
        return wPhone;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public String getNotes() {
        return notes;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void sethPhone(String hPhone) {
        this.hPhone = hPhone;
    }

    public void setwPhone(String wPhone) {
        this.wPhone = wPhone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public int editContact(String fName, String lName, String email, String hPhone, String wPhone, Address address, MyDate birthday, String notes) {
        this.setfName(fName);
        this.setlName(lName);
        this.setEmail(email);
        this.sethPhone(hPhone);
        this.setwPhone(wPhone);
        this.setAddress(address);
        this.setBirthday(birthday);
        this.setNotes(notes);
        return 0;
    }

    @Override
    public String toString() {
        String s = "\nName: " + fName + " " + lName + " // Email: " + email;
        s += "\nHome Phone: " + hPhone + " // Work Phone: " + wPhone;
        s += "\n" + address.toString();
        s += "\n" + birthday.toString();
        return s;
    }
}
