package HashTable;

/**
 * This hash table implementation uses open addressing strategy to handle collision by looking for the next available slot
 * Also known as Linear Probing, since each increment is called a "Probe"
 */
public class HashTable_LinearProbing {
    private StoredAllStars[] name;

    public HashTable_LinearProbing() {
        name = new StoredAllStars[10];
    }

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
            System.out.println("Sorry, cannot insert " + firstName + " because the seat is taken.");
        } else {
            name[hashedKey] = new StoredAllStars(lastName, firstName);
        }
    }

    private int findKey(String lastName) {
        int hashedKey = hashKey(lastName);
        if(name[hashedKey] != null && name[hashedKey].lastName.equals(lastName)) {
            return hashedKey;
        } else {
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

            if(stopIndex == hashedKey) {
                return -1;
            } else {
                return hashedKey;
            }
        }
    }

    public String get(String lastName) {
        int hashedKey = findKey(lastName);
        if(hashedKey == -1)
            return "Error locating the player";
        return name[hashedKey].firstName;
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
        System.out.println("Finished Seating the All-Stars");
    }

    public static void main(String[] args) {
        String[] lastName = {"Byrant", "Rose", "McGrady", "Duncan", "Walker", "James"};
        String[] firstName = {"Kobe", "Derrick", "Tracy", "Tim", "Kamba", "Lebron"};

        HashTable_LinearProbing nameTable = new HashTable_LinearProbing();

        for(int i = 0; i < lastName.length; i++) {
            nameTable.put(lastName[i], firstName[i]);
        }

        nameTable.printHash();

        System.out.println("Retrieving Walker's First Name: " + nameTable.get("Walker"));
    }
}
