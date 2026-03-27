import java.util.*;

/**
 * author: Jaslyn
 * version: 3.0
 */

public class Main {
    public static void main(String args[]){
        System.out.println("Train Consist Management App: ");

        Set<String>  bogies= new HashSet<String>();

        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");
        //duplicate entries test
        bogies.add("BG101");
        bogies.add("BG102");

        System.out.println("Bogie IDs after insertion:\n" + bogies);

        System.out.println("\nNote:\nDuplicates are automatically ignore by hashset");

    }
}
