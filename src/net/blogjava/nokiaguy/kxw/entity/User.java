package net.blogjava.nokiaguy.kxw.entity;

import java.util.Date;



public class User
{
    private int id;
    private String email;
    private String password;
    private String name;
    private Sex sex;
    private int sexId;
    private Date birthday;
    private City city;
    private int cityId;
    private Status status;
    private int statusId;
    private int loginStateId;
	private String company;
    public String getCompany()
	{
		return company;
	}
	public void setCompany(String company)
	{
		this.company = company;
	}
	public int getSexId()
	{
		return sexId;
	}
	public void setSexId(int sexId)
	{
		this.sexId = sexId;
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
	private String validationCode;
	public String getValidationCode()
	{
		return validationCode;
	}
	public void setValidationCode(String validationCode)
	{
		this.validationCode = validationCode;
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
	public Sex getSex()
	{
		return sex;
	}
	public void setSex(Sex sex)
	{
		this.sex = sex;
	}
	public Date getBirthday()
	{
		return birthday;
	}
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
	public City getCity()
	{
		return city;
	}
	public void setCity(City city)
	{
		this.city = city;
	} 
	public Status getStatus()
	{
		return status;
	}
	public void setStatus(Status status)
	{
		this.status = status;
	}
	public int getLoginStateId()
	{
		return loginStateId;
	}
	public void setLoginStateId(int loginStateId)
	{
		this.loginStateId = loginStateId;
	}
    
}
