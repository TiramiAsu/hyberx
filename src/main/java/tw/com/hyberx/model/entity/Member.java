package tw.com.hyberx.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "member")
public class Member implements Serializable{
	
	private static final long serialVersionUID = -5608241289036967005L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@OneToMany(mappedBy = "member")
	private Long id;
	
	@Column(name = "name",length = 255,nullable = false)
	private String name;
	
	@Column(name = "address",nullable = false)
	private String address;
	
	@Column(name = "phone",nullable = false)
	private String phone;
	
	@Column(name = "email",nullable = false)
	private String email;
	
	@Column(name = "time_build", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date timeBuild;
	
	@Column(name = "time_modify", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date timeModify;
	
	public Member() {}

	public Member(String name, String address, String phone, String email, Date timeBuild, Date timeModify) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.timeBuild = timeBuild;
		this.timeModify = timeModify;
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
		return "Member [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", timeBuild=" + timeBuild + ", timeModify=" + timeModify + "]";
	}
}
