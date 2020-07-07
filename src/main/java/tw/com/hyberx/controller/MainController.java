package tw.com.hyberx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.com.hyberx.model.entity.Account;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@GetMapping
	public String login(Model model) {
//		model.addAttribute("account",new Account());
		return "forward:/index.html";
	}
	
}
