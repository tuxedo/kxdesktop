package net.blogjava.nokiaguy.kxw.dao;

import java.util.List;

import net.blogjava.nokiaguy.kxw.dao.interfaces.SexDAO;
import net.blogjava.nokiaguy.kxw.entity.City;
import net.blogjava.nokiaguy.kxw.entity.Sex;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class SexDAOImpl extends ParentDAO implements SexDAO
{
	public SexDAOImpl(HibernateTemplate template)
	{
		super(template);
	}

	@Override
	public List<Sex> getSex()
	{		
		return template.find("from Sex");
	}


}
