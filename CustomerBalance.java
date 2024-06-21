
package fos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerBalance
{
    

    public CustomerBalance()
    {
        
    }
    
    
    
    
    
    //load balance
    public List<Customer> readBalance() throws IOException
    {
        List<Customer> balanceList = new ArrayList<>();
        
        File balanceFile = new File("customerProfile.txt");
        try (FileReader loadBalance = new FileReader(balanceFile)) 
        {
            BufferedReader brb = new BufferedReader(loadBalance);
            String line;
            while ((line = brb.readLine()) != null) 
            {
                String[] parts = line.split(",");
                if (parts.length >= 2) 
                {
                    String id = parts[0];
                    double balance = Double.parseDouble(parts[1]);

                    Customer bl = new Customer(id, balance);
                    balanceList.add(bl);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return balanceList; // Return the list if needed
    }
    
    //save balance
    public void saveBalance(List<Customer> balanceList) throws IOException 
    {
        File balanceFile = new File("customerProfile.txt");
        
        try (FileWriter sb = new FileWriter(balanceFile, false); 
             BufferedWriter bwb = new BufferedWriter(sb))
        {
            for (Customer bl : balanceList) 
            {
                String line = String.join(",", bl.getId(), String.valueOf(bl.getBalance()));
                bwb.write(line);
                bwb.newLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
       
    }
    
    //add receipt
    public void generateReceipt(String id, String type, double topupAmount, double newBalance)throws IOException
    {
        String receiptFile = "BalanceNotification.txt";
        String receiptData = id + "," + type + "," + topupAmount + "," + newBalance;
        
        try (FileWriter rw = new FileWriter(receiptFile, true);
            BufferedWriter rbw = new BufferedWriter(rw))
            {
                rbw.write(receiptData);
                rbw.newLine();
                //rbw.flush();
            } catch (IOException e){
                e.printStackTrace();
            }

    }
    
    //read notification(receipt)
    public List<String> readReceipt() throws IOException
    {
        List<String> receiptList = new ArrayList<>();
        
        File receiptFile = new File("BalanceNotification.txt");
        try (FileReader loadReceipt = new FileReader(receiptFile)) 
        {
            BufferedReader rReceipt = new BufferedReader(loadReceipt);
            String line;
            while ((line = rReceipt.readLine()) != null) 
            {
                receiptList.add(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return receiptList; // Return the list if needed
    }
    
    
    
    
}

