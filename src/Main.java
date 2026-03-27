import java.util.*;

import java.util.stream.Collectors;

/**
 * author: Jaslyn
 * version: 6.0
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
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("General", 90));
        System.out.println("\nAll Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
        List<Bogie> filteredBogies = bogies
                .stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        for (Bogie b : filteredBogies) {
            System.out.println(b);
        }
    }
}
