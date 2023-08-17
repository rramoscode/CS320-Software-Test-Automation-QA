package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import service.ContactClass;
import service.ContactService;

class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();

    }
    @Test 
    void testAddContact() {
    ContactClass contact = new ContactClass("12345", "Java 101", "Eclipse 10","1234567890", "1122 windsor rd, T Tx 4444");
    contactService.addContact(contact);
    assertEquals(contact, contactService.getContact("12345"));
    }
    
    @Test
    public void testAddContact_DuplicateID() {
        ContactClass contact1 = new ContactClass("12345", "Java 101", "Eclipse 10", "1234567890", "1122 windsor rd, T Tx 4444");
        ContactClass contact2 = new ContactClass("12345", "John", "Doe", "9876543210", "456 DarkDays St");

        contactService.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact2));
    }
    
    @Test
    public void testUpdateContact_FirstNameToLong() {
        ContactClass contact = new ContactClass("12345", "Java 101", "Eclipse 10","1234567890", "1122 windsor rd, T Tx 4444");
        contactService.addContact(contact);

        // Attempt to update with an invalid first name (more than 10 characters)
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContact("12345", "ThisIsTooLong", "Doe", "9876543210", "456 DarkDays St"));

        // Verify that the contact remains unchanged
        ContactClass unchangedContact = contactService.getContact("12345");
        assertEquals("Java 101", unchangedContact.getFirstName());
        assertEquals("Eclipse 10", unchangedContact.getLastName());
        assertEquals("1234567890", unchangedContact.getPhone());
        assertEquals("1122 windsor rd, T Tx 4444", unchangedContact.getAddress());
    }
    
    @Test
    void testDeleteContact() {
        ContactClass contact = new ContactClass("12345", "Java 101", "Eclipse 10","1234567890", "1122 windsor rd, T Tx 4444");
        contactService.addContact(contact);

        contactService.deleteContact("12345");
       assertNull(contactService.getContact("12345"));

    }
    
    @Test
    public void testDeleteContact_NonexistentID() {
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("1"));
    }
 

    @Test
    void testUpdateContact() {
        ContactClass contact = new ContactClass("12345", "Java 101", "Eclipse 10","1234567890", "1122 windsor rd, T Tx 4444");
        contactService.addContact(contact);

        contactService.updateContact("12345", "John", "Doe","9876543210", "456 DarkDays St");
        ContactClass updatedContact = contactService.getContact("12345");

        assertEquals("John", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("9876543210", updatedContact.getPhone());
        assertEquals("456 DarkDays St", updatedContact.getAddress());
    }
    
    @Test
    public void testUpdateContact_NonexistentID() {
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContact("12345", "John", "Doe", "9876543210", "456 Elm St"));
    
    }
    
}
