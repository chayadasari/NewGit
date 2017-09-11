package register.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.Session;
import org.hibernate.SQLQuery;

import java.util.List;
import register.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao 
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) 
	{
		System.out.println("gsx");
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	/* @Resource(name="sessionFactory")
     protected SessionFactory sessionFactory;*/

     public void setSessionFactory(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
     }
    
     protected Session getSession(){
            return sessionFactory.openSession();
     }

     public boolean checkLogin(String username, String password)
     {
			System.out.println("In Check login");
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			//Query using Hibernate Query Language
			String SQL_QUERY =" select username ,password from user_info  where username=? and password=?";
			SQLQuery query = session.createSQLQuery(SQL_QUERY);
			
			query.setParameter(0,username);
			query.setParameter(1,password);
			List list = query.list();
			System.out.println(list);
			if ((list != null) && (list.size() > 0)) {
				System.out.println("IN DAO");
				userFound= true;
			}
			else
			{
				return false;
			}

			session.close();
			return true;    
     }
		
}
