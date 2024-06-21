
package fos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Admin extends User
{
    private String adminUserID;
    private String adminUsername;
    private String email;
    private String phoneNumber;
    
    public Admin()
    {
        
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
    
    public Admin(String adminUserID)
    {
        this.adminUserID = adminUserID;
    }

  
    
    public Admin(String adminUserID, String adminUsername, String email, String phoneNumber)
    {
        this.adminUserID = adminUserID;
        this.adminUsername = adminUsername;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

  
    
    public String getAdminUserID() {
        return adminUserID;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void displayAdminProfile(String adminUserID)throws IOException
    {
        File af = new File("AdminProfile.txt");
        try (FileReader adminFile = new FileReader(af); 
             BufferedReader readAdminFile = new BufferedReader(adminFile)) {
            String line;
            while ((line = readAdminFile.readLine()) != null)
            {
                String[] parts = line.split(",");
                if (parts.length >= 4) 
                {
                    String fadminUserID = parts[0];
                    String fadminUsername = parts[1];
                    String fadminEmail = parts[2];
                    String fadminPhoneNumber = parts[3];
                
                    if (adminUserID.equals(fadminUserID)){
                        this.adminUserID = fadminUserID;
                        this.adminUsername = fadminUsername;
                        this.email = fadminEmail;
                        this.phoneNumber = fadminPhoneNumber;
                    }
                }
            }
        }
    }     
}
