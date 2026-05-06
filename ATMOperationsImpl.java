import java.util.Scanner;

public class ATMOperationsImpl implements ATMOperations {

    double balance = 1000;

    @Override
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    @Override
    public void deposit(double amount) {

        if(amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        }
        else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {

        if(amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        }
        else if(amount > balance) {
            System.out.println("Insufficient balance.");
        }
        else {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        }
    }
}