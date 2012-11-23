package net.blogjava.nokiaguy.kxw.model;

import java.util.Date;


public class User
{
    private int id;
    private String email;
    private String password;
    private String name;
    private int sexId;
    private Date birthday;
    private int cityId;
    private int statusId;
    private String validationCode;
    private String company;
	public String getCompany()
	{
		return company;
	}
	public void setCompany(String company)
	{
		this.company = company;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getSexId()
	{
		return sexId;
	}
	public void setSexId(int sexId)
	{
		this.sexId = sexId;
	}
	public Date getBirthday()
	{
		return birthday;
	}
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
	public int getCityId()
	{
		return cityId;
	}
	public void setCityId(int cityId)
	{
		this.cityId = cityId;
	}
	public int getStatusId()
	{
		return statusId;
	}
	public void setStatusId(int statusId)
	{
		this.statusId = statusId;
	}
	public String getValidationCode()
	{
		return validationCode;
	}
	public void setValidationCode(String validationCode)
	{
		this.validationCode = validationCode;
	}
}
