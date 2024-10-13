import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
    private Map<String, Double> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber) throws BankException {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists.");
        } else {
            accounts.put(accountNumber, 0.0);
        }
    }

    public void deposit(String accountNumber, double amount) throws BankException {
        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber);
            balance += amount;
            accounts.put(accountNumber, balance);
            System.out.println("Deposit successful.");
        } else {
            throw new BankException("Account does not exist.");
        }
    }

    public void withdraw(String accountNumber, double amount) throws BankException {
        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber);
            if (balance >= amount) {
                balance -= amount;
                accounts.put(accountNumber, balance);
                System.out.println("Withdrawal successful.");
            } else {
                throw new BankException("Insufficient balance.");
            }
        } else {
            throw new BankException("Account does not exist.");
        }
    }

    public double checkBalance(String accountNumber) throws BankException {
        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber);
            System.out.println("Account Balance: " + balance);
            return balance; // Return the actual balance
        } else {
            throw new BankException("Account does not exist.");
        }
    }

    public static void main(String[] args) throws BankException {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBank Account Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    bank.createAccount(accountNumber);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    try {
                        bank.deposit(accountNumber, depositAmount);
                    } catch (BankException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    try {
                        bank.withdraw(accountNumber, withdrawAmount);
                    } catch (BankException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    try {
                        bank.checkBalance(accountNumber);
                    } catch (BankException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
