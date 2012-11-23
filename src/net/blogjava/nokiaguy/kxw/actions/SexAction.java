package net.blogjava.nokiaguy.kxw.actions;

import java.util.List;

import net.blogjava.nokiaguy.kxw.dao.interfaces.SexDAO;
import net.blogjava.nokiaguy.kxw.entity.Sex;
import com.opensymphony.xwork2.ActionSupport;

public class SexAction extends ActionSupport
{
	private SexDAO sexDAO;
	private List<Sex> sex;

	public List<Sex> getSex()
	{
		return sex;
	}

	public void setSexDAO(SexDAO sexDAO)
	{
		this.sexDAO = sexDAO;
	}

	public String execute()
	{
		sex = sexDAO.getSex();		
		return SUCCESS;
	}
}
