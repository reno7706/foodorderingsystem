/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fos;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANNABEL
 */
public class Review extends SuperReview 
{
    private int orderid;
    private String vendorid,cusid,itemname,itemid,runnerid,fdreview,rReview;
    private LocalDateTime orderdate;
    
    public Review()
    {
        
    }
    
     public Review(int orderid,String itemid,String cusid,String vendorid,String runnerid,String itemname,String fdreview,String rReview,LocalDateTime orderdate)
    {
        this.orderid=orderid;
        this.itemid=itemid;
        this.cusid=cusid;
        this.vendorid=vendorid;
        this.runnerid=runnerid;
        this.itemname=itemname;
        this.fdreview=fdreview;
        this.rReview=rReview;
        this.orderdate=orderdate;
    }
    @Override
    public List<Review> readReview()
    {
    
        List<Review> reviewList = new ArrayList<>();
        
        File orderFile=new File("review.txt");
        try (FileReader input = new FileReader(orderFile); 
                BufferedReader readReview = new BufferedReader(input)) {
            
            String line; 
            while ((line = readReview.readLine()) != null)
            {
                String[] parts = line.split("\\$");
                
                if (parts.length >= 8) 
                {
                    int oid=Integer.parseInt(parts[0]);
                    String iid = parts[1];
                    String cid = parts[2];
                    String vid= parts[3];
                    String rid = parts[4];
                    String iname = parts[5];
                    String freview=parts[6];
                    String rreview=parts[7];
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime date = LocalDateTime.parse(parts[8], formatter);
                    
                    if (vendorid.equals(vid))
                    {
                        Review rw=new Review(oid,iid,cid,vid,rid,iname,freview,rreview,date);
                        reviewList.add(rw);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Review.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Review.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reviewList;
    }
    public int getOrderid() {
        return orderid;
    }
    public String getVendorid() {
        return vendorid;
    }
    public LocalDateTime getOrderdate() {
        return orderdate;
    }
    public String getCusid() {
        return cusid;
    }
    public String getItemname() {
        return itemname;
    }
    public String getItemid() {
        return itemid;
    }
    public String getRunnerid() {
        return runnerid;
    }
    public String getFdreview() {
        return fdreview;
    }
    public String getrReview() {
        return rReview;
    }

    /**
     * @param vendorid the vendorid to set
     */
    public void setVendorid(String vendorid) {
        this.vendorid = vendorid;
    }
    
}
