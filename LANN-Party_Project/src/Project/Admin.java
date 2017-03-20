package Project;
/**
 * FileName: Admin.java
 */

/**
 * @author Logan Dahlquist
 * @version 2/26/17
 *
 */
public class Admin {
	
	//Data fields
		/**The Admin's first name (String)*/
	String firstName;
	
	//Data fields
		/**The Admin's Last name (String)*/
	String lastName;
	
	//Data fields
		/**The Admin's username (String)*/
	String userName;
	
	//Data fields
		/**The Admin's password (String)*/
	String password;
	
	//Data fields
		/**The user's type to confirm they are an admin (char)*/
	char type;
	
	//Data fields
		/**The Admin's current status (for stealing sessions) (char)*/
	char status;
	
	//Data fields
		/**to determine if the Admin has logged in (boolean)*/
	boolean logon;

		/**
		 * Returns the Admin's first name
		 * 
		 * @return the firstName
		 */
		public String getFirstName() {
			return firstName;
		}

		/**
		 * sets the Admin's first name
		 * 
		 * @param firstName the firstName to set
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		/**
		 * returns the Admin's last name
		 * 
		 * @return the lastName
		 */
		public String getLastName() {
			return lastName;
		}

		/**
		 * sets the admin's last name
		 * 
		 * @param lastName the lastName to set
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		/**
		 * Returns the admin's userName
		 * 
		 * @return the userName
		 */
		public String getUserName() {
			return this.userName;
		}

		/**
		 * sets the admin's userName
		 * 
		 * @param userName the userName to set
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}

		/**
		 * Returns the admin's password
		 * 
		 * @return the password
		 */
		public String getPassword() {
			return this.password;
		}

		/**
		 * sets the admin's password
		 * 
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}

		/**
		 * Returns the admin's type to confirm they are an admin
		 * 
		 * @return the type
		 */
		public char getType() {
			return this.type;
		}

		/**
		 * sets the admin's type
		 * 
		 * @param type the type to set
		 */
		public void setType(char type) {
			this.type = type;
		}

		/**
		 * Returns the admin's session status
		 * 
		 * @return the status
		 */
		public char getStatus() {
			return this.status;
		}

		/**
		 * sets the admin's session status
		 * 
		 * @param status the status to set
		 */
		public void setStatus(char status) {
			this.status = status;
		}

		/**
		 * Returns the admin's logon status
		 * 
		 * @return the logon
		 */
		public boolean isLogon() {
			return this.logon;
		}

		/**
		 * sets the admin's logon status
		 * 
		 * @param logon the logon to set
		 */
		public void setLogon(boolean logon) {
			this.logon = logon;
		}
		
		/**
		 * @param firstName
		 * @param lastName
		 * @param userName
		 * @param password
		 * @param type
		 * @param status
		 * @param logon
		 */
		public Admin(String firstName, String lastName, String userName, String password, char type, char status,
				boolean logon) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.userName = userName;
			this.password = password;
			this.type = type;
			this.status = status;
			this.logon = logon;
		}
}
