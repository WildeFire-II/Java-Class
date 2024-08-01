// PhonebookManager class to manage the phonebook entries
public class PhonebookManager {
    private ListNode head; // Reference to the first node in the list

    // Constructor to initialize the phonebook manager
    public PhonebookManager() {
        head = null; // Initially, the list is empty
    }

    // Method to add an entry to the phonebook
    public void addEntry(String name, String address, String city, String phoneNumber) {
        ListNode newNode = new ListNode(name, address, city, phoneNumber);
        if (head == null) {
            head = newNode; // If the list is empty, set head to the new node
        } else {
            ListNode current = head;
            while (current.getNext() != null) {
                current = current.getNext(); // Traverse to the end of the list
            }
            current.setNext(newNode); // Add the new node at the end
        }
        sortByName(); // Sort the list by name after adding a new entry
    }

    // Method to delete an entry by name
    public void deleteEntry(String name) {
        if (head == null) return; // If the list is empty, return

        if (head.getName().equals(name)) {
            head = head.getNext(); // If the head node matches, delete it
            return;
        }

        ListNode current = head;
        while (current.getNext() != null && !current.getNext().getName().equals(name)) {
            current = current.getNext(); // Find the node to be deleted
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext()); // Delete the node
        }
    }

    // Method to modify an existing entry
    public void modifyEntry(String oldName, String newName, String newAddress, String newCity, String newPhoneNumber) {
        ListNode current = head;
        while (current != null) {
            if (current.getName().equals(oldName)) {
                current.setName(newName);
                current.setAddress(newAddress);
                current.setCity(newCity);
                current.setPhoneNumber(newPhoneNumber);
                sortByName(); // Sort the list after modification
                return;
            }
            current = current.getNext();
        }
    }

    // Method to sort the list by name
    public void sortByName() {
        if (head == null || head.getNext() == null) return;

        ListNode sorted = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.getNext();
            if (sorted == null || sorted.getName().compareTo(current.getName()) > 0) {
                current.setNext(sorted);
                sorted = current;
            } else {
                ListNode temp = sorted;
                while (temp.getNext() != null && temp.getNext().getName().compareTo(current.getName()) < 0) {
                    temp = temp.getNext();
                }
                current.setNext(temp.getNext());
                temp.setNext(current);
            }
            current = next;
        }
        head = sorted; // Set the head to the new sorted list
    }

    // Method to print all entries in the phonebook
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.println("Name: " + current.getName());
            System.out.println("Address: " + current.getAddress());
            System.out.println("City: " + current.getCity());
            System.out.println("Phone Number: " + current.getPhoneNumber());
            System.out.println("------------");
            current = current.getNext();
        }
    }
}
