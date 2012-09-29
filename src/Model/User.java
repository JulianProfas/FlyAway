package Model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User implements java.io.Serializable {

    private String username;
    private Staff staff;
    private String password;
    private String rank;

    public User() {
    }

    public User(String username, String password, String rank) {
        this.username = username;
        this.password = password;
        this.rank = rank;
    }

    public User(String username, Staff staff, String password, String rank) {
        this.username = username;
        this.staff = staff;
        this.password = password;
        this.rank = rank;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Staff getStaff() {
        return this.staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword(String password, boolean hashed) {
        if (password != null && this.password != null) {
            if (this.password.equals(password)) {
                return;
            }
        }

        if (hashed == true) {
            this.password = this.hash(password);
        } else {
            this.password = password;
        }
    }

    public String getRank() {
        return this.rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    private String hash(String password) {
        String result = "";

        String plaintext = password;
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        m.reset();
        m.update(plaintext.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashtext = bigInt.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        result = hashtext;

        return result;
    }
}
