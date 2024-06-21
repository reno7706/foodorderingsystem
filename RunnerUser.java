
package fos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class RunnerUser 
{
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
    
    public RunnerUser()
    {
        
    }
    
    protected String username,userID,role;
    
    public RunnerUser(String username, String userID,String role) 
    {
        this.username = username;
        this.userID = userID;
        this.role=role;
    }
    
    public void role()
    {
        switch(getRole())
            {
                
                case "runner":
                    HomePage c2=new HomePage(userID);
                    c2.setVisible(true);
                    
                    break;
                default:
                    
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
                    String ID=parts[3].trim();
                    if (uN.equals(Username) && PW.equals(Password)) 
                    {
                        userID = ID;
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
