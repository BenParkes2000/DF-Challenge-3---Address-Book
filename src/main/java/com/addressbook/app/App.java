package com.addressbook.app;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Create's two contacts
        System.out.println("Creating 2 contacts");
        Contact contact1 = new Contact("Fred Jones", "07123456780", "fredjones@gmail.com");
        Contact contact2 = new Contact("Tommy Jones", "07123456789", "tommyjones@gmail.com");
        System.out.println(contact1);
        System.out.println(contact2);

        // Adds them to the address book
        System.out.println("\nAdds them to the address book");
        AddressBook.addContact(contact1);
        AddressBook.addContact(contact2);

        // These can be viewed all at once
        System.out.println("These can be viewed all at once");
        AddressBook.viewAllContacts();

        // Or search via name separately and print a single contacts details
        System.out.println("\nOr search via name separately and print a single contacts details");
        AddressBook.printContactDetails("Fred Jones");

        // Contacts with duplicate numbers / emails cannot be added
        System.out.println("\nContacts with duplicate numbers / emails cannot be added");
        Contact contact3 = new Contact("Ben Parkes", "07123456789", "ben@gmail.com");
        System.out.println(contact3);
        AddressBook.addContact(contact3);
        AddressBook.viewAllContacts();

        // Contact data can also be edited
        System.out.println("\nContact data can also be edited");
        AddressBook.editContactName("Fred Jones", "Ben Jones");
        AddressBook.editEmailAddress("Tommy Jones", "Tommys@email.com");
        AddressBook.viewAllContacts();

        // Contacts can also be deleted from the address book
        System.out.println("\nContacts can also be deleted from the address book");
        AddressBook.removeContact("Tommy Jones");
        AddressBook.viewAllContacts();

        // Contacts can also be searched for by phone number
        System.out.println("\nContacts can also be searched for by phone number");
        AddressBook.printContactDetailsNumber("07123456780");
    }

}
