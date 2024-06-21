/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HPvictus2022
 */
class Order extends SuperOrder
{
    private String CorC;
    private int selectedRow;
    private String uID;
    private int orderId;
    private String orderTime;
    private String serviceType;
    private String itemID;
    private String address;
    private String vendorID;
    private double itemPrice;
    private String itemName;
    private int[] selectedRows;
    private String runnerID;
    private String orderStatus;
    private int deliveryS;
    private String foodR;
    private String deliveryR;
    private double deliveryFees;
    private int maxId=0;
    private Object[][] OrderH;        
    List<String> lines = new ArrayList<>();  

    /**
     * @return the deliveryS
     */
    public int getDeliveryS() {
        return deliveryS;
    }

    /**
     * @param deliveryS the deliveryS to set
     */
    public void setDeliveryS(int deliveryS) {
        this.deliveryS = deliveryS;
    }

    public Order()
    {
        
    }
    
    
    public Order(String uID)
    {
        this.uID=uID;
    }
    
    
    @Override
    public List<Order> ReadHistory() {
    List<Order> orderHisList = new ArrayList<>();
    String path="orderHistory.txt";
    File orderFile = new File(path);
    try (FileReader input = new FileReader(orderFile); BufferedReader readOrderHistory = new BufferedReader(input)){
        String line;
        while ((line = readOrderHistory.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 11) {
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
                if(cid.equals(uID))
                {
                    Order od = new Order(oid, date, oprice, cid, service, iname, vid, iid, rid, ostatus);
                    orderHisList.add(od);}}}} 
    catch (IOException ex) {
        Logger.getLogger(Vorder.class.getName()).log(Level.SEVERE, null, ex);
    }
    return orderHisList;
    }
    
    
    public Order(int oid,String date,double oprice,String cid,String service,String iname,String vid
            ,String iid,String rid,String ostatus)
    {
        this.uID=cid;
        this.orderId=oid;
        this.orderTime=date;
        this.serviceType=service;
        this.itemID=iid;
        this.vendorID=vid;
        this.itemPrice=oprice;
        this.itemName=iname;
        this.runnerID=rid;
        this.orderStatus=ostatus;
    }
    
    
    @Override
    public List<Order> ReadOrder() {
    List<Order> orderHisList = new ArrayList<>();
    String path="ordering.txt";
    File orderFile = new File(path);
    try (FileReader input = new FileReader(orderFile); BufferedReader readOrderHistory = new BufferedReader(input)){
        String line;
        while ((line = readOrderHistory.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 11) {
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
                if(cid.equals(uID))
                {
                    Order od = new Order(oid, date, oprice, cid, service, iname, vid,deliveryS, iid, rid, ostatus);
                    orderHisList.add(od);}}}} 
    catch (IOException ex) {
        Logger.getLogger(Vorder.class.getName()).log(Level.SEVERE, null, ex);
    }
    return orderHisList;
    }
    
    
    public Order(int oid,String date,double oprice,String cid,String service,String iname,String vid, int deliveryS
            ,String iid,String rid,String ostatus)
    {
        this.uID=cid;
        this.orderId=oid;
        this.orderTime=date;
        this.serviceType=service;
        this.itemID=iid;
        this.vendorID=vid;
        this.deliveryS=deliveryS;
        this.itemPrice=oprice;
        this.itemName=iname;
        this.runnerID=rid;
        this.orderStatus=ostatus;
    }
    
    
    public int generateID() {
        long timestamp = System.currentTimeMillis();
        Random random = new Random();
        int randomComponent = random.nextInt(1000);
        String orderIdString = timestamp + "" + randomComponent;
        orderId = Math.abs(orderIdString.hashCode());
        return orderId;
    }
    
    
    public String generateTime(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return time.format(formatt);}
    
    
    public void placeOrder() {
        List<String> orderedItems = new ArrayList<>();
        double total = 0.0;
        String runnerID="-";
        String addressC;
        if(getServiceType().equals("Delivery")){
        addressC= address;}else{addressC="-";}
        for (int row : selectedRows) {
            orderedItems.add(getItemName());
            total += getItemPrice();
        }
        String path="ordering.txt";
        try (BufferedWriter orderWriter = new BufferedWriter(new FileWriter(path, true))) {
            String orderDetails = String.format("%d,%s,%.2f,%s,%s,%s,%s,%s,%d,%s,%s,%s", getOrderId(),
                    getOrderTime(), total, getuID(), getServiceType(),
                    String.join(",", orderedItems),"pending",
                    getVendorID(),0, getItemID(),runnerID, addressC);
            orderWriter.write(orderDetails);
            orderWriter.newLine();
            JOptionPane.showMessageDialog(null, "Ordered successfully", "Order Status",
                    JOptionPane.INFORMATION_MESSAGE);
            orderWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed", "Order Status",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //two methods below is to cancel order and update it in the ordering txt 
    //three method below is for collecting item
    public boolean receivedOrder(String orderType) {
    if (selectedRow != -1) {
        if (orderType.equals("completed") && getOrderStatus().equals("completed")) {
            removeRowFromFile();
            return true;
        } else if ((orderType.equals("declined") || orderType.equals("pending")) 
                && (getOrderStatus().equals("declined") || getOrderStatus().equals("pending"))) {
            removeRowFromFile();
            return true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Your item is still in preparation or ready to collect, please be patient.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    } else {
        JOptionPane.showMessageDialog(null,
                "Please select an item to " + (orderType.equals("completed") ? "collect." : "cancel."),
                "Warning", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    }
    
    
    private void removeRowFromFile() {
    String path="ordering.txt";
        try {
        List<String> lines = Files.readAllLines(Paths.get(path));
        lines.removeIf(line -> line.startsWith(getOrderId() + ","));
        Files.write(Paths.get(path), lines);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    
    public void removeFromFile(String orderId) {
    String path="ordering.txt";
        try {
        List<String> lines = Files.readAllLines(Paths.get(path));
        lines.removeIf(line -> line.startsWith(orderId + ","));
        Files.write(Paths.get(path), lines);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    
    public void updateHistory() {
        String path="orderHistory.txt";
        if(getOrderStatus().equals("pending")){orderStatus="Canceled order";}
    try (BufferedWriter orderWriter = new BufferedWriter(new FileWriter(path, true))) 
    {
        String orderDetails = String.format("%d,%s,%.2f,%s,%s,%s,%s,%s,%s,%s,%.2f", getOrderId(),
                getOrderTime(), getItemPrice(),
                getuID(), getServiceType(), getItemName(), getVendorID(),
                getItemID(), getRunnerID(), getOrderStatus(),deliveryFees);
        orderWriter.write(orderDetails);
        orderWriter.newLine();
        JOptionPane.showMessageDialog(null,
                "Updated successfully", "Order Status", JOptionPane.INFORMATION_MESSAGE);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    
    public void review() {
        String path="review.txt";
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
        String orderDetails = String.format("%d$%s$%s$%s$%s$%s$%s$%s$%s", getOrderId(), getItemID(),
                getuID(), getVendorID(), getRunnerID(), getItemName(), foodR, deliveryR,
                getOrderTime());
        writer.write(orderDetails);
        writer.newLine();
        JOptionPane.showMessageDialog(null,
                "Enjoy your meal", "Review order", JOptionPane.INFORMATION_MESSAGE);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    
    //bewlow are displaying transaction history
    public DefaultTableModel transactions() {
    List<String[]> dateAndAmountList = new ArrayList<>();
    String path="orderHistory.txt";
    try (BufferedReader read = new BufferedReader(new FileReader(path))) {
        String line;
        while ((line = read.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 4 && parts[3].trim().equals(getuID())&& parts[9].trim().equals("completed")) {
                String date = parts[1].trim();
                String amount = parts[2].trim();
                dateAndAmountList.add(new String[]{date, amount});
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    Object[][] trans = new Object[dateAndAmountList.size()][];
    for (int i = 0; i < dateAndAmountList.size(); i++) {
        trans[i] = dateAndAmountList.get(i);
    }

    String[] labels = {"Date", "Total"};
    return new DefaultTableModel(trans, labels);
    }
    

    public Object[][] menu()
    {
        String path="menu.txt";
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = read.readLine()) != null) {
                String[]seperate=line.split(",");
                if(seperate.length>=4)
                {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        OrderH = new Object[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            OrderH[i] = lines.get(i).split(","); 
        }
        return OrderH;
    }
    
    
    public String[] MenuItems() {
        List<String> items = new ArrayList<>();
        String path="menu.txt";
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = read.readLine()) != null) {
                String[] separate = line.split(",");
                if (separate.length >= 4) {
                    items.add(separate[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items.toArray(new String[0]);
    }

    public String RandomMenuSuggestion() {
        String[] menuItems = MenuItems();
        if (menuItems.length > 0) {
            Random random = new Random();
            int randomIndex = random.nextInt(menuItems.length);
            return menuItems[randomIndex];
        } else {
            return "No menu items available.";
        }
    }
    
    public void displayRecommendations(String uID) {
        Order orderHistory = new Order();
        orderHistory.setuID(uID);
        List<Order> orderHistoryList = orderHistory.ReadHistory();
        StringBuilder recommendation = new StringBuilder("Here are some recommendations for you:\n");
        if (!orderHistoryList.isEmpty()) {
            Order lastOrder = orderHistoryList.get(orderHistoryList.size() - 1);
            String lastVendor = lastOrder.getVendorID();
            recommendation.append("1. Is the previous ordered items good?! Try more dishes from ")
                    .append(lastVendor).append("!\n");
            JOptionPane.showMessageDialog(null, recommendation.toString(),
                    "Recommendations", JOptionPane.INFORMATION_MESSAGE);
        } else {
            recommendation.append("You haven't placed any orders yet. Start exploring our menu!");
            JOptionPane.showMessageDialog(null, recommendation.toString(),
                    "Recommendations", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public String notification(String uid) {
        String path="BalanceNotification.txt";
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[0].trim().equals(uid)) {
                    double balance = Double.parseDouble(parts[2].trim());
                    result.append("You have top up RM").append(balance);
                }}}catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //below are just backup method, remove soon
    /*
    public int generateID2() {
    try (BufferedReader read1 = new BufferedReader(new FileReader("C:\\Users\\victu\\ordering.txt"));
         BufferedReader read2 = new BufferedReader(new FileReader("C:\\Users\\victu\\orderHistory.txt"))) {
        readAndCompareIds(read1);
        readAndCompareIds(read2);
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
    }
    return maxId;
    }

    
    private void readAndCompareIds(BufferedReader reader) throws IOException {
    String line;
    while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length > 0 && !parts[0].trim().isEmpty()) {
            try {
                int id = Integer.parseInt(parts[0].trim());
                if (id > maxId) {
                    maxId = id + 1;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
    }
    
    
    //below are read review
    public String showReview() {
    if (selectedRow != -1) {
        List<String> reviews = getReview();
        if (!reviews.isEmpty()) {
            StringBuilder reviewText = new StringBuilder();
            for (String review : reviews) {
                reviewText.append(review).append("\n");
            }
            return reviewText.toString();
        } else {
            return "No reviews available for this item.";
        }
    }return "Please select a row";
    }
    
    
    private Map<String, List<String>> reviewsMap = new HashMap<>();
    private List<String> getReview() {
        List<String> reviews = new ArrayList<>();
        String filePath = "C:\\Users\\victu\\review.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\$");
                if (parts.length >= 6 && parts[1].trim().equals(getItemID())) {
                    reviews.add(parts[6].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reviews;
    }
    
    
    public List<String[]> oStatus() {
    List<String[]> statusList = new ArrayList<>();
    try (BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\victu\\ordering.txt"))) {
        String line;
        while ((line = read.readLine()) != null) {
            String[] separate = line.split(",");
            if (separate.length >= 4 && separate[3].trim().equals(getuID())) {
                statusList.add(separate);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return statusList;
    }
    
    
    public List<String[]> readH() {
    List<String[]> lines = new ArrayList<>();
    try (BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\victu\\orderHistory.txt"))) {
        String line;
        while ((line = read.readLine()) != null) {
            String[] separate = line.split(",");
            if (separate.length >= 4 && separate[3].trim().equals(getuID())) {
                lines.add(separate);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return lines;}
    
    
    public List<String[]> oStatus() {
    List<String[]> statusList = new ArrayList<>();
    try (BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\victu\\ordering.txt"))) {
        String line;
        while ((line = read.readLine()) != null) {
            String[] separate = line.split(",");
            if (separate.length >= 4 && separate[3].trim().equals(getuID())) {
                statusList.add(separate);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return statusList;
}
    
    
    public boolean receivedOrder2(String orderType) {
    if (selectedRow != -1) {
        if ((orderType.equals("completed") && orderStatus.equals("completed")) ||
            ((orderType.equals("declined") || orderType.equals("pending")) 
                && (orderStatus.equals("declined") || orderStatus.equals("pending")))) {
            removeRowFromFile();
            return true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Your item is still in preparation, please be patient.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    } else {
        JOptionPane.showMessageDialog(null,
                "Please select an item to " + (orderType.equals("completed") ? "collect." : "cancel."), "Warning", JOptionPane.WARNING_MESSAGE);
        return false;
    }
}
    
    
    public Object[][] oStatus2()
    {
        List<String> status = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\victu\\ordering.txt"))) {
            String line;
            while ((line = read.readLine()) != null) 
            {
                String[]seperate=line.split(",");
                if(seperate.length>=4&& seperate[3].trim().equals(uID))
                {
                    status.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        statusH = new Object[status.size()][];
        for (int i = 0; i < status.size(); i++) {
            statusH[i] = status.get(i).split(","); 
        }
        return statusH;}
    
    
    public Object[][] readH2(){
        try (BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\victu\\orderHistory.txt"))) {
            String line;
            while ((line = read.readLine()) != null) {
                String[]seperate=line.split(",");
                if(seperate.length>=4&&seperate[3].trim().equals(uID))
                {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        OrderH = new Object[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            OrderH[i] = lines.get(i).split(","); 
        }
        return OrderH;}
    
    
    public boolean receivedOrder() {
        if (selectedRow != -1) {
            if (orderStatus.equals("completed")) {
            removeRowFromFile();
            return true;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Your item is still in preparation, please be patient.", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Please select an item to collect.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    
    public boolean receivedOrder2() {
    if (selectedRow != -1) {
        if (orderStatus.equals("declined") || orderStatus.equals("pending")) {
            removeRowFromFile();
            return true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Your item is still in preparation, please be patient.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    } else {
        JOptionPane.showMessageDialog(null,
                "Please select an item to cancel.", "Warning", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    }
    
    
    public boolean cancelOrder2(DefaultTableModel model,JTable statusTable) {
        int Row = statusTable.getSelectedRow();
        if (Row != -1) {
            model.removeRow(Row);
            for (int i = 0; i < model.getRowCount(); i++) {
                Object[] rowData = new Object[model.getColumnCount()];
                for (int j = 0; j < rowData.length; j++) {
                    rowData[j] = model.getValueAt(i, j);
                }
                data.add(rowData);
            }
            return true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Please select a row to remove.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    
    public void reOrder() {
        List<String> orderedItems = new ArrayList<>();
        double total = 0.0;
        String deliveryStatus="-";
        String runnerID="-";
        String addressC;
        if(serviceType.equals("Delivery")){
        addressC= address;}else{addressC="-";}
        for (int row : selectedRows) {
            orderedItems.add(itemName);
            total += itemPrice;
        }
        try (BufferedWriter orderWriter = new BufferedWriter(new FileWriter("C:\\Users\\victu\\ordering.txt", true))) {
            String orderDetails = String.format("%d,%s,%.2f,%s,%s,%s,%s,%s,%s,%s,%s,%s", orderId,
                    orderTime, total, uID, serviceType,
                    String.join(",", orderedItems),"pending",vendorID,
                    deliveryStatus, itemID,runnerID, addressC);
            orderWriter.write(orderDetails);
            orderWriter.newLine();
            JOptionPane.showMessageDialog(null,
                    "Ordered successfully", "Order Status", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public boolean cancelOrder(DefaultTableModel model) {
        if (Row != -1) {
            String orderStatus = (String) model.getValueAt(Row,6 );
            if (orderStatus.equals("pending")) {
                model.removeRow(Row);
                for (int i = 0; i < model.getRowCount(); i++) {
                    Object[] rowData = new Object[model.getColumnCount()];
                    for (int j = 0; j < rowData.length; j++) {
                        rowData[j] = model.getValueAt(i, j);
                    }
                    data.add(rowData);
                }
                return true;
            } 
            else if (orderStatus.equals("accept")) { 
            JOptionPane.showMessageDialog(null,
                    "The vendor is already preparing the food.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }else{
            JOptionPane.showMessageDialog(null,
                    "Your item is ready for collect", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;}
    } else {
            JOptionPane.showMessageDialog(null,
                    "Please select an item to cancel", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
}
    
    
    
    public void updateFile2(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Object[] row : data) {
                String line = String.join(",",
                        Arrays.asList(row).toString());
                writer.write(line);
                writer.newLine();
            }
            JOptionPane.showMessageDialog(null,
                    "Canceled successfully", "Order Status", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void updateFile3(String filePath) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        for (Object[] row : data) {
            StringBuilder line = new StringBuilder();
            for (Object element : row) {
                line.append(element.toString()).append(",");
            }
            // Remove the trailing comma
            line.deleteCharAt(line.length() - 1);

            writer.write(line.toString());
            writer.newLine();
        }
        JOptionPane.showMessageDialog(null,
                "Canceled successfully", "Order Status", JOptionPane.INFORMATION_MESSAGE);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    
    
    public void reOrder2(String Id,String Time,String total,String uID)
    {
        try (BufferedWriter order = new BufferedWriter(new FileWriter("C:\\Users\\victu\\ordering.txt", true))) 
            {
                order.write(Id + "," + Time + "," + total+ "," + uID);
                order.newLine();
                JOptionPane.showMessageDialog(null, "Ordered successful"
                        , "Order Status", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) 
            {
                e.printStackTrace();
            }
    }
    
    public Object[][] readH2(String id)
    {
        try (BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\victu\\orderHistory.txt"))) {
            String line;
            while ((line = read.readLine()) != null) {
                String[]seperate=line.split(",");
                if(seperate.length>=4&&seperate[3].trim().equals("c12"))
                {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        OrderH = new Object[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            OrderH[i] = lines.get(i).split(","); 
        }
        return OrderH;
    }      */

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @param orderTime the orderTime to set
     */
    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * @param serviceType the serviceType to set
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * @param itemID the itemID to set
     */
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param uID the uID to set
     */
    public void setuID(String uID) {
        this.uID = uID;
    }

    /**
     * @param vendorID the vendorID to set
     */
    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    /**
     * @param itemPrice the itemPrice to set
     */
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @param selectedRows the selectedRows to set
     */
    public void setSelectedRows(int[] selectedRows) {
        this.selectedRows = selectedRows;
    }

    /**
     * @param selectedRow the selectedRow to set
     */
    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    /**
     * @param oID the oID to set
     */
    public void setoID(String oID) {
    }

    /**
     * @param Row the Row to set
     */
    public void setRow(int Row) {
    }

    /**
     * @param runnerID the runnerID to set
     */
    public void setRunnerID(String runnerID) {
        this.runnerID = runnerID;
    }

    /**
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * @param foodR the foodR to set
     */
    public void setFoodR(String foodR) {
        this.foodR = foodR;
    }

    /**
     * @return the deliveryR
     */
    public String getDeliveryR() {
        return deliveryR;
    }

    /**
     * @param deliveryR the deliveryR to set
     */
    public void setDeliveryR(String deliveryR) {
        this.deliveryR = deliveryR;
    }

    /**
     * @param deliveryFees the deliveryFees to set
     */
    public void setDeliveryFees(double deliveryFees) {
        this.deliveryFees = deliveryFees;
    }

    /**
     * @return the CorC
     */
    public String getCorC() {
        return CorC;
    }

    /**
     * @param CorC the CorC to set
     */
    public void setCorC(String CorC) {
        this.CorC = CorC;
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @return the orderTime
     */
    public String getOrderTime() {
        return orderTime;
    }

    /**
     * @return the serviceType
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * @return the itemID
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * @return the vendorID
     */
    public String getVendorID() {
        return vendorID;
    }

    /**
     * @return the itemPrice
     */
    public double getItemPrice() {
        return itemPrice;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @return the runnerID
     */
    public String getRunnerID() {
        return runnerID;
    }

    /**
     * @return the orderStatus
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * @return the uID
     */
    public String getuID() {
        return uID;
    }

}
