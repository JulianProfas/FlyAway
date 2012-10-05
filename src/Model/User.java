/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class User implements Serializable {

    private String username;
    private String password;
    private Rank rank;
    private Staff staffAccount;

    public User() {
        rank = Rank.user;
    }

    public User(String username, Rank rank, Staff staff) {
        this.username = username;
        this.rank = rank;
        this.staffAccount = staff;
    }

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password, boolean hashed) {
        if (password != null && this.password != null) {
            if (this.password.equals(password)) {
                return;
            }
        }

        if (hashed == true) {

            this.password = password;

        } else {

            this.password = this.hash(password);
        }

    }

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Staff getStaffAccount() {
        return staffAccount;
    }

    public void setStaffAccount(Staff staffAccount) {
        this.staffAccount = staffAccount;
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

    @Override
    public String toString() {
        return username;
    }

    //Copy the given user values in the current once
    public void CopyUser(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.rank = user.getRank();
    }
}
