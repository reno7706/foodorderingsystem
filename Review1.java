
package fos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Review1 extends SuperReview
{

    /**
     * @return the OrderID
     */
    public int getOrderID() {
        return OrderID;
    }

    /**
     * @param OrderID the OrderID to set
     */
    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    /**
     * @return the VendorID
     */
    public String getVendorID() {
        return VendorID;
    }

    /**
     * @param VendorID the VendorID to set
     */
    public void setVendorID(String VendorID) {
        this.VendorID = VendorID;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    /**
     * @return the CustomerID
     */
    public String getCustomerID() {
        return CustomerID;
    }

    /**
     * @param CustomerID the CustomerID to set
     */
    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemID
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * @param itemID the itemID to set
     */
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    /**
     * @return the runnerID
     */
    public String getRunnerID() {
        return runnerID;
    }

    /**
     * @param runnerID the runnerID to set
     */
    public void setRunnerID(String runnerID) {
        this.runnerID = runnerID;
    }

    /**
     * @return the fdreview
     */
    public String getFdreview() {
        return fdreview;
    }

    /**
     * @param fdreview the fdreview to set
     */
    public void setFdreview(String fdreview) {
        this.fdreview = fdreview;
    }

    /**
     * @return the rReview
     */
    public String getrReview() {
        return rReview;
    }

    /**
     * @param rReview the rReview to set
     */
    public void setrReview(String rReview) {
        this.rReview = rReview;
    }
    private int OrderID;
    private String VendorID,Date,CustomerID,itemName,itemID,runnerID,fdreview,rReview;
    
    public Review1()
    {
    }
    public Review1(String runnerID)
    {
        this.runnerID=runnerID;
    }
    
     public Review1(int orderid,String itemid,String cusid,String vendorid,String runnerid,String itemname,String fdreview,String rReview,String orderdate)
    {
        this.OrderID=orderid;
        this.itemID=itemid;
        this.CustomerID=cusid;
        this.VendorID=vendorid;
        this.runnerID=runnerid;
        this.itemName=itemname;
        this.fdreview=fdreview;
        this.rReview=rReview;
        this.Date=orderdate;
    }
     
    @Override
       public List<Review1> readReview() 
    {
        List<Review1> reviewList = new ArrayList<>();
        
        File orderFile=new File("review.txt");
        try (FileReader input = new FileReader(orderFile); BufferedReader readReview = new BufferedReader(input)) 
        {
            
            String line; 
            while ((line = readReview.readLine()) != null)
            {
                String[] parts = line.split("\\$");
                
                if (parts.length >= 9) 
                {
                    int oid=Integer.parseInt(parts[0]);
                    String iid = parts[1];
                    String cid = parts[2];
                    String vid= parts[3];
                    String rid = parts[4];
                    String iname = parts[5];
                    String freview=parts[6];
                    String rreview=parts[7];
                    String date=parts[8];
                    
                    if (runnerID.equals(rid))
                    {
                        Review1 rw=new Review1(oid,iid,cid,vid,rid,iname,freview,rreview,date);
                        reviewList.add(rw);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Review1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Review1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reviewList;
    }
}
