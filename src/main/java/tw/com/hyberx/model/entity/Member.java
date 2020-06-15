package tw.com.hyberx.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "member")
public class Member implements Serializable{
	
	private static final long serialVersionUID = -5608241289036967005L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private Date time_build;
	
	@Column(name = "time_modify", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date time_modify;
	
	public Member() {}
	
	public Member(String name, 
			String address, 
			String phone, 
			String email, 
			Date time_build,
			Date time_modify) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.time_build = time_build;
		this.time_modify = time_modify;
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
	
	public Date getTime_build() {
		return time_build;
	}
	
	public void setTime_build(Date time_build) {
		this.time_build = time_build;
	}
	
	public Date getTime_modify() {
		return time_modify;
	}
	
	public void setTime_modify(Date time_modify) {
		this.time_modify = time_modify;
	}
	
	@Override
	public String toString() {
		return "Members [id=" + id +
				", name=" + name +
				", address=" + address +
				", phone=" + phone +
				", email=" + email +
				", time_build=" + time_build +
				", time_modify=" + time_modify +
				"]";
	}
}
