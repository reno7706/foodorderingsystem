/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fos;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class VendorRegistration extends javax.swing.JFrame 
{
    private DefaultTableModel vendorDetails = new DefaultTableModel();
    private String column [] = {"UserID", "Username", "Working Hours", "Email", "Phone Number", "Password"};

    /**
     * Creates new form VendorRegistration
     */
    public VendorRegistration(String adminUserID) {
        initComponents();
        this.adminUserID=adminUserID;
        vendorDetails.setColumnIdentifiers(column);
        loadDetails();
    }
    
    public VendorRegistration()
    {
        initComponents();
        vendorDetails.setColumnIdentifiers(column);
        loadDetails();
    }
    
    private String adminUserID;
    private String selectedUserID;
    private String vendorid;
    
    public void loadDetails() 
    {
        Registration rV = new Registration();
        vendorDetails.setRowCount(0); 

        try 
        {
            List<Vendor> vendorList = rV.readVendor();
            for (Vendor vd : vendorList) 
            {
                Object[] rowData = 
                {
                    vd.getVendorid(),
                    vd.getVendorname(),
                    vd.getWorkinghours(),
                    vd.getEmail(),
                    vd.getPhonenum(),
                    vd.getPassword(),
                };
                vendorDetails.addRow(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private User getUserForVendorUserID(String vendorid) 
    {
        Registration rV = new Registration();
        
        try 
        {
            List<User> userList = rV.readUser();

            for (User user : userList) 
            {
                if (user.getUserID().equals(vendorid)) 
                {
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldVID = new javax.swing.JTextField();
        jTextFieldVUN = new javax.swing.JTextField();
        jTextFieldVWH = new javax.swing.JTextField();
        jTextFieldVEm = new javax.swing.JTextField();
        jTextFieldVPN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonVC = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonVE = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonVD = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldVPw = new javax.swing.JTextField();
        jButtonVBTHP = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableV = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Working Hours : ");

        jLabel5.setText("Email : ");

        jLabel6.setText("Phone Number : ");

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setText("Vendor");

        jButtonVC.setText("Create");
        jButtonVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVCActionPerformed(evt);
            }
        });

        jLabel2.setText("UserID : ");

        jButtonVE.setText("Edit");
        jButtonVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVEActionPerformed(evt);
            }
        });

        jLabel3.setText("Username : ");

        jButtonVD.setText("Delete");
        jButtonVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVDActionPerformed(evt);
            }
        });

        jLabel7.setText("Password : ");

        jButtonVBTHP.setText("Back To Home Page");
        jButtonVBTHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVBTHPActionPerformed(evt);
            }
        });

        jTableV.setModel(vendorDetails);
        jTableV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableVMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonVC)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonVE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldVID, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(jTextFieldVUN, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(jTextFieldVWH, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(jTextFieldVEm, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(jTextFieldVPN, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(jTextFieldVPw)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButtonVD)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jButtonVBTHP)))
                .addContainerGap(334, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonVE)
                                .addComponent(jButtonVD)
                                .addComponent(jButtonVC))
                            .addComponent(jButtonVBTHP)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldVID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldVUN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldVWH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldVEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldVPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldVPw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVBTHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVBTHPActionPerformed
        AdminHomePage hp1 = new AdminHomePage(adminUserID);
        hp1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVBTHPActionPerformed

    private void jButtonVCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVCActionPerformed
        String vendorid = jTextFieldVID.getText();
        String vendorname = jTextFieldVUN.getText();
        String workinghours = jTextFieldVWH.getText();
        String email = jTextFieldVEm.getText();
        String phonenum = jTextFieldVPN.getText();
        String password = jTextFieldVPw.getText();
        
        Registration rv = new Registration();
        
        Vendor nV = null;
        try {
            nV = rv.registerVendor(vendorid, vendorname, workinghours, email, phonenum, password);
        } catch (IOException ex) {
            Logger.getLogger(VendorRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object[] rowData = 
        {
            nV.getVendorid(), 
            nV.getVendorname(),
            nV.getWorkinghours(),
            nV.getEmail(), 
            nV.getPhonenum(),
            nV.getPassword()       
        };
        vendorDetails.addRow(rowData);

        clearTextField();
    }//GEN-LAST:event_jButtonVCActionPerformed

    private void jButtonVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVEActionPerformed
        int row = jTableV.getSelectedRow();

        if (row == -1) {
        // No row selected, show an error or return
            return;
        }
        
        String selectedUserID = jTextFieldVID.getText();
        String newWorkinghours = jTextFieldVWH.getText();
        String newEmail = jTextFieldVEm.getText();
        String newPhoneNumber = jTextFieldVPN.getText();
        
        
        Registration ev = new Registration();
        
        DefaultTableModel vendorDetails = (DefaultTableModel) jTableV.getModel();
        vendorDetails.setValueAt(newWorkinghours, row, 2);
        vendorDetails.setValueAt(newEmail, row, 3);
        vendorDetails.setValueAt(newPhoneNumber, row, 4);
        
        try {
            ev.editVendor(selectedUserID, newWorkinghours, newEmail, newPhoneNumber);
        }catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
    }//GEN-LAST:event_jButtonVEActionPerformed

    private void jButtonVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVDActionPerformed
        int row = jTableV.getSelectedRow();
        Registration dv = new Registration();
        if(row == -1)
        {
            JOptionPane.showMessageDialog(this, "Please select a row");
        }
        else
        {
            String selectedUserID = String.valueOf(vendorDetails.getValueAt(row, 0));
            
            try 
            {
                dv.deleteVendor(selectedUserID);
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception according to your application's needs
            }
            
            vendorDetails.removeRow(row);
            clearTextField();
        }
    }//GEN-LAST:event_jButtonVDActionPerformed

    private void jTableVMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVMouseReleased
        int row = jTableV.getSelectedRow();

        String vendorid = String.valueOf(vendorDetails.getValueAt(row,0));

        User selectedUser = getUserForVendorUserID(vendorid);
        
        String vendorname = String.valueOf(vendorDetails.getValueAt(row,1));
        String workinghours = String.valueOf(vendorDetails.getValueAt(row, 2));
        String email = String.valueOf(vendorDetails.getValueAt(row,3));
        String phonenum = String.valueOf(vendorDetails.getValueAt(row,4));
        String password = String.valueOf(vendorDetails.getValueAt(row,5));
        
        jTextFieldVID.setText(vendorid);
        jTextFieldVUN.setText(vendorname);
        jTextFieldVWH.setText(workinghours);
        jTextFieldVEm.setText(email);
        jTextFieldVPN.setText(phonenum);
        jTextFieldVPw.setText(password);
    }//GEN-LAST:event_jTableVMouseReleased

    public void clearTextField()
    {
        jTextFieldVID.setText("");
        jTextFieldVUN.setText("");
        jTextFieldVWH.setText("");
        jTextFieldVEm.setText("");
        jTextFieldVPN.setText("");
        jTextFieldVPw.setText("");
        
        Registration rcv = new Registration();
    }
    
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
            java.util.logging.Logger.getLogger(VendorRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendorRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendorRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendorRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendorRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVBTHP;
    private javax.swing.JButton jButtonVC;
    private javax.swing.JButton jButtonVD;
    private javax.swing.JButton jButtonVE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableV;
    private javax.swing.JTextField jTextFieldVEm;
    private javax.swing.JTextField jTextFieldVID;
    private javax.swing.JTextField jTextFieldVPN;
    private javax.swing.JTextField jTextFieldVPw;
    private javax.swing.JTextField jTextFieldVUN;
    private javax.swing.JTextField jTextFieldVWH;
    // End of variables declaration//GEN-END:variables
}