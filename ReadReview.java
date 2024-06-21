
package fos;


import java.io.IOException;
import javax.swing.table.*;

public class ReadReview extends javax.swing.JFrame 
{
    private DefaultTableModel model = new DefaultTableModel();
    private String column[] = {"order id","item id", "customer id", "vendor id", "runner id", "item name", "review for food","review for runner","date"};
    
   
    
    public ReadReview() 
    {
        initComponents();
    }
    
    public ReadReview(String runnerid) 
    {
        initComponents();
        setLocationRelativeTo(null);
        this.runnerid=runnerid;
        Review1 review= new Review1(runnerid);
        review.setRunnerID(runnerid);
        ReviewTable.setModel(model);
        model.setColumnIdentifiers(column);
        ShowReview();
    }
    
    public void ShowReview()  
    {
        Review1 rw = new Review1(runnerid);
        java.util.List<Review1> orderlist = rw.readReview(); 
        for (Review1 RW : orderlist)
        {
            Object[] rowData =
            {
                RW.getOrderID(),
                RW.getItemID(),
                RW.getCustomerID(),
                RW.getVendorID(),
                RW.getRunnerID(),
                RW.getItemName(),
                RW.getFdreview(),
                RW.getrReview(),
                RW.getDate(),
            };
            if (RW.getRunnerID().equals(runnerid) ) {
                model.addRow(rowData);
                
            }
        }
    }
               
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Backbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ReviewTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Review");

        Backbtn.setText("Back");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });

        ReviewTable.setModel(model);
        jScrollPane1.setViewportView(ReviewTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(Backbtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(Backbtn)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        RunnerHome second = new RunnerHome(runnerid);
        second.show();
        
        dispose();
    }//GEN-LAST:event_BackbtnActionPerformed


       
    private String runnerid;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backbtn;
    private javax.swing.JTable ReviewTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
}
