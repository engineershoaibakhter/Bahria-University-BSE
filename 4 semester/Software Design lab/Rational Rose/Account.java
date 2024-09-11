//Source file: E:\\Rational Rose\\Account.java


public class Account 
{
   public Student theStudent;
   public Registration theRegistration;
   private String StudentID;
   
   /**
   @roseuid 5AAAC41B01E5
    */
    public void CreateAccount(){

    }
   public Account() 
   {
    
   }
}

private class Course 
{
   private String CourseCode;
   private int Date;
   private String Instructor;
   public void CreateCourse(){

   }
   public void DropCourse(){
      
   }
   private Course(){

   }
}

private class Student 
{
   private String StudentID;
   private String Name;
   private int DateOfBirth;
   private String Email;
   private String ContactNo;
   public void CreateStudent(){
      
   }
   public void getStudentInfo(){
      
   }
   private Student(){

   }

}

private class Professor 
{
   private Integer StaffID;
   private String Department;
   public void CreateProfessor(){

   }
   public void getProfessorInfo(){
      
   }
   private Professor(){

   } 
}

private class Registration 
{
   public Course theCourse;
   public Professor theProfessor;
   private String AccountID;
   private String CourseCode;
   private String ExamID;
   private String grade;
   public void getRegistrationInfo(){
      
   }
}
