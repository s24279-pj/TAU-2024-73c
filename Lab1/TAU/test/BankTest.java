import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank;
    private Map<String, Double> accounts;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        accounts = new HashMap<>();
    }

    @AfterEach
    void tearDown() {
        bank = null;
        accounts = null;
    }

    @Test
    void createAccount_success_whenAccountIsNew() throws BankException {
        bank.createAccount("12345");
        assertNotNull(accounts);
        assertEquals(0.0, bank.checkBalance("12345"));
    }

    @Test
    void createAccount_fails_whenAccountAlreadyExists() throws BankException {
        bank.createAccount("12345");
        bank.createAccount("12345"); // Attempt to create the same account again
        assertEquals(0.0, bank.checkBalance("12345")); // Balance should remain 0.0
    }

    @Test
    void deposit_success_whenAccountExists() throws BankException {
        bank.createAccount("12345");
        bank.deposit("12345", 100.0);
        assertEquals(100.0, bank.checkBalance("12345"));
    }

    @Test
    void deposit_shouldThrowException_whenAccountDoesNotExist() {
        Exception exception = assertThrows(BankException.class, () -> {
            bank.deposit("54321", 50.0); // Attempting to deposit to a non-existent account
        });
        assertEquals("Account does not exist.", exception.getMessage());
    }

    @Test
    void withdraw_success_whenSufficientBalance() throws BankException {
        bank.createAccount("12345");
        bank.deposit("12345", 100.0);
        bank.withdraw("12345", 50.0);
        assertEquals(50.0, bank.checkBalance("12345"));
    }

    @Test
    void withdraw_shouldThrowException_whenInsufficientBalance() throws BankException {
        bank.createAccount("12345");
        bank.deposit("12345", 50.0);
        Exception exception = assertThrows(BankException.class, () -> {
            bank.withdraw("12345", 100.0); // Attempting to withdraw more than the balance
        });
        assertEquals("Insufficient balance.", exception.getMessage());
    }

    @Test
    void withdraw_throwException_whenAccountDoesNotExist() {
        Exception exception = assertThrows(BankException.class, () -> {
            bank.withdraw("54321", 50.0); // Attempting to withdraw from a non-existent account
        });
        assertEquals("Account does not exist.", exception.getMessage());
    }

    @Test
    void checkBalance_success_whenAccountExists() throws BankException {
        bank.createAccount("12345");
        bank.deposit("12345", 200.0);
        assertEquals(200.0, bank.checkBalance("12345"));
    }

    @Test
    void checkBalance_shouldThrowException_whenAccountDoesNotExist() {
        Exception exception = assertThrows(BankException.class, () -> {
            bank.checkBalance("54321"); // Attempting to check balance of a non-existent account
        });
        assertEquals("Account does not exist.", exception.getMessage());
    }

    @Test
    void multipleDeposits_increasesBalance_whenAccountExists() throws BankException {
        bank.createAccount("12345");
        bank.deposit("12345", 50.0);
        bank.deposit("12345", 25.0);
        assertEquals(75.0, bank.checkBalance("12345"));
    }
}
