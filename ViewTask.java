package fos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewTask extends javax.swing.JFrame 
{
    String Choice;
    String runnerID;
    int OrderID;
    private DefaultTableModel model = new DefaultTableModel();

    private String column[] = {"OrderID", "Date", "Customer id", "Service", "ItemName", "Order Status", "ItemID", "Customer Add"};
    private int row = -1;

    public ViewTask(String runnerid) throws IOException 
    {
        initComponents();
        setLocationRelativeTo(null);
        AllTaskTable.setModel(model);
        this.runnerid = runnerid;
        model.setColumnIdentifiers(column);
        showtabledata();
    }

    public void showtabledata() throws FileNotFoundException, IOException 
    {
        Rorder odr = new Rorder();
        int Count = 0;
        try 
        {
            //get registered Runner count
             File orderFile=new File("User.txt");
             try (FileReader input = new FileReader(orderFile)) 
             {
                 BufferedReader CustomerCount=new BufferedReader(input);
                 String line; 
                 String Role;
                 while ((line = CustomerCount.readLine()) != null)
                 {
                     String[] parts = line.split(",");
                     if(parts.length>=3){
                     Role=(parts[2]);
                     if (Role.equals("runner"))  
                     {
                         Count ++;
                     }}
                }
             }
            
            List<Rorder> orderlist = odr.ReadOrder();
            for (Rorder od : orderlist) 
            {
                boolean show = true;
                if ( od.getServiceType().equals("Delivery") &&!od.getOrderStatus().equals("Completed")&& !od.getOrderStatus().equals("declined")&&  od.getDeliveryStatus() >= 0 && od.getDeliveryStatus() < Count) 
                {
                    File declinef = new File("DisplayDeclined.txt");
                    try (FileReader input = new FileReader(declinef)) 
                    {
                        BufferedReader Decliner=new BufferedReader(input);
                        String line ;
                        while ((line= Decliner.readLine())!=null)
                        {
                            String[] parts = line.split(",");
                            if (parts.length >= 2) 
                            {
                                String rID=parts[0];
                                int OID= Integer.parseInt(parts[1]);
                                if(od.getRunnerID().equals(rID) && od.getOrderId() == OID) 
                                {
                                    show = false;
                                }
                            }else{System.out.println("error data");}
                            
                        }
                        input.close();
                    }
                    if(show){
                Object[] rowData = 
                                    {
                                        od.getOrderId(),
                                        od.getDate(),
                                        od.getCustomerID(),
                                        od.getServiceType(),
                                        od.getItemName(),
                                        od.getOrderStatus(),
                                        od.getItemID(),
                                        od.getCustomerAdd()
                                    };
                                    model.addRow(rowData);
                    }
                }
            }
        } catch (IOException e) 
        {}
    }

    public ViewTask() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        Acceptbtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        AllTaskTable = new javax.swing.JTable();
        lblOrderID = new javax.swing.JLabel();
        lblCustomerID = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        DeclineBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        PhoneNum = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Task");

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        Acceptbtn.setText("Accept");
        Acceptbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                AcceptbtnMouseReleased(evt);
            }
        });
        Acceptbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptbtnActionPerformed(evt);
            }
        });

        AllTaskTable.setModel(model);
        AllTaskTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                AllTaskTableMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(AllTaskTable);

        lblOrderID.setText("jLabel2");

        lblCustomerID.setText("jLabel3");

        lblDate.setText("jLabel4");

        jLabel8.setText("Date/time :");

        jLabel9.setText("Order id :");

        jLabel10.setText("Customer ID:");

        DeclineBtn.setText("Decline");
        DeclineBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DeclineBtnMouseReleased(evt);
            }
        });
        DeclineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeclineBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Phone num :");

        PhoneNum.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(Acceptbtn)
                                .addGap(37, 37, 37)
                                .addComponent(DeclineBtn)
                                .addGap(621, 621, 621))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(47, 47, 47)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(PhoneNum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                                .addComponent(lblDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblCustomerID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(394, 394, 394)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BackBtn)
                .addGap(409, 409, 409))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblOrderID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblCustomerID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PhoneNum)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Acceptbtn)
                            .addComponent(DeclineBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(BackBtn)
                        .addGap(17, 17, 17))))
        );

        DeclineBtn.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        RunnerHome second = new RunnerHome(runnerid);
        second.show();
        dispose();
    }//GEN-LAST:event_BackBtnActionPerformed

    private void AcceptbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptbtnActionPerformed
        Rorder Accept = new Rorder(runnerid);
        if(lblOrderID != null)
        {
            if (Choice != null)
            {
                int orderID = Integer.parseInt(lblOrderID.getText());
                Accept.DecideOrder(orderID, Choice);
                JOptionPane.showMessageDialog(null, "Update status at next page.");
                
                
                UpdateStatus second = new UpdateStatus(runnerid);
                second.show();
                dispose();
            }
        }
    }//GEN-LAST:event_AcceptbtnActionPerformed

    private void AllTaskTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AllTaskTableMouseReleased
        
        int row = AllTaskTable.getSelectedRow();
        String OrderId = String.valueOf(model.getValueAt(row,0));
        String CustomerID = String.valueOf(model.getValueAt(row,2));
        String Date = String.valueOf(model.getValueAt(row,1));
        String PN="";
        
        //show phone num
        Rorder uid= new Rorder();
        uid.setCustomerID(CustomerID);
        try {
            PN=uid.getPhonenum();
        } catch (IOException ex) {
            Logger.getLogger(ViewTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lblOrderID.setText(OrderId); 
        lblCustomerID.setText(CustomerID);
        lblDate.setText(Date);
        PhoneNum.setText(PN);
        

    }//GEN-LAST:event_AllTaskTableMouseReleased

    private void DeclineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeclineBtnActionPerformed
        

    }//GEN-LAST:event_DeclineBtnActionPerformed

    private void AcceptbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AcceptbtnMouseReleased
       Choice = "accepted";
        
       
    }//GEN-LAST:event_AcceptbtnMouseReleased

    private void DeclineBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeclineBtnMouseReleased
        Choice = "declined";
        Rorder Decline = new Rorder(runnerid);
        if(lblOrderID != null)
        {
            if (Choice != null)
            {
                int orderID = Integer.parseInt(lblOrderID.getText());
                Decline.DecideOrder(orderID, Choice);
                Acceptbtn.setEnabled(false);
            }
        }
        JOptionPane.showMessageDialog(null, "Order Declined.");
        
    }//GEN-LAST:event_DeclineBtnMouseReleased

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
            java.util.logging.Logger.getLogger(ViewTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTask().setVisible(true);
            }
        });
    }

    private String runnerid;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Acceptbtn;
    private javax.swing.JTable AllTaskTable;
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton DeclineBtn;
    private javax.swing.JLabel PhoneNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblOrderID;
    // End of variables declaration//GEN-END:variables
}
