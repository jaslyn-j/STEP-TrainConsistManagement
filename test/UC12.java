import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UC12{
    private Main.GoodsBogie bogie(String type, String cargo) {
        return new Main.GoodsBogie(type, cargo);
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<Main.GoodsBogie> bogies = List.of(
                bogie("Cylindrical", "Petroleum"),
                bogie("Cylindrical", "Petroleum"),
                bogie("Open",        "Coal")
        );
        assertTrue(Main.isSafetyCompliant(bogies),
                "All cylindrical bogies carry Petroleum; train should be SAFE");
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<Main.GoodsBogie> bogies = List.of(
                bogie("Open", "Coal"),
                bogie("Box",  "Grain"),
                bogie("Open", "Steel")
        );
        assertTrue(Main.isSafetyCompliant(bogies),
                "Non-cylindrical bogies should accept any cargo");
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<Main.GoodsBogie> bogies = new ArrayList<>();
        assertTrue(Main.isSafetyCompliant(bogies),
                "Empty bogie list should return true (no violations)");
    }
    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<Main.GoodsBogie> bogies = List.of(
                bogie("Cylindrical", "Coal")
        );
        assertFalse(Main.isSafetyCompliant(bogies),
                "Cylindrical bogie with Coal should be UNSAFE");
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<Main.GoodsBogie> bogies = List.of(
                bogie("Cylindrical", "Petroleum"),
                bogie("Open",        "Coal"),
                bogie("Box",         "Grain"),
                bogie("Cylindrical", "Coal")
        );
        assertFalse(Main.isSafetyCompliant(bogies),
                "Mixed list with one violating cylindrical should be UNSAFE");
    }
}