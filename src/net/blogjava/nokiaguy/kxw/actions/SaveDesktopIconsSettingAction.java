package net.blogjava.nokiaguy.kxw.actions;

import java.io.PrintWriter;
import net.blogjava.nokiaguy.kxw.dao.interfaces.DesktopIconDAO;

public class SaveDesktopIconsSettingAction extends ParentAction
{
	private DesktopIconDAO desktopIconDAO;
	private String settings;

	public void setDesktopIconDAO(DesktopIconDAO desktopIconDAO)
	{
		this.desktopIconDAO = desktopIconDAO;
	}

	public void setSettings(String settings)
	{
		this.settings = settings;
	}

	@Override
	public String process()
	{
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
			desktopIconDAO.updateSettings(email, settings);			
			out.println("成功保存桌面图标状态！");
			
		}
		catch (Exception e)
		{
			out.println("保存桌面图标状态失败！");
		}
		return super.process();
	}

}
