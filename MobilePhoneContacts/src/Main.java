import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("111 222 333");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printOptions();
        while (!quit) {
            System.out.println("\nChoose action: (6 - to show action list)");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0 -> {
                    System.out.println("\nShutting down...");
                    quit = true;
                }
                case 1 -> mobilePhone.printContacts();
                case 2 -> addNewContact();
                case 3 -> updateContact();
                case 4 -> removeContact();
                case 5 -> queryContact();
                case 6 -> printOptions();
            }

        }


    }


    private static void startPhone() {
        System.out.println("Phone starting...");
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name:");
        String name = scanner.nextLine();
        System.out.println("Enter phone number:");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name + ", phone = " + phone);
        } else {
            System.out.println("Cannot add, " + name + " already exsists");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.print("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record.");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        if(mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Name: " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getPhoneNumber());

    }

    private static void printOptions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("""
                0  - to shutdown
                1  - to print contacts
                2  - to add a new contact
                3  - to update existing an existing contact
                4  - to remove an existing contact
                5  - query if an existing contact exists
                6  - to print a list of available actions.""");
    }

}
