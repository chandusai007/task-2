import java.util.HashMap;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds!");
            return false;
        }
    }
}

public class ATMSimulator {
    private static HashMap<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        // Creating sample accounts
        Account account1 = new Account("11223344", 10000);
        Account account2 = new Account("55667788", 5000);
        accounts.put(account1.getAccountNumber(), account1);
        accounts.put(account2.getAccountNumber(), account2);

        // Simulate ATM operations
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("\nATM Simulator");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.next();

            switch (choice) {
                case "1":
                    deposit(scanner);
                    break;
                case "2":
                    withdraw(scanner);
                    break;
                case "3":
                    transfer(scanner);
                    break;
                case "4":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (!choice.equals("4"));
        scanner.close();
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        if (accounts.containsKey(accountNumber)) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            Account account = accounts.get(accountNumber);
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        if (accounts.containsKey(accountNumber)) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            Account account = accounts.get(accountNumber);
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void transfer(Scanner scanner) {
        System.out.print("Enter your account number: ");
        String senderAccountNumber = scanner.next();
        System.out.print("Enter recipient account number: ");
        String recipientAccountNumber = scanner.next();
        if (accounts.containsKey(senderAccountNumber) && accounts.containsKey(recipientAccountNumber)) {
            System.out.print("Enter transfer amount: ");
            double amount = scanner.nextDouble();
            Account senderAccount = accounts.get(senderAccountNumber);
            Account recipientAccount = accounts.get(recipientAccountNumber);
            if (senderAccount.withdraw(amount)) {
                recipientAccount.deposit(amount);
                System.out.println("Transfer successful.");
                System.out.println("Sender's new balance: " + senderAccount.getBalance());
                System.out.println("Recipient's new balance: " + recipientAccount.getBalance());
            }
        } else {
            System.out.println("One or both accounts not found!");
        }
    }
}
