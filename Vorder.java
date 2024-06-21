/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fos;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ANNABEL
 */
public class Vorder extends SuperOrder
{
    private int orderid;
    private String vendorid,cusid,orderservice,itemname,orderstatus,deliverstatus,itemid,runnerid,cusAdd;
    private double orderprice,dfee;
    private LocalDateTime orderdate;

    public int getOrderid() {
        return orderid;
    }
    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
    public String getVendorid() {
        return vendorid;
    }
    public void setVendorid(String vendorid) {
        this.vendorid = vendorid;
    }
    public String getCusid() {
        return cusid;
    }
    public void setCusid(String cusid) {
        this.cusid = cusid;
    }
    public String getOrderservice() {
        return orderservice;
    }
    public void setOrderservice(String orderservice) {
        this.orderservice = orderservice;
    }
    public String getItemname() {
        return itemname;
    }
    public void setItemname(String itemname) {
        this.itemname = itemname;
    }
    public String getOrderstatus() {
        return orderstatus;
    }
    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }
    public String getDeliverstatus() {
        return deliverstatus;
    }
    public void setDeliverstatus(String deliverstatus) {
        this.deliverstatus = deliverstatus;
    }
    public String getItemid() {
        return itemid;
    }
    public void setItemid(String itemid) {
        this.itemid = itemid;
    }
    public String getRunnerid() {
        return runnerid;
    }
    public void setRunnerid(String runnerid) {
        this.runnerid = runnerid;
    }
    public double getOrderprice() {
        return orderprice;
    }
    public void setOrderprice(double orderprice) {
        this.orderprice = orderprice;
    }
    public String getCusAdd() {
        return cusAdd;
    }
    public LocalDateTime getOrderdate() {
        return orderdate;
    }
    public void setOrderdate(LocalDateTime orderdate) {
        this.orderdate = orderdate;
    }
    public Vorder()
    {
        
    }
    public Vorder(String vendorid)
    {
        this.vendorid=vendorid;
    }
    //for ordering
    public Vorder(int orderid,LocalDateTime orderdate,double orderprice,String cusid,String orderservice,String itemname,String orderstatus,String vendorid,String deliverstatus,String itemid,String runnerid,String cusAdd)
    {
        this.vendorid=vendorid;
        this.orderid=orderid;
        this.orderdate=orderdate;
        this.cusid=cusid;
        this.orderservice=orderservice;
        this.itemname=itemname;
        this.orderstatus=orderstatus;
        this.deliverstatus=deliverstatus;
        this.itemid=itemid;
        this.runnerid=runnerid;
        this.orderprice=orderprice;
        this.cusAdd=cusAdd;
    }
    //for orderhistory
    public Vorder(int orderid,LocalDateTime orderdate,double orderprice,String cusid,String orderservice,String itemname,String vendorid,String itemid,String runnerid,String orderstatus,double dfee)
    {
        this.vendorid=vendorid;
        this.orderid=orderid;
        this.orderdate=orderdate;
        this.cusid=cusid;
        this.orderservice=orderservice;
        this.itemname=itemname;
        this.orderstatus=orderstatus;
        this.itemid=itemid;
        this.runnerid=runnerid;
        this.orderprice=orderprice;
        this.dfee=dfee;
    }
    public FileReader ReadOrderingFile() throws FileNotFoundException
    {
        File orderFile=new File("ordering.txt");
        FileReader LoadOrderFile=new FileReader(orderFile);
        return LoadOrderFile;
    }
    //accept or decline order
    public void receiveOrder(int orderid,String choices) throws IOException
    {
        List<Vorder> AllOrderList;
            try (BufferedReader br = new BufferedReader(ReadOrderingFile())) {
                AllOrderList = new ArrayList<>();
                String line;
                while ((line = br.readLine()) != null) 
                {
                    String[] parts = line.split(",");
                    if (parts.length >= 12)
                    {
                        int oid=Integer.parseInt(parts[0]);
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime date = LocalDateTime.parse(parts[1], formatter);
                        double oprice=Double.parseDouble(parts[2]);
                        String cid = parts[3];
                        String service = parts[4];
                        String iname = parts[5];
                        String ostatus = parts[6];
                        String vid= parts[7];
                        String dstatus = parts[8];
                        String iid = parts[9];
                        String rid = parts[10];
                        String cadd=parts[11];
                        
                        Vorder od = new Vorder(oid,date,oprice,cid,service,iname,ostatus,vid,dstatus,iid,rid,cadd);
                        AllOrderList.add(od);
                    }
                }   for(Vorder allorder :AllOrderList)
                {
                    if( allorder.getOrderid()==orderid&& choices.equals("declined"))
                    {
                        allorder.setOrderstatus("declined");
                    }
                    else if( allorder.getOrderid()==orderid&& choices.equals("accepted"))
                    {
                        allorder.setOrderstatus("accepted");
                    }
                }
            }
            saveOrderToFile(AllOrderList);
    }
    
    public void updateOrder(int orderid)
    {
        try 
        {
            List<Vorder> AllOrderList;
            try (BufferedReader br = new BufferedReader(ReadOrderingFile())) {
                AllOrderList = new ArrayList<>();
                String line;
                while ((line = br.readLine()) != null) 
                {
                    String[] parts = line.split(",");
                    
                    if (parts.length >= 12)
                    {
                        int oid=Integer.parseInt(parts[0]);
                        
                        String  dateTimeString= parts[1]; 
                        
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime date = LocalDateTime.parse(dateTimeString, formatter);
                        
                        double oprice=Double.parseDouble(parts[2]);
                        String cid = parts[3];
                        String service = parts[4];
                        String iname = parts[5];
                        String ostatus = parts[6];
                        String vid= parts[7];
                        String dstatus = parts[8];
                        String iid = parts[9];
                        String rid = parts[10];
                        String cAdd=parts[11];
                        
                        Vorder od = new Vorder(oid,date,oprice,cid,service,iname,ostatus,vid,dstatus,iid,rid,cAdd);
                        AllOrderList.add(od);
                    }
                }   for(Vorder allorder :AllOrderList)
                {
                    if( allorder.getOrderid()==orderid&& (allorder.getOrderservice().equals("Dine In")||allorder.getOrderservice().equals("Take Away")))
                    {
                        allorder.setOrderstatus("completed");
                    }
                    else if(allorder.getOrderid()==orderid && allorder.getOrderservice().equals("Delivery"))
                    {
                        allorder.setOrderstatus("Ready");
                    }
                }
            }
            saveOrderToFile(AllOrderList);
        } 
        catch (IOException e) {
        }
    }
    
    
    @Override
    public List<Vorder> ReadOrder()
    {
        List<Vorder> orderList = new ArrayList<>();
        try (BufferedReader readOrder = new BufferedReader(ReadOrderingFile())) {
            
            String line; 
            while ((line = readOrder.readLine()) != null)
            {
                String[] parts = line.split(",");
                
                if (parts.length >= 12) 
                {
                    int oid=Integer.parseInt(parts[0]);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime date = LocalDateTime.parse(parts[1], formatter);
                    double oprice=Double.parseDouble(parts[2]);
                    String cid = parts[3];
                    String service = parts[4];
                    String iname = parts[5];
                    String ostatus = parts[6];
                    String vid= parts[7];
                    String dstatus = parts[8];
                    String iid = parts[9];
                    String rid = parts[10];
                    String cAdd=parts[11];
                    
                    
                    if (vid.equals(vendorid))
                    {
                        Vorder od = new Vorder(oid,date,oprice,cid,service,iname,ostatus,vid,dstatus,iid,rid,cAdd);
                        orderList.add(od);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Vorder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderList;
    }
    public void saveOrderToFile(List<Vorder> orders) throws IOException 
    {
        File orderFile = new File("ordering.txt");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try (FileWriter output = new FileWriter(orderFile); BufferedWriter writer = new BufferedWriter(output))
        {
            for (Vorder od:orders) 
            {
                String line = 
                        od.getOrderid() + "," + formatter.format(od.getOrderdate()) + "," + od.getOrderprice() + "," +
                        od.getCusid()+"," + od.getOrderservice()+"," +od.getItemname()+"," + 
                        od.getOrderstatus()+"," + od.getVendorid()+"," + od.getDeliverstatus()+"," + od.getItemid()+","+ od.getRunnerid()+","+od.getCusAdd();
                
                writer.write(line);
                writer.newLine();
            }
        }
    }
    
    
    @Override
    public List<Vorder> ReadHistory()
    {
        List<Vorder> orderHisList = new ArrayList<>();
        
        File orderFile=new File("orderHistory.txt");
        try (FileReader input = new FileReader(orderFile); BufferedReader readOrderHistory = new BufferedReader(input)) {
            
            String line; 
            while ((line = readOrderHistory.readLine()) != null)
            {
                String[] parts = line.split(",");
                
                if (parts.length >= 11) 
                {
                    int oid=Integer.parseInt(parts[0]);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime date = LocalDateTime.parse(parts[1], formatter);
                    double oprice=Double.parseDouble(parts[2]);
                    String cid = parts[3];
                    String service = parts[4];
                    String iname = parts[5];
                    String vid= parts[6];
                    String iid = parts[7];
                    String rid = parts[8];
                    String ostatus = parts[9];
                    double dfee=Double.parseDouble(parts[10]);
                    
                    
                    if (vid.equals(vendorid))
                    {
                        Vorder od = new Vorder(oid,date,oprice,cid,service,iname,vid,iid,rid,ostatus,dfee);
                        orderHisList.add(od);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Vorder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderHisList;
        
    }
    
    public List<Vorder> ReadOrderHistoryBasedOnTime(String vendorid,String choices)throws IOException
    {
        List<Vorder> orderHis = new ArrayList<>();
        LocalDateTime today = LocalDateTime.now(); 
        File orderFile=new File("orderHistory.txt");
        try (FileReader input = new FileReader(orderFile)) {
            BufferedReader readOrderHistory=new BufferedReader(input);
            
            String line; 
            while ((line = readOrderHistory.readLine()) != null)
            {
                String[] parts = line.split(",");
                
                if (parts.length >= 11) 
                {
                    int oid=Integer.parseInt(parts[0]);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime date = LocalDateTime.parse(parts[1], formatter);
                    double oprice=Double.parseDouble(parts[2]);
                    String cid = parts[3];
                    String service = parts[4];
                    String iname = parts[5];
                    String vid= parts[6];
                    String iid = parts[7];
                    String rid = parts[8];
                    String ostatus = parts[9];
                    double dfee=Double.parseDouble(parts[10]);
                    
                    if (vid.equals(vendorid)) 
                    {
                        switch (choices) 
                        {
                            case "Day" -> {
                                if (date.toLocalDate().isEqual(today.toLocalDate())) {
                                    Vorder od = new Vorder(oid,date,oprice,cid,service,iname,vid,iid,rid,ostatus,dfee);
                                    orderHis.add(od);
                                }
                            }
                            case "Month" -> {
                                if (date.getMonth() == today.getMonth()) {
                                    Vorder od = new Vorder(oid,date,oprice,cid,service,iname,vid,iid,rid,ostatus,dfee);
                                    orderHis.add(od);
                                }
                            }
                            case "Quarter" -> {
                                int currentQuarter = getQuarter(today);
                                int orderQuarter = getQuarter(date);
                                if (currentQuarter == orderQuarter)
                                {
                                    Vorder od = new Vorder(oid,date,oprice,cid,service,iname,vid,iid,rid,ostatus,dfee);
                                    orderHis.add(od);
                                }
                            }
                            case "--" -> {
                                Vorder od = new Vorder(oid,date,oprice,cid,service,iname,vid,iid,rid,ostatus,dfee);
                                orderHis.add(od);
                            }


                        }
                    }
                }
            } 
        }return orderHis;
    }
    public static int getQuarter(LocalDateTime date) 
    {
        int month = date.getMonthValue();
        if (month >= 1 && month <= 3)
        {
            return 1;
        } 
        else if (month >= 4 && month <= 6) 
        {
            return 2; 
        } 
        else if (month >= 7 && month <= 9) 
        {
            return 3; 
        } else 
        {
            return 4;
        }
    }
    public double calculateTodayTotalEarnings() throws IOException {
        double totalEarnings = 0.0;
        List<Vorder> orderList;
        orderList = ReadHistory(); 
        LocalDateTime today = LocalDateTime.now();
        for (Vorder order : orderList) {
            if (order.getOrderdate().toLocalDate().isEqual(today.toLocalDate())&& order.getOrderstatus().equals("completed")&&order.getVendorid().equals(vendorid)) {
                totalEarnings += order.getOrderprice();
            }
        }
        return totalEarnings;
    }
     public double calculateWeekTotalEarnings() throws IOException {
        double totalEarnings = 0.0;
        List<Vorder> orderList;
        orderList = ReadHistory(); 
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.minusDays(today.getDayOfWeek().getValue() - 1);
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        for (Vorder order : orderList) {
            LocalDate orderDate = order.getOrderdate().toLocalDate();
            if (!orderDate.isBefore(startOfWeek) && !orderDate.isAfter(endOfWeek)&& order.getOrderstatus().equals("completed")&&order.getVendorid().equals(vendorid)) {
                totalEarnings += order.getOrderprice();
            }
        }
        return totalEarnings;
    }
     
    public List<String> calculateMostOrderedFood() throws IOException {
        List<Vorder> orderList;
        List<String> foodItemNames = new ArrayList<>();
        orderList = ReadHistory();
        for (Vorder order : orderList) {
            if(order.getVendorid().equals(vendorid))
            {foodItemNames.add(order.getItemname());}
        }
        List<String> top= new ArrayList<>();
        int i=1;
        while (!foodItemNames.isEmpty() && top.size() < 3) 
        {
            String mostCommonItem = null;
            int maxCount = 0;
            for (String itemName : foodItemNames) 
            {
                int frequency = Collections.frequency(foodItemNames, itemName);
                if (frequency > maxCount) {
                    maxCount = frequency;
                    mostCommonItem = itemName;
                }
            }
            top.add(i+": "+mostCommonItem);
            foodItemNames.removeAll(Collections.singleton(mostCommonItem));
            i++;
        }return top;
    }
    public boolean VendorNotification() throws IOException
    {
        List<Vorder> orderList = ReadOrder();
        for(Vorder od:orderList){
            if (od.getOrderstatus().equals("pending")&&od.getVendorid().equals(vendorid)) 
            { 
                return true;
            }
        }return false; 
    }
}
