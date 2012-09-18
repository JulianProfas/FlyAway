/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class UserSerializer {

    public static boolean writeUsers(String filename, HashMap<String,User> users) {
         ObjectOutputStream outputStream = null;
        boolean result = false;

        try {
            //Construct the LineNumberReader object
            outputStream = new ObjectOutputStream(new FileOutputStream(filename));

            outputStream.writeObject(users);
            result = true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserSerializer.class.getName()).log(Level.SEVERE, null, ex);
        }
       catch (IOException ex) {
                Logger.getLogger(UserSerializer.class.getName()).log(Level.SEVERE, null, ex);
            }
        return result;
    }

    public static HashMap<String,User> readUsers(String filename){

        HashMap<String, User> result = null;
        try {
            ObjectInputStream inputStream = null;
            //Construct the ObjectInputStream object
            inputStream = new ObjectInputStream(new FileInputStream(filename));
            Object obj = null;
            if ((obj = inputStream.readObject()) != null) {
                if (obj instanceof HashMap) {
                    result = (HashMap<String, User>) obj;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserSerializer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserSerializer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
