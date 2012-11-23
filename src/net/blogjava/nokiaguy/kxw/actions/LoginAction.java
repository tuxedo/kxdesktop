package net.blogjava.nokiaguy.kxw.actions;

import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import net.blogjava.nokiaguy.kxw.dao.interfaces.DesktopIconDAO;
import net.blogjava.nokiaguy.kxw.data.DesktopIconsDefinition;
import net.blogjava.nokiaguy.kxw.entity.DesktopIcon;
import net.blogjava.nokiaguy.kxw.entity.User;
import net.blogjava.nokiaguy.kxw.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>,
		SessionAware, ServletRequestAware, ServletResponseAware
{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private User user = new User();
	private UserServiceImpl userService;
	private DesktopIconDAO desktopIconDAO;
	private Map<String, Object> session;
	private String javascript = "";
	private String msg;
	private boolean success;

	public void setDesktopIconDAO(DesktopIconDAO desktopIconDAO)
	{
		this.desktopIconDAO = desktopIconDAO;
	}

	public String getJavascript()
	{
		return javascript;
	}

	public boolean isSuccess()
	{
		return success;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}

	@Override
	public User getModel()
	{
		return user;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setUserService(UserServiceImpl userService)
	{
		this.userService = userService;
	}

	@Override
	public void setServletResponse(HttpServletResponse response)
	{
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;

	}

	public String execute()
	{
		try
		{
			String sessionValidationCode = (String) session
					.get("validationCode");

			if (!user.getValidationCode().equalsIgnoreCase(
					sessionValidationCode))
			{
				success = false;
				msg = "校验码错误!";
				return "result";
			}
			if (userService.verifyUser(user))
			{
				success = true;
				int time = 0;
				switch (user.getLoginStateId())
				{
					case 1:
						time = 24 * 3600;
						break;
					case 2:
						time = 24 * 3600 * 7;
						break;
					case 3:
						time = 24 * 3600 * 30;
						break;
					case 4:
						time = 24 * 3600 * 365;
						break;
				}
				if (time > 0)
				{
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(time);
					session.setAttribute("email", user.getEmail());
					Cookie cookie = new Cookie("JSESSIONID", session.getId());
					cookie.setMaxAge(time);
					response.addCookie(cookie);
				}				
				DesktopIcon desktopIcon = desktopIconDAO.getDesktopIcon(user
						.getEmail());				
				if (desktopIcon != null)
				{
					javascript = DesktopIconsDefinition
					.getShowDesktopIconsJavaScriptFunction(desktopIcon, true);					
					javascript = java.net.URLEncoder.encode(javascript, "utf-8");
				}				
				msg = "成功登录";   
  
			}
			else
			{
				success = false;
				msg = "登录失败！";

			}

		}
		catch (Exception e)
		{

			success = false;
			msg = "登录失败";
			System.out.println(e.getMessage());
		}
		return "result";
	}
}
