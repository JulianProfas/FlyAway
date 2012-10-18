/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StaffView.java
 *
 * Created on 19-jan-2010, 10:19:19
 */

package View;

import Controller.Controller;
import Model.PersonnelType;
import Model.Staff;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeroen
 */
public class StaffView extends javax.swing.JInternalFrame implements Observer {

    /** Creates new form StaffView */
    public StaffView() {
        initComponents();
        Controller.Instance().addObserver(this);
        fillTable();
        if (tblPersonnel.getColumnCount() == 5) {
            tblPersonnel.removeColumn(tblPersonnel.getColumnModel().getColumn(0));
        }

    }

    private void fillTable() {
        ArrayList<Staff> rows = Controller.Instance().getStaff();
        tblPersonnel.setModel(new GenericTableModel<Staff>(rows));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSearch = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        txtFieldSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonnel = new javax.swing.JTable();
        lblErrorMessage = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1200, 700));

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(flyaway.FlyAWayApp.class).getContext().getResourceMap(StaffView.class);
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

        btnRemove.setText(resourceMap.getString("btnRemove.text")); // NOI18N
        btnRemove.setName("btnRemove"); // NOI18N
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        txtFieldSearch.setText(resourceMap.getString("txtFieldSearch.text")); // NOI18N
        txtFieldSearch.setName("txtFieldSearch"); // NOI18N
        txtFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFieldSearchKeyPressed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblPersonnel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPersonnel.setName("tblPersonnel"); // NOI18N
        jScrollPane1.setViewportView(tblPersonnel);

        lblErrorMessage.setName("lblErrorMessage"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnChange, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCreate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
                            .addComponent(txtFieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 1164, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChange)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(253, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        CreateChangeStaffView ccsv = new CreateChangeStaffView(null);
        flyaway.FlyAWayApp app = (flyaway.FlyAWayApp)flyaway.FlyAWayApp.getApplication();
        app.getFlyAwayView().addFrame(ccsv);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        int selectedIndex = tblPersonnel.getSelectedRow();

        if(selectedIndex >= 0){
            Staff s = ((GenericTableModel<Staff>)tblPersonnel.getModel()).getRow(selectedIndex);

            CreateChangeStaffView ccsv = new CreateChangeStaffView(s);
            flyaway.FlyAWayApp app = (flyaway.FlyAWayApp)flyaway.FlyAWayApp.getApplication();
            app.getFlyAwayView().addFrame(ccsv);
        }
        else{
            lblErrorMessage.setText("Please select a row first");
        }
    }//GEN-LAST:event_btnChangeActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int selectedIndex = tblPersonnel.getSelectedRow();
        if (selectedIndex >= 0) {
            Staff s = ((GenericTableModel<Staff>) tblPersonnel.getModel()).getRow(selectedIndex);

            if (Controller.Instance().deleteObject(s)) {
                ((GenericTableModel<Staff>) tblPersonnel.getModel()).removeRow(s);
            } else {
                lblErrorMessage.setText("Staff cannot be deleted, because it is used in one or more flights");
            }
        } else {
            lblErrorMessage.setText("Please select a row first");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        searchStaff();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            searchStaff();
        }
    }//GEN-LAST:event_txtFieldSearchKeyPressed

    private void searchStaff() {
        String searchString = txtFieldSearch.getText();
        ArrayList<Staff> foundStaff = new ArrayList<Staff>();

        if (searchString.isEmpty()) {
            foundStaff = Controller.Instance().getStaff();
        } else {
            int searchId = -1;
            try {
                searchId = Integer.parseInt(searchString);
            } catch (NumberFormatException nfe) {
                Logger.getLogger(GenericTableModel.class.getName()).log(Level.FINER, null, nfe.getMessage());
            }

            if (searchId != -1) {
                foundStaff.addAll(Controller.Instance().SearchStaff(searchId));
            }
            PersonnelType st = null;
            try {
                st = (PersonnelType.valueOf(searchString));
            } catch (IllegalArgumentException iae) {
                Logger.getLogger(GenericTableModel.class.getName()).log(Level.FINER, null, iae.getMessage());
            }
            if (st != null) {
                foundStaff.addAll(Controller.Instance().SearchStaff(st));
            }
            foundStaff.addAll(Controller.Instance().SearchStaff(searchString));
        }

        tblPersonnel.setModel(new GenericTableModel<Staff>(foundStaff));

        if (tblPersonnel.getColumnCount() == 5) {
            tblPersonnel.removeColumn(tblPersonnel.getColumnModel().getColumn(0));
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JTable tblPersonnel;
    private javax.swing.JTextField txtFieldSearch;
    // End of variables declaration//GEN-END:variables

    public void update(Observable o, Object arg) {
        if(arg instanceof Staff){
            fillTable();
        }
    }

}
