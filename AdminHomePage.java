
package fos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminHomePage extends javax.swing.JFrame {

    /**
     * Creates new form AdminHomePage
     */
    public AdminHomePage() {
        initComponents();
    }
    
    private String adminUserID;
    private String vendorid;
    private String runnerid;
    private String id;
    
    public AdminHomePage(String adminUserID) 
    {
        this.adminUserID = adminUserID;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonPf = new javax.swing.JButton();
        jButtonAR = new javax.swing.JButton();
        jButtonVR = new javax.swing.JButton();
        jButtonRR = new javax.swing.JButton();
        jButtonCR = new javax.swing.JButton();
        jButtonTU = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setText("Home Page");

        jButtonPf.setText("Profile");
        jButtonPf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPfActionPerformed(evt);
            }
        });

        jButtonAR.setText("Admin Registration");
        jButtonAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonARActionPerformed(evt);
            }
        });

        jButtonVR.setText("Vendor Registration");
        jButtonVR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVRActionPerformed(evt);
            }
        });

        jButtonRR.setText("Runner Registration");
        jButtonRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRRActionPerformed(evt);
            }
        });

        jButtonCR.setText("Customer Registration");
        jButtonCR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCRActionPerformed(evt);
            }
        });

        jButtonTU.setText("Top Up");
        jButtonTU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonPf, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAR, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVR, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRR, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(139, 139, 139)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonCR, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonTU, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButtonPf)
                .addGap(18, 18, 18)
                .addComponent(jButtonAR)
                .addGap(18, 18, 18)
                .addComponent(jButtonVR)
                .addGap(18, 18, 18)
                .addComponent(jButtonRR)
                .addGap(18, 18, 18)
                .addComponent(jButtonCR)
                .addGap(18, 18, 18)
                .addComponent(jButtonTU)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonARActionPerformed
        try {
            AdminRegistration ar1 = new AdminRegistration(adminUserID);
            ar1.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(AdminHomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonARActionPerformed

    private void jButtonRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRRActionPerformed
        RunnerRegistration rr1 = new RunnerRegistration(adminUserID);
        rr1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonRRActionPerformed

    private void jButtonPfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPfActionPerformed
        AdminProfile ap1 = new AdminProfile(adminUserID);
        ap1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonPfActionPerformed

    private void jButtonVRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVRActionPerformed
        VendorRegistration vr1 = new VendorRegistration(adminUserID);
        vr1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVRActionPerformed

    private void jButtonCRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCRActionPerformed
        CustomerRegistration cr1 = new CustomerRegistration(adminUserID);
        cr1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCRActionPerformed

    private void jButtonTUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTUActionPerformed
        TopUp tu1 = new TopUp(adminUserID);
        tu1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonTUActionPerformed

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
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminHomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAR;
    private javax.swing.JButton jButtonCR;
    private javax.swing.JButton jButtonPf;
    private javax.swing.JButton jButtonRR;
    private javax.swing.JButton jButtonTU;
    private javax.swing.JButton jButtonVR;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}