package bankapp.util;
public interface Transaction {
    void deposit(double amount);

    void withdraw(double amount);
}
