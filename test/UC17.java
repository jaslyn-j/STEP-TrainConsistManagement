import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UC20{
    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        assertThrows(
                IllegalStateException.class,
                () -> Main.searchBogie(new String[]{}, "BG101"),
                "Empty array must trigger IllegalStateException");
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogies = {"BG101", "BG205"};
        assertDoesNotThrow(
                () -> Main.searchBogie(bogies, "BG101"),
                "Non-empty array must not throw during search");
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};
        assertTrue(Main.searchBogie(bogies, "BG205"),
                "BG205 must be found after passing state validation");
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};
        assertFalse(Main.searchBogie(bogies, "BG999"),
                "BG999 must return false after passing state validation");
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogies = {"BG101"};
        assertTrue(Main.searchBogie(bogies, "BG101"),
                "Single element array must find the matching ID");
    }
}