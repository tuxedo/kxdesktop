package net.blogjava.nokiaguy.kxw.service.interfaces;

import net.blogjava.nokiaguy.kxw.entity.User;

public interface UserService
{
    public void addUser(User user);
    public boolean verifyUser(User user);
}
