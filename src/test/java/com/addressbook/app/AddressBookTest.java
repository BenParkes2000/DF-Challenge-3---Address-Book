package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddressBookTest {

    @Nested
    @DisplayName("Add Contact to Address Book")
    class addContactTests {
        @Test
        @DisplayName("Test to see a contact is added to the address book when added")
        void testAddedContactToAddressBook() {
            // Arrange
            int length = 1;

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);

            // Assert
            assertEquals(length, AddressBook.getContacts().size());

            // Clean-up
            AddressBook.clearContacts();
        }

        @Test
        @DisplayName("Test to check a contact can't be added when duplicate data is given")
        void testToCheckExceptionThrownWhenDuplicateDataGiven() {
            // Arrange
            int length = 1;

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);

            Contact contactMock2 = mock(Contact.class);
            AddressBook.addContact(contactMock2);


            // Assert
            assertEquals(length, AddressBook.getContacts().size());

            // Clean-up
            AddressBook.clearContacts();
        }
    }

    @Nested
    @DisplayName("Search Address Book")
    class searchAddressBookTests {
        @Test
        @DisplayName("Test that correct index is returned when searched for")
        public void testCorrectIndexIsReturnedWhenSearched() {
            // Arrange
            int index = 0;

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);
            when(contactMock.getName()).thenReturn("Ben Parkes");


            // Assert
            assertEquals(index, AddressBook.indexReturner("Ben Parkes"));

            // Clean-up
            AddressBook.clearContacts();

        }

        @Test
        @DisplayName("Test that indexOutOfBoundsThrown when contact isn't in the address book")
        public void testIndexOutOfBoundsThrownWhenContactIsNotThere() {
            // Arrange

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);

            // Assert
            assertEquals(-2, AddressBook.printContactDetails("Ben Parkes"));

            // Clean-up
            AddressBook.clearContacts();

        }

        @Test
        @DisplayName("Test that indexOutOfBoundsThrown when address book is empty")
        public void testIndexOutOfBoundsThrownWhenAddressBookIsEmpty() {
            // Arrange

            // Act

            // Assert
            assertEquals(-2, AddressBook.printContactDetails("Ben Parkes"));

        }

        @Test
        @DisplayName("Test that results are printed for correct name")
        public void testCorrectResultsPrinted() {
            // Arrange

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);
            when(contactMock.getName()).thenReturn("Ben Parkes");

            // Assert
            assertEquals(0, AddressBook.printContactDetails("Ben Parkes"));

            // Clean-up
            AddressBook.clearContacts();
        }
        }

    @Nested
    @DisplayName("Name Validation")
    class NameValidation {
        @Test
        @DisplayName("Test that name cannot be null")
        public void testNameThrowsExceptionWhenNull() {
            // Arrange
            String name = null;

            // Act

            // Assert
            assertEquals(-1, AddressBook.printContactDetails(name));
        }

        @Test
        @DisplayName("Test that name cannot be nothing")
        public void testNameThrowsExceptionWhenNoNameGiven() {
            // Arrange
            String name = "";

            // Act

            // Assert
            assertEquals(-1, AddressBook.removeContact(name));
        }

        @Test
        @DisplayName("Test that name must be valid")
        public void testNameThrowsExceptionWhenNameFormatIsNotValid() {
            // Arrange
            String name = "Ben21048";

            // Act

            // Assert
            assertEquals(-1, AddressBook.printContactDetails(name));
        }
    }

    @Nested
    @DisplayName("Removing a Contact")
    class removeAContact {
        @Test
        @DisplayName("Test to see a contact is removed from the address book")
        void testContactRemovedFromAddressBook() {
            // Arrange
            int length = 0;

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);
            when(contactMock.getName()).thenReturn("Ben Parkes");
            AddressBook.removeContact("Ben Parkes");

            // Assert
            assertEquals(length, AddressBook.getContacts().size());

            // Clean-up
            AddressBook.clearContacts();
        }


        @Test
        @DisplayName("Test to see no contact is removed when an incorrect name is given")
        void testNoContactRemovedFromAddressBook() {
            // Arrange

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);
            when(contactMock.getName()).thenReturn("Ben Parkes");

            // Assert
            assertEquals(-2, AddressBook.removeContact("Ben Robertson"));

            // Clean-up
            AddressBook.clearContacts();
        }
    }

    @Nested
    @DisplayName("Editing Contact Details")
    class editContactDetails {

        @Test
        @DisplayName("Test to see that name can be changed")
        void testToSeeIfNameCanBeChanged() {

            // Arrange

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);
            when(contactMock.getName()).thenReturn("Ben Parkes");

            // Assert
            assertEquals(0 , AddressBook.editContactName("Ben Parkes", "Frank Jones"));

            // Clean-up
            AddressBook.clearContacts();
        }

        @Test
        @DisplayName("Test to see that name can't be changed if invalid")
        void testToSeeIfNameCantBeChanged() {

            // Arrange

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);
            when(contactMock.getName()).thenReturn("Ben Parkes");

            // Assert
            assertEquals(-1 , AddressBook.editContactName("BenParkes", "Frank Jones"));

            // Clean-up
            AddressBook.clearContacts();
        }

        @Test
        @DisplayName("Test to see that name can't be changed if not in address book")
        void testToSeeIfNameCantBeChanged2() {

            // Arrange

            // Act

            // Assert
            assertEquals(-2 , AddressBook.editContactName("Ben Parkes", "Frank Jones"));
        }

        @Test
        @DisplayName("Test to see that number can be changed")
        void testToSeeIfNumberCanBeChanged() {

            // Arrange

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);

            when(contactMock.getName()).thenReturn("Ben Parkes");

            // Assert
            assertEquals(0 , AddressBook.editContactNumber("Ben Parkes", "00123456789"));

            // Clean-up
            AddressBook.clearContacts();
        }

        @Test
        @DisplayName("Test to see that number can't be changed if invalid")
        void testToSeeIfNumberCantBeChanged() {

            // Arrange

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);
            when(contactMock.getName()).thenReturn("Ben Parkes");

            // Assert
            assertEquals(-1 , AddressBook.editContactNumber("BenParkes", "01234567890"));

            // Clean-up
            AddressBook.clearContacts();
        }

        @Test
        @DisplayName("Test to see that number can't be changed if not in address book")
        void testToSeeIfNumberCantBeChanged2() {

            // Arrange

            // Act

            // Assert
            assertEquals(-2 , AddressBook.editContactNumber("Ben Parkes", "01234567890"));
        }

        @Test
        @DisplayName("Test to see that email can be changed")
        void testToSeeIfEmailCanBeChanged() {

            // Arrange

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);

            when(contactMock.getName()).thenReturn("Ben Parkes");

            // Assert
            assertEquals(0 , AddressBook.editEmailAddress("Ben Parkes", "email@email.com"));

            // Clean-up
            AddressBook.clearContacts();
        }

        @Test
        @DisplayName("Test to see that email can't be changed if invalid")
        void testToSeeIfEmailCantBeChanged() {

            // Arrange

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);
            when(contactMock.getName()).thenReturn("Ben Parkes");

            // Assert
            assertEquals(-1 , AddressBook.editEmailAddress("BenParkes", "ben@gmail.com"));

            // Clean-up
            AddressBook.clearContacts();
        }

        @Test
        @DisplayName("Test to see that email can't be changed if not in address book")
        void testToSeeIfEmailCantBeChanged2() {

            // Arrange

            // Act

            // Assert
            assertEquals(-2 , AddressBook.editEmailAddress("Ben Parkes", "ben@gmail.com"));
        }
    }

    @Nested
    @DisplayName("Check for Duplicate Details")
    class duplicateDetails {

        @Test
        @DisplayName("Throws exception when provided a duplicate number")
        void testToCheckReturnsExceptionThrownWhenDuplicateNumber() {

            // Arrange

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);
            when(contactMock.getName()).thenReturn("Ben Parkes");
            when(contactMock.getPhoneNumber()).thenReturn("01234567890");

            // Assert
            assertEquals(-3, AddressBook.editContactNumber("Ben Parkes", "01234567890"));

            // Clean-up
            AddressBook.clearContacts();
        }

        @Test
        @DisplayName("Doesn't throw exception when provided a different number")
        void testToCheckNoExceptionThrownWhenDifferentNumber() {

            // Arrange

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);
            when(contactMock.getName()).thenReturn("Ben Parkes");
            when(contactMock.getPhoneNumber()).thenReturn("00000000000");

            // Assert
            assertEquals(0, AddressBook.editContactNumber("Ben Parkes", "01234567890"));

            // Clean-up
            AddressBook.clearContacts();
        }

        @Test
        @DisplayName("Throws exception when provided a duplicate email")
        void testToCheckReturnsExceptionThrownWhenDuplicateEmail() {

            // Arrange

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);
            when(contactMock.getName()).thenReturn("Ben Parkes");
            when(contactMock.getEmailAddress()).thenReturn("ben@gmail.com");

            // Assert
            assertEquals(-3, AddressBook.editEmailAddress("Ben Parkes", "ben@gmail.com"));

            // Clean-up
            AddressBook.clearContacts();
        }

        @Test
        @DisplayName("Doesn't throw exception when provided a different email")
        void testToCheckNoExceptionThrownWhenDifferentEmail() {

            // Arrange

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);
            when(contactMock.getName()).thenReturn("Ben Parkes");
            when(contactMock.getEmailAddress()).thenReturn("benP@gmail.com");

            // Assert
            assertEquals(0, AddressBook.editEmailAddress("Ben Parkes", "Ben@gmail.com"));

            // Clean-up
            AddressBook.clearContacts();
        }
    }

    @Nested
    @DisplayName("View All Contacts")
    class viewAllContacts {

//        @Test // Unsure how to test this initially so used chatGPT for how to style test, check docs for screenshot,
//              // attempted test below but couldn't figure out how to get it working
//        @DisplayName("Assert System.out.println is called a certain number of times")
//        void testSOUTisCalledACertainNumberOfTimes() {
//
//            // Arrange
//            PrintStream originalOut = System.out;
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            PrintStream mockPrintStream = new PrintStream(outputStream);
//            System.setOut(mockPrintStream);
//
//            // Act
//            Contact contactMock = mock(Contact.class);
//            when(contactMock.getName()).thenReturn("Ben Parkes");
//            when(contactMock.getPhoneNumber()).thenReturn("01234567890");
//            when(contactMock.getEmailAddress()).thenReturn("ben@gmail.com");
//            AddressBook.addContact(contactMock);
//            AddressBook.viewAllContacts();
//            String capturedOutput = outputStream.toString();
//
//            // Assert
////            verify(mockPrintStream, times(2)).println(Mockito.anyString());
//            assertEquals("All contacts are as follows:\nContact: Name - Ben Parkes, Phone Number = 01234567890, Email Address = ben@gmail.com", capturedOutput);
//
//            // Clean-up
//            AddressBook.clearContacts();
//            System.setOut(originalOut);
//        }
    }

    @Nested
    @DisplayName("Print Contact via Number")
    class printContactByNumber {

        @Test
        @DisplayName("Test that correct index is returned when searched for - AI written + adapted")
        public void testCorrectIndexIsReturnedWhenSearchedByNumber() {
            // Arrange
            Contact contact1 = mock(Contact.class);
            when(contact1.getPhoneNumber()).thenReturn("01234567890");

            // Act
            AddressBook.addContact(contact1);


            // Act
            int result = AddressBook.indexReturnerNumber("01234567890");

            // Assert
            assertEquals(0, result); // Assuming the second contact has the provided number

            // Clean-up
            AddressBook.clearContacts();


        }

        @Test
        @DisplayName("Test that indexOutOfBoundsThrown when contact isn't in the address book")
        public void testIndexOutOfBoundsThrownWhenContactIsNotThere() {
            // Arrange

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);

            // Assert
            assertEquals(-2, AddressBook.printContactDetailsNumber("01234567890"));

            // Clean-up
            AddressBook.clearContacts();

        }

        @Test
        @DisplayName("Test that indexOutOfBoundsThrown when address book is empty")
        public void testIndexOutOfBoundsThrownWhenAddressBookIsEmpty() {
            // Arrange

            // Act

            // Assert
            assertEquals(-2, AddressBook.printContactDetailsNumber("01234567890"));

        }

        @Test
        @DisplayName("Test that results are printed for correct number")
        public void testCorrectResultsPrinted() {
            // Arrange

            // Act
            Contact contactMock = mock(Contact.class);
            AddressBook.addContact(contactMock);
            when(contactMock.getPhoneNumber()).thenReturn("01234567890");

            // Assert
            assertEquals(0, AddressBook.printContactDetailsNumber("01234567890"));

            // Clean-up
            AddressBook.clearContacts();
        }

        @Test
        @DisplayName("Test that IllegalArgumentException thrown when invalid number given")
        public void testIllegalArgumentExceptionThrownWhenInvalidNumberGiven() {
            // Arrange

            // Act

            // Assert
            assertEquals(-1, AddressBook.printContactDetailsNumber("Ben"));
        }
    }
}
