package contact;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();

    // Adds a contact and returns the unique contact ID
    public String addContact(String firstName, String lastName, String phone, String address) {
        // Ensure the parameters are valid before creating a contact
        validateContactInfo(firstName, lastName, phone, address);

        // Generate a unique ID for the contact, limited to 10 characters
        String contactID = UUID.randomUUID().toString().substring(0, 10);
        
        // Create and store the contact
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        contacts.put(contactID, contact);
        
        return contactID;  // Return the ID for testing and verification purposes
    }

    // Retrieves a contact by its ID
    public Contact getContactById(String contactID) {
        return contacts.get(contactID);
    }

    // Deletes a contact by its ID
    public boolean deleteContact(String contactID) {
        if (contacts.containsKey(contactID)) {
            contacts.remove(contactID);
            return true;
        }
        return false;
    }

    // Updates a contact by its ID
    public boolean updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            return false;
        }
        
        // Ensure the new values are valid before updating
        validateContactInfo(firstName, lastName, phone, address);

        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
        return true;
    }

    // Method to validate contact information
    private void validateContactInfo(String firstName, String lastName, String phone, String address) {
        if (firstName == null || firstName.length() > 10 || firstName.isEmpty()) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (lastName == null || lastName.length() > 10 || lastName.isEmpty()) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        if (address == null || address.length() > 30 || address.isEmpty()) {
            throw new IllegalArgumentException("Invalid address");
        }
    }
}