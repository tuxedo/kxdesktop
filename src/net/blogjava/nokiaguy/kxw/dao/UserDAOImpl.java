package net.blogjava.nokiaguy.kxw.dao;

import java.util.List;
import net.blogjava.nokiaguy.kxw.dao.interfaces.UserDAO;
import net.blogjava.nokiaguy.kxw.entity.User;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class UserDAOImpl extends ParentDAOImpl implements UserDAO
{

	public UserDAOImpl(HibernateTemplate template)
	{
		super(template);
	}

	@Override
	public String getPassword(User user)
	{
	    List<String> password = template.find("select password from User where email=?", user.getEmail());
	    if(password.size() > 0)
	    {
	    	return password.get(0);
	    }
		return null;
	}

	@Override
	public void addUser(User user)
	{
		template.saveOrUpdate(user);
	}
}
