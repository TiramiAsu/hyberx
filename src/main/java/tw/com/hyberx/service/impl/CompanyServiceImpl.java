package tw.com.hyberx.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.hyberx.model.dao.CompanyDAO;
import tw.com.hyberx.model.dao.ProductDAO;
import tw.com.hyberx.model.entity.Company;
import tw.com.hyberx.model.entity.Product;
import tw.com.hyberx.service.CompanyService;
import tw.com.hyberx.service.ProductService;

@Service
public class CompanyServiceImpl  implements CompanyService{

	
	@Autowired
	private CompanyDAO companyDAO;
	
	@Override
	@Transactional
	public boolean create(Company bean) {
		return companyDAO.save(bean);
	}

	@Override
	@Transactional
	public List<Company> query() {
		List<Company> companyList = null;

        /* Initial value */
        /* Check */
        /* Search Condition */

        try {
        	companyList = companyDAO.findAll()
                    .stream()
                    .sorted((o1, o2) -> o2.getId().compareTo(o1.getId()))
                    // .peek(System.out::println)
                    .collect(Collectors.toList());
            if (companyList == null) {
                throw new Exception(">>> Company Query Failed <<<");
            }
        } catch (Exception e) {
        	companyList = null;
            e.printStackTrace();
        }
        return companyList;
	}

	@Override
	@Transactional
	public Company find(Long id) {
		return companyDAO.find(id);
	}

	@Override
	@Transactional
	public boolean update(Company bean) {
		return companyDAO.save(bean);
	}

	@Override
	@Transactional
	public boolean delete(Long id) {
		return companyDAO.remove(companyDAO.find(id));
	}

	
}
