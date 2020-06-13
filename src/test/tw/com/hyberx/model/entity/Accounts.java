package tw.com.hyberx.model.entity;

import java.sql.Timestamp;

public class Accounts {
	private Long id;
	private String name;
	private String password;
	private Members m_id;
	private int status;
	private int error_times;
	private Timestamp time_build;
	private Timestamp time_modify;
	public Accounts() {
		super();
	}
	public Accounts(String name, String password, Members m_id, int status, int error_times, Timestamp time_build,
			Timestamp time_modify) {
		super();
		this.name = name;
		this.password = password;
		this.m_id = m_id;
		this.status = status;
		this.error_times = error_times;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Members getM_id() {
		return m_id;
	}
	public void setM_id(Members m_id) {
		this.m_id = m_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getError_times() {
		return error_times;
	}
	public void setError_times(int error_times) {
		this.error_times = error_times;
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
		return "Accounts [id=" + id + ", name=" + name + ", password=" + password + ", m_id=" + m_id + ", status="
				+ status + ", error_times=" + error_times + ", time_build=" + time_build + ", time_modify="
				+ time_modify + "]";
	}
}
