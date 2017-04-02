package Project;
import java.util.*;
	/**
	 * FileName: Student.java
	 */
	
	/**
	 * Class dedicated to users who are Students
	 * @author Logan Dahlquist
	 * @version 3/27/2017
	 *
	 */
	public class Student {
		//Data fields
			/**The Student's first name (String)*/
		private String firstName;
		
		//Data fields
			/**The Student's last name (String)*/
		private String lastName;
		
		//Data fields
			/**The Student's user name (String)*/
		private String userName;
		
		//Data fields
			/**The Student's password (String)*/
		private String password;
		
		//Data fields
			/**The Student's Type: Default U (Char)*/
		private char type;
		
		//Data fields
			/**The Student's Current session status(char)*/
		private char status;
		
		//Data fields
			/**The Student's Saved Schools (ArrayList<String>)
			 * currently a ArrayList<String> due to unknown variable
			 * type as of 2/26/17
			 * please change later */
		private ArrayList<String> savedSchools;
		
		//Data fields
			/**The Student's logon status (Boolean)*/
		private boolean logon; 
		
		
			/**
			 * Creates a new Student, with the given inputs
				 * @param firstName
				 * @param lastName
				 * @param userName
				 * @param password
				 * @param type
				 * @param status
				 * @param savedSchools
				 * @param logon
				 */
		public Student(String firstName, String lastName, String userName, String password, char type, char status,
				ArrayList<String> savedSchools) {
					super();
					this.firstName = firstName;
					this.lastName = lastName;
					this.userName = userName;
					this.password = password;
					this.type = type;
					this.status = status;
					this.savedSchools = savedSchools;
					this.logon = false;
				}

		/**
		 * Return's the Student's first name
		 * 
		 * @param none
		 * @returns firstName
		 */
		public String getFirstName()
		{
			return this.firstName;
		}
		
		/**
		 * Return's the Student's Last name
		 * 
		 * @param none
		 * @returns lastName
		 */
		public String getLastName()
		{
			return this.lastName;
		}
		
		/**
		 * Return's the Student's User name
		 * 
		 * @param none
		 * @returns username
		 */
		public String getUserName()
		{
			return this.userName;
		}
		
		/**
		 * Return's the Student's type
		 * 
		 * @param none
		 * @returns type
		 */
		public char getType()
		{
			return this.type;
		}
		
		/**
		 * Return's the Student's Password
		 * 
		 * @param none
		 * @returns password
		 */
		public String getPassword()
		{
			return this.password;
		}
		
		/**
		 * Sets the Student's First Name
		 * 
		 * @param String new first name to be set
		 */
		public void setFirstName(String newfName)
		{
			this.firstName = newfName;
		}
		
		/**
		 * Sets the Student's Last Name
		 * 
		 * @param String lew last name to be set
		 */
		public void setLastName(String newlName)
		{
			this.lastName = newlName;
		}
		
		/**
		 * Sets the Student's Password
		 * 
		 * @param String new password to be set
		 */
		public void setPassword(String pass)
		{
			this.password = pass;
		}
		
		/**
		 * Sets the Student's Type
		 * 
		 * @param String new type to be set
		 */
		public void setType(char type)
		{
			this.type = type;
		}
		
		/**
		 * Sets the Student's Stat
		 * 
		 * @param String new status to be set
		 */
		public void setStatus(char stat)
		{
			this.status = stat;
		}
		

		/**
		 * gets the Student's Stat
		 * 
		 * @returns status of Student 
		 */
		public char getStatus()
		{
			return this.status;
		}
		

		/**
		 * Get's the students saved schools
		 * 
		 * @returns firstName
		 */
		public ArrayList<String> getSavedSchools()
		{
			return this.savedSchools;
		}
		
		/**
		 * Sets the Student's saved schools
		 * 
		 * @param ArrayList<String> list of saved schools
		 */
		public void setSavedSchools(ArrayList<String> schools)
		{
			this.savedSchools = schools;
		}
		
		/**
		 * Adds a school to saved schools
		 * 
		 * @param String school to add
		 */
		public void addSchool(String school)
		{
			this.savedSchools.add(school);
		}
		
		/**
		 * Updates the students info
		 * 
		 * @param String the username, fNam, pWord
		 * @param char Type, Status
		 */
		public void updateInfo(String uName, String fName, String lName, String pWord, char type, char status)
		{
			this.userName = uName;
			this.setFirstName(fName);
			this.setLastName(lName);
			this.setType(type);
			this.setStatus(status);
		}
		
		/**
		 * Checks if Student is logged in
		 * 
		 * @param none
		 * @return boolean logon
		 */
		public boolean isLoggedOn()
		{
			return this.logon;
		}
		
		/**
		 * Checks if Student is logged in
		 * 
		 * @param boolean log
		 */
		public void setLogon(boolean log )
		{
			this.logon = log;
		}
		
		/**
		 * Removes school from saved schools
		 * 
		 * @param String school to remove
		 */
		public void removeSchool(University school)
		{
			int index = this.savedSchools.lastIndexOf(school);
			if (index > -1)
				this.savedSchools.remove(index);
			
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return this.getFirstName()+","+this.getLastName()+","+this.getUserName()+","+this.getPassword()
			+","+this.getType();
		}
		
		
		
	}
