package tw.com.hyberx.utils;

import org.springframework.jdbc.core.JdbcTemplate;

import tw.com.hyberx.model.entity.Product;

public class InitDatabase{
	
	public static void main(String[] args) {
		Product product=new Product();
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.queryForList("");
	}
}
