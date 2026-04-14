import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UC13{

    private List<Main.Bogie> buildDataset() {
        List<Main.Bogie> bogies = new ArrayList<>();
        bogies.add(new Main.Bogie("Sleeper",72));
        bogies.add(new Main.Bogie("AC Chair",54));
        bogies.add(new Main.Bogie("First Class", 48));
        bogies.add(new Main.Bogie("Open",80));
        bogies.add(new Main.Bogie("Box",61));
        return bogies;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Main.Bogie> result =Main.filterWithLoop(buildDataset());

        assertEquals(3, result.size(),"Loop filter should return exactly 3 bogies with capacity > 60");

        assertTrue(result.stream()
                        .allMatch(b -> b.capacity > Main.CAPACITY_THRESHOLD),
                "All loop-filtered bogies must have capacity > 60");
    }

    @Test
    void testStreamFilteringLogic() {
        List<Main.Bogie> result =Main.filterWithStream(buildDataset());

        assertEquals(3, result.size(),
                "Stream filter should return exactly 3 bogies with capacity > 60");

        assertTrue(result.stream()
                        .allMatch(b -> b.capacity > Main.CAPACITY_THRESHOLD),
                "All stream-filtered bogies must have capacity > 60");
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Main.Bogie> dataset = buildDataset();
        int loopCount   = Main.filterWithLoop(dataset).size();
        int streamCount = Main.filterWithStream(dataset).size();

        assertEquals(loopCount, streamCount,
                "Loop and stream filtering must return the same number of bogies");
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Main.Bogie> dataset = buildDataset();

        long start   = System.nanoTime();
        Main.filterWithLoop(dataset);
        long elapsed = System.nanoTime() - start;

        // Elapsed time must be positive
        assertTrue(elapsed > 0,
                "Elapsed time measured by System.nanoTime() must be > 0");
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Main.Bogie> largeBogies = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            largeBogies.add(new Main.Bogie("Type-" + i, 30 + (i % 80)));
        }

        List<Main.Bogie> loopResult =Main.filterWithLoop(largeBogies);
        List<Main.Bogie> streamResult =Main.filterWithStream(largeBogies);

        assertNotNull(loopResult,   "Loop result must not be null");
        assertNotNull(streamResult, "Stream result must not be null");
        assertEquals(loopResult.size(), streamResult.size(),
                "Large dataset: loop and stream counts must match");

        assertTrue(loopResult.stream()
                        .allMatch(b -> b.capacity > Main.CAPACITY_THRESHOLD),
                "All bogies in large dataset loop result must have capacity > 60");
    }
}