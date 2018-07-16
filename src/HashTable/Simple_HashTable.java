package HashTable;

/**
 * This is a simple implementation of a hash table for basketball players with no handling for any collisions.
 */
public class Simple_HashTable {
    private String[] name;

    public Simple_HashTable() {
        name = new String[10];
    }

    public void put(String lastName, String firstName) {
        int hashedKey = hashKey(lastName);
        if(name[hashedKey] != null) {
            System.out.println("Sorry, cannot insert " + firstName + " because the seat is taken by " + name[hashedKey] + ".");
        } else {
            name[hashedKey] = firstName;
        }
    }

    public String get(String lastName) {
        int hashedKey = hashKey(lastName);
        return name[hashedKey];
    }

    public void printHash() {
        for(int i = 0; i < name.length; i++) {
            System.out.print(name[i] + " -> ");
        }
        System.out.println("Completed");
    }

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
    }
}