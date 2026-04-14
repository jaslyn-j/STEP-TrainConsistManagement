import java.util.Arrays;
import java.util.List;

/**
 * author: Jaslyn
 * @version 19.0
 */
public class Main{
    public static boolean binarySearch(String[] bogieIds, String searchId) {
        if (bogieIds == null || bogieIds.length == 0) {
            return false;
        }
        Arrays.sort(bogieIds);

        int low  = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid= low + (high - low) / 2;
            int cmp = searchId.compareTo(bogieIds[mid]);

            if (cmp == 0) {
                return true;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        Arrays.sort(bogieIds);

        String key = "BG309";
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }
        boolean found = binarySearch(bogieIds, key);

        System.out.println();
        if (found) {
            System.out.println("Bogie " + key + " found using Binary Search.");
        } else {
            System.out.println("Bogie " + key + " not found.");
        }
    }
}