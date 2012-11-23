package net.blogjava.nokiaguy.kxw.actions;

import java.util.List;

import net.blogjava.nokiaguy.kxw.dao.interfaces.SexDAO;
import net.blogjava.nokiaguy.kxw.dao.interfaces.StatusDAO;
import net.blogjava.nokiaguy.kxw.entity.Sex;
import net.blogjava.nokiaguy.kxw.entity.Status;

import com.opensymphony.xwork2.ActionSupport;

public class StatusAction extends ActionSupport
{
	private StatusDAO statusDAO;
	private List<Status> status;

	public List<Status> getStatus()
	{
		return status;
	}

	public void setStatusDAO(StatusDAO statusDAO)
	{
		this.statusDAO = statusDAO;
	}

	public String execute()
	{
		status = statusDAO.getStatus();
		return SUCCESS;
	}
}
