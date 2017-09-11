package register.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import register.dao.UserDao;
import register.model.User;

@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUser(User user)
	{
		System.out.println(user);
		userDao.addUser(user);
		}
		
	

	   public void setLoginDAO(UserDao userDao) {
              this.userDao = userDao;
       }
      
       public boolean checkLogin(String username, String password){
              System.out.println("In Service class...Check Login");
              return userDao.checkLogin(username, password);
       }
}


