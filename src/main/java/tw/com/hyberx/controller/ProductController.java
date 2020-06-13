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

import tw.com.hyberx.model.entity.Product;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	
	static List<Product> products = new ArrayList<>();
	
	static {
		Product product1 = new Product("AA202006071306", "Bob公司","Bob牛奶",70,"牛奶","新北市");
		product1.setId(1L);
        Product product2 = new Product("AA202006071307", "JAY公司","Jay牛奶",50,"牛奶","新竹市");
        product2.setId(2L);
        products.add(product1);
        products.add(product2);
    }
	
	@GetMapping("/input") // URL request 進來
    public String input(Model model) { // model 要傳給 JSP from
        Product product = new Product();
//      student.setName("Anita"); // 可傳入值在表單中
        model.addAttribute("product", product); // 屬性名稱為spring form 的 modelAttribute
        model.addAttribute("products", products);
        model.addAttribute("action", "add");
        return "test/product";
    }

    @PostMapping("/add") // Form request 進來
    public String add(@ModelAttribute Product product) {
        Long id = 1L;
        if (products.size() != 0) {
            id += products.stream().mapToLong(s -> s.getId()).max().getAsLong();
        }
        product.setId(id);
        products.add(product);
        products.stream().forEach(System.out::println);
        return "redirect:./input";
    }

    @GetMapping("/find/{id}")
    public String find(@PathVariable Long id, Model model) {
        Product product = products.stream().filter(s -> s.getId() == id).findFirst().get();
        model.addAttribute("product", product);
        model.addAttribute("products", products);
        model.addAttribute("action", "update");
        return "test/product";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product) {
        Product pro = products.stream().filter(s -> s.getId() == product.getId()).findFirst().get();
        pro.setCode(product.getCode());
        pro.setCompany(product.getCompany());
        pro.setName(product.getName());
        pro.setCost(product.getCost());
        pro.setType(product.getType());
        pro.setArea(product.getArea());
        return "redirect:./input";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        Product product = products.stream().filter(s -> s.getId() == id).findFirst().get();
        products.remove(product);
        return "redirect:../input";
    }
	
	
	
}
