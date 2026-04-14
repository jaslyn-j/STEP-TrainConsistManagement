import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * author: Jaslyn
 * @version 12.0
 */
public class Main{
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type  = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " - " + cargo;
        }
    }
    public static boolean isSafetyCompliant(List<GoodsBogie> bogies) {
        Predicate<GoodsBogie> safetyRule = bogie ->
                !bogie.type.equalsIgnoreCase("Cylindrical")
                        || bogie.cargo.equalsIgnoreCase("Petroleum");

        return bogies.stream().allMatch(safetyRule);
    }

    public static void main(String[] args) {

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open","Coal"));
        goodsBogies.add(new GoodsBogie("Box","Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical","Coal"));   // violation

        System.out.println("Goods Bogies in Train:");
        goodsBogies.forEach(System.out::println);

        boolean isSafe = isSafetyCompliant(goodsBogies);

        System.out.println("\nSafety Compliance Status: " + isSafe);
        System.out.println(isSafe ? "Train formation is SAFE" : "Train formation is NOT SAFE");

    }
}