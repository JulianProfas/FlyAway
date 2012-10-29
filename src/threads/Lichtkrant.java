/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import Model.Flight;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LaptopFreek
 */
public class Lichtkrant implements Runnable {
    
    public ArrayList<Flight> list;
    
    public Lichtkrant(){
        
    }

    @Override
    public void run() {

            //method 2
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            
            list = Controller.Controller.Instance().getFlightsLK(cal);
            
    }
}
