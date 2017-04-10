/**
 * 
 */
package Project;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
/**
 * @author lrdahlquist
 *
 */
public class UCTest {
	LoginUI loginUI;
	StudentUserInterface studentUI;
	DatabaseController dbc;
	String uName = "case123";
	String pWord = "case123";
	String fName = "case";
	String lName = "tester";
	char type = 'u';
	char status= 'y';
	Student caseTester = new Student(fName, lName, uName, pWord, type, status, null);
	
	public void setup(){
		loginUI = new LoginUI();
		studentUI = new StudentUserInterface();
		dbc = new DatabaseController("lannp", "lannp","csci230");
		Student caseTester = new Student(fName, lName, uName, pWord, type, status, null);
	}
	
	public void teardown(){
		
	}
	
	/*
	 * tests login
	 */
	public void testUC1(){
		assertTrue(loginUI.logon("case123", "case123", true));
	}
	
	/*
	 * viewProfile Test
	 */
	public void testUC2(){
		String info = dbc.getUser(fName).toString();
		assertTrue(studentUI.viewProfile(fName).equals(info));
	}
	
	/*
	 * manage profile test
	 */
	public void testUC3_1editFirstName(){
		assertTrue(studentUI.editInfo(uName, "bob", lName, pWord, type, status));
		assertTrue(caseTester.getFirstName().equals("bob"));
	}
	public void testUC3_2editLastName(){
		assertTrue(studentUI.editInfo(uName, "bob", "theBuilder", pWord, type, status));
		assertTrue(caseTester.getFirstName().equals("bob"));
	}
	public void testUC3_3editPassword(){
		assertTrue(studentUI.editInfo(uName, "bob", "theBuilder", "case321", type, status));
		assertTrue(caseTester.getFirstName().equals("bob"));
	}
	
	/*
	 * manage Saved Schools (menu?)
	 */
	public void testUC5(){
		
	}
	
	public void testUC6(){
		
	}
	
	public void testUC7(){
		
	}
	
	public void testUC8(){
		
	}
	
	public void testUC9(){
		
	}
	
	public void testUC10(){
		
	}
	
	public void testUC11(){
		
	}
	
	public void testUC12(){
		
	}
	
	public void testUC13(){
		
	}
	
	public void testUC14(){
		
	}
	
	public void testUC15(){
		
	}
	
	public void testUC16(){
		
	}
	
	public void testUC17(){
		
	}
	
	public void testUC18(){
		
	}
	
	public void testUC19(){
		
	}
	
	public void testUC20(){
		
	}

	public void testUC21(){
		
	}

	public void testUC22(){
		
	}

	public void testUC23(){
		
	}

	public void testUC24(){
		
	}

	public void testUC25(){
		
	}
	

}
