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
@Table(name = "product")
public class Product implements Serializable{

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
    private Long id;

    @Column(name = "code", length = 255, nullable = false)
    private String code;

    @Column(name = "company", nullable = false)
    private String company;
    

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
		
		public Product(String code, String company, String name, Integer cost, String type, String area) {
			super();
			this.code = code;
			this.company = company;
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


		public String getCompany() {
			return company;
		}


		public void setCompany(String company) {
			this.company = company;
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
			return "Product [id=" + id + ", code=" + code + ", company=" + company + ", name=" + name + ", cost=" + cost
					+ ", type=" + type + ", area=" + area + "]";
		}
		
		
		
		
		
		
}
