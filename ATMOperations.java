public interface ATMOperations {

    // Displays the current account balance.
    void checkBalance();

    // Adds money to the account.
    void deposit(double amount);

    // Removes money from the account.
    void withdraw(double amount);
}