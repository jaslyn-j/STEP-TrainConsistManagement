import java.util.*;

import java.util.stream.Collectors;

/**
 * author: Jaslyn
 * version: 10.0
 */
class Bogie {
    String name;
    int capacity;
    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
    public String toString() {
        return name + " -> " + capacity;
    }
}
public class Main {
    public static void main(String args[]){
        System.out.println(" Train Consist Management App ");
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 70));
        System.out.println("\nBogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
        // UC10: Calculate total seats using map() and reduce()
        int totalSeats = bogies
                .stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);
    }
}
