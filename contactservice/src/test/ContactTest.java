package test;

import static org.junit.Assert.*;
import org.junit.Test;
import contact.Contact;

public class ContactTest {

    // Test creating a valid contact
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Elm St");
        assertNotNull(contact);
        assertEquals("1234567890", contact.getContactID());
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Elm St", contact.getAddress());
    }

    // Test for invalid creation scenarios
    @Test(expected = IllegalArgumentException.class)
    public void testNullContactID() {
        new Contact(null, "Jane", "Doe", "1234567890", "123 Elm St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLongContactID() {
        new Contact("12345678901", "Jane", "Doe", "1234567890", "123 Elm St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyContactID() {
        new Contact("", "Jane", "Doe", "1234567890", "123 Elm St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullFirstName() {
        new Contact("1234567890", null, "Doe", "1234567890", "123 Elm St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLongFirstName() {
        new Contact("1234567890", "JaneDoeJaneDoe", "Doe", "1234567890", "123 Elm St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyFirstName() {
        new Contact("1234567890", "", "Doe", "1234567890", "123 Elm St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullLastName() {
        new Contact("1234567890", "Jane", null, "1234567890", "123 Elm St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLongLastName() {
        new Contact("1234567890", "Jane", "DoeDoeDoeDoe", "1234567890", "123 Elm St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyLastName() {
        new Contact("1234567890", "Jane", "", "1234567890", "123 Elm St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPhone() {
        new Contact("1234567890", "Jane", "Doe", null, "123 Elm St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShortPhoneNumber() {
        new Contact("1234567890", "Jane", "Doe", "123456789", "123 Elm St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullAddress() {
        new Contact("1234567890", "Jane", "Doe", "1234567890", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLongAddress() {
        new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Elm Street, Apartment 1000, City, State, Country");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyAddress() {
        new Contact("1234567890", "Jane", "Doe", "1234567890", "");
    }

    // Test updating fields
    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Elm St");
        contact.setFirstName("John");
        assertEquals("John", contact.getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidFirstName() {
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Elm St");
        contact.setFirstName("JohnDoeDoeDoeDoe");
    }

    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Elm St");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidLastName() {
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Elm St");
        contact.setLastName("SmithSmithSmithSmith");
    }

    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Elm St");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Elm St");
        contact.setAddress("456 Oak St");
        assertEquals("456 Oak St", contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidAddress() {
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Elm St");
        contact.setAddress("456 Oak Street, Apartment 2000, City, State, Country");
    }

    // Additional getter tests
    @Test
    public void testGetContactID() {
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Elm St");
        assertEquals("1234567890", contact.getContactID());
    }

    @Test
    public void testGetFirstName() {
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Elm St");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void testGetLastName() {
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Elm St");
        assertEquals("Doe", contact.getLastName());
    }

    @Test
    public void testGetPhone() {
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Elm St");
        assertEquals("1234567890", contact.getPhone());
    }

    @Test
    public void testGetAddress() {
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Elm St");
        assertEquals("123 Elm St", contact.getAddress());
    }
}