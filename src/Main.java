import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: Jaslyn
 * @version 13.0
 */
public class Main{
    static class Bogie {
        String type;
        int    capacity;

        Bogie(String type, int capacity) {
            this.type     = type;
            this.capacity = capacity;
        }
    }
    static final int CAPACITY_THRESHOLD = 60;

    public static List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > CAPACITY_THRESHOLD) {
                result.add(b);
            }
        }
        return result;
    }
    public static List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > CAPACITY_THRESHOLD)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Bogie> bogies = new ArrayList<>();
        String[] types = {"Sleeper", "AC Chair", "First Class", "Open", "Box"};
        for (int i = 0; i < 100_000; i++) {
            bogies.add(new Bogie(types[i % types.length], 30 + (i % 80)));
        }

        long loopStart  = System.nanoTime();
        List<Bogie> loopResult = filterWithLoop(bogies);
        long loopEnd    = System.nanoTime();
        long loopTime   = loopEnd - loopStart;

        long streamStart  = System.nanoTime();
        List<Bogie> streamResult = filterWithStream(bogies);
        long streamEnd    = System.nanoTime();
        long streamTime   = streamEnd - streamStart;

        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);
    }
}