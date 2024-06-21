
package fos;



import java.util.List;
import java.io.*;
import java.util.ArrayList;


public class Registration 
{

    private String username;
    private String userID;
    private String role;
    private String password;
    private String email;
    private String phoneNumber;
    private String workinghours;
    private String gender;
    private String age;
    private double balance;
    private String adminUsername;
    private String adminUserID;
    private String id;
    private String vendorid;
    private String vendorname;
    private String phonenum;
    private String runnerid;
    private String runnername;
    
    public Registration()
    {
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminUserID() {
        return adminUserID;
    }

    public void setAdminUserID(String adminUserID) {
        this.adminUserID = adminUserID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVendorid() {
        return vendorid;
    }

    public void setVendorid(String vendorid) {
        this.vendorid = vendorid;
    }

    public String getVendorname() {
        return vendorname;
    }

    public void setVendorname(String vendorname) {
        this.vendorname = vendorname;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getRunnerid() {
        return runnerid;
    }

    public void setRunnerid(String runnerid) {
        this.runnerid = runnerid;
    }

    public String getRunnername() {
        return runnername;
    }

    public void setRunnername(String runnername) {
        this.runnername = runnername;
    }
    
 
    
    
 
   

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWorkinghours() {
        return workinghours;
    }

    public void setWorkinghours(String workingHours) {
        this.workinghours = workingHours;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
   
    
    //load user data
    public List<User> readUser() throws IOException
    {
        List<User> userList = new ArrayList<>();
        
        File userFile = new File("User.txt");
        try (FileReader loadUser = new FileReader(userFile))
        {
            BufferedReader bru = new BufferedReader(loadUser);
            String line;
            while ((line = bru.readLine()) !=null)
            {
                String [] parts = line.split(",");
                if (parts.length>=4)
                {
                    String username = parts[0];
                    String password = parts[1];
                    String role = parts[2];
                    String userID = parts[3];
                    
                    User us = new User(username, password, userID, role);
                    userList.add(us);
                }
            }
        }
        return userList;
    }
    
    //delete from user.txt
    private void deleteUser(String selectedUserID)throws IOException
    {
        String userFile = "User.txt";
        
        List<String> lines = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(userFile)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[3].trim().equals(selectedUserID))
                {
                    continue;
                }
                lines.add(line);
            }
        }
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(userFile)))
        {
            for (String line : lines)
            {
                bw.write(line);
                bw.newLine();
            }
        }
    }
    

    //load admin data
    public List<Admin> readAdmin() throws IOException
    {
        List<Admin> adminList = new ArrayList<>();
        
        File adminFile = new File("AdminProfile.txt");
        try (FileReader loadAdmin = new FileReader(adminFile)) {
            BufferedReader bra = new BufferedReader(loadAdmin);
            String line;
            while ((line = bra.readLine()) != null) 
            {
                String[] parts = line.split(",");
                if (parts.length >= 4) 
                {
                    String adminUserID = parts[0];
                    String adminUsername = parts[1];
                    String email = parts[2];
                    String phoneNumber = parts[3];

                    Admin am = new Admin(adminUserID, adminUsername, email, phoneNumber);
                    adminList.add(am);
                }
            }
        }
        return adminList; // Return the list if needed
    }
    
    //save to adminProfile
    public void saveAdmin(List<Admin> adminList) throws IOException 
    {
        File adminFile = new File("AdminProfile.txt");
        
        try (FileWriter sa = new FileWriter(adminFile, false); 
             BufferedWriter bwa = new BufferedWriter(sa))
        {
            for (Admin am:adminList) 
            {
                String line = String.join(",", am.getAdminUserID(), am.getAdminUsername(), am.getEmail(), am.getPhoneNumber());
                        
                bwa.write(line);
                bwa.newLine();
            }
        }
    }
    
    //create admin (add)
    public Admin registerAdmin(String adminUserID, String adminUsername, String password, String email, String phoneNumber) throws IOException 
    {
        this.adminUserID = adminUserID;
        this.adminUsername = adminUsername;
        this.role = "admin";
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        
        List<Admin> adminList = readAdmin();
        
        Admin newAdmin = new Admin(adminUserID, adminUsername, email, phoneNumber);
        
        newAdmin.setPassword(password);
        
        adminList.add(newAdmin);
        
        String userData = adminUsername + "," + password + "," + role + "," + adminUserID;
        String adminData = adminUserID + "," + adminUsername + "," + email + "," + phoneNumber;

        // Define the file path
        String userFile = "User.txt";

        try (BufferedWriter bwru = new BufferedWriter(new FileWriter(userFile, true))) {
            // Append the user information to the file
            bwru.write(userData);
            bwru.newLine(); // Add a newline for better readability or separation of entries
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String adminFile = "AdminProfile.txt";

        try (BufferedWriter bwra = new BufferedWriter(new FileWriter(adminFile, true))) {
            // Append the user information to the file
            bwra.write(adminData);
            bwra.newLine(); // Add a newline for better readability or separation of entries
        } catch (IOException e) {
            e.printStackTrace();
        } 
        saveAdmin(adminList);
        return newAdmin;
    }

    //edit admin data
    public void editAdmin(String selectedUserID, String newEmail, String newPhoneNumber) throws IOException 
    {
        List<Admin> adminList = readAdmin();

        // Find the admin with the selectedUserID
        for (Admin admin : adminList) 
        {
            if (admin.getAdminUserID().equals(selectedUserID)) 
            {
                admin.setEmail(newEmail);
                admin.setPhoneNumber(newPhoneNumber);

                // Save the updated adminList to the file
                saveAdmin(adminList);
                return; // Break the loop once the edit is done
            }    
        }
    }
    
    //delete admin
    public void deleteAdmin(String selectedUserID) throws IOException 
    {
        List<Admin> adminList = readAdmin();
 
        // Find the index of the admin with the selectedUserID
        int indexToRemove = -1;
        for (int i = 0; i < adminList.size(); i++) 
        {
            if (adminList.get(i).getAdminUserID().equals(selectedUserID)) 
            {
                indexToRemove = i;
                break;
            }
             // Break the loop once the admin is found
        }

        if (indexToRemove != -1) 
        {
            adminList.remove(indexToRemove); 
        }
        saveAdmin(adminList);
        
        deleteUser(selectedUserID);
    } 
    
    
    
    
    
    
    //load vendor data
    public List<Vendor> readVendor() throws IOException
    {
        List<Vendor> vendorList = new ArrayList<>();
        
        File vendorFile = new File("VendorProfile.txt");
        try (FileReader loadVendor = new FileReader(vendorFile)) {
            BufferedReader brv = new BufferedReader(loadVendor);
            String line;
            while ((line = brv.readLine()) != null) 
            {
                String[] parts = line.split(",");
                if (parts.length >= 6) 
                {
                    String vendorid = parts[0];
                    String vendorname = parts[1];
                    String workinghours = parts[2];
                    String email = parts[3];
                    String phonenum = parts[4];
                    String password = parts[5];

                    Vendor vd = new Vendor(vendorname, vendorid, workinghours, email, phonenum, password);
                    vendorList.add(vd);
                }
            }
        }
        return vendorList; // Return the list if needed
    }
    
    //save to vendorProfile
    public void saveVendor(List<Vendor> vendorList) throws IOException 
    {
        File vendorFile = new File("VendorProfile.txt");
        
        try (FileWriter sv = new FileWriter(vendorFile, false); 
             BufferedWriter bwv = new BufferedWriter(sv))
        {
            for (Vendor vd:vendorList) 
            {
                String line = String.join(",", vd.getVendorid(), vd.getVendorname(), vd.getWorkinghours(), vd.getEmail(), vd.getPhonenum(), vd.getPassword());
                        
                bwv.write(line);
                bwv.newLine();
            }
        }
    }

    //create vendor(add)
    public Vendor registerVendor(String vendorid, String vendorname, String workinghours, String email, String phonenum, String password) throws IOException 
    {
        this.vendorid = vendorid;
        this.vendorname = vendorname;
        this.role = "vendor";
        this.workinghours = workinghours;
        this.email = email;
        this.phonenum = phonenum;
        this.password = password;
        
        List<Vendor> vendorList = readVendor();
        
        Vendor newVendor = new Vendor(vendorid, vendorname, workinghours, email, phonenum, password);
        
        vendorList.add(newVendor);
        
        String userData = vendorname + "," + password + "," + role + "," + vendorid;
        String vendorData = vendorid + "," + vendorname + "," + workinghours + "," + email + "," + phonenum + "," + password;

        // Define the file path
        String userFile = "User.txt";

        try (BufferedWriter bwrs = new BufferedWriter(new FileWriter(userFile, true))) {
            // Append the user information to the file
            bwrs.write(userData);
            bwrs.newLine(); // Add a newline for better readability or separation of entries
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String vendorFile = "VendorProfile.txt";

        try (BufferedWriter bwrv = new BufferedWriter(new FileWriter(vendorFile, true))) {
            // Append the user information to the file
            bwrv.write(vendorData);
            bwrv.newLine(); // Add a newline for better readability or separation of entries
        } catch (IOException e) {
            e.printStackTrace();
        } 
        saveVendor(vendorList);
        return newVendor;
    }
    
    //edit vendor data
    public void editVendor(String selectedUserID, String newWorkingHours, String newEmail, String newPhoneNumber) throws IOException 
    {
        List<Vendor> vendorList = readVendor();

        // Find the admin with the selectedUserID
        for (Vendor vendor : vendorList) 
        {
            if (vendor.getVendorid().equals(selectedUserID)) 
            {
                vendor.setWorkinghours(newWorkingHours);
                vendor.setEmail(newEmail);
                vendor.setPhonenum(newPhoneNumber);

                // Save the updated adminList to the file
                saveVendor(vendorList);
                return; // Break the loop once the edit is done
            }    
        }
    }
    
    //delete vendor
    public void deleteVendor(String selectedUserID) throws IOException 
    {
        List<Vendor> vendorList = readVendor();
    

        // Find the index of the admin with the selectedUserID
        int indexToRemove = -1;
        for (int i = 0; i < vendorList.size(); i++) 
        {
            if (vendorList.get(i).getVendorid().equals(selectedUserID)) 
            {
                indexToRemove = i;
                break;
            }
             // Break the loop once the admin is found
        }
    

        if (indexToRemove != -1) 
        {
            vendorList.remove(indexToRemove);
        }
        saveVendor(vendorList);
        
        deleteUser(selectedUserID);
    } 
    
    
    
    
    
    
    //load runner data
    public List<Runnerprofile> readRunner() throws IOException
    {
        String ageStr;
        List<Runnerprofile> runnerList = new ArrayList<>();
        
        File runnerFile = new File("RunnerProfile.txt");
        try (FileReader loadRunner = new FileReader(runnerFile)) {
            BufferedReader brr = new BufferedReader(loadRunner);
            String line;
            while ((line = brr.readLine()) != null) 
            {
                String[] parts = line.split(",");
                if (parts.length >= 6) 
                {
                    String runnerid = parts[0];
                    String runnername = parts[1];
                    String gender = parts[2];
                    String age = parts[3];
                    String email = parts[4];
                    String phonenum = parts[5];

                    Runnerprofile rn = new Runnerprofile(runnerid, runnername, gender, age, email, phonenum);
                    runnerList.add(rn);
                }
            }
        }
        return runnerList; // Return the list if needed
    }
    
    //save to runnerProfile
    public void saveRunner(List<Runnerprofile> runnerList) throws IOException 
    {
        File runnerFile = new File("RunnerProfile.txt");
        
        try (FileWriter sr = new FileWriter(runnerFile, false); 
             BufferedWriter bwr = new BufferedWriter(sr))
        {
            for (Runnerprofile rn:runnerList) 
            {
                String line = String.join(",", rn.getRunnerid(), rn.getRunnername(), rn.getGender(), rn.getAge(), rn.getEmail(), rn.getPhonenum());
                        
                bwr.write(line);
                bwr.newLine();
            }
        }
    }
    
    //create runner (add)
    public Runnerprofile registerRunner(String runnerid, String runnername, String password, String gender, String age, String email, String phonenum) throws IOException 
    {
        this.runnerid = runnerid;
        this.runnername = runnername;
        this.role = "runner";
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phonenum = phonenum;
        
        
        List<Runnerprofile> runnerList = readRunner();
        
        Runnerprofile newRunner = new Runnerprofile(runnerid, runnername, gender, age, email, phonenum);
        
        runnerList.add(newRunner);
        
        String userData = runnername + "," + password + "," + role + "," + runnerid;
        String runnerData = runnerid + "," + runnername + "," + gender + "," + age + "," + email + "," + phonenum;

        // Define the file path
        String userFile = "User.txt";

        try (BufferedWriter bwre = new BufferedWriter(new FileWriter(userFile, true))) {
            // Append the user information to the file
            bwre.write(userData);
            bwre.newLine(); // Add a newline for better readability or separation of entries
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String runnerFile = "RunnerProfile.txt";

        try (BufferedWriter bwrr = new BufferedWriter(new FileWriter(runnerFile, true))) {
            // Append the user information to the file
            bwrr.write(runnerData);
            bwrr.newLine(); // Add a newline for better readability or separation of entries
        } catch (IOException e) {
            e.printStackTrace();
        } 
        saveRunner(runnerList);
        return newRunner;
    }
    
    //edit runner data
    public void editRunner(String selectedUserID, String newGender, String newAge, String newEmail, String newPhoneNumber) throws IOException 
    {
        List<Runnerprofile> runnerList = readRunner();

        // Find the admin with the selectedUserID
        for (Runnerprofile runner : runnerList) 
        {
            if (runner.getRunnerid().equals(selectedUserID)) 
            {
                runner.setGender(newGender);
                runner.setAge(newAge);
                runner.setEmail(newEmail);
                runner.setPhonenum(newPhoneNumber);

                // Save the updated adminList to the file
                saveRunner(runnerList);
                return; // Break the loop once the edit is done
            }    
        }
    }
    
    //delete runner
    public void deleteRunner(String selectedUserID) throws IOException 
    {
        List<Runnerprofile> runnerList = readRunner();
    

        // Find the index of the admin with the selectedUserID
        int indexToRemove = -1;
        for (int i = 0; i < runnerList.size(); i++) 
        {
            if (runnerList.get(i).getRunnerid().equals(selectedUserID)) 
            {
                indexToRemove = i;
                break;
            }
             // Break the loop once the admin is found
        }
    

        if (indexToRemove != -1) 
        {
            runnerList.remove(indexToRemove);
        }
        saveRunner(runnerList);
        
        deleteUser(selectedUserID);
    } 

    
    //load customer data (read customerProfile)
    public List<Customer> readCustomer() throws IOException
    {
        List<Customer> customerList = new ArrayList<>();
        
        File customerFile = new File("customerProfile.txt");
        try (FileReader loadCustomer = new FileReader(customerFile)) {
            BufferedReader brc = new BufferedReader(loadCustomer);
            String line;
            while ((line = brc.readLine()) != null) 
            {
                String[] parts = line.split(",");
                if (parts.length >= 2) 
                {
                    String id = parts[0];
                    double balance = Double.parseDouble(parts[1]);

                    Customer ct = new Customer(id, balance);
                    customerList.add(ct);
                }
            }
        }
        return customerList; // Return the list if needed
    }
    
    //load customer data ( read cProfile)
    public List<Customer> readCustomerProfile() throws IOException
    {
        List<Customer> customerProfileList = new ArrayList<>();
        
        File customerProfileFile = new File("cProfile.txt");
        try (FileReader loadCustomerProfile = new FileReader(customerProfileFile)) {
            BufferedReader brcf = new BufferedReader(loadCustomerProfile);
            String line;
            while ((line = brcf.readLine()) != null) 
            {
                String[] parts = line.split(",");
                if (parts.length >= 5) 
                {
                    String id = parts[0];
                    String phoneNumber = parts[1];
                    String gender = parts[2];
                    String age = parts[3];
                    String email = parts[4];

                    Customer ct = new Customer(id, phoneNumber, gender, age, email);
                    customerProfileList.add(ct);
                }
            }
        }
        return customerProfileList; // Return the list if needed
    }
    
    //delete from cProfile
    private void deleteCustomerProfile(String selectedUserID)throws IOException
    {
        String customerProfileFile = "cProfile.txt";
        
        List<String> cProfileList = new ArrayList<>();
        
        try (BufferedReader brcp = new BufferedReader(new FileReader(customerProfileFile)))
        {
            String line;
            while ((line = brcp.readLine()) != null)
            {
                String[] parts = line.split(",");
                if (parts.length >= 5 && parts[0].trim().equals(selectedUserID))
                {
                    continue;
                }
                cProfileList.add(line);
            }
        }
        
        try(BufferedWriter bwcp = new BufferedWriter(new FileWriter(customerProfileFile)))
        {
            for (String line : cProfileList)
            {
                bwcp.write(line);
                bwcp.newLine();
            }
        }
    }
    
    //save to customerProfile
    public void saveCustomer(List<Customer> customerList) throws IOException 
    {
        File customerFile = new File("customerProfile.txt");
        
        try (FileWriter sc = new FileWriter(customerFile, false); 
             BufferedWriter bwc = new BufferedWriter(sc))
        {
            for (Customer ct:customerList) 
            {
                String line = String.join(",", ct.getId(), Double.toString(ct.getBalance()));
                        
                bwc.write(line);
                bwc.newLine();
            }
        }
    }
    
    //save to cProfile
    public void saveCustomerProfile(List<Customer> customerProfileList) throws IOException 
    {
        File customerProfileFile = new File("cProfile.txt");
        
        try (FileWriter scf = new FileWriter(customerProfileFile, false); 
             BufferedWriter bwcf = new BufferedWriter(scf))
        {
            for (Customer ct:customerProfileList) 
            {
                String line = String.join(",", ct.getId(), ct.getPhoneNumber(), ct.getGender(), ct.getAge(), ct.getEmail());
                        
                bwcf.write(line);
                bwcf.newLine();
            }
        }
    }
    
    //create customer (add)
    public Customer registerCustomer(String id, String username, String password, double balance, String phoneNumber, String gender, String age, String email) throws IOException 
    {
        this.id = id;
        this.username = username;
        this.role = "customer";
        this.password = password;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.email = email;
        
        
        List<Customer> customerProfileList = readCustomerProfile();
        
        Customer newCustomer = new Customer(id, phoneNumber, gender, age, email);
        
        customerProfileList.add(newCustomer);
        
        String userData = username + "," + password + "," + role + "," + id;
        String customerProfileData = id + "," + phoneNumber + "," + gender + "," + age + "," + email;

        // Define the file path
        String userFile = "User.txt";

        try (BufferedWriter bwre = new BufferedWriter(new FileWriter(userFile, true))) {
            // Append the user information to the file
            bwre.write(userData);
            bwre.newLine(); // Add a newline for better readability or separation of entries
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String customerProfileFile = "cProfile.txt";

        try (BufferedWriter bwrc = new BufferedWriter(new FileWriter(customerProfileFile, true))) {
            // Append the user information to the file
            bwrc.write(customerProfileData);
            bwrc.newLine(); // Add a newline for better readability or separation of entries
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        String customerData = newCustomer.getId() + "," + balance;

        String customerFile = "customerProfile.txt";

        try (BufferedWriter bwrcf = new BufferedWriter(new FileWriter(customerFile, true))) {
             //Append the user information to the file
            bwrcf.write(customerData);
            bwrcf.newLine(); // Add a newline for better readability or separation of entries
        } catch (IOException e) {
            e.printStackTrace();
        } 
        saveCustomerProfile(customerProfileList);
        return newCustomer;
    }
    
    
    
    //edit customer data
    public void editCustomer(String selectedUserID, String newPhoneNumber, String newGender, String newAge, String newEmail) throws IOException 
    {
        try
        {
            List<Customer> customerProfileList = readCustomerProfile();

            // Find the admin with the selectedUserID
            for (Customer customerProfile : customerProfileList) 
            {
                if (customerProfile.getId().equals(selectedUserID)) 
                { 
                    customerProfile.setPhoneNumber(newPhoneNumber);
                    customerProfile.setGender(newGender);
                    customerProfile.setAge(newAge);
                    customerProfile.setEmail(newEmail);

                    // Save the updated adminList to the file
                    saveCustomerProfile(customerProfileList);
                    
                    return;
                    // Break the loop once the edit is done
                }    
            }   
        }catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    //delete customer
    public void deleteCustomer(String selectedUserID) throws IOException 
    {
        List<Customer> customerList = readCustomer();
    

        // Find the index of the admin with the selectedUserID
        int indexToRemove = -1;
        for (int i = 0; i < customerList.size(); i++) 
        {
            if (customerList.get(i).getId().equals(selectedUserID)) 
            {
                indexToRemove = i;
                break;
            }
             // Break the loop once the admin is found
        }
    

        if (indexToRemove != -1) 
        {
            customerList.remove(indexToRemove);
        }
        saveCustomer(customerList);
        
        deleteUser(selectedUserID);
        
        deleteCustomerProfile(selectedUserID);
    } 

}




