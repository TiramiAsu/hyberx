package tw.com.hyberx.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
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
}
