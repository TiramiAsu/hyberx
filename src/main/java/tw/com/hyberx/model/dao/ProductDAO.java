package tw.com.hyberx.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import tw.com.hyberx.model.entity.Product;
 
public interface ProductDAO extends _DAO<Product>, GenericDAO<Product, Long> {

}