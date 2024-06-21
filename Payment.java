/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HPvictus2022
 */
public class Payment 
{

    /**
     * @return the uID
     */
    public String getuID() {
        return uID;
    }

    /**
     * @param uID the uID to set
     */
    public void setuID(String uID) {
        this.uID = uID;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the newBalance
     */
    public double getNewBalance() {
        return newBalance;
    }

    /**
     * @param newBalance the newBalance to set
     */
    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    /**
     * @return the delivery
     */
    public double getDelivery() {
        return delivery;
    }

    /**
     * @param delivery the delivery to set
     */
    public void setDelivery(double delivery) {
        this.delivery = delivery;
    }
    
    private String uID;
    private double total;
    private double balance;
    private double newBalance;
    private double delivery;
    
    
    public double calBalance() {
        double balance = 0.0;
        try (BufferedReader balanceReader = new BufferedReader(new FileReader("customerProfile.txt"))) {
            String line;
            while ((line = balanceReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[0].trim().equals(uID)) {
                    balance = Double.parseDouble(parts[1].trim());
                    break;
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return balance;
    }

    
    
    public void updateBalance() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("customerProfile.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 1 && parts[0].trim().equals(uID)) {
                    line = String.format("%s,%.2f", uID, newBalance);
                }
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace(); }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customerProfile.txt"))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();  }
        } catch (IOException e) {
            e.printStackTrace(); }
    }

    
    
    public double makePayment(double delivery) 
    {
        if (balance >= total) 
        {
            newBalance = balance - total- delivery;
            return newBalance;
        } else 
        {
            return -1;
        }
        
    }
    
}
