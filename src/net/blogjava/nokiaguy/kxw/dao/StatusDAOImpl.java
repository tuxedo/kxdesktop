package net.blogjava.nokiaguy.kxw.dao;

import java.util.List;

import net.blogjava.nokiaguy.kxw.dao.interfaces.StatusDAO;
import net.blogjava.nokiaguy.kxw.entity.Status;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class StatusDAOImpl extends ParentDAO implements StatusDAO
{
	public StatusDAOImpl(HibernateTemplate template)
	{
		super(template);
	}

	@Override
	public List<Status> getStatus()
	{		
		return template.find("from Status");
	}


}
