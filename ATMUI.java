import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ATMUI extends JFrame {

    private final ATMOperations atm;

    public ATMUI() {
        this.atm = new ATM();
        setupUI();
    }

    private void setupUI() {
        setTitle("ATM Simulation System");
        setSize(360, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 4 rows, 1 column with spacing for clean button layout.
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

        JButton checkBalanceButton = new JButton("Check Balance");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton exitButton = new JButton("Exit");

        checkBalanceButton.addActionListener(e -> atm.checkBalance());
        depositButton.addActionListener(e -> handleDeposit());
        withdrawButton.addActionListener(e -> handleWithdraw());
        exitButton.addActionListener(e -> dispose());

        panel.add(checkBalanceButton);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(exitButton);

        add(panel);
    }

    private void handleDeposit() {
        String input = JOptionPane.showInputDialog(
                this,
                "Enter amount to deposit:",
                "Deposit",
                JOptionPane.QUESTION_MESSAGE
        );

        if (input == null) {
            return; // User pressed cancel.
        }

        try {
            double amount = Double.parseDouble(input.trim());
            atm.deposit(amount);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid numeric amount.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void handleWithdraw() {
        String input = JOptionPane.showInputDialog(
                this,
                "Enter amount to withdraw:",
                "Withdraw",
                JOptionPane.QUESTION_MESSAGE
        );

        if (input == null) {
            return; // User pressed cancel.
        }

        try {
            double amount = Double.parseDouble(input.trim());
            atm.withdraw(amount);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid numeric amount.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void launch() {
        SwingUtilities.invokeLater(() -> {
            ATMUI atmUI = new ATMUI();
            atmUI.setVisible(true);
        });
    }
}
