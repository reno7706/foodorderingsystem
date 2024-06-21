
package fos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Rorder extends SuperOrder
{
    private int orderId;
    private String date;
    private double price;
    private String customerID;
    private String serviceType;
    private String OrderStatus;
    private String VendorID;
    private String itemName;
    private int deliveryStatus;
    private String itemID;
    private String runnerID;
    private String customerAdd;
    private String Phonenum;
    private double Fee;
    
  
    
    public void setRunnerID(String runnerid) {
        this.runnerID = runnerid;
    }
    public double getFee() {
        return Fee;
    } /**
     * @param runnerID the runnerID to set
     */

    /**
     * @param Fee the Fee to set
     */
    public void setFee(double Fee) {
        this.Fee = Fee;
    }
    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the customerID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * @return the serviceType
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * @return the OrderStatus
     */
    public String getOrderStatus() {
        return OrderStatus;
    }

    /**
     * @return the VendorID
     */
    public String getVendorID() {
        return VendorID;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @return the deliveryStatus
     */
    public int getDeliveryStatus() {
        return deliveryStatus;
    }

    /**
     * @return the itemID
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * @return the runnerID
     */
    public String getRunnerID() {
        return runnerID;
    }

    /**
     * @return the customerAdd
     */
    public String getCustomerAdd() {
        return customerAdd;
    }

     /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    /**
     * @param OrderStatus the OrderStatus to set
     */
    public void setOrderStatus(String OrderStatus) {
        this.OrderStatus = OrderStatus;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @param deliveryStatus the deliveryStatus to set
     */
    public void setDeliveryStatus(int deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    /**
     * @return the status
     */
    
   
    public Rorder(){}
    public Rorder(String runnerID){this.runnerID = runnerID;}
    
    public Rorder(int orderId, String date,double price, String customerID,
                    String serviceType, String itemName,String OrderStatus,String VendorID, int deliveryStatus,
                    String itemID, String runnerID,String customerAdd) 
            
    {
        this.orderId = orderId;
        this.date = date;
        this.price = price;
        this.customerID = customerID;
        this.serviceType = serviceType;
        this.itemName = itemName;
        this.deliveryStatus = deliveryStatus;
        this.itemID = itemID;
        this.runnerID = runnerID;
        this.customerAdd = customerAdd;
        this.VendorID = VendorID;
        this.OrderStatus =OrderStatus;
        this.customerAdd = customerAdd;
    }
    
    public Rorder(int oid,String date,double price,String CustomerID,String Service,String Itemname,String vid,String iid,String rid,String orderS, double fee)
    {
        this.orderId = oid;
        this.date = date;
        this.price = price;
        this.customerID = CustomerID;
        this.serviceType = Service;
        this.itemName = Itemname;
        this.VendorID = vid;
        this.itemID = iid;
        this.runnerID = rid;
        this.OrderStatus =orderS;
        this.Fee=fee;
    
    }
    
    public Rorder(String rid,int oid)
    {
        this.runnerID = rid;
        this.orderId = oid;
    }
    
    @Override
    public List<Rorder> ReadOrder()
    {
        List<Rorder> orderList = new ArrayList<>();
        
        File orderFile=new File("ordering.txt");
        try (FileReader input = new FileReader(orderFile)) 
        {
            BufferedReader readOrder=new BufferedReader(input);
            String line; 
            while ((line = readOrder.readLine()) != null)
            {
                String[] parts = line.split(",");
                
                if (parts.length >= 12) 
                {
                    int oid=Integer.parseInt(parts[0]);
                    String date=parts[1];
                    double oprice=Double.parseDouble(parts[2]);
                    String cid = parts[3];
                    String service = parts[4];
                    String iname = parts[5];
                    String ostatus = parts[6];
                    String vid= parts[7];
                    int dstatus = Integer.parseInt(parts[8]);
                    String iid = parts[9];
                    String rid = parts[10];
                    String cAdd = parts[11];
                    
                    {
                    Rorder od = new Rorder(oid,date,oprice,
                                cid,service,iname
                                ,ostatus,vid,dstatus,iid,rid,cAdd);
                        orderList.add(od);
                        
                    }
                    
                }
            }
            readOrder.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Rorder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Rorder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderList;   
    }
    
    public String getPhonenum() throws FileNotFoundException, IOException
    {
        File orderFile=new File("customerProfile.txt");
        try (FileReader input = new FileReader(orderFile)) 
        {
            BufferedReader getPhone=new BufferedReader(input);
            String line; 
            String uid;
            while ((line = getPhone.readLine()) != null)
            {
                String[] parts = line.split(",");
                uid=(parts[0]);
                if (parts.length >= 3 && customerID.equals(uid)  ) 
                {
                    Phonenum=(parts[2]);
                }
        }
    return Phonenum;
    }}
    
         
    public void DecideOrder(int orderid,String choices)
    {
        try 
        {
            File orderFile=new File("ordering.txt");
            FileReader LoadOrderFile=new FileReader(orderFile);
            BufferedReader br=new BufferedReader(LoadOrderFile);
            
            List<Rorder> AllOrderList = new ArrayList<>();
            String line;
                
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split(",");
                
                if (parts.length >= 12) 
                {
                    int oid=Integer.parseInt(parts[0]);
                    String date=parts[1];
                    double oprice=Double.parseDouble(parts[2]);
                    String cid = parts[3];
                    String service = parts[4];
                    String iname = parts[5];
                    String ostatus = parts[6];
                    String vid= parts[7];
                    int dstatus = Integer.parseInt(parts[8]);
                    String iid = parts[9];
                    String rid = parts[10];
                    String cAdd = parts[11];
                    
                    Rorder od = new Rorder(oid,date,oprice,
                                cid,service,iname
                                ,ostatus,vid,dstatus,iid,rid,cAdd);
                    AllOrderList.add(od);
                }
            }
            for(Rorder allorder :AllOrderList)
            {
                if( allorder.getOrderId()==orderid && choices.equals("declined"))
                {
                    allorder.setDeliveryStatus(allorder.getDeliveryStatus() + 1);
                         
                    File DeclineFile = new File("DisplayDeclined.txt");
                    try (FileWriter output = new FileWriter(DeclineFile, true))
                    {
                        BufferedWriter writer = new BufferedWriter(output);
                        {
                            String string = runnerID+","+allorder.getOrderId()+ "\n";
                            writer.write(string);
                        }
                        writer.close();
                         
                    }
                }
                else if( allorder.getOrderId()==orderid&& choices.equals("accepted"))
                {
                    allorder.setDeliveryStatus(-1); 
                    allorder.setRunnerID(runnerID);
                }
                else if( allorder.getOrderId()==orderid&& choices.equals("completed"))
                {
                    allorder.setDeliveryStatus(-2);
                    allorder.setOrderStatus("completed");

                }
            }
            br.close();
            saveOrderToFile(AllOrderList);
        } 
        catch (IOException e) 
        {
            e.printStackTrace(); // Handle the exception properly
        }
    }
    public void saveOrderToFile(List<Rorder> orders) throws IOException 
    {
        File orderFile = new File("ordering.txt");
        try (FileWriter output = new FileWriter(orderFile))
        {
            BufferedWriter writer = new BufferedWriter(output);
            for (Rorder od:orders) 
            {
                String line = 
                        od.getOrderId() + "," + od.getDate() + "," + od.getPrice() + "," +
                        od.getCustomerID()+"," + od.getServiceType()+"," +od.getItemName()+"," + 
                        od.getOrderStatus()+"," + od.getVendorID()+"," + od.getDeliveryStatus()+"," + od.getItemID()+","+ od.getRunnerID()+","+od.getCustomerAdd();
                
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        }
    }
    @Override
    public List<Rorder> ReadHistory()
    {
        List<Rorder> HistoryList = new ArrayList<>();
        File orderFile = new File("orderHistory.txt");
        try (FileReader input = new FileReader(orderFile)) 
            {
                BufferedReader readOrder=new BufferedReader(input);
                String line; 
                while ((line = readOrder.readLine()) != null)
                {
                    String[] parts = line.split(",");
                    if (parts.length >= 11) 
                    {
                        int oid=Integer.parseInt(parts[0]);
                        String date=parts[1];
                        double price =Double.parseDouble(parts[2]);
                        String cid =parts[3];
                        String service =parts[4];
                        String iname = parts[5];
                        String vid =parts[6];
                        String iid =parts[7];
                        String rid=parts[8];
                        String ostatus=parts[9];
                        double fee=Double.parseDouble(parts[10]);
                    
                        Rorder od = new Rorder(oid,date,price,cid,service,iname,vid,iid,rid,ostatus,fee);
                        HistoryList.add(od);
                    }
                }readOrder.close();
            } catch (FileNotFoundException ex) { 
            Logger.getLogger(Rorder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Rorder.class.getName()).log(Level.SEVERE, null, ex);
        }
return HistoryList; 
    }
}
    
    
   
       
       
            
           


    

          
        

    
    


    
   
