package net.blogjava.nokiaguy.kxw.actions;

import java.util.List;

import net.blogjava.nokiaguy.kxw.dao.interfaces.CityDAO;
import net.blogjava.nokiaguy.kxw.dao.interfaces.ProvinceDAO;
import net.blogjava.nokiaguy.kxw.entity.City;
import net.blogjava.nokiaguy.kxw.entity.Province;

import com.opensymphony.xwork2.ActionSupport;

public class CitiesAction extends ActionSupport
{
	private CityDAO cityDAO;
	private List<City> cities;
	private int provinceId;

	public void setProvinceId(int provinceId)
	{
		this.provinceId = provinceId;
	}

	public List<City> getCities()
	{
		return cities;
	}

	public void setCityDAO(CityDAO cityDAO)
	{
		this.cityDAO = cityDAO;
	}

	public String execute()
	{
		cities = cityDAO.getCities(provinceId);
		if (cities.size() > 0)
			return SUCCESS;
		else
			return "empty";
	}
}
