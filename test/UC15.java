import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UC15{

    private Main.GoodsBogie bogie(String shape) {
        return new Main.GoodsBogie(shape);
    }

    @Test
    void testCargo_SafeAssignment() {
        Main.GoodsBogie b = bogie("Cylindrical");
        assertDoesNotThrow(() -> b.assignCargo("Petroleum"),
                "Cylindrical bogie with Petroleum should assign safely");
        assertEquals("Petroleum", b.cargo,
                "Cargo field must be set after successful assignment");
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        Main.GoodsBogie b = bogie("Rectangular");
        assertDoesNotThrow(() -> b.assignCargo("Petroleum"),
                "Exception should be caught inside assignCargo; app must not crash");
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        Main.GoodsBogie b = bogie("Rectangular");
        b.assignCargo("Petroleum");
        assertNull(b.cargo,
                "Rectangular bogie must NOT store Petroleum after failed assignment");
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        Main.GoodsBogie b1 = bogie("Cylindrical");
        Main.GoodsBogie b2 = bogie("Rectangular");
        Main.GoodsBogie b3 = bogie("Cylindrical");

        assertDoesNotThrow(() -> {
            b1.assignCargo("Petroleum");
            b2.assignCargo("Petroleum");
            b3.assignCargo("Coal");
        }, "Program must continue executing after an unsafe assignment");

        assertEquals("Petroleum", b1.cargo);
        assertNull(b2.cargo);
        assertEquals("Coal", b3.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        Main.GoodsBogie safe   = bogie("Cylindrical");
        Main.GoodsBogie unsafe = bogie("Rectangular");

        safe.assignCargo("Petroleum");
        unsafe.assignCargo("Petroleum");

        assertEquals("Cylindrical", safe.shape);
        assertEquals("Rectangular", unsafe.shape);
    }
}