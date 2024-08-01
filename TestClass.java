// TestClass to demonstrate the functionality of PhonebookManager
public class TestClass {
    public static void main(String[] args) {
        PhonebookManager manager = new PhonebookManager();
        
        // Adding entries to the phonebook
        manager.addEntry("John Doe", "123 Main St", "Seattle", "555-1234");
        manager.addEntry("Jane Smith", "456 Maple Ave", "Bellingham", "555-5678");
        manager.addEntry("Alice Johnson", "789 Elm St", "Seattle", "555-9012");
        
        // Printing the phonebook entries
        System.out.println("Phonebook Entries:");
        manager.printList();
        
        // Modifying an entry
        System.out.println("After modification:");
        manager.modifyEntry("Jane Smith", "Jane Doe", "456 Maple Ave", "Bellingham", "555-8765");
        manager.printList();
        
        // Deleting an entry
        System.out.println("After deletion:");
        manager.deleteEntry("Alice Johnson");
        manager.printList();
    }
}
