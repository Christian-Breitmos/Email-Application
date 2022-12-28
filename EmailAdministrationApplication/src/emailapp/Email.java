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
    private String companySuffix = "aeycompany.com";

    //Constructor to receive the first and last name
        public Email(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
//            System.out.println("Email Created: " + this.firstName + " " + this.lastName); Deleted due to Redundancy

            //Call a method asking for the department - return the department
            this.department = setDepartment();
//            System.out.println("Department: " + this.department); Dont need to see department code due to it being in the email

            //Call a method that returns a random password
            this.password = randomPassword(defaultPasswordLength);
            System.out.println("Your Password is: " + this.password);

            //Combine elements to generate email
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
//            System.out.println("Your email is: " + email); Will be printed in the show info
        }
    //Ask for the department
        private String setDepartment(){
            System.out.print("New worker: " + firstName + "\nDepartment Codes:\n1 for Sales\n2 for Development\n3 for Accounting \n0 for none\nEnter department code: ");
            Scanner in = new Scanner(System.in);
            int depChoice = in.nextInt();
            if (depChoice == 1){
                return "Sales";
            }
            else if(depChoice == 2 ){
                    return "Development";
                }
            else if(depChoice == 3){
                return "Accounting";
            }
            else{
                return "";
            }
        }
    //Generate a random password
    private String randomPassword(int length){
            String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
            char [] password = new char[length];
            for(int i=0; i<length; i++){
               int rand = (int) (Math.random() * passwordSet.length());
               password[i] = passwordSet.charAt(rand);
            }
            return new String(password);
    }

    //Set the mailbox capacity
        public void setMailboxCapacity(int capacity){
            this.mailboxCapacity = capacity;
        }
    // set the alternate email
        public void setAlternateEmail(String altEmail){
            this.alternateEmail = altEmail;
        }
    //change the password
    public void changePassword(String password){
            this.password = password;
    }
    public int getMailboxCapacity (){
            return mailboxCapacity;
    }
    public String getAlternateEmail(){
            return alternateEmail;
    }
    public String getPassword(){
            return password;
    }

    //Method to show all the name, email address, mailbox capacity
    public String showInfo(){
            return "DISPLAY NAME: " + firstName + " " + lastName + "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
