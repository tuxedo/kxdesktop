package net.blogjava.nokiaguy.kxw.actions;

import java.util.List;
import net.blogjava.nokiaguy.kxw.entity.Province;
import net.blogjava.nokiaguy.kxw.service.interfaces.ProvinceService;
import com.opensymphony.xwork2.ActionSupport;

public class ProvincesAction extends ActionSupport
{
	private ProvinceService provinceService;
	private List<Province> provinces;

	public List<Province> getProvinces()
	{
		return provinces; 
	}

	public void setProvinceService(ProvinceService provinceService)
	{
		this.provinceService = provinceService;
	}

	public String execute()
	{

		provinces = provinceService.getProvinces();
		return SUCCESS;
	}
}
