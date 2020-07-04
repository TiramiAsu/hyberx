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

/**
 * 專案名稱： hyberx
 * 
 * 建立時間： 2020年6月10日下午8:40:34
 * 
 * Author： ChenYungYuan phone： (886)0971-667-299 E-mail： artemis3109@gmail.com
 * 
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {

<<<<<<< HEAD
=======
	
>>>>>>> 9110d1d3f27cfde3bb720c39fd67ef7fa9b46be4
	private static final long serialVersionUID = -8594710176376450721L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	@Column(name = "price", nullable = false)
	private Integer price;
	@Column(name = "remark", nullable = true)
	private String remark;
	@Column(name = "time_build", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date time_build;
	@Column(name = "time_modify", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date time_modify;

	public Order() {
	}

	public Order(String name, Integer price, String remark) {
		this.name = name;
		this.price = price;
		this.remark = remark;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getTime_build() {
		return time_build;
	}

	public void setTime_build(Date date) {
		this.time_build = date;
	}

	public Date getTime_modify() {
		return time_modify;
	}

	public void setTime_modify(Date time_modify) {
		this.time_modify = time_modify;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", price=" + price + ", remark=" + remark + ", time_build="
				+ time_build + ", time_modify=" + time_modify + "]";
	}
}
