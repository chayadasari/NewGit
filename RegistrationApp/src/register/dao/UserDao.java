package register.dao;

import java.util.List;

import register.model.User;



public interface UserDao 
{
	public void addUser(User user);

	  
    public boolean checkLogin(String username, String password);
	
	
}
