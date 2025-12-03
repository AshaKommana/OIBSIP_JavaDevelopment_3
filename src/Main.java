import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();

        users.add(new User("user1", "1234", new BankAccount(5000)));
        users.add(new User("user2", "5678", new BankAccount(8000)));
        users.add(new User("asha",  "9999", new BankAccount(12000)));

        ATM atm = new ATM(users);
        atm.start();
    }
}
