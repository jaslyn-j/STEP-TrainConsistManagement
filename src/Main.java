import java.util.Arrays;
import java.util.List;

/**
 * author: Jaslyn
 * @version 17.0
 */
public class Main{
    public static void sortBogieNames(String[] bogieNames) {
        Arrays.sort(bogieNames);
    }

    public static void main(String[] args) {
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));
        sortBogieNames(bogieNames);

        System.out.println("\nSorted Bogie Names: ");
        System.out.println(Arrays.toString(bogieNames));

    }
}