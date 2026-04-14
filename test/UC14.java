import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UC14{
    @Test
    void testException_ValidCapacityCreation()
            throws Main.InvalidCapacityException {
        Main.PassengerBogie bogie =
                new Main.PassengerBogie("Sleeper", 72);

        assertNotNull(bogie, "Valid bogie must not be null");
    }

    @Test
    void testException_ObjectIntegrityAfterCreation()
            throws Main.InvalidCapacityException {
        Main.PassengerBogie bogie =
                new Main.PassengerBogie("AC Chair", 54);

        assertEquals("AC Chair", bogie.type,     "Bogie type must match");
        assertEquals(54,          bogie.capacity, "Bogie capacity must match");
    }

    @Test
    void testException_MultipleValidBogiesCreation()
            throws Main.InvalidCapacityException {
        Main.PassengerBogie b1 =
                new Main.PassengerBogie("Sleeper",     72);
        Main.PassengerBogie b2 =
                new Main.PassengerBogie("AC Chair",    54);
        Main.PassengerBogie b3 =
                new Main.PassengerBogie("First Class", 24);

        assertNotNull(b1, "First bogie must not be null");
        assertNotNull(b2, "Second bogie must not be null");
        assertNotNull(b3, "Third bogie must not be null");
    }
    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(
                Main.InvalidCapacityException.class,
                () -> new Main.PassengerBogie("Sleeper", -10),
                "Negative capacity should throw InvalidCapacityException"
        );
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(
                Main.InvalidCapacityException.class,
                () -> new Main.PassengerBogie("AC Chair", 0),
                "Zero capacity should throw InvalidCapacityException"
        );
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Main.InvalidCapacityException ex =
                assertThrows(
                        Main.InvalidCapacityException.class,
                        () -> new Main.PassengerBogie("Sleeper", -1)
                );

        assertEquals("Capacity must be greater than zero", ex.getMessage(),
                "Exception message must be exactly 'Capacity must be greater than zero'");
    }
}