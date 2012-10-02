/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CreateChangeUser.java
 *
 * Created on 7-feb-2010, 19:30:32
 */

package View;

import Controller.Controller;
import Model.User;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class CreateChangeUser extends javax.swing.JInternalFrame {


    User user = null;
    /** Creates new form CreateChangeUser */
    public CreateChangeUser(User user) {
        initComponents();
        this.user = user;

        User.Rank ranks[] = User.Rank.values();
        for(User.Rank r : ranks){
            cmbBoxType.addItem(r);
        }
        cmbBoxType.setSelectedItem(User.Rank.user);

        if(user != null){
            fillUser(user);
        }

             
    }


    private void fillUser(User user){
        txtFieldUserName.setText(user.getUsername());
        txtFieldPassword.setText(user.getPassword());
        cmbBoxType.setSelectedItem(user.getRank());
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtFieldUserName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbBoxType = new javax.swing.JComboBox();
        txtFieldPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(flyaway.FlyAWayApp.class).getContext().getResourceMap(CreateChangeUser.class);
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        txtFieldUserName.setText(resourceMap.getString("txtFieldUserName.text")); // NOI18N
        txtFieldUserName.setName("txtFieldUserName"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        cmbBoxType.setName("cmbBoxType"); // NOI18N

        txtFieldPassword.setText(resourceMap.getString("txtFieldPassword.text")); // NOI18N
        txtFieldPassword.setName("txtFieldPassword"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        btnSave.setText(resourceMap.getString("btnSave.text")); // NOI18N
        btnSave.setName("btnSave"); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClose.setText(resourceMap.getString("btnClose.text")); // NOI18N
        btnClose.setName("btnClose"); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblError.setText(resourceMap.getString("lblError.text")); // NOI18N
        lblError.setName("lblError"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClose))
                    .addComponent(txtFieldPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(txtFieldUserName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(cmbBoxType, javax.swing.GroupLayout.Alignment.LEADING, 0, 126, Short.MAX_VALUE))
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnClose)))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String userName = txtFieldUserName.getText();

        char[] pw = txtFieldPassword.getPassword();
        String password = new String(pw);

        userName.trim();
        password.trim();
        if(!userName.isEmpty() && !password.isEmpty()){

            if(user == null){
                

                User u = new User();

                u.setUsername(userName);
                u.setPassword(password, false);
                u.setRank((User.Rank)cmbBoxType.getSelectedItem());

                if(Controller.Instance().addUser(u)){
                    JOptionPane.showMessageDialog(this, "User saved");
                       this.dispose();
                }
                else{
                    lblError.setText("UserName already exsists");
                }
            }
            else{
                User u = new User();
                u.CopyUser(user);
                u.setUsername(userName);
                u.setPassword(password, false);

                u.setRank((User.Rank)cmbBoxType.getSelectedItem());

                if(Controller.Instance().ChangeUser(user, u))
                {
                    JOptionPane.showMessageDialog(this, "User saved");
                    this.dispose();
                }
                else{
                    lblError.setText("Change User failed username already exsists");
                }
            }
        }
        else{
            lblError.setText("Please enter a correct username and or password");
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbBoxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblError;
    private javax.swing.JPasswordField txtFieldPassword;
    private javax.swing.JTextField txtFieldUserName;
    // End of variables declaration//GEN-END:variables

}
