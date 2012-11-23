package net.blogjava.nokiaguy.kxw.dao;

import java.io.Serializable;
import net.blogjava.nokiaguy.kxw.dao.interfaces.ParentDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class ParentDAOImpl implements ParentDAO
{
    HibernateTemplate template;
	public ParentDAOImpl(HibernateTemplate template)
	{
		this.template = template;
	}
	public Object getEntity(Class entityClass, Serializable id)
	{
		return template.get(entityClass, id);
	}
}
 