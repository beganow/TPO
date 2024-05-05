class Terminal implements Runnable {
    private final int terminalNumber;
    private final int[] destinations;

    public Terminal(int terminalNumber, int[] destinations) {
        this.terminalNumber = terminalNumber;
        this.destinations = destinations;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Логика для посадки/высадки пассажиров через терминал
                int destination = getRandomDestination();
                System.out.println("Terminal " + terminalNumber + ": Passengers boarding/deplaning for destination " + destination);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private int getRandomDestination() {
        int index = (int) (Math.random() * destinations.length);
        return destinations[index];
    }
}