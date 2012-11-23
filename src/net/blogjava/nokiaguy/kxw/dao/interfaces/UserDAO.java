package net.blogjava.nokiaguy.kxw.dao.interfaces;

import net.blogjava.nokiaguy.kxw.entity.User;

public interface UserDAO extends ParentDAO
{
    public void addUser(User user);
    public String getPassword(User user);     
}
