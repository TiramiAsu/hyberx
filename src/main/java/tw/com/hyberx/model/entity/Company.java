package tw.com.hyberx.model.entity;

<<<<<<< HEAD
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
=======
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
>>>>>>> bob
import javax.persistence.Table;

@Entity
@Table(name = "company")
<<<<<<< HEAD
public class Company {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String contactMan;
	private Date timeBuild;
	private Date timeModify;
	public Company() {
		super();
	}
	public Company(String name, String address, String phone, String email, String contactMan) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.contactMan = contactMan;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactMan() {
		return contactMan;
	}
	public void setContactMan(String contactMan) {
		this.contactMan = contactMan;
	}
	public Date getTimeBuild() {
		return timeBuild;
	}
	public void setTimeBuild(Date timeBuild) {
		this.timeBuild = timeBuild;
	}
	public Date getTimeModify() {
		return timeModify;
	}
	public void setTimeModify(Date timeModify) {
		this.timeModify = timeModify;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", contactMan=" + contactMan + ", timeBuild=" + timeBuild + ", timeModify=" + timeModify + "]";
	}
=======
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;

//	private Long id;
//	private String name;
//	private String address;
//	private String phone;
//	private String email;
//	private String contact_man;
	 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

//@OneToMany(mappedBy="company",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//private List<Product> products;

@Column(name = "name", length = 255, nullable = false)
private String name;

@Column(name = "address", nullable = false)
private String address;



@Column(name = "phone", nullable = false)
private String phone;

@Column(name = "email", nullable = false)
private String email;


@Column(name = "contact_man", nullable = false)
private String contact_man;


public Company() {
	super();
}


public Company(String name, String address, String phone, String email, String contact_man) {
	super();
	this.name = name;
	this.address = address;
	this.phone = phone;
	this.email = email;
	this.contact_man = contact_man;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getContact_man() {
	return contact_man;
}


public void setContact_man(String contact_man) {
	this.contact_man = contact_man;
}


@Override
public String toString() {
	return "Company [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email
			+ ", contact_man=" + contact_man + "]";
}

	



	
	
	
>>>>>>> bob
}
