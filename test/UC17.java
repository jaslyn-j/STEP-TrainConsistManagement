import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UC17{

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] names = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        Main.sortBogieNames(names);
        assertArrayEquals(
                new String[]{"AC Chair", "First Class", "General", "Luxury", "Sleeper"},
                names,
                "Names should be sorted alphabetically");
    }

    @Test
    void testSort_UnsortedInput() {
        String[] names = {"Luxury", "General", "Sleeper", "AC Chair"};
        Main.sortBogieNames(names);
        assertArrayEquals(
                new String[]{"AC Chair", "General", "Luxury", "Sleeper"},
                names,
                "Unsorted input should be rearranged alphabetically");
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] names = {"AC Chair", "First Class", "General"};
        Main.sortBogieNames(names);
        assertArrayEquals(
                new String[]{"AC Chair", "First Class", "General"},
                names,
                "Already sorted array must remain unchanged");
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] names = {"Sleeper", "AC Chair", "Sleeper", "General"};
        Main.sortBogieNames(names);
        assertArrayEquals(
                new String[]{"AC Chair", "General", "Sleeper", "Sleeper"},
                names,
                "Duplicates must be retained and correctly positioned");
    }

    @Test
    void testSort_SingleElementArray() {
        String[] names = {"Sleeper"};
        Main.sortBogieNames(names);
        assertArrayEquals(new String[]{"Sleeper"}, names,
                "Single element array must remain unchanged");
    }
}