package tw.com.hyberx.model.entity;

public class Product{

		private Long id;
		private String code;
		private String company;
		private String name;
		private Integer cost;
		private String type;
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
