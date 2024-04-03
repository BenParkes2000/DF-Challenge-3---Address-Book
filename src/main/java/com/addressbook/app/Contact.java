package com.addressbook.app;

public class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact (String contactName, String contactPhoneNumber, String contactEmailAddress) {
        nameValidator(contactName);
        numberValidator(contactPhoneNumber);
        emailValidator(contactEmailAddress);
        this.name = contactName;
        this.phoneNumber = contactPhoneNumber;
        this.emailAddress = contactEmailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    private static void nameValidator(String name) {
        if ( name == null || name.isEmpty() || !name.trim().matches("^[a-zA-Z][a-zA-Z'-]*[a-zA-Z] [a-zA-Z][a-zA-Z'-]*[a-zA-Z]$"))
        { throw new IllegalArgumentException("Contact's name cannot be null or empty and must have a valid format");}
    }

    private static void numberValidator(String number) {
        if ( number == null || number.isEmpty() || !number.trim().matches("^[0-9]{11}$"))
        {throw new IllegalArgumentException("Contact's number cannot be null or empty and must have a valid format");}
    }

    private static void emailValidator(String email) {
        if ( email == null || email.isEmpty() || !email.trim().matches("^[a-zA-Z0-9]*@[a-zA-Z0-9]*.[a-zA-Z]{2,4}$"))
        {throw new IllegalArgumentException("Contact's email address cannot be null or empty and must have a valid format");}
    }

    @Override
    public String toString() {
        return "Contact: Name - " + this.getName() + ", Phone Number = " + this.getPhoneNumber() + ", Email Address = " + this.getEmailAddress();
    }
}
