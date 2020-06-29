/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package tw.com.hyberx.utils;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

<<<<<<< HEAD
import tw.com.hyberx.model.entity.Account;
import tw.com.hyberx.model.entity.Member;
=======
import tw.com.hyberx.model.entity.BasicInfo;
>>>>>>> 5ae6d0bebca89f10a28c0ca4b33649bd428ef84a
import tw.com.hyberx.model.entity.Student;
import tw.com.hyberx.service.AccountService;
import tw.com.hyberx.service.MemberService;
import tw.com.hyberx.service.StudentService;

/**
 * <pre>
 * [Spring 工具] 2019-12-31 19:28
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@Component
public class SpringUtils {

	private static ApplicationContext context;

	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	public SpringUtils() {}

	public static Object getBean(String beanId) {
		return context.getBean(beanId, Object.class);
	}

	public static <T> T getBean(Class<T> clazz) {
		return context.getBean(clazz);
	}

	public static <T> T getBean(String beanId, Class<T> clazz) {
		return context.getBean(beanId, clazz);
	}

	public static void main(String[] args) {
//		StudentService studentService = SpringUtils.getBean("studentService");
//		StudentService studentService = SpringUtils.getBean("studentService", StudentService.class);
	    StudentService studentService = SpringUtils.getBean(StudentService.class);
		if (studentService == null) {
			System.out.println(">>> null <<<");
		} else {
		    List<Student> list = studentService.query();
		    list.add(new Student(new BasicInfo("Asia", 22)));
		    list.stream().forEach(System.out::println);
			System.out.println(">>> Success <<<");
		}
		MemberService memberService = SpringUtils.getBean(MemberService.class);
		if (memberService == null) {
			System.out.println(">>> null <<<");
		} else {
		    List<Member> list = memberService.query();
		    list.add(new Member("a", "a", "1", "a@a.a", new Date(), new Date()));
		    list.stream().forEach(System.out::println);
			System.out.println(">>> Success <<<");
		}
		AccountService accountService = SpringUtils.getBean(AccountService.class);
		if (accountService == null) {
			System.out.println(">>> null <<<");
		} else {
		    List<Account> list = accountService.query();
		    list.add(new Account("a", "a", null, 0, 0, new Date(), new Date()));
		    list.stream().forEach(System.out::println);
			System.out.println(">>> Success <<<");
		}
	}

}
