package tw.com.hyberx.model.entity;

/**
 * 專案名稱： hyberx
 * 
 * 建立時間： 2020年6月10日下午8:40:34
 * 
 * Author： ChenYungYuan phone： (886)0971-667-299 E-mail： artemis3109@gmail.com
 * 
 */

public class Order {

	private Long id;
	private String name;
	private Integer price;
	private String remark;
	private String time_build;
	private String time_modify;

	public Order() {
	}

	public Order(String name, Integer price, String remark, String time_build, String time_modify) {
		this.name = name;
		this.price = price;
		this.remark = remark;
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

	public String getTime_build() {
		return time_build;
	}

	public void setTime_build(String time_build) {
		this.time_build = time_build;
	}

	public String getTime_modify() {
		return time_modify;
	}

	public void setTime_modify(String time_modify) {
		this.time_modify = time_modify;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", price=" + price + ", remark=" + remark + ", time_build="
				+ time_build + ", time_modify=" + time_modify + "]";
	}
}
