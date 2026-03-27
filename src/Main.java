import java.util.*;

/**
 * author: Jaslyn
 * versino: 2.0
 */

public class Main {
    public static void main(String args[]){
        System.out.println("Train Consist Management App: ");

        List<String> passengerBogies=new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        System.out.println("After adding bogies: ");
        System.out.println("Passenger Bogies: "+passengerBogies);
        passengerBogies.remove("AC Chair");
        System.out.println("\nAfter removing AC Chair: ");
        System.out.println("Passenger Bogies: "+passengerBogies);
        System.out.println("\nChecking if 'Sleeper' exists:\nContains Sleeper? "+passengerBogies.contains( "Sleeper"));
        System.out.println("\nFinal train consist: "+passengerBogies);
    }
}
