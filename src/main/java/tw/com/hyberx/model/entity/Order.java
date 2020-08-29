package tw.com.hyberx.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

	private static final long serialVersionUID = -8594710176376450721L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "a_id")
	private Account a_id;
	
	@ManyToMany(mappedBy = "orders")
	 private List<Product> products = new ArrayList<>();
	
	
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
	public Order(Account a_id, List<Product> products, String name, Integer price, String remark) {
		super();
		this.a_id = a_id;
		this.products = products;
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

	public Account getA_id() {
		return a_id;
	}

	public void setA_id(Account a_id) {
		this.a_id = a_id;
	}

	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
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
		return "Order [id=" + id + ", a_id=" + a_id + ", products=" + products + ", name=" + name + ", price=" + price
				+ ", remark=" + remark + ", time_build=" + time_build + ", time_modify=" + time_modify + "]";
	}
	
	
}
