/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author HPvictus2022
 */
public class User 
{

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    public User()
    {
        
    }
    
    private String username,role,userID,password;;
    
    public User(String username, String userID,String role) 
    {
        this.username = username;
        this.userID = userID;
        this.role=role;
    }
    
    public User(String username, String password, String userID, String role)
    {
        this.username = username;
        this.password = password;
        this.userID = userID;
        this.role = role;
    }
    
    
    public void role()
    {
        switch(getRole())
            {
                case "customer":
                    CustomerHome c1=new CustomerHome(userID);
                    break;
                case "vendor":
                    HomePage c2=new HomePage(userID);
                    c2.setVisible(true);
                    break;
                case "runner":
                    RunnerHome c3=new RunnerHome(userID);
                    c3.setVisible(true);
                    break;
                case "admin":
                    AdminHomePage c4=new AdminHomePage(userID);
                    c4.setVisible(true);
                    break;
            }
    }
    
    
    public boolean login(String uN,String PW)
    {
        try (BufferedReader read = new BufferedReader(new FileReader("User.txt"))) {
            String line;
            while ((line = read.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String Username = parts[0].trim();
                    String Password = parts[1].trim();
                    setRole(parts[2].trim());
                    setUserID( parts[3].trim());
                    if (uN.equals(Username) && PW.equals(Password)) 
                    {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + getPassword() + '\'' +
                ", role='" + role + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }
    
}
