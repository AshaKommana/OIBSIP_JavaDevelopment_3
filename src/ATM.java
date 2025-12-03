import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    private ArrayList<User> users;
    private User loggedInUser;
    private Scanner sc = new Scanner(System.in);

    public ATM(ArrayList<User> users) {
        this.users = users;
    }

    public void start() {
        System.out.println(ConsoleColors.CYAN + "\n══════════════════════════════════════");
        System.out.println("        WELCOME TO JAVA ATM SYSTEM     ");
        System.out.println("══════════════════════════════════════\n" + ConsoleColors.RESET);

        login();
        menu();
    }

    private void login() {
        while (true) {
            System.out.print("Enter User ID: ");
            String id = sc.nextLine();

            System.out.print("Enter PIN: ");
            String pin = sc.nextLine();

            for (User u : users) {
                if (u.getUserId().equals(id) && u.validatePin(pin)) {
                    loggedInUser = u;
                    System.out.println(ConsoleColors.GREEN + "\nLogin Successful!" + ConsoleColors.RESET);
                    return;
                }
            }
            System.out.println(ConsoleColors.RED + "Invalid credentials! Try again.\n" + ConsoleColors.RESET);
        }
    }

    private void menu() {
        int choice;

        do {
            System.out.println(ConsoleColors.PURPLE + "\n════════════ ATM MENU ════════════");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.println("═══════════════════════════════════" + ConsoleColors.RESET);
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println(ConsoleColors.RED + "Please enter a valid number!" + ConsoleColors.RESET);
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showHistory();
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    deposit();
                    break;

                case 4:
                    transfer();
                    break;

                case 5:
                    System.out.println(ConsoleColors.CYAN + "Thank you for using ATM!" + ConsoleColors.RESET);
                    break;

                default:
                    System.out.println(ConsoleColors.RED + "Invalid choice!" + ConsoleColors.RESET);
            }


        } while (choice != 5);
    }

    private void showHistory() {
        System.out.println(ConsoleColors.YELLOW + "\n--- Transaction History ---" + ConsoleColors.RESET);
        for (String t : loggedInUser.getAccount().getHistory()) {
            System.out.println(t);
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();

        if (amt <= 0) {
            System.out.println(ConsoleColors.RED + "Invalid amount!" + ConsoleColors.RESET);
            return;
        }

        if (loggedInUser.getAccount().withdraw(amt))
            System.out.println(ConsoleColors.GREEN + "Withdrawal Successful!" + ConsoleColors.RESET);
        else
            System.out.println(ConsoleColors.RED + "Insufficient Balance!" + ConsoleColors.RESET);
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();

        if (amt <= 0) {
            System.out.println(ConsoleColors.RED + "Invalid amount!" + ConsoleColors.RESET);
            return;
        }

        loggedInUser.getAccount().deposit(amt);
        System.out.println(ConsoleColors.GREEN + "Deposit Successful!" + ConsoleColors.RESET);
    }

    private void transfer() {
        System.out.print("Enter receiver User ID: ");
        String receiverId = sc.next();

        User receiver = null;
        for (User u : users) {
            if (u.getUserId().equals(receiverId)) receiver = u;
        }

        if (receiver == null) {
            System.out.println(ConsoleColors.RED + "User not found!" + ConsoleColors.RESET);
            return;
        }

        System.out.print("Enter amount to transfer: ");
        double amt = sc.nextDouble();

        if (loggedInUser.getAccount().transfer(amt, receiver))
            System.out.println(ConsoleColors.GREEN + "Transfer Successful!" + ConsoleColors.RESET);
        else
            System.out.println(ConsoleColors.RED + "Insufficient Balance!" + ConsoleColors.RESET);
    }
}
