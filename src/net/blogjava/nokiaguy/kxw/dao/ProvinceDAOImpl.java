package net.blogjava.nokiaguy.kxw.dao;

import java.util.List;

import net.blogjava.nokiaguy.kxw.dao.interfaces.ProvinceDAO;
import net.blogjava.nokiaguy.kxw.entity.Province;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class ProvinceDAOImpl extends ParentDAO implements ProvinceDAO
{
	public ProvinceDAOImpl(HibernateTemplate template)
	{
		super(template);
	}

	@Override
	public List<Province> getProvinces()
	{
		return template.find("from Province");
	}

}
