package net.blogjava.nokiaguy.kxw.dao;


import org.springframework.orm.hibernate3.HibernateTemplate;

public class ParentDAO 
{
    protected HibernateTemplate template;
    public ParentDAO(HibernateTemplate template)
    {
    	this.template = template; 
    }    
}
