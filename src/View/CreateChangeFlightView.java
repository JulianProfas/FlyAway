/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CreateChangeFlightView.java
 *
 * Created on 26-jan-2010, 14:30:08
 */

package View;

import Controller.Controller;
import Model.Airport;
import Model.Flight;
import Model.Staff;
import Model.Plane;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;


/**
 *
 * @author Jeroen
 */
public class CreateChangeFlightView extends javax.swing.JInternalFrame implements KeyListener {
    private enum FieldEditing { PILOT, COPILOT, FROM, DESTINATION, PLANE }

    private FieldEditing currentField = null;

    private Flight flight = null; //The object to save.

    //Objects used to create / change the flight
    private Staff pilot = null;
    private Staff coPilot = null;
    private Airport from = null;
    private Airport destination = null;
    private Plane plane = null;
    private List<Staff> other = new ArrayList<Staff>();
    private Date date = new Date();
    private List<Airport> stops = new ArrayList<Airport>();
  

    


    /** Creates new form CreateChangeFlightView */
    public CreateChangeFlightView(Flight f) {
        initComponents();
        flight = f;
        if(f != null){
			txtFieldNumber.setEditable(false);
            fill(f);
        }
        else{
            //Defaulting date to current date.
			
            DateFormat df = new SimpleDateFormat(Flight.FlightDateFormat);
            txtFieldDate.setText(df.format(new Date()));
        }      

    }

    private void fill(Flight f){
        txtFieldNumber.setText(""+f.getNumber());
        SimpleDateFormat sdf = new SimpleDateFormat(Flight.FlightDateFormat);
        String sdate = sdf.format(f.getDate());
        txtFieldDate.setText(sdate);
        txtFieldCoPilot.setText(f.getPilot().toString());
        txtFieldPilot.setText(f.getCopilot().toString());
        txtFieldDestination.setText(f.getDestination().toString());
        txtFieldFrom.setText(f.getFrom().toString());
        txtFieldPlane.setText(f.getPlane().toString());
        txtPersonal.setText(f.getOtherPersonal().toString());
        txtFieldStops.setText(f.getStops().toString());

        pilot = f.getPilot();
        coPilot = f.getCopilot();
        from = f.getFrom();
        destination = f.getDestination();
        stops = f.getStops();
        plane = f.getPlane();

        other = f.getOtherPersonal();
        date = f.getDate();
    }

    public void keyPressed(KeyEvent e) {
      
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {       
        //Do nothing but we need the function.
    }      

    private void searchPilot(){
        String searchString = txtFieldPilot.getText();
        listSearchResults.setListData(Controller.Instance().SearchStaffPilots(searchString).toArray());
    }

     private void searchCoPilot(){
       
        String searchString = txtFieldCoPilot.getText();
        listSearchResults.setListData(Controller.Instance().SearchStaffPilots(searchString).toArray());

    }

     private void searchFrom(){
        
         String searchString = txtFieldFrom.getText();
         listSearchResults.setListData(Controller.Instance().SearchAirport(searchString).toArray());
     }

     private void searchDestination(){       
         String searchString = txtFieldDestination.getText();
         listSearchResults.setListData(Controller.Instance().SearchAirport(searchString).toArray());
     }    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFieldNumber = new javax.swing.JTextField();
        txtFieldPilot = new javax.swing.JTextField();
        txtFieldCoPilot = new javax.swing.JTextField();
        txtFieldFrom = new javax.swing.JTextField();
        txtFieldDestination = new javax.swing.JTextField();
        txtFieldPlane = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSearchResults = new javax.swing.JList();
        txtFieldDate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        txtPersonal = new javax.swing.JTextField();
        txtFieldStops = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(flyaway.FlyAWayApp.class).getContext().getResourceMap(CreateChangeFlightView.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        txtFieldNumber.setText(resourceMap.getString("txtFieldNumber.text")); // NOI18N
        txtFieldNumber.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("txtFieldCoPilot.border.lineColor"))); // NOI18N
        txtFieldNumber.setName("txtFieldNumber"); // NOI18N

        txtFieldPilot.setBackground(resourceMap.getColor("txtFieldCoPilot.background")); // NOI18N
        txtFieldPilot.setEditable(false);
        txtFieldPilot.setText(resourceMap.getString("txtFieldPilot.text")); // NOI18N
        txtFieldPilot.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("txtFieldCoPilot.border.lineColor"))); // NOI18N
        txtFieldPilot.setMinimumSize(new java.awt.Dimension(20, 6));
        txtFieldPilot.setName("txtFieldPilot"); // NOI18N
        txtFieldPilot.addKeyListener(this);
        txtFieldPilot.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldPilotFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldPilotFocusLost(evt);
            }
        });

        txtFieldCoPilot.setBackground(resourceMap.getColor("txtFieldCoPilot.background")); // NOI18N
        txtFieldCoPilot.setEditable(false);
        txtFieldCoPilot.setText(resourceMap.getString("txtFieldCoPilot.text")); // NOI18N
        txtFieldCoPilot.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("txtFieldCoPilot.border.lineColor"))); // NOI18N
        txtFieldCoPilot.setName("txtFieldCoPilot"); // NOI18N
        txtFieldCoPilot.addKeyListener(this);
        txtFieldCoPilot.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldCoPilotFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldCoPilotFocusLost(evt);
            }
        });

        txtFieldFrom.setBackground(resourceMap.getColor("txtFieldCoPilot.background")); // NOI18N
        txtFieldFrom.setEditable(false);
        txtFieldFrom.setText(resourceMap.getString("txtFieldFrom.text")); // NOI18N
        txtFieldFrom.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("txtFieldCoPilot.border.lineColor"))); // NOI18N
        txtFieldFrom.setName("txtFieldFrom"); // NOI18N
        txtFieldFrom.addKeyListener(this);
        txtFieldFrom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldFromFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldFromFocusLost(evt);
            }
        });

        txtFieldDestination.setBackground(resourceMap.getColor("txtFieldCoPilot.background")); // NOI18N
        txtFieldDestination.setEditable(false);
        txtFieldDestination.setText(resourceMap.getString("txtFieldDestination.text")); // NOI18N
        txtFieldDestination.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("txtFieldCoPilot.border.lineColor"))); // NOI18N
        txtFieldDestination.setName("txtFieldDestination"); // NOI18N
        txtFieldDestination.addKeyListener(this);
        txtFieldDestination.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldDestinationFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldDestinationFocusLost(evt);
            }
        });

        txtFieldPlane.setBackground(resourceMap.getColor("txtFieldCoPilot.background")); // NOI18N
        txtFieldPlane.setEditable(false);
        txtFieldPlane.setText(resourceMap.getString("txtFieldPlane.text")); // NOI18N
        txtFieldPlane.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("txtFieldCoPilot.border.lineColor"))); // NOI18N
        txtFieldPlane.setName("txtFieldPlane"); // NOI18N
        txtFieldPlane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldPlaneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldPlaneFocusLost(evt);
            }
        });

        btnSave.setText(resourceMap.getString("btnSave.text")); // NOI18N
        btnSave.setName("btnSave"); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText(resourceMap.getString("btnCancel.text")); // NOI18N
        btnCancel.setName("btnCancel"); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        listSearchResults.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listSearchResults.setEnabled(false);
        listSearchResults.setName("listSearchResults"); // NOI18N
        listSearchResults.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listSearchResultsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listSearchResults);

        txtFieldDate.setText(resourceMap.getString("txtFieldDate.text")); // NOI18N
        txtFieldDate.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("txtFieldCoPilot.border.lineColor"))); // NOI18N
        txtFieldDate.setName("txtFieldDate"); // NOI18N
        txtFieldDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldDateFocusLost(evt);
            }
        });

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        lblError.setText(resourceMap.getString("lblError.text")); // NOI18N
        lblError.setName("lblError"); // NOI18N

        txtPersonal.setText(resourceMap.getString("txtPersonal.text")); // NOI18N
        txtPersonal.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("txtFieldCoPilot.border.lineColor"))); // NOI18N
        txtPersonal.setName("txtPersonal"); // NOI18N
        txtPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPersonalMouseClicked(evt);
            }
        });

        txtFieldStops.setText(resourceMap.getString("txtFieldStops.text")); // NOI18N
        txtFieldStops.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("txtFieldCoPilot.border.lineColor"))); // NOI18N
        txtFieldStops.setName("txtFieldStops"); // NOI18N
        txtFieldStops.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFieldStopsMouseClicked(evt);
            }
        });

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFieldNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(txtFieldPilot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(txtFieldCoPilot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(txtFieldPlane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(txtPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(txtFieldFrom, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(txtFieldDestination, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(txtFieldDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(txtFieldStops, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldPilot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtFieldCoPilot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFieldFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtFieldDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldStops, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldPlane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldDateFocusLost
        try {
            txtFieldDate.setBackground(Color.WHITE);
            DateFormat d = new SimpleDateFormat(Flight.FlightDateFormat);
            date = d.parse(txtFieldDate.getText());
			
        } catch (ParseException ex) {
            Logger.getLogger(CreateChangeFlightView.class.getName()).log(Level.SEVERE, null, ex);
            txtFieldDate.setBackground(Color.RED);
        }    
		

    }//GEN-LAST:event_txtFieldDateFocusLost

    private void txtFieldPlaneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldPlaneFocusGained
        txtFieldPlane.setBorder(BorderFactory.createLineBorder(Color.orange));
        currentField = FieldEditing.PLANE;
        listSearchResults.setEnabled(true);
        listSearchResults.setListData(Controller.Instance().SearchPlanesAvailable(date).toArray());
    }//GEN-LAST:event_txtFieldPlaneFocusGained

    private void listSearchResultsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listSearchResultsValueChanged
        switch(currentField){
            case PLANE:
                Plane tmpPlane = (Plane)listSearchResults.getSelectedValue();

                if(tmpPlane != null){
                    plane = tmpPlane;
                    txtFieldPlane.setText(plane.toString());
                }
                break;
            case PILOT:
                Staff tmpPilot = (Staff)listSearchResults.getSelectedValue();

                if(tmpPilot != null){
                    pilot = tmpPilot;
                    txtFieldPilot.setText(pilot.toString());
                }
                break;
            case COPILOT:
                Staff tmpCoPilot = (Staff)listSearchResults.getSelectedValue();

                if(tmpCoPilot != null){
                    coPilot = tmpCoPilot;
                    txtFieldCoPilot.setText(coPilot.toString());
                }
                break;
            case FROM:
                Airport tmpFrom = (Airport)listSearchResults.getSelectedValue();

                if(tmpFrom != null){
                    from = tmpFrom;
                    txtFieldFrom.setText(from.toString());
                }
                break;
            case DESTINATION:
                Airport tmpDestination = (Airport)listSearchResults.getSelectedValue();

                if(tmpDestination != null){
                    destination = tmpDestination;
                    txtFieldDestination.setText(destination.toString());
                }
                break;
        }
    }//GEN-LAST:event_listSearchResultsValueChanged

    private void txtFieldPlaneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldPlaneFocusLost
        txtFieldPlane.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        listSearchResults.setEnabled(false);
    }//GEN-LAST:event_txtFieldPlaneFocusLost

    private void txtFieldPilotFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldPilotFocusLost
        txtFieldPilot.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        listSearchResults.setEnabled(false);
    }//GEN-LAST:event_txtFieldPilotFocusLost

    private void txtFieldCoPilotFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldCoPilotFocusLost
        txtFieldCoPilot.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        listSearchResults.setEnabled(false);
    }//GEN-LAST:event_txtFieldCoPilotFocusLost

    private void txtFieldFromFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldFromFocusLost
        txtFieldFrom.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        listSearchResults.setEnabled(false);
    }//GEN-LAST:event_txtFieldFromFocusLost

    private void txtFieldDestinationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldDestinationFocusLost
        txtFieldDestination.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        listSearchResults.setEnabled(false);
    }//GEN-LAST:event_txtFieldDestinationFocusLost

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        lblError.setText("");
		String errorMessage = "<html>";

        if(pilot == null){
            errorMessage += "Please insert a correct pilot <br> ";
        }
        if(coPilot == null){
            errorMessage += "Please insert a correct co pilot <br>";
        }
        if(from == null){
            errorMessage += "Please insert a correct Airfield: From field <br>";
        }
        if(destination == null){
            errorMessage += "Please insert a correct Airfield: Destination Field <br>";
        }
        if(plane == null){
            errorMessage += "Please insert a correct Plane <br>";
        }

        if(pilot != null && coPilot != null && pilot == coPilot){
            errorMessage += "Pilot and CoPilot can't be the same <br>";
        }

        if(destination != null && from != null && destination == from){
            errorMessage += "Destination and From airfield can't be the same <br>";
        }

        if(other.contains(pilot) || other.contains(coPilot)){
            errorMessage += "A pilot or copilot cannot also be registered as other personal <br>";
        }

        if(stops.contains(from) || stops.contains(destination)){
            errorMessage += "An airport cannot be booked as a stop if it is also the origin or the destination <br>";
        }

        if(flight == null){
            Calendar cal = Calendar.getInstance(Locale.FRANCE);
            Date today = new Date(cal.get(Calendar.YEAR) - 1900, cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
            
			DateFormat d = new SimpleDateFormat(Flight.FlightDateFormat);
			
            if(date.before(today)){
                errorMessage += "A flight cannot be booked in the past \n";
            }
			if (!d.format(date).equals(txtFieldDate.getText()))
			{
			    errorMessage = "The date that you provided is invalid.";
			}
        }

        int id = -1;

        try{
            id = Integer.parseInt(txtFieldNumber.getText());
			
			if(Controller.Instance().GetFlight(id) != null && flight == null){
				errorMessage += "Flight already exists with number: " + id + ". <br>";
			}
			
			if(id < 1){
				errorMessage += "Flightnumber is not a valid number <br>";
			}
        }
        catch(NumberFormatException ex){
              Logger.getLogger(CreateChangeFlightView.class.getName()).log(Level.SEVERE, null, ex);
			  
        }
		
		errorMessage += "</html>";

        if(errorMessage.equals("<html></html>")){
            
            if(flight == null){
                flight = new Flight(date, destination, from, id, other, stops, pilot, coPilot, plane, null);
                
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				c.add(Calendar.DATE, 1);
				int returnId = Controller.Instance().getReturnFlightID(id);
				System.out.println(returnId);
				
				Flight returnFlight = new Flight(c.getTime(), from, destination, returnId, other, stops, pilot, coPilot, plane, flight);
				
                if(Controller.Instance().saveObject(flight) && Controller.Instance().saveObject(returnFlight))
				{
					JOptionPane.showMessageDialog(this, "Flights saved");
                    this.dispose();
				}else{
                   JOptionPane.showMessageDialog(this, "Error while saving flights");
				   this.dispose();
                }   
            }
            else{

                flight.setDate(date);
                flight.setDestination(destination);
                flight.setFrom(from);
                flight.setNumber(id);
				flight.setPilot(pilot);
				flight.setCopilot(coPilot);
				flight.setStops(stops);
                flight.setOtherPersonal(other);
                flight.setPlane(plane);
				
				Flight rf = Controller.Instance().getReturnFlight(id);
				
				if(rf != null){
					
					Calendar c = Calendar.getInstance();
					c.setTime(date);
					c.add(Calendar.DATE, 1);
					rf.setDate(c.getTime());
					rf.setDestination(from);
					rf.setFrom(destination);
					rf.setNumber(id + 1);
					rf.setPilot(pilot);
					rf.setCopilot(coPilot);
					rf.setPlane(plane);
					List<Staff> otherReturn = new ArrayList<Staff>();
					otherReturn.addAll(other);
					rf.setOtherPersonal(otherReturn);
					List<Airport> stopsReturn = new ArrayList<Airport>();
					stopsReturn.addAll(stops);
					rf.setStops(stopsReturn);
					
				}
				
				
				if(Controller.Instance().updateObject(flight)){
					JOptionPane.showMessageDialog(this, "Flights Saved");
					this.dispose();
				}else{
					JOptionPane.showMessageDialog(this, "Error while saving flights");
					this.dispose();
				}
				
            }
        }
        else{
            lblError.setText(errorMessage);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPersonalMouseClicked
        final ChildPicker<Staff> staff = new ChildPicker<Staff>(Controller.Instance().SearchStaffAvailable(date), other);

        staff.setVisible(true);
        staff.getOKButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangePersonal(staff.getSelectedObjects());
                staff.dispose();
            }
        });
    }//GEN-LAST:event_txtPersonalMouseClicked

    private void txtFieldStopsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldStopsMouseClicked
        final ChildPicker<Airport> stopAirports = new ChildPicker<Airport>(Controller.Instance().getAirports(), stops);

        stopAirports.setVisible(true);
        stopAirports.getOKButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangeStops(stopAirports.getSelectedObjects());
                stopAirports.dispose();
            }
        });
    }//GEN-LAST:event_txtFieldStopsMouseClicked

    private void txtFieldPilotFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldPilotFocusGained
        txtFieldPilot.setBorder(BorderFactory.createLineBorder(Color.orange));
        currentField = FieldEditing.PILOT;
        listSearchResults.setEnabled(true);
        listSearchResults.setListData(Controller.Instance().SearchStaffPilotsAvailable(date).toArray());        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldPilotFocusGained

    private void txtFieldCoPilotFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldCoPilotFocusGained
        txtFieldCoPilot.setBorder(BorderFactory.createLineBorder(Color.orange));
        currentField = FieldEditing.COPILOT;
        listSearchResults.setEnabled(true);
        listSearchResults.setListData(Controller.Instance().SearchStaffPilotsAvailable(date).toArray());        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCoPilotFocusGained

    private void txtFieldFromFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldFromFocusGained
        txtFieldFrom.setBorder(BorderFactory.createLineBorder(Color.orange));
        currentField = FieldEditing.FROM;
        listSearchResults.setEnabled(true);
        listSearchResults.setListData(Controller.Instance().getAirports().toArray());
    }//GEN-LAST:event_txtFieldFromFocusGained

    private void txtFieldDestinationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldDestinationFocusGained
        txtFieldDestination.setBorder(BorderFactory.createLineBorder(Color.orange));
        currentField = FieldEditing.DESTINATION;
        listSearchResults.setEnabled(true);
        listSearchResults.setListData(Controller.Instance().getAirports().toArray());
    }//GEN-LAST:event_txtFieldDestinationFocusGained

	private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
		this.dispose();
	}//GEN-LAST:event_btnCancelActionPerformed

    private void ChangePersonal(List<Staff> staff){
        other = staff;
        txtPersonal.setText(other.toString());
        txtPersonal.repaint();
    }

    private void ChangeStops(List<Airport> stops){
        this.stops = stops;
        txtFieldStops.setText(stops.toString());
        txtFieldStops.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JList listSearchResults;
    private javax.swing.JTextField txtFieldCoPilot;
    private javax.swing.JTextField txtFieldDate;
    private javax.swing.JTextField txtFieldDestination;
    private javax.swing.JTextField txtFieldFrom;
    private javax.swing.JTextField txtFieldNumber;
    private javax.swing.JTextField txtFieldPilot;
    private javax.swing.JTextField txtFieldPlane;
    private javax.swing.JTextField txtFieldStops;
    private javax.swing.JTextField txtPersonal;
    // End of variables declaration//GEN-END:variables

}
