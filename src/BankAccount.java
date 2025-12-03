import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BankAccount {
    private static int nextAccountNo = 100001;

    private int accountNumber;
    private double balance;
    private ArrayList<String> history = new ArrayList<>();

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.accountNumber = nextAccountNo++;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    private String time() {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
    }

    public void deposit(double amount) {
        balance += amount;
        history.add(time() + " | Deposited ₹" + amount);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        history.add(time() + " | Withdrawn ₹" + amount);
        return true;
    }

    public boolean transfer(double amount, User receiver) {
        if (amount > balance) return false;
        balance -= amount;
        history.add(time() + " | Transferred ₹" + amount + " to " + receiver.getUserId());
        receiver.getAccount().deposit(amount);
        return true;
    }
}
