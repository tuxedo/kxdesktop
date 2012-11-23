package net.blogjava.nokiaguy.kxw.data;

import net.blogjava.nokiaguy.kxw.entity.DesktopIcon;

public class DesktopIconsDefinition
{
	public static DesktopIconSetting[] desktopIcons;
	public static String defaultDesktopIconSettings = "0:10:10";
	static
	{
		DesktopIconSetting desktopIconSetting1 = new DesktopIconSetting();
		desktopIconSetting1.setTitle("控制面板");
		desktopIconSetting1.setImageUrl("../images/settings.gif");
		desktopIconSetting1.setId("settings-shortcut");
		DesktopIconSetting desktopIconSetting2 = new DesktopIconSetting();
		desktopIconSetting2.setTitle("桌面图标");
		desktopIconSetting2.setImageUrl("../images/desktop-icons.gif");
		desktopIconSetting2.setId("desktop-icons-shortcut");
		desktopIcons = new DesktopIconSetting[]
		{ desktopIconSetting1, desktopIconSetting2 };
	};

	public static String getDesktopIconsHtml()
	{
		String html = "";
		for (int i = 0; i < desktopIcons.length; i++)
		{

			html += "<dt id='" + desktopIcons[i].getId()
					+ "' style='position: absolute;display:none;'><a href='#'>";
			html += "<img src='" + desktopIcons[i].getImageUrl()
					+ "' style='width:48px;height:48px'/>";
			html += "<div style='font-size:13px;margin-top:5px'>"
					+ desktopIcons[i].getTitle() + "</div></a></dt>";
		}
		return html;
	}

	public static String getCreateDesktopIconsObjectJavaScriptFunction()
	{
		String javascript = "<script type='text/javascript'>function createDesktopIconsObject(){";

		for (int i = 0; i < desktopIcons.length; i++)
		{
			javascript += "index = desktopIcons.length;";
			javascript += "desktopIcons[index] = new Object();";
			javascript += "desktopIcons[index].index = index;";
			javascript += "desktopIcons[index].dd = new Ext.dd.DD('"
					+ desktopIcons[i].getId() + "');";
			javascript += "desktopIcons[index].element = document.getElementById('"
					+ desktopIcons[i].getId() + "');";
			javascript += "desktopIcons[index].dd.lock();";
		}
		javascript += "}</script>";
		return javascript;
	}
	public static String getShowDesktopIconsJavaScriptFunction(
			DesktopIcon desktopIcon, boolean onlyCode)
	{
		String javascript = "";
		if (onlyCode == false)
		{
			javascript = "<script type='text/javascript'>";
			javascript += "function showDesktopIcons(){";
		}
		if (desktopIcon != null)
		{

			String settings = desktopIcon.getSettings();
			String[] desktopIconSettings = settings.split(",");
			for (int i = 0; i < DesktopIconsDefinition.desktopIcons.length; i++)
			{
				javascript += "desktopIcons[" + i
						+ "].element.style.display='none';";
			}
			for (int i = 0; i < desktopIconSettings.length; i++)
			{
				String[] desktopIconSetting = desktopIconSettings[i].split(":");
				int index = Integer.parseInt(desktopIconSetting[0]);
				if(index >= DesktopIconsDefinition.desktopIcons.length)
				{
					break;
				}
				String left = desktopIconSetting[1];
				String top = desktopIconSetting[2];
				javascript += "desktopIcons[" + index
						+ "].element.style.display='';";
				javascript += "desktopIcons[" + index + "].element.style.left="
						+ left + ";";
				javascript += "desktopIcons[" + index + "].element.style.top="
						+ top + ";";
			}

		}
		if (onlyCode == false)
		{
			javascript += "}</script>";
		}
		return javascript;
	}

}
