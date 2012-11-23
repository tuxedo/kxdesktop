package net.blogjava.nokiaguy.kxw.service;

import net.blogjava.nokiaguy.kxw.dao.interfaces.DesktopIconDAO;
import net.blogjava.nokiaguy.kxw.dao.interfaces.UserDAO;
import net.blogjava.nokiaguy.kxw.entity.City;
import net.blogjava.nokiaguy.kxw.entity.Sex;
import net.blogjava.nokiaguy.kxw.entity.Status;
import net.blogjava.nokiaguy.kxw.entity.User;
import net.blogjava.nokiaguy.kxw.service.interfaces.UserService;
import net.blogjava.nokiaguy.kxw.util.Encrypter;

public class UserServiceImpl implements UserService
{
	private UserDAO userDAO;
    private DesktopIconDAO desktopIconDAO;
	public UserServiceImpl(UserDAO userDAO, DesktopIconDAO desktopIconDAO)
	{
		this.userDAO = userDAO;
		this.desktopIconDAO = desktopIconDAO;
	}

	public void addUser(User user)
	{
		Sex sex = (Sex) userDAO.getEntity(Sex.class, user.getSexId());
		Status status = (Status) userDAO.getEntity(Status.class, user
				.getStatusId());
		City city = (City) userDAO.getEntity(City.class, user.getCityId());
		user.setSex(sex);
		user.setStatus(status);
		user.setCity(city);
		user.setPassword(Encrypter.md5(user.getPassword()));
		userDAO.addUser(user);
		desktopIconDAO.addDefaultSettings(user);
	}

	@Override
	public boolean verifyUser(User user)
	{
		String password = userDAO.getPassword(user);
		if (password == null)
			return false;
		if (password.equals(Encrypter.md5(user.getPassword())))
		{			
			return true;
		}
		return false;
	}
}
