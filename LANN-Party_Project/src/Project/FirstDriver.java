/**
 * File: FirstDriver.java
 * 
 * LANN-Party
 * 
 * @author LANN-Party
 * @version: 3/20/2017
 */

package Project;


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
  adminUI.addSchool("Weird1", "Alaska", "Fairbanks", "PRIVATE", 200, .9, 600, 600, 100, .9, 5, 1, 1, 10, 10, 10);
  adminUI.addSchool("Weird2", "Alaska", "Nome", "PRIVATE", 400, .85, 580, 570, 800, .85, 7, 1, 1, 10, 10, 10);
  adminUI.addSchool("Weird3", "Wyoming", "Sheridan", "PUBLIC", 700, .7, 400, 570, 2000, .85, 6, .9, .9, 8, 8, 8);
  studentUI.viewRecSchools("Weird1");
  adminUI.removeSchool("Weird1");
  adminUI.removeSchool("Weird2");
  adminUI.removeSchool("Weird3");
  //U6 search schools
  System.out.println();
  System.out.println("Search Results:");
  studentUI.searchSchool(null, "CALIFORNIA", null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
  System.out.println();
  System.out.println("Recommended Schools:");
  studentUI.viewRecSchools("AUGSBURG");
  
  /*
  //U8 save school
  studentUI.saveSchool("ajmac", "AUGSBURG");
  studentUI.saveSchool("ajmac", "ADELPHI");
  
  //U4 view saved schools
  System.out.println();
  System.out.println("Saved Schools:");
  studentUI.viewSavedSchools("ajmac");
  
  //U5 remove school
  studentUI.removeSchool("ajmac", "AUGSBURG");
  System.out.println();
  System.out.println("Saved Schools after remove:");
  studentUI.viewSavedSchools("ajmac");
  
  //U19 logout
  System.out.println();
  login.studentLogout("ajmac");
  
  System.out.println();
  
  login.logon("nadmin", "admin", true);
  
  System.out.println();
  //FIX getUsers() in dbcontroller based on getUser()
  adminUI.viewusers();
  
  System.out.println();
  
  //U16 add university
  adminUI.addSchool("Saint Johns University", "Minnesota", "Collegeville", "Private", 2000, 0.0, 
                    0, 0, 50000, 0.20, 400, 0.9, 0.7, 4, 4, 3);
  
  //U17 view university
  adminUI.viewSchool("Saint Johns University");
  
  System.out.println();
  //U18 edit university
  adminUI.editSchool("Saint Johns University", "Minnesota", "Collegeville", "Private", 2000, 0.0, 
                    550, 500, 60000, 0.20, 500, 0.9, 0.7, 2, 4, 3);
  adminUI.viewSchool("Saint Johns University");
  
  //U20 add emphasis
  adminUI.addEmphasis("Saint Johns University", "Biology");
  adminUI.addEmphasis("Saint Johns University", "Accounting");
  System.out.println();
  adminUI.getEmphases("Saint Johns University");
  
  System.out.println();
  
  adminUI.viewSchool("Saint Johns University");
  
  System.out.println();
  //U21 remove emphasis
  adminUI.removeEmphasis("Saint Johns University", "Biology");
  adminUI.removeEmphasis("Saint Johns University", "Accounting");
  adminUI.viewSchool("Saint Johns University");
  
  
  System.out.println();
  if(adminUI.removeSchool("Saint Johns University"))
	  System.out.println("School is removed");
  
  System.out.println();
  
  adminUI.viewSchools();
  
  
  
  
  System.out.println();
  if(adminUI.deactivateUser("ajmac"))
	  System.out.println("User deactivated");
  adminUI.veiwUser("ajmac");
  
  System.out.println();
  System.out.println("Added User:");
  adminUI.addUser("nhynes", "Noah", "Hynes-Marquette", "loser", 'u', 'y');
  adminUI.veiwUser("nhynes");
  System.out.println();
  
  System.out.println("User edited:");
  adminUI.editUser("nhynes", "Noah", "Dahlquist", "loser", 'u', 'y');
  adminUI.veiwUser("nhynes");
  System.out.println();
  if(adminUI.deleteUser("nhynes"))
	  System.out.println("User deleted");
  
  System.out.println();
  login.adminLogout("nadmin");
  */
 }
 
 
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  FirstDriver fD = new FirstDriver();
  fD.run();
 }

}