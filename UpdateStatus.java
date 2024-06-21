package fos;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class UpdateStatus extends javax.swing.JFrame 
{
    String Choice;
    private DefaultTableModel model=new DefaultTableModel();
     private String column[]={"OrderID","Date","CustomerID","Service type","Del status","Customer add"};
     private int row=-1;

    
    public UpdateStatus() 
    {
        initComponents();
    }
    
    
    public UpdateStatus(String runnerid) 
    {
        initComponents();
        setLocationRelativeTo(null);
        StatusTable.setModel(model);
        this.runnerid=runnerid;
        model.setColumnIdentifiers(column); 
        showtabledata(runnerid);
    }
    
    public void showtabledata(String runnerid) 
    {
        Rorder odr = new Rorder();
        List<Rorder> orderlist = odr.ReadOrder();
        for (Rorder od : orderlist) {
            Object[] rowData
                    = {
                        od.getOrderId(),
                        od.getDate(),
                        //od.getOrderprice(),
                        od.getCustomerID(),
                        od.getServiceType(),
                        //od.getItemName(),
                        //od.getOrderStatus(),
                        //od.getVendorid(),
                        od.getDeliveryStatus(),
                        //od.getItemID(),
                        //od.getRunnerID()
                        od.getCustomerAdd(),
                    };
            if (od.getServiceType().equals("Delivery")&& od.getRunnerID().equals(runnerid))
            { 
                if((od.getDeliveryStatus()== -1)&& (od.getDeliveryStatus()!= -2))
                {
                    model.addRow(rowData);
                }
            }
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        StatusTable = new javax.swing.JTable();
        CompleteBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblOrderID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update Status");

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        StatusTable.setModel(model);
        StatusTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                StatusTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(StatusTable);

        CompleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CompleteBtn.setText("Completed");
        CompleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CompleteBtnMouseReleased(evt);
            }
        });
        CompleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompleteBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("OrderID :");

        lblOrderID.setText("jLabel3");

        jLabel3.setText("Phonenum :");

        lblPhone.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lblOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(179, 179, 179)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CompleteBtn)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderID)
                    .addComponent(jLabel2)
                    .addComponent(CompleteBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblPhone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       RunnerHome second = new RunnerHome(runnerid);
        second.show();
        
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CompleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompleteBtnActionPerformed
        Rorder Accept = new Rorder();
        if(row ==-1)
        {
            JOptionPane.showMessageDialog(this,"please select");
        }
        else
        {
            if(lblOrderID != null)
        {
            if (Choice != null)
            {
                int orderID = Integer.parseInt(lblOrderID.getText());
                Accept.DecideOrder(orderID, Choice);
                
                
                JOptionPane.showMessageDialog(null, "Task completed,view record at the Task History.");
                
               
                CheckHistory second = new CheckHistory(runnerid);
                second.show();
                dispose();
            }
        }
        } 
        
        
    }//GEN-LAST:event_CompleteBtnActionPerformed

    private void StatusTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StatusTableMouseReleased
        row = StatusTable.getSelectedRow();
        String OrderId = String.valueOf(model.getValueAt(row,0));
        String CustomerID = String.valueOf(model.getValueAt(row,2));
        String PN=""; 
        
        //get phonenum
        Rorder uid= new Rorder();
        uid.setCustomerID(CustomerID);
        try {
            PN=uid.getPhonenum();
        } catch (IOException ex) {
            Logger.getLogger(UpdateStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblOrderID.setText(OrderId);
        lblPhone.setText(PN);
    }//GEN-LAST:event_StatusTableMouseReleased

    private void CompleteBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CompleteBtnMouseReleased
        Choice = "completed";
        
    }//GEN-LAST:event_CompleteBtnMouseReleased

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
            java.util.logging.Logger.getLogger(UpdateStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateStatus().setVisible(true);
            }
        });
    }
    private String runnerid;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CompleteBtn;
    private javax.swing.JTable StatusTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JLabel lblPhone;
    // End of variables declaration//GEN-END:variables
}
