import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UC16{

    @Test
    void testSort_BasicSorting() {
        int[] capacities = {72, 56, 24, 70, 60};
        Main.bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, capacities,
                "{72,56,24,70,60} should become {24,56,60,70,72}");
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] capacities = {24, 56, 60, 70, 72};
        Main.bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, capacities,
                "Already sorted array must remain unchanged");
    }

    @Test
    void testSort_DuplicateValues() {
        int[] capacities = {72, 56, 56, 24};
        Main.bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 56, 72}, capacities,
                "Duplicate values must be retained and correctly ordered");
    }

    @Test
    void testSort_SingleElementArray() {
        int[] capacities = {50};
        Main.bubbleSort(capacities);
        assertArrayEquals(new int[]{50}, capacities,
                "Single element array must remain unchanged");
    }

    @Test
    void testSort_AllEqualValues() {
        int[] capacities = {40, 40, 40};
        Main.bubbleSort(capacities);
        assertArrayEquals(new int[]{40, 40, 40}, capacities,
                "All equal values must remain unchanged");
    }
}