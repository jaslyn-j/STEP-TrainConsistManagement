import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UC18{
    private static final String[] STANDARD =
            {"BG101", "BG205", "BG309", "BG412", "BG550"};

    @Test
    void testSearch_BogieFound() {
        assertTrue(Main.linearSearch(STANDARD, "BG309"),
                "BG309 exists in the array and must be found");
    }

    @Test
    void testSearch_BogieNotFound() {
        assertFalse(Main.linearSearch(STANDARD, "BG999"),
                "BG999 does not exist; must return false");
    }

    @Test
    void testSearch_FirstElementMatch() {
        assertTrue(Main.linearSearch(STANDARD, "BG101"),
                "BG101 is at index 0; must be found immediately");
    }

    @Test
    void testSearch_LastElementMatch() {
        assertTrue(Main.linearSearch(STANDARD, "BG550"),
                "BG550 is the last element; must still be found");
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] single = {"BG101"};
        assertTrue(Main.linearSearch(single, "BG101"),
                "Single element array with matching ID must return true");
        assertFalse(Main.linearSearch(single, "BG999"),
                "Single element array with non-matching ID must return false");
    }
}