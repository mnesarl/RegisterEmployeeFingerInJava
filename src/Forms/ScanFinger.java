/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Database.DBConnect;
import FingerprintDevice.Device;
import Helper.TKHelper;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author STN-COM-01
 */
public class ScanFinger extends javax.swing.JFrame {

    private int employeeID;
    private int indexFinger;
    private int templateLength;
    private Device device;
    public int scannedTemplateLength = -1;
    public static int templateID;
    public String dataFinger = "";
    private final DBConnect db = new DBConnect();
    private Home home;

    /**
     * Creates new form ScanFinger
     */
    public ScanFinger() {
        initComponents();
        Initialize();
        setIconImage(Toolkit.getDefaultToolkit().getImage(Toolkit.getDefaultToolkit().getClass().getResource(TKHelper.ICON_PATH)));
    }

    public ScanFinger(int employeeID, int indexFinger, int templateLength, Home home) {
        initComponents();
        this.employeeID = employeeID;
        this.indexFinger = indexFinger;
        this.templateLength = templateLength;
        device = new Device(this);
        this.home = home;
        Initialize();
    }

    private void Initialize() {
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });

        txtPreviousQuality.setText(TKHelper.CalculatePercentageTemplateFingerprint(templateLength));
        txtFingerType.setText(TKHelper.GetFingerType(indexFinger));
    }

    private void handleClosing() {
        this.dispose();
        device.closeDevice();
    }

    public void showMessage(String type, String message) {
        switch (type) {
            case "warning":
                JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
                break;
            case "error":
                JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    public void appendLog(String logMessage) {
        fingerprintLog.setText(logMessage);
    }

    public void displayScannedFingerprint() throws IOException {
        fingerprint.setIcon(new ImageIcon(ImageIO.read(new File("fingerprint.bmp"))));
        txtCurrentQuality.setText(TKHelper.CalculatePercentageTemplateFingerprint(scannedTemplateLength));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFingerType = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCurrentQuality = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPreviousQuality = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnSave = new java.awt.Button();
        btnStart = new java.awt.Button();
        btnStop = new java.awt.Button();
        btnBack = new java.awt.Button();
        jPanel4 = new javax.swing.JPanel();
        fingerprint = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fingerprintLog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register Employee Finger - Scan Finger");
        setBackground(new java.awt.Color(32, 33, 35));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(32, 33, 35));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stn.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(32, 33, 35));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(57, 113, 177));
        jLabel2.setText(":");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 10, -1));

        txtFingerType.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtFingerType.setForeground(new java.awt.Color(57, 113, 177));
        txtFingerType.setText("Finger Type");
        jPanel1.add(txtFingerType, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(57, 113, 177));
        jLabel4.setText("Current Quality");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        txtCurrentQuality.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtCurrentQuality.setForeground(new java.awt.Color(57, 113, 177));
        txtCurrentQuality.setText("0%");
        jPanel1.add(txtCurrentQuality, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(57, 113, 177));
        jLabel6.setText("Previous Quality");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        txtPreviousQuality.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtPreviousQuality.setForeground(new java.awt.Color(57, 113, 177));
        txtPreviousQuality.setText("0%");
        jPanel1.add(txtPreviousQuality, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(57, 113, 177));
        jLabel8.setText("Type");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(57, 113, 177));
        jLabel9.setText(":");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 10, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(57, 113, 177));
        jLabel10.setText(":");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 10, -1));

        btnSave.setBackground(new java.awt.Color(126, 87, 194));
        btnSave.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setLabel("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 100, -1));

        btnStart.setBackground(new java.awt.Color(126, 87, 194));
        btnStart.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnStart.setForeground(new java.awt.Color(255, 255, 255));
        btnStart.setLabel("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        jPanel1.add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 100, -1));

        btnStop.setBackground(new java.awt.Color(153, 153, 255));
        btnStop.setEnabled(false);
        btnStop.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnStop.setForeground(new java.awt.Color(255, 255, 255));
        btnStop.setLabel("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        jPanel1.add(btnStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 100, -1));

        btnBack.setBackground(new java.awt.Color(126, 87, 194));
        btnBack.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setLabel("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 100, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 183, 410, 290));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fingerprint)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fingerprint)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 300, 375));

        fingerprintLog.setEditable(false);
        fingerprintLog.setColumns(20);
        fingerprintLog.setRows(5);
        jScrollPane1.setViewportView(fingerprintLog);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 300, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        device.closeDevice();
        this.home.fetchDataEmployeeByNIK(home.employeeNIK);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        appendLog("Opening the device ...");
        if (this.device.openDevice()) {
            btnStart.setEnabled(false);
            btnStart.setBackground(new Color(153, 153, 255));
            btnStop.setEnabled(true);
            btnStop.setBackground(new Color(126, 87, 194));
        } else {
            appendLog("Open device failed.");
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        this.device.closeDevice();
        btnStop.setEnabled(false);
        btnStop.setBackground(new Color(153, 153, 255));
        btnStart.setEnabled(true);
        btnStart.setBackground(new Color(126, 87, 194));
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (db.checkMySQLConnection(false)) {
            if (employeeID > 0) {
                if (!dataFinger.isEmpty()) {
                    int resultCheck = db.checkDataFingerExist(employeeID, indexFinger);
                    int effective = 1, templateType = 10, flag = 1;
                    switch (resultCheck) {
                        case 0:
                            String query = "INSERT into hr_template (effective, template_type, template_len, template_str, flag, template_index, employee_id) VALUES ("
                                    + effective + "," + templateType + "," + scannedTemplateLength + ",'" + dataFinger + "'," + flag + "," + indexFinger + "," + employeeID + ")";
                            db.execute_query(false, query);
                            JOptionPane.showMessageDialog(this, "Record has been inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 1:
                            if (templateID > 0) {
                                String updateQuery = "UPDATE hr_template set template_len = " + scannedTemplateLength + ", template_str = '" + dataFinger + "' WHERE id = " + templateID;
                                db.execute_query(false, updateQuery);
                                JOptionPane.showMessageDialog(this, "Record has been updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(this, "Invalid Template ID.", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(this, "Error : Something's wrong when connecting to server.", "Warning", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please Scan Your Finger First.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Employee ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error : Failed to connect database server.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScanFinger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScanFinger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScanFinger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScanFinger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScanFinger().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnBack;
    private java.awt.Button btnSave;
    private java.awt.Button btnStart;
    private java.awt.Button btnStop;
    private javax.swing.JLabel fingerprint;
    private javax.swing.JTextArea fingerprintLog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txtCurrentQuality;
    private javax.swing.JLabel txtFingerType;
    private javax.swing.JLabel txtPreviousQuality;
    // End of variables declaration//GEN-END:variables
}
