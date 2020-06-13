package tw.com.hyberx.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.com.hyberx.model.entity.Order;

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
	
	static List<Order> orders = new ArrayList<>();

	static {
		Order sd1 = new Order("訂單一", 2100,"備註","20200505","20200507");
		sd1.setId(1L);
		Order sd2 = new Order("訂單二", 300,"備註2","20200504","20200508");
		sd2.setId(2L);
		orders.add(sd1);
		orders.add(sd2);
	}

	@GetMapping("/input") // URL request 進來
	public String input(Model model) { // model 要傳給 JSP from
		Order order = new Order();
//      student.setName("Anita"); // 可傳入值在表單中
		model.addAttribute("order", order); // 屬性名稱為spring form 的 modelAttribute
		model.addAttribute("orders", orders);
		model.addAttribute("action", "add");
		return "test/order";
	}

	@PostMapping("/add") // Form request 進來
	public String add(@ModelAttribute Order order) {
		Long id = 1L;
		if (orders.size() != 0) {
			id += orders.stream().mapToLong(s -> s.getId()).max().getAsLong();
		}
		order.setId(id);
		orders.add(order);
		orders.stream().forEach(System.out::println);
		return "redirect:./input";
	}

	@GetMapping("/find/{id}")
	public String find(@PathVariable Long id, Model model) {
		Order order = orders.stream().filter(s -> s.getId() == id).findFirst().get();
		model.addAttribute("order", order);
		model.addAttribute("orders", orders);
		model.addAttribute("action", "update");
		return "test/order";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Order order) {
		Order ord = orders.stream().filter(s -> s.getId() == order.getId()).findFirst().get();
		ord.setName(order.getName());
		ord.setPrice(order.getPrice());
		ord.setRemark(order.getRemark());
		ord.setTime_build(order.getTime_build());
		ord.setTime_modify(order.getTime_modify());
		return "redirect:./input";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		Order order = orders.stream().filter(s -> s.getId() == id).findFirst().get();
		orders.remove(order);
		return "redirect:../input";
	}
}
