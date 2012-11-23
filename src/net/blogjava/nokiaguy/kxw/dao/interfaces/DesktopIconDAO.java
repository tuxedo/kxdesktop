package net.blogjava.nokiaguy.kxw.dao.interfaces;

import net.blogjava.nokiaguy.kxw.entity.DesktopIcon;
import net.blogjava.nokiaguy.kxw.entity.User;

public interface DesktopIconDAO extends ParentDAO
{
    public DesktopIcon getDesktopIcon(String email);
	public void addDefaultSettings(User user);	
	public void updateSettings(String email, String settings);

}
