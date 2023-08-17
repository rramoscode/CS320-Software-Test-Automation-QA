package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import service.ContactClass;

class ContactTest {

    @Test
    void testContactClass() {
        ContactClass c = new ContactClass("1234567891", "Java 101", "eclipse 11", "1234567891", "1122 windsor rd, T Tx 4444");

        assertTrue(c.getContactID().equals("1234567891"));
        assertTrue(c.getFirstName().equals("Java 101"));
        assertTrue(c.getLastName().equals("eclipse 11"));
        assertTrue(c.getPhone().equals("1234567891"));
        assertTrue(c.getAddress().equals("1122 windsor rd, T Tx 4444")); 
 
    }
 // Test for a valid contactID (exactly 10 characters long with valid characters)
    @Test
    void testValidContactID() {
    	ContactClass c = new ContactClass("ABCDE12345", "John", "Doe", "1234567891", "123 Main St");
    	// Assert that the getter method returns the expected valid contactID
    	assertEquals("ABCDE12345", c.getContactID());
    }
 // Test case for a contactID that is too long, expecting an IllegalArgumentException
    @Test
    void testContactIDToLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new ContactClass("123456789111", "Java 101", "eclipse 11", "1234567891", "1122 windsor rd, T Tx 4444");
        });
    }
 // Test case for a null contactID, expecting an IllegalArgumentException
    @Test
    void testContactIDIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { 
            new ContactClass(null, "Java 101", "eclipse 11", "1234567891", "1122 windsor rd, T Tx 4444");
        });
    }
    
    @Test
    void testUpdateContactDetails() {
        ContactClass c = new ContactClass("1234567890", "John", "Doe", "1234567890", "123 Elm St");
        
        // Update contact details using setter methods
        c.setFirstName("Jane");
        c.setLastName("Smith");
        c.setPhone("9876543210");
        c.setAddress("456 Oak St");
        
        // Assert that the updated values are correct
        assertEquals("Jane", c.getFirstName());
        assertEquals("Smith", c.getLastName());
        assertEquals("9876543210", c.getPhone());
        assertEquals("456 Oak St", c.getAddress());
    }
 // Test case for a valid firstName (exactly 10 characters long with valid characters)
    @Test
    void testValidFirstName() {
    	// Test for a valid firstName (exactly 10 characters long with valid characters)
    	ContactClass c = new ContactClass("1234567890", "Jane Doe", "Smith", "1234567891", "456 Elm St");
    	// Assert that the getter method returns the expected valid firstName
    	assertEquals("Jane Doe", c.getFirstName());
    }
 // Test case for a firstName that is too long, expecting an IllegalArgumentException
    @Test
    void testFirstNameToLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new ContactClass("123456789", "Java 101 nameToLong", "eclipse 11", "1234567891", "1122 windsor rd, T Tx 4444");
        });
    }
 // Test case for a null firstName, expecting an IllegalArgumentException
    @Test
    void testFirstNameIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	// Attempt to create a ContactClass instance with a null firstName
            new ContactClass("123456789", null, "eclipse 11", "1234567891", "1122 windsor rd, T Tx 4444");
        });
    }
 // Test case for a valid lastName (exactly 10 characters long with valid characters)
    @Test
    void testValidLastName() {
        ContactClass c = new ContactClass("9876543210", "John", "Doe-Smith", "1234567891", "789 Oak St");
        assertEquals("Doe-Smith", c.getLastName());
    }
 // Test case for a lastName that is too long, expecting an IllegalArgumentException
    @Test
    void testLastNameToLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	// Attempt to create a ContactClass instance with an invalid lastName
            new ContactClass("123456789", "Java 101", "eclipse 11 lastNameToLong", "1234567891", "1122 windsor rd, T Tx 4444");
        });
    }
   // Test case for a null lastName, expecting an IllegalArgumentException
    @Test
    void testLastNameIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	// Attempt to create a ContactClass instance with a null lastName
            new ContactClass("123456789", "Java 101", null, "1234567891", "1122 windsor rd, T Tx 4444");
        });
    } 
 // Test case for a valid phone number (exactly 10 digits long)
    @Test
    void testValidPhoneNumber() {
    	ContactClass c = new ContactClass("1357924680", "Java 101", "Smith", "9876543210", "111 Pine St");
    	// Assert that the getter method returns the expected valid phone number
    	assertEquals("9876543210" , c.getPhone()); 
    }
 // Test case for a phone number that is too long, expecting an IllegalArgumentException
   @Test
    void testPhoneToLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	// Attempt to create a ContactClass instance with an invalid phone number
            new ContactClass("123456789", "Java 101", "eclipse 11", "12345678911", "1122 windsor rd, T Tx 4444");
        });
    }
// Test case for a null phone number, expecting an IllegalArgumentException
    @Test
    void testPhoneIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	// Attempt to create a ContactClass instance with a null phone number
            new ContactClass("123456789", "Java 101", "eclipse 11", null, "1122 windsor rd, T Tx 4444");
        });
    }
 // Test case for a valid address (no longer than 30 characters with valid characters)
    @Test
    void testValidAddress() {
        // Test for a valid address (no longer than 30 characters with valid characters)
        ContactClass c = new ContactClass("2468135790", "Bob", "Johnson", "1234567890", "777 Maple Ave");
     // Assert that the getter method returns the expected valid address
        assertEquals("777 Maple Ave", c.getAddress());
    }
 // Test case for an address that is too long, expecting an IllegalArgumentException
    @Test
    void testAddressToLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	// Attempt to create a ContactClass instance with an invalid address
            new ContactClass("12345678911", "Java 101", "eclipse 11", "1234567891", "1122 windsor rd, T Tx 4444 addressToLong");
        });
    }
 // Test case for a null address, expecting an IllegalArgumentException
    @Test
    void testAddressIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	// Attempt to create a ContactClass instance with a null address
            new ContactClass("123456789", "Java 101", "eclipse 11", "1234567891", null);
        });
        
    }
    
}
