//Source file: E:\\Rational Rose\\School.java
public class School 
{
   /**
   @roseuid 5AAAC6190232
    */
    private String name;
    private String address;
    private int phone;
   public void addStudent() 
   {
    
   }
   public void removeStudent() 
   {
    
   }
   public void getStudent() 
   {
    
   }
   public void getAllStudents() 
   {
    
   }
   public void addDepartment() 
   {
    
   }
   public void removeDepartment() 
   {
    
   }
   public void getDepartment() 
   {
    
   }
   public void getAllDepartments() 
   {
    
   }
}

private class Student 
{
   public School theSchool;
   public Course theCourse;
   private String name;
   private int studentID;
}

private class Instructor 
{
   public Course theCourse;
   public Department theDepartment;
   private String name;
}

private class Course 
{
   public Department theDepartment;
   private String name;
   private int courseID;
}

private class Department 
{
   public School theSchool;
   public Instructor theInstructor;
   private String name;
   public void addInstructor(){

   }
   public void removeInstructor(){
      
   }
   public void getInstructor(){
      
   }
   public void getAllInstructors(){
      
   }
}
