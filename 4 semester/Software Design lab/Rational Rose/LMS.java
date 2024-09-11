//Source file: E:\\Rational Rose\\LMS.java


private class Librarian extends LibraryManagementSystem 
{
   
   /**
   @roseuid 5AAAC4F60281
    */
   public String Name;
   public int ID;
   private int Password;
   public void Verify_Librarian(){
	   
   }
}

private class Database extends LibraryManagementSystem 
{
   
   /**
   @roseuid 5AAAC4F602B0
    */
   public String Book;
   public void Add(){
	   
   }
   public void Delete(){
	   
   }
   public void update(){
	   
   }
   public void Search(){
	   
   }
}

private class Student extends LibraryManagementSystem 
{
   
   /**
   @roseuid 5AAAC4F602EE
    */
   public int ID;
   public int Name;
   public int amount;
   public void Check_Account(){
	   
   }
   public void get_Book(){
	   
   }
   private void Calc_Fine(){
	   
   }
   
}

private class Books extends LibraryManagementSystem 
{
   
   /**
   @roseuid 5AAAC4F6031D
    */
	public String Title;
	public String Author;
	private int ISBN;

   public void Reservation_status(){
	   
   }
   public void Feedback(){
	   
   }
   public void Book_Request(){
	   
   }
}

private class LibraryManagementSystem 
{
   
   /**
   @roseuid 5AAAC4F6036B
    */
   public String UserName;
   public String Password;
   public void Login(){
	   
   }
   public void Register(){
	   
   }
}
