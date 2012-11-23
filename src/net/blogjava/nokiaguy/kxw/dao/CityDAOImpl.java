package net.blogjava.nokiaguy.kxw.dao;

import java.util.List;

import net.blogjava.nokiaguy.kxw.dao.interfaces.CityDAO;
import net.blogjava.nokiaguy.kxw.entity.City;
import net.blogjava.nokiaguy.kxw.entity.Province;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class CityDAOImpl extends ParentDAO implements CityDAO
{
	public CityDAOImpl(HibernateTemplate template)
	{
		super(template);
	}

	@Override
	public List<City> getCities(int provinceId)
	{
		return template.find("from City where provinceId = ?",
				provinceId);
	}

}
