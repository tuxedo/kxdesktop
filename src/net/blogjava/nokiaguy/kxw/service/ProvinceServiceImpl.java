package net.blogjava.nokiaguy.kxw.service;

import java.util.ArrayList;
import java.util.List;

import net.blogjava.nokiaguy.kxw.dao.interfaces.CityDAO;
import net.blogjava.nokiaguy.kxw.dao.interfaces.ProvinceDAO;
import net.blogjava.nokiaguy.kxw.entity.City;
import net.blogjava.nokiaguy.kxw.entity.Province;
import net.blogjava.nokiaguy.kxw.service.interfaces.ProvinceService;

public class ProvinceServiceImpl implements ProvinceService
{
	private CityDAO cityDAO;
	private ProvinceDAO provinceDAO;

	public ProvinceServiceImpl(CityDAO cityDAO, ProvinceDAO provinceDAO)
	{
		this.cityDAO = cityDAO;
		this.provinceDAO = provinceDAO;
	}

	@Override
	public List<Province> getProvinces()
	{
		List<Province> provinces = new ArrayList<Province>();
		List<City> cities = cityDAO.getCities(0);
		Province province = null;
		for (City city : cities)
		{
			province = new Province();
			province.setId(city.getId());
			province.setName(city.getName());
			provinces.add(province);
		}
		provinces.addAll(provinceDAO.getProvinces());
		return provinces;
	}
}
