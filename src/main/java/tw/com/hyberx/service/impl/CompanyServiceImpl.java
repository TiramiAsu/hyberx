package tw.com.hyberx.service.impl;

<<<<<<< HEAD
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import tw.com.hyberx.model.dao.CompanyDAO;
import tw.com.hyberx.model.entity.Company;
import tw.com.hyberx.model.entity.Member;
import tw.com.hyberx.service.CompanyService;
import tw.com.hyberx.utils.ResponseREST;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDAO companyDAO;

	@Override
	@Transactional
	public boolean create(Company bean) {
		bean.setTimeBuild(new Date());
		bean.setTimeModify(new Date());
=======
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
>>>>>>> bob
		return companyDAO.save(bean);
	}

	@Override
	@Transactional
	public List<Company> query() {
		List<Company> companyList = null;

<<<<<<< HEAD
		try {
			companyList = companyDAO.findAll().stream().sorted((o1, o2) -> o2.getId().compareTo(o1.getId()))
					.collect(Collectors.toList());
			if (companyList == null) {
				throw new Exception(">>> Member Query Failed <<<");
			}
		} catch (Exception e) {
			companyList = null;
			e.printStackTrace();
		}
		return companyList;
=======
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
>>>>>>> bob
	}

	@Override
	@Transactional
	public Company find(Long id) {
		return companyDAO.find(id);
	}

	@Override
	@Transactional
	public boolean update(Company bean) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
=======
>>>>>>> bob
		return companyDAO.save(bean);
	}

	@Override
	@Transactional
	public boolean delete(Long id) {
<<<<<<< HEAD
		try {
			return companyDAO.remove(companyDAO.find(id));
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResponseREST queryREST(Object json) {
		// TODO Auto-generated method stub
		return null;
	}

=======
		return companyDAO.remove(companyDAO.find(id));
	}

	
>>>>>>> bob
}
