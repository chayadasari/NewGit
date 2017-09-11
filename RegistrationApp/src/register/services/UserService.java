package register.services;



import register.model.User;

public interface UserService 
{
	public  void addUser(User user) ;
		// TODO Auto-generated method stub
		
	 public boolean checkLogin(String username, String password);

	
}
