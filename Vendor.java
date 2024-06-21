/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fos;
import java.io.*;

/**
 *
 * @author ANNABEL
 */
public class Vendor extends User
{

    /**
     * @param vendorname the vendorname to set
     */
    public void setVendorname(String vendorname) {
        this.vendorname = vendorname;
    }

    /**
     * @param vendorid the vendorid to set
     */
    public void setVendorid(String vendorid) {
        this.vendorid = vendorid;
    }

    /**
     * @param workinghours the workinghours to set
     */
    public void setWorkinghours(String workinghours) {
        this.workinghours = workinghours;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param phonenum the phonenum to set
     */
    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    private String vendorname;
    private String vendorid;
    private String workinghours;
    private String email;
    private String phonenum;
    private String password;
    
    
    public Vendor()
    {
        
    }
    public Vendor(String vendorid)
    {
        this.vendorid=super.getUserID();
    }
    public Vendor(String vendorname, String vendorid, String workinghours, String email, String phonenum, String password)
    {
        this.vendorname=vendorname;
        this.vendorid=vendorid;
        this.workinghours=workinghours;
        this.email=email;
        this.phonenum=phonenum;
        this.password=password;
    }
   
    
    public void showprofile(String vendorid)throws IOException
    {
        File vendorProfile=new File("VendorProfile.txt");
        try (FileReader profile = new FileReader(vendorProfile); BufferedReader readProfile = new BufferedReader(profile)) {
            String line;
            while ((line = readProfile.readLine()) != null)
            {
                String[] parts = line.split(",");
                if (parts.length >= 6) 
                {
                    String fileVendorid = parts[0];
                    String Name=parts[1];
                    String Hours = parts[2];
                    String Email=parts[3];
                    String Phone=parts[4];
                    String pw=parts[5];
                    
                    if (vendorid.equals(fileVendorid)){
                        this.setVendorid(fileVendorid);
                        this.setVendorname(Name);
                        this.setWorkinghours(Hours);
                        this.setEmail(Email);
                        this.setPhonenum(Phone);
                        this.setPassword(pw);
                    }
                }
            }
        }
    }
    public String getVendorname() {
        return vendorname;
    }
    public String getVendorid() {
        return vendorid;
    }
    public String getWorkinghours() {
        return workinghours;
    }
    public String getEmail() {
        return email;
    }
    public String getPhonenum() {
        return phonenum;
    }
    public String getPassword() {
        return password;
    }
           
            
    
}
