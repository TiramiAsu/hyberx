package tw.com.hyberx.model.entity;

import java.sql.Timestamp;

public class Members {
	private Long id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String agent;
	private Timestamp time_build;
	private Timestamp time_modify;
	public Members() {
		super();
	}
	public Members(String name, String address, String phone, String email, String agent, Timestamp time_build,
			Timestamp time_modify) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.agent = agent;
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
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public Timestamp getTime_build() {
		return time_build;
	}
	public void setTime_build(Timestamp time_build) {
		this.time_build = time_build;
	}
	public Timestamp getTime_modify() {
		return time_modify;
	}
	public void setTime_modify(Timestamp time_modify) {
		this.time_modify = time_modify;
	}
	@Override
	public String toString() {
		return "Members [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", agent=" + agent + ", time_build=" + time_build + ", time_modify=" + time_modify + "]";
	}
}
