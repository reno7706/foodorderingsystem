
package fos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Salary 
{
    private int OrderID;
    private double DeliveryFee;
    private String CustomerID,ServiceType,itemName,vendorID,ItemID,RunnerID,OrderStatus;
    private LocalDateTime Date;
     
    public Salary()
    {
    }
    public Salary(String runnerid)
    {
        this.RunnerID=runnerid;
    }
    public Salary(int orderid,LocalDateTime orderdate,double price,String cusid,String service,String itemname,String vendorid,String itemid,String runnerid,String status,double fee)
    {
        this.OrderID=orderid;
        this.Date = orderdate;
        this.CustomerID = cusid;
        this.ServiceType = service;
        this.itemName = itemname;
        this.vendorID = vendorid;
        this.ItemID = itemid;
        this.RunnerID = runnerid;
        this.OrderStatus = status;
        this.DeliveryFee = fee;
    }
    
     public List<Salary> readSalary(String runnerid)throws IOException
    {
        List<Salary> salaryList = new ArrayList<>();
        
        File orderFile=new File("orderHistory.txt");
        try (FileReader input = new FileReader(orderFile); BufferedReader readSalary = new BufferedReader(input)) 
        {
            
            String line; 
            while ((line = readSalary.readLine()) != null)
            {
                String[] parts = line.split(",");
                
                if (parts.length >= 11) 
                {
                    int oid=Integer.parseInt(parts[0]);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime ODate=LocalDateTime.parse(parts[1],formatter);
                    double price = Double.parseDouble(parts[2]);
                    String cid= parts[3];
                    String service = parts[4];
                    String itemn = parts[5];
                    String vid=parts[6];
                    String itemid=parts[7];
                    String rid=parts[8];
                    String status=parts[9];
                    double fee=Double.parseDouble(parts[10]);
                    
                    if (runnerid.equals(rid))
                    {
                        Salary s= new Salary(oid,ODate,price,cid,service,itemn,vid,itemid,rid,status,fee);
                        salaryList.add(s);
                    }
                }
            }
        }
        return salaryList;
    }
     public double calculateTodayTotalEarnings() throws IOException {
        double totalEarnings = 0.0;
        List<Salary> salaryList;
        salaryList = readSalary(RunnerID); 
        LocalDateTime today = LocalDateTime.now();
        for (Salary order : salaryList) {
            if (order.getDate().toLocalDate().isEqual(today.toLocalDate())) {
                totalEarnings += order.getDeliveryFee();
            }
        }
        return totalEarnings;
    }
     public double calculateWeekTotalEarnings() throws IOException {
        double totalEarnings = 0.0;
        List<Salary> salaryList;
        salaryList = readSalary(RunnerID);  
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.minusDays(today.getDayOfWeek().getValue() - 1);
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        for (Salary order : salaryList) {
            LocalDate orderDate = order.getDate().toLocalDate();
            if (!orderDate.isBefore(startOfWeek) && !orderDate.isAfter(endOfWeek)) {
                totalEarnings += order.getDeliveryFee();
            }
        }
        return totalEarnings;
     }
     
      public double calculateYearTotalEarnings() throws IOException {
        double totalEarnings = 0.0;
        List<Salary> salaryList;
        salaryList = readSalary(RunnerID);
        LocalDate today = LocalDate.now();
        LocalDate startOfYear = LocalDate.of(today.getYear(), 1, 1);
        LocalDate endOfYear = LocalDate.of(today.getYear(), 12, 31);

        for (Salary order : salaryList) {
            LocalDate orderDate = order.getDate().toLocalDate();
            if (!orderDate.isBefore(startOfYear) && !orderDate.isAfter(endOfYear)) {
                totalEarnings += order.getDeliveryFee();
            }
        }
        return totalEarnings;
    }

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
     * @return the Date
     */
    public LocalDateTime getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(LocalDateTime Date) {
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
     * @return the ServiceType
     */
    public String getServiceType() {
        return ServiceType;
    }

    /**
     * @param ServiceType the ServiceType to set
     */
    public void setServiceType(String ServiceType) {
        this.ServiceType = ServiceType;
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
     * @return the vendorID
     */
    public String getVendorID() {
        return vendorID;
    }

    /**
     * @param vendorID the vendorID to set
     */
    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    /**
     * @return the ItemID
     */
    public String getItemID() {
        return ItemID;
    }

    /**
     * @param ItemID the ItemID to set
     */
    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    /**
     * @return the RunnerID
     */
    public String getRunnerID() {
        return RunnerID;
    }

    /**
     * @param RunnerID the RunnerID to set
     */
    public void setRunnerID(String RunnerID) {
        this.RunnerID = RunnerID;
    }

    /**
     * @return the OrderStatus
     */
    public String getOrderStatus() {
        return OrderStatus;
    }

    /**
     * @param OrderStatus the OrderStatus to set
     */
    public void setOrderStatus(String OrderStatus) {
        this.OrderStatus = OrderStatus;
    }
    
    /**
     * @param DeliveryFee the DeliveryFee to set
     */
    public void setDeliveryFee(double DeliveryFee) {
        this.DeliveryFee = DeliveryFee;
    }

    /**
     * @return the DeliveryFee
     */
    public double getDeliveryFee() {
        return DeliveryFee;
    }
     
    
}



