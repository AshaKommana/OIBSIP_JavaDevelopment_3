import java.security.MessageDigest;

public class User {
    private String userId;
    private String encryptedPin;
    private BankAccount account;

    public User(String userId, String pin, BankAccount account) {
        this.userId = userId;
        this.encryptedPin = encrypt(pin);
        this.account = account;
    }

    public String getUserId() {
        return userId;
    }

    public BankAccount getAccount() {
        return account;
    }

    public boolean validatePin(String pin) {
        return encryptedPin.equals(encrypt(pin));
    }

    private String encrypt(String pin) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(pin.getBytes());
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) hex.append(String.format("%02x", b));
            return hex.toString();
        } catch (Exception e) {
            return pin;
        }
    }
}
