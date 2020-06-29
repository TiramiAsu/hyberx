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

import tw.com.hyberx.model.entity.BasicInfo;

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
	}

}
