package multithreading;
class BankAccount {
    private int balance = 1000;

    synchronized void withdraw(int amount, String atm) {
        if (balance >= amount) {
            System.out.println(atm + " withdrawing " + amount);
            balance -= amount;
            System.out.println(atm + " completed. Balance: " + balance);
        } else {
            System.out.println(atm + ": Insufficient funds!");
        }
    }
}

class ATM extends Thread {
    private BankAccount account;
    private String atmName;

    public ATM(BankAccount acc, String atmName) {
        this.account = acc;
        this.atmName = atmName;
    }

    public void run() {
        for (int i = 0; i < 3; i++) { // 3 attempts
            account.withdraw(400, atmName);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        ATM atm1 = new ATM(acc, "ATM-1");
        ATM atm2 = new ATM(acc, "ATM-2");

        atm1.start();
        atm2.start();
    }
}
