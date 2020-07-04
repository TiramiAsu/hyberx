package tw.com.hyberx.controller;

import java.util.Date;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 9110d1d3f27cfde3bb720c39fd67ef7fa9b46be4

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
import com.sun.org.apache.bcel.internal.generic.NEW;

import tw.com.hyberx.model.entity.Account;
import tw.com.hyberx.model.entity.Member;
import tw.com.hyberx.service.AccountService;
import tw.com.hyberx.service.MemberService;
=======
import tw.com.hyberx.model.entity.Account;
import tw.com.hyberx.service.AccountService;
>>>>>>> 9110d1d3f27cfde3bb720c39fd67ef7fa9b46be4
import tw.com.hyberx.utils.SpringUtils;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	public AccountService accountService;
	
<<<<<<< HEAD
	@Autowired
	public MemberService memberService;
	
=======
>>>>>>> 9110d1d3f27cfde3bb720c39fd67ef7fa9b46be4
	public void initService() {
		accountService=(accountService==null)
				?SpringUtils.getBean(AccountService.class)
						:accountService;
	}
	
	
	@PostMapping("/account_verify")
	public String accountVerify(@ModelAttribute Account account) {
		initService();
		
		
		return "redirect:./input";
	}
	
	@GetMapping("/register")
<<<<<<< HEAD
	public String accountRegister(@ModelAttribute Account account,Model model) {
		initService();
		
		model.addAttribute("account",new Account());
		model.addAttribute("action","saveregister");
		return "main/features/register";
	}
	
	@PostMapping("/saveregister")
	public String saveRegister(@ModelAttribute Account account) {
		initService();
		
		
		memberService.create(account.getM_id());
		accountService.create(account);
		return "redirect:./input";
	}
	
	@GetMapping("/input")
	public String input(Model model) {
		List<Account> accounts=accountService.query();
		System.out.println(accounts);
		Account account=new Account();
		Member member=new Member();
		member.setId(1L);
		account.setM_id(member);
		
		model.addAttribute("account",account ); // 屬性名稱為spring form 的 modelAttribute
        model.addAttribute("accounts", accountService.query());
=======
	public String accountRegister(@ModelAttribute Account account) {
		
		return "main/features/register";
	}
	
	@GetMapping("/input")
	public String input(Model model) {
		initService();
		
		model.addAttribute("account", new Account()); // 屬性名稱為spring form 的 modelAttribute
        model.addAttribute("students", accountService.query());
>>>>>>> 9110d1d3f27cfde3bb720c39fd67ef7fa9b46be4
        model.addAttribute("action", "add");
        return "main/account";
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
        return "main/account";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Account account) {
		initService();
		
		Account oriAccount=accountService.find(account.getId());
		oriAccount.setName(oriAccount.getName().equals(account.getName())?account.getName():oriAccount.getName());
		oriAccount.setPassword(oriAccount.getPassword().equals(account.getPassword())?account.getPassword():oriAccount.getPassword());
		oriAccount.setM_id(oriAccount.getM_id().equals(account.getM_id())?account.getM_id():oriAccount.getM_id());
		oriAccount.setStatus(oriAccount.getStatus().equals(account.getStatus())?account.getStatus():oriAccount.getStatus());
		oriAccount.setErrorTimes(oriAccount.getErrorTimes().equals(account.getErrorTimes())?account.getErrorTimes():oriAccount.getErrorTimes());
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
