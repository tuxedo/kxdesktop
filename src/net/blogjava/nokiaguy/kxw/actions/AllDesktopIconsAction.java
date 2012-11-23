package net.blogjava.nokiaguy.kxw.actions;

import java.io.PrintWriter;
import net.blogjava.nokiaguy.kxw.dao.interfaces.DesktopIconDAO;
import net.blogjava.nokiaguy.kxw.data.DesktopIconsDefinition;
import net.blogjava.nokiaguy.kxw.entity.DesktopIcon;

public class AllDesktopIconsAction extends ParentAction
{
	private DesktopIconDAO desktopIconDAO;

	public void setDesktopIconDAO(DesktopIconDAO desktopIconDAO)
	{
		this.desktopIconDAO = desktopIconDAO;
	}

	@Override
	public String execute()
	{
		try
		{
			PrintWriter out = response.getWriter();
			out.println(DesktopIconsDefinition.getDesktopIconsHtml());
			out.println(DesktopIconsDefinition
					.getCreateDesktopIconsObjectJavaScriptFunction());

			super.execute();
		}
		catch (Exception e)
		{

		}
		return null;
	}

	@Override
	public String process()
	{
		try
		{
			String javascript = null;

			DesktopIcon desktopIcon = desktopIconDAO.getDesktopIcon(email);
			if (desktopIcon != null)
			{

				javascript = DesktopIconsDefinition
						.getShowDesktopIconsJavaScriptFunction(desktopIcon,
								false);

			}

			PrintWriter out = response.getWriter();
			out.write(javascript);
		}
		catch (Exception e)
		{

		}
		return super.process();
	}

}
