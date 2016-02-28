
package classes;

import java.io.*;
import java.util.Arrays;

/**
 *
 * @author Dima
 */
public class EmployeeList {
    //Private data:
    private int SIZE = 10;
    private Employee[] arrEmpList;

    public EmployeeList() {
        arrEmpList = new Employee[SIZE];
    }
    
    public Employee search(String s) {
        for(int i = 0; i < arrEmpList.length; i++) {
            
            try {
            if(arrEmpList[i] != null && 
                    s.equals(arrEmpList[i].getSsNumber())) {
                return arrEmpList[i];
                }
            }catch(NullPointerException e){}
             catch (Exception objE) { }
            finally {}
        
        } 

        return null;
    }

    public boolean add(Employee pointer) {
        for(int i = 0; i < arrEmpList.length; i++) {
            try {
            if(arrEmpList[i] == null) {
                arrEmpList[i] = pointer;
                return true;
                } 
            }catch(NullPointerException e){}
             catch (Exception objE) { }
            finally {}
            }
        
        return false;
    }
    
    public boolean add(String s, String f, String l, String d,
                   String a, String p, String e, String j) {
        for(int i = 0; i < arrEmpList.length; i++) {
            try {
            if(arrEmpList[i] == null) {
               arrEmpList[i] = new 
                Employee(s, f, l, d, a, p, e, j);
                return true;
            }
            }catch(NullPointerException ex){}
             catch (Exception objE) { }
            finally {}
        }

        return false;
    }

    public boolean edit(String s, Employee pointer) {
        for(int i = 0; i < arrEmpList.length; i++) {
            
            try {
            if(arrEmpList[i] != null && 
                arrEmpList[i].getSsNumber().equals(s)) {
                arrEmpList[i] = pointer;
                return true;
            }
            }catch(NullPointerException e){}
             catch (Exception objE) { }
            finally {}
        }

        return false;
    }

   
    public boolean edit(String s, String f, String l, String d,
                   String a, String p, String e, String j) {
        for(int i = 0; i < arrEmpList.length; i++) {
            
            try {
            if(arrEmpList[i] != null && 
                arrEmpList[i].getSsNumber().equals(s)) {
                arrEmpList[i].setPhone(p);
                arrEmpList[i].setLastName(l);
                arrEmpList[i].setFirstName(f);
                arrEmpList[i].setDateOfBirth(d);
                arrEmpList[i].setAddress(a);
                arrEmpList[i].setEmail(e);
                arrEmpList[i].setJobTitle(j);
                return true;
            }
            }catch(NullPointerException ex){}
             catch (Exception objE) { }
            finally {}
        }

        return false;
    }

    public boolean remove(String s) {
        for(int i = 0; i < arrEmpList.length; i++) {
            
            try {
            if(arrEmpList[i] != null && 
                    arrEmpList[i].getSsNumber().equals(s)) {
                arrEmpList[i] = null;
                return true;
            }
            }catch(NullPointerException e){}
             catch (Exception objE) { }
            finally {}
        }

        return false;
    }
    
    public boolean print(String s){
        for(int i = 0; i < arrEmpList.length; i++) {
            
            try {
            if(arrEmpList[i] != null && 
                arrEmpList[i].getSsNumber().equals(s)) {
                arrEmpList[i].print();
                return true;
            }
            }catch(NullPointerException e){}
             catch (Exception objE) { }
            finally {}
        }

        return false;
    }
    
    public void printAll(){
        for(int i = 0; i < arrEmpList.length; i++) {
            try {
            if(arrEmpList[i] != null) {
                arrEmpList[i].print();
            }
            }catch(NullPointerException e){}
             catch (Exception objE) { }
            finally {}
        }

    }

    public void clear() {
        try{
        Arrays.fill(arrEmpList, (Object)null);
        }catch(NullPointerException e){}
             catch (Exception objE) { }
            finally {}
    }

    
    public void load() {
        this.Database_Load();
    }

    public void save() {
        this.Database_Save();
    }

    protected void Database_Load() {
        
        
        String fileName = "EmployeeData.txt";
        String line = null;
        BufferedWriter wr = null;
    
        try {
            FileReader fileReader = 
                new FileReader(fileName);
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
                    
            
            while((line = bufferedReader.readLine()) != null) {
                String[] splited = line.split(",");
                
                add(new Employee(splited[0].trim(),splited[1].trim(),
                        splited[2].trim(),splited[3].trim(),splited[4].trim(),
                        splited[5].trim(),splited[6].trim(),splited[7].trim()));
            }    
            bufferedReader.close();            
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");    
        }
        
    }

    
    protected void Database_Save() {
        try { 

        PrintWriter objOutStream = new PrintWriter(
        new BufferedWriter(
        new FileWriter("EmployeeData.txt")), true);
        
        for (int i=0;i<arrEmpList.length;i++){
            if (arrEmpList[i] != null){
            objOutStream.println(arrEmpList[i].getSsNumber()+","
                                +arrEmpList[i].getFirstName()+","
                                +arrEmpList[i].getLastName()+ ","
                                +arrEmpList[i].getDateOfBirth()+ ","
                                +arrEmpList[i].getAddress()+ ","
                                +arrEmpList[i].getPhone()+ ","
                                +arrEmpList[i].getEmail()+ ","
                                +arrEmpList[i].getJobTitle());
            }
        }
        
        objOutStream.close();

    }
    catch (Exception objE) {

 }
        
    }
    
}

