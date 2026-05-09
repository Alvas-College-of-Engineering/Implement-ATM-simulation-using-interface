import javax.swing.JOptionPane;

public class ATM implements ATMOperations {

    // Default account balance is set to 1000.
    private double balance = 1000.0;

    @Override
    public void checkBalance() {
        JOptionPane.showMessageDialog(
                null,
                "Current Balance: \u20b9" + String.format("%.2f", balance),
                "Balance Enquiry",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    @Override
    public void deposit(double amount) {
        // Deposit amount must be greater than 0.
        if (amount <= 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "Invalid deposit amount. Please enter an amount greater than 0.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        balance += amount;
        JOptionPane.showMessageDialog(
                null,
                "\u20b9" + String.format("%.2f", amount) + " deposited successfully.\n"
                        + "Updated Balance: \u20b9" + String.format("%.2f", balance),
                "Deposit Successful",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    @Override
    public void withdraw(double amount) {
        // Withdrawal amount must be greater than 0.
        if (amount <= 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "Invalid withdrawal amount. Please enter an amount greater than 0.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Withdrawal should not exceed the available balance.
        if (amount > balance) {
            JOptionPane.showMessageDialog(
                    null,
                    "Insufficient balance. Your current balance is \u20b9" + String.format("%.2f", balance),
                    "Transaction Failed",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        balance -= amount;
        JOptionPane.showMessageDialog(
                null,
                "\u20b9" + String.format("%.2f", amount) + " withdrawn successfully.\n"
                        + "Remaining Balance: \u20b9" + String.format("%.2f", balance),
                "Withdrawal Successful",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
