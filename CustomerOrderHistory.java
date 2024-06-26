/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HPvictus2022
 */
public class CustomerOrderHistory extends javax.swing.JFrame 
{
    
    public CustomerOrderHistory() throws IOException 
    {
        
    }
    private String uID;
    
    public CustomerOrderHistory(String uID)
    {
        this.uID=uID;
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        Order H = new Order();
        H.setuID(uID);
        List<Order> orderHistoryList = H.ReadHistory();
        Object[][] orderHistoryData = new Object[orderHistoryList.size()][];
        for (int i = 0; i < orderHistoryList.size(); i++) {
        Order orderObj = orderHistoryList.get(i);
        orderHistoryData[i] = new Object[]{
                orderObj.getOrderId(),
                orderObj.getOrderTime(),
                orderObj.getItemPrice(),
                orderObj.getuID(),
                orderObj.getServiceType(),
                orderObj.getItemName(),
                orderObj.getVendorID(),
                orderObj.getItemID(),
                orderObj.getRunnerID(),
                orderObj.getOrderStatus()
        };
    }
    String[] columnNames = {"Order ID", "Date", "Total", "User ID", "Service Type", "Item Name",
            "Vendor ID", "Item ID", "Runner ID", "Order Status"};
    DefaultTableModel Ht = new DefaultTableModel(orderHistoryData, columnNames);
    historyTable.setModel(Ht);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        exit = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        historyTable = new javax.swing.JTable();
        orderTable = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressT = new javax.swing.JTextArea();
        recommend = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        exit.setActionCommand("oHexit");
        exit.setLabel("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        historyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        historyTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                historyTableMouseDragged(evt);
            }
        });
        historyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                historyTableMouseEntered(evt);
            }
        });
        historyTable.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                historyTableCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                historyTableInputMethodTextChanged(evt);
            }
        });
        historyTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                historyTablePropertyChange(evt);
            }
        });
        historyTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                historyTableKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                historyTableKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(historyTable);

        jScrollPane4.setViewportView(jScrollPane3);

        orderTable.setLabel("Reorder");
        orderTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderTableActionPerformed(evt);
            }
        });

        jLabel1.setText("Address:");

        addressT.setColumns(20);
        addressT.setRows(5);
        jScrollPane1.setViewportView(addressT);

        recommend.setText("Recommend");
        recommend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recommendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(recommend)
                        .addGap(73, 73, 73)
                        .addComponent(orderTable)
                        .addGap(31, 31, 31)
                        .addComponent(exit)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1079, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(orderTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(recommend))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exit)
                            .addComponent(jLabel1))))
                .addGap(31, 31, 31))
        );

        exit.getAccessibleContext().setAccessibleName("oHexit");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        CustomerHome s1=new CustomerHome(uID);
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void orderTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderTableActionPerformed
        int Row = historyTable.getSelectedRow();
        if(Row!=-1){
        Order Order=new Order();
        int orderId=Order.generateID();
        Payment balance=new Payment();
        balance.setuID(uID);
        double balances=balance.calBalance();
        balance.setBalance(balances);
        
        String orderTime = Order.generateTime();
        
        Object value = historyTable.getValueAt(Row, 2);
        double prices = Double.parseDouble(value.toString());
        String itemID = historyTable.getValueAt(Row, 7).toString();
        String vendorID= historyTable.getValueAt(Row, 6).toString();
        String itemName = historyTable.getValueAt(Row, 5).toString();
        double itemPrice = Double.parseDouble(historyTable.getValueAt(Row, 2).toString());
        int[] selectedRows = historyTable.getSelectedRows();
        balance.setTotal(prices);
        
        String[] options = {"Dine In", "Take Away", "Delivery"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Select Service Type",
                "Service Type",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        String service="Dine In";
        switch (choice) {
            case 0 -> service="Dine In";
            case 1 -> service="Take Away";
            case 2 -> service="Delivery";
            default -> {
            }
        }
        
        Order.setAddress(addressT.getText());
        Order.setItemID(itemID);
        Order.setOrderId(orderId);
        Order.setOrderTime(orderTime);
        Order.setServiceType(service);
        Order.setuID(uID);
        Order.setVendorID(vendorID);
        Order.setItemName(itemName);
        Order.setItemPrice(itemPrice);
        Order.setSelectedRows(selectedRows);
        
        if(service.equals("Delivery"))
        {
            if(addressT.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null,
                    "Please enter your address", "Order", JOptionPane.ERROR_MESSAGE); 
            }
            else
            {
        if (choice != JOptionPane.CLOSED_OPTION)
        {
            if(balance.makePayment(5)>-1)
            {
                JOptionPane.showMessageDialog(null,
                    "Payment successful", "Payment Status", JOptionPane.INFORMATION_MESSAGE);
                Order.placeOrder();
                double latestBalance=balance.makePayment(5);
                balance.setNewBalance(latestBalance);
                balance.updateBalance();
            }
            else
            {
                JOptionPane.showMessageDialog(null,
                    "Insufficient balance", "Payment Status", JOptionPane.ERROR_MESSAGE);  
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                    "Must pick a service type","Pick a type", JOptionPane.ERROR_MESSAGE);  
        }}}
        else
        {
            if (choice != JOptionPane.CLOSED_OPTION)
        {
            if(balance.makePayment(0)>-1)
            {
                JOptionPane.showMessageDialog(null,
                    "Payment successful", "Payment Status", JOptionPane.INFORMATION_MESSAGE);
                Order.placeOrder();
                double latestBalance=balance.makePayment(0);
                balance.setNewBalance(latestBalance);
                balance.updateBalance();
            }
            else
            {
                JOptionPane.showMessageDialog(null,
                    "Insufficient balance", "Payment Status", JOptionPane.ERROR_MESSAGE);  
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                    "Must pick a service type","Pick a type", JOptionPane.ERROR_MESSAGE);  
        }
        }
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                    "Please choose an order to reorder","Pick an order", JOptionPane.ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_orderTableActionPerformed

    private void historyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyTableMouseClicked
        boolean a=historyTable.isEditing();
        if(a==false)
        {
            JOptionPane.showMessageDialog(null,"You cannot edit the content");
        }
    }//GEN-LAST:event_historyTableMouseClicked

    private void historyTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_historyTablePropertyChange
        
    }//GEN-LAST:event_historyTablePropertyChange

    private void historyTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_historyTableMouseEntered

    private void historyTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_historyTableKeyTyped
        boolean a=historyTable.isEditing();
        if(a==false)
        {
            JOptionPane.showMessageDialog(null,"You cannot edit the content");
        }
    }//GEN-LAST:event_historyTableKeyTyped

    private void historyTableCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_historyTableCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_historyTableCaretPositionChanged

    private void historyTableMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyTableMouseDragged
        boolean a=historyTable.isEditing();
        if(a==false)
        {
            JOptionPane.showMessageDialog(null,"You cannot edit the content");
        }
    }//GEN-LAST:event_historyTableMouseDragged

    private void historyTableInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_historyTableInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_historyTableInputMethodTextChanged

    private void historyTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_historyTableKeyPressed
        boolean a=historyTable.isEditing();
        if(a==false)
        {
            JOptionPane.showMessageDialog(null,"You cannot edit the content");
        }
    }//GEN-LAST:event_historyTableKeyPressed

    private void recommendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recommendActionPerformed
        Order recommend=new Order();
        recommend.displayRecommendations(uID);
    }//GEN-LAST:event_recommendActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(CustomerOrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerOrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerOrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerOrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        /* Set the Nimbus look and feel */
    // ... (your look and feel code)
        //</editor-fold>
        /* Create and display the form */
        /* Set the Nimbus look and feel */
    // ... (your look and feel code)
        //</editor-fold>
        /* Create and display the form */
        /* Set the Nimbus look and feel */
    // ... (your look and feel code)
        //</editor-fold>
        /* Create and display the form */
        /* Set the Nimbus look and feel */
    // ... (your look and feel code)
    }
    
    public CustomerOrderHistory(List<String> orderHistory) 
    {
        
    }
    
    int maxId2=0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressT;
    private javax.swing.JButton exit;
    private javax.swing.JTable historyTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton orderTable;
    private javax.swing.JButton recommend;
    // End of variables declaration//GEN-END:variables
}
