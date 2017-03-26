/**
 * File: FirstDriver.java
 * 
 * LANN-Party
 * 
 * description: The first driver for the project
 * version: 3/20/2017
 */

package Project;

//////Use cases needed//////
/**
 * U7 search results
 * U9 view recommended schools
 * U10 view users
 * U11 view user
 * U12 add user
 * U13 edit user
 * U14 deactivate user
 * U15 view universities
 * U16 add university
 * U17 view university
 * U18 edit university
 * U20 add emphasis
 * U21 remove emphasis
 */

public class FirstDriver {

 private LoginUI login = new LoginUI();
 private AdminUI adminUI = new AdminUI();
 private StudentUserInterface studentUI = new StudentUserInterface();
 
 public FirstDriver(){
  super();
 }
 
 public void run(){
  //Registration
  login.registerStudent("Andrew", "McIntyre", "ajmac", "password", 'u', 'n');
  
  //U1 Login
  login.logon("ajmac", "password", true);
  
  /**
  if(login.registerStudent("Andrew", "McIntyre", "ajmac", "password", 'u', 'n')){
   login.logon("ajmac", "password", true);
  }
  else{
   System.out.println("Registration Failed");
   System.exit(0); //TODO change this later
  }
  **/
  
  //U2 View Profile
  studentUI.viewProfile("ajmac");
  
  //U3 edit profile
  studentUI.editInfo("ajmac", "Bob", "McIntyre", "password", 'u', 'n');
  studentUI.viewProfile("ajmac");
  studentUI.editInfo("ajmac", "Andrew", "McIntyre", "password", 'u', 'n');
  
  //U6 search schools
  studentUI.searchSchool("AUGSBURG");
  
  //U8 save school
  studentUI.saveSchool("ajmac", "AUGSBURG");
  studentUI.saveSchool("ajmac", "ADELPHI");
  
  //U4 view saved schools
  studentUI.viewSavedSchools("ajmac");
  
  //U5 remove school
  studentUI.removeSchool("ajmac", "AUGSBURG");
  studentUI.viewSavedSchools("ajmac");
  
  //U19 logout
  login.studentLogout("ajmac");
  
  login.logon("nadmin", "admin", true);
  //FIX getUsers() in dbcontroller based on getUser()
  adminUI.viewusers();
  
  //U16 add university
  adminUI.addSchool("Saint Johns University", "Minnesota", "Collegeville", "Private", 2000, 0.0, 
                    0, 0, 50000, 0.20, 400, 0.9, 0.7, 4, 4, 3);
  
  //U17 view university
  adminUI.viewSchool("Saint Johns University");
  
  //U18 edit university
  adminUI.editSchool("Saint Johns University", "Minnesota", "Collegeville", "Private", 2000, 0.0, 
                    550, 500, 60000, 0.20, 500, 0.9, 0.7, 2, 4, 3);
  adminUI.viewSchool("Saint Johns University");
  
  //U20 add emphasis
  adminUI.addEmphasis("Saint Johns University", "Biology");
  adminUI.addEmphasis("Saint Johns University", "Accounting");
  adminUI.viewSchool("Saint Johns University");
  
  //U21 remove emphasis
  adminUI.removeEmphasis("Saint Johns University", "Biology");
  adminUI.viewSchool("Saint Johns University");
  
 }
 
 
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  FirstDriver fD = new FirstDriver();
  fD.run();
 }

}