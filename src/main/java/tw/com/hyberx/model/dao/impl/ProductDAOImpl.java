package tw.com.hyberx.model.dao.impl;

import org.springframework.stereotype.Repository;

import tw.com.hyberx.model.dao.ProductDAO;
import tw.com.hyberx.model.entity.Product;
import tw.com.hyberx.model.entity.Student;
 
@Repository
public class ProductDAOImpl extends _DAOImpl<Product> implements ProductDAO {}
