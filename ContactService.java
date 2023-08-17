package service;
import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private Map<String, ContactClass> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }
 
    public void addContact(ContactClass contact) {
        String contactID = contact.getContactID();

        if (contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contactID, contact);
    }  

    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactID);
    }

    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        ContactClass contact = contacts.get(contactID);

        if (firstName == null || firstName.length() > 10) {
                throw new IllegalArgumentException("Invalid first name");
            }
            contact.firstName = firstName;

        if (lastName == null || lastName.length() > 10) {
                throw new IllegalArgumentException("Invalid last name");
            }
            contact.lastName = lastName;

        if (phone == null || phone.length() != 10) {
                throw new IllegalArgumentException("Invalid phone");
            }
            contact.phone = phone;

        if (address == null || address.length() >= 30) {
                throw new IllegalArgumentException("Invalid address");
            }
            contact.address = address;
    }
    public ContactClass getContact(String contactID) {
        return contacts.get(contactID);
    }

}
