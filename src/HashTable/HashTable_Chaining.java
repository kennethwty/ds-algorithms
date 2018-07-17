package HashTable;

import java.util.LinkedList;
import java.util.ListIterator;

public class HashTable_Chaining {
    private LinkedList<StoredAllStars>[] starsTable;

    // each entry of the 10 slots has a linked list
    public HashTable_Chaining() {
        starsTable = new LinkedList[10];
        for(int i = 0; i < starsTable.length; i++) {
            starsTable[i] = new LinkedList<StoredAllStars>();
        }
    }

    // put a new player into the table
    // trade-off: requires more memory due to the next pointers
    public void put(String lastName, String firstName) {
        int hashedKey = hashKey(lastName);
        starsTable[hashedKey].add(new StoredAllStars(lastName, firstName));
    }

    // given a last name, retrieve the first name of the player
    public String get(String lastName) {
        int hashedKey = hashKey(lastName);
        // using List Iterator to traverse the linked list to locate the player
        ListIterator<StoredAllStars> litr = starsTable[hashedKey].listIterator();
        StoredAllStars star = null;
        while(litr.hasNext()) {
            star = litr.next();
            if(star.lastName.equals(lastName)) {
                return star.firstName;
            }
        }
        // got out of the list and couldn't find the player
        return null;
    }

    public String remove(String lastName) {
        int index = -1;
        int hashedKey = hashKey(lastName);
        // using List Iterator to traverse the linked list to locate the player
        ListIterator<StoredAllStars> litr = starsTable[hashedKey].listIterator();
        StoredAllStars star = null;
        while(litr.hasNext()) {
            star = litr.next();
            index++;
            if(star.lastName.equals(lastName)) {
                break;
            }
        }
        // got out of the loop: either it couldn't find the player or found it and ready to remove it
        if(star == null || !star.lastName.equals(lastName)) {
            return null;
        } else { // found it
            starsTable[hashedKey].remove(index);
            return star.firstName;
        }
    }

    // simple hashing function
    public int hashKey(String lastName) {
        // return lastName.length() % starsTable.length;
        // Using the String class's hashCode method
        return Math.abs(lastName.hashCode() % starsTable.length);
    }

    public void printTable() {
        for(int i = 0; i < starsTable.length; i++) {
            if(starsTable[i].isEmpty()) {
                System.out.println("Position " + i + ": Empty");
            } else {
                System.out.print("Position " + i + ": ");
                ListIterator<StoredAllStars> litr = starsTable[i].listIterator();
                while(litr.hasNext()) {
                    System.out.print(litr.next().firstName);
                    System.out.print(" -> ");
                }
                System.out.println("end");
            }
        }
    }

    public static void main(String[] args) {
        String[] lastName = {"Bryant", "Rose", "McGrady", "Duncan", "Walker", "James"};
        String[] firstName = {"Kobe", "Derrick", "Tracy", "Tim", "Kamba", "Lebron"};

        HashTable_Chaining nameTable = new HashTable_Chaining();

        // adding players to the hash table
        for(int i = 0; i < lastName.length; i++) {
            nameTable.put(lastName[i], firstName[i]);
        }

        nameTable.printTable();

        // testing the .get method
        System.out.println();
        System.out.println("Retrieving McGrady's First Name: " + nameTable.get("McGrady"));

        // testing the .remove method
        System.out.println();
        System.out.println("Breaking News: Tim Duncan Retired. Removing Tim Duncan from the All-Star List.");
        nameTable.remove("Duncan");
        nameTable.printTable();

        // testing the .remove method
        System.out.println();
        System.out.println("Breaking News: Kobe Bryant and Tracy McGrady Retired At the Same Time. Removing Them from the All-Star List");
        nameTable.remove("Bryant");
        nameTable.remove("McGrady");
        nameTable.printTable();

        // add new players
        System.out.println();
        System.out.println("Western Conference All-Stars Finalists");
        nameTable.put("Anthony", "Carmelo");
        nameTable.put("Curry", "Stephen");
        nameTable.put("Durant", "Kevin");
        nameTable.put("Davis", "Anthony");
        nameTable.put("Antetokounmpo", "Giannis");
        nameTable.put("Oladipo", "Victor");
        nameTable.put("Irving", "Kyrie");
        nameTable.printTable();
    }
}
