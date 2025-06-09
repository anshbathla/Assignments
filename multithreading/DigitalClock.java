package multithreading;
import java.time.LocalTime;

class DigitalClock extends Thread {
    public void run() {
        while (true) {
            System.out.println("Current Time: " + LocalTime.now());
            try {
                Thread.sleep(1000); // 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DigitalClock().start();
    }
}
