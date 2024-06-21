
package fos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class ReadExtraFeature 
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
     * @return the DeliveryFee
     */
    public double getDeliveryFee() {
        return DeliveryFee;
    }

    /**
     * @param DeliveryFee the DeliveryFee to set
     */
    public void setDeliveryFee(double DeliveryFee) {
        this.DeliveryFee = DeliveryFee;
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
     * @return the Date
     */
    public LocalDate getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(LocalDate Date) {
        this.Date = Date;
    }
    
    private int OrderID;
    private double DeliveryFee;
    private String CustomerID,ServiceType,itemName,vendorID,ItemID,OrderStatus;
    private LocalDate Date;
    public ReadExtraFeature()
    {}
   
    
    public ReadExtraFeature(String orderdate)
    {
        
        this.Date = LocalDate.parse(orderdate);
    }
    
     public String GetBestRunnerCount() throws IOException 
     {
         String highestCountRunnerID = null;
         int highestCount = 0;

        File historyFile = new File("orderHistory.txt");

        try (FileReader input = new FileReader(historyFile); BufferedReader BR = new BufferedReader(input)) {
            String line;
            while ((line = BR.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 11) {
                    String rid = parts[8];
                    String orderDate = parts[1];
                    LocalDate localDate = LocalDate.parse(orderDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    if (localDate.getMonthValue() == LocalDate.now().getMonthValue()) {
                        int count = 1;
                        if (rid.equals(highestCountRunnerID)) {
                            count = highestCount + 1;
                        }
                        if (count > highestCount) {
                            highestCount = count;
                            highestCountRunnerID = rid;
                        }
                    }
                }
            }
        }

        return highestCountRunnerID;
    }
     
}







