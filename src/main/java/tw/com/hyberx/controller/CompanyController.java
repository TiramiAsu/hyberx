package tw.com.hyberx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.com.hyberx.model.entity.Company;
import tw.com.hyberx.model.entity.Product;
import tw.com.hyberx.service.CompanyService;
import tw.com.hyberx.service.ProductService;
import tw.com.hyberx.utils.SpringUtils;

@Controller
@RequestMapping("/company")
public class CompanyController {

	
	@Autowired
    public CompanyService companyService;
    
    public void initService() {
    	companyService = (companyService == null) ? SpringUtils.getBean(CompanyService.class) : companyService;
    }
	
	
	
//	static List<Product> products = new ArrayList<>();
	
//	static {
//		Product product1 = new Product("AA202006071306", "Bob公司","Bob牛奶",70,"牛奶","新北市");
//		product1.setId(1L);
//        Product product2 = new Product("AA202006071307", "JAY公司","Jay牛奶",50,"牛奶","新竹市");
//        product2.setId(2L);
//        products.add(product1);
//        products.add(product2);
//    }
	
	@GetMapping // URL request 進來
    public String input(Model model) { // model 要傳給 JSP from
//        Product product = new Product();
////      student.setName("Anita"); // 可傳入值在表單中
//        model.addAttribute("product", product); // 屬性名稱為spring form 的 modelAttribute
//        model.addAttribute("products", products);
//        model.addAttribute("action", "add");
//        return "test/product";
		initService();
        
        model.addAttribute("company", new Company()); // 屬性名稱為spring form 的 modelAttribute
        model.addAttribute("companys", companyService.query());
        model.addAttribute("action", "add");
        return "jsp/test/company";
		  
    }

    @PostMapping("/add") // Form r進來
    public String add(@ModelAttribute Company company) {
//        Long id = 1L;
//        if (products.size() != 0) {
//            id += products.stream().mapToLong(s -> s.getId()).max().getAsLong();
//        }
//        product.setId(id);
//        products.add(product);
//        products.stream().forEach(System.out::println);
//        return "redirect:./input";
    	initService();
        System.out.print(company);
        companyService.create(company);
        return "redirect:.";
    }

    @GetMapping("/find/{id}")
    public String find(@PathVariable Long id, Model model) {
//        Product product = products.stream().filter(s -> s.getId() == id).findFirst().get();
//        model.addAttribute("product", product);
//        model.addAttribute("products", products);
//        model.addAttribute("action", "update");
//        return "test/product";
    	initService();
        
        model.addAttribute("company", companyService.find(id));
        model.addAttribute("companys", companyService.query());
        model.addAttribute("action", "update");
        return "jsp/test/company";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Company company) {
//        Product pro = products.stream().filter(s -> s.getId() == product.getId()).findFirst().get();
//        pro.setCode(product.getCode());
//        pro.setCompany(product.getCompany());
//        pro.setName(product.getName());
//        pro.setCost(product.getCost());
//        pro.setType(product.getType());
//        pro.setArea(product.getArea());
//        return "redirect:./input";
    	initService();
//		private Long id;
//		private String code;
//		private String company;
//		private String name;
//		private Integer cost;
//		private String type;
//		private String area;
    	
    	
        
        Company oriCompany = companyService.find(company.getId());
        oriCompany.setName(oriCompany.getName().equals(company.getName()) ? oriCompany.getName() : company.getName());
        oriCompany.setAddress(oriCompany.getAddress().equals(company.getAddress()) ? oriCompany.getAddress()  : company.getAddress());
        oriCompany.setPhone(oriCompany.getPhone().equals(company.getPhone()) ? oriCompany.getPhone() : company.getPhone() );
        oriCompany.setEmail(oriCompany.getEmail().equals(company.getEmail()) ? oriCompany.getEmail() : company.getEmail() );
        oriCompany.setContact_man(oriCompany.getContact_man().equals(company.getContact_man()) ? oriCompany.getContact_man() : company.getContact_man());
        
        companyService.update(oriCompany);
        return "redirect:.";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
//        Product product = products.stream().filter(s -> s.getId() == id).findFirst().get();
//        products.remove(product);
//        return "redirect:../input";
    	initService();
        
        Company oriCompany = companyService.find(id);
        if (oriCompany.equals(null)) {
            System.out.println(">>> delete failed <<<");
        } else {
        	companyService.delete(id);
        }
        return "redirect:..";
    	
    }
	
}
