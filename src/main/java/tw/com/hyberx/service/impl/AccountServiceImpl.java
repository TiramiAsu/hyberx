package tw.com.hyberx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.hyberx.model.dao.AccountDAO;
import tw.com.hyberx.model.entity.Account;
import tw.com.hyberx.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	@Transactional
	public boolean create(Account bean) {
<<<<<<< HEAD
		bean.setStatus(0);
		bean.setErrorTimes(0);
=======
>>>>>>> 9110d1d3f27cfde3bb720c39fd67ef7fa9b46be4
		bean.setTimeBuild(new Date());
        bean.setTimeModify(new Date());
        return accountDAO.save(bean);
	}

	@Override
	@Transactional
	public List<Account> query() {
		List<Account> accountList=null;
		
		try {
			accountList=accountDAO.findAll()
					.stream()
					.sorted((o1,o2)->o2.getId().compareTo
							(o1.getId()))
					.collect(Collectors.toList());
			if (accountList==null) {
				throw new Exception(">>> Account Query Failed <<<");
			}
		} catch (Exception e) {
			accountList=null;
			e.printStackTrace();
		}
		return accountList;
	}

	@Override
	@Transactional
	public Account find(Long id) {
		// TODO Auto-generated method stub
		return accountDAO.find(id);
	}

	@Override
	@Transactional
	public boolean update(Account bean) {
		// TODO Auto-generated method stub
		return accountDAO.save(bean);
	}

	@Override
	@Transactional
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return accountDAO.remove(accountDAO.find(id));
	}
	
}
