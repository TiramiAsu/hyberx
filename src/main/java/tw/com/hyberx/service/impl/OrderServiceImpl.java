package tw.com.hyberx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.hyberx.model.dao.OrderDAO;
import tw.com.hyberx.model.entity.Order;
import tw.com.hyberx.service.OrderService;

/**
 * 專案名稱： hyberx
 * 
 * 建立時間： 2020/6/29上午 01:22:05
 * 
 * Author： ChenYungYuan phone： (886)0971-667-299 E-mail： artemis3109@gmail.com
 * 
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	@Transactional
	public boolean create(Order bean) {
		bean.setTime_build(new Date());
		bean.setTime_modify(new Date());
		return orderDAO.save(bean);
	}

	@Override
	@Transactional
	public List<Order> query() {
		List<Order> orderList = null;

		try {
			orderList = orderDAO.findAll().stream().sorted((o1, o2) -> o2.getId().compareTo(o1.getId()))
					.collect(Collectors.toList());
			if (orderList == null) {
				throw new Exception(">>> Order Query Failed <<<");
			}
		} catch (Exception e) {
			orderList = null;
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	@Transactional
	public Order find(Long id) {
		return orderDAO.find(id);
	}

	@Override
	@Transactional
	public boolean update(Order bean) {
		return orderDAO.save(bean);
	}

	@Override
	@Transactional
	public boolean delete(Long id) {
		return orderDAO.remove(orderDAO.find(id));
	}

}
