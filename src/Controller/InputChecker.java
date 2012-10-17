/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tom
 */
public class InputChecker {

    public InputChecker() {
    }

    public boolean checkText(String text, boolean numbersAllowed, boolean spacesAllowed) {

        text = text.trim();

        if (!text.isEmpty()) {

            if (numbersAllowed == true && spacesAllowed == true) {

                if (text.matches("[A-Za-z0-9 ]+")) {
                    return true;
                }
            } else if (numbersAllowed == true && spacesAllowed == false) {

                if (text.matches("[A-Za-z0-9]+")) {
                    return true;
                }
            } else if (numbersAllowed == false && spacesAllowed == true) {

                if (text.matches("[A-Za-z ]+")) {
                    return true;
                }
            } else {

                if (text.matches("[A-Za-z]+")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkNumberRange(int number, int minValue, int maxValue) {

        if (number >= minValue && number <= maxValue) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkNumber(String text) {

        text = text.trim();
        int i = -1;

        try {
            i = Integer.parseInt(text);

            return true;

        } catch (Exception ex) {
            Logger.getLogger(InputChecker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean checkDate(String text) {

        text = text.trim();
        Date date;

        try {

            DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
            date = d.parse(text);

            if (d.format(date).equals(text)) {
                return true;
            }

        } catch (ParseException ex) {
            Logger.getLogger(InputChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean checkMaxLength(String text, int maxLength) {

        text = text.trim();
        if (text.length() <= maxLength) {
            return true;
        }

        return false;
    }

    public boolean checkSpecificLength(String text, int specificLength) {

        text = text.trim();
        if (text.length() == specificLength) {
            return true;
        }

        return false;
    }

    public boolean checkUppercaseOnly(String text) {

        text = text.trim();
        if (text.matches("[A-Z]+")) {
            return true;
        }
        return false;
    }
}
