import java.util.Arrays;
import java.util.List;

/**
 * author: Jaslyn
 * @version 20.0
 */
public class Main{
    public static boolean searchBogie(String[] bogieIds, String searchId) {
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException(
                    "No bogies available in train. Cannot perform search.");
        }
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] bogieIds = {};
        String searchId = "BG101";

        if (bogieIds.length == 0) {
            throw new IllegalStateException(
                    "No bogies available in train. Cannot perform search.");
        }
        boolean found = false;
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Bogie " + searchId + " found.");
        } else {
            System.out.println("Bogie " + searchId + " not found.");
        }
    }
}