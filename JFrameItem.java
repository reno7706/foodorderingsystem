/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fos;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANNABEL
 */
public class JFrameItem extends javax.swing.JFrame {
    
    private DefaultTableModel model=new DefaultTableModel();
    
    private String column[]={"VendorID","ItemID","ItemName","Price"};
    private int row=-1;
    
    public JFrameItem() {
        initComponents();
        setLocationRelativeTo(null);
    }
    public JFrameItem(String vendorid){
        initComponents();
        setLocationRelativeTo(null);
        this.vendorid=vendorid;
        model.setColumnIdentifiers(column);   
        showtabledata();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblItemID = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtVendorID = new javax.swing.JTextField();
        txtItemID = new javax.swing.JTextField();
        txtItemName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        lblVendorID = new javax.swing.JLabel();
        lblItemName = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        btnHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblItemID.setText("Item ID");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblVendorID.setText("Vendor ID");

        lblItemName.setText("Item Name");

        lblPrice.setText("Price");

        lblTitle.setText("Item");

        ItemTable.setModel(model);
        ItemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ItemTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(ItemTable);

        btnHome.setText("Back to Home Page");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnHome)
                .addGap(306, 306, 306))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblItemName)
                                    .addComponent(lblItemID, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                    .addComponent(lblVendorID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btnEdit)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(btnAdd))
                            .addComponent(txtVendorID)
                            .addComponent(txtItemID)
                            .addComponent(txtItemName)
                            .addComponent(txtPrice))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVendorID, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtVendorID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblItemName))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrice))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnDelete)
                            .addComponent(btnEdit)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(btnHome)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        if(row==-1)
        {
            JOptionPane.showMessageDialog(this,"Please select a row");
        }
        else
        {
            
            String vid=txtVendorID.getText();
            String iid=txtItemID.getText();
            String iname=txtItemName.getText();
            double price=Double.parseDouble(txtPrice.getText());
            
            Item idel=new Item();
            try 
            {
                idel.deleteItem(vid,iid,iname,price);
            } catch (IOException ex) 
            {
                Logger.getLogger(JFrameItem.class.getName()).log(Level.SEVERE, null, ex);
            }
            model.removeRow(row);
            JOptionPane.showMessageDialog(rootPane,"Delete Successful");
            clearText();
            row=-1;
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if(row==-1)
        {
            JOptionPane.showMessageDialog(this,"Please select a row");
        }
        else
        {
            String vid=txtVendorID.getText();
            String iid=txtItemID.getText();
            String iname=txtItemName.getText();
            double price=Double.parseDouble(txtPrice.getText());
            Item iedit=new Item();
            iedit.updateItem(vid, iid, iname, price);
            JOptionPane.showMessageDialog(this,"Update Successful.Please Refresh to show the latest changes.");
            clearText();
            row=-1;
        }
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String vid=txtVendorID.getText();
        String iid=txtItemID.getText();
        String iname=txtItemName.getText();
        double price=Double.parseDouble(txtPrice.getText());

        if(vid.length()==0||iid.length()==0||iname.length()==0||price==0)
        {
            JOptionPane.showMessageDialog(this, "Please complete the form");
        }
        else
        {
            Item iadd=new Item();
            try {
                iadd.createItem(vid, iid, iname, price);
                String record[]={vid,iid,iname,Double.toString(price)};
                model.addRow(record);
                JOptionPane.showMessageDialog(this,"Successfully Added.");
                
            } catch (IOException ex) {
                Logger.getLogger(JFrameItem.class.getName()).log(Level.SEVERE, null, ex);
            }
            clearText();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        HomePage h1=new HomePage(vendorid);
        h1.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void ItemTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemTableMouseReleased
        // TODO add your handling code here:
        row=ItemTable.getSelectedRow();
        String vid=String.valueOf(model.getValueAt(row, 0));
        String iid=String.valueOf(model.getValueAt(row, 1));
        String iname=String.valueOf(model.getValueAt(row, 2));
        String iprice=String.valueOf(model.getValueAt(row,3));
        txtVendorID.setText(vid);
        txtItemName.setText(iname);
        txtItemID.setText(iid);
        txtPrice.setText(iprice);
    }//GEN-LAST:event_ItemTableMouseReleased

    public void clearText()
    {
        txtVendorID.setText("");
        txtItemName.setText("");
        txtItemID.setText("");
        txtPrice.setText("");
        
    }
   public void showtabledata()
   {
        Item it = new Item(vendorid);
        try
        {
            List<Item> iList=it.ReadItem();
            for (Item item : iList) 
            {
                Object[] rowData = {item.getVendorid(), item.getItemID(), item.getItemName(), item.getItemPrice()};
                model.addRow(rowData);
            }
        } catch (IOException e) 
        {
            System.out.println("Error Show Table");
        }
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
            java.util.logging.Logger.getLogger(JFrameItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameItem().setVisible(true);
            }
        });
    }

    private String vendorid;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ItemTable;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblItemID;
    private javax.swing.JLabel lblItemName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVendorID;
    private javax.swing.JTextField txtItemID;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtVendorID;
    // End of variables declaration//GEN-END:variables
}
