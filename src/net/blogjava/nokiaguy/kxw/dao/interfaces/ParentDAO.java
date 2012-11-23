package net.blogjava.nokiaguy.kxw.dao.interfaces;

import java.io.Serializable;

public interface ParentDAO
{
	public Object getEntity(Class entityClass, Serializable id);
}
