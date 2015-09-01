package com.sobit.webeq.services.dao.data.users;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.sobit.webeq.entities.Users;
 
import com.sobit.webeq.services.util.HibernateUtil;
 
public class UsersDAO {
 
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		 
		public UsersDAO() {
		 
		}
		public List<Users> getUsers()
		 
		{
		 
		Session s=sessionFactory.openSession();
		 
		List<Users> users= s.createCriteria(Users.class).list();
		 
		s.close();
		return users;
		 
		}
		 
		public Users getUsers(int id)
		 
		{
		 
		Session s=sessionFactory.openSession();
		 
		Criteria cr=s.createCriteria(Users.class);
		 
		cr.add(Restrictions.eq("id", id));
		 
		Users users=(Users) cr.list().get(0);
		 
		s.close();
		return users;
		 
		}
		 
		}