package emailapp;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	//Constructor to receive first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("Email Created: " + this.firstName +" " + this.lastName);
		
		//Call method asking for department - return dept
		this.department = setDepartment();
		//System.out.println("Department: " + this.department);
		
		//Call method that returns random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password: " + this.password);
		
		//Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		//System.out.println("Your email: " + email);
	}
	
	
	//Ask for dept
	private String setDepartment() {
		System.out.print("New worker: " + firstName + " " + lastName + "\nDepartment Codes: \n1 for Sales\n2 for Development\n3 for Account\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		if (deptChoice == 1) {return "sales";}
		else if (deptChoice == 2){return "dev";}
		else if (deptChoice == 3) {return "acct";}
		else {return "blank";}
	}
	
	
	
	//Generate random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for(int i = 0; i < length; i++) {
			int rand = (int) (Math.random() *passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String (password);
	}
	
	
	//Set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//Set Alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	
	
	//Change password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {return mailboxCapacity;}
	public String getAlternateEmail(){return alternateEmail;}
	public String getPassowrd() {return password;}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCompany email: " + email +
				"\nMailbox capacity: " + mailboxCapacity + "mb";
	}
	
}
