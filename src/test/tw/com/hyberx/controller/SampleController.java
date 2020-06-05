/*
 * 
 * 
 * 
 * 
 * 
 * &copy;Asu
 * 
 */
package tw.com.hyberx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * [Sample Controller]
 * <p>
 * Test SpringMVC
 * 
 * @author  Asu
 * @since   2020-06-01 23:45
 * @version 
 */
@Controller
@RequestMapping("/sample")
public class SampleController {

    @ResponseBody
    @RequestMapping("/returnString")
    public String sayHi() {
        return "Say Hi";
    }

    @RequestMapping("/returnJsp")
    public String sayYes() {
        return "test/sample";
    }
}
