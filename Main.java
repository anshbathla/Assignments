import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountManager accountManager = new AccountManager();

        while (true) {
            System.out.println("\n1: Add Account\n2: Deposit\n3: Withdraw\n4: Display Account Details");
            System.out.println("5: Calculate Interest\n6: Get Account Count\n7: Get Balance\n8: Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String accName = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    Account account = new Account(accNum, accName, balance);
                    accountManager.addAccount(account);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    String depAcc = scanner.nextLine();
                    Account depAccount = accountManager.findAccount(depAcc);
                    if (depAccount != null) {
                        System.out.print("Enter deposit amount: ");
                        double amount = scanner.nextDouble();
                        depAccount.deposit(amount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    String wAcc = scanner.nextLine();
                    Account wAccount = accountManager.findAccount(wAcc);
                    if (wAccount != null) {
                        System.out.print("Enter withdraw amount: ");
                        double wAmount = scanner.nextDouble();
                        wAccount.withdraw(wAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    String dAcc = scanner.nextLine();
                    accountManager.displayAccountDetails(dAcc);
                    break;
                case 5:
                    System.out.print("Enter account number: ");
                    String cAcc = scanner.nextLine();
                    Account cAccount = accountManager.findAccount(cAcc);
                    if (cAccount != null) {
                        double interest = cAccount.calculateInterest();
                        System.out.println("Calculated Interest: " + interest);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 6:
                    System.out.println("Total accounts: " + Account.getAccountCount());
                    break;
                case 7:
                    System.out.print("Enter account number: ");
                    String bAcc = scanner.nextLine();
                    Account bAccount = accountManager.findAccount(bAcc);
                    if (bAccount != null) {
                        System.out.println("Balance: " + bAccount.getBalance());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
