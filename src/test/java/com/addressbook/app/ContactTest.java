package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactTest {



    @Nested
    @DisplayName("Validation methods")
    class ValidationTests {

        @Nested
        @DisplayName("Name Validation")
        class NameValidation {
            @Test
            @DisplayName("Test that name cannot be null")
            public void testNameThrowsExceptionWhenNull() {
                // Arrange
                String name = null;
                String number = "01234567890";
                String email = "email@email.com";

                // Act

                // Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(name, number, email));
            }

            @Test
            @DisplayName("Test that name cannot be nothing")
            public void testNameThrowsExceptionWhenNoNameGiven() {
                // Arrange
                String name = "";
                String number = "01234567890";
                String email = "email@email.com";

                // Act

                // Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(name, number, email));
            }

            @Test
            @DisplayName("Test that name must be valid")
            public void testNameThrowsExceptionWhenNameFormatIsNotValid() {
                // Arrange
                String name = "Ben21048";
                String number = "01234567890";
                String email = "email@email.com";

                // Act

                // Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(name, number, email));
            }
        }

        @Nested
        @DisplayName("Number Validation")
        class NumberValidation {

            @Test
            @DisplayName("Test that number cannot be null")
            public void testNumberThrowsExceptionWhenNull() {
                // Arrange
                String name = "Ben Parkes";
                String number = null;
                String email = "email@email.com";

                // Act

                // Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(name, number, email));
            }

            @Test
            @DisplayName("Test that number cannot be empty")
            public void testNumberThrowsExceptionWhenEmpty() {
                // Arrange
                String name = "Ben Parkes";
                String number = "";
                String email = "email@email.com";

                // Act

                // Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(name, number, email));
            }

            @Test
            @DisplayName("Test that number must be valid - letters")
            public void testNumberThrowsExceptionWhenNumberFormatIsNotValid() {
                // Arrange
                String name = "Ben Parkes";
                String number = "akdfbbaf";
                String email = "email@email.com";

                // Act

                // Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(name, number, email));
            }

            @Test
            @DisplayName("Test that number must be valid - too many numbers")
            public void testNumberThrowsExceptionWhenNumberFormatIsNotValid2() {
                // Arrange
                String name = "Ben Parkes";
                String number = "123456789012345";
                String email = "email@email.com";

                // Act

                // Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(name, number, email));
            }
        }

        @Nested
        @DisplayName("Email Validation")
        class EmailValidation {
            @Test
            @DisplayName("Test that email cannot be null")
            public void testEmailThrowsExceptionWhenNull() {
                // Arrange
                String name = "Ben Parkes";
                String number = "01234567890";
                String email = null;

                // Act

                // Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(name, number, email));
            }

            @Test
            @DisplayName("Test that email cannot be nothing")
            public void testEmailThrowsExceptionWhenNoNameGiven() {
                // Arrange
                String name = "Ben Parkes";
                String number = "01234567890";
                String email = "";

                // Act

                // Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(name, number, email));
            }

            @Test
            @DisplayName("Test that email must be valid")
            public void testEmailThrowsExceptionWhenEmailFormatIsNotValid() {
                // Arrange
                String name = "Ben Parkes";
                String number = "01234567890";
                String email = "email";

                // Act

                // Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(name, number, email));
            }
        }
    }
}
