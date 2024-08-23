package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import contact.Contact;
import contact.ContactService;

public class ContactServiceTest {

    private ContactService contactService;
    private String contactID;

    @Before
    public void setUp() {
        contactService = new ContactService();
        // Add a contact first and capture its ID for further testing
        contactID = contactService.addContact("Jane", "Doe", "1234567890", "123 Elm St");
    }

    // Test adding a contact with maximum allowed length for each field
    @Test
    public void testAddContactWithMaxLengthFields() {
        String maxContactID = contactService.addContact("1234567890", "1234567890", "1234567890", "123456789012345678901234567890");
        Contact contact = contactService.getContactById(maxContactID);
        assertNotNull(contact);
        assertEquals("1234567890", contact.getFirstName());
        assertEquals("1234567890", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123456789012345678901234567890", contact.getAddress());
    }

    // Test updating a contact with maximum allowed length for each field
    @Test
    public void testUpdateContactWithMaxLengthFields() {
        contactService.updateContact(contactID, "1234567890", "1234567890", "1234567890", "123456789012345678901234567890");
        Contact updatedContact = contactService.getContactById(contactID);
        assertNotNull(updatedContact);
        assertEquals("1234567890", updatedContact.getFirstName());
        assertEquals("1234567890", updatedContact.getLastName());
        assertEquals("1234567890", updatedContact.getPhone());
        assertEquals("123456789012345678901234567890", updatedContact.getAddress());
    }

    // Test updating a non-existent contact
    @Test
    public void testUpdateNonExistentContact() {
        boolean isUpdated = contactService.updateContact("nonexistentID", "John", "Doe", "0987654321", "456 Maple St");
        assertFalse(isUpdated);
    }

    // Test getting a non-existent contact by ID
    @Test
    public void testGetNonExistentContactById() {
        Contact contact = contactService.getContactById("nonexistentID");
        assertNull(contact);
    }

    // Test deleting a non-existent contact
    @Test
    public void testDeleteNonExistentContactAgain() {
        boolean isDeleted = contactService.deleteContact("nonexistentID");
        assertFalse(isDeleted);
    }

    // Test getting an existing contact by ID after deletion
    @Test
    public void testGetContactByIdAfterDeletion() {
        contactService.deleteContact(contactID);
        Contact contact = contactService.getContactById(contactID);
        assertNull(contact);
    }
}