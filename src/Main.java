import java.util.*;

/**
 * author: Jaslyn
 * version: 6.0
 */

public class Main {
    public static void main(String args[]){
        System.out.println("Train Consist Management App: ");

        Map<String, Integer> capacityMap= new HashMap<>();
        capacityMap.put("First Class", 24);
        capacityMap.put("Cargo", 120);
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);

        for(Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
