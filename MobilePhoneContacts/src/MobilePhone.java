import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String phoneNumber) {
        this.myNumber = phoneNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {

        if (findContact(contact) != -1) {
            return false;
        } else {
            return myContacts.add(contact);
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        if (findContact(oldContact) == -1) {
            System.out.println("Contact doesn't exist");
            return false;
        } else if (findContact(newContact.getName()) > -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exists");
        }
        myContacts.set(findContact(oldContact.getName()), newContact);
        System.out.println("Succesfully updated contact " + oldContact.getName() + " with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        return findContact(contact) != -1 && myContacts.remove(contact);
    }

    private int findContact(Contact queryContact) {
        return findContact(queryContact.getName());
    }

    private int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName) {

        for (Contact contact : myContacts) {
            if (contact.getName().equals(contactName)) {
                return contact;
            }
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        int counter = 1;
        for (Contact contact : myContacts) {
            System.out.println(counter++ + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }

}