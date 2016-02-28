

package classes;

import classes.UserAccount;
import java.util.Arrays;
import java.io.*;

public class UserAccountList {
    //Private Data:
    private final int SIZE = 10;
    private UserAccount[] arrUserAccountList;
    
    public UserAccountList() {
       arrUserAccountList = new UserAccount[SIZE];
    }
    
    //Methods:
        public UserAccount search(String username) {
            for(int i = 0; i < arrUserAccountList.length; i++) {
                
                try{
                if(this.arrUserAccountList[i] != null && 
                    username.equals(arrUserAccountList[i].getUsername())) {
                        return arrUserAccountList[i];
                }
                }
                catch(NullPointerException e) {}
                catch (Exception objE) {}
                finally {}
               
            }
            
            return null;
        }
        
        public boolean add(UserAccount pointer) {
            for(int i = 0; i < arrUserAccountList.length; i++) {
                try{
                if(arrUserAccountList[i] == null) {
                    arrUserAccountList[i] = pointer;
                        return true;
            }
        }
                catch(NullPointerException e) {}
                catch (Exception objE){}
                finally {}
            }
                
            return false;
        }
        
        public boolean add(String username, String password, String email) {
            for(int i = 0; i < arrUserAccountList.length; i++) {
                try{
                if(arrUserAccountList[i] == null) {
                    arrUserAccountList[i] = UserAccount.getInstance(username, password, email);
                        return true;
            }
        }
                catch(NullPointerException e) {}
                catch (Exception objE){}
                finally {}
            }

            return false;
        }
        
        public boolean edit(String username, UserAccount pointer) {
            for(int i = 0; i < arrUserAccountList.length; i++) {
                try{
                if(arrUserAccountList[i] != null && 
                    arrUserAccountList[i].getUsername().equals(username)) {
                    arrUserAccountList[i] = pointer;
                        return true;
            }
        }           
                catch(NullPointerException e) {}
                catch (Exception objE){}
                finally {}
            }
            
            return false;
        }
        
        public boolean edit(String username, String password, String email) {
            for(int i = 0; i < arrUserAccountList.length; i++) {
                try{
                if(arrUserAccountList[i] != null && 
                    arrUserAccountList[i].getUsername().equals(username)) {
                    arrUserAccountList[i].setPassword(password);
                    arrUserAccountList[i].setEmail(email);
                        return true;
            }
        }
                catch(NullPointerException e) {}
                catch (Exception objE){}
                finally {}
                
            }

            return false;
        }
        
        public boolean remove(String username) {
            for(int i = 0; i < arrUserAccountList.length; i++) {
                try{
                if(arrUserAccountList[i] != null && 
                    arrUserAccountList[i].getUsername().equals(username)) {
                    arrUserAccountList[i] = null;
                        return true;
            }
        }
                catch(NullPointerException e) {}
                catch (Exception objE){}
                finally {}
                
            }

            return false;
        }
        
        public boolean changeUserName(String username, String newUserName){
            for(int i = 0; i < arrUserAccountList.length; i++) {
                try{
                if(arrUserAccountList[i] != null && 
                    arrUserAccountList[i].getUsername().equals(username)) {
                    arrUserAccountList[i].setUsername(newUserName);
                        return true;
            }
        }
                catch(NullPointerException e) {}
                catch (Exception objE){}
                finally {}
                
            }
            
            return false;
        }
        
        public boolean changePassword(String username, String newPassword){
            for(int i = 0; i < arrUserAccountList.length; i++) {
                try{
                if(arrUserAccountList[i] != null && 
                    arrUserAccountList[i].getUsername().equals(username)) {
                    arrUserAccountList[i].setPassword(newPassword);
                        return true;
            }
        }
                catch(NullPointerException e) {}
                catch (Exception objE){}
                finally {}
                
            }
            return false;
        }
    
        public boolean changeEmail(String username, String newEmail){
            for(int i = 0; i < arrUserAccountList.length; i++) {
                try{
                if(arrUserAccountList[i] != null && 
                    arrUserAccountList[i].getUsername().equals(username)) {
                    arrUserAccountList[i].setEmail(newEmail);
                        return true;
            }
        }
                catch(NullPointerException e) {}
                catch (Exception objE){}
                finally {}
                
            }
            return false;
        }
        
        public void clear() {
            try{
            Arrays.fill(arrUserAccountList, (Object)null);
            }
                catch(NullPointerException e) {}
                catch (Exception objE){}
                finally {}
            
        }
        
        public boolean authenticate (String U, String P){
            load();
            
            for (int i =0; i < arrUserAccountList.length; i++) {
                try{
                if (arrUserAccountList[i] != null &&
                    arrUserAccountList[i].authenticate(U, P) == true){
                    clear();
                    return true;
            }       
        }
                catch(NullPointerException e) {}
                catch (Exception objE){}
                finally {}
                
            }
            return false;
        }
        
        public void load() {
            Database_Load();
        }

        public void save() {
            Database_Save();
        }

    protected void Database_Load() {
        
        String fileName = "UserAccountData.txt";
        String line = null;

        try {
            FileReader fileReader = 
                new FileReader(fileName);
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String[] splited = line.split(",");
                
                this.add(UserAccount.getInstance(splited[1].trim(), 
                        splited[2].trim(), splited[3].trim()));
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
        new FileWriter("UserAccountData.txt")), true);
        
        for (int i=0;i<arrUserAccountList.length;i++){
            if (arrUserAccountList[i] != null){
            objOutStream.println(arrUserAccountList[i].getUserAccountID()+","
                                +arrUserAccountList[i].getUsername()+","
                                +arrUserAccountList[i].getPassword()+","
                                +arrUserAccountList[i].getEmail());
            }
        }
        
        objOutStream.close();

    }
    catch (Exception objE) {

 }
        
    }
    }
    
