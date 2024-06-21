/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author HPvictus2022
 */
public class Customer extends User {

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    
    @Override
    public String toString() 
    {
        return "Customer{id=" + id +
                ", balance=" + getBalance() +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
    
    
    
    public Customer()
    {
        
    }
    public Customer(String vendorid)
    {
        this.id=super.getUserID();
    }
    
    public Customer(String cname,String phonenum)
    {
        this.phoneNumber=phonenum;
        
    }
    
    public Customer(String id, double balance)
    {
        this.id = id;
        this.balance = balance;
    }
    
    public Customer(String id, String phoneNumber, String gender, String age, String email)
    {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }
   
    private String id;
    private String phoneNumber;
    private String gender;
    private String age;
    private String email;
    private double balance;
    
    public void showprofile(String customerid)throws IOException
    {
        File customerProfile=new File("cProfile.txt");
        try (FileReader profile = new FileReader(customerProfile); BufferedReader readProfile = 
                new BufferedReader(profile)) {
            String line;
            while ((line = readProfile.readLine()) != null)
            {
                String[] parts = line.split(",");
                if (parts.length >= 5) 
                {
                    String id=parts[0];
                    String phonenum=parts[1];
                    String gender=parts[2];
                    String age=parts[3];
                    String email=parts[4];
                    
                    if (id.equals(customerid)){
                        this.phoneNumber=phonenum;
                        this.setGender(gender);
                        this.setAge(age);
                        this.setEmail(email);
                    }
                }
            }
        }
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
