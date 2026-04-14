import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

/**
 * author: Jaslyn
 * version: 11.0
 */
public class Main{
    static final String TRAIN_ID_PATTERN  = "TRN-\\d{4}";
    static final String CARGO_CODE_PATTERN = "PET-[A-Z]{2}";

    public static boolean validateTrainId(String trainId) {
        if (trainId == null) return false;
        Pattern pattern = Pattern.compile(TRAIN_ID_PATTERN);
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    public static boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        Pattern pattern = Pattern.compile(CARGO_CODE_PATTERN);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        boolean isTrainIdValid  = validateTrainId(trainId);
        boolean isCargoCodeValid = validateCargoCode(cargoCode);

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: "    + isTrainIdValid);
        System.out.println("Cargo Code Valid: "  + isCargoCodeValid);
        scanner.close();
    }
}
