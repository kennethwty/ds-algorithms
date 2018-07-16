package HashTable;

/**
 * This is a simple implementation of a hash table backed by an array
 * for basketball players with no handling for any collisions.
 */
public class Simple_HashTable {
    private String[] name;

    // constructor
    public Simple_HashTable() {
        name = new String[10];
    }

    // put a player's first name into the hash table iff the slot isn't taken
    public void put(String lastName, String firstName) {
        int hashedKey = hashKey(lastName);
        // it is occupied
        if(name[hashedKey] != null) {
            System.out.println("Sorry, cannot insert " + firstName + " because the seat is taken by " + name[hashedKey] + ".");
        } else { // open slot, insert the first name of the player into the table
            name[hashedKey] = firstName;
        }
    }

    // retrieve a player's first name given his last name
    public String get(String lastName) {
        int hashedKey = hashKey(lastName);
        return name[hashedKey];
    }

    // print out the hash table
    public void printHash() {
        for(int i = 0; i < name.length; i++) {
            System.out.print(name[i] + " -> ");
        }
        System.out.println("Completed");
    }

    // simple hash function
    private int hashKey(String lastName) {
        return lastName.length() % name.length;
    }

    public static void main(String[] args) {
        String[] lastName = {"Byrant", "Rose", "McGrady", "Duncan", "Walker", "James"};
        String[] firstName = {"Kobe", "Derrick", "Tracy", "Tim", "Kamba", "Lebron"};

        Simple_HashTable nameTable = new Simple_HashTable();

        for(int i = 0; i < lastName.length; i++) {
            nameTable.put(lastName[i], firstName[i]);
        }

        nameTable.printHash();

        System.out.println("Retrieving Rose's First Name: " + nameTable.get("Rose"));
    }
}