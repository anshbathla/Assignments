package multithreading;
class EvenOddPrinter {
    private int number = 1;
    private final int MAX = 50;

    synchronized void printOdd() {
        while (number <= MAX) {
            while (number % 2 == 0) { // Wait if not odd
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number <= MAX) {
                System.out.println("Odd: " + number++);
                notify();
            }
        }
    }

    synchronized void printEven() {
        while (number <= MAX) {
            while (number % 2 == 1) { // Wait if not even
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number <= MAX) {
                System.out.println("Even: " + number++);
                notify();
            }
        }
    }

    public static void main(String[] args) {
        EvenOddPrinter printer = new EvenOddPrinter();
        Thread t1 = new Thread(printer::printOdd);
        Thread t2 = new Thread(printer::printEven);

        t1.start();
        t2.start();
    }
}
