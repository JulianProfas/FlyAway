/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PlaneView.java
 *
 * Created on 14-jan-2010, 12:03:04
 */
package View;

import Controller.Controller;
import Model.Plane;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author user
 */
public class PlaneView extends javax.swing.JInternalFrame implements Observer{

    /** Creates new form PlaneView */
    public PlaneView() {
        initComponents();
        Controller.Instance().addObserver(this);
        fillTable();
    }

    private void fillTable(){
        GenericTableModel<Plane> ptm = new GenericTableModel<Plane>(Controller.Instance().getPlanes());
	tblPlanes.setModel(ptm);
	tblPlanes.removeColumn(tblPlanes.getColumnModel().getColumn(1));
	
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
        tblPlanes = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        txtFieldSearch = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblErrorMessage = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(flyaway.FlyAWayApp.class).getContext().getResourceMap(PlaneView.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblPlanes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPlanes.setName("tblPlanes"); // NOI18N
        jScrollPane1.setViewportView(tblPlanes);

        btnSearch.setText(resourceMap.getString("btnSearch.text")); // NOI18N
        btnSearch.setName("btnSearch"); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtFieldSearch.setText(resourceMap.getString("txtFieldSearch.text")); // NOI18N
        txtFieldSearch.setName("txtFieldSearch"); // NOI18N

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

        btnDelete.setText(resourceMap.getString("btnDelete.text")); // NOI18N
        btnDelete.setName("btnDelete"); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnDelete)
                                .addComponent(btnChange))
                            .addComponent(btnCreate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18)
                        .addComponent(txtFieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                        .addGap(227, 227, 227))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnChange, btnCreate, btnDelete});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChange)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

     /*   ArrayList<Plane> foundPlanes = new ArrayList<Plane>();

        String searchString = txtFieldSearch.getText();

        if (searchString.isEmpty()) {
            foundPlanes = Controller.Instance().getPlanes();
        } else {
            int searchInt = -1;
            try {
                searchInt = Integer.parseInt(searchString);
            } catch (NumberFormatException ex) {
                Logger.getLogger(GenericTableModel.class.getName()).log(Level.FINER, null, ex.getMessage());
            }

            if (searchInt != -1) {
                foundPlanes.addAll(Controller.Instance().SearchPlanes(searchInt));
            }
            foundPlanes.addAll(Controller.Instance().SearchPlanes(searchString));
       
            GenericTableModel<Plane> ptm = new GenericTableModel<Plane>(foundPlanes);
            tblPlanes.setModel(ptm);
        }*/
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int index = tblPlanes.getSelectedRow();

        if(index >= 0){
             Plane p =   ((GenericTableModel<Plane>) tblPlanes.getModel()).getRow(index);
             Controller.Instance().DeletePlane(p);
             ((GenericTableModel<Plane>) tblPlanes.getModel()).removeRow(p);
        }
        else{
            lblErrorMessage.setText("Please select a row first");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        CreateChangePlaneView ccpv = new CreateChangePlaneView(null);

        flyaway.FlyAWayApp app = (flyaway.FlyAWayApp)flyaway.FlyAWayApp.getApplication();
        app.getFlyAwayView().addFrame(ccpv);
        
}//GEN-LAST:event_btnCreateActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        int selected = tblPlanes.getSelectedRow();
         GenericTableModel<Plane> ptm = (GenericTableModel<Plane>)tblPlanes.getModel();

         if(selected >= 0){
             Plane p = ptm.getRow(selected);
             CreateChangePlaneView ccpv = new CreateChangePlaneView(p);

             flyaway.FlyAWayApp app = (flyaway.FlyAWayApp)flyaway.FlyAWayApp.getApplication();
             app.getFlyAwayView().addFrame(ccpv);
         }
         else{
             lblErrorMessage.setBackground(Color.red);
             lblErrorMessage.setText("Please select a row firstbefore update");
         }
    }//GEN-LAST:event_btnChangeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JTable tblPlanes;
    private javax.swing.JTextField txtFieldSearch;
    // End of variables declaration//GEN-END:variables

    public void update(Observable o, Object arg) {
        if(arg instanceof Plane){
            fillTable();
        }
    }
}
