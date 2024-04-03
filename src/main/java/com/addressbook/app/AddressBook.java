package com.addressbook.app;

import java.util.ArrayList;
import java.util.Objects;

public class AddressBook {

    private static final ArrayList<Contact> contacts = new ArrayList<>();

    public static void clearContacts() {
        contacts.clear();
    }

    public static ArrayList<Contact> getContacts() {
        return contacts;
    }

    public static void addContact(Contact person) {
        try {
            checkDuplicateNumber(person.getPhoneNumber());
            checkDuplicateEmail(person.getEmailAddress());
            contacts.add(person);
        } catch (DuplicateException e) {
            System.out.println("Duplicate number / email detected, please try again");
        }
    }

    public static int removeContact(String name) {
        try {
            int index = indexReturner(name);
            contacts.remove(index);
            return 0;
        } catch (IllegalArgumentException e) {
            System.out.println("Please provide a valid name");
            return -1;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Name not found in address book");
            return -2;
        }
    }

    public static void viewAllContacts() {
        System.out.println("All contacts are as follows:");
        for (Contact i : contacts) {
            System.out.println(i);
        }
    }

    public static int printContactDetails(String name) {
        try {
            int index = indexReturner(name);
            System.out.println("Contact: Name = " + contacts.get(index).getName() + ", Phone Number = " + contacts.get(index).getPhoneNumber() + ", Email Address = " + contacts.get(index).getEmailAddress());
            return 0;
        } catch (IllegalArgumentException e) {
            System.out.println("Please provide a valid name");
            return -1;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Name not found in address book");
            return -2;
        }
    }

    public static int printContactDetailsNumber(String number) {
        try {
            int index = indexReturnerNumber(number);
            // System.out.println("Contact: Name = " + contacts.get(index).getName() + ", Phone Number = " + contacts.get(index).getPhoneNumber() + ", Email Address = " + contacts.get(index).getEmailAddress());
            // Refactored Code below
            Contact contact = contacts.get(index);
            System.out.println("Contact: Name = " + contact.getName() + ", Phone Number = " + contact.getPhoneNumber() + ", Email Address = " + contact.getEmailAddress());
            return 0;
        } catch (IllegalArgumentException e) {
            System.out.println("Please provide a valid number");
            return -1;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Number not found in address book");
            return -2;
        }
    }

    public static int indexReturner(String name) {
        nameValidator(name);
        for (Contact i : contacts) {
            if (Objects.equals(i.getName(), name)) {
                return contacts.indexOf(i);
            }
        }
        return -2;
    }

    public static int indexReturnerNumber(String number) {
        numberValidator(number);
        for (Contact i : contacts) {
            if (Objects.equals(i.getPhoneNumber(), number)) {
                return contacts.indexOf(i);
            }
        }
        return -2;
    }

    public static int editContactName(String name, String newName) {
        try {
            nameValidator(newName);
            int index = indexReturner(name);
            contacts.get(index).setName(newName);
            return 0;
        } catch (IllegalArgumentException e) {
            System.out.println("Please provide a valid name");
            return -1;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Name not found in address book");
            return -2;
        }
    }

    public static int editContactNumber(String name, String newNumber) {
        try {
            numberValidator(newNumber);
            int index = indexReturner(name);
            checkDuplicateNumber(newNumber);
            contacts.get(index).setPhoneNumber(newNumber);
            return 0;
        } catch (IllegalArgumentException e) {
            System.out.println("Please provide a valid name / number");
            return -1;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Name not found in address book");
            return -2;
        } catch (DuplicateException e) {
            System.out.println("Duplicate number located, try another number");
            return -3;
        }
    }

    public static int editEmailAddress(String name, String newEmail) {
        try {
            emailValidator(newEmail);
            int index = indexReturner(name);
            checkDuplicateEmail(newEmail);
            contacts.get(index).setEmailAddress(newEmail);
            return 0;
        } catch (IllegalArgumentException e) {
            System.out.println("Please provide a valid name / email");
            return -1;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Name not found in address book");
            return -2;
        } catch (DuplicateException e) {
            System.out.println("Duplicate email located, try another email");
            return -3;
        }
    }

    public static void checkDuplicateNumber(String number) throws DuplicateException {
        for (Contact i : contacts) {
            if (Objects.equals(i.getPhoneNumber(), number)) {
                throw new DuplicateException();
            }
        }
    }

    public static void checkDuplicateEmail(String email) throws DuplicateException {
        for (Contact i : contacts) {
            if (Objects.equals(i.getEmailAddress(), email)) {
                throw new DuplicateException();
            }
        }
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
}
