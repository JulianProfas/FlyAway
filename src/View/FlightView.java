/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FlightView.java
 *
 * Created on 25-jan-2010, 16:25:55
 */

package View;

import Controller.Controller;
import Model.Flight;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Jeroen
 */
public class FlightView extends javax.swing.JInternalFrame implements Observer {

    /** Creates new form FlightView */
    public FlightView() {
        initComponents();
        Controller.Instance().addObserver(this);
        ArrayList<Flight> flights = Controller.Instance().getFlights();
    
       fillTableModel(flights);
                 
    }

    private void fillTableModel(ArrayList<Flight> flights){
         GenericTableModel<Flight> flightsModel = new GenericTableModel<Flight>(flights);
         tblFlights.setModel(flightsModel);
          TableColumnModel tcm = tblFlights.getColumnModel();
        CustomTableCellRenderer tcr = new CustomTableCellRenderer();
        for(int it = 0; it < flightsModel.getColumnCount(); it++){
            tcm.getColumn(it).setCellRenderer(tcr);
        }


    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblFlights = new javax.swing.JTable();
        txtFieldSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        lblErrorMessage = new javax.swing.JLabel();

        setClosable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(flyaway.FlyAWayApp.class).getContext().getResourceMap(FlightView.class);
        setForeground(resourceMap.getColor("Form.foreground")); // NOI18N
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblFlights.setName("tblFlights"); // NOI18N
        jScrollPane1.setViewportView(tblFlights);

        txtFieldSearch.setText(resourceMap.getString("txtFieldSearch.text")); // NOI18N
        txtFieldSearch.setName("txtFieldSearch"); // NOI18N

        btnSearch.setText(resourceMap.getString("btnSearch.text")); // NOI18N
        btnSearch.setName("btnSearch"); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnCreate.setText(resourceMap.getString("btnCreate.text")); // NOI18N
        btnCreate.setName("btnCreate"); // NOI18N
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnChange.setText(resourceMap.getString("btnChange.text")); // NOI18N
        btnChange.setName("btnChange"); // NOI18N
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        btnNew.setText(resourceMap.getString("btnNew.text")); // NOI18N
        btnNew.setName("btnNew"); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        lblErrorMessage.setText(resourceMap.getString("lblErrorMessage.text")); // NOI18N
        lblErrorMessage.setName("lblErrorMessage"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnNew))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChange)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNew)))
                .addGap(21, 21, 21)
                .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        CreateChangeFlightView ccfv = new CreateChangeFlightView(null);

        flyaway.FlyAWayApp app = (flyaway.FlyAWayApp)flyaway.FlyAWayApp.getApplication();
        app.getFlyAwayView().addFrame(ccfv);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        int index = tblFlights.getSelectedRow();

        if(index >= 0){

            GenericTableModel<Flight> gtm = (GenericTableModel<Flight>)tblFlights.getModel();
            Flight f = gtm.getRow(index);

			if(f.getReturnFlight() == null){
			
				CreateChangeFlightView ccfv = new CreateChangeFlightView(f);
				 flyaway.FlyAWayApp app = (flyaway.FlyAWayApp)flyaway.FlyAWayApp.getApplication();
				 app.getFlyAwayView().addFrame(ccfv);
			}else{
				lblErrorMessage.setText("You have selected a automatically generated flight, this cannot be changed");
			}
             
        }
        else{
            lblErrorMessage.setText("Please select a row first");
        }
		
		
    }//GEN-LAST:event_btnChangeActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        int index = tblFlights.getSelectedRow();

        if(index >= 0){

			
            GenericTableModel<Flight> gtm = (GenericTableModel<Flight>)tblFlights.getModel();
            Flight f = gtm.getRow(index);
			
			if(f.getReturnFlight() == null){
				
				Controller.Instance().removeFlight(f);
				
			}else{
				
				lblErrorMessage.setText("You have selected a automatically generated flight, this cannot be removed");
			
			}
            
        }
        else{
            lblErrorMessage.setText("Please select a row first");
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String searchDate = txtFieldSearch.getText();
            SimpleDateFormat sdf = new SimpleDateFormat(Flight.FlightDateFormat);
            Date d = sdf.parse(searchDate);
            ArrayList<Flight> foundFlights = Controller.Instance().searchFlight(d);
            
            fillTableModel(foundFlights);

        } catch (ParseException ex) {
            lblErrorMessage.setText("Fill in a correct date in the format "+ Flight.FlightDateFormat);
            Logger.getLogger(FlightView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JTable tblFlights;
    private javax.swing.JTextField txtFieldSearch;
    // End of variables declaration//GEN-END:variables

    public void update(Observable o, Object arg) {
        if(arg instanceof Flight){
            ArrayList<Flight> flights = Controller.Instance().getFlights();
            fillTableModel(flights);
        }
    }

}
