package net.blogjava.nokiaguy.kxw.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;


public class LogoutAction extends ActionSupport implements
		ServletRequestAware
{
	private HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;

	}

	public String execute()
	{
		
		HttpSession session = request.getSession();
		if(session != null)
			session.removeAttribute("email");
		return null;
	}
}
