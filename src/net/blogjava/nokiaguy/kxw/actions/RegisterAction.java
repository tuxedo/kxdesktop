package net.blogjava.nokiaguy.kxw.actions;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import net.blogjava.nokiaguy.kxw.entity.User;
import net.blogjava.nokiaguy.kxw.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<User>,
		SessionAware
{
	private User user = new User();
	private UserServiceImpl userService;
	private Map<String, Object> session;
	private String msg;
	private boolean success;

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
			userService.addUser(user);
			success = true;
			msg = "注册成功";
		}
		catch (Exception e)
		{
			success = false;
			msg = "注册失败";
		}
		return "result";
	}
}
