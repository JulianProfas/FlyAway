/*
 * FlyAWayView.java
 */

package flyaway;


import Controller.Controller;
import Model.Flight;
import Model.Rank;
import Model.User;
import View.AirportView;
import View.FlightView;
<<<<<<< HEAD
import View.LoginView;
=======
import View.GenericTableModel;
>>>>>>> Release4
import View.PlaneView;
import View.ScheduleView;
import View.StaffView;
import View.UserView;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
<<<<<<< HEAD
import javax.swing.JOptionPane;
=======
import threads.Lichtkrant;
>>>>>>> Release4

/**
 * The application's main frame.
 */
public class FlyAWayView extends FrameView {

    public FlyAWayView(SingleFrameApplication app) {
        super(app);

<<<<<<< HEAD
		
        initComponents();        
=======
        initComponents();
        
        //Lichtkrant
        Lichtkrant nlk = new Lichtkrant(tblLk);
        Thread lk = new Thread(nlk);
        lk.start();
        
        
        
        
        
>>>>>>> Release4
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });

        this.getFrame().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.getFrame().addWindowListener(new FlyAwayWindowListener());

        User u = Controller.Instance().getLogedIn();
        lblWelkom.setText("Welcome : " +u.getUsername());
        if(u.getRank() == Rank.admin){
            btnUsers.setEnabled(true);
			btnSchedule.setEnabled(false);
        }else if(u.getRank() == Rank.staff){
			btnAirport.setEnabled(false);
			btnFlight.setEnabled(false);
			btnPlane.setEnabled(false);
			btnStaff.setEnabled(false);
		}else{
			btnSchedule.setEnabled(false);
		}
    }

    public void addFrame(JInternalFrame frame){
         frame.show();
        this.desktopPane.add(frame);
        try {
            frame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FlyAWayView.class.getName()).log(Level.SEVERE, null, ex);
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

        mainPanel = new javax.swing.JPanel();
        btnPlane = new javax.swing.JButton();
        btnStaff = new javax.swing.JButton();
        btnAirport = new javax.swing.JButton();
        btnFlight = new javax.swing.JButton();
        desktopPane = new javax.swing.JDesktopPane();
        btnUsers = new javax.swing.JButton();
        lblWelkom = new javax.swing.JLabel();
        btnSchedule = new javax.swing.JButton();
<<<<<<< HEAD
        btnLogout = new javax.swing.JButton();
=======
        jLKPane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLk = new javax.swing.JTable();
        lblVluchten = new javax.swing.JLabel();
>>>>>>> Release4
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N
<<<<<<< HEAD
        mainPanel.setPreferredSize(new java.awt.Dimension(900, 480));
=======
        mainPanel.setPreferredSize(new java.awt.Dimension(1000, 600));
>>>>>>> Release4

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(flyaway.FlyAWayApp.class).getContext().getResourceMap(FlyAWayView.class);
        btnPlane.setText(resourceMap.getString("btnPlane.text")); // NOI18N
        btnPlane.setName("btnPlane"); // NOI18N
        btnPlane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaneActionPerformed(evt);
            }
        });

        btnStaff.setText(resourceMap.getString("btnStaff.text")); // NOI18N
        btnStaff.setName("btnStaff"); // NOI18N
        btnStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffActionPerformed(evt);
            }
        });

        btnAirport.setText(resourceMap.getString("btnAirport.text")); // NOI18N
        btnAirport.setName("btnAirport"); // NOI18N
        btnAirport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAirportActionPerformed(evt);
            }
        });

        btnFlight.setText(resourceMap.getString("btnFlight.text")); // NOI18N
        btnFlight.setName("btnFlight"); // NOI18N
        btnFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlightActionPerformed(evt);
            }
        });

        desktopPane.setName("desktopPane"); // NOI18N

        btnUsers.setText(resourceMap.getString("btnUsers.text")); // NOI18N
        btnUsers.setEnabled(false);
        btnUsers.setName("btnUsers"); // NOI18N
        btnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });

        lblWelkom.setText(resourceMap.getString("lblWelkom.text")); // NOI18N
        lblWelkom.setName("lblWelkom"); // NOI18N

        btnSchedule.setText(resourceMap.getString("btnSchedule.text")); // NOI18N
        btnSchedule.setName("btnSchedule"); // NOI18N
        btnSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        btnLogout.setText(resourceMap.getString("btnLogout.text")); // NOI18N
        btnLogout.setName("btnLogout"); // NOI18N
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
=======
        jLKPane.setName("jLKPane"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblLk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tblLk.setName("tblLk"); // NOI18N
        jScrollPane1.setViewportView(tblLk);
        tblLk.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tblLk.columnModel.title0")); // NOI18N
        tblLk.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tblLk.columnModel.title1")); // NOI18N
        tblLk.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tblLk.columnModel.title2")); // NOI18N
        tblLk.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("tblLk.columnModel.title3")); // NOI18N
        tblLk.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("tblLk.columnModel.title4")); // NOI18N

        javax.swing.GroupLayout jLKPaneLayout = new javax.swing.GroupLayout(jLKPane);
        jLKPane.setLayout(jLKPaneLayout);
        jLKPaneLayout.setHorizontalGroup(
            jLKPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLKPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLKPaneLayout.setVerticalGroup(
            jLKPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLKPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblVluchten.setText(resourceMap.getString("lblVluchten.text")); // NOI18N
        lblVluchten.setName("lblVluchten"); // NOI18N
>>>>>>> Release4

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelkom, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(559, 559, 559))
            .addGroup(mainPanelLayout.createSequentialGroup()
<<<<<<< HEAD
                .addGap(11, 11, 11)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSchedule, 0, 0, Short.MAX_VALUE)
                    .addComponent(btnPlane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFlight, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(btnAirport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStaff, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUsers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPane))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelkom, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(559, 559, 559))
=======
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPlane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFlight, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(btnAirport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSchedule)))
                .addGap(14, 14, 14)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(lblVluchten)
                        .addContainerGap())
                    .addComponent(jLKPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
>>>>>>> Release4
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelkom, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
                    .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
=======
>>>>>>> Release4
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(btnPlane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnStaff)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAirport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFlight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUsers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
<<<<<<< HEAD
                        .addComponent(btnSchedule)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                        .addComponent(btnLogout)))
=======
                        .addComponent(btnSchedule))
                    .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVluchten)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLKPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> Release4
                .addContainerGap())
        );

        mainPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAirport, btnFlight, btnPlane, btnStaff});

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 604, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaneActionPerformed
       PlaneView pv = new PlaneView();
       addFrame(pv);
    }//GEN-LAST:event_btnPlaneActionPerformed

    private void btnStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffActionPerformed
        StaffView sv = new StaffView();
        addFrame(sv);
    }//GEN-LAST:event_btnStaffActionPerformed

    private void btnAirportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAirportActionPerformed
        AirportView av = new AirportView();
        addFrame(av);
    }//GEN-LAST:event_btnAirportActionPerformed

    private void btnFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlightActionPerformed
        FlightView fv = new FlightView();
        addFrame(fv);
    }//GEN-LAST:event_btnFlightActionPerformed

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        UserView uv = new UserView();
            flyaway.FlyAWayApp app = (flyaway.FlyAWayApp)flyaway.FlyAWayApp.getApplication();
            app.getFlyAwayView().addFrame(uv);
    }//GEN-LAST:event_btnUsersActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed

		System.exit(0);
		
    }//GEN-LAST:event_exitMenuItemActionPerformed

	private void btnScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleActionPerformed
		ScheduleView sv = new ScheduleView();
		flyaway.FlyAWayApp app = (flyaway.FlyAWayApp)flyaway.FlyAWayApp.getApplication();
            app.getFlyAwayView().addFrame(sv);
	}//GEN-LAST:event_btnScheduleActionPerformed

        private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
            this.getFrame().dispose();
            
            LoginView lv = new LoginView();
            flyaway.FlyAWayApp app = (flyaway.FlyAWayApp)flyaway.FlyAWayApp.getApplication();
            app.show(lv);
        }//GEN-LAST:event_btnLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAirport;
    private javax.swing.JButton btnFlight;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPlane;
    private javax.swing.JButton btnSchedule;
    private javax.swing.JButton btnStaff;
    private javax.swing.JButton btnUsers;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JPanel jLKPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblVluchten;
    private javax.swing.JLabel lblWelkom;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JTable tblLk;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    
}
