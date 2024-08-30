import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static int loginmode;
	public static int crntaclgnatmp=5;
	
	//login mode, 1 = Admin, 2 = Manager, 3 = Employee. This variable uses for keeping the status of role, which role is currently logged in.
	
	public static int userindexinlist;
	
	//userindexlist varaiable uses for keeping the index of current user from the user list.
	
	public static String username;
	public static String useremail="";
	
	public static int crntusrsrcindex;
	public static int crntusrsrcrole;
	
	public static List<String> adminEmails = new ArrayList<>();
	public static List<String> adminPasswords = new ArrayList<>();
	public static List<String> adminNames = new ArrayList<>();
	public static List<String> adminSalleries = new ArrayList<>();
	public static List<String> adminIds = new ArrayList<>();
	public static List<String> adminPositions = new ArrayList<>();
	public static List<String> adminStatus = new ArrayList<>();
	
	//Array list for admin data
	
	public static List<String> managerEmails = new ArrayList<>();
	public static List<String> managerPasswords = new ArrayList<>();
	public static List<String> managerNames = new ArrayList<>();
	public static List<String> managerSalleries= new ArrayList<>();
	public static List<String> managerIds = new ArrayList<>();
	public static List<String> managerPositions = new ArrayList<>();
	public static List<String> managerStatus = new ArrayList<>();
	
	//Array list for manager data
	
	public static List<String> employeeEmails = new ArrayList<>();
	public static List<String> employeePasswords = new ArrayList<>();
	public static List<String> employeeNames = new ArrayList<>();
	public static List<String> employeeSalleries = new ArrayList<>();
	public static List<String> employeeIds = new ArrayList<>();
	public static List<String> employeePositions = new ArrayList<>();
	public static List<String> employeeStatus = new ArrayList<>();
	
	
 //Array list for employee data
 
 
	public static void main(String[] args) {
		
		System.out.println("Good day,\nWelcome to employee managing system.");

//Adding test credential
		
	adminEmails.add("me@saisab.com");
	adminPasswords.add("123456");
	adminNames.add("Md Saisab Ekther");
	adminSalleries.add("466888");
	adminPositions.add("Admin");
	adminIds.add("11");
	adminStatus.add("true");
		
		
	managerEmails.add("me@ekther.com");
	managerPasswords.add("123456");
	managerNames.add("Md Ekther Saisab");
	managerSalleries.add("100088");
	managerPositions.add("Manager>Finance Manager");
	managerIds.add("22");
	managerStatus.add("true");
	
	employeeEmails.add("me@samad.com");
	employeePasswords.add("123456");
	employeeNames.add("Ekther Samad");
	employeeSalleries.add("200777");
	employeePositions.add("Employee>Desk officer");
	employeeIds.add("33");
	employeeStatus.add("true");
		
		
		
		Login all = new Login();
		
       
		
		all.loginPage();
	}
}







class Login{
    
    public void loginPage(){
        Scanner input = new Scanner (System.in);       Login all = new Login();
         String loginindex = "0";
        System.out.println("\n\n1) Login as a admin\n2) Login as a manager\n3) Login as a employee");
        
        System.out.println("\nType 1 or 2 or 3 to proceed");
        loginindex = input.nextLine();
        
        switch (loginindex) {
  case "1":
    all.adminlogin();
    break;
  case "2":
     all.managerlogin();
    break;
  case "3":
     all.employeelogin();
    break;
    default:
    System.out.println("\n\nWrong input. Input must be 1 or 2 or 3\nTry again");
    all.loginPage();
     break;
        }
        
    }
        
        
     public void adminlogin(){
      Extra all = new Extra () ;
      Login all2 = new Login ();
      Home all3 = new Home ();
      Scanner input = new Scanner (System.in);        String email;
      String password;
      System.out.println("\n\nAdmin Login");
      System.out.println("\nEnter your admin email");
      email = input.nextLine();
      
      System.out.println("Enter your admin password");
      password = input.nextLine();
      
      if(Main.adminEmails.contains(email)){
        Main.userindexinlist=Main.adminEmails.indexOf(email);
        
        if(password.equals((Main.adminPasswords.get(Main.userindexinlist)))){
            
            if(Main.adminStatus.get(Main.userindexinlist).equals("true")){
            
            Main.loginmode = 1;
            
            Main.username=Main.adminNames.get(Main.userindexinlist);
            all3.homePage(Main.username);
            
            }
            else{
                
                all.clearHistory();
                System.out.println("\nLogin failed.\nYour account is disabled.\nContact admin for further assistance.");
                all2.loginPage();
            }
            
            }
            
     else {
            
            
           
            System.out.println("\nLogin failed.\nPassword does not match");
            System.out.println("\nTry again");
            all2.adminlogin();
            
            
            }
       }
       else{
            all.clearHistory();
            System.out.println("\nNo account found");
            all.goLoginpage();
           }
       
      }
      
    public void managerlogin(){
      Scanner input = new Scanner (System.in); 
      Extra all = new Extra () ;   
      Login all2 = new Login ();   
      Home all3 = new Home (); 
      String email;
      String password;
      System.out.println("\n\nManager Login");
      System.out.println("\nEnter your manager email");
      email = input.nextLine();
      if(!email.equals(Main.useremail)){
          
          Main.useremail=email;
          Main.crntaclgnatmp=5;
          
          }
      
      
      System.out.println("Enter your manager password");
      password = input.nextLine();
      
      if(Main.managerEmails.contains(email)){
        Main.userindexinlist=Main.managerEmails.indexOf(email);
        
        Main.loginmode = 2;
        
        if(password.equals((Main.managerPasswords.get(Main.userindexinlist)))){
            
            if(Main.managerStatus.get(Main.userindexinlist).equals("true"))
            
            {
           
            
            Main.username=Main.managerNames.get(Main.userindexinlist);
            all3.homePage(Main.username);
            
            
            }
            
            else{
                
                all.clearHistory();
                System.out.println("\nLogin failed.\nYour account is disabled.\nContact admin for further assistance.");
                all2.loginPage();
            }
            
            }
            
            else {
                all.clearHistory();
                
                 Main.crntaclgnatmp=Main.crntaclgnatmp-1;
                 
            if(Main.crntaclgnatmp==0){
                
                
               Main.managerStatus.set(Main.userindexinlist,"false");
               Main.crntaclgnatmp=5;
                System.out.println("\nLogin failed.\nPassword does not match\n\nYour account has been disabled due to several unsuccess attempts\nContact admin for further assistance.");
                all2.loginPage();
                }
                
                else{
                    all.clearHistory();
                    System.out.println("\nLogin failed.\nPassword does not match.\nYou may attempt more "+Main.crntaclgnatmp+" time(s).");
            System.out.println("\nTry again");
            all2.managerlogin();
                    
                    }
                
                
                
            
            }
       }
       else{
            all.clearHistory();
            System.out.println("\nNo account found");
            all.goLoginpage();
           }
      
      
      }
    
    
    public void employeelogin(){
      Scanner input = new Scanner (System.in);
      Extra all = new Extra () ;
      Login all2 = new Login ();
      Home all3 = new Home ();
       String email;
      String password;
      System.out.println("\n\nEmployee Login");
      System.out.println("\nEnter your employee email");
      email = input.nextLine();
      if(!email.equals(Main.useremail)){
          
          Main.useremail=email;
          Main.crntaclgnatmp=5;
          
          }
      System.out.println("Enter your employee password");
      password = input.nextLine();
      
        if(Main.employeeEmails.contains(email)){
        Main.userindexinlist=Main.employeeEmails.indexOf(email);
        Main.loginmode = 3;
        if(password.equals((Main.employeePasswords.get(Main.userindexinlist)))){
            
            
            
            
            if(Main.employeeStatus.get(Main.userindexinlist).equals("true")){
            
            
            Main.username=Main.employeeNames.get(Main.userindexinlist);
            
            
            all3.homePage(Main.username);
            
            }
            
            
            
            
            
            else{
                
                all.clearHistory();
                System.out.println("\nLogin failed.\nYour account is disabled.\nContact admin for further assistance.");
                all2.loginPage();
            }
            
        }
            
            else {
                
                all.clearHistory();
                
                 Main.crntaclgnatmp=Main.crntaclgnatmp-1;
                 
            if(Main.crntaclgnatmp==0){
                
                
               Main.employeeStatus.set(Main.userindexinlist,"false");
               Main.crntaclgnatmp=5;
                System.out.println("\nLogin failed.\nPassword does not match\n\nYour account has been disabled due to several unsuccess attempts\nContact admin for further assistance.");
                all2.loginPage();
                }
                
                else{
                    all.clearHistory();
                    System.out.println("\nLogin failed.\nPassword does not match.\nYou may attempt more "+Main.crntaclgnatmp+" time(s).");
            System.out.println("\nTry again");
            all2.employeelogin();
                    
                    }
            
            }
       }
       else{
            all.clearHistory();
            System.out.println("\nNo account found");
            all.goLoginpage();
           }
      }
    
}








class Extra{
    
    public void goLoginpage(){
        
        String test;
        Login all = new Login();
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter anything to return login page");
        test=input.nextLine();
		all.loginPage();
        
        }
        
        
     public void clearHistory(){
         
         for(int i =0; i<100; i++ ){
             
             System.out.println("");
            
             
             }
             System.out.print("\033[H");
    System.out.flush();
         
         }
    
    }
    
    
    
    
    
    
    class Home{
        
        public void homePage(String name){
            Extra all = new Extra ();
            Operation all2 = new Operation();
            
            
            all.clearHistory();
            
            System.out.println("\nLogin successfull.\nHi, "+name+"\n");
            all2.checkRole();
            
          
                    
                    
                    
           }
      }
      
      
class Operation{
                
                
                public void checkRole(){
                    Extra all= new Extra();
                    Operation all2 = new Operation();
                    Login all3 = new Login ();
                    Scanner input = new Scanner(System.in);
                    String chooseindex="0";
                     if(Main.loginmode == 1){
            System.out.println("\n1) Add employee\n2) Delete employee\n3) Update employee data\n4) Search an employee\n5) Logout");
            
            System.out.println("\n\nType 1 or 2 or 3 or 4 to proceed...");
            chooseindex=input.nextLine();
            
            }
            
            else if(Main.loginmode == 2){
                
                System.out.println("\n3) Update employee data\n4) Search an employee\n5) Logout");
                System.out.println("\n\nType 3 or 4 to proceed...");
                chooseindex=input.nextLine();
                }
                
                else if(Main.loginmode == 3){
                    System.out.println("\n4) Search an employee\n5) Logout");
                    
                    System.out.println("\n\nType 4 to proceed...");
                    
         chooseindex=input.nextLine();
                        
                        }
                        
                   switch(chooseindex){
                        
                        case "1":
                       
                         
                            if(Main.loginmode == 1){
                            
                                 all.clearHistory();
                        all2.addEmployee();
                            }
                            
                            else {
                                
                                  all.clearHistory();
                                System.out.println("\n\nWrong input\n");
                                all2.checkRole();
                                }
                             
                           
                      
                         
                        
                        case "2":
                        
                         if(Main.loginmode == 1){
                            
                                 all.clearHistory();
                        all2.deleteEmployee();
                            }
                            
                            else {
                                
                                
                                  all.clearHistory();
                                  System.out.println("\n\nWrong input\n");
                                all2.checkRole();
                                }
                        
                        
                        
                        
                        case "3":
                        
                         if(Main.loginmode == 1 || Main.loginmode == 2){
                              all.clearHistory();
                        all2.updateEmployee();
                                 
                            }
                            
                            else {
                                
                                
                                  all.clearHistory();
                                  System.out.println("\n\nWrong input\n");
                                all2.checkRole();
                                }
                                
                         
                        
                        case "4":
                        all.clearHistory();
                        all2.searchEmployee();
                        
                        
                        case "5":
                        Main.userindexinlist=0;
                        Main.username="";
                        all.clearHistory();
                        System.out.println("Logged out succesfully");
                        all3.loginPage();
                        
                        default:
                        System.out.println("\n\nWrong input.\nInput must be 1 or 2 or 3 or 4");
                        all2.checkRole();
                        
                   
                        
                    }
                    
                    }
                
                
                
                public void deleteEmployee(){
                     
                    Scanner input = new Scanner(System.in);
                    Operation all = new Operation();
                    Extra all2 = new Extra ();
                    Home all3 = new Home();
                    String chooseindex ="0";
                    String employeeid;
                    int userindex;
                    String temp;
                   
                    System.out.println("\nDelete an  employee\n\n1) Choose employee via id\n2) Choose employee via email\n\nType H to return home at any time\n\nType 1 or 2 to proceed");
                    
                    chooseindex=input.nextLine();
                    
                    switch(chooseindex){
                        
                        case "1":
                        
                        System.out.println("\nEnter employee id");
                        employeeid = input.nextLine();
                        if(Main.adminIds.contains(employeeid)){
                            userindex = Main.adminIds.indexOf(employeeid);
                            Main.crntusrsrcrole=1;
                            Main.crntusrsrcindex=userindex;
                           all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+employeeid+"\nEmployee name: "+Main.adminNames.get(userindex)+"\nAccount email: "+Main.adminEmails.get(userindex));
                            
                        System.out.println("\nType Yes to delete this employee or anything else to cancel");
                    temp=input.nextLine();
                    if(temp.equals("Yes") || temp.equals("yes") || temp.equals("YES")){
                            
                            all.removeItem("Admin",userindex);
                            }
                            
                            else{
    
           all2.clearHistory();
             all3.homePage(Main.username);
    
    }
                            
                            }
                            
                            
              else if(Main.managerIds.contains(employeeid)){
                            userindex = Main.managerIds.indexOf(employeeid);
                            Main.crntusrsrcrole=2;
                            Main.crntusrsrcindex=userindex;
                            all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+employeeid+"\nEmployee name: "+Main.managerNames.get(userindex)+"\nAccount email: "+Main.managerEmails.get(userindex));
                            
                             System.out.println("\nType Yes to delete this employee or anything else to cancel");
                    temp=input.nextLine();
                    if(temp.equals("Yes") || temp.equals("yes") || temp.equals("YES")){
                            
                            all.removeItem("Manager",userindex);
                            }
                            else{
    
           all2.clearHistory();
             all3.homePage(Main.username);
    
    }
                            
                      
                            
                            }
                            
               else if(Main.employeeIds.contains(employeeid)){
                            userindex = Main.employeeIds.indexOf(employeeid);
                            Main.crntusrsrcrole=3;
                            Main.crntusrsrcindex=userindex;
                            all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+employeeid+"\nEmployee name: "+Main.employeeNames.get(userindex)+"\nAccount email: "+Main.employeeEmails.get(userindex));
                            System.out.println("\nType Yes to delete this employee or anything else to cancel");
                    temp=input.nextLine();
                    if(temp.equals("Yes") || temp.equals("yes") || temp.equals("YES")){
                            
                            all.removeItem("Employee",userindex);
                            }
                            
                            else{
    
           all2.clearHistory();
             all3.homePage(Main.username);
    
    }
                            
                            
                      
                            
                            }
                            
                   else{
                            
                            
                            all2.clearHistory();
                            System.out.println("\nNo account found\n\n");
                            
                            all.updateEmployee();
                            }
                            
                 
                        
                        
                        
                        case "2":
                        
                        System.out.println("\nEnter employee email");
                        employeeid = input.nextLine();
                        if(Main.adminEmails.contains(employeeid)){
                            userindex = Main.adminEmails.indexOf(employeeid);
                            Main.crntusrsrcrole=1;
                            Main.crntusrsrcindex=userindex;
                            all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+Main.adminIds.get(userindex)+"\nEmployee name: "+Main.adminNames.get(userindex)+"\nAccount email: "+employeeid);
                            
                             System.out.println("\nType Yes to delete this employee or anything else to cancel");
                    temp=input.nextLine();
                    if(temp.equals("Yes") || temp.equals("yes") || temp.equals("YES")){
                            
                            all.removeItem("Admin",userindex);
                            }
                            
                            else{
    
           all2.clearHistory();
             all3.homePage(Main.username);
    
    }
                            
                            
                            
                            }
                            
                            
              else if(Main.managerEmails.contains(employeeid)){
                            userindex = Main.managerEmails.indexOf(employeeid);
                            Main.crntusrsrcrole=2;
                            Main.crntusrsrcindex=userindex;
                            all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+Main.managerIds.get(userindex)+"\nEmployee name: "+Main.managerNames.get(userindex)+"\nAccount email: "+employeeid);
                            
                           System.out.println("\nType Yes to delete this employee or anything else to cancel");
                    temp=input.nextLine();
                    if(temp.equals("Yes") || temp.equals("yes") || temp.equals("YES")){
                            
                            all.removeItem("Manager",userindex);
                            }
                            
                            else{
    
           all2.clearHistory();
             all3.homePage(Main.username);
    
    }
                            
                      
                            
                            }
                            
               else if(Main.employeeEmails.contains(employeeid)){
                            userindex = Main.employeeEmails.indexOf(employeeid);
                            Main.crntusrsrcrole=3;
                            Main.crntusrsrcindex=userindex;
                            all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+employeeid+"\nEmployee name: "+Main.employeeIds.get(userindex)+"\nAccount email: "+employeeid);
                            
                            System.out.println("\nType Yes to delete this employee or anything else to cancel");
                    temp=input.nextLine();
                    if(temp.equals("Yes") || temp.equals("yes") || temp.equals("YES")){
                            
                            all.removeItem("Employee",userindex);
                            }
                            
                            else{
    
           all2.clearHistory();
             all3.homePage(Main.username);
    
    }
                      
                            
                            }
                            
                   else{
                            
                            
                            all2.clearHistory();
                            System.out.println("\nNo account found\n\n");
                            
                            all.updateEmployee();
                            }
                        
                        case "H":
                        all2.clearHistory();
                    all3.homePage(Main.username);
                    
                    case "h":
                        all2.clearHistory();
                    all3.homePage(Main.username);
                    
                        
                        default:
                        
                        all2.clearHistory();
                        System.out.println("\nWrong input. Input must be 1 or 2\n");
                        all.updateEmployee();
                        
                        
                        
                        }
                    
                    
                    
                }
                
                
                
                
                
                public void removeItem(String role, int userindex){
                    
                    String temp;
                   Scanner input = new Scanner(System.in);
                    Operation all = new Operation();
                    Extra all2 = new Extra ();
                    Home all3 = new Home();
                    
                    if(role=="Admin"){
                        
                        
                        
                        Main.adminEmails.remove(userindex);
	Main.adminPasswords.remove(userindex);
	Main.adminNames.remove(userindex);
	Main.adminSalleries.remove(userindex);
	Main.adminPositions.remove(userindex);
	Main.adminIds.remove(userindex);
	Main.adminStatus.remove(userindex);
                        
                        }
                   
                   else if(role=="Manager"){
                    
                    Main.managerEmails.remove(userindex);
	Main.managerPasswords.remove(userindex);
	Main.managerNames.remove(userindex);
	Main.managerSalleries.remove(userindex);
	Main.managerPositions.remove(userindex);
	Main.managerIds.remove(userindex);
	Main.managerStatus.remove(userindex);
                    
                    
                    }
                else {
                    
                    Main.employeeEmails.remove(userindex);
	Main.employeePasswords.remove(userindex);
	Main.employeeNames.remove(userindex);
	Main.employeeSalleries.remove(userindex);
	Main.employeePositions.remove(userindex);
	Main.employeeIds.remove(userindex);
	Main.employeeStatus.remove(userindex);
                    
                    }
           
           
           System.out.println("\n\nEmployee data has been deleted successfully.\n\nEnter anything to return home");
           temp=input.nextLine();
           
           all2.clearHistory();
             all3.homePage(Main.username);
                    
                    }
                
                
                
                
                
                
                
                
                
                
                
                
                public void updateEmployee(){
                     
                    Scanner input = new Scanner(System.in);
                    Operation all = new Operation();
                    Extra all2 = new Extra ();
                    Home all3 = new Home();
                    String chooseindex ="0";
                    String employeeid;
                    int userindex;
                   
                    System.out.println("\nUpdate employee data\n\n1) Choose employee via id\n2) Choose employee via email\n\nType H to return home at any time\n\nType 1 or 2 to proceed");
                    
                    chooseindex=input.nextLine();
                    
                    switch(chooseindex){
                        
                        case "1":
                        
                        System.out.println("\nEnter employee id");
                        employeeid = input.nextLine();
                        if(Main.adminIds.contains(employeeid)){
                            userindex = Main.adminIds.indexOf(employeeid);
                            Main.crntusrsrcrole=1;
                            Main.crntusrsrcindex=userindex;
                           all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+employeeid+"\nEmployee name: "+Main.adminNames.get(userindex)+"\nAccount email: "+Main.adminEmails.get(userindex));
                            
                           all.updateEmpOptions();
                            
                            }
                            
                            
              else if(Main.managerIds.contains(employeeid)){
                            userindex = Main.managerIds.indexOf(employeeid);
                            Main.crntusrsrcrole=2;
                            Main.crntusrsrcindex=userindex;
                            all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+employeeid+"\nEmployee name: "+Main.managerNames.get(userindex)+"\nAccount email: "+Main.managerEmails.get(userindex));
                            
                             all.updateEmpOptions();
                            
                      
                            
                            }
                            
               else if(Main.employeeIds.contains(employeeid)){
                            userindex = Main.employeeIds.indexOf(employeeid);
                            Main.crntusrsrcrole=3;
                            Main.crntusrsrcindex=userindex;
                            all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+employeeid+"\nEmployee name: "+Main.employeeNames.get(userindex)+"\nAccount email: "+Main.employeeEmails.get(userindex));
                            
                             all.updateEmpOptions();
                            
                            
                      
                            
                            }
                            
                   else{
                            
                            
                            all2.clearHistory();
                            System.out.println("\nNo account found\n\n");
                            
                            all.updateEmployee();
                            }
                            
                 
                        
                        
                        
                        case "2":
                        
                        System.out.println("\nEnter employee email");
                        employeeid = input.nextLine();
                        if(Main.adminEmails.contains(employeeid)){
                            userindex = Main.adminEmails.indexOf(employeeid);
                            Main.crntusrsrcrole=1;
                            Main.crntusrsrcindex=userindex;
                            all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+Main.adminIds.get(userindex)+"\nEmployee name: "+Main.adminNames.get(userindex)+"\nAccount email: "+employeeid);
                            
                             all.updateEmpOptions();
                            
                            
                            
                            }
                            
                            
              else if(Main.managerEmails.contains(employeeid)){
                            userindex = Main.managerEmails.indexOf(employeeid);
                            Main.crntusrsrcrole=2;
                            Main.crntusrsrcindex=userindex;
                            all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+Main.managerIds.get(userindex)+"\nEmployee name: "+Main.managerNames.get(userindex)+"\nAccount email: "+employeeid);
                            
                             all.updateEmpOptions();
                            
                      
                            
                            }
                            
               else if(Main.employeeEmails.contains(employeeid)){
                            userindex = Main.employeeEmails.indexOf(employeeid);
                            Main.crntusrsrcrole=3;
                            Main.crntusrsrcindex=userindex;
                            all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+employeeid+"\nEmployee name: "+Main.employeeIds.get(userindex)+"\nAccount email: "+employeeid);
                            
                            all.updateEmpOptions();
                      
                            
                            }
                            
                   else{
                            
                            
                            all2.clearHistory();
                            System.out.println("\nNo account found\n\n");
                            
                            all.updateEmployee();
                            }
                        
                        case "H":
                        all2.clearHistory();
                    all3.homePage(Main.username);
                    
                    case "h":
                        all2.clearHistory();
                    all3.homePage(Main.username);
                    
                        
                        default:
                        
                        all2.clearHistory();
                        System.out.println("\nWrong input. Input must be 1 or 2\n");
                        all.updateEmployee();
                        
                        
                        
                        }
                    
                    
                    
                }
                
                
                
              public void searchEmployee(){
                     
                    Scanner input = new Scanner(System.in);
                    Operation all = new Operation();
                    Extra all2 = new Extra ();
                    Home all3 = new Home();
                    String chooseindex ="0";
                    String employeeid;
                    int userindex;
                    String temp;
                   
                    System.out.println("\nSearch an employee\n\n1) Find employee via id\n2) Find employee via email\n\nType H to return home at any time\n\nType 1 or 2 to proceed");
                    
                    chooseindex=input.nextLine();
                    
                    switch(chooseindex){
                        
                        case "1":
                        
                        System.out.println("\nEnter employee id");
                        employeeid = input.nextLine();
                        if(Main.adminIds.contains(employeeid)){
                            userindex = Main.adminIds.indexOf(employeeid);
                            Main.crntusrsrcrole=1;
                            Main.crntusrsrcindex=userindex;
                           all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+employeeid+"\nEmployee name: "+Main.adminNames.get(userindex)+"\nEmployee email: "+Main.adminEmails.get(userindex)+"\nEmployee position: "+Main.adminPositions.get(userindex)+"\nEmployee salary: "+Main.adminSalleries.get(userindex)+"\nAccount status: "+Main.adminStatus.get(userindex));
                            
                           System.out.println("\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all3.homePage(Main.username);
        all2.clearHistory();
                            
                            }
                            
                            
              else if(Main.managerIds.contains(employeeid)){
                            userindex = Main.managerIds.indexOf(employeeid);
                            Main.crntusrsrcrole=2;
                            Main.crntusrsrcindex=userindex;
                            all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+employeeid+"\nEmployee name: "+Main.managerNames.get(userindex)+"\nEmployee email: "+Main.managerEmails.get(userindex)+"\nEmployee position: "+Main.managerPositions.get(userindex)+"\nEmployee salary: "+Main.managerSalleries.get(userindex)+"\nAccount status: "+Main.managerStatus.get(userindex));
                            
                             
                            System.out.println("\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all3.homePage(Main.username);
        all2.clearHistory();
                      
                            
                            }
                            
               else if(Main.employeeIds.contains(employeeid)){
                            userindex = Main.employeeIds.indexOf(employeeid);
                            Main.crntusrsrcrole=3;
                            Main.crntusrsrcindex=userindex;
                            all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+employeeid+"\nEmployee name: "+Main.employeeNames.get(userindex)+"\nEmployee email: "+Main.employeeEmails.get(userindex)+"\nEmployee position: "+Main.employeePositions.get(userindex)+"\nEmployee salary: "+Main.employeeSalleries.get(userindex)+"\nAccount status: "+Main.employeeStatus.get(userindex));
                            
                             
                            System.out.println("\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all3.homePage(Main.username);
        all2.clearHistory();
                            
                      
                            
                            }
                            
                   else{
                            
                            
                            all2.clearHistory();
                            System.out.println("\nNo account found\n\n");
                            
                            all.updateEmployee();
                            }
                            
                 
                        
                        
                        
                        case "2":
                        
                        System.out.println("\nEnter employee email");
                        employeeid = input.nextLine();
                        if(Main.adminEmails.contains(employeeid)){
                            userindex = Main.adminEmails.indexOf(employeeid);
                            Main.crntusrsrcrole=1;
                            Main.crntusrsrcindex=userindex;
                            all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+Main.adminIds.get(userindex)+"\nEmployee name: "+Main.adminNames.get(userindex)+"\nEmployee email: "+employeeid+"\nEmployee position: "+Main.adminPositions.get(userindex)+"\nEmployee salary: "+Main.adminSalleries.get(userindex)+"\nAccount status: "+Main.adminStatus.get(userindex));
                            
                             
                            System.out.println("\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all3.homePage(Main.username);
        all2.clearHistory();
                            
                            
                            }
                            
                            
              else if(Main.managerEmails.contains(employeeid)){
                            userindex = Main.managerEmails.indexOf(employeeid);
                            Main.crntusrsrcrole=2;
                            Main.crntusrsrcindex=userindex;
                            all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+Main.managerIds.get(userindex)+"\nEmployee name: "+Main.managerNames.get(userindex)+"\nEmployee email: "+employeeid+"\nEmployee position: "+Main.managerPositions.get(userindex)+"\nEmployee salary: "+Main.managerSalleries.get(userindex)+"\nAccount status: "+Main.managerStatus.get(userindex));
                            
                             
                            System.out.println("\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all3.homePage(Main.username);
        all2.clearHistory();
                      
                            
                            }
                            
               else if(Main.employeeEmails.contains(employeeid)){
                            userindex = Main.employeeEmails.indexOf(employeeid);
                            Main.crntusrsrcrole=3;
                            Main.crntusrsrcindex=userindex;
                            all2.clearHistory();
                            System.out.println("\nEmployee found.\n\nEmployee id: "+employeeid+"\nEmployee name: "+Main.employeeIds.get(userindex)+"\nEmployee email: "+employeeid+"\nEmployee position: "+Main.employeePositions.get(userindex)+"\nEmployee salary: "+Main.employeeSalleries.get(userindex)+"\nAccount status: "+Main.employeeStatus.get(userindex));
                            
                            System.out.println("\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all3.homePage(Main.username);
        all2.clearHistory();
                      
                            
                            }
                            
                   else{
                            
                            
                            all2.clearHistory();
                            System.out.println("\nNo account found\n\n");
                            
                            all.updateEmployee();
                            }
                        
                        case "H":
                        all2.clearHistory();
                    all3.homePage(Main.username);
                    
                    case "h":
                        all2.clearHistory();
                    all3.homePage(Main.username);
                    
                        
                        default:
                        
                        all2.clearHistory();
                        System.out.println("\nWrong input. Input must be 1 or 2\n");
                        all.searchEmployee();
                        
                        
                        
                        }
                    
                    
                    
                }
              
              
              
                
                
         public void updateEmpOptions(){
                
                Scanner input = new Scanner (System.in);
                Extra all = new Extra();
                Home all2 = new Home();
                String chooseindex = "0";
                String temp;
                String test;
             
                System.out.println("\n\nChoose an option...\n\n1) Update name\n2) Update email\n3) Update salary\n4) Update position\n5) Enable or disable acoount\n\nType H to cancel & return home\n\nEnter 1 or 2 or 3 or 4 or 5 to proceed...");
                
                chooseindex=input.nextLine();
              
                
                    all.clearHistory();
                
                  switch(chooseindex){
                    
                    
                    
                    case "1":
                    if (Main.crntusrsrcrole == 1) {
    System.out.println("\nUpdate employee name\n\nCurrent name: " + Main.adminNames.get(Main.crntusrsrcindex)+"\n\nEnter new name");
    test = input.nextLine();
    
    System.out.println("\n\nType Yes to complete or anything else to cancel");
    temp = input.nextLine();
    
    if(temp.equals("yes") || temp.equals("Yes") || temp.equals("YES")  ){
        
        Main.adminNames.set(Main.crntusrsrcindex,test);
        
        System.out.println("\nData has been updated.\n\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
        
    
    else{
        
        
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
    
   
} 

else if (Main.crntusrsrcrole == 2) {
    System.out.println("\nUpdate employee name\n\nCurrent name: " + Main.managerNames.get(Main.crntusrsrcindex)+"\n\nEnter new name");
    test = input.nextLine();
    
    System.out.println("\n\nType Yes to complete or anything else to cancel");
    temp = input.nextLine();
    
    if(temp.equals("yes") || temp.equals("Yes") || temp.equals("YES")  ){
        
        Main.managerNames.set(Main.crntusrsrcindex,test);
        
        System.out.println("\nData has been updated.\n\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
        
    
    else{
        
        
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
}

else {
    System.out.println("\nUpdate employee name\n\nCurrent name: " + Main.employeeNames.get(Main.crntusrsrcindex)+"\n\nEnter new name");
    test = input.nextLine();
    
    System.out.println("\n\nType Yes to complete or anything else to cancel");
    temp = input.nextLine();
    
    if(temp.equals("yes") || temp.equals("Yes") || temp.equals("YES")  ){
        
        Main.employeeNames.set(Main.crntusrsrcindex,test);
        
        System.out.println("\nData has been updated.\n\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
        
    
    else{
        
        
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
}



                  
                    
                    case "2":
                    
                    
                    if (Main.crntusrsrcrole == 1) {
    System.out.println("\nUpdate employee email\n\nCurrent email: " + Main.adminEmails.get(Main.crntusrsrcindex)+"\n\nEnter new email");
    test = input.nextLine();
    
    System.out.println("\n\nType Yes to complete or anything else to cancel");
    temp = input.nextLine();
    
    if(temp.equals("yes") || temp.equals("Yes") || temp.equals("YES")  ){
        
        Main.adminEmails.set(Main.crntusrsrcindex,test);
        
        System.out.println("\nData has been updated.\n\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
        
    
    else{
        
        
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
    
   
} 

else if (Main.crntusrsrcrole == 2) {
    System.out.println("\nUpdate employee email\n\nCurrent email: " + Main.managerEmails.get(Main.crntusrsrcindex)+"\n\nEnter new email");
    test = input.nextLine();
    
    System.out.println("\n\nType Yes to complete or anything else to cancel");
    temp = input.nextLine();
    
    if(temp.equals("yes") || temp.equals("Yes") || temp.equals("YES")  ){
        
        Main.managerEmails.set(Main.crntusrsrcindex,test);
        
        System.out.println("\nData has been updated.\n\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
        
    
    else{
        
        
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
}

else {
    System.out.println("\nUpdate employee email\n\nCurrent email: " + Main.employeeEmails.get(Main.crntusrsrcindex)+"\n\nEnter new email");
    test = input.nextLine();
    
    System.out.println("\n\nType Yes to complete or anything else to cancel");
    temp = input.nextLine();
    
    if(temp.equals("yes") || temp.equals("Yes") || temp.equals("YES")  ){
        
        Main.employeeEmails.set(Main.crntusrsrcindex,test);
        
        System.out.println("\nData has been updated.\n\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
        
    
    else{
        
        
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
}

                    
                    
                    
                    
                    case "3":
                    
                    if (Main.crntusrsrcrole == 1) {
    System.out.println("\nUpdate employee salary\n\nCurrent salary: " + Main.adminSalleries.get(Main.crntusrsrcindex)+"\n\nEnter new salary");
    test = input.nextLine();
    
    System.out.println("\n\nType Yes to complete or anything else to cancel");
    temp = input.nextLine();
    
    if(temp.equals("yes") || temp.equals("Yes") || temp.equals("YES")  ){
        
        Main.adminSalleries.set(Main.crntusrsrcindex,test);
        
        System.out.println("\nData has been updated.\n\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
        
    
    else{
        
        
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
    
   
} 

else if (Main.crntusrsrcrole == 2) {
    System.out.println("\nUpdate employee salary\n\nCurrent salary: " + Main.managerSalleries.get(Main.crntusrsrcindex)+"\n\nEnter new salary");
    test = input.nextLine();
    
    System.out.println("\n\nType Yes to complete or anything else to cancel");
    temp = input.nextLine();
    
    if(temp.equals("yes") || temp.equals("Yes") || temp.equals("YES")  ){
        
        Main.managerSalleries.set(Main.crntusrsrcindex,test);
        
        System.out.println("\nData has been updated.\n\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
        
    
    else{
        
        
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
}

else {
    System.out.println("\nUpdate employee salary\n\nCurrent salary: " + Main.employeeSalleries.get(Main.crntusrsrcindex)+"\n\nEnter new salary");
    test = input.nextLine();
    
    System.out.println("\n\nType Yes to complete or anything else to cancel");
    temp = input.nextLine();
    
    if(temp.equals("yes") || temp.equals("Yes") || temp.equals("YES")  ){
        
        Main.employeeSalleries.set(Main.crntusrsrcindex,test);
        
        System.out.println("\nData has been updated.\n\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
        
    
    else{
        
        
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
}

                    
                    
                    case "4":
                    
                    if (Main.crntusrsrcrole == 1) {
    System.out.println("\nUpdate employee position\n\nCurrent position: " + Main.adminPositions.get(Main.crntusrsrcindex)+"\n\nEnter new position");
    test = input.nextLine();
    
    System.out.println("\n\nType Yes to complete or anything else to cancel");
    temp = input.nextLine();
    
    if(temp.equals("yes") || temp.equals("Yes") || temp.equals("YES")  ){
        
        Main.adminPositions.set(Main.crntusrsrcindex,test);
        
        System.out.println("\nData has been updated.\n\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
        
    
    else{
        
        
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
    
   
} 

else if (Main.crntusrsrcrole == 2) {
    System.out.println("\nUpdate employee position\n\nCurrent position: " + Main.managerPositions.get(Main.crntusrsrcindex)+"\n\nEnter new position");
    test = input.nextLine();
    
    System.out.println("\n\nType Yes to complete or anything else to cancel");
    temp = input.nextLine();
    
    if(temp.equals("yes") || temp.equals("Yes") || temp.equals("YES")  ){
        
        Main.managerPositions.set(Main.crntusrsrcindex,test);
        
        System.out.println("\nData has been updated.\n\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
        
    
    else{
        
        
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
}

else {
    System.out.println("\nUpdate employee position\n\nCurrent position: " + Main.employeePositions.get(Main.crntusrsrcindex)+"\n\nEnter new position");
    test = input.nextLine();
    
    System.out.println("\n\nType Yes to complete or anything else to cancel");
    temp = input.nextLine();
    
    if(temp.equals("yes") || temp.equals("Yes") || temp.equals("YES")  ){
        
        Main.employeePositions.set(Main.crntusrsrcindex,test);
        
        System.out.println("\nData has been updated.\n\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
        
    
    else{
        
        
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
}
                    
                    
                    case "5":
                    
                    
                    if (Main.crntusrsrcrole == 1) {
    System.out.println("\nAccount enable or disable\n\nCurrent Status: " + Main.adminStatus.get(Main.crntusrsrcindex)+"\n\nEnter new status (eg: true or false)");
    test = input.nextLine();
    
    System.out.println("\n\nType Yes to complete or anything else to cancel");
    temp = input.nextLine();
    
    if(temp.equals("yes") || temp.equals("Yes") || temp.equals("YES")  ){
        
        Main.adminStatus.set(Main.crntusrsrcindex,test);
        
        System.out.println("\nData has been updated.\n\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
        
    
    else{
        
        
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
    
   
} 

else if (Main.crntusrsrcrole == 2) {
    System.out.println("\nAccount enable or disable\n\nCurrent Status: " + Main.managerStatus.get(Main.crntusrsrcindex)+"\n\nEnter new status (eg: true or false)");
    test = input.nextLine();
    
    System.out.println("\n\nType Yes to complete or anything else to cancel");
    temp = input.nextLine();
    
    if(temp.equals("yes") || temp.equals("Yes") || temp.equals("YES")  ){
        
        Main.managerStatus.set(Main.crntusrsrcindex,test);
        
        System.out.println("\nData has been updated.\n\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
        
    
    else{
        
        
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
}

else {
    System.out.println("\nAccount enable or disable\n\nCurrent Status: " + Main.employeeStatus.get(Main.crntusrsrcindex)+"\n\nEnter new status (eg: true or false)");
    test = input.nextLine();
    
    System.out.println("\n\nType Yes to complete or anything else to cancel");
    temp = input.nextLine();
    
    if(temp.equals("yes") || temp.equals("Yes") || temp.equals("YES")  ){
        
        Main.employeeStatus.set(Main.crntusrsrcindex,test);
        
        System.out.println("\nData has been updated.\n\nEnter anything to return home");
       
    temp = input.nextLine();
    
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
        
    
    else{
        
        
        all2.homePage(Main.username);
        all.clearHistory();
        
        
        }
        
}
                    
                    
                    
                    case "H":
                     
                    all2.homePage(Main.username);
                    
                    
                    case "h":
                     
                    all2.homePage(Main.username);
                    
                    
                    default:
                     
                  
                    
                    }
                
                
                
               }
                
                
              
                
                
                
                public void addEmployee(){
                    
                    Scanner input=new Scanner(System.in);
                    Home all=new Home();
                    Operation all2 = new Operation();
                    Extra all3= new Extra();
                    String eid;
                    String ename;
                    String eposition;
                    String eemail;
                    String epassword;
                    String esallery;
                    String temp;
         
                    System.out.println("\nAdd an employee\n\nNOTE: Enter H to cancel & return home at any time\n");
                    System.out.println("\nEnter employee id");
                    eid=input.nextLine();
                    if(eid.equals("H") || eid.equals("h")){
  
                       all.homePage(Main.username);
                       return;
                        }
                        
                       else if(eid.equals("")){
                        all3.clearHistory();
                       System.out.println("Input must not be empty");
  
                       all2.addEmployee();
                       return;
                        }
                       
                        
                    System.out.println("\nEnter employee position\n(Format eg: \nAdmin or\nManager>Finance Manager or\n Employee>Desk Officer)");
                    eposition=input.nextLine();
                    
                    if(eposition.equals("H") || eposition.equals("h")){
  
                       all.homePage(Main.username);
                       return;
                        }
                        
                         else if(eposition.equals("")){
                        all3.clearHistory();
                       System.out.println("Input must not be empty");
  
                       all2.addEmployee();
                       return;
                        }
                      
                        
                    System.out.println("\nEnter employee name");
                    ename=input.nextLine();
                    
                    if(ename.equals("H") || ename.equals("h")){
  
                       all.homePage(Main.username);
                       return;
                        }
                        
                         else if(ename.equals("")){
                        all3.clearHistory();
                       System.out.println("Input must not be empty");
  
                       all2.addEmployee();
                       return;
                        }
                        
                        
                        System.out.println("\nEnter salary amount");
                    esallery=input.nextLine();
                    
                    if(esallery.equals("H") || esallery.equals("h")){
  
                       all.homePage(Main.username);
                       return;
                        }
                        
                         else if(esallery.equals("")){
                        all3.clearHistory();
                       System.out.println("Input must not be empty");
  
                       all2.addEmployee();
                       return;
                        }
                        
                    
                    
                    System.out.println("\nEnter employee email");
                    eemail=input.nextLine();
                    if(eemail.equals("H") || eemail.equals("H")){
  
                       all.homePage(Main.username);
                        }
                        
                         else if(eemail.equals("")){
                        all3.clearHistory();
                       System.out.println("Input must not be empty");
  
                       all2.addEmployee();
                       return;
                        }
                        
                    System.out.println("\nEnter a temporary password");
                    epassword=input.nextLine();
                    if(epassword.equals("H") || epassword.equals("h")){
  
                       all.homePage(Main.username);
                       return;
                        }
                        
                         else if(epassword.equals("")){
                        all3.clearHistory();
                       System.out.println("Input must not be empty");
  
                       all2.addEmployee();
                       return;
                        }
           
                    
                    System.out.println("\nDouble check your details and type Yes to add data and type No to cancel");
                    temp=input.nextLine();
                    if(temp.equals("H") || temp.equals("H")){
  
                       all.homePage(Main.username);
                       return;
                        }
                        
                         else if(temp.equals("")){
                        all3.clearHistory();
                       System.out.println("Input must not be empty");
  
                       all2.addEmployee();
                       return;
                        }
                    
                    else if(temp.equals("no") || temp.equals("No") || temp.equals("NO")){
                        
                       all.homePage(Main.username);
                       return;
             
                        }
                        
                        
                        else if(temp.equals("yes") || temp.equals("Yes") || temp.equals("YES")){
                        
                        
                      
                     
                     if (eposition.contains("Admin")){
                         
                         Main.adminEmails.add(eemail);
                         Main.adminPasswords.add(epassword);
                         
                        Main.adminPositions.add(eposition);                         
                         Main.adminNames.add(ename);
                         Main.adminSalleries.add(esallery);
                         Main.adminIds.add(eid);
                          Main.adminStatus.add(eid);
                         
                         }
                         
                         
                      else if (eposition.contains("Manager")){
                         
                         Main.managerEmails.add(eemail);
                         Main.managerPasswords.add(epassword);
                         
                        Main.managerPositions.add(eposition);                         
                         Main.managerNames.add(ename);
                         Main.managerSalleries.add(esallery);
                         Main.managerIds.add(eid);
                          Main.managerStatus.add(eid);
                         
                         }
                       
                         else {
                         
                         Main.employeeEmails.add(eemail);
                         Main.employeePasswords.add(epassword);
                         
                        Main.employeePositions.add(eposition);                         
                         Main.employeeNames.add(ename);
                         Main.employeeSalleries.add(esallery);
                         Main.employeeIds.add(eid);
                          Main.employeeStatus.add(eid);
                         
                         }
                         System.out.println("\n\nEmployee data has been added.\n\nEnter anything to return home");
                     temp=input.nextLine();
                         
                         
                         
                         
                     
                      all.homePage(Main.username);
                      
          
                    return;
                    }
                    
                    else{
                        System.out.println("Wrong input.\nInput must be Yes or No.");
  
                       all2.addEmployee();
                       return;
                        
                        }
                }
                    
                    
                    
                
}
                
                
               
            
            
            
        
       