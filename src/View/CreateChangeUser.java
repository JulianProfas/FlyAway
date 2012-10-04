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

import Controller.InputChecker;
import Model.Rank;
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

        cmbBoxType.addItem(Rank.user);
		cmbBoxType.addItem(Rank.admin);
        cmbBoxType.setSelectedItem(Rank.user);

        if(user != null){
			
			if(user.getRank().equals(Rank.staff)){
				cmbBoxType.addItem(Rank.staff);
			}else{
				cmbBoxType.addItem(Rank.user);
				cmbBoxType.addItem(Rank.admin);
			}
			
			txtFieldUserName.setEditable(false);
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
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClose))
                            .addComponent(txtFieldPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(txtFieldUserName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(cmbBoxType, javax.swing.GroupLayout.Alignment.LEADING, 0, 126, Short.MAX_VALUE))
                        .addGap(110, 110, 110))))
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
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
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
		Rank r = (Rank)cmbBoxType.getSelectedItem();
		
		InputChecker ip = new InputChecker();
		
		lblError.setText("");
		String errorMessage = "<html>";
		
		if(ip.checkText(userName, isClosed, isClosed)){
			
			if(Controller.Controller.Instance().getUserByUsername(userName) != null && user == null){
				errorMessage += "User already exists with username: " + userName + ". <br> ";
			}
			
		}else{
			errorMessage += "Username is not a valid word. <br>";
		}
		
		if(!ip.checkText(password, true, false)){
			errorMessage += "No spaces allowed in password. <br>";
		}
		
		errorMessage += "</html>";
		
        if(errorMessage.equals("<html></html>")){

            if(user == null){
                
                user = new User(userName, r, null);
                user.setPassword(password, false);

                if(Controller.Controller.Instance().saveObject(user)){
                    JOptionPane.showMessageDialog(this, "User saved");
                    this.dispose();
                }else{
					JOptionPane.showMessageDialog(this, "Error while saving user");
                    this.dispose();
				}
               
            }
            else{
				
                user.setUsername(userName);
                user.setPassword(password, false);
                user.setRank((Rank)cmbBoxType.getSelectedItem());
				
                if(Controller.Controller.Instance().updateObject(user)){
                    JOptionPane.showMessageDialog(this, "User saved");
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Error while saving user");
                    this.dispose();
                }
            }
        }
        else{
            lblError.setText(errorMessage);
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
