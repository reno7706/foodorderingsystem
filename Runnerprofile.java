
package fos;

import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Runnerprofile 
{
    private String runnerid;
    private String runnername;
    private String gender;
    private String age;
    private String email;
    private String phonenum;
    
    public Runnerprofile(String runnerid, String runnername, String gender, String age, String email, String phonenum)
    {
        this.runnerid = runnerid;
        this.runnername = runnername;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phonenum = phonenum;
    }
    
    public Runnerprofile(){}
   
    
    public void showprofile(String runnerid)throws IOException
    {
        File runnerProfile=new File("RunnerProfile.txt");
        FileReader profile=new FileReader(runnerProfile);
        BufferedReader readProfile=new BufferedReader(profile);
        
        String line;
        while ((line = readProfile.readLine()) != null) 
        {
            String[] parts = line.split(",");
            
            if (parts.length >= 6)
            {
                String Runnerid = parts[0];
                String Name=parts[1];
                String Gender = parts[2];
                String Age=parts[3];
                String Email=parts[4];
                String Phone=parts[5];

                if (runnerid.equals(Runnerid)) 
                {
                    this.setRunnerid(Runnerid);
                    this.setRunnername(Name);
                    this.setGender(Gender);
                    this.setAge(Age);
                    this.setEmail(Email);
                    this.setPhonenum(Phone);
                }
            }
        } 
        readProfile.close();
        profile.close();
}

    /**
     * @return the runnerid
     */
    public String getRunnerid() {
        return runnerid;
    }

    /**
     * @param runnerid the runnerid to set
     */
    public void setRunnerid(String runnerid) {
        this.runnerid = runnerid;
    }

    /**
     * @return the runnername
     */
    public String getRunnername() {
        return runnername;
    }

    /**
     * @param runnername the runnername to set
     */
    public void setRunnername(String runnername) {
        this.runnername = runnername;
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
     * @return the phonenum
     */
    public String getPhonenum() {
        return phonenum;
    }

    /**
     * @param phonenum the phonenum to set
     */
    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    
}

    

