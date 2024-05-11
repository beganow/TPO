import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Airport {
    private final int numTerminals;
    private final int numJetways;
    private final int[] destinations;
    private final int[] ranges;

    public Airport(int numTerminals, int numJetways, int[] destinations, int[] ranges) {
        this.numTerminals = numTerminals;
        this.numJetways = numJetways;
        this.destinations = destinations;
        this.ranges = ranges;
    }

    public void operate() {
        ExecutorService terminalExecutor = Executors.newFixedThreadPool(numTerminals);
        ExecutorService jetwayExecutor = Executors.newFixedThreadPool(numJetways);

        for (int i = 0; i < numTerminals; i++) {
            terminalExecutor.execute(new Terminal(i, destinations));
        }

        for (int i = 0; i < numJetways; i++) {
            jetwayExecutor.execute(new Jetway(i, ranges));
        }

        terminalExecutor.shutdown();
        jetwayExecutor.shutdown();
    }
}
