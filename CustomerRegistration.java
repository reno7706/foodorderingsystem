/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fos;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class CustomerRegistration extends javax.swing.JFrame 
{
    private DefaultTableModel customerDetails = new DefaultTableModel();
    private String column [] = {"UserID", "Phone Number", "Gender", "Age", "Email"};

    /**
     * Creates new form CustomerRegistration
     */
    public CustomerRegistration(String adminUserID) 
    {
        initComponents();
        this.adminUserID=adminUserID;
        customerDetails.setColumnIdentifiers(column);
        loadDetails();
    }
    
    public CustomerRegistration()
    {
        initComponents();
        customerDetails.setColumnIdentifiers(column);
        loadDetails();
    }
    
    private String adminUserID;
    private String selectedUserID;
    
    public void loadDetails() 
    {
        Registration rC = new Registration();
        customerDetails.setRowCount(0); // Clear existing rows

        try 
        {
            List<Customer> customerProfileList = rC.readCustomerProfile();
            for (Customer ct : customerProfileList) 
            {
                Object[] rowData = 
                {
                    ct.getId(),
                    ct.getPhoneNumber(),
                    ct.getGender(),
                    ct.getAge(),
                    ct.getEmail()                    
                };
                customerDetails.addRow(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void displayPassword(String id) 
    {
        Registration rC = new Registration();

        try 
        {
            List<User> userList = rC.readUser();

            for (User user : userList) 
            {
                if (id.equals(user.getUserID())) 
                {
                    jTextFieldCPw.setText(user.getPassword());
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void displayUsername(String id) 
    {
        Registration rC = new Registration();

        try 
        {
            List<User> userList = rC.readUser();

            for (User user : userList) 
            {
                if (id.equals(user.getUserID())) 
                {
                    jTextFieldCUN.setText(user.getUsername());
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void displayBalance(String id) 
    {
        Registration rC = new Registration();

        try 
        {
            List<Customer> customerList = rC.readCustomer();

            for (Customer cust : customerList) 
            {
                if (id.equals(cust.getId())) 
                {
                    double balance = cust.getBalance();
                    jTextFieldCB.setText(String.valueOf(balance));
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private User getUserForCustomerUserID(String id) 
    {
        Registration rC = new Registration();
        
        try 
        {
            List<User> userList = rC.readUser();

            for (User user : userList) 
            {
                if (user.getUserID().equals(id)) 
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
        jTextFieldCID = new javax.swing.JTextField();
        jTextFieldCUN = new javax.swing.JTextField();
        jTextFieldCPw = new javax.swing.JTextField();
        jTextFieldCB = new javax.swing.JTextField();
        jTextFieldCPN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonCBTHP = new javax.swing.JButton();
        jButtonCC = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonCE = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonCD = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableC = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldCG = new javax.swing.JTextField();
        jTextFieldCA = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCEm = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Password : ");

        jLabel5.setText("Balance : ");

        jLabel6.setText("Phone Number : ");

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setText("Customer");

        jButtonCBTHP.setText("Back To Home Page");
        jButtonCBTHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCBTHPActionPerformed(evt);
            }
        });

        jButtonCC.setText("Create");
        jButtonCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCCActionPerformed(evt);
            }
        });

        jLabel2.setText("UserID : ");

        jButtonCE.setText("Edit");
        jButtonCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCEActionPerformed(evt);
            }
        });

        jLabel3.setText("Username : ");

        jButtonCD.setText("Delete");
        jButtonCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCDActionPerformed(evt);
            }
        });

        jTableC.setModel(customerDetails);
        jTableC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableCMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableC);

        jLabel7.setText("Gender : ");

        jLabel8.setText("Age : ");

        jLabel9.setText("Email : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldCID, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCUN, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCPw, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCB, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCPN, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCG)
                                    .addComponent(jTextFieldCA)
                                    .addComponent(jTextFieldCEm))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButtonCC)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCD)
                        .addGap(182, 182, 182)
                        .addComponent(jButtonCBTHP)))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldCID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldCUN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldCPw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldCPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldCG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldCEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCE)
                        .addComponent(jButtonCD)
                        .addComponent(jButtonCC))
                    .addComponent(jButtonCBTHP))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCBTHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCBTHPActionPerformed
        AdminHomePage hp1 = new AdminHomePage(adminUserID);
        hp1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCBTHPActionPerformed

    private void jButtonCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCCActionPerformed
        String id = jTextFieldCID.getText();
        String username = jTextFieldCUN.getText();
        String password = jTextFieldCPw.getText();
        String balanceStr = jTextFieldCB.getText();
        String phoneNumber = jTextFieldCPN.getText();
        String gender = jTextFieldCG.getText();
        String age = jTextFieldCA.getText();
        String email = jTextFieldCEm.getText();
        
        double balance = Double.parseDouble(balanceStr);
        
        Registration rc = new Registration();
        
        
        Customer nC = new Customer();

        
        try {
            nC = rc.registerCustomer(id, username, password, balance, phoneNumber, gender, age, email);
        
            Object[] rowData = 
            {
                nC.getId(), 
                nC.getPhoneNumber(),
                nC.getGender(),
                nC.getAge(),
                nC.getEmail()
            };
            customerDetails.addRow(rowData);
            } catch (IOException ex) {
                Logger.getLogger(CustomerRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }

        clearTextField();


    }//GEN-LAST:event_jButtonCCActionPerformed

    private void jButtonCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCEActionPerformed
        int row = jTableC.getSelectedRow();

        if (row == -1) {
        // No row selected, show an error or return
            return;
        }
        
        String selectedUserID = jTextFieldCID.getText();
        
        String newPhoneNumber = jTextFieldCPN.getText();
        String newGender = jTextFieldCG.getText();
        String newAge = jTextFieldCA.getText();
        String newEmail = jTextFieldCEm.getText();
        
        
        Registration ec = new Registration();
        
        DefaultTableModel customerDetails = (DefaultTableModel) jTableC.getModel();
        customerDetails.setValueAt(newPhoneNumber, row, 1);
        customerDetails.setValueAt(newGender, row, 2);
        customerDetails.setValueAt(newAge, row, 3);
        customerDetails.setValueAt(newEmail, row, 4);
        
        
        try {
            ec.editCustomer(selectedUserID, newPhoneNumber, newGender, newAge, newEmail);
        }catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
        
        clearTextField();
    }//GEN-LAST:event_jButtonCEActionPerformed

    private void jButtonCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCDActionPerformed
        int row = jTableC.getSelectedRow();
        Registration dc = new Registration();
        if(row == -1)
        {
            JOptionPane.showMessageDialog(this, "Please select a row");
        }
        else
        {
            String selectedUserID = String.valueOf(customerDetails.getValueAt(row, 0));
            
            try 
            {
                dc.deleteCustomer(selectedUserID);
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception according to your application's needs
            }
            
            customerDetails.removeRow(row);
            clearTextField();
        }

    }//GEN-LAST:event_jButtonCDActionPerformed

    private void jTableCMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCMouseReleased
        int row = jTableC.getSelectedRow();

        String id = String.valueOf(customerDetails.getValueAt(row,0));
        
        displayPassword(id);
        displayUsername(id);
        displayBalance(id);
        
        User selectedUser = getUserForCustomerUserID(id);
        
        String phoneNumber = String.valueOf(customerDetails.getValueAt(row,1));
        String gender = String.valueOf(customerDetails.getValueAt(row,2));
        String age = String.valueOf(customerDetails.getValueAt(row,3));
        String email = String.valueOf(customerDetails.getValueAt(row,4));
        
        jTextFieldCID.setText(id);
        jTextFieldCPN.setText(phoneNumber);
        jTextFieldCG.setText(gender);
        jTextFieldCA.setText(age);
        jTextFieldCEm.setText(email);
        
    }//GEN-LAST:event_jTableCMouseReleased

    public void clearTextField()
    {
        jTextFieldCID.setText("");
        jTextFieldCUN.setText("");
        jTextFieldCPw.setText("");
        jTextFieldCB.setText("");
        jTextFieldCPN.setText("");
        jTextFieldCG.setText("");
        jTextFieldCA.setText("");
        jTextFieldCEm.setText("");
        
        Registration rcc = new Registration();
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
            java.util.logging.Logger.getLogger(CustomerRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCBTHP;
    private javax.swing.JButton jButtonCC;
    private javax.swing.JButton jButtonCD;
    private javax.swing.JButton jButtonCE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableC;
    private javax.swing.JTextField jTextFieldCA;
    private javax.swing.JTextField jTextFieldCB;
    private javax.swing.JTextField jTextFieldCEm;
    private javax.swing.JTextField jTextFieldCG;
    private javax.swing.JTextField jTextFieldCID;
    private javax.swing.JTextField jTextFieldCPN;
    private javax.swing.JTextField jTextFieldCPw;
    private javax.swing.JTextField jTextFieldCUN;
    // End of variables declaration//GEN-END:variables
}
