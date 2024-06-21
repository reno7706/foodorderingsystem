/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fos;

import java.io.*;
import java.util.*;


/**
 *
 * @author ANNABEL
 */
public class Item
{
    private String vendorid;
    private String itemID;
    private String itemName;
    private double itemPrice;
    
    
    public Item()
    {
        
    }
    public Item(String vendorid)
    {
        this.vendorid=vendorid;
    }
    
    public Item(String vendorid,String itemID,String itemName, double itemPrice)
    {
        this.vendorid=vendorid;
        this.itemID=itemID;
        this.itemName=itemName;
        this.itemPrice=itemPrice;
        
    }
    public String getItemID() {
        return itemID;
    }
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public String getVendorid() {
        return vendorid;
    }
    public void setVendorid(String vendorid) {
        this.vendorid = vendorid;
    }
    public FileReader ReadItemFile() throws FileNotFoundException
    {
        File itemFile=new File("menu.txt");
        FileReader LoaditemFile=new FileReader(itemFile);
        return LoaditemFile;
    }
    //create new item
    //write new item into textfile
    public void createItem(String vendorid,String itemID, String itemName,double itemPrice) throws IOException
    {
        File itemFile=new File("menu.txt");
        FileWriter fw=new FileWriter(itemFile,true);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            String line = String.format("%s,%s,%s,%.2f", vendorid, itemID, itemName, itemPrice);
            bw.write(line);
            bw.newLine();
        }        
    }
    //can update id,name or price of the item
    public void updateItem(String vendorid,String iID, String itemName,double itemPrice)
    {
        try 
        {
            List<Item> AllItemList;
            try (BufferedReader br = new BufferedReader(ReadItemFile())) {
                AllItemList = new ArrayList<>();
                String line;
                while ((line = br.readLine()) != null) 
                {
                    String[] parts = line.split(",");
                    
                    if (parts.length >= 4)
                    {
                        String fileVendorID = parts[0];
                        String id=parts[1];
                        String iname = parts[2];
                        double iprice=Double.parseDouble(parts[3]);
                        
                        Item item = new Item(fileVendorID,id,iname,iprice);
                        AllItemList.add(item);
                    }
                }   for(Item allitem :AllItemList)
                {
                    if( allitem.getItemID().equals(iID))
                    {
                        allitem.setVendorid(vendorid);
                        allitem.setItemID(iID);
                        allitem.setItemName(itemName);
                        allitem.setItemPrice(itemPrice);
                    }
                }
            }
            saveItemsToFile(AllItemList);
        } 
        catch (IOException e) {
            
        }
    }
    public void deleteItem(String vendorid,String itemID, String itemName,double itemPrice) throws IOException
    {
        try 
        {
            List<Item> AllItemList;
            try (BufferedReader br = new BufferedReader(ReadItemFile())) {
                AllItemList = new ArrayList<>();
                String line;
                while ((line = br.readLine()) != null) 
                {
                    String[] parts = line.split(",");
                    
                    if (parts.length >= 4)
                    {
                        String fileVendorID = parts[0];
                        String id=parts[1];
                        String iname = parts[2];
                        double iprice=Double.parseDouble(parts[3]);
                        
                        Item item = new Item(fileVendorID,id,iname,iprice);
                        AllItemList.add(item);
                    }
                }   int index=0;
                for(Item allitem :AllItemList)
                {
                    if( allitem.getItemID().equals(itemID))
                    {
                        AllItemList.remove(index);
                        break;
                    }
                    index++;
                }
            }
            saveItemsToFile(AllItemList);
        } 
        catch (IOException e) {
            
        }
        
    }

    public List<Item> ReadItem()throws IOException
    {
        List<Item> itemList = new ArrayList<>();
        
        try (BufferedReader readItem = new BufferedReader(ReadItemFile()))
        {
            
            String line; 
            while ((line = readItem.readLine()) != null)
            {
                String[] parts = line.split(",");
                if (parts.length >= 4) 
                {
                    String fileVendorID = parts[0];
                    String id=parts[1];
                    String iname = parts[2];
                    double iprice=Double.parseDouble(parts[3]);
                    
                    if (getVendorid().equals(fileVendorID))
                    {
                        Item item = new Item(fileVendorID,id,iname,iprice);
                        itemList.add(item);
                    }
                }
            }
        }
        return itemList;
    }
    
    public void saveItemsToFile(List<Item> items) throws IOException 
    {
    // Write the updated items back to the file
        File itemFile = new File("menu.txt");
        try (FileWriter output = new FileWriter(itemFile); BufferedWriter writer = new BufferedWriter(output))
        {
            for (Item item : items) 
            {
                String line = item.getVendorid() + "," + item.getItemID() + "," + item.getItemName() + "," + item.getItemPrice();
                writer.write(line);
                writer.newLine();
            }
        }
    }

}

        
    


