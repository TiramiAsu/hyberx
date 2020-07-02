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

import tw.com.hyberx.model.entity.Account;
import tw.com.hyberx.service.AccountService;
import tw.com.hyberx.utils.SpringUtils;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	public AccountService accountService;
	
	public void initService() {
		accountService=(accountService==null)
				?SpringUtils.getBean(AccountService.class)
						:accountService;
	}
	
	@GetMapping("/input")
	public String input(Model model) {
		initService();
		
		model.addAttribute("account", new Account()); // 屬性名稱為spring form 的 modelAttribute
        model.addAttribute("students", accountService.query());
        model.addAttribute("action", "add");
        return "test/account";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute Account account) {
		initService();
		
		accountService.create(account);
		return "redirect:./input";
	}
	
	@GetMapping("/find/{id}")
	public String find(@PathVariable Long id,Model model) {
		initService();
		
		model.addAttribute("account", accountService.find(id));
        model.addAttribute("accounts", accountService.query());
        model.addAttribute("action", "update");
        return "test/account";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Account account) {
		initService();
		
		Account oriAccount=accountService.find(account.getId());
		oriAccount.setName(oriAccount.getName().equals(account.getName())?account.getName():oriAccount.getName());
		oriAccount.setPassword(oriAccount.getPassword().equals(account.getPassword())?account.getPassword():oriAccount.getPassword());
		oriAccount.setM_id(oriAccount.getM_id().equals(account.getM_id())?account.getM_id():oriAccount.getM_id());
		oriAccount.setStatus(oriAccount.getStatus().equals(account.getStatus())?account.getStatus():oriAccount.getStatus());
		oriAccount.setError_times(oriAccount.getError_times().equals(account.getError_times())?account.getError_times():oriAccount.getError_times());
		oriAccount.setTimeBuild(oriAccount.getTimeBuild());
		oriAccount.setTimeModify(new Date());
		
		accountService.update(oriAccount);
		return "redirect:./input";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		initService();
		
		Account oriAccount=accountService.find(id);
		if (oriAccount.equals(null)) {
			System.out.println(">>> delete failed <<<");
		}else {
			accountService.delete(id);
		}
		return "redirect:../input";
	}
	
}
