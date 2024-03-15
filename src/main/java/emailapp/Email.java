
package emailapp;
import java.util.Scanner;

public class Email {
   private String firstName;
   private String lastName;
   private String password;
   private String email;
   private int defaultPasswordLength=10;
   private String department;
   private int mailboxCapacity=500;
   private String alternateEmail;
   private String companySuffix="aeycompany.com";
   
   //constructor to receive first and last name
   public Email(String firstName,String lastName){
       this.firstName=firstName;
       this.lastName=lastName;
      // System.out.println("email created : "+this.firstName + " " +this.lastName);
      
       //call method for asking dept--return department
       this.department=setDepartment();
       //System.out.println("department is : "+this.department);
       
       //call method for return a random password
       this.password=randomPassword(defaultPasswordLength);
       System.out.println("your password is : "+this.password);
      
       //combine elements to generate email
       email=firstName.toLowerCase()+ "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
       //System.out.println("Your email is : "+email);
   }
   //ask for the dept
   private String setDepartment(){
       System.out.println("New worker: " + firstName + " .Department codes:\n1 for Sales\n2 for development\n3 for Accounting\n0 for none");
       Scanner in=new Scanner(System.in);
       int depChoice=in.nextInt();
       if(depChoice==1){
           return "sales";
       }else if(depChoice==2){
           return "dev";
       }else if(depChoice==3){
           return "acct";
       }else{
           return " ";
       }
   }
   //generate random password
   private String randomPassword(int length){
       String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
       char[] password=new char[length];
       for (int i = 0; i <length; i++) {
        int rand=(int) (Math.random() *passwordSet.length());
        password[i]=passwordSet.charAt(rand);
       }
       return new String(password);
   }
   //set the mailbox capacity
   public void setMailboxCapacity(int capacity){
       this.mailboxCapacity=capacity;
   }
   //set alternative email
   public void setAlternateEmail(String altEmail){
       this.alternateEmail=altEmail;
   }
   //change password
   public void changePassword(String password){
       this.password=password;
   }
   public int getMailboxCapacity(){
       return mailboxCapacity;
   }
   public String getAlternateEmail(){
       return alternateEmail;
   }
   public String getPassword(){
       return password;
   }
   public String showInfo(){
       return "display name :" +firstName + " " + lastName + 
          "\ncompany email : " + email +
               "\nmailbox capacity :" +mailboxCapacity + "mb";
   }
}
