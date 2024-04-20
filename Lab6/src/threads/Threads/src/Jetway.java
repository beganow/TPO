class Jetway implements Runnable {
    private final int jetwayNumber;
    private final int[] ranges;

    public Jetway(int jetwayNumber, int[] ranges) {
        this.jetwayNumber = jetwayNumber;
        this.ranges = ranges;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Логика для посадки/высадки пассажиров через трап
                int range = getRandomRange();
                System.out.println("Jetway " + jetwayNumber + ": Passengers boarding/deplaning for range " + range);
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private int getRandomRange() {
        int index = (int) (Math.random() * ranges.length);
        return ranges[index];
    }
}