package tw.com.hyberx.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.hyberx.model.dao.ProductDAO;
import tw.com.hyberx.model.entity.Product;
import tw.com.hyberx.model.entity.Student;
import tw.com.hyberx.service.ProductService;
import tw.com.hyberx.utils.ResponseREST;
 
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	@Transactional
	public boolean create(Product bean) {
		return productDAO.save(bean);
	}

	@Override
	@Transactional
	public List<Product> query() {
		List<Product> productList = null;

        /* Initial value */
        /* Check */
        /* Search Condition */

        try {
            productList = productDAO.findAll()
                    .stream()
                    .sorted((o1, o2) -> o2.getId().compareTo(o1.getId()))
                    // .peek(System.out::println)
                    .collect(Collectors.toList());
            if (productList == null) {
                throw new Exception(">>> Product Query Failed <<<");
            }
        } catch (Exception e) {
            productList = null;
            e.printStackTrace();
        }
        return productList;
	}

	@Override
	@Transactional
	public Product find(Long id) {
		return productDAO.find(id);
	}

	@Override
	@Transactional
	public boolean update(Product bean) {
		return productDAO.save(bean);
	}

	@Override
	@Transactional
	public boolean delete(Long id) {
		return productDAO.remove(productDAO.find(id));
	}

	@Override
	public ResponseREST queryREST(Object json) {
		// TODO Auto-generated method stub
		return null;
	}

}
