package net.blogjava.nokiaguy.kxw.dao.interfaces;

import java.util.List;

import net.blogjava.nokiaguy.kxw.entity.City;

public interface CityDAO
{
    public List<City> getCities(int provinceId);
}
