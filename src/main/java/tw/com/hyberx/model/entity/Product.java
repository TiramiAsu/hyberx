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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

//		private Long id;
//		private String code;
//		private String company;
//		private String name;
//		private Integer cost;
//		private String type;
//		private String area;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "code", length = 255, nullable = false)
	private String code;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "product_order",
		joinColumns = {
			@JoinColumn(name = "product_id", nullable = false, updatable = false) },
		inverseJoinColumns = {
			@JoinColumn(name = "order_id", nullable = false, updatable = false) })
	private List<Order> orders = new ArrayList<>();

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "cost", nullable = false)
	private Integer cost;

	@Column(name = "type", nullable = false)
	private String type;

	@Column(name = "area", nullable = false)
	private String area;

	public Product() {
		super();
	}

	public Product(String code, Company company, List<Order> orders, String name, Integer cost, String type,
			String area) {
		super();
		this.code = code;
		this.company = company;
		this.orders = orders;
		this.name = name;
		this.cost = cost;
		this.type = type;
		this.area = area;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", company=" + company + ", orders=" + orders + ", name=" + name
				+ ", cost=" + cost + ", type=" + type + ", area=" + area + "]";
	}

}
