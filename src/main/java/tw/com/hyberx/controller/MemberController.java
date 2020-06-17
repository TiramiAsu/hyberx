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

import tw.com.hyberx.model.entity.Member;
import tw.com.hyberx.service.MemberService;
import tw.com.hyberx.utils.SpringUtils;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	public MemberService memberService;

	public void initService() {
		memberService = (memberService == null) ? SpringUtils.getBean(MemberService.class) : memberService;
	}

	@GetMapping("/input")
	public String input(Model model) {
		initService();
		
		Member member=new Member();
		member.setId(memberService.query().stream().mapToLong(v->v.getId()).max().getAsLong()+1);
		model.addAttribute("member",member);
		model.addAttribute("members", memberService.query());
		model.addAttribute("action", "add");
		return "main/member";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute Member member) {
		initService();

		memberService.create(member);
		return "redirect:./input";
	}

	@GetMapping("/find/{id}")
	public String find(@PathVariable Long id, Model model) {
		initService();

		model.addAttribute("member", memberService.find(id));
		model.addAttribute("members", memberService.query());
		model.addAttribute("action", "update");
		return "main/member";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Member member) {
		initService();

		Member oriMember = memberService.find(member.getId()); // 舊資料
		// 設舊資料(舊資料跟新資料是否相等?放新資料:放舊資料)
		oriMember.setName(oriMember.getName().equals(member.getName()) ? member.getName() : oriMember.getName());
		oriMember.setAddress(
				oriMember.getAddress().equals(member.getAddress()) ? member.getAddress() : oriMember.getAddress());
		oriMember.setPhone(oriMember.getPhone().equals(member.getPhone()) ? member.getPhone() : oriMember.getPhone());
		oriMember.setEmail(oriMember.getEmail().equals(member.getEmail()) ? member.getEmail() : oriMember.getEmail());
		oriMember.setTimeBuild(oriMember.getTimeBuild());
		oriMember.setTimeModify(new Date());

		memberService.update(oriMember);
		return "redirect:./input";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		initService();

		Member oriMember = memberService.find(id);
		if (oriMember.equals(null)) {
			System.out.println(">>> delete failed <<<");
		} else {
			memberService.delete(id);
		}
		return "redirect:../input";
	}
}
