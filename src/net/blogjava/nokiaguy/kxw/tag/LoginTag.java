package net.blogjava.nokiaguy.kxw.tag;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LoginTag extends SimpleTagSupport
{

	@Override
	public void doTag() throws JspException, IOException
	{
		PageContext pageContext = (PageContext) this.getJspContext(); 
		HttpSession session = pageContext.getSession();
		String email =(String) session.getAttribute("email");
		String bodyText = "";		
		if(email == null)
		{
			bodyText += "<script type='text/javascript'>";
			bodyText += "login.show();";
			bodyText += "</script>";
		}
		else
		{
			bodyText += "<script type='text/javascript'>bLogin = true;welcomeMsg = '欢迎";
			bodyText += email + "';</script>";			

		}
		    
		pageContext.getOut().write(bodyText); 
	}}
