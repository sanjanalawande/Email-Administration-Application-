package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private int defaultPasswordLength = 10;
	private String companySuffix = "xyzcompany.com";
	
	
	
	//Constructor to receive the first and last name 
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
		
		// Call a method asking for department - return the department 
		
		this.department = setDepartment();
		//System.out.println("Department: " +this.department);
		
		
		//Call a method that returns a random password 
		
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password); 
		
		
		//Combine elements to generate email 
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
		//System.out.println("Your email is: " + email);
	}
	
	//Ask for department 
	
	private String setDepartment() {
		System.out.println("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\n"
				+ "Enter Department Code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) {
			return "Sales";
			}
		else if (depChoice == 2) {
			return "Development";
		}
		else if (depChoice == 3) {
			return "Accounting";
		}
		else {
			return "";
		}	
	}
	
	
	//Generate a random password 
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
		char[] password = new char[length];
		for(int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	
	
	//Set the mailbox capacity 
	
	public void setMailCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	
	//Set an  alternate email 
	
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	
	//Change the password
	
	public void changePassword(String password) {
		this.password = password;
		
	}
	
	public int getMailboxCapacity() { return mailboxCapacity;	}
	
	public String getAlternateEmail() { return alternateEmail;	}
	
	public String getPassword()	{	return password;	}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + 
				"\nCOMPANY NAME: " + email + 
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}
