import java.util.*;

/**
 * author: Jaslyn
 * version: 4.0
 */

public class Main {
    public static void main(String args[]){
        System.out.println("Train Consist Management App: ");

        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Engine"); //testing duplicate property
        System.out.println("Final Train Formation: " + formation);
    }
}
