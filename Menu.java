/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fos;

import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HPvictus2022
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form menu
     */
    public Menu() {
        
    }
    
    private String uID;
    public Menu(String uID)
    {
        this.uID=uID;
        initComponents();
        setVisible(true);
        Order status=new Order();
        String[] columnNames = {"Vendor ID","Item ID","Item Name","Item Price"};
        DefaultTableModel Ht = new DefaultTableModel(status.menu(), columnNames);
        menu.setModel(Ht);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        placeOrder = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        menu = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        reviews = new javax.swing.JTextArea();
        review = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        addressT = new javax.swing.JTextField();
        suggest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        placeOrder.setText("Place Order");
        placeOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeOrderActionPerformed(evt);
            }
        });

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        menu.setModel(new javax.swing.table.DefaultTableModel(
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
        menu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                menuMouseDragged(evt);
            }
        });
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(menu);

        reviews.setColumns(20);
        reviews.setRows(5);
        jScrollPane2.setViewportView(reviews);

        review.setText("Display reviews");
        review.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewActionPerformed(evt);
            }
        });

        jLabel1.setText("Address:");

        suggest.setText("Random Item Suggestion");
        suggest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suggestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(addressT, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(suggest))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(placeOrder)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(review)
                                .addGap(77, 77, 77))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(exitBtn)
                                .addGap(40, 40, 40))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(review)
                    .addComponent(addressT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(suggest))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(exitBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(placeOrder)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        CustomerHome s1=new CustomerHome(uID);
        this.dispose();
    }//GEN-LAST:event_exitBtnActionPerformed

    private void placeOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeOrderActionPerformed
        int Row = menu.getSelectedRow();
        if(Row!=-1){
        Order place=new Order();
        int orderId = place.generateID();
        String orderTime = place.generateTime();
        Payment balance=new Payment();
        balance.setuID(uID);
        double balances=balance.calBalance();
        balance.setBalance(balances);

        Object value = menu.getValueAt(Row, 3);
        double prices = Double.parseDouble(value.toString());
        String itemID = menu.getValueAt(Row, 1).toString();
        String vendorID = menu.getValueAt(Row, 0).toString();
        double itemPrice = Double.parseDouble(menu.getValueAt(Row, 3).toString());
        String itemName = menu.getValueAt(Row, 2).toString();
        int[] selectedRows = menu.getSelectedRows();
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
        
        
        place.setAddress(addressT.getText());
        place.setItemID(itemID);
        place.setOrderId(orderId);
        place.setOrderTime(orderTime);
        place.setServiceType(service);
        place.setuID(uID);
        place.setVendorID(vendorID);
        place.setItemName(itemName);
        place.setItemPrice(itemPrice);
        place.setSelectedRows(selectedRows);
        
        if(service.equals("Delivery"))
        {
            if(addressT.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null,
                    "Please enter your address", "Order", JOptionPane.ERROR_MESSAGE); 
            }
            else
            {if (choice != JOptionPane.CLOSED_OPTION)
        {
            if(balance.makePayment(5)>-1)
            {
                JOptionPane.showMessageDialog(null,
                    "Payment successful", "Payment Status", JOptionPane.INFORMATION_MESSAGE);
                place.placeOrder();
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
        } 
            }
        }
        else
        {
            if (choice != JOptionPane.CLOSED_OPTION)
        {
            if(balance.makePayment(0)>-1)
            {
                JOptionPane.showMessageDialog(null,
                    "Payment successful", "Payment Status", JOptionPane.INFORMATION_MESSAGE);
                place.placeOrder();
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
        }else
        {
            JOptionPane.showMessageDialog(null,
                    "Please pick an item to order","Pick a type", JOptionPane.ERROR_MESSAGE);  
        }
        /*
        if (choice != JOptionPane.CLOSED_OPTION)
        {
            payment pay=new payment();
            if(pay.makePayment(prices,balances)>-1)
            {
                JOptionPane.showMessageDialog(null,
                    "Payment successful", "Payment Status", JOptionPane.INFORMATION_MESSAGE);
                place.placeOrder(menu,uID,orderId,orderTime,service, itemID, address);
                double latestBalance=pay.makePayment(prices,balances);
                pay.updateBalance("c12",latestBalance);
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
        }*/
    }//GEN-LAST:event_placeOrderActionPerformed

    private void reviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewActionPerformed
    int row = menu.getSelectedRow();
    if(row!=-1){
    String itemID = menu.getValueAt(row, 1).toString();
    cReview review = new cReview(itemID, "");
    List<cReview> reviews2 = review.readReview();
    StringBuilder allReviews = new StringBuilder();
    for (cReview r : reviews2) {
        allReviews.append(r.showReviews()).append("\n");
    }
    reviews.setText(allReviews.toString());
    }else
    {
        JOptionPane.showMessageDialog(null,
                    "Please pick an item to view the review","Pick an item", JOptionPane.ERROR_MESSAGE);  
    }

    }//GEN-LAST:event_reviewActionPerformed

    private void suggestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suggestActionPerformed
        Order menuOrder = new Order();
        String suggestion = menuOrder.RandomMenuSuggestion();
        JOptionPane.showMessageDialog(null, "Random Menu Suggestion: " + suggestion, "Menu Suggestion", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_suggestActionPerformed

    private void menuMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseDragged
        boolean a=menu.isEditing();
        if(a==false)
        {
            JOptionPane.showMessageDialog(null,"Cannot select multiple items");
        }
    }//GEN-LAST:event_menuMouseDragged

    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
        boolean a=menu.isEditing();
        if(a==false)
        {
            JOptionPane.showMessageDialog(null,"Cannot edit items");
        }
    }//GEN-LAST:event_menuMouseClicked

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressT;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable menu;
    private javax.swing.JButton placeOrder;
    private javax.swing.JButton review;
    private javax.swing.JTextArea reviews;
    private javax.swing.JButton suggest;
    // End of variables declaration//GEN-END:variables
}