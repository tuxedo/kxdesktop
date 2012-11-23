package net.blogjava.nokiaguy.kxw.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.opensymphony.xwork2.ActionSupport;

public abstract class ParentAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware
{
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected String email;

	@Override
	public void setServletResponse(HttpServletResponse response)
	{
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;
		this.session = request.getSession();
		this.email = (String) session.getAttribute("email");

	}

	public String process()
	{
		return null;
	}

	public String execute()
	{
		if (email != null)
			return process();
		else
			return null;
	}
}
