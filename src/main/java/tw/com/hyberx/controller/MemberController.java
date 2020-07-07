package tw.com.hyberx.controller;

import static tw.com.hyberx.utils.enums.InfoAPI._ADD;
import static tw.com.hyberx.utils.enums.InfoAPI._CANCEL;
import static tw.com.hyberx.utils.enums.InfoAPI._FIND;
import static tw.com.hyberx.utils.enums.InfoAPI._MODIFY;
import static tw.com.hyberx.utils.enums.InfoAPI._REMOVE;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.com.hyberx.model.entity.Member;
import tw.com.hyberx.service.MemberService;
import tw.com.hyberx.utils.ControllerUtil;
import tw.com.hyberx.utils.SpringUtils;

@Controller
@RequestMapping("/members")
public class MemberController {
	
	public static final String _NAME="members";

	@Autowired
	public MemberService memberService;

	public void initService() {
		memberService = (memberService == null) ? SpringUtils.getBean(MemberService.class) : memberService;
	}

	@GetMapping
	public String input(Model model) {
		initService();

		Member member = new Member();
		member.setId(memberService.query().stream().mapToLong(v -> v.getId()).max().getAsLong() + 1);
		model.addAttribute("member", member);
		model.addAttribute("members", memberService.query());
//		model.addAttribute("action", "add");
		ControllerUtil.setAPI(model, _NAME, _ADD, _CANCEL, _FIND, _REMOVE);
		return "jsp/main/member";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute Member member) {
		initService();

		memberService.create(member);
		return "redirect:.";
	}

	@GetMapping("/find/{id}")
	public String find(@PathVariable Long id, Model model) {
		initService();

		model.addAttribute("member", memberService.find(id));
		model.addAttribute("members", memberService.query());
//		model.addAttribute("action", "update");
		ControllerUtil.setAPI(model, _NAME, _MODIFY, _CANCEL, _FIND, _REMOVE);
		return "jsp/main/member";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Member member) {
		initService();

		Member oriMember = memberService.find(member.getId()); // 舊資料
		// 設舊資料(舊資料跟新資料是否相等?放新資料:放舊資料)
		oriMember.setName(oriMember.getName().equals(member.getName()) ? oriMember.getName() : member.getName());
		oriMember.setAddress(
				oriMember.getAddress().equals(member.getAddress()) ? oriMember.getAddress() : member.getAddress());
		oriMember.setPhone(oriMember.getPhone().equals(member.getPhone()) ? oriMember.getPhone() : member.getPhone());
		oriMember.setEmail(oriMember.getEmail().equals(member.getEmail()) ? oriMember.getEmail() : member.getEmail());
		oriMember.setTimeBuild(oriMember.getTimeBuild());
		oriMember.setTimeModify(new Date());

		memberService.update(oriMember);
		return "redirect:.";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		initService();

		Member oriMember = memberService.find(id);
		if (oriMember.equals(null)) {
			System.out.println(">>> delete failed <<<");
		} else {
			try {
				memberService.delete(id);
			} catch (DataIntegrityViolationException e) {
				model.addAttribute("dberror", "Account尚有帳號未刪除");
				Member member = new Member();
				member.setId(memberService.query().stream().mapToLong(v -> v.getId()).max().getAsLong() + 1);
				model.addAttribute("member", member);
				model.addAttribute("members", memberService.query());
				model.addAttribute("action", "add");
				return "jsp/main/member";
			}
		}
		return "redirect:..";
	}

}
