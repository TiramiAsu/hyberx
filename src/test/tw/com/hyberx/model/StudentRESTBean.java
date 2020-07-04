/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package tw.com.hyberx.model;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * [學生 REST Bean] 2019-12-24 23:19
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class StudentRESTBean implements Serializable {

	private static final long serialVersionUID = 6210808508968509212L;
	
	private Long id;
	private String name;
	private Integer age;
	private Date timeModify;

	public StudentRESTBean() {}

	public Long getId() {
		return id;
	}

	public StudentRESTBean setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public StudentRESTBean setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getAge() {
		return age;
	}

	public StudentRESTBean setAge(Integer age) {
		this.age = age;
		return this;
	}

	public Date getTimeModify() {
		return timeModify;
	}

	public StudentRESTBean setTimeModify(Date timeModify) {
		this.timeModify = timeModify;
		return this;
	}

	@Override
	public String toString() {
		return "MemberRESTBean [id=" + id +
				", name=" + name +
				", age=" + age +
				", timeModify=" + timeModify +
				"]";
	}
	
}
