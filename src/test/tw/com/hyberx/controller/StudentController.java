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

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.com.hyberx.model.entity.Student;

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

    static List<Student> students = new ArrayList<>();
    
    static {
        Student sd1 = new Student("Anita", 21);
        sd1.setId(1);
        Student sd2 = new Student("Asia", 19);
        sd2.setId(2);
        students.add(sd1);
        students.add(sd2);
    }

    @GetMapping("/input") // URL request 進來
    public String input(Model model) { // model 要傳給 JSP from
        Student student = new Student();
//      student.setName("Anita"); // 可傳入值在表單中
        model.addAttribute("student", student); // 屬性名稱為spring form 的 modelAttribute
        model.addAttribute("students", students);
        model.addAttribute("action", "add");
        return "test/student";
    }

    @PostMapping("/add") // Form request 進來
    public String add(@ModelAttribute Student student) {
        int id = 1;
        if (students.size() != 0) {
            id += students.stream().mapToInt(s -> s.getId()).max().getAsInt();
        }
        student.setId(id);
        students.add(student);
        students.stream().forEach(System.out::println);
        return "redirect:./input";
    }

    @GetMapping("/find/{id}")
    public String find(@PathVariable Integer id, Model model) {
        Student student = students.stream().filter(s -> s.getId() == id).findFirst().get();
        model.addAttribute("student", student);
        model.addAttribute("students", students);
        model.addAttribute("action", "update");
        return "test/student";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Student student) {
        Student stu = students.stream().filter(s -> s.getId() == student.getId()).findFirst().get();
        stu.setName(student.getName());
        stu.setAge(student.getAge());
        return "redirect:./input";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Student student = students.stream().filter(s -> s.getId() == id).findFirst().get();
        students.remove(student);
        return "redirect:../input";
    }
}