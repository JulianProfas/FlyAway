/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CreateChangeAirportView.java
 *
 * Created on 19-jan-2010, 14:13:19
 */

package View;

import Model.Airport;
import Model.Country;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeroen
 */
public class CreateChangeAirportView extends javax.swing.JInternalFrame {

    private Airport airport = null;
    /** Creates new form CreateChangeAirportView */
    public CreateChangeAirportView(Airport airport) {
        initComponents();
        
        //get all countries
        ArrayList<Country> countries = Controller.Controller.Instance().getCountries();

        //add country choices to combobox selection
        for(Country c:countries){
        cmbBoxCountry.addItem(c);
        }
        
        this.airport = airport;
        if(airport != null){
            fillFields();
        }
    }


    private void fillFields(){
        this.txtFieldCity.setText(airport.getCity());
        this.cmbBoxCountry.setSelectedItem(airport.getCountry());
        //this.txtFieldCountry.setText(airport.getCountry().toString());
        this.txtFieldName.setText(airport.getName());
        this.txtFieldCode.setText(airport.getAirportcode());
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
        txtFieldName = new javax.swing.JTextField();
        txtFieldCity = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblErrorMessage = new javax.swing.JLabel();
        txtFieldCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbBoxCountry = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(flyaway.FlyAWayApp.class).getContext().getResourceMap(CreateChangeAirportView.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        txtFieldName.setText(resourceMap.getString("txtFieldName.text")); // NOI18N
        txtFieldName.setName("txtFieldName"); // NOI18N

        txtFieldCity.setText(resourceMap.getString("txtFieldCity.text")); // NOI18N
        txtFieldCity.setName("txtFieldCity"); // NOI18N

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

        lblErrorMessage.setText(resourceMap.getString("lblErrorMessage.text")); // NOI18N
        lblErrorMessage.setName("lblErrorMessage"); // NOI18N

        txtFieldCode.setText(resourceMap.getString("txtFieldCode.text")); // NOI18N
        txtFieldCode.setName("txtFieldCode"); // NOI18N

        jLabel4.setLabelFor(txtFieldCode);
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        cmbBoxCountry.setName("cmbBoxCountry"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtFieldCity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(txtFieldCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(txtFieldName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxCountry, 0, 193, Short.MAX_VALUE)))
                        .addGap(252, 252, 252))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbBoxCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave)
                        .addComponent(btnCancel))
                    .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtFieldCity, txtFieldName});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String name = txtFieldName.getText();
        Country country = (Country)cmbBoxCountry.getSelectedItem();
        //String country = txtFieldCountry.getText();
        String city = txtFieldCity.getText();
        String code = txtFieldCode.getText();

       String errorMessage = "";
       name = name.trim();
       if(name.isEmpty()){
           errorMessage += "Please fill in a name\n";
       }

       /*country = country.trim();
       if(country.isEmpty()){
           errorMessage += "pleade fill in a country \n";
       } else if (country.length() > 2) {
           errorMessage += "please fill in a valid country code (2 characters max) \n";
       }*/

       city = city.trim();
       if(city.isEmpty()){
           errorMessage += "please fill in a city \n";
       }

       code = code.trim();
       if(code.isEmpty()){
           errorMessage += "please fill in a airport code \n";
       } else if (code.length() > 3) {
           errorMessage += "please fill in a valid airport code (3 characters max) \n";
       }

       if(errorMessage.isEmpty()){
           if(airport == null){
                airport = new Airport();
                airport.setCity(city);
                //Country myCountry = Controller.Controller.Instance().getCountryByCode(txtFieldCountry.getText());
                
                airport.setCountry(country);
                airport.setName(name);
                airport.setAirportcode(code);


                if(Controller.Controller.Instance().AddAirport(airport)){
                     JOptionPane.showMessageDialog(this, "Airport saved");
                     this.dispose();
                }
                else{
                    errorMessage = "Unable to save Airport";
                }
           }
           else{
               Airport airportNew = new Airport();
               airportNew.setCity(city);
               //Country myCountry = Controller.Controller.Instance().getCountryByCode(txtFieldCountry.getText());
               airportNew.setCountry(country);
               airportNew.setName(name);
               airportNew.setAirportcode(code);

               if(Controller.Controller.Instance().ChangeAirport(airportNew, airport)){
                   JOptionPane.showMessageDialog(this, "Airport saved");
                   this.dispose();
               }
               else{
                   errorMessage = "Unable to change Airport";
               }
           }           
       }
      
       lblErrorMessage.setText(""+errorMessage);
       
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbBoxCountry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JTextField txtFieldCity;
    private javax.swing.JTextField txtFieldCode;
    private javax.swing.JTextField txtFieldName;
    // End of variables declaration//GEN-END:variables

}
