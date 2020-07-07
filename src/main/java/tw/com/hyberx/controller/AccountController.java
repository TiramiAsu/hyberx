package tw.com.hyberx.controller;

import static tw.com.hyberx.utils.enums.InfoAPI._ADD;
import static tw.com.hyberx.utils.enums.InfoAPI._CANCEL;
import static tw.com.hyberx.utils.enums.InfoAPI._FIND;
import static tw.com.hyberx.utils.enums.InfoAPI._MODIFY;
import static tw.com.hyberx.utils.enums.InfoAPI._REMOVE;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sun.org.apache.bcel.internal.generic.NEW;

import tw.com.hyberx.model.entity.Account;
import tw.com.hyberx.model.entity.Member;
import tw.com.hyberx.service.AccountService;
import tw.com.hyberx.service.MemberService;
import tw.com.hyberx.model.entity.Account;
import tw.com.hyberx.service.AccountService;
import tw.com.hyberx.utils.ControllerUtil;
import tw.com.hyberx.utils.SpringUtils;

@Controller
@RequestMapping("/accounts")
@SessionAttributes("loginuserprofile")
public class AccountController {

	public static final String _NAME = "accounts";

	@Autowired
	public AccountService accountService;

	@Autowired
	public MemberService memberService;

	public void initService() {
		accountService = (accountService == null) ? SpringUtils.getBean(AccountService.class) : accountService;
	}

	@PostMapping("/account_verify")
	public String accountVerify(@ModelAttribute Account account, Model model) {
		initService();

		List<Account> accounts = accountService.query();
		List<Account> list = accounts.stream().filter(a -> a.getName().equals(account.getName()))
				.collect(Collectors.toList());
		for (Account bean : list) {
			if (bean.getStatus().equals(1)) {
				return "jsp/main/features/loginerror";
			} else if (bean.getErrorTimes() > 2) {
				if (bean.getStatus() != -1)
					bean.setStatus(-1);
				return "jsp/main/features/loginerror";
			} else if (bean.getPassword().equals(account.getPassword())) {
				if (bean.getErrorTimes() != 0)bean.setErrorTimes(0);
				bean.setStatus(1);
				model.addAttribute("loginuserprofile", bean);
				return "redirect:../index";
			} else {
				bean.setErrorTimes(bean.getErrorTimes() + 1);
				return "jsp/main/features/loginerror";
			}
		}
		return "jsp/main/features/loginerror";
	}

	@GetMapping("/register")
	public String accountRegister(@ModelAttribute Account account, Model model) {
		initService();

		model.addAttribute("account", new Account());
		model.addAttribute("action", "saveregister");
		return "jsp/main/features/register";
	}

	@PostMapping("/saveregister")
	public String saveRegister(@ModelAttribute Account account) {
		initService();

		memberService.create(account.getM_id());
		accountService.create(account);
		return "redirect:../main";
	}

	@GetMapping
	public String input(Model model) {
		List<Account> accounts = accountService.query();
		Account account = new Account();
//		Member member=new Member();
//		account.setM_id(member);

		model.addAttribute("account", account); // 屬性名稱為spring form 的 modelAttribute
		model.addAttribute("accounts", accountService.query());
//		model.addAttribute("action", "add");
		ControllerUtil.setAPI(model, _NAME,  _ADD, _CANCEL, _FIND, _REMOVE);
		return "/jsp/main/account";
	}

	public String accountRegister(@ModelAttribute Account account) {

		return "main/features/register";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute Account account) {
		initService();

		Date date = new Date();
		Member member = new Member("null", "null", "null", "null", null, null);
		memberService.create(member);
		account.setM_id(member);
		accountService.create(account);
		return "redirect:.";
	}

	@GetMapping("/find/{id}")
	public String find(@PathVariable Long id, Model model) {
		initService();

		model.addAttribute("account", accountService.find(id));
		model.addAttribute("accounts", accountService.query());
//		model.addAttribute("action", "update");
		ControllerUtil.setAPI(model, _NAME, _MODIFY, _CANCEL, _FIND, _REMOVE);
		return "jsp/main/account";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Account account) {
		initService();

		Account oriAccount = accountService.find(account.getId());
		oriAccount.setName(oriAccount.getName().equals(account.getName()) ? oriAccount.getName() : account.getName());
		oriAccount.setPassword(oriAccount.getPassword().equals(account.getPassword())? oriAccount.getPassword(): account.getPassword());
		oriAccount.setM_id(oriAccount.getM_id().equals(account.getM_id())? oriAccount.getM_id() : account.getM_id());
		oriAccount.setStatus(oriAccount.getStatus().equals(account.getStatus())? oriAccount.getStatus() : account.getStatus());
		oriAccount.setErrorTimes(oriAccount.getErrorTimes().equals(account.getErrorTimes()) ? oriAccount.getErrorTimes(): account.getErrorTimes());
		oriAccount.setTimeBuild(oriAccount.getTimeBuild());
		oriAccount.setTimeModify(new Date());

		accountService.update(oriAccount);
		return "redirect:.";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		initService();

		Account oriAccount = accountService.find(id);
		if (oriAccount.equals(null)) {
			System.out.println(">>> delete failed <<<");
		} else {
			accountService.delete(id);
		}
		return "redirect:..";
	}

}
