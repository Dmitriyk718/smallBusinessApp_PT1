
package consoleApp;

import classes.UserAccount;
import classes.UserAccountList;
import classes.Employee;
import classes.EmployeeList;
import java.util.Scanner;

public class BusinessApplication {
    //Declarations:
    public static UserAccountList objUserAccountList;
    public static UserAccount userAccount;
    public static EmployeeList objEmployeeList;
    public static Employee emp;
    public static String userName;
    public static String password;
    public static String email;
    public static Scanner scan;
    
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        objUserAccountList = new UserAccountList();
        userAccount = UserAccount.getInstance();
        objEmployeeList  = new EmployeeList();
        emp = new Employee();
        
        
        authenticationMenu();
        
    }
    
    //AuthenticationMenu
    public static void authenticationMenu(){
        System.out.println("Welcome to the Business Application\n");
        System.out.println("Please enter username ");
            userName = scan.nextLine();
            
        System.out.println("Please enter password ");
        password = scan.nextLine();
        
        while (!(userName.equals("-1") && password.equals("-1"))){
                
            if (Authenticate(userName, password) ){
                System.out.println("Access Granted!!");
                mainMenuScreen();
                scan.nextLine();
            } else {
                System.out.println("Access Denied!!");
                
            }
            
            System.out.println("\nPlease enter username ");
            userName = scan.nextLine();
            
            System.out.println("Please enter password ");
            password = scan.nextLine();
            
        }
        System.out.println("Program ends....");
    }
    
    //MainMenu
    public static void mainMenuScreen(){
        boolean exit = false;
        while(!exit){ 
        System.out.println("\n~~~~~~~~~~ Main Menu Text Screen ~~~~~~~~~~\n");
        System.out.println("1. Back-end Management Screen");
        System.out.println("2. Retail Point-Of-Sales");
        System.out.println("0. Exit (return to Login Screen)");
        
        System.out.println("\nPlease select a menu option (1, 2 or 0)");
        int selection = scan.nextInt();
              
        switch (selection) {
            case 0:  exit = true;
                     break;
            case 1:  backEndMngtScreen();
                     break;                
            case 2:  retailPoint();
                     break;
            default: System.out.println("Invalid input");
                     break;
        }
        } 
              
        
    }
    
    //RetailMenu
    public static void retailPoint(){
        boolean exit = false;
        while(!exit){ 
        System.out.println("\n~~~~~~~~~~ Welcome to Retail Point-of-Sales Portal ~~~~~~~~~~\n");
        System.out.println("1. Register New Customer");
        System.out.println("0. Exit (return to Main Screen)");
        
        System.out.println("\nPlease select a menu option (1 or 0)");
        int selection = scan.nextInt();
              
        switch (selection) {
            case 0:  exit = true;
                     break;
            case 1:  underConstruction();
                     break; 
            default: System.out.println("Invalid input");
                     break;
        }
        } 
        
    }
    
    //TOBECONSTRUCTED
    public static void underConstruction(){
        System.out.println("\nUnder Construction");
    }
    
    //BackEndMngt
    public static void backEndMngtScreen(){
        boolean exit = false;
        while(!exit){ 
        System.out.println("\n~~~~~~~~~~ Welcome to the Back-end & Maintenance ~~~~~~~~~~");
        System.out.println("\t\t\tManagement Portal\n");
        
        System.out.println("1. User Account Management");
        System.out.println("2. Employee Account Management");
        System.out.println("0. Exit (return to Login Screen)");
        
        System.out.println("\nPlease select a menu option (1, 2 or 0)");
        int selection = scan.nextInt();
              
        switch (selection) {
            case 0:  exit = true;
                     break;
            case 1:  userAccountMngtScreen();
                     break; 
            case 2:  empAccountMngtScreen();
                     break;
            default: System.out.println("Invalid input");
                     break;
        }
        }
    }
    
   //employeeMngt
    public static void empAccountMngtScreen(){
        boolean exit = false;
        objEmployeeList.load();
        while(!exit){ 
        System.out.println("\n~~~~~~~~~~ Welcome to the Employee Management Portal ~~~~~~~~~~\n");
        
        System.out.println("1. Search for Employee Record");
        System.out.println("2. Add Employee Record");
        System.out.println("3. Edit Employee Record");
        System.out.println("4. Remove Employee Record");
        System.out.println("5. Print Employee Record");
        System.out.println("6. Print All Employee Records");
        
        System.out.println("0. Exit & Save (Save & return to Back-end Mgt.\n" +
                 "Screen)");
        
        System.out.println("\nPlease select a menu option (1,2,3,4,5,6 or 0)");
        int selection = scan.nextInt();
              
        switch (selection) {
            case 0:  exit = true;
                     break;
            case 1:  searchEmp();
                     break; 
            case 2:  addEmpScreen();
                     break;   
            case 3:  editEmpScreen();
                     break;
            case 4:  removeEmpScreen();
                     break;   
            case 5:  printEmpScreen();
                     break;   
            case 6:  printAllEmp();
                     break; 
               
                
            default: System.out.println("Invalid input");
                     break;
        }
         }
        objEmployeeList.save();
        objUserAccountList.clear();
        
    }
    //searchEmp
    public static void searchEmp(){
        System.out.println("\n~~~~~~~~~~ Search Employee Record ~~~~~~~~~~\n");
        scan.nextLine();
        System.out.println("Please enter Social Security Number");
        String ssn = scan.nextLine();
        emp = objEmployeeList.search(ssn);
        if (emp != null){
            System.out.println("First Name: " +emp.getFirstName()+
                    "\nLast Name: "+emp.getLastName()+
                    "\nSocial Num: "+emp.getSsNumber()+
                    "\nAddress: "+ emp.getAddress()+
                    "\nAge: "+ emp.getAge()+
                    "\nEmail: "+ emp.getEmail()+
                    "\nTitle: "+ emp.getJobTitle());
        }
            
        else 
            System.out.println("User not found!");
    }
    
    //addEmp
    public static void addEmpScreen(){
        System.out.println("\n~~~~~~~~~~ Add Employee Record ~~~~~~~~~~\n");
        scan.nextLine();
        
        System.out.println("Please enter NEW SSNumber:");
        String s = scan.nextLine();
        
        System.out.println("Please enter NEW first name:");
        String f = scan.nextLine();
        
        System.out.println("Please enter NEW last name:");
        String l = scan.nextLine();
        
        System.out.println("Please enter NEW DOB:");
        String d = scan.nextLine();
        
        System.out.println("Please enter NEW address:");
        String a = scan.nextLine();
        
        System.out.println("Please enter NEW Email:");
        String e = scan.nextLine();
        
        System.out.println("Please enter NEW job title:");
        String j = scan.nextLine();
        
        System.out.println("Please enter NEW phone number:");
        String p = scan.nextLine();
        
        if(objEmployeeList.add(s, f, l, d, a, p, e, j))
            System.out.println("Add Results:\n User Account Added Successfully");
            else
            System.out.println("Attempt failed");
    }
    
    //editEmp
    public static void editEmpScreen(){
        System.out.println("\n~~~~~~~~~~ Edit Employee Record ~~~~~~~~~~\n");
        scan.nextLine();
        
        System.out.println("Please SSNumber of account to search & Edit");
        String s = scan.nextLine();
        
        System.out.println("Please enter NEW first name:");
        String f = scan.nextLine();
        
        System.out.println("Please enter NEW last name:");
        String l = scan.nextLine();
        
        System.out.println("Please enter NEW DOB:");
        String d = scan.nextLine();
        
        System.out.println("Please enter NEW address:");
        String a = scan.nextLine();
        
        System.out.println("Please enter NEW Email:");
        String e = scan.nextLine();
        
        System.out.println("Please enter NEW job title:");
        String j = scan.nextLine();
        
        System.out.println("Please enter NEW phone number:");
        String p = scan.nextLine();
        
        if(objEmployeeList.edit(s, f, l, d, a, e, j, p))
            System.out.println("Edit Results:\nUser Account Edited Successfully");
            else
            System.out.println("Attempt failed");
    }
    
    //removeEmp
    public static void removeEmpScreen(){
        System.out.println("\n~~~~~~~~~~ Remove Employee Record ~~~~~~~~~~\n");
        scan.nextLine();
        
        System.out.println("Please enter SSNumber of record to delete");
        String ssn = scan.nextLine();
                       
        if(objEmployeeList.remove(ssn))
            System.out.println("Remove Results:\nEmployee Record Deleted Successfully");
            else
            System.out.println("Attempt failed");
    }
    
    //printEmp
    public static void printEmpScreen(){
        System.out.println("\n~~~~~~~~~~ Print Employee Record ~~~~~~~~~~\n");
        scan.nextLine();
        
        System.out.println("Please enter SSNumber of record to print");
        String ssn = scan.nextLine();
                       
        if(objEmployeeList.print(ssn))
            System.out.println("Print Results:\nEmployee record printed to file successfully");
            else
            System.out.println("Attempt failed");
    }
    
    //printAllEmp
    public static void printAllEmp(){
        objEmployeeList.printAll();
    }
    
    //userAccountMngt
    public static void userAccountMngtScreen(){
        boolean exit = false;
        objUserAccountList.load();
        while(!exit){ 
        System.out.println("\n~~~~~~~~~~ Welcome to the User Account Management Portal ~~~~~~~~~~\n");
        
        System.out.println("1. Search for a User Account Record");
        System.out.println("2. Add a User Account Record");
        System.out.println("3. Edit a User Account Record");
        System.out.println("4. Remove a User Account Record");
        System.out.println("5. Change a Username");
        System.out.println("6. Change a Password");
        System.out.println("7. Change an Email");
        System.out.println("0. Exit & Save (Save & return to Back-end Mgt.\n" +
                 "Screen)");
        
        System.out.println("\nPlease select a menu option (1,2,3,4,5,6,7 or 0)");
        int selection = scan.nextInt();
              
        switch (selection) {
            case 0:  exit = true;
                     break;
            case 1:  searchUserAcc();
                     break; 
            case 2:  addUserAccountScreen();
                     break;   
            case 3:  editUserAccountScreen();
                     break;
            case 4:  removeUserAccountScreen();
                     break;   
            case 5:  changeUserAccountScreen();
                     break;   
            case 6:  changePasswordAccountScreen();
                     break; 
            case 7:  changeEmailAccountScreen();
                     break;   
                
            default: System.out.println("Invalid input");
                     break;
        }
        }
        objUserAccountList.save();
        objUserAccountList.clear();
    }
    
    //SearchUser
    public static void searchUserAcc(){
        System.out.println("\n~~~~~~~~~~ Search User Account Screen & Results ~~~~~~~~~~\n");
        scan.nextLine();
        System.out.println("Please enter Username");
        userName = scan.nextLine();
        userAccount = objUserAccountList.search(userName);
        if (userAccount != null){
            System.out.println("\nUser Information:" + 
                    "\nUserName: " +userAccount.getUsername()+
                    "\nPassword: "+userAccount.getPassword()+
                    "\nEmail: "+userAccount.getEmail()+
                    "\nUser Account ID: "+userAccount.getUserAccountID());
        }
            
        else 
            System.out.println("User not found!");
    }
    
    //AddUser
    public static void addUserAccountScreen(){
        System.out.println("\n~~~~~~~~~~ Add User Account Screen & Results ~~~~~~~~~~\n");
        scan.nextLine();
        System.out.println("Please enter Username");
        userName = scan.nextLine();
        
        System.out.println("Please enter Password");
        password = scan.nextLine();
        
        System.out.println("Please enter Email");
        email = scan.nextLine();
        if(objUserAccountList.add(userName, password, email))
            System.out.println("\nAdd Results:\nUser Account Added Successfully");
            else
            System.out.println("\nAttempt failed");
    }
    
    //EditUser
    public static void editUserAccountScreen(){
        System.out.println("\n~~~~~~~~~~ Edit User Account Screen & Results ~~~~~~~~~~\n");
        scan.nextLine();
        
        System.out.println("Please enter Username");
        userName = scan.nextLine();
        
        System.out.println("Please enter Password");
        password = scan.nextLine();
        
        System.out.println("Please enter Email");
        email = scan.nextLine();
        
        if(objUserAccountList.edit(userName, password, email))
            System.out.println("\nEdit Results:\nUser Account Edited Successfully");
            else
            System.out.println("\nAttempt failed");
    }
    
    //RemoveUser
    public static void removeUserAccountScreen(){
        System.out.println("\n~~~~~~~~~~ Remove User Account ~~~~~~~~~~\n");
        scan.nextLine();
        
        System.out.println("Please enter Username of record to delete");
        userName = scan.nextLine();
                       
        if(objUserAccountList.remove(userName))
            System.out.println("\nRemove Results:\nUser Account Deleted  Successfully");
            else
            System.out.println("\nAttempt failed");
    }
    
    //ChangeUser
    public static void changeUserAccountScreen(){
        System.out.println("\n~~~~~~~~~~ Change Username Screen & Results ~~~~~~~~~~\n");
        scan.nextLine();
        
        System.out.println("Please enter Username to change");
        userName = scan.nextLine();
        
        System.out.println("Please enter new User Name");
        String newUserName = scan.nextLine();
                       
        if(objUserAccountList.changeUserName(userName, newUserName))
            System.out.println("\nEdit Results:\nUsername Changed Successfully");
            else
            System.out.println("\nAttempt failed");
    }
    
    //ChangePass
    public static void changePasswordAccountScreen(){
        System.out.println("\n~~~~~~~~~~ Change Password  ~~~~~~~~~~\n");
        scan.nextLine();
        
        System.out.println("Please enter Username");
        userName = scan.nextLine();
        
        System.out.println("Please enter new password");
        String newPassword = scan.nextLine();
                       
        if(objUserAccountList.changePassword(userName, newPassword))
            System.out.println("\nEdit Results:\nPassword Changed Successfully");
            else
            System.out.println("\nAttempt failed");
    }
    
    //ChangeEmail
    public static void changeEmailAccountScreen(){
        System.out.println("\n~~~~~~~~~~ Change Email  ~~~~~~~~~~\n");
        scan.nextLine();
        
        System.out.println("Please enter Username");
        userName = scan.nextLine();
        
        System.out.println("Please enter new email");
        String newEmail = scan.nextLine();
                       
        if(objUserAccountList.changeEmail(userName, newEmail))
            System.out.println("\nEdit Results:\nEmail Changed Successfully");
            else
            System.out.println("\nAttempt failed");
    }
    
    //AuthenticateMethod
    public static boolean Authenticate(String U, String P){
        return objUserAccountList.authenticate(U, P);
    }
    
    
}

