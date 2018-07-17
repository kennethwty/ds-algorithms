package HashTable;

/**
 * This hash table implementation uses open addressing strategy to handle collision by looking for the next available slot
 * aka. Linear Probing
 */
public class HashTable_LinearProbing {
    private StoredAllStars[] name;

    public HashTable_LinearProbing() {
        name = new StoredAllStars[10];
    }

    // add a player to the table
    public void put(String lastName, String firstName) {
        int hashedKey = hashKey(lastName);
        if(occupied(hashedKey)) {
            int stopIndex = hashedKey;
            // wrapping it to the start of the hash table
            if(hashedKey == name.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }
            // wrapping
            while(occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % name.length;
            }
        }

        // check if it is the stopping index, insert if not
        if(occupied((hashedKey))) {
            System.out.println("Sorry, cannot insert " + firstName + " because the seat is taken by another all-star.");
        } else {
            name[hashedKey] = new StoredAllStars(lastName, firstName);
        }
    }

    // locate a key
    private int findKey(String lastName) {
        int hashedKey = hashKey(lastName);
        // occupied by this player
        if(name[hashedKey] != null && name[hashedKey].lastName.equals(lastName)) {
            return hashedKey;
        } else { // occupied by some one else, loop till it finds it or -1 if none
            int stopIndex = hashedKey;
            // wrapping it to the start of the hash table
            if (hashedKey == name.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }
            // wrapping
            while (hashedKey != stopIndex && name[hashedKey] != null && !name[hashedKey].lastName.equals(lastName)) {
                hashedKey = (hashedKey + 1) % name.length;
            }

            if(name[hashedKey] != null && name[hashedKey].lastName.equals(lastName)) {
                return hashedKey;
            } else {
                return -1;
            }
        }
    }

    public String get(String lastName) {
        int hashedKey = findKey(lastName);
        if(hashedKey == -1)
            return "Error locating the player";
        return name[hashedKey].firstName;
    }

    public String remove(String lastName) {
        // find the key first
        int hashedKey = findKey(lastName);
        // couldn't locate it
        if(hashedKey == -1)
            return null;

        String playerFirstName = name[hashedKey].firstName;
        name[hashedKey] = null;
        return playerFirstName;
    }

    private int hashKey(String lastName) {
        return lastName.length() % name.length;
    }

    private boolean occupied(int index) {
        return name[index] != null;
    }

    public void printHash() {
        for(int i = 0; i < name.length; i++) {
            if(name[i] == null) {
                System.out.print("Empty" + " -> ");
            } else {
                System.out.print(name[i].firstName + " -> ");
            }
        }
        System.out.println("Completed Seating the All-Stars");
    }

    public static void main(String[] args) {
        String[] lastName = {"Bryant", "Rose", "McGrady", "Duncan", "Walker", "James"};
        String[] firstName = {"Kobe", "Derrick", "Tracy", "Tim", "Kamba", "Lebron"};

        HashTable_LinearProbing nameTable = new HashTable_LinearProbing();

        // adding players to the hash table
        for(int i = 0; i < lastName.length; i++) {
            nameTable.put(lastName[i], firstName[i]);
        }

        nameTable.printHash();

        // testing the .get method
        System.out.println("Retrieving Walker's First Name: " + nameTable.get("Walker"));

        // testing the .remove method
        System.out.println();
        System.out.println("Breaking News: Tim Duncan Retired. Removing Tim Duncan from the All-Star List.");
        nameTable.remove("Duncan");
        nameTable.printHash();

        // testing the .remove method
        System.out.println();
        System.out.println("Breaking News: Kobe Bryant and Tracy McGrady Retired At the Same Time. Removing Them from the All-Star List");
        nameTable.remove("Bryant");
        nameTable.remove("McGrady");
        nameTable.printHash();

        // add new players
        System.out.println();
        System.out.println("Western Conference All-Stars Finalists");
        nameTable.put("Anthony", "Carmelo");
        nameTable.put("Curry", "Stephen");
        nameTable.put("Paul", "Chris");
        nameTable.put("Davis", "Anthony");
        nameTable.put("Antetokounmpo", "Giannis");
        nameTable.put("Oladipo", "Victor");
        nameTable.put("Irving", "Kyrie");
        nameTable.printHash();

        // error, list is full
        System.out.println();
        nameTable.put("Wong", "Kenneth");
    }
}
