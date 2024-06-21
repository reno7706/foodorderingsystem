
package fos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Refund 
{
    public Refund()
    {
        
    }
    
    private String uID;
    private int orderId;
    private String orderTime;
    private String serviceType;
    private String itemID;
    private String vendorID;
    private int deliveryS;
    private double itemPrice;
    private String itemName;
    private String runnerID;
    private String orderStatus;

    public String getuID() {
        return uID;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getServiceType() {
        return serviceType;
    }

    public int getDeliveryS() {
        return deliveryS;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
    
    
    public Refund(int oid,String date,double oprice,String cid,String service,String iname,String vid,String iid,String rid,String ostatus)
    {
        this.orderId=oid;
        this.orderTime=date;
        this.itemPrice=oprice;
        this.uID=cid;
        this.serviceType=service;
        this.itemName=iname;
        this.vendorID=vid;
        this.itemID=iid;
        this.runnerID=rid;
        this.orderStatus=ostatus;
    }
    
    public Refund(int oid,String date,double oprice,String cid,String service,String iname,String ostatus,String vid, int deliveryS,String iid, String rid)
    {
        this.orderId=oid;
        this.orderTime=date;
        this.itemPrice=oprice;
        this.uID=cid;
        this.serviceType=service;
        this.itemName=iname;
        this.orderStatus=ostatus;
        this.vendorID=vid;
        this.deliveryS=deliveryS;
        this.itemID=iid;
        this.runnerID=rid;
    }
    
    //read customerProfile
    public List<Customer> readCustomerBalance() throws IOException
    {
        List<Customer> customerBalanceList = new ArrayList<>();
        
        File customerBalanceFile = new File("customerProfile.txt");
        try (FileReader loadCustomerBalance = new FileReader(customerBalanceFile)) 
        {
            BufferedReader brcb = new BufferedReader(loadCustomerBalance);
            String line;
            while ((line = brcb.readLine()) != null) 
            {
                String[] parts = line.split(",");
                if (parts.length >= 2) 
                {
                    String id = parts[0];
                    double balance = Double.parseDouble(parts[1]);

                    Customer cbl = new Customer(id, balance);
                    customerBalanceList.add(cbl);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return customerBalanceList; // Return the list if needed
    }
    
    //save customerProfile after update balance
    public void saveCustomerBalance(List<Customer> customerBalanceList) throws IOException 
    {
        File customerBalanceFile = new File("customerProfile.txt");
        
        try (FileWriter scb = new FileWriter(customerBalanceFile, false); 
             BufferedWriter bwcb = new BufferedWriter(scb))
        {
            for (Customer cbl : customerBalanceList) 
            {
                String line = String.join(",", cbl.getId(), String.valueOf(cbl.getBalance()));
                bwcb.write(line);
                bwcb.newLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //read orderHistory
    public List<Refund> readOrderHistory() throws IOException
    {
        List<Refund> orderHList = new ArrayList<>();
        
        File orderHFile = new File("orderHistory.txt");
        try (FileReader loadOrderHistory = new FileReader(orderHFile)) 
        {
            BufferedReader broh = new BufferedReader(loadOrderHistory);
            String line;
            while ((line = broh.readLine()) != null) 
            {
                String[] parts = line.split(",");
                if (parts.length >= 10) 
                {
                    int oid = Integer.parseInt(parts[0]);
                    String date = parts[1];
                    double oprice = Double.parseDouble(parts[2]);
                    String cid = parts[3];
                    String service = parts[4];
                    String iname = parts[5];
                    String vid = parts[6];
                    String iid = parts[7];
                    String rid = parts[8];
                    String ostatus = parts[9];

                    Refund oh = new Refund(oid, date, oprice, cid, service, iname, vid, iid, rid, ostatus);
                    orderHList.add(oh);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return orderHList; // Return the list if needed
    }
    
    
    //read ordering
    public List<Refund> readOrdering() throws IOException
    {
        List<Refund> orderingList = new ArrayList<>();
        
        File orderingFile = new File("ordering.txt");
        try (FileReader loadOrdering = new FileReader(orderingFile)) 
        {
            BufferedReader bro = new BufferedReader(loadOrdering);
            String line;
            while ((line = bro.readLine()) != null) 
            {
                String[] parts = line.split(",");
                if (parts.length >= 11) 
                {
                    int oid = Integer.parseInt(parts[0]);
                    String date = parts[1];
                    double oprice = Double.parseDouble(parts[2]);
                    String cid = parts[3];
                    String service = parts[4];
                    String iname = parts[5];
                    String ostatus = parts[6];
                    String vid = parts[7];
                    int deliveryS = Integer.parseInt(parts[8]);
                    String iid = parts[9];
                    String rid = parts[10];

                    Refund o1 = new Refund(oid, date, oprice, cid, service, iname, ostatus, vid, deliveryS, iid, rid);
                    orderingList.add(o1);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return orderingList; // Return the list if needed
    }
    
    //refund order
    public void refundOrder() throws IOException
    {
        List<Customer> customerBalanceList = readCustomerBalance();
        List<Refund> orderHList = readOrderHistory();
        
        for (Refund ro : orderHList)
        {
            Customer cb1 = findCustomerById(customerBalanceList, ro.getuID());
            
            if (cb1 != null)
            {
                double newBalance = cb1.getBalance() + ro.getItemPrice();
                cb1.setBalance(newBalance);
            }
        }
        saveCustomerBalance(customerBalanceList);
    }
    
    // matche the customer id in customerProfile and orderHistory
    private Customer findCustomerById(List<Customer> customerBalanceList, String cid)
    {
        for (Customer cb1 : customerBalanceList)
        {
            if (cb1.getId().equals(cid))
            {
                return cb1;
            }
        }
        return null; // Customer not found
    }
    
    //refund delivery fee
    public void refundDeliveryFees() throws IOException
    {
        List<Customer> customerBalanceList = readCustomerBalance();
        List<Refund> orderingList = readOrdering();
        
        for (Refund rd : orderingList)
        {
            Customer cb1 = findCustomerById(customerBalanceList, rd.getuID());
            
            if (cb1 != null) 
            {
                double newBalance = cb1.getBalance() + 5.0;
                cb1.setBalance(newBalance);
            }
        }
        saveCustomerBalance(customerBalanceList);
    }
    
    // count runner
    private int countRunners() throws IOException
    {
        int Count = 0;
        
        File uFile = new File("User.txt");
        try(FileReader ru = new FileReader(uFile))
        {
            BufferedReader cCount = new BufferedReader(ru);
            String line;
            String Role;
            while((line = cCount.readLine()) != null)
            {
                String [] parts = line.split(",");
                if(parts.length>3){
                Role = (parts[2]);
                if(Role.equals("runner"))
                {
                    Count ++;
                }}
            }
        }
        return Count;
    }
    
    //big method
    public void refundBalance() throws IOException
    {
        int runnerCount = countRunners();
        
        List<Refund> orderingList = readOrdering();
        for (Refund rd : orderingList)
        {
            if ("Delivery".equals(rd.getServiceType()) && "completed".equals(rd.getOrderStatus()) && runnerCount > rd.getDeliveryS())
            {
                refundDeliveryFees();
            }
        }
            
        List<Refund> orderHList = readOrderHistory();
        for (Refund ro : orderHList)
        {
            if ("Canceled order".equals(ro.getOrderStatus()))
            {
                refundOrder();
            }
        }
    }
}
