/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import Model.Flight;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LaptopFreek
 */
public class Lichtkrant implements Runnable {

    public JTable list;

    public Lichtkrant(JTable table) {
        this.list = table;
    }

    @Override
    public void run() {

        //Datum neutraal maken
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date datum = cal.getTime();



        //Flights ophalen
        ArrayList<Flight> flights = new ArrayList<Flight>();
        flights = Controller.Controller.Instance().getFlights();

        //Flight filteren op datum
        ArrayList<Flight> flightsToday = new ArrayList<Flight>();


        for (Flight f : flights) {

            Calendar c = Calendar.getInstance();
            c.setTime(f.getDate());
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            Date flightDatum = c.getTime();

            if (datum.equals(flightDatum)) {
                flightsToday.add(f);
            }
        }

        //Kolomnamen bepalen
        String[] columnNames = {"Flightnumber", "Destination", "From", "Pilot", "Co-Pilot", "Plane"};

        //Object aanmaken
        Object[][] ob = new Object[flightsToday.size()][columnNames.length];

        //Object vullen
        int i = 0;
        for (Flight x : flightsToday) {
            ob[i][0] = x.getNumber();
            ob[i][1] = x.getDestination().toString();
            ob[i][2] = x.getFrom().toString();
            ob[i][3] = x.getPilot().getName();
            ob[i][4] = x.getCopilot().getName();
            ob[i][5] = x.getPlane().getNumber();
            i++;
        }
        //Printobject vullen
        Object[][] pob = new Object[4][columnNames.length];

        if (flightsToday.size() > 4) {
            i = 0;
            while (true) {
                try {
                    if (i + 3 < pob.length) {
                        pob[0] = ob[i];
                        pob[1] = ob[i + 1];
                        pob[2] = ob[i + 2];
                        pob[3] = ob[i + 3];
                    } else if (i + 2 < pob.length) {
                        pob[0] = ob[i];
                        pob[1] = ob[i + 1];
                        pob[2] = ob[i + 2];
                        pob[3] = ob[0];
                    } else if (i + 1 < pob.length) {
                        pob[0] = ob[i];
                        pob[1] = ob[i + 1];
                        pob[2] = ob[0];
                        pob[3] = ob[1];
                    } else if (i < pob.length) {
                        pob[0] = ob[i];
                        pob[1] = ob[0];
                        pob[2] = ob[1];
                        pob[3] = ob[2];
                        i = -1;
                    }
                    i = i + 1;
                    JTable temp = new JTable(pob, columnNames);
                    list.setModel(temp.getModel());
                    Thread.sleep(3000);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Lichtkrant.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (flightsToday.size() == 4) {
            pob = ob;
            JTable temp = new JTable(pob, columnNames);
            list.setModel(temp.getModel());
        }
        if (flightsToday.size() == 3) {
            pob[0] = ob[0];
            pob[1] = ob[1];
            pob[2] = ob[2];
            for (int j = 0; j < columnNames.length; j++) {
                pob[3][j] = "";
            }
            JTable temp = new JTable(pob, columnNames);
            list.setModel(temp.getModel());
        }
        if (flightsToday.size() == 2) {
            pob[0] = ob[0];
            pob[1] = ob[1];
            for (int j = 0; j < columnNames.length; j++) {
                pob[2][j] = "";
            }
            for (int j = 0; j < columnNames.length; j++) {
                pob[3][j] = "";
            }
            JTable temp = new JTable(pob, columnNames);
            list.setModel(temp.getModel());
        }
        if (flightsToday.size() == 1) {
            pob[0] = ob[0];
            for (int j = 0; j < columnNames.length; j++) {
                pob[1][j] = "";
            }
            for (int j = 0; j < columnNames.length; j++) {
                pob[2][j] = "";
            }
            for (int j = 0; j < columnNames.length; j++) {
                pob[3][j] = "";
            }
            JTable temp = new JTable(pob, columnNames);
            list.setModel(temp.getModel());
        }
        if (flightsToday.isEmpty()) {
            for (int j = 0; j < columnNames.length; j++) {
                pob[0][j] = "";
            }
            for (int j = 0; j < columnNames.length; j++) {
                pob[1][j] = "";
            }
            for (int j = 0; j < columnNames.length; j++) {
                pob[2][j] = "";
            }
            for (int j = 0; j < columnNames.length; j++) {
                pob[3][j] = "";
            }
            JTable temp = new JTable(pob, columnNames);
            list.setModel(temp.getModel());
        }


    }
}
