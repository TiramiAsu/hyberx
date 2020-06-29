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

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.com.hyberx.model.entity.Student;
import tw.com.hyberx.service.StudentService;
import tw.com.hyberx.utils.SpringUtils;

/**
 * [Student Controller]
 * <p>
 * 
 * @author  Asu
 * @since   2020-06-06 01:23
 * @version 
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    public StudentService studentService;
    
    public void initService() {
        studentService = (studentService == null) ? SpringUtils.getBean(StudentService.class) : studentService;
    }

    /* list 假資料
    static List<Student> students = new ArrayList<>();
    
    static {
        Student sd1 = new Student("Anita", 21);
        sd1.setId(1);
        Student sd2 = new Student("Asia", 19);
        sd2.setId(2);
        students.add(sd1);
        students.add(sd2);
    }
    */

    @GetMapping("/input") // URL request 進來
    public String input(Model model) { // model 要傳給 JSP from
        
        /* list 假資料
        Student student = new Student();
//      student.setName("Anita"); // 可傳入值在表單中
        model.addAttribute("student", student); // 屬性名稱為spring form 的 modelAttribute
        model.addAttribute("students", students);
        model.addAttribute("action", "add");
        */

        /** 正式串接 DB */
        
        // initial Service
        initService();
        
        model.addAttribute("student", new Student()); // 屬性名稱為spring form 的 modelAttribute
        model.addAttribute("students", studentService.query());
        model.addAttribute("action", "add");
        return "test/student";
    }

    @PostMapping("/add") // Form request 進來
    public String add(@ModelAttribute Student student) {
        
        /* list 假資料
        Long id = 1L;
        if (students.size() != 0) {
            id += students.stream().mapToLong(s -> s.getId()).max().getAsLong();
        }
        student.setId(id);
        students.add(student);
        students.stream().forEach(System.out::println);
        */

        /** 正式串接 DB */
        
        // initial Service
        initService();
        
        studentService.create(student);
        return "redirect:./input";
    }

    @GetMapping("/find/{id}")
    public String find(@PathVariable Long id, Model model) {
        
        /* list 假資料
        Student student = students.stream().filter(s -> s.getId() == id).findFirst().get();
        
        model.addAttribute("student", student);
        model.addAttribute("students", students);
        model.addAttribute("action", "update");
        */

        /** 正式串接 DB */
        
        // initial Service
        initService();
        
        model.addAttribute("student", studentService.find(id));
        model.addAttribute("students", studentService.query());
        model.addAttribute("action", "update");
        return "test/student";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Student student) {
        
        /* list 假資料
        Student stu = students.stream().filter(s -> s.getId() == student.getId()).findFirst().get();
        stu.setName(student.getName());
        stu.setAge(student.getAge());
        */

        /** 正式串接 DB */
        
        // initial Service
        initService();
        
        Student oriStudent = studentService.find(student.getId());
        oriStudent.setName(oriStudent.getName().equals(student.getName()) ? student.getName() : oriStudent.getName());
        oriStudent.setAge(oriStudent.getAge().equals(student.getAge()) ? student.getAge() : oriStudent.getAge());
        oriStudent.setTimeBuild(oriStudent.getTimeBuild());
        oriStudent.setTimeModify(new Date());
        
        studentService.update(oriStudent);
        return "redirect:./input";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        
        /* list 假資料
        Student student = students.stream().filter(s -> s.getId() == id).findFirst().get();
        students.remove(student);
        */

        /** 正式串接 DB */
        
        // initial Service
        initService();
        
        Student oriStudent = studentService.find(id);
        if (oriStudent.equals(null)) {
            System.out.println(">>> delete failed <<<");
        } else {
            studentService.delete(id);
        }
        return "redirect:../input";
    }
}