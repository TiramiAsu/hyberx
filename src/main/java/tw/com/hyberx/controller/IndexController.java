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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tw.com.hyberx.model.entity.Student;
import tw.com.hyberx.service.StudentService;
import tw.com.hyberx.utils.SpringUtils;

/**
 * <pre>
 * [首頁] 2020-07-04 14:57
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@Controller
@RequestMapping("/index")
public class IndexController {

	@GetMapping
	public ModelAndView in() {

		return new ModelAndView("/index");
	}
}