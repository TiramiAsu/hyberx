package tw.com.hyberx.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "account")
public class Account implements Serializable{
	
	private static final long serialVersionUID = -5608241289036967005L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name",length = 255,nullable = false)
	private String name;
	
	@Column(name = "password",nullable = false)
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "m_id",nullable = false)
	private Member m_id;
	
	@Column(name = "status",nullable = false)
	private int status;
	
	@Column(name = "error_times",nullable = false)
	private int error_times;
	
	@Column(name = "time_build", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date time_build;
	
	@Column(name = "time_modify", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date time_modify;
	
	public Account() {}
	
	public Account(String name, 
			String password,
			Member m_id,
			int status,
			int error_times,
			Date time_build,
			Date time_modify) {
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
	
	public Member getM_id() {
		return m_id;
	}
	
	public void setM_id(Member m_id) {
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
		return "Accounts [id=" + id + ", name=" + name + ", password=" + password + ", m_id=" + m_id + ", status="
				+ status + ", error_times=" + error_times + ", time_build=" + time_build + ", time_modify="
				+ time_modify + "]";
	}
}
