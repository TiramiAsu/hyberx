/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package tw.com.hyberx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * [首頁] 2020-07-04 14:57
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@Controller
@RequestMapping("/index")
@SessionAttributes("loginuserprofile")
public class IndexController {

	@GetMapping
	public ModelAndView in() {
		return new ModelAndView("/index");
	}
}
