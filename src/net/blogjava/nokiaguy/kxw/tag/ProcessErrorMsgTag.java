package net.blogjava.nokiaguy.kxw.tag;

import java.io.IOException;
import java.io.StringWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ProcessErrorMsgTag extends SimpleTagSupport
{

	@Override
	public void doTag() throws JspException, IOException
	{
		PageContext pageContext = (PageContext) this.getJspContext(); 
		JspFragment fragment = this.getJspBody(); 
		StringWriter out = new StringWriter();		
		fragment.invoke(out);
		String bodyText = out.toString();
		bodyText = bodyText.replaceAll("[\r|\n]", "");
		System.out.println(bodyText);
		pageContext.getOut().write(bodyText);
	} 
} 
