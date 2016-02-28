/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Employee {
    //Variables: 
    private String ssNumber;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int age;
    private String address;
    private String phone;
    private String email;
    private String jobTitle;
    private static int count;
    private static int calcAge;
    
    private void CalculateAnyPersonAge(String dateOfBirth) {
        try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate objDOB = LocalDate.parse(dateOfBirth, formatter);
        LocalDate today = LocalDate.now();
        age = today.getYear() - objDOB.getYear();
        } catch (Exception ei){
           System.out.println("Exception is thrown: "+ei);
           }
    }
    
    public String getSsNumber() {
        return ssNumber;
    }

    public void setSsNumber(String s) {
        ssNumber = s;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String f) {
        firstName = f;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String l) {
        lastName = l;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String d) {
        dateOfBirth = d;
        if (getDateOfBirth() != null){
            CalculateAnyPersonAge(getDateOfBirth());
    }
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String a) {
        address = a;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String p) {
        phone = p;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String e) {
        email = e;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String j) {
        jobTitle = j;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int c) {
        count = c;
    }

    public Employee(String s, String f, String l, String d, String a, String p, String e, String j) {
        setSsNumber(s);
        setFirstName(f);
        setLastName(l);
        setDateOfBirth(d);
        setAddress(a);
        setPhone(p);
        setEmail(e);
        setJobTitle(j);
        count = count+1;
    }

    public Employee() {
    ssNumber = "";
    firstName = "";
    lastName = "";
    dateOfBirth = "01/01/1900";
    age = 0;
    address = "";
    phone = "";
    email = "";
    jobTitle = "";
    count = count+1;
    }
    
    public void print() {
        
        PrintWriter objOutStream = null;
        try {
            objOutStream = new PrintWriter(new BufferedWriter(new   
                               FileWriter("Network_Printer.txt", true)));
            objOutStream.println("Employee information:");
            objOutStream.println("First Name = "+ firstName);
            objOutStream.println("Last Name = "+ lastName);
            objOutStream.println("Social Security = "+ ssNumber);
            objOutStream.println("Date of Birth = "+dateOfBirth);
            objOutStream.println("Address = "+ address);
            objOutStream.println("Age = "+ age);
            objOutStream.println("Phone = "+ phone);
            objOutStream.println("Email = "+ email);
            objOutStream.println("Title = "+ jobTitle+"\n");
            
            
        } catch (IOException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        objOutStream.close();
        
    }
    
     public void load(String key) {
        this.Database_Load(key);
    }

    public void insert() {
        this.Database_Insert();
    }

    public void update() {
        this.Database_Update();
    }

    public void delete() {
        this.Database_Delete();
    }

    protected void Database_Load(String key) {
    }

    protected void Database_Insert() {
    }

    protected void Database_Update() {
    }

    protected void Database_Delete() {
    }
}
   

