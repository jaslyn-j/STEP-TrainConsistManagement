import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase11TrainConsistMgmntTest {
    @Test
    void testValidTrainID() {
        assertTrue(Main.validateTrainId("TRN-1234"),
                "TRN-1234 should be valid");
    }

    @Test
    void testInvalidTrainIDFormat() {
        assertFalse(Main.validateTrainId("TRAIN12"),
                "TRAIN12 should be invalid");
        assertFalse(Main.validateTrainId("TRN12A"),
                "TRN12A should be invalid");
        assertFalse(Main.validateTrainId("1234-TRN"),
                "1234-TRN should be invalid");
    }

    @Test
    void testTrainIDDigitLengthValidation() {
        assertFalse(Main.validateTrainId("TRN-123"),
                "TRN-123 (3 digits) should be invalid");
        assertFalse(Main.validateTrainId("TRN-12345"),
                "TRN-12345 (5 digits) should be invalid");
    }

    @Test
    void testValidCargoCode() {
        assertTrue(Main.validateCargoCode("PET-AB"),
                "PET-AB should be valid");
        assertTrue(Main.validateCargoCode("PET-FH"),
                "PET-FH should be valid");
    }

    @Test
    void testInvalidCargoCodeFormat() {
        assertFalse(Main.validateCargoCode("PET-ab"),
                "PET-ab (lowercase) should be invalid");
        assertFalse(Main.validateCargoCode("PET123"),
                "PET123 (no hyphen) should be invalid");
        assertFalse(Main.validateCargoCode("AB-PET"),
                "AB-PET (reversed) should be invalid");
    }

    @Test
    void testCargoCodeUppercaseValidation() {
        assertFalse(Main.validateCargoCode("PET-aB"),
                "PET-aB should be invalid (mixed case)");
        assertFalse(Main.validateCargoCode("PET-ab"),
                "PET-ab should be invalid (all lowercase)");
    }

    @Test
    void testEmptyInputHandling() {
        assertFalse(Main.validateTrainId(""),
                "Empty Train ID should be invalid");
        assertFalse(Main.validateCargoCode(""),
                "Empty Cargo Code should be invalid");
    }

    @Test
    void testExactPatternMatch() {
        assertFalse(Main.validateTrainId("TRN-1234X"),
                "TRN-1234X has extra char; should be invalid");
        assertFalse(Main.validateCargoCode("PET-ABC"),
                "PET-ABC has 3-letter suffix; should be invalid");
        assertFalse(Main.validateTrainId(" TRN-1234"),
                "Leading space should be invalid");
    }
}