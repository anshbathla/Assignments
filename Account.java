public class Account extends BankAccount implements Transaction {
    private double balance;

    private static int accountCount = 0;
    private static final String BANK_NAME = "MyBank";

    public Account(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName);
        this.balance = balance;
        accountCount++;
    }

    // Implement deposit
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Implement withdraw
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance!");
        }
    }

    // Override calculateInterest
    @Override
    public double calculateInterest() {
        double interestRate = 0.03; // Example interest rate
        return balance * interestRate;
    }

    // Final method
    public final String getBankName() {
        return BANK_NAME;
    }

    // Static method
    public static int getAccountCount() {
        return accountCount;
    }

    // Getters and setters
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
                ", Account Holder: " + accountHolderName +
                ", Balance: " + balance;
    }
}
