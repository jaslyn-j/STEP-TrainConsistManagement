import java.util.*;

/**
 * author: Jaslyn
 * version: 4.0
 */

public class Main {
    public static void main(String args[]){
        System.out.println("Train Consist Management App: ");

        List<String> trainConsist = new LinkedList<>();

        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");
        System.out.println("Initial Train Consist: \n" + trainConsist);
        trainConsist.add(2, "Pantry Car");
        System.out.println("After insert Pantry Car at index 2: \n" + trainConsist);
        trainConsist.removeFirst();
        trainConsist.removeLast();
        System.out.println("After removing first and last bogies: \n" + trainConsist);
        System.out.println("Final Train Consist: \n" + trainConsist);
    }
}
