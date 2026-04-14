import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UC19{

    private static final String[] STANDARD =
            {"BG101", "BG205", "BG309", "BG412", "BG550"};

    @Test
    void testBinarySearch_BogieFound() {
        assertTrue(Main.binarySearch(STANDARD.clone(), "BG309"),
                "BG309 must be found in the sorted array");
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        assertFalse(Main.binarySearch(STANDARD.clone(), "BG999"),
                "BG999 does not exist; must return false");
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        assertTrue(Main.binarySearch(STANDARD.clone(), "BG101"),
                "BG101 at the start must be found");
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        assertTrue(Main.binarySearch(STANDARD.clone(), "BG550"),
                "BG550 at the end must be found");
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        assertTrue(Main.binarySearch(
                        new String[]{"BG101"}, "BG101"),
                "Single element match must return true");
        assertFalse(Main.binarySearch(
                        new String[]{"BG101"}, "BG999"),
                "Single element non-match must return false");
    }

    @Test
    void testBinarySearch_EmptyArray() {
        assertFalse(Main.binarySearch(new String[]{}, "BG101"),
                "Empty array must return false without error");
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        // Method sorts internally before searching
        String[] unsorted = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(Main.binarySearch(unsorted, "BG205"),
                "BG205 must be found even if input was unsorted");
    }
}