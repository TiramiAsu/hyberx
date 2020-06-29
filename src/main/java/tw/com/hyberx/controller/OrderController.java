package tw.com.hyberx.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.com.hyberx.model.entity.Order;
import tw.com.hyberx.service.OrderService;
import tw.com.hyberx.utils.SpringUtils;

/**
 * 專案名稱： hyberx
 * 
 * 建立時間： 2020年6月10日下午8:39:31
 * 
 * Author： ChenYungYuan phone： (886)0971-667-299 E-mail： artemis3109@gmail.com
 * 
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	public OrderService orderService;

	public void initService() {
		orderService = (orderService == null) ? SpringUtils.getBean(OrderService.class) : orderService;
	}

//	static {
//	static List<Order> orders = new ArrayList<>();
//		Order sd1 = new Order("訂單一", 2100,"備註","20200505","20200507");
//		sd1.setId(1L);
//		Order sd2 = new Order("訂單二", 300,"備註2","20200504","20200508");
//		sd2.setId(2L);
//		orders.add(sd1);
//		orders.add(sd2);
//	}

	@GetMapping("/input") // URL request 進來
	public String input(Model model) { // model 要傳給 JSP from
//		Order order = new Order();
//		model.addAttribute("order", order); // 屬性名稱為spring form 的 modelAttribute
//		model.addAttribute("orders", orders);
//		model.addAttribute("action", "add");
//		return "test/order";
		initService();

		model.addAttribute("order", new Order()); // 屬性名稱為spring form 的 modelAttribute
		model.addAttribute("orders", orderService.query());
		model.addAttribute("action", "add");
		return "test/order";
	}

	@PostMapping("/add") // Form request 進來
	public String add(@ModelAttribute Order order) {
//		Long id = 1L;
//		if (orders.size() != 0) {
//			id += orders.stream().mapToLong(s -> s.getId()).max().getAsLong();
//		}
//		order.setId(id);
//		orders.add(order);
//		orders.stream().forEach(System.out::println);
//		return "redirect:./input";
		initService();
		orderService.create(order);
		return "redirect:./input";
	}

	@GetMapping("/find/{id}")
	public String find(@PathVariable Long id, Model model) {
//		Order order = orders.stream().filter(s -> s.getId() == id).findFirst().get();
//		model.addAttribute("order", order);
//		model.addAttribute("orders", orders);
//		model.addAttribute("action", "update");
//		return "test/order";
		initService();
		model.addAttribute("order", orderService.find(id));
		model.addAttribute("orders", orderService.query());
		model.addAttribute("action", "update");
		return "test/order";

	}

	@PostMapping("/update")
	public String update(@ModelAttribute Order order) {
//		Order ord = orders.stream().filter(s -> s.getId() == order.getId()).findFirst().get();
//		ord.setName(order.getName());
//		ord.setPrice(order.getPrice());
//		ord.setRemark(order.getRemark());
//		ord.setTime_build(order.getTime_build());
//		ord.setTime_modify(order.getTime_modify());
//		return "redirect:./input";

		initService();
		Order oriOrder = orderService.find(order.getId());
		oriOrder.setName(oriOrder.getName().equals(order.getName()) ? order.getName() : oriOrder.getName());
		oriOrder.setPrice(oriOrder.getPrice().equals(order.getPrice()) ? order.getPrice() : oriOrder.getPrice());
		oriOrder.setRemark(oriOrder.getRemark().equals(order.getRemark()) ? order.getRemark() : oriOrder.getRemark());
		oriOrder.setTime_build(oriOrder.getTime_build());
		oriOrder.setTime_modify(new Date());
		orderService.update(oriOrder);
		return "redirect:./input";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
//		Order order = orders.stream().filter(s -> s.getId() == id).findFirst().get();
//		orders.remove(order);
//		return "redirect:../input";

		initService();
		Order oriOrder = orderService.find(id);
		if (oriOrder.equals(null)) {
			System.out.println(">>> delete failed <<<");
		} else {
			orderService.delete(id);
		}
		return "redirect:../input";
	}
}
