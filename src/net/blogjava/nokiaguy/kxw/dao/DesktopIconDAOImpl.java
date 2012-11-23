package net.blogjava.nokiaguy.kxw.dao;

import java.util.List;

import net.blogjava.nokiaguy.kxw.dao.interfaces.DesktopIconDAO;
import net.blogjava.nokiaguy.kxw.data.DesktopIconsDefinition;
import net.blogjava.nokiaguy.kxw.entity.DesktopIcon;
import net.blogjava.nokiaguy.kxw.entity.User;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class DesktopIconDAOImpl extends ParentDAOImpl implements DesktopIconDAO
{
	public DesktopIconDAOImpl(HibernateTemplate template)
	{
		super(template);
	}

	@Override
	public void updateSettings(String email, String settings)
	{
		template.bulkUpdate(
				"update DesktopIcon set settings = ? where email=?",
				new String[]
				{ settings, email });
	}

	@Override
	public void addDefaultSettings(User user)
	{
		DesktopIcon desktopIcon = new DesktopIcon();
		desktopIcon.setEmail(user.getEmail());
		desktopIcon
				.setSettings(DesktopIconsDefinition.defaultDesktopIconSettings);
		template.saveOrUpdate(desktopIcon);

	}

	@Override
	public DesktopIcon getDesktopIcon(String email)
	{
		List<DesktopIcon> desktopIcons = template.find(
				"from DesktopIcon where email=?", new String[]
				{ email });
		if (desktopIcons.size() > 0)
		{
			return desktopIcons.get(0);
		}
		return null;
	}
}
